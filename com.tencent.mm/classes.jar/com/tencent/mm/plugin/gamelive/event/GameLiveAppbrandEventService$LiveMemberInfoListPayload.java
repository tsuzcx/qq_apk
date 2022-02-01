package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoListPayload;", "Landroid/os/Parcelable;", "msgList", "", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoPayload;", "(Ljava/util/List;)V", "getMsgList", "()Ljava/util/List;", "setMsgList", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveMemberInfoListPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveMemberInfoListPayload> CREATOR;
  public List<GameLiveAppbrandEventService.LiveMemberInfoPayload> EgE;
  
  static
  {
    AppMethodBeat.i(277456);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277456);
  }
  
  private GameLiveAppbrandEventService$LiveMemberInfoListPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveMemberInfoListPayload(List<GameLiveAppbrandEventService.LiveMemberInfoPayload> paramList)
  {
    this.EgE = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277479);
    if (this == paramObject)
    {
      AppMethodBeat.o(277479);
      return true;
    }
    if (!(paramObject instanceof LiveMemberInfoListPayload))
    {
      AppMethodBeat.o(277479);
      return false;
    }
    paramObject = (LiveMemberInfoListPayload)paramObject;
    if (!s.p(this.EgE, paramObject.EgE))
    {
      AppMethodBeat.o(277479);
      return false;
    }
    AppMethodBeat.o(277479);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(277470);
    if (this.EgE == null)
    {
      AppMethodBeat.o(277470);
      return 0;
    }
    int i = this.EgE.hashCode();
    AppMethodBeat.o(277470);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277463);
    String str = "LiveMemberInfoListPayload(msgList=" + this.EgE + ')';
    AppMethodBeat.o(277463);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277496);
    s.u(paramParcel, "out");
    Object localObject = this.EgE;
    if (localObject == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(277496);
      return;
    }
    paramParcel.writeInt(1);
    paramParcel.writeInt(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GameLiveAppbrandEventService.LiveMemberInfoPayload)((Iterator)localObject).next()).writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(277496);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveMemberInfoListPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload
 * JD-Core Version:    0.7.0.1
 */