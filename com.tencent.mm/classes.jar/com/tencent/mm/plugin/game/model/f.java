package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.hw.a;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String tdk;
  
  static
  {
    AppMethodBeat.i(41406);
    tdk = com.tencent.mm.plugin.game.commlib.e.b.b(b.a.sWx) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(hw paramhw)
  {
    AppMethodBeat.i(41401);
    int i = paramhw.diU.CW;
    ac.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramhw.diU.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.fj((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label178:
        paramhw.diV.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramhw = paramhw.diU.param;
        ac.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramhw });
        if (!bs.isNullOrNil(paramhw))
        {
          com.tencent.mm.kernel.g.agi().a(1369, new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(41398);
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                ac.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { this.jib });
                com.tencent.mm.kernel.g.agi().b(1369, this);
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(41397);
                    f.a(this.tdl, f.1.this.jib);
                    AppMethodBeat.o(41397);
                  }
                });
                AppMethodBeat.o(41398);
                return;
              }
              ac.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { this.jib });
              AppMethodBeat.o(41398);
            }
          });
          paramhw = new as(paramhw);
          com.tencent.mm.kernel.g.agi().a(paramhw, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramhw.diU.param;
        ac.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOn().agO("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!bs.cv((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramhw.diV.result = ((String)localObject2);
              ac.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramhw) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramhw);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramhw.diU.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.fr((Context)localObject1);
          localObject1 = localObject2;
          if (bs.isNullOrNil((String)localObject2)) {
            localObject1 = e.cPW();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label434:
          paramhw.diV.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          com.tencent.mm.plugin.game.commlib.b.cOz().mE(true);
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!bs.isNullOrNil(paramhw.diU.param)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramhw.diU.param).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException3)
          {
            label511:
            break label511;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).v((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).cPf();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label539:
            paramhw.diV.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!bs.isNullOrNil(paramhw.diU.param))
            {
              try
              {
                paramhw = new JSONObject(paramhw.diU.param);
                i = paramhw.optInt("basic_type");
                if (!paramhw.optBoolean("ban")) {
                  break label617;
                }
                e.Gs(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramhw) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label617:
            e.Gt(i);
            AppMethodBeat.o(41401);
            return;
            c(paramhw);
            AppMethodBeat.o(41401);
            return;
            d(paramhw);
            AppMethodBeat.o(41401);
            return;
            e(paramhw);
          }
          catch (JSONException localJSONException2)
          {
            break label539;
          }
        }
        catch (JSONException localJSONException1)
        {
          break label434;
        }
      }
      catch (JSONException localJSONException4)
      {
        break label178;
      }
    }
  }
  
  private static void a(final List<bug> paramList, final a parama)
  {
    AppMethodBeat.i(41402);
    if (bs.gY(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      AppMethodBeat.o(41402);
      return;
    }
    bug localbug = (bug)paramList.remove(0);
    if ((localbug == null) || (bs.isNullOrNil(localbug.ThumbUrl)))
    {
      ac.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = tdk + com.tencent.mm.b.g.getMessageDigest(localbug.ThumbUrl.getBytes());
    c.a locala = new c.a();
    locala.hKx = true;
    locala.gKe = ((String)localObject);
    localObject = locala.aFT();
    o.aFB().a(localbug.ThumbUrl, (c)localObject, new d()
    {
      public final void eI(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41400);
        if (paramAnonymousVarArgs)
        {
          ac.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.tdn.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(41400);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem ahq(String paramString)
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
          ((WebViewJSSDKImageItem)paramString).bt(localJSONObject);
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
      ((WebViewJSSDKVideoItem)paramString).bt(localJSONObject);
    }
    AppMethodBeat.o(183857);
    return null;
  }
  
  private static void b(hw paramhw)
  {
    AppMethodBeat.i(41403);
    paramhw = paramhw.diU.param;
    if (bs.isNullOrNil(paramhw))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramhw);
      j = bs.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramhw = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      ac.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramhw, localObject });
      if (j == 0)
      {
        ac.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramhw)
    {
      ac.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramhw.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!bs.isNullOrNil(paramhw))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.e.a.bl(j, paramhw);
        AppMethodBeat.o(41403);
        return;
      }
      h.wUl.kvStat(j, paramhw);
      AppMethodBeat.o(41403);
      return;
    }
    if (!bs.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramhw = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramhw.length()) {
          break label293;
        }
        localObject = paramhw.getString(i);
        if (bs.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.e.a.bl(j, (String)localObject);
        } else {
          h.wUl.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramhw)
      {
        ac.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramhw.getMessage() });
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
  
  private static void c(hw paramhw)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.cQi();
    Object localObject2;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject2 = ((String)localObject1).split(",");
      localObject1 = new JSONArray();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        if (!bs.isNullOrNil(str)) {
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
      paramhw.diV.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label94;
    }
  }
  
  private static void d(hw paramhw)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!bs.isNullOrNil(paramhw.diU.param)) {
      ac.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramhw.diU.param });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramhw.diU.param);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBU(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).fcF().toString();
              if (bs.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).agP(str2);
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).p(str2, str1.getBytes());
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
        ac.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds result:%s", new Object[] { localObject });
        paramhw.diV.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).fcF().toString();
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
  
  private static void e(hw paramhw)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!bs.isNullOrNil(paramhw.diU.param))
    {
      ac.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramhw.diU.param });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramhw.diU.param);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBU((String)localObject2);
          if ((localObject3 != null) && (i.eA(((WebViewJSSDKFileItem)localObject3).jAH)) && ((bs.isNullOrNil(((WebViewJSSDKFileItem)localObject3).kmB)) || (i.eA(((WebViewJSSDKFileItem)localObject3).kmB))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.g.aqy((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.e)localObject2).field_status;
              localObject3 = e.b.wmt;
              if (j == e.b.bsf())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.e)localObject2).duk();
                if ((localObject2 == null) || (!i.eA(((afq)localObject2).wqG)) || (!i.eA(((afq)localObject2).Eyb))) {
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
        ac.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds result:%s", new Object[] { localObject1 });
        paramhw.diV.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.e)localObject2).duk();
        if ((localObject2 != null) && (i.eA(((afq)localObject2).wqF)))
        {
          ((JSONArray)localObject1).put(true);
        }
        else
        {
          label333:
          ((JSONArray)localObject1).put(false);
          break label467;
          if (bs.isNullOrNil((String)localObject2)) {
            break label474;
          }
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).agO((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = ahq(new String((byte[])localObject2));
          if ((localObject2 == null) || (!i.eA(((WebViewJSSDKFileItem)localObject2).jAH)) || ((!bs.isNullOrNil(((WebViewJSSDKFileItem)localObject2).kmB)) && (!i.eA(((WebViewJSSDKFileItem)localObject2).kmB)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.g.eCa().a((WebViewJSSDKFileItem)localObject2);
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