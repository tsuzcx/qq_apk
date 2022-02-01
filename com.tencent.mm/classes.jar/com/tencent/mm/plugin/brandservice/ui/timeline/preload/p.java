package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class p
{
  public static final p sNx;
  
  static
  {
    AppMethodBeat.i(6737);
    sNx = new p();
    AppMethodBeat.o(6737);
  }
  
  public static final String aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    kotlin.g.b.p.k(paramString, "uid");
    paramString = b.cDo() + paramInt + '_' + paramString + ".html";
    Log.i(q.aBy(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String aJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    kotlin.g.b.p.k(paramString, "uid");
    paramString = b.cDo() + paramInt + '_' + paramString + ".fd";
    Log.i(q.aBy(), "genTmplPath() genTmplFDPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    kotlin.g.b.p.k(paramString1, "uid");
    kotlin.g.b.p.k(paramString2, "file");
    paramString1 = b.cDo() + paramInt + '_' + paramString1 + '/' + paramString2;
    Log.i(q.aBy(), "genTmplPath() tmplPath:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.p
 * JD-Core Version:    0.7.0.1
 */