package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.module.cache.a.b;
import com.tencent.component.network.module.cache.a.e;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import cuy;
import cvd;
import java.io.File;
import java.util.HashMap;

public class a
{
  private static final e jdField_a_of_type_ComTencentComponentNetworkModuleCacheAE = new e(new cvd());
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static b a(Context paramContext)
  {
    String str2 = "tmp";
    String str3 = com.tencent.component.network.downloader.common.a.a(paramContext);
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.contains(":"))
      {
        int i = str3.lastIndexOf(":");
        str1 = str2;
        if (i > 0) {
          str1 = "tmp" + "_" + str3.substring(i + 1);
        }
      }
    }
    return a(paramContext, str1, 500, 200);
  }
  
  public static b a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString, paramInt1, paramInt2, false);
  }
  
  public static b a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        b localb2 = (b)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new b(paramContext, paramString, paramInt1, paramInt2, paramBoolean);
          localb1.a(jdField_a_of_type_ComTencentComponentNetworkModuleCacheAE);
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localb1);
        }
        return localb1;
      }
    }
  }
  
  public static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = b(paramContext, paramBoolean);
    if (str == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = str;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(str + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.a(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "cache";
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static String b(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramBoolean);
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    if (paramContext.isFile()) {
      FileUtils.a(paramContext);
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  private static String b(Context paramContext, boolean paramBoolean)
  {
    if (!a()) {}
    for (;;)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = cuy.a(paramContext, false); paramContext != null; paramContext = cuy.a(paramContext, "cache", false)) {
        return paramContext.getAbsolutePath();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.a
 * JD-Core Version:    0.7.0.1
 */