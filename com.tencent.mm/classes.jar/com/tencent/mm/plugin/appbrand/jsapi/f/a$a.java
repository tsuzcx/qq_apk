package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.luckymoney.appbrand.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class a$a
  extends j
{
  public a$a(i parami, o paramo, q paramq, JSONObject paramJSONObject, int paramInt)
  {
    super(parami, paramo, paramq, paramJSONObject, paramInt);
  }
  
  protected final boolean a(MMActivity paramMMActivity, JSONObject paramJSONObject, int paramInt)
  {
    String str = Zy().mAppId;
    paramJSONObject = paramJSONObject.optString("redPacketId", null);
    if ((bk.bl(str)) || (bk.bl(paramJSONObject)))
    {
      y.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", new Object[] { str, paramJSONObject });
      return false;
    }
    ((a)g.r(a.class)).a(paramMMActivity, paramJSONObject, str, paramInt);
    return true;
  }
  
  protected final void n(Intent paramIntent)
  {
    y.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
    paramIntent = new HashMap();
    paramIntent.put("errCode", Integer.valueOf(0));
    r(paramIntent);
  }
  
  protected final void onError(int paramInt, String paramString)
  {
    y.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    i(paramString, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a
 * JD-Core Version:    0.7.0.1
 */