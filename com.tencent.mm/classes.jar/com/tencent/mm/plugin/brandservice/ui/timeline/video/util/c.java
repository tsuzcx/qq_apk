package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "", "id", "", "startTime", "", "endTime", "minShowTime", "url", "", "(IDDDLjava/lang/String;)V", "canCreateTime", "getCanCreateTime", "()D", "setCanCreateTime", "(D)V", "end", "", "getEnd", "()Z", "setEnd", "(Z)V", "getEndTime", "hasShow", "getHasShow", "setHasShow", "getId", "()I", "isBeforeCurrentTime", "setBeforeCurrentTime", "isShowControlBar", "setShowControlBar", "getMinShowTime", "needAdjustHeight", "getNeedAdjustHeight", "setNeedAdjustHeight", "needDestroyNotInDotArea", "getNeedDestroyNotInDotArea", "setNeedDestroyNotInDotArea", "posInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "getPosInfo", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "setPosInfo", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;)V", "getStartTime", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "plugin-brandservice_release"})
public final class c
{
  public boolean dvh;
  public final int id;
  double pKm;
  public boolean pKn;
  public boolean pKo;
  public boolean pKp;
  public boolean pKq;
  public boolean pKr;
  public d pKs;
  public final double pKt;
  public final double pKu;
  private final double pKv;
  public final String url;
  
  public c(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString)
  {
    AppMethodBeat.i(7284);
    this.id = paramInt;
    this.pKt = paramDouble1;
    this.pKu = paramDouble2;
    this.pKv = paramDouble3;
    this.url = paramString;
    this.pKm = (this.pKu - this.pKv);
    this.pKs = new d();
    AppMethodBeat.o(7284);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(7287);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.id != paramObject.id) || (Double.compare(this.pKt, paramObject.pKt) != 0) || (Double.compare(this.pKu, paramObject.pKu) != 0) || (Double.compare(this.pKv, paramObject.pKv) != 0) || (!p.j(this.url, paramObject.url))) {}
      }
    }
    else
    {
      AppMethodBeat.o(7287);
      return true;
    }
    AppMethodBeat.o(7287);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(7286);
    int j = this.id;
    long l = Double.doubleToLongBits(this.pKt);
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.pKu);
    int m = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.pKv);
    int n = (int)(l ^ l >>> 32);
    String str = this.url;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(7286);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(7285);
    String str = "BizVideoDotInfo(id=" + this.id + ", startTime=" + this.pKt + ", endTime=" + this.pKu + ", minShowTime=" + this.pKv + ", url=" + this.url + ")";
    AppMethodBeat.o(7285);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c
 * JD-Core Version:    0.7.0.1
 */