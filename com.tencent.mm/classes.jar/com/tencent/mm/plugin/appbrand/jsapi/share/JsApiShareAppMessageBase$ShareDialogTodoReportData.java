package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class JsApiShareAppMessageBase$ShareDialogTodoReportData
  implements Parcelable
{
  public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
  public String ixZ;
  public int mrA;
  public int mrB;
  public String mry;
  public int mrz;
  public String username;
  
  static
  {
    AppMethodBeat.i(184723);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(184723);
  }
  
  protected JsApiShareAppMessageBase$ShareDialogTodoReportData(Parcel paramParcel)
  {
    AppMethodBeat.i(184722);
    this.mry = paramParcel.readString();
    this.username = paramParcel.readString();
    this.ixZ = paramParcel.readString();
    this.mrz = paramParcel.readInt();
    this.mrA = paramParcel.readInt();
    this.mrB = paramParcel.readInt();
    AppMethodBeat.o(184722);
  }
  
  public JsApiShareAppMessageBase$ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mry = paramString1;
    this.username = paramString2;
    this.ixZ = paramString3;
    this.mrz = paramInt1;
    this.mrA = paramInt2;
    this.mrB = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(184721);
    paramParcel.writeString(this.mry);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.ixZ);
    paramParcel.writeInt(this.mrz);
    paramParcel.writeInt(this.mrA);
    paramParcel.writeInt(this.mrB);
    AppMethodBeat.o(184721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.ShareDialogTodoReportData
 * JD-Core Version:    0.7.0.1
 */