package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends d<s>
{
  private static final int CTRL_INDEX = 424;
  private static final String NAME = "openRedPacket";
  
  public final boolean bEa()
  {
    return true;
  }
  
  public static final class a
    extends q
  {
    public a(p paramp, s params, ac paramac, JSONObject paramJSONObject, int paramInt)
    {
      super(params, paramac, paramJSONObject, paramInt);
    }
    
    public final void C(Intent paramIntent)
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
      String str = NY().getAppId();
      paramJSONObject = paramJSONObject.optString("redPacketId", null);
      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramJSONObject)))
      {
        Log.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", new Object[] { str, paramJSONObject });
        AppMethodBeat.o(174839);
        return false;
      }
      ((com.tencent.mm.plugin.luckymoney.appbrand.a)g.af(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(paramActivity, paramJSONObject, str, paramInt);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */