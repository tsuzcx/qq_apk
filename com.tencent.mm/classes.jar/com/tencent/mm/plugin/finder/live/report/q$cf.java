package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSURE_BLESS_BAG", "CLICK_LUCKY_BAG", "CLICK_JOIN_LOTTERY", "SEND_SUCC_COMMENT", "POPUP_TOAST_JOINED", "SHOW_WIN_RESULT_CARD", "CLICK_WIN_LIST", "ENTER_WIN_RECORD_BY_RIGHH_CORNER", "CLICK_WIN_ITEM_ENTER_DETAIL", "CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", "LOTTERY_ATTEND_BTN_EXPOSURE", "FOLLOW_SUC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$cf
{
  final int type;
  
  static
  {
    AppMethodBeat.i(351938);
    DFe = new cf("EXPOSURE_BLESS_BAG", 0, 1);
    DFf = new cf("CLICK_LUCKY_BAG", 1, 2);
    DFg = new cf("CLICK_JOIN_LOTTERY", 2, 3);
    DFh = new cf("SEND_SUCC_COMMENT", 3, 4);
    DFi = new cf("POPUP_TOAST_JOINED", 4, 5);
    DFj = new cf("SHOW_WIN_RESULT_CARD", 5, 6);
    DFk = new cf("CLICK_WIN_LIST", 6, 7);
    DFl = new cf("ENTER_WIN_RECORD_BY_RIGHH_CORNER", 7, 8);
    DFm = new cf("CLICK_WIN_ITEM_ENTER_DETAIL", 8, 9);
    DFn = new cf("CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", 9, 10);
    DFo = new cf("LOTTERY_ATTEND_BTN_EXPOSURE", 10, 11);
    DFp = new cf("FOLLOW_SUC", 11, 12);
    DFq = new cf[] { DFe, DFf, DFg, DFh, DFi, DFj, DFk, DFl, DFm, DFn, DFo, DFp };
    AppMethodBeat.o(351938);
  }
  
  private q$cf(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.cf
 * JD-Core Version:    0.7.0.1
 */