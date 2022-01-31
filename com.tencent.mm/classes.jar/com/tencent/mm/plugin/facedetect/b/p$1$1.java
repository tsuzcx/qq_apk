package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class p$1$1
  implements f
{
  p$1$1(p.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
      p.aNX();
      this.jNb.jNa.Cl(p.NJ());
      this.jNb.jNa.dmL.onSceneEnd(paramInt1, paramInt2, "", this.jNb.jNa);
      return;
    }
    this.jNb.jNa.g(p.b(this.jNb.jNa));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p.1.1
 * JD-Core Version:    0.7.0.1
 */