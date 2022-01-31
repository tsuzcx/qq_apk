package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

 enum a$a
{
  final DateFormat hWG;
  
  static
  {
    AppMethodBeat.i(126342);
    hWD = new a("YEAR", 0, new SimpleDateFormat("yyyy", Locale.US));
    hWE = new a("MONTH", 1, new SimpleDateFormat("yyyy-MM", Locale.US));
    hWF = new a("DAY", 2, new SimpleDateFormat("yyyy-MM-dd", Locale.US));
    hWH = new a[] { hWD, hWE, hWF };
    AppMethodBeat.o(126342);
  }
  
  private a$a(DateFormat paramDateFormat)
  {
    this.hWG = paramDateFormat;
  }
  
  static a CL(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(126340);
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
        paramString = hWE;
        AppMethodBeat.o(126340);
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
    paramString = hWD;
    AppMethodBeat.o(126340);
    return paramString;
    paramString = hWE;
    AppMethodBeat.o(126340);
    return paramString;
    paramString = hWF;
    AppMethodBeat.o(126340);
    return paramString;
  }
  
  final Date parse(String paramString)
  {
    AppMethodBeat.i(126341);
    try
    {
      paramString = this.hWG.parse(paramString);
      AppMethodBeat.o(126341);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126341);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a.a
 * JD-Core Version:    0.7.0.1
 */