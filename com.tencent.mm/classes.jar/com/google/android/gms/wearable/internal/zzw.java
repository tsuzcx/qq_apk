package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.InputStream;

public final class zzw
  extends InputStream
{
  private final InputStream zzbUh;
  private volatile zzr zzbUi;
  
  public zzw(InputStream paramInputStream)
  {
    this.zzbUh = ((InputStream)zzac.zzw(paramInputStream));
  }
  
  private int zzpv(int paramInt)
  {
    if (paramInt == -1)
    {
      zzr localzzr = this.zzbUi;
      if (localzzr != null) {
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzr.zzbTY, localzzr.zzbTZ);
      }
    }
    return paramInt;
  }
  
  public final int available()
  {
    return this.zzbUh.available();
  }
  
  public final void close()
  {
    this.zzbUh.close();
  }
  
  public final void mark(int paramInt)
  {
    this.zzbUh.mark(paramInt);
  }
  
  public final boolean markSupported()
  {
    return this.zzbUh.markSupported();
  }
  
  public final int read()
  {
    return zzpv(this.zzbUh.read());
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return zzpv(this.zzbUh.read(paramArrayOfByte));
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzpv(this.zzbUh.read(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public final void reset()
  {
    this.zzbUh.reset();
  }
  
  public final long skip(long paramLong)
  {
    return this.zzbUh.skip(paramLong);
  }
  
  final zzad zzUt()
  {
    return new zzw.1(this);
  }
  
  final void zza(zzr paramzzr)
  {
    this.zzbUi = ((zzr)zzac.zzw(paramzzr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzw
 * JD-Core Version:    0.7.0.1
 */