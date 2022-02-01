package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveStartInfoPayload;", "Landroid/os/Parcelable;", "nickname", "", "headerUrl", "joinLiveTips", "liveId", "", "finderUsrName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getFinderUsrName", "()Ljava/lang/String;", "setFinderUsrName", "(Ljava/lang/String;)V", "getHeaderUrl", "setHeaderUrl", "getJoinLiveTips", "setJoinLiveTips", "getLiveId", "()J", "setLiveId", "(J)V", "getNickname", "setNickname", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveStartInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  private String Dmw;
  private String Dmx;
  private String Dmy;
  private long liveId;
  private String nickname;
  
  static
  {
    AppMethodBeat.i(208383);
    CREATOR = new a();
    AppMethodBeat.o(208383);
  }
  
  private GameLiveAppbrandEventService$LiveStartInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveStartInfoPayload(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this.nickname = paramString1;
    this.Dmw = paramString2;
    this.Dmx = paramString3;
    this.liveId = paramLong;
    this.Dmy = paramString4;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208379);
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveStartInfoPayload))
      {
        paramObject = (LiveStartInfoPayload)paramObject;
        if ((!p.h(this.nickname, paramObject.nickname)) || (!p.h(this.Dmw, paramObject.Dmw)) || (!p.h(this.Dmx, paramObject.Dmx)) || (this.liveId != paramObject.liveId) || (!p.h(this.Dmy, paramObject.Dmy))) {}
      }
    }
    else
    {
      AppMethodBeat.o(208379);
      return true;
    }
    AppMethodBeat.o(208379);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(208377);
    String str = this.nickname;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.Dmw;
      if (str == null) {
        break label128;
      }
      j = str.hashCode();
      label42:
      str = this.Dmx;
      if (str == null) {
        break label133;
      }
    }
    label128:
    label133:
    for (int k = str.hashCode();; k = 0)
    {
      long l = this.liveId;
      int n = (int)(l ^ l >>> 32);
      str = this.Dmy;
      if (str != null) {
        m = str.hashCode();
      }
      AppMethodBeat.o(208377);
      return ((k + (j + i * 31) * 31) * 31 + n) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208376);
    String str = "LiveStartInfoPayload(nickname=" + this.nickname + ", headerUrl=" + this.Dmw + ", joinLiveTips=" + this.Dmx + ", liveId=" + this.liveId + ", finderUsrName=" + this.Dmy + ")";
    AppMethodBeat.o(208376);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208382);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.Dmw);
    paramParcel.writeString(this.Dmx);
    paramParcel.writeLong(this.liveId);
    paramParcel.writeString(this.Dmy);
    AppMethodBeat.o(208382);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208740);
      p.k(paramParcel, "in");
      paramParcel = new GameLiveAppbrandEventService.LiveStartInfoPayload(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readLong(), paramParcel.readString());
      AppMethodBeat.o(208740);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveStartInfoPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveStartInfoPayload
 * JD-Core Version:    0.7.0.1
 */