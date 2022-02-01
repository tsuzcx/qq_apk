package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends c<y>
{
  private static final int CTRL_INDEX = 424;
  private static final String NAME = "openRedPacket";
  
  public final boolean cpE()
  {
    return true;
  }
  
  public static final class a
    extends q
  {
    public a(p paramp, y paramy, ad paramad, JSONObject paramJSONObject, int paramInt)
    {
      super(paramy, paramad, paramJSONObject, paramInt);
    }
    
    public final void F(Intent paramIntent)
    {
      AppMethodBeat.i(46389);
      Log.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
      paramIntent = new HashMap();
      paramIntent.put("errCode", Integer.valueOf(0));
      J(paramIntent);
      AppMethodBeat.o(46389);
    }
    
    public final boolean a(Activity paramActivity, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(174839);
      String str = ari().getAppId();
      paramJSONObject = paramJSONObject.optString("redPacketId", null);
      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramJSONObject)))
      {
        Log.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", new Object[] { str, paramJSONObject });
        AppMethodBeat.o(174839);
        return false;
      }
      ((com.tencent.mm.plugin.luckymoney.appbrand.a)h.ax(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(paramActivity, paramJSONObject, str, paramInt);
      AppMethodBeat.o(174839);
      return true;
    }
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(46390);
      Log.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramInt));
      o(paramString, localHashMap);
      AppMethodBeat.o(46390);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a
 * JD-Core Version:    0.7.0.1
 */