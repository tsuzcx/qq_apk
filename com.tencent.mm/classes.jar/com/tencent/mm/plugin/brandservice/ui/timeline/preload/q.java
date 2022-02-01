package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class q
{
  public static final q neF;
  
  static
  {
    AppMethodBeat.i(6737);
    neF = new q();
    AppMethodBeat.o(6737);
  }
  
  public static final String ax(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    k.h(paramString, "uid");
    paramString = b.bEs() + paramInt + '_' + paramString + ".html";
    ad.i(r.abb(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String az(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    k.h(paramString, "uid");
    paramString = b.bEs() + paramInt + '_' + paramString + ".fd";
    ad.i(r.abb(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    k.h(paramString1, "uid");
    k.h(paramString2, "file");
    paramString1 = b.bEs() + paramInt + '_' + paramString1 + '/' + paramString2;
    ad.i(r.abb(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.q
 * JD-Core Version:    0.7.0.1
 */