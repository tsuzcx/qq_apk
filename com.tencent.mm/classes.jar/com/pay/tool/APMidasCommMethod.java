package com.pay.tool;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class APMidasCommMethod
{
  private static Stack<Activity> activityStack = null;
  
  public static String MaptoString(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(253796);
    StringBuffer localStringBuffer = new StringBuffer();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
      localStringBuffer.append("&");
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(253796);
    return paramHashMap;
  }
  
  public static String MaptoString(HashMap<String, String> paramHashMap, String paramString)
  {
    AppMethodBeat.i(253797);
    StringBuffer localStringBuffer = new StringBuffer();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      localStringBuffer.append((String)((Map.Entry)paramHashMap.next()).getValue());
      localStringBuffer.append(paramString);
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(253797);
    return paramHashMap;
  }
  
  public static String dealString(String paramString)
  {
    AppMethodBeat.i(253798);
    String str = rawString(paramString);
    if (str.length() <= 3)
    {
      AppMethodBeat.o(253798);
      return paramString;
    }
    if ((str.length() > 3) && (str.length() <= 6))
    {
      paramString = paramString.substring(0, 3) + " " + paramString.substring(4, paramString.length());
      AppMethodBeat.o(253798);
      return paramString;
    }
    if ((str.length() > 6) && (str.length() <= 9))
    {
      paramString = paramString.substring(3, 6) + " " + paramString.substring(7, paramString.length());
      AppMethodBeat.o(253798);
      return paramString;
    }
    if ((str.length() > 9) && (str.length() <= 12))
    {
      paramString = paramString.substring(6, 9) + " " + paramString.substring(10, paramString.length());
      AppMethodBeat.o(253798);
      return paramString;
    }
    AppMethodBeat.o(253798);
    return paramString;
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(253812);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(253812);
    return i;
  }
  
  public static String fenToYuan(String paramString, int paramInt)
  {
    AppMethodBeat.i(253803);
    DecimalFormat localDecimalFormat = (DecimalFormat)DecimalFormat.getInstance();
    if (paramInt == 0) {
      localDecimalFormat.applyPattern("0");
    }
    try
    {
      for (;;)
      {
        paramString = localDecimalFormat.format(Float.valueOf(paramString).floatValue() / 100.0F);
        AppMethodBeat.o(253803);
        return paramString;
        if (paramInt == 1) {
          localDecimalFormat.applyPattern("0.0");
        } else if (paramInt == 2) {
          localDecimalFormat.applyPattern("0.00");
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
  }
  
  public static int getAnimId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253811);
    int i = paramContext.getApplicationContext().getResources().getIdentifier(paramString, "anim", paramContext.getApplicationContext().getPackageName());
    AppMethodBeat.o(253811);
    return i;
  }
  
  public static String getApplicationPackageName()
  {
    AppMethodBeat.i(253817);
    String str2 = "";
    try
    {
      Context localContext = APMidasPayAPI.fromApplicationContext;
      String str1 = str2;
      if (localContext != null)
      {
        PackageManager localPackageManager = localContext.getPackageManager();
        str1 = str2;
        if (localPackageManager != null) {
          str1 = localPackageManager.getPackageInfo(localContext.getPackageName(), 0).packageName;
        }
      }
      AppMethodBeat.o(253817);
      return str1;
    }
    catch (Exception localException)
    {
      APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + localException.toString());
      AppMethodBeat.o(253817);
    }
    return "";
  }
  
  public static String getApplicationVersion()
  {
    AppMethodBeat.i(253818);
    try
    {
      String str = APMidasPayAPI.fromApplicationContext.getPackageManager().getPackageInfo(APMidasPayAPI.fromApplicationContext.getPackageName(), 0).versionName;
      AppMethodBeat.o(253818);
      return str;
    }
    catch (Exception localException)
    {
      APLog.i("APMidasCommMethod", "getApplicationVersion error:" + localException.toString());
      AppMethodBeat.o(253818);
    }
    return "";
  }
  
  public static int getColorId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253810);
    int i = paramContext.getResources().getIdentifier(paramString, "color", paramContext.getPackageName());
    i = paramContext.getResources().getColor(i);
    AppMethodBeat.o(253810);
    return i;
  }
  
  public static Drawable getDrawable(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253807);
    int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    paramContext = paramContext.getResources().getDrawable(i);
    AppMethodBeat.o(253807);
    return paramContext;
  }
  
  public static int getDrawableId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253806);
    int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
    AppMethodBeat.o(253806);
    return i;
  }
  
  public static int getId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253809);
    int i = paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
    AppMethodBeat.o(253809);
    return i;
  }
  
  public static int getLayoutId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253804);
    int i = paramContext.getResources().getIdentifier(paramString, "layout", paramContext.getPackageName());
    AppMethodBeat.o(253804);
    return i;
  }
  
  public static String getStringId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253805);
    int i = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    paramContext = paramContext.getResources().getString(i);
    AppMethodBeat.o(253805);
    return paramContext;
  }
  
  public static int getStyleId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253808);
    int i = paramContext.getResources().getIdentifier(paramString, "style", paramContext.getPackageName());
    AppMethodBeat.o(253808);
    return i;
  }
  
  public static void popActivity()
  {
    AppMethodBeat.i(253815);
    APLog.i("jar popActivity", "1");
    try
    {
      Stack localStack = activityStack;
      if (localStack == null)
      {
        AppMethodBeat.o(253815);
        return;
      }
      int i = 0;
      while (i < activityStack.size())
      {
        if (activityStack.get(i) != null) {
          ((Activity)activityStack.get(i)).finish();
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      APLog.i("jar popActivity ex", localException.toString());
      releaseActivityStack();
      AppMethodBeat.o(253815);
    }
  }
  
  public static void pushActivity(Activity paramActivity)
  {
    AppMethodBeat.i(253814);
    if (activityStack == null) {
      activityStack = new Stack();
    }
    activityStack.push(paramActivity);
    AppMethodBeat.o(253814);
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(253813);
    int i = (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
    AppMethodBeat.o(253813);
    return i;
  }
  
  public static String rawString(String paramString)
  {
    AppMethodBeat.i(253799);
    paramString = paramString.replace(" ", "");
    AppMethodBeat.o(253799);
    return paramString;
  }
  
  public static void releaseActivityStack()
  {
    AppMethodBeat.i(253816);
    if (activityStack != null) {
      activityStack.clear();
    }
    activityStack = null;
    AppMethodBeat.o(253816);
  }
  
  public static void transformStrToList(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(253802);
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    paramList.clear();
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() != 0)
      {
        paramString = paramString.split(",");
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          paramList.add(paramString[i]);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(253802);
  }
  
  public static void transformStrToMap(String paramString, TreeMap<String, String> paramTreeMap)
  {
    AppMethodBeat.i(253800);
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() == 0)
      {
        paramTreeMap.clear();
        AppMethodBeat.o(253800);
        return;
      }
      paramString = paramString.split(",");
      j = paramString.length;
      if ((j > 0) && (j % 2 == 0))
      {
        paramTreeMap.clear();
        i = 0;
        while (i < j / 2)
        {
          paramTreeMap.put(paramString[(i * 2)], paramString[(i * 2 + 1)]);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(253800);
  }
  
  public static void transformStrToMpInfoList(String paramString, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(253801);
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() == 0)
      {
        paramList1.clear();
        paramList2.clear();
        AppMethodBeat.o(253801);
        return;
      }
      paramString = paramString.split(",");
      j = paramString.length;
      if ((j > 0) && (j % 2 == 0))
      {
        paramList1.clear();
        paramList2.clear();
        i = 0;
        while (i < j / 2)
        {
          Object localObject1 = paramString[(i * 2)];
          Object localObject2 = paramString[(i * 2 + 1)];
          paramList1.add(localObject1);
          paramList2.add(localObject2);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(253801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.pay.tool.APMidasCommMethod
 * JD-Core Version:    0.7.0.1
 */