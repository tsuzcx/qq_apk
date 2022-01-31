package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class k$3
  extends ClickableSpan
{
  k$3(k paramk, MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    bk.I(this.fod.mController.uMN, this.fod.getString(q.j.url_agreement));
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.fod.getResources().getColor(q.c.link_color));
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k.3
 * JD-Core Version:    0.7.0.1
 */