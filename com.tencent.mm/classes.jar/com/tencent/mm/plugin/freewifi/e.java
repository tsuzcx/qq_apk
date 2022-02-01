package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
{
  Lock aHh;
  private Activity activity;
  private WifiManager bSR;
  private BroadcastReceiver broadcastReceiver;
  Condition cEv;
  private int sol;
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(24649);
    this.activity = paramActivity;
    this.aHh = new ReentrantLock();
    this.cEv = this.aHh.newCondition();
    this.bSR = ((WifiManager)ai.getContext().getSystemService("wifi"));
    this.sol = 10;
    AppMethodBeat.o(24649);
  }
  
  public final void cIr()
  {
    AppMethodBeat.i(24651);
    try
    {
      this.activity.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(24651);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(24651);
    }
  }
  
  /* Error */
  public final int cIt()
  {
    // Byte code:
    //   0: sipush 24650
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_3
    //   7: aload_0
    //   8: getfield 62	com/tencent/mm/plugin/freewifi/e:bSR	Landroid/net/wifi/WifiManager;
    //   11: invokevirtual 86	android/net/wifi/WifiManager:getWifiState	()I
    //   14: if_icmpne +11 -> 25
    //   17: sipush 24650
    //   20: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: new 6	com/tencent/mm/plugin/freewifi/e$1
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 89	com/tencent/mm/plugin/freewifi/e$1:<init>	(Lcom/tencent/mm/plugin/freewifi/e;)V
    //   34: putfield 73	com/tencent/mm/plugin/freewifi/e:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   37: aload_0
    //   38: getfield 36	com/tencent/mm/plugin/freewifi/e:aHh	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 92 1 0
    //   46: new 94	android/content/IntentFilter
    //   49: dup
    //   50: invokespecial 95	android/content/IntentFilter:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: ldc 97
    //   57: invokevirtual 101	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 31	com/tencent/mm/plugin/freewifi/e:activity	Landroid/app/Activity;
    //   64: aload_0
    //   65: getfield 73	com/tencent/mm/plugin/freewifi/e:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   68: aload_2
    //   69: invokevirtual 105	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   72: pop
    //   73: aload_0
    //   74: getfield 62	com/tencent/mm/plugin/freewifi/e:bSR	Landroid/net/wifi/WifiManager;
    //   77: iconst_1
    //   78: invokevirtual 109	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   81: pop
    //   82: aload_0
    //   83: getfield 44	com/tencent/mm/plugin/freewifi/e:cEv	Ljava/util/concurrent/locks/Condition;
    //   86: aload_0
    //   87: getfield 64	com/tencent/mm/plugin/freewifi/e:sol	I
    //   90: i2l
    //   91: getstatic 115	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   94: invokeinterface 121 4 0
    //   99: istore_1
    //   100: iload_1
    //   101: ifeq +24 -> 125
    //   104: aload_0
    //   105: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:cIr	()V
    //   108: aload_0
    //   109: getfield 36	com/tencent/mm/plugin/freewifi/e:aHh	Ljava/util/concurrent/locks/Lock;
    //   112: invokeinterface 126 1 0
    //   117: sipush 24650
    //   120: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iconst_0
    //   124: ireturn
    //   125: aload_0
    //   126: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:cIr	()V
    //   129: aload_0
    //   130: getfield 36	com/tencent/mm/plugin/freewifi/e:aHh	Ljava/util/concurrent/locks/Lock;
    //   133: invokeinterface 126 1 0
    //   138: sipush 24650
    //   141: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_1
    //   145: ireturn
    //   146: astore_2
    //   147: aload_0
    //   148: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:cIr	()V
    //   151: aload_0
    //   152: getfield 36	com/tencent/mm/plugin/freewifi/e:aHh	Ljava/util/concurrent/locks/Lock;
    //   155: invokeinterface 126 1 0
    //   160: sipush 24650
    //   163: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iconst_2
    //   167: ireturn
    //   168: astore_2
    //   169: aload_0
    //   170: invokevirtual 123	com/tencent/mm/plugin/freewifi/e:cIr	()V
    //   173: aload_0
    //   174: getfield 36	com/tencent/mm/plugin/freewifi/e:aHh	Ljava/util/concurrent/locks/Lock;
    //   177: invokeinterface 126 1 0
    //   182: sipush 24650
    //   185: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e
 * JD-Core Version:    0.7.0.1
 */