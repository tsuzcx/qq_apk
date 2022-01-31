package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class IPCallShareCouponCardUI$6
  extends ClickableSpan
{
  IPCallShareCouponCardUI$6(IPCallShareCouponCardUI paramIPCallShareCouponCardUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22287);
    ((TextView)paramView).setHighlightColor(this.nVC.getResources().getColor(2131690605));
    com.tencent.mm.plugin.report.service.h.qsU.e(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
    com.tencent.mm.ui.base.h.b(this.nVC.getContext(), this.nVH, this.nVC.getString(2131300960), true).a(2131300832, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(22287);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(22288);
    paramTextPaint.setColor(this.nVC.getResources().getColor(2131690214));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(22288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.6
 * JD-Core Version:    0.7.0.1
 */