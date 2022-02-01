package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PrivilegedAction;

public final class h
  implements PrivilegedAction
{
  private String gdB;
  private String gdC;
  
  public h(String paramString)
  {
    this.gdB = paramString;
  }
  
  public final Object run()
  {
    AppMethodBeat.i(155902);
    String str = System.getProperty(this.gdB);
    if (str == null)
    {
      str = this.gdC;
      AppMethodBeat.o(155902);
      return str;
    }
    AppMethodBeat.o(155902);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.util.h
 * JD-Core Version:    0.7.0.1
 */