package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<Object> jVK;
  private static final char[] mnY;
  private static final String[] mnZ;
  
  static
  {
    AppMethodBeat.i(135362);
    jVK = new HashSet();
    mnY = new char[] { 60, 62, 34, 39, 38, 32, 39 };
    mnZ = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;" };
    AppMethodBeat.o(135362);
  }
  
  public static String Ru(String paramString)
  {
    AppMethodBeat.i(135356);
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramString.length();
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < mnY.length)
      {
        String str = mnZ[j];
        int k = 0;
        while ((k < str.length()) && (i + k < m) && (str.charAt(k) == paramString.charAt(i + k))) {
          k += 1;
        }
        if (k == str.length()) {
          break;
        }
        j += 1;
      }
      if (j != mnY.length)
      {
        localStringBuffer.append(mnY[j]);
        i = mnZ[j].length() + i;
      }
      else
      {
        localStringBuffer.append(paramString.charAt(i));
        i += 1;
      }
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(135356);
    return paramString;
  }
  
  public static String Rv(String paramString)
  {
    AppMethodBeat.i(135357);
    if (paramString == null)
    {
      AppMethodBeat.o(135357);
      return null;
    }
    paramString = paramString.replace(' ', '\n').replace(' ', '\n');
    AppMethodBeat.o(135357);
    return paramString;
  }
  
  public static void bh(Object paramObject)
  {
    AppMethodBeat.i(135353);
    jVK.remove(paramObject);
    AppMethodBeat.o(135353);
  }
  
  @Deprecated
  public static void bxi()
  {
    AppMethodBeat.i(135354);
    l.bxi();
    AppMethodBeat.o(135354);
  }
  
  @Deprecated
  public static l.a bxj()
  {
    AppMethodBeat.i(193525);
    l.a locala = l.bxj();
    AppMethodBeat.o(193525);
    return locala;
  }
  
  public static long bxm()
  {
    AppMethodBeat.i(135350);
    long l = bs.aNx();
    AppMethodBeat.o(135350);
    return l;
  }
  
  public static <T> T cF(T paramT)
  {
    AppMethodBeat.i(135352);
    jVK.add(paramT);
    AppMethodBeat.o(135352);
    return paramT;
  }
  
  public static String d(ComponentName paramComponentName)
  {
    AppMethodBeat.i(135358);
    if (paramComponentName == null)
    {
      AppMethodBeat.o(135358);
      return "[UNKNOWN]";
    }
    PackageManager localPackageManager = ai.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(135358);
      return "[UNKNOWN]";
    }
    try
    {
      paramComponentName = localPackageManager.getActivityInfo(paramComponentName, 128);
      if (paramComponentName != null)
      {
        paramComponentName = paramComponentName.taskAffinity;
        AppMethodBeat.o(135358);
        return paramComponentName;
      }
    }
    catch (Exception paramComponentName)
    {
      ac.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[] { paramComponentName });
      AppMethodBeat.o(135358);
    }
    return "[UNKNOWN]";
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135351);
    paramVarArgs = ai.getResources().getString(paramInt, paramVarArgs);
    AppMethodBeat.o(135351);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.e
 * JD-Core Version:    0.7.0.1
 */