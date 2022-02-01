package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.id.a;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String uba;
  
  static
  {
    AppMethodBeat.i(41406);
    uba = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.tTf) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(id paramid)
  {
    AppMethodBeat.i(41401);
    int i = paramid.duG.EN;
    ad.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramid.duG.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.fn((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label186:
        paramid.duH.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramid = paramid.duG.param;
        ad.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramid });
        if (!bt.isNullOrNil(paramid))
        {
          com.tencent.mm.kernel.g.aiU().a(1369, new f.1(paramid));
          paramid = new as(paramid);
          com.tencent.mm.kernel.g.aiU().a(paramid, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramid.duG.param;
        ad.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().all("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!bt.cC((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramid.duH.result = ((String)localObject2);
              ad.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramid) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramid);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramid.duG.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.fv((Context)localObject1);
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            localObject1 = e.cYB();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label442:
          paramid.duH.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          com.tencent.mm.plugin.game.commlib.b.cWV().mW(true);
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!bt.isNullOrNil(paramid.duG.param)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramid.duG.param).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException4)
          {
            label519:
            break label519;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).w((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).cXK();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label547:
            paramid.duH.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!bt.isNullOrNil(paramid.duG.param))
            {
              try
              {
                paramid = new JSONObject(paramid.duG.param);
                i = paramid.optInt("basic_type");
                if (!paramid.optBoolean("ban")) {
                  break label625;
                }
                e.HM(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramid) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label625:
            e.HN(i);
            AppMethodBeat.o(41401);
            return;
            c(paramid);
            AppMethodBeat.o(41401);
            return;
            d(paramid);
            AppMethodBeat.o(41401);
            return;
            e(paramid);
            AppMethodBeat.o(41401);
            return;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("disable_gamelife_api", false);
              if ((com.tencent.mm.plugin.game.commlib.a.cWU() != null) && (com.tencent.mm.plugin.game.commlib.a.cWU().uhl)) {
                ((JSONObject)localObject1).put("disable_gamelife_api", true);
              }
              label706:
              localObject1 = ((JSONObject)localObject1).toString();
              paramid.duH.result = ((String)localObject1);
            }
            catch (JSONException localJSONException2)
            {
              break label706;
            }
          }
          catch (JSONException localJSONException3)
          {
            break label547;
          }
        }
        catch (JSONException localJSONException1)
        {
          break label442;
        }
      }
      catch (JSONException localJSONException5)
      {
        break label186;
      }
    }
  }
  
  private static void a(final List<byv> paramList, final a parama)
  {
    AppMethodBeat.i(41402);
    if (bt.hj(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      AppMethodBeat.o(41402);
      return;
    }
    byv localbyv = (byv)paramList.remove(0);
    if ((localbyv == null) || (bt.isNullOrNil(localbyv.ThumbUrl)))
    {
      ad.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = uba + com.tencent.mm.b.g.getMessageDigest(localbyv.ThumbUrl.getBytes());
    c.a locala = new c.a();
    locala.idr = true;
    locala.hdP = ((String)localObject);
    localObject = locala.aJc();
    com.tencent.mm.aw.q.aIJ().a(localbyv.ThumbUrl, (com.tencent.mm.aw.a.a.c)localObject, new d()
    {
      public final void eK(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41400);
        if (paramAnonymousVarArgs)
        {
          ad.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.ubd.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(41400);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem alS(String paramString)
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
          ((WebViewJSSDKImageItem)paramString).bC(localJSONObject);
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
      ((WebViewJSSDKVideoItem)paramString).bC(localJSONObject);
    }
    AppMethodBeat.o(183857);
    return null;
  }
  
  private static void b(id paramid)
  {
    AppMethodBeat.i(41403);
    paramid = paramid.duG.param;
    if (bt.isNullOrNil(paramid))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramid);
      j = bt.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramid = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      ad.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramid, localObject });
      if (j == 0)
      {
        ad.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramid)
    {
      ad.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramid.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!bt.isNullOrNil(paramid))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.e.a.bo(j, paramid);
        AppMethodBeat.o(41403);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(j, paramid);
      AppMethodBeat.o(41403);
      return;
    }
    if (!bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramid = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramid.length()) {
          break label293;
        }
        localObject = paramid.getString(i);
        if (bt.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.e.a.bo(j, (String)localObject);
        } else {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramid)
      {
        ad.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramid.getMessage() });
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
  
  private static void c(id paramid)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.cYN();
    Object localObject2;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = ((String)localObject1).split(",");
      localObject1 = new JSONArray();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        if (!bt.isNullOrNil(str)) {
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
      paramid.duH.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label94;
    }
  }
  
  private static void d(id paramid)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!bt.isNullOrNil(paramid.duG.param)) {
      ad.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramid.duG.param });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramid.duG.param);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eQU().aHu(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).ftr().toString();
              if (bt.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).alm(str2);
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).q(str2, str1.getBytes());
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
        ad.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds result:%s", new Object[] { localObject });
        paramid.duH.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).ftr().toString();
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
  
  private static void e(id paramid)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!bt.isNullOrNil(paramid.duG.param))
    {
      ad.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramid.duG.param });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramid.duG.param);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.g.eQU().aHu((String)localObject2);
          if ((localObject3 != null) && (i.fv(((WebViewJSSDKFileItem)localObject3).jUC)) && ((bt.isNullOrNil(((WebViewJSSDKFileItem)localObject3).kHB)) || (i.fv(((WebViewJSSDKFileItem)localObject3).kHB))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.e.avy((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).field_status;
              localObject3 = c.b.xuj;
              if (j == c.b.bwj())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).dEG();
                if ((localObject2 == null) || (!i.fv(((aif)localObject2).xyx)) || (!i.fv(((aif)localObject2).GfI))) {
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
        ad.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds result:%s", new Object[] { localObject1 });
        paramid.duH.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).dEG();
        if ((localObject2 != null) && (i.fv(((aif)localObject2).xyw)))
        {
          ((JSONArray)localObject1).put(true);
        }
        else
        {
          label333:
          ((JSONArray)localObject1).put(false);
          break label467;
          if (bt.isNullOrNil((String)localObject2)) {
            break label474;
          }
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).all((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = alS(new String((byte[])localObject2));
          if ((localObject2 == null) || (!i.fv(((WebViewJSSDKFileItem)localObject2).jUC)) || ((!bt.isNullOrNil(((WebViewJSSDKFileItem)localObject2).kHB)) && (!i.fv(((WebViewJSSDKFileItem)localObject2).kHB)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.g.eQU().a((WebViewJSSDKFileItem)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f
 * JD-Core Version:    0.7.0.1
 */