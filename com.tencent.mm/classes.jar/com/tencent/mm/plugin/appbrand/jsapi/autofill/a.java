package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends ClickableSpan
{
  private String kfA;
  private int kfB;
  
  public a(String paramString)
  {
    AppMethodBeat.i(46107);
    this.kfB = ai.getContext().getResources().getColor(2131099769);
    this.kfA = paramString;
    AppMethodBeat.o(46107);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46109);
    if (bs.isNullOrNil(this.kfA))
    {
      ac.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
      AppMethodBeat.o(46109);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.kfA);
    localIntent.putExtra("forceHideShare", true);
    d.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    ac.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", new Object[] { this.kfA });
    AppMethodBeat.o(46109);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(46108);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.kfB);
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(46108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a
 * JD-Core Version:    0.7.0.1
 */