package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.a.a;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;
import java.util.Map;

public final class ca
  extends a
{
  public ca(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
  }
  
  public static void bAp()
  {
    AppMethodBeat.i(123974);
    a.a.a("reportbizlocation", new a.a()
    {
      public final a a(Map<String, String> paramAnonymousMap, cc paramAnonymouscc)
      {
        AppMethodBeat.i(123972);
        paramAnonymousMap = new ca(paramAnonymousMap, paramAnonymouscc);
        AppMethodBeat.o(123972);
        return paramAnonymousMap;
      }
    });
    AppMethodBeat.o(123974);
  }
  
  public final boolean bAo()
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
    this.oPl.add(str1);
    this.oPm.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.oPn.add(Integer.valueOf(str2.length()));
    this.oPj = str2;
    AppMethodBeat.o(123973);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ca
 * JD-Core Version:    0.7.0.1
 */