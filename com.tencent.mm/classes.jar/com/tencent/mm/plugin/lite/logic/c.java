package com.tencent.mm.plugin.lite.logic;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppCallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.mm.plugin.lite.WxaLiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.lite.d.e;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppMMUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.List;

public class c
  implements LiteAppCenter.ILiteAppCallback
{
  public static c vkF;
  
  public static e apC(String paramString)
  {
    AppMethodBeat.i(217803);
    try
    {
      Bundle localBundle = ak.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/"), "getLiteAppInfo", paramString, null);
      if (localBundle == null)
      {
        ae.i("MicroMsg.LiteApp.LiteAppService", "null == bundle, appId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(217803);
        return null;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.LiteApp.LiteAppService", localException, "", new Object[0]);
        localObject = null;
      }
      paramString = new e();
      paramString.field_appId = localObject.getString("appId");
      paramString.field_updateTime = localObject.getLong("updateTime");
      paramString.field_patchId = localObject.getString("patchId");
      paramString.field_pkgPath = localObject.getString("pkgPath");
      paramString.field_pkgType = localObject.getString("pkgType");
      paramString.field_signatureKey = localObject.getString("signatureKey");
      AppMethodBeat.o(217803);
    }
    return paramString;
  }
  
  public static com.tencent.mm.plugin.lite.d.c apD(String paramString)
  {
    AppMethodBeat.i(217804);
    try
    {
      paramString = ak.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/"), "getLiteAppAuthInfo", paramString, null);
      if (paramString == null)
      {
        AppMethodBeat.o(217804);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.LiteApp.LiteAppService", paramString, "", new Object[0]);
        paramString = null;
      }
      com.tencent.mm.plugin.lite.d.c localc = new com.tencent.mm.plugin.lite.d.c();
      localc.field_host = paramString.getString("host");
      localc.field_param = paramString.getString("param");
      localc.field_paramMap = paramString.getString("paramMap");
      localc.field_headerMap = paramString.getString("headerMap");
      localc.field_updateTime = paramString.getLong("updateTime");
      AppMethodBeat.o(217804);
      return localc;
    }
  }
  
  public static void b(e parame)
  {
    AppMethodBeat.i(217805);
    if (parame.field_appId.equalsIgnoreCase("wxalitecce81f5fba338df4dd5f74df8229c600"))
    {
      ay localay = ay.fpc();
      localay.putString("wxa_lite_app_game_center_version", parame.field_patchId);
      localay.commit();
    }
    AppMethodBeat.o(217805);
  }
  
  private static boolean c(e parame)
  {
    AppMethodBeat.i(217809);
    if (parame == null)
    {
      AppMethodBeat.o(217809);
      return true;
    }
    if (parame.diD())
    {
      AppMethodBeat.o(217809);
      return false;
    }
    AppMethodBeat.o(217809);
    return true;
  }
  
  public static e diA()
  {
    AppMethodBeat.i(217806);
    diz();
    e locale = apC("wxalitebaselibrary");
    AppMethodBeat.o(217806);
    return locale;
  }
  
  public static boolean diC()
  {
    AppMethodBeat.i(217812);
    if (ak.coh())
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJy, 0) == 1)
      {
        AppMethodBeat.o(217812);
        return true;
      }
      AppMethodBeat.o(217812);
      return false;
    }
    AppMethodBeat.o(217812);
    return false;
  }
  
  public static boolean diw()
  {
    AppMethodBeat.i(217813);
    if (ak.coh())
    {
      boolean bool;
      int i;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJy, 0) == 1)
      {
        bool = true;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJA, 10);
        localObject = apC("wxalitecce81f5fba338df4dd5f74df8229c600");
        if (localObject != null) {
          break label146;
        }
      }
      label146:
      for (Object localObject = "";; localObject = ((e)localObject).field_patchId)
      {
        int j = ay.fpc().getInt("count_".concat(String.valueOf(localObject)), 0);
        ae.i("MicroMsg.LiteApp.LiteAppService", "isLiteAppOpen version%s enable:%b, crashCount:%d", new Object[] { localObject, Boolean.valueOf(bool), Integer.valueOf(j) });
        if (!bool) {
          break label174;
        }
        if (j >= i) {
          break label154;
        }
        com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 100L, 1L);
        AppMethodBeat.o(217813);
        return true;
        bool = false;
        break;
      }
      label154:
      com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 101L, 1L);
      for (;;)
      {
        AppMethodBeat.o(217813);
        return false;
        label174:
        com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 102L, 1L);
      }
    }
    ae.i("MicroMsg.LiteApp.LiteAppService", "can no get 'isLiteAppOpen' value when is no mm process.");
    AppMethodBeat.o(217813);
    return false;
  }
  
  public static c diz()
  {
    AppMethodBeat.i(217801);
    if (vkF == null) {}
    try
    {
      c localc = new c();
      vkF = localc;
      LiteAppCenter.setCallback(localc);
      localc = vkF;
      AppMethodBeat.o(217801);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(217801);
    }
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(217802);
    Uri localUri = Uri.parse("content://com.tencent.mm.plugin.lite.logic.LiteAppInfo/");
    AppMethodBeat.o(217802);
    return localUri;
  }
  
  public final void a(final String paramString, final a parama)
  {
    AppMethodBeat.i(217808);
    final e locale = apC(paramString);
    if (c(locale)) {
      if ((locale == null) || (locale.field_patchId == null) || (locale.field_patchId.isEmpty())) {
        break label113;
      }
    }
    label113:
    for (String str = locale.field_patchId;; str = "")
    {
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.boots.a.c.class)).a(paramString, paramString, str, new f()
      {
        public final void a(com.tencent.mm.plugin.boots.a.g paramAnonymousg)
        {
          AppMethodBeat.i(217800);
          if (!bu.isNullOrNil(paramAnonymousg.gKg))
          {
            ae.i("MicroMsg.LiteApp.LiteAppService", "start download liteapp:" + paramString + ", url:" + paramAnonymousg.gKg);
            com.tencent.mm.plugin.lite.b.vjN.a(paramAnonymousg, "release", parama);
            AppMethodBeat.o(217800);
            return;
          }
          if (parama != null)
          {
            ae.i("MicroMsg.LiteApp.LiteAppService", "checkLiteApp, url is null, appId:" + paramString);
            if (locale != null)
            {
              parama.a(locale);
              AppMethodBeat.o(217800);
              return;
            }
            parama.cZO();
          }
          AppMethodBeat.o(217800);
        }
      });
      AppMethodBeat.o(217808);
      return;
      ae.i("MicroMsg.LiteApp.LiteAppService", "no need download, local pkg is debug");
      if (parama != null) {
        parama.a(locale);
      }
      AppMethodBeat.o(217808);
      return;
    }
  }
  
  public final void diB()
  {
    AppMethodBeat.i(217807);
    final e locale = diA();
    diz().a("wxalitebaselibrary", new a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(217799);
        if (paramAnonymouse == null)
        {
          AppMethodBeat.o(217799);
          return;
        }
        if (locale != null)
        {
          if (!locale.field_pkgPath.equals(paramAnonymouse.field_pkgPath))
          {
            c.diz();
            if (!c.diw()) {}
          }
        }
        else
        {
          Intent localIntent = new Intent();
          localIntent.setClass(ak.getContext(), WxaLiteAppTaskPreloadReceiver.class);
          localIntent.addFlags(268435456);
          localIntent.putExtra("task", "updateBaseLibPath");
          localIntent.putExtra("path", paramAnonymouse.field_pkgPath);
          ak.getContext().sendBroadcast(localIntent);
        }
        AppMethodBeat.o(217799);
      }
      
      public final void cZO() {}
    });
    AppMethodBeat.o(217807);
  }
  
  public String[] getAppInfo(String paramString)
  {
    AppMethodBeat.i(217810);
    Object localObject = apC(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(217810);
      return null;
    }
    paramString = ((e)localObject).field_pkgPath;
    localObject = ((e)localObject).field_signatureKey;
    AppMethodBeat.o(217810);
    return new String[] { paramString, localObject };
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
  
  public void openPage(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217811);
    e locale = apC(paramString1);
    paramString2 = LiteAppCenter.showView(paramString1, paramString2, paramString3, locale.field_pkgPath, locale.field_signatureKey);
    ae.i("MicroMsg.LiteApp.LiteAppService", "show view result %b", new Object[] { Boolean.valueOf(paramString2.success) });
    paramString3 = new HashMap();
    paramString3.put("appId", paramString1);
    paramString3.put("appPtr", Long.valueOf(paramString2.appPtr));
    paramString3.put("pageViewId", Long.valueOf(paramString2.pageId));
    paramString3.put("basePath", paramString2.basePath);
    paramString3.put("pageRenderPtr", Long.valueOf(paramString2.renderId));
    paramString3.put("startTime", Long.valueOf(System.currentTimeMillis()));
    paramString1 = new Intent(ak.getContext(), WxaLiteAppMMUI.class);
    paramString1.addFlags(268435456);
    paramString1.putExtra("main", "liteApp");
    paramString1.putExtra("name", String.valueOf(paramString2.pageId));
    paramString1.putExtra("params", new com.tencent.wax.d.a(paramString3));
    paramString2 = ak.getContext();
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
    com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString1.ahE(), "com/tencent/mm/plugin/lite/logic/LiteAppLogic", "openPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString2.startActivity((Intent)paramString1.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/plugin/lite/logic/LiteAppLogic", "openPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.c
 * JD-Core Version:    0.7.0.1
 */