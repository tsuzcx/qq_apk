package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements f
{
  private List<b> callbacks;
  int h;
  bf iai;
  LinkedList<c> vmk;
  c vml;
  int w;
  
  public m()
  {
    AppMethodBeat.i(55717);
    this.iai = new bf(1, "location_worker");
    this.vmk = new LinkedList();
    this.vml = null;
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
    String str = d.azR() + paramc.charAt(0) + paramc.charAt(1) + "/" + paramc.charAt(3) + paramc.charAt(4) + "/";
    if (!o.fB(str)) {
      new k(str).mkdirs();
    }
    paramc = str + "static_map_" + paramc;
    AppMethodBeat.o(55721);
    return paramc;
  }
  
  private void nY(boolean paramBoolean)
  {
    AppMethodBeat.i(55722);
    ae.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator;
    b localb;
    if (paramBoolean)
    {
      if (this.vml != null)
      {
        localIterator = this.callbacks.iterator();
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          if (localb != null) {
            localb.a(b(this.vml), this.vml);
          }
        }
      }
    }
    else if (this.vml != null)
    {
      localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (localb != null) {
          localb.a(this.vml);
        }
      }
    }
    this.vml = null;
    aIf();
    AppMethodBeat.o(55722);
  }
  
  private void start()
  {
    AppMethodBeat.i(55718);
    com.tencent.mm.kernel.g.ajj().a(648, this);
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
    ae.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
    if (this.callbacks.size() == 1) {
      start();
    }
    AppMethodBeat.o(55715);
  }
  
  final void aIf()
  {
    AppMethodBeat.i(55720);
    if ((this.vml == null) && (this.vmk.size() > 0))
    {
      this.vml = ((c)this.vmk.removeFirst());
      try
      {
        i = Integer.valueOf(bu.bI(com.tencent.mm.n.g.acL().getValue("StaticMapGetClient"), "")).intValue();
        ae.i("MicroMsg.StaticMapServer", "run local %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          h localh = new h(this.vml.iab, this.vml.iac, this.vml.dzG + 1, this.w, this.h, b(this.vml), ad.fom());
          com.tencent.mm.kernel.g.ajj().a(localh, 0);
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
        if (bu.jq(ak.getContext()))
        {
          str = String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.vml.iab), Float.valueOf(this.vml.iac), Integer.valueOf(this.vml.dzG), ad.fom() });
          this.iai.c(new a(true, str, b(this.vml)));
          AppMethodBeat.o(55720);
          return;
        }
        String str = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.vml.iac), Float.valueOf(this.vml.iab), Integer.valueOf(this.vml.dzG) });
        this.iai.c(new a(false, str, b(this.vml)));
      }
    }
    AppMethodBeat.o(55720);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(55716);
    this.callbacks.remove(paramb);
    ae.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
    if (this.callbacks.size() == 0)
    {
      ae.i("MicroMsg.StaticMapServer", "clean task");
      this.vmk.clear();
      this.vml = null;
      stop();
    }
    AppMethodBeat.o(55716);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(55723);
    if (paramn.getType() == 648)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (this.vml != null))
      {
        nY(true);
        AppMethodBeat.o(55723);
        return;
      }
      nY(false);
    }
    AppMethodBeat.o(55723);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55719);
    ae.i("MicroMsg.StaticMapServer", "stop static map server");
    com.tencent.mm.kernel.g.ajj().b(648, this);
    AppMethodBeat.o(55719);
  }
  
  public final class a
    implements bf.a
  {
    private byte[] data;
    private String mFilePath;
    String url;
    boolean vmm;
    private int vmn;
    private int vmo;
    
    public a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(55712);
      this.url = "";
      this.vmm = true;
      this.vmm = paramBoolean;
      this.vmn = m.this.w;
      this.vmo = m.this.h;
      this.url = paramString1;
      while (this.vmn * this.vmo > 270000)
      {
        this.vmn = ((int)(this.vmn / 1.2D));
        this.vmo = ((int)(this.vmo / 1.2D));
      }
      this.mFilePath = paramString2;
      ae.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[] { paramString1, bu.bI(this.mFilePath, "") });
      AppMethodBeat.o(55712);
    }
    
    public final boolean aEC()
    {
      AppMethodBeat.i(55713);
      this.data = bu.aSF(this.url);
      if (this.data != null) {
        o.f(this.mFilePath, this.data, this.data.length);
      }
      AppMethodBeat.o(55713);
      return true;
    }
    
    public final boolean aED()
    {
      AppMethodBeat.i(55714);
      StringBuilder localStringBuilder = new StringBuilder("http onPostExecute ");
      if (this.data == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.StaticMapServer", bool + " isGoole: " + this.vmm);
        if (this.data != null) {
          break label233;
        }
        if (!this.vmm) {
          break label218;
        }
        if (m.this.vml != null) {
          break;
        }
        m.a(m.this, false);
        AppMethodBeat.o(55714);
        return false;
      }
      this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(this.vmn), Integer.valueOf(this.vmo), Float.valueOf(m.this.vml.iac), Float.valueOf(m.this.vml.iab), Integer.valueOf(m.this.vml.dzG) });
      m.this.iai.c(new a(m.this, false, this.url, m.b(m.this.vml)));
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