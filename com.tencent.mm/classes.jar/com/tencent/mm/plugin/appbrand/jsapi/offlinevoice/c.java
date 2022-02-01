package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 634;
  public static final String NAME = "setCurrentPaySpeech";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46660);
    ae.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "invoke JsApiSetCurrentPaySpeech!");
    if (paramc == null)
    {
      ae.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:component is null");
      AppMethodBeat.o(46660);
      return;
    }
    if (paramc.getContext() == null)
    {
      ae.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:context is null");
      paramc.h(paramInt, e("fail：service.getContext() is null ", null));
      AppMethodBeat.o(46660);
      return;
    }
    String str1 = paramJSONObject.optString("dialectPackId");
    String str2 = paramJSONObject.optString("tempFilePath");
    String str3 = paramJSONObject.optString("md5Sum");
    boolean bool = paramJSONObject.optBoolean("isOnlyDownload");
    ae.d("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "tempFilePath:%s dialectPackId:%s md5Sum:%s isOnlyDownload:%s", new Object[] { str2, str1, str3, Boolean.valueOf(bool) });
    paramJSONObject = "";
    if (!bu.isNullOrNil(str2))
    {
      paramJSONObject = paramc.Fl().MP(str2);
      if ((paramJSONObject != null) && (paramJSONObject.exists())) {
        paramJSONObject = w.B(paramJSONObject.fTh());
      }
    }
    else
    {
      h.a("com.tencent.mm", new IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam(str1, str2, paramJSONObject, bool, str3), IPCSetCurrentPaySpeech.class, new d() {});
      AppMethodBeat.o(46660);
      return;
    }
    ae.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:tempFile no exist");
    paramc.h(paramInt, e("fail:tempFile no exist", null));
    AppMethodBeat.o(46660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c
 * JD-Core Version:    0.7.0.1
 */