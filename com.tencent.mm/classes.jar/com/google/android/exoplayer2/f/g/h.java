package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  private static final Pattern aXw;
  private static final Pattern aXx;
  
  static
  {
    AppMethodBeat.i(95748);
    aXw = Pattern.compile("^NOTE(( |\t).*)?$");
    aXx = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");
    AppMethodBeat.o(95748);
  }
  
  public static void I(m paramm)
  {
    AppMethodBeat.i(95744);
    paramm = paramm.readLine();
    if ((paramm == null) || (!aXx.matcher(paramm).matches()))
    {
      paramm = new com.google.android.exoplayer2.f.f("Expected WEBVTT. Got ".concat(String.valueOf(paramm)));
      AppMethodBeat.o(95744);
      throw paramm;
    }
    AppMethodBeat.o(95744);
  }
  
  public static Matcher J(m paramm)
  {
    AppMethodBeat.i(95747);
    Object localObject;
    do
    {
      localObject = paramm.readLine();
      if (localObject == null) {
        break;
      }
      if (aXw.matcher((CharSequence)localObject).matches()) {
        for (;;)
        {
          localObject = paramm.readLine();
          if ((localObject == null) || (((String)localObject).isEmpty())) {
            break;
          }
        }
      }
      localObject = f.aXl.matcher((CharSequence)localObject);
    } while (!((Matcher)localObject).matches());
    AppMethodBeat.o(95747);
    return localObject;
    AppMethodBeat.o(95747);
    return null;
  }
  
  public static long aw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(95745);
    long l1 = 0L;
    paramString = paramString.split("\\.", 2);
    String[] arrayOfString = paramString[0].split(":");
    int j = arrayOfString.length;
    while (i < j)
    {
      l1 = l1 * 60L + Long.parseLong(arrayOfString[i]);
      i += 1;
    }
    long l2 = Long.parseLong(paramString[1]);
    AppMethodBeat.o(95745);
    return (l2 + l1 * 1000L) * 1000L;
  }
  
  public static float ax(String paramString)
  {
    AppMethodBeat.i(95746);
    if (!paramString.endsWith("%"))
    {
      paramString = new NumberFormatException("Percentages must end with %");
      AppMethodBeat.o(95746);
      throw paramString;
    }
    float f = Float.parseFloat(paramString.substring(0, paramString.length() - 1)) / 100.0F;
    AppMethodBeat.o(95746);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.h
 * JD-Core Version:    0.7.0.1
 */