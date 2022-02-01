package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

public final class zzbl
  extends OutputStream
{
  @Nullable
  private volatile zzav zzcw;
  private final OutputStream zzcy;
  
  public zzbl(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(101071);
    this.zzcy = ((OutputStream)Preconditions.checkNotNull(paramOutputStream));
    AppMethodBeat.o(101071);
  }
  
  private final IOException zza(IOException paramIOException)
  {
    AppMethodBeat.i(101077);
    zzav localzzav = this.zzcw;
    if (localzzav != null)
    {
      Log.isLoggable("ChannelOutputStream", 2);
      paramIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzav.zzg, localzzav.zzcj);
      AppMethodBeat.o(101077);
      return paramIOException;
    }
    AppMethodBeat.o(101077);
    return paramIOException;
  }
  
  public final void close()
  {
    AppMethodBeat.i(101072);
    try
    {
      this.zzcy.close();
      AppMethodBeat.o(101072);
      return;
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = zza(localIOException1);
      AppMethodBeat.o(101072);
      throw localIOException2;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(101073);
    try
    {
      this.zzcy.flush();
      AppMethodBeat.o(101073);
      return;
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = zza(localIOException1);
      AppMethodBeat.o(101073);
      throw localIOException2;
    }
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(101076);
    try
    {
      this.zzcy.write(paramInt);
      AppMethodBeat.o(101076);
      return;
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = zza(localIOException1);
      AppMethodBeat.o(101076);
      throw localIOException2;
    }
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101074);
    try
    {
      this.zzcy.write(paramArrayOfByte);
      AppMethodBeat.o(101074);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = zza(paramArrayOfByte);
      AppMethodBeat.o(101074);
      throw paramArrayOfByte;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101075);
    try
    {
      this.zzcy.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(101075);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = zza(paramArrayOfByte);
      AppMethodBeat.o(101075);
      throw paramArrayOfByte;
    }
  }
  
  final void zzc(zzav paramzzav)
  {
    this.zzcw = paramzzav;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbl
 * JD-Core Version:    0.7.0.1
 */