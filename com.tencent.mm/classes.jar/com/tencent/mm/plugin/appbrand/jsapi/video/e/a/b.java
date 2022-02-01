package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "", "maxWeight", "", "(I)V", "currentSortOrder", "nextSampleIndex", "recycledSampleCount", "recycledSamples", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "samples", "Ljava/util/ArrayList;", "totalWeight", "addSample", "", "weight", "value", "", "ensureSortedByIndex", "ensureSortedByValue", "getEstimateValue", "Companion", "Sample", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  static final Comparator<b> dkF;
  private static final Comparator<b> dkG;
  public static final b.a sFt;
  final int dkH;
  final ArrayList<b> dkI;
  int dkK;
  int dkL;
  int dkM;
  int dkN;
  final b[] sFu;
  
  static
  {
    AppMethodBeat.i(328653);
    sFt = new b.a((byte)0);
    dkF = b..ExternalSyntheticLambda0.INSTANCE;
    dkG = b..ExternalSyntheticLambda1.INSTANCE;
    AppMethodBeat.o(328653);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(328639);
    this.dkH = paramInt;
    this.sFu = new b[5];
    this.dkI = new ArrayList();
    this.dkK = -1;
    AppMethodBeat.o(328639);
  }
  
  private static final int a(b paramb1, b paramb2)
  {
    return paramb1.index - paramb2.index;
  }
  
  private static final int b(b paramb1, b paramb2)
  {
    if (paramb1.value < paramb2.value) {
      return -1;
    }
    if (paramb2.value < paramb1.value) {
      return 1;
    }
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding$Sample;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "value", "", "getValue", "()F", "setValue", "(F)V", "weight", "getWeight", "setWeight", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    int index;
    float value;
    int weight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.b
 * JD-Core Version:    0.7.0.1
 */