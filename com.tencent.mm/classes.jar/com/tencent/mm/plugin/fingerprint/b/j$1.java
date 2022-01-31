package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.y;

final class j$1
  implements a
{
  j$1(j paramj) {}
  
  public final void ai(int paramInt, String paramString)
  {
    y.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      this.klu.gk(false);
      return;
    }
    this.klu.U(1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.j.1
 * JD-Core Version:    0.7.0.1
 */