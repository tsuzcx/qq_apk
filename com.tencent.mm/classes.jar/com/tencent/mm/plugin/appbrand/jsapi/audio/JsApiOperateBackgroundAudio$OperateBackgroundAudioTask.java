package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio$OperateBackgroundAudioTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateBackgroundAudioTask> CREATOR;
  public String appId;
  public boolean error;
  public String hBF;
  public String hBW;
  public int hry;
  private m hxs;
  public c hyO;
  
  static
  {
    AppMethodBeat.i(137758);
    CREATOR = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask.1();
    AppMethodBeat.o(137758);
  }
  
  public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(Parcel paramParcel)
  {
    AppMethodBeat.i(137753);
    this.error = false;
    this.hBF = "";
    f(paramParcel);
    AppMethodBeat.o(137753);
  }
  
  public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
  {
    this.error = false;
    this.hBF = "";
    this.hxs = parama;
    this.hyO = paramc;
    this.hry = paramInt;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(137754);
    ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
    Object localObject = a.a.aHK().ipb;
    if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
    {
      ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
      this.error = true;
      this.hBF = "appid not match cannot operate";
      aBp();
      AppMethodBeat.o(137754);
      return;
    }
    String str;
    int i;
    try
    {
      localObject = new JSONObject(this.hBW);
      str = ((JSONObject)localObject).optString("operationType");
      i = ((JSONObject)localObject).optInt("currentTime", -1);
      if (TextUtils.isEmpty(str))
      {
        ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
        this.error = true;
        this.hBF = "operationType is null";
        aBp();
        AppMethodBeat.o(137754);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.hBW });
      this.error = true;
      this.hBF = "parser data fail, data is invalid";
      ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
      aBp();
      AppMethodBeat.o(137754);
      return;
    }
    ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", new Object[] { str, Integer.valueOf(i) });
    this.error = false;
    e locale;
    if (str.equalsIgnoreCase("play"))
    {
      locale = com.tencent.mm.aw.a.aiz();
      if (locale != null) {
        a.a.aHK().ipc = locale.fKj;
      }
      if (b.aiB()) {
        ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
      }
    }
    for (;;)
    {
      if (this.error) {
        ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.hBF);
      }
      aBp();
      AppMethodBeat.o(137754);
      return;
      if (com.tencent.mm.aw.a.aiw())
      {
        this.error = true;
        this.hBF = "music is playing, don't play again";
      }
      else if ((locale != null) && (this.appId.equals(locale.fKw)))
      {
        ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
        com.tencent.mm.aw.a.b(locale);
      }
      else
      {
        this.error = true;
        this.hBF = "play music fail";
        continue;
        if (str.equalsIgnoreCase("pause"))
        {
          if (b.aiC())
          {
            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
          }
          else
          {
            this.error = true;
            this.hBF = "pause music fail";
          }
        }
        else if (str.equalsIgnoreCase("seek"))
        {
          if (i < 0)
          {
            ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
            this.error = true;
            this.hBF = "currentTime is invalid";
          }
          else if (com.tencent.mm.aw.a.lN(i * 1000))
          {
            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
          }
          else
          {
            this.error = true;
            this.hBF = "seek music fail";
          }
        }
        else if (str.equalsIgnoreCase("stop"))
        {
          if (b.aiD())
          {
            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
          }
          else
          {
            this.error = true;
            this.hBF = "stop music fail";
          }
        }
        else
        {
          ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
          this.error = true;
          this.hBF = "operationType is invalid";
        }
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(137755);
    if (this.hyO == null)
    {
      ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
      AppMethodBeat.o(137755);
      return;
    }
    if (!this.error)
    {
      ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
      this.hyO.h(this.hry, this.hxs.j("ok", null));
      AppMethodBeat.o(137755);
      return;
    }
    ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.hBF });
    this.hyO.h(this.hry, this.hxs.j("fail:" + this.hBF, null));
    AppMethodBeat.o(137755);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(137756);
    this.appId = paramParcel.readString();
    this.hBW = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.error = bool;
      this.hBF = paramParcel.readString();
      AppMethodBeat.o(137756);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137757);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hBW);
    if (this.error) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hBF);
      AppMethodBeat.o(137757);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.OperateBackgroundAudioTask
 * JD-Core Version:    0.7.0.1
 */