package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.magicbrush.al;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.r;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getLayoutId", "", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "JsEngine", "plugin-brandservice_release"})
public final class BizTestCanvasUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestCanvasUI";
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(258022);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(258022);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(258021);
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
    AppMethodBeat.o(258021);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return d.f.stG;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(258020);
    p.k(paramView, "view");
    AppMethodBeat.o(258020);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(258019);
    super.onCreate(paramBundle);
    setMMTitle("调试Canvas");
    paramBundle = new a();
    paramBundle.setJsExceptionHandler((h)new b("TestCanvas", this));
    paramBundle.addJavascriptInterface(new c("TestCanvas", this), "console");
    Object localObject1 = (FrameLayout)findViewById(d.e.container);
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    localObject2 = new MagicBrushView((Context)localObject2, MagicBrushView.h.cPU);
    com.tencent.magicbrush.e locale = paramBundle.szG;
    locale.UI();
    ((MagicBrushView)localObject2).setMagicBrush(locale);
    Log.i(this.TAG, "createCanvasView " + ((MagicBrushView)localObject2).getVirtualElementId());
    ((MagicBrushView)localObject2).setOpaque(false);
    ((MagicBrushView)localObject2).setClipChildren(false);
    ((MagicBrushView)localObject2).setClipToPadding(false);
    ((MagicBrushView)localObject2).setEnableTouchEvent(true);
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject1 = new com.tencent.mm.vfs.q(b.aSL() + "jsengine/test.js");
    if (((com.tencent.mm.vfs.q)localObject1).ifE()) {
      paramBundle.evaluateJavascript(r.ak((com.tencent.mm.vfs.q)localObject1), null);
    }
    for (;;)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new d(this, paramBundle));
      AppMethodBeat.o(258019);
      return;
      Log.e(this.TAG, "can not found ".concat(String.valueOf(localObject1)));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "()V", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush", "()Lcom/tencent/magicbrush/MagicBrush;", "plugin-brandservice_release"})
  public static final class a
    extends x
  {
    final com.tencent.magicbrush.e szG;
    
    public a()
    {
      AppMethodBeat.i(266829);
      Object localObject = new f();
      ((com.tencent.magicbrush.g)localObject).context = MMApplicationContext.getContext();
      ((f)localObject).ad(com.tencent.mm.plugin.appbrand.ac.g.clS());
      ((com.tencent.magicbrush.g)localObject).cMv = ((kotlin.g.a.a)new a(this));
      ((com.tencent.magicbrush.g)localObject).cMu = ((com.tencent.magicbrush.handler.a)new b(this));
      ((f)localObject).b(a.b.cPr);
      String str = b.aSL();
      p.j(str, "CConstants.DATAROOT_SDCARD_PATH()");
      ((f)localObject).ez(str);
      ((f)localObject).cH(false);
      localObject = ((f)localObject).UW();
      if (localObject == null) {
        p.iCn();
      }
      this.szG = ((com.tencent.magicbrush.e)localObject);
      AppMethodBeat.o(266829);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<al>
    {
      a(BizTestCanvasUI.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "plugin-brandservice_release"})
    public static final class b
      implements com.tencent.magicbrush.handler.a
    {
      b(BizTestCanvasUI.a parama) {}
      
      public final boolean OF()
      {
        AppMethodBeat.i(263881);
        IJSRuntime localIJSRuntime = this.szH.bYQ();
        p.j(localIJSRuntime, "this@JsEngine.jsRuntime");
        boolean bool = localIJSRuntime.abY();
        AppMethodBeat.o(263881);
        return bool;
      }
      
      public final String OG()
      {
        AppMethodBeat.i(263879);
        String str = this.szH.OG();
        AppMethodBeat.o(263879);
        return str;
      }
      
      public final void a(Runnable paramRunnable, boolean paramBoolean)
      {
        AppMethodBeat.i(263880);
        p.k(paramRunnable, "p0");
        this.szH.a(paramRunnable, paramBoolean);
        AppMethodBeat.o(263880);
      }
      
      public final boolean doInnerLoopTask()
      {
        AppMethodBeat.i(263883);
        boolean bool = this.szH.doInnerLoopTask();
        AppMethodBeat.o(263883);
        return bool;
      }
      
      public final void resumeLoopTasks()
      {
        AppMethodBeat.i(263882);
        this.szH.resumeLoopTasks();
        AppMethodBeat.o(263882);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$1"})
  static final class b
    implements h
  {
    b(String paramString, BizTestCanvasUI paramBizTestCanvasUI) {}
    
    public final void A(String paramString1, String paramString2)
    {
      AppMethodBeat.i(257268);
      Log.e(BizTestCanvasUI.a(jdField_this), "JsException[" + this.szI + "]:" + paramString1 + '\n' + paramString2);
      AppMethodBeat.o(257268);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$2", "", "error", "", "objects", "", "([Ljava/lang/Object;)V", "info", "log", "plugin-brandservice_release"})
  public static final class c
  {
    c(String paramString, BizTestCanvasUI paramBizTestCanvasUI) {}
    
    @JavascriptInterface
    public final void error(Object... paramVarArgs)
    {
      AppMethodBeat.i(266058);
      p.k(paramVarArgs, "objects");
      Log.e(BizTestCanvasUI.a(jdField_this), "JsError[" + this.szI + "]:" + kotlin.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(266058);
    }
    
    @JavascriptInterface
    public final void info(Object... paramVarArgs)
    {
      AppMethodBeat.i(266057);
      p.k(paramVarArgs, "objects");
      Log.i(BizTestCanvasUI.a(jdField_this), "JsInfo[" + this.szI + "]:" + kotlin.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(266057);
    }
    
    @JavascriptInterface
    public final void log(Object... paramVarArgs)
    {
      AppMethodBeat.i(266056);
      p.k(paramVarArgs, "objects");
      Log.d(BizTestCanvasUI.a(jdField_this), "JsLog[" + this.szI + "]:" + kotlin.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(266056);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(BizTestCanvasUI paramBizTestCanvasUI, BizTestCanvasUI.a parama) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(257262);
      paramBundle.destroy();
      this.szJ.finish();
      AppMethodBeat.o(257262);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestCanvasUI
 * JD-Core Version:    0.7.0.1
 */