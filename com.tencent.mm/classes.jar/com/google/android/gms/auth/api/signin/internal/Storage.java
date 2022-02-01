package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class Storage
{
  private static final Lock zzaf;
  private static Storage zzag;
  private final Lock zzah;
  private final SharedPreferences zzai;
  
  static
  {
    AppMethodBeat.i(10898);
    zzaf = new ReentrantLock();
    AppMethodBeat.o(10898);
  }
  
  private Storage(Context paramContext)
  {
    AppMethodBeat.i(10884);
    this.zzah = new ReentrantLock();
    this.zzai = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
    AppMethodBeat.o(10884);
  }
  
  public static Storage getInstance(Context paramContext)
  {
    AppMethodBeat.i(10883);
    Preconditions.checkNotNull(paramContext);
    zzaf.lock();
    try
    {
      if (zzag == null) {
        zzag = new Storage(paramContext.getApplicationContext());
      }
      paramContext = zzag;
      return paramContext;
    }
    finally
    {
      zzaf.unlock();
      AppMethodBeat.o(10883);
    }
  }
  
  public static void setInstance(Storage paramStorage)
  {
    AppMethodBeat.i(10882);
    zzaf.lock();
    try
    {
      zzag = paramStorage;
      return;
    }
    finally
    {
      zzaf.unlock();
      AppMethodBeat.o(10882);
    }
  }
  
  private static String zza(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10897);
    paramString1 = String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + ":" + paramString2;
    AppMethodBeat.o(10897);
    return paramString1;
  }
  
  private final GoogleSignInAccount zzb(String paramString)
  {
    AppMethodBeat.i(10889);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10889);
      return null;
    }
    paramString = getFromStore(zza("googleSignInAccount", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInAccount.fromJsonString(paramString);
      AppMethodBeat.o(10889);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(10889);
    }
    AppMethodBeat.o(10889);
    return null;
    return null;
  }
  
  private final GoogleSignInOptions zzc(String paramString)
  {
    AppMethodBeat.i(10891);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10891);
      return null;
    }
    paramString = getFromStore(zza("googleSignInOptions", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInOptions.fromJsonString(paramString);
      AppMethodBeat.o(10891);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(10891);
    }
    AppMethodBeat.o(10891);
    return null;
    return null;
  }
  
  public void clear()
  {
    AppMethodBeat.i(10896);
    this.zzah.lock();
    try
    {
      this.zzai.edit().clear().apply();
      return;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(10896);
    }
  }
  
  protected String getFromStore(String paramString)
  {
    AppMethodBeat.i(10893);
    this.zzah.lock();
    try
    {
      paramString = this.zzai.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(10893);
    }
  }
  
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount()
  {
    AppMethodBeat.i(10888);
    GoogleSignInAccount localGoogleSignInAccount = zzb(getFromStore("defaultGoogleSignInAccount"));
    AppMethodBeat.o(10888);
    return localGoogleSignInAccount;
  }
  
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions()
  {
    AppMethodBeat.i(10890);
    GoogleSignInOptions localGoogleSignInOptions = zzc(getFromStore("defaultGoogleSignInAccount"));
    AppMethodBeat.o(10890);
    return localGoogleSignInOptions;
  }
  
  public String getSavedRefreshToken()
  {
    AppMethodBeat.i(10892);
    String str = getFromStore("refreshToken");
    AppMethodBeat.o(10892);
    return str;
  }
  
  protected void removeFromStore(String paramString)
  {
    AppMethodBeat.i(10895);
    this.zzah.lock();
    try
    {
      this.zzai.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(10895);
    }
  }
  
  public void removeSavedDefaultGoogleSignInAccount()
  {
    AppMethodBeat.i(10894);
    String str = getFromStore("defaultGoogleSignInAccount");
    removeFromStore("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str))
    {
      removeFromStore(zza("googleSignInAccount", str));
      removeFromStore(zza("googleSignInOptions", str));
    }
    AppMethodBeat.o(10894);
  }
  
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(10885);
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    saveToStore("defaultGoogleSignInAccount", paramGoogleSignInAccount.getObfuscatedIdentifier());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.getObfuscatedIdentifier();
    saveToStore(zza("googleSignInAccount", str), paramGoogleSignInAccount.toJsonForStorage());
    saveToStore(zza("googleSignInOptions", str), paramGoogleSignInOptions.toJson());
    AppMethodBeat.o(10885);
  }
  
  public void saveRefreshToken(String paramString)
  {
    AppMethodBeat.i(10886);
    if (!TextUtils.isEmpty(paramString)) {
      saveToStore("refreshToken", paramString);
    }
    AppMethodBeat.o(10886);
  }
  
  protected void saveToStore(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10887);
    this.zzah.lock();
    try
    {
      this.zzai.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(10887);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.Storage
 * JD-Core Version:    0.7.0.1
 */