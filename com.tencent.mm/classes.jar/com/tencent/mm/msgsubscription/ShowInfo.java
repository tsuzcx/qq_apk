package com.tencent.mm.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ShowInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "showType", "", "title", "", "content", "(ILjava/lang/String;Ljava/lang/String;)V", "alertContent", "getAlertContent", "()Ljava/lang/String;", "setAlertContent", "(Ljava/lang/String;)V", "alertTitle", "getAlertTitle", "setAlertTitle", "getShowType", "()I", "setShowType", "(I)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShowInfo> CREATOR;
  public static final ShowInfo.a phg;
  public int hAN;
  public String phh;
  public String phi;
  
  static
  {
    AppMethodBeat.i(149529);
    phg = new ShowInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(149529);
  }
  
  public ShowInfo(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149528);
    this.hAN = paramInt;
    this.phh = paramString1;
    this.phi = paramString2;
    AppMethodBeat.o(149528);
  }
  
  public ShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(149527);
    this.hAN = paramParcel.readInt();
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.phh = str1;
    str1 = paramParcel.readString();
    paramParcel = str1;
    if (str1 == null) {
      paramParcel = "";
    }
    this.phi = paramParcel;
    AppMethodBeat.o(149527);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(149526);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.hAN);
    paramParcel.writeString(this.phh);
    paramParcel.writeString(this.phi);
    AppMethodBeat.o(149526);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ShowInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/ShowInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/ShowInfo;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<ShowInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ShowInfo
 * JD-Core Version:    0.7.0.1
 */