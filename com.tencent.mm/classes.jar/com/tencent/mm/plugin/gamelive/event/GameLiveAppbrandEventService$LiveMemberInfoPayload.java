package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoPayload;", "Landroid/os/Parcelable;", "nickname", "", "rewardAmountInHeat", "", "(Ljava/lang/String;I)V", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "getRewardAmountInHeat", "()I", "setRewardAmountInHeat", "(I)V", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveMemberInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveMemberInfoPayload> CREATOR;
  public int Jfs;
  public String nickname;
  
  static
  {
    AppMethodBeat.i(277386);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277386);
  }
  
  private GameLiveAppbrandEventService$LiveMemberInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveMemberInfoPayload(String paramString, int paramInt)
  {
    this.nickname = paramString;
    this.Jfs = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277406);
    if (this == paramObject)
    {
      AppMethodBeat.o(277406);
      return true;
    }
    if (!(paramObject instanceof LiveMemberInfoPayload))
    {
      AppMethodBeat.o(277406);
      return false;
    }
    paramObject = (LiveMemberInfoPayload)paramObject;
    if (!s.p(this.nickname, paramObject.nickname))
    {
      AppMethodBeat.o(277406);
      return false;
    }
    if (this.Jfs != paramObject.Jfs)
    {
      AppMethodBeat.o(277406);
      return false;
    }
    AppMethodBeat.o(277406);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(277399);
    if (this.nickname == null) {}
    for (int i = 0;; i = this.nickname.hashCode())
    {
      int j = this.Jfs;
      AppMethodBeat.o(277399);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277394);
    String str = "LiveMemberInfoPayload(nickname=" + this.nickname + ", rewardAmountInHeat=" + this.Jfs + ')';
    AppMethodBeat.o(277394);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277417);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.nickname);
    paramParcel.writeInt(this.Jfs);
    AppMethodBeat.o(277417);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveMemberInfoPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoPayload
 * JD-Core Version:    0.7.0.1
 */