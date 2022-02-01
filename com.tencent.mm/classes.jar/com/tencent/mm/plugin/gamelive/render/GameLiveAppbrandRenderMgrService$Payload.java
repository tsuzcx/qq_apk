package com.tencent.mm.plugin.gamelive.render;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService$Payload;", "Landroid/os/Parcelable;", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandRenderMgrService$Payload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public final int height;
  public final int width;
  
  static
  {
    AppMethodBeat.i(208579);
    CREATOR = new a();
    AppMethodBeat.o(208579);
  }
  
  public GameLiveAppbrandRenderMgrService$Payload(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Payload))
      {
        paramObject = (Payload)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208574);
    String str = "Payload(width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(208574);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208577);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(208577);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208165);
      p.k(paramParcel, "in");
      paramParcel = new GameLiveAppbrandRenderMgrService.Payload(paramParcel.readInt(), paramParcel.readInt());
      AppMethodBeat.o(208165);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandRenderMgrService.Payload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.GameLiveAppbrandRenderMgrService.Payload
 * JD-Core Version:    0.7.0.1
 */