package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "cdnUrl", "audienceMode", "", "anchorUserId", "appId", "bizId", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;JJ)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnUrl", "setCdnUrl", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
public final class c
{
  public long appId;
  public String gGA;
  public long gGy;
  public long gHA;
  public String gHx;
  public int gHy;
  public String gHz;
  
  public c()
  {
    this(null, 0L, null, 0, null, 0L, 0L, 127);
  }
  
  private c(String paramString1, long paramLong1, String paramString2, int paramInt, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(216813);
    this.gGA = paramString1;
    this.gGy = paramLong1;
    this.gHx = paramString2;
    this.gHy = paramInt;
    this.gHz = paramString3;
    this.appId = paramLong2;
    this.gHA = paramLong3;
    AppMethodBeat.o(216813);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216817);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.i(this.gGA, paramObject.gGA)) || (this.gGy != paramObject.gGy) || (!p.i(this.gHx, paramObject.gHx)) || (this.gHy != paramObject.gHy) || (!p.i(this.gHz, paramObject.gHz)) || (this.appId != paramObject.appId) || (this.gHA != paramObject.gHA)) {}
      }
    }
    else
    {
      AppMethodBeat.o(216817);
      return true;
    }
    AppMethodBeat.o(216817);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(216816);
    String str = this.gGA;
    int i;
    long l;
    int m;
    if (str != null)
    {
      i = str.hashCode();
      l = this.gGy;
      m = (int)(l ^ l >>> 32);
      str = this.gHx;
      if (str == null) {
        break label161;
      }
    }
    label161:
    for (int j = str.hashCode();; j = 0)
    {
      int n = this.gHy;
      str = this.gHz;
      if (str != null) {
        k = str.hashCode();
      }
      l = this.appId;
      int i1 = (int)(l ^ l >>> 32);
      l = this.gHA;
      int i2 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(216816);
      return ((((j + (i * 31 + m) * 31) * 31 + n) * 31 + k) * 31 + i1) * 31 + i2;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216815);
    String str = "LiveRoomInfo(liveName=" + this.gGA + ", liveId=" + this.gGy + ", cdnUrl=" + this.gHx + ", audienceMode=" + this.gHy + ", anchorUserId=" + this.gHz + ", appId=" + this.appId + ", bizId=" + this.gHA + ")";
    AppMethodBeat.o(216815);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.c
 * JD-Core Version:    0.7.0.1
 */