package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzaaq
  implements zzaau
{
  private final zzaav zzaBk;
  private boolean zzaBl = false;
  
  public zzaaq(zzaav paramzzaav)
  {
    this.zzaBk = paramzzaav;
  }
  
  private <A extends Api.zzb> void zze(zzaad.zza<? extends Result, A> paramzza)
  {
    this.zzaBk.zzaAw.zzaBW.zzb(paramzza);
    Api.zze localzze = this.zzaBk.zzaAw.zzc(paramzza.zzvg());
    if ((!localzze.isConnected()) && (this.zzaBk.zzaCf.containsKey(paramzza.zzvg())))
    {
      paramzza.zzB(new Status(17));
      return;
    }
    Object localObject = localzze;
    if ((localzze instanceof zzal)) {
      localObject = ((zzal)localzze).zzyn();
    }
    paramzza.zzb((Api.zzb)localObject);
  }
  
  public void begin() {}
  
  public void connect()
  {
    if (this.zzaBl)
    {
      this.zzaBl = false;
      this.zzaBk.zza(new zzaav.zza(this)
      {
        public void zzwe()
        {
          zzaaq.zza(zzaaq.this).zzaCj.zzo(null);
        }
      });
    }
  }
  
  public boolean disconnect()
  {
    if (this.zzaBl) {
      return false;
    }
    if (this.zzaBk.zzaAw.zzwq())
    {
      this.zzaBl = true;
      Iterator localIterator = this.zzaBk.zzaAw.zzaBV.iterator();
      while (localIterator.hasNext()) {
        ((zzabx)localIterator.next()).zzxb();
      }
      return false;
    }
    this.zzaBk.zzh(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaBk.zzh(null);
    this.zzaBk.zzaCj.zzc(paramInt, this.zzaBl);
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzaad.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  public <A extends Api.zzb, T extends zzaad.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zze(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.zzaBk.zza(new zzaaq.1(this, this));
    }
    return paramT;
  }
  
  void zzwd()
  {
    if (this.zzaBl)
    {
      this.zzaBl = false;
      this.zzaBk.zzaAw.zzaBW.release();
      disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaq
 * JD-Core Version:    0.7.0.1
 */