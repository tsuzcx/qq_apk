package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.jsapi.s.i.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public final String cDW;
  final ac cwK;
  public i.a mKh;
  boolean nBN;
  final LinkedList<String> nBO;
  public final Map<String, a> nBP;
  
  public a(ac paramac)
  {
    AppMethodBeat.i(219494);
    this.cDW = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.mKh = null;
    this.nBO = new LinkedList();
    this.nBP = new ConcurrentHashMap();
    this.cwK = paramac;
    this.nBN = this.cwK.cwV;
    Log.i(this.cDW, "mIsCurPageForeground: " + this.nBN);
    paramac.a(new i.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(219490);
        a locala = a.this;
        Log.i(locala.cDW, "markCurPageForeground");
        locala.nBN = true;
        AppMethodBeat.o(219490);
      }
    });
    paramac.a(new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(219491);
        a locala = a.this;
        Log.i(locala.cDW, "markCurPageBackground");
        locala.nBN = false;
        AppMethodBeat.o(219491);
      }
    });
    AppMethodBeat.o(219494);
  }
  
  public final void aez(String paramString)
  {
    AppMethodBeat.i(219495);
    Log.i(this.cDW, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.nBO)
    {
      this.nBO.remove(paramString);
      AppMethodBeat.o(219495);
      return;
    }
  }
  
  final String bTD()
  {
    AppMethodBeat.i(219496);
    synchronized (this.nBO)
    {
      if (this.nBO.isEmpty())
      {
        AppMethodBeat.o(219496);
        return null;
      }
      String str = (String)this.nBO.getFirst();
      AppMethodBeat.o(219496);
      return str;
    }
  }
  
  public static final class a
  {
    public final int id;
    public b.a nBR;
    public boolean nBS;
    public final h.a nBT;
    public final com.tencent.mm.plugin.appbrand.jsapi.s.c nBU;
    public final g nBV;
    public final i nBW;
    public c nBX;
    
    public a(int paramInt, b paramb, g paramg, h.a parama, com.tencent.mm.plugin.appbrand.jsapi.s.c paramc, c paramc1, i.a parama1)
    {
      AppMethodBeat.i(219492);
      this.nBR = b.a.mnq;
      this.nBS = false;
      this.id = paramInt;
      this.nBV = paramg;
      this.nBT = parama;
      this.nBU = paramc;
      this.nBX = paramc1;
      a(paramb);
      this.nBW = paramg.bIs();
      this.nBW.a(parama1);
      AppMethodBeat.o(219492);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(219493);
      b.a locala = paramb.Px();
      if (locala != null) {
        this.nBR = locala;
      }
      paramb = paramb.Py();
      if (paramb != null) {
        this.nBS = paramb.booleanValue();
      }
      AppMethodBeat.o(219493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a
 * JD-Core Version:    0.7.0.1
 */