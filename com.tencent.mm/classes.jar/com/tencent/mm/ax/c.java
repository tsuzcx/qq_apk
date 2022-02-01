package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public c(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
  }
  
  protected final boolean bAo()
  {
    AppMethodBeat.i(101784);
    if (this.values == null)
    {
      AppMethodBeat.o(101784);
      return false;
    }
    if (!this.TYPE.equals("chatroommuteexpt"))
    {
      AppMethodBeat.o(101784);
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.chatroommuteexpt.text");
    String str1 = (String)this.values.get(".sysmsg.chatroommuteexpt.link.text");
    str2 = str2 + str1;
    this.oPl.add(str1);
    this.oPm.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.oPn.add(Integer.valueOf(str2.length()));
    this.oPj = str2;
    AppMethodBeat.o(101784);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ax.c
 * JD-Core Version:    0.7.0.1
 */