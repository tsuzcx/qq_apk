package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class AppBrandProfileUI$7
  extends ClickableSpan
{
  AppBrandProfileUI$7(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48712);
    paramView = new g();
    paramView.username = "gh_32d0f14ab3c6@app";
    paramView.scene = 1085;
    ((t)h.ax(t.class)).a(MMApplicationContext.getContext(), paramView);
    AppBrandProfileUI.a(this.udA, 24, 1);
    AppBrandProfileUI.cLo();
    AppMethodBeat.o(48712);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(322439);
    paramTextPaint.setColor(this.udA.getResources().getColor(ba.c.link_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(322439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.7
 * JD-Core Version:    0.7.0.1
 */