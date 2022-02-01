package com.tencent.mm.plugin.finder.live.view.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "nickname", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWhiteListGroupAdapter$ChatRoomInfo
  implements Parcelable
{
  public static final a CREATOR;
  private final String nickname;
  private final String username;
  
  static
  {
    AppMethodBeat.i(359118);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(359118);
  }
  
  public FinderLiveWhiteListGroupAdapter$ChatRoomInfo(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(359110);
    AppMethodBeat.o(359110);
  }
  
  private FinderLiveWhiteListGroupAdapter$ChatRoomInfo(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.nickname = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(359147);
    if (this == paramObject)
    {
      AppMethodBeat.o(359147);
      return true;
    }
    if (!(paramObject instanceof ChatRoomInfo))
    {
      AppMethodBeat.o(359147);
      return false;
    }
    paramObject = (ChatRoomInfo)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(359147);
      return false;
    }
    if (!s.p(this.nickname, paramObject.nickname))
    {
      AppMethodBeat.o(359147);
      return false;
    }
    AppMethodBeat.o(359147);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(359140);
    int i;
    if (this.username == null)
    {
      i = 0;
      if (this.nickname != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(359140);
      return i * 31 + j;
      i = this.username.hashCode();
      break;
      label46:
      j = this.nickname.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359136);
    String str = "ChatRoomInfo(username=" + this.username + ", nickname=" + this.nickname + ')';
    AppMethodBeat.o(359136);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(359124);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(359124);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<FinderLiveWhiteListGroupAdapter.ChatRoomInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.ChatRoomInfo
 * JD-Core Version:    0.7.0.1
 */