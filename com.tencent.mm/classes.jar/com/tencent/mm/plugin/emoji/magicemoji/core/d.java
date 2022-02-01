package com.tencent.mm.plugin.emoji.magicemoji.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.tencent.magicbrush.a.b.a;
import com.tencent.magicbrush.g.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.ad;
import com.tencent.mm.plugin.appbrand.n.af;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.x;
import com.tencent.mm.plugin.emoji.magicemoji.c.b.b.b;
import com.tencent.mm.plugin.emoji.magicemoji.c.b.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "meContext", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;", "(Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;)V", "isRunning", "", "mCommonBinding", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandCommonBinding;", "magicBrushInstaller", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "getMeContext", "()Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiServiceContextBase;", "profiler", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiProfiler;", "getProfiler", "()Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiProfiler;", "profiler$delegate", "Lkotlin/Lazy;", "callInJsThreadOrReturn", "", "r", "Lkotlin/Function0;", "ignorePause", "(Lkotlin/jvm/functions/Function0;Z)Lkotlin/Unit;", "createJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "createJsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "destroy", "evaluateJavaScript", "script", "cb", "Landroid/webkit/ValueCallback;", "generateWxConfig", "getAppId", "getAppState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "getContext", "Landroid/content/Context;", "getFileSystem", "Lcom/tencent/mm/plugin/emoji/magicemoji/fs/MagicEmojiFileSystem;", "getJsThreadHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "getWasmOptState", "", "init", "injectCommonLib", "injectWxConfig", "installMagicBrush", "onMessageCome", "type", "msg", "onRuntimeReady", "pause", "postJsRuntimeCreated", "provideCommonBindingParams", "Lcom/tencent/mm/appbrand/commonjni/AppBrandCommonBindingJniParams;", "provideMagicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "resume", "triggerClearScreen", "triggerResizeWindow", "width", "height", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.g
{
  public static final d.a xIG;
  private static final byte[] xIJ;
  private boolean Uz;
  private final com.tencent.luggage.sdk.b.a.d.a esO;
  public final MagicEmojiServiceContextBase xIC;
  private com.tencent.luggage.game.a.d xIH;
  private final j xII;
  
  static
  {
    AppMethodBeat.i(270120);
    xIG = new d.a((byte)0);
    com.tencent.mm.plugin.appbrand.n.w.czm();
    byte[] arrayOfByte;
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMn, false)) {
      arrayOfByte = null;
    }
    for (;;)
    {
      xIJ = arrayOfByte;
      AppMethodBeat.o(270120);
      return;
      if (com.tencent.mm.compatible.deviceinfo.q.awm()) {
        arrayOfByte = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot64.bin");
      } else {
        arrayOfByte = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot.bin");
      }
    }
  }
  
  public d(MagicEmojiServiceContextBase paramMagicEmojiServiceContextBase)
  {
    AppMethodBeat.i(270062);
    this.xIC = paramMagicEmojiServiceContextBase;
    this.Uz = true;
    this.esO = new com.tencent.luggage.sdk.b.a.d.a((com.tencent.mm.appbrand.commonjni.a.a.a)new e(this));
    this.xII = k.cm((kotlin.g.a.a)new j(this));
    AppMethodBeat.o(270062);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(270105);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.esO.esf.notifyDestroy();
    AppMethodBeat.o(270105);
  }
  
  private final ah aI(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(270069);
    Object localObject = getJsRuntime();
    if (localObject == null)
    {
      AppMethodBeat.o(270069);
      return null;
    }
    localObject = (com.tencent.mm.plugin.appbrand.n.q)((i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
    if (localObject == null)
    {
      AppMethodBeat.o(270069);
      return null;
    }
    ((com.tencent.mm.plugin.appbrand.n.q)localObject).a(new d..ExternalSyntheticLambda4(parama), false);
    parama = ah.aiuX;
    AppMethodBeat.o(270069);
    return parama;
  }
  
  private static final void aJ(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(270087);
    kotlin.g.b.s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(270087);
  }
  
  private static final void anS(String paramString)
  {
    AppMethodBeat.i(270094);
    Log.d("MicroMsg.MagicEmojiService", kotlin.g.b.s.X("stevecai: common lib inject ok with ", paramString));
    AppMethodBeat.o(270094);
  }
  
  private static final void anT(String paramString)
  {
    AppMethodBeat.i(270098);
    Log.i("MicroMsg.MagicEmojiService", "stevecai: onRuntimeReady: inject game script ok");
    AppMethodBeat.o(270098);
  }
  
  private static final void gI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(270082);
    paramString1 = "stevecai: js exception: " + paramString1 + ", " + paramString2;
    Log.w("MicroMsg.MagicEmojiService", paramString1);
    paramString2 = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
    com.tencent.mm.plugin.emoji.magicemoji.d.e.aoa(paramString1);
    AppMethodBeat.o(270082);
  }
  
  public final void aEr()
  {
    Object localObject1 = null;
    AppMethodBeat.i(270258);
    com.tencent.mm.plugin.emoji.magicemoji.b.b localb = this.xIC.dyP();
    Object localObject2 = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
    localObject2 = com.tencent.mm.plugin.emoji.magicemoji.d.e.a((com.tencent.mm.plugin.appbrand.appstorage.w)localb, "/game.js");
    aI((kotlin.g.a.a)new f(this));
    String str = n.bV("/game.js", "/", "") + '_' + getAppId();
    ((i)getJsRuntime().Z(i.class)).a(null, str, this.xIC.dyS(), 0, (String)localObject2, d..ExternalSyntheticLambda1.INSTANCE);
    localObject2 = this.xIH;
    if (localObject2 == null) {
      kotlin.g.b.s.bIx("magicBrushInstaller");
    }
    for (;;)
    {
      localObject1.getMagicBrush().avq().addImageStreamFetcher((com.github.henryye.nativeiv.b.b)new com.tencent.luggage.game.b.a.a((com.tencent.luggage.game.b.a.d.b)new g(localb, this)), true);
      AppMethodBeat.o(270258);
      return;
      localObject1 = localObject2;
    }
  }
  
  public final Map<String, p> arA()
  {
    AppMethodBeat.i(270165);
    Object localObject = com.tencent.mm.plugin.emoji.magicemoji.c.b.xJb;
    localObject = com.tencent.mm.plugin.emoji.magicemoji.c.b.anV(this.xIC.appId);
    AppMethodBeat.o(270165);
    return localObject;
  }
  
  public final void ary()
  {
    AppMethodBeat.i(270205);
    Log.d("MicroMsg.MagicEmojiService", "stevecai: postJsRuntimeCreated() called");
    Object localObject2 = this.esO.esf;
    AppBrandCommonBindingJniParams localAppBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
    localAppBrandCommonBindingJniParams.wasmCachePath = af.cpf();
    if (!TextUtils.isEmpty((CharSequence)localAppBrandCommonBindingJniParams.wasmCachePath)) {
      localAppBrandCommonBindingJniParams.wasmCachePath = com.tencent.mm.vfs.y.n(localAppBrandCommonBindingJniParams.wasmCachePath, true);
    }
    int i;
    Object localObject1;
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrand_wasm_opt", -2);
      if (i != -2) {
        if (i != 0)
        {
          localObject1 = "enable";
          Log.i("MicroMsg.MagicEmojiService", "stevecai: wasm opt force %s by cmd", new Object[] { localObject1 });
        }
      }
    }
    for (;;)
    {
      localAppBrandCommonBindingJniParams.wasmOptState = i;
      ((AppBrandCommonBindingJni)localObject2).notifyCreate(localAppBrandCommonBindingJniParams);
      aI((kotlin.g.a.a)new i(this));
      Log.i("MicroMsg.MagicEmojiService", "stevecai: installMagicBrush() called");
      com.tencent.magicbrush.a.b.a((b.a)new d.b());
      com.tencent.magicbrush.a.b.loadLibraries();
      new d.c().aoW();
      this.xIH = ((com.tencent.luggage.game.a.d)new d(this, getContext(), getJsRuntime()));
      localObject2 = this.xIH;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("magicBrushInstaller");
        localObject1 = null;
      }
      ((com.tencent.luggage.game.a.d)localObject1).aoP();
      AppMethodBeat.o(270205);
      return;
      localObject1 = "disable";
      break;
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRW, -2);
      if (i != -2)
      {
        if (i != 0) {}
        for (localObject1 = "enable";; localObject1 = "disable")
        {
          Log.i("MicroMsg.MagicEmojiService", "stevecai: wasm opt force %s by abtest", new Object[] { localObject1 });
          break;
        }
      }
      i = -2;
    }
  }
  
  public final i arz()
  {
    AppMethodBeat.i(270192);
    Log.i("MicroMsg.MagicEmojiService", "stevecai: createJsRuntime() called");
    Object localObject = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject).hmb = ad.cpf();
    ((IJSRuntime.Config)localObject).hmc = xIJ;
    ((IJSRuntime.Config)localObject).hmd = "1";
    ((IJSRuntime.Config)localObject).hme = true;
    ((IJSRuntime.Config)localObject).hmg = true;
    ((IJSRuntime.Config)localObject).hmh = false;
    ((IJSRuntime.Config)localObject).hmj = "RuntimeME";
    ((IJSRuntime.Config)localObject).hml = new WeakReference(this);
    Log.d("MicroMsg.MagicEmojiService", "stevecai: test config instance is %d", new Object[] { Integer.valueOf(((IJSRuntime.Config)localObject).hashCode()) });
    localObject = new x((IJSRuntime.Config)localObject);
    ((x)localObject).setJsExceptionHandler(d..ExternalSyntheticLambda2.INSTANCE);
    localObject = (i)localObject;
    AppMethodBeat.o(270192);
    return localObject;
  }
  
  public final void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(270266);
    kotlin.g.b.s.u(paramString, "msg");
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.MagicEmojiService", kotlin.g.b.s.X("stevecai: unknown message type ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(270266);
      return;
    case 4096: 
      com.tencent.mm.plugin.emoji.magicemoji.c.b.a locala = new com.tencent.mm.plugin.emoji.magicemoji.c.b.a();
      com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this;
      kotlin.g.b.s.u(localf, "component");
      kotlin.g.b.s.u(paramString, "data");
      locala.h(localf).ZQ(paramString).cpV();
      AppMethodBeat.o(270266);
      return;
    case 4097: 
      cJ("UnityEvent", paramString);
      AppMethodBeat.o(270266);
      return;
    }
    ((com.tencent.mm.plugin.emoji.magicemoji.d.c)this.xII.getValue()).anZ(paramString);
    AppMethodBeat.o(270266);
  }
  
  public final void c(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(270223);
    kotlin.g.b.s.u(paramString, "script");
    getJsRuntime().evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(270223);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(270288);
    Log.i("MicroMsg.MagicEmojiService", "stevecai: destroy service");
    com.tencent.luggage.game.a.d locald = this.xIH;
    Object localObject = locald;
    if (locald == null)
    {
      kotlin.g.b.s.bIx("magicBrushInstaller");
      localObject = null;
    }
    ((com.tencent.luggage.game.a.d)localObject).destroy();
    localObject = (m)getJsRuntime().Z(m.class);
    if (localObject != null) {
      ((m)localObject).a(new d..ExternalSyntheticLambda3(this));
    }
    cleanup();
    AppMethodBeat.o(270288);
  }
  
  public final void dyL()
  {
    AppMethodBeat.i(270215);
    com.tencent.mm.plugin.emoji.magicemoji.c.b.b localb = new com.tencent.mm.plugin.emoji.magicemoji.c.b.b((b.b)new b.c());
    com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this;
    kotlin.g.b.s.u(localf, "component");
    localb.h(localf).ZQ(localb.dyV()).cpV();
    AppMethodBeat.o(270215);
  }
  
  public final com.tencent.magicbrush.e dyM()
  {
    AppMethodBeat.i(270246);
    com.tencent.luggage.game.a.d locald = this.xIH;
    Object localObject = locald;
    if (locald == null)
    {
      kotlin.g.b.s.bIx("magicBrushInstaller");
      localObject = null;
    }
    localObject = ((com.tencent.luggage.game.a.d)localObject).getMagicBrush();
    AppMethodBeat.o(270246);
    return localObject;
  }
  
  public final String getAppId()
  {
    return this.xIC.appId;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b getAppState()
  {
    if (this.Uz) {
      return com.tencent.mm.plugin.appbrand.b.b.qKw;
    }
    return com.tencent.mm.plugin.appbrand.b.b.qKx;
  }
  
  public final Context getContext()
  {
    return (Context)this.xIC;
  }
  
  public final void init()
  {
    AppMethodBeat.i(270238);
    super.init();
    Object localObject1 = new StringBuilder("var __wxConfig = ");
    Object localObject2 = (Map)new HashMap(5);
    ((Map)localObject2).put("platform", "android");
    ((Map)localObject2).put("isIsolateContext", Boolean.FALSE);
    ((Map)localObject2).put("nativeBufferEnabled", Boolean.TRUE);
    ((Map)localObject2).put("JSEngineName", "NodeJS");
    ((Map)localObject2).put("clientVersion", Integer.valueOf(BuildInfo.CLIENT_VERSION_INT));
    ((Map)localObject2).put("isDarkMode", Boolean.valueOf(aw.isDarkMode()));
    localObject2 = new JSONObject((Map)localObject2).toString();
    kotlin.g.b.s.s(localObject2, "JSONObject(configMap).toString()");
    localObject1 = (String)localObject2 + ';';
    Log.d("MicroMsg.MagicEmojiService", kotlin.g.b.s.X("stevecai: injected wxconfig is ", localObject1));
    getJsRuntime().evaluateJavascript((String)localObject1, null);
    localObject1 = com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/lazy_load.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/node_jsapi.js") + com.tencent.mm.plugin.appbrand.af.d.ags("magic_emoji/basic_common_lib.js") + com.tencent.mm.plugin.appbrand.af.d.ags("magic_emoji/magic_emoji_common_lib.js");
    getJsRuntime().evaluateJavascript((String)localObject1, d..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(270238);
  }
  
  public final boolean isRunning()
  {
    return this.Uz;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(270283);
    Object localObject = (com.tencent.mm.plugin.appbrand.n.q)getJsRuntime().Z(com.tencent.mm.plugin.appbrand.n.q.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.n.q)localObject).nM(10);
    }
    localObject = getJsRuntime();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsruntime.AppBrandNodeJSBasedJsEngine");
      AppMethodBeat.o(270283);
      throw ((Throwable)localObject);
    }
    ((x)localObject).pause();
    aI((kotlin.g.a.a)new h(this));
    com.tencent.luggage.game.a.d locald = this.xIH;
    localObject = locald;
    if (locald == null)
    {
      kotlin.g.b.s.bIx("magicBrushInstaller");
      localObject = null;
    }
    ((com.tencent.luggage.game.a.d)localObject).getMagicBrush().avm();
    AppMethodBeat.o(270283);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(270276);
    Object localObject = (com.tencent.mm.plugin.appbrand.n.q)getJsRuntime().Z(com.tencent.mm.plugin.appbrand.n.q.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.n.q)localObject).nM(-4);
    }
    localObject = getJsRuntime();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsruntime.AppBrandNodeJSBasedJsEngine");
      AppMethodBeat.o(270276);
      throw ((Throwable)localObject);
    }
    ((x)localObject).resume();
    aI((kotlin.g.a.a)new k(this));
    com.tencent.luggage.game.a.d locald = this.xIH;
    localObject = locald;
    if (locald == null)
    {
      kotlin.g.b.s.bIx("magicBrushInstaller");
      localObject = null;
    }
    ((com.tencent.luggage.game.a.d)localObject).getMagicBrush().avl();
    AppMethodBeat.o(270276);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService$installMagicBrush$3", "Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.luggage.game.a.b
  {
    d(d paramd, Context paramContext, i parami)
    {
      super(parami, true, false, 1, true);
      AppMethodBeat.i(270027);
      AppMethodBeat.o(270027);
    }
    
    public final void a(com.tencent.magicbrush.f paramf)
    {
      AppMethodBeat.i(270033);
      kotlin.g.b.s.u(paramf, "builder");
      super.a(paramf);
      paramf.dk(true);
      kotlin.g.b.s.t("ME.GLThread", "<set-?>");
      paramf.eIx.a(com.tencent.magicbrush.g.aYe[30], "ME.GLThread");
      paramf.b(a.b.eKw);
      paramf.dn(false);
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQY, 1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramf.dp(bool);
        paramf.dy(d.b(this.xIK).esf.getNativeHandle());
        paramf.ds(true);
        paramf.bf(com.tencent.mm.ce.c.d(MMApplicationContext.getContext().getResources().getDisplayMetrics()).density);
        AppMethodBeat.o(270033);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService$mCommonBinding$1", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandCommonBinding$AbsAppBrandDelegate;", "doInnerLoopTask", "", "nativeInvokeHandler", "", "api", "data", "privateData", "callbackId", "", "isFromAsync", "resumeLoopTasks", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends com.tencent.luggage.sdk.b.a.d.a.a
  {
    e(d paramd)
    {
      super();
      AppMethodBeat.i(270032);
      AppMethodBeat.o(270032);
    }
    
    public final boolean doInnerLoopTask()
    {
      AppMethodBeat.i(270041);
      com.tencent.mm.plugin.appbrand.n.q localq = d.c(this.xIK);
      if (localq == null)
      {
        Log.d("MicroMsg.MagicEmojiService", "stevecai: resumeLoopTasks() called without js thread");
        AppMethodBeat.o(270041);
        return false;
      }
      boolean bool = localq.doInnerLoopTask();
      AppMethodBeat.o(270041);
      return bool;
    }
    
    public final String nativeInvokeHandler(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(270048);
      paramString3 = super.nativeInvokeHandler(paramString1, paramString2, paramString3, paramInt, paramBoolean);
      Log.d("MicroMsg.MagicEmojiService", "stevecai: api = " + paramString1 + ", data = " + paramString2 + ", callbackId = " + paramInt + ", isFromAsync = " + paramBoolean);
      kotlin.g.b.s.s(paramString3, "result");
      AppMethodBeat.o(270048);
      return paramString3;
    }
    
    public final void resumeLoopTasks()
    {
      AppMethodBeat.i(270036);
      com.tencent.mm.plugin.appbrand.n.q localq = d.c(this.xIK);
      if (localq == null)
      {
        Log.d("MicroMsg.MagicEmojiService", "stevecai: resumeLoopTasks() called without js thread");
        AppMethodBeat.o(270036);
        return;
      }
      localq.resumeLoopTasks();
      AppMethodBeat.o(270036);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService$onRuntimeReady$3", "Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa$IFsImageFetcherConfig;", "getEnvId", "", "getFileSystem", "Lcom/tencent/mm/plugin/emoji/magicemoji/fs/MagicEmojiFileSystem;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.luggage.game.b.a.d.b
  {
    g(com.tencent.mm.plugin.emoji.magicemoji.b.b paramb, d paramd) {}
    
    public final String aoQ()
    {
      AppMethodBeat.i(270038);
      String str = jdField_this.getAppId();
      AppMethodBeat.o(270038);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(d paramd)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService$postJsRuntimeCreated$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/IBufferURLManager;", "createBufferURL", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "getBuffer", "url", "revokeBufferURL", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.appbrand.n.y
    {
      a(d paramd) {}
      
      public final ByteBuffer fu(String paramString)
      {
        AppMethodBeat.i(270103);
        paramString = d.b(this.xIK).esg.fu(paramString);
        AppMethodBeat.o(270103);
        return paramString;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiProfiler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.emoji.magicemoji.d.c>
  {
    j(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.d
 * JD-Core Version:    0.7.0.1
 */