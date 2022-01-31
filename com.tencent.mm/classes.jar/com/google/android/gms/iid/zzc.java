package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class zzc
{
  static String zzbhW = null;
  static int zzbhX = 0;
  static int zzbhY = 0;
  static int zzbhZ = 0;
  PendingIntent zzbgF;
  Messenger zzbgJ;
  Map<String, Object> zzbia = new HashMap();
  Messenger zzbib;
  MessengerCompat zzbic;
  long zzbid;
  long zzbie;
  int zzbif;
  int zzbig;
  long zzbih;
  Context zzqn;
  
  public zzc(Context paramContext)
  {
    this.zzqn = paramContext;
  }
  
  private void zzG(Object paramObject)
  {
    synchronized (getClass())
    {
      Iterator localIterator = this.zzbia.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.zzbia.get(str);
        this.zzbia.put(str, paramObject);
        zzg(localObject, paramObject);
      }
    }
  }
  
  public static String zzHm()
  {
    try
    {
      int i = zzbhZ;
      zzbhZ = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  static String zza(KeyPair paramKeyPair, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 108
    //   2: aload_1
    //   3: invokestatic 114	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   6: ldc 116
    //   8: invokevirtual 120	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   11: astore_1
    //   12: aload_0
    //   13: invokevirtual 126	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   16: astore_2
    //   17: aload_2
    //   18: instanceof 128
    //   21: ifeq +29 -> 50
    //   24: ldc 130
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 136	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   31: astore_0
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 140	java/security/Signature:initSign	(Ljava/security/PrivateKey;)V
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 144	java/security/Signature:update	([B)V
    //   42: aload_0
    //   43: invokevirtual 148	java/security/Signature:sign	()[B
    //   46: invokestatic 154	com/google/android/gms/iid/InstanceID:zzv	([B)Ljava/lang/String;
    //   49: areturn
    //   50: ldc 156
    //   52: astore_0
    //   53: goto -26 -> 27
    //   56: astore_0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramKeyPair	KeyPair
    //   0	62	1	paramVarArgs	String[]
    //   16	18	2	localPrivateKey	java.security.PrivateKey
    // Exception table:
    //   from	to	target	type
    //   12	24	56	java/security/GeneralSecurityException
    //   27	50	56	java/security/GeneralSecurityException
    //   0	12	59	java/io/UnsupportedEncodingException
  }
  
  private Intent zzb(Bundle arg1, KeyPair paramKeyPair)
  {
    ConditionVariable localConditionVariable = new ConditionVariable();
    String str = zzHm();
    synchronized (getClass())
    {
      this.zzbia.put(str, localConditionVariable);
      zza(???, paramKeyPair, str);
      localConditionVariable.block(30000L);
    }
    synchronized (getClass())
    {
      paramKeyPair = this.zzbia.remove(str);
      if ((paramKeyPair instanceof Intent))
      {
        paramKeyPair = (Intent)paramKeyPair;
        return paramKeyPair;
        ??? = finally;
        throw ???;
      }
      if ((paramKeyPair instanceof String)) {
        throw new IOException((String)paramKeyPair);
      }
    }
    paramKeyPair = String.valueOf(paramKeyPair);
    new StringBuilder(String.valueOf(paramKeyPair).length() + 12).append("No response ").append(paramKeyPair);
    throw new IOException("TIMEOUT");
  }
  
  public static String zzbA(Context paramContext)
  {
    if (zzbhW != null) {
      return zzbhW;
    }
    zzbhX = Process.myUid();
    paramContext = paramContext.getPackageManager();
    Object localObject1 = paramContext.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      Object localObject3;
      if (paramContext.checkPermission("com.google.android.c2dm.permission.RECEIVE", ((ResolveInfo)localObject2).serviceInfo.packageName) == 0)
      {
        try
        {
          localObject3 = paramContext.getApplicationInfo(((ResolveInfo)localObject2).serviceInfo.packageName, 0);
          int i = ((ApplicationInfo)localObject3).uid;
          new StringBuilder(17).append("Found ").append(i);
          zzbhY = ((ApplicationInfo)localObject3).uid;
          localObject2 = ((ResolveInfo)localObject2).serviceInfo.packageName;
          zzbhW = (String)localObject2;
          return localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      }
      else
      {
        String str = String.valueOf(localNameNotFoundException2.serviceInfo.packageName);
        localObject3 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
        new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(localObject3).length()).append("Possible malicious package ").append(str).append(" declares ").append((String)localObject3).append(" without permission");
      }
    }
    try
    {
      localObject1 = paramContext.getApplicationInfo("com.google.android.gms", 0);
      zzbhW = ((ApplicationInfo)localObject1).packageName;
      zzbhY = ((ApplicationInfo)localObject1).uid;
      localObject1 = zzbhW;
      return localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      try
      {
        paramContext = paramContext.getApplicationInfo("com.google.android.gsf", 0);
        zzbhW = paramContext.packageName;
        zzbhY = paramContext.uid;
        paramContext = zzbhW;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return null;
  }
  
  private static int zzbB(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(zzbA(paramContext), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
  
  private void zzeF(String paramString)
  {
    if (!"com.google.android.gsf".equals(zzbhW)) {}
    do
    {
      return;
      this.zzbif += 1;
    } while (this.zzbif < 3);
    if (this.zzbif == 3) {
      this.zzbig = (new Random().nextInt(1000) + 1000);
    }
    this.zzbig *= 2;
    this.zzbih = (SystemClock.elapsedRealtime() + this.zzbig);
    int i = this.zzbig;
    new StringBuilder(String.valueOf(paramString).length() + 31).append("Backoff due to ").append(paramString).append(" for ").append(i);
  }
  
  private void zzg(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof ConditionVariable)) {
      ((ConditionVariable)paramObject1).open();
    }
    Message localMessage;
    if ((paramObject1 instanceof Messenger))
    {
      paramObject1 = (Messenger)paramObject1;
      localMessage = Message.obtain();
      localMessage.obj = paramObject2;
    }
    try
    {
      paramObject1.send(localMessage);
      return;
    }
    catch (RemoteException paramObject1)
    {
      paramObject1 = String.valueOf(paramObject1);
      new StringBuilder(String.valueOf(paramObject1).length() + 24).append("Failed to send response ").append(paramObject1);
    }
  }
  
  private void zzi(String paramString, Object paramObject)
  {
    synchronized (getClass())
    {
      Object localObject = this.zzbia.get(paramString);
      this.zzbia.put(paramString, paramObject);
      zzg(localObject, paramObject);
      return;
    }
  }
  
  void zzHl()
  {
    if (this.zzbgJ != null) {
      return;
    }
    zzbA(this.zzqn);
    this.zzbgJ = new Messenger(new zzc.1(this, Looper.getMainLooper()));
  }
  
  Intent zza(Bundle paramBundle, KeyPair paramKeyPair)
  {
    Intent localIntent2 = zzb(paramBundle, paramKeyPair);
    Intent localIntent1 = localIntent2;
    if (localIntent2 != null)
    {
      localIntent1 = localIntent2;
      if (localIntent2.hasExtra("google.messenger")) {
        localIntent1 = zzb(paramBundle, paramKeyPair);
      }
    }
    return localIntent1;
  }
  
  void zza(Bundle paramBundle, KeyPair paramKeyPair, String paramString)
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.zzbih != 0L) && (l1 <= this.zzbih))
    {
      long l2 = this.zzbih;
      int i = this.zzbig;
      new StringBuilder(78).append("Backoff mode, next request attempt: ").append(l2 - l1).append(" interval: ").append(i);
      throw new IOException("RETRY_LATER");
    }
    zzHl();
    if (zzbhW == null) {
      throw new IOException("MISSING_INSTANCEID_SERVICE");
    }
    this.zzbid = SystemClock.elapsedRealtime();
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage(zzbhW);
    paramBundle.putString("gmsv", Integer.toString(zzbB(this.zzqn)));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", Integer.toString(InstanceID.zzbx(this.zzqn)));
    paramBundle.putString("app_ver_name", InstanceID.zzby(this.zzqn));
    paramBundle.putString("cliv", "iid-10298000");
    paramBundle.putString("appid", InstanceID.zza(paramKeyPair));
    String str = InstanceID.zzv(paramKeyPair.getPublic().getEncoded());
    paramBundle.putString("pub2", str);
    paramBundle.putString("sig", zza(paramKeyPair, new String[] { this.zzqn.getPackageName(), str }));
    localIntent.putExtras(paramBundle);
    zzs(localIntent);
    zzb(localIntent, paramString);
  }
  
  protected void zzb(Intent paramIntent, String paramString)
  {
    this.zzbid = SystemClock.elapsedRealtime();
    paramIntent.putExtra("kid", String.valueOf(paramString).length() + 5 + "|ID|" + paramString + "|");
    paramIntent.putExtra("X-kid", String.valueOf(paramString).length() + 5 + "|ID|" + paramString + "|");
    boolean bool = "com.google.android.gsf".equals(zzbhW);
    paramString = paramIntent.getStringExtra("useGsf");
    if (paramString != null) {
      bool = "1".equals(paramString);
    }
    if (Log.isLoggable("InstanceID/Rpc", 3))
    {
      paramString = String.valueOf(paramIntent.getExtras());
      new StringBuilder(String.valueOf(paramString).length() + 8).append("Sending ").append(paramString);
    }
    if (this.zzbib != null)
    {
      paramIntent.putExtra("google.messenger", this.zzbgJ);
      paramString = Message.obtain();
      paramString.obj = paramIntent;
      try
      {
        this.zzbib.send(paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.isLoggable("InstanceID/Rpc", 3);
      }
    }
    if (bool)
    {
      paramString = new Intent("com.google.android.gms.iid.InstanceID");
      paramString.setPackage(this.zzqn.getPackageName());
      paramString.putExtra("GSF", paramIntent);
      this.zzqn.startService(paramString);
      return;
    }
    paramIntent.putExtra("google.messenger", this.zzbgJ);
    paramIntent.putExtra("messenger2", "1");
    if (this.zzbic != null)
    {
      paramString = Message.obtain();
      paramString.obj = paramIntent;
      try
      {
        this.zzbic.send(paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        Log.isLoggable("InstanceID/Rpc", 3);
      }
    }
    this.zzqn.startService(paramIntent);
  }
  
  public void zze(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (!(paramMessage.obj instanceof Intent)) {
      return;
    }
    Object localObject = (Intent)paramMessage.obj;
    ((Intent)localObject).setExtrasClassLoader(MessengerCompat.class.getClassLoader());
    if (((Intent)localObject).hasExtra("google.messenger"))
    {
      localObject = ((Intent)localObject).getParcelableExtra("google.messenger");
      if ((localObject instanceof MessengerCompat)) {
        this.zzbic = ((MessengerCompat)localObject);
      }
      if ((localObject instanceof Messenger)) {
        this.zzbib = ((Messenger)localObject);
      }
    }
    zzv((Intent)paramMessage.obj);
  }
  
  void zzs(Intent paramIntent)
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
  
  String zzt(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    String str2 = paramIntent.getStringExtra("registration_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("unregistered");
    }
    paramIntent.getLongExtra("Retry-After", 0L);
    if (str1 == null)
    {
      str1 = paramIntent.getStringExtra("error");
      if (str1 != null) {
        throw new IOException(str1);
      }
      paramIntent = String.valueOf(paramIntent.getExtras());
      new StringBuilder(String.valueOf(paramIntent).length() + 29).append("Unexpected response from GCM ").append(paramIntent);
      new Throwable();
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    return str1;
  }
  
  void zzu(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("error");
    if (str == null)
    {
      paramIntent = String.valueOf(paramIntent.getExtras());
      new StringBuilder(String.valueOf(paramIntent).length() + 49).append("Unexpected response, no error or registration id ").append(paramIntent);
    }
    Object localObject1;
    label153:
    label203:
    label335:
    label346:
    do
    {
      return;
      Object localObject2;
      Object localObject3;
      if (Log.isLoggable("InstanceID/Rpc", 3))
      {
        localObject1 = String.valueOf(str);
        if (((String)localObject1).length() != 0) {
          "Received InstanceID error ".concat((String)localObject1);
        }
      }
      else
      {
        localObject2 = null;
        localObject3 = null;
        localObject1 = str;
        if (str.startsWith("|"))
        {
          localObject1 = str.split("\\|");
          if (!"ID".equals(localObject1[1]))
          {
            localObject2 = String.valueOf(str);
            if (((String)localObject2).length() == 0) {
              break label309;
            }
            "Unexpected structured response ".concat((String)localObject2);
          }
          if (localObject1.length <= 2) {
            break label323;
          }
          localObject3 = localObject1[2];
          str = localObject1[3];
          localObject2 = localObject3;
          localObject1 = str;
          if (str.startsWith(":"))
          {
            localObject1 = str.substring(1);
            localObject2 = localObject3;
          }
          paramIntent.putExtra("error", (String)localObject1);
        }
        if (localObject2 != null) {
          break label335;
        }
        zzG(localObject1);
      }
      for (;;)
      {
        long l = paramIntent.getLongExtra("Retry-After", 0L);
        if (l <= 0L) {
          break label346;
        }
        this.zzbie = SystemClock.elapsedRealtime();
        this.zzbig = ((int)l * 1000);
        this.zzbih = (SystemClock.elapsedRealtime() + this.zzbig);
        int i = this.zzbig;
        new StringBuilder(52).append("Explicit request from server to backoff: ").append(i);
        return;
        new String("Received InstanceID error ");
        break;
        new String("Unexpected structured response ");
        break label153;
        localObject1 = "UNKNOWN";
        localObject2 = localObject3;
        break label203;
        zzi((String)localObject2, localObject1);
      }
    } while ((!"SERVICE_NOT_AVAILABLE".equals(localObject1)) && (!"AUTHENTICATION_FAILED".equals(localObject1)));
    label309:
    label323:
    zzeF((String)localObject1);
  }
  
  public void zzv(Intent paramIntent)
  {
    if (paramIntent == null) {
      Log.isLoggable("InstanceID/Rpc", 3);
    }
    do
    {
      return;
      localObject1 = paramIntent.getAction();
      if (("com.google.android.c2dm.intent.REGISTRATION".equals(localObject1)) || ("com.google.android.gms.iid.InstanceID".equals(localObject1))) {
        break;
      }
    } while (!Log.isLoggable("InstanceID/Rpc", 3));
    paramIntent = String.valueOf(paramIntent.getAction());
    if (paramIntent.length() != 0)
    {
      "Unexpected response ".concat(paramIntent);
      return;
    }
    new String("Unexpected response ");
    return;
    Object localObject1 = paramIntent.getStringExtra("registration_id");
    if (localObject1 == null) {
      localObject1 = paramIntent.getStringExtra("unregistered");
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        zzu(paramIntent);
        return;
      }
      this.zzbid = SystemClock.elapsedRealtime();
      this.zzbih = 0L;
      this.zzbif = 0;
      this.zzbig = 0;
      String str = null;
      Object localObject2;
      if (((String)localObject1).startsWith("|"))
      {
        localObject2 = ((String)localObject1).split("\\|");
        if (!"ID".equals(localObject2[1]))
        {
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() == 0) {
            break label272;
          }
          "Unexpected structured response ".concat((String)localObject1);
        }
        str = localObject2[2];
        if (localObject2.length > 4)
        {
          if (!"SYNC".equals(localObject2[3])) {
            break label286;
          }
          InstanceIDListenerService.zzbz(this.zzqn);
        }
      }
      label272:
      label286:
      while (!"RST".equals(localObject2[3]))
      {
        localObject2 = localObject2[(localObject2.length - 1)];
        localObject1 = localObject2;
        if (((String)localObject2).startsWith(":")) {
          localObject1 = ((String)localObject2).substring(1);
        }
        paramIntent.putExtra("registration_id", (String)localObject1);
        if (str != null) {
          break label330;
        }
        zzG(paramIntent);
        return;
        new String("Unexpected structured response ");
        break;
      }
      InstanceIDListenerService.zza(this.zzqn, InstanceID.getInstance(this.zzqn).zzHi());
      paramIntent.removeExtra("registration_id");
      zzi(str, paramIntent);
      return;
      label330:
      zzi(str, paramIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.zzc
 * JD-Core Version:    0.7.0.1
 */