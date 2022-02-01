package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.a.ae;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.u;
import d.v;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTaskManager;", "", "()V", "TAG", "", "TIMEOUT_INTERVAL", "", "tasksTimeOutHandler", "", "", "Ljava/lang/Runnable;", "tasksWaitingFinish", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "finishAndClear", "", "webViewId", "url", "timeout", "", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "notifyFinish", "notifyFinish$luggage_wechat_full_sdk_release", "(Ljava/lang/Integer;Ljava/lang/String;)V", "summit", "task", "luggage-wechat-full-sdk_release"})
public final class s
{
  private static final Map<Integer, r> kSF;
  private static final Map<Integer, Runnable> kSG;
  public static final s kSH;
  
  static
  {
    AppMethodBeat.i(169642);
    kSH = new s();
    kSF = (Map)new LinkedHashMap();
    kSG = (Map)new LinkedHashMap();
    AppMethodBeat.o(169642);
  }
  
  public static void a(r paramr)
  {
    AppMethodBeat.i(169638);
    k.h(paramr, "task");
    kSF.put(Integer.valueOf(paramr.kSC), paramr);
    Object localObject = kSG;
    int i = paramr.kSC;
    b localb = new b(paramr);
    aq.n((Runnable)localb, 1000L);
    ((Map)localObject).put(Integer.valueOf(i), localb);
    localObject = com.tencent.mm.plugin.appbrand.jsapi.r.jwh;
    i = paramr.kSC;
    paramr = paramr.jZU;
    k.h(paramr, "service");
    localObject = ae.b(u.P("webviewId", Integer.valueOf(i)));
    new com.tencent.mm.plugin.appbrand.jsapi.r((byte)0).g((c)paramr).B((Map)localObject).aXQ();
    AppMethodBeat.o(169638);
  }
  
  public static void a(Integer paramInteger, final String paramString)
  {
    AppMethodBeat.i(169639);
    aq.f((Runnable)new a(paramInteger, paramString));
    AppMethodBeat.o(169639);
  }
  
  private static void a(Integer paramInteger, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(169640);
    Object localObject = kSG;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (Runnable)aa.eP(localObject).remove(paramInteger);
    if (localObject != null) {
      aq.az((Runnable)localObject);
    }
    localObject = kSF;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (r)aa.eP(localObject).remove(paramInteger);
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ad.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] timeout webViewId[" + paramInteger + ']');
        ((r)localObject).kSD.bic();
        AppMethodBeat.o(169640);
        return;
      }
      ad.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] finish webViewId[" + paramInteger + "]  url[" + paramString + ']');
      ((r)localObject).kSD.KQ(paramString);
      AppMethodBeat.o(169640);
      return;
    }
    AppMethodBeat.o(169640);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Integer paramInteger, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(169636);
      s locals = s.kSH;
      s.b(this.kSI, paramString);
      AppMethodBeat.o(169636);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(r paramr) {}
    
    public final void run()
    {
      AppMethodBeat.i(169637);
      s locals = s.kSH;
      s.i(Integer.valueOf(this.kSJ.kSC));
      AppMethodBeat.o(169637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.s
 * JD-Core Version:    0.7.0.1
 */