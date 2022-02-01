package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$SimpleLiveStateChangePayload;", "Landroid/os/Parcelable;", "data", "", "", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$SimpleLiveStateChangePayload
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleLiveStateChangePayload> CREATOR;
  public final Map<String, Integer> data;
  
  static
  {
    AppMethodBeat.i(277446);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277446);
  }
  
  public GameLiveAppbrandEventService$SimpleLiveStateChangePayload(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(277438);
    this.data = paramMap;
    AppMethodBeat.o(277438);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277468);
    if (this == paramObject)
    {
      AppMethodBeat.o(277468);
      return true;
    }
    if (!(paramObject instanceof SimpleLiveStateChangePayload))
    {
      AppMethodBeat.o(277468);
      return false;
    }
    paramObject = (SimpleLiveStateChangePayload)paramObject;
    if (!s.p(this.data, paramObject.data))
    {
      AppMethodBeat.o(277468);
      return false;
    }
    AppMethodBeat.o(277468);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(277461);
    int i = this.data.hashCode();
    AppMethodBeat.o(277461);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277453);
    String str = "SimpleLiveStateChangePayload(data=" + this.data + ')';
    AppMethodBeat.o(277453);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277487);
    s.u(paramParcel, "out");
    Object localObject1 = this.data;
    paramParcel.writeInt(((Map)localObject1).size());
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      paramParcel.writeString((String)((Map.Entry)localObject2).getKey());
      paramParcel.writeInt(((Number)((Map.Entry)localObject2).getValue()).intValue());
    }
    AppMethodBeat.o(277487);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.SimpleLiveStateChangePayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.SimpleLiveStateChangePayload
 * JD-Core Version:    0.7.0.1
 */