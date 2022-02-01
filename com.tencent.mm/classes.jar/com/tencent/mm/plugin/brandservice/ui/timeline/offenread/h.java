package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "bizSessionId", "", "getBizSessionId", "()I", "setBizSessionId", "(I)V", "dataBuffer", "", "getDataBuffer", "()Ljava/lang/String;", "setDataBuffer", "(Ljava/lang/String;)V", "toJsonString", "Companion", "plugin-brandservice_release"})
public final class h
  implements d
{
  public static final a ohm;
  String oha = "";
  int ohl;
  
  static
  {
    AppMethodBeat.i(209810);
    ohm = new a((byte)0);
    AppMethodBeat.o(209810);
  }
  
  public final String aYt()
  {
    AppMethodBeat.i(209809);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("sessionId", this.ohl);
      ((JSONObject)localObject).put("dataBuffer", bt.nullAsNil(this.oha));
      localObject = new JSONObject().put("bizVideoChannelInfo", localObject).toString();
      p.g(localObject, "JSONObject().put(\"bizVid…nelInfo\", obj).toString()");
      AppMethodBeat.o(209809);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BizVideoChannelNativeExtraData", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */