package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class WordingInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WordingInfo> CREATOR;
  public static final a iAJ;
  public final String iAA;
  public final String iAB;
  public final String iAC;
  public final String iAD;
  public final String iAE;
  public final String iAF;
  private final String iAG;
  public final String iAH;
  public final String iAI;
  public final String iAy;
  public final String iAz;
  
  static
  {
    AppMethodBeat.i(149560);
    iAJ = new a((byte)0);
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
    this.iAy = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAz = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAA = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAB = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAC = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAD = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAE = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAF = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAG = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.iAH = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.iAI = paramParcel;
    AppMethodBeat.o(149559);
  }
  
  public WordingInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(149558);
    this.iAy = paramString1;
    this.iAz = paramString2;
    this.iAA = paramString3;
    this.iAB = paramString4;
    this.iAC = paramString5;
    this.iAD = paramString6;
    this.iAE = paramString7;
    this.iAF = paramString8;
    this.iAG = paramString9;
    this.iAH = paramString10;
    this.iAI = paramString11;
    AppMethodBeat.o(149558);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149557);
    String str = "WordingInfo(PopupTitle='" + this.iAy + "', PopupAllow='" + this.iAz + "', PopupCancel='" + this.iAA + "', PopupBottom='" + this.iAB + "', ExampleTitle='" + this.iAC + "', AlwaysReject='" + this.iAD + "', PopupDesc='" + this.iAE + "', SendWording='" + this.iAF + "', MultiRemind='" + this.iAG + "', WxaMultiRemind='" + this.iAH + "')";
    AppMethodBeat.o(149557);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149556);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.iAy);
    paramParcel.writeString(this.iAz);
    paramParcel.writeString(this.iAA);
    paramParcel.writeString(this.iAB);
    paramParcel.writeString(this.iAC);
    paramParcel.writeString(this.iAD);
    paramParcel.writeString(this.iAE);
    paramParcel.writeString(this.iAF);
    paramParcel.writeString(this.iAG);
    paramParcel.writeString(this.iAH);
    paramParcel.writeString(this.iAI);
    AppMethodBeat.o(149556);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/WordingInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/WordingInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<WordingInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.WordingInfo
 * JD-Core Version:    0.7.0.1
 */