package com.tencent.mm.plugin.i;

import com.tencent.mm.ak.f;
import com.tencent.mm.model.p;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
  extends p
  implements com.tencent.mm.plugin.auth.a.a
{
  private static a iAl;
  
  private a()
  {
    super(f.class);
  }
  
  public static a aDq()
  {
    try
    {
      if (iAl == null) {
        iAl = new a();
      }
      a locala = iAl;
      return locala;
    }
    finally {}
  }
  
  public final void a(i.f paramf, i.g paramg, boolean paramBoolean) {}
  
  public final void a(u.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramb.sqm.jwX != 0) {
      ai.d(new a.1(paramb.sqm.sCd, paramb.sqm.sCe, paramb.sqm.sCf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a
 * JD-Core Version:    0.7.0.1
 */