package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoListPayload;", "Landroid/os/Parcelable;", "msgList", "", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoPayload;", "(Ljava/util/List;)V", "getMsgList", "()Ljava/util/List;", "setMsgList", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveMemberInfoListPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public List<GameLiveAppbrandEventService.LiveMemberInfoPayload> ziq;
  
  static
  {
    AppMethodBeat.i(208072);
    CREATOR = new a();
    AppMethodBeat.o(208072);
  }
  
  private GameLiveAppbrandEventService$LiveMemberInfoListPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveMemberInfoListPayload(List<GameLiveAppbrandEventService.LiveMemberInfoPayload> paramList)
  {
    this.ziq = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208070);
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveMemberInfoListPayload))
      {
        paramObject = (LiveMemberInfoListPayload)paramObject;
        if (!p.h(this.ziq, paramObject.ziq)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208070);
      return true;
    }
    AppMethodBeat.o(208070);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208068);
    List localList = this.ziq;
    if (localList != null)
    {
      int i = localList.hashCode();
      AppMethodBeat.o(208068);
      return i;
    }
    AppMethodBeat.o(208068);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208066);
    String str = "LiveMemberInfoListPayload(msgList=" + this.ziq + ")";
    AppMethodBeat.o(208066);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208071);
    p.k(paramParcel, "parcel");
    Object localObject = this.ziq;
    if (localObject != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Collection)localObject).size());
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GameLiveAppbrandEventService.LiveMemberInfoPayload)((Iterator)localObject).next()).writeToParcel(paramParcel, 0);
      }
      AppMethodBeat.o(208071);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(208071);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208386);
      p.k(paramParcel, "in");
      ArrayList localArrayList;
      if (paramParcel.readInt() != 0)
      {
        int i = paramParcel.readInt();
        localArrayList = new ArrayList(i);
        while (i != 0)
        {
          localArrayList.add((GameLiveAppbrandEventService.LiveMemberInfoPayload)GameLiveAppbrandEventService.LiveMemberInfoPayload.CREATOR.createFromParcel(paramParcel));
          i -= 1;
        }
      }
      for (paramParcel = localArrayList;; paramParcel = null)
      {
        paramParcel = new GameLiveAppbrandEventService.LiveMemberInfoListPayload(paramParcel);
        AppMethodBeat.o(208386);
        return paramParcel;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveMemberInfoListPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload
 * JD-Core Version:    0.7.0.1
 */