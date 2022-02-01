package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public c(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
  }
  
  protected final boolean axn()
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
    this.hOC.add(str1);
    this.hOD.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.hOE.add(Integer.valueOf(str2.length()));
    this.hOA = str2;
    AppMethodBeat.o(101784);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.c
 * JD-Core Version:    0.7.0.1
 */