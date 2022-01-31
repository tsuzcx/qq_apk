package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzx
  extends OutputStream
{
  private volatile zzr zzbUi;
  private final OutputStream zzbUk;
  
  public zzx(OutputStream paramOutputStream)
  {
    this.zzbUk = ((OutputStream)zzac.zzw(paramOutputStream));
  }
  
  private IOException zza(IOException paramIOException)
  {
    zzr localzzr = this.zzbUi;
    if (localzzr != null)
    {
      Log.isLoggable("ChannelOutputStream", 2);
      paramIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzr.zzbTY, localzzr.zzbTZ);
    }
    return paramIOException;
  }
  
  public final void close()
  {
    try
    {
      this.zzbUk.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }
  
  public final void flush()
  {
    try
    {
      this.zzbUk.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }
  
  public final void write(int paramInt)
  {
    try
    {
      this.zzbUk.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    try
    {
      this.zzbUk.write(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw zza(paramArrayOfByte);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.zzbUk.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw zza(paramArrayOfByte);
    }
  }
  
  final zzad zzUt()
  {
    return new zzx.1(this);
  }
  
  final void zzc(zzr paramzzr)
  {
    this.zzbUi = paramzzr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzx
 * JD-Core Version:    0.7.0.1
 */