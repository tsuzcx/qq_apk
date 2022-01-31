package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzn
{
  private static final Lock zzakO = new ReentrantLock();
  private static zzn zzakP;
  private final Lock zzakQ = new ReentrantLock();
  private final SharedPreferences zzakR;
  
  zzn(Context paramContext)
  {
    this.zzakR = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static zzn zzas(Context paramContext)
  {
    zzac.zzw(paramContext);
    zzakO.lock();
    try
    {
      if (zzakP == null) {
        zzakP = new zzn(paramContext.getApplicationContext());
      }
      paramContext = zzakP;
      return paramContext;
    }
    finally
    {
      zzakO.unlock();
    }
  }
  
  private String zzy(String paramString1, String paramString2)
  {
    String str = String.valueOf(":");
    return String.valueOf(paramString1).length() + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2;
  }
  
  void zza(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzw(paramGoogleSignInAccount);
    zzac.zzw(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zzrf();
    zzx(zzy("googleSignInAccount", str), paramGoogleSignInAccount.zzrh());
    zzx(zzy("googleSignInOptions", str), paramGoogleSignInOptions.zzrg());
  }
  
  public void zzb(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzw(paramGoogleSignInAccount);
    zzac.zzw(paramGoogleSignInOptions);
    zzx("defaultGoogleSignInAccount", paramGoogleSignInAccount.zzrf());
    zza(paramGoogleSignInAccount, paramGoogleSignInOptions);
  }
  
  GoogleSignInOptions zzcA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzcB(zzy("googleSignInOptions", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInOptions.zzcx(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  protected String zzcB(String paramString)
  {
    this.zzakQ.lock();
    try
    {
      paramString = this.zzakR.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzakQ.unlock();
    }
  }
  
  void zzcC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    zzcD(zzy("googleSignInAccount", paramString));
    zzcD(zzy("googleSignInOptions", paramString));
  }
  
  protected void zzcD(String paramString)
  {
    this.zzakQ.lock();
    try
    {
      this.zzakR.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zzakQ.unlock();
    }
  }
  
  GoogleSignInAccount zzcz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzcB(zzy("googleSignInAccount", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInAccount.zzcv(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public GoogleSignInAccount zzrB()
  {
    return zzcz(zzcB("defaultGoogleSignInAccount"));
  }
  
  public GoogleSignInOptions zzrC()
  {
    return zzcA(zzcB("defaultGoogleSignInAccount"));
  }
  
  public void zzrD()
  {
    String str = zzcB("defaultGoogleSignInAccount");
    zzcD("defaultGoogleSignInAccount");
    zzcC(str);
  }
  
  protected void zzx(String paramString1, String paramString2)
  {
    this.zzakQ.lock();
    try
    {
      this.zzakR.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zzakQ.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzn
 * JD-Core Version:    0.7.0.1
 */