package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class RegByMobileRegAIOUI$18
  extends ClickableSpan
{
  RegByMobileRegAIOUI$18(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    bk.I(this.fqF.mController.uMN, this.fqF.getString(q.j.url_agreement));
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.fqF.getResources().getColor(q.c.link_color));
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.18
 * JD-Core Version:    0.7.0.1
 */