package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;
import org.json.JSONArray;
import org.json.JSONObject;

final class c$4
  implements RGBConfigRequester
{
  c$4(c paramc, String paramString) {}
  
  public final RGBConfigRequester.YTColorSeqReq getColorSeqReq()
  {
    AppMethodBeat.i(792);
    RGBConfigRequester.YTColorSeqReq localYTColorSeqReq = new RGBConfigRequester.YTColorSeqReq("", "", "");
    AppMethodBeat.o(792);
    return localYTColorSeqReq;
  }
  
  public final void request(String paramString, RGBConfigRequester.RGBConfigRequestCallBack paramRGBConfigRequestCallBack)
  {
    AppMethodBeat.i(793);
    ab.i("MicroMsg.FaceReflectLogic", " get config lightList");
    paramString = "";
    String str1 = paramString;
    try
    {
      JSONArray localJSONArray = new JSONObject(this.msc).optJSONArray("face_action_seq");
      String str2 = paramString;
      if (localJSONArray != null)
      {
        int i = 0;
        for (;;)
        {
          str1 = paramString;
          str2 = paramString;
          if (i >= localJSONArray.length()) {
            break;
          }
          str1 = paramString;
          JSONObject localJSONObject = localJSONArray.optJSONObject(i);
          str2 = paramString;
          if (localJSONObject != null)
          {
            str2 = paramString;
            str1 = paramString;
            if (localJSONObject.optInt("action_id", 0) == 6)
            {
              str1 = paramString;
              str2 = localJSONObject.optString("action_data");
            }
          }
          i += 1;
          paramString = str2;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.FaceReflectLogic", paramString, "parse action data error", new Object[0]);
      str2 = str1;
      ab.i("MicroMsg.FaceReflectLogic", "get actionData: %s", new Object[] { str2 });
      if (!bo.isNullOrNil(str2))
      {
        h.qsU.idkeyStat(917L, 5L, 1L, false);
        paramRGBConfigRequestCallBack.onSuccess(str2);
        AppMethodBeat.o(793);
        return;
      }
      h.qsU.idkeyStat(917L, 6L, 1L, false);
      paramRGBConfigRequestCallBack.onFailed(-1);
      AppMethodBeat.o(793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.4
 * JD-Core Version:    0.7.0.1
 */