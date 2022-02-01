package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveIntPayload;", "Landroid/os/Parcelable;", "param", "", "(I)V", "getParam", "()I", "setParam", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveIntPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveIntPayload> CREATOR;
  public int JcS;
  
  static
  {
    AppMethodBeat.i(277437);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277437);
  }
  
  private GameLiveAppbrandEventService$LiveIntPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveIntPayload(int paramInt)
  {
    this.JcS = paramInt;
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
      if (!(paramObject instanceof LiveIntPayload)) {
        return false;
      }
      paramObject = (LiveIntPayload)paramObject;
    } while (this.JcS == paramObject.JcS);
    return false;
  }
  
  public final int hashCode()
  {
    return this.JcS;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277447);
    String str = "LiveIntPayload(param=" + this.JcS + ')';
    AppMethodBeat.o(277447);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277478);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.JcS);
    AppMethodBeat.o(277478);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveIntPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveIntPayload
 * JD-Core Version:    0.7.0.1
 */