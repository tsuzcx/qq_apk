package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements f
{
  private List<a> callbacks;
  az fBI;
  int h;
  LinkedList<com.tencent.mm.pluginsdk.location.b> oaC;
  com.tencent.mm.pluginsdk.location.b oaD;
  int w;
  
  public k()
  {
    AppMethodBeat.i(113335);
    this.fBI = new az(1, "location_worker");
    this.oaC = new LinkedList();
    this.oaD = null;
    this.callbacks = new ArrayList();
    this.w = 300;
    this.h = 300;
    start();
    AppMethodBeat.o(113335);
  }
  
  public static String b(com.tencent.mm.pluginsdk.location.b paramb)
  {
    AppMethodBeat.i(113339);
    paramb = com.tencent.mm.a.g.w(paramb.toString().getBytes());
    String str = c.YL() + paramb.charAt(0) + paramb.charAt(1) + "/" + paramb.charAt(3) + paramb.charAt(4) + "/";
    if (!com.tencent.mm.vfs.e.cN(str)) {
      new com.tencent.mm.vfs.b(str).mkdirs();
    }
    paramb = str + "static_map_" + paramb;
    AppMethodBeat.o(113339);
    return paramb;
  }
  
  private void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(113340);
    ab.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator;
    a locala;
    if (paramBoolean)
    {
      if (this.oaD != null)
      {
        localIterator = this.callbacks.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (locala != null) {
            locala.a(b(this.oaD), this.oaD);
          }
        }
      }
    }
    else if (this.oaD != null)
    {
      localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (locala != null) {
          locala.a(this.oaD);
        }
      }
    }
    this.oaD = null;
    agO();
    AppMethodBeat.o(113340);
  }
  
  private void start()
  {
    AppMethodBeat.i(113336);
    com.tencent.mm.kernel.g.Rc().a(648, this);
    AppMethodBeat.o(113336);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(113333);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (parama.equals((a)localIterator.next()))
      {
        AppMethodBeat.o(113333);
        return;
      }
    }
    this.callbacks.add(parama);
    ab.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
    if (this.callbacks.size() == 1) {
      start();
    }
    AppMethodBeat.o(113333);
  }
  
  final void agO()
  {
    AppMethodBeat.i(113338);
    if ((this.oaD == null) && (this.oaC.size() > 0))
    {
      this.oaD = ((com.tencent.mm.pluginsdk.location.b)this.oaC.removeFirst());
      try
      {
        i = Integer.valueOf(bo.bf(com.tencent.mm.m.g.Nq().getValue("StaticMapGetClient"), "")).intValue();
        ab.i("MicroMsg.StaticMapServer", "run local %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          g localg = new g(this.oaD.fBB, this.oaD.fBC, this.oaD.cyX + 1, this.w, this.h, b(this.oaD), aa.dsG());
          com.tencent.mm.kernel.g.Rc().a(localg, 0);
          AppMethodBeat.o(113338);
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
        if (bo.hl(ah.getContext()))
        {
          str = String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.oaD.fBB), Float.valueOf(this.oaD.fBC), Integer.valueOf(this.oaD.cyX), aa.dsG() });
          this.fBI.e(new k.a(this, true, str, b(this.oaD)));
          AppMethodBeat.o(113338);
          return;
        }
        String str = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.oaD.fBC), Float.valueOf(this.oaD.fBB), Integer.valueOf(this.oaD.cyX) });
        this.fBI.e(new k.a(this, false, str, b(this.oaD)));
      }
    }
    AppMethodBeat.o(113338);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(113334);
    this.callbacks.remove(parama);
    ab.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
    if (this.callbacks.size() == 0)
    {
      ab.i("MicroMsg.StaticMapServer", "clean task");
      this.oaC.clear();
      this.oaD = null;
      stop();
    }
    AppMethodBeat.o(113334);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(113341);
    if (paramm.getType() == 648)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0) && (this.oaD != null))
      {
        iR(true);
        AppMethodBeat.o(113341);
        return;
      }
      iR(false);
    }
    AppMethodBeat.o(113341);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(113337);
    ab.i("MicroMsg.StaticMapServer", "stop static map server");
    com.tencent.mm.kernel.g.Rc().b(648, this);
    AppMethodBeat.o(113337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k
 * JD-Core Version:    0.7.0.1
 */