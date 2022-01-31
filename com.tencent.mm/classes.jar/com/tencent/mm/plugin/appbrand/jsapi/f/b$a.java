package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.luckymoney.appbrand.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b$a
  extends j
{
  public b$a(i parami, o paramo, q paramq, JSONObject paramJSONObject, int paramInt)
  {
    super(parami, paramo, paramq, paramJSONObject, paramInt);
  }
  
  protected final boolean a(MMActivity paramMMActivity, JSONObject paramJSONObject, int paramInt)
  {
    int j = 0;
    String str = paramJSONObject.optString("defaultWishingWord", null);
    paramJSONObject = paramJSONObject.optJSONArray("scope");
    boolean bool1;
    boolean bool2;
    if (paramJSONObject != null)
    {
      bool1 = paramJSONObject.toString().contains("friend");
      bool2 = paramJSONObject.toString().contains("public");
      if ((bool1) && (!bool2)) {
        break label117;
      }
    }
    label117:
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
        ((a)g.r(a.class)).a(paramMMActivity, Zy().mAppId, j, str, paramInt);
        return true;
        y.i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
      }
    }
  }
  
  protected final void n(Intent paramIntent)
  {
    y.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
    if ((paramIntent == null) || (paramIntent.getStringExtra("sendId") == null))
    {
      y.e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", new Object[] { paramIntent });
      onError(-1, "fail:system error {{result data error or sendId is null}}");
      return;
    }
    String str = paramIntent.getStringExtra("sendId");
    y.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", new Object[] { str, Boolean.valueOf(paramIntent.getBooleanExtra("result_share_msg", false)) });
    y.i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
    paramIntent = new HashMap();
    paramIntent.put("errCode", Integer.valueOf(0));
    paramIntent.put("redPacketId", str);
    r(paramIntent);
  }
  
  protected final void onError(int paramInt, String paramString)
  {
    y.i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    i(paramString, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.b.a
 * JD-Core Version:    0.7.0.1
 */