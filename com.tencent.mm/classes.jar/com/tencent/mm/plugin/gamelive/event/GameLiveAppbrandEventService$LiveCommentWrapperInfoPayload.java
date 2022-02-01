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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload;", "Landroid/os/Parcelable;", "liveId", "", "currOnlineCount", "totalViewCount", "currLikeCount", "totalRewardCount", "msgList", "", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveSingleCommentPayload;", "(JJJJJLjava/util/List;)V", "getCurrLikeCount", "()J", "setCurrLikeCount", "(J)V", "getCurrOnlineCount", "setCurrOnlineCount", "getLiveId", "setLiveId", "getMsgList", "()Ljava/util/List;", "setMsgList", "(Ljava/util/List;)V", "getTotalRewardCount", "setTotalRewardCount", "getTotalViewCount", "setTotalViewCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public long Dmf;
  public long Dmg;
  public long Dmh;
  public long Dmi;
  public long liveId;
  public List<GameLiveAppbrandEventService.LiveSingleCommentPayload> ziq;
  
  static
  {
    AppMethodBeat.i(208673);
    CREATOR = new a();
    AppMethodBeat.o(208673);
  }
  
  private GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload(byte paramByte)
  {
    this();
  }
  
  public GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, List<GameLiveAppbrandEventService.LiveSingleCommentPayload> paramList)
  {
    this.liveId = paramLong1;
    this.Dmf = paramLong2;
    this.Dmg = paramLong3;
    this.Dmh = paramLong4;
    this.Dmi = paramLong5;
    this.ziq = paramList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208670);
    if (this != paramObject)
    {
      if ((paramObject instanceof LiveCommentWrapperInfoPayload))
      {
        paramObject = (LiveCommentWrapperInfoPayload)paramObject;
        if ((this.liveId != paramObject.liveId) || (this.Dmf != paramObject.Dmf) || (this.Dmg != paramObject.Dmg) || (this.Dmh != paramObject.Dmh) || (this.Dmi != paramObject.Dmi) || (!p.h(this.ziq, paramObject.ziq))) {}
      }
    }
    else
    {
      AppMethodBeat.o(208670);
      return true;
    }
    AppMethodBeat.o(208670);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208668);
    long l = this.liveId;
    int j = (int)(l ^ l >>> 32);
    l = this.Dmf;
    int k = (int)(l ^ l >>> 32);
    l = this.Dmg;
    int m = (int)(l ^ l >>> 32);
    l = this.Dmh;
    int n = (int)(l ^ l >>> 32);
    l = this.Dmi;
    int i1 = (int)(l ^ l >>> 32);
    List localList = this.ziq;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      AppMethodBeat.o(208668);
      return i + ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208667);
    String str = "LiveCommentWrapperInfoPayload(liveId=" + this.liveId + ", currOnlineCount=" + this.Dmf + ", totalViewCount=" + this.Dmg + ", currLikeCount=" + this.Dmh + ", totalRewardCount=" + this.Dmi + ", msgList=" + this.ziq + ")";
    AppMethodBeat.o(208667);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208672);
    p.k(paramParcel, "parcel");
    paramParcel.writeLong(this.liveId);
    paramParcel.writeLong(this.Dmf);
    paramParcel.writeLong(this.Dmg);
    paramParcel.writeLong(this.Dmh);
    paramParcel.writeLong(this.Dmi);
    Object localObject = this.ziq;
    if (localObject != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeInt(((Collection)localObject).size());
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GameLiveAppbrandEventService.LiveSingleCommentPayload)((Iterator)localObject).next()).writeToParcel(paramParcel, 0);
      }
      AppMethodBeat.o(208672);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(208672);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(208391);
      p.k(paramParcel, "in");
      long l1 = paramParcel.readLong();
      long l2 = paramParcel.readLong();
      long l3 = paramParcel.readLong();
      long l4 = paramParcel.readLong();
      long l5 = paramParcel.readLong();
      if (paramParcel.readInt() != 0)
      {
        int i = paramParcel.readInt();
        ArrayList localArrayList2 = new ArrayList(i);
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (i == 0) {
            break;
          }
          localArrayList2.add((GameLiveAppbrandEventService.LiveSingleCommentPayload)GameLiveAppbrandEventService.LiveSingleCommentPayload.CREATOR.createFromParcel(paramParcel));
          i -= 1;
        }
      }
      ArrayList localArrayList1 = null;
      paramParcel = new GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload(l1, l2, l3, l4, l5, localArrayList1);
      AppMethodBeat.o(208391);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload
 * JD-Core Version:    0.7.0.1
 */