package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class WordingInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WordingInfo> CREATOR;
  public static final a iDC;
  public final String iDA;
  public final String iDB;
  public final String iDr;
  public final String iDs;
  public final String iDt;
  public final String iDu;
  public final String iDv;
  public final String iDw;
  public final String iDx;
  public final String iDy;
  private final String iDz;
  
  static
  {
    AppMethodBeat.i(149560);
    iDC = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149560);
  }
  
  public WordingInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(149559);
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDr = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDs = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDt = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDu = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDv = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDw = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDx = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDy = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDz = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iDA = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.iDB = paramParcel;
    AppMethodBeat.o(149559);
  }
  
  public WordingInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(149558);
    this.iDr = paramString1;
    this.iDs = paramString2;
    this.iDt = paramString3;
    this.iDu = paramString4;
    this.iDv = paramString5;
    this.iDw = paramString6;
    this.iDx = paramString7;
    this.iDy = paramString8;
    this.iDz = paramString9;
    this.iDA = paramString10;
    this.iDB = paramString11;
    AppMethodBeat.o(149558);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149557);
    String str = "WordingInfo(PopupTitle='" + this.iDr + "', PopupAllow='" + this.iDs + "', PopupCancel='" + this.iDt + "', PopupBottom='" + this.iDu + "', ExampleTitle='" + this.iDv + "', AlwaysReject='" + this.iDw + "', PopupDesc='" + this.iDx + "', SendWording='" + this.iDy + "', MultiRemind='" + this.iDz + "', WxaMultiRemind='" + this.iDA + "')";
    AppMethodBeat.o(149557);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149556);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.iDr);
    paramParcel.writeString(this.iDs);
    paramParcel.writeString(this.iDt);
    paramParcel.writeString(this.iDu);
    paramParcel.writeString(this.iDv);
    paramParcel.writeString(this.iDw);
    paramParcel.writeString(this.iDx);
    paramParcel.writeString(this.iDy);
    paramParcel.writeString(this.iDz);
    paramParcel.writeString(this.iDA);
    paramParcel.writeString(this.iDB);
    AppMethodBeat.o(149556);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/WordingInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/WordingInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<WordingInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.WordingInfo
 * JD-Core Version:    0.7.0.1
 */