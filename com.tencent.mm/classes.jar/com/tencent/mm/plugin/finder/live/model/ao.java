package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveWatchTimeMgr;", "", "()V", "TAG", "", "recordTimeMap", "", "", "getRecordTimeMap", "()Ljava/util/Map;", "recordTimeMap$delegate", "Lkotlin/Lazy;", "getCurrentWatchTime", "anchorUserName", "joinLive", "", "quitLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  public static final ao CIe;
  private static final j CIf;
  
  static
  {
    AppMethodBeat.i(360348);
    CIe = new ao();
    CIf = k.cm((a)a.CIg);
    AppMethodBeat.o(360348);
  }
  
  public static Map<String, Long> emf()
  {
    AppMethodBeat.i(360343);
    Map localMap = (Map)CIf.getValue();
    AppMethodBeat.o(360343);
    return localMap;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Map<String, Long>>
  {
    public static final a CIg;
    
    static
    {
      AppMethodBeat.i(359538);
      CIg = new a();
      AppMethodBeat.o(359538);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ao
 * JD-Core Version:    0.7.0.1
 */