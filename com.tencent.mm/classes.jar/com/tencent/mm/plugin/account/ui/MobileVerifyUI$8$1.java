package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.at.b;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class MobileVerifyUI$8$1
  implements n.c
{
  MobileVerifyUI$8$1(MobileVerifyUI.8 param8) {}
  
  public final void a(l paraml)
  {
    paraml.e(0, this.fpX.fpS.getString(q.j.mobileverify_resend));
    if (b.mA(this.fpX.fpS.bSe)) {
      paraml.e(1, this.fpX.fpS.getString(q.j.bind_mcontact_voice_verify_entrance));
    }
    if ((MobileVerifyUI.f(this.fpX.fpS) == 2) && (this.fpX.fpS.fpO)) {
      paraml.e(2, this.fpX.fpS.getString(q.j.regbymobile_reg_qq_reg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8.1
 * JD-Core Version:    0.7.0.1
 */