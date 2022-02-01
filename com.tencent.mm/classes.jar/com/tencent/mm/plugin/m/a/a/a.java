package com.tencent.mm.plugin.m.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import com.tencent.mm.sdk.platformtools.ak;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "activity", "Landroid/app/Activity;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "entryPoint", "", "channelName", "(Landroid/app/Activity;Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Ljava/lang/String;Ljava/lang/String;)V", "firstFrameRendered", "", "foregroundCnt", "", "keyboardHeight", "keyboardShown", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mRoute", "getMRoute", "()Ljava/lang/String;", "mRoute$delegate", "Lkotlin/Lazy;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "wxaChannelService", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "createRenderView", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "view", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "pageViewId", "", "renderPtr", "pagePath", "container", "Landroid/view/ViewGroup;", "eventHandler", "Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "ensureFlutterReady", "Lio/flutter/embedding/engine/FlutterEngine;", "getHeight", "getNecessaryResource", "Ljava/util/HashMap;", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "initChannel", "", "bm", "Lio/flutter/plugin/common/BinaryMessenger;", "notifyKeyboardChanged", "onBackground", "onDestroy", "onDestroyView", "onForeground", "parent", "onKeyboardStateChanged", "shown", "onPrepareDone", "pickerSelectCallback", "id", "ok", "data", "refreshHeight", "height", "scrollToTop", "Companion", "luggage-native-view_release"})
public final class a
  implements u.c
{
  public static Map<Integer, a.a> vOd;
  public static final a.a vOe;
  private final Activity activity;
  public com.tencent.mm.plugin.appbrand.widget.input.u cog;
  public final com.tencent.luggage.sdk.d.d lZl;
  private int nMm;
  private boolean vNW;
  public int vNX;
  public com.tencent.mm.plugin.m.a.a.a.a.d vNY;
  public com.tencent.mm.plugin.m.a.a.b.b vNZ;
  private final f vOa;
  private final String vOb;
  private final String vOc;
  
  static
  {
    AppMethodBeat.i(123796);
    vOe = new a.a((byte)0);
    vOd = (Map)new LinkedHashMap();
    AppMethodBeat.o(123796);
  }
  
  public a(Activity paramActivity, com.tencent.luggage.sdk.d.d paramd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123804);
    this.activity = paramActivity;
    this.lZl = paramd;
    this.vOb = paramString1;
    this.vOc = paramString2;
    this.vNY = new com.tencent.mm.plugin.m.a.a.a.a.d(this.vOc);
    this.vNZ = new com.tencent.mm.plugin.m.a.a.b.b(this.vNY);
    this.vOa = g.O((d.g.a.a)new b(this));
    dmM().gje().bds(dmL());
    AppMethodBeat.o(123804);
  }
  
  public static void a(com.tencent.mm.plugin.m.a.a.b.a parama)
  {
    AppMethodBeat.i(123802);
    p.h(parama, "view");
    vOd.remove(Integer.valueOf((int)parama.getViewId()));
    AppMethodBeat.o(123802);
  }
  
  private final String dmL()
  {
    AppMethodBeat.i(123797);
    String str = (String)this.vOa.getValue();
    AppMethodBeat.o(123797);
    return str;
  }
  
  private final io.flutter.embedding.engine.a dmM()
  {
    AppMethodBeat.i(123799);
    Object localObject1 = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.aqn("init_flutter_start");
    localObject1 = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("ui_create", "init_flutter_start");
    FlutterMain.startInitialization(ak.getContext());
    FlutterMain.ensureInitializationComplete(ak.getContext(), new String[0]);
    localObject1 = c.vOg.fP((Context)this.activity);
    Object localObject2 = new com.tencent.mm.b((io.flutter.embedding.engine.a)localObject1, (Context)this.activity);
    ((io.flutter.embedding.engine.a)localObject1).gje().setInitialRoute(dmL());
    Object localObject4 = (io.flutter.plugin.a.c)((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
    Object localObject3 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
    if (com.tencent.mm.plugin.m.a.a.a.a.dmP().vOl == null)
    {
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.dmP();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vOl = ((io.flutter.plugin.a.c)localObject4);
      localObject4 = ((Iterable)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vOi).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vOl != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).aqm((String)localObject5);
        }
        localObject6 = (k.c)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vOj.get(localObject5);
        if (localObject6 != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).a((String)localObject5, (k.c)localObject6);
        }
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vOj.clear();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).vOi.clear();
    }
    localObject3 = this.vNY;
    Object localObject5 = this.lZl;
    localObject4 = this.vNZ;
    p.h(localObject4, "renderViewManager");
    ((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).lZl = ((com.tencent.luggage.sdk.d.d)localObject5);
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.dmP();
    Object localObject6 = ((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).vOc;
    p.h(localObject6, "name");
    if ((a.d)((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vOh.get(localObject6) == null)
    {
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vOl != null) {
        break label529;
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vOi.add(localObject6);
    }
    for (;;)
    {
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.dmP();
      localObject6 = ((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).vOc;
      k.c localc = ((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).vOo;
      p.h(localObject6, "name");
      p.h(localc, "handler");
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).a((String)localObject6, localc);
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vOi.contains(localObject6)) {
        ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).vOj.put(localObject6, localc);
      }
      ((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.b((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      ((com.tencent.mm.plugin.m.a.a.a.a.d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.c((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
      p.g(localObject3, "flutterEngine.dartExecutor");
      if (!((DartExecutor)localObject3).gjr())
      {
        localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
        this.activity.getAssets();
        localObject4 = FlutterMain.findAppBundlePath(ak.getContext());
        if (localObject4 == null) {
          p.gkB();
        }
        ((DartExecutor)localObject3).a(new DartExecutor.a((String)localObject4, "main", (byte)0));
      }
      io.flutter.a.a.registerWith((m)localObject2);
      localObject2 = com.tencent.mm.plugin.m.a.c.c.vPc;
      com.tencent.mm.plugin.m.a.c.c.aqn("init_flutter_end");
      localObject2 = com.tencent.mm.plugin.m.a.c.c.vPc;
      com.tencent.mm.plugin.m.a.c.c.hU("init_flutter_start", "init_flutter_end");
      AppMethodBeat.o(123799);
      return localObject1;
      label529:
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).aqm((String)localObject6);
    }
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(123803);
    this.vNW = paramBoolean;
    com.tencent.mm.plugin.m.a.a.a.a.d locald = this.vNY;
    paramBoolean = this.vNW;
    int i = this.nMm;
    com.tencent.mm.plugin.m.a.a.a.a.b localb = com.tencent.mm.plugin.m.a.a.a.a.vOn;
    com.tencent.mm.plugin.m.a.a.a.a.dmP().g(locald.vOc, "notifyKeyboardChanged", ae.a(new o[] { d.u.R("shown", Boolean.valueOf(paramBoolean)), d.u.R("height", Integer.valueOf(i)) }));
    AppMethodBeat.o(123803);
  }
  
  public final void gB(int paramInt)
  {
    this.nMm = paramInt;
  }
  
  public final int getHeight()
  {
    return this.nMm;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "", "generateInputEventData", "", "id", "", "hideKeyboard", "", "inputLocationChange", "offset", "inputOnKeyboardValueChange", "detail", "", "onEvent", "eventName", "", "onRenderCallback", "setCanOverScroll", "enable", "", "showPicker", "luggage-native-view_release"})
  public static abstract interface a$a
  {
    public abstract void Jt(int paramInt);
    
    public abstract String Ka(int paramInt);
    
    public abstract void ap(Map<String, ?> paramMap);
    
    public abstract void aq(Map<String, ?> paramMap);
    
    public abstract void c(int paramInt, String paramString, Map<String, Float> paramMap);
    
    public abstract void diG();
    
    public abstract void dmK();
    
    public abstract void om(boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a
 * JD-Core Version:    0.7.0.1
 */