package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 634;
  public static final String NAME = "setCurrentPaySpeech";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46660);
    Log.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "invoke JsApiSetCurrentPaySpeech!");
    if (paramf == null)
    {
      Log.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:component is null");
      AppMethodBeat.o(46660);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:context is null");
      paramf.i(paramInt, h("fail：service.getContext() is null ", null));
      AppMethodBeat.o(46660);
      return;
    }
    String str1 = paramJSONObject.optString("dialectPackId");
    String str2 = paramJSONObject.optString("tempFilePath");
    String str3 = paramJSONObject.optString("md5Sum");
    String str4 = paramJSONObject.optString("version");
    boolean bool = paramJSONObject.optBoolean("isOnlyDownload");
    Log.d("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "tempFilePath:%s dialectPackId:%s md5Sum:%s isOnlyDownload:%s", new Object[] { str2, str1, str3, Boolean.valueOf(bool) });
    paramJSONObject = "";
    if (!Util.isNullOrNil(str2))
    {
      paramJSONObject = paramf.getFileSystem().VY(str2);
      if ((paramJSONObject != null) && (paramJSONObject.exists())) {
        paramJSONObject = aa.z(paramJSONObject.her());
      }
    }
    else
    {
      h.a(MainProcessIPCService.dkO, new IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam(str1, str2, paramJSONObject, bool, str3, str4), IPCSetCurrentPaySpeech.class, new com.tencent.mm.ipcinvoker.d() {});
      AppMethodBeat.o(46660);
      return;
    }
    Log.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:tempFile no exist");
    paramf.i(paramInt, h("fail:tempFile no exist", null));
    AppMethodBeat.o(46660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c
 * JD-Core Version:    0.7.0.1
 */