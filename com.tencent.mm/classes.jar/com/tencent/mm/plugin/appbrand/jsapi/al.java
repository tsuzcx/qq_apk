package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class al
  extends a
{
  public static final int CTRL_INDEX = 62;
  public static final String NAME = "openAddress";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("req_app_id", paramc.getAppId());
    localIntent.putExtra("launch_from_appbrand", true);
    if ((paramc instanceof o))
    {
      paramJSONObject = ((o)paramc).F(Activity.class);
      if ((paramJSONObject != null) && ((paramJSONObject instanceof MMActivity))) {
        break label91;
      }
    }
    label91:
    for (paramJSONObject = null;; paramJSONObject = (MMActivity)paramJSONObject)
    {
      if (paramJSONObject != null) {
        break label99;
      }
      paramc.C(paramInt, h("fail", null));
      return;
      paramJSONObject = paramc.getContext();
      break;
    }
    label99:
    paramJSONObject.gJb = new al.1(this, paramc, paramInt);
    d.a(paramJSONObject, "address", ".ui.WalletSelectAddrUI", localIntent, hashCode() & 0xFFFF, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al
 * JD-Core Version:    0.7.0.1
 */