package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveNetWorkPayload;", "Landroid/os/Parcelable;", "netQuality", "", "threshold", "(II)V", "getNetQuality", "()I", "setNetQuality", "(I)V", "getThreshold", "setThreshold", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveNetWorkPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public int Dmk;
  public int Dml;
  
  static
  {
    AppMethodBeat.i(208403);
    CREATOR = new a();
    AppMethodBeat.o(208403);
  }
  
  private GameLiveAppbrandEventService$LiveNetWorkPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveNetWorkPayload(int paramInt1, int paramInt2)
  {
    this.Dmk = paramInt1;
    this.Dml = paramInt2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveNetWorkPayload))
      {
        paramObject = (LiveNetWorkPayload)paramObject;
        if ((this.Dmk != paramObject.Dmk) || (this.Dml != paramObject.Dml)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.Dmk * 31 + this.Dml;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208401);
    String str = "LiveNetWorkPayload(netQuality=" + this.Dmk + ", threshold=" + this.Dml + ")";
    AppMethodBeat.o(208401);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208402);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.Dmk);
    paramParcel.writeInt(this.Dml);
    AppMethodBeat.o(208402);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208510);
      p.k(paramParcel, "in");
      paramParcel = new GameLiveAppbrandEventService.LiveNetWorkPayload(paramParcel.readInt(), paramParcel.readInt());
      AppMethodBeat.o(208510);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveNetWorkPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveNetWorkPayload
 * JD-Core Version:    0.7.0.1
 */