package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
{
  private Activity activity;
  Condition bVg;
  private BroadcastReceiver broadcastReceiver;
  private WifiManager bsO;
  Lock mHZ;
  private int mIl;
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(20572);
    this.activity = paramActivity;
    this.mHZ = new ReentrantLock();
    this.bVg = this.mHZ.newCondition();
    this.bsO = ((WifiManager)ah.getContext().getSystemService("wifi"));
    this.mIl = 10;
    AppMethodBeat.o(20572);
  }
  
  public final void bzQ()
  {
    AppMethodBeat.i(20574);
    try
    {
      this.activity.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(20574);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(20574);
    }
  }
  
  /* Error */
  public final int bzS()
  {
    // Byte code:
    //   0: sipush 20573
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_3
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/freewifi/e:bsO	Landroid/net/wifi/WifiManager;
    //   11: invokevirtual 84	android/net/wifi/WifiManager:getWifiState	()I
    //   14: if_icmpne +11 -> 25
    //   17: sipush 20573
    //   20: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: new 86	com/tencent/mm/plugin/freewifi/e$1
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 89	com/tencent/mm/plugin/freewifi/e$1:<init>	(Lcom/tencent/mm/plugin/freewifi/e;)V
    //   34: putfield 71	com/tencent/mm/plugin/freewifi/e:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   37: aload_0
    //   38: getfield 34	com/tencent/mm/plugin/freewifi/e:mHZ	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 92 1 0
    //   46: new 94	android/content/IntentFilter
    //   49: dup
    //   50: invokespecial 95	android/content/IntentFilter:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: ldc 97
    //   57: invokevirtual 101	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 29	com/tencent/mm/plugin/freewifi/e:activity	Landroid/app/Activity;
    //   64: aload_0
    //   65: getfield 71	com/tencent/mm/plugin/freewifi/e:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   68: aload_2
    //   69: invokevirtual 105	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   72: pop
    //   73: aload_0
    //   74: getfield 60	com/tencent/mm/plugin/freewifi/e:bsO	Landroid/net/wifi/WifiManager;
    //   77: iconst_1
    //   78: invokevirtual 109	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   81: pop
    //   82: aload_0
    //   83: getfield 42	com/tencent/mm/plugin/freewifi/e:bVg	Ljava/util/concurrent/locks/Condition;
    //   86: aload_0
    //   87: getfield 62	com/tencent/mm/plugin/freewifi/e:mIl	I
    //   90: i2l
    //   91: getstatic 115	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   94: invokeinterface 121 4 0
    //   99: istore_1
    //   100: iload_1
    //   101: ifeq +24 -> 125
    //   104: aload_0
    //   105: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:bzQ	()V
    //   108: aload_0
    //   109: getfield 34	com/tencent/mm/plugin/freewifi/e:mHZ	Ljava/util/concurrent/locks/Lock;
    //   112: invokeinterface 126 1 0
    //   117: sipush 20573
    //   120: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload_0
    //   126: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:bzQ	()V
    //   129: aload_0
    //   130: getfield 34	com/tencent/mm/plugin/freewifi/e:mHZ	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 126 1 0
    //   138: sipush 20573
    //   141: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_1
    //   145: ireturn
    //   146: astore_2
    //   147: aload_0
    //   148: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:bzQ	()V
    //   151: aload_0
    //   152: getfield 34	com/tencent/mm/plugin/freewifi/e:mHZ	Ljava/util/concurrent/locks/Lock;
    //   155: invokeinterface 126 1 0
    //   160: sipush 20573
    //   163: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iconst_2
    //   167: ireturn
    //   168: astore_2
    //   169: aload_0
    //   170: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:bzQ	()V
    //   173: aload_0
    //   174: getfield 34	com/tencent/mm/plugin/freewifi/e:mHZ	Ljava/util/concurrent/locks/Lock;
    //   177: invokeinterface 126 1 0
    //   182: sipush 20573
    //   185: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_2
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	e
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e
 * JD-Core Version:    0.7.0.1
 */