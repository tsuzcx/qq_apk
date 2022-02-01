package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveWatchTimeMgr;", "", "()V", "TAG", "", "recordTimeMap", "", "", "getRecordTimeMap", "()Ljava/util/Map;", "recordTimeMap$delegate", "Lkotlin/Lazy;", "getCurrentWatchTime", "anchorUserName", "joinLive", "", "quitLive", "plugin-finder_release"})
public final class am
{
  private static final f yii;
  public static final am yij;
  
  static
  {
    AppMethodBeat.i(278147);
    yij = new am();
    yii = g.ar((a)a.yik);
    AppMethodBeat.o(278147);
  }
  
  public static Map<String, Long> dzT()
  {
    AppMethodBeat.i(278144);
    Map localMap = (Map)yii.getValue();
    AppMethodBeat.o(278144);
    return localMap;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "", "invoke"})
  static final class a
    extends q
    implements a<Map<String, Long>>
  {
    public static final a yik;
    
    static
    {
      AppMethodBeat.i(254479);
      yik = new a();
      AppMethodBeat.o(254479);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.am
 * JD-Core Version:    0.7.0.1
 */