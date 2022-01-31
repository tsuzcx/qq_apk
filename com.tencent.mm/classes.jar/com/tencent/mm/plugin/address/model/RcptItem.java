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
  public String gKS;
  public boolean gKT;
  public String name;
  
  static
  {
    AppMethodBeat.i(16759);
    CREATOR = new RcptItem.1();
    AppMethodBeat.o(16759);
  }
  
  public RcptItem()
  {
    this.name = "";
    this.code = "";
    this.gKS = "";
    this.gKT = false;
  }
  
  public RcptItem(Parcel paramParcel)
  {
    AppMethodBeat.i(16757);
    this.name = "";
    this.code = "";
    this.gKS = "";
    this.gKT = false;
    this.name = paramParcel.readString();
    this.code = paramParcel.readString();
    this.gKS = paramParcel.readString();
    AppMethodBeat.o(16757);
  }
  
  public RcptItem(String paramString1, String paramString2, String paramString3)
  {
    this.name = "";
    this.code = "";
    this.gKS = "";
    this.gKT = false;
    this.name = paramString1;
    this.code = paramString2;
    this.gKS = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(16758);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.gKS);
    AppMethodBeat.o(16758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptItem
 * JD-Core Version:    0.7.0.1
 */