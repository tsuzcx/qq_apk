package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import java.util.Iterator;
import java.util.Set;

public class zzd
  extends zzl<zzk>
{
  private final GoogleSignInOptions zzakw;
  
  public zzd(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInOptions != null) {}
    for (;;)
    {
      paramContext = paramGoogleSignInOptions;
      if (paramzzg.zzxM().isEmpty()) {
        break label103;
      }
      paramContext = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
      paramLooper = paramzzg.zzxM().iterator();
      while (paramLooper.hasNext()) {
        paramContext.requestScopes((Scope)paramLooper.next(), new Scope[0]);
      }
      paramGoogleSignInOptions = new GoogleSignInOptions.Builder().build();
    }
    paramContext = paramContext.build();
    label103:
    this.zzakw = paramContext;
  }
  
  protected zzk zzaK(IBinder paramIBinder)
  {
    return zzk.zza.zzaM(paramIBinder);
  }
  
  protected String zzeA()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
  
  protected String zzez()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  public boolean zzrr()
  {
    return true;
  }
  
  public Intent zzrs()
  {
    return zze.zza(getContext(), this.zzakw);
  }
  
  public GoogleSignInOptions zzrt()
  {
    return this.zzakw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzd
 * JD-Core Version:    0.7.0.1
 */