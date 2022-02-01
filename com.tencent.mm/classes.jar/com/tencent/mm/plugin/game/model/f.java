package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.ie.a;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String umc;
  
  static
  {
    AppMethodBeat.i(41406);
    umc = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.udW) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(ie paramie)
  {
    AppMethodBeat.i(41401);
    int i = paramie.dvL.EN;
    ae.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramie.dvL.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.fr((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label186:
        paramie.dvM.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramie = paramie.dvL.param;
        ae.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramie });
        if (!bu.isNullOrNil(paramie))
        {
          com.tencent.mm.kernel.g.ajj().a(1369, new f.1(paramie));
          paramie = new as(paramie);
          com.tencent.mm.kernel.g.ajj().a(paramie, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramie.dvL.param;
        ae.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZm().amj("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!bu.cF((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramie.dvM.result = ((String)localObject2);
              ae.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramie) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramie);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramie.dvL.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.fz((Context)localObject1);
          localObject1 = localObject2;
          if (bu.isNullOrNil((String)localObject2)) {
            localObject1 = e.dbl();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label442:
          paramie.dvM.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          com.tencent.mm.plugin.game.commlib.b.cZC().na(true);
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!bu.isNullOrNil(paramie.dvL.param)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramie.dvL.param).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException4)
          {
            label519:
            break label519;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).x((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).dau();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label547:
            paramie.dvM.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!bu.isNullOrNil(paramie.dvL.param))
            {
              try
              {
                paramie = new JSONObject(paramie.dvL.param);
                i = paramie.optInt("basic_type");
                if (!paramie.optBoolean("ban")) {
                  break label625;
                }
                e.Ij(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramie) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label625:
            e.Ik(i);
            AppMethodBeat.o(41401);
            return;
            c(paramie);
            AppMethodBeat.o(41401);
            return;
            d(paramie);
            AppMethodBeat.o(41401);
            return;
            e(paramie);
            AppMethodBeat.o(41401);
            return;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("disable_gamelife_api", false);
              if ((com.tencent.mm.plugin.game.commlib.a.cZy() != null) && (com.tencent.mm.plugin.game.commlib.a.cZy().usI)) {
                ((JSONObject)localObject1).put("disable_gamelife_api", true);
              }
              label706:
              localObject1 = ((JSONObject)localObject1).toString();
              paramie.dvM.result = ((String)localObject1);
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
  
  private static void a(final List<bzp> paramList, final a parama)
  {
    AppMethodBeat.i(41402);
    if (bu.ht(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      AppMethodBeat.o(41402);
      return;
    }
    bzp localbzp = (bzp)paramList.remove(0);
    if ((localbzp == null) || (bu.isNullOrNil(localbzp.ThumbUrl)))
    {
      ae.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = umc + com.tencent.mm.b.g.getMessageDigest(localbzp.ThumbUrl.getBytes());
    c.a locala = new c.a();
    locala.igk = true;
    locala.hgD = ((String)localObject);
    localObject = locala.aJu();
    com.tencent.mm.av.q.aJb().a(localbzp.ThumbUrl, (com.tencent.mm.av.a.a.c)localObject, new d()
    {
      public final void eM(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41400);
        if (paramAnonymousVarArgs)
        {
          ae.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.umf.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(41400);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem amS(String paramString)
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
  
  private static void b(ie paramie)
  {
    AppMethodBeat.i(41403);
    paramie = paramie.dvL.param;
    if (bu.isNullOrNil(paramie))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramie);
      j = bu.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramie = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      ae.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramie, localObject });
      if (j == 0)
      {
        ae.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramie)
    {
      ae.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramie.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!bu.isNullOrNil(paramie))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.e.a.bn(j, paramie);
        AppMethodBeat.o(41403);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(j, paramie);
      AppMethodBeat.o(41403);
      return;
    }
    if (!bu.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramie = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramie.length()) {
          break label293;
        }
        localObject = paramie.getString(i);
        if (bu.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.e.a.bn(j, (String)localObject);
        } else {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramie)
      {
        ae.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramie.getMessage() });
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
  
  private static void c(ie paramie)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.dbx();
    Object localObject2;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = ((String)localObject1).split(",");
      localObject1 = new JSONArray();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        if (!bu.isNullOrNil(str)) {
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
      paramie.dvM.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label94;
    }
  }
  
  private static void d(ie paramie)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!bu.isNullOrNil(paramie.dvL.param)) {
      ae.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramie.dvL.param });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramie.dvL.param);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).eUc().toString();
              if (bu.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).amk(str2);
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
        ae.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds result:%s", new Object[] { localObject });
        paramie.dvM.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).eUc().toString();
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
  
  private static void e(ie paramie)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!bu.isNullOrNil(paramie.dvL.param))
    {
      ae.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramie.dvL.param });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramie.dvL.param);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN((String)localObject2);
          if ((localObject3 != null) && (o.fB(((WebViewJSSDKFileItem)localObject3).jXT)) && ((bu.isNullOrNil(((WebViewJSSDKFileItem)localObject3).kKQ)) || (o.fB(((WebViewJSSDKFileItem)localObject3).kKQ))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.e.awN((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).field_status;
              localObject3 = c.b.xKg;
              if (j == c.b.bxa())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).dHX();
                if ((localObject2 == null) || (!o.fB(((aip)localObject2).xOt)) || (!o.fB(((aip)localObject2).Gyq))) {
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
        ae.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds result:%s", new Object[] { localObject1 });
        paramie.dvM.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject2).dHX();
        if ((localObject2 != null) && (o.fB(((aip)localObject2).xOs)))
        {
          ((JSONArray)localObject1).put(true);
        }
        else
        {
          label333:
          ((JSONArray)localObject1).put(false);
          break label467;
          if (bu.isNullOrNil((String)localObject2)) {
            break label474;
          }
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).amj((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = amS(new String((byte[])localObject2));
          if ((localObject2 == null) || (!o.fB(((WebViewJSSDKFileItem)localObject2).jXT)) || ((!bu.isNullOrNil(((WebViewJSSDKFileItem)localObject2).kKQ)) && (!o.fB(((WebViewJSSDKFileItem)localObject2).kKQ)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.g.eUG().a((WebViewJSSDKFileItem)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f
 * JD-Core Version:    0.7.0.1
 */