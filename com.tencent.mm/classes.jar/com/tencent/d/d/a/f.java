package com.tencent.d.d.a;

import com.tencent.d.d.b.a;
import com.tencent.d.d.b.c;
import com.tencent.d.f.h;
import java.io.File;
import java.io.IOException;

public final class f
{
  private static boolean U(File paramFile)
  {
    boolean bool = false;
    try
    {
      int i = c.afG(paramFile.getAbsolutePath());
      if ((i & 0x800) > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramFile)
    {
      h.l(paramFile);
    }
    return false;
  }
  
  public static boolean cOK()
  {
    if (com.tencent.d.d.b.f.cOM()) {
      h.i("SetuidBitChecker : SELinux is enforcing");
    }
    int j;
    int i;
    label57:
    File localFile;
    for (;;)
    {
      return false;
      try
      {
        Object localObject = new String(a.afF("/proc/mounts"));
        h.d("SetuidBitChecker mounts : " + (String)localObject);
        localObject = ((String)localObject).split("\n");
        j = localObject.length;
        i = 0;
        if (i < j)
        {
          localFile = localObject[i];
          if (localFile.contains(" /system "))
          {
            if (!localFile.contains(",nosuid")) {
              break label115;
            }
            h.i("SetuidBitChecker : nosuid found");
          }
        }
        label115:
        for (i = 1; i == 0; i = 0)
        {
          if (c.isAvailable()) {
            break label127;
          }
          h.i("SetuidBitChecker : OsUtil isn't available");
          return false;
          i += 1;
          break label57;
        }
        arrayOfFile = new File("/system/bin").listFiles();
      }
      catch (IOException localIOException)
      {
        h.l(localIOException);
        return false;
      }
    }
    label127:
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if ((!"run-as".equals(localFile.getName())) && (U(localFile)))
        {
          h.i("SetuidBitChecker s-bit found : " + localFile.getAbsolutePath());
          return true;
        }
        i += 1;
      }
    }
    File[] arrayOfFile = new File("/system/xbin").listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if (U(localFile))
        {
          h.i("SetuidBitChecker s-bit found : " + localFile.getAbsolutePath());
          return true;
        }
        i += 1;
      }
    }
    h.i("SetuidBitChecker s-bit not found");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.a.f
 * JD-Core Version:    0.7.0.1
 */