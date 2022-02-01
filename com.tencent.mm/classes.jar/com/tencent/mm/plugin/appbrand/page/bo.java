package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class bo
  implements f
{
  private final String TAG;
  private final ad enm;
  private final ak ttm;
  
  public bo(ad paramad, ak paramak)
  {
    AppMethodBeat.i(147996);
    this.enm = paramad;
    this.ttm = paramak;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(147996);
  }
  
  public void a(final f.a parama, final int paramInt)
  {
    AppMethodBeat.i(147991);
    s.u(parama, "style");
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147991);
      return;
    }
    this.enm.V((Runnable)new d(this, this, parama, paramInt));
    AppMethodBeat.o(147991);
  }
  
  public final void aeW(final String paramString)
  {
    AppMethodBeat.i(147993);
    s.u(paramString, "style");
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147993);
      return;
    }
    this.enm.V((Runnable)new f(this, this, paramString));
    AppMethodBeat.o(147993);
  }
  
  public final void cFS()
  {
    AppMethodBeat.i(147987);
    com.tencent.mm.sdk.platformtools.Log.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.enm.getAppId() + " url:" + this.enm.cgR());
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147987);
      return;
    }
    this.enm.V((Runnable)new h(this, this));
    AppMethodBeat.o(147987);
  }
  
  public final void cFT()
  {
    AppMethodBeat.i(147988);
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147988);
      return;
    }
    this.enm.V((Runnable)new i(this, this));
    AppMethodBeat.o(147988);
  }
  
  public void fj(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147992);
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147992);
      return;
    }
    this.enm.V((Runnable)new e(this, this, paramString1, paramString2));
    AppMethodBeat.o(147992);
  }
  
  public final void kr(final boolean paramBoolean)
  {
    AppMethodBeat.i(147989);
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147989);
      return;
    }
    this.enm.V((Runnable)new b(this, this, paramBoolean));
    AppMethodBeat.o(147989);
  }
  
  public final void kt(final boolean paramBoolean)
  {
    AppMethodBeat.i(147990);
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147990);
      return;
    }
    this.enm.V((Runnable)new a(this, this, paramBoolean));
    AppMethodBeat.o(147990);
  }
  
  public final void requestDisallowInterceptTouchEvent(final boolean paramBoolean)
  {
    AppMethodBeat.i(147995);
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147995);
      return;
    }
    this.enm.V((Runnable)new c(this, this, paramBoolean));
    AppMethodBeat.o(147995);
  }
  
  public final void setPullDownText(final String paramString)
  {
    AppMethodBeat.i(147994);
    s.u(paramString, "text");
    if (!this.enm.isRunning())
    {
      com.tencent.mm.sdk.platformtools.Log.e(this.TAG, s.X("runOnUiThread PageView destroyed, stack=", android.util.Log.getStackTraceString(new Throwable())));
      AppMethodBeat.o(147994);
      return;
    }
    this.enm.V((Runnable)new g(this, this, paramString));
    AppMethodBeat.o(147994);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Runnable
  {
    public a(bo parambo1, bo parambo2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147978);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147978);
        return;
      }
      bo.c(jdField_this).setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(147978);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    public b(bo parambo1, bo parambo2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147979);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147979);
        return;
      }
      bo.c(jdField_this).setPullDownEnabled(paramBoolean);
      bo.c(jdField_this).kr(paramBoolean);
      AppMethodBeat.o(147979);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Runnable
  {
    public c(bo parambo1, bo parambo2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147980);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147980);
        return;
      }
      bo.c(jdField_this).requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(147980);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    public d(bo parambo1, bo parambo2, f.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(147981);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147981);
        return;
      }
      bo.c(jdField_this).cX(parama.name().toLowerCase(), paramInt);
      AppMethodBeat.o(147981);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Runnable
  {
    public e(bo parambo1, bo parambo2, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147982);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147982);
        return;
      }
      bo.c(jdField_this).cX(paramString1, i.dq(paramString2, -1));
      AppMethodBeat.o(147982);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Runnable
  {
    public f(bo parambo1, bo parambo2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147983);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147983);
        return;
      }
      bo.c(jdField_this).setBackgroundTextStyle(paramString);
      AppMethodBeat.o(147983);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Runnable
  {
    public g(bo parambo1, bo parambo2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147984);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147984);
        return;
      }
      bo.c(jdField_this).setPullDownText(paramString);
      AppMethodBeat.o(147984);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Runnable
  {
    public h(bo parambo1, bo parambo2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147985);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147985);
        return;
      }
      com.tencent.mm.sdk.platformtools.Log.i(bo.b(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bo.a(jdField_this).getAppId() + " url:" + bo.a(jdField_this).cgR());
      try
      {
        if (bo.a(jdField_this).tti.getWebScrollY() != 0) {
          bo.a(jdField_this).tti.apO();
        }
        bo.c(jdField_this).kr(true);
        bo.c(jdField_this).cFp();
        AppMethodBeat.o(147985);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bo.a(jdField_this).getAppId() + " url:" + bo.a(jdField_this).cgR() + " e:" + localNullPointerException);
        AppMethodBeat.o(147985);
        throw localNullPointerException;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    implements Runnable
  {
    public i(bo parambo1, bo parambo2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147986);
      if (!bo.a(this.tAv).isRunning())
      {
        com.tencent.mm.sdk.platformtools.Log.e(bo.b(this.tAv), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147986);
        return;
      }
      bo.c(jdField_this).cFt();
      AppMethodBeat.o(147986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bo
 * JD-Core Version:    0.7.0.1
 */