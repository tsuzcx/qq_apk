package com.tencent.mm.cl;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.r;
import com.tencent.xweb.util.b;
import org.xwalk.core.WebViewExtensionListener;

public final class a
{
  public static b wDk = new a.1();
  public static r wDl = new a.2();
  public static WebViewExtensionListener wDm = new a.3();
  
  public static String cNC()
  {
    String str2 = ae.getProcessName();
    String str1;
    if (str2 == null) {
      str1 = "";
    }
    do
    {
      do
      {
        return str1;
        if (!str2.contains(":")) {
          break;
        }
        str2 = str2.substring(str2.lastIndexOf(":") + 1).toLowerCase();
        str1 = str2;
      } while (!str2.startsWith("appbrand"));
      return "appbrand";
      str1 = str2;
    } while (!str2.contains("."));
    return str2.substring(str2.lastIndexOf(".") + 1).toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cl.a
 * JD-Core Version:    0.7.0.1
 */