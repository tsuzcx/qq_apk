package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;
import com.tencent.mm.plugin.appbrand.jsapi.n.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.i;
import com.tencent.mm.plugin.appbrand.jsapi.n.i.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  final aa caw;
  public final String cgL;
  boolean lMr;
  final LinkedList<String> lMs;
  public final Map<String, a> lMt;
  public i.a lbd;
  
  public a(aa paramaa)
  {
    AppMethodBeat.i(193434);
    this.cgL = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.lbd = null;
    this.lMs = new LinkedList();
    this.lMt = new ConcurrentHashMap();
    this.caw = paramaa;
    this.lMr = this.caw.caH;
    ac.i(this.cgL, "mIsCurPageForeground: " + this.lMr);
    paramaa.a(new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(193430);
        a locala = a.this;
        ac.i(locala.cgL, "markCurPageForeground");
        locala.lMr = true;
        AppMethodBeat.o(193430);
      }
    });
    paramaa.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(193431);
        a locala = a.this;
        ac.i(locala.cgL, "markCurPageBackground");
        locala.lMr = false;
        AppMethodBeat.o(193431);
      }
    });
    AppMethodBeat.o(193434);
  }
  
  public final void Qw(String paramString)
  {
    AppMethodBeat.i(193435);
    ac.i(this.cgL, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.lMs)
    {
      this.lMs.remove(paramString);
      AppMethodBeat.o(193435);
      return;
    }
  }
  
  final String bsx()
  {
    AppMethodBeat.i(193436);
    synchronized (this.lMs)
    {
      if (this.lMs.isEmpty())
      {
        AppMethodBeat.o(193436);
        return null;
      }
      String str = (String)this.lMs.getFirst();
      AppMethodBeat.o(193436);
      return str;
    }
  }
  
  public static final class a
  {
    public final int id;
    public final i lMA;
    public c lMB;
    public b.a lMv;
    public boolean lMw;
    public final h.a lMx;
    public final com.tencent.mm.plugin.appbrand.jsapi.n.c lMy;
    public final g lMz;
    
    public a(int paramInt, b paramb, g paramg, h.a parama, com.tencent.mm.plugin.appbrand.jsapi.n.c paramc, c paramc1, i.a parama1)
    {
      AppMethodBeat.i(193432);
      this.lMv = b.a.kHN;
      this.lMw = false;
      this.id = paramInt;
      this.lMz = paramg;
      this.lMx = parama;
      this.lMy = paramc;
      this.lMB = paramc1;
      a(paramb);
      this.lMA = paramg.biy();
      this.lMA.a(parama1);
      AppMethodBeat.o(193432);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(193433);
      b.a locala = paramb.Ei();
      if (locala != null) {
        this.lMv = locala;
      }
      paramb = paramb.Ej();
      if (paramb != null) {
        this.lMw = paramb.booleanValue();
      }
      AppMethodBeat.o(193433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a
 * JD-Core Version:    0.7.0.1
 */