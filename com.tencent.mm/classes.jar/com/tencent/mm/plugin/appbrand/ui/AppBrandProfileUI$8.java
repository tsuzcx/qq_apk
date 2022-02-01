package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.sdk.platformtools.Util;

final class AppBrandProfileUI$8
  extends ClickableSpan
{
  AppBrandProfileUI$8(AppBrandProfileUI paramAppBrandProfileUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48713);
    if (!Util.isNullOrNil(this.udE))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.udE);
      c.b(this.udA.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppBrandProfileUI.a(this.udA, 22, 1);
    AppMethodBeat.o(48713);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(48714);
    paramTextPaint.setColor(this.udA.getResources().getColor(ba.c.link_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(48714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.8
 * JD-Core Version:    0.7.0.1
 */