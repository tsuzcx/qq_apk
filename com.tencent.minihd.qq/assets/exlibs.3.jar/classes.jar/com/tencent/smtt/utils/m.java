package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileFilter;

public class m
{
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    if (Looper.getMainLooper() != Looper.myLooper()) {
      bool = b(paramContext);
    }
    return bool;
  }
  
  private static boolean a(File paramFile)
  {
    try
    {
      boolean bool = e.b(paramFile);
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      Log.e("TbsCheckUtils", "isOatFileBroken exception: " + paramFile);
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (Build.VERSION.SDK_INT > 25) {
            return true;
          }
          paramContext = c(paramContext);
          if (paramContext != null)
          {
            paramContext = paramContext.listFiles(new FileFilter()
            {
              public boolean accept(File paramAnonymousFile)
              {
                paramAnonymousFile = paramAnonymousFile.getName();
                return (!TextUtils.isEmpty(paramAnonymousFile)) && (paramAnonymousFile.endsWith(".dex"));
              }
            });
            int j = paramContext.length;
            i = 0;
            if (i < j)
            {
              File localFile = paramContext[i];
              if ((!localFile.isFile()) || (!localFile.exists())) {
                break label159;
              }
              if (a(localFile))
              {
                TbsLog.w("TbsCheckUtils", "" + localFile + " is invalid --> check failed!");
                localFile.delete();
                return false;
              }
              TbsLog.i("TbsCheckUtils", "" + localFile + " #4 check success!");
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
      }
      return true;
      label159:
      i += 1;
    }
  }
  
  private static File c(Context paramContext)
  {
    File localFile = new File(QbSdk.getTbsFolderDir(paramContext), "core_share");
    if (localFile != null)
    {
      if (localFile.isDirectory())
      {
        paramContext = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        paramContext = null;
      }
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */