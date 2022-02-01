package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "bizSessionId", "", "getBizSessionId", "()I", "setBizSessionId", "(I)V", "dataBuffer", "", "getDataBuffer", "()Ljava/lang/String;", "setDataBuffer", "(Ljava/lang/String;)V", "toJsonString", "Companion", "plugin-brandservice_release"})
public final class h
  implements d
{
  public static final a nEJ;
  int nEI;
  String nEy = "";
  
  static
  {
    AppMethodBeat.i(198865);
    nEJ = new a((byte)0);
    AppMethodBeat.o(198865);
  }
  
  public final String aUZ()
  {
    AppMethodBeat.i(198864);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("sessionId", this.nEI);
      ((JSONObject)localObject).put("dataBuffer", bs.nullAsNil(this.nEy));
      localObject = new JSONObject().put("bizVideoChannelInfo", localObject).toString();
      k.g(localObject, "JSONObject().put(\"bizVid…nelInfo\", obj).toString()");
      AppMethodBeat.o(198864);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BizVideoChannelNativeExtraData", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizVideoChannelNativeExtraData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */