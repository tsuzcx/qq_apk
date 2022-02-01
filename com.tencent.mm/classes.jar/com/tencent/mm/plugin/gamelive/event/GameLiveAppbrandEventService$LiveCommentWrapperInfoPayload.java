package com.tencent.mm.plugin.gamelive.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload;", "Landroid/os/Parcelable;", "liveId", "", "currOnlineCount", "totalViewCount", "currLikeCount", "totalRewardCount", "msgList", "", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveSingleCommentPayload;", "(JJJJJLjava/util/List;)V", "getCurrLikeCount", "()J", "setCurrLikeCount", "(J)V", "getCurrOnlineCount", "setCurrOnlineCount", "getLiveId", "setLiveId", "getMsgList", "()Ljava/util/List;", "setMsgList", "(Ljava/util/List;)V", "getTotalRewardCount", "setTotalRewardCount", "getTotalViewCount", "setTotalViewCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator<LiveCommentWrapperInfoPayload> CREATOR;
  public List<GameLiveAppbrandEventService.LiveSingleCommentPayload> EgE;
  public long Jfo;
  public long Jfp;
  public long Jfq;
  public long Jfr;
  public long liveId;
  
  static
  {
    AppMethodBeat.i(277424);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(277424);
  }
  
  private GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, List<GameLiveAppbrandEventService.LiveSingleCommentPayload> paramList)
  {
    this.liveId = paramLong1;
    this.Jfo = paramLong2;
    this.Jfp = paramLong3;
    this.Jfq = paramLong4;
    this.Jfr = paramLong5;
    this.EgE = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277442);
    if (this == paramObject)
    {
      AppMethodBeat.o(277442);
      return true;
    }
    if (!(paramObject instanceof LiveCommentWrapperInfoPayload))
    {
      AppMethodBeat.o(277442);
      return false;
    }
    paramObject = (LiveCommentWrapperInfoPayload)paramObject;
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(277442);
      return false;
    }
    if (this.Jfo != paramObject.Jfo)
    {
      AppMethodBeat.o(277442);
      return false;
    }
    if (this.Jfp != paramObject.Jfp)
    {
      AppMethodBeat.o(277442);
      return false;
    }
    if (this.Jfq != paramObject.Jfq)
    {
      AppMethodBeat.o(277442);
      return false;
    }
    if (this.Jfr != paramObject.Jfr)
    {
      AppMethodBeat.o(277442);
      return false;
    }
    if (!s.p(this.EgE, paramObject.EgE))
    {
      AppMethodBeat.o(277442);
      return false;
    }
    AppMethodBeat.o(277442);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(277433);
    int j = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int k = q.a..ExternalSyntheticBackport0.m(this.Jfo);
    int m = q.a..ExternalSyntheticBackport0.m(this.Jfp);
    int n = q.a..ExternalSyntheticBackport0.m(this.Jfq);
    int i1 = q.a..ExternalSyntheticBackport0.m(this.Jfr);
    if (this.EgE == null) {}
    for (int i = 0;; i = this.EgE.hashCode())
    {
      AppMethodBeat.o(277433);
      return i + ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277429);
    String str = "LiveCommentWrapperInfoPayload(liveId=" + this.liveId + ", currOnlineCount=" + this.Jfo + ", totalViewCount=" + this.Jfp + ", currLikeCount=" + this.Jfq + ", totalRewardCount=" + this.Jfr + ", msgList=" + this.EgE + ')';
    AppMethodBeat.o(277429);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277458);
    s.u(paramParcel, "out");
    paramParcel.writeLong(this.liveId);
    paramParcel.writeLong(this.Jfo);
    paramParcel.writeLong(this.Jfp);
    paramParcel.writeLong(this.Jfq);
    paramParcel.writeLong(this.Jfr);
    Object localObject = this.EgE;
    if (localObject == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(277458);
      return;
    }
    paramParcel.writeInt(1);
    paramParcel.writeInt(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GameLiveAppbrandEventService.LiveSingleCommentPayload)((Iterator)localObject).next()).writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(277458);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload
 * JD-Core Version:    0.7.0.1
 */