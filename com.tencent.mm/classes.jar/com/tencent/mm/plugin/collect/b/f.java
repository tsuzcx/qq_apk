package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements com.tencent.mm.ah.f
{
  public static f iGP;
  private final String TAG = "MicroMsg.F2fGetPayUrlManager";
  public Map<l, f.a> hLB = new HashMap();
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    f.a locala;
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      locala = (f.a)this.hLB.get(paramm);
      if (locala == null) {
        y.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
      }
    }
    else
    {
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      locala.a(true, paramString.iHp);
    }
    for (;;)
    {
      this.hLB.remove(paramm);
      return;
      y.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[] { paramString });
      locala.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.f
 * JD-Core Version:    0.7.0.1
 */