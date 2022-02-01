package com.tencent.mm.plugin.m.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.ae;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.m;
import io.flutter.view.FlutterMain;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "activity", "Landroid/app/Activity;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "entryPoint", "", "channelName", "(Landroid/app/Activity;Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Ljava/lang/String;Ljava/lang/String;)V", "firstFrameRendered", "", "foregroundCnt", "", "keyboardHeight", "keyboardShown", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mRoute", "getMRoute", "()Ljava/lang/String;", "mRoute$delegate", "Lkotlin/Lazy;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "wxaChannelService", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "createRenderView", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "view", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "pageViewId", "", "renderPtr", "pagePath", "container", "Landroid/view/ViewGroup;", "eventHandler", "Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "ensureFlutterReady", "Lio/flutter/embedding/engine/FlutterEngine;", "getHeight", "getNecessaryResource", "Ljava/util/HashMap;", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "initChannel", "", "bm", "Lio/flutter/plugin/common/BinaryMessenger;", "notifyKeyboardChanged", "onBackground", "onDestroy", "onDestroyView", "onForeground", "parent", "onKeyboardStateChanged", "shown", "onPrepareDone", "pickerSelectCallback", "id", "ok", "data", "refreshHeight", "height", "scrollToTop", "Companion", "luggage-native-view_release"})
public final class a
  implements u.c
{
  public static Map<Integer, a.a> vBZ;
  public static final a.a vCa;
  private final Activity activity;
  public com.tencent.mm.plugin.appbrand.widget.input.u coe;
  public final com.tencent.luggage.sdk.d.c lUI;
  private int nGK;
  private boolean vBS;
  public int vBT;
  public d vBU;
  public com.tencent.mm.plugin.m.a.a.b.b vBV;
  private final f vBW;
  private final String vBX;
  private final String vBY;
  
  static
  {
    AppMethodBeat.i(123796);
    vCa = new a.a((byte)0);
    vBZ = (Map)new LinkedHashMap();
    AppMethodBeat.o(123796);
  }
  
  public a(Activity paramActivity, com.tencent.luggage.sdk.d.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123804);
    this.activity = paramActivity;
    this.lUI = paramc;
    this.vBX = paramString1;
    this.vBY = paramString2;
    this.vBU = new d(this.vBY);
    this.vBV = new com.tencent.mm.plugin.m.a.a.b.b(this.vBU);
    this.vBW = g.O((d.g.a.a)new b(this));
    djN().geC().bbO(djM());
    AppMethodBeat.o(123804);
  }
  
  public static void a(com.tencent.mm.plugin.m.a.a.b.a parama)
  {
    AppMethodBeat.i(123802);
    p.h(parama, "view");
    vBZ.remove(Integer.valueOf((int)parama.getViewId()));
    AppMethodBeat.o(123802);
  }
  
  private final String djM()
  {
    AppMethodBeat.i(123797);
    String str = (String)this.vBW.getValue();
    AppMethodBeat.o(123797);
    return str;
  }
  
  private final io.flutter.embedding.engine.a djN()
  {
    AppMethodBeat.i(123799);
    Object localObject1 = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.api("init_flutter_start");
    localObject1 = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.hN("ui_create", "init_flutter_start");
    FlutterMain.startInitialization(aj.getContext());
    FlutterMain.ensureInitializationComplete(aj.getContext(), new String[0]);
    localObject1 = c.vCc.fJ((Context)this.activity);
    Object localObject2 = new com.tencent.mm.b((io.flutter.embedding.engine.a)localObject1, (Context)this.activity);
    ((io.flutter.embedding.engine.a)localObject1).geC().setInitialRoute(djM());
    Object localObject4 = (io.flutter.plugin.a.c)((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
    Object localObject3 = com.tencent.mm.plugin.m.a.a.a.a.vCj;
    if (com.tencent.mm.plugin.m.a.a.a.a.djQ().vCh == null)
    {
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.vCj;
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.djQ();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vCh = ((io.flutter.plugin.a.c)localObject4);
      localObject4 = ((Iterable)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vCe).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vCh != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).aph((String)localObject5);
        }
        localObject6 = (k.c)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vCf.get(localObject5);
        if (localObject6 != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).a((String)localObject5, (k.c)localObject6);
        }
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vCf.clear();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vCe.clear();
    }
    localObject3 = this.vBU;
    Object localObject5 = this.lUI;
    localObject4 = this.vBV;
    p.h(localObject4, "renderViewManager");
    ((d)localObject3).lUI = ((com.tencent.luggage.sdk.d.c)localObject5);
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.vCj;
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.djQ();
    Object localObject6 = ((d)localObject3).vBY;
    p.h(localObject6, "name");
    if ((a.d)((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vCd.get(localObject6) == null)
    {
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vCh != null) {
        break label529;
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vCe.add(localObject6);
    }
    for (;;)
    {
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.vCj;
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.djQ();
      localObject6 = ((d)localObject3).vBY;
      k.c localc = ((d)localObject3).vCk;
      p.h(localObject6, "name");
      p.h(localc, "handler");
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).a((String)localObject6, localc);
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vCe.contains(localObject6)) {
        ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vCf.put(localObject6, localc);
      }
      ((d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.b((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      ((d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.c((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
      p.g(localObject3, "flutterEngine.dartExecutor");
      if (!((DartExecutor)localObject3).geP())
      {
        localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
        this.activity.getAssets();
        localObject4 = FlutterMain.findAppBundlePath(aj.getContext());
        if (localObject4 == null) {
          p.gfZ();
        }
        ((DartExecutor)localObject3).a(new DartExecutor.a((String)localObject4, "main", (byte)0));
      }
      io.flutter.a.a.registerWith((m)localObject2);
      localObject2 = com.tencent.mm.plugin.m.a.c.c.vCY;
      com.tencent.mm.plugin.m.a.c.c.api("init_flutter_end");
      localObject2 = com.tencent.mm.plugin.m.a.c.c.vCY;
      com.tencent.mm.plugin.m.a.c.c.hN("init_flutter_start", "init_flutter_end");
      AppMethodBeat.o(123799);
      return localObject1;
      label529:
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).aph((String)localObject6);
    }
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(123803);
    this.vBS = paramBoolean;
    d locald = this.vBU;
    paramBoolean = this.vBS;
    int i = this.nGK;
    com.tencent.mm.plugin.m.a.a.a.a.b localb = com.tencent.mm.plugin.m.a.a.a.a.vCj;
    com.tencent.mm.plugin.m.a.a.a.a.djQ().g(locald.vBY, "notifyKeyboardChanged", ae.a(new o[] { d.u.S("shown", Boolean.valueOf(paramBoolean)), d.u.S("height", Integer.valueOf(i)) }));
    AppMethodBeat.o(123803);
  }
  
  public final void gB(int paramInt)
  {
    this.nGK = paramInt;
  }
  
  public final int getHeight()
  {
    return this.nGK;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "", "generateInputEventData", "", "id", "", "hideKeyboard", "", "inputLocationChange", "offset", "inputOnKeyboardValueChange", "detail", "", "onEvent", "eventName", "", "onRenderCallback", "setCanOverScroll", "enable", "", "showPicker", "luggage-native-view_release"})
  public static abstract interface a$a
  {
    public abstract void IV(int paramInt);
    
    public abstract String JB(int paramInt);
    
    public abstract void aj(Map<String, ?> paramMap);
    
    public abstract void ak(Map<String, ?> paramMap);
    
    public abstract void c(int paramInt, String paramString, Map<String, Float> paramMap);
    
    public abstract void dfJ();
    
    public abstract void djL();
    
    public abstract void oh(boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<String>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a
 * JD-Core Version:    0.7.0.1
 */