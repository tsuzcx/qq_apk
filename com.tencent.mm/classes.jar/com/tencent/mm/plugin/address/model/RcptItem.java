package com.tencent.mm.plugin.address.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RcptItem
  implements Parcelable
{
  public static final Parcelable.Creator<RcptItem> CREATOR;
  public String code;
  public String iyB;
  public boolean iyC;
  public String name;
  
  static
  {
    AppMethodBeat.i(20800);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(20800);
  }
  
  public RcptItem()
  {
    this.name = "";
    this.code = "";
    this.iyB = "";
    this.iyC = false;
  }
  
  public RcptItem(Parcel paramParcel)
  {
    AppMethodBeat.i(20798);
    this.name = "";
    this.code = "";
    this.iyB = "";
    this.iyC = false;
    this.name = paramParcel.readString();
    this.code = paramParcel.readString();
    this.iyB = paramParcel.readString();
    AppMethodBeat.o(20798);
  }
  
  public RcptItem(String paramString1, String paramString2, String paramString3)
  {
    this.name = "";
    this.code = "";
    this.iyB = "";
    this.iyC = false;
    this.name = paramString1;
    this.code = paramString2;
    this.iyB = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(20799);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.iyB);
    AppMethodBeat.o(20799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptItem
 * JD-Core Version:    0.7.0.1
 */