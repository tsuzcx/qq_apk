package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;
import org.json.JSONArray;
import org.json.JSONObject;

final class b$4
  implements RGBConfigRequester
{
  b$4(b paramb, String paramString) {}
  
  public final RGBConfigRequester.YTColorSeqReq getColorSeqReq()
  {
    return new RGBConfigRequester.YTColorSeqReq("", "", "");
  }
  
  public final void request(String paramString, RGBConfigRequester.RGBConfigRequestCallBack paramRGBConfigRequestCallBack)
  {
    y.i("MicroMsg.FaceReflectLogic", " get config lightList");
    paramString = "";
    String str1 = paramString;
    try
    {
      JSONArray localJSONArray = new JSONObject(this.jXL).optJSONArray("face_action_seq");
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
      y.printErrStackTrace("MicroMsg.FaceReflectLogic", paramString, "parse action data error", new Object[0]);
      str2 = str1;
      y.i("MicroMsg.FaceReflectLogic", "get actionData: %s", new Object[] { str2 });
      if (!bk.bl(str2))
      {
        h.nFQ.a(917L, 5L, 1L, false);
        paramRGBConfigRequestCallBack.onSuccess(str2);
        return;
      }
      h.nFQ.a(917L, 6L, 1L, false);
      paramRGBConfigRequestCallBack.onFailed(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.4
 * JD-Core Version:    0.7.0.1
 */