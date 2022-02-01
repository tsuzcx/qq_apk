package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PrivilegedAction;

public final class i
  implements PrivilegedAction
{
  private String lYV;
  private String lYW;
  
  public i(String paramString)
  {
    this.lYV = paramString;
  }
  
  public final Object run()
  {
    AppMethodBeat.i(155902);
    String str = System.getProperty(this.lYV);
    if (str == null)
    {
      str = this.lYW;
      AppMethodBeat.o(155902);
      return str;
    }
    AppMethodBeat.o(155902);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.util.i
 * JD-Core Version:    0.7.0.1
 */