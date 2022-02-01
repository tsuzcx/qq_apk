package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.luckymoney.appbrand.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 423;
  private static final String NAME = "sendRedPacket";
  
  public static final class a
    extends q
  {
    public a(p paramp, y paramy, ad paramad, JSONObject paramJSONObject, int paramInt)
    {
      super(paramy, paramad, paramJSONObject, paramInt);
    }
    
    public final void F(Intent paramIntent)
    {
      AppMethodBeat.i(46393);
      Log.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
      if ((paramIntent == null) || (paramIntent.getStringExtra("sendId") == null))
      {
        Log.e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", new Object[] { paramIntent });
        onError(-1, "fail:system error {{result data error or sendId is null}}");
        AppMethodBeat.o(46393);
        return;
      }
      String str = paramIntent.getStringExtra("sendId");
      Log.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", new Object[] { str, Boolean.valueOf(paramIntent.getBooleanExtra("result_share_msg", false)) });
      Log.i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
      paramIntent = new HashMap();
      paramIntent.put("errCode", Integer.valueOf(0));
      paramIntent.put("redPacketId", str);
      J(paramIntent);
      AppMethodBeat.o(46393);
    }
    
    public final boolean a(Activity paramActivity, JSONObject paramJSONObject, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(174840);
      String str = paramJSONObject.optString("defaultWishingWord", null);
      paramJSONObject = paramJSONObject.optJSONArray("scope");
      boolean bool1;
      boolean bool2;
      if (paramJSONObject != null)
      {
        bool1 = paramJSONObject.toString().contains("friend");
        bool2 = paramJSONObject.toString().contains("public");
        if ((bool1) && (!bool2)) {
          break label127;
        }
      }
      label127:
      for (int i = 1;; i = 0)
      {
        j = i;
        if (bool2)
        {
          j = i;
          if (bool1) {
            j = 2;
          }
        }
        for (;;)
        {
          ((a)h.ax(a.class)).a(paramActivity, ari().getAppId(), j, str, paramInt);
          AppMethodBeat.o(174840);
          return true;
          Log.i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
        }
      }
    }
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(46394);
      Log.i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramInt));
      o(paramString, localHashMap);
      AppMethodBeat.o(46394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.b
 * JD-Core Version:    0.7.0.1
 */