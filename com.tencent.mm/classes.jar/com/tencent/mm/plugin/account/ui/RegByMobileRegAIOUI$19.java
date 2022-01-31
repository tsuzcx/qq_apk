package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class RegByMobileRegAIOUI$19
  extends ClickableSpan
{
  RegByMobileRegAIOUI$19(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    bk.I(this.fqF.mController.uMN, this.fqF.getString(q.j.license_read_url, new Object[] { x.cqJ(), x.cqI(), "setting", Integer.valueOf(0), Integer.valueOf(0) }));
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.fqF.getResources().getColor(q.c.link_color));
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.19
 * JD-Core Version:    0.7.0.1
 */