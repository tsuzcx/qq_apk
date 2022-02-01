package com.tencent.mm.choosemsgfile.compat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MsgFile
  implements Parcelable
{
  public static final Parcelable.Creator<MsgFile> CREATOR;
  public String fVf;
  public String fileName;
  public String filePath;
  public int fileSize;
  public long timeStamp;
  public String type;
  
  static
  {
    AppMethodBeat.i(127511);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(127511);
  }
  
  public MsgFile() {}
  
  protected MsgFile(Parcel paramParcel)
  {
    AppMethodBeat.i(127510);
    this.fileSize = paramParcel.readInt();
    this.filePath = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.timeStamp = paramParcel.readLong();
    this.type = paramParcel.readString();
    this.fVf = paramParcel.readString();
    AppMethodBeat.o(127510);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(127508);
    String str = "MsgFile{fileSize=" + this.fileSize + ", filePath='" + this.filePath + '\'' + ", fileName='" + this.fileName + '\'' + ", timeStamp=" + this.timeStamp + ", type='" + this.type + '\'' + ", fileExt='" + this.fVf + '\'' + '}';
    AppMethodBeat.o(127508);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127509);
    paramParcel.writeInt(this.fileSize);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.fileName);
    paramParcel.writeLong(this.timeStamp);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.fVf);
    AppMethodBeat.o(127509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.choosemsgfile.compat.MsgFile
 * JD-Core Version:    0.7.0.1
 */