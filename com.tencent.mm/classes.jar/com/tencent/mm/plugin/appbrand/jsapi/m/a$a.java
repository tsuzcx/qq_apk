package com.tencent.mm.plugin.appbrand.jsapi.m;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

 enum a$a
{
  final DateFormat gzF;
  
  private a$a(DateFormat paramDateFormat)
  {
    this.gzF = paramDateFormat;
  }
  
  static a uA(String paramString)
  {
    int i = 0;
    paramString = paramString.substring(0, Math.max(0, Math.min(paramString.length(), 5))).toLowerCase();
    switch (paramString.hashCode())
    {
    default: 
      label60:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return gzD;
        if (!paramString.equals("year")) {
          break label60;
        }
        continue;
        if (!paramString.equals("month")) {
          break label60;
        }
        i = 1;
        continue;
        if (!paramString.equals("day")) {
          break label60;
        }
        i = 2;
      }
    }
    return gzC;
    return gzD;
    return gzE;
  }
  
  final Date parse(String paramString)
  {
    try
    {
      paramString = this.gzF.parse(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.a
 * JD-Core Version:    0.7.0.1
 */