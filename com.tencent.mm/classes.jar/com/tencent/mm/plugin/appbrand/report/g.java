package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.platformtools.d;
import com.tencent.xweb.WebView;

public enum g
{
  private g() {}
  
  public static g aoc()
  {
    boolean bool1 = WebView.isSys();
    boolean bool2 = WebView.isXWalk();
    boolean bool3 = WebView.isX5();
    if (((!bool1) || (bool2) || (bool3)) && ((bool1) || (!bool2) || (bool3)) && ((bool1) || (bool2) || (!bool3)))
    {
      if (d.DEBUG) {
        throw new IllegalStateException("WebViewType invalid");
      }
      return gXK;
    }
    if (bool3) {
      return gXH;
    }
    if (bool2) {
      return gXJ;
    }
    return gXI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g
 * JD-Core Version:    0.7.0.1
 */