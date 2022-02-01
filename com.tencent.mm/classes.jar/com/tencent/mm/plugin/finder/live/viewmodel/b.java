package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "", "liveId", "", "objectId", "liveMicId", "", "finderUsername", "sdkLiveId", "sdkUserId", "scene", "", "businessType", "pkSign", "avatarUrl", "finderNickname", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getBusinessType", "()I", "setBusinessType", "(I)V", "getFinderNickname", "setFinderNickname", "getFinderUsername", "setFinderUsername", "getLiveId", "()J", "setLiveId", "(J)V", "getLiveMicId", "setLiveMicId", "getObjectId", "setObjectId", "getPkSign", "setPkSign", "getScene", "setScene", "getSdkLiveId", "setSdkLiveId", "getSdkUserId", "setSdkUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class b
{
  public int businessType;
  public String finderUsername;
  public long hFK;
  public String hFO;
  public String kog;
  public long liveId;
  public int scene;
  public String uCn;
  public String uCo;
  public String uCp;
  public String uCq;
  
  public b()
  {
    this(0L, 0L, null, null, null, null, 0, 0, null, null, null, 2047);
  }
  
  private b(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.hFO = paramString1;
    this.finderUsername = paramString2;
    this.uCn = paramString3;
    this.uCo = paramString4;
    this.scene = paramInt1;
    this.businessType = paramInt2;
    this.uCp = paramString5;
    this.kog = paramString6;
    this.uCq = paramString7;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247873);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.liveId != paramObject.liveId) || (this.hFK != paramObject.hFK) || (!p.j(this.hFO, paramObject.hFO)) || (!p.j(this.finderUsername, paramObject.finderUsername)) || (!p.j(this.uCn, paramObject.uCn)) || (!p.j(this.uCo, paramObject.uCo)) || (this.scene != paramObject.scene) || (this.businessType != paramObject.businessType) || (!p.j(this.uCp, paramObject.uCp)) || (!p.j(this.kog, paramObject.kog)) || (!p.j(this.uCq, paramObject.uCq))) {}
      }
    }
    else
    {
      AppMethodBeat.o(247873);
      return true;
    }
    AppMethodBeat.o(247873);
    return false;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(247872);
    long l = this.liveId;
    int i3 = (int)(l ^ l >>> 32);
    l = this.hFK;
    int i4 = (int)(l ^ l >>> 32);
    String str = this.hFO;
    int i;
    int j;
    label76:
    int k;
    label93:
    int m;
    label111:
    int i5;
    int i6;
    int n;
    if (str != null)
    {
      i = str.hashCode();
      str = this.finderUsername;
      if (str == null) {
        break label247;
      }
      j = str.hashCode();
      str = this.uCn;
      if (str == null) {
        break label252;
      }
      k = str.hashCode();
      str = this.uCo;
      if (str == null) {
        break label257;
      }
      m = str.hashCode();
      i5 = this.scene;
      i6 = this.businessType;
      str = this.uCp;
      if (str == null) {
        break label263;
      }
      n = str.hashCode();
      label141:
      str = this.kog;
      if (str == null) {
        break label269;
      }
    }
    label257:
    label263:
    label269:
    for (int i1 = str.hashCode();; i1 = 0)
    {
      str = this.uCq;
      if (str != null) {
        i2 = str.hashCode();
      }
      AppMethodBeat.o(247872);
      return (i1 + (n + (((m + (k + (j + (i + (i3 * 31 + i4) * 31) * 31) * 31) * 31) * 31 + i5) * 31 + i6) * 31) * 31) * 31 + i2;
      i = 0;
      break;
      label247:
      j = 0;
      break label76;
      label252:
      k = 0;
      break label93;
      m = 0;
      break label111;
      n = 0;
      break label141;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247871);
    String str = "FinderLinkMicUser(liveId=" + this.liveId + ", objectId=" + this.hFK + ", liveMicId=" + this.hFO + ", finderUsername=" + this.finderUsername + ", sdkLiveId=" + this.uCn + ", sdkUserId=" + this.uCo + ", scene=" + this.scene + ", businessType=" + this.businessType + ", pkSign=" + this.uCp + ", avatarUrl=" + this.kog + ", finderNickname=" + this.uCq + ")";
    AppMethodBeat.o(247871);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.b
 * JD-Core Version:    0.7.0.1
 */