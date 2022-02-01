package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/util/CameraReportHelper;", "", "()V", "TAG", "", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "checkAndReportCamera2Info", "", "CameraInfo", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static FutureTask<Integer> evy;
  public static final d nNb;
  
  static
  {
    AppMethodBeat.i(237514);
    nNb = new d();
    AppMethodBeat.o(237514);
  }
  
  private static final Integer bvA()
  {
    AppMethodBeat.i(237504);
    HashSet localHashSet = new HashSet();
    int n = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    int m = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    Object localObject4 = com.tencent.mm.compatible.c.a.lQF;
    String str1 = com.tencent.mm.compatible.c.a.aOm();
    if (str1 != null)
    {
      Iterator localIterator = ((Iterable)n.b((CharSequence)str1, new String[] { "+" })).iterator();
      k = n;
      if (localIterator.hasNext())
      {
        Object localObject5 = n.b((CharSequence)localIterator.next(), new String[] { "-" });
        label129:
        label133:
        String str2;
        String str3;
        if (((List)localObject5).size() >= 3)
        {
          m = 1;
          if (m == 0) {
            break label362;
          }
          if (localObject5 == null) {
            break label668;
          }
          str2 = (String)((List)localObject5).get(0);
          localObject4 = (String)((List)localObject5).get(1);
          str3 = (String)((List)localObject5).get(2);
          localObject5 = n.bJF((String)localObject4);
          if (localObject5 != null) {}
          switch (((Number)localObject5).intValue())
          {
          default: 
            label232:
            localObject5 = n.bJF(str3);
            if (localObject5 != null) {
              switch (((Number)localObject5).intValue())
              {
              }
            }
            break;
          }
        }
        for (;;)
        {
          if ((s.p(localObject3, localObject4)) || (localObject3 == null)) {
            break label665;
          }
          localObject3 = a.nMV;
          a.bvp();
          k = 1;
          localObject3 = n.bJF(str2);
          if (localObject3 != null) {
            localHashSet.add(new d.a(((Number)localObject3).intValue(), str3, (String)localObject4));
          }
          m = i;
          i = j;
          j = m;
          label344:
          m = j;
          localObject3 = localObject4;
          j = i;
          i = m;
          break;
          m = 0;
          break label129;
          label362:
          localObject5 = null;
          break label133;
          localObject5 = a.nMV;
          a.bvg();
          break label232;
          localObject5 = a.nMV;
          a.bvh();
          break label232;
          localObject5 = a.nMV;
          a.bvi();
          break label232;
          localObject5 = a.nMV;
          a.bvj();
          break label232;
          localObject5 = a.nMV;
          a.bvk();
          break label232;
          localObject5 = localObject1;
          if (localObject1 == null) {
            localObject5 = localObject4;
          }
          j += 1;
          localObject1 = localObject5;
          continue;
          localObject5 = localObject2;
          if (localObject2 == null) {
            localObject5 = localObject4;
          }
          i += 1;
          localObject2 = localObject5;
        }
      }
      else
      {
        m = k;
        k = i;
        localObject3 = localObject2;
        localObject2 = localObject1;
        i = m;
        localObject1 = str1;
      }
    }
    for (;;)
    {
      localObject4 = com.tencent.mm.compatible.c.a.lQF;
      localObject4 = Integer.valueOf(com.tencent.mm.compatible.c.a.aOl());
      if (((Number)localObject4).intValue() != -1)
      {
        m = 1;
        if (m == 0) {
          break label621;
        }
        label520:
        if (localObject4 == null) {
          break label660;
        }
        m = ((Number)localObject4).intValue();
        switch (m)
        {
        default: 
          localObject4 = a.nMV;
          a.bvo();
        }
      }
      for (;;)
      {
        if ((m != -1) && (localObject1 != null) && (localObject2 != null) && (localObject3 != null))
        {
          localObject4 = a.nMV;
          a.a(m, localObject1, i, localObject2, (String)localObject3, j, k);
        }
        AppMethodBeat.o(237504);
        return Integer.valueOf(1);
        m = 0;
        break;
        label621:
        localObject4 = null;
        break label520;
        localObject4 = a.nMV;
        a.bvl();
        continue;
        localObject4 = a.nMV;
        a.bvm();
        continue;
        localObject4 = a.nMV;
        a.bvn();
        continue;
        label660:
        m = -1;
      }
      label665:
      break;
      label668:
      m = j;
      j = i;
      localObject4 = localObject3;
      i = m;
      break label344;
      localObject3 = null;
      localObject2 = null;
      i = 0;
      localObject1 = null;
      j = m;
    }
  }
  
  private static final void bvB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(237511);
    i locali = h.ahAA;
    FutureTask localFutureTask2 = evy;
    FutureTask localFutureTask1 = localFutureTask2;
    if (localFutureTask2 == null)
    {
      s.bIx("futureTask");
      localFutureTask1 = null;
    }
    locali.bm((Runnable)localFutureTask1);
    try
    {
      localFutureTask2 = evy;
      localFutureTask1 = localFutureTask2;
      if (localFutureTask2 == null)
      {
        s.bIx("futureTask");
        localFutureTask1 = null;
      }
      localFutureTask1.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(237511);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      Log.e("MicroMsg.CameraReportHelper", "futureTask TimeoutException cancel");
      localFutureTask2 = evy;
      Object localObject1 = localFutureTask2;
      if (localFutureTask2 == null)
      {
        s.bIx("futureTask");
        localObject1 = null;
      }
      if (!((FutureTask)localObject1).isCancelled())
      {
        localFutureTask2 = evy;
        localObject1 = localFutureTask2;
        if (localFutureTask2 == null)
        {
          s.bIx("futureTask");
          localObject1 = null;
        }
        if (!((FutureTask)localObject1).isDone())
        {
          localObject1 = evy;
          if (localObject1 == null)
          {
            s.bIx("futureTask");
            localObject1 = localObject2;
          }
          for (;;)
          {
            ((FutureTask)localObject1).cancel(true);
            AppMethodBeat.o(237511);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CameraReportHelper", "futureTask Exception");
      AppMethodBeat.o(237511);
    }
  }
  
  public static void bvz()
  {
    AppMethodBeat.i(237496);
    evy = new FutureTask(d..ExternalSyntheticLambda1.INSTANCE);
    h.ahAA.bm(d..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(237496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.d
 * JD-Core Version:    0.7.0.1
 */