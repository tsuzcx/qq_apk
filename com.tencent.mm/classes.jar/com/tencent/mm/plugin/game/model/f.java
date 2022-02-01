package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.kk;
import com.tencent.mm.autogen.a.kk.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.b.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String ICF;
  
  static
  {
    AppMethodBeat.i(41406);
    ICF = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Ito) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(kk paramkk)
  {
    AppMethodBeat.i(41401);
    int i = paramkk.hMa.bUl;
    Log.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramkk.hMa.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.hK((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label218:
        paramkk.hMb.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramkk = paramkk.hMa.param;
        Log.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramkk });
        if (!Util.isNullOrNil(paramkk))
        {
          com.tencent.mm.kernel.h.aZW().a(1369, new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(41398);
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { f.this });
                com.tencent.mm.kernel.h.aZW().b(1369, this);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(41397);
                    f.a(this.ICG, f.this);
                    AppMethodBeat.o(41397);
                  }
                });
                AppMethodBeat.o(41398);
                return;
              }
              Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { f.this });
              AppMethodBeat.o(41398);
            }
          });
          paramkk = new as(paramkk);
          com.tencent.mm.kernel.h.aZW().a(paramkk, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramkk.hMa.param;
        Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCi().aFI("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!Util.isNullOrNil((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramkk.hMb.result = ((String)localObject2);
              Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramkk) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramkk);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramkk.hMa.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.hS((Context)localObject1);
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = e.fFV();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label494:
          paramkk.hMb.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          i = Util.getInt(paramkk.hMa.param, 0);
          b.fEb().V(true, i);
          AppMethodBeat.o(41401);
          return;
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCi().aGM("cache_my_chatroom");
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCi().aGM("cache_chatroom_recommend");
          paramkk = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCi();
          localObject1 = "delete from GamePBCache where key like '" + "cache_game_chat_msg#" + "%'";
          Log.i("MicroMsg.GamePBCacheStorage", "deleteDataWithPrefix, ret:%b, sql: %s", new Object[] { Boolean.valueOf(paramkk.execSQL("GameHaowanMedia", (String)localObject1)), localObject1 });
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCi().aGN("memberVersion");
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCi().aGN("updateTime");
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!Util.isNullOrNil(paramkk.hMa.param)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramkk.hMa.param).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException5)
          {
            label738:
            break label738;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).B((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).fFg();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label772:
            paramkk.hMb.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!Util.isNullOrNil(paramkk.hMa.param))
            {
              try
              {
                paramkk = new JSONObject(paramkk.hMa.param);
                i = paramkk.optInt("basic_type");
                if (!paramkk.optBoolean("ban")) {
                  break label853;
                }
                e.Xx(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramkk) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label853:
            e.Xy(i);
            AppMethodBeat.o(41401);
            return;
            c(paramkk);
            AppMethodBeat.o(41401);
            return;
            d(paramkk);
            AppMethodBeat.o(41401);
            return;
            e(paramkk);
            AppMethodBeat.o(41401);
            return;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("disable_gamelife_api", false);
              if ((com.tencent.mm.plugin.game.commlib.a.fDW() != null) && (com.tencent.mm.plugin.game.commlib.a.fDW().IJr)) {
                ((JSONObject)localObject1).put("disable_gamelife_api", true);
              }
              label937:
              localObject1 = ((JSONObject)localObject1).toString();
              paramkk.hMb.result = ((String)localObject1);
              AppMethodBeat.o(41401);
              return;
              if (!Util.isNullOrNil(paramkk.hMa.param)) {
                try
                {
                  paramkk = new JSONObject(paramkk.hMa.param);
                  localObject1 = paramkk.optString("appid");
                  int j = paramkk.optInt("version");
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
                  com.tencent.mm.pluginsdk.model.app.h.is((String)localObject1, i);
                  AppMethodBeat.o(41401);
                  return;
                }
                catch (JSONException paramkk) {}
              }
              AppMethodBeat.o(41401);
              return;
              localObject1 = new JSONObject();
              try
              {
                ((JSONObject)localObject1).put("isExDevice", z.bBb());
                label1095:
                localObject1 = ((JSONObject)localObject1).toString();
                paramkk.hMb.result = ((String)localObject1);
              }
              catch (JSONException localJSONException2)
              {
                break label1095;
              }
            }
            catch (JSONException localJSONException3)
            {
              break label937;
            }
          }
          catch (JSONException localJSONException4)
          {
            break label772;
          }
        }
        catch (JSONException localJSONException1)
        {
          break label494;
        }
      }
      catch (JSONException localJSONException6)
      {
        break label218;
      }
    }
  }
  
  private static void a(final List<doh> paramList, final a parama)
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
    doh localdoh = (doh)paramList.remove(0);
    if ((localdoh == null) || (Util.isNullOrNil(localdoh.ThumbUrl)))
    {
      Log.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = ICF + com.tencent.mm.b.g.getMessageDigest(localdoh.ThumbUrl.getBytes());
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    locala.fullPath = ((String)localObject);
    localObject = locala.bKx();
    r.bKe().a(localdoh.ThumbUrl, (com.tencent.mm.modelimage.loader.a.c)localObject, new d()
    {
      public final void onImageDownload(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(275396);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { f.this.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(275396);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem aGI(String paramString)
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
          ((WebViewJSSDKImageItem)paramString).cT(localJSONObject);
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
      ((WebViewJSSDKVideoItem)paramString).cT(localJSONObject);
    }
    AppMethodBeat.o(183857);
    return null;
  }
  
  private static void b(kk paramkk)
  {
    AppMethodBeat.i(41403);
    paramkk = paramkk.hMa.param;
    if (Util.isNullOrNil(paramkk))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramkk);
      j = Util.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramkk = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramkk, localObject });
      if (j == 0)
      {
        Log.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramkk)
    {
      Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramkk.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!Util.isNullOrNil(paramkk))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.c.a.cc(j, paramkk);
        AppMethodBeat.o(41403);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(j, paramkk);
      AppMethodBeat.o(41403);
      return;
    }
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramkk = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramkk.length()) {
          break label293;
        }
        localObject = paramkk.getString(i);
        if (Util.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.c.a.cc(j, (String)localObject);
        } else {
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramkk)
      {
        Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramkk.getMessage() });
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
  
  private static void c(kk paramkk)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.fGh();
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
      label95:
      paramkk.hMb.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
    }
  }
  
  private static void d(kk paramkk)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!Util.isNullOrNil(paramkk.hMa.param)) {
      Log.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramkk.hMa.param });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramkk.hMa.param);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bks(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).kLR().toString();
              if (Util.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.commlib.a.a.class)).aFJ(str2);
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.commlib.a.a.class)).x(str2, str1.getBytes());
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
        paramkk.hMb.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).kLR().toString();
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
  
  private static void e(kk paramkk)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!Util.isNullOrNil(paramkk.hMa.param))
    {
      Log.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramkk.hMa.param });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramkk.hMa.param);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bks((String)localObject2);
          if ((localObject3 != null) && (y.ZC(((WebViewJSSDKFileItem)localObject3).qUK)) && ((Util.isNullOrNil(((WebViewJSSDKFileItem)localObject3).rPM)) || (y.ZC(((WebViewJSSDKFileItem)localObject3).rPM))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.e.aSP((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).field_status;
              localObject3 = c.b.NDQ;
              if (j == c.b.cHj())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).gGF();
                if ((localObject2 == null) || (!y.ZC(((apw)localObject2).NIe)) || (!y.ZC(((apw)localObject2).Zxl))) {
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
        paramkk.hMb.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).gGF();
        if ((localObject2 != null) && (y.ZC(((apw)localObject2).NId)))
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
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.commlib.a.a.class)).aFI((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = aGI(new String((byte[])localObject2));
          if ((localObject2 == null) || (!y.ZC(((WebViewJSSDKFileItem)localObject2).qUK)) || ((!Util.isNullOrNil(((WebViewJSSDKFileItem)localObject2).rPM)) && (!y.ZC(((WebViewJSSDKFileItem)localObject2).rPM)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.g.ivZ().a((WebViewJSSDKFileItem)localObject2);
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