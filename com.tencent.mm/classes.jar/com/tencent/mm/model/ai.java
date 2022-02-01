package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storage.ci.a;

public final class ai
{
  public static ah Kb(String paramString)
  {
    AppMethodBeat.i(150163);
    paramString = new ah("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(150163);
    return paramString;
  }
  
  public static ah Kc(String paramString)
  {
    AppMethodBeat.i(150164);
    ci localci = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
    if (localci == null)
    {
      AppMethodBeat.o(150164);
      return null;
    }
    paramString = new ah("@t.qq.com", null, paramString, null, localci.isEnable(), localci.gEp());
    AppMethodBeat.o(150164);
    return paramString;
  }
  
  private static String aM(String paramString1, String paramString2)
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
  
  public static ah aN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150166);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY(paramString1);
    if ((paramString1 == null) || (!paramString1.gEq()))
    {
      AppMethodBeat.o(150166);
      return null;
    }
    paramString1 = new ah("@domain.android", paramString1.name, aM(paramString1.OrA.bkR(""), paramString2), paramString1.OrA.bkR(""), paramString1.isEnable(), true);
    AppMethodBeat.o(150166);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ai
 * JD-Core Version:    0.7.0.1
 */