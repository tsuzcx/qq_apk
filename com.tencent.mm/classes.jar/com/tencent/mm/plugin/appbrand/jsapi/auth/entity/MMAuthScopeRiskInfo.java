package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.euo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scopeRiskPopUpInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;)V", "route_type", "", "native_route_type", "wording", "", "left_button_wording", "right_button_wording", "right_button_h5_url", "wxa_app_info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "getLeft_button_wording", "()Ljava/lang/String;", "setLeft_button_wording", "(Ljava/lang/String;)V", "getNative_route_type", "()I", "setNative_route_type", "(I)V", "getRight_button_h5_url", "setRight_button_h5_url", "getRight_button_wording", "setRight_button_wording", "getRoute_type", "setRoute_type", "getWording", "setWording", "getWxa_app_info", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "setWxa_app_info", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MMAuthScopeRiskInfo
  implements Parcelable
{
  public static final a CREATOR;
  public int rGS;
  public int rGT;
  public String rGU;
  public String rGV;
  public MMAuthScopeRiskWxaAppInfo rGW;
  public String right_button_wording;
  public String wording;
  
  static
  {
    AppMethodBeat.i(326966);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(326966);
  }
  
  private MMAuthScopeRiskInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, MMAuthScopeRiskWxaAppInfo paramMMAuthScopeRiskWxaAppInfo)
  {
    this.rGS = paramInt1;
    this.rGT = paramInt2;
    this.wording = paramString1;
    this.rGU = paramString2;
    this.right_button_wording = paramString3;
    this.rGV = paramString4;
    this.rGW = paramMMAuthScopeRiskWxaAppInfo;
  }
  
  public MMAuthScopeRiskInfo(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), (MMAuthScopeRiskWxaAppInfo)paramParcel.readParcelable(MMAuthScopeRiskWxaAppInfo.class.getClassLoader()));
    AppMethodBeat.i(326956);
    AppMethodBeat.o(326956);
  }
  
  public MMAuthScopeRiskInfo(euo parameuo) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326971);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.rGS);
    paramParcel.writeInt(this.rGT);
    paramParcel.writeString(this.wording);
    paramParcel.writeString(this.rGU);
    paramParcel.writeString(this.right_button_wording);
    paramParcel.writeString(this.rGV);
    paramParcel.writeParcelable((Parcelable)this.rGW, paramInt);
    AppMethodBeat.o(326971);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "()V", "NativeRouteType_None", "", "NativeRouteType_RealNameBlock", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MMAuthScopeRiskInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo
 * JD-Core Version:    0.7.0.1
 */