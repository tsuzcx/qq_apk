package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "actionType", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "username", "", "appId", "versionType", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "getAppId", "()Ljava/lang/String;", "getUsername", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class JsApiOperateRecentUsageList$Companion$Parameter
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final int cBU;
  final JsApiOperateRecentUsageList.Companion.a pmU;
  final String username;
  
  static
  {
    AppMethodBeat.i(277137);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(277137);
  }
  
  public JsApiOperateRecentUsageList$Companion$Parameter(Parcel paramParcel)
  {
    this(JsApiOperateRecentUsageList.Companion.a.valueOf(String.valueOf(paramParcel.readString())), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), paramParcel.readInt());
    AppMethodBeat.i(277136);
    AppMethodBeat.o(277136);
  }
  
  public JsApiOperateRecentUsageList$Companion$Parameter(JsApiOperateRecentUsageList.Companion.a parama, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(277135);
    this.pmU = parama;
    this.username = paramString1;
    this.appId = paramString2;
    this.cBU = paramInt;
    AppMethodBeat.o(277135);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277141);
    if (this != paramObject)
    {
      if ((paramObject instanceof Parameter))
      {
        paramObject = (Parameter)paramObject;
        if ((!p.h(this.pmU, paramObject.pmU)) || (!p.h(this.username, paramObject.username)) || (!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU)) {}
      }
    }
    else
    {
      AppMethodBeat.o(277141);
      return true;
    }
    AppMethodBeat.o(277141);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(277140);
    Object localObject = this.pmU;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.username;
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.appId;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.cBU;
      AppMethodBeat.o(277140);
      return ((j + i * 31) * 31 + k) * 31 + m;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277138);
    String str = "Parameter(actionType=" + this.pmU + ", username=" + this.username + ", appId=" + this.appId + ", versionType=" + this.cBU + ")";
    AppMethodBeat.o(277138);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277133);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.pmU.name());
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    AppMethodBeat.o(277133);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Parameter>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Parameter
 * JD-Core Version:    0.7.0.1
 */