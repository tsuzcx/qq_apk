package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "cdnUrl", "audienceMode", "", "anchorUserId", "appId", "bizId", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;JJ)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnUrl", "setCdnUrl", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
public final class c
{
  public long appId;
  public long gJh;
  public String gJj;
  public String gKg;
  public int gKh;
  public String gKi;
  public long gKj;
  
  public c()
  {
    this(null, 0L, null, 0, null, 0L, 0L, 127);
  }
  
  private c(String paramString1, long paramLong1, String paramString2, int paramInt, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(196825);
    this.gJj = paramString1;
    this.gJh = paramLong1;
    this.gKg = paramString2;
    this.gKh = paramInt;
    this.gKi = paramString3;
    this.appId = paramLong2;
    this.gKj = paramLong3;
    AppMethodBeat.o(196825);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196829);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.i(this.gJj, paramObject.gJj)) || (this.gJh != paramObject.gJh) || (!p.i(this.gKg, paramObject.gKg)) || (this.gKh != paramObject.gKh) || (!p.i(this.gKi, paramObject.gKi)) || (this.appId != paramObject.appId) || (this.gKj != paramObject.gKj)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196829);
      return true;
    }
    AppMethodBeat.o(196829);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(196828);
    String str = this.gJj;
    int i;
    long l;
    int m;
    if (str != null)
    {
      i = str.hashCode();
      l = this.gJh;
      m = (int)(l ^ l >>> 32);
      str = this.gKg;
      if (str == null) {
        break label161;
      }
    }
    label161:
    for (int j = str.hashCode();; j = 0)
    {
      int n = this.gKh;
      str = this.gKi;
      if (str != null) {
        k = str.hashCode();
      }
      l = this.appId;
      int i1 = (int)(l ^ l >>> 32);
      l = this.gKj;
      int i2 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(196828);
      return ((((j + (i * 31 + m) * 31) * 31 + n) * 31 + k) * 31 + i1) * 31 + i2;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196827);
    String str = "LiveRoomInfo(liveName=" + this.gJj + ", liveId=" + this.gJh + ", cdnUrl=" + this.gKg + ", audienceMode=" + this.gKh + ", anchorUserId=" + this.gKi + ", appId=" + this.appId + ", bizId=" + this.gKj + ")";
    AppMethodBeat.o(196827);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.c
 * JD-Core Version:    0.7.0.1
 */