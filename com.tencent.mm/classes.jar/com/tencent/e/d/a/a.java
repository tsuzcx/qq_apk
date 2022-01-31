package com.tencent.e.d.a;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class a
{
  public static boolean awA(String paramString)
  {
    AppMethodBeat.i(114502);
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) || (((File)localObject).length() > 51200L))
    {
      AppMethodBeat.o(114502);
      return true;
    }
    try
    {
      localObject = new String(com.tencent.e.d.b.a.awB(((File)localObject).getAbsolutePath()));
      boolean bool = ((String)localObject).contains("applypatch ");
      new StringBuilder("BootScriptChecker script (").append(paramString).append(") content : \n").append((String)localObject);
      h.dUU();
      if (!bool)
      {
        "BootScriptChecker found unofficial file : ".concat(String.valueOf(paramString));
        h.dUT();
      }
      AppMethodBeat.o(114502);
      return bool;
    }
    catch (Exception paramString)
    {
      h.w(paramString);
      AppMethodBeat.o(114502);
    }
    return true;
  }
  
  public static boolean awz(String paramString)
  {
    AppMethodBeat.i(114501);
    if (!new File(paramString).exists())
    {
      AppMethodBeat.o(114501);
      return true;
    }
    try
    {
      boolean bool = com.tencent.e.d.b.a.awz(paramString);
      if (!bool)
      {
        "BootScriptChecker found no-elf file : ".concat(String.valueOf(paramString));
        h.dUT();
      }
      AppMethodBeat.o(114501);
      return bool;
    }
    catch (IOException paramString)
    {
      h.w(paramString);
      AppMethodBeat.o(114501);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.d.a.a
 * JD-Core Version:    0.7.0.1
 */