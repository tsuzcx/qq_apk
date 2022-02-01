package com.tencent.mm.media.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/CfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "init", "", "startTime", "", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class a
  implements c
{
  private final String TAG = "DecodeStrategy";
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(93522);
    k.h(paramList, "frames");
    k.h(paramMap, "parents");
    k.h(paramMap1, "outPts");
    ac.i(this.TAG, "use cfr decode strategy");
    long l3 = 0L;
    long l2 = -1L;
    long l5 = -1L;
    if (paramInt2 != 0) {}
    long l4;
    long l6;
    long l7;
    for (;;)
    {
      long l8 = 1000000L / paramInt2;
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (!localIterator.hasNext()) {
        break label282;
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
      for (l2 = l3; l4 >= l2; l2 += l8)
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
      label282:
      AppMethodBeat.o(93522);
      return;
      l3 = l2;
      l2 = l4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.c.a
 * JD-Core Version:    0.7.0.1
 */