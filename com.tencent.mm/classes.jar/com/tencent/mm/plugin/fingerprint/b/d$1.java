package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a;

final class d$1
  implements com.tencent.mm.plugin.soter.d.g
{
  d$1(d paramd) {}
  
  public final void ai(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (a.cPw()))
    {
      y.i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is now switched to SoterAuthMgrImp");
      paramString = new l();
      paramString.aSH();
      com.tencent.mm.kernel.g.a(k.class, paramString);
      return;
    }
    y.i("MicroMsg.FingerPrintMgrImpl", "After recheck IFingerPrintMgr is still FingerPrintMgrImpl errCode[" + paramInt + "], errMsg[" + paramString + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d.1
 * JD-Core Version:    0.7.0.1
 */