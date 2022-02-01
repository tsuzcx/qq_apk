package com.tencent.map.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;

public class Util
{
  private static final boolean DEBUG = false;
  private static final int DEFAUlT_GlEsVersion = 65537;
  public static final String META_NAME_API_KEY = "TencentMapSDK";
  public static final int SMALL_SCREEN_THRESHOLD = 400;
  private static final String TAG = "Util";
  
  public static String filterBuilder(String... paramVarArgs)
  {
    AppMethodBeat.i(180763);
    Object localObject = "";
    if (paramVarArgs != null)
    {
      String str = "category=";
      int i = 0;
      localObject = str;
      if (i < paramVarArgs.length)
      {
        if (i == 0) {}
        for (str = str + paramVarArgs[i];; str = str + "," + paramVarArgs[i])
        {
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(180763);
    return localObject;
  }
  
  public static <T> Class<? extends T> findClass(String paramString, Class<T> paramClass, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(180772);
    try
    {
      paramString = Class.forName(paramString, false, paramClassLoader);
      boolean bool = paramClass.isAssignableFrom(paramString);
      if (bool)
      {
        AppMethodBeat.o(180772);
        return paramString;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(180772);
    }
    return null;
  }
  
  public static Class findClass(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(180771);
    try
    {
      paramString = Class.forName(paramString, false, paramClassLoader);
      AppMethodBeat.o(180771);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(180771);
    }
    return null;
  }
  
  public static Method findMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(180770);
    localObject = null;
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if (paramClass.getSuperclass() != Object.class) {
          localObject = findMethod(paramClass.getSuperclass(), paramString, paramArrayOfClass);
        }
      }
    }
    AppMethodBeat.o(180770);
    return localObject;
  }
  
  public static String getAppName(Context paramContext)
  {
    AppMethodBeat.i(180761);
    if (paramContext == null)
    {
      AppMethodBeat.o(180761);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.loadLabel(localPackageManager);
        try
        {
          paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
          AppMethodBeat.o(180761);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
        continue;
        paramContext = "can't find app name";
      }
    }
  }
  
  public static String getAppVersion(Context paramContext)
  {
    AppMethodBeat.i(180757);
    if (paramContext == null)
    {
      AppMethodBeat.o(180757);
      return "";
    }
    String str1 = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str2 = paramContext.versionName;
      int i = paramContext.versionCode;
      paramContext = str2 + i;
      AppMethodBeat.o(180757);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(180753);
    if (paramContext == null)
    {
      AppMethodBeat.o(180753);
      return 1.0F;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(180753);
    return f;
  }
  
  public static Object getField(Object paramObject, String paramString)
  {
    AppMethodBeat.i(180767);
    if (paramObject == null)
    {
      AppMethodBeat.o(180767);
      return null;
    }
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      AppMethodBeat.o(180767);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(180767);
      return null;
    }
    catch (NoSuchFieldException paramObject)
    {
      label44:
      break label44;
    }
  }
  
  @SuppressLint({"HardwareIds", "MissingPermission"})
  public static String getIMei(Context paramContext)
  {
    AppMethodBeat.i(180760);
    if (paramContext == null)
    {
      AppMethodBeat.o(180760);
      return "";
    }
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    if (localObject1 == null)
    {
      AppMethodBeat.o(180760);
      return "";
    }
    int i = ((TelephonyManager)localObject1).getPhoneType();
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
        break label159;
      }
      if (Build.VERSION.SDK_INT >= 29) {
        if (i != 1) {}
      }
    }
    for (;;)
    {
      String str1;
      try
      {
        localObject1 = ((TelephonyManager)localObject1).getImei();
        Object localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        }
        paramContext = (Context)localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          paramContext = "";
        }
        AppMethodBeat.o(180760);
        return paramContext;
      }
      catch (Exception localException1)
      {
        str1 = null;
        continue;
      }
      if (i == 2)
      {
        try
        {
          str1 = str1.getMeid();
        }
        catch (Exception localException2)
        {
          str2 = null;
        }
        continue;
        String str2 = str2.getDeviceId();
        continue;
        try
        {
          str2 = str2.getDeviceId();
        }
        catch (Exception localException3) {}
      }
      else
      {
        label159:
        Object localObject2 = null;
      }
    }
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getMacAddress(Context paramContext)
  {
    AppMethodBeat.i(180759);
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext == null)
    {
      AppMethodBeat.o(180759);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(180759);
      return "";
    }
    String str = paramContext.getMacAddress();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    AppMethodBeat.o(180759);
    return paramContext;
  }
  
  public static String getMetaKey(Context paramContext, String paramString)
  {
    AppMethodBeat.i(180758);
    if (paramContext == null)
    {
      AppMethodBeat.o(180758);
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(180758);
        return "";
      }
      if (paramContext.metaData == null)
      {
        AppMethodBeat.o(180758);
        return "";
      }
      paramContext = paramContext.metaData.getString(paramString);
      AppMethodBeat.o(180758);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static int getOpenglesVersion(Context paramContext)
  {
    AppMethodBeat.i(180756);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (paramContext != null)
    {
      int i = paramContext.reqGlEsVersion;
      AppMethodBeat.o(180756);
      return i;
    }
    AppMethodBeat.o(180756);
    return 65537;
  }
  
  public static String getResolution(Context paramContext)
  {
    AppMethodBeat.i(180762);
    if (paramContext == null)
    {
      AppMethodBeat.o(180762);
      return "";
    }
    String str = "";
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = paramContext.widthPixels + "*" + paramContext.heightPixels;
      AppMethodBeat.o(180762);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public static int getWindowHeight(Context paramContext)
  {
    AppMethodBeat.i(180755);
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(180755);
    return i;
  }
  
  public static int getWindowWidth(Context paramContext)
  {
    AppMethodBeat.i(180754);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(180754);
    return i;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(180769);
    if (paramObject == null)
    {
      AppMethodBeat.o(180769);
      return null;
    }
    try
    {
      paramString = findMethod(paramObject.getClass(), paramString, paramArrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.invoke(paramObject, paramArrayOfObject);
        AppMethodBeat.o(180769);
        return paramObject;
      }
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = new RuntimeException(paramObject.getTargetException());
      AppMethodBeat.o(180769);
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(180769);
    }
    return null;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(180768);
    if (paramObject == null)
    {
      AppMethodBeat.o(180768);
      return null;
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      arrayOfClass[i] = paramVarArgs[i].getClass();
      i += 1;
    }
    try
    {
      paramString = findMethod(paramObject.getClass(), paramString, arrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.invoke(paramObject, paramVarArgs);
        AppMethodBeat.o(180768);
        return paramObject;
      }
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = new RuntimeException(paramObject.getTargetException());
      AppMethodBeat.o(180768);
      throw paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(180768);
    }
    return null;
  }
  
  public static Object invokeStaticMethod(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(195075);
    if (paramClass == null)
    {
      AppMethodBeat.o(195075);
      return null;
    }
    try
    {
      paramString = findMethod(paramClass, paramString, paramArrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramClass = paramString.invoke(paramClass, paramArrayOfObject);
        AppMethodBeat.o(195075);
        return paramClass;
      }
    }
    catch (InvocationTargetException paramClass)
    {
      paramClass = new RuntimeException(paramClass.getTargetException());
      AppMethodBeat.o(195075);
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(195075);
    }
    return null;
  }
  
  private static boolean isMatchClassTypes(Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(180765);
    if (paramArrayOfClass.length != paramArrayOfObject.length)
    {
      AppMethodBeat.o(180765);
      return false;
    }
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfClass.length; j = k)
    {
      if (paramArrayOfClass[i] != paramArrayOfObject[i].getClass())
      {
        k = j;
        if (!paramArrayOfClass[i].isAssignableFrom(paramArrayOfObject[i].getClass())) {}
      }
      else
      {
        k = j + 1;
      }
      i += 1;
    }
    if (j == paramArrayOfClass.length)
    {
      AppMethodBeat.o(180765);
      return true;
    }
    AppMethodBeat.o(180765);
    return false;
  }
  
  public static <T> T newInstance(Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(180764);
    if ((paramClass == null) || (paramClass.isEnum()) || (paramClass.isInterface()) || (paramClass.isAnnotation()) || (paramClass.isArray()))
    {
      AppMethodBeat.o(180764);
      return null;
    }
    Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
    int i = 0;
    for (;;)
    {
      if ((i >= arrayOfConstructor.length) || (isMatchClassTypes(arrayOfConstructor[i].getParameterTypes(), paramVarArgs))) {}
      try
      {
        arrayOfConstructor[i].setAccessible(true);
        Object localObject = arrayOfConstructor[i].newInstance(paramVarArgs);
        AppMethodBeat.o(180764);
        return localObject;
      }
      catch (InvocationTargetException paramClass)
      {
        paramClass = new RuntimeException(paramClass.getTargetException());
        AppMethodBeat.o(180764);
        throw paramClass;
      }
      catch (InstantiationException localInstantiationException)
      {
        i += 1;
        continue;
        try
        {
          paramClass = paramClass.newInstance();
          AppMethodBeat.o(180764);
          return paramClass;
        }
        catch (InstantiationException paramClass)
        {
          paramClass = new RuntimeException(paramClass);
          AppMethodBeat.o(180764);
          throw paramClass;
        }
        catch (IllegalAccessException paramClass)
        {
          AppMethodBeat.o(180764);
          return null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label120:
        break label120;
      }
    }
  }
  
  public static void setField(Object paramObject1, String paramString, Object paramObject2)
  {
    AppMethodBeat.i(180766);
    if (paramObject1 == null)
    {
      AppMethodBeat.o(180766);
      return;
    }
    try
    {
      paramString = paramObject1.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramObject1, paramObject2);
      AppMethodBeat.o(180766);
      return;
    }
    catch (NoSuchFieldException paramObject1)
    {
      AppMethodBeat.o(180766);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      AppMethodBeat.o(180766);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.Util
 * JD-Core Version:    0.7.0.1
 */