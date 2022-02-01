package com.tencent.mm.miniutil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MiniReaderLogic$MiniQbFloatBallMenuActionBrandEvent
  implements Parcelable
{
  public static final Parcelable.Creator<MiniQbFloatBallMenuActionBrandEvent> CREATOR;
  public int action;
  public String filePath;
  
  static
  {
    AppMethodBeat.i(150139);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150139);
  }
  
  public MiniReaderLogic$MiniQbFloatBallMenuActionBrandEvent(int paramInt, String paramString)
  {
    this.action = paramInt;
    this.filePath = paramString;
  }
  
  protected MiniReaderLogic$MiniQbFloatBallMenuActionBrandEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(150138);
    this.action = paramParcel.readInt();
    this.filePath = paramParcel.readString();
    AppMethodBeat.o(150138);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150137);
    paramParcel.writeInt(this.action);
    paramParcel.writeString(this.filePath);
    AppMethodBeat.o(150137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent
 * JD-Core Version:    0.7.0.1
 */