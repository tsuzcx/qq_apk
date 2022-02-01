package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class b<Service extends c>
  extends e<Service>
{
  private com.tencent.luggage.sdk.b.a.a.c ckc;
  private com.tencent.luggage.sdk.b.a.a.d cke;
  volatile boolean coF;
  private volatile boolean coG;
  private volatile boolean coH;
  private final LinkedList<Runnable> coI;
  private final Map<String, Boolean> coJ;
  
  public b(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(146798);
    this.coF = false;
    this.coG = false;
    this.coH = false;
    this.coI = new LinkedList();
    this.coJ = new HashMap();
    AppMethodBeat.o(146798);
  }
  
  private void CR()
  {
    AppMethodBeat.i(146806);
    try
    {
      Object localObject = ((c)El()).aYh();
      if (localObject == null)
      {
        AppMethodBeat.o(146806);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(-2);
      }
      AppMethodBeat.o(146806);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146806);
    }
  }
  
  private void EF()
  {
    AppMethodBeat.i(146810);
    if (this.coF)
    {
      AppMethodBeat.o(146810);
      return;
    }
    if (this.coH)
    {
      AppMethodBeat.o(146810);
      return;
    }
    EH();
    String str = ((c)El()).En().Fa().jYh.pkgPath;
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(146810);
      return;
    }
    r.a(((c)El()).En(), ((c)El()).aYh(), str, "app-service.js", "", "", r.a.mOX, new b.d("app-service.js", (c)El(), (byte)0));
    this.coH = true;
    AppMethodBeat.o(146810);
  }
  
  private void bv(boolean paramBoolean)
  {
    AppMethodBeat.i(146812);
    Object localObject1;
    String str1;
    String str2;
    if (!this.coG)
    {
      aq.a((com.tencent.mm.plugin.appbrand.d)El(), ((c)El()).aYh());
      localObject1 = CZ();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)El()).aYh(), (String)localObject1, new b.3(this, l, paramBoolean));
      localObject2 = EG();
      str1 = ((b.b)localObject2).name;
      str2 = ((b.b)localObject2).source;
      if (!TextUtils.isEmpty(((b.b)localObject2).coP)) {
        break label211;
      }
      localObject1 = str1;
      if (!TextUtils.isEmpty(((b.b)localObject2).coQ)) {
        break label221;
      }
    }
    label211:
    label221:
    for (Object localObject2 = "v" + ((c)El()).aVF().aZp();; localObject2 = ((b.b)localObject2).coQ)
    {
      r.a((com.tencent.mm.plugin.appbrand.q)El(), ((c)El()).aYh(), str1, (String)localObject1, (String)localObject2, Da(), str2, r.a.mOW, new b.c(str1, str2, (c)El(), paramBoolean, (byte)0));
      this.coG = true;
      AppMethodBeat.o(146812);
      return;
      localObject1 = ((b.b)localObject2).coP;
      break;
    }
  }
  
  public final boolean CK()
  {
    return this.coF;
  }
  
  protected i CL()
  {
    AppMethodBeat.i(146799);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(146799);
    return localc;
  }
  
  protected void CM()
  {
    AppMethodBeat.i(146800);
    super.CM();
    Object localObject1 = ((c)El()).aYh();
    Object localObject2 = (t)((i)localObject1).P(t.class);
    if (localObject2 != null)
    {
      localObject2 = a((t)localObject2);
      ((i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      ((a)localObject2).Dk();
    }
    for (this.coF = true;; this.coF = false)
    {
      ((i)localObject1).setJsExceptionHandler(new h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146789);
          ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          String str = String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Vc(paramAnonymousString1), p.Vc(paramAnonymousString2) });
          cj.a(this.coK, "onError", str, 0);
          b.this.z(paramAnonymousString1, paramAnonymousString2);
          ad.e("MicroMsg.AppBrand.JsRuntimeException", str);
          AppMethodBeat.o(146789);
        }
      });
      this.ckc = new com.tencent.luggage.sdk.b.a.a.c();
      this.ckc.a((i)localObject1, El());
      this.cke = new com.tencent.luggage.sdk.b.a.a.d();
      this.cke.a(((c)El()).aYh(), El(), 0);
      localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject1).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192189);
            if ((b.this.El() == null) || (((c)b.this.El()).aYh() == null))
            {
              ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
              AppMethodBeat.o(192189);
              return;
            }
            v localv = (v)((c)b.this.El()).aYh().P(v.class);
            com.tencent.mm.plugin.appbrand.jsapi.ac.b.c.D(localv.getIsolatePtr(), localv.NB());
            AppMethodBeat.o(192189);
          }
        });
      }
      AppMethodBeat.o(146800);
      return;
    }
  }
  
  protected void CN()
  {
    AppMethodBeat.i(146809);
    super.CN();
    if (this.ckc != null) {
      this.ckc.a(((c)El()).aYh());
    }
    if (this.cke != null) {
      this.cke.b(((c)El()).aYh());
    }
    AppMethodBeat.o(146809);
  }
  
  public final void CX()
  {
    AppMethodBeat.i(146804);
    super.CX();
    CR();
    AppMethodBeat.o(146804);
  }
  
  public final void CY()
  {
    AppMethodBeat.i(146805);
    super.CY();
    try
    {
      Object localObject = ((c)El()).aYh();
      if (localObject == null)
      {
        AppMethodBeat.o(146805);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(146805);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(146805);
    }
  }
  
  protected String CZ()
  {
    AppMethodBeat.i(146801);
    String str = "" + com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/android.js");
    str = str + com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/shared_buffer.js");
    str = str + com.tencent.mm.plugin.appbrand.jsapi.ac.b.c.bpK();
    AppMethodBeat.o(146801);
    return str;
  }
  
  protected int Da()
  {
    return 0;
  }
  
  protected void Dd()
  {
    AppMethodBeat.i(146808);
    if (!this.coG) {
      ((c)El()).aYh().evaluateJavascript(com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/android.js"), null);
    }
    ((c)El()).EO();
    bv(false);
    EF();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.coI)
    {
      localLinkedList.addAll(this.coI);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    EI();
    AppMethodBeat.o(146808);
  }
  
  protected void De()
  {
    AppMethodBeat.i(146814);
    bv(true);
    ((c)El()).bid();
    AppMethodBeat.o(146814);
  }
  
  protected b.b EG()
  {
    AppMethodBeat.i(146811);
    Object localObject1;
    if (this.coF) {
      localObject1 = ((c)El()).aVF().Ld("WAServiceMainContext.js");
    }
    for (String str = "WAServiceMainContext.js";; str = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "WAService.js";
        localObject2 = ((c)El()).aVF().Ld("WAService.js");
      }
      localObject1 = new b.b();
      ((b.b)localObject1).name = str;
      ((b.b)localObject1).source = ((String)localObject2);
      AppMethodBeat.o(146811);
      return localObject1;
      localObject1 = null;
    }
  }
  
  protected void EH() {}
  
  protected a a(t paramt)
  {
    AppMethodBeat.i(160992);
    paramt = new g((c)El(), paramt);
    AppMethodBeat.o(160992);
    return paramt;
  }
  
  protected void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146803);
    Objects.requireNonNull(El());
    if (this.cke != null) {
      this.cke.b(((c)El()).aYh(), El());
    }
    CR();
    paramAppBrandRuntime.b(z.class, new ae(com.tencent.mm.sdk.f.a.jq(paramAppBrandRuntime.mContext)));
    com.tencent.mm.plugin.appbrand.jsapi.ac.b.c.a((com.tencent.mm.plugin.appbrand.f.b)((c)El()).K(com.tencent.mm.plugin.appbrand.f.b.class), (com.tencent.mm.plugin.appbrand.f.a)((c)El()).K(com.tencent.mm.plugin.appbrand.f.a.class), (com.tencent.mm.plugin.appbrand.q)El());
    ad.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    paramAppBrandRuntime = com.tencent.mm.plugin.appbrand.i.a.bgy();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin(paramAppBrandRuntime);
    AppMethodBeat.o(146803);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146807);
    super.c(paramJSONObject);
    ((c)El()).c(paramJSONObject, "isLazyLoad", Boolean.valueOf(((y)((c)El()).En().ar(y.class)).bup()));
    AppMethodBeat.o(146807);
  }
  
  public final boolean cS(String arg1)
  {
    AppMethodBeat.i(192193);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(192193);
      return false;
    }
    for (;;)
    {
      Object localObject1;
      synchronized (this.coJ)
      {
        localObject1 = (Boolean)this.coJ.get(???);
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          ad.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", new Object[] { getAppId(), ??? });
          bool = false;
          AppMethodBeat.o(192193);
          return bool;
        }
        this.coJ.put(???, Boolean.TRUE);
        ad.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", new Object[] { getAppId(), ??? });
        localObject1 = new b.4(this, ???);
        if (El() == null) {
          ad.w("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
        } else if (((c)El()).isRunning()) {
          ((Runnable)localObject1).run();
        }
      }
      synchronized (this.coI)
      {
        this.coI.add(localObject1);
      }
      boolean bool = true;
    }
  }
  
  protected void z(String paramString1, String paramString2) {}
  
  public static final class a
    implements com.tencent.luggage.sdk.b.a.b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */