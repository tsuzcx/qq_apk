package com.tencent.mm.plugin.finder.nearby.live.square.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabParser;", "", "()V", "COMMENT_SCENE_PREFIX", "", "isFinderLiveSquareCommentScene", "", "commentScene", "isFinderLiveSquareMoreCommentScene", "isFinderLiveSquareOperationCommentScene", "parseTabCommentScene", "tabId", "parseTabIdFlag", "plugin-finder-nearby_release"})
public final class a
{
  public static final a zGC;
  
  static
  {
    AppMethodBeat.i(199953);
    zGC = new a();
    AppMethodBeat.o(199953);
  }
  
  public static int Ou(int paramInt)
  {
    return 1005000 + paramInt;
  }
  
  public static boolean Ov(int paramInt)
  {
    return (paramInt == 9500001) || (paramInt == 9500002);
  }
  
  public static boolean isFinderLiveSquareCommentScene(int paramInt)
  {
    return paramInt / 100000 == 94;
  }
  
  public static boolean isFinderLiveSquareMoreCommentScene(int paramInt)
  {
    return (paramInt / 100000 == 80) || (paramInt == 80);
  }
  
  public static int parseTabCommentScene(int paramInt1, int paramInt2)
  {
    return 100000 * paramInt1 + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.a
 * JD-Core Version:    0.7.0.1
 */