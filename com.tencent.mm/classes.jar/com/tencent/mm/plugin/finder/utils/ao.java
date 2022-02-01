package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abh;
import com.tencent.mm.g.a.abh.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderReportUtil;", "", "()V", "onCommentAction", "", "action", "", "commentId", "", "onLikeComment", "isLike", "", "onPostComment", "plugin-finder_release"})
public final class ao
{
  public static final ao UpX;
  
  static
  {
    AppMethodBeat.i(258553);
    UpX = new ao();
    AppMethodBeat.o(258553);
  }
  
  public static void bc(int paramInt, long paramLong)
  {
    AppMethodBeat.i(258552);
    abh localabh = new abh();
    localabh.gVp.action = paramInt;
    localabh.gVp.commentId = paramLong;
    EventCenter.instance.publish((IEvent)localabh);
    AppMethodBeat.o(258552);
  }
  
  public static void gEA()
  {
    AppMethodBeat.i(258551);
    abh localabh = new abh();
    localabh.gVp.action = 1;
    localabh.gVp.commentId = 0L;
    EventCenter.instance.publish((IEvent)localabh);
    AppMethodBeat.o(258551);
  }
  
  public static void m(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(258550);
    abh localabh = new abh();
    abh.a locala = localabh.gVp;
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      locala.action = i;
      localabh.gVp.commentId = paramLong;
      EventCenter.instance.publish((IEvent)localabh);
      AppMethodBeat.o(258550);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ao
 * JD-Core Version:    0.7.0.1
 */