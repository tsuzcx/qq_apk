package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;

public final class z
{
  private static String aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77808);
    String str = "";
    if (paramString1 != null) {
      str = "" + paramString1.replace("@", "");
    }
    paramString1 = str;
    if (paramString2 != null) {
      paramString1 = str + paramString2;
    }
    AppMethodBeat.o(77808);
    return paramString1;
  }
  
  public static y ak(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77809);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      AppMethodBeat.o(77809);
      return null;
    }
    paramString1 = ((j)g.E(j.class)).YI().TL(paramString1);
    if ((paramString1 == null) || (!paramString1.dyI()))
    {
      AppMethodBeat.o(77809);
      return null;
    }
    paramString1 = new y("@domain.android", paramString1.name, aj(paramString1.yOV.asA(""), paramString2), paramString1.yOV.asA(""), paramString1.isEnable(), true);
    AppMethodBeat.o(77809);
    return paramString1;
  }
  
  public static y oS(String paramString)
  {
    AppMethodBeat.i(77806);
    paramString = new y("@black.android", null, paramString, null, true, true);
    AppMethodBeat.o(77806);
    return paramString;
  }
  
  public static y oT(String paramString)
  {
    AppMethodBeat.i(77807);
    bq localbq = ((j)g.E(j.class)).YI().TL("@t.qq.com");
    if (localbq == null)
    {
      AppMethodBeat.o(77807);
      return null;
    }
    paramString = new y("@t.qq.com", null, paramString, null, localbq.isEnable(), localbq.dyH());
    AppMethodBeat.o(77807);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.z
 * JD-Core Version:    0.7.0.1
 */