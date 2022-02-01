package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.ad;

@SuppressLint({"ViewConstructor"})
public final class an
  extends q
{
  private aa cdz;
  private String mUrl;
  
  public an(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
  }
  
  protected final View Cq()
  {
    AppMethodBeat.i(135241);
    if (this.cdz == null)
    {
      this.cdz = getContainer().bjq();
      this.cdz.lbd = this;
    }
    ViewGroup localViewGroup = this.cdz.jhz;
    AppMethodBeat.o(135241);
    return localViewGroup;
  }
  
  protected final void Cr()
  {
    AppMethodBeat.i(135244);
    super.Cr();
    this.cdz.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void Cs()
  {
    AppMethodBeat.i(135246);
    super.Cs();
    this.cdz.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void Ct()
  {
    AppMethodBeat.i(135247);
    super.Ct();
    this.cdz.onBackground();
    AppMethodBeat.o(135247);
  }
  
  public final void Lu(String paramString)
  {
    AppMethodBeat.i(194511);
    this.mUrl = paramString;
    this.cdz.ct(paramString);
    AppMethodBeat.o(194511);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!f(paramArrayOfInt, this.cdz.aOd()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.cdz.c(paramString1, paramString2, 0);
    AppMethodBeat.o(135248);
  }
  
  public final boolean cl(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = k.cA(this.mUrl).equals(k.cA(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.cdz.cleanup();
    AppMethodBeat.o(135245);
  }
  
  public final aa getCurrentPageView()
  {
    return this.cdz;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(135242);
    ad.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl");
    if (this.mUrl != null)
    {
      AppMethodBeat.o(135242);
      return;
    }
    this.mUrl = paramString;
    this.cdz.ct(paramString);
    AppMethodBeat.o(135242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.an
 * JD-Core Version:    0.7.0.1
 */