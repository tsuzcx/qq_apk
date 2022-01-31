package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class az
  extends ak
  implements ay
{
  v bBK;
  private final ae ixt;
  private am izD;
  final bm izE;
  ay.a izF;
  final LinkedList<Runnable> izG;
  
  public final void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(140929);
    this.izE.a(bl.iAf, paramRunnable);
    AppMethodBeat.o(140929);
  }
  
  public final void a(ay.a parama)
  {
    AppMethodBeat.i(140931);
    this.bBK = parama.aJW();
    this.izF = parama;
    this.ixt.bBK = this.bBK;
    this.izG.clear();
    AppMethodBeat.o(140931);
  }
  
  public final void aJO()
  {
    AppMethodBeat.i(140926);
    this.izE.a(bl.iAa, null);
    AppMethodBeat.o(140926);
  }
  
  public final boolean aJP()
  {
    AppMethodBeat.i(140932);
    if (this.izE.aKb() == this.izE.iAi)
    {
      AppMethodBeat.o(140932);
      return true;
    }
    AppMethodBeat.o(140932);
    return false;
  }
  
  public final void aJZ()
  {
    AppMethodBeat.i(140927);
    this.ixt.iyw = this.izF.aJV();
    this.izE.a(bl.iAb, null);
    AppMethodBeat.o(140927);
  }
  
  public final boolean aJw()
  {
    return false;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(140936);
    super.addJavascriptInterface(paramObject, paramString);
    if ((paramObject instanceof am)) {
      this.izD = ((am)paramObject);
    }
    AppMethodBeat.o(140936);
  }
  
  public final void ap(Context paramContext)
  {
    AppMethodBeat.i(140935);
    super.ap(paramContext);
    am localam = this.izD;
    if (localam != null) {
      localam.setBaseContext(paramContext);
    }
    AppMethodBeat.o(140935);
  }
  
  public final void d(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140928);
    paramString = new az.1(this, paramString, paramValueCallback);
    this.izE.a(bl.iAf, paramString);
    AppMethodBeat.o(140928);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140937);
    super.destroy();
    this.izE.aKc();
    this.izG.clear();
    AppMethodBeat.o(140937);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140930);
    if (TextUtils.isEmpty(paramString))
    {
      paramValueCallback.onReceiveValue("FATAL");
      AppMethodBeat.o(140930);
      return;
    }
    d(paramString, paramValueCallback);
    AppMethodBeat.o(140930);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(140934);
    super.onBackground();
    this.izE.a(bl.iAe, null);
    AppMethodBeat.o(140934);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(140933);
    super.onForeground();
    this.izE.a(bl.iAd, null);
    AppMethodBeat.o(140933);
  }
  
  public final void setOnTrimListener(ah paramah)
  {
    AppMethodBeat.i(140925);
    paramah = new UnsupportedOperationException();
    AppMethodBeat.o(140925);
    throw paramah;
  }
  
  public final boolean ww()
  {
    AppMethodBeat.i(140938);
    if (this.izE.aKb() == this.izE.iAj)
    {
      aJZ();
      J(new az.2(this));
      AppMethodBeat.o(140938);
      return true;
    }
    AppMethodBeat.o(140938);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.az
 * JD-Core Version:    0.7.0.1
 */