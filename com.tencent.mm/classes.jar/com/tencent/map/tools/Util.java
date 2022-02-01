package com.tencent.map.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.tencent.mm.hellhoundlib.a.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

public class Util
{
  private static final boolean DEBUG = false;
  private static final int DEFAUlT_GlEsVersion = 65537;
  public static final String META_NAME_API_KEY = "TencentMapSDK";
  public static final int SMALL_SCREEN_THRESHOLD = 400;
  private static final String TAG = "Util";
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(236271);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(236271);
      return true;
    }
    AppMethodBeat.o(236271);
    return false;
  }
  
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
  
  public static <T> void foreach(Iterable<T> paramIterable, Callback<T> paramCallback)
  {
    AppMethodBeat.i(236273);
    if ((paramIterable == null) || (paramCallback == null))
    {
      AppMethodBeat.o(236273);
      return;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramCallback.callback(paramIterable.next());
    }
    AppMethodBeat.o(236273);
  }
  
  public static <T> void foreach(T[] paramArrayOfT, Callback<T> paramCallback)
  {
    AppMethodBeat.i(236274);
    if ((paramArrayOfT == null) || (paramCallback == null))
    {
      AppMethodBeat.o(236274);
      return;
    }
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramCallback.callback(paramArrayOfT[i]);
      i += 1;
    }
    AppMethodBeat.o(236274);
  }
  
  public static String getAppName(Context paramContext)
  {
    AppMethodBeat.i(180761);
    paramContext = getRawAppName(paramContext);
    try
    {
      String str = URLEncoder.encode(paramContext, "utf-8");
      paramContext = str;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    AppMethodBeat.o(180761);
    return paramContext;
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
        break label219;
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
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = paramContext.getSharedPreferences("device", 0);
          paramContext = ((SharedPreferences)localObject3).getString("device_id", "");
          localObject1 = paramContext;
          if (TextUtils.isEmpty(paramContext))
          {
            localObject1 = UUID.randomUUID().toString();
            ((SharedPreferences)localObject3).edit().putString("device_id", (String)localObject1).apply();
          }
        }
        AppMethodBeat.o(180760);
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        str1 = null;
        continue;
      }
      if (i == 2)
      {
        String str2;
        try
        {
          str1 = str1.getMeid();
        }
        catch (Throwable localThrowable2)
        {
          str2 = null;
        }
        continue;
        String str3;
        try
        {
          str2 = str2.getDeviceId();
        }
        catch (Throwable localThrowable3)
        {
          str3 = null;
        }
        continue;
        try
        {
          str3 = str3.getDeviceId();
        }
        catch (Exception localException) {}
      }
      else
      {
        label219:
        Object localObject2 = null;
      }
    }
  }
  
  public static String getMD5String(String paramString)
  {
    AppMethodBeat.i(236266);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(236266);
      return "";
    }
    paramString = getMD5String(paramString.getBytes());
    AppMethodBeat.o(236266);
    return paramString;
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236269);
    char[] arrayOfChar = new char[16];
    char[] tmp14_12 = arrayOfChar;
    tmp14_12[0] = 48;
    char[] tmp20_14 = tmp14_12;
    tmp20_14[1] = 49;
    char[] tmp26_20 = tmp20_14;
    tmp26_20[2] = 50;
    char[] tmp32_26 = tmp26_20;
    tmp32_26[3] = 51;
    char[] tmp38_32 = tmp32_26;
    tmp38_32[4] = 52;
    char[] tmp44_38 = tmp38_32;
    tmp44_38[5] = 53;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[6] = 54;
    char[] tmp57_50 = tmp50_44;
    tmp57_50[7] = 55;
    char[] tmp64_57 = tmp57_50;
    tmp64_57[8] = 56;
    char[] tmp71_64 = tmp64_57;
    tmp71_64[9] = 57;
    char[] tmp78_71 = tmp71_64;
    tmp78_71[10] = 97;
    char[] tmp85_78 = tmp78_71;
    tmp85_78[11] = 98;
    char[] tmp92_85 = tmp85_78;
    tmp92_85[12] = 99;
    char[] tmp99_92 = tmp92_85;
    tmp99_92[13] = 100;
    char[] tmp106_99 = tmp99_92;
    tmp106_99[14] = 101;
    char[] tmp113_106 = tmp106_99;
    tmp113_106[15] = 102;
    tmp113_106;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(236269);
      return paramArrayOfByte;
      while (i < 16)
      {
        int m = paramArrayOfByte[i];
        int k = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        localObject[k] = arrayOfChar[(m & 0xF)];
        i += 1;
        j = k + 1;
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
    paramContext = (WifiInfo)a.a(paramContext, "com/tencent/map/tools/Util", "getMacAddress", "(Landroid/content/Context;)Ljava/lang/String;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
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
  
  public static String getRawAppName(Context paramContext)
  {
    AppMethodBeat.i(236249);
    if (paramContext == null)
    {
      AppMethodBeat.o(236249);
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
        paramContext = paramContext.toString();
        AppMethodBeat.o(236249);
        return paramContext;
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
  
  public static int hash(Object... paramVarArgs)
  {
    AppMethodBeat.i(236272);
    int i = Arrays.hashCode(paramVarArgs);
    AppMethodBeat.o(236272);
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
    AppMethodBeat.i(236258);
    if (paramClass == null)
    {
      AppMethodBeat.o(236258);
      return null;
    }
    try
    {
      paramString = findMethod(paramClass, paramString, paramArrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramClass = paramString.invoke(paramClass, paramArrayOfObject);
        AppMethodBeat.o(236258);
        return paramClass;
      }
    }
    catch (InvocationTargetException paramClass)
    {
      paramClass = new RuntimeException(paramClass.getTargetException());
      AppMethodBeat.o(236258);
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(236258);
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
  
  public static <T> boolean where(Iterable<T> paramIterable, ReturnCallback<Boolean, T> paramReturnCallback)
  {
    AppMethodBeat.i(236275);
    if ((paramIterable == null) || (paramReturnCallback == null))
    {
      AppMethodBeat.o(236275);
      return false;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (((Boolean)paramReturnCallback.callback(paramIterable.next())).booleanValue())
      {
        AppMethodBeat.o(236275);
        return true;
      }
    }
    paramReturnCallback.callback(null);
    AppMethodBeat.o(236275);
    return false;
  }
  
  public static <T> boolean where(T[] paramArrayOfT, ReturnCallback<Boolean, T> paramReturnCallback)
  {
    AppMethodBeat.i(236276);
    if ((paramArrayOfT == null) || (paramReturnCallback == null))
    {
      AppMethodBeat.o(236276);
      return false;
    }
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramReturnCallback.callback(paramArrayOfT[i])).booleanValue())
      {
        AppMethodBeat.o(236276);
        return true;
      }
      i += 1;
    }
    paramReturnCallback.callback(null);
    AppMethodBeat.o(236276);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.Util
 * JD-Core Version:    0.7.0.1
 */