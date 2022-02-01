package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveIntPayload;", "Landroid/os/Parcelable;", "param", "", "(I)V", "getParam", "()I", "setParam", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveIntPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public int Djt;
  
  static
  {
    AppMethodBeat.i(207839);
    CREATOR = new a();
    AppMethodBeat.o(207839);
  }
  
  private GameLiveAppbrandEventService$LiveIntPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveIntPayload(int paramInt)
  {
    this.Djt = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveIntPayload))
      {
        paramObject = (LiveIntPayload)paramObject;
        if (this.Djt != paramObject.Djt) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.Djt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207834);
    String str = "LiveIntPayload(param=" + this.Djt + ")";
    AppMethodBeat.o(207834);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(207837);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.Djt);
    AppMethodBeat.o(207837);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208690);
      p.k(paramParcel, "in");
      paramParcel = new GameLiveAppbrandEventService.LiveIntPayload(paramParcel.readInt());
      AppMethodBeat.o(208690);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveIntPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveIntPayload
 * JD-Core Version:    0.7.0.1
 */