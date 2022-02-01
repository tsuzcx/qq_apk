package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

final class zzbh
  implements Channel.GetOutputStreamResult
{
  private final OutputStream zzcu;
  private final Status zzp;
  
  zzbh(Status paramStatus, @Nullable OutputStream paramOutputStream)
  {
    AppMethodBeat.i(101055);
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzcu = paramOutputStream;
    AppMethodBeat.o(101055);
  }
  
  @Nullable
  public final OutputStream getOutputStream()
  {
    return this.zzcu;
  }
  
  public final Status getStatus()
  {
    return this.zzp;
  }
  
  public final void release()
  {
    AppMethodBeat.i(101056);
    if (this.zzcu != null) {
      try
      {
        this.zzcu.close();
        AppMethodBeat.o(101056);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(101056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbh
 * JD-Core Version:    0.7.0.1
 */