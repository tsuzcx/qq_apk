package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCurrentRoomInfoPayload;", "Landroid/os/Parcelable;", "startTime", "", "topic", "", "(ILjava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveCurrentRoomInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveCurrentRoomInfoPayload> CREATOR;
  public int startTime;
  public String topic;
  
  static
  {
    AppMethodBeat.i(277393);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277393);
  }
  
  private GameLiveAppbrandEventService$LiveCurrentRoomInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveCurrentRoomInfoPayload(int paramInt, String paramString)
  {
    this.startTime = paramInt;
    this.topic = paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277409);
    if (this == paramObject)
    {
      AppMethodBeat.o(277409);
      return true;
    }
    if (!(paramObject instanceof LiveCurrentRoomInfoPayload))
    {
      AppMethodBeat.o(277409);
      return false;
    }
    paramObject = (LiveCurrentRoomInfoPayload)paramObject;
    if (this.startTime != paramObject.startTime)
    {
      AppMethodBeat.o(277409);
      return false;
    }
    if (!s.p(this.topic, paramObject.topic))
    {
      AppMethodBeat.o(277409);
      return false;
    }
    AppMethodBeat.o(277409);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(277404);
    int j = this.startTime;
    if (this.topic == null) {}
    for (int i = 0;; i = this.topic.hashCode())
    {
      AppMethodBeat.o(277404);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277398);
    String str = "LiveCurrentRoomInfoPayload(startTime=" + this.startTime + ", topic=" + this.topic + ')';
    AppMethodBeat.o(277398);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277421);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.startTime);
    paramParcel.writeString(this.topic);
    AppMethodBeat.o(277421);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveCurrentRoomInfoPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCurrentRoomInfoPayload
 * JD-Core Version:    0.7.0.1
 */