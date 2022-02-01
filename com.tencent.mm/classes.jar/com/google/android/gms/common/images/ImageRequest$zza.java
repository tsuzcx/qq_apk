package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageRequest$zza
{
  public final Uri uri;
  
  public ImageRequest$zza(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(11734);
    if (!(paramObject instanceof zza))
    {
      AppMethodBeat.o(11734);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(11734);
      return true;
    }
    boolean bool = Objects.equal(((zza)paramObject).uri, this.uri);
    AppMethodBeat.o(11734);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(11733);
    int i = Objects.hashCode(new Object[] { this.uri });
    AppMethodBeat.o(11733);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageRequest.zza
 * JD-Core Version:    0.7.0.1
 */