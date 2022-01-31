package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.d.a;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"})
public class au
  implements com.tencent.mm.plugin.appbrand.page.b.d
{
  private final String TAG;
  private final v bBK;
  private final ab iuC;
  
  public au(v paramv, ab paramab)
  {
    AppMethodBeat.i(141027);
    this.bBK = paramv;
    this.iuC = paramab;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(141027);
  }
  
  public final void Eq(String paramString)
  {
    AppMethodBeat.i(141024);
    j.q(paramString, "style");
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.setBackgroundTextStyle(paramString);
      AppMethodBeat.o(141024);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.f(this, paramString));
      AppMethodBeat.o(141024);
      return;
    }
    AppMethodBeat.o(141024);
  }
  
  public void a(d.a parama, int paramInt)
  {
    AppMethodBeat.i(141022);
    j.q(parama, "style");
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.bp(parama.aKf(), paramInt);
      AppMethodBeat.o(141022);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.d(this, parama, paramInt));
      AppMethodBeat.o(141022);
      return;
    }
    AppMethodBeat.o(141022);
  }
  
  public final void aJs()
  {
    AppMethodBeat.i(141018);
    com.tencent.luggage.g.d.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.bBK.getAppId() + " url:" + this.bBK.getURL());
    v localv = this.bBK;
    if (al.isMainThread())
    {
      com.tencent.luggage.g.d.i(this.TAG, "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + this.bBK.getAppId() + " url:" + this.bBK.getURL());
      try
      {
        this.iuC.eE(true);
        this.iuC.aJC();
        AppMethodBeat.o(141018);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.tencent.luggage.g.d.e(this.TAG, "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + this.bBK.getAppId() + " url:" + this.bBK.getURL() + " e:" + localNullPointerException);
        localObject = (Throwable)localNullPointerException;
        AppMethodBeat.o(141018);
        throw ((Throwable)localObject);
      }
    }
    Object localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.h(this));
      AppMethodBeat.o(141018);
      return;
    }
    AppMethodBeat.o(141018);
  }
  
  public final void aJt()
  {
    AppMethodBeat.i(141019);
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.aJG();
      AppMethodBeat.o(141019);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.i(this));
      AppMethodBeat.o(141019);
      return;
    }
    AppMethodBeat.o(141019);
  }
  
  public void cO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141023);
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.bp(paramString1, g.bA(paramString2, -1));
      AppMethodBeat.o(141023);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.e(this, paramString1, paramString2));
      AppMethodBeat.o(141023);
      return;
    }
    AppMethodBeat.o(141023);
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(141020);
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.setPullDownEnabled(paramBoolean);
      this.iuC.eE(paramBoolean);
      AppMethodBeat.o(141020);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.b(this, paramBoolean));
      AppMethodBeat.o(141020);
      return;
    }
    AppMethodBeat.o(141020);
  }
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(141021);
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(141021);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.a(this, paramBoolean));
      AppMethodBeat.o(141021);
      return;
    }
    AppMethodBeat.o(141021);
  }
  
  public final void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(141026);
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(141026);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.c(this, paramBoolean));
      AppMethodBeat.o(141026);
      return;
    }
    AppMethodBeat.o(141026);
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(141025);
    j.q(paramString, "text");
    Object localObject = this.bBK;
    if (al.isMainThread())
    {
      this.iuC.setPullDownText(paramString);
      AppMethodBeat.o(141025);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new au.g(this, paramString));
      AppMethodBeat.o(141025);
      return;
    }
    AppMethodBeat.o(141025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.au
 * JD-Core Version:    0.7.0.1
 */