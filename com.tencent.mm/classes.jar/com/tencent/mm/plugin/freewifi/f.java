package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f
{
  private WifiManager bci;
  Condition btV;
  private Context context;
  Lock kmn;
  private BroadcastReceiver kmq;
  private int kmz;
  
  public f(Context paramContext)
  {
    this.context = paramContext;
    this.kmn = new ReentrantLock();
    this.btV = this.kmn.newCondition();
    this.bci = ((WifiManager)ae.getContext().getSystemService("wifi"));
    this.kmz = 10;
  }
  
  public final void aTl()
  {
    try
    {
      this.context.unregisterReceiver(this.kmq);
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
    //   2: getfield 54	com/tencent/mm/plugin/freewifi/f:bci	Landroid/net/wifi/WifiManager;
    //   5: invokevirtual 73	android/net/wifi/WifiManager:getWifiState	()I
    //   8: if_icmpne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: new 75	com/tencent/mm/plugin/freewifi/f$1
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 78	com/tencent/mm/plugin/freewifi/f$1:<init>	(Lcom/tencent/mm/plugin/freewifi/f;)V
    //   22: putfield 62	com/tencent/mm/plugin/freewifi/f:kmq	Landroid/content/BroadcastReceiver;
    //   25: aload_0
    //   26: getfield 28	com/tencent/mm/plugin/freewifi/f:kmn	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 81 1 0
    //   34: new 83	android/content/IntentFilter
    //   37: dup
    //   38: invokespecial 84	android/content/IntentFilter:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc 86
    //   45: invokevirtual 90	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 23	com/tencent/mm/plugin/freewifi/f:context	Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 62	com/tencent/mm/plugin/freewifi/f:kmq	Landroid/content/BroadcastReceiver;
    //   56: aload_2
    //   57: invokevirtual 94	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   60: pop
    //   61: aload_0
    //   62: getfield 54	com/tencent/mm/plugin/freewifi/f:bci	Landroid/net/wifi/WifiManager;
    //   65: iconst_1
    //   66: invokevirtual 98	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield 36	com/tencent/mm/plugin/freewifi/f:btV	Ljava/util/concurrent/locks/Condition;
    //   74: aload_0
    //   75: getfield 56	com/tencent/mm/plugin/freewifi/f:kmz	I
    //   78: i2l
    //   79: getstatic 104	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   82: invokeinterface 110 4 0
    //   87: istore_1
    //   88: iload_1
    //   89: ifeq +18 -> 107
    //   92: aload_0
    //   93: invokevirtual 112	com/tencent/mm/plugin/freewifi/f:aTl	()V
    //   96: aload_0
    //   97: getfield 28	com/tencent/mm/plugin/freewifi/f:kmn	Ljava/util/concurrent/locks/Lock;
    //   100: invokeinterface 115 1 0
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_0
    //   108: invokevirtual 112	com/tencent/mm/plugin/freewifi/f:aTl	()V
    //   111: aload_0
    //   112: getfield 28	com/tencent/mm/plugin/freewifi/f:kmn	Ljava/util/concurrent/locks/Lock;
    //   115: invokeinterface 115 1 0
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_2
    //   123: aload_0
    //   124: invokevirtual 112	com/tencent/mm/plugin/freewifi/f:aTl	()V
    //   127: aload_0
    //   128: getfield 28	com/tencent/mm/plugin/freewifi/f:kmn	Ljava/util/concurrent/locks/Lock;
    //   131: invokeinterface 115 1 0
    //   136: iconst_2
    //   137: ireturn
    //   138: astore_2
    //   139: aload_0
    //   140: invokevirtual 112	com/tencent/mm/plugin/freewifi/f:aTl	()V
    //   143: aload_0
    //   144: getfield 28	com/tencent/mm/plugin/freewifi/f:kmn	Ljava/util/concurrent/locks/Lock;
    //   147: invokeinterface 115 1 0
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	f
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f
 * JD-Core Version:    0.7.0.1
 */