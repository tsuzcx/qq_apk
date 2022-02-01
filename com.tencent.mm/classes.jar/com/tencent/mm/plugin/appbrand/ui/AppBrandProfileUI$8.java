package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.sdk.platformtools.Util;

final class AppBrandProfileUI$8
  extends ClickableSpan
{
  AppBrandProfileUI$8(AppBrandProfileUI paramAppBrandProfileUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48713);
    if (!Util.isNullOrNil(this.qXE))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.qXE);
      c.b(this.qXA.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppBrandProfileUI.a(this.qXA, 22, 1);
    AppMethodBeat.o(48713);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(48714);
    paramTextPaint.setColor(this.qXA.getResources().getColor(au.c.link_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(48714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.8
 * JD-Core Version:    0.7.0.1
 */