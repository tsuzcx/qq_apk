package com.tencent.open.downloadnew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import lhw;

public class YybHandleUtil
{
  public static final long a = 710020706L;
  public static String a = "YybHandleUtil";
  public static String b = "APK/MobileAssistant_main.apk";
  public static String c = "yyb.apk";
  public static final String d = "1101070898";
  public static final String e = "5848";
  public static final String f = "https://softfile.3g.qq.com/msoft/allen/qq_com.tencent.android.qqdownloader.apk";
  public static final String g = "com.tencent.android.qqdownloader";
  public static final String h = "ANDROIDQQ.MYAPP.YYBDOWNLOAD";
  public static final String i = "应用宝";
  
  public static String a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    float f2 = paramInt;
    paramInt = 0;
    float f1;
    String str2;
    String str1;
    if (f2 / 1048576.0F > 1.0F)
    {
      f1 = f2 / 1048576.0F;
      paramInt = 2;
      str2 = new DecimalFormat("#.#").format(f1);
      if (paramInt != 2) {
        break label92;
      }
      str1 = "MB";
    }
    for (;;)
    {
      return str2 + str1;
      f1 = f2;
      if (f2 / 1024.0F <= 1.0F) {
        break;
      }
      f1 = f2 / 1024.0F;
      paramInt = 1;
      break;
      label92:
      if (paramInt == 1) {
        str1 = "KB";
      } else {
        str1 = "B";
      }
    }
  }
  
  public static void a()
  {
    LogUtility.c(a, "---deleteYYBApkPackage--");
    ThreadManager.b().post(new lhw());
  }
  
  public static boolean a()
  {
    String str = CommonDataAdapter.a().a().getFilesDir().getAbsolutePath() + File.separator + c;
    return AppUtil.a(CommonDataAdapter.a().a(), str);
  }
  
  @SuppressLint({"WorldReadableFiles"})
  protected static boolean b()
  {
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    LogUtility.c(a, "---copyApkFormAssets--");
    Object localObject7 = new File(CommonDataAdapter.a().a().getFilesDir().getAbsolutePath() + File.separator + c);
    if ((localObject7 != null) && (((File)localObject7).exists())) {
      ((File)localObject7).delete();
    }
    try
    {
      localInputStream = CommonDataAdapter.a().a().getAssets().open(b);
      bool2 = true;
    }
    catch (IOException localIOException7)
    {
      try
      {
        localObject7 = CommonDataAdapter.a().a().openFileOutput("yyb.apk", 0);
        localObject3 = localObject7;
        localObject5 = localObject7;
        localObject1 = localObject7;
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          localObject3 = localObject7;
          localObject5 = localObject7;
          localObject1 = localObject7;
          int j = localInputStream.read(arrayOfByte);
          if (j == -1) {
            break;
          }
          localObject3 = localObject7;
          localObject5 = localObject7;
          localObject1 = localObject7;
          ((FileOutputStream)localObject7).write(arrayOfByte, 0, j);
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        InputStream localInputStream;
        boolean bool2;
        localObject1 = localObject3;
        localFileNotFoundException.printStackTrace();
        localObject1 = localObject3;
        LogUtility.c(a, "---copyApkFormAssets--msg22 = " + localFileNotFoundException.getMessage());
        if (localObject3 == null) {
          break label244;
        }
        for (;;)
        {
          try
          {
            localObject3.close();
            bool1 = false;
          }
          catch (IOException localIOException2)
          {
            localIOException2.printStackTrace();
            bool1 = false;
            continue;
          }
          if (localInputStream != null) {}
          try
          {
            localInputStream.close();
            return bool1;
          }
          catch (IOException localIOException5)
          {
            Object localObject6;
            Object localObject2;
            localIOException5.printStackTrace();
          }
          localIOException7 = localIOException7;
          LogUtility.c(a, "---copyApkFormAssets--msg11 = " + localIOException7.getMessage());
          localIOException7.printStackTrace();
          localInputStream = null;
          bool2 = false;
          break;
          localObject3 = localIOException7;
          localObject6 = localIOException7;
          localObject1 = localIOException7;
          localIOException7.flush();
          bool1 = bool2;
          if (localIOException7 != null) {
            try
            {
              localIOException7.close();
              bool1 = bool2;
            }
            catch (IOException localIOException1)
            {
              localIOException1.printStackTrace();
              bool1 = bool2;
            }
          }
        }
      }
      catch (IOException localIOException6)
      {
        for (;;)
        {
          localObject2 = localObject6;
          localIOException6.printStackTrace();
          localObject2 = localObject6;
          LogUtility.c(a, "---copyApkFormAssets--msg33 = " + localIOException6.getMessage());
          if (localObject6 != null) {}
          try
          {
            localObject6.close();
            bool1 = false;
          }
          catch (IOException localIOException3)
          {
            localIOException3.printStackTrace();
            bool1 = false;
          }
        }
      }
      finally
      {
        if (localIOException3 == null) {
          break label432;
        }
        try
        {
          localIOException3.close();
          throw localObject4;
        }
        catch (IOException localIOException4)
        {
          for (;;)
          {
            localIOException4.printStackTrace();
          }
        }
      }
    }
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (localInputStream == null) {}
    }
    label244:
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil
 * JD-Core Version:    0.7.0.1
 */