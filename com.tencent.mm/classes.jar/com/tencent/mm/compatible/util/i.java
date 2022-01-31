package com.tencent.mm.compatible.util;

import java.security.PrivilegedAction;

public final class i
  implements PrivilegedAction
{
  private String dzW;
  private String dzX;
  
  public i(String paramString)
  {
    this.dzW = paramString;
  }
  
  public final Object run()
  {
    String str2 = System.getProperty(this.dzW);
    String str1 = str2;
    if (str2 == null) {
      str1 = this.dzX;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.util.i
 * JD-Core Version:    0.7.0.1
 */