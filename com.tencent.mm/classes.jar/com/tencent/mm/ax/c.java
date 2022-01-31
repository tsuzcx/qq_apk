package com.tencent.mm.ax;

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
  
  protected final boolean Ib()
  {
    if (this.values == null) {}
    while (!this.TYPE.equals("chatroommuteexpt")) {
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.chatroommuteexpt.text");
    String str1 = (String)this.values.get(".sysmsg.chatroommuteexpt.link.text");
    str2 = str2 + str1;
    this.evA.add(str1);
    this.evB.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.evC.add(Integer.valueOf(str2.length()));
    this.evy = str2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ax.c
 * JD-Core Version:    0.7.0.1
 */