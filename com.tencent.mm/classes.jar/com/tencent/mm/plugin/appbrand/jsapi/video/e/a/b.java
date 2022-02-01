package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "", "maxWeight", "", "(I)V", "currentSortOrder", "nextSampleIndex", "recycledSampleCount", "recycledSamples", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "samples", "Ljava/util/ArrayList;", "totalWeight", "addSample", "", "weight", "value", "", "ensureSortedByIndex", "ensureSortedByValue", "getEstimateValue", "Companion", "Sample", "luggage-commons-jsapi-video-ext_release"})
public final class b
{
  static final Comparator<d> bHu;
  private static final Comparator<d> bHv;
  public static final b.a mBJ;
  int bHA;
  int bHB;
  int bHC;
  final int bHw;
  final ArrayList<d> bHx;
  int bHz;
  final d[] mBI;
  
  static
  {
    AppMethodBeat.i(235233);
    mBJ = new b.a((byte)0);
    bHu = (Comparator)b.mBK;
    bHv = (Comparator)c.mBL;
    AppMethodBeat.o(235233);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(235232);
    this.bHw = paramInt;
    this.mBI = new d[5];
    this.bHx = new ArrayList();
    this.bHz = -1;
    AppMethodBeat.o(235232);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class b<T>
    implements Comparator<b.d>
  {
    public static final b mBK;
    
    static
    {
      AppMethodBeat.i(235230);
      mBK = new b();
      AppMethodBeat.o(235230);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class c<T>
    implements Comparator<b.d>
  {
    public static final c mBL;
    
    static
    {
      AppMethodBeat.i(235231);
      mBL = new c();
      AppMethodBeat.o(235231);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "value", "", "getValue", "()F", "setValue", "(F)V", "weight", "getWeight", "setWeight", "luggage-commons-jsapi-video-ext_release"})
  static final class d
  {
    int index;
    float value;
    int weight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.b
 * JD-Core Version:    0.7.0.1
 */