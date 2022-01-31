package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;

final class IPCallShareCouponCardUI$6
  extends ClickableSpan
{
  IPCallShareCouponCardUI$6(IPCallShareCouponCardUI paramIPCallShareCouponCardUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    ((TextView)paramView).setHighlightColor(this.lyq.getResources().getColor(R.e.transparent));
    com.tencent.mm.plugin.report.service.h.nFQ.f(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
    com.tencent.mm.ui.base.h.b(this.lyq.mController.uMN, this.lyv, this.lyq.getString(R.l.ipcall_share_coupon_promotion_title), true).a(R.l.ip_call_alter_tip_ok, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.lyq.getResources().getColor(R.e.link_color));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.6
 * JD-Core Version:    0.7.0.1
 */