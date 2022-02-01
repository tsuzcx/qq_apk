package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class t
{
  public static final t pDu;
  
  static
  {
    AppMethodBeat.i(6737);
    pDu = new t();
    AppMethodBeat.o(6737);
  }
  
  public static final String aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    p.h(paramString, "uid");
    paramString = b.coS() + paramInt + '_' + paramString + ".html";
    Log.i(u.auD(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    p.h(paramString, "uid");
    paramString = b.coS() + paramInt + '_' + paramString + ".fd";
    Log.i(u.auD(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    p.h(paramString1, "uid");
    p.h(paramString2, "file");
    paramString1 = b.coS() + paramInt + '_' + paramString1 + '/' + paramString2;
    Log.i(u.auD(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.t
 * JD-Core Version:    0.7.0.1
 */