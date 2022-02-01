package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

 enum b$a
{
  final DateFormat bMW;
  
  static
  {
    AppMethodBeat.i(137574);
    pkU = new a("YEAR", 0, new SimpleDateFormat("yyyy", Locale.US));
    pkV = new a("MONTH", 1, new SimpleDateFormat("yyyy-MM", Locale.US));
    pkW = new a("DAY", 2, new SimpleDateFormat("yyyy-MM-dd", Locale.US));
    pkX = new a[] { pkU, pkV, pkW };
    AppMethodBeat.o(137574);
  }
  
  private b$a(DateFormat paramDateFormat)
  {
    this.bMW = paramDateFormat;
  }
  
  static a aiu(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(137572);
    paramString = paramString.substring(0, Math.max(0, Math.min(paramString.length(), 5))).toLowerCase();
    switch (paramString.hashCode())
    {
    default: 
      label68:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramString = pkV;
        AppMethodBeat.o(137572);
        return paramString;
        if (!paramString.equals("year")) {
          break label68;
        }
        continue;
        if (!paramString.equals("month")) {
          break label68;
        }
        i = 1;
        continue;
        if (!paramString.equals("day")) {
          break label68;
        }
        i = 2;
      }
    }
    paramString = pkU;
    AppMethodBeat.o(137572);
    return paramString;
    paramString = pkV;
    AppMethodBeat.o(137572);
    return paramString;
    paramString = pkW;
    AppMethodBeat.o(137572);
    return paramString;
  }
  
  final Date aiv(String paramString)
  {
    AppMethodBeat.i(137573);
    try
    {
      paramString = this.bMW.parse(paramString);
      AppMethodBeat.o(137573);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(137573);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.a
 * JD-Core Version:    0.7.0.1
 */