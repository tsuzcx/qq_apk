package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;

public final class ac
{
  private static String ay(String paramString1, String paramString2)
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
  
  public static ab az(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150166);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP(paramString1);
    if ((paramString1 == null) || (!paramString1.eMS()))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = new ab("@domain.android", paramString1.name, ay(paramString1.FAK.aJf(""), paramString2), paramString1.FAK.aJf(""), paramString1.isEnable(), true);
    AppMethodBeat.o(150166);
    return paramString1;
  }
  
  public static ab tF(String paramString)
  {
    AppMethodBeat.i(150163);
    paramString = new ab("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(150163);
    return paramString;
  }
  
  public static ab tG(String paramString)
  {
    AppMethodBeat.i(150164);
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP("@t.qq.com");
    if (localbr == null)
    {
      AppMethodBeat.o(150164);
      return null;
    }
    paramString = new ab("@t.qq.com", null, paramString, null, localbr.isEnable(), localbr.eMR());
    AppMethodBeat.o(150164);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ac
 * JD-Core Version:    0.7.0.1
 */