package com.tencent.mm.plugin.datareport.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.c.i;

public final class b
{
  public static int amy(String paramString)
  {
    AppMethodBeat.i(262812);
    int i = 0;
    if (i.qA(paramString, "page_in")) {
      i = 6;
    }
    for (;;)
    {
      AppMethodBeat.o(262812);
      return i;
      if (i.qA(paramString, "page_out")) {
        i = 10;
      } else if (i.qA(paramString, "session_in")) {
        i = 18;
      } else if (i.qA(paramString, "session_out")) {
        i = 34;
      }
    }
  }
  
  public static int amz(String paramString)
  {
    AppMethodBeat.i(262820);
    int i = 0;
    if (i.qA(paramString, "view_clk")) {
      i = 14;
    }
    for (;;)
    {
      AppMethodBeat.o(262820);
      return i;
      if (i.qA(paramString, "view_exp")) {
        i = 50;
      } else if (i.qA(paramString, "view_unexp")) {
        i = 194;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.j.b
 * JD-Core Version:    0.7.0.1
 */