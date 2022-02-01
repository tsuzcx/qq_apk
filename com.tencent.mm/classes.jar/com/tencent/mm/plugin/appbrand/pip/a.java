package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  final aa ckN;
  public final String crd;
  public i.a lye;
  boolean mmf;
  final LinkedList<String> mmg;
  public final Map<String, a.a> mmh;
  
  public a(aa paramaa)
  {
    AppMethodBeat.i(197351);
    this.crd = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.lye = null;
    this.mmg = new LinkedList();
    this.mmh = new ConcurrentHashMap();
    this.ckN = paramaa;
    this.mmf = this.ckN.ckY;
    ad.i(this.crd, "mIsCurPageForeground: " + this.mmf);
    paramaa.a(new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(197347);
        a locala = a.this;
        ad.i(locala.crd, "markCurPageForeground");
        locala.mmf = true;
        AppMethodBeat.o(197347);
      }
    });
    paramaa.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(197348);
        a locala = a.this;
        ad.i(locala.crd, "markCurPageBackground");
        locala.mmf = false;
        AppMethodBeat.o(197348);
      }
    });
    AppMethodBeat.o(197351);
  }
  
  public final void Ub(String paramString)
  {
    AppMethodBeat.i(197352);
    ad.i(this.crd, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.mmg)
    {
      this.mmg.remove(paramString);
      AppMethodBeat.o(197352);
      return;
    }
  }
  
  final String bwC()
  {
    AppMethodBeat.i(197353);
    synchronized (this.mmg)
    {
      if (this.mmg.isEmpty())
      {
        AppMethodBeat.o(197353);
        return null;
      }
      String str = (String)this.mmg.getFirst();
      AppMethodBeat.o(197353);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a
 * JD-Core Version:    0.7.0.1
 */