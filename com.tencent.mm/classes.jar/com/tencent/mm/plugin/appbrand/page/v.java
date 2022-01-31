package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;

public final class v
  extends k
{
  private q gSP;
  private String mUrl;
  
  public v(Context paramContext, n paramn)
  {
    super(paramContext, paramn);
  }
  
  protected final View agF()
  {
    if (this.gSP == null) {
      this.gSP = getContainer().getPageViewPrivate();
    }
    return this.gSP.getContentView();
  }
  
  protected final void agG()
  {
    super.agG();
    this.gSP.onDestroy();
  }
  
  public final void agH()
  {
    super.agH();
    this.gSP.pY();
  }
  
  public final void agI()
  {
    super.agI();
    this.gSP.qa();
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (!e(paramArrayOfInt, this.gSP.hashCode())) {
      return;
    }
    this.gSP.i(paramString1, paramString2, 0);
  }
  
  public final void cleanup()
  {
    super.cleanup();
    this.gSP.cleanup();
  }
  
  public final q getCurrentPageView()
  {
    return this.gSP;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final void loadUrl(String paramString)
  {
    if (this.mUrl != null) {
      return;
    }
    this.mUrl = paramString;
    this.gSP.tB(paramString);
    agK();
  }
  
  public final boolean tz(String paramString)
  {
    return g.bi(this.mUrl).equals(g.bi(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */