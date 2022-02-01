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
  public long cYu;
  public float kaP;
  public boolean oJp;
  public String oKt;
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
    this.cYu = paramParcel.readLong();
    this.oKt = paramParcel.readString();
    this.progress = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.oJp = bool;
      this.kaP = paramParcel.readFloat();
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
    paramParcel.writeLong(this.cYu);
    paramParcel.writeString(this.oKt);
    paramParcel.writeInt(this.progress);
    if (this.oJp) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeFloat(this.kaP);
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