package com.tencent.d.d.a;

import com.tencent.d.d.b.a;
import com.tencent.d.d.b.c;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class f
{
  private static boolean Y(File paramFile)
  {
    AppMethodBeat.i(138351);
    try
    {
      if ((c.aZk(paramFile.getAbsolutePath()) & 0x800) > 0)
      {
        AppMethodBeat.o(138351);
        return true;
      }
      AppMethodBeat.o(138351);
      return false;
    }
    catch (Exception paramFile)
    {
      h.w(paramFile);
      AppMethodBeat.o(138351);
    }
    return false;
  }
  
  public static boolean fTM()
  {
    AppMethodBeat.i(138352);
    if (com.tencent.d.d.b.f.fTO())
    {
      h.fUg();
      AppMethodBeat.o(138352);
      return false;
    }
    int j;
    int i;
    File localFile;
    try
    {
      Object localObject = new String(a.aZj("/proc/mounts"));
      "SetuidBitChecker mounts : ".concat(String.valueOf(localObject));
      h.fuo();
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
          h.fUg();
        }
      }
      label109:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label126;
        }
        AppMethodBeat.o(138352);
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
      AppMethodBeat.o(138352);
      return false;
    }
    label126:
    h.fUg();
    AppMethodBeat.o(138352);
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
        if ((!"run-as".equals(localFile.getName())) && (Y(localFile)))
        {
          new StringBuilder("SetuidBitChecker s-bit found : ").append(localFile.getAbsolutePath());
          h.fUg();
          AppMethodBeat.o(138352);
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
        if (Y(localFile))
        {
          new StringBuilder("SetuidBitChecker s-bit found : ").append(localFile.getAbsolutePath());
          h.fUg();
          AppMethodBeat.o(138352);
          return true;
        }
        i += 1;
      }
    }
    h.fUg();
    AppMethodBeat.o(138352);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.a.f
 * JD-Core Version:    0.7.0.1
 */