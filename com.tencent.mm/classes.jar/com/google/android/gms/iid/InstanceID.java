package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.e.a;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class InstanceID
{
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String ERROR_TIMEOUT = "TIMEOUT";
  private static Map<String, InstanceID> zzbq;
  private static long zzbr;
  private static zzak zzbs;
  private static zzaf zzbt;
  private static String zzbu;
  private String zzbv;
  private Context zzk;
  
  static
  {
    AppMethodBeat.i(2472);
    zzbq = new a();
    zzbr = TimeUnit.DAYS.toSeconds(7L);
    AppMethodBeat.o(2472);
  }
  
  private InstanceID(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2456);
    this.zzbv = "";
    this.zzk = paramContext.getApplicationContext();
    this.zzbv = paramString;
    AppMethodBeat.o(2456);
  }
  
  @Deprecated
  public static InstanceID getInstance(Context paramContext)
  {
    AppMethodBeat.i(2459);
    paramContext = getInstance(paramContext, null);
    AppMethodBeat.o(2459);
    return paramContext;
  }
  
  @KeepForSdk
  public static InstanceID getInstance(Context paramContext, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(2460);
        if (paramBundle == null)
        {
          paramBundle = "";
          break label169;
          Context localContext = paramContext.getApplicationContext();
          if (zzbs == null)
          {
            paramContext = localContext.getPackageName();
            new StringBuilder(String.valueOf(paramContext).length() + 73).append("Instance ID SDK is deprecated, ").append(paramContext).append(" should update to use Firebase Instance ID");
            zzbs = new zzak(localContext);
            zzbt = new zzaf(localContext);
          }
          zzbu = Integer.toString(zzg(localContext));
          InstanceID localInstanceID = (InstanceID)zzbq.get(paramBundle);
          paramContext = localInstanceID;
          if (localInstanceID == null)
          {
            paramContext = new InstanceID(localContext, paramBundle);
            zzbq.put(paramBundle, paramContext);
          }
          AppMethodBeat.o(2460);
          return paramContext;
        }
        else
        {
          paramBundle = paramBundle.getString("subtype");
        }
      }
      finally {}
      label169:
      while (paramBundle != null) {
        break;
      }
      paramBundle = "";
    }
  }
  
  private final KeyPair getKeyPair()
  {
    AppMethodBeat.i(2461);
    KeyPair localKeyPair = zzbs.zzj(this.zzbv).getKeyPair();
    AppMethodBeat.o(2461);
    return localKeyPair;
  }
  
  static String zzd(KeyPair paramKeyPair)
  {
    AppMethodBeat.i(2463);
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      AppMethodBeat.o(2463);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair)
    {
      AppMethodBeat.o(2463);
    }
    return null;
  }
  
  static int zzg(Context paramContext)
  {
    AppMethodBeat.i(2457);
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      AppMethodBeat.o(2457);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 38).append("Never happens: can't find own package ").append(paramContext);
      AppMethodBeat.o(2457);
    }
    return 0;
  }
  
  static String zzh(Context paramContext)
  {
    AppMethodBeat.i(2458);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      AppMethodBeat.o(2458);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 38).append("Never happens: can't find own package ").append(paramContext);
      AppMethodBeat.o(2458);
    }
    return null;
  }
  
  public static zzak zzn()
  {
    return zzbs;
  }
  
  @Deprecated
  public void deleteInstanceID()
  {
    AppMethodBeat.i(2465);
    zzd("*", "*", null);
    zzm();
    AppMethodBeat.o(2465);
  }
  
  @Deprecated
  public void deleteToken(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2467);
    zzd(paramString1, paramString2, null);
    AppMethodBeat.o(2467);
  }
  
  @Deprecated
  public long getCreationTime()
  {
    AppMethodBeat.i(2464);
    long l = zzbs.zzj(this.zzbv).getCreationTime();
    AppMethodBeat.o(2464);
    return l;
  }
  
  @Deprecated
  public String getId()
  {
    AppMethodBeat.i(2462);
    String str = zzd(getKeyPair());
    AppMethodBeat.o(2462);
    return str;
  }
  
  @KeepForSdk
  public String getSubtype()
  {
    return this.zzbv;
  }
  
  @Deprecated
  public String getToken(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2469);
    paramString1 = getToken(paramString1, paramString2, null);
    AppMethodBeat.o(2469);
    return paramString1;
  }
  
  @Deprecated
  public String getToken(String paramString1, String paramString2, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(2470);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString1 = new IOException("MAIN_THREAD");
      AppMethodBeat.o(2470);
      throw paramString1;
    }
    Object localObject1 = null;
    Object localObject2 = zzbs.get("appVersion");
    int i = j;
    if (localObject2 != null)
    {
      if (((String)localObject2).equals(zzbu)) {
        break label162;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        localObject1 = zzbs.zze(this.zzbv, paramString1, paramString2);
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramBundle;
        if (paramBundle == null) {
          localObject1 = new Bundle();
        }
        paramBundle = zze(paramString1, paramString2, (Bundle)localObject1);
        localObject2 = paramBundle;
        if (paramBundle != null)
        {
          zzbs.zzd(this.zzbv, paramString1, paramString2, paramBundle, zzbu);
          localObject2 = paramBundle;
        }
      }
      AppMethodBeat.o(2470);
      return localObject2;
      label162:
      localObject2 = zzbs.get("lastToken");
      i = j;
      if (localObject2 != null)
      {
        long l = Long.parseLong((String)localObject2);
        i = j;
        if (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() <= zzbr) {
          i = 0;
        }
      }
    }
  }
  
  public final void zzd(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(2468);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString1 = new IOException("MAIN_THREAD");
      AppMethodBeat.o(2468);
      throw paramString1;
    }
    zzbs.zzf(this.zzbv, paramString1, paramString2);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("sender", paramString1);
    if (paramString2 != null) {
      localBundle.putString("scope", paramString2);
    }
    localBundle.putString("subscription", paramString1);
    localBundle.putString("delete", "1");
    localBundle.putString("X-delete", "1");
    if ("".equals(this.zzbv))
    {
      paramString2 = paramString1;
      localBundle.putString("subtype", paramString2);
      if (!"".equals(this.zzbv)) {
        break label188;
      }
    }
    for (;;)
    {
      localBundle.putString("X-subtype", paramString1);
      zzaf.zzi(zzbt.zzd(localBundle, getKeyPair()));
      AppMethodBeat.o(2468);
      return;
      paramString2 = this.zzbv;
      break;
      label188:
      paramString1 = this.zzbv;
    }
  }
  
  public final String zze(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(2471);
    if (paramString2 != null) {
      paramBundle.putString("scope", paramString2);
    }
    paramBundle.putString("sender", paramString1);
    if ("".equals(this.zzbv)) {}
    for (paramString2 = paramString1;; paramString2 = this.zzbv)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      paramString1 = zzaf.zzi(zzbt.zzd(paramBundle, getKeyPair()));
      if ((!"RST".equals(paramString1)) && (!paramString1.startsWith("RST|"))) {
        break;
      }
      InstanceIDListenerService.zzd(this.zzk, zzbs);
      paramString1 = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(2471);
      throw paramString1;
    }
    AppMethodBeat.o(2471);
    return paramString1;
  }
  
  final void zzm()
  {
    AppMethodBeat.i(2466);
    zzbs.zzk(this.zzbv);
    AppMethodBeat.o(2466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceID
 * JD-Core Version:    0.7.0.1
 */