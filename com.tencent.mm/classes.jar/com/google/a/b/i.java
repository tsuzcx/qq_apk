package com.google.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class i
{
  public static DateFormat bw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107934);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(fA(paramInt1) + " " + fB(paramInt2), Locale.US);
    AppMethodBeat.o(107934);
    return localSimpleDateFormat;
  }
  
  private static String fA(int paramInt)
  {
    AppMethodBeat.i(107935);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Unknown DateFormat style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(107935);
      throw localIllegalArgumentException;
    case 3: 
      AppMethodBeat.o(107935);
      return "M/d/yy";
    case 2: 
      AppMethodBeat.o(107935);
      return "MMM d, yyyy";
    case 1: 
      AppMethodBeat.o(107935);
      return "MMMM d, yyyy";
    }
    AppMethodBeat.o(107935);
    return "EEEE, MMMM d, yyyy";
  }
  
  private static String fB(int paramInt)
  {
    AppMethodBeat.i(107936);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Unknown DateFormat style: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(107936);
      throw localIllegalArgumentException;
    case 3: 
      AppMethodBeat.o(107936);
      return "h:mm a";
    case 2: 
      AppMethodBeat.o(107936);
      return "h:mm:ss a";
    }
    AppMethodBeat.o(107936);
    return "h:mm:ss a z";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.a.b.i
 * JD-Core Version:    0.7.0.1
 */