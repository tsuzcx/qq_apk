package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
    paramView = b.a(this.kkL);
    y.i("MicroMsg.WalletFaceIdDialog", "click left btn");
    if (paramView.kkQ) {
      paramView.rj(-1);
    }
    for (;;)
    {
      this.kkL.dismiss();
      return;
      paramView.aSj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b.1
 * JD-Core Version:    0.7.0.1
 */