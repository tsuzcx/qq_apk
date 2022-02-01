package com.bumptech.glide.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class i
{
  public static <T extends Collection<Y>, Y> T b(T paramT)
  {
    AppMethodBeat.i(77769);
    if (paramT.isEmpty())
    {
      paramT = new IllegalArgumentException("Must not be empty.");
      AppMethodBeat.o(77769);
      throw paramT;
    }
    AppMethodBeat.o(77769);
    return paramT;
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(77766);
    if (!paramBoolean)
    {
      paramString = new IllegalArgumentException(paramString);
      AppMethodBeat.o(77766);
      throw paramString;
    }
    AppMethodBeat.o(77766);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(77768);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("Must not be null or empty");
      AppMethodBeat.o(77768);
      throw paramString;
    }
    AppMethodBeat.o(77768);
    return paramString;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    AppMethodBeat.i(77767);
    if (paramT == null)
    {
      paramT = new NullPointerException(paramString);
      AppMethodBeat.o(77767);
      throw paramT;
    }
    AppMethodBeat.o(77767);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h.i
 * JD-Core Version:    0.7.0.1
 */