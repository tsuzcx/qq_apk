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
    AppMethodBeat.i(71088);
    this.zzcy = ((OutputStream)Preconditions.checkNotNull(paramOutputStream));
    AppMethodBeat.o(71088);
  }
  
  private final IOException zza(IOException paramIOException)
  {
    AppMethodBeat.i(71094);
    zzav localzzav = this.zzcw;
    if (localzzav != null)
    {
      Log.isLoggable("ChannelOutputStream", 2);
      paramIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzav.zzg, localzzav.zzcj);
      AppMethodBeat.o(71094);
      return paramIOException;
    }
    AppMethodBeat.o(71094);
    return paramIOException;
  }
  
  public final void close()
  {
    AppMethodBeat.i(71089);
    try
    {
      this.zzcy.close();
      AppMethodBeat.o(71089);
      return;
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = zza(localIOException1);
      AppMethodBeat.o(71089);
      throw localIOException2;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(71090);
    try
    {
      this.zzcy.flush();
      AppMethodBeat.o(71090);
      return;
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = zza(localIOException1);
      AppMethodBeat.o(71090);
      throw localIOException2;
    }
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(71093);
    try
    {
      this.zzcy.write(paramInt);
      AppMethodBeat.o(71093);
      return;
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = zza(localIOException1);
      AppMethodBeat.o(71093);
      throw localIOException2;
    }
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71091);
    try
    {
      this.zzcy.write(paramArrayOfByte);
      AppMethodBeat.o(71091);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = zza(paramArrayOfByte);
      AppMethodBeat.o(71091);
      throw paramArrayOfByte;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(71092);
    try
    {
      this.zzcy.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(71092);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = zza(paramArrayOfByte);
      AppMethodBeat.o(71092);
      throw paramArrayOfByte;
    }
  }
  
  final void zzc(zzav paramzzav)
  {
    this.zzcw = paramzzav;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbl
 * JD-Core Version:    0.7.0.1
 */