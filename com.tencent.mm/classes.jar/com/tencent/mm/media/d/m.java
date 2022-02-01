package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/VfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "init", "", "startTime", "", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements c
{
  private final String TAG = "DecodeStrategy";
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(93558);
    s.u(paramList, "frames");
    s.u(paramMap, "parents");
    s.u(paramMap1, "outPts");
    Log.i(this.TAG, "use vfr decode strategy");
    Object localObject1 = paramList.iterator();
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        if (((Number)((Iterator)localObject1).next()).longValue() < paramLong) {
          break label1249;
        }
        j = paramList.size() - i;
        i = j * paramInt2 / paramInt1;
        paramList = p.ag(paramList, j);
        localObject1 = ab.aivy;
        paramLong = System.currentTimeMillis();
        localObject1 = d.nyu;
        s.u(paramList, "frames");
        k = paramList.size();
        localObject1 = new ArrayList(k);
        paramInt1 = 0;
        while (paramInt1 < k)
        {
          ((ArrayList)localObject1).add(Boolean.FALSE);
          paramInt1 += 1;
        }
        localObject1 = (List)localObject1;
        j = i + 1;
        localObject2 = new ArrayList(j);
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject3 = new ArrayList(k);
          paramInt2 = 0;
          while (paramInt2 < k)
          {
            ((ArrayList)localObject3).add(Long.valueOf(2305843009213693952L));
            paramInt2 += 1;
          }
          ((ArrayList)localObject2).add((List)localObject3);
          paramInt1 += 1;
        }
        localObject2 = (List)localObject2;
        j = i + 1;
        localObject3 = new ArrayList(j);
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject4 = new ArrayList(k);
          paramInt2 = 0;
          while (paramInt2 < k)
          {
            ((ArrayList)localObject4).add(Integer.valueOf(-1));
            paramInt2 += 1;
          }
          ((ArrayList)localObject3).add((List)localObject4);
          paramInt1 += 1;
        }
        localObject3 = (List)localObject3;
        ((List)((List)localObject2).get(1)).set(0, Long.valueOf(0L));
        ((List)((List)localObject3).get(1)).set(0, Integer.valueOf(0));
        localObject4 = (List)new ArrayList();
        if (2 <= i)
        {
          paramInt1 = 2;
          ((List)localObject4).clear();
          ((List)localObject4).add(Integer.valueOf(paramInt1 - 2));
          paramInt2 = paramInt1 - 1;
          if (paramInt2 >= k) {}
        }
      }
      for (;;)
      {
        j = paramInt2 + 1;
        double d1;
        double d2;
        while (((List)localObject4).size() > 1)
        {
          d1 = d.a(((Number)((List)localObject4).get(1)).intValue(), ((Number)((List)localObject4).get(0)).intValue(), (List)((List)localObject2).get(paramInt1 - 1), paramList);
          d2 = ((Number)paramList.get(paramInt2)).doubleValue();
          if (d1 >= d.a(((Number)((List)localObject4).get(1)).intValue(), ((Number)((List)localObject4).get(0)).intValue(), paramList) * d2) {
            break;
          }
          ((List)localObject4).remove(0);
        }
        int m = ((Number)p.oK((List)localObject4)).intValue();
        ((List)((List)localObject2).get(paramInt1)).set(paramInt2, Long.valueOf(((Number)((List)((List)localObject2).get(paramInt1 - 1)).get(m)).longValue() + (((Number)paramList.get(paramInt2)).longValue() - ((Number)paramList.get(m)).longValue()) * (((Number)paramList.get(paramInt2)).longValue() - ((Number)paramList.get(m)).longValue())));
        ((List)((List)localObject3).get(paramInt1)).set(paramInt2, Integer.valueOf(m));
        while (((List)localObject4).size() > 1)
        {
          d1 = d.a(paramInt2, ((Number)((List)localObject4).get(p.oE((List)localObject4))).intValue(), (List)((List)localObject2).get(paramInt1 - 1), paramList);
          d2 = d.a(((Number)((List)localObject4).get(p.oE((List)localObject4))).intValue(), ((Number)((List)localObject4).get(p.oE((List)localObject4) - 1)).intValue(), paramList);
          double d3 = d.a(((Number)((List)localObject4).get(p.oE((List)localObject4))).intValue(), ((Number)((List)localObject4).get(p.oE((List)localObject4) - 1)).intValue(), (List)((List)localObject2).get(paramInt1 - 1), paramList);
          if (d1 * d2 >= d.a(paramInt2, ((Number)((List)localObject4).get(p.oE((List)localObject4))).intValue(), paramList) * d3) {
            break;
          }
          ((List)localObject4).remove(p.oE((List)localObject4));
        }
        ((List)localObject4).add(Integer.valueOf(paramInt2));
        if (j >= k)
        {
          if (paramInt1 == i)
          {
            paramInt2 = k - 1;
            paramInt1 = i;
            while (paramInt1 > 0)
            {
              ((List)localObject1).set(paramInt2, Boolean.TRUE);
              paramInt2 = ((Number)((List)((List)localObject3).get(paramInt1)).get(paramInt2)).intValue();
              paramInt1 -= 1;
            }
            long l = System.currentTimeMillis();
            Log.i(this.TAG, "DropFrame, total frames = " + paramList.size() + ", remain frames = " + i + ", cost " + (l - paramLong) + "ms");
            paramLong = -1L;
            paramList = p.d((Iterable)localObject1, (Iterable)paramList).iterator();
            while (paramList.hasNext())
            {
              localObject1 = (r)paramList.next();
              boolean bool = ((Boolean)((r)localObject1).bsC).booleanValue();
              l = ((Number)((r)localObject1).bsD).longValue();
              if (bool)
              {
                paramMap.put(Long.valueOf(l), Long.valueOf(paramLong));
                paramMap1.put(Long.valueOf(l), p.mutableListOf(new Long[] { Long.valueOf(l) }));
                paramLong = l;
              }
            }
            AppMethodBeat.o(93558);
            return;
          }
          paramInt1 += 1;
          break;
        }
        paramInt2 = j;
      }
      label1249:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.d.m
 * JD-Core Version:    0.7.0.1
 */