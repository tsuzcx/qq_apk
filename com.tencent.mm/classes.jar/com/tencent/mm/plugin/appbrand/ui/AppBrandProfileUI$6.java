package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;

final class AppBrandProfileUI$6
  extends ClickableSpan
{
  AppBrandProfileUI$6(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48710);
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://jiazhang.qq.com/wap/guard/dist/main/index.html#/Index?source=mini_game");
    d.b(this.lBL.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppBrandProfileUI.a(this.lBL, 24, 1);
    AppBrandProfileUI.bov();
    AppMethodBeat.o(48710);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(48711);
    paramTextPaint.setColor(this.lBL.getResources().getColor(2131100547));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(48711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6
 * JD-Core Version:    0.7.0.1
 */