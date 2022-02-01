package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "", "duration", "", "audienceNum", "likeCount", "newFans", "wecoinHot", "", "(IIIIJ)V", "getAudienceNum", "()I", "setAudienceNum", "(I)V", "getDuration", "setDuration", "getLikeCount", "setLikeCount", "getNewFans", "setNewFans", "getWecoinHot", "()J", "setWecoinHot", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class a
{
  public int duration;
  public int likeCount;
  public int uCk;
  public int uCl;
  public long uCm;
  
  public a()
  {
    this(0, 0, 0, 0, 31);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.duration = paramInt1;
    this.uCk = paramInt2;
    this.likeCount = paramInt3;
    this.uCl = paramInt4;
    this.uCm = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.duration != paramObject.duration) || (this.uCk != paramObject.uCk) || (this.likeCount != paramObject.likeCount) || (this.uCl != paramObject.uCl) || (this.uCm != paramObject.uCm)) {}
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
    int j = this.uCk;
    int k = this.likeCount;
    int m = this.uCl;
    long l = this.uCm;
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247868);
    String str = "AnchorFinishInfo:duration:" + this.duration + ",audienceNum:" + this.uCk + ",likeCount:" + this.likeCount + ",newFans:" + this.uCl;
    AppMethodBeat.o(247868);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */