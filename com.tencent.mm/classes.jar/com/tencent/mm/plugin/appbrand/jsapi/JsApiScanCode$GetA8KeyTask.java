package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.w;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetA8KeyTask> CREATOR = new JsApiScanCode.GetA8KeyTask.2();
  public int actionCode;
  public int bIj;
  public int bIk;
  public String ghx;
  public String ghy;
  public Runnable ghz;
  
  public final void Zu()
  {
    h localh = new h(this.ghx, 36, this.bIj, this.bIk, null, (int)System.currentTimeMillis(), new byte[0]);
    w.a(localh.dmK, new JsApiScanCode.GetA8KeyTask.1(this, localh), true);
  }
  
  public final void Zv()
  {
    if (this.ghz != null) {
      this.ghz.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.ghx = paramParcel.readString();
    this.actionCode = paramParcel.readInt();
    this.ghy = paramParcel.readString();
    this.bIj = paramParcel.readInt();
    this.bIk = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ghx);
    paramParcel.writeInt(this.actionCode);
    paramParcel.writeString(this.ghy);
    paramParcel.writeInt(this.bIj);
    paramParcel.writeInt(this.bIk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask
 * JD-Core Version:    0.7.0.1
 */