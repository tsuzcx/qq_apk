package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.az.a.a;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class by
  extends a
{
  public by(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  public static void aTB()
  {
    AppMethodBeat.i(123974);
    a.a.a("reportbizlocation", new a.a()
    {
      public final a a(Map<String, String> paramAnonymousMap, ca paramAnonymousca)
      {
        AppMethodBeat.i(123972);
        paramAnonymousMap = new by(paramAnonymousMap, paramAnonymousca);
        AppMethodBeat.o(123972);
        return paramAnonymousMap;
      }
    });
    AppMethodBeat.o(123974);
  }
  
  public final boolean aTA()
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
    this.jfI.add(str1);
    this.jfJ.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.jfK.add(Integer.valueOf(str2.length()));
    this.jfG = str2;
    AppMethodBeat.o(123973);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.by
 * JD-Core Version:    0.7.0.1
 */