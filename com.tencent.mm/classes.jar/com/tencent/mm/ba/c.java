package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public c(Map<String, String> paramMap, bl parambl)
  {
    super(paramMap, parambl);
  }
  
  protected final boolean aqx()
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
    this.hnZ.add(str1);
    this.hoa.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.hob.add(Integer.valueOf(str2.length()));
    this.hnX = str2;
    AppMethodBeat.o(101784);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.c
 * JD-Core Version:    0.7.0.1
 */