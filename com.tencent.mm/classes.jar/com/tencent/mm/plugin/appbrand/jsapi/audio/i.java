package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.a.a;
import com.tencent.mm.plugin.appbrand.media.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class i
  extends d
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private l.a lDW;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(145729);
    if (!a.acB(paramf.getAppId()))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramf.i(paramInt, h("fail:App is paused or background", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(145729);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramf.i(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      Log.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramf.i(paramInt, h("fail:operationType is empty", null));
      AppMethodBeat.o(145729);
      return;
    }
    if (this.lDW == null) {
      this.lDW = new l.a(paramf);
    }
    this.lDW.appId = paramf.getAppId();
    this.lDW.bjm();
    i.a locala = new i.a(this, paramf, paramInt);
    locala.appId = paramf.getAppId();
    locala.dtX = str1;
    locala.dCS = i;
    locala.lDX = str2;
    if (str2.equalsIgnoreCase("play"))
    {
      long l4 = paramJSONObject.optLong("timestamp", 0L);
      long l3 = System.currentTimeMillis();
      long l1 = l2;
      if (l4 > 0L)
      {
        l1 = l2;
        if (l4 < l3) {
          l1 = l3 - l4;
        }
      }
      locala.iJJ = l1;
      locala.iJK = l3;
    }
    paramf = a.acz(str1);
    if (paramf != null)
    {
      locala.lDY = paramf.lDY;
      locala.lDZ = paramf.lDZ;
      locala.dtT = paramf.dtT;
    }
    locala.processName = MMApplicationContext.getProcessName();
    locala.bjm();
    AppMethodBeat.o(145729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */