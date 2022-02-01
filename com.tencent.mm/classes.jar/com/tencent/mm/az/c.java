package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public c(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  protected final boolean aTA()
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
    this.jfI.add(str1);
    this.jfJ.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.jfK.add(Integer.valueOf(str2.length()));
    this.jfG = str2;
    AppMethodBeat.o(101784);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.c
 * JD-Core Version:    0.7.0.1
 */