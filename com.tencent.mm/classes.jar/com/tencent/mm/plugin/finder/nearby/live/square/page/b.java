package com.tencent.mm.plugin.finder.nearby.live.square.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabParser;", "", "()V", "COMMENT_SCENE_PREFIX", "", "isFinderLiveSquareCommentScene", "", "commentScene", "isFinderLiveSquareMoreCommentScene", "isFinderLiveSquareOperationCommentScene", "isLocalCityPage", "parseTabCommentScene", "tabId", "parseTabIdFlag", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ELW;
  
  static
  {
    AppMethodBeat.i(341334);
    ELW = new b();
    AppMethodBeat.o(341334);
  }
  
  public static boolean QN(int paramInt)
  {
    return (paramInt == 9500001) || (paramInt == 9500002) || (paramInt == 9500004) || (paramInt == 9500003);
  }
  
  public static boolean QO(int paramInt)
  {
    return paramInt == 112;
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
  
  public static int parseTabIdFlag(int paramInt1, int paramInt2)
  {
    return 1005000 + paramInt2 + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.b
 * JD-Core Version:    0.7.0.1
 */