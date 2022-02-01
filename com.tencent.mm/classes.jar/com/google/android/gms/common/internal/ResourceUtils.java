package com.google.android.gms.common.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ResourceUtils
{
  private static final Uri zzuw;
  
  static
  {
    AppMethodBeat.i(4742);
    zzuw = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();
    AppMethodBeat.o(4742);
  }
  
  public static Uri getDrawableUri(String paramString)
  {
    AppMethodBeat.i(4741);
    Preconditions.checkNotNull(paramString, "Resource name must not be null.");
    paramString = zzuw.buildUpon().appendPath(paramString).build();
    AppMethodBeat.o(4741);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResourceUtils
 * JD-Core Version:    0.7.0.1
 */