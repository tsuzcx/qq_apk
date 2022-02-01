package com.tencent.mm.plugin.appbrand.page;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.f.a;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mPageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "mPullDownWrapper", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPullDownWebView;)V", "TAG", "", "enablePullDown", "", "enable", "", "enablePullDownRefresh", "getPullDownBackgroundColor", "", "requestDisallowInterceptTouchEvent", "disallow", "runOnUiThread", "block", "Lkotlin/Function0;", "setPullDownBackground", "style", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension$BackgroundTextStyle;", "color", "colorStr", "setPullDownBackgroundStyle", "setPullDownText", "text", "startPullDownRefresh", "stopPullDownRefresh", "luggage-wechat-full-sdk_release"})
public class bj
  implements f
{
  private final String TAG;
  private final aa caw;
  private final ah lyI;
  
  public bj(aa paramaa, ah paramah)
  {
    AppMethodBeat.i(147996);
    this.caw = paramaa;
    this.lyI = paramah;
    this.TAG = "Luggage.MPPageViewPullDownExtensionImpl";
    AppMethodBeat.o(147996);
  }
  
  public final void PS(final String paramString)
  {
    AppMethodBeat.i(147993);
    k.h(paramString, "style");
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147993);
      return;
    }
    this.caw.N((Runnable)new f(this, this, paramString));
    AppMethodBeat.o(147993);
  }
  
  public void a(final f.a parama, final int paramInt)
  {
    AppMethodBeat.i(147991);
    k.h(parama, "style");
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147991);
      return;
    }
    this.caw.N((Runnable)new d(this, this, parama, paramInt));
    AppMethodBeat.o(147991);
  }
  
  public final void brn()
  {
    AppMethodBeat.i(147987);
    ac.i(this.TAG, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.caw.getAppId() + " url:" + this.caw.getURL());
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147987);
      return;
    }
    this.caw.N((Runnable)new h(this, this));
    AppMethodBeat.o(147987);
  }
  
  public final void bro()
  {
    AppMethodBeat.i(147988);
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147988);
      return;
    }
    this.caw.N((Runnable)new i(this, this));
    AppMethodBeat.o(147988);
  }
  
  public void dY(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147992);
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147992);
      return;
    }
    this.caw.N((Runnable)new e(this, this, paramString1, paramString2));
    AppMethodBeat.o(147992);
  }
  
  public final void gZ(final boolean paramBoolean)
  {
    AppMethodBeat.i(147989);
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147989);
      return;
    }
    this.caw.N((Runnable)new b(this, this, paramBoolean));
    AppMethodBeat.o(147989);
  }
  
  public final void hb(final boolean paramBoolean)
  {
    AppMethodBeat.i(147990);
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147990);
      return;
    }
    this.caw.N((Runnable)new a(this, this, paramBoolean));
    AppMethodBeat.o(147990);
  }
  
  public final void requestDisallowInterceptTouchEvent(final boolean paramBoolean)
  {
    AppMethodBeat.i(147995);
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147995);
      return;
    }
    this.caw.N((Runnable)new c(this, this, paramBoolean));
    AppMethodBeat.o(147995);
  }
  
  public final void setPullDownText(final String paramString)
  {
    AppMethodBeat.i(147994);
    k.h(paramString, "text");
    if (!this.caw.isRunning())
    {
      ac.e(this.TAG, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(147994);
      return;
    }
    this.caw.N((Runnable)new g(this, this, paramString));
    AppMethodBeat.o(147994);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bj parambj1, bj parambj2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147978);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147978);
        return;
      }
      bj.c(jdField_this).setPullDownEnabled(paramBoolean);
      AppMethodBeat.o(147978);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class b
    implements Runnable
  {
    public b(bj parambj1, bj parambj2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147979);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147979);
        return;
      }
      bj.c(jdField_this).setPullDownEnabled(paramBoolean);
      bj.c(jdField_this).gZ(paramBoolean);
      AppMethodBeat.o(147979);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bj parambj1, bj parambj2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(147980);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147980);
        return;
      }
      bj.c(jdField_this).requestDisallowInterceptTouchEvent(paramBoolean);
      AppMethodBeat.o(147980);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class d
    implements Runnable
  {
    public d(bj parambj1, bj parambj2, f.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(147981);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147981);
        return;
      }
      bj.c(jdField_this).bM(parama.brB(), paramInt);
      AppMethodBeat.o(147981);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class e
    implements Runnable
  {
    public e(bj parambj1, bj parambj2, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147982);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147982);
        return;
      }
      bj.c(jdField_this).bM(paramString1, g.cd(paramString2, -1));
      AppMethodBeat.o(147982);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class f
    implements Runnable
  {
    public f(bj parambj1, bj parambj2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147983);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147983);
        return;
      }
      bj.c(jdField_this).setBackgroundTextStyle(paramString);
      AppMethodBeat.o(147983);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class g
    implements Runnable
  {
    public g(bj parambj1, bj parambj2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(147984);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147984);
        return;
      }
      bj.c(jdField_this).setPullDownText(paramString);
      AppMethodBeat.o(147984);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class h
    implements Runnable
  {
    public h(bj parambj1, bj parambj2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147985);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147985);
        return;
      }
      ac.i(bj.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bj.b(jdField_this).getAppId() + " url:" + bj.b(jdField_this).getURL());
      try
      {
        bj.c(jdField_this).gZ(true);
        bj.c(jdField_this).bqY();
        AppMethodBeat.o(147985);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ac.e(bj.a(jdField_this), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + bj.b(jdField_this).getAppId() + " url:" + bj.b(jdField_this).getURL() + " e:" + localNullPointerException);
        Throwable localThrowable = (Throwable)localNullPointerException;
        AppMethodBeat.o(147985);
        throw localThrowable;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"})
  public static final class i
    implements Runnable
  {
    public i(bj parambj1, bj parambj2) {}
    
    public final void run()
    {
      AppMethodBeat.i(147986);
      if (!bj.b(this.lFr).isRunning())
      {
        ac.e(bj.a(this.lFr), "runOnUiThread in ui-thread PageView destroyed");
        AppMethodBeat.o(147986);
        return;
      }
      bj.c(jdField_this).brc();
      AppMethodBeat.o(147986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */