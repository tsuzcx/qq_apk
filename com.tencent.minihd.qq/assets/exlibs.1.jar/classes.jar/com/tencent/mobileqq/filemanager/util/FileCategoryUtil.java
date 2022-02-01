package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import jas;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileCategoryUtil
{
  private static final int jdField_a_of_type_Int = 0;
  private static Comparator jdField_a_of_type_JavaUtilComparator;
  private static final int b = 1;
  private static final int c = 2;
  
  static
  {
    a = new jas();
  }
  
  public static int a(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = b(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if ((localObject != null) && (((PackageInfo)localObject).applicationInfo != null))
      {
        localObject = ((PackageInfo)localObject).applicationInfo;
        if ((localObject == null) || (((ApplicationInfo)localObject).icon == 0)) {
          break label159;
        }
        Class localClass = Class.forName("android.content.res.AssetManager");
        AssetManager localAssetManager = (AssetManager)localClass.getConstructor((Class[])null).newInstance((Object[])null);
        localClass.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
        paramString = new DisplayMetrics();
        paramString.setToDefaults();
        paramContext = new Resources(localAssetManager, paramString, paramContext.getResources().getConfiguration()).getDrawable(((ApplicationInfo)localObject).icon);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    return null;
    label159:
    return null;
  }
  
  public static Drawable a(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    Object localObject = paramContext.getPackageArchiveInfo(paramString, 1);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      ((ApplicationInfo)localObject).sourceDir = paramString;
      ((ApplicationInfo)localObject).publicSourceDir = paramString;
      try
      {
        paramString = paramContext.getApplicationIcon((ApplicationInfo)localObject);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApkIconLoader", 2, paramString.toString());
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (localPackageInfo != null) {
      return localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
    }
    return FileManagerUtil.a(paramString);
  }
  
  public static String a(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
    if (paramContext != null) {
      return paramContext.applicationInfo.packageName;
    }
    return FileManagerUtil.a(paramString);
  }
  
  public static List a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager().getInstalledPackages(0);
    int i = 0;
    while (i < paramContext.size())
    {
      PackageInfo localPackageInfo = (PackageInfo)paramContext.get(i);
      int j = localPackageInfo.applicationInfo.flags;
      ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
      if (((j & 0x1) <= 0) && (FileUtil.a(localPackageInfo.applicationInfo.publicSourceDir))) {
        localArrayList.add(localPackageInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  @TargetApi(9)
  public static List a(Context paramContext, QfileBaseTabView paramQfileBaseTabView)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramContext);
    paramContext = paramContext.getPackageManager();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
      try
      {
        FileInfo localFileInfo = new FileInfo(localPackageInfo.applicationInfo.publicSourceDir);
        localFileInfo.b(5);
        localFileInfo.d(localPackageInfo.applicationInfo.loadLabel(paramContext).toString());
        localFileInfo.c(localPackageInfo.applicationInfo.packageName);
        if (Build.VERSION.SDK_INT >= 9) {
          localFileInfo.b(localPackageInfo.lastUpdateTime);
        }
        localFileInfo.a("已安装");
        localArrayList.add(localFileInfo);
        if (paramQfileBaseTabView != null) {
          paramQfileBaseTabView.a(localFileInfo);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Collections.sort(localArrayList, a);
    return localArrayList;
  }
  
  public static Map a(Context paramContext)
  {
    paramContext = a(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 31	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_0
    //   15: invokestatic 314	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 40 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 40 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 40 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  private static Map a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i;
    int j;
    int k;
    int m;
    Object localObject;
    int n;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      if (!paramCursor.moveToNext()) {
        break label315;
      }
      localObject = paramCursor.getString(m);
      n = paramCursor.getInt(k);
      paramCursor.getInt(j);
      if (paramInt == 1) {
        break;
      }
    }
    for (String str = paramCursor.getString(i); localObject != null; str = "音乐")
    {
      localObject = FileInfo.a((String)localObject);
      if (localObject == null) {
        break;
      }
      ((FileInfo)localObject).a(n);
      ((FileInfo)localObject).b(paramInt);
      ((FileInfo)localObject).a(str);
      if (!localHashMap.containsKey(str)) {
        localHashMap.put(str, new ArrayList());
      }
      ((List)localHashMap.get(str)).add(localObject);
      break;
      m = paramCursor.getColumnIndexOrThrow("_data");
      k = paramCursor.getColumnIndexOrThrow("_id");
      i = 0;
      j = 0;
      break;
      m = paramCursor.getColumnIndexOrThrow("_data");
      k = paramCursor.getColumnIndexOrThrow("_id");
      j = paramCursor.getColumnIndexOrThrow("bucket_id");
      i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
      break;
      m = paramCursor.getColumnIndexOrThrow("_data");
      k = paramCursor.getColumnIndexOrThrow("_id");
      j = paramCursor.getColumnIndexOrThrow("bucket_id");
      i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
      break;
    }
    label315:
    return localHashMap;
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((paramFileManagerEntity.nFileType != 5) || (paramFileManagerEntity.cloudType != 3) || (FileUtil.a(paramFileManagerEntity.strFilePath)) || (paramFileManagerEntity.strApkPackageName == null) || (paramFileManagerEntity.strApkPackageName.length() == 0)) {}
        localIterator = a(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!paramFileManagerEntity.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    paramFileManagerEntity.strFilePath = localPackageInfo.applicationInfo.publicSourceDir;
    paramFileManagerEntity.fileName = a(paramFileManagerEntity.strFilePath);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, HashMap paramHashMap, QfileBaseTabView paramQfileBaseTabView)
  {
    if ((paramQfileBaseTabView != null) && (paramQfileBaseTabView.c())) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            Thread.sleep(0L);
            File localFile = new File(paramString1);
            if (localFile.isDirectory())
            {
              if (localFile.getName().indexOf(".") == 0) {
                continue;
              }
              paramString1 = localFile.listFiles();
              if (paramString1 == null) {
                continue;
              }
              int i = 0;
              while (i < paramString1.length)
              {
                a(paramString1[i].getAbsolutePath(), paramString2, paramString3, paramHashMap, paramQfileBaseTabView);
                i += 1;
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("scanFileList", 4, "inFilter[" + paramString2 + "],outOfFilter[" + paramString3 + "],path[" + paramString1 + "]");
            }
            String str = FileUtil.a(paramString1);
            Object localObject = str;
            if (paramString2 != null)
            {
              localObject = str;
              if (paramString2.length() > 0)
              {
                if ((str == null) || (str.length() <= 1)) {
                  continue;
                }
                localObject = str.toLowerCase();
                if (paramString2.indexOf((String)localObject) < 0) {
                  continue;
                }
              }
            }
            paramString2 = (String)localObject;
            if (localObject != null)
            {
              paramString2 = (String)localObject;
              if (((String)localObject).length() > 1)
              {
                paramString2 = (String)localObject;
                if (paramString3 != null)
                {
                  paramString2 = (String)localObject;
                  if (paramString3.length() > 0)
                  {
                    paramString2 = ((String)localObject).toLowerCase();
                    if (paramString3.indexOf(paramString2) >= 0) {
                      continue;
                    }
                  }
                }
              }
            }
          }
        }
      } while (paramString1 == null);
      paramString1 = FileInfo.a(paramString1);
    } while (paramString1 == null);
    if (!paramHashMap.containsKey(paramString2)) {
      paramHashMap.put(paramString2, new ArrayList());
    }
    if (paramQfileBaseTabView != null) {
      paramQfileBaseTabView.a(paramString1);
    }
    ((List)paramHashMap.get(paramString2)).add(paramString1);
  }
  
  public static void a(Map paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext()) {
        Collections.sort((List)paramMap.get((String)localIterator.next()), a);
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = c(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  /* Error */
  public static Drawable b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 86	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   6: astore_3
    //   7: aload_3
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 92	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   13: getfield 98	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   16: astore 4
    //   18: aload 4
    //   20: aload_1
    //   21: putfield 170	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   24: aload 4
    //   26: aload_1
    //   27: putfield 173	android/content/pm/ApplicationInfo:publicSourceDir	Ljava/lang/String;
    //   30: aload_3
    //   31: aload 4
    //   33: invokevirtual 462	android/content/pm/PackageManager:getResourcesForApplication	(Landroid/content/pm/ApplicationInfo;)Landroid/content/res/Resources;
    //   36: astore_0
    //   37: new 464	android/util/TypedValue
    //   40: dup
    //   41: invokespecial 465	android/util/TypedValue:<init>	()V
    //   44: astore_1
    //   45: aload_0
    //   46: aload 4
    //   48: getfield 103	android/content/pm/ApplicationInfo:icon	I
    //   51: aload_1
    //   52: iconst_1
    //   53: invokevirtual 469	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   56: aload_1
    //   57: getfield 473	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   60: invokeinterface 207 1 0
    //   65: astore 5
    //   67: aload_0
    //   68: aload_1
    //   69: aload_0
    //   70: invokevirtual 477	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   73: aload_1
    //   74: getfield 480	android/util/TypedValue:assetCookie	I
    //   77: aload 5
    //   79: invokevirtual 484	android/content/res/AssetManager:openNonAssetFd	(ILjava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   82: invokevirtual 490	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   85: aconst_null
    //   86: invokestatic 496	android/graphics/drawable/Drawable:createFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: aload_0
    //   93: ifnonnull +10 -> 103
    //   96: aload 4
    //   98: aload_3
    //   99: invokevirtual 500	android/content/pm/ApplicationInfo:loadIcon	(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
    //   102: astore_1
    //   103: aload_1
    //   104: areturn
    //   105: astore_0
    //   106: aload_2
    //   107: astore_0
    //   108: goto -18 -> 90
    //   111: astore_0
    //   112: aload_2
    //   113: astore_0
    //   114: goto -24 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   0	117	1	paramString	String
    //   1	112	2	localObject	Object
    //   6	93	3	localPackageManager	PackageManager
    //   16	81	4	localApplicationInfo	ApplicationInfo
    //   65	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   30	67	105	android/content/pm/PackageManager$NameNotFoundException
    //   67	90	105	android/content/pm/PackageManager$NameNotFoundException
    //   67	90	111	java/io/IOException
  }
  
  public static Map b(Context paramContext)
  {
    paramContext = b(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 504	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_2
    //   15: invokestatic 314	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 40 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 40 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 40 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  public static int c(Context paramContext)
  {
    localObject = null;
    localContext = null;
    int j = 0;
    try
    {
      paramContext = a(paramContext, "1=1 )GROUP BY (_data", null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label77;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  private static Cursor c(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return paramContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static Map c(Context paramContext)
  {
    paramContext = c(paramContext, "1=1 )GROUP BY (_data", 0);
    if (paramContext != null) {
      a(paramContext);
    }
    return paramContext;
  }
  
  /* Error */
  public static Map c(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 451	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:c	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_1
    //   15: invokestatic 314	com/tencent/mobileqq/filemanager/util/FileCategoryUtil:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 40 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 40 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 40 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  public static int d(Context paramContext)
  {
    return 0;
  }
  
  public static int e(Context paramContext)
  {
    return a(paramContext).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil
 * JD-Core Version:    0.7.0.1
 */