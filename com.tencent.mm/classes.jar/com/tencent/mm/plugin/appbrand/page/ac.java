package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;

@SuppressLint({"ViewConstructor"})
public final class ac
  extends o
{
  private v bBK;
  private String mUrl;
  
  public ac(Context paramContext, r paramr)
  {
    super(paramContext, paramr);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87311);
    if (!f(paramArrayOfInt, this.bBK.hashCode()))
    {
      AppMethodBeat.o(87311);
      return;
    }
    this.bBK.c(paramString1, paramString2, 0);
    AppMethodBeat.o(87311);
  }
  
  public final boolean bV(String paramString)
  {
    AppMethodBeat.i(87306);
    boolean bool = h.cg(this.mUrl).equals(h.cg(paramString));
    AppMethodBeat.o(87306);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(87308);
    super.cleanup();
    this.bBK.cleanup();
    AppMethodBeat.o(87308);
  }
  
  public final v getCurrentPageView()
  {
    return this.bBK;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(87305);
    if (this.mUrl != null)
    {
      AppMethodBeat.o(87305);
      return;
    }
    this.mUrl = paramString;
    this.bBK.Em(paramString);
    AppMethodBeat.o(87305);
  }
  
  protected final View vs()
  {
    AppMethodBeat.i(87304);
    if (this.bBK == null)
    {
      this.bBK = getContainer().aJb();
      this.bBK.ixs = this;
    }
    ViewGroup localViewGroup = this.bBK.hmw;
    AppMethodBeat.o(87304);
    return localViewGroup;
  }
  
  protected final void vt()
  {
    AppMethodBeat.i(87307);
    super.vt();
    this.bBK.onDestroy();
    AppMethodBeat.o(87307);
  }
  
  public final void vu()
  {
    AppMethodBeat.i(87309);
    super.vu();
    this.bBK.onForeground();
    AppMethodBeat.o(87309);
  }
  
  public final void vv()
  {
    AppMethodBeat.i(87310);
    super.vv();
    this.bBK.onBackground();
    AppMethodBeat.o(87310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */