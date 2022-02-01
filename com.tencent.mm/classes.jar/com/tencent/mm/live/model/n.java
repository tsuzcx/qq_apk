package com.tencent.mm.live.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "", "liveId", "", "audience", "", "headImg", "nickName", "sdkUid", "micId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "getHeadImg", "getLiveId", "()J", "getMicId", "getNickName", "getSdkUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public final long liveId;
  public final String mXH;
  public final String mXK;
  public final String mXx;
  public final String mZa;
  public final String nickName;
  
  public n(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.liveId = paramLong;
    this.mXK = paramString1;
    this.mZa = paramString2;
    this.nickName = paramString3;
    this.mXH = paramString4;
    this.mXx = paramString5;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246532);
    if (this == paramObject)
    {
      AppMethodBeat.o(246532);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(246532);
      return false;
    }
    paramObject = (n)paramObject;
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(246532);
      return false;
    }
    if (!s.p(this.mXK, paramObject.mXK))
    {
      AppMethodBeat.o(246532);
      return false;
    }
    if (!s.p(this.mZa, paramObject.mZa))
    {
      AppMethodBeat.o(246532);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(246532);
      return false;
    }
    if (!s.p(this.mXH, paramObject.mXH))
    {
      AppMethodBeat.o(246532);
      return false;
    }
    if (!s.p(this.mXx, paramObject.mXx))
    {
      AppMethodBeat.o(246532);
      return false;
    }
    AppMethodBeat.o(246532);
    return true;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(246522);
    int i1 = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int i;
    int j;
    label35:
    int k;
    label44:
    int m;
    if (this.mXK == null)
    {
      i = 0;
      if (this.mZa != null) {
        break label107;
      }
      j = 0;
      if (this.nickName != null) {
        break label118;
      }
      k = 0;
      if (this.mXH != null) {
        break label129;
      }
      m = 0;
      label54:
      if (this.mXx != null) {
        break label141;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(246522);
      return (m + (k + (j + (i + i1 * 31) * 31) * 31) * 31) * 31 + n;
      i = this.mXK.hashCode();
      break;
      label107:
      j = this.mZa.hashCode();
      break label35;
      label118:
      k = this.nickName.hashCode();
      break label44;
      label129:
      m = this.mXH.hashCode();
      break label54;
      label141:
      n = this.mXx.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246514);
    String str = "LiveMicSuccessInfo(liveId=" + this.liveId + ", audience=" + this.mXK + ", headImg=" + this.mZa + ", nickName=" + this.nickName + ", sdkUid=" + this.mXH + ", micId=" + this.mXx + ')';
    AppMethodBeat.o(246514);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.n
 * JD-Core Version:    0.7.0.1
 */