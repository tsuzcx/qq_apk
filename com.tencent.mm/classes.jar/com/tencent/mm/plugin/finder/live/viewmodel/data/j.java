package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "objectId", "", "sessionBuffer", "", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "targetFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "tabType", "", "nonceId", "scene", "long", "", "lat", "commentScene", "pullMoreType", "contextId", "(Lcom/tencent/mm/protobuf/ByteString;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;Lcom/tencent/mm/protocal/protobuf/FinderObject;ILjava/lang/String;IFFIILjava/lang/String;)V", "getCommentScene", "()I", "setCommentScene", "(I)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLat", "()F", "setLat", "(F)V", "getLbsTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "setLbsTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;)V", "getLong", "setLong", "getNonceId", "setNonceId", "getObjectId", "()J", "setObjectId", "(J)V", "getPullMoreType", "setPullMoreType", "getScene", "setScene", "getSessionBuffer", "setSessionBuffer", "getTabType", "setTabType", "getTargetFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTargetFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"})
public final class j
{
  public int fEH;
  public float lLr;
  public String nonceId;
  int scene;
  public String sessionBuffer;
  public String wmL;
  public b xaw;
  public long xbk;
  public awq xdb;
  public int xkX;
  public int yeH;
  public FinderObject yeL;
  public float zeN;
  
  private j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263640);
    this.xaw = null;
    this.xbk = 0L;
    this.sessionBuffer = paramString1;
    this.xdb = null;
    this.yeL = null;
    this.fEH = 3;
    this.nonceId = paramString2;
    this.scene = 0;
    this.zeN = 0.0F;
    this.lLr = 0.0F;
    this.xkX = 0;
    this.yeH = -1;
    this.wmL = null;
    AppMethodBeat.o(263640);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(263644);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((!p.h(this.xaw, paramObject.xaw)) || (this.xbk != paramObject.xbk) || (!p.h(this.sessionBuffer, paramObject.sessionBuffer)) || (!p.h(this.xdb, paramObject.xdb)) || (!p.h(this.yeL, paramObject.yeL)) || (this.fEH != paramObject.fEH) || (!p.h(this.nonceId, paramObject.nonceId)) || (this.scene != paramObject.scene) || (Float.compare(this.zeN, paramObject.zeN) != 0) || (Float.compare(this.lLr, paramObject.lLr) != 0) || (this.xkX != paramObject.xkX) || (this.yeH != paramObject.yeH) || (!p.h(this.wmL, paramObject.wmL))) {}
      }
    }
    else
    {
      AppMethodBeat.o(263644);
      return true;
    }
    AppMethodBeat.o(263644);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(263643);
    Object localObject = this.xaw;
    int i;
    int i2;
    int j;
    label59:
    int k;
    label76:
    int m;
    label94:
    int i3;
    if (localObject != null)
    {
      i = localObject.hashCode();
      long l = this.xbk;
      i2 = (int)(l ^ l >>> 32);
      localObject = this.sessionBuffer;
      if (localObject == null) {
        break label254;
      }
      j = localObject.hashCode();
      localObject = this.xdb;
      if (localObject == null) {
        break label259;
      }
      k = localObject.hashCode();
      localObject = this.yeL;
      if (localObject == null) {
        break label264;
      }
      m = localObject.hashCode();
      i3 = this.fEH;
      localObject = this.nonceId;
      if (localObject == null) {
        break label270;
      }
    }
    label259:
    label264:
    label270:
    for (int n = localObject.hashCode();; n = 0)
    {
      int i4 = this.scene;
      int i5 = Float.floatToIntBits(this.zeN);
      int i6 = Float.floatToIntBits(this.lLr);
      int i7 = this.xkX;
      int i8 = this.yeH;
      localObject = this.wmL;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      AppMethodBeat.o(263643);
      return ((((((n + ((m + (k + (j + (i * 31 + i2) * 31) * 31) * 31) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i1;
      i = 0;
      break;
      label254:
      j = 0;
      break label59;
      k = 0;
      break label76;
      m = 0;
      break label94;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263642);
    String str = "FinderLiveRelatedLoaderParam(lastBuf=" + this.xaw + ", objectId=" + this.xbk + ", sessionBuffer=" + this.sessionBuffer + ", lbsTabTipsInfo=" + this.xdb + ", targetFeedObject=" + this.yeL + ", tabType=" + this.fEH + ", nonceId=" + this.nonceId + ", scene=" + this.scene + ", long=" + this.zeN + ", lat=" + this.lLr + ", commentScene=" + this.xkX + ", pullMoreType=" + this.yeH + ", contextId=" + this.wmL + ")";
    AppMethodBeat.o(263642);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.j
 * JD-Core Version:    0.7.0.1
 */