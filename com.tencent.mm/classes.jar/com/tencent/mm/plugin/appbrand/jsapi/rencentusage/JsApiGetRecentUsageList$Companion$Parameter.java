package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "lastUpdateTime", "", "requestId", "(IJI)V", "getCount", "()I", "getLastUpdateTime", "()J", "getRequestId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiGetRecentUsageList$Companion$Parameter
  implements Parcelable
{
  public static final a CREATOR;
  final int count;
  final long lastUpdateTime;
  final int requestId;
  
  static
  {
    AppMethodBeat.i(327369);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327369);
  }
  
  public JsApiGetRecentUsageList$Companion$Parameter(int paramInt1, long paramLong, int paramInt2)
  {
    this.count = paramInt1;
    this.lastUpdateTime = paramLong;
    this.requestId = paramInt2;
  }
  
  public JsApiGetRecentUsageList$Companion$Parameter(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readInt());
    AppMethodBeat.i(327366);
    AppMethodBeat.o(327366);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Parameter)) {
        return false;
      }
      paramObject = (Parameter)paramObject;
      if (this.count != paramObject.count) {
        return false;
      }
      if (this.lastUpdateTime != paramObject.lastUpdateTime) {
        return false;
      }
    } while (this.requestId == paramObject.requestId);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(327386);
    int i = this.count;
    int j = q.a..ExternalSyntheticBackport0.m(this.lastUpdateTime);
    int k = this.requestId;
    AppMethodBeat.o(327386);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(327382);
    String str = "Parameter(count=" + this.count + ", lastUpdateTime=" + this.lastUpdateTime + ", requestId=" + this.requestId + ')';
    AppMethodBeat.o(327382);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327373);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.count);
    paramParcel.writeLong(this.lastUpdateTime);
    paramParcel.writeInt(this.requestId);
    AppMethodBeat.o(327373);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<JsApiGetRecentUsageList.Companion.Parameter>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList.Companion.Parameter
 * JD-Core Version:    0.7.0.1
 */