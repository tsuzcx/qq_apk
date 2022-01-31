package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;

final class zza$zza
{
  public final Uri uri;
  
  public zza$zza(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zza)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return zzaa.equal(((zza)paramObject).uri, this.uri);
  }
  
  public final int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.uri });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.images.zza.zza
 * JD-Core Version:    0.7.0.1
 */