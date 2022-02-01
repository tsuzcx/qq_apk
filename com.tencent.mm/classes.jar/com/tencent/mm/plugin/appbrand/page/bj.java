package com.tencent.mm.plugin.appbrand.page;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.f.a;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"})
public class bj
  implements f
{
  private final String TAG;
  private final aa ckN;
  private final ah lYg;
  
  public bj(aa paramaa, ah paramah)
  {
    AppMethodBeat.i(147996);
    this.ckN = paramaa;
    this.lYg = paramah;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(147996);
  }
  
  public final void Tw(final String paramString)
  {
    AppMethodBeat.i(147993);
    p.h(paramString, "style");
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147993);
      return;
    }
    this.ckN.M((Runnable)new f(this, this, paramString));
    AppMethodBeat.o(147993);
  }
  
  public void a(final f.a parama, final int paramInt)
  {
    AppMethodBeat.i(147991);
    p.h(parama, "style");
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147991);
      return;
    }
    this.ckN.M((Runnable)new d(this, this, parama, paramInt));
    AppMethodBeat.o(147991);
  }
  
  public final void bvo()
  {
    AppMethodBeat.i(147987);
    ad.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.ckN.getAppId() + " url:" + this.ckN.getURL());
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147987);
      return;
    }
    this.ckN.M((Runnable)new h(this, this));
    AppMethodBeat.o(147987);
  }
  
  public final void bvp()
  {
    AppMethodBeat.i(147988);
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147988);
      return;
    }
    this.ckN.M((Runnable)new i(this, this));
    AppMethodBeat.o(147988);
  }
  
  public void ei(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147992);
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147992);
      return;
    }
    this.ckN.M((Runnable)new e(this, this, paramString1, paramString2));
    AppMethodBeat.o(147992);
  }
  
  public final void hh(final boolean paramBoolean)
  {
    AppMethodBeat.i(147989);
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147989);
      return;
    }
    this.ckN.M((Runnable)new b(this, this, paramBoolean));
    AppMethodBeat.o(147989);
  }
  
  public final void hj(final boolean paramBoolean)
  {
    AppMethodBeat.i(147990);
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147990);
      return;
    }
    this.ckN.M((Runnable)new a(this, this, paramBoolean));
    AppMethodBeat.o(147990);
  }
  
  public final void requestDisallowInterceptTouchEvent(final boolean paramBoolean)
  {
    AppMethodBeat.i(147995);
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147995);
      return;
    }
    this.ckN.M((Runnable)new c(this, this, paramBoolean));
    AppMethodBeat.o(147995);
  }
  
  public final void setPullDownText(final String paramString)
  {
    AppMethodBeat.i(147994);
    p.h(paramString, "text");
    if (!this.ckN.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147994);
      return;
    }
    this.ckN.M((Runnable)new g(this, this, paramString));
    AppMethodBeat.o(147994);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bj parambj1, bj parambj2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147978);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147978);
        return;
      }
      bj.c(jdField_this).setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(147978);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class b
    implements Runnable
  {
    public b(bj parambj1, bj parambj2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147979);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147979);
        return;
      }
      bj.c(jdField_this).setPullDownEnabled(paramBoolean);
      bj.c(jdField_this).hh(paramBoolean);
      AppMethodBeat.o(147979);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bj parambj1, bj parambj2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147980);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147980);
        return;
      }
      bj.c(jdField_this).requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(147980);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class d
    implements Runnable
  {
    public d(bj parambj1, bj parambj2, f.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(147981);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147981);
        return;
      }
      bj.c(jdField_this).bP(parama.bvD(), paramInt);
      AppMethodBeat.o(147981);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class e
    implements Runnable
  {
    public e(bj parambj1, bj parambj2, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147982);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147982);
        return;
      }
      bj.c(jdField_this).bP(paramString1, g.cg(paramString2, -1));
      AppMethodBeat.o(147982);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class f
    implements Runnable
  {
    public f(bj parambj1, bj parambj2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147983);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147983);
        return;
      }
      bj.c(jdField_this).setBackgroundTextStyle(paramString);
      AppMethodBeat.o(147983);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class g
    implements Runnable
  {
    public g(bj parambj1, bj parambj2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147984);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147984);
        return;
      }
      bj.c(jdField_this).setPullDownText(paramString);
      AppMethodBeat.o(147984);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class h
    implements Runnable
  {
    public h(bj parambj1, bj parambj2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147985);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147985);
        return;
      }
      ad.i(bj.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bj.b(jdField_this).getAppId() + " url:" + bj.b(jdField_this).getURL());
      try
      {
        ay localay = bj.b(jdField_this).buz();
        p.g(localay, "mPageView.webView");
        if (localay.getWebScrollY() != 0) {
          bj.b(jdField_this).buz().Dn();
        }
        bj.c(jdField_this).hh(true);
        bj.c(jdField_this).buZ();
        AppMethodBeat.o(147985);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ad.e(bj.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bj.b(jdField_this).getAppId() + " url:" + bj.b(jdField_this).getURL() + " e:" + localNullPointerException);
        Throwable localThrowable = (Throwable)localNullPointerException;
        AppMethodBeat.o(147985);
        throw localThrowable;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class i
    implements Runnable
  {
    public i(bj parambj1, bj parambj2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147986);
      if (!bj.b(this.meV).isRunning())
      {
        ad.e(bj.a(this.meV), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147986);
        return;
      }
      bj.c(jdField_this).bvd();
      AppMethodBeat.o(147986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */