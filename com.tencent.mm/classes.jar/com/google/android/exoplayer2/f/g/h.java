package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  private static final Pattern bnq;
  private static final Pattern bnr;
  
  static
  {
    AppMethodBeat.i(92916);
    bnq = Pattern.compile("^NOTE(( |\t).*)?$");
    bnr = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");
    AppMethodBeat.o(92916);
  }
  
  public static void I(m paramm)
  {
    AppMethodBeat.i(92912);
    paramm = paramm.readLine();
    if ((paramm == null) || (!bnr.matcher(paramm).matches()))
    {
      paramm = new com.google.android.exoplayer2.f.f("Expected WEBVTT. Got ".concat(String.valueOf(paramm)));
      AppMethodBeat.o(92912);
      throw paramm;
    }
    AppMethodBeat.o(92912);
  }
  
  public static Matcher J(m paramm)
  {
    AppMethodBeat.i(92915);
    Object localObject;
    do
    {
      localObject = paramm.readLine();
      if (localObject == null) {
        break;
      }
      if (bnq.matcher((CharSequence)localObject).matches()) {
        for (;;)
        {
          localObject = paramm.readLine();
          if ((localObject == null) || (((String)localObject).isEmpty())) {
            break;
          }
        }
      }
      localObject = f.bng.matcher((CharSequence)localObject);
    } while (!((Matcher)localObject).matches());
    AppMethodBeat.o(92915);
    return localObject;
    AppMethodBeat.o(92915);
    return null;
  }
  
  public static long by(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(92913);
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
    AppMethodBeat.o(92913);
    return (l2 + l1 * 1000L) * 1000L;
  }
  
  public static float bz(String paramString)
  {
    AppMethodBeat.i(92914);
    if (!paramString.endsWith("%"))
    {
      paramString = new NumberFormatException("Percentages must end with %");
      AppMethodBeat.o(92914);
      throw paramString;
    }
    float f = Float.parseFloat(paramString.substring(0, paramString.length() - 1)) / 100.0F;
    AppMethodBeat.o(92914);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.h
 * JD-Core Version:    0.7.0.1
 */