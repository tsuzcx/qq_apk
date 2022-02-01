package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.config.k;
import java.util.Arrays;
import java.util.List;

public final class q
{
  private static final List<String> mnk;
  
  static
  {
    AppMethodBeat.i(147668);
    mnk = Arrays.asList(new String[] { "scope.userLocation", "scope.camera" });
    AppMethodBeat.o(147668);
  }
  
  public static String a(String paramString, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147667);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramString = paramAppBrandRuntime.getAppConfig().NO(paramString);
        if (paramString != null) {
          break label99;
        }
        AppMethodBeat.o(147667);
        return null;
        if (paramString.equals("scope.camera")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paramAppBrandRuntime.mContext.getString(2131755948);
    AppMethodBeat.o(147667);
    return paramString;
    label99:
    paramString = paramString.desc;
    AppMethodBeat.o(147667);
    return paramString;
  }
  
  public static boolean a(String paramString, k paramk)
  {
    AppMethodBeat.i(147666);
    if (!mnk.contains(paramString))
    {
      AppMethodBeat.o(147666);
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
        AppMethodBeat.o(147666);
        return false;
        if (paramString.equals("scope.userLocation"))
        {
          i = 0;
          continue;
          if (paramString.equals("scope.camera")) {
            i = 1;
          }
        }
        break;
      }
    }
    boolean bool = paramk.kbs;
    AppMethodBeat.o(147666);
    return bool;
    AppMethodBeat.o(147666);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.q
 * JD-Core Version:    0.7.0.1
 */