package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.id;
import com.tencent.mm.f.a.id.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderReportUtil;", "", "()V", "onCommentAction", "", "action", "", "commentId", "", "onLikeComment", "isLike", "", "onPostComment", "plugin-finder_release"})
public final class z
{
  public static final z AEm;
  
  static
  {
    AppMethodBeat.i(226737);
    AEm = new z();
    AppMethodBeat.o(226737);
  }
  
  public static void ap(int paramInt, long paramLong)
  {
    AppMethodBeat.i(226736);
    id localid = new id();
    localid.fFj.action = paramInt;
    localid.fFj.commentId = paramLong;
    EventCenter.instance.publish((IEvent)localid);
    AppMethodBeat.o(226736);
  }
  
  public static void edr()
  {
    AppMethodBeat.i(226731);
    id localid = new id();
    localid.fFj.action = 1;
    localid.fFj.commentId = 0L;
    EventCenter.instance.publish((IEvent)localid);
    AppMethodBeat.o(226731);
  }
  
  public static void h(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(226726);
    id localid = new id();
    id.a locala = localid.fFj;
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      locala.action = i;
      localid.fFj.commentId = paramLong;
      EventCenter.instance.publish((IEvent)localid);
      AppMethodBeat.o(226726);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.z
 * JD-Core Version:    0.7.0.1
 */