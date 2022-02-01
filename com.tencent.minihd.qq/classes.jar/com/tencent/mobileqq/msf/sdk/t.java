package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.f;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

final class t
  extends Thread
{
  t(int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = new SimpleDateFormat("yy.MM.dd.HH");
    String str = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime()) + ".log";
    ((Calendar)localObject1).add(11, -1);
    localObject2 = ((SimpleDateFormat)localObject2).format(((Calendar)localObject1).getTime()) + ".log";
    File[] arrayOfFile = new File(o.n()).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      localObject1 = new ArrayList();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if ((localFile.getName().endsWith(str)) || (localFile.getName().endsWith((String)localObject2))) {
          ((ArrayList)localObject1).add(new o.a(localFile.getPath()));
        }
        i += 1;
      }
      o.e(o.o().replace(":", "_"));
      str = o.n() + o.o() + ".zip";
      localObject2 = new File(str);
      ((File)localObject2).delete();
    }
    try
    {
      ((File)localObject2).createNewFile();
      f.a((ArrayList)localObject1, str);
      f.a(this.a, str, this.b, this.c);
      ((File)localObject2).delete();
      return;
    }
    catch (IOException localIOException)
    {
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf exception " + localIOException);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf error " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.t
 * JD-Core Version:    0.7.0.1
 */