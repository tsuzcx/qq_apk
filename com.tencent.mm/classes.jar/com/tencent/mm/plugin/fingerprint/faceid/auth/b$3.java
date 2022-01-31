package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements FrameAnimatorImageView.a
{
  b$3(b paramb) {}
  
  public final void onStop()
  {
    y.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
    b.b(this.kkL).a(a.e.faceid_verify_breath, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b.3
 * JD-Core Version:    0.7.0.1
 */