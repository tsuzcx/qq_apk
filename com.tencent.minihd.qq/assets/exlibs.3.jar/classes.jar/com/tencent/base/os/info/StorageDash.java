package com.tencent.base.os.info;

import android.os.Environment;
import com.tencent.base.Global;

public class StorageDash
{
  public static StorageInfo getExternalInfo()
  {
    if (!hasExternalReadable()) {
      return null;
    }
    return StorageInfo.fromFile(Environment.getExternalStorageDirectory());
  }
  
  public static StorageInfo getInnerInfo()
  {
    return StorageInfo.fromFile(Global.getFilesDir());
  }
  
  public static boolean hasExternal()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean hasExternalReadable()
  {
    String str = Environment.getExternalStorageState();
    return ("mounted".equals(str)) || ("mounted_ro".equals(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.info.StorageDash
 * JD-Core Version:    0.7.0.1
 */