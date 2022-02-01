package com.tencent.mm.plugin.gamelive;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "Landroid/os/Parcelable;", "action", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "appId", "", "versionType", "", "payload", "(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;Ljava/lang/String;ILandroid/os/Parcelable;)V", "getAction", "()Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "getAppId", "()Ljava/lang/String;", "getPayload", "()Landroid/os/Parcelable;", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IPCLiveControlAction", "plugin-gamelive_release"})
public final class PluginGameLive$IPCLiveControlData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final PluginGameLive.IPCLiveControlData.b Dkt;
  public final Parcelable Dku;
  private final String appId;
  private final int cBU;
  
  static
  {
    AppMethodBeat.i(208400);
    CREATOR = new a();
    AppMethodBeat.o(208400);
  }
  
  public PluginGameLive$IPCLiveControlData(PluginGameLive.IPCLiveControlData.b paramb)
  {
    this(paramb, null, null, 14);
  }
  
  public PluginGameLive$IPCLiveControlData(PluginGameLive.IPCLiveControlData.b paramb, String paramString, int paramInt, Parcelable paramParcelable)
  {
    AppMethodBeat.i(208392);
    this.Dkt = paramb;
    this.appId = paramString;
    this.cBU = paramInt;
    this.Dku = paramParcelable;
    AppMethodBeat.o(208392);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208398);
    if (this != paramObject)
    {
      if ((paramObject instanceof IPCLiveControlData))
      {
        paramObject = (IPCLiveControlData)paramObject;
        if ((!p.h(this.Dkt, paramObject.Dkt)) || (!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU) || (!p.h(this.Dku, paramObject.Dku))) {}
      }
    }
    else
    {
      AppMethodBeat.o(208398);
      return true;
    }
    AppMethodBeat.o(208398);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(208397);
    Object localObject = this.Dkt;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.appId;
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (int j = localObject.hashCode();; j = 0)
    {
      int m = this.cBU;
      localObject = this.Dku;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(208397);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208396);
    String str = "IPCLiveControlData(action=" + this.Dkt + ", appId=" + this.appId + ", versionType=" + this.cBU + ", payload=" + this.Dku + ")";
    AppMethodBeat.o(208396);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208399);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.Dkt.name());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeParcelable(this.Dku, paramInt);
    AppMethodBeat.o(208399);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208414);
      p.k(paramParcel, "in");
      paramParcel = new PluginGameLive.IPCLiveControlData((PluginGameLive.IPCLiveControlData.b)Enum.valueOf(PluginGameLive.IPCLiveControlData.b.class, paramParcel.readString()), paramParcel.readString(), paramParcel.readInt(), paramParcel.readParcelable(PluginGameLive.IPCLiveControlData.class.getClassLoader()));
      AppMethodBeat.o(208414);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new PluginGameLive.IPCLiveControlData[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData
 * JD-Core Version:    0.7.0.1
 */