package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.w.b;
import com.tencent.mm.plugin.appbrand.jsapi.w.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.i;
import com.tencent.mm.plugin.appbrand.jsapi.w.i.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  final ad enm;
  public final String exO;
  public i.a sPS;
  boolean tIN;
  final LinkedList<String> tIO;
  public final Map<String, a> tIP;
  
  public a(ad paramad)
  {
    AppMethodBeat.i(319592);
    this.exO = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.sPS = null;
    this.tIO = new LinkedList();
    this.tIP = new ConcurrentHashMap();
    this.enm = paramad;
    this.tIN = this.enm.eny;
    Log.i(this.exO, "mIsCurPageForeground: " + this.tIN);
    paramad.a(new i.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(319637);
        a locala = a.this;
        Log.i(locala.exO, "markCurPageForeground");
        locala.tIN = true;
        AppMethodBeat.o(319637);
      }
    });
    paramad.a(new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(319582);
        a locala = a.this;
        Log.i(locala.exO, "markCurPageBackground");
        locala.tIN = false;
        AppMethodBeat.o(319582);
      }
    });
    AppMethodBeat.o(319592);
  }
  
  public final void afG(String paramString)
  {
    AppMethodBeat.i(319599);
    Log.i(this.exO, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.tIO)
    {
      this.tIO.remove(paramString);
      AppMethodBeat.o(319599);
      return;
    }
  }
  
  final String cHG()
  {
    AppMethodBeat.i(319607);
    synchronized (this.tIO)
    {
      if (this.tIO.isEmpty())
      {
        AppMethodBeat.o(319607);
        return null;
      }
      String str = (String)this.tIO.getFirst();
      AppMethodBeat.o(319607);
      return str;
    }
  }
  
  public static final class a
  {
    public final int id;
    public b.a tIR;
    public boolean tIS;
    public final h.a tIT;
    public final com.tencent.mm.plugin.appbrand.jsapi.w.c tIU;
    public final g tIV;
    public final i tIW;
    public c tIX;
    
    public a(int paramInt, b paramb, g paramg, h.a parama, com.tencent.mm.plugin.appbrand.jsapi.w.c paramc, c paramc1, i.a parama1)
    {
      AppMethodBeat.i(319578);
      this.tIR = b.a.sqy;
      this.tIS = false;
      this.id = paramInt;
      this.tIV = paramg;
      this.tIT = parama;
      this.tIU = paramc;
      this.tIX = paramc1;
      a(paramb);
      this.tIW = paramg.cun();
      this.tIW.a(parama1);
      AppMethodBeat.o(319578);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(319584);
      b.a locala = paramb.atC();
      if (locala != null) {
        this.tIR = locala;
      }
      paramb = paramb.atD();
      if (paramb != null) {
        this.tIS = paramb.booleanValue();
      }
      AppMethodBeat.o(319584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a
 * JD-Core Version:    0.7.0.1
 */