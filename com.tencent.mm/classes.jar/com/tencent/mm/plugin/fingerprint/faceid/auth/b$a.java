package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.g.f;

final class b$a
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener
{
  private Bundle ezQ;
  b kkM;
  private k kkN;
  private a kkO;
  private int kkP;
  boolean kkQ = false;
  private c kkR = new b.a.1(this);
  private int retryCount = 0;
  private int scene;
  
  public b$a(b paramb, a parama, Bundle paramBundle)
  {
    this.kkM = paramb;
    this.kkO = parama;
    this.ezQ = paramBundle;
    if (this.ezQ != null) {
      this.scene = this.ezQ.getInt("face_auth_scene");
    }
  }
  
  private void aSu()
  {
    this.kkN.aSC();
  }
  
  final void aSj()
  {
    y.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
    if (this.kkO != null)
    {
      this.kkO.aSj();
      this.kkO = null;
    }
  }
  
  final void aSv()
  {
    y.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
    if (this.kkN == null)
    {
      y.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
      return;
    }
    this.kkN.aSM();
    this.kkN.aSL();
    if (!this.kkN.aST())
    {
      y.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
      rj(-2);
      return;
    }
    if (bk.bl(s.qyz.klM))
    {
      y.i("MicroMsg.WalletFaceIdDialog", "no challenge");
      rj(-3);
      return;
    }
    this.kkN.a(this.kkR);
    b localb = this.kkM;
    y.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
    localb.kkF.a(a.e.faceid_verify_trigger, new b.3(localb));
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
    aSj();
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
    aSu();
    if (this.scene == 1) {
      aSj();
    }
  }
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
    this.kkN = ((k)g.r(k.class));
    f.cPH().cPI();
    aSv();
  }
  
  final void rj(int paramInt)
  {
    y.i("MicroMsg.WalletFaceIdDialog", "auth fail");
    if (this.kkO != null)
    {
      this.kkO.rj(paramInt);
      this.kkO = null;
    }
    this.kkM.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.b.a
 * JD-Core Version:    0.7.0.1
 */