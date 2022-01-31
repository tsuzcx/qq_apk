package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiUploadWeRunData$UploadMiniAppStepTask$1
  implements w.a
{
  JsApiUploadWeRunData$UploadMiniAppStepTask$1(JsApiUploadWeRunData.UploadMiniAppStepTask paramUploadMiniAppStepTask) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(130621);
    if (paramm.getType() != 1949)
    {
      AppMethodBeat.o(130621);
      return 0;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      JsApiUploadWeRunData.UploadMiniAppStepTask.a(this.hAw, true);
      ab.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
    }
    for (;;)
    {
      JsApiUploadWeRunData.UploadMiniAppStepTask.a(this.hAw);
      AppMethodBeat.o(130621);
      return 0;
      JsApiUploadWeRunData.UploadMiniAppStepTask.a(this.hAw, false);
      ab.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask.1
 * JD-Core Version:    0.7.0.1
 */