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
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class JsApiShareAppMessageBase$2
  implements IPCRunCgi.a
{
  JsApiShareAppMessageBase$2(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, Intent paramIntent, JsApiShareAppMessageBase.d paramd, c paramc, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(188521);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hNL.hNQ != null) && ((paramb.hNL.hNQ instanceof dec)))
    {
      paramString = (dec)paramb.hNL.hNQ;
      if ((paramString.Hst.dqI == 0) && (!bt.isNullOrNil(paramString.username)))
      {
        ad.i("MicroMsg.JsApiShareAppMessageBase", "shareTransId success, username:%s", new Object[] { paramString.username });
        this.val$intent.putExtra("Select_Conv_User", paramString.username);
        this.val$intent.putExtra("KSendWording", this.lhB.dsa.getResources().getString(2131756050));
        this.lhC.a(this.ksc, this.cjQ, this.lhB, this.val$intent, true);
        AppMethodBeat.o(188521);
        return;
      }
      if (!bt.isNullOrNil(paramString.Hst.dqJ))
      {
        ad.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response error msg:%s", new Object[] { paramString.Hst.dqJ });
        this.ksc.h(this.cjQ, this.lhC.e("fail:" + paramString.Hst.dqJ, null));
        AppMethodBeat.o(188521);
        return;
      }
      ad.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response username is null");
      this.ksc.h(this.cjQ, this.lhC.e("fail:response username is null", null));
      AppMethodBeat.o(188521);
      return;
    }
    ad.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, convert openId to username fail");
    this.ksc.h(this.cjQ, this.lhC.e("fail:convert openId to username fail", null));
    AppMethodBeat.o(188521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.2
 * JD-Core Version:    0.7.0.1
 */