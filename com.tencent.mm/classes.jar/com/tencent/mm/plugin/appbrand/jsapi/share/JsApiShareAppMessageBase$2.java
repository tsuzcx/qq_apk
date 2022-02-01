package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class JsApiShareAppMessageBase$2
  implements IPCRunCgi.a
{
  JsApiShareAppMessageBase$2(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, Intent paramIntent, JsApiShareAppMessageBase.d paramd, c paramc, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(222671);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hQE.hQJ != null) && ((paramb.hQE.hQJ instanceof dew)))
    {
      paramString = (dew)paramb.hQE.hQJ;
      if ((paramString.HLW.drN == 0) && (!bu.isNullOrNil(paramString.username)))
      {
        ae.i("MicroMsg.JsApiShareAppMessageBase", "shareTransId success, username:%s", new Object[] { paramString.username });
        this.val$intent.putExtra("Select_Conv_User", paramString.username);
        this.val$intent.putExtra("KSendWording", this.lln.dtg.getResources().getString(2131756050));
        this.llo.a(this.kvs, this.cjS, this.lln, this.val$intent, true);
        AppMethodBeat.o(222671);
        return;
      }
      if (!bu.isNullOrNil(paramString.HLW.drO))
      {
        ae.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response error msg:%s", new Object[] { paramString.HLW.drO });
        this.kvs.h(this.cjS, this.llo.e("fail:" + paramString.HLW.drO, null));
        AppMethodBeat.o(222671);
        return;
      }
      ae.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response username is null");
      this.kvs.h(this.cjS, this.llo.e("fail:response username is null", null));
      AppMethodBeat.o(222671);
      return;
    }
    ae.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, convert openId to username fail");
    this.kvs.h(this.cjS, this.llo.e("fail:convert openId to username fail", null));
    AppMethodBeat.o(222671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.2
 * JD-Core Version:    0.7.0.1
 */