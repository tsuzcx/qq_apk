package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.av.c;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR = new JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask.1();
  public String appId = "";
  public int bFN;
  public int duration = 0;
  public int eCF;
  public int eaX;
  public String eaY;
  public boolean error = false;
  public String gio;
  public String gip;
  public String giq;
  public String gir;
  public String gis;
  public String protocol;
  public int startTime;
  public String title;
  
  public JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask() {}
  
  public JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    Object localObject = a.a.amd().gNh;
    if ((!bk.bl((String)localObject)) && (!((String)localObject).equals(this.appId)))
    {
      y.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
      this.error = true;
      this.gio = "appid not match cannot get background audio state";
      ahI();
      return;
    }
    localObject = com.tencent.mm.av.a.Pw();
    c localc;
    int j;
    int i;
    if (localObject != null)
    {
      localc = com.tencent.mm.av.a.Px();
      if (localc == null) {
        break label437;
      }
      j = localc.mDuration;
      i = localc.mPosition;
    }
    for (;;)
    {
      if ((localc == null) || (j < 0) || (i < 0))
      {
        y.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        this.error = true;
        this.gio = "return parameter is invalid";
        ahI();
        return;
      }
      j /= 1000;
      int k = i / 1000;
      int m = localc.mStatus;
      i = localc.eut;
      if (j > 0) {}
      for (i = i * j / 100;; i = 0)
      {
        this.duration = j;
        this.bFN = k;
        if (m == 1)
        {
          j = 0;
          this.eCF = j;
          this.eaY = ((e)localObject).euD;
          this.eaX = i;
          this.title = ((e)localObject).euz;
          this.gip = ((e)localObject).euB;
          this.giq = ((e)localObject).euA;
          this.gir = ((e)localObject).euC;
          this.gis = ((e)localObject).euF;
          this.protocol = ((e)localObject).protocol;
          this.startTime = ((e)localObject).startTime;
          y.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s", new Object[] { Integer.valueOf(this.duration), Integer.valueOf(this.bFN), Integer.valueOf(this.eCF), Integer.valueOf(this.eaX), this.eaY, Integer.valueOf(this.startTime), this.title, this.giq, this.gis, this.gir, this.protocol });
        }
        for (;;)
        {
          ahI();
          return;
          j = 1;
          break;
          y.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
          this.error = true;
          this.gio = "currentWrapper is null";
        }
      }
      label437:
      i = -1;
      j = -1;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.duration = paramParcel.readInt();
    this.bFN = paramParcel.readInt();
    this.eCF = paramParcel.readInt();
    this.eaX = paramParcel.readInt();
    this.eaY = paramParcel.readString();
    this.title = paramParcel.readString();
    this.gip = paramParcel.readString();
    this.giq = paramParcel.readString();
    this.gir = paramParcel.readString();
    this.gis = paramParcel.readString();
    this.protocol = paramParcel.readString();
    this.startTime = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.bFN);
    paramParcel.writeInt(this.eCF);
    paramParcel.writeInt(this.eaX);
    paramParcel.writeString(this.eaY);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.gip);
    paramParcel.writeString(this.giq);
    paramParcel.writeString(this.gir);
    paramParcel.writeString(this.gis);
    paramParcel.writeString(this.protocol);
    paramParcel.writeInt(this.startTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask
 * JD-Core Version:    0.7.0.1
 */