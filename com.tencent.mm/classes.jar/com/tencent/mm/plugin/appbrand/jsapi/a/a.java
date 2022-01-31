package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends ClickableSpan
{
  private String gkd;
  private int gke = ae.getContext().getResources().getColor(y.d.green_text_color);
  
  public a(String paramString)
  {
    this.gkd = paramString;
  }
  
  public final void onClick(View paramView)
  {
    if (bk.bl(this.gkd))
    {
      y.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.gkd);
    localIntent.putExtra("forceHideShare", true);
    d.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    y.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", new Object[] { this.gkd });
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.gke);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a
 * JD-Core Version:    0.7.0.1
 */