package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$FloatActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_FLOAT_ACTION_UNKNOWN", "LIVE_FLOAT_ACTION_MAXIMIZE", "LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", "LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", "LIVE_FLOAT_ACTION_ENTER_PROFILE", "VISITOR_CLICK_ENTER_LOTTERY_RECORD", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$z
{
  public final int type;
  
  static
  {
    AppMethodBeat.i(351636);
    Dxw = new z("LIVE_FLOAT_ACTION_UNKNOWN", 0, 0);
    Dxx = new z("LIVE_FLOAT_ACTION_MAXIMIZE", 1, 1);
    Dxy = new z("LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", 2, 2);
    Dxz = new z("LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", 3, 3);
    DxA = new z("LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", 4, 4);
    DxB = new z("LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", 5, 5);
    DxC = new z("LIVE_FLOAT_ACTION_ENTER_PROFILE", 6, 6);
    DxD = new z("VISITOR_CLICK_ENTER_LOTTERY_RECORD", 7, 7);
    DxE = new z[] { Dxw, Dxx, Dxy, Dxz, DxA, DxB, DxC, DxD };
    AppMethodBeat.o(351636);
  }
  
  private q$z(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.z
 * JD-Core Version:    0.7.0.1
 */