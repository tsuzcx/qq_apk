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
    AppMethodBeat.i(57546);
    zzco = zzai.zzw().zzd("gcm_iid_use_messenger_ipc", true);
    zzcp = null;
    zzcq = false;
    zzcr = 0;
    zzcs = 0;
    zzck = 0;
    zzct = null;
    AppMethodBeat.o(57546);
  }
  
  public zzaf(Context paramContext)
  {
    AppMethodBeat.i(57530);
    this.zzcu = new a();
    this.zzk = paramContext;
    AppMethodBeat.o(57530);
  }
  
  private static void zzd(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(57540);
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
        AppMethodBeat.o(57540);
        return;
      }
      catch (RemoteException paramObject1)
      {
        paramObject1 = String.valueOf(paramObject1);
        new StringBuilder(String.valueOf(paramObject1).length() + 24).append("Failed to send response ").append(paramObject1);
      }
    }
    AppMethodBeat.o(57540);
  }
  
  private final void zzd(String paramString, Object paramObject)
  {
    AppMethodBeat.i(57539);
    synchronized (getClass())
    {
      Object localObject = this.zzcu.get(paramString);
      this.zzcu.put(paramString, paramObject);
      zzd(localObject, paramObject);
      AppMethodBeat.o(57539);
      return;
    }
  }
  
  private static boolean zzd(PackageManager paramPackageManager, String paramString)
  {
    AppMethodBeat.i(57534);
    try
    {
      paramPackageManager = paramPackageManager.getApplicationInfo(paramString, 0);
      zzcp = paramPackageManager.packageName;
      zzcs = paramPackageManager.uid;
      AppMethodBeat.o(57534);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      AppMethodBeat.o(57534);
    }
    return false;
  }
  
  private static boolean zzd(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(57533);
    if (paramPackageManager.checkPermission("com.google.android.c2dm.permission.SEND", paramString1) == 0)
    {
      boolean bool = zzd(paramPackageManager, paramString1);
      AppMethodBeat.o(57533);
      return bool;
    }
    new StringBuilder(String.valueOf(paramString1).length() + 56 + String.valueOf(paramString2).length()).append("Possible malicious package ").append(paramString1).append(" declares ").append(paramString2).append(" without permission");
    AppMethodBeat.o(57533);
    return false;
  }
  
  private final void zzg(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(57537);
      if (this.zzad == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzad = PendingIntent.getBroadcast(this.zzk, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzad);
      AppMethodBeat.o(57537);
      return;
    }
    finally {}
  }
  
  static String zzi(Bundle paramBundle)
  {
    AppMethodBeat.i(57538);
    if (paramBundle == null)
    {
      paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(57538);
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
        AppMethodBeat.o(57538);
        throw paramBundle;
      }
      paramBundle = String.valueOf(paramBundle);
      new StringBuilder(String.valueOf(paramBundle).length() + 29).append("Unexpected response from GCM ").append(paramBundle);
      new Throwable();
      paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(57538);
      throw paramBundle;
    }
    AppMethodBeat.o(57538);
    return str1;
  }
  
  private final Bundle zzj(Bundle paramBundle)
  {
    AppMethodBeat.i(57543);
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
    AppMethodBeat.o(57543);
    return localBundle1;
  }
  
  /* Error */
  private final Bundle zzk(Bundle arg1)
  {
    // Byte code:
    //   0: ldc 242
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 86	android/os/ConditionVariable
    //   8: dup
    //   9: invokespecial 243	android/os/ConditionVariable:<init>	()V
    //   12: astore 5
    //   14: invokestatic 247	com/google/android/gms/iid/zzaf:zzv	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload_0
    //   20: invokevirtual 131	java/lang/Object:getClass	()Ljava/lang/Class;
    //   23: astore_3
    //   24: aload_3
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 78	com/google/android/gms/iid/zzaf:zzcu	Ljava/util/Map;
    //   30: aload 4
    //   32: aload 5
    //   34: invokeinterface 141 3 0
    //   39: pop
    //   40: aload_3
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 249	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   46: ifnonnull +33 -> 79
    //   49: aload_0
    //   50: getfield 80	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   53: invokestatic 253	com/google/android/gms/iid/zzaf:zzl	(Landroid/content/Context;)Ljava/lang/String;
    //   56: pop
    //   57: aload_0
    //   58: new 91	android/os/Messenger
    //   61: dup
    //   62: new 255	com/google/android/gms/iid/zzag
    //   65: dup
    //   66: aload_0
    //   67: invokestatic 261	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   70: invokespecial 264	com/google/android/gms/iid/zzag:<init>	(Lcom/google/android/gms/iid/zzaf;Landroid/os/Looper;)V
    //   73: invokespecial 267	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   76: putfield 249	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   79: getstatic 54	com/google/android/gms/iid/zzaf:zzcp	Ljava/lang/String;
    //   82: ifnonnull +31 -> 113
    //   85: new 208	java/io/IOException
    //   88: dup
    //   89: ldc_w 269
    //   92: invokespecial 213	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   95: astore_1
    //   96: ldc 242
    //   98: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_3
    //   105: monitorexit
    //   106: ldc 242
    //   108: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: athrow
    //   113: getstatic 56	com/google/android/gms/iid/zzaf:zzcq	Z
    //   116: ifeq +285 -> 401
    //   119: ldc_w 271
    //   122: astore_3
    //   123: new 184	android/content/Intent
    //   126: dup
    //   127: aload_3
    //   128: invokespecial 272	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   131: astore_3
    //   132: aload_3
    //   133: getstatic 54	com/google/android/gms/iid/zzaf:zzcp	Ljava/lang/String;
    //   136: invokevirtual 191	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   139: pop
    //   140: aload_3
    //   141: aload_1
    //   142: invokevirtual 276	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   145: pop
    //   146: aload_0
    //   147: aload_3
    //   148: invokespecial 278	com/google/android/gms/iid/zzaf:zzg	(Landroid/content/Intent;)V
    //   151: aload_3
    //   152: ldc_w 280
    //   155: new 113	java/lang/StringBuilder
    //   158: dup
    //   159: aload 4
    //   161: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   164: invokevirtual 117	java/lang/String:length	()I
    //   167: iconst_5
    //   168: iadd
    //   169: invokespecial 119	java/lang/StringBuilder:<init>	(I)V
    //   172: ldc_w 282
    //   175: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 4
    //   180: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 284
    //   186: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokevirtual 290	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   195: pop
    //   196: aload_3
    //   197: ldc_w 292
    //   200: new 113	java/lang/StringBuilder
    //   203: dup
    //   204: aload 4
    //   206: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokevirtual 117	java/lang/String:length	()I
    //   212: iconst_5
    //   213: iadd
    //   214: invokespecial 119	java/lang/StringBuilder:<init>	(I)V
    //   217: ldc_w 282
    //   220: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 4
    //   225: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 284
    //   231: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokevirtual 290	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   240: pop
    //   241: ldc_w 294
    //   244: getstatic 54	com/google/android/gms/iid/zzaf:zzcp	Ljava/lang/String;
    //   247: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: istore_2
    //   251: aload_3
    //   252: ldc_w 300
    //   255: invokevirtual 303	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_1
    //   259: aload_1
    //   260: ifnull +11 -> 271
    //   263: ldc_w 305
    //   266: aload_1
    //   267: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   270: istore_2
    //   271: ldc_w 307
    //   274: iconst_3
    //   275: invokestatic 313	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   278: ifeq +39 -> 317
    //   281: aload_3
    //   282: invokevirtual 317	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   285: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   288: astore_1
    //   289: new 113	java/lang/StringBuilder
    //   292: dup
    //   293: aload_1
    //   294: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   297: invokevirtual 117	java/lang/String:length	()I
    //   300: bipush 8
    //   302: iadd
    //   303: invokespecial 119	java/lang/StringBuilder:<init>	(I)V
    //   306: ldc_w 319
    //   309: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_1
    //   313: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_0
    //   318: getfield 321	com/google/android/gms/iid/zzaf:zzcv	Landroid/os/Messenger;
    //   321: ifnull +96 -> 417
    //   324: aload_3
    //   325: ldc 237
    //   327: aload_0
    //   328: getfield 249	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   331: invokevirtual 203	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   334: pop
    //   335: invokestatic 97	android/os/Message:obtain	()Landroid/os/Message;
    //   338: astore_1
    //   339: aload_1
    //   340: aload_3
    //   341: putfield 101	android/os/Message:obj	Ljava/lang/Object;
    //   344: aload_0
    //   345: getfield 321	com/google/android/gms/iid/zzaf:zzcv	Landroid/os/Messenger;
    //   348: aload_1
    //   349: invokevirtual 105	android/os/Messenger:send	(Landroid/os/Message;)V
    //   352: aload 5
    //   354: ldc2_w 322
    //   357: invokevirtual 327	android/os/ConditionVariable:block	(J)Z
    //   360: pop
    //   361: aload_0
    //   362: invokevirtual 131	java/lang/Object:getClass	()Ljava/lang/Class;
    //   365: astore_1
    //   366: aload_1
    //   367: monitorenter
    //   368: aload_0
    //   369: getfield 78	com/google/android/gms/iid/zzaf:zzcu	Ljava/util/Map;
    //   372: aload 4
    //   374: invokeinterface 330 2 0
    //   379: astore_3
    //   380: aload_3
    //   381: instanceof 217
    //   384: ifeq +211 -> 595
    //   387: aload_3
    //   388: checkcast 217	android/os/Bundle
    //   391: astore_3
    //   392: aload_1
    //   393: monitorexit
    //   394: ldc 242
    //   396: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload_3
    //   400: areturn
    //   401: ldc_w 332
    //   404: astore_3
    //   405: goto -282 -> 123
    //   408: astore_1
    //   409: ldc_w 307
    //   412: iconst_3
    //   413: invokestatic 313	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   416: pop
    //   417: iload_2
    //   418: ifeq +90 -> 508
    //   421: aload_0
    //   422: monitorenter
    //   423: getstatic 64	com/google/android/gms/iid/zzaf:zzct	Landroid/content/BroadcastReceiver;
    //   426: ifnonnull +59 -> 485
    //   429: new 334	com/google/android/gms/iid/zzah
    //   432: dup
    //   433: aload_0
    //   434: invokespecial 337	com/google/android/gms/iid/zzah:<init>	(Lcom/google/android/gms/iid/zzaf;)V
    //   437: putstatic 64	com/google/android/gms/iid/zzaf:zzct	Landroid/content/BroadcastReceiver;
    //   440: ldc_w 307
    //   443: iconst_3
    //   444: invokestatic 313	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   447: pop
    //   448: new 339	android/content/IntentFilter
    //   451: dup
    //   452: ldc_w 341
    //   455: invokespecial 342	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   458: astore_1
    //   459: aload_1
    //   460: aload_0
    //   461: getfield 80	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   464: invokevirtual 347	android/content/Context:getPackageName	()Ljava/lang/String;
    //   467: invokevirtual 350	android/content/IntentFilter:addCategory	(Ljava/lang/String;)V
    //   470: aload_0
    //   471: getfield 80	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   474: getstatic 64	com/google/android/gms/iid/zzaf:zzct	Landroid/content/BroadcastReceiver;
    //   477: aload_1
    //   478: ldc 165
    //   480: aconst_null
    //   481: invokevirtual 354	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   484: pop
    //   485: aload_0
    //   486: monitorexit
    //   487: aload_0
    //   488: getfield 80	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   491: aload_3
    //   492: invokevirtual 357	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   495: goto -143 -> 352
    //   498: astore_1
    //   499: aload_0
    //   500: monitorexit
    //   501: ldc 242
    //   503: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: aload_1
    //   507: athrow
    //   508: aload_3
    //   509: ldc 237
    //   511: aload_0
    //   512: getfield 249	com/google/android/gms/iid/zzaf:zzah	Landroid/os/Messenger;
    //   515: invokevirtual 203	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   518: pop
    //   519: aload_3
    //   520: ldc_w 359
    //   523: ldc_w 305
    //   526: invokevirtual 290	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   529: pop
    //   530: aload_0
    //   531: getfield 361	com/google/android/gms/iid/zzaf:zzcw	Lcom/google/android/gms/iid/MessengerCompat;
    //   534: ifnull +32 -> 566
    //   537: invokestatic 97	android/os/Message:obtain	()Landroid/os/Message;
    //   540: astore_1
    //   541: aload_1
    //   542: aload_3
    //   543: putfield 101	android/os/Message:obj	Ljava/lang/Object;
    //   546: aload_0
    //   547: getfield 361	com/google/android/gms/iid/zzaf:zzcw	Lcom/google/android/gms/iid/MessengerCompat;
    //   550: aload_1
    //   551: invokevirtual 364	com/google/android/gms/iid/MessengerCompat:send	(Landroid/os/Message;)V
    //   554: goto -202 -> 352
    //   557: astore_1
    //   558: ldc_w 307
    //   561: iconst_3
    //   562: invokestatic 313	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   565: pop
    //   566: getstatic 56	com/google/android/gms/iid/zzaf:zzcq	Z
    //   569: ifeq +14 -> 583
    //   572: aload_0
    //   573: getfield 80	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   576: aload_3
    //   577: invokevirtual 357	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   580: goto -228 -> 352
    //   583: aload_0
    //   584: getfield 80	com/google/android/gms/iid/zzaf:zzk	Landroid/content/Context;
    //   587: aload_3
    //   588: invokevirtual 368	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   591: pop
    //   592: goto -240 -> 352
    //   595: aload_3
    //   596: instanceof 107
    //   599: ifeq +32 -> 631
    //   602: new 208	java/io/IOException
    //   605: dup
    //   606: aload_3
    //   607: checkcast 107	java/lang/String
    //   610: invokespecial 213	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   613: astore_3
    //   614: ldc 242
    //   616: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: aload_3
    //   620: athrow
    //   621: astore_3
    //   622: aload_1
    //   623: monitorexit
    //   624: ldc 242
    //   626: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: aload_3
    //   630: athrow
    //   631: aload_3
    //   632: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   635: astore_3
    //   636: new 113	java/lang/StringBuilder
    //   639: dup
    //   640: aload_3
    //   641: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   644: invokevirtual 117	java/lang/String:length	()I
    //   647: bipush 12
    //   649: iadd
    //   650: invokespecial 119	java/lang/StringBuilder:<init>	(I)V
    //   653: ldc_w 370
    //   656: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_3
    //   660: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: new 208	java/io/IOException
    //   667: dup
    //   668: ldc_w 372
    //   671: invokespecial 213	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   674: astore_3
    //   675: ldc 242
    //   677: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   680: aload_3
    //   681: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	zzaf
    //   250	168	2	bool	boolean
    //   23	597	3	localObject1	Object
    //   621	11	3	localObject2	Object
    //   635	46	3	localObject3	Object
    //   17	356	4	str	String
    //   12	341	5	localConditionVariable	ConditionVariable
    // Exception table:
    //   from	to	target	type
    //   26	42	103	finally
    //   104	106	103	finally
    //   344	352	408	android/os/RemoteException
    //   423	485	498	finally
    //   485	487	498	finally
    //   499	501	498	finally
    //   546	554	557	android/os/RemoteException
    //   368	394	621	finally
    //   595	621	621	finally
    //   622	624	621	finally
    //   631	682	621	finally
  }
  
  public static boolean zzk(Context paramContext)
  {
    AppMethodBeat.i(57531);
    if (zzcp != null) {
      zzl(paramContext);
    }
    boolean bool = zzcq;
    AppMethodBeat.o(57531);
    return bool;
  }
  
  public static String zzl(Context paramContext)
  {
    AppMethodBeat.i(57532);
    if (zzcp != null)
    {
      paramContext = zzcp;
      AppMethodBeat.o(57532);
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
        AppMethodBeat.o(57532);
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
      AppMethodBeat.o(57532);
      return paramContext;
    }
    if (zzd(paramContext, "com.google.android.gms"))
    {
      zzcq = PlatformVersion.isAtLeastO();
      paramContext = zzcp;
      AppMethodBeat.o(57532);
      return paramContext;
    }
    if ((!PlatformVersion.isAtLeastLollipop()) && (zzd(paramContext, "com.google.android.gsf")))
    {
      zzcq = false;
      paramContext = zzcp;
      AppMethodBeat.o(57532);
      return paramContext;
    }
    AppMethodBeat.o(57532);
    return null;
  }
  
  private static int zzm(Context paramContext)
  {
    AppMethodBeat.i(57535);
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(zzl(paramContext), 0).versionCode;
      AppMethodBeat.o(57535);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(57535);
    }
    return -1;
  }
  
  private static String zzv()
  {
    try
    {
      AppMethodBeat.i(57544);
      int i = zzck;
      zzck = i + 1;
      String str = Integer.toString(i);
      AppMethodBeat.o(57544);
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
    AppMethodBeat.i(57542);
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
      AppMethodBeat.o(57542);
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
        AppMethodBeat.o(57542);
        return paramBundle;
      }
      AppMethodBeat.o(57542);
      return null;
      paramBundle = zzj(paramBundle);
      AppMethodBeat.o(57542);
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
    AppMethodBeat.i(57536);
    if (paramMessage == null)
    {
      AppMethodBeat.o(57536);
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
      AppMethodBeat.o(57536);
      return;
    }
    AppMethodBeat.o(57536);
  }
  
  public final void zzh(Intent arg1)
  {
    AppMethodBeat.i(57541);
    if (??? == null)
    {
      Log.isLoggable("InstanceID", 3);
      AppMethodBeat.o(57541);
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
          AppMethodBeat.o(57541);
          return;
        }
        new String("Unexpected response ");
      }
      AppMethodBeat.o(57541);
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
        AppMethodBeat.o(57541);
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
      AppMethodBeat.o(57541);
      return;
      label470:
      zzd((String)localObject3, str1);
      AppMethodBeat.o(57541);
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
          AppMethodBeat.o(57541);
          return;
        }
        new String("Unexpected response string: ");
      }
      AppMethodBeat.o(57541);
      return;
    }
    String str1 = ((Matcher)localObject3).group(1);
    localObject3 = ((Matcher)localObject3).group(2);
    ??? = ???.getExtras();
    ???.putString("registration_id", (String)localObject3);
    zzd(str1, ???);
    AppMethodBeat.o(57541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.iid.zzaf
 * JD-Core Version:    0.7.0.1
 */