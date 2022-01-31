package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import javax.annotation.Nullable;

public final class zzbj
  extends InputStream
{
  private final InputStream zzcv;
  @Nullable
  private volatile zzav zzcw;
  
  public zzbj(InputStream paramInputStream)
  {
    AppMethodBeat.i(71075);
    this.zzcv = ((InputStream)Preconditions.checkNotNull(paramInputStream));
    AppMethodBeat.o(71075);
  }
  
  private final int zza(int paramInt)
  {
    AppMethodBeat.i(71086);
    if (paramInt == -1)
    {
      Object localObject = this.zzcw;
      if (localObject != null)
      {
        localObject = new ChannelIOException("Channel closed unexpectedly before stream was finished", ((zzav)localObject).zzg, ((zzav)localObject).zzcj);
        AppMethodBeat.o(71086);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(71086);
    return paramInt;
  }
  
  public final int available()
  {
    AppMethodBeat.i(71077);
    int i = this.zzcv.available();
    AppMethodBeat.o(71077);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(71078);
    this.zzcv.close();
    AppMethodBeat.o(71078);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(71079);
    this.zzcv.mark(paramInt);
    AppMethodBeat.o(71079);
  }
  
  public final boolean markSupported()
  {
    AppMethodBeat.i(71080);
    boolean bool = this.zzcv.markSupported();
    AppMethodBeat.o(71080);
    return bool;
  }
  
  public final int read()
  {
    AppMethodBeat.i(71081);
    int i = zza(this.zzcv.read());
    AppMethodBeat.o(71081);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71082);
    int i = zza(this.zzcv.read(paramArrayOfByte));
    AppMethodBeat.o(71082);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71083);
    paramInt1 = zza(this.zzcv.read(paramArrayOfByte, paramInt1, paramInt2));
    AppMethodBeat.o(71083);
    return paramInt1;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(71084);
    this.zzcv.reset();
    AppMethodBeat.o(71084);
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(71085);
    paramLong = this.zzcv.skip(paramLong);
    AppMethodBeat.o(71085);
    return paramLong;
  }
  
  final void zza(zzav paramzzav)
  {
    AppMethodBeat.i(71076);
    this.zzcw = ((zzav)Preconditions.checkNotNull(paramzzav));
    AppMethodBeat.o(71076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbj
 * JD-Core Version:    0.7.0.1
 */