package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class zzaax$zza<O extends Api.ApiOptions>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzaah
{
  private final Api.zze zzaAJ;
  private boolean zzaBL;
  private final zzaal zzaCA;
  private final Set<zzaab> zzaCB = new HashSet();
  private final Map<zzabh.zzb<?>, zzabn> zzaCC = new HashMap();
  private final int zzaCD;
  private final zzabr zzaCE;
  private ConnectionResult zzaCF = null;
  private final Queue<zzzx> zzaCy = new LinkedList();
  private final Api.zzb zzaCz;
  private final zzzz<O> zzayU;
  
  public zzaax$zza(zzc<O> paramzzc)
  {
    Object localObject;
    this.zzaAJ = localObject.buildApiClient(zzaax.zza(paramzzc).getLooper(), this);
    if ((this.zzaAJ instanceof zzal)) {}
    for (this.zzaCz = ((zzal)this.zzaAJ).zzyn();; this.zzaCz = this.zzaAJ)
    {
      this.zzayU = localObject.getApiKey();
      this.zzaCA = new zzaal();
      this.zzaCD = localObject.getInstanceId();
      if (!this.zzaAJ.zzrd()) {
        break;
      }
      this.zzaCE = localObject.createSignInCoordinator(zzaax.zzb(paramzzc), zzaax.zza(paramzzc));
      return;
    }
    this.zzaCE = null;
  }
  
  private void zzb(zzzx paramzzzx)
  {
    paramzzzx.zza(this.zzaCA, zzrd());
    try
    {
      paramzzzx.zza(this);
      return;
    }
    catch (DeadObjectException paramzzzx)
    {
      onConnectionSuspended(1);
      this.zzaAJ.disconnect();
    }
  }
  
  private void zzj(ConnectionResult paramConnectionResult)
  {
    Iterator localIterator = this.zzaCB.iterator();
    while (localIterator.hasNext()) {
      ((zzaab)localIterator.next()).zza(this.zzayU, paramConnectionResult);
    }
    this.zzaCB.clear();
  }
  
  private void zzwF()
  {
    zzwJ();
    zzj(ConnectionResult.zzayj);
    zzwL();
    Iterator localIterator = this.zzaCC.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localIterator.next();
      }
      try
      {
        new TaskCompletionSource();
      }
      catch (DeadObjectException localDeadObjectException)
      {
        onConnectionSuspended(1);
        this.zzaAJ.disconnect();
        zzwH();
        zzwM();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
  }
  
  private void zzwG()
  {
    zzwJ();
    this.zzaBL = true;
    this.zzaCA.zzwa();
    zzaax.zza(this.zzaCx).sendMessageDelayed(Message.obtain(zzaax.zza(this.zzaCx), 9, this.zzayU), zzaax.zzc(this.zzaCx));
    zzaax.zza(this.zzaCx).sendMessageDelayed(Message.obtain(zzaax.zza(this.zzaCx), 11, this.zzayU), zzaax.zzd(this.zzaCx));
    zzaax.zza(this.zzaCx, -1);
  }
  
  private void zzwH()
  {
    while ((this.zzaAJ.isConnected()) && (!this.zzaCy.isEmpty())) {
      zzb((zzzx)this.zzaCy.remove());
    }
  }
  
  private void zzwL()
  {
    if (this.zzaBL)
    {
      zzaax.zza(this.zzaCx).removeMessages(11, this.zzayU);
      zzaax.zza(this.zzaCx).removeMessages(9, this.zzayU);
      this.zzaBL = false;
    }
  }
  
  private void zzwM()
  {
    zzaax.zza(this.zzaCx).removeMessages(12, this.zzayU);
    zzaax.zza(this.zzaCx).sendMessageDelayed(zzaax.zza(this.zzaCx).obtainMessage(12, this.zzayU), zzaax.zzh(this.zzaCx));
  }
  
  public void connect()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    if ((this.zzaAJ.isConnected()) || (this.zzaAJ.isConnecting())) {
      return;
    }
    if ((this.zzaAJ.zzvh()) && (zzaax.zzi(this.zzaCx) != 0))
    {
      zzaax.zza(this.zzaCx, zzaax.zzg(this.zzaCx).isGooglePlayServicesAvailable(zzaax.zzb(this.zzaCx)));
      if (zzaax.zzi(this.zzaCx) != 0)
      {
        onConnectionFailed(new ConnectionResult(zzaax.zzi(this.zzaCx), null));
        return;
      }
    }
    zzaax.zzb localzzb = new zzaax.zzb(this.zzaCx, this.zzaAJ, this.zzayU);
    if (this.zzaAJ.zzrd()) {
      this.zzaCE.zza(localzzb);
    }
    this.zzaAJ.zza(localzzb);
  }
  
  public int getInstanceId()
  {
    return this.zzaCD;
  }
  
  boolean isConnected()
  {
    return this.zzaAJ.isConnected();
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (Looper.myLooper() == zzaax.zza(this.zzaCx).getLooper())
    {
      zzwF();
      return;
    }
    zzaax.zza(this.zzaCx).post(new zzaax.zza.1(this));
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    if (this.zzaCE != null) {
      this.zzaCE.zzwY();
    }
    zzwJ();
    zzaax.zza(this.zzaCx, -1);
    zzj(paramConnectionResult);
    if (paramConnectionResult.getErrorCode() == 4) {
      zzD(zzaax.zzwD());
    }
    do
    {
      return;
      if (this.zzaCy.isEmpty())
      {
        this.zzaCF = paramConnectionResult;
        return;
      }
      synchronized (zzaax.zzwE())
      {
        if ((zzaax.zze(this.zzaCx) != null) && (zzaax.zzf(this.zzaCx).contains(this.zzayU)))
        {
          zzaax.zze(this.zzaCx).zzb(paramConnectionResult, this.zzaCD);
          return;
        }
      }
    } while (this.zzaCx.zzc(paramConnectionResult, this.zzaCD));
    if (paramConnectionResult.getErrorCode() == 18) {
      this.zzaBL = true;
    }
    if (this.zzaBL)
    {
      zzaax.zza(this.zzaCx).sendMessageDelayed(Message.obtain(zzaax.zza(this.zzaCx), 9, this.zzayU), zzaax.zzc(this.zzaCx));
      return;
    }
    paramConnectionResult = String.valueOf(this.zzayU.zzvw());
    zzD(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    if (Looper.myLooper() == zzaax.zza(this.zzaCx).getLooper())
    {
      zzwG();
      return;
    }
    zzaax.zza(this.zzaCx).post(new zzaax.zza.2(this));
  }
  
  public void resume()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    if (this.zzaBL) {
      connect();
    }
  }
  
  public void signOut()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    zzD(zzaax.zzaCn);
    this.zzaCA.zzvZ();
    Iterator localIterator = this.zzaCC.keySet().iterator();
    while (localIterator.hasNext()) {
      zza(new zzzx.zze((zzabh.zzb)localIterator.next(), new TaskCompletionSource()));
    }
    zzj(new ConnectionResult(4));
    this.zzaAJ.disconnect();
  }
  
  public void zzD(Status paramStatus)
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    Iterator localIterator = this.zzaCy.iterator();
    while (localIterator.hasNext()) {
      ((zzzx)localIterator.next()).zzz(paramStatus);
    }
    this.zzaCy.clear();
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    if (Looper.myLooper() == zzaax.zza(this.zzaCx).getLooper())
    {
      onConnectionFailed(paramConnectionResult);
      return;
    }
    zzaax.zza(this.zzaCx).post(new zzaax.zza.3(this, paramConnectionResult));
  }
  
  public void zza(zzzx paramzzzx)
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    if (this.zzaAJ.isConnected())
    {
      zzb(paramzzzx);
      zzwM();
      return;
    }
    this.zzaCy.add(paramzzzx);
    if ((this.zzaCF != null) && (this.zzaCF.hasResolution()))
    {
      onConnectionFailed(this.zzaCF);
      return;
    }
    connect();
  }
  
  public void zzb(zzaab paramzzaab)
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    this.zzaCB.add(paramzzaab);
  }
  
  public void zzi(ConnectionResult paramConnectionResult)
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    this.zzaAJ.disconnect();
    onConnectionFailed(paramConnectionResult);
  }
  
  public boolean zzrd()
  {
    return this.zzaAJ.zzrd();
  }
  
  public Api.zze zzvU()
  {
    return this.zzaAJ;
  }
  
  public Map<zzabh.zzb<?>, zzabn> zzwI()
  {
    return this.zzaCC;
  }
  
  public void zzwJ()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    this.zzaCF = null;
  }
  
  public ConnectionResult zzwK()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    return this.zzaCF;
  }
  
  public void zzwN()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    if ((this.zzaAJ.isConnected()) && (this.zzaCC.size() == 0))
    {
      if (this.zzaCA.zzvY()) {
        zzwM();
      }
    }
    else {
      return;
    }
    this.zzaAJ.disconnect();
  }
  
  zzbai zzwO()
  {
    if (this.zzaCE == null) {
      return null;
    }
    return this.zzaCE.zzwO();
  }
  
  public void zzwn()
  {
    zzac.zza(zzaax.zza(this.zzaCx));
    if (this.zzaBL)
    {
      zzwL();
      if (zzaax.zzg(this.zzaCx).isGooglePlayServicesAvailable(zzaax.zzb(this.zzaCx)) != 18) {
        break label71;
      }
    }
    label71:
    for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
    {
      zzD(localStatus);
      this.zzaAJ.disconnect();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaax.zza
 * JD-Core Version:    0.7.0.1
 */