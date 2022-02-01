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
public final class ai
  extends r
{
  private aa ckN;
  private String mUrl;
  
  public ai(Context paramContext, u paramu)
  {
    super(paramContext, paramu);
  }
  
  protected final View Dt()
  {
    AppMethodBeat.i(135241);
    if (this.ckN == null)
    {
      this.ckN = getContainer().bui();
      this.ckN.mcd = this;
    }
    ViewGroup localViewGroup = this.ckN.kca;
    AppMethodBeat.o(135241);
    return localViewGroup;
  }
  
  protected final void Du()
  {
    AppMethodBeat.i(135244);
    super.Du();
    this.ckN.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void Dv()
  {
    AppMethodBeat.i(135246);
    super.Dv();
    this.ckN.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void Dw()
  {
    AppMethodBeat.i(135247);
    super.Dw();
    this.ckN.onBackground();
    AppMethodBeat.o(135247);
  }
  
  public final void Tf(String paramString)
  {
    AppMethodBeat.i(197340);
    this.mUrl = paramString;
    this.ckN.dk(paramString);
    AppMethodBeat.o(197340);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!i(paramArrayOfInt, this.ckN.aXC()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.ckN.c(paramString1, paramString2, 0);
    AppMethodBeat.o(135248);
  }
  
  public final boolean cV(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = k.dr(this.mUrl).equals(k.dr(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.ckN.cleanup();
    AppMethodBeat.o(135245);
  }
  
  public final aa getCurrentPageView()
  {
    return this.ckN;
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
    this.ckN.dk(paramString);
    AppMethodBeat.o(135242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */