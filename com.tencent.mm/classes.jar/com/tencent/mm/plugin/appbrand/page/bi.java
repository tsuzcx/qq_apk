package com.tencent.mm.plugin.appbrand.page;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"})
public class bi
  implements f
{
  private final String TAG;
  private final z ckP;
  private final ag mcN;
  
  public bi(z paramz, ag paramag)
  {
    AppMethodBeat.i(147996);
    this.ckP = paramz;
    this.mcN = paramag;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(147996);
  }
  
  public final void Uh(final String paramString)
  {
    AppMethodBeat.i(147993);
    p.h(paramString, "style");
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147993);
      return;
    }
    this.ckP.K((Runnable)new f(this, this, paramString));
    AppMethodBeat.o(147993);
  }
  
  public void a(final f.a parama, final int paramInt)
  {
    AppMethodBeat.i(147991);
    p.h(parama, "style");
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147991);
      return;
    }
    this.ckP.K((Runnable)new d(this, this, parama, paramInt));
    AppMethodBeat.o(147991);
  }
  
  public final void bvZ()
  {
    AppMethodBeat.i(147987);
    ae.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.ckP.getAppId() + " url:" + this.ckP.getURL());
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147987);
      return;
    }
    this.ckP.K((Runnable)new h(this, this));
    AppMethodBeat.o(147987);
  }
  
  public final void bwa()
  {
    AppMethodBeat.i(147988);
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147988);
      return;
    }
    this.ckP.K((Runnable)new i(this, this));
    AppMethodBeat.o(147988);
  }
  
  public void el(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147992);
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147992);
      return;
    }
    this.ckP.K((Runnable)new e(this, this, paramString1, paramString2));
    AppMethodBeat.o(147992);
  }
  
  public final void hi(final boolean paramBoolean)
  {
    AppMethodBeat.i(147989);
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147989);
      return;
    }
    this.ckP.K((Runnable)new b(this, this, paramBoolean));
    AppMethodBeat.o(147989);
  }
  
  public final void hk(final boolean paramBoolean)
  {
    AppMethodBeat.i(147990);
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147990);
      return;
    }
    this.ckP.K((Runnable)new a(this, this, paramBoolean));
    AppMethodBeat.o(147990);
  }
  
  public final void requestDisallowInterceptTouchEvent(final boolean paramBoolean)
  {
    AppMethodBeat.i(147995);
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147995);
      return;
    }
    this.ckP.K((Runnable)new c(this, this, paramBoolean));
    AppMethodBeat.o(147995);
  }
  
  public final void setPullDownText(final String paramString)
  {
    AppMethodBeat.i(147994);
    p.h(paramString, "text");
    if (!this.ckP.isRunning())
    {
      ae.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147994);
      return;
    }
    this.ckP.K((Runnable)new g(this, this, paramString));
    AppMethodBeat.o(147994);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bi parambi1, bi parambi2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147978);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147978);
        return;
      }
      bi.c(jdField_this).setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(147978);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class b
    implements Runnable
  {
    public b(bi parambi1, bi parambi2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147979);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147979);
        return;
      }
      bi.c(jdField_this).setPullDownEnabled(paramBoolean);
      bi.c(jdField_this).hi(paramBoolean);
      AppMethodBeat.o(147979);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bi parambi1, bi parambi2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147980);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147980);
        return;
      }
      bi.c(jdField_this).requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(147980);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class d
    implements Runnable
  {
    public d(bi parambi1, bi parambi2, f.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(147981);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147981);
        return;
      }
      bi.c(jdField_this).bT(parama.bwu(), paramInt);
      AppMethodBeat.o(147981);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class e
    implements Runnable
  {
    public e(bi parambi1, bi parambi2, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147982);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147982);
        return;
      }
      bi.c(jdField_this).bT(paramString1, g.ck(paramString2, -1));
      AppMethodBeat.o(147982);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class f
    implements Runnable
  {
    public f(bi parambi1, bi parambi2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147983);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147983);
        return;
      }
      bi.c(jdField_this).setBackgroundTextStyle(paramString);
      AppMethodBeat.o(147983);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class g
    implements Runnable
  {
    public g(bi parambi1, bi parambi2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147984);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147984);
        return;
      }
      bi.c(jdField_this).setPullDownText(paramString);
      AppMethodBeat.o(147984);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class h
    implements Runnable
  {
    public h(bi parambi1, bi parambi2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147985);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147985);
        return;
      }
      ae.i(bi.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bi.b(jdField_this).getAppId() + " url:" + bi.b(jdField_this).getURL());
      try
      {
        ax localax = bi.b(jdField_this).bvk();
        p.g(localax, "mPageView.webView");
        if (localax.getWebScrollY() != 0) {
          bi.b(jdField_this).bvk().Dq();
        }
        bi.c(jdField_this).hi(true);
        bi.c(jdField_this).bvK();
        AppMethodBeat.o(147985);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ae.e(bi.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bi.b(jdField_this).getAppId() + " url:" + bi.b(jdField_this).getURL() + " e:" + localNullPointerException);
        Throwable localThrowable = (Throwable)localNullPointerException;
        AppMethodBeat.o(147985);
        throw localThrowable;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class i
    implements Runnable
  {
    public i(bi parambi1, bi parambi2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147986);
      if (!bi.b(this.mjq).isRunning())
      {
        ae.e(bi.a(this.mjq), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147986);
        return;
      }
      bi.c(jdField_this).bvO();
      AppMethodBeat.o(147986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bi
 * JD-Core Version:    0.7.0.1
 */