package com.tencent.mm.modelfriend;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class a$1$1
  implements f
{
  a$1$1(a.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.ekW.ekV.dmL.onSceneEnd(paramInt1, paramInt2, "", this.ekW.ekV);
      return;
    }
    this.ekW.ekV.a(this.ekW.ekV.edc, this.ekW.ekV.dmL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a.1.1
 * JD-Core Version:    0.7.0.1
 */