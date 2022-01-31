package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

final class d$1
  implements JsApiAppBrandNFCBase.a
{
  d$1(d paramd) {}
  
  public final void J(int paramInt, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramString = this.gyb;
      if (!(paramString.gfZ.getContext() instanceof Activity))
      {
        paramString.tT(paramString.h("fail: unknown error", null));
        return;
      }
      paramString.fyk = ((Activity)paramString.gfZ.getContext());
      localObject = new Intent(paramString.fyk, paramString.gxX);
      ((Intent)localObject).putExtra("HCE_Result_Receiver", new JsApiNFCStartHCE.2(paramString, ah.fetchFreeHandler(Looper.getMainLooper())));
      paramString.fyk.startActivity((Intent)localObject);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.E(this.gyb.gfZ.getAppId(), paramInt, -1);
    this.gyb.tT(this.gyb.h("fail: " + paramString, (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.1
 * JD-Core Version:    0.7.0.1
 */