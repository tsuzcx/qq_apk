package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class JsApiUploadWeRunData
  extends a
{
  public static final int CTRL_INDEX = 323;
  public static final String NAME = "uploadWeRunData";
  private JsApiUploadWeRunData.UploadMiniAppStepTask hAt;
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130631);
    ab.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiUploadWeRunData", "data is null");
      AppMethodBeat.o(130631);
      return;
    }
    a(this, paramc, paramInt, paramJSONObject.optInt("step"), false);
    AppMethodBeat.o(130631);
  }
  
  public final void a(m paramm, c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(130632);
    if (paramInt2 <= 0)
    {
      paramc.h(paramInt1, paramm.j("fail:step invalid", null));
      AppMethodBeat.o(130632);
      return;
    }
    this.hAt = new JsApiUploadWeRunData.UploadMiniAppStepTask(paramm, paramc, paramInt1, paramInt2, paramBoolean);
    this.hAt.aBj();
    AppBrandMainProcessService.a(this.hAt);
    AppMethodBeat.o(130632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData
 * JD-Core Version:    0.7.0.1
 */