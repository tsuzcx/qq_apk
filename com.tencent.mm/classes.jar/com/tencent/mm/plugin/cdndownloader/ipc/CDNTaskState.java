package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskState
  implements Parcelable
{
  public static final Parcelable.Creator<CDNTaskState> CREATOR;
  public long completeSize = 0L;
  public long fileTotalSize = 0L;
  public int taskState = -100;
  
  static
  {
    AppMethodBeat.i(120763);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(120763);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(120762);
    paramParcel.writeInt(this.taskState);
    paramParcel.writeLong(this.completeSize);
    paramParcel.writeLong(this.fileTotalSize);
    AppMethodBeat.o(120762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState
 * JD-Core Version:    0.7.0.1
 */