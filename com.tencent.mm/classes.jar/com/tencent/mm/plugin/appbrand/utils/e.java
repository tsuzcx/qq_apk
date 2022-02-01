package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<Object> kpY;
  private static final char[] mOA;
  private static final String[] mOB;
  
  static
  {
    AppMethodBeat.i(135362);
    kpY = new HashSet();
    mOA = new char[] { 60, 62, 34, 39, 38, 32, 39 };
    mOB = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;" };
    AppMethodBeat.o(135362);
  }
  
  public static String Va(String paramString)
  {
    AppMethodBeat.i(135356);
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramString.length();
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < mOA.length)
      {
        String str = mOB[j];
        int k = 0;
        while ((k < str.length()) && (i + k < m) && (str.charAt(k) == paramString.charAt(i + k))) {
          k += 1;
        }
        if (k == str.length()) {
          break;
        }
        j += 1;
      }
      if (j != mOA.length)
      {
        localStringBuffer.append(mOA[j]);
        i = mOB[j].length() + i;
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
  
  public static String Vb(String paramString)
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
  
  @Deprecated
  public static void bBo()
  {
    AppMethodBeat.i(135354);
    m.bBo();
    AppMethodBeat.o(135354);
  }
  
  @Deprecated
  public static m.a bBp()
  {
    AppMethodBeat.i(197446);
    m.a locala = m.bBp();
    AppMethodBeat.o(197446);
    return locala;
  }
  
  public static void bj(Object paramObject)
  {
    AppMethodBeat.i(135353);
    kpY.remove(paramObject);
    AppMethodBeat.o(135353);
  }
  
  public static <T> T cH(T paramT)
  {
    AppMethodBeat.i(135352);
    kpY.add(paramT);
    AppMethodBeat.o(135352);
    return paramT;
  }
  
  public static long currentTime()
  {
    AppMethodBeat.i(135350);
    long l = bt.aQJ();
    AppMethodBeat.o(135350);
    return l;
  }
  
  public static String d(ComponentName paramComponentName)
  {
    AppMethodBeat.i(135358);
    if (paramComponentName == null)
    {
      AppMethodBeat.o(135358);
      return "[UNKNOWN]";
    }
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
      ad.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[] { paramComponentName });
      AppMethodBeat.o(135358);
    }
    return "[UNKNOWN]";
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135351);
    paramVarArgs = aj.getResources().getString(paramInt, paramVarArgs);
    AppMethodBeat.o(135351);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.e
 * JD-Core Version:    0.7.0.1
 */