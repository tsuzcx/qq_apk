package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.WalletFaceIdDialog", "click right btn");
    paramView = b.a(this.kkL);
    y.i("MicroMsg.WalletFaceIdDialog", "click right btn");
    b localb = paramView.kkM;
    localb.kkG.setEnabled(false);
    localb.iKV.setText(a.i.faceid_auth_dialog_verify);
    paramView.aSv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b.2
 * JD-Core Version:    0.7.0.1
 */