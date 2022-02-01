package com.tencent.mm.plugin.gamelive;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "Landroid/os/Parcelable;", "action", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "appId", "", "versionType", "", "payload", "(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;Ljava/lang/String;ILandroid/os/Parcelable;)V", "getAction", "()Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "getAppId", "()Ljava/lang/String;", "getPayload", "()Landroid/os/Parcelable;", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IPCLiveControlAction", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginGameLive$IPCLiveControlData
  implements Parcelable
{
  public static final Parcelable.Creator<IPCLiveControlData> CREATOR;
  final PluginGameLive.IPCLiveControlData.b JdA;
  public final Parcelable JdB;
  private final String appId;
  private final int euz;
  
  static
  {
    AppMethodBeat.i(277192);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277192);
  }
  
  public PluginGameLive$IPCLiveControlData(PluginGameLive.IPCLiveControlData.b paramb)
  {
    this(paramb, null, null, 14);
    AppMethodBeat.i(277186);
    AppMethodBeat.o(277186);
  }
  
  public PluginGameLive$IPCLiveControlData(PluginGameLive.IPCLiveControlData.b paramb, String paramString, int paramInt, Parcelable paramParcelable)
  {
    AppMethodBeat.i(277180);
    this.JdA = paramb;
    this.appId = paramString;
    this.euz = paramInt;
    this.JdB = paramParcelable;
    AppMethodBeat.o(277180);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277209);
    if (this == paramObject)
    {
      AppMethodBeat.o(277209);
      return true;
    }
    if (!(paramObject instanceof IPCLiveControlData))
    {
      AppMethodBeat.o(277209);
      return false;
    }
    paramObject = (IPCLiveControlData)paramObject;
    if (this.JdA != paramObject.JdA)
    {
      AppMethodBeat.o(277209);
      return false;
    }
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(277209);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(277209);
      return false;
    }
    if (!s.p(this.JdB, paramObject.JdB))
    {
      AppMethodBeat.o(277209);
      return false;
    }
    AppMethodBeat.o(277209);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(277205);
    int k = this.JdA.hashCode();
    int i;
    int m;
    if (this.appId == null)
    {
      i = 0;
      m = this.euz;
      if (this.JdB != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(277205);
      return ((i + k * 31) * 31 + m) * 31 + j;
      i = this.appId.hashCode();
      break;
      label71:
      j = this.JdB.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277198);
    String str = "IPCLiveControlData(action=" + this.JdA + ", appId=" + this.appId + ", versionType=" + this.euz + ", payload=" + this.JdB + ')';
    AppMethodBeat.o(277198);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277215);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.JdA.name());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    paramParcel.writeParcelable(this.JdB, paramInt);
    AppMethodBeat.o(277215);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<PluginGameLive.IPCLiveControlData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData
 * JD-Core Version:    0.7.0.1
 */