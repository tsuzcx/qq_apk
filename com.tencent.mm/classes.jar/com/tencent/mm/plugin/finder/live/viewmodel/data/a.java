package com.tencent.mm.plugin.finder.live.viewmodel.data;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "", "duration", "", "audienceNum", "likeCount", "", "newFans", "wecoinHot", "maxOnlineCnt", "avgDuration", "totalGift", "bizLiveNewFansNum", "(IIJIJIIJI)V", "getAudienceNum", "()I", "setAudienceNum", "(I)V", "getAvgDuration", "setAvgDuration", "getBizLiveNewFansNum", "setBizLiveNewFansNum", "getDuration", "setDuration", "getLikeCount", "()J", "setLikeCount", "(J)V", "getMaxOnlineCnt", "setMaxOnlineCnt", "getNewFans", "setNewFans", "getTotalGift", "setTotalGift", "getWecoinHot", "setWecoinHot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public long DFW;
  public int Ebh;
  public int Ebi;
  public long Ebj;
  public int Ebk;
  public int Ebl;
  public long Ebm;
  public int Ebn;
  public int duration;
  
  public a()
  {
    this(0, 0, 0L, 0, 0L, 0, 0, 0L, 511, (byte)0);
  }
  
  public a(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, int paramInt4, int paramInt5, long paramLong3, int paramInt6)
  {
    this.duration = paramInt1;
    this.Ebh = paramInt2;
    this.DFW = paramLong1;
    this.Ebi = paramInt3;
    this.Ebj = paramLong2;
    this.Ebk = paramInt4;
    this.Ebl = paramInt5;
    this.Ebm = paramLong3;
    this.Ebn = paramInt6;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.duration != paramObject.duration) {
        return false;
      }
      if (this.Ebh != paramObject.Ebh) {
        return false;
      }
      if (this.DFW != paramObject.DFW) {
        return false;
      }
      if (this.Ebi != paramObject.Ebi) {
        return false;
      }
      if (this.Ebj != paramObject.Ebj) {
        return false;
      }
      if (this.Ebk != paramObject.Ebk) {
        return false;
      }
      if (this.Ebl != paramObject.Ebl) {
        return false;
      }
      if (this.Ebm != paramObject.Ebm) {
        return false;
      }
    } while (this.Ebn == paramObject.Ebn);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(356578);
    int i = this.duration;
    int j = this.Ebh;
    int k = q.a..ExternalSyntheticBackport0.m(this.DFW);
    int m = this.Ebi;
    int n = q.a..ExternalSyntheticBackport0.m(this.Ebj);
    int i1 = this.Ebk;
    int i2 = this.Ebl;
    int i3 = q.a..ExternalSyntheticBackport0.m(this.Ebm);
    int i4 = this.Ebn;
    AppMethodBeat.o(356578);
    return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356569);
    String str = "AnchorFinishInfo(duration=" + this.duration + ", audienceNum=" + this.Ebh + ", likeCount=" + this.DFW + ", newFans=" + this.Ebi + ", wecoinHot=" + this.Ebj + ", maxOnlineCnt=" + this.Ebk + ", avgDuration=" + this.Ebl + ", totalGift=" + this.Ebm + ", bizLiveNewFansNum=" + this.Ebn + ')';
    AppMethodBeat.o(356569);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a
 * JD-Core Version:    0.7.0.1
 */