package com.tencent.e.d.a;

import com.tencent.e.d.b.b;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class a
{
  public static boolean bFw(String paramString)
  {
    AppMethodBeat.i(138342);
    if (!new File(paramString).exists())
    {
      AppMethodBeat.o(138342);
      return true;
    }
    try
    {
      boolean bool = b.bFw(paramString);
      if (!bool)
      {
        "BootScriptChecker found no-elf file : ".concat(String.valueOf(paramString));
        h.jXC();
      }
      AppMethodBeat.o(138342);
      return bool;
    }
    catch (IOException paramString)
    {
      h.w(paramString);
      AppMethodBeat.o(138342);
    }
    return true;
  }
  
  public static boolean bFx(String paramString)
  {
    AppMethodBeat.i(138343);
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) || (((File)localObject).length() > 51200L))
    {
      AppMethodBeat.o(138343);
      return true;
    }
    try
    {
      localObject = new String(b.bgq(((File)localObject).getAbsolutePath()));
      boolean bool = ((String)localObject).contains("applypatch ");
      new StringBuilder("BootScriptChecker script (").append(paramString).append(") content : \n").append((String)localObject);
      h.jhd();
      if (!bool)
      {
        "BootScriptChecker found unofficial file : ".concat(String.valueOf(paramString));
        h.jXC();
      }
      AppMethodBeat.o(138343);
      return bool;
    }
    catch (Exception paramString)
    {
      h.w(paramString);
      AppMethodBeat.o(138343);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.a.a
 * JD-Core Version:    0.7.0.1
 */