package com.tencent.mm.plugin.flutter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.EngineDataReportListener;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/base/CachedFlutterEngines;", "", "()V", "TAG", "", "warmUpJob", "Lkotlinx/coroutines/Job;", "warmUpScope", "Lkotlinx/coroutines/CoroutineScope;", "clear", "", "engineId", "create", "Lkotlin/Pair;", "Lio/flutter/embedding/engine/FlutterEngine;", "pluginName", "automaticallyRegisterPlugins", "", "paramsBuilder", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vmEntry", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBlock", "ensureInitFlutterLoader", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateUniqueKey", "warmUpEngine", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Hke;
  private static cb Hkf;
  private static final aq Hkg;
  
  static
  {
    AppMethodBeat.i(263182);
    Hke = new b();
    Hkg = ar.b(ar.d((f)bg.kCi()), (f)cx.g(null));
    AppMethodBeat.o(263182);
  }
  
  private static final void aD(Runnable paramRunnable)
  {
    AppMethodBeat.i(263168);
    h.ahAA.bm(paramRunnable);
    AppMethodBeat.o(263168);
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(263157);
    s.u(paramString, "engineId");
    FlutterEngine localFlutterEngine = FlutterEngineCache.getInstance().get(paramString);
    FlutterEngineCache.getInstance().remove(paramString);
    Log.i("MicroMsg.CachedFlutterEngines", "clear: engineId=" + paramString + ", engine=" + localFlutterEngine);
    if (localFlutterEngine != null) {
      localFlutterEngine.destroy();
    }
    AppMethodBeat.o(263157);
  }
  
  private static String fuY()
  {
    AppMethodBeat.i(263160);
    String str;
    do
    {
      str = UUID.randomUUID().toString();
      s.s(str, "randomUUID().toString()");
    } while (FlutterEngineCache.getInstance().contains(str));
    AppMethodBeat.o(263160);
    return str;
  }
  
  public final Object a(String paramString1, String paramString2, boolean paramBoolean, kotlin.g.a.b<? super Map<String, Object>, ah> paramb, kotlin.d.d<? super r<String, ? extends FlutterEngine>> paramd)
  {
    AppMethodBeat.i(263212);
    a locala;
    if ((paramd instanceof a))
    {
      locala = (a)paramd;
      if ((locala.label & 0x80000000) != 0) {
        locala.label += -2147483648;
      }
    }
    Object localObject;
    kotlin.d.a.a locala1;
    for (;;)
    {
      localObject = locala.result;
      locala1 = kotlin.d.a.a.aiwj;
      switch (locala.label)
      {
      default: 
        paramString1 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263212);
        throw paramString1;
        locala = new a(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject);
    b localb = this;
    String str2 = paramString1;
    String str1 = paramString2;
    boolean bool = paramBoolean;
    paramd = paramb;
    if (Hkf != null)
    {
      paramd = Hkf;
      if ((paramd != null) && (!paramd.isCompleted())) {}
      for (int i = 1;; i = 0)
      {
        localb = this;
        str2 = paramString1;
        str1 = paramString2;
        bool = paramBoolean;
        paramd = paramb;
        if (i == 0) {
          break;
        }
        Log.i("MicroMsg.CachedFlutterEngines", "create engine wait warmUp job finished");
        localObject = Hkf;
        localb = this;
        str2 = paramString1;
        str1 = paramString2;
        bool = paramBoolean;
        paramd = paramb;
        if (localObject == null) {
          break;
        }
        locala.L$0 = this;
        locala.Uf = paramString1;
        locala.VC = paramString2;
        locala.VD = paramb;
        locala.YF = paramBoolean;
        locala.label = 1;
        localb = this;
        str2 = paramString1;
        str1 = paramString2;
        bool = paramBoolean;
        paramd = paramb;
        if (((cb)localObject).ay(locala) != locala1) {
          break;
        }
        AppMethodBeat.o(263212);
        return locala1;
      }
      bool = locala.YF;
      paramd = (kotlin.g.a.b)locala.VD;
      str1 = (String)locala.VC;
      str2 = (String)locala.Uf;
      localb = (b)locala.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    paramString1 = (f)bg.kCi();
    paramString2 = (m)new b.b(null);
    locala.L$0 = localb;
    locala.Uf = str2;
    locala.VC = str1;
    locala.VD = paramd;
    locala.YF = bool;
    locala.label = 2;
    if (l.a(paramString1, paramString2, locala) == locala1)
    {
      AppMethodBeat.o(263212);
      return locala1;
      bool = locala.YF;
      paramd = (kotlin.g.a.b)locala.VD;
      str1 = (String)locala.VC;
      str2 = (String)locala.Uf;
      ResultKt.throwOnFailure(localObject);
    }
    paramString1 = new c(str2, str1, new LinkedHashMap());
    paramb = MMApplicationContext.getContext();
    paramString2 = new HashMap();
    paramString2.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.getScaleSize(paramb)));
    paramString2.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.mo(paramb)));
    paramString2.put("language", LocaleUtil.getApplicationLanguage());
    paramString2.put("sessionId", UUID.randomUUID().toString());
    if (paramd != null) {
      paramd.invoke(paramString2);
    }
    paramb = ah.aiuX;
    paramString1.Hka = paramString2;
    paramString1.Hkc = true;
    paramString2 = MMApplicationContext.getContext();
    if (bool) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString2 = new FlutterEngine(paramString2, null, paramBoolean);
      paramString2.getNavigationChannel().setInitialRoute(paramString1.toJsonString());
      paramString2.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), str1));
      paramString2.setBackgroundExecutor(b..ExternalSyntheticLambda0.INSTANCE);
      paramString1 = a.Hkd;
      paramString1 = paramString2.getPlugins();
      s.s(paramString1, "flutterEngine.plugins");
      a.a(paramString1);
      paramString2.addDataReportListener((EngineDataReportListener)new com.tencent.mm.plugin.flutter.model.a(paramString2));
      paramString1 = fuY();
      FlutterEngineCache.getInstance().put(paramString1, paramString2);
      Log.i("MicroMsg.CachedFlutterEngines", "preload: pluginName=" + str2 + ", vmEntry=" + str1 + ", engineId=" + paramString1);
      paramString1 = new r(paramString1, paramString2);
      AppMethodBeat.o(263212);
      return paramString1;
    }
  }
  
  public final Object a(String paramString, boolean paramBoolean, kotlin.g.a.b<? super Map<String, Object>, ah> paramb, kotlin.d.d<? super r<String, ? extends FlutterEngine>> paramd)
  {
    AppMethodBeat.i(263217);
    paramString = a(paramString, "home", paramBoolean, paramb, paramd);
    AppMethodBeat.o(263217);
    return paramString;
  }
  
  public final void fuX()
  {
    try
    {
      AppMethodBeat.i(263192);
      Log.i("MicroMsg.CachedFlutterEngines", "warmUpEngine");
      if (Hkf == null) {
        Hkf = j.a(Hkg, null, null, (m)new b.e(null), 3);
      }
      AppMethodBeat.o(263192);
      return;
    }
    finally {}
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    boolean YF;
    int label;
    
    a(b paramb, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263131);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Hkh.a(null, null, false, null, (kotlin.d.d)this);
      AppMethodBeat.o(263131);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.b
 * JD-Core Version:    0.7.0.1
 */