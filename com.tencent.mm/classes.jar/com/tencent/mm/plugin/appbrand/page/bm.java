package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"})
public class bm
  implements f
{
  private final String TAG;
  private final ac cwK;
  private final aj nnb;
  
  public bm(ac paramac, aj paramaj)
  {
    AppMethodBeat.i(147996);
    this.cwK = paramac;
    this.nnb = paramaj;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(147996);
  }
  
  public void a(final f.a parama, final int paramInt)
  {
    AppMethodBeat.i(147991);
    p.h(parama, "style");
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147991);
      return;
    }
    this.cwK.P((Runnable)new d(this, this, parama, paramInt));
    AppMethodBeat.o(147991);
  }
  
  public final void adV(final String paramString)
  {
    AppMethodBeat.i(147993);
    p.h(paramString, "style");
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147993);
      return;
    }
    this.cwK.P((Runnable)new f(this, this, paramString));
    AppMethodBeat.o(147993);
  }
  
  public final void bSe()
  {
    AppMethodBeat.i(147987);
    com.tencent.mm.sdk.platformtools.Log.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.cwK.getAppId() + " url:" + this.cwK.getURL());
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147987);
      return;
    }
    this.cwK.P((Runnable)new h(this, this));
    AppMethodBeat.o(147987);
  }
  
  public final void bSf()
  {
    AppMethodBeat.i(147988);
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147988);
      return;
    }
    this.cwK.P((Runnable)new i(this, this));
    AppMethodBeat.o(147988);
  }
  
  public void eE(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147992);
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147992);
      return;
    }
    this.cwK.P((Runnable)new e(this, this, paramString1, paramString2));
    AppMethodBeat.o(147992);
  }
  
  public final void ij(final boolean paramBoolean)
  {
    AppMethodBeat.i(147989);
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147989);
      return;
    }
    this.cwK.P((Runnable)new b(this, this, paramBoolean));
    AppMethodBeat.o(147989);
  }
  
  public final void il(final boolean paramBoolean)
  {
    AppMethodBeat.i(147990);
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147990);
      return;
    }
    this.cwK.P((Runnable)new a(this, this, paramBoolean));
    AppMethodBeat.o(147990);
  }
  
  public final void requestDisallowInterceptTouchEvent(final boolean paramBoolean)
  {
    AppMethodBeat.i(147995);
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147995);
      return;
    }
    this.cwK.P((Runnable)new c(this, this, paramBoolean));
    AppMethodBeat.o(147995);
  }
  
  public final void setPullDownText(final String paramString)
  {
    AppMethodBeat.i(147994);
    p.h(paramString, "text");
    if (!this.cwK.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147994);
      return;
    }
    this.cwK.P((Runnable)new g(this, this, paramString));
    AppMethodBeat.o(147994);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bm parambm1, bm parambm2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147978);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147978);
        return;
      }
      bm.c(jdField_this).setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(147978);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class b
    implements Runnable
  {
    public b(bm parambm1, bm parambm2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147979);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147979);
        return;
      }
      bm.c(jdField_this).setPullDownEnabled(paramBoolean);
      bm.c(jdField_this).ij(paramBoolean);
      AppMethodBeat.o(147979);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bm parambm1, bm parambm2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147980);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147980);
        return;
      }
      bm.c(jdField_this).requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(147980);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class d
    implements Runnable
  {
    public d(bm parambm1, bm parambm2, f.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(147981);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147981);
        return;
      }
      bm.c(jdField_this).cb(parama.bSC(), paramInt);
      AppMethodBeat.o(147981);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class e
    implements Runnable
  {
    public e(bm parambm1, bm parambm2, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147982);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147982);
        return;
      }
      bm.c(jdField_this).cb(paramString1, g.cu(paramString2, -1));
      AppMethodBeat.o(147982);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class f
    implements Runnable
  {
    public f(bm parambm1, bm parambm2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147983);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147983);
        return;
      }
      bm.c(jdField_this).setBackgroundTextStyle(paramString);
      AppMethodBeat.o(147983);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class g
    implements Runnable
  {
    public g(bm parambm1, bm parambm2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147984);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147984);
        return;
      }
      bm.c(jdField_this).setPullDownText(paramString);
      AppMethodBeat.o(147984);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class h
    implements Runnable
  {
    public h(bm parambm1, bm parambm2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147985);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147985);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i(bm.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bm.b(jdField_this).getAppId() + " url:" + bm.b(jdField_this).getURL());
      try
      {
        bb localbb = bm.b(jdField_this).bRk();
        p.g(localbb, "mPageView.webView");
        if (localbb.getWebScrollY() != 0) {
          bm.b(jdField_this).bRk().MM();
        }
        bm.c(jdField_this).ij(true);
        bm.c(jdField_this).bRP();
        AppMethodBeat.o(147985);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bm.b(jdField_this).getAppId() + " url:" + bm.b(jdField_this).getURL() + " e:" + localNullPointerException);
        Throwable localThrowable = (Throwable)localNullPointerException;
        AppMethodBeat.o(147985);
        throw localThrowable;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class i
    implements Runnable
  {
    public i(bm parambm1, bm parambm2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147986);
      if (!bm.b(this.ntK).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bm.a(this.ntK), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147986);
        return;
      }
      bm.c(jdField_this).bRT();
      AppMethodBeat.o(147986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */