package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fvl;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserPrivacyProtectInfo;", "Landroid/os/Parcelable;", "info", "Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "need_show", "", "wording", "", "(ZLjava/lang/String;)V", "describeContents", "", "needShow", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMUserPrivacyProtectInfo
  implements Parcelable
{
  public static final a CREATOR;
  public static final MMUserPrivacyProtectInfo rHk;
  private final boolean rHj;
  public final String wording;
  
  static
  {
    AppMethodBeat.i(326961);
    CREATOR = new a((byte)0);
    rHk = new MMUserPrivacyProtectInfo(false, "");
    AppMethodBeat.o(326961);
  }
  
  public MMUserPrivacyProtectInfo(Parcel paramParcel) {}
  
  public MMUserPrivacyProtectInfo(fvl paramfvl)
  {
    this(bool, paramfvl);
    AppMethodBeat.i(326952);
    AppMethodBeat.o(326952);
  }
  
  private MMUserPrivacyProtectInfo(boolean paramBoolean, String paramString)
  {
    this.rHj = paramBoolean;
    this.wording = paramString;
  }
  
  public final boolean cqt()
  {
    AppMethodBeat.i(326964);
    if (this.rHj)
    {
      if (!n.bp((CharSequence)this.wording)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(326964);
        return true;
      }
    }
    AppMethodBeat.o(326964);
    return false;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326969);
    s.u(paramParcel, "parcel");
    if (this.rHj) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.wording);
      AppMethodBeat.o(326969);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserPrivacyProtectInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserPrivacyProtectInfo;", "()V", "DUMMY", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserPrivacyProtectInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MMUserPrivacyProtectInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserPrivacyProtectInfo
 * JD-Core Version:    0.7.0.1
 */