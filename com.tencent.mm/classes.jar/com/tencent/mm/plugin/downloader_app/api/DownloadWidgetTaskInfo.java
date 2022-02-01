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
  public long djM;
  public float kvl;
  public boolean pmW;
  public String poa;
  public int progress;
  public int state;
  
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
    this.djM = paramParcel.readLong();
    this.poa = paramParcel.readString();
    this.progress = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.pmW = bool;
      this.kvl = paramParcel.readFloat();
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
    paramParcel.writeLong(this.djM);
    paramParcel.writeString(this.poa);
    paramParcel.writeInt(this.progress);
    if (this.pmW) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeFloat(this.kvl);
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