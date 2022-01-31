package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg
  extends zze.zza
{
  private static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(90479);
    CONTENT_URI = Uri.parse("content://com.google.settings/partner");
    AppMethodBeat.o(90479);
  }
  
  public static int getInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(90478);
    paramContentResolver = getString(paramContentResolver, paramString);
    paramInt = i;
    if (paramContentResolver != null) {}
    try
    {
      paramInt = Integer.parseInt(paramContentResolver);
      AppMethodBeat.o(90478);
      return paramInt;
    }
    catch (NumberFormatException paramContentResolver)
    {
      for (;;)
      {
        paramInt = i;
      }
    }
  }
  
  private static String getString(ContentResolver paramContentResolver, String paramString)
  {
    AppMethodBeat.i(90476);
    paramContentResolver = zza(paramContentResolver, CONTENT_URI, paramString);
    AppMethodBeat.o(90476);
    return paramContentResolver;
  }
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    AppMethodBeat.i(90477);
    paramContentResolver = getString(paramContentResolver, paramString1);
    if (paramContentResolver == null) {}
    for (;;)
    {
      AppMethodBeat.o(90477);
      return paramString2;
      paramString2 = paramContentResolver;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzg
 * JD-Core Version:    0.7.0.1
 */