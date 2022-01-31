package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.ag.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$9
  implements a.a
{
  c$9(c paramc) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 128) {
      y.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission requestCode is not for sms");
    }
    do
    {
      return;
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
      {
        if (paramArrayOfInt == null) {}
        for (int i = -1;; i = paramArrayOfInt.length)
        {
          y.w("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
          return;
        }
      }
      if (paramArrayOfInt[0] != 0) {
        break;
      }
      y.i("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission permission is grant for sms");
    } while (this.gkx.gkr == null);
    this.gkx.gkr.start();
    return;
    y.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission sys perm denied for sms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.9
 * JD-Core Version:    0.7.0.1
 */