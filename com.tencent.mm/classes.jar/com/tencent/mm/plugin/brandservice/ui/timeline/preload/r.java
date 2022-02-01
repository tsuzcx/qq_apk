package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class r
{
  public static final r opT;
  
  static
  {
    AppMethodBeat.i(6737);
    opT = new r();
    AppMethodBeat.o(6737);
  }
  
  public static final String aA(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    p.h(paramString, "uid");
    paramString = b.bRi() + paramInt + '_' + paramString + ".html";
    ae.i(s.aeP(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    p.h(paramString, "uid");
    paramString = b.bRi() + paramInt + '_' + paramString + ".fd";
    ae.i(s.aeP(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    p.h(paramString1, "uid");
    p.h(paramString2, "file");
    paramString1 = b.bRi() + paramInt + '_' + paramString1 + '/' + paramString2;
    ae.i(s.aeP(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.r
 * JD-Core Version:    0.7.0.1
 */