package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/SimpleVfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "frameTimeInterval", "", "getFrameTimeInterval", "()J", "setFrameTimeInterval", "(J)V", "avgFrameInterval", "", "startPts", "endPts", "frameCount", "", "init", "", "startTime", "frames", "", "inFPS", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements c
{
  private final String TAG = "DecodeStrategy";
  private long nyf = 33L;
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(236900);
    s.u(paramList, "frames");
    s.u(paramMap, "parents");
    s.u(paramMap1, "outPts");
    Log.i(this.TAG, "use simple vfr decode strategy");
    long l1 = -1L;
    long l3 = -1L;
    label70:
    long l4;
    long l2;
    float f;
    if (paramInt2 != 0)
    {
      this.nyf = (1000000L / paramInt2);
      paramList = ((Iterable)paramList).iterator();
      if (!paramList.hasNext()) {
        break label258;
      }
      long l5 = ((Number)paramList.next()).longValue();
      l4 = l1;
      if (l5 < paramLong) {
        break label264;
      }
      l2 = l1;
      if (l1 == -1L) {
        l2 = l5;
      }
      paramInt1 = paramMap.size() + 1;
      switch (paramInt1)
      {
      default: 
        f = (float)(l5 - l2) / paramInt1;
        label168:
        l4 = l2;
        if (f >= (float)this.nyf)
        {
          paramMap.put(Long.valueOf(l5), Long.valueOf(l3));
          paramMap1.put(Long.valueOf(l5), p.mutableListOf(new Long[] { Long.valueOf(l5) }));
          l1 = l2;
          l2 = l5;
        }
        break;
      }
    }
    for (;;)
    {
      l3 = l2;
      break label70;
      paramInt2 = paramInt1;
      break;
      f = 3.4028235E+38F;
      break label168;
      label258:
      AppMethodBeat.o(236900);
      return;
      label264:
      l2 = l3;
      l1 = l4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.d.l
 * JD-Core Version:    0.7.0.1
 */