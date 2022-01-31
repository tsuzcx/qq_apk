package com.tencent.e.d.a;

import com.tencent.e.d.b.a;
import com.tencent.e.d.b.c;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class f
{
  private static boolean ad(File paramFile)
  {
    AppMethodBeat.i(114510);
    try
    {
      if ((c.awC(paramFile.getAbsolutePath()) & 0x800) > 0)
      {
        AppMethodBeat.o(114510);
        return true;
      }
      AppMethodBeat.o(114510);
      return false;
    }
    catch (Exception paramFile)
    {
      h.w(paramFile);
      AppMethodBeat.o(114510);
    }
    return false;
  }
  
  public static boolean dUz()
  {
    AppMethodBeat.i(114511);
    if (com.tencent.e.d.b.f.dUB())
    {
      h.dUT();
      AppMethodBeat.o(114511);
      return false;
    }
    int j;
    int i;
    File localFile;
    try
    {
      Object localObject = new String(a.awB("/proc/mounts"));
      "SetuidBitChecker mounts : ".concat(String.valueOf(localObject));
      h.dUU();
      localObject = ((String)localObject).split("\n");
      j = localObject.length;
      i = 0;
      if (i < j)
      {
        localFile = localObject[i];
        if (localFile.contains(" /system "))
        {
          if (!localFile.contains(",nosuid")) {
            break label109;
          }
          h.dUT();
        }
      }
      label109:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label126;
        }
        AppMethodBeat.o(114511);
        return false;
        i += 1;
        break;
      }
      if (c.isAvailable()) {
        break label142;
      }
    }
    catch (IOException localIOException)
    {
      h.w(localIOException);
      AppMethodBeat.o(114511);
      return false;
    }
    label126:
    h.dUT();
    AppMethodBeat.o(114511);
    return false;
    label142:
    File[] arrayOfFile = new File("/system/bin").listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if ((!"run-as".equals(localFile.getName())) && (ad(localFile)))
        {
          new StringBuilder("SetuidBitChecker s-bit found : ").append(localFile.getAbsolutePath());
          h.dUT();
          AppMethodBeat.o(114511);
          return true;
        }
        i += 1;
      }
    }
    arrayOfFile = new File("/system/xbin").listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if (ad(localFile))
        {
          new StringBuilder("SetuidBitChecker s-bit found : ").append(localFile.getAbsolutePath());
          h.dUT();
          AppMethodBeat.o(114511);
          return true;
        }
        i += 1;
      }
    }
    h.dUT();
    AppMethodBeat.o(114511);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.e.d.a.f
 * JD-Core Version:    0.7.0.1
 */