package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;

final class l$9
  implements View.OnClickListener
{
  l$9(l paraml) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.fok.fnW, this.fok.fnW.getString(q.j.regbymobile_reg_verify_mobile_msg) + this.fok.account, this.fok.fnW.getString(q.j.regbymobile_reg_verify_mobile_title), this.fok.fnW.getString(q.j.app_ok), this.fok.fnW.getString(q.j.app_cancel), false, new l.9.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        l.9.this.fok.fnW.foq.reset();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.9
 * JD-Core Version:    0.7.0.1
 */