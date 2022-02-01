package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class JsApiShareAppMessageBase$1
  implements IPCRunCgi.a
{
  JsApiShareAppMessageBase$1(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, Intent paramIntent, JsApiShareAppMessageBase.d paramd, c paramc, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(174890);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.gUT.gUX != null) && ((paramb.gUT.gUX instanceof cte)))
    {
      paramString = (cte)paramb.gUT.gUX;
      if ((paramString.EkN.dhR == 0) && (!bt.isNullOrNil(paramString.username)))
      {
        ad.i("MicroMsg.JsApiShareAppMessageBase", "shareTransId success, username:%s", new Object[] { paramString.username });
        this.val$intent.putExtra("Select_Conv_User", paramString.username);
        this.val$intent.putExtra("KSendWording", this.kjL.djj.getResources().getString(2131756050));
        this.kjM.a(this.jxl, this.ccB, this.kjL, this.val$intent, true);
        AppMethodBeat.o(174890);
        return;
      }
      if (!bt.isNullOrNil(paramString.EkN.dhS))
      {
        ad.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response error msg:%s", new Object[] { paramString.EkN.dhS });
        this.jxl.h(this.ccB, this.kjM.e("fail:" + paramString.EkN.dhS, null));
        AppMethodBeat.o(174890);
        return;
      }
      ad.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response username is null");
      this.jxl.h(this.ccB, this.kjM.e("fail:response username is null", null));
      AppMethodBeat.o(174890);
      return;
    }
    ad.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, convert openId to username fail");
    this.jxl.h(this.ccB, this.kjM.e("fail:convert openId to username fail", null));
    AppMethodBeat.o(174890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.1
 * JD-Core Version:    0.7.0.1
 */