package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoPayload;", "Landroid/os/Parcelable;", "nickname", "", "rewardAmountInHeat", "", "(Ljava/lang/String;I)V", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "getRewardAmountInHeat", "()I", "setRewardAmountInHeat", "(I)V", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveMemberInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public int Dmj;
  public String nickname;
  
  static
  {
    AppMethodBeat.i(208586);
    CREATOR = new a();
    AppMethodBeat.o(208586);
  }
  
  private GameLiveAppbrandEventService$LiveMemberInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveMemberInfoPayload(String paramString, int paramInt)
  {
    this.nickname = paramString;
    this.Dmj = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208584);
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveMemberInfoPayload))
      {
        paramObject = (LiveMemberInfoPayload)paramObject;
        if ((!p.h(this.nickname, paramObject.nickname)) || (this.Dmj != paramObject.Dmj)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208584);
      return true;
    }
    AppMethodBeat.o(208584);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208583);
    String str = this.nickname;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.Dmj;
      AppMethodBeat.o(208583);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208582);
    String str = "LiveMemberInfoPayload(nickname=" + this.nickname + ", rewardAmountInHeat=" + this.Dmj + ")";
    AppMethodBeat.o(208582);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208585);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.nickname);
    paramParcel.writeInt(this.Dmj);
    AppMethodBeat.o(208585);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208054);
      p.k(paramParcel, "in");
      paramParcel = new GameLiveAppbrandEventService.LiveMemberInfoPayload(paramParcel.readString(), paramParcel.readInt());
      AppMethodBeat.o(208054);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveMemberInfoPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoPayload
 * JD-Core Version:    0.7.0.1
 */