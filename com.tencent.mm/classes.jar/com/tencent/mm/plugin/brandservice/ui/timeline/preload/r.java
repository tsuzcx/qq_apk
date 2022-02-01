package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class r
{
  public static final r ojT;
  
  static
  {
    AppMethodBeat.i(6737);
    ojT = new r();
    AppMethodBeat.o(6737);
  }
  
  public static final String aB(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    p.h(paramString, "uid");
    paramString = b.bQh() + paramInt + '_' + paramString + ".html";
    ad.i(s.aeD(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String aD(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    p.h(paramString, "uid");
    paramString = b.bQh() + paramInt + '_' + paramString + ".fd";
    ad.i(s.aeD(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    p.h(paramString1, "uid");
    p.h(paramString2, "file");
    paramString1 = b.bQh() + paramInt + '_' + paramString1 + '/' + paramString2;
    ad.i(s.aeD(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.r
 * JD-Core Version:    0.7.0.1
 */