package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements com.tencent.mm.ak.g
{
  private List<b> callbacks;
  int h;
  bd hEL;
  LinkedList<c> tXq;
  c tXr;
  int w;
  
  public m()
  {
    AppMethodBeat.i(55717);
    this.hEL = new bd(1, "location_worker");
    this.tXq = new LinkedList();
    this.tXr = null;
    this.callbacks = new ArrayList();
    this.w = 300;
    this.h = 300;
    start();
    AppMethodBeat.o(55717);
  }
  
  public static String b(c paramc)
  {
    AppMethodBeat.i(55721);
    paramc = com.tencent.mm.b.g.getMessageDigest(paramc.toString().getBytes());
    String str = d.awM() + paramc.charAt(0) + paramc.charAt(1) + "/" + paramc.charAt(3) + paramc.charAt(4) + "/";
    if (!i.eA(str)) {
      new com.tencent.mm.vfs.e(str).mkdirs();
    }
    paramc = str + "static_map_" + paramc;
    AppMethodBeat.o(55721);
    return paramc;
  }
  
  private void nz(boolean paramBoolean)
  {
    AppMethodBeat.i(55722);
    ac.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator;
    b localb;
    if (paramBoolean)
    {
      if (this.tXr != null)
      {
        localIterator = this.callbacks.iterator();
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          if (localb != null) {
            localb.a(b(this.tXr), this.tXr);
          }
        }
      }
    }
    else if (this.tXr != null)
    {
      localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (localb != null) {
          localb.a(this.tXr);
        }
      }
    }
    this.tXr = null;
    aEJ();
    AppMethodBeat.o(55722);
  }
  
  private void start()
  {
    AppMethodBeat.i(55718);
    com.tencent.mm.kernel.g.agi().a(648, this);
    AppMethodBeat.o(55718);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(55715);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (paramb.equals((b)localIterator.next()))
      {
        AppMethodBeat.o(55715);
        return;
      }
    }
    this.callbacks.add(paramb);
    ac.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
    if (this.callbacks.size() == 1) {
      start();
    }
    AppMethodBeat.o(55715);
  }
  
  final void aEJ()
  {
    AppMethodBeat.i(55720);
    if ((this.tXr == null) && (this.tXq.size() > 0))
    {
      this.tXr = ((c)this.tXq.removeFirst());
      try
      {
        i = Integer.valueOf(bs.bG(com.tencent.mm.m.g.ZY().getValue("StaticMapGetClient"), "")).intValue();
        ac.i("MicroMsg.StaticMapServer", "run local %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          h localh = new h(this.tXr.hEE, this.tXr.hEF, this.tXr.dmN + 1, this.w, this.h, b(this.tXr), ab.eUO());
          com.tencent.mm.kernel.g.agi().a(localh, 0);
          AppMethodBeat.o(55720);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = 0;
        }
        int j = this.w;
        for (int i = this.h; j * i > 270000; i = (int)(i / 1.2D)) {
          j = (int)(j / 1.2D);
        }
        if (bs.ja(ai.getContext()))
        {
          str = String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.tXr.hEE), Float.valueOf(this.tXr.hEF), Integer.valueOf(this.tXr.dmN), ab.eUO() });
          this.hEL.c(new a(true, str, b(this.tXr)));
          AppMethodBeat.o(55720);
          return;
        }
        String str = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.tXr.hEF), Float.valueOf(this.tXr.hEE), Integer.valueOf(this.tXr.dmN) });
        this.hEL.c(new a(false, str, b(this.tXr)));
      }
    }
    AppMethodBeat.o(55720);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(55716);
    this.callbacks.remove(paramb);
    ac.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
    if (this.callbacks.size() == 0)
    {
      ac.i("MicroMsg.StaticMapServer", "clean task");
      this.tXq.clear();
      this.tXr = null;
      stop();
    }
    AppMethodBeat.o(55716);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(55723);
    if (paramn.getType() == 648)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (this.tXr != null))
      {
        nz(true);
        AppMethodBeat.o(55723);
        return;
      }
      nz(false);
    }
    AppMethodBeat.o(55723);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55719);
    ac.i("MicroMsg.StaticMapServer", "stop static map server");
    com.tencent.mm.kernel.g.agi().b(648, this);
    AppMethodBeat.o(55719);
  }
  
  public final class a
    implements bd.a
  {
    private byte[] data;
    private String mFilePath;
    boolean tXs;
    private int tXt;
    private int tXu;
    String url;
    
    public a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(55712);
      this.url = "";
      this.tXs = true;
      this.tXs = paramBoolean;
      this.tXt = m.this.w;
      this.tXu = m.this.h;
      this.url = paramString1;
      while (this.tXt * this.tXu > 270000)
      {
        this.tXt = ((int)(this.tXt / 1.2D));
        this.tXu = ((int)(this.tXu / 1.2D));
      }
      this.mFilePath = paramString2;
      ac.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[] { paramString1, bs.bG(this.mFilePath, "") });
      AppMethodBeat.o(55712);
    }
    
    public final boolean aBj()
    {
      AppMethodBeat.i(55713);
      this.data = bs.aLC(this.url);
      if (this.data != null) {
        i.f(this.mFilePath, this.data, this.data.length);
      }
      AppMethodBeat.o(55713);
      return true;
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(55714);
      StringBuilder localStringBuilder = new StringBuilder("http onPostExecute ");
      if (this.data == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.StaticMapServer", bool + " isGoole: " + this.tXs);
        if (this.data != null) {
          break label233;
        }
        if (!this.tXs) {
          break label218;
        }
        if (m.this.tXr != null) {
          break;
        }
        m.a(m.this, false);
        AppMethodBeat.o(55714);
        return false;
      }
      this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(this.tXt), Integer.valueOf(this.tXu), Float.valueOf(m.this.tXr.hEF), Float.valueOf(m.this.tXr.hEE), Integer.valueOf(m.this.tXr.dmN) });
      m.this.hEL.c(new a(m.this, false, this.url, m.b(m.this.tXr)));
      AppMethodBeat.o(55714);
      return false;
      label218:
      m.a(m.this, false);
      AppMethodBeat.o(55714);
      return false;
      label233:
      m.a(m.this, true);
      AppMethodBeat.o(55714);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.m
 * JD-Core Version:    0.7.0.1
 */