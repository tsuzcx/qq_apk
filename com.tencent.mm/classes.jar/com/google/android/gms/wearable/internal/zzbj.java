package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class zzbj
  extends InputStream
{
  private final InputStream zzcv;
  private volatile zzav zzcw;
  
  public zzbj(InputStream paramInputStream)
  {
    AppMethodBeat.i(101058);
    this.zzcv = ((InputStream)Preconditions.checkNotNull(paramInputStream));
    AppMethodBeat.o(101058);
  }
  
  private final int zza(int paramInt)
  {
    AppMethodBeat.i(101069);
    if (paramInt == -1)
    {
      Object localObject = this.zzcw;
      if (localObject != null)
      {
        localObject = new ChannelIOException("Channel closed unexpectedly before stream was finished", ((zzav)localObject).zzg, ((zzav)localObject).zzcj);
        AppMethodBeat.o(101069);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(101069);
    return paramInt;
  }
  
  public final int available()
  {
    AppMethodBeat.i(101060);
    int i = this.zzcv.available();
    AppMethodBeat.o(101060);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(101061);
    this.zzcv.close();
    AppMethodBeat.o(101061);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(101062);
    this.zzcv.mark(paramInt);
    AppMethodBeat.o(101062);
  }
  
  public final boolean markSupported()
  {
    AppMethodBeat.i(101063);
    boolean bool = this.zzcv.markSupported();
    AppMethodBeat.o(101063);
    return bool;
  }
  
  public final int read()
  {
    AppMethodBeat.i(101064);
    int i = zza(this.zzcv.read());
    AppMethodBeat.o(101064);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101065);
    int i = zza(this.zzcv.read(paramArrayOfByte));
    AppMethodBeat.o(101065);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101066);
    paramInt1 = zza(this.zzcv.read(paramArrayOfByte, paramInt1, paramInt2));
    AppMethodBeat.o(101066);
    return paramInt1;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(101067);
    this.zzcv.reset();
    AppMethodBeat.o(101067);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(101068);
    paramLong = this.zzcv.skip(paramLong);
    AppMethodBeat.o(101068);
    return paramLong;
  }
  
  final void zza(zzav paramzzav)
  {
    AppMethodBeat.i(101059);
    this.zzcw = ((zzav)Preconditions.checkNotNull(paramzzav));
    AppMethodBeat.o(101059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbj
 * JD-Core Version:    0.7.0.1
 */