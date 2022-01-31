package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public c(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  protected final boolean Zh()
  {
    AppMethodBeat.i(5555);
    if (this.values == null)
    {
      AppMethodBeat.o(5555);
      return false;
    }
    if (!this.TYPE.equals("chatroommuteexpt"))
    {
      AppMethodBeat.o(5555);
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.chatroommuteexpt.text");
    String str1 = (String)this.values.get(".sysmsg.chatroommuteexpt.link.text");
    str2 = str2 + str1;
    this.fLn.add(str1);
    this.fLo.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.fLp.add(Integer.valueOf(str2.length()));
    this.fLl = str2;
    AppMethodBeat.o(5555);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ay.c
 * JD-Core Version:    0.7.0.1
 */