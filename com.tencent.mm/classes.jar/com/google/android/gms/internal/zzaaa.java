package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzaaa
  extends zzaae
{
  private final SparseArray<zzaaa.zza> zzazN = new SparseArray();
  
  private zzaaa(zzabf paramzzabf)
  {
    super(paramzzabf);
    this.zzaCR.zza("AutoManageHelper", this);
  }
  
  public static zzaaa zza(zzabd paramzzabd)
  {
    paramzzabd = zzc(paramzzabd);
    zzaaa localzzaaa = (zzaaa)paramzzabd.zza("AutoManageHelper", zzaaa.class);
    if (localzzaaa != null) {
      return localzzaaa;
    }
    return new zzaaa(paramzzabd);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < this.zzazN.size())
    {
      ((zzaaa.zza)this.zzazN.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    boolean bool = this.mStarted;
    String str = String.valueOf(this.zzazN);
    new StringBuilder(String.valueOf(str).length() + 14).append("onStart ").append(bool).append(" ").append(str);
    if (!this.zzazZ)
    {
      int i = 0;
      while (i < this.zzazN.size())
      {
        ((zzaaa.zza)this.zzazN.valueAt(i)).zzazP.connect();
        i += 1;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < this.zzazN.size())
    {
      ((zzaaa.zza)this.zzazN.valueAt(i)).zzazP.disconnect();
      i += 1;
    }
  }
  
  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zzazN.indexOfKey(paramInt) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzac.zza(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      bool1 = this.mStarted;
      boolean bool2 = this.zzazZ;
      new StringBuilder(54).append("starting AutoManage for client ").append(paramInt).append(" ").append(bool1).append(" ").append(bool2);
      paramOnConnectionFailedListener = new zzaaa.zza(this, paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      this.zzazN.put(paramInt, paramOnConnectionFailedListener);
      if ((this.mStarted) && (!this.zzazZ))
      {
        paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
        new StringBuilder(String.valueOf(paramOnConnectionFailedListener).length() + 11).append("connecting ").append(paramOnConnectionFailedListener);
        paramGoogleApiClient.connect();
      }
      return;
    }
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (zzaaa.zza)this.zzazN.get(paramInt);
      } while (localObject == null);
      zzcA(paramInt);
      localObject = ((zzaaa.zza)localObject).zzazQ;
    } while (localObject == null);
    ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
  }
  
  public void zzcA(int paramInt)
  {
    zzaaa.zza localzza = (zzaaa.zza)this.zzazN.get(paramInt);
    this.zzazN.remove(paramInt);
    if (localzza != null) {
      localzza.zzvy();
    }
  }
  
  protected void zzvx()
  {
    int i = 0;
    while (i < this.zzazN.size())
    {
      ((zzaaa.zza)this.zzazN.valueAt(i)).zzazP.connect();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaa
 * JD-Core Version:    0.7.0.1
 */