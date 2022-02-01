package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.q.b;
import com.tencent.mm.plugin.appbrand.jsapi.q.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  final z ckP;
  public final String crG;
  public i.a lCC;
  boolean mrc;
  final LinkedList<String> mrd;
  public final Map<String, a> mre;
  
  public a(z paramz)
  {
    AppMethodBeat.i(207892);
    this.crG = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.lCC = null;
    this.mrd = new LinkedList();
    this.mre = new ConcurrentHashMap();
    this.ckP = paramz;
    this.mrc = this.ckP.cla;
    ae.i(this.crG, "mIsCurPageForeground: " + this.mrc);
    paramz.a(new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(207888);
        a locala = a.this;
        ae.i(locala.crG, "markCurPageForeground");
        locala.mrc = true;
        AppMethodBeat.o(207888);
      }
    });
    paramz.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(207889);
        a locala = a.this;
        ae.i(locala.crG, "markCurPageBackground");
        locala.mrc = false;
        AppMethodBeat.o(207889);
      }
    });
    AppMethodBeat.o(207892);
  }
  
  public final void UL(String paramString)
  {
    AppMethodBeat.i(207893);
    ae.i(this.crG, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.mrd)
    {
      this.mrd.remove(paramString);
      AppMethodBeat.o(207893);
      return;
    }
  }
  
  final String bxt()
  {
    AppMethodBeat.i(207894);
    synchronized (this.mrd)
    {
      if (this.mrd.isEmpty())
      {
        AppMethodBeat.o(207894);
        return null;
      }
      String str = (String)this.mrd.getFirst();
      AppMethodBeat.o(207894);
      return str;
    }
  }
  
  public static final class a
  {
    public final int id;
    public b.a mrg;
    public boolean mrh;
    public final h.a mri;
    public final com.tencent.mm.plugin.appbrand.jsapi.q.c mrj;
    public final g mrk;
    public final i mrl;
    public c mrm;
    
    public a(int paramInt, b paramb, g paramg, h.a parama, com.tencent.mm.plugin.appbrand.jsapi.q.c paramc, c paramc1, i.a parama1)
    {
      AppMethodBeat.i(207890);
      this.mrg = b.a.lhS;
      this.mrh = false;
      this.id = paramInt;
      this.mrk = paramg;
      this.mri = parama;
      this.mrj = paramc;
      this.mrm = paramc1;
      a(paramb);
      this.mrl = paramg.bmT();
      this.mrl.a(parama1);
      AppMethodBeat.o(207890);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(207891);
      b.a locala = paramb.FO();
      if (locala != null) {
        this.mrg = locala;
      }
      paramb = paramb.FP();
      if (paramb != null) {
        this.mrh = paramb.booleanValue();
      }
      AppMethodBeat.o(207891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a
 * JD-Core Version:    0.7.0.1
 */