package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cb.a;

public final class ae
{
  public static ad Bv(String paramString)
  {
    AppMethodBeat.i(150163);
    paramString = new ad("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(150163);
    return paramString;
  }
  
  public static ad Bw(String paramString)
  {
    AppMethodBeat.i(150164);
    cb localcb = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
    if (localcb == null)
    {
      AppMethodBeat.o(150164);
      return null;
    }
    paramString = new ad("@t.qq.com", null, paramString, null, localcb.isEnable(), localcb.fwD());
    AppMethodBeat.o(150164);
    return paramString;
  }
  
  private static String aK(String paramString1, String paramString2)
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
  
  public static ad aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150166);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD(paramString1);
    if ((paramString1 == null) || (!paramString1.fwE()))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = new ad("@domain.android", paramString1.name, aK(paramString1.JhI.aVT(""), paramString2), paramString1.JhI.aVT(""), paramString1.isEnable(), true);
    AppMethodBeat.o(150166);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ae
 * JD-Core Version:    0.7.0.1
 */