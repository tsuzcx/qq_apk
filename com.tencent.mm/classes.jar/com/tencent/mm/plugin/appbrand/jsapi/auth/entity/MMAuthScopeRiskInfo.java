package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyi;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scopeRiskPopUpInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskPopUpInfo;)V", "route_type", "", "wording", "", "left_button_wording", "right_button_wording", "right_button_h5_url", "wxa_app_info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "getLeft_button_wording", "()Ljava/lang/String;", "setLeft_button_wording", "(Ljava/lang/String;)V", "getRight_button_h5_url", "setRight_button_h5_url", "getRight_button_wording", "setRight_button_wording", "getRoute_type", "()I", "setRoute_type", "(I)V", "getWording", "setWording", "getWxa_app_info", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "setWxa_app_info", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public class MMAuthScopeRiskInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String dyI;
  public int kCY;
  public String kCZ;
  public String kDa;
  public String kDb;
  public MMAuthScopeRiskWxaAppInfo kDc;
  
  static
  {
    AppMethodBeat.i(223343);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(223343);
  }
  
  private MMAuthScopeRiskInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MMAuthScopeRiskWxaAppInfo paramMMAuthScopeRiskWxaAppInfo)
  {
    AppMethodBeat.i(223340);
    this.kCY = paramInt;
    this.dyI = paramString1;
    this.kCZ = paramString2;
    this.kDa = paramString3;
    this.kDb = paramString4;
    this.kDc = paramMMAuthScopeRiskWxaAppInfo;
    AppMethodBeat.o(223340);
  }
  
  public MMAuthScopeRiskInfo(Parcel paramParcel)
  {
    this(i, str1, str2, str3, str4, (MMAuthScopeRiskWxaAppInfo)paramParcel.readParcelable(MMAuthScopeRiskWxaAppInfo.class.getClassLoader()));
    AppMethodBeat.i(223341);
    AppMethodBeat.o(223341);
  }
  
  public MMAuthScopeRiskInfo(cyi paramcyi) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223339);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.kCY);
    paramParcel.writeString(this.dyI);
    paramParcel.writeString(this.kCZ);
    paramParcel.writeString(this.kDa);
    paramParcel.writeString(this.kDb);
    paramParcel.writeParcelable((Parcelable)this.kDc, paramInt);
    AppMethodBeat.o(223339);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMAuthScopeRiskInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo
 * JD-Core Version:    0.7.0.1
 */