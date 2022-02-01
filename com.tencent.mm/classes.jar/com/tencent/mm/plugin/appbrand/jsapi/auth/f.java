package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ConstantsAppBrandJsApiMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "Lcom/tencent/mm/wxaprotocol/ConstantsWxaProtocol;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "getWindowAndroid", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;)Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "setUserInfoListData", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "bridge", "_Var", "Lcom/tencent/mm/vending/pipeline/Mario;", "pipeable", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "fill", "Lcom/tencent/mm/protocal/protobuf/WxaExternalInfo;", "service", "notNullContext", "runCgi", "R", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "url", "request", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "clazz", "Ljava/lang/Class;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "ApiInvokeInterruptCallbackException", "ComponentInterruptedException", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static Context a(f paramf, k paramk)
    {
      AppMethodBeat.i(326794);
      s.u(paramf, "this");
      s.u(paramk, "receiver");
      paramf = paramk.getContext();
      if (paramf == null)
      {
        s.u(paramk, "$this_notNullContext");
        paramf = paramk.getRuntime().mContext;
        s.s(paramf, "{\n            this.runtime.appContext\n        }()");
        AppMethodBeat.o(326794);
        return paramf;
      }
      AppMethodBeat.o(326794);
      return paramf;
    }
    
    public static glg a(f paramf, glg paramglg, k paramk)
    {
      int j = 0;
      AppMethodBeat.i(326819);
      s.u(paramf, "this");
      s.u(paramglg, "receiver");
      s.u(paramk, "service");
      paramf = paramk.getRuntime();
      int i;
      if ((paramf instanceof com.tencent.luggage.sdk.e.d))
      {
        paramf = (com.tencent.luggage.sdk.e.d)paramf;
        if (paramf != null) {
          break label82;
        }
        i = 0;
        label51:
        paramglg.scene = i;
        if (!(paramk instanceof y)) {
          break label107;
        }
        i = 1;
      }
      for (;;)
      {
        paramglg.acgQ = i;
        AppMethodBeat.o(326819);
        return paramglg;
        paramf = null;
        break;
        label82:
        paramf = paramf.asA().epn;
        if (paramf == null)
        {
          i = 0;
          break label51;
        }
        i = paramf.scene;
        break label51;
        label107:
        i = j;
        if ((paramk instanceof ad)) {
          i = 2;
        }
      }
    }
    
    public static <R extends esc> com.tencent.mm.vending.g.c<R> a(f paramf, k paramk, String paramString, a parama, Class<R> paramClass)
    {
      AppMethodBeat.i(326797);
      s.u(paramf, "this");
      s.u(paramk, "receiver");
      s.u(paramString, "url");
      s.u(parama, "request");
      s.u(paramClass, "clazz");
      paramf = paramk.T(com.tencent.mm.plugin.appbrand.networking.c.class);
      s.checkNotNull(paramf);
      paramf = (com.tencent.mm.plugin.appbrand.networking.c)paramf;
      paramk.getAppId();
      paramf = paramf.a(paramString, parama, paramClass);
      s.s(paramf, "this.customize(ICgiServi…is.appId, request, clazz)");
      AppMethodBeat.o(326797);
      return paramf;
    }
    
    public static void a(f paramf, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
    {
      AppMethodBeat.i(326812);
      s.u(paramf, "this");
      s.u(paramContext, "context");
      s.u(paramb, "dialog");
      MMHandlerThread.postToMainThread(new f.c..ExternalSyntheticLambda2(paramString1, paramContext, paramString2, paramBitmap, paramb));
      AppMethodBeat.o(326812);
    }
    
    public static <_Var> void a(f paramf, com.tencent.mm.vending.g.b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
    {
      AppMethodBeat.i(326803);
      s.u(paramf, "this");
      s.u(paramb, "receiver");
      s.u(paramc, "pipeable");
      paramc.a(new f.c..ExternalSyntheticLambda1(paramb)).a(new f.c..ExternalSyntheticLambda0(paramb));
      AppMethodBeat.o(326803);
    }
    
    private static final void a(com.tencent.mm.vending.g.b paramb, Object paramObject)
    {
      AppMethodBeat.i(326825);
      s.u(paramb, "$mario");
      g.a(paramb, new Object[] { paramObject });
      AppMethodBeat.o(326825);
    }
    
    private static final void a(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
    {
      AppMethodBeat.i(326835);
      s.u(paramContext, "$context");
      s.u(paramb, "$dialog");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new k.a(paramString1, paramContext.getResources().getString(a.g.appbrand_authorize_item_decs_personal_information), paramString2, paramBitmap));
      paramb.setSelectListItem((List)localArrayList);
      AppMethodBeat.o(326835);
    }
    
    private static final void b(com.tencent.mm.vending.g.b paramb, Object paramObject)
    {
      AppMethodBeat.i(326830);
      s.u(paramb, "$mario");
      paramb.gM(paramObject);
      AppMethodBeat.o(326830);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f
 * JD-Core Version:    0.7.0.1
 */