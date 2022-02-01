package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveDescHelper;", "", "()V", "endStickyCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "msgPos", "", "isFromManual", "", "getEndStickyCallback", "()Lkotlin/jvm/functions/Function2;", "setEndStickyCallback", "(Lkotlin/jvm/functions/Function2;)V", "inSticky", "manualClearSticky", "needCheckShowTime", "needStickyTime", "getNeedStickyTime", "()I", "needStickyTime$delegate", "Lkotlin/Lazy;", "startStickyCallback", "", "content", "getStartStickyCallback", "setStartStickyCallback", "targetStickyCommentMsgIndex", "getTargetStickyCommentMsgIndex", "setTargetStickyCommentMsgIndex", "(I)V", "targetStickyCommentMsgSeq", "", "targetStickyCommentMsgStartShowTime", "weirdLockSticky", "checkSticky", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "curVisiableFirstPosition", "compatibleSysLawTipPosAdd", "isInSticky", "msgIndex", "onDescShow", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "reset", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final a CFt;
  
  static
  {
    AppMethodBeat.i(359339);
    CFt = new a((byte)0);
    AppMethodBeat.o(359339);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveDescHelper$Companion;", "", "()V", "MinStickyTime", "", "NeedStickyTimeDefault", "", "TAG", "", "isDescMsgType", "", "msgType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean OP(int paramInt)
    {
      return (paramInt == 100000) || (paramInt == 20036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.l
 * JD-Core Version:    0.7.0.1
 */