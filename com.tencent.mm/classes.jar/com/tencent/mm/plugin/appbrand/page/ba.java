package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends ak
  implements ay
{
  private v bBK;
  private boolean gRF;
  private final ae ixt;
  private String iyw;
  private ay.a izF;
  private final LinkedList<Runnable> izG;
  private boolean izJ;
  private boolean izK;
  private boolean izL;
  private boolean izM;
  
  ba(ap paramap)
  {
    super(paramap);
    AppMethodBeat.i(140947);
    this.izJ = false;
    this.izK = false;
    this.izG = new LinkedList();
    this.izL = false;
    this.gRF = false;
    this.izM = false;
    this.iyw = null;
    this.ixt = new ba.1(this);
    ((aq)paramap).setAppBrandWebViewClient(this.ixt);
    aKa();
    AppMethodBeat.o(140947);
  }
  
  private void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(140949);
    if (this.izJ)
    {
      paramRunnable.run();
      AppMethodBeat.o(140949);
      return;
    }
    this.izG.addLast(paramRunnable);
    AppMethodBeat.o(140949);
  }
  
  private void aKa()
  {
    AppMethodBeat.i(154471);
    this.iuy.setOnTrimListener(new ba.2(this));
    AppMethodBeat.o(154471);
  }
  
  public final void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(140952);
    if (this.izJ)
    {
      paramRunnable.run();
      AppMethodBeat.o(140952);
      return;
    }
    this.izG.addLast(paramRunnable);
    AppMethodBeat.o(140952);
  }
  
  public final void a(ay.a parama)
  {
    AppMethodBeat.i(140953);
    this.bBK = parama.aJW();
    this.izF = parama;
    this.ixt.bBK = this.bBK;
    this.izG.clear();
    AppMethodBeat.o(140953);
  }
  
  public final void aJO()
  {
    AppMethodBeat.i(140954);
    d.i("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchPreload");
    if (!this.izK)
    {
      this.izF.eH(true);
      this.izK = true;
      this.izL = true;
    }
    K(new ba.5(this));
    AppMethodBeat.o(140954);
  }
  
  public final boolean aJP()
  {
    return this.izL;
  }
  
  public final void aJZ()
  {
    AppMethodBeat.i(140955);
    this.izM = false;
    this.izL = false;
    ae localae = this.ixt;
    String str = this.izF.aJV();
    this.iyw = str;
    localae.iyw = str;
    aKa();
    d.i("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchInit %s, mPageFrameReady %b, mPageFrameLoaded %b", new Object[] { this.iyw, Boolean.valueOf(this.izJ), Boolean.valueOf(this.izK) });
    if (!this.izK)
    {
      this.izF.eH(false);
      this.izK = true;
    }
    K(new ba.6(this));
    AppMethodBeat.o(140955);
  }
  
  public final boolean aJw()
  {
    return this.gRF;
  }
  
  public final void d(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140951);
    if (this.izJ)
    {
      this.iuy.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(140951);
      return;
    }
    this.izG.addLast(new ba.4(this, paramString, paramValueCallback));
    AppMethodBeat.o(140951);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140958);
    super.destroy();
    this.izG.clear();
    AppMethodBeat.o(140958);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(140950);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      AppMethodBeat.o(140950);
      return;
    }
    this.bBK.runOnUiThread(new ba.3(this, paramString, paramValueCallback));
    AppMethodBeat.o(140950);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(140957);
    super.onBackground();
    AppMethodBeat.o(140957);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(140956);
    super.onForeground();
    ww();
    AppMethodBeat.o(140956);
  }
  
  public final void setOnTrimListener(ah paramah)
  {
    AppMethodBeat.i(140948);
    paramah = new UnsupportedOperationException();
    AppMethodBeat.o(140948);
    throw paramah;
  }
  
  public final boolean ww()
  {
    AppMethodBeat.i(140959);
    if (!this.izM)
    {
      AppMethodBeat.o(140959);
      return false;
    }
    this.izK = false;
    this.izJ = false;
    aJZ();
    K(new ba.7(this));
    AppMethodBeat.o(140959);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ba
 * JD-Core Version:    0.7.0.1
 */