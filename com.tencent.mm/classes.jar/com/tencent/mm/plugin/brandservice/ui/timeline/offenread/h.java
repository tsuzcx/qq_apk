package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "bizSessionId", "", "getBizSessionId", "()I", "setBizSessionId", "(I)V", "dataBuffer", "", "getDataBuffer", "()Ljava/lang/String;", "setDataBuffer", "(Ljava/lang/String;)V", "toJsonString", "Companion", "plugin-brandservice_release"})
public final class h
  implements d
{
  public static final a onl;
  String omZ = "";
  int onk;
  
  static
  {
    AppMethodBeat.i(208802);
    onl = new a((byte)0);
    AppMethodBeat.o(208802);
  }
  
  public final String aYO()
  {
    AppMethodBeat.i(208801);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("sessionId", this.onk);
      ((JSONObject)localObject).put("dataBuffer", bu.nullAsNil(this.omZ));
      localObject = new JSONObject().put("bizVideoChannelInfo", localObject).toString();
      p.g(localObject, "JSONObject().put(\"bizVid…nelInfo\", obj).toString()");
      AppMethodBeat.o(208801);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BizVideoChannelNativeExtraData", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */