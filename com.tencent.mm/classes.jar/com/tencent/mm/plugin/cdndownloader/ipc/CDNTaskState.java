package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskState
  implements Parcelable
{
  public static final Parcelable.Creator<CDNTaskState> CREATOR = new CDNTaskState.1();
  public int completeSize = 0;
  public int fileTotalSize = 0;
  public int taskState = -100;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.taskState);
    paramParcel.writeInt(this.completeSize);
    paramParcel.writeInt(this.fileTotalSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState
 * JD-Core Version:    0.7.0.1
 */