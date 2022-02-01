package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchApi$PullPrefetchResultReq;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "instanceId", "", "prefetchType", "", "(Ljava/lang/String;I)V", "getInstanceId", "()Ljava/lang/String;", "getPrefetchType", "()I", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCgiPrefetchApi$PullPrefetchResultReq
  implements Parcelable
{
  public static final a CREATOR;
  final String eup;
  final int sVB;
  
  static
  {
    AppMethodBeat.i(320973);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(320973);
  }
  
  private AppBrandCgiPrefetchApi$PullPrefetchResultReq(Parcel paramParcel)
  {
    this(str, paramParcel.readInt());
    AppMethodBeat.i(320958);
    AppMethodBeat.o(320958);
  }
  
  public AppBrandCgiPrefetchApi$PullPrefetchResultReq(String paramString, int paramInt)
  {
    AppMethodBeat.i(320949);
    this.eup = paramString;
    this.sVB = paramInt;
    AppMethodBeat.o(320949);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320983);
    s.u(paramParcel, "dest");
    paramParcel.writeString(this.eup);
    paramParcel.writeInt(this.sVB);
    AppMethodBeat.o(320983);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchApi$PullPrefetchResultReq$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchApi$PullPrefetchResultReq;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchApi$PullPrefetchResultReq;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandCgiPrefetchApi.PullPrefetchResultReq>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchApi.PullPrefetchResultReq
 * JD-Core Version:    0.7.0.1
 */