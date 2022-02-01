package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import org.apache.commons.c.i;

public class al
  extends u
{
  protected ad enm;
  private String mUrl;
  private final AtomicBoolean tyy;
  
  public al(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
    AppMethodBeat.i(325221);
    this.tyy = new AtomicBoolean(false);
    AppMethodBeat.o(325221);
  }
  
  public final ad L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(325252);
    ad localad;
    if ((paramBoolean) && (this.enm.cEI()))
    {
      if (this.enm.CE(paramInt))
      {
        localad = this.enm;
        AppMethodBeat.o(325252);
        return localad;
      }
      AppMethodBeat.o(325252);
      return null;
    }
    if (this.enm.getComponentId() == paramInt)
    {
      localad = this.enm;
      AppMethodBeat.o(325252);
      return localad;
    }
    AppMethodBeat.o(325252);
    return null;
  }
  
  protected final void a(String paramString, ad paramad)
  {
    AppMethodBeat.i(325274);
    this.mUrl = paramString;
    this.tyy.set(true);
    AppMethodBeat.o(325274);
  }
  
  public void a(String paramString, cb paramcb)
  {
    AppMethodBeat.i(325265);
    if ((TextUtils.isEmpty(this.mUrl)) || (i.qA(this.mUrl, paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", new Object[] { getAppId(), paramString });
      this.mUrl = paramString;
      if (!this.tyy.getAndSet(true)) {
        this.enm.c(paramString, paramcb);
      }
      AppMethodBeat.o(325265);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135248);
    if (!v(paramArrayOfInt, this.enm.getComponentId()))
    {
      AppMethodBeat.o(135248);
      return;
    }
    this.enm.cJ(paramString1, paramString2);
    AppMethodBeat.o(135248);
  }
  
  public final void aeA(String paramString)
  {
    AppMethodBeat.i(325240);
    this.mUrl = paramString;
    this.tyy.set(true);
    this.enm.c(paramString, cb.tBq);
    AppMethodBeat.o(325240);
  }
  
  protected final void apV()
  {
    AppMethodBeat.i(135244);
    super.apV();
    this.enm.onDestroy();
    AppMethodBeat.o(135244);
  }
  
  public final void apW()
  {
    AppMethodBeat.i(135246);
    super.apW();
    this.enm.onForeground();
    AppMethodBeat.o(135246);
  }
  
  public final void apX()
  {
    AppMethodBeat.i(135247);
    super.apX();
    this.enm.onBackground();
    AppMethodBeat.o(135247);
  }
  
  protected final void cEb()
  {
    AppMethodBeat.i(325354);
    this.enm.cEb();
    AppMethodBeat.o(325354);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135245);
    super.cleanup();
    this.enm.cleanup();
    AppMethodBeat.o(135245);
  }
  
  protected View createContentView()
  {
    AppMethodBeat.i(135241);
    if (this.enm == null)
    {
      this.enm = getContainer().aeI(m.fL(this.mUrl));
      this.enm.t(this);
    }
    View localView = this.enm.getContentView();
    AppMethodBeat.o(135241);
    return localView;
  }
  
  public final boolean fa(String paramString)
  {
    AppMethodBeat.i(135243);
    boolean bool = m.fL(this.mUrl).equals(m.fL(paramString));
    AppMethodBeat.o(135243);
    return bool;
  }
  
  public ad getCurrentPageView()
  {
    return this.enm;
  }
  
  public String getCurrentUrl()
  {
    return this.mUrl;
  }
  
  protected void setInitialUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */