package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveCloseShowFollowGuideLogic;", "", "()V", "SHOW_FOLLOW_GUIDE_INTERVAL_THRESHOLD", "", "TAG", "", "showFollowGuideWatchTimeThreshold", "getShowFollowGuideWatchTimeThreshold", "()I", "showFollowGuideWatchTimeThreshold$delegate", "Lkotlin/Lazy;", "shouldShowFollowGuide", "", "anchorUserName", "bizUsername", "isBizMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j CFo;
  private static final kotlin.j CFp;
  
  static
  {
    AppMethodBeat.i(359312);
    CFo = new j();
    CFp = k.cm((a)a.CFq);
    AppMethodBeat.o(359312);
  }
  
  public static int ekE()
  {
    AppMethodBeat.i(359306);
    int i = ((Number)CFp.getValue()).intValue();
    AppMethodBeat.o(359306);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Integer>
  {
    public static final a CFq;
    
    static
    {
      AppMethodBeat.i(359561);
      CFq = new a();
      AppMethodBeat.o(359561);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.j
 * JD-Core Version:    0.7.0.1
 */