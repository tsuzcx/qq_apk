package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;

public final class ac
{
  private static String aG(String paramString1, String paramString2)
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
  
  public static ab aH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150166);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ(paramString1);
    if ((paramString1 == null) || (!paramString1.fcw()))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = new ab("@domain.android", paramString1.name, aG(paramString1.GZM.aOB(""), paramString2), paramString1.GZM.aOB(""), paramString1.isEnable(), true);
    AppMethodBeat.o(150166);
    return paramString1;
  }
  
  public static ab xL(String paramString)
  {
    AppMethodBeat.i(150163);
    paramString = new ab("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(150163);
    return paramString;
  }
  
  public static ab xM(String paramString)
  {
    AppMethodBeat.i(150164);
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ("@t.qq.com");
    if (localbu == null)
    {
      AppMethodBeat.o(150164);
      return null;
    }
    paramString = new ab("@t.qq.com", null, paramString, null, localbu.isEnable(), localbu.fcv());
    AppMethodBeat.o(150164);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ac
 * JD-Core Version:    0.7.0.1
 */