package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.e.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzad
  extends zzk
{
  private GoogleApiManager zzcq;
  private final b<zzh<?>> zzhb;
  
  private zzad(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    AppMethodBeat.i(60686);
    this.zzhb = new b();
    this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    AppMethodBeat.o(60686);
  }
  
  public static void zza(Activity paramActivity, GoogleApiManager paramGoogleApiManager, zzh<?> paramzzh)
  {
    AppMethodBeat.i(60685);
    LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
    zzad localzzad = (zzad)localLifecycleFragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zzad.class);
    paramActivity = localzzad;
    if (localzzad == null) {
      paramActivity = new zzad(localLifecycleFragment);
    }
    paramActivity.zzcq = paramGoogleApiManager;
    Preconditions.checkNotNull(paramzzh, "ApiKey cannot be null");
    paramActivity.zzhb.add(paramzzh);
    paramGoogleApiManager.zza(paramActivity);
    AppMethodBeat.o(60685);
  }
  
  private final void zzan()
  {
    AppMethodBeat.i(60692);
    if (!this.zzhb.isEmpty()) {
      this.zzcq.zza(this);
    }
    AppMethodBeat.o(60692);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(60688);
    super.onResume();
    zzan();
    AppMethodBeat.o(60688);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(60687);
    super.onStart();
    zzan();
    AppMethodBeat.o(60687);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(60689);
    super.onStop();
    this.zzcq.zzb(this);
    AppMethodBeat.o(60689);
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(60690);
    this.zzcq.zza(paramConnectionResult, paramInt);
    AppMethodBeat.o(60690);
  }
  
  final b<zzh<?>> zzam()
  {
    return this.zzhb;
  }
  
  protected final void zzr()
  {
    AppMethodBeat.i(60691);
    this.zzcq.zzr();
    AppMethodBeat.o(60691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzad
 * JD-Core Version:    0.7.0.1
 */