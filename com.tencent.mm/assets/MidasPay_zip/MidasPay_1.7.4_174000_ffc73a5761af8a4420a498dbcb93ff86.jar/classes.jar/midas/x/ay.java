package midas.x;

import android.content.Context;
import android.os.Environment;
import com.tencent.midas.comm.APLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ay
{
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a.a().d.getDir("midaspluginsTemp", 0);
    File localFile = a.a().d.getDir("midasplugins", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject2).append("/Tencent/MidasPay/");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    File[] arrayOfFile = ((File)localObject1).listFiles();
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    if (paramInt1 == 1)
    {
      a(arrayOfFile, localFile);
      a((File)localObject1, localFile, 1);
      if (paramInt2 != 1) {
        a((File)localObject1, (File)localObject2, 2);
      }
      if (((File)localObject1).listFiles().length > 0)
      {
        localObject1 = ((File)localObject1).listFiles();
        paramInt1 = 0;
        while (paramInt1 < localObject1.length)
        {
          localObject1[paramInt1].delete();
          paramInt1 += 1;
        }
      }
    }
    else if (paramInt1 == 2)
    {
      a((File)localObject1, (File)localObject2, 2);
    }
    aq.a().e(false);
    APLog.i("APMidasMerge ", "resultData=data区的app_midasplugins的文件删除完成");
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  private static void a(File paramFile1, File paramFile2, int paramInt)
  {
    File[] arrayOfFile = paramFile1.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      try
      {
        APLog.i("APMidasMerge ", "resultData=data区的app_midaspugintemp到app_midasplugins的copy开始");
        if (arrayOfFile[i].getName().endsWith(".diff"))
        {
          APLog.i("APMidasMerge ", "resultData=删除data区的app_midasplugins的diff文件");
          arrayOfFile[i].delete();
        }
        else if (paramInt == 2)
        {
          if (!arrayOfFile[i].getName().endsWith(".ini")) {
            a(arrayOfFile, paramFile1, paramFile2, i);
          }
        }
        else
        {
          a(arrayOfFile, paramFile1, paramFile2, i);
        }
        APLog.i("APMidasMerge ", "resultData=data区的app_midaspugintemp到app_midasplugins的copy完成");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
  }
  
  private static void a(File[] paramArrayOfFile, File paramFile)
  {
    if ((paramArrayOfFile != null) && (paramArrayOfFile.length > 0))
    {
      paramFile = paramFile.listFiles();
      int i = 0;
      while (i < paramArrayOfFile.length)
      {
        String str1 = paramArrayOfFile[i].getName().split("\\_")[0];
        int j = 0;
        while (j < paramFile.length)
        {
          String str2 = paramFile[j].getName().split("\\_")[0];
          if ((str1 != null) && (str2 != null) && (str1.equals(str2)))
          {
            paramFile[j].delete();
            break;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private static void a(File[] paramArrayOfFile, File paramFile1, File paramFile2, int paramInt)
  {
    try
    {
      paramFile1 = new File(paramFile1, paramArrayOfFile[paramInt].getName());
      paramFile2 = new File(paramFile2, paramArrayOfFile[paramInt].getName());
      paramArrayOfFile = new FileInputStream(paramFile1);
      paramFile1 = new BufferedInputStream(paramArrayOfFile);
      paramFile2 = new FileOutputStream(paramFile2);
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        paramInt = paramFile1.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        localBufferedOutputStream.write(arrayOfByte, 0, paramInt);
      }
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      paramFile2.flush();
      paramFile2.close();
      paramFile1.close();
      paramArrayOfFile.close();
      return;
    }
    catch (Exception paramArrayOfFile)
    {
      paramArrayOfFile.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ay
 * JD-Core Version:    0.7.0.1
 */