package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.io;
import com.tencent.mm.autogen.a.io.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderReportUtil;", "", "()V", "onCommentAction", "", "action", "", "commentId", "", "onLikeComment", "isLike", "", "onPostComment", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public static final ak GhA;
  
  static
  {
    AppMethodBeat.i(333535);
    GhA = new ak();
    AppMethodBeat.o(333535);
  }
  
  public static void av(int paramInt, long paramLong)
  {
    AppMethodBeat.i(333530);
    io localio = new io();
    localio.hKb.action = paramInt;
    localio.hKb.commentId = paramLong;
    localio.publish();
    AppMethodBeat.o(333530);
  }
  
  public static void ffl()
  {
    AppMethodBeat.i(333523);
    io localio = new io();
    localio.hKb.action = 1;
    localio.hKb.commentId = 0L;
    localio.publish();
    AppMethodBeat.o(333523);
  }
  
  public static void k(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(333519);
    io localio = new io();
    io.a locala = localio.hKb;
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      locala.action = i;
      localio.hKb.commentId = paramLong;
      localio.publish();
      AppMethodBeat.o(333519);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ak
 * JD-Core Version:    0.7.0.1
 */