package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class h$a
  implements q.a
{
  private h$a(h paramh) {}
  
  public final void tT(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ai.d(new h.a.1(this));
      y.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
      return;
    }
    ai.d(new h.a.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h.a
 * JD-Core Version:    0.7.0.1
 */