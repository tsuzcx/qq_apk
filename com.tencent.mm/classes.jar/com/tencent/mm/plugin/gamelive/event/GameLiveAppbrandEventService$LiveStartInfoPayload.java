package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveStartInfoPayload;", "Landroid/os/Parcelable;", "nickname", "", "headerUrl", "joinLiveTips", "liveId", "", "finderUsrName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getFinderUsrName", "()Ljava/lang/String;", "setFinderUsrName", "(Ljava/lang/String;)V", "getHeaderUrl", "setHeaderUrl", "getJoinLiveTips", "setJoinLiveTips", "getLiveId", "()J", "setLiveId", "(J)V", "getNickname", "setNickname", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveStartInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveStartInfoPayload> CREATOR;
  private String JfK;
  private String JfL;
  private String JfM;
  private long liveId;
  private String nickname;
  
  static
  {
    AppMethodBeat.i(277451);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277451);
  }
  
  private GameLiveAppbrandEventService$LiveStartInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveStartInfoPayload(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this.nickname = paramString1;
    this.JfK = paramString2;
    this.JfL = paramString3;
    this.liveId = paramLong;
    this.JfM = paramString4;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277477);
    if (this == paramObject)
    {
      AppMethodBeat.o(277477);
      return true;
    }
    if (!(paramObject instanceof LiveStartInfoPayload))
    {
      AppMethodBeat.o(277477);
      return false;
    }
    paramObject = (LiveStartInfoPayload)paramObject;
    if (!s.p(this.nickname, paramObject.nickname))
    {
      AppMethodBeat.o(277477);
      return false;
    }
    if (!s.p(this.JfK, paramObject.JfK))
    {
      AppMethodBeat.o(277477);
      return false;
    }
    if (!s.p(this.JfL, paramObject.JfL))
    {
      AppMethodBeat.o(277477);
      return false;
    }
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(277477);
      return false;
    }
    if (!s.p(this.JfM, paramObject.JfM))
    {
      AppMethodBeat.o(277477);
      return false;
    }
    AppMethodBeat.o(277477);
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(277466);
    int i;
    int j;
    label26:
    int k;
    label35:
    int n;
    if (this.nickname == null)
    {
      i = 0;
      if (this.JfK != null) {
        break label91;
      }
      j = 0;
      if (this.JfL != null) {
        break label102;
      }
      k = 0;
      n = q.a..ExternalSyntheticBackport0.m(this.liveId);
      if (this.JfM != null) {
        break label113;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(277466);
      return ((k + (j + i * 31) * 31) * 31 + n) * 31 + m;
      i = this.nickname.hashCode();
      break;
      label91:
      j = this.JfK.hashCode();
      break label26;
      label102:
      k = this.JfL.hashCode();
      break label35;
      label113:
      m = this.JfM.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277459);
    String str = "LiveStartInfoPayload(nickname=" + this.nickname + ", headerUrl=" + this.JfK + ", joinLiveTips=" + this.JfL + ", liveId=" + this.liveId + ", finderUsrName=" + this.JfM + ')';
    AppMethodBeat.o(277459);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277491);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.JfK);
    paramParcel.writeString(this.JfL);
    paramParcel.writeLong(this.liveId);
    paramParcel.writeString(this.JfM);
    AppMethodBeat.o(277491);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveStartInfoPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveStartInfoPayload
 * JD-Core Version:    0.7.0.1
 */