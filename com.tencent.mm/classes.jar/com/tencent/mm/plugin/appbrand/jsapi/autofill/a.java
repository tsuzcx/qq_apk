package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends ClickableSpan
{
  private String rHA;
  private int rHB;
  
  public a(String paramString)
  {
    AppMethodBeat.i(46107);
    this.rHB = MMApplicationContext.getContext().getResources().getColor(ba.c.Link);
    this.rHA = paramString;
    AppMethodBeat.o(46107);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46109);
    if (Util.isNullOrNil(this.rHA))
    {
      Log.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
      AppMethodBeat.o(46109);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.rHA);
    localIntent.putExtra("forceHideShare", true);
    c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    Log.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", new Object[] { this.rHA });
    AppMethodBeat.o(46109);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(46108);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.rHB);
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(46108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a
 * JD-Core Version:    0.7.0.1
 */