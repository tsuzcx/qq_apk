package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.aj;

final class AppBrandProfileUI$6
  extends ClickableSpan
{
  AppBrandProfileUI$6(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48710);
    paramView = new f();
    paramView.username = "gh_32d0f14ab3c6@app";
    paramView.scene = 1085;
    ((o)g.ab(o.class)).a(aj.getContext(), paramView);
    AppBrandProfileUI.a(this.mDY, 24, 1);
    AppBrandProfileUI.bzy();
    AppMethodBeat.o(48710);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(48711);
    paramTextPaint.setColor(this.mDY.getResources().getColor(2131100547));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(48711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6
 * JD-Core Version:    0.7.0.1
 */