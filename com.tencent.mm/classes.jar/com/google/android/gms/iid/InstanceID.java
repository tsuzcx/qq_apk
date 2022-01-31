package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class InstanceID
{
  public static final String ERROR_BACKOFF = "RETRY_LATER";
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String ERROR_TIMEOUT = "TIMEOUT";
  static Map<String, InstanceID> zzbhG = new HashMap();
  private static zzd zzbhH;
  private static zzc zzbhI;
  static String zzbhM;
  Context mContext;
  KeyPair zzbhJ;
  String zzbhK = "";
  long zzbhL;
  
  protected InstanceID(Context paramContext, String paramString, Bundle paramBundle)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzbhK = paramString;
  }
  
  public static InstanceID getInstance(Context paramContext)
  {
    return zza(paramContext, null);
  }
  
  public static InstanceID zza(Context paramContext, Bundle paramBundle)
  {
    String str;
    if (paramBundle == null) {
      str = "";
    }
    for (;;)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (zzbhH == null)
        {
          zzbhH = new zzd(localContext);
          zzbhI = new zzc(localContext);
        }
        zzbhM = Integer.toString(zzbx(localContext));
        InstanceID localInstanceID = (InstanceID)zzbhG.get(str);
        paramContext = localInstanceID;
        if (localInstanceID == null)
        {
          paramContext = new InstanceID(localContext, str, paramBundle);
          zzbhG.put(str, paramContext);
        }
        return paramContext;
      }
      finally {}
      str = paramBundle.getString("subtype");
      while (str != null) {
        break;
      }
      str = "";
    }
  }
  
  static String zza(KeyPair paramKeyPair)
  {
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112 & 0xFF));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair) {}
    return null;
  }
  
  static int zzbx(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 38).append("Never happens: can't find own package ").append(paramContext);
    }
    return 0;
  }
  
  static String zzby(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 38).append("Never happens: can't find own package ").append(paramContext);
    }
    return null;
  }
  
  static String zzv(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  public void deleteInstanceID()
  {
    zzb("*", "*", null);
    zzHh();
  }
  
  public void deleteToken(String paramString1, String paramString2)
  {
    zzb(paramString1, paramString2, null);
  }
  
  public long getCreationTime()
  {
    if (this.zzbhL == 0L)
    {
      String str = zzbhH.get(this.zzbhK, "cre");
      if (str != null) {
        this.zzbhL = Long.parseLong(str);
      }
    }
    return this.zzbhL;
  }
  
  public String getId()
  {
    return zza(zzHg());
  }
  
  public String getToken(String paramString1, String paramString2)
  {
    return getToken(paramString1, paramString2, null);
  }
  
  public String getToken(String paramString1, String paramString2, Bundle paramBundle)
  {
    int j = 0;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    int i = 1;
    if (zzHk()) {}
    for (Object localObject = null; localObject != null; localObject = zzbhH.zzh(this.zzbhK, paramString1, paramString2)) {
      return localObject;
    }
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    if (((Bundle)localObject).getString("ttl") != null) {
      i = 0;
    }
    if ("jwt".equals(((Bundle)localObject).getString("type"))) {
      i = j;
    }
    for (;;)
    {
      paramBundle = zzc(paramString1, paramString2, (Bundle)localObject);
      localObject = paramBundle;
      if (paramBundle == null) {
        break;
      }
      localObject = paramBundle;
      if (i == 0) {
        break;
      }
      zzbhH.zza(this.zzbhK, paramString1, paramString2, paramBundle, zzbhM);
      return paramBundle;
    }
  }
  
  KeyPair zzHg()
  {
    if (this.zzbhJ == null) {
      this.zzbhJ = zzbhH.zzeI(this.zzbhK);
    }
    if (this.zzbhJ == null)
    {
      this.zzbhL = System.currentTimeMillis();
      this.zzbhJ = zzbhH.zze(this.zzbhK, this.zzbhL);
    }
    return this.zzbhJ;
  }
  
  public void zzHh()
  {
    this.zzbhL = 0L;
    zzbhH.zzeJ(this.zzbhK);
    this.zzbhJ = null;
  }
  
  public zzd zzHi()
  {
    return zzbhH;
  }
  
  public zzc zzHj()
  {
    return zzbhI;
  }
  
  boolean zzHk()
  {
    String str = zzbhH.get("appVersion");
    if ((str == null) || (!str.equals(zzbhM))) {}
    long l;
    do
    {
      do
      {
        return true;
        str = zzbhH.get("lastToken");
      } while (str == null);
      l = Long.parseLong(str);
    } while (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() > 604800L);
    return false;
  }
  
  public void zzb(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    zzbhH.zzi(this.zzbhK, paramString1, paramString2);
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
    if ("".equals(this.zzbhK))
    {
      paramString2 = paramString1;
      localBundle.putString("subtype", paramString2);
      if (!"".equals(this.zzbhK)) {
        break label173;
      }
    }
    for (;;)
    {
      localBundle.putString("X-subtype", paramString1);
      paramString1 = zzbhI.zza(localBundle, zzHg());
      zzbhI.zzt(paramString1);
      return;
      paramString2 = this.zzbhK;
      break;
      label173:
      paramString1 = this.zzbhK;
    }
  }
  
  public String zzc(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramString2 != null) {
      paramBundle.putString("scope", paramString2);
    }
    paramBundle.putString("sender", paramString1);
    if ("".equals(this.zzbhK)) {}
    for (paramString2 = paramString1;; paramString2 = this.zzbhK)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      paramString1 = zzbhI.zza(paramBundle, zzHg());
      return zzbhI.zzt(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceID
 * JD-Core Version:    0.7.0.1
 */