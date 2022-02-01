package com.tencent.mm.plugin.m.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import d.a.ae;
import d.f;
import d.g;
import d.g.b.w;
import d.o;
import io.flutter.a.a.k.c;
import io.flutter.a.a.m;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "activity", "Landroid/app/Activity;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "entryPoint", "", "channelName", "(Landroid/app/Activity;Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Ljava/lang/String;Ljava/lang/String;)V", "firstFrameRendered", "", "foregroundCnt", "", "keyboardHeight", "keyboardShown", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mRoute", "getMRoute", "()Ljava/lang/String;", "mRoute$delegate", "Lkotlin/Lazy;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "wxaChannelService", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/WxaChannelService;", "createRenderView", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "view", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "pageViewId", "", "renderPtr", "pagePath", "container", "Landroid/view/ViewGroup;", "eventHandler", "Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "ensureFlutterReady", "Lio/flutter/embedding/engine/FlutterEngine;", "getHeight", "getNecessaryResource", "Ljava/util/HashMap;", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "initChannel", "", "bm", "Lio/flutter/plugin/common/BinaryMessenger;", "notifyKeyboardChanged", "onBackground", "onDestroy", "onDestroyView", "onForeground", "parent", "onKeyboardStateChanged", "shown", "onPrepareDone", "pickerSelectCallback", "id", "ok", "data", "refreshHeight", "height", "scrollToTop", "Companion", "luggage-native-view_release"})
public class a
  implements u.c
{
  private static Map<Integer, a.a> tre;
  public static final a.a trf;
  private final Activity activity;
  private com.tencent.mm.plugin.appbrand.widget.input.u cgS;
  public final com.tencent.luggage.sdk.d.c kTU;
  private int mEi;
  private boolean tqW;
  private int tqX;
  private boolean tqY;
  public d tqZ;
  public com.tencent.mm.plugin.m.a.a.b.b tra;
  private final f trb;
  private final String trc;
  private final String trd;
  
  static
  {
    AppMethodBeat.i(123796);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(a.class), "mRoute", "getMRoute()Ljava/lang/String;")) };
    trf = new a.a((byte)0);
    tre = (Map)new LinkedHashMap();
    AppMethodBeat.o(123796);
  }
  
  public a(Activity paramActivity, com.tencent.luggage.sdk.d.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123804);
    this.activity = paramActivity;
    this.kTU = paramc;
    this.trc = paramString1;
    this.trd = paramString2;
    this.tqZ = new d(this.trd);
    this.tra = new com.tencent.mm.plugin.m.a.a.b.b(this.tqZ);
    this.trb = g.E((d.g.a.a)new d(this));
    cMT().fuC().aPN(cMS());
    AppMethodBeat.o(123804);
  }
  
  public static void b(com.tencent.mm.plugin.m.a.a.b.a parama)
  {
    AppMethodBeat.i(123802);
    d.g.b.k.h(parama, "view");
    tre.remove(Integer.valueOf((int)parama.getViewId()));
    AppMethodBeat.o(123802);
  }
  
  private final String cMS()
  {
    AppMethodBeat.i(123797);
    String str = (String)this.trb.getValue();
    AppMethodBeat.o(123797);
    return str;
  }
  
  private final io.flutter.embedding.engine.a cMT()
  {
    AppMethodBeat.i(123799);
    Object localObject1 = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.afB("init_flutter_start");
    localObject1 = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("ui_create", "init_flutter_start");
    FlutterMain.startInitialization(aj.getContext());
    FlutterMain.ensureInitializationComplete(aj.getContext(), new String[0]);
    localObject1 = c.trh.fs((Context)this.activity);
    Object localObject2 = new com.tencent.mm.b((io.flutter.embedding.engine.a)localObject1, (Context)this.activity);
    ((io.flutter.embedding.engine.a)localObject1).fuC().setInitialRoute(cMS());
    Object localObject4 = (io.flutter.a.a.c)((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
    Object localObject3 = com.tencent.mm.plugin.m.a.a.a.a.tro;
    if (com.tencent.mm.plugin.m.a.a.a.a.cMW().trm == null)
    {
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.tro;
      localObject3 = com.tencent.mm.plugin.m.a.a.a.a.cMW();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).trm = ((io.flutter.a.a.c)localObject4);
      localObject4 = ((Iterable)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).trj).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        if (((com.tencent.mm.plugin.m.a.a.a.a)localObject3).trm != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).afA((String)localObject5);
        }
        localObject6 = (k.c)((com.tencent.mm.plugin.m.a.a.a.a)localObject3).trk.get(localObject5);
        if (localObject6 != null) {
          ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).a((String)localObject5, (k.c)localObject6);
        }
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).trk.clear();
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject3).trj.clear();
    }
    localObject3 = this.tqZ;
    Object localObject5 = this.kTU;
    localObject4 = this.tra;
    d.g.b.k.h(localObject4, "renderViewManager");
    ((d)localObject3).kTU = ((com.tencent.luggage.sdk.d.c)localObject5);
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.tro;
    localObject5 = com.tencent.mm.plugin.m.a.a.a.a.cMW();
    Object localObject6 = ((d)localObject3).trd;
    d.g.b.k.h(localObject6, "name");
    if ((com.tencent.mm.plugin.m.a.a.a.a.d)((com.tencent.mm.plugin.m.a.a.a.a)localObject5).tri.get(localObject6) == null)
    {
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).trm != null) {
        break label564;
      }
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).trj.add(localObject6);
    }
    for (;;)
    {
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.tro;
      localObject5 = com.tencent.mm.plugin.m.a.a.a.a.cMW();
      localObject6 = ((d)localObject3).trd;
      k.c localc = ((d)localObject3).trp;
      d.g.b.k.h(localObject6, "name");
      d.g.b.k.h(localc, "handler");
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).a((String)localObject6, localc);
      if (((com.tencent.mm.plugin.m.a.a.a.a)localObject5).trj.contains(localObject6)) {
        ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).trk.put(localObject6, localc);
      }
      ((d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.b((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      ((d)localObject3).a((com.tencent.mm.plugin.m.a.a.a.a.a)new com.tencent.mm.plugin.m.a.a.a.a.c((com.tencent.mm.plugin.m.a.a.b.b)localObject4));
      localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
      d.g.b.k.g(localObject3, "flutterEngine.dartExecutor");
      if (!((DartExecutor)localObject3).fuQ())
      {
        localObject3 = ((io.flutter.embedding.engine.a)localObject1).getDartExecutor();
        this.activity.getAssets();
        localObject4 = FlutterMain.findAppBundlePath(aj.getContext());
        if (localObject4 == null) {
          d.g.b.k.fvU();
        }
        ((DartExecutor)localObject3).a(new DartExecutor.a((String)localObject4, "main", (byte)0));
        ((io.flutter.embedding.engine.a)localObject1).fuA().addOnFirstFrameRenderedListener((io.flutter.embedding.engine.b.b)new b(this));
        aq.n((Runnable)new c(this), 10000L);
      }
      io.flutter.b.a.registerWith((m)localObject2);
      localObject2 = com.tencent.mm.plugin.m.a.c.c.tsc;
      com.tencent.mm.plugin.m.a.c.c.afB("init_flutter_end");
      localObject2 = com.tencent.mm.plugin.m.a.c.c.tsc;
      com.tencent.mm.plugin.m.a.c.c.hi("init_flutter_start", "init_flutter_end");
      AppMethodBeat.o(123799);
      return localObject1;
      label564:
      ((com.tencent.mm.plugin.m.a.a.a.a)localObject5).afA((String)localObject6);
    }
  }
  
  public final com.tencent.mm.plugin.m.a.a.b.a a(bd parambd, long paramLong1, long paramLong2, Activity paramActivity, String paramString, ViewGroup paramViewGroup, a.a parama)
  {
    AppMethodBeat.i(123798);
    d.g.b.k.h(paramActivity, "activity");
    d.g.b.k.h(paramString, "pagePath");
    d.g.b.k.h(paramViewGroup, "container");
    d.g.b.k.h(parama, "eventHandler");
    tre.put(Integer.valueOf((int)paramLong1), parama);
    this.tra.a((b)c.trh);
    paramActivity = this.tra.b(paramLong1, (Context)paramActivity);
    paramActivity.setWxaWebView(parambd);
    parama = new HashMap();
    if (-1 == d.n.n.e((CharSequence)paramString, "/"))
    {
      ((Map)parama).put("workDir", paramString);
      ((Map)parama).put("renderPtr", Long.valueOf(paramLong2));
      this.tra.a(paramActivity, parama);
      com.tencent.mm.plugin.m.a.a.b.b.a(this.tra, paramActivity, paramViewGroup);
      AppMethodBeat.o(123798);
      return paramActivity;
    }
    Map localMap = (Map)parama;
    parambd = paramString.subSequence(0, d.n.n.e((CharSequence)paramString, "/"));
    if (d.n.n.e(parambd, (CharSequence)"/")) {}
    for (;;)
    {
      localMap.put("workDir", parambd);
      break;
      parambd = (CharSequence)("/" + parambd);
    }
  }
  
  public final void a(com.tencent.mm.plugin.m.a.a.b.a parama)
  {
    AppMethodBeat.i(123801);
    d.g.b.k.h(parama, "view");
    this.tqX -= 1;
    this.tra.a(parama);
    if (this.tqX <= 0)
    {
      parama = this.cgS;
      if (parama != null)
      {
        parama.b((u.c)this);
        AppMethodBeat.o(123801);
        return;
      }
    }
    AppMethodBeat.o(123801);
  }
  
  public final void a(com.tencent.mm.plugin.m.a.a.b.a parama, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123800);
    d.g.b.k.h(parama, "view");
    d.g.b.k.h(paramViewGroup, "parent");
    this.tqX += 1;
    this.tra.a(parama, paramViewGroup);
    this.cgS = com.tencent.mm.plugin.appbrand.widget.input.n.db((View)paramViewGroup);
    parama = this.cgS;
    if (parama != null)
    {
      parama.a((u.c)this);
      AppMethodBeat.o(123800);
      return;
    }
    AppMethodBeat.o(123800);
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(123803);
    this.tqW = paramBoolean;
    d locald = this.tqZ;
    paramBoolean = this.tqW;
    int i = this.mEi;
    com.tencent.mm.plugin.m.a.a.a.a.b localb = com.tencent.mm.plugin.m.a.a.a.a.tro;
    com.tencent.mm.plugin.m.a.a.a.a.cMW().f(locald.trd, "notifyKeyboardChanged", ae.a(new o[] { d.u.P("shown", Boolean.valueOf(paramBoolean)), d.u.P("height", Integer.valueOf(i)) }));
    AppMethodBeat.o(123803);
  }
  
  public final void gM(int paramInt)
  {
    this.mEi = paramInt;
  }
  
  public int getHeight()
  {
    return this.mEi;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/luggage/natives/flutter/FlutterRenderEngine$Companion$EventHandler;", "", "generateInputEventData", "", "id", "", "hideKeyboard", "", "inputLocationChange", "offset", "inputOnKeyboardValueChange", "detail", "", "onEvent", "eventName", "", "onRenderCallback", "setCanOverScroll", "enable", "", "showPicker", "luggage-native-view_release"})
  public static abstract interface a$a
  {
    public abstract String FD(int paramInt);
    
    public abstract void FE(int paramInt);
    
    public abstract void ac(Map<String, ?> paramMap);
    
    public abstract void ad(Map<String, ?> paramMap);
    
    public abstract void b(int paramInt, String paramString, Map<String, Float> paramMap);
    
    public abstract void cJe();
    
    public abstract void cJf();
    
    public abstract void mG(boolean paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onFirstFrameRendered"})
  static final class b
    implements io.flutter.embedding.engine.b.b
  {
    b(a parama) {}
    
    public final void onFirstFrameRendered()
    {
      AppMethodBeat.i(123793);
      ad.i("FlutterRenderEngine", "onFirstFrameRendered");
      a.b(this.trg);
      AppMethodBeat.o(123793);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(123794);
      if (!a.a(this.trg))
      {
        ad.i("FlutterRenderEngine", "Delayed 10s not render first frame !");
        h.vKh.a(18090, "FlutterRenderEngine", true, true);
        ad.eFx();
        Process.killProcess(Process.myPid());
      }
      AppMethodBeat.o(123794);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a
 * JD-Core Version:    0.7.0.1
 */