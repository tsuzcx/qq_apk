package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import java.io.IOException;
import java.io.OutputStream;

final class zzu$zzb
  implements Channel.GetOutputStreamResult
{
  private final Status zzair;
  private final OutputStream zzbUg;
  
  zzu$zzb(Status paramStatus, OutputStream paramOutputStream)
  {
    this.zzair = ((Status)zzac.zzw(paramStatus));
    this.zzbUg = paramOutputStream;
  }
  
  public final OutputStream getOutputStream()
  {
    return this.zzbUg;
  }
  
  public final Status getStatus()
  {
    return this.zzair;
  }
  
  public final void release()
  {
    if (this.zzbUg != null) {}
    try
    {
      this.zzbUg.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzu.zzb
 * JD-Core Version:    0.7.0.1
 */