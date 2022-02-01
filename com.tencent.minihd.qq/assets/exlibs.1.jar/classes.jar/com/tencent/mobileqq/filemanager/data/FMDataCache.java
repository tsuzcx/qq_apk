package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FMDataCache
{
  private static int jdField_a_of_type_Int;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private static ArrayList c = new ArrayList();
  private static ArrayList d = new ArrayList();
  private static ArrayList e;
  
  static
  {
    jdField_a_of_type_Int = 20;
    e = new ArrayList();
  }
  
  public static long a()
  {
    return jdField_a_of_type_JavaUtilArrayList.size() + d.size() + c.size() + jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public static WeiYunFileInfo a(String paramString)
  {
    return (WeiYunFileInfo)jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static ArrayList a()
  {
    return e;
  }
  
  public static void a()
  {
    e.clear();
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(FileInfo paramFileInfo)
  {
    if (!b()) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!b()) {
      return;
    }
    d.add(paramFileManagerEntity);
  }
  
  public static void a(OfflineFileInfo paramOfflineFileInfo)
  {
    if (!b()) {
      return;
    }
    c.add(paramOfflineFileInfo);
  }
  
  public static void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!b()) {
      return;
    }
    jdField_b_of_type_JavaUtilArrayList.add(paramWeiYunFileInfo);
  }
  
  public static void a(String paramString)
  {
    jdField_b_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, WeiYunFileInfo paramWeiYunFileInfo)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, paramWeiYunFileInfo);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    FMDataCache.TmpSignature localTmpSignature = new FMDataCache.TmpSignature();
    localTmpSignature.jdField_a_of_type_JavaLangString = paramString;
    localTmpSignature.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    jdField_b_of_type_JavaUtilMap.put(paramString, localTmpSignature);
  }
  
  public static void a(ArrayList paramArrayList)
  {
    e.clear();
    e.addAll(paramArrayList);
  }
  
  public static boolean a()
  {
    long l = b();
    return (l > 5242880L) || (l < 0L);
  }
  
  public static boolean a(FileInfo paramFileInfo)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return d.contains(paramFileManagerEntity);
  }
  
  public static boolean a(OfflineFileInfo paramOfflineFileInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      if (((OfflineFileInfo)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramOfflineFileInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public static byte[] a(String paramString)
  {
    paramString = (FMDataCache.TmpSignature)jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public static long b()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((FileInfo)localIterator.next()).a()) {}
    localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.cloudType == 3) {
        l += FileUtil.a(localFileManagerEntity.strFilePath);
      }
    }
    return l;
  }
  
  public static ArrayList b()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
    d.clear();
    c.clear();
    jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public static void b(FileInfo paramFileInfo)
  {
    jdField_a_of_type_JavaUtilArrayList.remove(paramFileInfo);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    d.remove(paramFileManagerEntity);
  }
  
  public static void b(OfflineFileInfo paramOfflineFileInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      OfflineFileInfo localOfflineFileInfo = (OfflineFileInfo)localIterator.next();
      if (localOfflineFileInfo.jdField_a_of_type_JavaLangString.equals(paramOfflineFileInfo.jdField_a_of_type_JavaLangString)) {
        c.remove(localOfflineFileInfo);
      }
    }
  }
  
  public static void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (localWeiYunFileInfo.jdField_a_of_type_JavaLangString.equals(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
        jdField_b_of_type_JavaUtilArrayList.remove(localWeiYunFileInfo);
      }
    }
  }
  
  private static boolean b()
  {
    if ((jdField_a_of_type_Int > 0) && (a() >= jdField_a_of_type_Int))
    {
      if (50 == jdField_a_of_type_Int) {
        FMToastUtil.c(2131362550);
      }
      for (;;)
      {
        return false;
        FMToastUtil.c(2131362079);
      }
    }
    return true;
  }
  
  public static long c()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((FileInfo)localIterator.next()).a()) {}
    localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      l += ((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_Long;
    }
    localIterator = c.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).b;
    }
    localIterator = d.iterator();
    while (localIterator.hasNext()) {
      l += ((FileManagerEntity)localIterator.next()).fileSize;
    }
    return l;
  }
  
  public static ArrayList c()
  {
    return d;
  }
  
  public static void c()
  {
    jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public static long d()
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_Long) {}
    localIterator = c.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).b;
    }
    localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      switch (localFileManagerEntity.cloudType)
      {
      default: 
        break;
      case 1: 
      case 2: 
        l += localFileManagerEntity.fileSize;
      }
    }
    return l;
  }
  
  public static ArrayList d()
  {
    return c;
  }
  
  public static ArrayList e()
  {
    return jdField_b_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMDataCache
 * JD-Core Version:    0.7.0.1
 */