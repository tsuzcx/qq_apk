package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.List;

public final class bm
  extends PhoneStateListener
{
  volatile boolean a;
  private final b b;
  private final bf c;
  private CellLocation d = null;
  private SignalStrength e = null;
  private ServiceState f = null;
  private bw g = null;
  private long h;
  private HandlerThread i;
  private Handler j;
  private a k = null;
  private final Object l = new Object();
  
  public bm(bf parambf, b paramb)
    throws Exception
  {
    if (b.a.a(parambf, paramb)) {
      throw new NullPointerException();
    }
    this.c = parambf;
    this.b = paramb;
    if (b.a.a(parambf.a()))
    {
      cj.b("TencentCellProvider", "could not get telephony manager.");
      throw new NullPointerException("telephony manager is null");
    }
  }
  
  private void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.c.a();
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException)
    {
      cj.a("TencentCellProvider", "listenCellState: failed! flags=" + paramInt, localException);
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.l)
    {
      if (this.j != null) {
        this.j.sendEmptyMessageDelayed(5998, paramLong);
      }
      return;
    }
  }
  
  private void c()
  {
    try
    {
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    if ((!this.a) || (this.d == null)) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while (l1 - this.h <= 2000L);
    this.h = l1;
    if (this.k == null) {
      this.k = new a((byte)0);
    }
    synchronized (this.l)
    {
      if (this.j != null) {
        this.j.post(this.k);
      }
      return;
    }
  }
  
  private void e()
  {
    int m = 1;
    if (!this.a) {
      return;
    }
    if (this.f != null) {
      if (this.f.getState() != 0) {}
    }
    for (;;)
    {
      this.b.a(12003, m);
      return;
      if (this.f.getState() == 1) {
        m = 0;
      } else {
        m = -1;
      }
    }
  }
  
  public final void a()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.i = new HandlerThread("worker");
    this.i.start();
    this.j = new Handler(this.i.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        if (!bm.this.a) {}
        while (paramAnonymousMessage.what != 5998) {
          return;
        }
        cj.a("TencentCellProvider", "initHandler: read cid positively");
        bm.a(bm.this, b.a.a(bm.a(bm.this).a()));
        bm.b(bm.this);
      }
    };
    a(273);
    cj.a("TencentCellProvider", "startup: state=[start]");
    a(3000L);
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    a(0);
    synchronized (this.l)
    {
      if (this.j != null)
      {
        this.j.removeCallbacksAndMessages(null);
        this.j = null;
      }
      this.i.quit();
      this.i = null;
      cj.a("TencentCellProvider", "shutdown: state=[shutdown]");
      c();
      return;
    }
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    if (paramCellLocation == null) {
      return;
    }
    for (;;)
    {
      bw localbw;
      try
      {
        localbw = bw.a(this.c, paramCellLocation, null);
        if (localbw == null)
        {
          bool = true;
          if (bool) {
            this.d = paramCellLocation;
          }
          d();
          return;
        }
      }
      finally {}
      boolean bool = b.a.a(localbw);
    }
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.f == null)
        {
          this.f = paramServiceState;
          e();
          return;
        }
      }
      finally {}
      if (this.f.getState() != paramServiceState.getState())
      {
        this.f = paramServiceState;
        e();
      }
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {
      return;
    }
    int m = this.c.d().b;
    try
    {
      if (b.a.a(m, this.e, paramSignalStrength))
      {
        this.e = paramSignalStrength;
        d();
      }
      return;
    }
    finally {}
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      Object localObject1 = bm.a(bm.this).a();
      if (b.a.a(localObject1)) {
        return;
      }
      for (;;)
      {
        synchronized (bm.this)
        {
          localObject1 = b.a.b((TelephonyManager)localObject1);
          Object localObject3 = bm.a(bm.this);
          CellLocation localCellLocation = bm.c(bm.this);
          SignalStrength localSignalStrength = bm.d(bm.this);
          bm.e(bm.this);
          localObject3 = bw.a((bf)localObject3, localCellLocation, localSignalStrength);
          if (b.a.b(localObject3))
          {
            ((bw)localObject3).a((List)localObject1);
            localObject1 = bm.g(bm.this);
            if ((bm.f(bm.this) != null) && (((bw)localObject3).e != bm.f(bm.this).e))
            {
              bool = true;
              ((bm.b)localObject1).a((bw)localObject3, bool);
              bm.a(bm.this, (bw)localObject3);
            }
          }
          else
          {
            return;
          }
        }
        boolean bool = false;
      }
    }
  }
  
  public static abstract interface b
    extends bm.c
  {
    public abstract void a(bw parambw, boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bm
 * JD-Core Version:    0.7.0.1
 */