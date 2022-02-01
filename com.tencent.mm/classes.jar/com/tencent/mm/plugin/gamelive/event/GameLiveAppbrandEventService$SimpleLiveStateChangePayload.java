package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$SimpleLiveStateChangePayload;", "Landroid/os/Parcelable;", "data", "", "", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$SimpleLiveStateChangePayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public final Map<String, Integer> data;
  
  static
  {
    AppMethodBeat.i(208335);
    CREATOR = new a();
    AppMethodBeat.o(208335);
  }
  
  public GameLiveAppbrandEventService$SimpleLiveStateChangePayload(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(208330);
    this.data = paramMap;
    AppMethodBeat.o(208330);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208333);
    if (this != paramObject)
    {
      if ((paramObject instanceof SimpleLiveStateChangePayload))
      {
        paramObject = (SimpleLiveStateChangePayload)paramObject;
        if (!p.h(this.data, paramObject.data)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208333);
      return true;
    }
    AppMethodBeat.o(208333);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208332);
    Map localMap = this.data;
    if (localMap != null)
    {
      int i = localMap.hashCode();
      AppMethodBeat.o(208332);
      return i;
    }
    AppMethodBeat.o(208332);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208331);
    String str = "SimpleLiveStateChangePayload(data=" + this.data + ")";
    AppMethodBeat.o(208331);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208334);
    p.k(paramParcel, "parcel");
    Object localObject1 = this.data;
    paramParcel.writeInt(((Map)localObject1).size());
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      paramParcel.writeString((String)localObject2.getKey());
      paramParcel.writeInt(((Integer)localObject2.getValue()).intValue());
    }
    AppMethodBeat.o(208334);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208716);
      p.k(paramParcel, "in");
      int i = paramParcel.readInt();
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(i);
      while (i != 0)
      {
        localLinkedHashMap.put(paramParcel.readString(), Integer.valueOf(paramParcel.readInt()));
        i -= 1;
      }
      paramParcel = new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(localLinkedHashMap);
      AppMethodBeat.o(208716);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.SimpleLiveStateChangePayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.SimpleLiveStateChangePayload
 * JD-Core Version:    0.7.0.1
 */