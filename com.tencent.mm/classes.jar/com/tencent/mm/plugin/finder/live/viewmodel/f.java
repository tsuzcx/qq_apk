package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "objectId", "", "tabType", "", "nonceId", "", "scene", "long", "", "lat", "commentScene", "pullMoreType", "(Lcom/tencent/mm/protobuf/ByteString;JILjava/lang/String;IFFII)V", "getCommentScene", "()I", "setCommentScene", "(I)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLat", "()F", "setLat", "(F)V", "getLong", "setLong", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "getObjectId", "()J", "setObjectId", "(J)V", "getPullMoreType", "setPullMoreType", "getScene", "setScene", "getTabType", "setTabType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class f
{
  public int dLS;
  public long hFK;
  public String hwg;
  public float iUY;
  public int scene;
  public int tCE;
  public b tsO;
  public float uDl;
  public int uiy;
  
  private f(String paramString)
  {
    AppMethodBeat.i(247943);
    this.tsO = null;
    this.hFK = 0L;
    this.dLS = 3;
    this.hwg = paramString;
    this.scene = 0;
    this.uDl = 0.0F;
    this.iUY = 0.0F;
    this.tCE = 0;
    this.uiy = -1;
    AppMethodBeat.o(247943);
  }
  
  public final void atS(String paramString)
  {
    AppMethodBeat.i(247942);
    p.h(paramString, "<set-?>");
    this.hwg = paramString;
    AppMethodBeat.o(247942);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247947);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!p.j(this.tsO, paramObject.tsO)) || (this.hFK != paramObject.hFK) || (this.dLS != paramObject.dLS) || (!p.j(this.hwg, paramObject.hwg)) || (this.scene != paramObject.scene) || (Float.compare(this.uDl, paramObject.uDl) != 0) || (Float.compare(this.iUY, paramObject.iUY) != 0) || (this.tCE != paramObject.tCE) || (this.uiy != paramObject.uiy)) {}
      }
    }
    else
    {
      AppMethodBeat.o(247947);
      return true;
    }
    AppMethodBeat.o(247947);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(247946);
    Object localObject = this.tsO;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      long l = this.hFK;
      int k = (int)(l ^ l >>> 32);
      int m = this.dLS;
      localObject = this.hwg;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      int n = this.scene;
      int i1 = Float.floatToIntBits(this.uDl);
      int i2 = Float.floatToIntBits(this.iUY);
      int i3 = this.tCE;
      int i4 = this.uiy;
      AppMethodBeat.o(247946);
      return (((((((i * 31 + k) * 31 + m) * 31 + j) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247945);
    String str = "FinderLiveRelatedLoaderParam(lastBuf=" + this.tsO + ", objectId=" + this.hFK + ", tabType=" + this.dLS + ", nonceId=" + this.hwg + ", scene=" + this.scene + ", long=" + this.uDl + ", lat=" + this.iUY + ", commentScene=" + this.tCE + ", pullMoreType=" + this.uiy + ")";
    AppMethodBeat.o(247945);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.f
 * JD-Core Version:    0.7.0.1
 */