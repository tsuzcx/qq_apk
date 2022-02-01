package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.game.a.f;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.jsruntime.aa;
import com.tencent.mm.plugin.appbrand.jsruntime.ad;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.w;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.c.b<c>
{
  private com.tencent.mm.plugin.appbrand.q.b.a mBg = null;
  com.tencent.luggage.game.a.e mBh = null;
  
  public b(c paramc)
  {
    super(paramc);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i CO()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    final long l = System.currentTimeMillis();
    if (((c)Eo()).getContext() == null) {
      com.tencent.mm.sdk.platformtools.ak.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzX, false)) {}
    for (Object localObject2 = ad.bie();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzW, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          localObject1 = com.tencent.mm.plugin.appbrand.y.d.VF("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        int i = ((c)Eo()).aWe().aZM();
        com.tencent.mm.plugin.appbrand.ak.aYh();
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.m.koh.att()).booleanValue();
        boolean bool1;
        if (!((Boolean)l.kog.att()).booleanValue())
        {
          bool1 = true;
          label139:
          localObject2 = w.a(i, (String)localObject2, (byte[])localObject1, bool2, bool1, aa.o((com.tencent.mm.plugin.appbrand.r)Eo()), (com.tencent.mm.plugin.appbrand.jsapi.d)Eo());
          if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.jsruntime.x))
          {
            this.mBg = new com.tencent.mm.plugin.appbrand.q.a();
            this.mBg.a((com.tencent.mm.plugin.appbrand.r)Eo(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2);
          }
          localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.p)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2).P(com.tencent.mm.plugin.appbrand.jsruntime.p.class);
          if (localObject1 == null) {
            break label286;
          }
          ((com.tencent.mm.plugin.appbrand.jsruntime.p)localObject1).a(new p.a()
          {
            public final void onInitialized()
            {
              AppMethodBeat.i(48248);
              com.tencent.mm.plugin.appbrand.report.quality.a.byG();
              if (this.knE) {}
              for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.mDe;; locale = null)
              {
                com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, l, com.tencent.mm.plugin.appbrand.report.d.d(this.coM));
                AppMethodBeat.o(48248);
                return;
              }
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(48257);
          return localObject2;
          localObject1 = com.tencent.mm.plugin.appbrand.y.d.VF("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label139;
          label286:
          com.tencent.mm.plugin.appbrand.report.quality.a.byG();
          localObject1 = localObject3;
          if (((c)Eo()).aXP()) {
            localObject1 = com.tencent.mm.plugin.appbrand.task.e.mDe;
          }
          com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.task.e)localObject1, ((c)Eo()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.d.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void CP()
  {
    AppMethodBeat.i(48264);
    super.CP();
    if (aa.o((com.tencent.mm.plugin.appbrand.r)Eo()))
    {
      ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      aa.a(((c)Eo()).aYB(), ((c)Eo()).aXX(), getAppId());
      aa.a(((c)Eo()).aYB(), ((c)Eo()).aXX(), ((c)Eo()).aXX(), getAppId());
    }
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = ((c)Eo()).aYB();
    if (this.mBh != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.mBh == null) {
        break;
      }
      AppMethodBeat.o(48264);
      return;
    }
    if ((Eo() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e)) {}
    for (bool = false;; bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCZ, true))
    {
      if (bool)
      {
        com.tencent.magicbrush.a.b.loadLibraries();
        com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
        this.mBh = new com.tencent.luggage.game.a.e(((c)Eo()).getContext(), locali)
        {
          public final void a(com.tencent.magicbrush.d paramAnonymousd, long paramAnonymousLong)
          {
            AppMethodBeat.i(222964);
            com.tencent.mm.plugin.appbrand.report.quality.a.byG();
            com.tencent.mm.plugin.appbrand.report.quality.b.a(((c)b.this.Eo()).aXP(), ((c)b.this.Eo()).getAppId(), paramAnonymousLong);
            AppMethodBeat.o(222964);
          }
          
          public final void a(com.tencent.magicbrush.e paramAnonymouse)
          {
            boolean bool2 = true;
            AppMethodBeat.i(222963);
            super.a(paramAnonymouse);
            paramAnonymouse.ae(com.tencent.mm.plugin.appbrand.game.a.d.knR.jdMethod_do(((c)b.this.Eo()).getContext()));
            paramAnonymouse.bP(false);
            paramAnonymouse.bR(((Boolean)h.knY.att()).booleanValue());
            paramAnonymouse.bS(((Boolean)l.kog.att()).booleanValue());
            if (((this.cit instanceof com.tencent.mm.plugin.appbrand.jsruntime.x)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.r.kom.att()).booleanValue())) {
              paramAnonymouse.b(com.tencent.magicbrush.ui.a.b.cAw);
            }
            boolean bool3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.e.knV.att()).booleanValue();
            boolean bool1 = ((Boolean)n.koi.att()).booleanValue();
            boolean bool4 = ((Boolean)o.koj.att()).booleanValue();
            String str1;
            String str2;
            label162:
            String str3;
            if (bool3)
            {
              str1 = "yes";
              if (!bool1) {
                break label243;
              }
              str2 = "yes";
              if (!bool4) {
                break label250;
              }
              str3 = "yes";
              label171:
              ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
              if ((!bool3) || (!bool1)) {
                break label257;
              }
              bool1 = true;
              label208:
              paramAnonymouse.bU(bool1);
              if ((!bool3) || (!bool4)) {
                break label262;
              }
            }
            label257:
            label262:
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymouse.bT(bool1);
              AppMethodBeat.o(222963);
              return;
              str1 = "no";
              break;
              label243:
              str2 = "no";
              break label162;
              label250:
              str3 = "no";
              break label171;
              bool1 = false;
              break label208;
            }
          }
        };
        this.mBh.Cy();
        com.tencent.luggage.game.a.a.a(this.mBh.getMagicBrush(), ((c)Eo()).aYB());
        this.mBh.getMagicBrush().cwY = new com.tencent.magicbrush.handler.b()
        {
          public final String a(final String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(222965);
            if (b.this.Eo() == null)
            {
              AppMethodBeat.o(222965);
              return "";
            }
            try
            {
              paramAnonymousString1 = ((c)b.this.Eo()).b(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousBoolean);
              AppMethodBeat.o(222965);
              return paramAnonymousString1;
            }
            catch (Throwable paramAnonymousString1)
            {
              ae.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramAnonymousString1, "IMBInvokeHandler.invoke", new Object[0]);
              ar.f(new Runnable()
              {
                public final void run()
                {
                  throw paramAnonymousString1;
                }
              });
              AppMethodBeat.o(222965);
            }
            return "";
          }
          
          public final String[] getAsyncableJsApis()
          {
            AppMethodBeat.i(222966);
            if (b.this.Eo() == null)
            {
              AppMethodBeat.o(222966);
              return null;
            }
            String[] arrayOfString = ((c)b.this.Eo()).getAsyncableJsApis();
            AppMethodBeat.o(222966);
            return arrayOfString;
          }
          
          public final ByteBuffer readWeAppFile(String paramAnonymousString)
          {
            AppMethodBeat.i(222967);
            if (b.this.Eo() == null)
            {
              AppMethodBeat.o(222967);
              return null;
            }
            com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
            com.tencent.mm.plugin.appbrand.appstorage.m localm = ((c)b.this.Eo()).Fl().b(paramAnonymousString, locali);
            if (localm == com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
            {
              paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.x.q((ByteBuffer)locali.value);
              AppMethodBeat.o(222967);
              return paramAnonymousString;
            }
            ae.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "readFile %s failed: %s", new Object[] { paramAnonymousString, localm });
            AppMethodBeat.o(222967);
            return null;
          }
        };
        if (((c)Eo()).isRunning()) {
          this.mBh.b(((c)Eo()).getRuntime());
        }
        locali.addJavascriptInterface(new a((byte)0), "MagicBrushViewIdTransfer");
      }
      AppMethodBeat.o(48264);
      return;
    }
  }
  
  public final void CQ()
  {
    AppMethodBeat.i(48262);
    super.CQ();
    if (this.mBh != null) {
      this.mBh.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void CR()
  {
    AppMethodBeat.i(48263);
    if (this.mBg != null) {
      this.mBg.bup();
    }
    AppMethodBeat.o(48263);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DJ()
  {
    AppMethodBeat.i(48261);
    if ((Eo() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      localMap = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j.bte();
      AppMethodBeat.o(48261);
      return localMap;
    }
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final String Dc()
  {
    AppMethodBeat.i(48260);
    if ((this.mBh != null) && (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEA, true))) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.Dc();
      localObject = str;
      if (this.mBg != null) {
        localObject = str + this.mBg.buq();
      }
      if (this.mBh != null) {}
      for (localObject = (String)localObject + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/NativeGlobal-WAService.js");; localObject = (String)localObject + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/NativeGlobal-Dummy.js"))
      {
        AppMethodBeat.o(48260);
        return localObject;
      }
    }
  }
  
  public final int Dd()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qLp, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final void Dg()
  {
    AppMethodBeat.i(222970);
    super.Dg();
    AppMethodBeat.o(222970);
  }
  
  public final void Dh()
  {
    AppMethodBeat.i(222971);
    super.Dh();
    AppMethodBeat.o(222971);
  }
  
  public final void EJ()
  {
    AppMethodBeat.i(48267);
    Object localObject1 = u.mBs;
    if (u.d((c)Eo()))
    {
      final long l = System.currentTimeMillis();
      localObject1 = u.mBs;
      localObject1 = u.bza();
      Object localObject2 = u.mBs;
      localObject2 = u.bzb();
      Object localObject3 = u.mBs;
      localObject3 = u.bzc();
      ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript name:%s", new Object[] { localObject1 });
      ae.v("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript jsSource:%s", new Object[] { localObject2 });
      final d.a locala = new d.a();
      locala.scriptName = ((String)localObject1);
      locala.cnx = ((String)localObject2);
      locala.cny = ((String)localObject2).length();
      s.a(((c)Eo()).aYB(), "https://lib/" + (String)localObject1, "", "", 0, (String)localObject2, (String)localObject3, new s.a()
      {
        public final void cV(String paramAnonymousString)
        {
          AppMethodBeat.i(222969);
          ((c)b.this.Eo()).a(locala, false, l, System.currentTimeMillis(), null);
          ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onFailure ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(222969);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(222968);
          ((c)b.this.Eo()).a(locala, true, l, System.currentTimeMillis(), null);
          ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onSuccess ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(222968);
        }
      });
    }
    AppMethodBeat.o(48267);
  }
  
  public final com.tencent.luggage.sdk.b.a.c.a a(t paramt)
  {
    AppMethodBeat.i(160614);
    com.tencent.mm.plugin.appbrand.ak.aYh();
    paramt = new a((c)Eo(), paramt);
    AppMethodBeat.o(160614);
    return paramt;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.mBh != null) {
      this.mBh.b(paramAppBrandRuntime);
    }
    AppMethodBeat.o(48265);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.c(paramJSONObject);
    u localu = u.mBs;
    boolean bool = u.d((c)Eo());
    try
    {
      paramJSONObject.put("exportBaseMethods", bool);
      paramJSONObject.put("supressOffscreenPatch", true);
      ae.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(48266);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods e:%s", new Object[] { paramJSONObject });
      }
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(222972);
    if ((Eo() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(222972);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(222972);
    return bool;
  }
  
  public final boolean i(int paramInt, String paramString)
  {
    AppMethodBeat.i(222973);
    if ((Eo() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(222973);
      return true;
    }
    boolean bool = super.i(paramInt, paramString);
    AppMethodBeat.o(222973);
    return bool;
  }
  
  public final void z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.z(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.j.b((c)Eo(), paramString1, paramString2);
      AppMethodBeat.o(48258);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(48258);
    }
  }
  
  final class a
  {
    private a() {}
    
    @JavascriptInterface
    public final int exec(int paramInt)
    {
      AppMethodBeat.i(48256);
      try
      {
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.Qi(((c)b.this.Eo()).getAppId()).cqi.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        int i = ((com.tencent.mm.plugin.appbrand.jsapi.a.a.b)localObject).kMe.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.Eo()).getAppId() });
          paramInt = -1;
        }
      }
      AppMethodBeat.o(48256);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */