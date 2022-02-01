package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class al
  extends u
{
  private ad cvo;
  private String mUrl;
  
  public al(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
  }
  
  protected final View PL()
  {
    AppMethodBeat.i(135241);
    if (this.cvo == null)
    {
      this.cvo = getContainer().cdJ();
      this.cvo.qsG = this;
    }
    View localView = this.cvo.getContentView();
    AppMethodBeat.o(135241);
    return localView;
  }
  
  protected final void PM()
  {
    AppMethodBeat.i(135244);
    super.PM();
    this.cvo.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void PN()
  {
    AppMethodBeat.i(135246);
    super.PN();
    this.cvo.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void PO()
  {
    AppMethodBeat.i(135247);
    super.PO();
    this.cvo.onBackground();
    AppMethodBeat.o(135247);
  }
  
  public final void a(String paramString, ca paramca)
  {
    AppMethodBeat.i(243556);
    Log.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", new Object[] { getAppId(), paramString });
    if (this.mUrl != null)
    {
      AppMethodBeat.o(243556);
      return;
    }
    this.mUrl = paramString;
    this.cvo.c(paramString, paramca);
    AppMethodBeat.o(243556);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!i(paramArrayOfInt, this.cvo.getComponentId()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.cvo.ct(paramString1, paramString2);
    AppMethodBeat.o(135248);
  }
  
  public final void alw(String paramString)
  {
    AppMethodBeat.i(243553);
    this.mUrl = paramString;
    this.cvo.c(paramString, ca.qwB);
    AppMethodBeat.o(243553);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.cvo.cleanup();
    AppMethodBeat.o(135245);
  }
  
  public final boolean dP(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = l.eo(this.mUrl).equals(l.eo(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public final ad getCurrentPageView()
  {
    return this.cvo;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final ad iL(int paramInt)
  {
    AppMethodBeat.i(243555);
    if (this.cvo.getComponentId() == paramInt)
    {
      ad localad = this.cvo;
      AppMethodBeat.o(243555);
      return localad;
    }
    AppMethodBeat.o(243555);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */