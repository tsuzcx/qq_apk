package com.tencent.mm.plugin.account.bind.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindLinkedInUI$12
  extends ClickableSpan
{
  BindLinkedInUI$12(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView) {}
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(13399);
    paramTextPaint.setColor(this.gtf.getResources().getColor(2131690214));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(13399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.12
 * JD-Core Version:    0.7.0.1
 */