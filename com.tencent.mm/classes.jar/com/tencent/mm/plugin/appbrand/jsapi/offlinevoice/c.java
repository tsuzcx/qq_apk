package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 634;
  public static final String NAME = "setCurrentPaySpeech";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131374);
    ab.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "invoke JsApiSetCurrentPaySpeech!");
    if (paramc == null)
    {
      ab.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:component is null");
      AppMethodBeat.o(131374);
      return;
    }
    if (paramc.getContext() == null)
    {
      ab.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:context is null");
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131374);
      return;
    }
    String str1 = paramJSONObject.optString("dialectPackId");
    String str2 = paramJSONObject.optString("tempFilePath");
    String str3 = paramJSONObject.optString("md5Sum");
    boolean bool = paramJSONObject.optBoolean("isOnlyDownload");
    ab.d("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "tempFilePath:%s dialectPackId:%s md5Sum:%s isOnlyDownload:%s", new Object[] { str2, str1, str3, Boolean.valueOf(bool) });
    paramJSONObject = "";
    if (!bo.isNullOrNil(str2))
    {
      paramJSONObject = paramc.wX().zg(str2);
      if ((paramJSONObject != null) && (paramJSONObject.exists())) {
        paramJSONObject = paramJSONObject.getAbsolutePath();
      }
    }
    else
    {
      f.a("com.tencent.mm", new IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam(str1, str2, paramJSONObject, bool, str3), IPCSetCurrentPaySpeech.class, new c.1(this, paramc, paramInt));
      AppMethodBeat.o(131374);
      return;
    }
    ab.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:tempFile no exist");
    paramc.h(paramInt, j("fail", null));
    AppMethodBeat.o(131374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c
 * JD-Core Version:    0.7.0.1
 */