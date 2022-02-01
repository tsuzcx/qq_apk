package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PrivilegedAction;

public final class h
  implements PrivilegedAction
{
  private String jvD;
  private String jvE;
  
  public h(String paramString)
  {
    this.jvD = paramString;
  }
  
  public final Object run()
  {
    AppMethodBeat.i(155902);
    String str = System.getProperty(this.jvD);
    if (str == null)
    {
      str = this.jvE;
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