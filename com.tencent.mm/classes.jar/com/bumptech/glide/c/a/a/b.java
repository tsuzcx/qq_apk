package com.bumptech.glide.c.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  public static boolean aT(int paramInt1, int paramInt2)
  {
    return (paramInt1 != -2147483648) && (paramInt2 != -2147483648) && (paramInt1 <= 512) && (paramInt2 <= 384);
  }
  
  public static boolean f(Uri paramUri)
  {
    AppMethodBeat.i(76903);
    if ((paramUri != null) && ("content".equals(paramUri.getScheme())) && ("media".equals(paramUri.getAuthority())))
    {
      AppMethodBeat.o(76903);
      return true;
    }
    AppMethodBeat.o(76903);
    return false;
  }
  
  public static boolean g(Uri paramUri)
  {
    AppMethodBeat.i(76904);
    boolean bool = paramUri.getPathSegments().contains("video");
    AppMethodBeat.o(76904);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */