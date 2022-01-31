package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.e.a;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaf;
import com.google.android.gms.iid.zzak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class GoogleCloudMessaging
{
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String INSTANCE_ID_SCOPE = "GCM";
  @Deprecated
  public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
  @Deprecated
  public static final String MESSAGE_TYPE_MESSAGE = "gcm";
  @Deprecated
  public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
  @Deprecated
  public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
  private static GoogleCloudMessaging zzac;
  private static final AtomicInteger zzaf;
  private PendingIntent zzad;
  private final Map<String, Handler> zzae;
  private final BlockingQueue<Intent> zzag;
  private final Messenger zzah;
  private Context zzk;
  
  static
  {
    AppMethodBeat.i(69976);
    zzaf = new AtomicInteger(1);
    AppMethodBeat.o(69976);
  }
  
  public GoogleCloudMessaging()
  {
    AppMethodBeat.i(69962);
    this.zzae = Collections.synchronizedMap(new a());
    this.zzag = new LinkedBlockingQueue();
    this.zzah = new Messenger(new zzf(this, Looper.getMainLooper()));
    AppMethodBeat.o(69962);
  }
  
  @Deprecated
  public static GoogleCloudMessaging getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(69960);
      if (zzac == null)
      {
        zze(paramContext);
        GoogleCloudMessaging localGoogleCloudMessaging = new GoogleCloudMessaging();
        zzac = localGoogleCloudMessaging;
        localGoogleCloudMessaging.zzk = paramContext.getApplicationContext();
      }
      paramContext = zzac;
      AppMethodBeat.o(69960);
      return paramContext;
    }
    finally {}
  }
  
  @Deprecated
  private final Intent zzd(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(69970);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramBundle = new IOException("MAIN_THREAD");
      AppMethodBeat.o(69970);
      throw paramBundle;
    }
    if (zzf(this.zzk) < 0)
    {
      paramBundle = new IOException("Google Play Services missing");
      AppMethodBeat.o(69970);
      throw paramBundle;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = "com.google.iid.TOKEN_REQUEST";
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setPackage(zzaf.zzl(this.zzk));
      zze((Intent)localObject);
      int i = zzaf.getAndIncrement();
      ((Intent)localObject).putExtra("google.message_id", 21 + "google.rpc" + i);
      ((Intent)localObject).putExtras(paramBundle);
      ((Intent)localObject).putExtra("google.messenger", this.zzah);
      if (!paramBoolean) {
        break label197;
      }
      this.zzk.sendBroadcast((Intent)localObject);
    }
    for (;;)
    {
      try
      {
        paramBundle = (Intent)this.zzag.poll(30000L, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(69970);
        return paramBundle;
      }
      catch (InterruptedException paramBundle)
      {
        label197:
        paramBundle = new IOException(paramBundle.getMessage());
        AppMethodBeat.o(69970);
        throw paramBundle;
      }
      localObject = "com.google.android.c2dm.intent.REGISTER";
      break;
      this.zzk.startService((Intent)localObject);
    }
  }
  
  @Deprecated
  @VisibleForTesting
  private final String zzd(boolean paramBoolean, String... paramVarArgs)
  {
    Object localObject1;
    try
    {
      AppMethodBeat.i(69969);
      localObject1 = zzaf.zzl(this.zzk);
      if (localObject1 == null)
      {
        paramVarArgs = new IOException("SERVICE_NOT_AVAILABLE");
        AppMethodBeat.o(69969);
        throw paramVarArgs;
      }
    }
    finally {}
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = new IllegalArgumentException("No senderIds");
      AppMethodBeat.o(69969);
      throw paramVarArgs;
    }
    Object localObject2 = new StringBuilder(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      ((StringBuilder)localObject2).append(',').append(paramVarArgs[i]);
      i += 1;
    }
    paramVarArgs = ((StringBuilder)localObject2).toString();
    localObject2 = new Bundle();
    if (((String)localObject1).contains(".gsf"))
    {
      ((Bundle)localObject2).putString("legacy.sender", paramVarArgs);
      paramVarArgs = InstanceID.getInstance(this.zzk).getToken(paramVarArgs, "GCM", (Bundle)localObject2);
      AppMethodBeat.o(69969);
    }
    for (;;)
    {
      return paramVarArgs;
      ((Bundle)localObject2).putString("sender", paramVarArgs);
      localObject1 = zzd((Bundle)localObject2, paramBoolean);
      if (localObject1 == null)
      {
        paramVarArgs = new IOException("SERVICE_NOT_AVAILABLE");
        AppMethodBeat.o(69969);
        throw paramVarArgs;
      }
      paramVarArgs = ((Intent)localObject1).getStringExtra("registration_id");
      if (paramVarArgs == null) {
        break;
      }
      AppMethodBeat.o(69969);
    }
    paramVarArgs = ((Intent)localObject1).getStringExtra("error");
    if (paramVarArgs != null)
    {
      paramVarArgs = new IOException(paramVarArgs);
      AppMethodBeat.o(69969);
      throw paramVarArgs;
    }
    paramVarArgs = new IOException("SERVICE_NOT_AVAILABLE");
    AppMethodBeat.o(69969);
    throw paramVarArgs;
  }
  
  private final boolean zzd(Intent paramIntent)
  {
    AppMethodBeat.i(69966);
    Object localObject2 = paramIntent.getStringExtra("In-Reply-To");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramIntent.hasExtra("error")) {
        localObject1 = paramIntent.getStringExtra("google.message_id");
      }
    }
    if (localObject1 != null)
    {
      localObject1 = (Handler)this.zzae.remove(localObject1);
      if (localObject1 != null)
      {
        localObject2 = Message.obtain();
        ((Message)localObject2).obj = paramIntent;
        boolean bool = ((Handler)localObject1).sendMessage((Message)localObject2);
        AppMethodBeat.o(69966);
        return bool;
      }
    }
    AppMethodBeat.o(69966);
    return false;
  }
  
  static void zze(Context paramContext)
  {
    AppMethodBeat.i(69961);
    paramContext = paramContext.getPackageName();
    new StringBuilder(String.valueOf(paramContext).length() + 48).append("GCM SDK is deprecated, ").append(paramContext).append(" should update to use FCM");
    AppMethodBeat.o(69961);
  }
  
  private final void zze(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(69972);
      if (this.zzad == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzad = PendingIntent.getBroadcast(this.zzk, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzad);
      AppMethodBeat.o(69972);
      return;
    }
    finally {}
  }
  
  public static int zzf(Context paramContext)
  {
    AppMethodBeat.i(69974);
    String str = zzaf.zzl(paramContext);
    if (str != null) {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
        if (paramContext != null)
        {
          int i = paramContext.versionCode;
          AppMethodBeat.o(69974);
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    AppMethodBeat.o(69974);
    return -1;
  }
  
  private final void zzg()
  {
    try
    {
      AppMethodBeat.i(69973);
      if (this.zzad != null)
      {
        this.zzad.cancel();
        this.zzad = null;
      }
      AppMethodBeat.o(69973);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void close()
  {
    AppMethodBeat.i(69963);
    zzac = null;
    zzd.zzj = null;
    zzg();
    AppMethodBeat.o(69963);
  }
  
  @Deprecated
  public String getMessageType(Intent paramIntent)
  {
    AppMethodBeat.i(69971);
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))
    {
      AppMethodBeat.o(69971);
      return null;
    }
    paramIntent = paramIntent.getStringExtra("message_type");
    if (paramIntent != null)
    {
      AppMethodBeat.o(69971);
      return paramIntent;
    }
    AppMethodBeat.o(69971);
    return "gcm";
  }
  
  @Deprecated
  public String register(String... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(69968);
      paramVarArgs = zzd(zzaf.zzk(this.zzk), paramVarArgs);
      AppMethodBeat.o(69968);
      return paramVarArgs;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
  
  @Deprecated
  public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(69965);
    if (paramString1 == null)
    {
      paramString1 = new IllegalArgumentException("Missing 'to'");
      AppMethodBeat.o(69965);
      throw paramString1;
    }
    Object localObject1 = zzaf.zzl(this.zzk);
    if (localObject1 == null)
    {
      paramString1 = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(69965);
      throw paramString1;
    }
    Object localObject2 = new Intent("com.google.android.gcm.intent.SEND");
    if (paramBundle != null) {
      ((Intent)localObject2).putExtras(paramBundle);
    }
    zze((Intent)localObject2);
    ((Intent)localObject2).setPackage((String)localObject1);
    ((Intent)localObject2).putExtra("google.to", paramString1);
    ((Intent)localObject2).putExtra("google.message_id", paramString2);
    ((Intent)localObject2).putExtra("google.ttl", Long.toString(paramLong));
    int i = paramString1.indexOf('@');
    if (i > 0) {}
    for (String str = paramString1.substring(0, i);; str = paramString1)
    {
      InstanceID.getInstance(this.zzk);
      ((Intent)localObject2).putExtra("google.from", InstanceID.zzn().zze("", str, "GCM"));
      if (((String)localObject1).contains(".gsf"))
      {
        localObject1 = new Bundle();
        localObject2 = paramBundle.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          Object localObject3 = paramBundle.get(str);
          if ((localObject3 instanceof String))
          {
            str = String.valueOf(str);
            if (str.length() != 0) {}
            for (str = "gcm.".concat(str);; str = new String("gcm."))
            {
              ((Bundle)localObject1).putString(str, (String)localObject3);
              break;
            }
          }
        }
        ((Bundle)localObject1).putString("google.to", paramString1);
        ((Bundle)localObject1).putString("google.message_id", paramString2);
        InstanceID.getInstance(this.zzk).zze("GCM", "upstream", (Bundle)localObject1);
        AppMethodBeat.o(69965);
        return;
      }
      this.zzk.sendOrderedBroadcast((Intent)localObject2, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
      AppMethodBeat.o(69965);
      return;
    }
  }
  
  @Deprecated
  public void send(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(69964);
    send(paramString1, paramString2, -1L, paramBundle);
    AppMethodBeat.o(69964);
  }
  
  @Deprecated
  public void unregister()
  {
    try
    {
      AppMethodBeat.i(69967);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        IOException localIOException = new IOException("MAIN_THREAD");
        AppMethodBeat.o(69967);
        throw localIOException;
      }
    }
    finally {}
    InstanceID.getInstance(this.zzk).deleteInstanceID();
    AppMethodBeat.o(69967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging
 * JD-Core Version:    0.7.0.1
 */