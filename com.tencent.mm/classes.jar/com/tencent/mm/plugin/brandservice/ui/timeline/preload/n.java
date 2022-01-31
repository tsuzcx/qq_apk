package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class n
{
  public static final n kcu;
  
  static
  {
    AppMethodBeat.i(14952);
    kcu = new n();
    AppMethodBeat.o(14952);
  }
  
  public static final String ak(int paramInt, String paramString)
  {
    AppMethodBeat.i(14948);
    j.q(paramString, "uid");
    paramString = b.aXR() + paramInt + '_' + paramString + ".html";
    ab.i(o.Ot(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(14948);
    return paramString;
  }
  
  public static final String am(int paramInt, String paramString)
  {
    AppMethodBeat.i(14951);
    j.q(paramString, "uid");
    paramString = b.aXR() + paramInt + '_' + paramString + ".fd";
    ab.i(o.Ot(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(14951);
    return paramString;
  }
  
  public static final String q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14949);
    j.q(paramString1, "uid");
    j.q(paramString2, "file");
    paramString1 = b.aXR() + paramInt + '_' + paramString1 + '/' + paramString2;
    ab.i(o.Ot(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(14949);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.n
 * JD-Core Version:    0.7.0.1
 */