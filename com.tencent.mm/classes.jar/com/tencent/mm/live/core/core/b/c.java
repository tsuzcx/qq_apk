package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "cdnUrl", "audienceMode", "", "anchorUserId", "appId", "bizId", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;JJ)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnUrl", "setCdnUrl", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
public final class c
{
  public long DlB;
  public long appId;
  public String qud;
  public int qzb;
  public String qzc;
  public long qzd;
  public String syH;
  
  public c()
  {
    this(null, 0L, null, 0, null, 0L, 0L, 127);
  }
  
  private c(String paramString1, long paramLong1, String paramString2, int paramInt, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(205623);
    this.qud = paramString1;
    this.DlB = paramLong1;
    this.syH = paramString2;
    this.qzb = paramInt;
    this.qzc = paramString3;
    this.appId = paramLong2;
    this.qzd = paramLong3;
    AppMethodBeat.o(205623);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205627);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!k.g(this.qud, paramObject.qud)) || (this.DlB != paramObject.DlB) || (!k.g(this.syH, paramObject.syH)) || (this.qzb != paramObject.qzb) || (!k.g(this.qzc, paramObject.qzc)) || (this.appId != paramObject.appId) || (this.qzd != paramObject.qzd)) {}
      }
    }
    else
    {
      AppMethodBeat.o(205627);
      return true;
    }
    AppMethodBeat.o(205627);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(205626);
    String str = this.qud;
    int i;
    long l;
    int m;
    if (str != null)
    {
      i = str.hashCode();
      l = this.DlB;
      m = (int)(l ^ l >>> 32);
      str = this.syH;
      if (str == null) {
        break label161;
      }
    }
    label161:
    for (int j = str.hashCode();; j = 0)
    {
      int n = this.qzb;
      str = this.qzc;
      if (str != null) {
        k = str.hashCode();
      }
      l = this.appId;
      int i1 = (int)(l ^ l >>> 32);
      l = this.qzd;
      int i2 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(205626);
      return ((((j + (i * 31 + m) * 31) * 31 + n) * 31 + k) * 31 + i1) * 31 + i2;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205625);
    String str = "LiveRoomInfo(liveName=" + this.qud + ", liveId=" + this.DlB + ", cdnUrl=" + this.syH + ", audienceMode=" + this.qzb + ", anchorUserId=" + this.qzc + ", appId=" + this.appId + ", bizId=" + this.qzd + ")";
    AppMethodBeat.o(205625);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.c
 * JD-Core Version:    0.7.0.1
 */