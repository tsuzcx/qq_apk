package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.g;

final class JsApiLaunchMiniProgram$LaunchPreconditionTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<LaunchPreconditionTask> CREATOR = new JsApiLaunchMiniProgram.LaunchPreconditionTask.1();
  private String gwN;
  private int gwO;
  private int gwP = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.gwQ.ordinal();
  
  JsApiLaunchMiniProgram$LaunchPreconditionTask() {}
  
  JsApiLaunchMiniProgram$LaunchPreconditionTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    g.wr(this.gwN);
    this.gwP = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.gwS.ordinal();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gwN = paramParcel.readString();
    this.gwO = paramParcel.readInt();
    this.gwP = paramParcel.readInt();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gwN);
    paramParcel.writeInt(this.gwO);
    paramParcel.writeInt(this.gwP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.LaunchPreconditionTask
 * JD-Core Version:    0.7.0.1
 */