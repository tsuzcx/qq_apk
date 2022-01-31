package com.tencent.mm.plugin.base.model;

import android.os.Process;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static String cm(String paramString1, String paramString2)
  {
    return g.o((g.o(paramString1.getBytes()) + b.cl(paramString2, paramString1)).getBytes());
  }
  
  public static String decrypt(String paramString)
  {
    String str1;
    if ((paramString == null) || (paramString.length() <= 0)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          do
          {
            return str1;
            y.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { bk.am(ae.getContext(), Process.myPid()) });
            str1 = paramString;
          } while (!paramString.startsWith("shortcut_"));
          str1 = paramString;
        } while (paramString.length() <= 9);
        str2 = paramString.substring(9);
        str1 = paramString;
      } while (str2 == null);
      str1 = paramString;
    } while (str2.length() <= 0);
    return b.cl(new String(b.xI(str2)), q.zf());
  }
  
  public static String xJ(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      return null;
      y.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { bk.am(ae.getContext(), Process.myPid()) });
      paramString = b.cl(paramString, q.zf());
    } while (bk.bl(paramString));
    return "shortcut_" + b.W(paramString.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c
 * JD-Core Version:    0.7.0.1
 */