package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.cj.a;

public final class ai
{
  public static ah Rt(String paramString)
  {
    AppMethodBeat.i(150163);
    paramString = new ah("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(150163);
    return paramString;
  }
  
  public static ah Ru(String paramString)
  {
    AppMethodBeat.i(150164);
    cj localcj = ((n)h.ae(n.class)).bbU().aPi("@t.qq.com");
    if (localcj == null)
    {
      AppMethodBeat.o(150164);
      return null;
    }
    paramString = new ah("@t.qq.com", null, paramString, null, localcj.isEnable(), localcj.hAF());
    AppMethodBeat.o(150164);
    return paramString;
  }
  
  private static String aQ(String paramString1, String paramString2)
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
  
  public static ah aR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150166);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = ((n)h.ae(n.class)).bbU().aPi(paramString1);
    if ((paramString1 == null) || (!paramString1.hAG()))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = new ah("@domain.android", paramString1.name, aQ(paramString1.VHx.bxr(""), paramString2), paramString1.VHx.bxr(""), paramString1.isEnable(), true);
    AppMethodBeat.o(150166);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ai
 * JD-Core Version:    0.7.0.1
 */