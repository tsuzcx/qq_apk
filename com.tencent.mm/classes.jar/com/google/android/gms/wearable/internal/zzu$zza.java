package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import java.io.IOException;
import java.io.InputStream;

final class zzu$zza
  implements Channel.GetInputStreamResult
{
  private final Status zzair;
  private final InputStream zzbUf;
  
  zzu$zza(Status paramStatus, InputStream paramInputStream)
  {
    this.zzair = ((Status)zzac.zzw(paramStatus));
    this.zzbUf = paramInputStream;
  }
  
  public final InputStream getInputStream()
  {
    return this.zzbUf;
  }
  
  public final Status getStatus()
  {
    return this.zzair;
  }
  
  public final void release()
  {
    if (this.zzbUf != null) {}
    try
    {
      this.zzbUf.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzu.zza
 * JD-Core Version:    0.7.0.1
 */