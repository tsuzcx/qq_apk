package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.h;
import com.tencent.xweb.util.c;
import com.tencent.xweb.y;
import org.xwalk.core.WebViewExtensionListener;

public final class b
{
  public static c AZH;
  public static y AZI;
  public static WebViewExtensionListener AZJ;
  public static h AZK;
  
  static
  {
    AppMethodBeat.i(80385);
    AZH = new b.1();
    AZI = new b.2();
    AZJ = new b.3();
    AZK = new b.4();
    AppMethodBeat.o(80385);
  }
  
  public static String dTi()
  {
    AppMethodBeat.i(80384);
    String str = ah.getProcessName();
    if (str == null)
    {
      AppMethodBeat.o(80384);
      return "";
    }
    if (str.contains(":"))
    {
      str = str.substring(str.lastIndexOf(":") + 1).toLowerCase();
      if (str.startsWith("appbrand"))
      {
        AppMethodBeat.o(80384);
        return "appbrand";
      }
      AppMethodBeat.o(80384);
      return str;
    }
    if (str.contains("."))
    {
      str = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
      AppMethodBeat.o(80384);
      return str;
    }
    AppMethodBeat.o(80384);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cn.b
 * JD-Core Version:    0.7.0.1
 */