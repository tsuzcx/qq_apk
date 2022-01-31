package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class q$1$1
  implements f
{
  q$1$1(q.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.ezN.ezM.dmL.onSceneEnd(paramInt1, paramInt2, "", this.ezN.ezM);
      return;
    }
    this.ezN.ezM.a(this.ezN.ezM.edc, this.ezN.ezM.dmL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q.1.1
 * JD-Core Version:    0.7.0.1
 */