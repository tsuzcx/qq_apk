package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.stats.zza;
import java.util.Collections;
import java.util.List;

public class zzsf
  extends zzsa
{
  private final zzsf.zza zzael;
  private zzta zzaem;
  private final zzsr zzaen;
  private zztj zzaeo;
  
  protected zzsf(zzsc paramzzsc)
  {
    super(paramzzsc);
    this.zzaeo = new zztj(paramzzsc.zznR());
    this.zzael = new zzsf.zza(this);
    this.zzaen = new zzsf.1(this, paramzzsc);
  }
  
  private void onDisconnect()
  {
    zzmA().zznN();
  }
  
  private void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzmR();
    if (this.zzaem != null)
    {
      this.zzaem = null;
      zza("Disconnected from device AnalyticsService", paramComponentName);
      onDisconnect();
    }
  }
  
  private void zza(zzta paramzzta)
  {
    zzmR();
    this.zzaem = paramzzta;
    zzoo();
    zzmA().onServiceConnected();
  }
  
  private void zzoo()
  {
    this.zzaeo.start();
    this.zzaen.zzy(zznT().zzpq());
  }
  
  private void zzop()
  {
    zzmR();
    if (!isConnected()) {
      return;
    }
    zzbP("Inactivity, disconnecting from device AnalyticsService");
    disconnect();
  }
  
  public boolean connect()
  {
    zzmR();
    zzob();
    if (this.zzaem != null) {
      return true;
    }
    zzta localzzta = this.zzael.zzoq();
    if (localzzta != null)
    {
      this.zzaem = localzzta;
      zzoo();
      return true;
    }
    return false;
  }
  
  public void disconnect()
  {
    zzmR();
    zzob();
    try
    {
      zza.zzyJ().zza(getContext(), this.zzael);
      label22:
      if (this.zzaem != null)
      {
        this.zzaem = null;
        onDisconnect();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label22;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label22;
    }
  }
  
  public boolean isConnected()
  {
    zzmR();
    zzob();
    return this.zzaem != null;
  }
  
  public boolean zzb(zzsz paramzzsz)
  {
    zzac.zzw(paramzzsz);
    zzmR();
    zzob();
    zzta localzzta = this.zzaem;
    if (localzzta == null) {
      return false;
    }
    if (paramzzsz.zzpS()) {}
    for (String str = zznT().zzpj();; str = zznT().zzpk())
    {
      List localList = Collections.emptyList();
      try
      {
        localzzta.zza(paramzzsz.zzfE(), paramzzsz.zzpQ(), str, localList);
        zzoo();
        return true;
      }
      catch (RemoteException paramzzsz)
      {
        zzbP("Failed to send hits to AnalyticsService");
      }
    }
    return false;
  }
  
  protected void zzmS() {}
  
  public boolean zzon()
  {
    zzmR();
    zzob();
    zzta localzzta = this.zzaem;
    if (localzzta == null) {
      return false;
    }
    try
    {
      localzzta.zznK();
      zzoo();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzbP("Failed to clear hits from AnalyticsService");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzsf
 * JD-Core Version:    0.7.0.1
 */