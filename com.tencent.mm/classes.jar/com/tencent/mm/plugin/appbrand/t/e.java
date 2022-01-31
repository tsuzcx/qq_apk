package com.tencent.mm.plugin.appbrand.t;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<Object> hwB;
  private static final char[] iXA;
  private static final String[] iXB;
  private static final String iXz;
  
  static
  {
    AppMethodBeat.i(87422);
    iXz = ah.getPackageName();
    hwB = new HashSet();
    iXA = new char[] { 60, 62, 34, 39, 38, 32, 39 };
    iXB = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;" };
    AppMethodBeat.o(87422);
  }
  
  public static String Fp(String paramString)
  {
    AppMethodBeat.i(87417);
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramString.length();
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < iXA.length)
      {
        String str = iXB[j];
        int k = 0;
        while ((k < str.length()) && (i + k < m) && (str.charAt(k) == paramString.charAt(i + k))) {
          k += 1;
        }
        if (k == str.length()) {
          break;
        }
        j += 1;
      }
      if (j != iXA.length)
      {
        localStringBuffer.append(iXA[j]);
        i = iXB[j].length() + i;
      }
      else
      {
        localStringBuffer.append(paramString.charAt(i));
        i += 1;
      }
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(87417);
    return paramString;
  }
  
  public static String Fq(String paramString)
  {
    AppMethodBeat.i(87418);
    if (paramString == null)
    {
      AppMethodBeat.o(87418);
      return null;
    }
    paramString = paramString.replace(' ', '\n').replace(' ', '\n');
    AppMethodBeat.o(87418);
    return paramString;
  }
  
  @Deprecated
  public static void aNR()
  {
    AppMethodBeat.i(87414);
    m.aNR();
    AppMethodBeat.o(87414);
  }
  
  @Deprecated
  public static al aNS()
  {
    AppMethodBeat.i(87415);
    al localal = m.aNS();
    AppMethodBeat.o(87415);
    return localal;
  }
  
  public static void aNX()
  {
    AppMethodBeat.i(87409);
    eX(true);
    AppMethodBeat.o(87409);
  }
  
  public static long aNY()
  {
    AppMethodBeat.i(87410);
    long l = bo.aox();
    AppMethodBeat.o(87410);
    return l;
  }
  
  public static void ai(Object paramObject)
  {
    AppMethodBeat.i(87413);
    hwB.remove(paramObject);
    AppMethodBeat.o(87413);
  }
  
  public static <T> T bq(T paramT)
  {
    AppMethodBeat.i(87412);
    hwB.add(paramT);
    AppMethodBeat.o(87412);
    return paramT;
  }
  
  public static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(87420);
    int i = Math.round(paramContext.getResources().getDisplayMetrics().density * paramFloat);
    AppMethodBeat.o(87420);
    return i;
  }
  
  public static String d(ComponentName paramComponentName)
  {
    AppMethodBeat.i(87419);
    if (paramComponentName == null)
    {
      AppMethodBeat.o(87419);
      return "[UNKNOWN]";
    }
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(87419);
      return "[UNKNOWN]";
    }
    try
    {
      paramComponentName = localPackageManager.getActivityInfo(paramComponentName, 128);
      if (paramComponentName != null)
      {
        paramComponentName = paramComponentName.taskAffinity;
        AppMethodBeat.o(87419);
        return paramComponentName;
      }
    }
    catch (Exception paramComponentName)
    {
      ab.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[] { paramComponentName });
      AppMethodBeat.o(87419);
    }
    return "[UNKNOWN]";
  }
  
  public static float df(Context paramContext)
  {
    AppMethodBeat.i(87421);
    float f = 3.0F / paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(87421);
    return f;
  }
  
  public static void eX(boolean paramBoolean)
  {
    AppMethodBeat.i(154662);
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(iXz, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    ah.getContext().sendBroadcast(localIntent);
    if (!paramBoolean)
    {
      AppMethodBeat.o(154662);
      return;
    }
    localIntent = new Intent();
    localIntent.setComponent(new ComponentName(iXz, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(154662);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87411);
    paramVarArgs = ah.getResources().getString(paramInt, paramVarArgs);
    AppMethodBeat.o(87411);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.e
 * JD-Core Version:    0.7.0.1
 */