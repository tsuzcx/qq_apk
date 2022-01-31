package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class Storage
{
  private static final Lock zzaf;
  @GuardedBy("sLk")
  private static Storage zzag;
  private final Lock zzah;
  @GuardedBy("mLk")
  private final SharedPreferences zzai;
  
  static
  {
    AppMethodBeat.i(60406);
    zzaf = new ReentrantLock();
    AppMethodBeat.o(60406);
  }
  
  @VisibleForTesting
  private Storage(Context paramContext)
  {
    AppMethodBeat.i(60392);
    this.zzah = new ReentrantLock();
    this.zzai = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
    AppMethodBeat.o(60392);
  }
  
  public static Storage getInstance(Context paramContext)
  {
    AppMethodBeat.i(60391);
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
      AppMethodBeat.o(60391);
    }
  }
  
  @VisibleForTesting
  public static void setInstance(@Nullable Storage paramStorage)
  {
    AppMethodBeat.i(60390);
    zzaf.lock();
    try
    {
      zzag = paramStorage;
      return;
    }
    finally
    {
      zzaf.unlock();
      AppMethodBeat.o(60390);
    }
  }
  
  private static String zza(String paramString1, String paramString2)
  {
    AppMethodBeat.i(60405);
    paramString1 = String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length() + paramString1 + ":" + paramString2;
    AppMethodBeat.o(60405);
    return paramString1;
  }
  
  @Nullable
  @VisibleForTesting
  private final GoogleSignInAccount zzb(String paramString)
  {
    AppMethodBeat.i(60397);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(60397);
      return null;
    }
    paramString = getFromStore(zza("googleSignInAccount", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInAccount.fromJsonString(paramString);
      AppMethodBeat.o(60397);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(60397);
    }
    AppMethodBeat.o(60397);
    return null;
    return null;
  }
  
  @Nullable
  @VisibleForTesting
  private final GoogleSignInOptions zzc(String paramString)
  {
    AppMethodBeat.i(60399);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(60399);
      return null;
    }
    paramString = getFromStore(zza("googleSignInOptions", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInOptions.fromJsonString(paramString);
      AppMethodBeat.o(60399);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(60399);
    }
    AppMethodBeat.o(60399);
    return null;
    return null;
  }
  
  public void clear()
  {
    AppMethodBeat.i(60404);
    this.zzah.lock();
    try
    {
      this.zzai.edit().clear().apply();
      return;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(60404);
    }
  }
  
  @Nullable
  protected String getFromStore(String paramString)
  {
    AppMethodBeat.i(60401);
    this.zzah.lock();
    try
    {
      paramString = this.zzai.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(60401);
    }
  }
  
  @Nullable
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount()
  {
    AppMethodBeat.i(60396);
    GoogleSignInAccount localGoogleSignInAccount = zzb(getFromStore("defaultGoogleSignInAccount"));
    AppMethodBeat.o(60396);
    return localGoogleSignInAccount;
  }
  
  @Nullable
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions()
  {
    AppMethodBeat.i(60398);
    GoogleSignInOptions localGoogleSignInOptions = zzc(getFromStore("defaultGoogleSignInAccount"));
    AppMethodBeat.o(60398);
    return localGoogleSignInOptions;
  }
  
  @Nullable
  public String getSavedRefreshToken()
  {
    AppMethodBeat.i(60400);
    String str = getFromStore("refreshToken");
    AppMethodBeat.o(60400);
    return str;
  }
  
  protected void removeFromStore(String paramString)
  {
    AppMethodBeat.i(60403);
    this.zzah.lock();
    try
    {
      this.zzai.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(60403);
    }
  }
  
  public void removeSavedDefaultGoogleSignInAccount()
  {
    AppMethodBeat.i(60402);
    String str = getFromStore("defaultGoogleSignInAccount");
    removeFromStore("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str))
    {
      removeFromStore(zza("googleSignInAccount", str));
      removeFromStore(zza("googleSignInOptions", str));
    }
    AppMethodBeat.o(60402);
  }
  
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    AppMethodBeat.i(60393);
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    saveToStore("defaultGoogleSignInAccount", paramGoogleSignInAccount.getObfuscatedIdentifier());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.getObfuscatedIdentifier();
    saveToStore(zza("googleSignInAccount", str), paramGoogleSignInAccount.toJsonForStorage());
    saveToStore(zza("googleSignInOptions", str), paramGoogleSignInOptions.toJson());
    AppMethodBeat.o(60393);
  }
  
  public void saveRefreshToken(String paramString)
  {
    AppMethodBeat.i(60394);
    if (!TextUtils.isEmpty(paramString)) {
      saveToStore("refreshToken", paramString);
    }
    AppMethodBeat.o(60394);
  }
  
  protected void saveToStore(String paramString1, String paramString2)
  {
    AppMethodBeat.i(60395);
    this.zzah.lock();
    try
    {
      this.zzai.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zzah.unlock();
      AppMethodBeat.o(60395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.Storage
 * JD-Core Version:    0.7.0.1
 */