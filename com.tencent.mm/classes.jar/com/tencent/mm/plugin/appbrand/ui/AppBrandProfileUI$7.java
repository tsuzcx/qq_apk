package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.bt;

final class AppBrandProfileUI$7
  extends ClickableSpan
{
  AppBrandProfileUI$7(AppBrandProfileUI paramAppBrandProfileUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48712);
    if (!bt.isNullOrNil(this.mEd))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.mEd);
      d.b(this.mDY.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppBrandProfileUI.a(this.mDY, 22, 1);
    AppMethodBeat.o(48712);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(188876);
    paramTextPaint.setColor(this.mDY.getResources().getColor(2131100547));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(188876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.7
 * JD-Core Version:    0.7.0.1
 */