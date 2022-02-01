package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "convertParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class af
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(325546);
    if (!(paramProcessRequest instanceof DoSetTextStatusRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiSetTextStatus", "handleRequest, request is not DoSetTextStatusRequest");
      AppMethodBeat.o(325546);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiSetTextStatus", "handleRequest, setTextStatus");
    n localn = (n)h.ax(n.class);
    if (localn != null)
    {
      Context localContext = (Context)getActivityContext();
      paramProcessRequest = ((DoSetTextStatusRequest)paramProcessRequest).rwR;
      LinkedList localLinkedList = new LinkedList();
      TextStatusJumpInfo localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "7";
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("username", paramProcessRequest.hzv);
      ((JSONObject)localObject).put("path", paramProcessRequest.qAF);
      ((JSONObject)localObject).put("version", paramProcessRequest.version);
      ((JSONObject)localObject).put("versionType", paramProcessRequest.euz);
      ((JSONObject)localObject).put("headImageURL", paramProcessRequest.phA);
      localTextStatusJumpInfo.busiBuf = ((JSONObject)localObject).toString();
      localObject = ah.aiuX;
      localLinkedList.add(localTextStatusJumpInfo);
      localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "3";
      localTextStatusJumpInfo.busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
      localObject = ah.aiuX;
      localLinkedList.add(localTextStatusJumpInfo);
      paramProcessRequest = new w.a().bdx(paramProcessRequest.appName).bdy("http://wxapp.tc.qq.com/258/20304/stodownload?m=78b18448b71e7f791aad33ecee51e533&filekey=30340201010420301e0202010204025348041078b18448b71e7f791aad33ecee51e53302020ad5040d00000004627466730000000131&hy=SH&storeid=32303231303432373134313731383030306535393731303030303030303037636638353130393030303030313032&bizid=1023").bdu(s.X(paramProcessRequest.appId, "@weapp")).bdv(paramProcessRequest.rBJ).bdr(paramProcessRequest.rBI).bdt(paramProcessRequest.thumbUrl).bdw(paramProcessRequest.verifyInfo).bds(paramProcessRequest.desc).ls((List)localLinkedList).ThS;
      s.s(paramProcessRequest, "Builder()\n            .s…fos)\n            .build()");
      localn.a(localContext, paramProcessRequest);
    }
    finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new EmptyResult());
    AppMethodBeat.o(325546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af
 * JD-Core Version:    0.7.0.1
 */