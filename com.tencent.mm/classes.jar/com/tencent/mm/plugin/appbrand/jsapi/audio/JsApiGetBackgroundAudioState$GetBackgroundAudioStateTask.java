package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
  public String appId;
  public String ceq;
  public boolean error;
  public int fSw;
  public String hBF;
  public double hBG;
  public double hBH;
  public double hBI;
  public String hBJ;
  public String hBK;
  public String hBL;
  public String hBM;
  public String protocol;
  public int startTime;
  public String title;
  
  static
  {
    AppMethodBeat.i(137735);
    CREATOR = new JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask.1();
    AppMethodBeat.o(137735);
  }
  
  public JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask()
  {
    this.appId = "";
    this.hBG = 0.0D;
    this.error = false;
  }
  
  public JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(137731);
    this.appId = "";
    this.hBG = 0.0D;
    this.error = false;
    f(paramParcel);
    AppMethodBeat.o(137731);
  }
  
  public final void ata()
  {
    double d = 0.0D;
    AppMethodBeat.i(137732);
    Object localObject = a.a.aHK().ipb;
    if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
    {
      ab.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
      this.error = true;
      this.hBF = "appid not match cannot get background audio state";
      aBp();
      AppMethodBeat.o(137732);
      return;
    }
    localObject = com.tencent.mm.aw.a.aiz();
    int i;
    if (localObject != null)
    {
      c localc = com.tencent.mm.aw.a.aiA();
      int j = -1;
      i = -1;
      if (localc != null)
      {
        j = localc.mDuration;
        i = localc.mPosition;
      }
      if ((localc == null) || (j < 0) || (i < 0))
      {
        ab.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        this.error = true;
        this.hBF = "return parameter is invalid";
        aBp();
        AppMethodBeat.o(137732);
        return;
      }
      this.hBG = (j / 1000.0D);
      this.hBH = (i / 1000.0D);
      i = localc.mStatus;
      j = localc.fKf;
      if (this.hBG > 0.0D) {
        d = j * this.hBG / 100.0D;
      }
      this.hBI = d;
      if (i == 1)
      {
        i = 0;
        this.fSw = i;
        this.ceq = ((e)localObject).fKp;
        this.title = ((e)localObject).fKl;
        this.hBJ = ((e)localObject).fKn;
        this.hBK = ((e)localObject).fKm;
        this.hBL = ((e)localObject).fKo;
        this.hBM = ((e)localObject).fKr;
        this.protocol = ((e)localObject).protocol;
        this.startTime = ((e)localObject).startTime;
        ab.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s", new Object[] { Double.valueOf(this.hBG), Double.valueOf(this.hBH), Integer.valueOf(this.fSw), Double.valueOf(this.hBI), this.ceq, Integer.valueOf(this.startTime), this.title, this.hBK, this.hBM, this.hBL, this.protocol });
      }
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(137732);
      return;
      i = 1;
      break;
      ab.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
      this.error = true;
      this.hBF = "currentWrapper is null";
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(137733);
    this.appId = paramParcel.readString();
    this.hBG = paramParcel.readDouble();
    this.hBH = paramParcel.readDouble();
    this.fSw = paramParcel.readInt();
    this.hBI = paramParcel.readDouble();
    this.ceq = paramParcel.readString();
    this.title = paramParcel.readString();
    this.hBJ = paramParcel.readString();
    this.hBK = paramParcel.readString();
    this.hBL = paramParcel.readString();
    this.hBM = paramParcel.readString();
    this.protocol = paramParcel.readString();
    this.startTime = paramParcel.readInt();
    AppMethodBeat.o(137733);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137734);
    paramParcel.writeString(this.appId);
    paramParcel.writeDouble(this.hBG);
    paramParcel.writeDouble(this.hBH);
    paramParcel.writeInt(this.fSw);
    paramParcel.writeDouble(this.hBI);
    paramParcel.writeString(this.ceq);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.hBJ);
    paramParcel.writeString(this.hBK);
    paramParcel.writeString(this.hBL);
    paramParcel.writeString(this.hBM);
    paramParcel.writeString(this.protocol);
    paramParcel.writeInt(this.startTime);
    AppMethodBeat.o(137734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask
 * JD-Core Version:    0.7.0.1
 */