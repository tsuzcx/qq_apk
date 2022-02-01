package com.tencent.mm.plugin.appbrand.page;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"})
public class bo
  implements f
{
  private final String TAG;
  private final aa cdz;
  private final am kWY;
  
  public bo(aa paramaa, am paramam)
  {
    AppMethodBeat.i(147996);
    this.cdz = paramaa;
    this.kWY = paramam;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(147996);
  }
  
  public final void LM(final String paramString)
  {
    AppMethodBeat.i(147993);
    k.h(paramString, "style");
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147993);
      return;
    }
    this.cdz.L((Runnable)new f(this, this, paramString));
    AppMethodBeat.o(147993);
  }
  
  public void a(final f.a parama, final int paramInt)
  {
    AppMethodBeat.i(147991);
    k.h(parama, "style");
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147991);
      return;
    }
    this.cdz.L((Runnable)new d(this, this, parama, paramInt));
    AppMethodBeat.o(147991);
  }
  
  public final void bky()
  {
    AppMethodBeat.i(147987);
    ad.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.cdz.getAppId() + " url:" + this.cdz.getURL());
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147987);
      return;
    }
    this.cdz.L((Runnable)new h(this, this));
    AppMethodBeat.o(147987);
  }
  
  public final void bkz()
  {
    AppMethodBeat.i(147988);
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147988);
      return;
    }
    this.cdz.L((Runnable)new i(this, this));
    AppMethodBeat.o(147988);
  }
  
  public void dM(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147992);
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147992);
      return;
    }
    this.cdz.L((Runnable)new e(this, this, paramString1, paramString2));
    AppMethodBeat.o(147992);
  }
  
  public final void gF(final boolean paramBoolean)
  {
    AppMethodBeat.i(147989);
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147989);
      return;
    }
    this.cdz.L((Runnable)new b(this, this, paramBoolean));
    AppMethodBeat.o(147989);
  }
  
  public final void gH(final boolean paramBoolean)
  {
    AppMethodBeat.i(147990);
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147990);
      return;
    }
    this.cdz.L((Runnable)new a(this, this, paramBoolean));
    AppMethodBeat.o(147990);
  }
  
  public final void requestDisallowInterceptTouchEvent(final boolean paramBoolean)
  {
    AppMethodBeat.i(147995);
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147995);
      return;
    }
    this.cdz.L((Runnable)new c(this, this, paramBoolean));
    AppMethodBeat.o(147995);
  }
  
  public final void setPullDownText(final String paramString)
  {
    AppMethodBeat.i(147994);
    k.h(paramString, "text");
    if (!this.cdz.isRunning())
    {
      ad.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147994);
      return;
    }
    this.cdz.L((Runnable)new g(this, this, paramString));
    AppMethodBeat.o(147994);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bo parambo1, bo parambo2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147978);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147978);
        return;
      }
      bo.c(jdField_this).setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(147978);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class b
    implements Runnable
  {
    public b(bo parambo1, bo parambo2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147979);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147979);
        return;
      }
      bo.c(jdField_this).setPullDownEnabled(paramBoolean);
      bo.c(jdField_this).gF(paramBoolean);
      AppMethodBeat.o(147979);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bo parambo1, bo parambo2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147980);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147980);
        return;
      }
      bo.c(jdField_this).requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(147980);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class d
    implements Runnable
  {
    public d(bo parambo1, bo parambo2, f.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(147981);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147981);
        return;
      }
      bo.c(jdField_this).bI(parama.bkM(), paramInt);
      AppMethodBeat.o(147981);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class e
    implements Runnable
  {
    public e(bo parambo1, bo parambo2, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147982);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147982);
        return;
      }
      bo.c(jdField_this).bI(paramString1, g.bY(paramString2, -1));
      AppMethodBeat.o(147982);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class f
    implements Runnable
  {
    public f(bo parambo1, bo parambo2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147983);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147983);
        return;
      }
      bo.c(jdField_this).setBackgroundTextStyle(paramString);
      AppMethodBeat.o(147983);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class g
    implements Runnable
  {
    public g(bo parambo1, bo parambo2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147984);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147984);
        return;
      }
      bo.c(jdField_this).setPullDownText(paramString);
      AppMethodBeat.o(147984);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class h
    implements Runnable
  {
    public h(bo parambo1, bo parambo2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147985);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147985);
        return;
      }
      ad.i(bo.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bo.b(jdField_this).getAppId() + " url:" + bo.b(jdField_this).getURL());
      try
      {
        bo.c(jdField_this).gF(true);
        bo.c(jdField_this).bkj();
        AppMethodBeat.o(147985);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ad.e(bo.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bo.b(jdField_this).getAppId() + " url:" + bo.b(jdField_this).getURL() + " e:" + localNullPointerException);
        Throwable localThrowable = (Throwable)localNullPointerException;
        AppMethodBeat.o(147985);
        throw localThrowable;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class i
    implements Runnable
  {
    public i(bo parambo1, bo parambo2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147986);
      if (!bo.b(this.lfx).isRunning())
      {
        ad.e(bo.a(this.lfx), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147986);
        return;
      }
      bo.c(jdField_this).bkn();
      AppMethodBeat.o(147986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bo
 * JD-Core Version:    0.7.0.1
 */