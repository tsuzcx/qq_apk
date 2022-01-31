package c.t.m.g;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public final class dv
{
  final LinkedBlockingQueue<dv.a> a;
  final dg b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  boolean h;
  volatile Handler i;
  
  dv(dg paramdg)
  {
    this.b = paramdg;
    this.a = new LinkedBlockingQueue(3);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TencentLogImpl.isDebugEnabled()) && (paramArrayOfByte != null)) {}
    try
    {
      if (e.o(paramArrayOfByte, 1) < 0) {
        return do.a(paramInt, 0);
      }
      paramArrayOfByte = do.a(paramInt, 1);
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte) {}
    return null;
  }
  
  public final void a(String paramString, ec paramec, int paramInt)
  {
    try
    {
      j.a("TxRequestSender", 6, paramString);
      byte[] arrayOfByte = j.c(paramString.getBytes("GBK"));
      paramec = new dv.a(1, arrayOfByte, a(arrayOfByte, paramInt), paramec);
      paramec.b = paramString;
      a(paramec);
      return;
    }
    catch (Throwable paramString)
    {
      j.a("TxRequestSender", "", paramString);
    }
  }
  
  final boolean a(dv.a parama)
  {
    SystemClock.elapsedRealtime();
    if (dv.a.a(parama) != null) {}
    for (boolean bool = this.a.offer(parama);; bool = false)
    {
      String str;
      if (!bool)
      {
        this.a.clear();
        this.a.offer(parama);
        str = "Location";
        if (dv.a.b(parama) != 2) {
          break label84;
        }
        str = "List";
      }
      for (;;)
      {
        j.a("TxRequestSender", 6, "post" + str + "Request: failed to add request,because the queue has full,so we delete the first");
        return bool;
        label84:
        if (dv.a.b(parama) == 3) {
          str = "Wifis";
        } else if (dv.a.b(parama) == 4) {
          str = "EventTrack";
        }
      }
    }
  }
  
  final void b(dv.a parama)
  {
    dv.a.d(parama);
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (dv.a.b((dv.a)localIterator.next()) != dv.a.b(parama));
    for (int j = 1;; j = 0)
    {
      if ((dv.a.e(parama) > 0) && (j == 0))
      {
        j.a("TxRequestSender", 4, "retryIfNeed: times=" + dv.a.e(parama));
        this.a.offer(parama);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.dv
 * JD-Core Version:    0.7.0.1
 */