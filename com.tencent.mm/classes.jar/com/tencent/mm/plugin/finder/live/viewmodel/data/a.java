package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "", "duration", "", "audienceNum", "likeCount", "newFans", "wecoinHot", "", "(IIIIJ)V", "getAudienceNum", "()I", "setAudienceNum", "(I)V", "getDuration", "setDuration", "getLikeCount", "setLikeCount", "getNewFans", "setNewFans", "getWecoinHot", "()J", "setWecoinHot", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class a
{
  public int duration;
  public int likeCount;
  public int zes;
  public int zet;
  public long zeu;
  
  public a()
  {
    this(0, 0, 0, 0, 31);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.duration = paramInt1;
    this.zes = paramInt2;
    this.likeCount = paramInt3;
    this.zet = paramInt4;
    this.zeu = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.duration != paramObject.duration) || (this.zes != paramObject.zes) || (this.likeCount != paramObject.likeCount) || (this.zet != paramObject.zet) || (this.zeu != paramObject.zeu)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.duration;
    int j = this.zes;
    int k = this.likeCount;
    int m = this.zet;
    long l = this.zeu;
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260982);
    String str = "AnchorFinishInfo:duration:" + this.duration + ",audienceNum:" + this.zes + ",likeCount:" + this.likeCount + ",newFans:" + this.zet;
    AppMethodBeat.o(260982);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a
 * JD-Core Version:    0.7.0.1
 */