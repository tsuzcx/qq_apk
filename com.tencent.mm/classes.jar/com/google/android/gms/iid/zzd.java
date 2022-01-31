package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzd
{
  SharedPreferences zzbij;
  Context zzqn;
  
  public zzd(Context paramContext)
  {
    this(paramContext, "com.google.android.gms.appid");
  }
  
  public zzd(Context paramContext, String paramString)
  {
    this.zzqn = paramContext;
    this.zzbij = paramContext.getSharedPreferences(paramString, 0);
    paramContext = String.valueOf(paramString);
    paramString = String.valueOf("-no-backup");
    if (paramString.length() != 0) {}
    for (paramContext = paramContext.concat(paramString);; paramContext = new String(paramContext))
    {
      zzeG(paramContext);
      return;
    }
  }
  
  private void zzeG(String paramString)
  {
    paramString = new File(zzx.getNoBackupFilesDir(this.zzqn), paramString);
    if (paramString.exists()) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((paramString.createNewFile()) && (!isEmpty()))
          {
            InstanceIDListenerService.zza(this.zzqn, this);
            return;
          }
        }
        catch (IOException paramString) {}
      }
    } while (!Log.isLoggable("InstanceID/Store", 3));
    paramString = String.valueOf(paramString.getMessage());
    if (paramString.length() != 0)
    {
      "Error creating file in no backup dir: ".concat(paramString);
      return;
    }
    new String("Error creating file in no backup dir: ");
  }
  
  private String zzg(String paramString1, String paramString2, String paramString3)
  {
    String str = String.valueOf("|T|");
    return String.valueOf(paramString1).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + str + paramString2 + "|" + paramString3;
  }
  
  String get(String paramString)
  {
    try
    {
      paramString = this.zzbij.getString(paramString, null);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String get(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences localSharedPreferences = this.zzbij;
      String str = String.valueOf("|S|");
      paramString1 = localSharedPreferences.getString(String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean isEmpty()
  {
    return this.zzbij.getAll().isEmpty();
  }
  
  public void zzHn()
  {
    try
    {
      this.zzbij.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void zza(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = String.valueOf("|S|");
      paramEditor.putString(String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2, paramString3);
      return;
    }
    finally
    {
      paramEditor = finally;
      throw paramEditor;
    }
  }
  
  public void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = zzg(paramString1, paramString2, paramString3);
      paramString2 = this.zzbij.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  KeyPair zze(String paramString, long paramLong)
  {
    try
    {
      KeyPair localKeyPair = zza.zzHf();
      SharedPreferences.Editor localEditor = this.zzbij.edit();
      zza(localEditor, paramString, "|P|", InstanceID.zzv(localKeyPair.getPublic().getEncoded()));
      zza(localEditor, paramString, "|K|", InstanceID.zzv(localKeyPair.getPrivate().getEncoded()));
      zza(localEditor, paramString, "cre", Long.toString(paramLong));
      localEditor.commit();
      return localKeyPair;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void zzeH(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.zzbij.edit();
      Iterator localIterator = this.zzbij.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
  }
  
  public KeyPair zzeI(String paramString)
  {
    return zzeL(paramString);
  }
  
  void zzeJ(String paramString)
  {
    zzeH(String.valueOf(paramString).concat("|"));
  }
  
  public void zzeK(String paramString)
  {
    zzeH(String.valueOf(paramString).concat("|T|"));
  }
  
  KeyPair zzeL(String paramString)
  {
    Object localObject1 = get(paramString, "|P|");
    Object localObject2 = get(paramString, "|K|");
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    try
    {
      paramString = Base64.decode((String)localObject1, 8);
      localObject1 = Base64.decode((String)localObject2, 8);
      localObject2 = KeyFactory.getInstance("RSA");
      paramString = new KeyPair(((KeyFactory)localObject2).generatePublic(new X509EncodedKeySpec(paramString)), ((KeyFactory)localObject2).generatePrivate(new PKCS8EncodedKeySpec((byte[])localObject1)));
      return paramString;
    }
    catch (InvalidKeySpecException paramString)
    {
      paramString = String.valueOf(paramString);
      new StringBuilder(String.valueOf(paramString).length() + 19).append("Invalid key stored ").append(paramString);
      InstanceIDListenerService.zza(this.zzqn, this);
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label82:
      break label82;
    }
  }
  
  public String zzh(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzg(paramString1, paramString2, paramString3);
      paramString1 = this.zzbij.getString(paramString1, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzi(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzg(paramString1, paramString2, paramString3);
      paramString2 = this.zzbij.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.iid.zzd
 * JD-Core Version:    0.7.0.1
 */