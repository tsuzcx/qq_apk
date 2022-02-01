package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/SimpleVfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "frameTimeInterval", "", "getFrameTimeInterval", "()J", "setFrameTimeInterval", "(J)V", "avgFrameInterval", "", "startPts", "endPts", "frameCount", "", "init", "", "startTime", "frames", "", "inFPS", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class m
  implements c
{
  private final String TAG = "DecodeStrategy";
  private long kSw = 33L;
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(259930);
    p.k(paramList, "frames");
    p.k(paramMap, "parents");
    p.k(paramMap1, "outPts");
    Log.i(this.TAG, "use simple vfr decode strategy");
    long l1 = -1L;
    long l3;
    label70:
    long l5;
    long l4;
    long l2;
    float f;
    if (paramInt2 != 0)
    {
      this.kSw = (1000000L / paramInt2);
      paramList = ((Iterable)paramList).iterator();
      l3 = -1L;
      if (!paramList.hasNext()) {
        break label251;
      }
      l5 = ((Number)paramList.next()).longValue();
      l4 = l1;
      if (l5 < paramLong) {
        break label257;
      }
      l2 = l1;
      if (l1 == -1L) {
        l2 = l5;
      }
      paramInt1 = paramMap.size() + 1;
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label236;
      }
      kotlin.g.b.l locall = kotlin.g.b.l.aaBt;
      f = kotlin.g.b.l.iCk();
      label153:
      l4 = l2;
      if (f < (float)this.kSw) {
        break label257;
      }
      paramMap.put(Long.valueOf(l5), Long.valueOf(l3));
      paramMap1.put(Long.valueOf(l5), j.mutableListOf(new Long[] { Long.valueOf(l5) }));
      l1 = l2;
      l2 = l5;
    }
    for (;;)
    {
      l3 = l2;
      break label70;
      paramInt2 = paramInt1;
      break;
      label236:
      f = (float)(l5 - l2) / paramInt1;
      break label153;
      label251:
      AppMethodBeat.o(259930);
      return;
      label257:
      l2 = l3;
      l1 = l4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.d.m
 * JD-Core Version:    0.7.0.1
 */