package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.luggage.l.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.exv;
import com.tencent.mm.protocal.protobuf.exw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "REQUEST_CODE", "", "getREQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cy
  extends c<k>
{
  @Deprecated
  public static final int CTRL_INDEX = 990;
  @Deprecated
  public static final String NAME = "sendRedCoverAppMsg";
  private static final a rAB;
  final int REQUEST_CODE;
  final String TAG;
  
  static
  {
    AppMethodBeat.i(325447);
    rAB = new a((byte)0);
    AppMethodBeat.o(325447);
  }
  
  public cy()
  {
    AppMethodBeat.i(325444);
    this.TAG = "MicroMsg.JsApiSendRedCoverAppMsg";
    this.REQUEST_CODE = com.tencent.luggage.sdk.h.a.ce(this);
    AppMethodBeat.o(325444);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$invoke$1", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e.c
  {
    b(cy paramcy, k paramk, int paramInt, ah.f<String> paramf) {}
    
    public final boolean onResult(final int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(325709);
      if (paramInt1 != this.rAC.REQUEST_CODE)
      {
        AppMethodBeat.o(325709);
        return false;
      }
      if (paramInt2 == -1) {
        if (paramIntent != null)
        {
          ah.f localf = this.rAE;
          cy localcy = this.rAC;
          final k localk = this.rAD;
          paramInt1 = this.rxe;
          exv localexv = new exv();
          localexv.abzw = ((String)localf.aqH);
          localexv.aavx = paramIntent.getStringExtra("Select_Conv_User");
          Log.i(localcy.TAG, "do send redcover appmsg: " + localf.aqH + ", " + localexv.aavx);
          paramIntent = new c.a();
          paramIntent.funcId = 6446;
          paramIntent.uri = "/cgi-bin/micromsg-bin/sendsharecovermsg";
          paramIntent.otE = ((com.tencent.mm.bx.a)localexv);
          paramIntent.otF = ((com.tencent.mm.bx.a)new exw());
          IPCRunCgi.a(paramIntent.bEF(), (IPCRunCgi.a)new a(localcy, localk, paramInt1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(325709);
        return true;
        this.rAD.callback(this.rxe, this.rAC.ZP("fail:cancel"));
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$invoke$1$onResult$1$1", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "callback", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements IPCRunCgi.a
    {
      a(cy paramcy, k paramk, int paramInt) {}
      
      public final void callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
      {
        AppMethodBeat.i(325635);
        Log.i(this.rAC.TAG, "sendRedCoverAppMsg errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (paramc == null) {
            paramString = null;
          }
        }
        while ((paramString instanceof exw))
        {
          paramString = c.c.b(paramc.otC);
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendShareCoverMsgResp");
            AppMethodBeat.o(325635);
            throw paramString;
            paramString = c.c.b(paramc.otC);
          }
          else
          {
            paramString = (exw)paramString;
            Log.i(this.rAC.TAG, s.X("send result: ", Integer.valueOf(paramString.hAV)));
            if (paramString.hAV == 0)
            {
              localk.callback(paramInt1, this.rAC.ZP("ok"));
              AppMethodBeat.o(325635);
              return;
            }
            localk.callback(paramInt1, this.rAC.ZP("fail:send fail"));
            AppMethodBeat.o(325635);
            return;
            Log.e(this.rAC.TAG, "send error");
            localk.callback(paramInt1, this.rAC.ZP("fail:send error"));
          }
        }
        AppMethodBeat.o(325635);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cy
 * JD-Core Version:    0.7.0.1
 */