package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;

public final class ad
{
  public static ac AL(String paramString)
  {
    AppMethodBeat.i(150163);
    paramString = new ac("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(150163);
    return paramString;
  }
  
  public static ac AM(String paramString)
  {
    AppMethodBeat.i(150164);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy("@t.qq.com");
    if (localca == null)
    {
      AppMethodBeat.o(150164);
      return null;
    }
    paramString = new ac("@t.qq.com", null, paramString, null, localca.isEnable(), localca.fsC());
    AppMethodBeat.o(150164);
    return paramString;
  }
  
  private static String aJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150165);
    String str = "";
    if (paramString1 != null) {
      str = "" + paramString1.replace("@", "");
    }
    paramString1 = str;
    if (paramString2 != null) {
      paramString1 = str + paramString2;
    }
    AppMethodBeat.o(150165);
    return paramString1;
  }
  
  public static ac aK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150166);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy(paramString1);
    if ((paramString1 == null) || (!paramString1.fsD()))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = new ac("@domain.android", paramString1.name, aJ(paramString1.INb.aUs(""), paramString2), paramString1.INb.aUs(""), paramString1.isEnable(), true);
    AppMethodBeat.o(150166);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ad
 * JD-Core Version:    0.7.0.1
 */