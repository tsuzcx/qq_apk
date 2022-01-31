package com.tencent.mm.plugin.appbrand.game.d;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.game.d.f;
import com.tencent.luggage.game.d.f.a;
import com.tencent.luggage.game.d.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

public final class a
  implements f
{
  private WebView hsS;
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(143140);
    this.hsS.setWebViewClient(new a.2(this, paramb));
    AppMethodBeat.o(143140);
  }
  
  public final void ao(Context paramContext)
  {
    AppMethodBeat.i(143138);
    this.hsS = new WebView(paramContext);
    AppMethodBeat.o(143138);
  }
  
  public final void by(String paramString)
  {
    AppMethodBeat.i(143145);
    this.hsS.evaluateJavascript(paramString, null);
    AppMethodBeat.o(143145);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(143146);
    this.hsS.destroy();
    AppMethodBeat.o(143146);
  }
  
  public final View getView()
  {
    return this.hsS;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(143141);
    this.hsS.loadUrl(paramString);
    AppMethodBeat.o(143141);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(143144);
    this.hsS.requestLayout();
    AppMethodBeat.o(143144);
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(143142);
    this.hsS.setTranslationY(paramFloat);
    AppMethodBeat.o(143142);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(143143);
    this.hsS.setVisibility(paramInt);
    AppMethodBeat.o(143143);
  }
  
  public final f.a uH()
  {
    AppMethodBeat.i(143139);
    a.1 local1 = new a.1(this, this.hsS.getSettings());
    AppMethodBeat.o(143139);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a
 * JD-Core Version:    0.7.0.1
 */