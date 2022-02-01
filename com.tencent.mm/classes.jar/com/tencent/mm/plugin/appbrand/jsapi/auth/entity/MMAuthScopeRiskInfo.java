package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.drd;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scopeRiskPopUpInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;)V", "route_type", "", "wording", "", "left_button_wording", "right_button_wording", "right_button_h5_url", "wxa_app_info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "getLeft_button_wording", "()Ljava/lang/String;", "setLeft_button_wording", "(Ljava/lang/String;)V", "getRight_button_h5_url", "setRight_button_h5_url", "getRight_button_wording", "setRight_button_wording", "getRoute_type", "()I", "setRoute_type", "(I)V", "getWording", "setWording", "getWxa_app_info", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "setWxa_app_info", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public class MMAuthScopeRiskInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String dQx;
  public String lHA;
  public String lHB;
  public String lHC;
  public MMAuthScopeRiskWxaAppInfo lHD;
  public int lHz;
  
  static
  {
    AppMethodBeat.i(228316);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228316);
  }
  
  private MMAuthScopeRiskInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MMAuthScopeRiskWxaAppInfo paramMMAuthScopeRiskWxaAppInfo)
  {
    AppMethodBeat.i(228313);
    this.lHz = paramInt;
    this.dQx = paramString1;
    this.lHA = paramString2;
    this.lHB = paramString3;
    this.lHC = paramString4;
    this.lHD = paramMMAuthScopeRiskWxaAppInfo;
    AppMethodBeat.o(228313);
  }
  
  public MMAuthScopeRiskInfo(Parcel paramParcel)
  {
    this(paramParcel.readInt(), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), (MMAuthScopeRiskWxaAppInfo)paramParcel.readParcelable(MMAuthScopeRiskWxaAppInfo.class.getClassLoader()));
    AppMethodBeat.i(228314);
    AppMethodBeat.o(228314);
  }
  
  public MMAuthScopeRiskInfo(drd paramdrd) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228312);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.lHz);
    paramParcel.writeString(this.dQx);
    paramParcel.writeString(this.lHA);
    paramParcel.writeString(this.lHB);
    paramParcel.writeString(this.lHC);
    paramParcel.writeParcelable((Parcelable)this.lHD, paramInt);
    AppMethodBeat.o(228312);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMAuthScopeRiskInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo
 * JD-Core Version:    0.7.0.1
 */