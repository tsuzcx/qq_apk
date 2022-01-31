package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class av
  extends a
{
  public static final int CTRL_INDEX = 62;
  public static final String NAME = "openAddress";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130513);
    Intent localIntent = new Intent();
    localIntent.putExtra("req_app_id", paramc.getAppId());
    localIntent.putExtra("launch_from_appbrand", true);
    if ((paramc instanceof r))
    {
      paramJSONObject = ((r)paramc).X(Activity.class);
      if ((paramJSONObject != null) && ((paramJSONObject instanceof MMActivity))) {
        break label101;
      }
    }
    label101:
    for (paramJSONObject = null;; paramJSONObject = (MMActivity)paramJSONObject)
    {
      if (paramJSONObject != null) {
        break label109;
      }
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(130513);
      return;
      paramJSONObject = paramc.getContext();
      break;
    }
    label109:
    paramJSONObject.mmSetOnActivityResultCallback(new av.1(this, paramc, paramInt));
    d.a(paramJSONObject, "address", ".ui.WalletSelectAddrUI", localIntent, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(130513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.av
 * JD-Core Version:    0.7.0.1
 */