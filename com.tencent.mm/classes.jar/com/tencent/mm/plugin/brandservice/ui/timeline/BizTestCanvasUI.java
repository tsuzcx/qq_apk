package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.magicbrush.aj;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getLayoutId", "", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "JsEngine", "plugin-brandservice_release"})
public final class BizTestCanvasUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestCanvasUI";
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195167);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195167);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195166);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(195166);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131493249;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195165);
    kotlin.g.b.p.h(paramView, "view");
    AppMethodBeat.o(195165);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(195164);
    super.onCreate(paramBundle);
    setMMTitle("调试Canvas");
    paramBundle = new a();
    paramBundle.setJsExceptionHandler((h)new b("TestCanvas", this));
    paramBundle.addJavascriptInterface(new c("TestCanvas", this), "console");
    Object localObject1 = (FrameLayout)findViewById(2131299174);
    Object localObject2 = getContext();
    kotlin.g.b.p.g(localObject2, "context");
    localObject2 = new MagicBrushView((Context)localObject2, MagicBrushView.h.cPd);
    com.tencent.magicbrush.e locale = paramBundle.pqH;
    locale.Rc();
    ((MagicBrushView)localObject2).setMagicBrush(locale);
    Log.i(this.TAG, "createCanvasView " + ((MagicBrushView)localObject2).getVirtualElementId());
    ((MagicBrushView)localObject2).setOpaque(false);
    ((MagicBrushView)localObject2).setClipChildren(false);
    ((MagicBrushView)localObject2).setClipToPadding(false);
    ((MagicBrushView)localObject2).setEnableTouchEvent(true);
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject1 = new o(b.aKJ() + "jsengine/test.js");
    if (((o)localObject1).exists()) {
      paramBundle.evaluateJavascript(com.tencent.mm.vfs.p.an((o)localObject1), null);
    }
    for (;;)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new d(this, paramBundle));
      AppMethodBeat.o(195164);
      return;
      Log.e(this.TAG, "can not found ".concat(String.valueOf(localObject1)));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "()V", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush", "()Lcom/tencent/magicbrush/MagicBrush;", "plugin-brandservice_release"})
  public static final class a
    extends x
  {
    final com.tencent.magicbrush.e pqH;
    
    public a()
    {
      AppMethodBeat.i(195158);
      Object localObject = new f();
      ((com.tencent.magicbrush.g)localObject).context = MMApplicationContext.getContext();
      ((f)localObject).ae(com.tencent.mm.plugin.appbrand.ac.g.bZk());
      ((com.tencent.magicbrush.g)localObject).cLK = ((kotlin.g.a.a)new a(this));
      ((com.tencent.magicbrush.g)localObject).cLJ = ((com.tencent.magicbrush.handler.a)new b(this));
      ((f)localObject).b(a.b.cOC);
      String str = b.aKJ();
      kotlin.g.b.p.g(str, "CConstants.DATAROOT_SDCARD_PATH()");
      ((f)localObject).dY(str);
      ((f)localObject).ct(false);
      localObject = ((f)localObject).Rm();
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      this.pqH = ((com.tencent.magicbrush.e)localObject);
      AppMethodBeat.o(195158);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<aj>
    {
      a(BizTestCanvasUI.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "plugin-brandservice_release"})
    public static final class b
      implements com.tencent.magicbrush.handler.a
    {
      b(BizTestCanvasUI.a parama) {}
      
      public final boolean LO()
      {
        AppMethodBeat.i(195155);
        IJSRuntime localIJSRuntime = this.pqI.bMz();
        kotlin.g.b.p.g(localIJSRuntime, "this@JsEngine.jsRuntime");
        boolean bool = localIJSRuntime.Xw();
        AppMethodBeat.o(195155);
        return bool;
      }
      
      public final String LP()
      {
        AppMethodBeat.i(195153);
        String str = this.pqI.LP();
        AppMethodBeat.o(195153);
        return str;
      }
      
      public final void a(Runnable paramRunnable, boolean paramBoolean)
      {
        AppMethodBeat.i(195154);
        kotlin.g.b.p.h(paramRunnable, "p0");
        this.pqI.a(paramRunnable, paramBoolean);
        AppMethodBeat.o(195154);
      }
      
      public final boolean doInnerLoopTask()
      {
        AppMethodBeat.i(195157);
        boolean bool = this.pqI.doInnerLoopTask();
        AppMethodBeat.o(195157);
        return bool;
      }
      
      public final void resumeLoopTasks()
      {
        AppMethodBeat.i(195156);
        this.pqI.resumeLoopTasks();
        AppMethodBeat.o(195156);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$1"})
  static final class b
    implements h
  {
    b(String paramString, BizTestCanvasUI paramBizTestCanvasUI) {}
    
    public final void u(String paramString1, String paramString2)
    {
      AppMethodBeat.i(195159);
      Log.e(BizTestCanvasUI.a(jdField_this), "JsException[" + this.pqJ + "]:" + paramString1 + '\n' + paramString2);
      AppMethodBeat.o(195159);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$2", "", "error", "", "objects", "", "([Ljava/lang/Object;)V", "info", "log", "plugin-brandservice_release"})
  public static final class c
  {
    c(String paramString, BizTestCanvasUI paramBizTestCanvasUI) {}
    
    @JavascriptInterface
    public final void error(Object... paramVarArgs)
    {
      AppMethodBeat.i(195162);
      kotlin.g.b.p.h(paramVarArgs, "objects");
      Log.e(BizTestCanvasUI.a(jdField_this), "JsError[" + this.pqJ + "]:" + kotlin.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(195162);
    }
    
    @JavascriptInterface
    public final void info(Object... paramVarArgs)
    {
      AppMethodBeat.i(195161);
      kotlin.g.b.p.h(paramVarArgs, "objects");
      Log.i(BizTestCanvasUI.a(jdField_this), "JsInfo[" + this.pqJ + "]:" + kotlin.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(195161);
    }
    
    @JavascriptInterface
    public final void log(Object... paramVarArgs)
    {
      AppMethodBeat.i(195160);
      kotlin.g.b.p.h(paramVarArgs, "objects");
      Log.d(BizTestCanvasUI.a(jdField_this), "JsLog[" + this.pqJ + "]:" + kotlin.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(195160);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(BizTestCanvasUI paramBizTestCanvasUI, BizTestCanvasUI.a parama) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(195163);
      paramBundle.destroy();
      this.pqK.finish();
      AppMethodBeat.o(195163);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestCanvasUI
 * JD-Core Version:    0.7.0.1
 */