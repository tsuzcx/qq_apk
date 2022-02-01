package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "cdnUrl", "audienceMode", "", "anchorUserId", "appId", "bizId", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;JJ)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnUrl", "setCdnUrl", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
public final class c
{
  public long appId;
  public long gmP;
  public String gmR;
  public String gnO;
  public int gnP;
  public String gnQ;
  public long gnR;
  
  public c()
  {
    this(null, 0L, null, 0, null, 0L, 0L, 127);
  }
  
  private c(String paramString1, long paramLong1, String paramString2, int paramInt, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(209156);
    this.gmR = paramString1;
    this.gmP = paramLong1;
    this.gnO = paramString2;
    this.gnP = paramInt;
    this.gnQ = paramString3;
    this.appId = paramLong2;
    this.gnR = paramLong3;
    AppMethodBeat.o(209156);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209160);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!k.g(this.gmR, paramObject.gmR)) || (this.gmP != paramObject.gmP) || (!k.g(this.gnO, paramObject.gnO)) || (this.gnP != paramObject.gnP) || (!k.g(this.gnQ, paramObject.gnQ)) || (this.appId != paramObject.appId) || (this.gnR != paramObject.gnR)) {}
      }
    }
    else
    {
      AppMethodBeat.o(209160);
      return true;
    }
    AppMethodBeat.o(209160);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(209159);
    String str = this.gmR;
    int i;
    long l;
    int m;
    if (str != null)
    {
      i = str.hashCode();
      l = this.gmP;
      m = (int)(l ^ l >>> 32);
      str = this.gnO;
      if (str == null) {
        break label161;
      }
    }
    label161:
    for (int j = str.hashCode();; j = 0)
    {
      int n = this.gnP;
      str = this.gnQ;
      if (str != null) {
        k = str.hashCode();
      }
      l = this.appId;
      int i1 = (int)(l ^ l >>> 32);
      l = this.gnR;
      int i2 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(209159);
      return ((((j + (i * 31 + m) * 31) * 31 + n) * 31 + k) * 31 + i1) * 31 + i2;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209158);
    String str = "LiveRoomInfo(liveName=" + this.gmR + ", liveId=" + this.gmP + ", cdnUrl=" + this.gnO + ", audienceMode=" + this.gnP + ", anchorUserId=" + this.gnQ + ", appId=" + this.appId + ", bizId=" + this.gnR + ")";
    AppMethodBeat.o(209158);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.c
 * JD-Core Version:    0.7.0.1
 */