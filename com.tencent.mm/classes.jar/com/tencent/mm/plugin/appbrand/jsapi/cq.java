package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eef;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "REQUEST_CODE", "", "getREQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class cq
  extends c<j>
{
  public static final int CTRL_INDEX = 990;
  public static final String NAME = "sendRedCoverAppMsg";
  @Deprecated
  public static final a owY;
  final int REQUEST_CODE;
  final String TAG;
  
  static
  {
    AppMethodBeat.i(270730);
    owY = new a((byte)0);
    AppMethodBeat.o(270730);
  }
  
  public cq()
  {
    AppMethodBeat.i(270729);
    this.TAG = "MicroMsg.JsApiSendRedCoverAppMsg";
    this.REQUEST_CODE = com.tencent.luggage.sdk.h.a.aI(this);
    AppMethodBeat.o(270729);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$invoke$1", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class b
    implements f.c
  {
    b(aa.f paramf, j paramj, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(269231);
      if (paramInt1 != this.owZ.REQUEST_CODE)
      {
        AppMethodBeat.o(269231);
        return false;
      }
      if (paramInt2 == -1) {
        if (paramIntent != null)
        {
          eee localeee = new eee();
          localeee.Uig = ((String)this.oxa.aaBC);
          localeee.Uih = paramIntent.getStringExtra("Select_Conv_User");
          Log.i(this.owZ.TAG, "do send redcover appmsg: " + (String)this.oxa.aaBC + ", " + localeee.Uih);
          d.a locala = new d.a();
          locala.vD(6446);
          locala.TW("/cgi-bin/micromsg-bin/sendsharecovermsg");
          locala.c((com.tencent.mm.cd.a)localeee);
          locala.d((com.tencent.mm.cd.a)new eef());
          IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new a(this, paramIntent));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(269231);
        return true;
        this.oxb.j(this.otk, this.owZ.agS("fail:cancel"));
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$invoke$1$onResult$1$1", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "callback", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-appbrand-integration_release"})
    public static final class a
      implements IPCRunCgi.a
    {
      a(cq.b paramb, Intent paramIntent) {}
      
      public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
      {
        AppMethodBeat.i(281591);
        Log.i(this.oxc.owZ.TAG, "sendRedCoverAppMsg errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramd != null) {
            paramString = paramd.bhY();
          }
        }
        while ((paramString instanceof eef))
        {
          paramString = paramd.bhY();
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendShareCoverMsgResp");
            AppMethodBeat.o(281591);
            throw paramString;
            paramString = null;
          }
          else
          {
            paramString = (eef)paramString;
            Log.i(this.oxc.owZ.TAG, "send result: " + paramString.fwx);
            if (paramString.fwx == 0)
            {
              this.oxc.oxb.j(this.oxc.otk, this.oxc.owZ.agS("ok"));
              AppMethodBeat.o(281591);
              return;
            }
            this.oxc.oxb.j(this.oxc.otk, this.oxc.owZ.agS("fail:send fail"));
            AppMethodBeat.o(281591);
            return;
            Log.e(this.oxc.owZ.TAG, "send error");
            this.oxc.oxb.j(this.oxc.otk, this.oxc.owZ.agS("fail:send error"));
          }
        }
        AppMethodBeat.o(281591);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cq
 * JD-Core Version:    0.7.0.1
 */