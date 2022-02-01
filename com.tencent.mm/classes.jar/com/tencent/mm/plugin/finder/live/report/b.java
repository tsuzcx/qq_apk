package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ex;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/DeviceStatusReporter;", "", "()V", "TAG", "", "finderNickname", "liveId", "liveScene", "", "reportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doReport", "", "startReportDeviceStatus", "currentLiveScene", "isAnchor", "", "stopReportDeviceStatus", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  long Dnb;
  private final String TAG;
  String liveId;
  String mPd;
  final MTimerHandler mPe;
  
  public b()
  {
    AppMethodBeat.i(351791);
    this.TAG = "Finder.DeviceStatusReporter";
    this.mPe = new MTimerHandler(this.TAG, new b..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(351791);
  }
  
  private static final boolean a(b paramb)
  {
    int i = 2;
    AppMethodBeat.i(351802);
    s.u(paramb, "this$0");
    ex localex = new ex();
    localex.iCR = localex.F("LiveId", paramb.liveId, true);
    localex.iGi = paramb.Dnb;
    localex.iGj = localex.F("FinderNickname", paramb.mPd, true);
    paramb = a.DJT;
    paramb = MMApplicationContext.getContext();
    s.s(paramb, "getContext()");
    paramb = a.gA(paramb);
    localex.iGm = (paramb[0] / 10);
    if (paramb[1] == 2)
    {
      localex.iGk = i;
      paramb = a.DJT;
      paramb = a.euQ();
      if (paramb != null) {
        break label148;
      }
    }
    label148:
    for (i = 0;; i = paramb.intValue())
    {
      localex.iGl = i;
      localex.bMH();
      AppMethodBeat.o(351802);
      return true;
      if (paramb[1] == 5)
      {
        i = 3;
        break;
      }
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.b
 * JD-Core Version:    0.7.0.1
 */