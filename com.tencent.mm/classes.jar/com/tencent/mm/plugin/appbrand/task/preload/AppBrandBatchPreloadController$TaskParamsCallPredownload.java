package com.tencent.mm.plugin.appbrand.task.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBatchPreloadController$TaskParamsCallPredownload
  implements Parcelable
{
  public static final Parcelable.Creator<TaskParamsCallPredownload> CREATOR;
  String appId;
  int appType;
  String path;
  boolean qSs;
  int scene;
  
  static
  {
    AppMethodBeat.i(48493);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48493);
  }
  
  protected AppBrandBatchPreloadController$TaskParamsCallPredownload(Parcel paramParcel)
  {
    AppMethodBeat.i(48492);
    this.appId = paramParcel.readString();
    this.appType = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.scene = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.qSs = bool;
      AppMethodBeat.o(48492);
      return;
      bool = false;
    }
  }
  
  public AppBrandBatchPreloadController$TaskParamsCallPredownload(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.appId = paramString1;
    this.appType = paramInt1;
    this.path = paramString2;
    this.scene = paramInt2;
    this.qSs = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48491);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.appType);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.scene);
    if (this.qSs) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(48491);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.TaskParamsCallPredownload
 * JD-Core Version:    0.7.0.1
 */