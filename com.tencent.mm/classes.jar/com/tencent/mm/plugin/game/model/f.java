package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hp.a;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.recordvideo.background.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String rVs;
  
  static
  {
    AppMethodBeat.i(41406);
    rVs = com.tencent.mm.plugin.game.commlib.e.b.b(b.a.rOH) + "hvmenu/";
    AppMethodBeat.o(41406);
  }
  
  public static void a(hp paramhp)
  {
    AppMethodBeat.i(41401);
    int i = paramhp.dll.BX;
    ad.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41401);
      return;
      Object localObject2 = paramhp.dll.context;
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        localObject2 = e.eW((Context)localObject2);
        if (localObject2 == null) {}
      }
      try
      {
        ((JSONObject)localObject1).put("gameRegionName", e.a((GameRegionPreference.a)localObject2));
        label178:
        paramhp.dlm.result = ((JSONObject)localObject1).toString();
        AppMethodBeat.o(41401);
        return;
        paramhp = paramhp.dll.dln;
        ad.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[] { paramhp });
        if (!bt.isNullOrNil(paramhp))
        {
          com.tencent.mm.kernel.g.aeS().a(1369, new com.tencent.mm.al.g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(41398);
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                ad.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[] { this.iHZ });
                com.tencent.mm.kernel.g.aeS().b(1369, this);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(41397);
                    f.a(this.rVt, f.1.this.iHZ);
                    AppMethodBeat.o(41397);
                  }
                });
                AppMethodBeat.o(41398);
                return;
              }
              ad.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[] { this.iHZ });
              AppMethodBeat.o(41398);
            }
          });
          paramhp = new as(paramhp);
          com.tencent.mm.kernel.g.aeS().a(paramhp, 0);
        }
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramhp.dll.dln;
        ad.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[] { localObject1 });
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBe().abW("pb_game_hv_menu_".concat(String.valueOf(localObject1)));
          if (!bt.cw((byte[])localObject2)) {
            try
            {
              localObject2 = new String((byte[])localObject2, "ISO-8859-1");
              paramhp.dlm.result = ((String)localObject2);
              ad.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[] { localObject1 });
              AppMethodBeat.o(41401);
              return;
            }
            catch (UnsupportedEncodingException paramhp) {}
          }
        }
        AppMethodBeat.o(41401);
        return;
        b(paramhp);
        AppMethodBeat.o(41401);
        return;
        localObject1 = paramhp.dll.context;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new JSONObject();
          localObject2 = e.fe((Context)localObject1);
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            localObject1 = e.cCM();
          }
        }
        try
        {
          ((JSONObject)localObject3).put("regionCode", localObject1);
          label434:
          paramhp.dlm.result = ((JSONObject)localObject3).toString();
          AppMethodBeat.o(41401);
          return;
          com.tencent.mm.plugin.game.commlib.b.cBq().lL(true);
          AppMethodBeat.o(41401);
          return;
          localObject3 = new com.tencent.mm.plugin.game.media.a();
          if (!bt.isNullOrNil(paramhp.dll.dln)) {
            localObject1 = null;
          }
          try
          {
            localObject2 = new JSONObject(paramhp.dll.dln).optJSONArray("albumInfos");
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException3)
          {
            label511:
            break label511;
          }
          ((com.tencent.mm.plugin.game.media.a)localObject3).v((JSONArray)localObject1);
          localObject2 = ((com.tencent.mm.plugin.game.media.a)localObject3).cBU();
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("newVideoDesc", localObject2);
            label539:
            paramhp.dlm.result = ((JSONObject)localObject1).toString();
            AppMethodBeat.o(41401);
            return;
            if (!bt.isNullOrNil(paramhp.dll.dln))
            {
              try
              {
                paramhp = new JSONObject(paramhp.dll.dln);
                i = paramhp.optInt("basic_type");
                if (!paramhp.optBoolean("ban")) {
                  break label617;
                }
                e.Ew(i);
                AppMethodBeat.o(41401);
                return;
              }
              catch (JSONException paramhp) {}
            }
            else
            {
              AppMethodBeat.o(41401);
              return;
            }
            label617:
            e.Ex(i);
            AppMethodBeat.o(41401);
            return;
            c(paramhp);
            AppMethodBeat.o(41401);
            return;
            d(paramhp);
            AppMethodBeat.o(41401);
            return;
            e(paramhp);
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
  
  private static void a(final List<bpp> paramList, final a parama)
  {
    AppMethodBeat.i(41402);
    if (bt.gL(paramList))
    {
      if (parama != null) {
        parama.onComplete();
      }
      AppMethodBeat.o(41402);
      return;
    }
    bpp localbpp = (bpp)paramList.remove(0);
    if ((localbpp == null) || (bt.isNullOrNil(localbpp.ThumbUrl)))
    {
      ad.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
      AppMethodBeat.o(41402);
      return;
    }
    Object localObject = rVs + com.tencent.mm.b.g.getMessageDigest(localbpp.ThumbUrl.getBytes());
    c.a locala = new c.a();
    locala.hjU = true;
    locala.gjt = ((String)localObject);
    localObject = locala.azc();
    o.ayJ().a(localbpp.ThumbUrl, (c)localObject, new com.tencent.mm.aw.a.c.d()
    {
      public final void en(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(41400);
        if (paramAnonymousVarArgs)
        {
          ad.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.rVv.ThumbUrl });
          f.b(paramList, parama);
        }
        AppMethodBeat.o(41400);
      }
    });
    AppMethodBeat.o(41402);
  }
  
  private static WebViewJSSDKFileItem acy(String paramString)
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
  
  private static void b(hp paramhp)
  {
    AppMethodBeat.i(41403);
    paramhp = paramhp.dll.dln;
    if (bt.isNullOrNil(paramhp))
    {
      AppMethodBeat.o(41403);
      return;
    }
    Object localObject;
    int j;
    boolean bool;
    try
    {
      localObject = new JSONObject(paramhp);
      j = bt.getInt(((JSONObject)localObject).getString("game_page_report_id"), 0);
      bool = ((JSONObject)localObject).getBoolean("game_page_report_instantly");
      paramhp = ((JSONObject)localObject).optString("game_page_report_format_data");
      localObject = ((JSONObject)localObject).optString("game_page_report_tabs_format_data");
      ad.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), paramhp, localObject });
      if (j == 0)
      {
        ad.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
        AppMethodBeat.o(41403);
        return;
      }
    }
    catch (JSONException paramhp)
    {
      ad.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[] { paramhp.getMessage() });
      AppMethodBeat.o(41403);
      return;
    }
    if (!bt.isNullOrNil(paramhp))
    {
      if (bool)
      {
        com.tencent.mm.plugin.game.e.a.bg(j, paramhp);
        AppMethodBeat.o(41403);
        return;
      }
      h.vKh.kvStat(j, paramhp);
      AppMethodBeat.o(41403);
      return;
    }
    if (!bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        paramhp = new JSONArray((String)localObject);
        i = 0;
        if (i >= paramhp.length()) {
          break label293;
        }
        localObject = paramhp.getString(i);
        if (bt.isNullOrNil((String)localObject)) {
          break label300;
        }
        if (bool) {
          com.tencent.mm.plugin.game.e.a.bg(j, (String)localObject);
        } else {
          h.vKh.kvStat(j, (String)localObject);
        }
      }
      catch (JSONException paramhp)
      {
        ad.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[] { paramhp.getMessage() });
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
  
  private static void c(hp paramhp)
  {
    AppMethodBeat.i(183854);
    Object localObject1 = e.cCY();
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
      paramhp.dlm.result = ((JSONObject)localObject2).toString();
      AppMethodBeat.o(183854);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label94;
    }
  }
  
  private static void d(hp paramhp)
  {
    AppMethodBeat.i(183855);
    JSONArray localJSONArray1 = new JSONArray();
    if (!bt.isNullOrNil(paramhp.dll.dln)) {
      ad.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", new Object[] { paramhp.dll.dln });
    }
    for (;;)
    {
      int i;
      WebViewJSSDKFileItem localWebViewJSSDKFileItem;
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramhp.dll.dln);
        i = 0;
        if (i < localJSONArray2.length())
        {
          String str2 = localJSONArray2.getString(i);
          localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.emF().awC(str2);
          if (localWebViewJSSDKFileItem == null)
          {
            localJSONArray1.put(false);
          }
          else
          {
            String str1 = null;
            if (localWebViewJSSDKFileItem.mediaType == 1)
            {
              str1 = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).fZv().toString();
              if (bt.isNullOrNil(str1)) {
                break label261;
              }
              ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).abX(str2);
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
        ad.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds result:%s", new Object[] { localObject });
        paramhp.dlm.result = ((String)localObject);
        AppMethodBeat.o(183855);
        return;
        if (localWebViewJSSDKFileItem.mediaType != 4) {
          continue;
        }
        localObject = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).fZv().toString();
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
  
  private static void e(hp paramhp)
  {
    AppMethodBeat.i(183856);
    Object localObject1 = new JSONArray();
    int i;
    Object localObject2;
    int j;
    JSONObject localJSONObject;
    if (!bt.isNullOrNil(paramhp.dll.dln))
    {
      ad.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", new Object[] { paramhp.dll.dln });
      try
      {
        JSONArray localJSONArray = new JSONArray(paramhp.dll.dln);
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getString(i);
          Object localObject3 = com.tencent.mm.plugin.webview.modeltools.g.emF().awC((String)localObject2);
          if ((localObject3 != null) && (i.eK(((WebViewJSSDKFileItem)localObject3).jau)) && ((bt.isNullOrNil(((WebViewJSSDKFileItem)localObject3).jMa)) || (i.eK(((WebViewJSSDKFileItem)localObject3).jMa))))
          {
            ((JSONArray)localObject1).put(true);
          }
          else if (((String)localObject2).startsWith("weixin://bgmixid/"))
          {
            localObject2 = ((String)localObject2).replace("weixin://bgmixid/", "");
            localObject3 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
            localObject2 = com.tencent.mm.plugin.recordvideo.background.f.alz((String)localObject2);
            if (localObject2 != null)
            {
              j = ((com.tencent.mm.plugin.recordvideo.background.d)localObject2).field_status;
              localObject3 = d.b.vdD;
              if (j == d.b.blq())
              {
                localObject2 = ((com.tencent.mm.plugin.recordvideo.background.d)localObject2).dgC();
                if ((localObject2 == null) || (!i.eK(((aer)localObject2).vhU)) || (!i.eK(((aer)localObject2).DeV))) {
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
        paramhp.dlm.result = ((String)localObject1);
        AppMethodBeat.o(183856);
        return;
        localObject2 = ((com.tencent.mm.plugin.recordvideo.background.d)localObject2).dgC();
        if ((localObject2 != null) && (i.eK(((aer)localObject2).vhT)))
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
          localObject2 = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).abW((String)localObject2);
          if ((localObject2 == null) || (localObject2.length == 0)) {
            break label474;
          }
          localObject2 = acy(new String((byte[])localObject2));
          if ((localObject2 == null) || (!i.eK(((WebViewJSSDKFileItem)localObject2).jau)) || ((!bt.isNullOrNil(((WebViewJSSDKFileItem)localObject2).jMa)) && (!i.eK(((WebViewJSSDKFileItem)localObject2).jMa)))) {
            break label474;
          }
          com.tencent.mm.plugin.webview.modeltools.g.emF().a((WebViewJSSDKFileItem)localObject2);
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