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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class a$a
  extends n
{
  public a$a(m paramm, r paramr, v paramv, JSONObject paramJSONObject, int paramInt)
  {
    super(paramm, paramr, paramv, paramJSONObject, paramInt);
  }
  
  public final void D(Intent paramIntent)
  {
    AppMethodBeat.i(131116);
    ab.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
    paramIntent = new HashMap();
    paramIntent.put("errCode", Integer.valueOf(0));
    v(paramIntent);
    AppMethodBeat.o(131116);
  }
  
  public final boolean a(MMActivity paramMMActivity, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131115);
    String str = ws().getAppId();
    paramJSONObject = paramJSONObject.optString("redPacketId", null);
    if ((bo.isNullOrNil(str)) || (bo.isNullOrNil(paramJSONObject)))
    {
      ab.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", new Object[] { str, paramJSONObject });
      AppMethodBeat.o(131115);
      return false;
    }
    ((a)g.E(a.class)).a(paramMMActivity, paramJSONObject, str, paramInt);
    AppMethodBeat.o(131115);
    return true;
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(131117);
    ab.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    k(paramString, localHashMap);
    AppMethodBeat.o(131117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a
 * JD-Core Version:    0.7.0.1
 */