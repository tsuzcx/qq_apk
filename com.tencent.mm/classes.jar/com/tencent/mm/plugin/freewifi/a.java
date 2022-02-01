package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  Lock aGr;
  Activity activity;
  private WifiManager bVj;
  private BroadcastReceiver broadcastReceiver;
  Condition cHn;
  private long csI;
  boolean rfj;
  boolean rfk;
  String ssid;
  
  public a(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(24634);
    this.rfj = false;
    this.rfk = false;
    this.activity = paramActivity;
    this.csI = 15000L;
    this.ssid = paramString;
    this.aGr = new ReentrantLock();
    this.cHn = this.aGr.newCondition();
    this.bVj = ((WifiManager)aj.getContext().getSystemService("wifi"));
    AppMethodBeat.o(24634);
  }
  
  private void cvf()
  {
    AppMethodBeat.i(24636);
    try
    {
      this.activity.unregisterReceiver(this.broadcastReceiver);
      AppMethodBeat.o(24636);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(24636);
    }
  }
  
  /* Error */
  public final void a(final a parama)
  {
    // Byte code:
    //   0: sipush 24635
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/freewifi/a$1
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 103	com/tencent/mm/plugin/freewifi/a$1:<init>	(Lcom/tencent/mm/plugin/freewifi/a;Lcom/tencent/mm/plugin/freewifi/a$a;)V
    //   15: astore_1
    //   16: invokestatic 70	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   19: ldc 105
    //   21: invokevirtual 78	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 107	android/net/ConnectivityManager
    //   27: iconst_1
    //   28: invokevirtual 111	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   31: invokevirtual 117	android/net/NetworkInfo:isConnected	()Z
    //   34: ifeq +29 -> 63
    //   37: aload_0
    //   38: getfield 51	com/tencent/mm/plugin/freewifi/a:ssid	Ljava/lang/String;
    //   41: invokestatic 123	com/tencent/mm/plugin/freewifi/model/d:cvQ	()Ljava/lang/String;
    //   44: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +16 -> 63
    //   50: aload_1
    //   51: invokeinterface 132 1 0
    //   56: sipush 24635
    //   59: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: invokestatic 138	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   66: invokestatic 144	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   69: invokevirtual 147	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   72: if_acmpne +21 -> 93
    //   75: new 149	java/lang/RuntimeException
    //   78: dup
    //   79: ldc 151
    //   81: invokespecial 154	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   84: astore_1
    //   85: sipush 24635
    //   88: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_1
    //   92: athrow
    //   93: aload_0
    //   94: new 8	com/tencent/mm/plugin/freewifi/a$2
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 157	com/tencent/mm/plugin/freewifi/a$2:<init>	(Lcom/tencent/mm/plugin/freewifi/a;)V
    //   102: putfield 91	com/tencent/mm/plugin/freewifi/a:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   105: aload_0
    //   106: getfield 56	com/tencent/mm/plugin/freewifi/a:aGr	Ljava/util/concurrent/locks/Lock;
    //   109: invokeinterface 160 1 0
    //   114: new 162	android/content/IntentFilter
    //   117: dup
    //   118: invokespecial 163	android/content/IntentFilter:<init>	()V
    //   121: astore 7
    //   123: aload 7
    //   125: ldc 165
    //   127: invokevirtual 168	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   130: aload 7
    //   132: ldc 170
    //   134: invokevirtual 168	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 45	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   141: aload_0
    //   142: getfield 91	com/tencent/mm/plugin/freewifi/a:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   145: aload 7
    //   147: invokevirtual 174	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   150: pop
    //   151: aload_0
    //   152: getfield 82	com/tencent/mm/plugin/freewifi/a:bVj	Landroid/net/wifi/WifiManager;
    //   155: invokevirtual 177	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   158: ifne +63 -> 221
    //   161: new 179	com/tencent/mm/plugin/freewifi/e
    //   164: dup
    //   165: aload_0
    //   166: getfield 45	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   169: invokespecial 182	com/tencent/mm/plugin/freewifi/e:<init>	(Landroid/app/Activity;)V
    //   172: invokevirtual 186	com/tencent/mm/plugin/freewifi/e:cvh	()I
    //   175: istore_2
    //   176: ldc 188
    //   178: ldc 190
    //   180: iload_2
    //   181: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   184: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: iload_2
    //   191: ifeq +30 -> 221
    //   194: aload_1
    //   195: iload_2
    //   196: invokeinterface 206 2 0
    //   201: aload_0
    //   202: invokespecial 208	com/tencent/mm/plugin/freewifi/a:cvf	()V
    //   205: aload_0
    //   206: getfield 56	com/tencent/mm/plugin/freewifi/a:aGr	Ljava/util/concurrent/locks/Lock;
    //   209: invokeinterface 211 1 0
    //   214: sipush 24635
    //   217: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    //   221: aload_0
    //   222: getfield 51	com/tencent/mm/plugin/freewifi/a:ssid	Ljava/lang/String;
    //   225: invokestatic 215	com/tencent/mm/plugin/freewifi/model/d:aaB	(Ljava/lang/String;)I
    //   228: istore_2
    //   229: iload_2
    //   230: ifeq +34 -> 264
    //   233: aload_0
    //   234: invokespecial 208	com/tencent/mm/plugin/freewifi/a:cvf	()V
    //   237: aload_1
    //   238: iload_2
    //   239: invokeinterface 206 2 0
    //   244: aload_0
    //   245: invokespecial 208	com/tencent/mm/plugin/freewifi/a:cvf	()V
    //   248: aload_0
    //   249: getfield 56	com/tencent/mm/plugin/freewifi/a:aGr	Ljava/util/concurrent/locks/Lock;
    //   252: invokeinterface 211 1 0
    //   257: sipush 24635
    //   260: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: return
    //   264: iconst_0
    //   265: istore_3
    //   266: aload_0
    //   267: getfield 41	com/tencent/mm/plugin/freewifi/a:rfj	Z
    //   270: ifeq +13 -> 283
    //   273: iload_3
    //   274: istore 4
    //   276: aload_0
    //   277: getfield 43	com/tencent/mm/plugin/freewifi/a:rfk	Z
    //   280: ifne +195 -> 475
    //   283: invokestatic 221	java/lang/System:currentTimeMillis	()J
    //   286: lstore 5
    //   288: aload_0
    //   289: getfield 64	com/tencent/mm/plugin/freewifi/a:cHn	Ljava/util/concurrent/locks/Condition;
    //   292: aload_0
    //   293: getfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   296: getstatic 227	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   299: invokeinterface 233 4 0
    //   304: istore_3
    //   305: iload_3
    //   306: istore 4
    //   308: iload_3
    //   309: ifeq +166 -> 475
    //   312: invokestatic 221	java/lang/System:currentTimeMillis	()J
    //   315: lload 5
    //   317: lsub
    //   318: lstore 5
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   325: lload 5
    //   327: lsub
    //   328: putfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   331: ldc 188
    //   333: new 235	java/lang/StringBuilder
    //   336: dup
    //   337: ldc 237
    //   339: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: lload 5
    //   344: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: ldc 244
    //   349: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_0
    //   353: getfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   356: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: getfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   369: lconst_0
    //   370: lcmp
    //   371: ifle +96 -> 467
    //   374: aload_0
    //   375: getfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   378: lstore 5
    //   380: aload_0
    //   381: lload 5
    //   383: putfield 49	com/tencent/mm/plugin/freewifi/a:csI	J
    //   386: goto -120 -> 266
    //   389: astore 7
    //   391: ldc 188
    //   393: ldc 252
    //   395: iconst_3
    //   396: anewarray 4	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload_0
    //   402: getfield 45	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   405: invokevirtual 256	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   408: invokestatic 262	com/tencent/mm/plugin/freewifi/m:ai	(Landroid/content/Intent;)Ljava/lang/String;
    //   411: aastore
    //   412: dup
    //   413: iconst_1
    //   414: aload_0
    //   415: getfield 45	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   418: invokevirtual 256	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   421: invokestatic 266	com/tencent/mm/plugin/freewifi/m:aj	(Landroid/content/Intent;)I
    //   424: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   427: aastore
    //   428: dup
    //   429: iconst_2
    //   430: aload 7
    //   432: invokevirtual 274	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   435: aastore
    //   436: invokestatic 277	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: aload_1
    //   440: bipush 239
    //   442: invokeinterface 206 2 0
    //   447: aload_0
    //   448: invokespecial 208	com/tencent/mm/plugin/freewifi/a:cvf	()V
    //   451: aload_0
    //   452: getfield 56	com/tencent/mm/plugin/freewifi/a:aGr	Ljava/util/concurrent/locks/Lock;
    //   455: invokeinterface 211 1 0
    //   460: sipush 24635
    //   463: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   466: return
    //   467: ldc2_w 278
    //   470: lstore 5
    //   472: goto -92 -> 380
    //   475: iload 4
    //   477: ifne +31 -> 508
    //   480: aload_1
    //   481: bipush 240
    //   483: invokeinterface 206 2 0
    //   488: aload_0
    //   489: invokespecial 208	com/tencent/mm/plugin/freewifi/a:cvf	()V
    //   492: aload_0
    //   493: getfield 56	com/tencent/mm/plugin/freewifi/a:aGr	Ljava/util/concurrent/locks/Lock;
    //   496: invokeinterface 211 1 0
    //   501: sipush 24635
    //   504: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   507: return
    //   508: aload_1
    //   509: invokeinterface 132 1 0
    //   514: goto -26 -> 488
    //   517: astore_1
    //   518: aload_0
    //   519: invokespecial 208	com/tencent/mm/plugin/freewifi/a:cvf	()V
    //   522: aload_0
    //   523: getfield 56	com/tencent/mm/plugin/freewifi/a:aGr	Ljava/util/concurrent/locks/Lock;
    //   526: invokeinterface 211 1 0
    //   531: sipush 24635
    //   534: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: aload_1
    //   538: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	a
    //   0	539	1	parama	a
    //   175	64	2	i	int
    //   265	44	3	bool1	boolean
    //   274	202	4	bool2	boolean
    //   286	185	5	l	long
    //   121	25	7	localIntentFilter	android.content.IntentFilter
    //   389	42	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   266	273	389	java/lang/InterruptedException
    //   276	283	389	java/lang/InterruptedException
    //   283	305	389	java/lang/InterruptedException
    //   312	380	389	java/lang/InterruptedException
    //   380	386	389	java/lang/InterruptedException
    //   105	190	517	finally
    //   194	201	517	finally
    //   221	229	517	finally
    //   233	244	517	finally
    //   266	273	517	finally
    //   276	283	517	finally
    //   283	305	517	finally
    //   312	380	517	finally
    //   380	386	517	finally
    //   391	447	517	finally
    //   480	488	517	finally
    //   508	514	517	finally
  }
  
  public static abstract interface a
  {
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a
 * JD-Core Version:    0.7.0.1
 */