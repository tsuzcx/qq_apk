package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements com.tencent.mm.al.g
{
  private List<b> callbacks;
  int h;
  be hei;
  LinkedList<c> sPd;
  c sPe;
  int w;
  
  public m()
  {
    AppMethodBeat.i(55717);
    this.hei = new be(1, "location_worker");
    this.sPd = new LinkedList();
    this.sPe = null;
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
    String str = d.apX() + paramc.charAt(0) + paramc.charAt(1) + "/" + paramc.charAt(3) + paramc.charAt(4) + "/";
    if (!i.eK(str)) {
      new com.tencent.mm.vfs.e(str).mkdirs();
    }
    paramc = str + "static_map_" + paramc;
    AppMethodBeat.o(55721);
    return paramc;
  }
  
  private void mH(boolean paramBoolean)
  {
    AppMethodBeat.i(55722);
    ad.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator;
    b localb;
    if (paramBoolean)
    {
      if (this.sPe != null)
      {
        localIterator = this.callbacks.iterator();
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          if (localb != null) {
            localb.a(b(this.sPe), this.sPe);
          }
        }
      }
    }
    else if (this.sPe != null)
    {
      localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (localb != null) {
          localb.a(this.sPe);
        }
      }
    }
    this.sPe = null;
    axR();
    AppMethodBeat.o(55722);
  }
  
  private void start()
  {
    AppMethodBeat.i(55718);
    com.tencent.mm.kernel.g.aeS().a(648, this);
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
    ad.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
    if (this.callbacks.size() == 1) {
      start();
    }
    AppMethodBeat.o(55715);
  }
  
  final void axR()
  {
    AppMethodBeat.i(55720);
    if ((this.sPe == null) && (this.sPd.size() > 0))
    {
      this.sPe = ((c)this.sPd.removeFirst());
      try
      {
        i = Integer.valueOf(bt.by(com.tencent.mm.m.g.Zd().getValue("StaticMapGetClient"), "")).intValue();
        ad.i("MicroMsg.StaticMapServer", "run local %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          h localh = new h(this.sPe.heb, this.sPe.hec, this.sPe.dpd + 1, this.w, this.h, b(this.sPe), ac.eFu());
          com.tencent.mm.kernel.g.aeS().a(localh, 0);
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
        if (bt.iP(aj.getContext()))
        {
          str = String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.sPe.heb), Float.valueOf(this.sPe.hec), Integer.valueOf(this.sPe.dpd), ac.eFu() });
          this.hei.c(new a(true, str, b(this.sPe)));
          AppMethodBeat.o(55720);
          return;
        }
        String str = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.sPe.hec), Float.valueOf(this.sPe.heb), Integer.valueOf(this.sPe.dpd) });
        this.hei.c(new a(false, str, b(this.sPe)));
      }
    }
    AppMethodBeat.o(55720);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(55716);
    this.callbacks.remove(paramb);
    ad.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
    if (this.callbacks.size() == 0)
    {
      ad.i("MicroMsg.StaticMapServer", "clean task");
      this.sPd.clear();
      this.sPe = null;
      stop();
    }
    AppMethodBeat.o(55716);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(55723);
    if (paramn.getType() == 648)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (this.sPe != null))
      {
        mH(true);
        AppMethodBeat.o(55723);
        return;
      }
      mH(false);
    }
    AppMethodBeat.o(55723);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55719);
    ad.i("MicroMsg.StaticMapServer", "stop static map server");
    com.tencent.mm.kernel.g.aeS().b(648, this);
    AppMethodBeat.o(55719);
  }
  
  public final class a
    implements be.a
  {
    private byte[] data;
    private String mFilePath;
    boolean sPf;
    private int sPg;
    private int sPh;
    String url;
    
    public a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(55712);
      this.url = "";
      this.sPf = true;
      this.sPf = paramBoolean;
      this.sPg = m.this.w;
      this.sPh = m.this.h;
      this.url = paramString1;
      while (this.sPg * this.sPh > 270000)
      {
        this.sPg = ((int)(this.sPg / 1.2D));
        this.sPh = ((int)(this.sPh / 1.2D));
      }
      this.mFilePath = paramString2;
      ad.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[] { paramString1, bt.by(this.mFilePath, "") });
      AppMethodBeat.o(55712);
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(55713);
      this.data = bt.aGl(this.url);
      if (this.data != null) {
        i.f(this.mFilePath, this.data, this.data.length);
      }
      AppMethodBeat.o(55713);
      return true;
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(55714);
      StringBuilder localStringBuilder = new StringBuilder("http onPostExecute ");
      if (this.data == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.StaticMapServer", bool + " isGoole: " + this.sPf);
        if (this.data != null) {
          break label233;
        }
        if (!this.sPf) {
          break label218;
        }
        if (m.this.sPe != null) {
          break;
        }
        m.a(m.this, false);
        AppMethodBeat.o(55714);
        return false;
      }
      this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(this.sPg), Integer.valueOf(this.sPh), Float.valueOf(m.this.sPe.hec), Float.valueOf(m.this.sPe.heb), Integer.valueOf(m.this.sPe.dpd) });
      m.this.hei.c(new a(m.this, false, this.url, m.b(m.this.sPe)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.m
 * JD-Core Version:    0.7.0.1
 */