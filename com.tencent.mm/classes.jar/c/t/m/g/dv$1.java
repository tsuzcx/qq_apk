package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

final class dv$1
  implements Runnable
{
  dv$1(dv paramdv) {}
  
  public final void run()
  {
    this.a.a.clear();
    dv localdv = this.a;
    LinkedBlockingQueue localLinkedBlockingQueue = localdv.a;
    Object localObject1 = null;
    for (;;)
    {
      long l2;
      Object localObject5;
      if (localdv.g)
      {
        l2 = 0L;
        try
        {
          localObject5 = (dv.a)localLinkedBlockingQueue.take();
          l1 = l2;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            Object localObject6;
            Object localObject7;
            long l3;
            long l4;
            int i;
            Object localObject2;
            Object localObject3;
            localObject5 = localObject4;
            localObject4 = localThrowable2;
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            localObject5 = localObject4;
            localObject4 = localIOException2;
            long l1 = l2;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          for (;;)
          {
            label229:
            localObject5 = localObject4;
            label388:
            label709:
            localObject4 = localInterruptedException2;
          }
        }
        try
        {
          if (dv.a.d == localObject5)
          {
            l1 = l2;
            j.a("TxRequestSender", 4, "run: state=[shutdown]");
            return;
          }
          l1 = l2;
          l2 = System.currentTimeMillis();
          l1 = l2;
          localObject1 = localdv.b;
          l1 = l2;
          localObject6 = dv.a.c((dv.a)localObject5);
          l1 = l2;
          localObject7 = dv.a.a((dv.a)localObject5);
          l1 = l2;
          l3 = System.currentTimeMillis();
          l1 = l2;
          localObject6 = ((dg)localObject1).h.postSync((String)localObject6, (byte[])localObject7);
          l1 = l2;
          l4 = System.currentTimeMillis();
          l1 = l2;
          j.b("HalleyTimeCost:" + (l4 - l3) + ",reqKey:" + ((Bundle)localObject6).getString("req_key"));
          l1 = l2;
          localObject7 = j.d(((Bundle)localObject6).getByteArray("data_bytes"));
          localObject1 = "{}";
          if (localObject7 != null)
          {
            l1 = l2;
            localObject1 = new String((byte[])localObject7, ((Bundle)localObject6).getString("data_charset"));
            l1 = l2;
            ((Bundle)localObject6).remove("data_charset");
            l1 = l2;
            ((Bundle)localObject6).remove("data_bytes");
            l1 = l2;
            ((Bundle)localObject6).putString("result", (String)localObject1);
            l1 = l2;
            localObject1 = ((Bundle)localObject6).getString("result");
            l1 = l2;
            l3 = System.currentTimeMillis() - l2;
            l1 = l2;
            j.b("cost:" + l3 + ",result:" + (String)localObject1);
            l1 = l2;
            localdv.c += 1L;
            l1 = l2;
            localdv.d += dv.a.a((dv.a)localObject5).length;
            l1 = l2;
            localObject7 = j.c(((String)localObject1).getBytes());
            l1 = l2;
            l4 = localdv.e;
            if (localObject7 != null)
            {
              l1 = l2;
              i = localObject7.length;
              l1 = l2;
              localdv.e = (l4 + i);
              l1 = l2;
              localObject7 = localdv.i;
              l1 = l2;
              ((dv.a)localObject5).c = l2;
              l1 = l2;
              if (!localdv.h)
              {
                l1 = l2;
                if ((localdv.g) && (localObject7 != null))
                {
                  l1 = l2;
                  if (((Handler)localObject7).getLooper().getThread().isAlive())
                  {
                    l1 = l2;
                    localObject7 = ((Handler)localObject7).obtainMessage();
                    l1 = l2;
                    ((Message)localObject7).arg1 = ((int)l3);
                    l1 = l2;
                    if (1 == dv.a.b((dv.a)localObject5))
                    {
                      l1 = l2;
                      ((Message)localObject7).obj = Pair.create(localObject1, localObject5);
                      l1 = l2;
                      ((Message)localObject7).what = 4999;
                      l1 = l2;
                      ((Message)localObject7).sendToTarget();
                    }
                  }
                }
              }
              l1 = l2;
              if (dv.a.b((dv.a)localObject5) != 1) {
                break label813;
              }
              l1 = l2;
              if (localdv.b.b.n != 0L) {
                break label813;
              }
              l1 = l2;
              localdv.b.b.n = l3;
              l1 = l2;
              localdv.b.b.o = ((Bundle)localObject6).getString("req_key");
              break label813;
            }
          }
          else
          {
            l1 = l2;
            j.a("AppContext", 4, "postSync: inflate failed");
            break label229;
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          j.a("TxRequestSender", "run: thread is interrupted", localInterruptedException1);
          localObject2 = localObject5;
          continue;
          i = 0;
          break label388;
        }
        catch (IOException localIOException1)
        {
          l2 = System.currentTimeMillis();
          j.a("TxRequestSender", "cost:" + (l2 - l1) + ",run: io error", localIOException1);
          localdv.b((dv.a)localObject5);
          j.a("TxRequestSender", 6, "Send timeout");
          localObject6 = localdv.i;
          if (localObject6 == null)
          {
            localObject3 = null;
            if ((localObject3 != null) && (((Looper)localObject3).getThread().isAlive())) {
              ((Handler)localObject6).sendEmptyMessageDelayed(4998, 0L);
            }
            localObject3 = localObject5;
            continue;
          }
          localObject3 = ((Handler)localObject6).getLooper();
          break label709;
        }
        catch (Throwable localThrowable1)
        {
          j.a("TxRequestSender", "run: other exception.", localThrowable1);
          localObject4 = localObject5;
        }
        continue;
      }
      return;
      label813:
      Object localObject4 = localObject5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.dv.1
 * JD-Core Version:    0.7.0.1
 */