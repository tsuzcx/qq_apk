package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class JsApiShareAppMessageBase$ShareDialogTodoReportData
  implements Parcelable
{
  public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
  public String hiX;
  public String kLv;
  public int kLw;
  public int kLx;
  public int kLy;
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
    this.kLv = paramParcel.readString();
    this.username = paramParcel.readString();
    this.hiX = paramParcel.readString();
    this.kLw = paramParcel.readInt();
    this.kLx = paramParcel.readInt();
    this.kLy = paramParcel.readInt();
    AppMethodBeat.o(184722);
  }
  
  public JsApiShareAppMessageBase$ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.kLv = paramString1;
    this.username = paramString2;
    this.hiX = paramString3;
    this.kLw = paramInt1;
    this.kLx = paramInt2;
    this.kLy = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(184721);
    paramParcel.writeString(this.kLv);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.hiX);
    paramParcel.writeInt(this.kLw);
    paramParcel.writeInt(this.kLx);
    paramParcel.writeInt(this.kLy);
    AppMethodBeat.o(184721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.ShareDialogTodoReportData
 * JD-Core Version:    0.7.0.1
 */