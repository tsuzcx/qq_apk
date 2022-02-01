package com.tencent.mm.plugin.downloader_app.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadWidgetTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadWidgetTaskInfo> CREATOR;
  public String appId;
  public long hyV;
  public int progress;
  public float rCn;
  public int state;
  public String vXL;
  public boolean xop;
  
  static
  {
    AppMethodBeat.i(175251);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(175251);
  }
  
  public DownloadWidgetTaskInfo() {}
  
  private DownloadWidgetTaskInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(175249);
    this.appId = paramParcel.readString();
    this.hyV = paramParcel.readLong();
    this.vXL = paramParcel.readString();
    this.progress = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.xop = bool;
      this.rCn = paramParcel.readFloat();
      this.state = paramParcel.readInt();
      AppMethodBeat.o(175249);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(175250);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.hyV);
    paramParcel.writeString(this.vXL);
    paramParcel.writeInt(this.progress);
    if (this.xop) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeFloat(this.rCn);
      paramParcel.writeInt(this.state);
      AppMethodBeat.o(175250);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo
 * JD-Core Version:    0.7.0.1
 */