package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class r
{
  public static final r nHq;
  
  static
  {
    AppMethodBeat.i(6737);
    nHq = new r();
    AppMethodBeat.o(6737);
  }
  
  public static final String aA(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    k.h(paramString, "uid");
    paramString = b.bLG() + paramInt + '_' + paramString + ".fd";
    ac.i(s.abZ(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String ay(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    k.h(paramString, "uid");
    paramString = b.bLG() + paramInt + '_' + paramString + ".html";
    ac.i(s.abZ(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    k.h(paramString1, "uid");
    k.h(paramString2, "file");
    paramString1 = b.bLG() + paramInt + '_' + paramString1 + '/' + paramString2;
    ac.i(s.abZ(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.r
 * JD-Core Version:    0.7.0.1
 */