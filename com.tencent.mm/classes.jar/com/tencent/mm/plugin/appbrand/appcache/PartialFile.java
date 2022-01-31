package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PartialFile
  implements Parcelable
{
  public static final Parcelable.Creator<PartialFile> CREATOR;
  public String bsd;
  public String cqq;
  public String filePath;
  public String gUB;
  public int version;
  
  static
  {
    AppMethodBeat.i(105315);
    CREATOR = new PartialFile.1();
    AppMethodBeat.o(105315);
  }
  
  public PartialFile() {}
  
  protected PartialFile(Parcel paramParcel)
  {
    AppMethodBeat.i(105314);
    this.bsd = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.gUB = paramParcel.readString();
    this.cqq = paramParcel.readString();
    this.filePath = paramParcel.readString();
    AppMethodBeat.o(105314);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105313);
    paramParcel.writeString(this.bsd);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.gUB);
    paramParcel.writeString(this.cqq);
    paramParcel.writeString(this.filePath);
    AppMethodBeat.o(105313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.PartialFile
 * JD-Core Version:    0.7.0.1
 */