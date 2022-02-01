package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderGlobalRptConstants;", "", "()V", "FINDER_GLOBAL_ENTER_COST", "", "FINDER_LIVE_ENTER_COST", "FINDER_MEGA_VIDEO_TYPE", "FINDER_MULTITASK_ENTER", "FINDER_SHARE_ENTER_LOADING_TYPE", "FINDER_STREAM_LOADING_TYPE", "INNER_VERSION_21680", "", "tempContextId", "", "getTempContextId", "()Ljava/lang/String;", "setTempContextId", "(Ljava/lang/String;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n FpH;
  private static String FpI;
  
  static
  {
    AppMethodBeat.i(331386);
    FpH = new n();
    FpI = "";
    AppMethodBeat.o(331386);
  }
  
  public static void azI(String paramString)
  {
    FpI = paramString;
  }
  
  public static String eMA()
  {
    return FpI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.n
 * JD-Core Version:    0.7.0.1
 */