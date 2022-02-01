package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.a.a;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;
import java.util.Map;

public final class bs
  extends a
{
  public bs(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
  }
  
  public static void aAd()
  {
    AppMethodBeat.i(123974);
    a.a.a("reportbizlocation", new a.a()
    {
      public final a a(Map<String, String> paramAnonymousMap, bu paramAnonymousbu)
      {
        AppMethodBeat.i(123972);
        paramAnonymousMap = new bs(paramAnonymousMap, paramAnonymousbu);
        AppMethodBeat.o(123972);
        return paramAnonymousMap;
      }
    });
    AppMethodBeat.o(123974);
  }
  
  public final boolean aAc()
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
    this.ihQ.add(str1);
    this.ihR.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.ihS.add(Integer.valueOf(str2.length()));
    this.ihO = str2;
    AppMethodBeat.o(123973);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */