package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class dx
  extends BroadcastReceiver
{
  static boolean d;
  private static final Comparator<ScanResult> q = new dx.3();
  volatile boolean a;
  final dg b;
  HashSet<String> c;
  volatile Handler e;
  volatile dx.a f;
  volatile List<ScanResult> g;
  Runnable h;
  String i;
  public long j = 30000L;
  final byte[] k = new byte[0];
  private final WifiManager l;
  private long m;
  private volatile List<ScanResult> n;
  private Runnable o;
  private boolean p;
  
  public dx(dg paramdg)
  {
    this.b = paramdg;
    this.l = paramdg.f;
    this.c = new HashSet();
    this.p = true;
    this.o = new dx.1(this);
    this.h = new Runnable()
    {
      public final void run()
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        try
        {
          if (dx.c(dx.this) != null)
          {
            dx.d(dx.this).a.registerReceiver(dx.this, localIntentFilter, null, dx.c(dx.this));
            return;
          }
          dx.d(dx.this).a.registerReceiver(dx.this, localIntentFilter);
          return;
        }
        catch (Exception localException)
        {
          j.a("TxWifiProvider", "listenWifiState: failed", localException);
        }
      }
    };
  }
  
  private void a(int paramInt)
  {
    if (this.f != null) {
      this.f.obtainMessage(paramInt).sendToTarget();
    }
  }
  
  private void a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      c();
    }
    for (;;)
    {
      long l1 = this.m;
      es.a(this.l);
      paramList = new ee(paramList, l1);
      this.b.b(paramList);
      return;
      if (es.a)
      {
        es.a = false;
        c();
      }
    }
  }
  
  private void c()
  {
    i1 = 1;
    for (;;)
    {
      try
      {
        i2 = es.a(this.l);
        if (i2 == 3)
        {
          a(0L);
          i2 = i1;
        }
      }
      catch (Throwable localThrowable1)
      {
        Message localMessage;
        j.a("TxWifiProvider", "notifyStatus error!", localThrowable1);
        return;
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          int i3 = Settings.Secure.getInt(this.b.a.getContentResolver(), "location_mode");
          i2 = i1;
          if (i3 == 0) {
            i2 = 5;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        i2 = i1;
        continue;
      }
      localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12001;
      localMessage.arg2 = i2;
      this.b.b(localMessage);
      return;
      if (i2 == 1)
      {
        i2 = 0;
        i1 = i2;
        if (!es.b(this.b))
        {
          if (this.g != null) {
            this.g.clear();
          }
          i1 = i2;
          if (this.e != null)
          {
            this.e.sendEmptyMessage(555);
            i1 = i2;
          }
        }
      }
      else
      {
        i1 = -1;
      }
    }
  }
  
  public final void a(long paramLong)
  {
    Handler localHandler = this.e;
    Runnable localRunnable = this.o;
    if (localHandler == null) {}
    for (Looper localLooper = null;; localLooper = localHandler.getLooper())
    {
      if ((localLooper != null) && (localLooper.getThread().isAlive()))
      {
        localHandler.removeCallbacks(localRunnable);
        localHandler.postDelayed(localRunnable, paramLong);
      }
      return;
    }
  }
  
  final boolean a()
  {
    if ((!es.b(this.b)) || (d)) {
      return false;
    }
    return es.b(this.l);
  }
  
  /* Error */
  public final void onReceive(Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 378	android/content/Intent:getAction	()Ljava/lang/String;
    //   9: astore_1
    //   10: ldc_w 277
    //   13: iconst_4
    //   14: new 308	java/lang/StringBuilder
    //   17: dup
    //   18: ldc_w 380
    //   21: invokespecial 383	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 334	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: ldc_w 385
    //   37: aload_1
    //   38: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifeq +10 -> 53
    //   46: aload_0
    //   47: sipush 1201
    //   50: invokespecial 390	c/t/m/g/dx:a	(I)V
    //   53: iload_3
    //   54: ifne +15 -> 69
    //   57: ldc_w 392
    //   60: aload_1
    //   61: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq -62 -> 4
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 66	c/t/m/g/dx:l	Landroid/net/wifi/WifiManager;
    //   74: invokestatic 395	c/t/m/g/es:c	(Landroid/net/wifi/WifiManager;)Ljava/util/List;
    //   77: putfield 289	c/t/m/g/dx:n	Ljava/util/List;
    //   80: aload_0
    //   81: sipush 1202
    //   84: invokespecial 390	c/t/m/g/dx:a	(I)V
    //   87: return
    //   88: astore_1
    //   89: ldc_w 277
    //   92: ldc_w 397
    //   95: aload_1
    //   96: invokestatic 284	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: return
    //   100: astore_1
    //   101: ldc_w 277
    //   104: ldc_w 399
    //   107: aload_1
    //   108: invokestatic 284	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 289	c/t/m/g/dx:n	Ljava/util/List;
    //   116: goto -36 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	dx
    //   0	119	1	paramContext	Context
    //   0	119	2	paramIntent	android.content.Intent
    //   41	25	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	42	88	java/lang/Throwable
    //   46	53	88	java/lang/Throwable
    //   57	65	88	java/lang/Throwable
    //   80	87	88	java/lang/Throwable
    //   101	116	88	java/lang/Throwable
    //   69	80	100	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.dx
 * JD-Core Version:    0.7.0.1
 */