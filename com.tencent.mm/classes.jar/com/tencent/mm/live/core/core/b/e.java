package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "", "liveName", "", "liveId", "", "audienceMode", "", "anchorUserId", "appId", "bizId", "liveScene", "cdnSwitchMode", "Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "cdnQualitySvrcfg", "cdnH265BackCfg", "cdnUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startTime", "(Ljava/lang/String;JILjava/lang/String;JJILcom/tencent/mm/live/core/core/model/CdnSwitchMode;IILjava/util/HashMap;J)V", "getAnchorUserId", "()Ljava/lang/String;", "setAnchorUserId", "(Ljava/lang/String;)V", "getAppId", "()J", "setAppId", "(J)V", "getAudienceMode", "()I", "setAudienceMode", "(I)V", "getBizId", "setBizId", "getCdnH265BackCfg", "setCdnH265BackCfg", "getCdnQualitySvrcfg", "setCdnQualitySvrcfg", "getCdnSwitchMode", "()Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "setCdnSwitchMode", "(Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;)V", "getCdnUrlMap", "()Ljava/util/HashMap;", "setCdnUrlMap", "(Ljava/util/HashMap;)V", "getLiveId", "setLiveId", "getLiveName", "setLiveName", "getLiveScene", "setLiveScene", "getStartTime", "setStartTime", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getCdnUrl", "cdnQualityTag", "hashCode", "indexOfUrl", "url", "toString", "plugin-core_release"})
public final class e
{
  public long appId;
  private String hwb;
  public int hzl;
  public String hzm;
  public long hzn;
  public int hzo;
  public a hzp;
  public int hzq;
  public int hzr;
  public HashMap<Integer, String> hzs;
  public long liveId;
  public long startTime;
  
  public e()
  {
    this(null, 0L, 0, null, 0L, 0L, 0, null, null, 0L, 4095);
  }
  
  private e(String paramString1, long paramLong1, int paramInt1, String paramString2, long paramLong2, long paramLong3, int paramInt2, a parama, HashMap<Integer, String> paramHashMap, long paramLong4)
  {
    AppMethodBeat.i(196458);
    this.hwb = paramString1;
    this.liveId = paramLong1;
    this.hzl = paramInt1;
    this.hzm = paramString2;
    this.appId = paramLong2;
    this.hzn = paramLong3;
    this.hzo = paramInt2;
    this.hzp = parama;
    this.hzq = 0;
    this.hzr = 0;
    this.hzs = paramHashMap;
    this.startTime = paramLong4;
    AppMethodBeat.o(196458);
  }
  
  public final void Gn(String paramString)
  {
    AppMethodBeat.i(196456);
    p.h(paramString, "<set-?>");
    this.hwb = paramString;
    AppMethodBeat.o(196456);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(196457);
    p.h(parama, "<set-?>");
    this.hzp = parama;
    AppMethodBeat.o(196457);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196462);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.j(this.hwb, paramObject.hwb)) || (this.liveId != paramObject.liveId) || (this.hzl != paramObject.hzl) || (!p.j(this.hzm, paramObject.hzm)) || (this.appId != paramObject.appId) || (this.hzn != paramObject.hzn) || (this.hzo != paramObject.hzo) || (!p.j(this.hzp, paramObject.hzp)) || (this.hzq != paramObject.hzq) || (this.hzr != paramObject.hzr) || (!p.j(this.hzs, paramObject.hzs)) || (this.startTime != paramObject.startTime)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196462);
      return true;
    }
    AppMethodBeat.o(196462);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(196461);
    Object localObject = this.hwb;
    int i;
    long l;
    int n;
    int i1;
    int j;
    label65:
    int i2;
    int i3;
    int i4;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.liveId;
      n = (int)(l ^ l >>> 32);
      i1 = this.hzl;
      localObject = this.hzm;
      if (localObject == null) {
        break label245;
      }
      j = localObject.hashCode();
      l = this.appId;
      i2 = (int)(l ^ l >>> 32);
      l = this.hzn;
      i3 = (int)(l ^ l >>> 32);
      i4 = this.hzo;
      localObject = this.hzp;
      if (localObject == null) {
        break label250;
      }
    }
    label245:
    label250:
    for (int k = localObject.hashCode();; k = 0)
    {
      int i5 = this.hzq;
      int i6 = this.hzr;
      localObject = this.hzs;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      l = this.startTime;
      int i7 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(196461);
      return ((((k + ((((j + ((i * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + m) * 31 + i7;
      i = 0;
      break;
      j = 0;
      break label65;
    }
  }
  
  public final String qr(int paramInt)
  {
    AppMethodBeat.i(196455);
    Log.i("LiveRoomInfo", "getCdnUrl cdnQualitySvrcfg".concat(String.valueOf(paramInt)));
    String str2 = (String)this.hzs.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = (String)this.hzs.get(Integer.valueOf(0));
    }
    AppMethodBeat.o(196455);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196460);
    String str = "LiveRoomInfo(liveName=" + this.hwb + ", liveId=" + this.liveId + ", audienceMode=" + this.hzl + ", anchorUserId=" + this.hzm + ", appId=" + this.appId + ", bizId=" + this.hzn + ", liveScene=" + this.hzo + ", cdnSwitchMode=" + this.hzp + ", cdnQualitySvrcfg=" + this.hzq + ", cdnH265BackCfg=" + this.hzr + ", cdnUrlMap=" + this.hzs + ", startTime=" + this.startTime + ")";
    AppMethodBeat.o(196460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.e
 * JD-Core Version:    0.7.0.1
 */