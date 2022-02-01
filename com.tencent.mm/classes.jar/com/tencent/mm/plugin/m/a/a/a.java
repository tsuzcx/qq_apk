package com.tencent.mm.plugin.m.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import com.tencent.mm.sdk.platformtools.ai;
import d.a.ae;
import d.f;
import d.g;
import d.g.b.w;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "activity", "Landroid/app/Activity;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "entryPoint", "", "channelName", "(Landroid/app/Activity;Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Ljava/lang/String;Ljava/lang/String;)V", "firstFrameRendered", "", "foregroundCnt", "", "keyboardHeight", "keyboardShown", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mRoute", "getMRoute", "()Ljava/lang/String;", "mRoute$delegate", "Lkotlin/Lazy;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "wxaChannelService", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "createRenderView", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "view", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "pageViewId", "", "renderPtr", "pagePath", "container", "Landroid/view/ViewGroup;", "eventHandler", "Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "ensureFlutterReady", "Lio/flutter/embedding/engine/FlutterEngine;", "getHeight", "getNecessaryResource", "Ljava/util/HashMap;", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "initChannel", "", "bm", "Lio/flutter/plugin/common/BinaryMessenger;", "notifyKeyboardChanged", "onBackground", "onDestroy", "onDestroyView", "onForeground", "parent", "onKeyboardStateChanged", "shown", "onPrepareDone", "pickerSelectCallback", "id", "ok", "data", "refreshHeight", "height", "scrollToTop", "Companion", "luggage-native-view_release"})
public class a
  implements u.c
{
  public static Map<Integer, a.a.a> uzw;
  public static final a uzx;
  private final Activity activity;
  public com.tencent.mm.plugin.appbrand.widget.input.u cdO;
  public final com.tencent.luggage.sdk.d.c lvz;
  private int ngo;
  private boolean uzp;
  public int uzq;
  public d uzr;
  public com.tencent.mm.plugin.m.a.a.b.b uzs;
  private final f uzt;
  private final String uzu;
  private final String uzv;
  
  static
  {
    AppMethodBeat.i(123796);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(a.class), "mRoute", "getMRoute()Ljava/lang/String;")) };
    uzx = new a((byte)0);
    uzw = (Map)new LinkedHashMap();
    AppMethodBeat.o(123796);
  }
  
  public a(Activity paramActivity, com.tencent.luggage.sdk.d.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123804);
    this.activity = paramActivity;
    this.lvz = paramc;
    this.uzu = paramString1;
    this.uzv = paramString2;
    this.uzr = new d(this.uzv);
    this.uzs = new com.tencent.mm.plugin.m.a.a.b.b(this.uzr);
    this.uzt = g.K((d.g.a.a)new b(this));
    daA().fNc().aVL(daz());
    AppMethodBeat.o(123804);
  }
  
  public static void a(com.tencent.mm.plugin.m.a.a.b.a parama)
  {
    AppMethodBeat.i(123802);
    d.g.b.k.h(parama, "view");
    uzw.remove(Integer.valueOf((int)parama.getViewId()));
    AppMethodBeat.o(123802);
  }
  
  private final io.flutter.embedding.engine.a daA()
  {
    AppMethodBeat.i(123799);
    Object localObject1 = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.akv("init_flutter_start");
    localObject1 = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("ui_create", "init_flutter_start");
    FlutterMain.startInitialization(ai.getContext());
    FlutterMain.ensureInitializationComplete(ai.getContext(), new String[0]);
    localObject1 = c.uzz.fE((Context)this.activity);
    Object localObject2 = new com.tencent.mm.b((io.flutter.embedding.engine.a)localObject1, (Context)this.activity);
    ((io.flutter.embedding.engine.a)localObject1).fNc().setInitialRoute(daz());
    Object localObject4 = (io.flutter.plugin.a.c)((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
    Object localObject3 = com.tencent.mm.plugin.m.a.a.a.a.uzG;
    if (com.tencent.mm.plugin.m.a.a.a.a.daD().uzE == null)
    {
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.uzG;
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.daD();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).uzE = ((io.flutter.plugin.a.c)localObject4);
      localObject4 = ((Iterable)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).uzB).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.m.a.a.a.a)localObject3).uzE != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).aku((String)localObject5);
        }
        localObject6 = (k.c)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).uzC.get(localObject5);
        if (localObject6 != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).a((String)localObject5, (k.c)localObject6);
        }
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).uzC.clear();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).uzB.clear();
    }
    localObject3 = this.uzr;
    Object localObject5 = this.lvz;
    localObject4 = this.uzs;
    d.g.b.k.h(localObject4, "renderViewManager");
    ((d)localObject3).lvz = ((com.tencent.luggage.sdk.d.c)localObject5);
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.uzG;
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.daD();
    Object localObject6 = ((d)localObject3).uzv;
    d.g.b.k.h(localObject6, "name");
    if ((a.d)((com.tencent.mm.plugin.m.a.a.a.a)localObject5).uzA.get(localObject6) == null)
    {
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).uzE != null) {
        break label529;
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).uzB.add(localObject6);
    }
    for (;;)
    {
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.uzG;
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.daD();
      localObject6 = ((d)localObject3).uzv;
      k.c localc = ((d)localObject3).uzH;
      d.g.b.k.h(localObject6, "name");
      d.g.b.k.h(localc, "handler");
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).a((String)localObject6, localc);
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).uzB.contains(localObject6)) {
        ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).uzC.put(localObject6, localc);
      }
      ((d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.b((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      ((d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.c((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
      d.g.b.k.g(localObject3, "flutterEngine.dartExecutor");
      if (!((DartExecutor)localObject3).fNq())
      {
        localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
        this.activity.getAssets();
        localObject4 = FlutterMain.findAppBundlePath(ai.getContext());
        if (localObject4 == null) {
          d.g.b.k.fOy();
        }
        ((DartExecutor)localObject3).a(new DartExecutor.a((String)localObject4, "main", (byte)0));
      }
      io.flutter.a.a.registerWith((m)localObject2);
      localObject2 = com.tencent.mm.plugin.m.a.c.c.uAv;
      com.tencent.mm.plugin.m.a.c.c.akv("init_flutter_end");
      localObject2 = com.tencent.mm.plugin.m.a.c.c.uAv;
      com.tencent.mm.plugin.m.a.c.c.hB("init_flutter_start", "init_flutter_end");
      AppMethodBeat.o(123799);
      return localObject1;
      label529:
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).aku((String)localObject6);
    }
  }
  
  private final String daz()
  {
    AppMethodBeat.i(123797);
    String str = (String)this.uzt.getValue();
    AppMethodBeat.o(123797);
    return str;
  }
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(123803);
    this.uzp = paramBoolean;
    d locald = this.uzr;
    paramBoolean = this.uzp;
    int i = this.ngo;
    com.tencent.mm.plugin.m.a.a.a.a.b localb = com.tencent.mm.plugin.m.a.a.a.a.uzG;
    com.tencent.mm.plugin.m.a.a.a.a.daD().f(locald.uzv, "notifyKeyboardChanged", ae.a(new o[] { d.u.Q("shown", Boolean.valueOf(paramBoolean)), d.u.Q("height", Integer.valueOf(i)) }));
    AppMethodBeat.o(123803);
  }
  
  public int getHeight()
  {
    return this.ngo;
  }
  
  public final void gw(int paramInt)
  {
    this.ngo = paramInt;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion;", "", "()V", "TAG", "", "eventHandlers", "", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "getEventHandlers", "()Ljava/util/Map;", "setEventHandlers", "(Ljava/util/Map;)V", "EventHandler", "luggage-native-view_release"})
  public static final class a
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "", "generateInputEventData", "", "id", "", "hideKeyboard", "", "inputLocationChange", "offset", "inputOnKeyboardValueChange", "detail", "", "onEvent", "eventName", "", "onRenderCallback", "setCanOverScroll", "enable", "", "showPicker", "luggage-native-view_release"})
    public static abstract interface a
    {
      public abstract void Hz(int paramInt);
      
      public abstract String If(int paramInt);
      
      public abstract void ae(Map<String, ?> paramMap);
      
      public abstract void af(Map<String, ?> paramMap);
      
      public abstract void b(int paramInt, String paramString, Map<String, Float> paramMap);
      
      public abstract void cWx();
      
      public abstract void day();
      
      public abstract void nN(boolean paramBoolean);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a
 * JD-Core Version:    0.7.0.1
 */