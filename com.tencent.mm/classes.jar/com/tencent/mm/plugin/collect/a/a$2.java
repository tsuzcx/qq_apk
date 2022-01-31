package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements f
{
  a$2(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    g.DO().dJT.b(304, this);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.i("MicroMsg.SubCoreCollect", "set sound fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a.2
 * JD-Core Version:    0.7.0.1
 */