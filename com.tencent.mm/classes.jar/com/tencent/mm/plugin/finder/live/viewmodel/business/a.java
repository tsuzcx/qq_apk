package com.tencent.mm.plugin.finder.live.viewmodel.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/business/LiveReportSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "joinStatus", "", "markJoinStatusRecResp", "", "markJoinStatusWaitResp", "onCleared", "reportJoinLive", "screenStateOfConfig", "newCommentScene", "", "newChnlExtra", "exitLive", "", "actionResult", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a DZS;
  private static final int DZU = 0;
  public static final int DZV;
  public static final int DZW;
  public static final String TAG;
  public int DZT;
  
  static
  {
    AppMethodBeat.i(356332);
    DZS = new a((byte)0);
    TAG = "Finder.LiveReportSlice";
    DZV = 1;
    DZW = 2;
    AppMethodBeat.o(356332);
  }
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356315);
    this.DZT = DZU;
    AppMethodBeat.o(356315);
  }
  
  public final void onCleared()
  {
    this.DZT = DZU;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/business/LiveReportSlice$Companion;", "", "()V", "REPORT_JOIN_STATUS_DEFAULT", "", "getREPORT_JOIN_STATUS_DEFAULT", "()I", "REPORT_JOIN_STATUS_REC_RESP", "getREPORT_JOIN_STATUS_REC_RESP", "REPORT_JOIN_STATUS_WAIT_RESP", "getREPORT_JOIN_STATUS_WAIT_RESP", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.business.a
 * JD-Core Version:    0.7.0.1
 */