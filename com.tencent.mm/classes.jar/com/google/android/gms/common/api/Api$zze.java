package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzf.zzf;
import com.google.android.gms.common.internal.zzr;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public abstract interface Api$zze
  extends Api.zzb
{
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void zza(zzf.zzf paramzzf);
  
  public abstract void zza(zzr paramzzr, Set<Scope> paramSet);
  
  public abstract boolean zzrd();
  
  public abstract boolean zzrr();
  
  public abstract Intent zzrs();
  
  public abstract boolean zzvh();
  
  public abstract IBinder zzvi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.Api.zze
 * JD-Core Version:    0.7.0.1
 */