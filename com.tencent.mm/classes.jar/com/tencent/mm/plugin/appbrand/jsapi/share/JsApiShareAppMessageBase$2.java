package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class JsApiShareAppMessageBase$2
  implements IPCRunCgi.a
{
  JsApiShareAppMessageBase$2(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, Intent paramIntent, JsApiShareAppMessageBase.d paramd, c paramc, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(226983);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (paramd.iLL.iLR != null) && ((paramd.iLL.iLR instanceof dyb)))
    {
      paramString = (dyb)paramd.iLL.iLR;
      if ((paramString.MXF.dIZ == 0) && (!Util.isNullOrNil(paramString.username)))
      {
        Log.i("MicroMsg.JsApiShareAppMessageBase", "shareTransId success, username:%s", new Object[] { paramString.username });
        this.val$intent.putExtra("Select_Conv_User", paramString.username);
        this.val$intent.putExtra("KSendWording", this.mra.dKq.getResources().getString(2131756165));
        this.mrb.a(this.lzl, this.cvP, this.mra, this.val$intent, true);
        AppMethodBeat.o(226983);
        return;
      }
      if (!Util.isNullOrNil(paramString.MXF.dJa))
      {
        Log.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response error msg:%s", new Object[] { paramString.MXF.dJa });
        this.lzl.i(this.cvP, this.mrb.h("fail:" + paramString.MXF.dJa, null));
        AppMethodBeat.o(226983);
        return;
      }
      Log.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response username is null");
      this.lzl.i(this.cvP, this.mrb.h("fail:response username is null", null));
      AppMethodBeat.o(226983);
      return;
    }
    Log.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, convert openId to username fail");
    this.lzl.i(this.cvP, this.mrb.h("fail:convert openId to username fail", null));
    AppMethodBeat.o(226983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.2
 * JD-Core Version:    0.7.0.1
 */