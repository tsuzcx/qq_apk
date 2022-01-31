package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;

public final class zzbah
{
  public static final Api<zzbaj> API = new Api("SignIn.API", zzaie, zzaid);
  public static final Api<zzbah.zza> zzaKN = new Api("SignIn.INTERNAL_API", zzbEk, zzbEj);
  public static final Api.zzf<zzbat> zzaid = new Api.zzf();
  public static final Api.zza<zzbat, zzbaj> zzaie;
  public static final Scope zzakh;
  public static final Scope zzaki;
  public static final Api.zzf<zzbat> zzbEj = new Api.zzf();
  static final Api.zza<zzbat, zzbah.zza> zzbEk;
  
  static
  {
    zzaie = new zzbah.1();
    zzbEk = new Api.zza()
    {
      public final zzbat zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, zzbah.zza paramAnonymouszza, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new zzbat(paramAnonymousContext, paramAnonymousLooper, false, paramAnonymouszzg, paramAnonymouszza.zzPH(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
      }
    };
    zzakh = new Scope("profile");
    zzaki = new Scope("email");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzbah
 * JD-Core Version:    0.7.0.1
 */