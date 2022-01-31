package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetBackgroundAudioStateTask> CREATOR = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask.1();
  public String appId;
  public String bTY;
  public boolean error = false;
  private i gfG;
  public int gfg;
  public c ggu;
  public String giD;
  public String gio = "";
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
  {
    this.gfG = parama;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
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
      Object localObject1 = new JSONObject(this.giD);
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
        break label282;
      }
      y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
      str1 = a.a.amd().gNh;
      if ((!bk.bl(str1)) && (!str1.equals(this.appId)))
      {
        y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
      this.error = true;
      this.gio = "parser data fail, data is invalid";
      y.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
      ahI();
      return;
    }
    this.error = false;
    if (localJSONException.equalsIgnoreCase("pause"))
    {
      if (com.tencent.mm.av.b.Pz())
      {
        y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
        return;
      }
      this.error = true;
      this.gio = "pause music fail";
    }
    for (;;)
    {
      ahI();
      return;
      if (localJSONException.equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.av.b.PA())
        {
          y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
          return;
        }
        this.error = true;
        this.gio = "stop music fail";
      }
    }
    label282:
    if (TextUtils.isEmpty(str3))
    {
      y.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
      this.error = true;
      this.gio = "src is null";
      ahI();
      return;
    }
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d, localPath", new Object[] { str3, str4, str5, str6, str1, str2, str7, Integer.valueOf(i), this.bTY });
    Object localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    localObject2 = f.a(11, (String)localObject2, str4, str6, str7, str3, str3, new StringBuilder().append(this.appId).append(str3).append((String)localObject2).toString().hashCode(), com.tencent.mm.compatible.util.e.bkH, tQ((String)localObject2), str5, "");
    ((com.tencent.mm.av.e)localObject2).startTime = (i * 1000);
    ((com.tencent.mm.av.e)localObject2).protocol = str2;
    if (this.bTY.startsWith("file://")) {
      ((com.tencent.mm.av.e)localObject2).euJ = this.bTY;
    }
    a.a.amd().gNi = ((com.tencent.mm.av.e)localObject2).eux;
    com.tencent.mm.av.a.b((com.tencent.mm.av.e)localObject2);
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
    y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
    this.error = false;
    ahI();
  }
  
  public final void Zv()
  {
    if (this.ggu == null)
    {
      y.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
      return;
    }
    if (!this.error)
    {
      y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
      this.ggu.C(this.gfg, this.gfG.h("ok", null));
      return;
    }
    y.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.gio });
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
      this.bTY = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public String tQ(String paramString)
  {
    return com.tencent.mm.loader.a.b.bkH + "/image/" + paramString.hashCode();
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
      paramParcel.writeString(this.bTY);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask
 * JD-Core Version:    0.7.0.1
 */