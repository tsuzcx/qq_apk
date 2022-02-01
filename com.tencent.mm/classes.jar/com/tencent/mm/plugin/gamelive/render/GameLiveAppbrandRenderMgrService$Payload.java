package com.tencent.mm.plugin.gamelive.render;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService$Payload;", "Landroid/os/Parcelable;", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandRenderMgrService$Payload
  implements Parcelable
{
  public static final Parcelable.Creator<Payload> CREATOR;
  public final int height;
  public final int width;
  
  static
  {
    AppMethodBeat.i(277306);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277306);
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
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Payload)) {
        return false;
      }
      paramObject = (Payload)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277310);
    String str = "Payload(width=" + this.width + ", height=" + this.height + ')';
    AppMethodBeat.o(277310);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277325);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(277325);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandRenderMgrService.Payload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.GameLiveAppbrandRenderMgrService.Payload
 * JD-Core Version:    0.7.0.1
 */