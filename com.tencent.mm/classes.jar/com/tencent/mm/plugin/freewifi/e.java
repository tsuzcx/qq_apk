package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
{
  private Activity activity;
  private WifiManager bci;
  Condition btV;
  Lock kmn;
  private BroadcastReceiver kmq;
  private int kmz;
  
  public e(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.kmn = new ReentrantLock();
    this.btV = this.kmn.newCondition();
    this.bci = ((WifiManager)ae.getContext().getSystemService("wifi"));
    this.kmz = 10;
  }
  
  public final void aTl()
  {
    try
    {
      this.activity.unregisterReceiver(this.kmq);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  /* Error */
  public final int aTn()
  {
    // Byte code:
    //   0: iconst_3
    //   1: aload_0
    //   2: getfield 54	com/tencent/mm/plugin/freewifi/e:bci	Landroid/net/wifi/WifiManager;
    //   5: invokevirtual 75	android/net/wifi/WifiManager:getWifiState	()I
    //   8: if_icmpne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: new 77	com/tencent/mm/plugin/freewifi/e$1
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 80	com/tencent/mm/plugin/freewifi/e$1:<init>	(Lcom/tencent/mm/plugin/freewifi/e;)V
    //   22: putfield 62	com/tencent/mm/plugin/freewifi/e:kmq	Landroid/content/BroadcastReceiver;
    //   25: aload_0
    //   26: getfield 28	com/tencent/mm/plugin/freewifi/e:kmn	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 83 1 0
    //   34: new 85	android/content/IntentFilter
    //   37: dup
    //   38: invokespecial 86	android/content/IntentFilter:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc 88
    //   45: invokevirtual 92	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 23	com/tencent/mm/plugin/freewifi/e:activity	Landroid/app/Activity;
    //   52: aload_0
    //   53: getfield 62	com/tencent/mm/plugin/freewifi/e:kmq	Landroid/content/BroadcastReceiver;
    //   56: aload_2
    //   57: invokevirtual 96	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   60: pop
    //   61: aload_0
    //   62: getfield 54	com/tencent/mm/plugin/freewifi/e:bci	Landroid/net/wifi/WifiManager;
    //   65: iconst_1
    //   66: invokevirtual 100	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield 36	com/tencent/mm/plugin/freewifi/e:btV	Ljava/util/concurrent/locks/Condition;
    //   74: aload_0
    //   75: getfield 56	com/tencent/mm/plugin/freewifi/e:kmz	I
    //   78: i2l
    //   79: getstatic 106	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   82: invokeinterface 112 4 0
    //   87: istore_1
    //   88: iload_1
    //   89: ifeq +18 -> 107
    //   92: aload_0
    //   93: invokevirtual 114	com/tencent/mm/plugin/freewifi/e:aTl	()V
    //   96: aload_0
    //   97: getfield 28	com/tencent/mm/plugin/freewifi/e:kmn	Ljava/util/concurrent/locks/Lock;
    //   100: invokeinterface 117 1 0
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_0
    //   108: invokevirtual 114	com/tencent/mm/plugin/freewifi/e:aTl	()V
    //   111: aload_0
    //   112: getfield 28	com/tencent/mm/plugin/freewifi/e:kmn	Ljava/util/concurrent/locks/Lock;
    //   115: invokeinterface 117 1 0
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_2
    //   123: aload_0
    //   124: invokevirtual 114	com/tencent/mm/plugin/freewifi/e:aTl	()V
    //   127: aload_0
    //   128: getfield 28	com/tencent/mm/plugin/freewifi/e:kmn	Ljava/util/concurrent/locks/Lock;
    //   131: invokeinterface 117 1 0
    //   136: iconst_2
    //   137: ireturn
    //   138: astore_2
    //   139: aload_0
    //   140: invokevirtual 114	com/tencent/mm/plugin/freewifi/e:aTl	()V
    //   143: aload_0
    //   144: getfield 28	com/tencent/mm/plugin/freewifi/e:kmn	Ljava/util/concurrent/locks/Lock;
    //   147: invokeinterface 117 1 0
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	e
    //   87	2	1	bool	boolean
    //   41	16	2	localIntentFilter	android.content.IntentFilter
    //   122	1	2	localInterruptedException	java.lang.InterruptedException
    //   138	15	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	88	122	java/lang/InterruptedException
    //   25	88	138	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e
 * JD-Core Version:    0.7.0.1
 */