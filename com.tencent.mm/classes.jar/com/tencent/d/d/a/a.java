package com.tencent.d.d.a;

import com.tencent.d.f.h;
import java.io.File;
import java.io.IOException;

public final class a
{
  public static boolean afD(String paramString)
  {
    if (!new File(paramString).exists()) {
      return true;
    }
    try
    {
      boolean bool = com.tencent.d.d.b.a.afD(paramString);
      if (!bool) {
        h.i("BootScriptChecker found no-elf file : " + paramString);
      }
      return bool;
    }
    catch (IOException paramString)
    {
      h.l(paramString);
    }
    return true;
  }
  
  public static boolean afE(String paramString)
  {
    boolean bool2 = true;
    Object localObject = new File(paramString);
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      if (((File)localObject).length() <= 51200L) {
        break label35;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        label35:
        localObject = new String(com.tencent.d.d.b.a.afF(((File)localObject).getAbsolutePath()));
        bool2 = ((String)localObject).contains("applypatch ");
        h.d("BootScriptChecker script (" + paramString + ") content : \n" + (String)localObject);
        bool1 = bool2;
        if (!bool2)
        {
          h.i("BootScriptChecker found unofficial file : " + paramString);
          return bool2;
        }
      }
      catch (Exception paramString)
      {
        h.l(paramString);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.d.a.a
 * JD-Core Version:    0.7.0.1
 */