package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ShowInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "showType", "", "title", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "alertContent", "getAlertContent", "()Ljava/lang/String;", "setAlertContent", "(Ljava/lang/String;)V", "alertTitle", "getAlertTitle", "setAlertTitle", "getShowType", "()I", "setShowType", "(I)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"})
public final class ShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShowInfo> CREATOR;
  public static final a igr;
  public int cZX;
  public String igp;
  public String igq;
  
  static
  {
    AppMethodBeat.i(149529);
    igr = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149529);
  }
  
  public ShowInfo(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149528);
    this.cZX = paramInt;
    this.igp = paramString1;
    this.igq = paramString2;
    AppMethodBeat.o(149528);
  }
  
  public ShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(149527);
    this.cZX = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.igp = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.igq = paramParcel;
    AppMethodBeat.o(149527);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149526);
    k.h(paramParcel, "parcel");
    paramParcel.writeInt(this.cZX);
    paramParcel.writeString(this.igp);
    paramParcel.writeString(this.igq);
    AppMethodBeat.o(149526);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ShowInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "SHOW_TYPE_ALERT", "", "SHOW_TYPE_GO_TO_SETTING_PAGE", "SHOW_TYPE_POPUP", "SHOW_TYPE_TOAST", "wxbiz-msgsubscription-sdk_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ShowInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/ShowInfo;", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
    implements Parcelable.Creator<ShowInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ShowInfo
 * JD-Core Version:    0.7.0.1
 */