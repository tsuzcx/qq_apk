package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eaz;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scopeRiskPopUpInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;)V", "route_type", "", "native_route_type", "wording", "", "left_button_wording", "right_button_wording", "right_button_h5_url", "wxa_app_info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "getLeft_button_wording", "()Ljava/lang/String;", "setLeft_button_wording", "(Ljava/lang/String;)V", "getNative_route_type", "()I", "setNative_route_type", "(I)V", "getRight_button_h5_url", "setRight_button_h5_url", "getRight_button_wording", "setRight_button_wording", "getRoute_type", "setRoute_type", "getWording", "setWording", "getWxa_app_info", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "setWxa_app_info", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public class MMAuthScopeRiskInfo
  implements Parcelable
{
  public static final MMAuthScopeRiskInfo.a CREATOR;
  public int oDH;
  public int oDI;
  public String oDJ;
  public String oDK;
  public String oDL;
  public MMAuthScopeRiskWxaAppInfo oDM;
  public String wording;
  
  static
  {
    AppMethodBeat.i(282573);
    CREATOR = new MMAuthScopeRiskInfo.a((byte)0);
    AppMethodBeat.o(282573);
  }
  
  private MMAuthScopeRiskInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, MMAuthScopeRiskWxaAppInfo paramMMAuthScopeRiskWxaAppInfo)
  {
    this.oDH = paramInt1;
    this.oDI = paramInt2;
    this.wording = paramString1;
    this.oDJ = paramString2;
    this.oDK = paramString3;
    this.oDL = paramString4;
    this.oDM = paramMMAuthScopeRiskWxaAppInfo;
  }
  
  public MMAuthScopeRiskInfo(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), (MMAuthScopeRiskWxaAppInfo)paramParcel.readParcelable(MMAuthScopeRiskWxaAppInfo.class.getClassLoader()));
    AppMethodBeat.i(282569);
    AppMethodBeat.o(282569);
  }
  
  public MMAuthScopeRiskInfo(eaz parameaz) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(282565);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.oDH);
    paramParcel.writeInt(this.oDI);
    paramParcel.writeString(this.wording);
    paramParcel.writeString(this.oDJ);
    paramParcel.writeString(this.oDK);
    paramParcel.writeString(this.oDL);
    paramParcel.writeParcelable((Parcelable)this.oDM, paramInt);
    AppMethodBeat.o(282565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo
 * JD-Core Version:    0.7.0.1
 */