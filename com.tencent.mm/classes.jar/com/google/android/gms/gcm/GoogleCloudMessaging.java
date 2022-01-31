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
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import com.google.android.gms.iid.zzd;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
  public static int zzbgB = 5000000;
  public static int zzbgC = 6500000;
  public static int zzbgD = 7000000;
  static GoogleCloudMessaging zzbgE;
  private static final AtomicInteger zzbgH = new AtomicInteger(1);
  private PendingIntent zzbgF;
  private Map<String, Handler> zzbgG = Collections.synchronizedMap(new HashMap());
  private final BlockingQueue<Intent> zzbgI = new LinkedBlockingQueue();
  final Messenger zzbgJ = new Messenger(new GoogleCloudMessaging.1(this, Looper.getMainLooper()));
  private Context zzqn;
  
  public static GoogleCloudMessaging getInstance(Context paramContext)
  {
    try
    {
      if (zzbgE == null)
      {
        GoogleCloudMessaging localGoogleCloudMessaging = new GoogleCloudMessaging();
        zzbgE = localGoogleCloudMessaging;
        localGoogleCloudMessaging.zzqn = paramContext.getApplicationContext();
      }
      paramContext = zzbgE;
      return paramContext;
    }
    finally {}
  }
  
  private String zzGR()
  {
    String str1 = String.valueOf("google.rpc");
    String str2 = String.valueOf(String.valueOf(zzbgH.getAndIncrement()));
    if (str2.length() != 0) {
      return str1.concat(str2);
    }
    return new String(str1);
  }
  
  static String zza(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    paramString = paramIntent.getStringExtra(paramString);
    if (paramString != null) {
      return paramString;
    }
    paramIntent = paramIntent.getStringExtra("error");
    if (paramIntent != null) {
      throw new IOException(paramIntent);
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  private void zza(String paramString1, String paramString2, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Missing 'to'");
    }
    String str = zzbv(this.zzqn);
    if (str == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    Object localObject1 = new Intent("com.google.android.gcm.intent.SEND");
    if (paramBundle != null) {
      ((Intent)localObject1).putExtras(paramBundle);
    }
    zzr((Intent)localObject1);
    ((Intent)localObject1).setPackage(str);
    ((Intent)localObject1).putExtra("google.to", paramString1);
    ((Intent)localObject1).putExtra("google.message_id", paramString2);
    ((Intent)localObject1).putExtra("google.ttl", Long.toString(paramLong));
    ((Intent)localObject1).putExtra("google.delay", Integer.toString(paramInt));
    ((Intent)localObject1).putExtra("google.from", zzeE(paramString1));
    if (str.contains(".gsf"))
    {
      localObject1 = new Bundle();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        Object localObject2 = paramBundle.get(str);
        if ((localObject2 instanceof String))
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "gcm.".concat(str);; str = new String("gcm."))
          {
            ((Bundle)localObject1).putString(str, (String)localObject2);
            break;
          }
        }
      }
      ((Bundle)localObject1).putString("google.to", paramString1);
      ((Bundle)localObject1).putString("google.message_id", paramString2);
      InstanceID.getInstance(this.zzqn).zzc("GCM", "upstream", (Bundle)localObject1);
      return;
    }
    this.zzqn.sendOrderedBroadcast((Intent)localObject1, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
  }
  
  public static String zzbv(Context paramContext)
  {
    return zzc.zzbA(paramContext);
  }
  
  public static int zzbw(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = zzbv(paramContext);
    if (paramContext != null) {
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext, 0);
        if (paramContext != null)
        {
          int i = paramContext.versionCode;
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return -1;
  }
  
  private String zzeE(String paramString)
  {
    int i = paramString.indexOf('@');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    return InstanceID.getInstance(this.zzqn).zzHi().zzh("", str, "GCM");
  }
  
  private boolean zzq(Intent paramIntent)
  {
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
      localObject1 = (Handler)this.zzbgG.remove(localObject1);
      if (localObject1 != null)
      {
        localObject2 = Message.obtain();
        ((Message)localObject2).obj = paramIntent;
        return ((Handler)localObject1).sendMessage((Message)localObject2);
      }
    }
    return false;
  }
  
  public void close()
  {
    zzbgE = null;
    zza.zzbgq = null;
    zzGS();
  }
  
  public String getMessageType(Intent paramIntent)
  {
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction())) {
      paramIntent = null;
    }
    String str;
    do
    {
      return paramIntent;
      str = paramIntent.getStringExtra("message_type");
      paramIntent = str;
    } while (str != null);
    return "gcm";
  }
  
  @Deprecated
  public String register(String... paramVarArgs)
  {
    String str;
    try
    {
      str = zzbv(this.zzqn);
      if (str == null) {
        throw new IOException("SERVICE_NOT_AVAILABLE");
      }
    }
    finally {}
    paramVarArgs = zzf(paramVarArgs);
    Bundle localBundle = new Bundle();
    if (str.contains(".gsf")) {
      localBundle.putString("legacy.sender", paramVarArgs);
    }
    for (paramVarArgs = InstanceID.getInstance(this.zzqn).getToken(paramVarArgs, "GCM", localBundle);; paramVarArgs = zza(zzJ(localBundle), "registration_id"))
    {
      return paramVarArgs;
      localBundle.putString("sender", paramVarArgs);
    }
  }
  
  public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    zza(paramString1, paramString2, paramLong, -1, paramBundle);
  }
  
  public void send(String paramString1, String paramString2, Bundle paramBundle)
  {
    send(paramString1, paramString2, -1L, paramBundle);
  }
  
  @Deprecated
  public void unregister()
  {
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        throw new IOException("MAIN_THREAD");
      }
    }
    finally {}
    InstanceID.getInstance(this.zzqn).deleteInstanceID();
  }
  
  void zzGS()
  {
    try
    {
      if (this.zzbgF != null)
      {
        this.zzbgF.cancel();
        this.zzbgF = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  Intent zzJ(Bundle paramBundle)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    if (zzbw(this.zzqn) < 0) {
      throw new IOException("Google Play Services missing");
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent("com.google.android.c2dm.intent.REGISTER");
    paramBundle.setPackage(zzbv(this.zzqn));
    zzr(paramBundle);
    paramBundle.putExtra("google.message_id", zzGR());
    paramBundle.putExtras(localBundle);
    paramBundle.putExtra("google.messenger", this.zzbgJ);
    this.zzqn.startService(paramBundle);
    try
    {
      paramBundle = (Intent)this.zzbgI.poll(30000L, TimeUnit.MILLISECONDS);
      return paramBundle;
    }
    catch (InterruptedException paramBundle)
    {
      throw new IOException(paramBundle.getMessage());
    }
  }
  
  String zzf(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No senderIds");
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(',').append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  void zzr(Intent paramIntent)
  {
    try
    {
      if (this.zzbgF == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzbgF = PendingIntent.getBroadcast(this.zzqn, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzbgF);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging
 * JD-Core Version:    0.7.0.1
 */