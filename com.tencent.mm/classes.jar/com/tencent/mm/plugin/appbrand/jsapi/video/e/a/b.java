package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.ArrayList;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "", "maxWeight", "", "(I)V", "currentSortOrder", "nextSampleIndex", "recycledSampleCount", "recycledSamples", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "samples", "Ljava/util/ArrayList;", "totalWeight", "addSample", "", "weight", "value", "", "ensureSortedByIndex", "ensureSortedByValue", "getEstimateValue", "Companion", "Sample", "luggage-commons-jsapi-video-ext_release"})
public final class b
{
  static final Comparator<d> bHd;
  private static final Comparator<d> bHe;
  public static final b.a lqA;
  final int bHf;
  final ArrayList<d> bHg;
  int bHi;
  int bHj;
  int bHk;
  int bHl;
  final d[] lqz;
  
  static
  {
    AppMethodBeat.i(206520);
    lqA = new b.a((byte)0);
    bHd = (Comparator)b.lqB;
    bHe = (Comparator)c.lqC;
    AppMethodBeat.o(206520);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(206519);
    this.bHf = paramInt;
    this.lqz = new d[5];
    this.bHg = new ArrayList();
    this.bHi = -1;
    AppMethodBeat.o(206519);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class b<T>
    implements Comparator<b.d>
  {
    public static final b lqB;
    
    static
    {
      AppMethodBeat.i(206517);
      lqB = new b();
      AppMethodBeat.o(206517);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class c<T>
    implements Comparator<b.d>
  {
    public static final c lqC;
    
    static
    {
      AppMethodBeat.i(206518);
      lqC = new c();
      AppMethodBeat.o(206518);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "value", "", "getValue", "()F", "setValue", "(F)V", "weight", "getWeight", "setWeight", "luggage-commons-jsapi-video-ext_release"})
  static final class d
  {
    int index;
    float value;
    int weight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.b
 * JD-Core Version:    0.7.0.1
 */