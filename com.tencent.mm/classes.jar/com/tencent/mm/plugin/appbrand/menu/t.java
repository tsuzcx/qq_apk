package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;
import d.u;
import d.v;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTaskManager;", "", "()V", "TAG", "", "TIMEOUT_INTERVAL", "", "tasksTimeOutHandler", "", "", "Ljava/lang/Runnable;", "tasksWaitingFinish", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "finishAndClear", "", "webViewId", "url", "timeout", "", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "notifyFinish", "notifyFinish$luggage_wechat_full_sdk_release", "(Ljava/lang/Integer;Ljava/lang/String;)V", "summit", "task", "luggage-wechat-full-sdk_release"})
public final class t
{
  private static final Map<Integer, s> lTp;
  private static final Map<Integer, Runnable> lTq;
  public static final t lTr;
  
  static
  {
    AppMethodBeat.i(169642);
    lTr = new t();
    lTp = (Map)new LinkedHashMap();
    lTq = (Map)new LinkedHashMap();
    AppMethodBeat.o(169642);
  }
  
  public static void a(s params)
  {
    AppMethodBeat.i(169638);
    d.g.b.p.h(params, "task");
    lTp.put(Integer.valueOf(params.lTm), params);
    Object localObject = lTq;
    int i = params.lTm;
    b localb = new b(params);
    aq.o((Runnable)localb, 1000L);
    ((Map)localObject).put(Integer.valueOf(i), localb);
    localObject = r.kqU;
    i = params.lTm;
    params = params.kWP;
    d.g.b.p.h(params, "service");
    localObject = d.a.ae.c(u.S("webviewId", Integer.valueOf(i)));
    new r((byte)0).g((c)params).A((Map)localObject).bir();
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
    Object localObject = lTq;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (Runnable)d.g.b.ae.eV(localObject).remove(paramInteger);
    if (localObject != null) {
      aq.aA((Runnable)localObject);
    }
    localObject = lTp;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (s)d.g.b.ae.eV(localObject).remove(paramInteger);
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ad.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] timeout webViewId[" + paramInteger + ']');
        ((s)localObject).lTn.bsV();
        AppMethodBeat.o(169640);
        return;
      }
      ad.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] finish webViewId[" + paramInteger + "]  url[" + paramString + ']');
      ((s)localObject).lTn.SA(paramString);
      AppMethodBeat.o(169640);
      return;
    }
    AppMethodBeat.o(169640);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Integer paramInteger, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(169636);
      t localt = t.lTr;
      t.b(this.lTs, paramString);
      AppMethodBeat.o(169636);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(169637);
      t localt = t.lTr;
      t.i(Integer.valueOf(this.lTt.lTm));
      AppMethodBeat.o(169637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.t
 * JD-Core Version:    0.7.0.1
 */