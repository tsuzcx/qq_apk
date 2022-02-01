package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.a.a;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class bz
  extends a
{
  public bz(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  public static void bcA()
  {
    AppMethodBeat.i(123974);
    a.a.a("reportbizlocation", new a.a()
    {
      public final a a(Map<String, String> paramAnonymousMap, ca paramAnonymousca)
      {
        AppMethodBeat.i(123972);
        paramAnonymousMap = new bz(paramAnonymousMap, paramAnonymousca);
        AppMethodBeat.o(123972);
        return paramAnonymousMap;
      }
    });
    AppMethodBeat.o(123974);
  }
  
  public final boolean bcz()
  {
    AppMethodBeat.i(123973);
    if (this.values == null)
    {
      AppMethodBeat.o(123973);
      return false;
    }
    if (!this.TYPE.equals("reportbizlocation"))
    {
      AppMethodBeat.o(123973);
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.reportbizlocation.text");
    String str1 = (String)this.values.get(".sysmsg.reportbizlocation.link.text");
    str2 = str2 + str1;
    this.lWj.add(str1);
    this.lWk.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.lWl.add(Integer.valueOf(str2.length()));
    this.lWg = str2;
    AppMethodBeat.o(123973);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bz
 * JD-Core Version:    0.7.0.1
 */