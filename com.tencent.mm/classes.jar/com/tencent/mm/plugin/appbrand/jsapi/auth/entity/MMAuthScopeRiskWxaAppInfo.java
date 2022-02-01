package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxp;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "info", "Lcom/tencent/mm/protocal/protobuf/ScopeRiskWxaAppInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeRiskWxaAppInfo;)V", "username", "", "path", "version", "", "scene", "type", "(Ljava/lang/String;Ljava/lang/String;III)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScene", "()I", "setScene", "(I)V", "getType", "setType", "getUsername", "setUsername", "getVersion", "setVersion", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public class MMAuthScopeRiskWxaAppInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String path;
  public int scene;
  public int type;
  public String username;
  public int version;
  
  static
  {
    AppMethodBeat.i(189090);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(189090);
  }
  
  public MMAuthScopeRiskWxaAppInfo(Parcel paramParcel)
  {
    this(str1, str2, paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
    AppMethodBeat.i(189088);
    AppMethodBeat.o(189088);
  }
  
  public MMAuthScopeRiskWxaAppInfo(cxp paramcxp)
  {
    this(str1, str2, paramcxp.version, paramcxp.scene, paramcxp.type);
    AppMethodBeat.i(189089);
    AppMethodBeat.o(189089);
  }
  
  private MMAuthScopeRiskWxaAppInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189087);
    this.username = paramString1;
    this.path = paramString2;
    this.version = paramInt1;
    this.scene = paramInt2;
    this.type = paramInt3;
    AppMethodBeat.o(189087);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(189086);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.type);
    AppMethodBeat.o(189086);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskWxaAppInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMAuthScopeRiskWxaAppInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo
 * JD-Core Version:    0.7.0.1
 */