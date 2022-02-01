package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.ae;

@SuppressLint({"ViewConstructor"})
public final class ah
  extends q
{
  private z ckP;
  private String mUrl;
  
  public ah(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
  }
  
  protected final View Dw()
  {
    AppMethodBeat.i(135241);
    if (this.ckP == null)
    {
      this.ckP = getContainer().buT();
      this.ckP.mgv = this;
    }
    ViewGroup localViewGroup = this.ckP.kfr;
    AppMethodBeat.o(135241);
    return localViewGroup;
  }
  
  protected final void Dx()
  {
    AppMethodBeat.i(135244);
    super.Dx();
    this.ckP.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void Dy()
  {
    AppMethodBeat.i(135246);
    super.Dy();
    this.ckP.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void Dz()
  {
    AppMethodBeat.i(135247);
    super.Dz();
    this.ckP.onBackground();
    AppMethodBeat.o(135247);
  }
  
  public final void TO(String paramString)
  {
    AppMethodBeat.i(207855);
    this.mUrl = paramString;
    this.ckP.dm(paramString);
    AppMethodBeat.o(207855);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!i(paramArrayOfInt, this.ckP.aXX()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.ckP.c(paramString1, paramString2, 0);
    AppMethodBeat.o(135248);
  }
  
  public final boolean cX(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = k.dt(this.mUrl).equals(k.dt(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.ckP.cleanup();
    AppMethodBeat.o(135245);
  }
  
  public final z getCurrentPageView()
  {
    return this.ckP;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(135242);
    ae.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl");
    if (this.mUrl != null)
    {
      AppMethodBeat.o(135242);
      return;
    }
    this.mUrl = paramString;
    this.ckP.dm(paramString);
    AppMethodBeat.o(135242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */