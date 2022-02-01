package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveNetWorkPayload;", "Landroid/os/Parcelable;", "netQuality", "", "threshold", "(II)V", "getNetQuality", "()I", "setNetQuality", "(I)V", "getThreshold", "setThreshold", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveNetWorkPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveNetWorkPayload> CREATOR;
  public int Jft;
  public int Jfu;
  
  static
  {
    AppMethodBeat.i(277484);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277484);
  }
  
  private GameLiveAppbrandEventService$LiveNetWorkPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveNetWorkPayload(int paramInt1, int paramInt2)
  {
    this.Jft = paramInt1;
    this.Jfu = paramInt2;
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
      if (!(paramObject instanceof LiveNetWorkPayload)) {
        return false;
      }
      paramObject = (LiveNetWorkPayload)paramObject;
      if (this.Jft != paramObject.Jft) {
        return false;
      }
    } while (this.Jfu == paramObject.Jfu);
    return false;
  }
  
  public final int hashCode()
  {
    return this.Jft * 31 + this.Jfu;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277497);
    String str = "LiveNetWorkPayload(netQuality=" + this.Jft + ", threshold=" + this.Jfu + ')';
    AppMethodBeat.o(277497);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277540);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.Jft);
    paramParcel.writeInt(this.Jfu);
    AppMethodBeat.o(277540);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveNetWorkPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveNetWorkPayload
 * JD-Core Version:    0.7.0.1
 */