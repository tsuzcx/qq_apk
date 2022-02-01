package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/WordingInfo;", "Landroid/os/Parcelable;", "PopupTitle", "", "PopupAllow", "PopupCancel", "PopupBottom", "ExampleTitle", "AlwaysReject", "PopupDesc", "SendWording", "MultiRemind", "WxaMultiRemind", "SendBelowMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAlwaysReject", "()Ljava/lang/String;", "getExampleTitle", "getMultiRemind", "getPopupAllow", "getPopupBottom", "getPopupCancel", "getPopupDesc", "getPopupTitle", "getSendBelowMsg", "getSendWording", "getWxaMultiRemind", "describeContents", "", "toString", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class WordingInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WordingInfo> CREATOR;
  public static final a ihp;
  public final String ihe;
  public final String ihf;
  public final String ihg;
  public final String ihh;
  public final String ihi;
  public final String ihj;
  public final String ihk;
  public final String ihl;
  private final String ihm;
  public final String ihn;
  public final String iho;
  
  static
  {
    AppMethodBeat.i(149560);
    ihp = new a((byte)0);
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
    this.ihe = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihf = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihg = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihh = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihi = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihj = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihk = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihl = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihm = str1;
    str2 = paramParcel.readString();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ihn = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.iho = paramParcel;
    AppMethodBeat.o(149559);
  }
  
  public WordingInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(149558);
    this.ihe = paramString1;
    this.ihf = paramString2;
    this.ihg = paramString3;
    this.ihh = paramString4;
    this.ihi = paramString5;
    this.ihj = paramString6;
    this.ihk = paramString7;
    this.ihl = paramString8;
    this.ihm = paramString9;
    this.ihn = paramString10;
    this.iho = paramString11;
    AppMethodBeat.o(149558);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149557);
    String str = "WordingInfo(PopupTitle='" + this.ihe + "', PopupAllow='" + this.ihf + "', PopupCancel='" + this.ihg + "', PopupBottom='" + this.ihh + "', ExampleTitle='" + this.ihi + "', AlwaysReject='" + this.ihj + "', PopupDesc='" + this.ihk + "', SendWording='" + this.ihl + "', MultiRemind='" + this.ihm + "', WxaMultiRemind='" + this.ihn + "')";
    AppMethodBeat.o(149557);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149556);
    k.h(paramParcel, "parcel");
    paramParcel.writeString(this.ihe);
    paramParcel.writeString(this.ihf);
    paramParcel.writeString(this.ihg);
    paramParcel.writeString(this.ihh);
    paramParcel.writeString(this.ihi);
    paramParcel.writeString(this.ihj);
    paramParcel.writeString(this.ihk);
    paramParcel.writeString(this.ihl);
    paramParcel.writeString(this.ihm);
    paramParcel.writeString(this.ihn);
    paramParcel.writeString(this.iho);
    AppMethodBeat.o(149556);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/WordingInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/WordingInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/WordingInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/WordingInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<WordingInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.WordingInfo
 * JD-Core Version:    0.7.0.1
 */