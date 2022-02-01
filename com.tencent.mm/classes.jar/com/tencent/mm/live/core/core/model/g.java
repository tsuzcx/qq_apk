package com.tencent.mm.live.core.core.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "audienceMode", "", "anchorUserId", "appId", "bizId", "cdnSwitchMode", "Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "cdnQualitySvrcfg", "cdnH265BackCfg", "cdnCustomerSwitchLevel", "cdnUrlMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "Lkotlin/collections/HashMap;", "startTime", "seiMode", "channelParams", "Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;", "nickName", "useTXLivePlayerCustomRender", "customRenderInfo", "(Ljava/lang/String;JILjava/lang/String;JJLcom/tencent/mm/live/core/core/model/CdnSwitchMode;IIILjava/util/HashMap;JILcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;Ljava/lang/String;JJ)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnCustomerSwitchLevel", "setCdnCustomerSwitchLevel", "getCdnH265BackCfg", "setCdnH265BackCfg", "getCdnQualitySvrcfg", "setCdnQualitySvrcfg", "getCdnSwitchMode", "()Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "setCdnSwitchMode", "(Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;)V", "getCdnUrlMap", "()Ljava/util/HashMap;", "setCdnUrlMap", "(Ljava/util/HashMap;)V", "getChannelParams", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;", "setChannelParams", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;)V", "getCustomRenderInfo", "setCustomRenderInfo", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "getNickName", "setNickName", "getSeiMode", "setSeiMode", "getStartTime", "setStartTime", "getUseTXLivePlayerCustomRender", "setUseTXLivePlayerCustomRender", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "currentVideoLevel", "customerSwitchCfgEnable", "", "equals", "other", "exchangeCdnUrl", "", "firstCfg", "secondCfg", "getCdnUrl", "cdnQualityTag", "getLiveVideoInfo", "urlInfo", "getLiveVideoInfoByLevel", "level", "hashCode", "indexOfLevel", "indexOfUrl", "url", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public long appId;
  public long liveId;
  public String mIA;
  public int mJU;
  public int mNn;
  public String mNo;
  public long mNp;
  public a mNq;
  public int mNr;
  public int mNs;
  public HashMap<Integer, j> mNt;
  public int mNu;
  public diw mNv;
  public long mNw;
  public long mNx;
  public String nickName;
  public long startTime;
  
  public g()
  {
    this(null, 0L, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131071);
  }
  
  private g(String paramString1, long paramLong1, int paramInt1, String paramString2, long paramLong2, long paramLong3, a parama, int paramInt2, HashMap<Integer, j> paramHashMap, long paramLong4, diw paramdiw, String paramString3)
  {
    AppMethodBeat.i(247950);
    this.mIA = paramString1;
    this.liveId = paramLong1;
    this.mNn = paramInt1;
    this.mNo = paramString2;
    this.appId = paramLong2;
    this.mNp = paramLong3;
    this.mNq = parama;
    this.mNr = 0;
    this.mJU = 0;
    this.mNs = paramInt2;
    this.mNt = paramHashMap;
    this.startTime = paramLong4;
    this.mNu = 0;
    this.mNv = paramdiw;
    this.nickName = paramString3;
    this.mNw = 0L;
    this.mNx = 0L;
    AppMethodBeat.o(247950);
  }
  
  private j sR(int paramInt)
  {
    AppMethodBeat.i(247967);
    Object localObject = this.mNt.values();
    s.s(localObject, "cdnUrlMap.values");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((j)localObject).level == paramInt)
      {
        i = 1;
        label61:
        if (i == 0) {
          break label80;
        }
      }
    }
    for (;;)
    {
      localObject = (j)localObject;
      AppMethodBeat.o(247967);
      return localObject;
      i = 0;
      break label61;
      label80:
      break;
      localObject = null;
    }
  }
  
  public final void FN(String paramString)
  {
    AppMethodBeat.i(247982);
    s.u(paramString, "<set-?>");
    this.mIA = paramString;
    AppMethodBeat.o(247982);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(247987);
    s.u(parama, "<set-?>");
    this.mNq = parama;
    AppMethodBeat.o(247987);
  }
  
  public final void a(diw paramdiw)
  {
    AppMethodBeat.i(247993);
    s.u(paramdiw, "<set-?>");
    this.mNv = paramdiw;
    AppMethodBeat.o(247993);
  }
  
  public final boolean bel()
  {
    AppMethodBeat.i(248019);
    if ((this.mNs > 0) && (sR(this.mNs) != null))
    {
      AppMethodBeat.o(248019);
      return true;
    }
    AppMethodBeat.o(248019);
    return false;
  }
  
  public final int bem()
  {
    AppMethodBeat.i(248025);
    if (bel())
    {
      i = this.mNs;
      AppMethodBeat.o(248025);
      return i;
    }
    j localj = sQ(this.mNr);
    if (localj == null)
    {
      AppMethodBeat.o(248025);
      return 0;
    }
    int i = localj.level;
    AppMethodBeat.o(248025);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248064);
    if (this == paramObject)
    {
      AppMethodBeat.o(248064);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(248064);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.mIA, paramObject.mIA))
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNn != paramObject.mNn)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (!s.p(this.mNo, paramObject.mNo))
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.appId != paramObject.appId)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNp != paramObject.mNp)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNq != paramObject.mNq)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNr != paramObject.mNr)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mJU != paramObject.mJU)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNs != paramObject.mNs)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (!s.p(this.mNt, paramObject.mNt))
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.startTime != paramObject.startTime)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNu != paramObject.mNu)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (!s.p(this.mNv, paramObject.mNv))
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNw != paramObject.mNw)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    if (this.mNx != paramObject.mNx)
    {
      AppMethodBeat.o(248064);
      return false;
    }
    AppMethodBeat.o(248064);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(248049);
    int j = this.mIA.hashCode();
    int k = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int m = this.mNn;
    if (this.mNo == null) {}
    for (int i = 0;; i = this.mNo.hashCode())
    {
      int n = q.a..ExternalSyntheticBackport0.m(this.appId);
      int i1 = q.a..ExternalSyntheticBackport0.m(this.mNp);
      int i2 = this.mNq.hashCode();
      int i3 = this.mNr;
      int i4 = this.mJU;
      int i5 = this.mNs;
      int i6 = this.mNt.hashCode();
      int i7 = q.a..ExternalSyntheticBackport0.m(this.startTime);
      int i8 = this.mNu;
      int i9 = this.mNv.hashCode();
      int i10 = this.nickName.hashCode();
      int i11 = q.a..ExternalSyntheticBackport0.m(this.mNw);
      int i12 = q.a..ExternalSyntheticBackport0.m(this.mNx);
      AppMethodBeat.o(248049);
      return (((((((((((((i + ((j * 31 + k) * 31 + m) * 31) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12;
    }
  }
  
  public final String sP(int paramInt)
  {
    AppMethodBeat.i(248004);
    Log.i("LiveRoomInfo", "getCdnUrl cdnQualityTag:" + paramInt + ", liveInfo:" + this.mNt.get(Integer.valueOf(paramInt)) + ", cdnQualitySvrcfg:" + this.mNr + ",cdnCustomerSwitchCfg:" + this.mNs);
    Object localObject = (j)this.mNt.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = (j)this.mNt.get(Integer.valueOf(0));
      if (localObject == null)
      {
        AppMethodBeat.o(248004);
        return null;
      }
      localObject = ((j)localObject).url;
      AppMethodBeat.o(248004);
      return localObject;
    }
    localObject = ((j)localObject).url;
    AppMethodBeat.o(248004);
    return localObject;
  }
  
  public final j sQ(int paramInt)
  {
    AppMethodBeat.i(248013);
    Log.i("LiveRoomInfo", "getLiveVideoInfo cdnQualityTag:" + paramInt + ", liveInfo:" + this.mNt.get(Integer.valueOf(paramInt)) + ", cdnQualitySvrcfg:" + this.mNr + ",cdnCustomerSwitchCfg:" + this.mNs);
    j localj = (j)this.mNt.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(248013);
    return localj;
  }
  
  public final int sS(int paramInt)
  {
    AppMethodBeat.i(248034);
    Object localObject1 = this.mNt.values();
    s.s(localObject1, "cdnUrlMap.values");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      if (((j)localObject2).level == paramInt)
      {
        j = 1;
        label76:
        if (j == 0) {
          break label137;
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.live.core.d.a.mWH;
      if (com.tencent.mm.live.core.d.a.bgV()) {
        Log.i("LiveRoomInfo", "indexOfUrl " + paramInt + ", index:" + i);
      }
      AppMethodBeat.o(248034);
      return i;
      j = 0;
      break label76;
      label137:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(247998);
    s.u(paramString, "<set-?>");
    this.nickName = paramString;
    AppMethodBeat.o(247998);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248040);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LiveRoomInfo(liveName=").append(this.mIA).append(", liveId=").append(this.liveId).append(", audienceMode=").append(this.mNn).append(", anchorUserId=").append(this.mNo).append(", appId=").append(this.appId).append(", bizId=").append(this.mNp).append(", cdnSwitchMode=").append(this.mNq).append(", cdnQualitySvrcfg=").append(this.mNr).append(", cdnH265BackCfg=").append(this.mJU).append(", cdnCustomerSwitchLevel=").append(this.mNs).append(", cdnUrlMap=").append(this.mNt).append(", startTime=");
    ((StringBuilder)localObject).append(this.startTime).append(", seiMode=").append(this.mNu).append(", channelParams=").append(this.mNv).append(", nickName=").append(this.nickName).append(", useTXLivePlayerCustomRender=").append(this.mNw).append(", customRenderInfo=").append(this.mNx).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(248040);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.g
 * JD-Core Version:    0.7.0.1
 */