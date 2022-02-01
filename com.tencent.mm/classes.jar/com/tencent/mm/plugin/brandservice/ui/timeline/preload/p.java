package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p vTc;
  
  static
  {
    AppMethodBeat.i(6737);
    vTc = new p();
    AppMethodBeat.o(6737);
  }
  
  public static final String aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(6733);
    s.u(paramString, "uid");
    paramString = b.dgO() + paramInt + '_' + paramString + ".html";
    Log.d(q.aUw(), s.X("genTmplPath() tmplPath:", paramString));
    AppMethodBeat.o(6733);
    return paramString;
  }
  
  public static final String aW(int paramInt, String paramString)
  {
    AppMethodBeat.i(6736);
    s.u(paramString, "uid");
    paramString = b.dgO() + paramInt + '_' + paramString + ".fd";
    Log.d(q.aUw(), s.X("genTmplPath() genTmplFDPath:", paramString));
    AppMethodBeat.o(6736);
    return paramString;
  }
  
  public static final String x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(6734);
    s.u(paramString1, "uid");
    s.u(paramString2, "file");
    paramString1 = b.dgO() + paramInt + '_' + paramString1 + '/' + paramString2;
    Log.d(q.aUw(), s.X("genTmplPath() tmplPath:", paramString1));
    AppMethodBeat.o(6734);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.p
 * JD-Core Version:    0.7.0.1
 */