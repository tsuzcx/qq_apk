package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.a.a;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends a
{
  public n(Map<String, String> paramMap, bl parambl)
  {
    super(paramMap, parambl);
  }
  
  public static void aqy()
  {
    AppMethodBeat.i(123971);
    a.a.a("biz_services_mute", new a.a()
    {
      public final a a(Map<String, String> paramAnonymousMap, bl paramAnonymousbl)
      {
        AppMethodBeat.i(123969);
        paramAnonymousMap = new n(paramAnonymousMap, paramAnonymousbl);
        AppMethodBeat.o(123969);
        return paramAnonymousMap;
      }
    });
    AppMethodBeat.o(123971);
  }
  
  public final boolean aqx()
  {
    AppMethodBeat.i(123970);
    if (this.values == null)
    {
      AppMethodBeat.o(123970);
      return false;
    }
    if (!this.TYPE.equals("biz_services_mute"))
    {
      AppMethodBeat.o(123970);
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.biz_services_mute.text");
    String str1 = (String)this.values.get(".sysmsg.biz_services_mute.link.text");
    str2 = str2 + str1;
    this.hnZ.add(str1);
    this.hoa.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.hob.add(Integer.valueOf(str2.length()));
    this.hnX = str2;
    AppMethodBeat.o(123970);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.n
 * JD-Core Version:    0.7.0.1
 */