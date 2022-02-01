package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ShowInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "showType", "", "title", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "alertContent", "getAlertContent", "()Ljava/lang/String;", "setAlertContent", "(Ljava/lang/String;)V", "alertTitle", "getAlertTitle", "setAlertTitle", "getShowType", "()I", "setShowType", "(I)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class ShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShowInfo> CREATOR;
  public static final a izL;
  public int dlp;
  public String izJ;
  public String izK;
  
  static
  {
    AppMethodBeat.i(149529);
    izL = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149529);
  }
  
  public ShowInfo(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149528);
    this.dlp = paramInt;
    this.izJ = paramString1;
    this.izK = paramString2;
    AppMethodBeat.o(149528);
  }
  
  public ShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(149527);
    this.dlp = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.izJ = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.izK = paramParcel;
    AppMethodBeat.o(149527);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149526);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.dlp);
    paramParcel.writeString(this.izJ);
    paramParcel.writeString(this.izK);
    AppMethodBeat.o(149526);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ShowInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "SHOW_TYPE_ALERT", "", "SHOW_TYPE_GO_TO_SETTING_PAGE", "SHOW_TYPE_POPUP", "SHOW_TYPE_TOAST", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ShowInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/ShowInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<ShowInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ShowInfo
 * JD-Core Version:    0.7.0.1
 */