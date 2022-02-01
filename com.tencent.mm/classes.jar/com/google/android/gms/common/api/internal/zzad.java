package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.b.b;
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
    AppMethodBeat.i(11178);
    this.zzhb = new b();
    this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    AppMethodBeat.o(11178);
  }
  
  public static void zza(Activity paramActivity, GoogleApiManager paramGoogleApiManager, zzh<?> paramzzh)
  {
    AppMethodBeat.i(11177);
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
    AppMethodBeat.o(11177);
  }
  
  private final void zzan()
  {
    AppMethodBeat.i(11184);
    if (!this.zzhb.isEmpty()) {
      this.zzcq.zza(this);
    }
    AppMethodBeat.o(11184);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(11180);
    super.onResume();
    zzan();
    AppMethodBeat.o(11180);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(11179);
    super.onStart();
    zzan();
    AppMethodBeat.o(11179);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(11181);
    super.onStop();
    this.zzcq.zzb(this);
    AppMethodBeat.o(11181);
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(11182);
    this.zzcq.zza(paramConnectionResult, paramInt);
    AppMethodBeat.o(11182);
  }
  
  final b<zzh<?>> zzam()
  {
    return this.zzhb;
  }
  
  protected final void zzr()
  {
    AppMethodBeat.i(11183);
    this.zzcq.zzr();
    AppMethodBeat.o(11183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzad
 * JD-Core Version:    0.7.0.1
 */