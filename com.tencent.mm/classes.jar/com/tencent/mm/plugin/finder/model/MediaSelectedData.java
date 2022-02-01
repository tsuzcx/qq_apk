package com.tencent.mm.plugin.finder.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwj;

public class MediaSelectedData
  implements Parcelable
{
  public static final Parcelable.Creator<MediaSelectedData> CREATOR;
  public String path;
  public bwj stz;
  public String thumbPath;
  public int type;
  
  static
  {
    AppMethodBeat.i(168635);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(168635);
  }
  
  public MediaSelectedData(int paramInt)
  {
    this.stz = null;
    this.type = paramInt;
  }
  
  protected MediaSelectedData(Parcel paramParcel)
  {
    AppMethodBeat.i(168634);
    this.stz = null;
    this.path = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.type = paramParcel.readInt();
    AppMethodBeat.o(168634);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(168633);
    String str = "MediaSelectedData{path='" + this.path + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", type=" + this.type + ", cropInfo=" + this.stz + '}';
    AppMethodBeat.o(168633);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(168632);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeInt(this.type);
    AppMethodBeat.o(168632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.MediaSelectedData
 * JD-Core Version:    0.7.0.1
 */