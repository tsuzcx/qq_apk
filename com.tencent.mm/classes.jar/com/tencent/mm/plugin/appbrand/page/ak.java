package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class ak
  extends t
{
  private ac cwK;
  private String mUrl;
  
  public ak(Context paramContext, w paramw)
  {
    super(paramContext, paramw);
  }
  
  protected final View MT()
  {
    AppMethodBeat.i(135241);
    if (this.cwK == null)
    {
      this.cwK = getContainer().bQT();
      this.cwK.nqU = this;
    }
    View localView = this.cwK.getContentView();
    AppMethodBeat.o(135241);
    return localView;
  }
  
  protected final void MU()
  {
    AppMethodBeat.i(135244);
    super.MU();
    this.cwK.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void MV()
  {
    AppMethodBeat.i(135246);
    super.MV();
    this.cwK.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void MW()
  {
    AppMethodBeat.i(135247);
    super.MW();
    this.cwK.onBackground();
    AppMethodBeat.o(135247);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!i(paramArrayOfInt, this.cwK.getComponentId()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.cwK.c(paramString1, paramString2, 0);
    AppMethodBeat.o(135248);
  }
  
  public final void adB(String paramString)
  {
    AppMethodBeat.i(219450);
    this.mUrl = paramString;
    this.cwK.dE(paramString);
    AppMethodBeat.o(219450);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.cwK.cleanup();
    AppMethodBeat.o(135245);
  }
  
  public final boolean dw(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = l.dM(this.mUrl).equals(l.dM(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public final ac getCurrentPageView()
  {
    return this.cwK;
  }
  
  public final String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  public final ac hL(int paramInt)
  {
    AppMethodBeat.i(219451);
    if (this.cwK.getComponentId() == paramInt)
    {
      ac localac = this.cwK;
      AppMethodBeat.o(219451);
      return localac;
    }
    AppMethodBeat.o(219451);
    return null;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(135242);
    Log.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", new Object[] { getAppId(), paramString });
    if (this.mUrl != null)
    {
      AppMethodBeat.o(135242);
      return;
    }
    this.mUrl = paramString;
    this.cwK.dE(paramString);
    AppMethodBeat.o(135242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak
 * JD-Core Version:    0.7.0.1
 */