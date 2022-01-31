package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$1$1
  implements q
{
  e$1$1(e.1 param1) {}
  
  public final void O(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ExtQrCodeHandler", "hy: result: %s, code type: %d, code version: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved result!");
      this.jLj.bS(null);
      return;
    }
    this.jLj.bS(new e.a(paramInt1, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.1.1
 * JD-Core Version:    0.7.0.1
 */