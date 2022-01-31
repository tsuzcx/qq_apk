package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.luckymoney.appbrand.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b$a
  extends n
{
  public b$a(m paramm, r paramr, v paramv, JSONObject paramJSONObject, int paramInt)
  {
    super(paramm, paramr, paramv, paramJSONObject, paramInt);
  }
  
  public final void D(Intent paramIntent)
  {
    AppMethodBeat.i(131120);
    ab.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
    if ((paramIntent == null) || (paramIntent.getStringExtra("sendId") == null))
    {
      ab.e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", new Object[] { paramIntent });
      onError(-1, "fail:system error {{result data error or sendId is null}}");
      AppMethodBeat.o(131120);
      return;
    }
    String str = paramIntent.getStringExtra("sendId");
    ab.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", new Object[] { str, Boolean.valueOf(paramIntent.getBooleanExtra("result_share_msg", false)) });
    ab.i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
    paramIntent = new HashMap();
    paramIntent.put("errCode", Integer.valueOf(0));
    paramIntent.put("redPacketId", str);
    v(paramIntent);
    AppMethodBeat.o(131120);
  }
  
  public final boolean a(MMActivity paramMMActivity, JSONObject paramJSONObject, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(131119);
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
        ((a)g.E(a.class)).a(paramMMActivity, ws().getAppId(), j, str, paramInt);
        AppMethodBeat.o(131119);
        return true;
        ab.i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
      }
    }
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(131121);
    ab.i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    k(paramString, localHashMap);
    AppMethodBeat.o(131121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.b.a
 * JD-Core Version:    0.7.0.1
 */