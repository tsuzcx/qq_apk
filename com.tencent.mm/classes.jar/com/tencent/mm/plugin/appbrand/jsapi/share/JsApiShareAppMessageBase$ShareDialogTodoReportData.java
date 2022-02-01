package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class JsApiShareAppMessageBase$ShareDialogTodoReportData
  implements Parcelable
{
  public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR;
  public String hDU;
  public String llJ;
  public int llK;
  public int llL;
  public int llM;
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
    this.llJ = paramParcel.readString();
    this.username = paramParcel.readString();
    this.hDU = paramParcel.readString();
    this.llK = paramParcel.readInt();
    this.llL = paramParcel.readInt();
    this.llM = paramParcel.readInt();
    AppMethodBeat.o(184722);
  }
  
  public JsApiShareAppMessageBase$ShareDialogTodoReportData(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.llJ = paramString1;
    this.username = paramString2;
    this.hDU = paramString3;
    this.llK = paramInt1;
    this.llL = paramInt2;
    this.llM = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(184721);
    paramParcel.writeString(this.llJ);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.hDU);
    paramParcel.writeInt(this.llK);
    paramParcel.writeInt(this.llL);
    paramParcel.writeInt(this.llM);
    AppMethodBeat.o(184721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.ShareDialogTodoReportData
 * JD-Core Version:    0.7.0.1
 */