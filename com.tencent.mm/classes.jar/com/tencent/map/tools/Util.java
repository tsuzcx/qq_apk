package com.tencent.map.tools;

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
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Util
{
  private static final boolean DEBUG = false;
  private static final int DEFAUlT_GlEsVersion = 65537;
  public static final String META_NAME_API_KEY = "TencentMapSDK";
  public static final int SMALL_SCREEN_THRESHOLD = 400;
  private static final String SUID_FILE_NAME = "txlbs_suid";
  private static final String SUID_KEY = "txlbs_key_suid";
  private static final String TAG = "Util";
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(211058);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(211058);
      return true;
    }
    AppMethodBeat.o(211058);
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
  
  public static Field findField(Class paramClass, String paramString)
  {
    AppMethodBeat.i(211039);
    localObject = null;
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      localObject = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        if (paramClass.getSuperclass() != Object.class) {
          localObject = findField(paramClass.getSuperclass(), paramString);
        }
      }
    }
    AppMethodBeat.o(211039);
    return localObject;
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
    AppMethodBeat.i(211066);
    if ((paramIterable == null) || (paramCallback == null))
    {
      AppMethodBeat.o(211066);
      return;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramCallback.callback(paramIterable.next());
    }
    AppMethodBeat.o(211066);
  }
  
  public static <T> void foreach(T[] paramArrayOfT, Callback<T> paramCallback)
  {
    AppMethodBeat.i(211069);
    if ((paramArrayOfT == null) || (paramCallback == null))
    {
      AppMethodBeat.o(211069);
      return;
    }
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramCallback.callback(paramArrayOfT[i]);
      i += 1;
    }
    AppMethodBeat.o(211069);
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
      Class localClass = paramObject.getClass();
      if ((paramObject instanceof Class)) {
        localClass = (Class)paramObject;
      }
      paramString = findField(localClass, paramString);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.get(paramObject);
        AppMethodBeat.o(180767);
        return paramObject;
      }
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(180767);
    }
    return null;
  }
  
  public static String getIMei(Context paramContext)
  {
    AppMethodBeat.i(180760);
    if (paramContext == null)
    {
      AppMethodBeat.o(180760);
      return "";
    }
    paramContext = getSuidFromSharePrerences(paramContext);
    AppMethodBeat.o(180760);
    return paramContext;
  }
  
  public static String getMD5String(String paramString)
  {
    AppMethodBeat.i(211048);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211048);
      return "";
    }
    paramString = getMD5String(paramString.getBytes());
    AppMethodBeat.o(211048);
    return paramString;
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211055);
    char[] arrayOfChar = new char[16];
    char[] tmp13_11 = arrayOfChar;
    tmp13_11[0] = 48;
    char[] tmp18_13 = tmp13_11;
    tmp18_13[1] = 49;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[2] = 50;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[3] = 51;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 52;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 53;
    char[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 54;
    char[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 55;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 56;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 57;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 97;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 98;
    char[] tmp80_73 = tmp73_67;
    tmp80_73[12] = 99;
    char[] tmp87_80 = tmp80_73;
    tmp87_80[13] = 100;
    char[] tmp94_87 = tmp87_80;
    tmp94_87[14] = 101;
    char[] tmp101_94 = tmp94_87;
    tmp101_94[15] = 102;
    tmp101_94;
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
      AppMethodBeat.o(211055);
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
  
  /* Error */
  public static String getProcessName(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 323
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 325	java/io/BufferedReader
    //   9: dup
    //   10: new 327	java/io/FileReader
    //   13: dup
    //   14: new 54	java/lang/StringBuilder
    //   17: dup
    //   18: ldc_w 329
    //   21: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: iload_0
    //   25: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 334
    //   31: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 335	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 338	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 341	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +53 -> 106
    //   56: aload_1
    //   57: invokevirtual 344	java/lang/String:trim	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 347	java/io/BufferedReader:close	()V
    //   65: ldc_w 323
    //   68: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 347	java/io/BufferedReader:close	()V
    //   84: ldc_w 323
    //   87: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_2
    //   93: goto -28 -> 65
    //   96: astore_1
    //   97: goto -13 -> 84
    //   100: astore_1
    //   101: aload_2
    //   102: astore_1
    //   103: goto -27 -> 76
    //   106: goto -45 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramInt	int
    //   48	24	1	str	String
    //   73	1	1	localObject1	Object
    //   75	6	1	localObject2	Object
    //   96	1	1	localIOException1	java.io.IOException
    //   100	1	1	localObject3	Object
    //   102	1	1	localIOException2	java.io.IOException
    //   43	19	2	localBufferedReader	java.io.BufferedReader
    //   92	10	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   6	44	73	finally
    //   61	65	92	java/io/IOException
    //   80	84	96	java/io/IOException
    //   44	61	100	finally
  }
  
  public static String getRawAppName(Context paramContext)
  {
    AppMethodBeat.i(211001);
    if (paramContext == null)
    {
      AppMethodBeat.o(211001);
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
        AppMethodBeat.o(211001);
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
  
  public static String getSharePreference(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210992);
    if (paramContext == null)
    {
      AppMethodBeat.o(210992);
      return "";
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, "");
    AppMethodBeat.o(210992);
    return paramContext;
  }
  
  private static String getSuidFromSharePrerences(Context paramContext)
  {
    AppMethodBeat.i(210981);
    String str2 = getSharePreference(paramContext, "txlbs_suid", "txlbs_key_suid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = getUUID();
      saveSharePreference(paramContext, "txlbs_suid", "txlbs_key_suid", str1);
    }
    AppMethodBeat.o(210981);
    return str1;
  }
  
  public static String getUUID()
  {
    AppMethodBeat.i(210986);
    try
    {
      String str1 = UUID.randomUUID().toString();
      AppMethodBeat.o(210986);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = System.currentTimeMillis();
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
    AppMethodBeat.i(211062);
    int i = Arrays.hashCode(paramVarArgs);
    AppMethodBeat.o(211062);
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
    AppMethodBeat.i(211033);
    if (paramClass == null)
    {
      AppMethodBeat.o(211033);
      return null;
    }
    try
    {
      paramString = findMethod(paramClass, paramString, paramArrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramClass = paramString.invoke(paramClass, paramArrayOfObject);
        AppMethodBeat.o(211033);
        return paramClass;
      }
    }
    catch (InvocationTargetException paramClass)
    {
      paramClass = new RuntimeException(paramClass.getTargetException());
      AppMethodBeat.o(211033);
      throw paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(211033);
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
  
  public static <T> List<T> listWhere(Iterable<T> paramIterable, Condition<T> paramCondition)
  {
    AppMethodBeat.i(211080);
    List localList = Collections.emptyList();
    if ((paramIterable == null) || (paramCondition == null))
    {
      AppMethodBeat.o(211080);
      return localList;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramCondition.callback(localObject).booleanValue()) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(211080);
    return localList;
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
  
  public static void saveSharePreference(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(210997);
    if (paramContext == null)
    {
      AppMethodBeat.o(210997);
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.apply();
    AppMethodBeat.o(210997);
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
      paramString = findField(paramObject1.getClass(), paramString);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramString.set(paramObject1, paramObject2);
      }
      AppMethodBeat.o(180766);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      AppMethodBeat.o(180766);
    }
  }
  
  public static <T> T singleWhere(Iterable<T> paramIterable, Condition<T> paramCondition)
  {
    AppMethodBeat.i(211074);
    if ((paramIterable == null) || (paramCondition == null))
    {
      AppMethodBeat.o(211074);
      return null;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramCondition.callback(localObject).booleanValue())
      {
        AppMethodBeat.o(211074);
        return localObject;
      }
    }
    AppMethodBeat.o(211074);
    return null;
  }
  
  public static <T> boolean where(Iterable<T> paramIterable, ReturnCallback<Boolean, T> paramReturnCallback)
  {
    AppMethodBeat.i(211086);
    if ((paramIterable == null) || (paramReturnCallback == null))
    {
      AppMethodBeat.o(211086);
      return false;
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (((Boolean)paramReturnCallback.callback(paramIterable.next())).booleanValue())
      {
        AppMethodBeat.o(211086);
        return true;
      }
    }
    paramReturnCallback.callback(null);
    AppMethodBeat.o(211086);
    return false;
  }
  
  public static <T> boolean where(T[] paramArrayOfT, ReturnCallback<Boolean, T> paramReturnCallback)
  {
    AppMethodBeat.i(211089);
    if ((paramArrayOfT == null) || (paramReturnCallback == null))
    {
      AppMethodBeat.o(211089);
      return false;
    }
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (((Boolean)paramReturnCallback.callback(paramArrayOfT[i])).booleanValue())
      {
        AppMethodBeat.o(211089);
        return true;
      }
      i += 1;
    }
    paramReturnCallback.callback(null);
    AppMethodBeat.o(211089);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.Util
 * JD-Core Version:    0.7.0.1
 */