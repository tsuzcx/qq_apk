package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio$OperateBackgroundAudioTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateBackgroundAudioTask> CREATOR = new JsApiOperateBackgroundAudio.OperateBackgroundAudioTask.1();
  public String appId;
  public boolean error = false;
  private i gfG;
  public int gfg;
  public c ggu;
  public String giD;
  public String gio = "";
  
  public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
  {
    this.gfG = parama;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
    Object localObject = a.a.amd().gNh;
    if ((!bk.bl((String)localObject)) && (!((String)localObject).equals(this.appId)))
    {
      y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
      this.error = true;
      this.gio = "appid not match cannot operate";
      ahI();
      return;
    }
    String str;
    int i;
    try
    {
      localObject = new JSONObject(this.giD);
      str = ((JSONObject)localObject).optString("operationType");
      i = ((JSONObject)localObject).optInt("currentTime", -1);
      if (TextUtils.isEmpty(str))
      {
        y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
        this.error = true;
        this.gio = "operationType is null";
        ahI();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.giD });
      this.error = true;
      this.gio = "parser data fail, data is invalid";
      y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
      ahI();
      return;
    }
    y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", new Object[] { str, Integer.valueOf(i) });
    this.error = false;
    if (str.equalsIgnoreCase("play"))
    {
      e locale = com.tencent.mm.av.a.Pw();
      if (locale != null) {
        a.a.amd().gNi = locale.eux;
      }
      if (b.Py()) {
        y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
      }
    }
    for (;;)
    {
      if (this.error) {
        y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.gio);
      }
      ahI();
      return;
      if (com.tencent.mm.av.a.Pu())
      {
        this.error = true;
        this.gio = "music is playing, don't play again";
      }
      else
      {
        this.error = true;
        this.gio = "play music fail";
        continue;
        if (str.equalsIgnoreCase("pause"))
        {
          if (b.Pz())
          {
            y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
          }
          else
          {
            this.error = true;
            this.gio = "pause music fail";
          }
        }
        else if (str.equalsIgnoreCase("seek"))
        {
          if (i < 0)
          {
            y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
            this.error = true;
            this.gio = "currentTime is invalid";
          }
          else if (com.tencent.mm.av.a.iV(i * 1000))
          {
            y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
          }
          else
          {
            this.error = true;
            this.gio = "seek music fail";
          }
        }
        else if (str.equalsIgnoreCase("stop"))
        {
          if (b.PA())
          {
            y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
          }
          else
          {
            this.error = true;
            this.gio = "stop music fail";
          }
        }
        else
        {
          y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
          this.error = true;
          this.gio = "operationType is invalid";
        }
      }
    }
  }
  
  public final void Zv()
  {
    if (this.ggu == null)
    {
      y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
      return;
    }
    if (!this.error)
    {
      y.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
      this.ggu.C(this.gfg, this.gfG.h("ok", null));
      return;
    }
    y.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.gio });
    this.ggu.C(this.gfg, this.gfG.h("fail:" + this.gio, null));
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.appId = paramParcel.readString();
    this.giD = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.error = bool;
      this.gio = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.giD);
    if (this.error) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.gio);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.OperateBackgroundAudioTask
 * JD-Core Version:    0.7.0.1
 */