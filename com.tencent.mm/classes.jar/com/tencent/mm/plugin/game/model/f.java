package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.jj;
import com.tencent.mm.f.a.jj.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String CIv;
  
  static
  {
    AppMethodBeat.i(41406);
    CIv = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Czy) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(jj paramjj)
  {
    AppMethodBeat.i(41401);
    int i = paramjj.fGE.Vh;
    Log.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramjj.fGE.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.gr((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label210:
        paramjj.fGF.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramjj = paramjj.fGE.param;
        Log.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramjj });
        if (!Util.isNullOrNil(paramjj))
        {
          com.tencent.mm.kernel.h.aGY().a(1369, new i()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
            {
              AppMethodBeat.i(41398);
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { this.nzB });
                com.tencent.mm.kernel.h.aGY().b(1369, this);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(41397);
                    f.a(this.CIw, f.1.this.nzB);
                    AppMethodBeat.o(41397);
                  }
                });
                AppMethodBeat.o(41398);
                return;
              }
              Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { this.nzB });
              AppMethodBeat.o(41398);
            }
          });
          paramjj = new as(paramjj);
          com.tencent.mm.kernel.h.aGY().a(paramjj, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramjj.fGE.param;
        Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evp().aIX("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!Util.isNullOrNil((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramjj.fGF.result = ((String)localObject2);
              Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramjj) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramjj);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramjj.fGE.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.gz((Context)localObject1);
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = e.exZ();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label486:
          paramjj.fGF.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          i = Util.getInt(paramjj.fGE.param, 0);
          b.ewm().T(true, i);
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!Util.isNullOrNil(paramjj.fGE.param)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramjj.fGE.param).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException5)
          {
            label580:
            break label580;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).y((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).exj();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label613:
            paramjj.fGF.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!Util.isNullOrNil(paramjj.fGE.param))
            {
              try
              {
                paramjj = new JSONObject(paramjj.fGE.param);
                i = paramjj.optInt("basic_type");
                if (!paramjj.optBoolean("ban")) {
                  break label692;
                }
                e.TD(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramjj) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label692:
            e.TE(i);
            AppMethodBeat.o(41401);
            return;
            c(paramjj);
            AppMethodBeat.o(41401);
            return;
            d(paramjj);
            AppMethodBeat.o(41401);
            return;
            e(paramjj);
            AppMethodBeat.o(41401);
            return;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("disable_gamelife_api", false);
              if ((com.tencent.mm.plugin.game.commlib.a.ewg() != null) && (com.tencent.mm.plugin.game.commlib.a.ewg().CPh)) {
                ((JSONObject)localObject1).put("disable_gamelife_api", true);
              }
              label776:
              localObject1 = ((JSONObject)localObject1).toString();
              paramjj.fGF.result = ((String)localObject1);
              AppMethodBeat.o(41401);
              return;
              if (!Util.isNullOrNil(paramjj.fGE.param)) {
                try
                {
                  paramjj = new JSONObject(paramjj.fGE.param);
                  localObject1 = paramjj.optString("appid");
                  int j = paramjj.optInt("version");
                  Log.i("MicroMsg.GameCommOpertionProcessor", "updateAppInfo, appid:%s, version:%d", new Object[] { localObject1, Integer.valueOf(j) });
                  boolean bool = Util.isNullOrNil((String)localObject1);
                  if (bool)
                  {
                    AppMethodBeat.o(41401);
                    return;
                  }
                  i = j;
                  if (j == 0) {
                    i = 2147483647;
                  }
                  com.tencent.mm.pluginsdk.model.app.h.hn((String)localObject1, i);
                  AppMethodBeat.o(41401);
                  return;
                }
                catch (JSONException paramjj) {}
              }
              AppMethodBeat.o(41401);
              return;
              localObject1 = new JSONObject();
              try
              {
                ((JSONObject)localObject1).put("isExDevice", z.bdj());
                label934:
                localObject1 = ((JSONObject)localObject1).toString();
                paramjj.fGF.result = ((String)localObject1);
              }
              catch (JSONException localJSONException2)
              {
                break label934;
              }
            }
            catch (JSONException localJSONException3)
            {
              break label776;
            }
          }
          catch (JSONException localJSONException4)
          {
            break label613;
          }
        }
        catch (JSONException localJSONException1)
        {
          break label486;
        }
      }
      catch (JSONException localJSONException6)
      {
        break label210;
      }
    }
  }
  
  private static void a(final List<cxc> paramList, final a parama)
  {
    AppMethodBeat.i(41402);
    if (Util.isNullOrNil(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      AppMethodBeat.o(41402);
      return;
    }
    cxc localcxc = (cxc)paramList.remove(0);
    if ((localcxc == null) || (Util.isNullOrNil(localcxc.ThumbUrl)))
    {
      Log.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = CIv + g.getMessageDigest(localcxc.ThumbUrl.getBytes());
    com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
    locala.lRD = true;
    locala.fullPath = ((String)localObject);
    localObject = locala.bmL();
    com.tencent.mm.ay.q.bml().a(localcxc.ThumbUrl, (com.tencent.mm.ay.a.a.c)localObject, new com.tencent.mm.ay.a.c.d()
    {
      public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(200952);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.CIy.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(200952);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem aJT(String paramString)
  {
    AppMethodBeat.i(183857);
    for (;;)
    {
      JSONObject localJSONObject;
      int i;
      try
      {
        localJSONObject = new JSONObject(paramString);
        i = localJSONObject.optInt("mediaType", 0);
        if (i == 1)
        {
          paramString = new WebViewJSSDKImageItem();
          ((WebViewJSSDKImageItem)paramString).cm(localJSONObject);
          AppMethodBeat.o(183857);
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(183857);
        return null;
      }
      if (i != 4) {
        break;
      }
      paramString = new WebViewJSSDKVideoItem();
      ((WebViewJSSDKVideoItem)paramString).cm(localJSONObject);
    }
    AppMethodBeat.o(183857);
    return null;
  }
  
  private static void b(jj paramjj)
  {
    AppMethodBeat.i(41403);
    paramjj = paramjj.fGE.param;
    if (Util.isNullOrNil(paramjj))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramjj);
      j = Util.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramjj = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramjj, localObject });
      if (j == 0)
      {
        Log.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramjj)
    {
      Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramjj.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!Util.isNullOrNil(paramjj))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.c.a.bw(j, paramjj);
        AppMethodBeat.o(41403);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(j, paramjj);
      AppMethodBeat.o(41403);
      return;
    }
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramjj = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramjj.length()) {
          break label293;
        }
        localObject = paramjj.getString(i);
        if (Util.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.c.a.bw(j, (String)localObject);
        } else {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramjj)
      {
        Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramjj.getMessage() });
      }
      AppMethodBeat.o(41403);
      return;
      label293:
      AppMethodBeat.o(41403);
      return;
      label300:
      i += 1;
    }
  }
  
  private static void c(jj paramjj)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.eyl();
    Object localObject2;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = ((String)localObject1).split(",");
      localObject1 = new JSONArray();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        if (!Util.isNullOrNil(str)) {
          ((JSONArray)localObject1).put(Integer.valueOf(str));
        }
        i += 1;
      }
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("basic_type", localObject1);
      label94:
      paramjj.fGF.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label94;
    }
  }
  
  private static void d(jj paramjj)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!Util.isNullOrNil(paramjj.fGE.param)) {
      Log.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramjj.fGE.param });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramjj.fGE.param);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).gVK().toString();
              if (Util.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.commlib.a.a.class)).aIY(str2);
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.commlib.a.a.class)).t(str2, str1.getBytes());
              localJSONArray1.put(true);
            }
          }
        }
      }
      catch (JSONException localJSONException1) {}
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("result", localJSONArray1);
        label201:
        localObject = ((JSONObject)localObject).toString();
        Log.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds result:%s", new Object[] { localObject });
        paramjj.fGF.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).gVK().toString();
        continue;
        label261:
        localJSONArray1.put(false);
      }
      catch (JSONException localJSONException2)
      {
        break label201;
      }
      i += 1;
    }
  }
  
  private static void e(jj paramjj)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!Util.isNullOrNil(paramjj.fGE.param))
    {
      Log.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramjj.fGE.param });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramjj.fGE.param);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI((String)localObject2);
          if ((localObject3 != null) && (u.agG(((WebViewJSSDKFileItem)localObject3).nVa)) && ((Util.isNullOrNil(((WebViewJSSDKFileItem)localObject3).oLR)) || (u.agG(((WebViewJSSDKFileItem)localObject3).oLR))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.e.aVH((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).field_status;
              localObject3 = c.b.HGu;
              if (j == c.b.cgp())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).fuP();
                if ((localObject2 == null) || (!u.agG(((ame)localObject2).HLg)) || (!u.agG(((ame)localObject2).SwC))) {
                  break label333;
                }
                ((JSONArray)localObject1).put(true);
              }
            }
          }
        }
      }
      catch (JSONException localJSONException2) {}
    }
    else
    {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("result", localObject1);
        localObject1 = localJSONObject.toString();
        Log.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds result:%s", new Object[] { localObject1 });
        paramjj.fGF.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).fuP();
        if ((localObject2 != null) && (u.agG(((ame)localObject2).HLf)))
        {
          ((JSONArray)localObject1).put(true);
        }
        else
        {
          label333:
          ((JSONArray)localObject1).put(false);
          break label467;
          if (Util.isNullOrNil((String)localObject2)) {
            break label474;
          }
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.commlib.a.a.class)).aIX((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = aJT(new String((byte[])localObject2));
          if ((localObject2 == null) || (!u.agG(((WebViewJSSDKFileItem)localObject2).nVa)) || ((!Util.isNullOrNil(((WebViewJSSDKFileItem)localObject2).oLR)) && (!u.agG(((WebViewJSSDKFileItem)localObject2).oLR)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.f.gWt().a((WebViewJSSDKFileItem)localObject2);
          j = 1;
          if (j != 0) {
            ((JSONArray)localObject1).put(true);
          } else {
            ((JSONArray)localObject1).put(false);
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        continue;
      }
      label467:
      i += 1;
      break;
      label474:
      j = 0;
    }
  }
  
  static abstract interface a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f
 * JD-Core Version:    0.7.0.1
 */