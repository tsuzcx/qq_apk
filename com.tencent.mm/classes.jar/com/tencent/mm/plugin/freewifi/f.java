package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f
{
  Condition bVg;
  private BroadcastReceiver broadcastReceiver;
  private WifiManager bsO;
  private Context context;
  Lock mHZ;
  private int mIl;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(20576);
    this.context = paramContext;
    this.mHZ = new ReentrantLock();
    this.bVg = this.mHZ.newCondition();
    this.bsO = ((WifiManager)ah.getContext().getSystemService("wifi"));
    this.mIl = 10;
    AppMethodBeat.o(20576);
  }
  
  public final void bzQ()
  {
    AppMethodBeat.i(20578);
    try
    {
      this.context.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(20578);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(20578);
    }
  }
  
  /* Error */
  public final int bzS()
  {
    // Byte code:
    //   0: sipush 20577
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_3
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/freewifi/f:bsO	Landroid/net/wifi/WifiManager;
    //   11: invokevirtual 82	android/net/wifi/WifiManager:getWifiState	()I
    //   14: if_icmpne +11 -> 25
    //   17: sipush 20577
    //   20: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: new 84	com/tencent/mm/plugin/freewifi/f$1
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 87	com/tencent/mm/plugin/freewifi/f$1:<init>	(Lcom/tencent/mm/plugin/freewifi/f;)V
    //   34: putfield 71	com/tencent/mm/plugin/freewifi/f:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   37: aload_0
    //   38: getfield 34	com/tencent/mm/plugin/freewifi/f:mHZ	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 90 1 0
    //   46: new 92	android/content/IntentFilter
    //   49: dup
    //   50: invokespecial 93	android/content/IntentFilter:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: ldc 95
    //   57: invokevirtual 99	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 29	com/tencent/mm/plugin/freewifi/f:context	Landroid/content/Context;
    //   64: aload_0
    //   65: getfield 71	com/tencent/mm/plugin/freewifi/f:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   68: aload_2
    //   69: invokevirtual 103	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   72: pop
    //   73: aload_0
    //   74: getfield 60	com/tencent/mm/plugin/freewifi/f:bsO	Landroid/net/wifi/WifiManager;
    //   77: iconst_1
    //   78: invokevirtual 107	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   81: pop
    //   82: aload_0
    //   83: getfield 42	com/tencent/mm/plugin/freewifi/f:bVg	Ljava/util/concurrent/locks/Condition;
    //   86: aload_0
    //   87: getfield 62	com/tencent/mm/plugin/freewifi/f:mIl	I
    //   90: i2l
    //   91: getstatic 113	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   94: invokeinterface 119 4 0
    //   99: istore_1
    //   100: iload_1
    //   101: ifeq +24 -> 125
    //   104: aload_0
    //   105: invokevirtual 121	com/tencent/mm/plugin/freewifi/f:bzQ	()V
    //   108: aload_0
    //   109: getfield 34	com/tencent/mm/plugin/freewifi/f:mHZ	Ljava/util/concurrent/locks/Lock;
    //   112: invokeinterface 124 1 0
    //   117: sipush 20577
    //   120: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload_0
    //   126: invokevirtual 121	com/tencent/mm/plugin/freewifi/f:bzQ	()V
    //   129: aload_0
    //   130: getfield 34	com/tencent/mm/plugin/freewifi/f:mHZ	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 124 1 0
    //   138: sipush 20577
    //   141: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_1
    //   145: ireturn
    //   146: astore_2
    //   147: aload_0
    //   148: invokevirtual 121	com/tencent/mm/plugin/freewifi/f:bzQ	()V
    //   151: aload_0
    //   152: getfield 34	com/tencent/mm/plugin/freewifi/f:mHZ	Ljava/util/concurrent/locks/Lock;
    //   155: invokeinterface 124 1 0
    //   160: sipush 20577
    //   163: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iconst_2
    //   167: ireturn
    //   168: astore_2
    //   169: aload_0
    //   170: invokevirtual 121	com/tencent/mm/plugin/freewifi/f:bzQ	()V
    //   173: aload_0
    //   174: getfield 34	com/tencent/mm/plugin/freewifi/f:mHZ	Ljava/util/concurrent/locks/Lock;
    //   177: invokeinterface 124 1 0
    //   182: sipush 20577
    //   185: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_2
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	f
    //   99	2	1	bool	boolean
    //   53	16	2	localIntentFilter	android.content.IntentFilter
    //   146	1	2	localInterruptedException	java.lang.InterruptedException
    //   168	21	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   37	100	146	java/lang/InterruptedException
    //   37	100	168	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f
 * JD-Core Version:    0.7.0.1
 */