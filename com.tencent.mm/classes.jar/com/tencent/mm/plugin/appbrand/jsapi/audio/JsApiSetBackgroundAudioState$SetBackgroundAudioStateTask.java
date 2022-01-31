package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetBackgroundAudioStateTask> CREATOR;
  public String appId;
  public String cBD;
  public boolean error;
  public String hBF;
  public String hBW;
  public int hry;
  private m hxs;
  public c hyO;
  
  static
  {
    AppMethodBeat.i(137789);
    CREATOR = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask.1();
    AppMethodBeat.o(137789);
  }
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(137783);
    this.error = false;
    this.hBF = "";
    f(paramParcel);
    AppMethodBeat.o(137783);
  }
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
  {
    this.error = false;
    this.hBF = "";
    this.hxs = parama;
    this.hyO = paramc;
    this.hry = paramInt;
  }
  
  public String BQ(String paramString)
  {
    AppMethodBeat.i(137784);
    paramString = com.tencent.mm.loader.j.b.eQz + "/image/" + paramString.hashCode();
    AppMethodBeat.o(137784);
    return paramString;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(137785);
    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
    String str3;
    String str4;
    String str5;
    String str6;
    String str1;
    String str7;
    String str2;
    int i;
    try
    {
      Object localObject1 = new JSONObject(this.hBW);
      str3 = ((JSONObject)localObject1).optString("src");
      str4 = ((JSONObject)localObject1).optString("title");
      str5 = ((JSONObject)localObject1).optString("epname");
      str6 = ((JSONObject)localObject1).optString("singer");
      str1 = ((JSONObject)localObject1).optString("coverImgUrl");
      str7 = ((JSONObject)localObject1).optString("webUrl");
      str2 = ((JSONObject)localObject1).optString("protocol");
      i = ((JSONObject)localObject1).optInt("startTime", 0);
      localObject1 = ((JSONObject)localObject1).optString("operationType");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label312;
      }
      ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
      str1 = a.a.aHK().ipb;
      if ((!bo.isNullOrNil(str1)) && (!str1.equals(this.appId)))
      {
        ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
        AppMethodBeat.o(137785);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
      this.error = true;
      this.hBF = "parser data fail, data is invalid";
      ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
      aBp();
      AppMethodBeat.o(137785);
      return;
    }
    this.error = false;
    if (localJSONException.equalsIgnoreCase("pause"))
    {
      if (com.tencent.mm.aw.b.aiC())
      {
        ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
        AppMethodBeat.o(137785);
        return;
      }
      this.error = true;
      this.hBF = "pause music fail";
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(137785);
      return;
      if (localJSONException.equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.aw.b.aiD())
        {
          ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
          AppMethodBeat.o(137785);
          return;
        }
        this.error = true;
        this.hBF = "stop music fail";
      }
    }
    label312:
    if (TextUtils.isEmpty(str3))
    {
      ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
      this.error = true;
      this.hBF = "src is null";
      aBp();
      AppMethodBeat.o(137785);
      return;
    }
    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d, localPath", new Object[] { str3, str4, str5, str6, str1, str2, str7, Integer.valueOf(i), this.cBD });
    Object localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    localObject2 = f.a(11, (String)localObject2, str4, str6, str7, str3, str3, new StringBuilder().append(this.appId).append(str3).append((String)localObject2).toString().hashCode(), com.tencent.mm.compatible.util.e.eQz, BQ((String)localObject2), str5, this.appId);
    ((com.tencent.mm.aw.e)localObject2).startTime = (i * 1000);
    ((com.tencent.mm.aw.e)localObject2).protocol = str2;
    if (this.cBD.startsWith("file://")) {
      ((com.tencent.mm.aw.e)localObject2).fKv = this.cBD;
    }
    a.a.aHK().ipc = ((com.tencent.mm.aw.e)localObject2).fKj;
    com.tencent.mm.aw.a.b((com.tencent.mm.aw.e)localObject2);
    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
    this.error = false;
    aBp();
    AppMethodBeat.o(137785);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(137786);
    if (this.hyO == null)
    {
      ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
      AppMethodBeat.o(137786);
      return;
    }
    if (!this.error)
    {
      ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
      this.hyO.h(this.hry, this.hxs.j("ok", null));
      AppMethodBeat.o(137786);
      return;
    }
    ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.hBF });
    this.hyO.h(this.hry, this.hxs.j("fail:" + this.hBF, null));
    AppMethodBeat.o(137786);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(137787);
    this.appId = paramParcel.readString();
    this.hBW = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.error = bool;
      this.hBF = paramParcel.readString();
      this.cBD = paramParcel.readString();
      AppMethodBeat.o(137787);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137788);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hBW);
    if (this.error) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hBF);
      paramParcel.writeString(this.cBD);
      AppMethodBeat.o(137788);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask
 * JD-Core Version:    0.7.0.1
 */