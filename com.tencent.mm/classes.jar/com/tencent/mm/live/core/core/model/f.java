package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "audienceMode", "", "anchorUserId", "appId", "bizId", "cdnSwitchMode", "Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "cdnQualitySvrcfg", "cdnH265BackCfg", "cdnUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startTime", "seiMode", "channelParams", "Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;", "(Ljava/lang/String;JILjava/lang/String;JJLcom/tencent/mm/live/core/core/model/CdnSwitchMode;IILjava/util/HashMap;JILcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnH265BackCfg", "setCdnH265BackCfg", "getCdnQualitySvrcfg", "setCdnQualitySvrcfg", "getCdnSwitchMode", "()Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "setCdnSwitchMode", "(Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;)V", "getCdnUrlMap", "()Ljava/util/HashMap;", "setCdnUrlMap", "(Ljava/util/HashMap;)V", "getChannelParams", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;", "setChannelParams", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;)V", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "getSeiMode", "setSeiMode", "getStartTime", "setStartTime", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getCdnUrl", "cdnQualityTag", "hashCode", "indexOfUrl", "url", "toString", "plugin-core_release"})
public final class f
{
  public long appId;
  public String kie;
  public int kjq;
  public int kjr;
  public int kmi;
  public String kmj;
  public long kmk;
  public a kml;
  public HashMap<Integer, String> kmm;
  public int kmn;
  public crv kmo;
  public long liveId;
  public long startTime;
  
  public f()
  {
    this(null, 0L, 0, null, 0L, 0L, null, null, 0L, null, 8191);
  }
  
  private f(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2, long paramLong3, a parama, HashMap<Integer, String> paramHashMap, long paramLong4, crv paramcrv)
  {
    AppMethodBeat.i(198763);
    this.kie = paramString1;
    this.liveId = paramLong1;
    this.kmi = paramInt;
    this.kmj = paramString2;
    this.appId = paramLong2;
    this.kmk = paramLong3;
    this.kml = parama;
    this.kjq = 0;
    this.kjr = 0;
    this.kmm = paramHashMap;
    this.startTime = paramLong4;
    this.kmn = 0;
    this.kmo = paramcrv;
    AppMethodBeat.o(198763);
  }
  
  public final void Nu(String paramString)
  {
    AppMethodBeat.i(198755);
    p.k(paramString, "<set-?>");
    this.kie = paramString;
    AppMethodBeat.o(198755);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(198757);
    p.k(parama, "<set-?>");
    this.kml = parama;
    AppMethodBeat.o(198757);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198779);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!p.h(this.kie, paramObject.kie)) || (this.liveId != paramObject.liveId) || (this.kmi != paramObject.kmi) || (!p.h(this.kmj, paramObject.kmj)) || (this.appId != paramObject.appId) || (this.kmk != paramObject.kmk) || (!p.h(this.kml, paramObject.kml)) || (this.kjq != paramObject.kjq) || (this.kjr != paramObject.kjr) || (!p.h(this.kmm, paramObject.kmm)) || (this.startTime != paramObject.startTime) || (this.kmn != paramObject.kmn) || (!p.h(this.kmo, paramObject.kmo))) {}
      }
    }
    else
    {
      AppMethodBeat.o(198779);
      return true;
    }
    AppMethodBeat.o(198779);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(198774);
    Object localObject = this.kie;
    int i;
    long l;
    int i1;
    int i2;
    int j;
    label65:
    int i3;
    int i4;
    int k;
    label116:
    int i5;
    int i6;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.liveId;
      i1 = (int)(l ^ l >>> 32);
      i2 = this.kmi;
      localObject = this.kmj;
      if (localObject == null) {
        break label269;
      }
      j = localObject.hashCode();
      l = this.appId;
      i3 = (int)(l ^ l >>> 32);
      l = this.kmk;
      i4 = (int)(l ^ l >>> 32);
      localObject = this.kml;
      if (localObject == null) {
        break label274;
      }
      k = localObject.hashCode();
      i5 = this.kjq;
      i6 = this.kjr;
      localObject = this.kmm;
      if (localObject == null) {
        break label279;
      }
    }
    label269:
    label274:
    label279:
    for (int m = localObject.hashCode();; m = 0)
    {
      l = this.startTime;
      int i7 = (int)(l ^ l >>> 32);
      int i8 = this.kmn;
      localObject = this.kmo;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      AppMethodBeat.o(198774);
      return (((m + (((k + (((j + ((i * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label65;
      k = 0;
      break label116;
    }
  }
  
  public final String sS(int paramInt)
  {
    AppMethodBeat.i(198753);
    Log.i("LiveRoomInfo", "getCdnUrl cdnQualitySvrcfg".concat(String.valueOf(paramInt)));
    String str2 = (String)this.kmm.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = (String)this.kmm.get(Integer.valueOf(0));
    }
    AppMethodBeat.o(198753);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198773);
    String str = "LiveRoomInfo(liveName=" + this.kie + ", liveId=" + this.liveId + ", audienceMode=" + this.kmi + ", anchorUserId=" + this.kmj + ", appId=" + this.appId + ", bizId=" + this.kmk + ", cdnSwitchMode=" + this.kml + ", cdnQualitySvrcfg=" + this.kjq + ", cdnH265BackCfg=" + this.kjr + ", cdnUrlMap=" + this.kmm + ", startTime=" + this.startTime + ", seiMode=" + this.kmn + ", channelParams=" + this.kmo + ")";
    AppMethodBeat.o(198773);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.f
 * JD-Core Version:    0.7.0.1
 */