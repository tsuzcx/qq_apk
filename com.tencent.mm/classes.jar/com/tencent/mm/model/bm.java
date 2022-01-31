package com.tencent.mm.model;

import com.tencent.mm.ax.a;
import com.tencent.mm.ax.a.a;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class bm
  extends a
{
  public bm(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  public static void Ic()
  {
    a.a.a("reportbizlocation", new bm.1());
  }
  
  protected final boolean Ib()
  {
    if (this.values == null) {}
    while (!this.TYPE.equals("reportbizlocation")) {
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.reportbizlocation.text");
    String str1 = (String)this.values.get(".sysmsg.reportbizlocation.link.text");
    str2 = str2 + str1;
    this.evA.add(str1);
    this.evB.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.evC.add(Integer.valueOf(str2.length()));
    this.evy = str2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bm
 * JD-Core Version:    0.7.0.1
 */