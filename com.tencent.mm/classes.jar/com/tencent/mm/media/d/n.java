package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/VfrDecodeStrategy;", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "init", "", "startTime", "", "frames", "", "inFPS", "", "outFPS", "parents", "", "outPts", "", "plugin-mediaeditor_release"})
public final class n
  implements c
{
  private final String TAG = "DecodeStrategy";
  
  public final void a(long paramLong, List<Long> paramList, int paramInt1, int paramInt2, Map<Long, Long> paramMap, Map<Long, List<Long>> paramMap1)
  {
    AppMethodBeat.i(93558);
    p.k(paramList, "frames");
    p.k(paramMap, "parents");
    p.k(paramMap1, "outPts");
    Log.i(this.TAG, "use vfr decode strategy");
    int i = 0;
    Object localObject1 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject1).hasNext()) {
      if (((Number)((Iterator)localObject1).next()).longValue() >= paramLong)
      {
        int j = paramList.size() - i;
        i = j * paramInt2 / paramInt1;
        paramList = j.O(paramList, j);
        localObject1 = v.aaAd;
        paramLong = System.currentTimeMillis();
        localObject1 = d.kSM;
        p.k(paramList, "frames");
        j = paramList.size();
        localObject1 = new ArrayList(j);
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          ((ArrayList)localObject1).add(Boolean.FALSE);
          paramInt1 += 1;
        }
        localObject1 = (List)localObject1;
        int k = i + 1;
        Object localObject2 = new ArrayList(k);
        paramInt1 = 0;
        while (paramInt1 < k)
        {
          localObject3 = new ArrayList(j);
          paramInt2 = 0;
          while (paramInt2 < j)
          {
            ((ArrayList)localObject3).add(Long.valueOf(2305843009213693952L));
            paramInt2 += 1;
          }
          ((ArrayList)localObject2).add((List)localObject3);
          paramInt1 += 1;
        }
        localObject2 = (List)localObject2;
        k = i + 1;
        Object localObject3 = new ArrayList(k);
        paramInt1 = 0;
        while (paramInt1 < k)
        {
          localObject4 = new ArrayList(j);
          paramInt2 = 0;
          while (paramInt2 < j)
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
        Object localObject4 = (List)new ArrayList();
        if (2 <= i)
        {
          paramInt1 = 2;
          for (;;)
          {
            ((List)localObject4).clear();
            ((List)localObject4).add(Integer.valueOf(paramInt1 - 2));
            paramInt2 = paramInt1 - 1;
            while (paramInt2 < j)
            {
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
              k = ((Number)j.lo((List)localObject4)).intValue();
              ((List)((List)localObject2).get(paramInt1)).set(paramInt2, Long.valueOf(((Number)((List)((List)localObject2).get(paramInt1 - 1)).get(k)).longValue() + (((Number)paramList.get(paramInt2)).longValue() - ((Number)paramList.get(k)).longValue()) * (((Number)paramList.get(paramInt2)).longValue() - ((Number)paramList.get(k)).longValue())));
              ((List)((List)localObject3).get(paramInt1)).set(paramInt2, Integer.valueOf(k));
              while (((List)localObject4).size() > 1)
              {
                d1 = d.a(paramInt2, ((Number)((List)localObject4).get(j.lk((List)localObject4))).intValue(), (List)((List)localObject2).get(paramInt1 - 1), paramList);
                d2 = d.a(((Number)((List)localObject4).get(j.lk((List)localObject4))).intValue(), ((Number)((List)localObject4).get(j.lk((List)localObject4) - 1)).intValue(), paramList);
                double d3 = d.a(((Number)((List)localObject4).get(j.lk((List)localObject4))).intValue(), ((Number)((List)localObject4).get(j.lk((List)localObject4) - 1)).intValue(), (List)((List)localObject2).get(paramInt1 - 1), paramList);
                if (d1 * d2 >= d.a(paramInt2, ((Number)((List)localObject4).get(j.lk((List)localObject4))).intValue(), paramList) * d3) {
                  break;
                }
                ((List)localObject4).remove(j.lk((List)localObject4));
              }
              ((List)localObject4).add(Integer.valueOf(paramInt2));
              paramInt2 += 1;
            }
            if (paramInt1 == i) {
              break;
            }
            paramInt1 += 1;
          }
        }
        paramInt2 = j - 1;
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
        paramList = j.c((Iterable)localObject1, (Iterable)paramList).iterator();
        label1133:
        if (paramList.hasNext())
        {
          localObject1 = (o)paramList.next();
          boolean bool = ((Boolean)((o)localObject1).Mx).booleanValue();
          l = ((Number)((o)localObject1).My).longValue();
          if (!bool) {
            break label1256;
          }
          paramMap.put(Long.valueOf(l), Long.valueOf(paramLong));
          paramMap1.put(Long.valueOf(l), j.mutableListOf(new Long[] { Long.valueOf(l) }));
          paramLong = l;
        }
      }
    }
    label1256:
    for (;;)
    {
      break label1133;
      AppMethodBeat.o(93558);
      return;
      i += 1;
      break;
      AppMethodBeat.o(93558);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.d.n
 * JD-Core Version:    0.7.0.1
 */