package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.e;
import com.tencent.mm.plugin.appbrand.config.l;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class q
{
  private static final List<String> qzP;
  
  static
  {
    AppMethodBeat.i(147668);
    qzP = Arrays.asList(new String[] { "scope.userLocation", "scope.camera" });
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
        paramString = paramAppBrandRuntime.getAppConfig().aeJ(paramString);
        if (paramString != null) {
          break label100;
        }
        AppMethodBeat.o(147667);
        return null;
        if (paramString.equals("scope.camera")) {
          i = 0;
        }
        break;
      }
    }
    paramString = paramAppBrandRuntime.mContext.getString(a.g.appbrand_camera_permission_authorize_desc);
    AppMethodBeat.o(147667);
    return paramString;
    label100:
    paramString = paramString.desc;
    AppMethodBeat.o(147667);
    return paramString;
  }
  
  public static boolean a(String paramString, l paraml)
  {
    int j = 0;
    AppMethodBeat.i(147666);
    if (!qzP.contains(paramString))
    {
      if (!(paraml instanceof AppBrandSysConfigLU))
      {
        AppMethodBeat.o(147666);
        return false;
      }
      String[] arrayOfString = ((AppBrandSysConfigLU)paraml).cxL.nXz;
      if (arrayOfString == null)
      {
        AppMethodBeat.o(147666);
        return false;
      }
      int k = arrayOfString.length;
      i = 0;
      if (i >= k) {
        break label179;
      }
      if (!Objects.equals(arrayOfString[i], paramString)) {}
    }
    label179:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(147666);
        return false;
        i += 1;
        break;
      }
      switch (paramString.hashCode())
      {
      }
      label124:
      for (i = -1;; i = j) {
        switch (i)
        {
        default: 
          AppMethodBeat.o(147666);
          return true;
          if (!paramString.equals("scope.userLocation")) {
            break label124;
          }
        }
      }
      boolean bool = paraml.nYN;
      AppMethodBeat.o(147666);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.q
 * JD-Core Version:    0.7.0.1
 */