package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.t.b;
import com.tencent.mm.plugin.appbrand.jsapi.t.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.i;
import com.tencent.mm.plugin.appbrand.jsapi.t.i.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public final String cED;
  final ad cvo;
  public i.a pKZ;
  boolean qDY;
  final LinkedList<String> qDZ;
  public final Map<String, a> qEa;
  
  public a(ad paramad)
  {
    AppMethodBeat.i(244097);
    this.cED = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.pKZ = null;
    this.qDZ = new LinkedList();
    this.qEa = new ConcurrentHashMap();
    this.cvo = paramad;
    this.qDY = this.cvo.cvA;
    Log.i(this.cED, "mIsCurPageForeground: " + this.qDY);
    paramad.a(new h.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(243550);
        a locala = a.this;
        Log.i(locala.cED, "markCurPageForeground");
        locala.qDY = true;
        AppMethodBeat.o(243550);
      }
    });
    paramad.a(new h.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(242816);
        a locala = a.this;
        Log.i(locala.cED, "markCurPageBackground");
        locala.qDY = false;
        AppMethodBeat.o(242816);
      }
    });
    AppMethodBeat.o(244097);
  }
  
  public final void amt(String paramString)
  {
    AppMethodBeat.i(244098);
    Log.i(this.cED, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.qDZ)
    {
      this.qDZ.remove(paramString);
      AppMethodBeat.o(244098);
      return;
    }
  }
  
  final String cgI()
  {
    AppMethodBeat.i(244099);
    synchronized (this.qDZ)
    {
      if (this.qDZ.isEmpty())
      {
        AppMethodBeat.o(244099);
        return null;
      }
      String str = (String)this.qDZ.getFirst();
      AppMethodBeat.o(244099);
      return str;
    }
  }
  
  public static final class a
  {
    public final int id;
    public b.a qEc;
    public boolean qEd;
    public final h.a qEe;
    public final com.tencent.mm.plugin.appbrand.jsapi.t.c qEf;
    public final g qEg;
    public final i qEh;
    public c qEi;
    
    public a(int paramInt, b paramb, g paramg, h.a parama, com.tencent.mm.plugin.appbrand.jsapi.t.c paramc, c paramc1, i.a parama1)
    {
      AppMethodBeat.i(244351);
      this.qEc = b.a.plw;
      this.qEd = false;
      this.id = paramInt;
      this.qEg = paramg;
      this.qEe = parama;
      this.qEf = paramc;
      this.qEi = paramc1;
      a(paramb);
      this.qEh = paramg.bUa();
      this.qEh.a(parama1);
      AppMethodBeat.o(244351);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(244352);
      b.a locala = paramb.SX();
      if (locala != null) {
        this.qEc = locala;
      }
      paramb = paramb.SY();
      if (paramb != null) {
        this.qEd = paramb.booleanValue();
      }
      AppMethodBeat.o(244352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a
 * JD-Core Version:    0.7.0.1
 */