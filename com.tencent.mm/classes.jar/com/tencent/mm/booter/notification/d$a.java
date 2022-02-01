package com.tencent.mm.booter.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class d$a
  implements Serializable
{
  public int dwg;
  public String userName;
  
  public final String toString()
  {
    AppMethodBeat.i(19957);
    String str = "[" + this.userName + "(" + this.dwg + ")]";
    AppMethodBeat.o(19957);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d.a
 * JD-Core Version:    0.7.0.1
 */