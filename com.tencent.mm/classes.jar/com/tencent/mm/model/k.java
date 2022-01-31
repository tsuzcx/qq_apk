package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class k
  extends a
{
  public k(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  public static void Zi()
  {
    AppMethodBeat.i(11236);
    a.a.a("biz_services_mute", new k.1());
    AppMethodBeat.o(11236);
  }
  
  public final boolean Zh()
  {
    AppMethodBeat.i(11235);
    if (this.values == null)
    {
      AppMethodBeat.o(11235);
      return false;
    }
    if (!this.TYPE.equals("biz_services_mute"))
    {
      AppMethodBeat.o(11235);
      return false;
    }
    String str2 = (String)this.values.get(".sysmsg.biz_services_mute.text");
    String str1 = (String)this.values.get(".sysmsg.biz_services_mute.link.text");
    str2 = str2 + str1;
    this.fLn.add(str1);
    this.fLo.addFirst(Integer.valueOf(str2.length() - str1.length()));
    this.fLp.add(Integer.valueOf(str2.length()));
    this.fLl = str2;
    AppMethodBeat.o(11235);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.k
 * JD-Core Version:    0.7.0.1
 */