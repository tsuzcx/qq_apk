package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzaf
{
  private static int zzck;
  private static final zzaj<Boolean> zzco;
  private static String zzcp;
  private static boolean zzcq;
  private static int zzcr;
  private static int zzcs;
  private static BroadcastReceiver zzct;
  private PendingIntent zzad;
  private Messenger zzah;
  private Map<String, Object> zzcu;
  private Messenger zzcv;
  private MessengerCompat zzcw;
  private Context zzk;
  
  static
  {
    AppMethodBeat.i(2500);
    zzco = zzai.zzw().zzd("gcm_iid_use_messenger_ipc", true);
    zzcp = null;
    zzcq = false;
    zzcr = 0;
    zzcs = 0;
    zzck = 0;
    zzct = null;
    AppMethodBeat.o(2500);
  }
  
  public zzaf(Context paramContext)
  {
    AppMethodBeat.i(2484);
    this.zzcu = new a();
    this.zzk = paramContext;
    AppMethodBeat.o(2484);
  }
  
  private static void zzd(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(2494);
    if ((paramObject1 instanceof ConditionVariable)) {
      ((ConditionVariable)paramObject1).open();
    }
    if ((paramObject1 instanceof Messenger))
    {
      paramObject1 = (Messenger)paramObject1;
      Message localMessage = Message.obtain();
      localMessage.obj = paramObject2;
      try
      {
        paramObject1.send(localMessage);
        AppMethodBeat.o(2494);
        return;
      }
      catch (RemoteException paramObject1)
      {
        paramObject1 = String.valueOf(paramObject1);
        new StringBuilder(String.valueOf(paramObject1).length() + 24).append("Failed to send response ").append(paramObject1);
      }
    }
    AppMethodBeat.o(2494);
  }
  
  private final void zzd(String paramString, Object paramObject)
  {
    AppMethodBeat.i(2493);
    synchronized (getClass())
    {
      Object localObject = this.zzcu.get(paramString);
      this.zzcu.put(paramString, paramObject);
      zzd(localObject, paramObject);
      AppMethodBeat.o(2493);
      return;
    }
  }
  
  private static boolean zzd(PackageManager paramPackageManager, String paramString)
  {
    AppMethodBeat.i(2488);
    try
    {
      paramPackageManager = paramPackageManager.getApplicationInfo(paramString, 0);
      zzcp = paramPackageManager.packageName;
      zzcs = paramPackageManager.uid;
      AppMethodBeat.o(2488);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      AppMethodBeat.o(2488);
    }
    return false;
  }
  
  private static boolean zzd(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(2487);
    if (paramPackageManager.checkPermission("com.google.android.c2dm.permission.SEND", paramString1) == 0)
    {
      boolean bool = zzd(paramPackageManager, paramString1);
      AppMethodBeat.o(2487);
      return bool;
    }
    new StringBuilder(String.valueOf(paramString1).length() + 56 + String.valueOf(paramString2).length()).append("Possible malicious package ").append(paramString1).append(" declares ").append(paramString2).append(" without permission");
    AppMethodBeat.o(2487);
    return false;
  }
  
  private final void zzg(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(2491);
      if (this.zzad == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzad = PendingIntent.getBroadcast(this.zzk, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzad);
      AppMethodBeat.o(2491);
      return;
    }
    finally {}
  }
  
  static String zzi(Bundle paramBundle)
  {
    AppMethodBeat.i(2492);
    if (paramBundle == null)
    {
      paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(2492);
      throw paramBundle;
    }
    String str2 = paramBundle.getString("registration_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("unregistered");
    }
    if (str1 == null)
    {
      str1 = paramBundle.getString("error");
      if (str1 != null)
      {
        paramBundle = new IOException(str1);
        AppMethodBeat.o(2492);
        throw paramBundle;
      }
      paramBundle = String.valueOf(paramBundle);
      new StringBuilder(String.valueOf(paramBundle).length() + 29).append("Unexpected response from GCM ").append(paramBundle);
      new Throwable();
      paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(2492);
      throw paramBundle;
    }
    AppMethodBeat.o(2492);
    return str1;
  }
  
  private final Bundle zzj(Bundle paramBundle)
  {
    AppMethodBeat.i(2497);
    Bundle localBundle2 = zzk(paramBundle);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 != null)
    {
      localBundle1 = localBundle2;
      if (localBundle2.containsKey("google.messenger"))
      {
        paramBundle = zzk(paramBundle);
        localBundle1 = paramBundle;
        if (paramBundle != null)
        {
          localBundle1 = paramBundle;
          if (paramBundle.containsKey("google.messenger")) {
            localBundle1 = null;
          }
        }
      }
    }
    AppMethodBeat.o(2497);
    return localBundle1;
  }
  
  /* Error */
  private final Bundle zzk(Bundle arg1)
  {
    // Byte code:
    //   0: sipush 2499
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 83	android/os/ConditionVariable
    //   9: dup
    //   10: invokespecial 233	android/os/ConditionVariable:<init>	()V
    //   13: astore 5
    //   15: invokestatic 237	com/google/android/gms/iid/zzaf:zzv	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: astore_3
    //   25: aload_3
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 76	com/google/android/gms/iid/zzaf:zzcu	Ljava/util/Map;
    //   31: aload 4
    //   33: aload 5
    //   35: invokeinterface 137 3 0
    //   40: pop
    //   41: aload_3
    //   42: monitorexit
    //   43: aload_0
    //   44: getfield 239	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   47: ifnonnull +33 -> 80
    //   50: aload_0
    //   51: getfield 78	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   54: invokestatic 243	com/google/android/gms/iid/zzaf:zzl	(Landroid/content/Context;)Ljava/lang/String;
    //   57: pop
    //   58: aload_0
    //   59: new 88	android/os/Messenger
    //   62: dup
    //   63: new 245	com/google/android/gms/iid/zzag
    //   66: dup
    //   67: aload_0
    //   68: invokestatic 251	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   71: invokespecial 254	com/google/android/gms/iid/zzag:<init>	(Lcom/google/android/gms/iid/zzaf;Landroid/os/Looper;)V
    //   74: invokespecial 257	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   77: putfield 239	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   80: getstatic 53	com/google/android/gms/iid/zzaf:zzcp	Ljava/lang/String;
    //   83: ifnonnull +33 -> 116
    //   86: new 200	java/io/IOException
    //   89: dup
    //   90: ldc_w 259
    //   93: invokespecial 205	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   96: astore_1
    //   97: sipush 2499
    //   100: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_3
    //   107: monitorexit
    //   108: sipush 2499
    //   111: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_1
    //   115: athrow
    //   116: getstatic 55	com/google/android/gms/iid/zzaf:zzcq	Z
    //   119: ifeq +286 -> 405
    //   122: ldc_w 261
    //   125: astore_3
    //   126: new 177	android/content/Intent
    //   129: dup
    //   130: aload_3
    //   131: invokespecial 262	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   134: astore_3
    //   135: aload_3
    //   136: getstatic 53	com/google/android/gms/iid/zzaf:zzcp	Ljava/lang/String;
    //   139: invokevirtual 184	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   142: pop
    //   143: aload_3
    //   144: aload_1
    //   145: invokevirtual 266	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   148: pop
    //   149: aload_0
    //   150: aload_3
    //   151: invokespecial 268	com/google/android/gms/iid/zzaf:zzg	(Landroid/content/Intent;)V
    //   154: aload_3
    //   155: ldc_w 270
    //   158: new 110	java/lang/StringBuilder
    //   161: dup
    //   162: aload 4
    //   164: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 114	java/lang/String:length	()I
    //   170: iconst_5
    //   171: iadd
    //   172: invokespecial 116	java/lang/StringBuilder:<init>	(I)V
    //   175: ldc_w 272
    //   178: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 4
    //   183: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 274
    //   189: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   198: pop
    //   199: aload_3
    //   200: ldc_w 282
    //   203: new 110	java/lang/StringBuilder
    //   206: dup
    //   207: aload 4
    //   209: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokevirtual 114	java/lang/String:length	()I
    //   215: iconst_5
    //   216: iadd
    //   217: invokespecial 116	java/lang/StringBuilder:<init>	(I)V
    //   220: ldc_w 272
    //   223: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 4
    //   228: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 274
    //   234: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   243: pop
    //   244: ldc_w 284
    //   247: getstatic 53	com/google/android/gms/iid/zzaf:zzcp	Ljava/lang/String;
    //   250: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: istore_2
    //   254: aload_3
    //   255: ldc_w 290
    //   258: invokevirtual 293	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +11 -> 274
    //   266: ldc_w 295
    //   269: aload_1
    //   270: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: istore_2
    //   274: ldc_w 297
    //   277: iconst_3
    //   278: invokestatic 303	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   281: ifeq +39 -> 320
    //   284: aload_3
    //   285: invokevirtual 307	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   288: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   291: astore_1
    //   292: new 110	java/lang/StringBuilder
    //   295: dup
    //   296: aload_1
    //   297: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   300: invokevirtual 114	java/lang/String:length	()I
    //   303: bipush 8
    //   305: iadd
    //   306: invokespecial 116	java/lang/StringBuilder:<init>	(I)V
    //   309: ldc_w 309
    //   312: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_1
    //   316: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_0
    //   321: getfield 311	com/google/android/gms/iid/zzaf:zzcv	Landroid/os/Messenger;
    //   324: ifnull +97 -> 421
    //   327: aload_3
    //   328: ldc 228
    //   330: aload_0
    //   331: getfield 239	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   334: invokevirtual 196	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   337: pop
    //   338: invokestatic 94	android/os/Message:obtain	()Landroid/os/Message;
    //   341: astore_1
    //   342: aload_1
    //   343: aload_3
    //   344: putfield 98	android/os/Message:obj	Ljava/lang/Object;
    //   347: aload_0
    //   348: getfield 311	com/google/android/gms/iid/zzaf:zzcv	Landroid/os/Messenger;
    //   351: aload_1
    //   352: invokevirtual 102	android/os/Messenger:send	(Landroid/os/Message;)V
    //   355: aload 5
    //   357: ldc2_w 312
    //   360: invokevirtual 317	android/os/ConditionVariable:block	(J)Z
    //   363: pop
    //   364: aload_0
    //   365: invokevirtual 127	java/lang/Object:getClass	()Ljava/lang/Class;
    //   368: astore_1
    //   369: aload_1
    //   370: monitorenter
    //   371: aload_0
    //   372: getfield 76	com/google/android/gms/iid/zzaf:zzcu	Ljava/util/Map;
    //   375: aload 4
    //   377: invokeinterface 320 2 0
    //   382: astore_3
    //   383: aload_3
    //   384: instanceof 209
    //   387: ifeq +213 -> 600
    //   390: aload_3
    //   391: checkcast 209	android/os/Bundle
    //   394: astore_3
    //   395: aload_1
    //   396: monitorexit
    //   397: sipush 2499
    //   400: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_3
    //   404: areturn
    //   405: ldc_w 322
    //   408: astore_3
    //   409: goto -283 -> 126
    //   412: astore_1
    //   413: ldc_w 297
    //   416: iconst_3
    //   417: invokestatic 303	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   420: pop
    //   421: iload_2
    //   422: ifeq +91 -> 513
    //   425: aload_0
    //   426: monitorenter
    //   427: getstatic 63	com/google/android/gms/iid/zzaf:zzct	Landroid/content/BroadcastReceiver;
    //   430: ifnonnull +59 -> 489
    //   433: new 324	com/google/android/gms/iid/zzah
    //   436: dup
    //   437: aload_0
    //   438: invokespecial 327	com/google/android/gms/iid/zzah:<init>	(Lcom/google/android/gms/iid/zzaf;)V
    //   441: putstatic 63	com/google/android/gms/iid/zzaf:zzct	Landroid/content/BroadcastReceiver;
    //   444: ldc_w 297
    //   447: iconst_3
    //   448: invokestatic 303	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   451: pop
    //   452: new 329	android/content/IntentFilter
    //   455: dup
    //   456: ldc_w 331
    //   459: invokespecial 332	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   462: astore_1
    //   463: aload_1
    //   464: aload_0
    //   465: getfield 78	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   468: invokevirtual 337	android/content/Context:getPackageName	()Ljava/lang/String;
    //   471: invokevirtual 340	android/content/IntentFilter:addCategory	(Ljava/lang/String;)V
    //   474: aload_0
    //   475: getfield 78	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   478: getstatic 63	com/google/android/gms/iid/zzaf:zzct	Landroid/content/BroadcastReceiver;
    //   481: aload_1
    //   482: ldc 159
    //   484: aconst_null
    //   485: invokevirtual 344	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   488: pop
    //   489: aload_0
    //   490: monitorexit
    //   491: aload_0
    //   492: getfield 78	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   495: aload_3
    //   496: invokevirtual 347	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   499: goto -144 -> 355
    //   502: astore_1
    //   503: aload_0
    //   504: monitorexit
    //   505: sipush 2499
    //   508: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: aload_1
    //   512: athrow
    //   513: aload_3
    //   514: ldc 228
    //   516: aload_0
    //   517: getfield 239	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   520: invokevirtual 196	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   523: pop
    //   524: aload_3
    //   525: ldc_w 349
    //   528: ldc_w 295
    //   531: invokevirtual 280	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   534: pop
    //   535: aload_0
    //   536: getfield 351	com/google/android/gms/iid/zzaf:zzcw	Lcom/google/android/gms/iid/MessengerCompat;
    //   539: ifnull +32 -> 571
    //   542: invokestatic 94	android/os/Message:obtain	()Landroid/os/Message;
    //   545: astore_1
    //   546: aload_1
    //   547: aload_3
    //   548: putfield 98	android/os/Message:obj	Ljava/lang/Object;
    //   551: aload_0
    //   552: getfield 351	com/google/android/gms/iid/zzaf:zzcw	Lcom/google/android/gms/iid/MessengerCompat;
    //   555: aload_1
    //   556: invokevirtual 354	com/google/android/gms/iid/MessengerCompat:send	(Landroid/os/Message;)V
    //   559: goto -204 -> 355
    //   562: astore_1
    //   563: ldc_w 297
    //   566: iconst_3
    //   567: invokestatic 303	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   570: pop
    //   571: getstatic 55	com/google/android/gms/iid/zzaf:zzcq	Z
    //   574: ifeq +14 -> 588
    //   577: aload_0
    //   578: getfield 78	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   581: aload_3
    //   582: invokevirtual 347	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   585: goto -230 -> 355
    //   588: aload_0
    //   589: getfield 78	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   592: aload_3
    //   593: invokevirtual 358	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   596: pop
    //   597: goto -242 -> 355
    //   600: aload_3
    //   601: instanceof 104
    //   604: ifeq +34 -> 638
    //   607: new 200	java/io/IOException
    //   610: dup
    //   611: aload_3
    //   612: checkcast 104	java/lang/String
    //   615: invokespecial 205	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   618: astore_3
    //   619: sipush 2499
    //   622: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   625: aload_3
    //   626: athrow
    //   627: astore_3
    //   628: aload_1
    //   629: monitorexit
    //   630: sipush 2499
    //   633: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   636: aload_3
    //   637: athrow
    //   638: aload_3
    //   639: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   642: astore_3
    //   643: new 110	java/lang/StringBuilder
    //   646: dup
    //   647: aload_3
    //   648: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   651: invokevirtual 114	java/lang/String:length	()I
    //   654: bipush 12
    //   656: iadd
    //   657: invokespecial 116	java/lang/StringBuilder:<init>	(I)V
    //   660: ldc_w 360
    //   663: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_3
    //   667: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: new 200	java/io/IOException
    //   674: dup
    //   675: ldc_w 362
    //   678: invokespecial 205	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   681: astore_3
    //   682: sipush 2499
    //   685: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_3
    //   689: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	zzaf
    //   253	169	2	bool	boolean
    //   24	602	3	localObject1	Object
    //   627	12	3	localObject2	Object
    //   642	47	3	localObject3	Object
    //   18	358	4	str	String
    //   13	343	5	localConditionVariable	ConditionVariable
    // Exception table:
    //   from	to	target	type
    //   27	43	105	finally
    //   106	108	105	finally
    //   347	355	412	android/os/RemoteException
    //   427	489	502	finally
    //   489	491	502	finally
    //   503	505	502	finally
    //   551	559	562	android/os/RemoteException
    //   371	397	627	finally
    //   600	627	627	finally
    //   628	630	627	finally
    //   638	690	627	finally
  }
  
  public static boolean zzk(Context paramContext)
  {
    AppMethodBeat.i(2485);
    if (zzcp != null) {
      zzl(paramContext);
    }
    boolean bool = zzcq;
    AppMethodBeat.o(2485);
    return bool;
  }
  
  public static String zzl(Context paramContext)
  {
    AppMethodBeat.i(2486);
    if (zzcp != null)
    {
      paramContext = zzcp;
      AppMethodBeat.o(2486);
      return paramContext;
    }
    zzcr = Process.myUid();
    paramContext = paramContext.getPackageManager();
    if (!PlatformVersion.isAtLeastO())
    {
      localIterator = paramContext.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
      while (localIterator.hasNext()) {
        if (zzd(paramContext, ((ResolveInfo)localIterator.next()).serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
          zzcq = false;
        }
      }
      for (i = 1; i != 0; i = 0)
      {
        paramContext = zzcp;
        AppMethodBeat.o(2486);
        return paramContext;
      }
    }
    Iterator localIterator = paramContext.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
    while (localIterator.hasNext()) {
      if (zzd(paramContext, ((ResolveInfo)localIterator.next()).activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
        zzcq = true;
      }
    }
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = zzcp;
      AppMethodBeat.o(2486);
      return paramContext;
    }
    if (zzd(paramContext, "com.google.android.gms"))
    {
      zzcq = PlatformVersion.isAtLeastO();
      paramContext = zzcp;
      AppMethodBeat.o(2486);
      return paramContext;
    }
    if ((!PlatformVersion.isAtLeastLollipop()) && (zzd(paramContext, "com.google.android.gsf")))
    {
      zzcq = false;
      paramContext = zzcp;
      AppMethodBeat.o(2486);
      return paramContext;
    }
    AppMethodBeat.o(2486);
    return null;
  }
  
  private static int zzm(Context paramContext)
  {
    AppMethodBeat.i(2489);
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(zzl(paramContext), 0).versionCode;
      AppMethodBeat.o(2489);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(2489);
    }
    return -1;
  }
  
  private static String zzv()
  {
    try
    {
      AppMethodBeat.i(2498);
      int i = zzck;
      zzck = i + 1;
      String str = Integer.toString(i);
      AppMethodBeat.o(2498);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final Bundle zzd(Bundle paramBundle, KeyPair paramKeyPair)
  {
    AppMethodBeat.i(2496);
    int i = zzm(this.zzk);
    paramBundle.putString("gmsv", Integer.toString(i));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzk)));
    paramBundle.putString("app_ver_name", InstanceID.zzh(this.zzk));
    paramBundle.putString("cliv", "iid-12451000");
    paramBundle.putString("appid", InstanceID.zzd(paramKeyPair));
    if ((i >= 12000000) && (((Boolean)zzco.get()).booleanValue())) {
      paramKeyPair = new zzr(this.zzk).zzd(1, paramBundle);
    }
    try
    {
      paramKeyPair = (Bundle)Tasks.await(paramKeyPair);
      AppMethodBeat.o(2496);
      return paramKeyPair;
    }
    catch (InterruptedException paramKeyPair)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        String str = String.valueOf(paramKeyPair);
        new StringBuilder(String.valueOf(str).length() + 22).append("Error making request: ").append(str);
      }
      if (((paramKeyPair.getCause() instanceof zzaa)) && (((zzaa)paramKeyPair.getCause()).getErrorCode() == 4))
      {
        paramBundle = zzj(paramBundle);
        AppMethodBeat.o(2496);
        return paramBundle;
      }
      AppMethodBeat.o(2496);
      return null;
      paramBundle = zzj(paramBundle);
      AppMethodBeat.o(2496);
      return paramBundle;
    }
    catch (ExecutionException paramKeyPair)
    {
      label148:
      break label148;
    }
  }
  
  public final void zze(Message paramMessage)
  {
    AppMethodBeat.i(2490);
    if (paramMessage == null)
    {
      AppMethodBeat.o(2490);
      return;
    }
    if ((paramMessage.obj instanceof Intent))
    {
      Object localObject = (Intent)paramMessage.obj;
      ((Intent)localObject).setExtrasClassLoader(MessengerCompat.class.getClassLoader());
      if (((Intent)localObject).hasExtra("google.messenger"))
      {
        localObject = ((Intent)localObject).getParcelableExtra("google.messenger");
        if ((localObject instanceof MessengerCompat)) {
          this.zzcw = ((MessengerCompat)localObject);
        }
        if ((localObject instanceof Messenger)) {
          this.zzcv = ((Messenger)localObject);
        }
      }
      zzh((Intent)paramMessage.obj);
      AppMethodBeat.o(2490);
      return;
    }
    AppMethodBeat.o(2490);
  }
  
  public final void zzh(Intent arg1)
  {
    AppMethodBeat.i(2495);
    if (??? == null)
    {
      Log.isLoggable("InstanceID", 3);
      AppMethodBeat.o(2495);
      return;
    }
    Object localObject1 = ???.getAction();
    if ((!"com.google.android.c2dm.intent.REGISTRATION".equals(localObject1)) && (!"com.google.android.gms.iid.InstanceID".equals(localObject1)))
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        ??? = String.valueOf(???.getAction());
        if (???.length() != 0)
        {
          "Unexpected response ".concat(???);
          AppMethodBeat.o(2495);
          return;
        }
        new String("Unexpected response ");
      }
      AppMethodBeat.o(2495);
      return;
    }
    Object localObject3 = ???.getStringExtra("registration_id");
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = ???.getStringExtra("unregistered");
    }
    if (localObject1 == null)
    {
      Object localObject4 = ???.getStringExtra("error");
      if (localObject4 == null)
      {
        ??? = String.valueOf(???.getExtras());
        new StringBuilder(String.valueOf(???).length() + 49).append("Unexpected response, no error or registration id ").append(???);
        AppMethodBeat.o(2495);
        return;
      }
      String str2;
      if (Log.isLoggable("InstanceID", 3))
      {
        localObject1 = String.valueOf(localObject4);
        if (((String)localObject1).length() != 0) {
          "Received InstanceID error ".concat((String)localObject1);
        }
      }
      else
      {
        localObject3 = null;
        str2 = null;
        localObject1 = localObject4;
        if (((String)localObject4).startsWith("|"))
        {
          localObject1 = ((String)localObject4).split("\\|");
          if (!"ID".equals(localObject1[1]))
          {
            localObject3 = String.valueOf(localObject4);
            if (((String)localObject3).length() == 0) {
              break label437;
            }
            "Unexpected structured response ".concat((String)localObject3);
          }
          label280:
          if (localObject1.length <= 2) {
            break label451;
          }
          str2 = localObject1[2];
          localObject4 = localObject1[3];
          localObject3 = str2;
          localObject1 = localObject4;
          if (((String)localObject4).startsWith(":")) {
            localObject1 = ((String)localObject4).substring(1);
          }
        }
      }
      for (localObject3 = str2;; localObject3 = str2)
      {
        ???.putExtra("error", (String)localObject1);
        if (localObject3 != null) {
          break label470;
        }
        synchronized (getClass())
        {
          localObject3 = this.zzcu.keySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label461;
          }
          str2 = (String)((Iterator)localObject3).next();
          localObject4 = this.zzcu.get(str2);
          this.zzcu.put(str2, localObject1);
          zzd(localObject4, localObject1);
        }
        new String("Received InstanceID error ");
        break;
        label437:
        new String("Unexpected structured response ");
        break label280;
        label451:
        str1 = "UNKNOWN";
      }
      label461:
      AppMethodBeat.o(2495);
      return;
      label470:
      zzd((String)localObject3, str1);
      AppMethodBeat.o(2495);
      return;
    }
    localObject3 = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(str1);
    if (!((Matcher)localObject3).matches())
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        ??? = String.valueOf(str1);
        if (???.length() != 0)
        {
          "Unexpected response string: ".concat(???);
          AppMethodBeat.o(2495);
          return;
        }
        new String("Unexpected response string: ");
      }
      AppMethodBeat.o(2495);
      return;
    }
    String str1 = ((Matcher)localObject3).group(1);
    localObject3 = ((Matcher)localObject3).group(2);
    ??? = ???.getExtras();
    ???.putString("registration_id", (String)localObject3);
    zzd(str1, ???);
    AppMethodBeat.o(2495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.zzaf
 * JD-Core Version:    0.7.0.1
 */