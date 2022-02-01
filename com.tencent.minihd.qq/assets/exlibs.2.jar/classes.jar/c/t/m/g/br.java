package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;

public final class br
  implements bm.b, bn.a, bp.a, bv.a
{
  private static SparseArray<String> a;
  private int b = 1;
  private a c;
  private final bm d;
  private final bp e;
  private final bv f;
  private final bo g;
  private final bs h;
  private final bu i;
  private final bn j;
  private bw k;
  private bz l;
  private bx m;
  private final bf n;
  private TencentLocationListener o;
  private final Object p = new Object();
  private final TencentLocationRequest q = TencentLocationRequest.create();
  private b r;
  private int s = 404;
  private final boolean t;
  private String u;
  private String v;
  private boolean w;
  private final bh.a x;
  private b y;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    a = localSparseArray;
    localSparseArray.put(0, "OK");
    a.put(1, "ERROR_NETWORK");
    a.put(2, "BAD_JSON");
    a.put(4, "DEFLECT_FAILED");
  }
  
  public br(bf parambf, String paramString)
  {
    this.u = paramString;
    this.n = parambf;
    cg.a(parambf.a);
    this.x = bh.a;
    this.h = new bs(this.n);
    this.i = new bu(this.n);
    this.j = new bn(this.i);
    this.g = bo.a(parambf.a);
    this.f = h();
    parambf = g();
    this.d = parambf;
    paramString = f();
    this.e = paramString;
    this.t = b.a.a(parambf, new Object[] { paramString });
  }
  
  private void a(int paramInt, b paramb)
  {
    if (paramb == null) {}
    label258:
    label389:
    for (;;)
    {
      return;
      int i1;
      if (this.s == 404)
      {
        i1 = 1;
        if (i1 == 0) {
          break label103;
        }
        this.s = paramInt;
        this.r = paramb;
        if ((!b.a.a(this.c)) && (this.q.getInterval() > 0L)) {
          this.c.sendEmptyMessageDelayed(11999, 0L);
        }
      }
      for (;;)
      {
        if ((this.q.getInterval() != 0L) || (!b.a.b(this.o))) {
          break label389;
        }
        b(11998);
        return;
        i1 = 0;
        break;
        label103:
        if ((this.s == 0) && (paramInt == 0) && (this.r != null))
        {
          long l1 = paramb.a() - this.r.a();
          double d1;
          int i2;
          if (l1 > 0L)
          {
            d1 = b.a.a(paramb.getLatitude(), paramb.getLongitude(), this.r.getLatitude(), this.r.getLongitude());
            double d2 = 1000.0D * d1 / l1;
            cj.a("TxLocationManagerImpl", "updateLastLocation: new location got.  distance=" + d1 + ", velocity=" + d2 + ",time_delta=" + l1);
            i2 = paramb.b();
            if ((!this.n.f()) || (i2 <= 0) || (i2 >= 3) || (d1 <= 1000.0D)) {
              break label335;
            }
            i1 = 1;
            if ((i2 <= 0) || (paramb.getAccuracy() <= 800.0F)) {
              break label341;
            }
            i2 = 1;
            if ((i1 == 0) && (i2 == 0)) {
              break label347;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label353;
            }
            cj.a("TxLocationManagerImpl", "updateLastLocation: discards bad fix: usedMac=" + paramb.b() + ", distance=" + d1);
            return;
            l1 = 1L;
            break;
            i1 = 0;
            break label258;
            i2 = 0;
            break label276;
          }
          if ((d1 < 5.0D) && (d1 > 1.0E-007D))
          {
            cj.a("TxLocationManagerImpl", "updateLastLocation: ignore near fix");
            return;
          }
        }
        label276:
        label335:
        label341:
        label347:
        label353:
        this.s = paramInt;
        this.r = paramb;
      }
    }
  }
  
  private final void a(b paramb)
  {
    if (paramb != null)
    {
      if (this.q.isAllowDirection()) {
        paramb.getExtra().putDouble("direction", this.g.c());
      }
      paramb.getExtra().putAll(this.q.getExtras());
    }
  }
  
  private void b(int paramInt)
  {
    if (this.c != null) {
      this.c.sendEmptyMessage(paramInt);
    }
  }
  
  private bp f()
  {
    try
    {
      bp localbp = new bp(this.n, this);
      return localbp;
    }
    catch (Exception localException)
    {
      cj.a("TxLocationManagerImpl", "createGpsProvider: failed", localException);
    }
    return null;
  }
  
  private bm g()
  {
    try
    {
      bm localbm = new bm(this.n, this);
      return localbm;
    }
    catch (Exception localException)
    {
      cj.a("TxLocationManagerImpl", "createCellProvider: failed", localException);
    }
    return null;
  }
  
  private bv h()
  {
    try
    {
      bv localbv = new bv(this.n, this);
      return localbv;
    }
    catch (Exception localException)
    {
      cj.a("TxLocationManagerImpl", "createWifiProvider: failed", localException);
    }
    return null;
  }
  
  private void i()
  {
    this.h.a();
    bu localbu = this.i;
    localbu.a.clear();
    localbu.a.offer(bu.a.a);
    localbu.g = 0L;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = localbu.d;
    long l3 = localbu.e;
    cj.a("TxRequestSender", "shutdown: duration=[" + l1 / 1000L / 60L + " min], traffic=[" + localbu.d + "," + localbu.e + "," + (l2 + l3) + "], requestCount=[" + localbu.c + "]");
    localbu.c = 0L;
    localbu.d = 0L;
    localbu.e = 0L;
    if (b.a.b(this.f)) {
      this.f.b();
    }
    if (b.a.b(this.d)) {
      this.d.b();
    }
    if (b.a.b(this.e)) {
      this.e.a();
    }
    this.g.b();
    if (b.a.b(this.c)) {
      this.c.a();
    }
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    int i1;
    if (this.u != null)
    {
      ??? = this.u;
      if (!((String)???).contains(",")) {
        break label160;
      }
      ??? = ((String)???).split(",");
      if ((??? == null) || (???.length <= 1) || (???[0] == null) || (???[1] == null) || (b.a.a(???[0], ???[1]) <= 0)) {
        break label140;
      }
      i1 = 1;
      if (i1 == 0) {
        break label146;
      }
      ??? = ???[0];
      label88:
      this.v = ((String)???);
      if (i1 == 0) {
        break label154;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (i1 >= 0) {
        break label179;
      }
      cj.b("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + this.u + "]");
      return 2;
      label140:
      i1 = 0;
      break;
      label146:
      ??? = "";
      break label88;
      label154:
      i1 = -1;
      continue;
      label160:
      i1 = b.a.b((String)???);
      this.v = Integer.toString(i1);
    }
    label179:
    if (this.t) {
      return 1;
    }
    this.s = 404;
    this.l = null;
    this.k = null;
    this.m = null;
    this.w = false;
    this.n.a("cell").a();
    for (;;)
    {
      synchronized (this.p)
      {
        this.o = paramTencentLocationListener;
        TencentLocationRequest.copy(this.q, paramTencentLocationRequest);
        if (b.a.a(this.c))
        {
          this.c = new a(paramLooper);
          i();
          boolean bool = this.q.getExtras().getBoolean("use_network", true);
          paramTencentLocationRequest = this.c;
          this.h.a(paramTencentLocationRequest);
          paramTencentLocationListener = this.i;
          paramTencentLocationListener.b.e().execute(new bu.1(paramTencentLocationListener, paramTencentLocationRequest));
          if ((bool) && (b.a.b(this.f)))
          {
            paramTencentLocationListener = this.f;
            this.q.getInterval();
            paramTencentLocationListener.a(paramTencentLocationRequest);
          }
          if ((bool) && (b.a.b(this.d))) {
            this.d.a();
          }
          if ((b.a.b(this.e)) && (TencentExtraKeys.isAllowGps(this.q))) {
            this.e.a(paramTencentLocationRequest, this.q.getInterval() - 2000L);
          }
          if (this.q.isAllowDirection())
          {
            paramTencentLocationListener = this.g;
            paramTencentLocationRequest.getLooper();
            paramTencentLocationListener.a();
          }
          return 0;
        }
      }
      this.c.removeCallbacksAndMessages(null);
      if (this.c.getLooper() != paramLooper) {
        this.c = new a(paramLooper);
      }
    }
  }
  
  public final String a()
  {
    return this.u;
  }
  
  public final void a(int paramInt)
  {
    if (!cj.a) {
      synchronized (this.p)
      {
        if (this.o != null) {
          throw new IllegalStateException("removeUpdates MUST called before set coordinate type!");
        }
      }
    }
    this.b = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    String str1 = null;
    String str2;
    switch (paramInt1)
    {
    default: 
      str2 = null;
    }
    synchronized (this.p)
    {
      for (;;)
      {
        if (this.o != null) {
          this.o.onStatusUpdate(str2, paramInt2, str1);
        }
        return;
        str2 = "gps";
        if (paramInt2 == 1)
        {
          str1 = "gps enabled";
        }
        else if (paramInt2 == 0)
        {
          str1 = "gps disabled";
        }
        else
        {
          str1 = "unknown";
          continue;
          str2 = "cell";
          if (paramInt2 == 1)
          {
            str1 = "radio enabled";
          }
          else if (paramInt2 == 0)
          {
            str1 = "radio disabled";
          }
          else
          {
            str1 = "unknown";
            continue;
            str2 = "wifi";
            if (paramInt2 == 1)
            {
              str1 = "wifi enabled";
            }
            else
            {
              if (paramInt2 != 0) {
                break;
              }
              str1 = "wifi disabled";
            }
          }
        }
      }
      str1 = "unknown";
    }
  }
  
  public final void a(Location paramLocation, double[] paramArrayOfDouble, int paramInt)
  {
    b.b localb1 = new b.b();
    b localb;
    if (this.y != null)
    {
      localb = this.y;
      localb1.b = localb;
      localb1.d = paramLocation.getProvider();
      localb1.c = this.q.getRequestLevel();
      localb1.e = paramLocation;
      localb = localb1.a();
      TencentExtraKeys.setRawGps(localb, new Location(paramLocation));
      if (paramInt == 0)
      {
        paramLocation.setLatitude(paramArrayOfDouble[0]);
        paramLocation.setLongitude(paramArrayOfDouble[1]);
        localb.a(paramLocation);
      }
      if (paramInt != 0) {
        break label123;
      }
    }
    label123:
    for (paramInt = 0;; paramInt = 4)
    {
      a(paramInt, localb);
      return;
      localb = this.r;
      break;
    }
  }
  
  public final void a(bw parambw, boolean paramBoolean)
  {
    int i2;
    int i1;
    if (this.k != null)
    {
      i2 = this.k.e;
      i1 = this.k.f;
    }
    for (;;)
    {
      if (i2 == parambw.e) {}
      for (boolean bool = true;; bool = false)
      {
        this.w = bool;
        this.k = parambw;
        cj.a("TxLocationManagerImpl", String.format("onCellChanged: %d(%d)-->%d(%d)", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(parambw.e), Integer.valueOf(parambw.f) }));
        if ((!paramBoolean) && (this.f != null)) {
          break;
        }
        cj.a("TxLocationManagerImpl", "onCellChanged: start location [cell change]");
        b(3999);
        return;
      }
      i1 = this.f.a();
      if (i1 == 1)
      {
        cj.a("TxLocationManagerImpl", "onCellChanged: wifi disbaled, failed to scan");
        b(3999);
        return;
      }
      cj.a("TxLocationManagerImpl", "onCellChanged: scan again. status=" + i1);
      return;
      i1 = 0;
      i2 = 0;
    }
  }
  
  public final void a(bx parambx)
  {
    this.m = parambx;
    parambx = new bx(parambx).a;
    double d1;
    double d2;
    if (cj.a)
    {
      d1 = parambx.getLatitude();
      d2 = parambx.getLongitude();
      float f1 = parambx.getAccuracy();
      localObject1 = new StringBuilder("handleLocationWgs84Update: gps=");
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append("lat=").append(d1).append(", ");
      ((StringBuilder)localObject1).append("lng=").append(d2).append(", ");
      ((StringBuilder)localObject1).append("accu=").append(f1);
      ((StringBuilder)localObject1).append("]");
      cj.a("TxLocationManagerImpl", ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.r;
    int i1 = this.b;
    int i2 = this.q.getRequestLevel();
    if (b.a.a(i1)) {
      if ((localObject1 != null) || (i2 == 0))
      {
        localObject4 = this.j;
        if ((parambx != null) && (this != null)) {
          break label196;
        }
        cj.b("TxDeflector", "deflect: location or listener is null");
      }
    }
    label196:
    label254:
    while (!b.a.b(i1))
    {
      Object localObject3;
      do
      {
        return;
        localObject1 = new double[2];
        if ((Math.abs(((bn)localObject4).b) > 1.0E-007D) && (Math.abs(((bn)localObject4).c) > 1.0E-007D))
        {
          i1 = 1;
          if (i1 == 0) {
            break label368;
          }
          if ((((bn)localObject4).d != null) && (parambx != null)) {
            break label326;
          }
          i1 = 0;
          if (i1 == 0) {
            break label368;
          }
          d1 = parambx.getLatitude();
          d2 = ((bn)localObject4).b;
          double d3 = parambx.getLongitude();
          double d4 = ((bn)localObject4).c;
          localObject1[0] = (d1 + d2);
          localObject1[1] = (d3 + d4);
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label380;
          }
          a(parambx, (double[])localObject1, 0);
          return;
          i1 = 0;
          break;
          if (b.a.a(parambx.getLatitude(), parambx.getLongitude(), ((bn)localObject4).d.getLatitude(), parambx.getLongitude()) < 1500.0D)
          {
            i1 = 1;
            break label254;
          }
          i1 = 0;
          break label254;
          ((bn)localObject4).d = parambx;
        }
        ((bn)localObject4).e = this;
        localObject1 = ((bn)localObject4).a;
        d1 = parambx.getLatitude();
        d2 = parambx.getLongitude();
        localObject2 = "{\"version\":\"3.1.10\",\"source\":203,\"access_token\":\"160e7bd42dec9428721034e0146fc6dd\",\"location\":{\"latitude\":" + d1 + ",\"longitude\":" + d2 + "}}";
        localObject3 = b.a.b(((String)localObject2).getBytes());
        Object localObject4 = Pair.create(parambx, localObject4);
        parambx = bu.a((byte[])localObject3, 1);
        localObject3 = new bu.a(2, (byte[])localObject3, parambx, localObject4);
        cj.a("TxRequestSender", "postDeflectRequest: json=" + (String)localObject2 + ",url=" + parambx);
      } while (bu.a.a((bu.a)localObject3) == null);
      ((bu)localObject1).a.offer(localObject3);
      return;
    }
    label326:
    label368:
    label380:
    Object localObject2 = new b.b();
    ((b.b)localObject2).b = ((b)localObject1);
    ((b.b)localObject2).d = "gps";
    ((b.b)localObject2).c = i2;
    ((b.b)localObject2).e = parambx;
    localObject1 = ((b.b)localObject2).a();
    ((b)localObject1).a(parambx);
    a(0, (b)localObject1);
  }
  
  public final void a(bz parambz, boolean paramBoolean)
  {
    this.l = parambz;
    int i1;
    long l1;
    if (b.a.b(this.f))
    {
      if ((!b.a.a(this.m)) && (this.m.b - System.currentTimeMillis() <= 5000L)) {
        break label84;
      }
      i1 = 1;
      l1 = this.q.getInterval();
      parambz = this.n.d();
      if (i1 == 0) {
        break label89;
      }
      parambz.a(l1);
    }
    for (;;)
    {
      if (paramBoolean) {
        b(3999);
      }
      return;
      label84:
      i1 = 0;
      break;
      label89:
      parambz.a(l1 + 10000L);
    }
  }
  
  public final void a(String paramString)
  {
    this.u = paramString;
  }
  
  public final TencentLocation b()
  {
    if (this.s == 0)
    {
      a(this.r);
      return this.r;
    }
    return null;
  }
  
  public final void c()
  {
    i();
    synchronized (this.p)
    {
      this.o = null;
      this.y = null;
      ??? = this.x;
      return;
    }
  }
  
  public final int d()
  {
    return this.b;
  }
  
  final class a
    extends Handler
  {
    private final bq a = new bq();
    private final bh.b b;
    private int c;
    
    a(Looper paramLooper)
    {
      super();
      this.a.b = br.a(br.this).isAllowCache();
      this.b = bh.b;
    }
    
    public final void a()
    {
      removeCallbacksAndMessages(null);
      this.a.a.clear();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      Object localObject1;
      int j;
      long l;
      Object localObject3;
      synchronized (br.c(br.this))
      {
        if (br.d(br.this) == null) {
          return;
        }
        localObject1 = br.d(br.this);
        ??? = br.a(br.this);
        j = ((TencentLocationRequest)???).getRequestLevel();
        l = ((TencentLocationRequest)???).getInterval();
        localObject3 = ((TencentLocationRequest)???).getQQ();
        br.b(br.this).d().g = ((String)localObject3);
        switch (paramMessage.what)
        {
        default: 
          return;
        case 3998: 
          paramMessage = new by(null, null, new bx((Location)paramMessage.obj, System.currentTimeMillis(), 3, 3, 0));
          localObject1 = paramMessage.a(j, br.i(br.this), br.b(br.this));
          br.l(br.this).a((String)localObject1, paramMessage, br.g(br.this));
          return;
        }
      }
      if (br.e(br.this) != null)
      {
        br.a(br.this, br.e(br.this));
        ((TencentLocationListener)localObject1).onLocationChanged(br.e(br.this), br.f(br.this), (String)br.e().get(br.f(br.this)));
      }
      if (l > 0L)
      {
        sendEmptyMessageDelayed(11999, l);
        return;
        if (br.e(br.this) != null)
        {
          br.a(br.this, br.e(br.this));
          ((TencentLocationListener)localObject1).onLocationChanged(br.e(br.this), br.f(br.this), (String)br.e().get(br.f(br.this)));
          return;
          int k = br.g(br.this);
          localObject3 = br.h(br.this);
          paramMessage = ((by)localObject3).a(j, br.i(br.this), br.b(br.this));
          if (!b.a.c(paramMessage)) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              cj.b("TxLocationManagerImpl", "handleMessage: bad json " + paramMessage);
            }
            if (i == 0) {
              break;
            }
            this.c += 1;
            if (this.c < 2) {
              return;
            }
            cj.b("TxLocationManagerImpl", "handleMessage: bad json " + paramMessage);
            br.a(br.this, 2, b.a);
            return;
          }
          this.c = 0;
          if (br.j(br.this) != null)
          {
            l = br.j(br.this).b;
            System.currentTimeMillis();
          }
          br.k(br.this);
          if (!b.a.a(paramMessage))
          {
            if (TencentExtraKeys.isRequestRawData((TencentLocationRequest)???))
            {
              ??? = new b.b();
              ((b.b)???).b = null;
              ((b.b)???).c = j;
              ??? = ((b.b)???).a();
              TencentExtraKeys.setRawData((TencentLocation)???, paramMessage.getBytes());
              br.a(br.this, (b)???);
              ((TencentLocationListener)localObject1).onLocationChanged((TencentLocation)???, 0, (String)br.e().get(0));
              return;
            }
            if (!b.a.b(br.b(br.this).a))
            {
              br.a(br.this, 1, b.a);
              return;
            }
            localObject1 = this.a.a((by)localObject3);
            if (localObject1 == null)
            {
              br.l(br.this).a(paramMessage, (by)localObject3, k);
              br.k(br.this);
              System.currentTimeMillis();
              return;
            }
            br.a(br.this, 0, (b)localObject1);
            return;
            removeMessages(4998);
            paramMessage = (Pair)paramMessage.obj;
            ??? = paramMessage.first.toString();
            localObject1 = (by)paramMessage.second;
            if (b.a.b(((by)localObject1).c)) {}
            for (paramMessage = "gps";; paramMessage = "network") {
              try
              {
                localObject3 = new b.b();
                ((b.b)localObject3).a = ((String)???);
                ((b.b)localObject3).c = j;
                ((b.b)localObject3).d = paramMessage;
                ??? = ((b.b)localObject3).a();
                b.a((b)???);
                b.a((b)???, br.m(br.this));
                TencentExtraKeys.setRawQuery((TencentLocation)???, ((by)localObject1).a(j, br.i(br.this), br.b(br.this)));
                br.b(br.this).a("map").a(((b)???).getExtra());
                if (!"gps".equals(paramMessage)) {
                  break;
                }
                br.b(br.this, (b)???);
                return;
              }
              catch (JSONException paramMessage)
              {
                cj.a("TxLocationManagerImpl", "handleMessage: location failed", paramMessage);
                paramMessage = this.b;
                br.a(br.this, 404, b.a);
                return;
              }
            }
            paramMessage = this.a;
            if ((paramMessage.b) && (((b)???).getAccuracy() < 500.0F))
            {
              if (paramMessage.a.size() > 1) {
                paramMessage.a.removeLast();
              }
              paramMessage.a.addFirst(new bq.a((by)localObject1, (b)???));
            }
            br.a(br.this, 0, (b)???);
            return;
            br.a(br.this, 1, b.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.br
 * JD-Core Version:    0.7.0.1
 */