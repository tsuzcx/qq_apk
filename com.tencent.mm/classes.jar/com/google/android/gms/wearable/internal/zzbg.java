package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

final class zzbg
  implements Channel.GetInputStreamResult
{
  private final InputStream zzct;
  private final Status zzp;
  
  zzbg(Status paramStatus, InputStream paramInputStream)
  {
    AppMethodBeat.i(101053);
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzct = paramInputStream;
    AppMethodBeat.o(101053);
  }
  
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
    AppMethodBeat.i(101054);
    if (this.zzct != null) {
      try
      {
        this.zzct.close();
        AppMethodBeat.o(101054);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(101054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbg
 * JD-Core Version:    0.7.0.1
 */