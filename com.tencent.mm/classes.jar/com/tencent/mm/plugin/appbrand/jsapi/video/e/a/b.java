package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "", "maxWeight", "", "(I)V", "currentSortOrder", "nextSampleIndex", "recycledSampleCount", "recycledSamples", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "samples", "Ljava/util/ArrayList;", "totalWeight", "addSample", "", "weight", "value", "", "ensureSortedByIndex", "ensureSortedByValue", "getEstimateValue", "Companion", "Sample", "luggage-commons-jsapi-video-ext_release"})
public final class b
{
  static final Comparator<d> brb;
  private static final Comparator<d> brc;
  public static final b.a pAr;
  final int brd;
  final ArrayList<d> bre;
  int brg;
  int brh;
  int bri;
  int brj;
  final d[] pAq;
  
  static
  {
    AppMethodBeat.i(229309);
    pAr = new b.a((byte)0);
    brb = (Comparator)b.pAs;
    brc = (Comparator)c.pAt;
    AppMethodBeat.o(229309);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(229306);
    this.brd = paramInt;
    this.pAq = new d[5];
    this.bre = new ArrayList();
    this.brg = -1;
    AppMethodBeat.o(229306);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class b<T>
    implements Comparator<b.d>
  {
    public static final b pAs;
    
    static
    {
      AppMethodBeat.i(228881);
      pAs = new b();
      AppMethodBeat.o(228881);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class c<T>
    implements Comparator<b.d>
  {
    public static final c pAt;
    
    static
    {
      AppMethodBeat.i(228383);
      pAt = new c();
      AppMethodBeat.o(228383);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "value", "", "getValue", "()F", "setValue", "(F)V", "weight", "getWeight", "setWeight", "luggage-commons-jsapi-video-ext_release"})
  static final class d
  {
    int index;
    float value;
    int weight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.b
 * JD-Core Version:    0.7.0.1
 */