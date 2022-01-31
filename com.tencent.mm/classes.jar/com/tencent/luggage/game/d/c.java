package com.tencent.luggage.game.d;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements f
{
  private WebView bAt;
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(140385);
    this.bAt.setWebViewClient(new c.2(this, paramb));
    AppMethodBeat.o(140385);
  }
  
  public final void ao(Context paramContext)
  {
    AppMethodBeat.i(140383);
    this.bAt = new WebView(paramContext);
    AppMethodBeat.o(140383);
  }
  
  public final void by(String paramString)
  {
    AppMethodBeat.i(140390);
    this.bAt.evaluateJavascript(paramString, null);
    AppMethodBeat.o(140390);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140391);
    this.bAt.destroy();
    AppMethodBeat.o(140391);
  }
  
  public final View getView()
  {
    return this.bAt;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140386);
    this.bAt.loadUrl(paramString);
    AppMethodBeat.o(140386);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(140389);
    this.bAt.requestLayout();
    AppMethodBeat.o(140389);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(140387);
    this.bAt.setTranslationY(paramFloat);
    AppMethodBeat.o(140387);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(140388);
    this.bAt.setVisibility(paramInt);
    AppMethodBeat.o(140388);
  }
  
  public final f.a uH()
  {
    AppMethodBeat.i(140384);
    c.1 local1 = new c.1(this, this.bAt.getSettings());
    AppMethodBeat.o(140384);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.c
 * JD-Core Version:    0.7.0.1
 */