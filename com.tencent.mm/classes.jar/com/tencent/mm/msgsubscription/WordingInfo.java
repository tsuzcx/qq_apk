package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class WordingInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WordingInfo> CREATOR;
  public static final WordingInfo.a jyS;
  public final String jyH;
  public final String jyI;
  public final String jyJ;
  public final String jyK;
  public final String jyL;
  public final String jyM;
  public final String jyN;
  public final String jyO;
  private final String jyP;
  public final String jyQ;
  public final String jyR;
  
  static
  {
    AppMethodBeat.i(149560);
    jyS = new WordingInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new WordingInfo.b();
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
    this.jyH = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyI = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyJ = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyK = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyL = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyM = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyN = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyO = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyP = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jyQ = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.jyR = paramParcel;
    AppMethodBeat.o(149559);
  }
  
  public WordingInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(149558);
    this.jyH = paramString1;
    this.jyI = paramString2;
    this.jyJ = paramString3;
    this.jyK = paramString4;
    this.jyL = paramString5;
    this.jyM = paramString6;
    this.jyN = paramString7;
    this.jyO = paramString8;
    this.jyP = paramString9;
    this.jyQ = paramString10;
    this.jyR = paramString11;
    AppMethodBeat.o(149558);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149557);
    String str = "WordingInfo(PopupTitle='" + this.jyH + "', PopupAllow='" + this.jyI + "', PopupCancel='" + this.jyJ + "', PopupBottom='" + this.jyK + "', ExampleTitle='" + this.jyL + "', AlwaysReject='" + this.jyM + "', PopupDesc='" + this.jyN + "', SendWording='" + this.jyO + "', MultiRemind='" + this.jyP + "', WxaMultiRemind='" + this.jyQ + "')";
    AppMethodBeat.o(149557);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149556);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.jyH);
    paramParcel.writeString(this.jyI);
    paramParcel.writeString(this.jyJ);
    paramParcel.writeString(this.jyK);
    paramParcel.writeString(this.jyL);
    paramParcel.writeString(this.jyM);
    paramParcel.writeString(this.jyN);
    paramParcel.writeString(this.jyO);
    paramParcel.writeString(this.jyP);
    paramParcel.writeString(this.jyQ);
    paramParcel.writeString(this.jyR);
    AppMethodBeat.o(149556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.WordingInfo
 * JD-Core Version:    0.7.0.1
 */