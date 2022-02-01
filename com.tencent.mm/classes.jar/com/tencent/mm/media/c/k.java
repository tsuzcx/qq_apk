package com.tencent.mm.media.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/decoder/PassthroughDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "init", "", "startTime", "", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class k
  implements c
{
  private final String TAG = "DecodeStrategy";
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(93557);
    d.g.b.k.h(paramList, "frames");
    d.g.b.k.h(paramMap, "parents");
    d.g.b.k.h(paramMap1, "outPts");
    ad.i(this.TAG, "use passthrough decode strategy");
    paramList = ((Iterable)paramList).iterator();
    long l1 = -1L;
    if (paramList.hasNext())
    {
      long l2 = ((Number)paramList.next()).longValue();
      if (l2 < paramLong) {
        break label138;
      }
      paramMap.put(Long.valueOf(l2), Long.valueOf(l1));
      paramMap1.put(Long.valueOf(l2), j.mutableListOf(new Long[] { Long.valueOf(l2) }));
      l1 = l2;
    }
    label138:
    for (;;)
    {
      break;
      AppMethodBeat.o(93557);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.c.k
 * JD-Core Version:    0.7.0.1
 */