package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "bizSessionId", "", "getBizSessionId", "()I", "setBizSessionId", "(I)V", "dataBuffer", "", "getDataBuffer", "()Ljava/lang/String;", "setDataBuffer", "(Ljava/lang/String;)V", "toJsonString", "Companion", "plugin-brandservice_release"})
public final class i
  implements d
{
  public static final a pAb;
  int pAa;
  String pzP = "";
  
  static
  {
    AppMethodBeat.i(195520);
    pAb = new a((byte)0);
    AppMethodBeat.o(195520);
  }
  
  public final String bua()
  {
    AppMethodBeat.i(195519);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("sessionId", this.pAa);
      ((JSONObject)localObject).put("dataBuffer", Util.nullAsNil(this.pzP));
      localObject = new JSONObject().put("bizVideoChannelInfo", localObject).toString();
      p.g(localObject, "JSONObject().put(\"bizVid…nelInfo\", obj).toString()");
      AppMethodBeat.o(195519);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BizVideoChannelNativeExtraData", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.i
 * JD-Core Version:    0.7.0.1
 */