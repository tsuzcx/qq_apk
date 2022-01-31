package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  Activity activity;
  private WifiManager bci;
  Condition btV;
  private long edM;
  Lock kmn;
  boolean kmo = false;
  boolean kmp = false;
  private BroadcastReceiver kmq;
  String ssid;
  
  public a(String paramString, Activity paramActivity)
  {
    this.activity = paramActivity;
    this.edM = 15000L;
    this.ssid = paramString;
    this.kmn = new ReentrantLock();
    this.btV = this.kmn.newCondition();
    this.bci = ((WifiManager)ae.getContext().getSystemService("wifi"));
  }
  
  private void aTl()
  {
    try
    {
      this.activity.unregisterReceiver(this.kmq);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  /* Error */
  public final void a(a.a parama)
  {
    // Byte code:
    //   0: new 89	com/tencent/mm/plugin/freewifi/a$1
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 92	com/tencent/mm/plugin/freewifi/a$1:<init>	(Lcom/tencent/mm/plugin/freewifi/a;Lcom/tencent/mm/plugin/freewifi/a$a;)V
    //   9: astore_1
    //   10: invokestatic 59	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   13: ldc 94
    //   15: invokevirtual 67	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 96	android/net/ConnectivityManager
    //   21: iconst_1
    //   22: invokevirtual 100	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   25: invokevirtual 106	android/net/NetworkInfo:isConnected	()Z
    //   28: ifeq +23 -> 51
    //   31: aload_0
    //   32: getfield 40	com/tencent/mm/plugin/freewifi/a:ssid	Ljava/lang/String;
    //   35: invokestatic 112	com/tencent/mm/plugin/freewifi/model/d:aUa	()Ljava/lang/String;
    //   38: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +10 -> 51
    //   44: aload_1
    //   45: invokeinterface 121 1 0
    //   50: return
    //   51: invokestatic 127	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   54: invokestatic 133	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   57: invokevirtual 136	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   60: if_acmpne +13 -> 73
    //   63: new 138	java/lang/RuntimeException
    //   66: dup
    //   67: ldc 140
    //   69: invokespecial 143	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: aload_0
    //   74: new 145	com/tencent/mm/plugin/freewifi/a$2
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 148	com/tencent/mm/plugin/freewifi/a$2:<init>	(Lcom/tencent/mm/plugin/freewifi/a;)V
    //   82: putfield 77	com/tencent/mm/plugin/freewifi/a:kmq	Landroid/content/BroadcastReceiver;
    //   85: aload_0
    //   86: getfield 45	com/tencent/mm/plugin/freewifi/a:kmn	Ljava/util/concurrent/locks/Lock;
    //   89: invokeinterface 151 1 0
    //   94: new 153	android/content/IntentFilter
    //   97: dup
    //   98: invokespecial 154	android/content/IntentFilter:<init>	()V
    //   101: astore 7
    //   103: aload 7
    //   105: ldc 156
    //   107: invokevirtual 159	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   110: aload 7
    //   112: ldc 161
    //   114: invokevirtual 159	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield 34	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   121: aload_0
    //   122: getfield 77	com/tencent/mm/plugin/freewifi/a:kmq	Landroid/content/BroadcastReceiver;
    //   125: aload 7
    //   127: invokevirtual 165	android/app/Activity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   130: pop
    //   131: aload_0
    //   132: getfield 71	com/tencent/mm/plugin/freewifi/a:bci	Landroid/net/wifi/WifiManager;
    //   135: invokevirtual 168	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   138: ifne +64 -> 202
    //   141: new 170	com/tencent/mm/plugin/freewifi/e
    //   144: dup
    //   145: aload_0
    //   146: getfield 34	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   149: invokespecial 173	com/tencent/mm/plugin/freewifi/e:<init>	(Landroid/app/Activity;)V
    //   152: invokevirtual 177	com/tencent/mm/plugin/freewifi/e:aTn	()I
    //   155: istore_2
    //   156: ldc 179
    //   158: new 181	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 183
    //   164: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: iload_2
    //   168: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 197	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iload_2
    //   178: ifeq +24 -> 202
    //   181: aload_1
    //   182: iload_2
    //   183: invokeinterface 201 2 0
    //   188: aload_0
    //   189: invokespecial 203	com/tencent/mm/plugin/freewifi/a:aTl	()V
    //   192: aload_0
    //   193: getfield 45	com/tencent/mm/plugin/freewifi/a:kmn	Ljava/util/concurrent/locks/Lock;
    //   196: invokeinterface 206 1 0
    //   201: return
    //   202: aload_0
    //   203: getfield 40	com/tencent/mm/plugin/freewifi/a:ssid	Ljava/lang/String;
    //   206: invokestatic 210	com/tencent/mm/plugin/freewifi/model/d:Dv	(Ljava/lang/String;)I
    //   209: istore_2
    //   210: iload_2
    //   211: ifeq +28 -> 239
    //   214: aload_0
    //   215: invokespecial 203	com/tencent/mm/plugin/freewifi/a:aTl	()V
    //   218: aload_1
    //   219: iload_2
    //   220: invokeinterface 201 2 0
    //   225: aload_0
    //   226: invokespecial 203	com/tencent/mm/plugin/freewifi/a:aTl	()V
    //   229: aload_0
    //   230: getfield 45	com/tencent/mm/plugin/freewifi/a:kmn	Ljava/util/concurrent/locks/Lock;
    //   233: invokeinterface 206 1 0
    //   238: return
    //   239: iconst_0
    //   240: istore_3
    //   241: aload_0
    //   242: getfield 30	com/tencent/mm/plugin/freewifi/a:kmo	Z
    //   245: ifeq +13 -> 258
    //   248: iload_3
    //   249: istore 4
    //   251: aload_0
    //   252: getfield 32	com/tencent/mm/plugin/freewifi/a:kmp	Z
    //   255: ifne +189 -> 444
    //   258: invokestatic 216	java/lang/System:currentTimeMillis	()J
    //   261: lstore 5
    //   263: aload_0
    //   264: getfield 53	com/tencent/mm/plugin/freewifi/a:btV	Ljava/util/concurrent/locks/Condition;
    //   267: aload_0
    //   268: getfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   271: getstatic 222	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   274: invokeinterface 228 4 0
    //   279: istore_3
    //   280: iload_3
    //   281: istore 4
    //   283: iload_3
    //   284: ifeq +160 -> 444
    //   287: invokestatic 216	java/lang/System:currentTimeMillis	()J
    //   290: lload 5
    //   292: lsub
    //   293: lstore 5
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   300: lload 5
    //   302: lsub
    //   303: putfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   306: ldc 179
    //   308: new 181	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 230
    //   314: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: lload 5
    //   319: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: ldc 235
    //   324: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: getfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   331: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 197	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload_0
    //   341: getfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   344: lconst_0
    //   345: lcmp
    //   346: ifle +90 -> 436
    //   349: aload_0
    //   350: getfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   353: lstore 5
    //   355: aload_0
    //   356: lload 5
    //   358: putfield 38	com/tencent/mm/plugin/freewifi/a:edM	J
    //   361: goto -120 -> 241
    //   364: astore 7
    //   366: ldc 179
    //   368: ldc 240
    //   370: iconst_3
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_0
    //   377: getfield 34	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   380: invokevirtual 244	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   383: invokestatic 250	com/tencent/mm/plugin/freewifi/m:B	(Landroid/content/Intent;)Ljava/lang/String;
    //   386: aastore
    //   387: dup
    //   388: iconst_1
    //   389: aload_0
    //   390: getfield 34	com/tencent/mm/plugin/freewifi/a:activity	Landroid/app/Activity;
    //   393: invokevirtual 244	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   396: invokestatic 254	com/tencent/mm/plugin/freewifi/m:C	(Landroid/content/Intent;)I
    //   399: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   402: aastore
    //   403: dup
    //   404: iconst_2
    //   405: aload 7
    //   407: invokevirtual 263	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   410: aastore
    //   411: invokestatic 266	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: aload_1
    //   415: bipush 239
    //   417: invokeinterface 201 2 0
    //   422: aload_0
    //   423: invokespecial 203	com/tencent/mm/plugin/freewifi/a:aTl	()V
    //   426: aload_0
    //   427: getfield 45	com/tencent/mm/plugin/freewifi/a:kmn	Ljava/util/concurrent/locks/Lock;
    //   430: invokeinterface 206 1 0
    //   435: return
    //   436: ldc2_w 267
    //   439: lstore 5
    //   441: goto -86 -> 355
    //   444: iload 4
    //   446: ifne +25 -> 471
    //   449: aload_1
    //   450: bipush 240
    //   452: invokeinterface 201 2 0
    //   457: aload_0
    //   458: invokespecial 203	com/tencent/mm/plugin/freewifi/a:aTl	()V
    //   461: aload_0
    //   462: getfield 45	com/tencent/mm/plugin/freewifi/a:kmn	Ljava/util/concurrent/locks/Lock;
    //   465: invokeinterface 206 1 0
    //   470: return
    //   471: aload_1
    //   472: invokeinterface 121 1 0
    //   477: goto -20 -> 457
    //   480: astore_1
    //   481: aload_0
    //   482: invokespecial 203	com/tencent/mm/plugin/freewifi/a:aTl	()V
    //   485: aload_0
    //   486: getfield 45	com/tencent/mm/plugin/freewifi/a:kmn	Ljava/util/concurrent/locks/Lock;
    //   489: invokeinterface 206 1 0
    //   494: aload_1
    //   495: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	a
    //   0	496	1	parama	a.a
    //   155	65	2	i	int
    //   240	44	3	bool1	boolean
    //   249	196	4	bool2	boolean
    //   261	179	5	l	long
    //   101	25	7	localIntentFilter	android.content.IntentFilter
    //   364	42	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   241	248	364	java/lang/InterruptedException
    //   251	258	364	java/lang/InterruptedException
    //   258	280	364	java/lang/InterruptedException
    //   287	355	364	java/lang/InterruptedException
    //   355	361	364	java/lang/InterruptedException
    //   85	177	480	finally
    //   181	188	480	finally
    //   202	210	480	finally
    //   214	225	480	finally
    //   241	248	480	finally
    //   251	258	480	finally
    //   258	280	480	finally
    //   287	355	480	finally
    //   355	361	480	finally
    //   366	422	480	finally
    //   449	457	480	finally
    //   471	477	480	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a
 * JD-Core Version:    0.7.0.1
 */