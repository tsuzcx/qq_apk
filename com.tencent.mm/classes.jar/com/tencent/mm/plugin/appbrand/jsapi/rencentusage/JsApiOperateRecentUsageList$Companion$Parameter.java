package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "actionType", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "username", "", "appId", "versionType", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "getAppId", "()Ljava/lang/String;", "getUsername", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOperateRecentUsageList$Companion$Parameter
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final int euz;
  final JsApiOperateRecentUsageList.Companion.a srM;
  final String username;
  
  static
  {
    AppMethodBeat.i(327362);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327362);
  }
  
  public JsApiOperateRecentUsageList$Companion$Parameter(Parcel paramParcel)
  {
    this(JsApiOperateRecentUsageList.Companion.a.valueOf(String.valueOf(paramParcel.readString())), String.valueOf(paramParcel.readString()), String.valueOf(paramParcel.readString()), paramParcel.readInt());
    AppMethodBeat.i(327360);
    AppMethodBeat.o(327360);
  }
  
  public JsApiOperateRecentUsageList$Companion$Parameter(JsApiOperateRecentUsageList.Companion.a parama, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(327358);
    this.srM = parama;
    this.username = paramString1;
    this.appId = paramString2;
    this.euz = paramInt;
    AppMethodBeat.o(327358);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(327383);
    if (this == paramObject)
    {
      AppMethodBeat.o(327383);
      return true;
    }
    if (!(paramObject instanceof Parameter))
    {
      AppMethodBeat.o(327383);
      return false;
    }
    paramObject = (Parameter)paramObject;
    if (this.srM != paramObject.srM)
    {
      AppMethodBeat.o(327383);
      return false;
    }
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(327383);
      return false;
    }
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(327383);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(327383);
      return false;
    }
    AppMethodBeat.o(327383);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(327376);
    int i = this.srM.hashCode();
    int j = this.username.hashCode();
    int k = this.appId.hashCode();
    int m = this.euz;
    AppMethodBeat.o(327376);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(327371);
    String str = "Parameter(actionType=" + this.srM + ", username=" + this.username + ", appId=" + this.appId + ", versionType=" + this.euz + ')';
    AppMethodBeat.o(327371);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327365);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.srM.name());
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    AppMethodBeat.o(327365);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<JsApiOperateRecentUsageList.Companion.Parameter>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Parameter
 * JD-Core Version:    0.7.0.1
 */