package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.ar;
import d.l;
import d.v;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTaskManager;", "", "()V", "TAG", "", "TIMEOUT_INTERVAL", "", "tasksTimeOutHandler", "", "", "Ljava/lang/Runnable;", "tasksWaitingFinish", "Lcom/tencent/mm/plugin/appbrand/menu/PageUrlDecodeTask;", "finishAndClear", "", "webViewId", "url", "timeout", "", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "notifyFinish", "notifyFinish$luggage_wechat_full_sdk_release", "(Ljava/lang/Integer;Ljava/lang/String;)V", "summit", "task", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static final Map<Integer, t> lXR;
  private static final Map<Integer, Runnable> lXS;
  public static final u lXT;
  
  static
  {
    AppMethodBeat.i(169642);
    lXT = new u();
    lXR = (Map)new LinkedHashMap();
    lXS = (Map)new LinkedHashMap();
    AppMethodBeat.o(169642);
  }
  
  public static void a(t paramt)
  {
    AppMethodBeat.i(169638);
    d.g.b.p.h(paramt, "task");
    lXR.put(Integer.valueOf(paramt.lXO), paramt);
    Object localObject = lXS;
    int i = paramt.lXO;
    b localb = new b(paramt);
    ar.o((Runnable)localb, 1000L);
    ((Map)localObject).put(Integer.valueOf(i), localb);
    localObject = r.kuj;
    i = paramt.lXO;
    paramt = paramt.lay;
    d.g.b.p.h(paramt, "service");
    localObject = d.a.ae.c(d.u.R("webviewId", Integer.valueOf(i)));
    new r((byte)0).g((c)paramt).H((Map)localObject).bja();
    AppMethodBeat.o(169638);
  }
  
  public static void a(Integer paramInteger, final String paramString)
  {
    AppMethodBeat.i(169639);
    ar.f((Runnable)new a(paramInteger, paramString));
    AppMethodBeat.o(169639);
  }
  
  private static void a(Integer paramInteger, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(169640);
    Object localObject = lXS;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (Runnable)d.g.b.ae.eY(localObject).remove(paramInteger);
    if (localObject != null) {
      ar.ay((Runnable)localObject);
    }
    localObject = lXR;
    if (localObject == null)
    {
      paramInteger = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
      AppMethodBeat.o(169640);
      throw paramInteger;
    }
    localObject = (t)d.g.b.ae.eY(localObject).remove(paramInteger);
    if (localObject != null)
    {
      if (paramBoolean)
      {
        com.tencent.mm.sdk.platformtools.ae.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] timeout webViewId[" + paramInteger + ']');
        ((t)localObject).lXP.btG();
        AppMethodBeat.o(169640);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("PageUrlDecodeTaskManager", "[AppbrandCopyUrl] finish webViewId[" + paramInteger + "]  url[" + paramString + ']');
      ((t)localObject).lXP.Tj(paramString);
      AppMethodBeat.o(169640);
      return;
    }
    AppMethodBeat.o(169640);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Integer paramInteger, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(169636);
      u localu = u.lXT;
      u.b(this.lXU, paramString);
      AppMethodBeat.o(169636);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(169637);
      u localu = u.lXT;
      u.j(Integer.valueOf(this.lXV.lXO));
      AppMethodBeat.o(169637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.u
 * JD-Core Version:    0.7.0.1
 */