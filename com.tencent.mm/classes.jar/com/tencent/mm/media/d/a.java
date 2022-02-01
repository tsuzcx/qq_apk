package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/CfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "frameTimeInterval", "", "getFrameTimeInterval", "()J", "setFrameTimeInterval", "(J)V", "init", "", "startTime", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class a
  implements c
{
  private final String TAG = "DecodeStrategy";
  long oss = 33L;
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(93522);
    p.h(paramList, "frames");
    p.h(paramMap, "parents");
    p.h(paramMap1, "outPts");
    Log.i(this.TAG, "use cfr decode strategy");
    long l3 = 0L;
    long l2 = -1L;
    long l5 = -1L;
    if (paramInt2 != 0) {}
    long l4;
    long l6;
    long l7;
    for (;;)
    {
      this.oss = (1000000L / paramInt2);
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (!localIterator.hasNext()) {
        break label286;
      }
      l4 = ((Number)localIterator.next()).longValue();
      l6 = l2;
      l7 = l3;
      if (l4 < paramLong) {
        break;
      }
      l1 = l2;
      if (l2 == -1L)
      {
        l1 = l4;
        l3 = l4;
      }
      l6 = l1;
      l7 = l3;
      if (l4 < l3) {
        break;
      }
      paramMap.put(Long.valueOf(l4), Long.valueOf(l5));
      for (l2 = l3; l4 >= l2; l2 += this.oss)
      {
        Long localLong = Long.valueOf(l4);
        Object localObject = paramMap1.get(localLong);
        paramList = localObject;
        if (localObject == null)
        {
          paramList = (List)new ArrayList();
          paramMap1.put(localLong, paramList);
        }
        ((List)paramList).add(Long.valueOf(l2));
      }
      paramInt2 = paramInt1;
    }
    l2 = l5;
    l3 = l7;
    long l1 = l6;
    for (;;)
    {
      l5 = l2;
      l2 = l1;
      break;
      label286:
      AppMethodBeat.o(93522);
      return;
      l3 = l2;
      l2 = l4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.d.a
 * JD-Core Version:    0.7.0.1
 */