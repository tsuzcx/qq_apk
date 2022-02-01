package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.ac;

@SuppressLint({"ViewConstructor"})
public final class ai
  extends r
{
  private aa caw;
  private String mUrl;
  
  public ai(Context paramContext, u paramu)
  {
    super(paramContext, paramu);
  }
  
  protected final View BU()
  {
    AppMethodBeat.i(135241);
    if (this.caw == null)
    {
      this.caw = getContainer().bqi();
      this.caw.lCC = this;
    }
    ViewGroup localViewGroup = this.caw.jHO;
    AppMethodBeat.o(135241);
    return localViewGroup;
  }
  
  protected final void BV()
  {
    AppMethodBeat.i(135244);
    super.BV();
    this.caw.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void BW()
  {
    AppMethodBeat.i(135246);
    super.BW();
    this.caw.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void BX()
  {
    AppMethodBeat.i(135247);
    super.BX();
    this.caw.onBackground();
    AppMethodBeat.o(135247);
  }
  
  public final void PC(String paramString)
  {
    AppMethodBeat.i(193423);
    this.mUrl = paramString;
    this.caw.ci(paramString);
    AppMethodBeat.o(193423);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!i(paramArrayOfInt, this.caw.aUT()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.caw.c(paramString1, paramString2, 0);
    AppMethodBeat.o(135248);
  }
  
  public final boolean cb(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = k.cp(this.mUrl).equals(k.cp(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.caw.cleanup();
    AppMethodBeat.o(135245);
  }
  
  public final aa getCurrentPageView()
  {
    return this.caw;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(135242);
    ac.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl");
    if (this.mUrl != null)
    {
      AppMethodBeat.o(135242);
      return;
    }
    this.mUrl = paramString;
    this.caw.ci(paramString);
    AppMethodBeat.o(135242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */