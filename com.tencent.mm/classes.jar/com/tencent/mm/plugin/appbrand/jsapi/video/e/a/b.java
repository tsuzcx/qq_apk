package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.ArrayList;
import java.util.Comparator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "", "maxWeight", "", "(I)V", "currentSortOrder", "nextSampleIndex", "recycledSampleCount", "recycledSamples", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "samples", "Ljava/util/ArrayList;", "totalWeight", "addSample", "", "weight", "value", "", "ensureSortedByIndex", "ensureSortedByValue", "getEstimateValue", "Companion", "Sample", "luggage-commons-jsapi-video-ext_release"})
public final class b
{
  static final Comparator<d> bHd;
  private static final Comparator<d> bHe;
  public static final b.a luY;
  final int bHf;
  final ArrayList<d> bHg;
  int bHi;
  int bHj;
  int bHk;
  int bHl;
  final d[] luX;
  
  static
  {
    AppMethodBeat.i(211550);
    luY = new b.a((byte)0);
    bHd = (Comparator)b.luZ;
    bHe = (Comparator)c.lva;
    AppMethodBeat.o(211550);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(211549);
    this.bHf = paramInt;
    this.luX = new d[5];
    this.bHg = new ArrayList();
    this.bHi = -1;
    AppMethodBeat.o(211549);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class b<T>
    implements Comparator<b.d>
  {
    public static final b luZ;
    
    static
    {
      AppMethodBeat.i(211547);
      luZ = new b();
      AppMethodBeat.o(211547);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class c<T>
    implements Comparator<b.d>
  {
    public static final c lva;
    
    static
    {
      AppMethodBeat.i(211548);
      lva = new c();
      AppMethodBeat.o(211548);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "value", "", "getValue", "()F", "setValue", "(F)V", "weight", "getWeight", "setWeight", "luggage-commons-jsapi-video-ext_release"})
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