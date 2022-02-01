package c.t.m.g;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public final class bu
{
  final LinkedBlockingQueue<a> a;
  final bf b;
  long c;
  long d;
  long e;
  final bh.c f;
  long g;
  
  bu(bf parambf)
  {
    this.b = parambf;
    this.a = new LinkedBlockingQueue(3);
    this.f = bh.d;
  }
  
  static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((TencentExtraKeys.isDebugEnabled()) || (paramArrayOfByte == null) || (b.a.a(paramArrayOfByte) < 0)) {
      return b.a.a(paramInt, 0);
    }
    return b.a.a(paramInt, 1);
  }
  
  final void a(a parama)
  {
    if (a.c(parama) == 1)
    {
      parama = (by)a.d(parama);
      if (parama.c == null) {
        break label61;
      }
      i = 1;
      if (i != 0)
      {
        if (parama.b == null) {
          break label66;
        }
        i = 1;
        label38:
        if (i == 0) {
          if (parama.a == null) {
            break label71;
          }
        }
      }
    }
    label61:
    label66:
    label71:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        parama = this.f;
      }
      return;
      i = 0;
      break;
      i = 0;
      break label38;
    }
  }
  
  public final void a(String paramString, by paramby, int paramInt)
  {
    boolean bool = false;
    cj.a("TxRequestSender", "postLocationRequest: queue size=" + this.a.size());
    long l = SystemClock.elapsedRealtime();
    if (l - this.g < 2500L) {}
    for (int i = 1; i != 0; i = 0)
    {
      cj.a("TxRequestSender", "postLocationRequest: skip frequent request");
      return;
    }
    paramString = b.a.b(paramString.getBytes());
    paramString = new a(1, paramString, a(paramString, paramInt), paramby);
    if (a.a(paramString) != null) {
      bool = this.a.offer(paramString);
    }
    if (bool)
    {
      this.g = l;
      return;
    }
    cj.a("TxRequestSender", "postLocationRequest: failed to add request");
  }
  
  final void b(a parama)
  {
    a.e(parama);
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (a.c((a)localIterator.next()) != a.c(parama));
    for (int i = 1;; i = 0)
    {
      if ((a.f(parama) > 0) && (i == 0))
      {
        cj.a("TxRequestSender", "retryIfNeed: times=" + a.f(parama));
        this.a.offer(parama);
        return;
      }
      a(parama);
      return;
    }
  }
  
  static final class a
  {
    public static final a a = new a();
    private final int b;
    private final byte[] c;
    private final String d;
    private final Object e;
    private int f = 2;
    
    private a()
    {
      this.b = 0;
      this.c = null;
      this.d = null;
      this.e = null;
    }
    
    a(int paramInt, byte[] paramArrayOfByte, String paramString, Object paramObject)
    {
      this.b = paramInt;
      this.c = paramArrayOfByte;
      this.d = paramString;
      this.e = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bu
 * JD-Core Version:    0.7.0.1
 */