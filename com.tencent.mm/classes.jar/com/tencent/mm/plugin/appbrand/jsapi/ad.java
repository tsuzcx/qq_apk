package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "convertParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class ad
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(274281);
    if (!(paramProcessRequest instanceof DoSetTextStatusRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiSetTextStatus", "handleRequest, request is not DoSetTextStatusRequest");
      AppMethodBeat.o(274281);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiSetTextStatus", "handleRequest, setTextStatus");
    com.tencent.mm.plugin.textstatus.a.l locall = (com.tencent.mm.plugin.textstatus.a.l)h.ae(com.tencent.mm.plugin.textstatus.a.l.class);
    if (locall != null)
    {
      Context localContext = (Context)bPf();
      paramProcessRequest = ((DoSetTextStatusRequest)paramProcessRequest).osS;
      LinkedList localLinkedList = new LinkedList();
      TextStatusJumpInfo localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "7";
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("username", paramProcessRequest.fvb);
      localJSONObject.put("path", paramProcessRequest.nBq);
      localJSONObject.put("version", paramProcessRequest.version);
      localJSONObject.put("versionType", paramProcessRequest.cBU);
      localJSONObject.put("headImageURL", paramProcessRequest.mnM);
      localTextStatusJumpInfo.busiBuf = localJSONObject.toString();
      localLinkedList.add(localTextStatusJumpInfo);
      localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "3";
      localTextStatusJumpInfo.busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
      localLinkedList.add(localTextStatusJumpInfo);
      paramProcessRequest = new q.a().bei(paramProcessRequest.appName).bej("http://wxapp.tc.qq.com/258/20304/stodownload?m=78b18448b71e7f791aad33ecee51e533&filekey=30340201010420301e0202010204025348041078b18448b71e7f791aad33ecee51e53302020ad5040d00000004627466730000000131&hy=SH&storeid=32303231303432373134313731383030306535393731303030303030303037636638353130393030303030313032&bizid=1023").bef(paramProcessRequest.appId + "@weapp").beg(paramProcessRequest.oym).bec(paramProcessRequest.oyl).bee(paramProcessRequest.thumbUrl).beh(paramProcessRequest.verifyInfo).bed(paramProcessRequest.desc).im((List)localLinkedList).gkO();
      p.j(paramProcessRequest, "SetStatusParam.Builder()…fos)\n            .build()");
      locall.a(localContext, paramProcessRequest);
    }
    b((AppBrandProxyUIProcessTask.ProcessResult)new EmptyResult());
    AppMethodBeat.o(274281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad
 * JD-Core Version:    0.7.0.1
 */