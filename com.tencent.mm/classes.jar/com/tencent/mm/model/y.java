package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;

public final class y
{
  public static x T(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return null;
    }
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic(paramString1);
    if (localbq != null) {
      if (localbq.uCK != 1) {
        break label56;
      }
    }
    label56:
    for (int i = 1; i == 0; i = 0) {
      return null;
    }
    String str2 = localbq.name;
    String str1 = localbq.uCJ.aco("");
    paramString1 = "";
    if (str1 != null) {
      paramString1 = "" + str1.replace("@", "");
    }
    str1 = paramString1;
    if (paramString2 != null) {
      str1 = paramString1 + paramString2;
    }
    return new x("@domain.android", str2, str1, localbq.uCJ.aco(""), localbq.isEnable(), true);
  }
  
  public static x il(String paramString)
  {
    return new x("@black.android", null, paramString, null, true, true);
  }
  
  public static x im(String paramString)
  {
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
    if (localbq == null) {
      return null;
    }
    return new x("@t.qq.com", null, paramString, null, localbq.isEnable(), localbq.cvY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */