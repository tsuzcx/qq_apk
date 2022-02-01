package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "bizSessionId", "", "getBizSessionId", "()I", "setBizSessionId", "(I)V", "dataBuffer", "", "getDataBuffer", "()Ljava/lang/String;", "setDataBuffer", "(Ljava/lang/String;)V", "toJsonString", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements d
{
  public static final a vQj;
  String vPX = "";
  int vQk;
  
  static
  {
    AppMethodBeat.i(302249);
    vQj = new a((byte)0);
    AppMethodBeat.o(302249);
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(302258);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("sessionId", this.vQk);
      ((JSONObject)localObject).put("dataBuffer", Util.nullAsNil(this.vPX));
      localObject = new JSONObject().put("bizVideoChannelInfo", localObject).toString();
      s.s(localObject, "{\n            val obj = …obj).toString()\n        }");
      AppMethodBeat.o(302258);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.j
 * JD-Core Version:    0.7.0.1
 */