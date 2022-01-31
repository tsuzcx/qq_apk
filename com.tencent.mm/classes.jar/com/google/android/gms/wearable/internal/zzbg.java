package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

final class zzbg
  implements Channel.GetInputStreamResult
{
  private final InputStream zzct;
  private final Status zzp;
  
  zzbg(Status paramStatus, @Nullable InputStream paramInputStream)
  {
    AppMethodBeat.i(71070);
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzct = paramInputStream;
    AppMethodBeat.o(71070);
  }
  
  @Nullable
  public final InputStream getInputStream()
  {
    return this.zzct;
  }
  
  public final Status getStatus()
  {
    return this.zzp;
  }
  
  public final void release()
  {
    AppMethodBeat.i(71071);
    if (this.zzct != null) {
      try
      {
        this.zzct.close();
        AppMethodBeat.o(71071);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(71071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbg
 * JD-Core Version:    0.7.0.1
 */