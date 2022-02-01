package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.a.ae;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.u;
import d.v;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTaskManager;", "", "()V", "TAG", "", "TIMEOUT_INTERVAL", "", "tasksTimeOutHandler", "", "", "Ljava/lang/Runnable;", "tasksWaitingFinish", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "finishAndClear", "", "webViewId", "url", "timeout", "", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "notifyFinish", "notifyFinish$luggage_wechat_full_sdk_release", "(Ljava/lang/Integer;Ljava/lang/String;)V", "summit", "task", "luggage-wechat-full-sdk_release"})
public final class s
{
  private static final Map<Integer, r> luf;
  private static final Map<Integer, Runnable> lug;
  public static final s luh;
  
  static
  {
    AppMethodBeat.i(169642);
    luh = new s();
    luf = (Map)new LinkedHashMap();
    lug = (Map)new LinkedHashMap();
    AppMethodBeat.o(169642);
  }
  
  public static void a(r paramr)
  {
    AppMethodBeat.i(169638);
    k.h(paramr, "task");
    luf.put(Integer.valueOf(paramr.luc), paramr);
    Object localObject = lug;
    int i = paramr.luc;
    b localb = new b(paramr);
    ap.n((Runnable)localb, 1000L);
    ((Map)localObject).put(Integer.valueOf(i), localb);
    localObject = com.tencent.mm.plugin.appbrand.jsapi.r.jWD;
    i = paramr.luc;
    paramr = paramr.kAH;
    k.h(paramr, "service");
    localObject = ae.b(u.Q("webviewId", Integer.valueOf(i)));
    new com.tencent.mm.plugin.appbrand.jsapi.r((byte)0).g((c)paramr).A((Map)localObject).beN();
    AppMethodBeat.o(169638);
  }
  
  public static void a(Integer paramInteger, final String paramString)
  {
    AppMethodBeat.i(169639);
    ap.f((Runnable)new a(paramInteger, paramString));
    AppMethodBeat.o(169639);
  }
  
  private static void a(Integer paramInteger, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(169640);
    Object localObject = lug;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (Runnable)aa.eS(localObject).remove(paramInteger);
    if (localObject != null) {
      ap.aB((Runnable)localObject);
    }
    localObject = luf;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (r)aa.eS(localObject).remove(paramInteger);
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ac.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] timeout webViewId[" + paramInteger + ']');
        ((r)localObject).lud.boW();
        AppMethodBeat.o(169640);
        return;
      }
      ac.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] finish webViewId[" + paramInteger + "]  url[" + paramString + ']');
      ((r)localObject).lud.OX(paramString);
      AppMethodBeat.o(169640);
      return;
    }
    AppMethodBeat.o(169640);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Integer paramInteger, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(169636);
      s locals = s.luh;
      s.b(this.lui, paramString);
      AppMethodBeat.o(169636);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(r paramr) {}
    
    public final void run()
    {
      AppMethodBeat.i(169637);
      s locals = s.luh;
      s.i(Integer.valueOf(this.luj.luc));
      AppMethodBeat.o(169637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.s
 * JD-Core Version:    0.7.0.1
 */