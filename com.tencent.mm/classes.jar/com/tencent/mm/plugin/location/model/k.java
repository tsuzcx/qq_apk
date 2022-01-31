package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements f
{
  List<a> dhm = new ArrayList();
  av elq = new av(1, "location_worker");
  int h = 300;
  LinkedList<com.tencent.mm.pluginsdk.location.b> lDq = new LinkedList();
  com.tencent.mm.pluginsdk.location.b lDr = null;
  int w = 300;
  
  public k()
  {
    start();
  }
  
  public static String b(com.tencent.mm.pluginsdk.location.b paramb)
  {
    paramb = com.tencent.mm.a.g.o(paramb.toString().getBytes());
    String str = c.FH() + paramb.charAt(0) + paramb.charAt(1) + "/" + paramb.charAt(3) + paramb.charAt(4) + "/";
    if (!com.tencent.mm.vfs.e.bK(str)) {
      new com.tencent.mm.vfs.b(str).mkdirs();
    }
    return str + "static_map_" + paramb;
  }
  
  private void hh(boolean paramBoolean)
  {
    y.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator;
    a locala;
    if (paramBoolean)
    {
      if (this.lDr != null)
      {
        localIterator = this.dhm.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (locala != null) {
            locala.a(b(this.lDr), this.lDr);
          }
        }
      }
    }
    else if (this.lDr != null)
    {
      localIterator = this.dhm.iterator();
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (locala != null) {
          locala.a(this.lDr);
        }
      }
    }
    this.lDr = null;
    Oa();
  }
  
  final void Oa()
  {
    if ((this.lDr == null) && (this.lDq.size() > 0)) {
      this.lDr = ((com.tencent.mm.pluginsdk.location.b)this.lDq.removeFirst());
    }
    try
    {
      i = Integer.valueOf(bk.aM(com.tencent.mm.m.g.AA().getValue("StaticMapGetClient"), "")).intValue();
      y.i("MicroMsg.StaticMapServer", "run local %d", new Object[] { Integer.valueOf(i) });
      if (i == 0)
      {
        g localg = new g(this.lDr.elk, this.lDr.ell, this.lDr.bRv + 1, this.w, this.h, b(this.lDr), x.cqJ());
        com.tencent.mm.kernel.g.Dk().a(localg, 0);
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
      if (bk.fV(ae.getContext()))
      {
        str = String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.lDr.elk), Float.valueOf(this.lDr.ell), Integer.valueOf(this.lDr.bRv), x.cqJ() });
        this.elq.c(new k.a(this, true, str, b(this.lDr)));
        return;
      }
      String str = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.lDr.ell), Float.valueOf(this.lDr.elk), Integer.valueOf(this.lDr.bRv) });
      this.elq.c(new k.a(this, false, str, b(this.lDr)));
    }
  }
  
  public final void a(a parama)
  {
    this.dhm.remove(parama);
    y.i("MicroMsg.StaticMapServer", "removeCallback " + this.dhm.size());
    if (this.dhm.size() == 0)
    {
      y.i("MicroMsg.StaticMapServer", "clean task");
      this.lDq.clear();
      this.lDr = null;
      stop();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 648)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (this.lDr != null)) {
        hh(true);
      }
    }
    else {
      return;
    }
    hh(false);
  }
  
  public final void start()
  {
    com.tencent.mm.kernel.g.Dk().a(648, this);
  }
  
  public final void stop()
  {
    y.i("MicroMsg.StaticMapServer", "stop static map server");
    com.tencent.mm.kernel.g.Dk().b(648, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */