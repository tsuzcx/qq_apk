package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import java.util.Arrays;
import java.util.List;

public final class m
{
  private static final List<String> iCi;
  
  static
  {
    AppMethodBeat.i(102310);
    iCi = Arrays.asList(new String[] { "scope.userLocation" });
    AppMethodBeat.o(102310);
  }
  
  public static String a(String paramString, i parami)
  {
    AppMethodBeat.i(102309);
    paramString = parami.getAppConfig().zU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(102309);
      return null;
    }
    paramString = paramString.desc;
    AppMethodBeat.o(102309);
    return paramString;
  }
  
  public static boolean a(String paramString, h paramh)
  {
    AppMethodBeat.i(102308);
    if (!iCi.contains(paramString))
    {
      AppMethodBeat.o(102308);
      return false;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(102308);
        return false;
        if (paramString.equals("scope.userLocation")) {
          i = 0;
        }
        break;
      }
    }
    boolean bool = paramh.hiT;
    AppMethodBeat.o(102308);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.m
 * JD-Core Version:    0.7.0.1
 */