package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  private static final int CTRL_INDEX = 424;
  private static final String NAME = "openRedPacket";
  
  public final boolean biK()
  {
    return true;
  }
  
  public static final class a
    extends n
  {
    public a(m paramm, r paramr, z paramz, JSONObject paramJSONObject, int paramInt)
    {
      super(paramr, paramz, paramJSONObject, paramInt);
    }
    
    public final void C(Intent paramIntent)
    {
      AppMethodBeat.i(46389);
      ae.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
      paramIntent = new HashMap();
      paramIntent.put("errCode", Integer.valueOf(0));
      G(paramIntent);
      AppMethodBeat.o(46389);
    }
    
    public final boolean a(Activity paramActivity, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(174839);
      String str = Ey().getAppId();
      paramJSONObject = paramJSONObject.optString("redPacketId", null);
      if ((bu.isNullOrNil(str)) || (bu.isNullOrNil(paramJSONObject)))
      {
        ae.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", new Object[] { str, paramJSONObject });
        AppMethodBeat.o(174839);
        return false;
      }
      ((com.tencent.mm.plugin.luckymoney.appbrand.a)g.ab(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(paramActivity, paramJSONObject, str, paramInt);
      AppMethodBeat.o(174839);
      return true;
    }
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(46390);
      ae.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramInt));
      o(paramString, localHashMap);
      AppMethodBeat.o(46390);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.a
 * JD-Core Version:    0.7.0.1
 */