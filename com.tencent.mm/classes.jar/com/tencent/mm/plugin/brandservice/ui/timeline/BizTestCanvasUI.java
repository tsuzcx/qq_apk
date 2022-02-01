package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.magicbrush.ai;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;
import d.g.b.p;
import d.g.b.q;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getLayoutId", "", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "JsEngine", "plugin-brandservice_release"})
public final class BizTestCanvasUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestCanvasUI";
  
  public final int getLayoutId()
  {
    return 2131496513;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208643);
    p.h(paramView, "view");
    AppMethodBeat.o(208643);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208642);
    super.onCreate(paramBundle);
    setMMTitle("调试Canvas");
    paramBundle = new a();
    paramBundle.setJsExceptionHandler((h)new b("TestCanvas", this));
    paramBundle.addJavascriptInterface(new c("TestCanvas", this), "console");
    Object localObject1 = (FrameLayout)findViewById(2131298736);
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = new MagicBrushView((Context)localObject2, MagicBrushView.h.cAX);
    d locald = paramBundle.nvp;
    locald.Hj();
    ((MagicBrushView)localObject2).setMagicBrush(locald);
    ae.i(this.TAG, "createCanvasView " + ((MagicBrushView)localObject2).getVirtualElementId());
    ((MagicBrushView)localObject2).setOpaque(false);
    ((MagicBrushView)localObject2).setClipChildren(false);
    ((MagicBrushView)localObject2).setClipToPadding(false);
    ((MagicBrushView)localObject2).setEnableTouchEvent(true);
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject1 = new k(b.asj() + "jsengine/test.js");
    if (((k)localObject1).exists()) {
      paramBundle.evaluateJavascript(com.tencent.mm.vfs.l.ah((k)localObject1), null);
    }
    for (;;)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new BizTestCanvasUI.d(this, paramBundle));
      AppMethodBeat.o(208642);
      return;
      ae.e(this.TAG, "can not found ".concat(String.valueOf(localObject1)));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "()V", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush", "()Lcom/tencent/magicbrush/MagicBrush;", "plugin-brandservice_release"})
  public static final class a
    extends x
  {
    final d nvp;
    
    public a()
    {
      AppMethodBeat.i(208635);
      Object localObject = new com.tencent.magicbrush.e();
      ((f)localObject).context = ak.getContext();
      ((com.tencent.magicbrush.e)localObject).ad(g.bCg());
      ((f)localObject).cxC = ((d.g.a.a)new a(this));
      ((f)localObject).cxB = ((com.tencent.magicbrush.handler.a)new b(this));
      ((com.tencent.magicbrush.e)localObject).b(a.b.cAw);
      String str = b.asj();
      p.g(str, "CConstants.DATAROOT_SDCARD_PATH()");
      ((com.tencent.magicbrush.e)localObject).dE(str);
      ((com.tencent.magicbrush.e)localObject).bS(false);
      localObject = ((com.tencent.magicbrush.e)localObject).Hu();
      if (localObject == null) {
        p.gkB();
      }
      this.nvp = ((d)localObject);
      AppMethodBeat.o(208635);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$1"})
    static final class a
      extends q
      implements d.g.a.a<ai>
    {
      a(BizTestCanvasUI.a parama)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$JsEngine$magicBrush$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "plugin-brandservice_release"})
    public static final class b
      implements com.tencent.magicbrush.handler.a
    {
      b(BizTestCanvasUI.a parama) {}
      
      public final boolean Cw()
      {
        AppMethodBeat.i(208632);
        IJSRuntime localIJSRuntime = BizTestCanvasUI.a.a(this.ofL);
        p.g(localIJSRuntime, "this@JsEngine.jsRuntime");
        boolean bool = localIJSRuntime.Nk();
        AppMethodBeat.o(208632);
        return bool;
      }
      
      public final String Cx()
      {
        AppMethodBeat.i(208630);
        String str = this.ofL.Cx();
        AppMethodBeat.o(208630);
        return str;
      }
      
      public final void a(Runnable paramRunnable, boolean paramBoolean)
      {
        AppMethodBeat.i(208631);
        p.h(paramRunnable, "p0");
        this.ofL.a(paramRunnable, paramBoolean);
        AppMethodBeat.o(208631);
      }
      
      public final boolean doInnerLoopTask()
      {
        AppMethodBeat.i(208634);
        boolean bool = this.ofL.doInnerLoopTask();
        AppMethodBeat.o(208634);
        return bool;
      }
      
      public final void resumeLoopTasks()
      {
        AppMethodBeat.i(208633);
        this.ofL.resumeLoopTasks();
        AppMethodBeat.o(208633);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$1"})
  static final class b
    implements h
  {
    b(String paramString, BizTestCanvasUI paramBizTestCanvasUI) {}
    
    public final void u(String paramString1, String paramString2)
    {
      AppMethodBeat.i(208637);
      ae.e(BizTestCanvasUI.a(jdField_this), "JsException[" + this.ofM + "]:" + paramString1 + '\n' + paramString2);
      AppMethodBeat.o(208637);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestCanvasUI$onCreate$jsEngine$1$2", "", "error", "", "objects", "", "([Ljava/lang/Object;)V", "info", "log", "plugin-brandservice_release"})
  public static final class c
  {
    c(String paramString, BizTestCanvasUI paramBizTestCanvasUI) {}
    
    @JavascriptInterface
    public final void error(Object... paramVarArgs)
    {
      AppMethodBeat.i(208640);
      p.h(paramVarArgs, "objects");
      ae.e(BizTestCanvasUI.a(jdField_this), "JsError[" + this.ofM + "]:" + d.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(208640);
    }
    
    @JavascriptInterface
    public final void info(Object... paramVarArgs)
    {
      AppMethodBeat.i(208639);
      p.h(paramVarArgs, "objects");
      ae.i(BizTestCanvasUI.a(jdField_this), "JsInfo[" + this.ofM + "]:" + d.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(208639);
    }
    
    @JavascriptInterface
    public final void log(Object... paramVarArgs)
    {
      AppMethodBeat.i(208638);
      p.h(paramVarArgs, "objects");
      ae.d(BizTestCanvasUI.a(jdField_this), "JsLog[" + this.ofM + "]:" + d.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(208638);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestCanvasUI
 * JD-Core Version:    0.7.0.1
 */