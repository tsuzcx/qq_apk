package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

public class zzi
  extends zzk
{
  private final SparseArray<zza> zzed;
  
  private zzi(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    AppMethodBeat.i(11418);
    this.zzed = new SparseArray();
    this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    AppMethodBeat.o(11418);
  }
  
  public static zzi zza(LifecycleActivity paramLifecycleActivity)
  {
    AppMethodBeat.i(11417);
    paramLifecycleActivity = getFragment(paramLifecycleActivity);
    zzi localzzi = (zzi)paramLifecycleActivity.getCallbackOrNull("AutoManageHelper", zzi.class);
    if (localzzi != null)
    {
      AppMethodBeat.o(11417);
      return localzzi;
    }
    paramLifecycleActivity = new zzi(paramLifecycleActivity);
    AppMethodBeat.o(11417);
    return paramLifecycleActivity;
  }
  
  private final zza zzd(int paramInt)
  {
    AppMethodBeat.i(11426);
    if (this.zzed.size() <= paramInt)
    {
      AppMethodBeat.o(11426);
      return null;
    }
    zza localzza = (zza)this.zzed.get(this.zzed.keyAt(paramInt));
    AppMethodBeat.o(11426);
    return localzza;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(11423);
    int i = 0;
    while (i < this.zzed.size())
    {
      zza localzza = zzd(i);
      if (localzza != null)
      {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(localzza.zzee);
        paramPrintWriter.println(":");
        localzza.zzef.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      i += 1;
    }
    AppMethodBeat.o(11423);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(11421);
    super.onStart();
    boolean bool = this.mStarted;
    Object localObject = String.valueOf(this.zzed);
    new StringBuilder(String.valueOf(localObject).length() + 14).append("onStart ").append(bool).append(" ").append((String)localObject);
    if (this.zzer.get() == null)
    {
      int i = 0;
      while (i < this.zzed.size())
      {
        localObject = zzd(i);
        if (localObject != null) {
          ((zza)localObject).zzef.connect();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(11421);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(11422);
    super.onStop();
    int i = 0;
    while (i < this.zzed.size())
    {
      zza localzza = zzd(i);
      if (localzza != null) {
        localzza.zzef.disconnect();
      }
      i += 1;
    }
    AppMethodBeat.o(11422);
  }
  
  public final void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11419);
    Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zzed.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      zzl localzzl = (zzl)this.zzer.get();
      bool = this.mStarted;
      String str = String.valueOf(localzzl);
      new StringBuilder(String.valueOf(str).length() + 49).append("starting AutoManage for client ").append(paramInt).append(" ").append(bool).append(" ").append(str);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      this.zzed.put(paramInt, paramOnConnectionFailedListener);
      if ((this.mStarted) && (localzzl == null))
      {
        paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
        new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 11).append("connecting ").append(paramOnConnectionFailedListener);
        paramGoogleApiClient.connect();
      }
      AppMethodBeat.o(11419);
      return;
    }
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(11424);
    if (paramInt < 0)
    {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      AppMethodBeat.o(11424);
      return;
    }
    Object localObject = (zza)this.zzed.get(paramInt);
    if (localObject != null)
    {
      zzc(paramInt);
      localObject = ((zza)localObject).zzeg;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
    AppMethodBeat.o(11424);
  }
  
  public final void zzc(int paramInt)
  {
    AppMethodBeat.i(11420);
    zza localzza = (zza)this.zzed.get(paramInt);
    this.zzed.remove(paramInt);
    if (localzza != null)
    {
      localzza.zzef.unregisterConnectionFailedListener(localzza);
      localzza.zzef.disconnect();
    }
    AppMethodBeat.o(11420);
  }
  
  protected final void zzr()
  {
    AppMethodBeat.i(11425);
    int i = 0;
    while (i < this.zzed.size())
    {
      zza localzza = zzd(i);
      if (localzza != null) {
        localzza.zzef.connect();
      }
      i += 1;
    }
    AppMethodBeat.o(11425);
  }
  
  final class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zzee;
    public final GoogleApiClient zzef;
    public final GoogleApiClient.OnConnectionFailedListener zzeg;
    
    public zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      AppMethodBeat.i(11415);
      this.zzee = paramInt;
      this.zzef = paramGoogleApiClient;
      this.zzeg = paramOnConnectionFailedListener;
      paramGoogleApiClient.registerConnectionFailedListener(this);
      AppMethodBeat.o(11415);
    }
    
    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(11416);
      String str = String.valueOf(paramConnectionResult);
      new StringBuilder(String.valueOf(str).length() + 27).append("beginFailureResolution for ").append(str);
      zzi.this.zzb(paramConnectionResult, this.zzee);
      AppMethodBeat.o(11416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzi
 * JD-Core Version:    0.7.0.1
 */