package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.it.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String xEu;
  
  static
  {
    AppMethodBeat.i(41406);
    xEu = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.xvI) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(it paramit)
  {
    AppMethodBeat.i(41401);
    int i = paramit.dNs.EX;
    Log.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramit.dNs.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.fX((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label210:
        paramit.dNt.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramit = paramit.dNs.param;
        Log.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramit });
        if (!Util.isNullOrNil(paramit))
        {
          com.tencent.mm.kernel.g.azz().a(1369, new i()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
            {
              AppMethodBeat.i(41398);
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { this.kFU });
                com.tencent.mm.kernel.g.azz().b(1369, this);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(41397);
                    f.a(this.xEv, f.1.this.kFU);
                    AppMethodBeat.o(41397);
                  }
                });
                AppMethodBeat.o(41398);
                return;
              }
              Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { this.kFU });
              AppMethodBeat.o(41398);
            }
          });
          paramit = new as(paramit);
          com.tencent.mm.kernel.g.azz().a(paramit, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramit.dNs.param;
        Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!Util.isNullOrNil((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramit.dNt.result = ((String)localObject2);
              Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramit) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramit);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramit.dNs.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.gf((Context)localObject1);
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = e.dUS();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label486:
          paramit.dNt.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          i = Util.getInt(paramit.dNs.param, 0);
          com.tencent.mm.plugin.game.commlib.b.dTd().I(true, i);
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!Util.isNullOrNil(paramit.dNs.param)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramit.dNs.param).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException5)
          {
            label580:
            break label580;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).y((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).dUc();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label613:
            paramit.dNt.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!Util.isNullOrNil(paramit.dNs.param))
            {
              try
              {
                paramit = new JSONObject(paramit.dNs.param);
                i = paramit.optInt("basic_type");
                if (!paramit.optBoolean("ban")) {
                  break label692;
                }
                e.Ok(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramit) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label692:
            e.Ol(i);
            AppMethodBeat.o(41401);
            return;
            c(paramit);
            AppMethodBeat.o(41401);
            return;
            d(paramit);
            AppMethodBeat.o(41401);
            return;
            e(paramit);
            AppMethodBeat.o(41401);
            return;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("disable_gamelife_api", false);
              if ((com.tencent.mm.plugin.game.commlib.a.dSY() != null) && (com.tencent.mm.plugin.game.commlib.a.dSY().xLa)) {
                ((JSONObject)localObject1).put("disable_gamelife_api", true);
              }
              label776:
              localObject1 = ((JSONObject)localObject1).toString();
              paramit.dNt.result = ((String)localObject1);
              AppMethodBeat.o(41401);
              return;
              if (!Util.isNullOrNil(paramit.dNs.param)) {
                try
                {
                  paramit = new JSONObject(paramit.dNs.param);
                  localObject1 = paramit.optString("appid");
                  int j = paramit.optInt("version");
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
                  com.tencent.mm.pluginsdk.model.app.h.gE((String)localObject1, i);
                  AppMethodBeat.o(41401);
                  return;
                }
                catch (JSONException paramit) {}
              }
              AppMethodBeat.o(41401);
              return;
              localObject1 = new JSONObject();
              try
              {
                ((JSONObject)localObject1).put("isExDevice", z.aUh());
                label934:
                localObject1 = ((JSONObject)localObject1).toString();
                paramit.dNt.result = ((String)localObject1);
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
  
  private static void a(final List<coq> paramList, final a parama)
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
    coq localcoq = (coq)paramList.remove(0);
    if ((localcoq == null) || (Util.isNullOrNil(localcoq.ThumbUrl)))
    {
      Log.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = xEu + com.tencent.mm.b.g.getMessageDigest(localcoq.ThumbUrl.getBytes());
    c.a locala = new c.a();
    locala.jbf = true;
    locala.fullPath = ((String)localObject);
    localObject = locala.bdv();
    com.tencent.mm.av.q.bcV().a(localcoq.ThumbUrl, (com.tencent.mm.av.a.a.c)localObject, new com.tencent.mm.av.a.c.d()
    {
      public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(204148);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.xEx.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(204148);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem aAi(String paramString)
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
          ((WebViewJSSDKImageItem)paramString).cb(localJSONObject);
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
      ((WebViewJSSDKVideoItem)paramString).cb(localJSONObject);
    }
    AppMethodBeat.o(183857);
    return null;
  }
  
  private static void b(it paramit)
  {
    AppMethodBeat.i(41403);
    paramit = paramit.dNs.param;
    if (Util.isNullOrNil(paramit))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramit);
      j = Util.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramit = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramit, localObject });
      if (j == 0)
      {
        Log.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramit)
    {
      Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramit.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!Util.isNullOrNil(paramit))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.d.a.bz(j, paramit);
        AppMethodBeat.o(41403);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(j, paramit);
      AppMethodBeat.o(41403);
      return;
    }
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramit = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramit.length()) {
          break label293;
        }
        localObject = paramit.getString(i);
        if (Util.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.d.a.bz(j, (String)localObject);
        } else {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramit)
      {
        Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramit.getMessage() });
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
  
  private static void c(it paramit)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.dVe();
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
      paramit.dNt.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label94;
    }
  }
  
  private static void d(it paramit)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!Util.isNullOrNil(paramit.dNs.param)) {
      Log.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramit.dNs.param });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramit.dNs.param);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).gWR().toString();
              if (Util.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).azo(str2);
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).q(str2, str1.getBytes());
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
        paramit.dNt.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).gWR().toString();
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
  
  private static void e(it paramit)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!Util.isNullOrNil(paramit.dNs.param))
    {
      Log.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramit.dNs.param });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramit.dNs.param);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO((String)localObject2);
          if ((localObject3 != null) && (s.YS(((WebViewJSSDKFileItem)localObject3).laR)) && ((Util.isNullOrNil(((WebViewJSSDKFileItem)localObject3).lPx)) || (s.YS(((WebViewJSSDKFileItem)localObject3).lPx))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.e.aLf((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).field_status;
              localObject3 = c.b.BKk;
              if (j == c.b.bTk())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).eIK();
                if ((localObject2 == null) || (!s.YS(((ald)localObject2).BOA)) || (!s.YS(((ald)localObject2).Lue))) {
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
        paramit.dNt.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).eIK();
        if ((localObject2 != null) && (s.YS(((ald)localObject2).BOz)))
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
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).azn((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = aAi(new String((byte[])localObject2));
          if ((localObject2 == null) || (!s.YS(((WebViewJSSDKFileItem)localObject2).laR)) || ((!Util.isNullOrNil(((WebViewJSSDKFileItem)localObject2).lPx)) && (!s.YS(((WebViewJSSDKFileItem)localObject2).lPx)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.g.gdv().a((WebViewJSSDKFileItem)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f
 * JD-Core Version:    0.7.0.1
 */