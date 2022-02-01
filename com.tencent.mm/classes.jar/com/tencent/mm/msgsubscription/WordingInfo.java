package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class WordingInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WordingInfo> CREATOR;
  public static final WordingInfo.a hGN;
  public final String hGC;
  public final String hGD;
  public final String hGE;
  public final String hGF;
  public final String hGG;
  public final String hGH;
  public final String hGI;
  public final String hGJ;
  private final String hGK;
  public final String hGL;
  public final String hGM;
  
  static
  {
    AppMethodBeat.i(149560);
    hGN = new WordingInfo.a((byte)0);
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
    this.hGC = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGD = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGE = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGF = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGG = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGH = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGI = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGJ = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGK = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.hGL = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.hGM = paramParcel;
    AppMethodBeat.o(149559);
  }
  
  public WordingInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(149558);
    this.hGC = paramString1;
    this.hGD = paramString2;
    this.hGE = paramString3;
    this.hGF = paramString4;
    this.hGG = paramString5;
    this.hGH = paramString6;
    this.hGI = paramString7;
    this.hGJ = paramString8;
    this.hGK = paramString9;
    this.hGL = paramString10;
    this.hGM = paramString11;
    AppMethodBeat.o(149558);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149557);
    String str = "WordingInfo(PopupTitle='" + this.hGC + "', PopupAllow='" + this.hGD + "', PopupCancel='" + this.hGE + "', PopupBottom='" + this.hGF + "', ExampleTitle='" + this.hGG + "', AlwaysReject='" + this.hGH + "', PopupDesc='" + this.hGI + "', SendWording='" + this.hGJ + "', MultiRemind='" + this.hGK + "', WxaMultiRemind='" + this.hGL + "')";
    AppMethodBeat.o(149557);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149556);
    k.h(paramParcel, "parcel");
    paramParcel.writeString(this.hGC);
    paramParcel.writeString(this.hGD);
    paramParcel.writeString(this.hGE);
    paramParcel.writeString(this.hGF);
    paramParcel.writeString(this.hGG);
    paramParcel.writeString(this.hGH);
    paramParcel.writeString(this.hGI);
    paramParcel.writeString(this.hGJ);
    paramParcel.writeString(this.hGK);
    paramParcel.writeString(this.hGL);
    paramParcel.writeString(this.hGM);
    AppMethodBeat.o(149556);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/WordingInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<WordingInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.WordingInfo
 * JD-Core Version:    0.7.0.1
 */