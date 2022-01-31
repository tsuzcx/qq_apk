package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$2$1
  implements f
{
  e$2$1(e.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((a)paramm).jLn == 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(bool) });
      g.DO().dJT.b(782, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.jLk.bS(Boolean.valueOf(bool));
      return;
    }
    this.jLk.bS(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.2.1
 * JD-Core Version:    0.7.0.1
 */