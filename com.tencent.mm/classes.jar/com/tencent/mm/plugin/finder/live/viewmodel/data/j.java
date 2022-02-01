package com.tencent.mm.plugin.finder.live.viewmodel.data;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.bmx;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "objectId", "", "sessionBuffer", "", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "targetFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "tabType", "", "nonceId", "scene", "long", "", "lat", "commentScene", "pullMoreType", "contextId", "byPassInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "enterScene", "readList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedListReadStat;", "curIndex", "squareEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "(Lcom/tencent/mm/protobuf/ByteString;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;Lcom/tencent/mm/protocal/protobuf/FinderObject;ILjava/lang/String;IFFIILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;ILjava/util/LinkedList;ILcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;)V", "getByPassInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "setByPassInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;)V", "getCommentScene", "()I", "setCommentScene", "(I)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getCurIndex", "setCurIndex", "getEnterScene", "setEnterScene", "getLastBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLat", "()F", "setLat", "(F)V", "getLbsTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "setLbsTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;)V", "getLong", "setLong", "getNonceId", "setNonceId", "getObjectId", "()J", "setObjectId", "(J)V", "getPullMoreType", "setPullMoreType", "getReadList", "()Ljava/util/LinkedList;", "setReadList", "(Ljava/util/LinkedList;)V", "getScene", "setScene", "getSessionBuffer", "setSessionBuffer", "getSquareEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "setSquareEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;)V", "getTabType", "setTabType", "getTargetFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTargetFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public bcl ACt;
  public avb ACu;
  public bmx ACw;
  public int AJo;
  public b AyB;
  public int CFf;
  public FinderObject CFj;
  public float EbM;
  public LinkedList<bly> EbN;
  public int enterScene;
  public int hJx;
  public long hKN;
  public String nonceId;
  public float oDT;
  int scene;
  public String sessionBuffer;
  public String zIO;
  public int zVI;
  
  private j(String paramString1, String paramString2, LinkedList<bly> paramLinkedList)
  {
    AppMethodBeat.i(356850);
    this.AyB = null;
    this.hKN = 0L;
    this.sessionBuffer = paramString1;
    this.ACt = null;
    this.CFj = null;
    this.hJx = 3;
    this.nonceId = paramString2;
    this.scene = 0;
    this.EbM = 0.0F;
    this.oDT = 0.0F;
    this.AJo = 0;
    this.CFf = -1;
    this.zIO = null;
    this.ACu = null;
    this.enterScene = 0;
    this.EbN = paramLinkedList;
    this.zVI = 0;
    this.ACw = null;
    AppMethodBeat.o(356850);
  }
  
  public final void aC(LinkedList<bly> paramLinkedList)
  {
    AppMethodBeat.i(356872);
    s.u(paramLinkedList, "<set-?>");
    this.EbN = paramLinkedList;
    AppMethodBeat.o(356872);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356891);
    if (this == paramObject)
    {
      AppMethodBeat.o(356891);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    paramObject = (j)paramObject;
    if (!s.p(this.AyB, paramObject.AyB))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.hKN != paramObject.hKN)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.sessionBuffer, paramObject.sessionBuffer))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.ACt, paramObject.ACt))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.CFj, paramObject.CFj))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.hJx != paramObject.hJx)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.nonceId, paramObject.nonceId))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.scene != paramObject.scene)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(Float.valueOf(this.EbM), Float.valueOf(paramObject.EbM)))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(Float.valueOf(this.oDT), Float.valueOf(paramObject.oDT)))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.AJo != paramObject.AJo)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.CFf != paramObject.CFf)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.zIO, paramObject.zIO))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.ACu, paramObject.ACu))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.enterScene != paramObject.enterScene)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.EbN, paramObject.EbN))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (this.zVI != paramObject.zVI)
    {
      AppMethodBeat.o(356891);
      return false;
    }
    if (!s.p(this.ACw, paramObject.ACw))
    {
      AppMethodBeat.o(356891);
      return false;
    }
    AppMethodBeat.o(356891);
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(356885);
    int i;
    int i3;
    int j;
    label35:
    int k;
    label44:
    int m;
    label54:
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int n;
    label115:
    int i1;
    label125:
    int i11;
    int i12;
    int i13;
    if (this.AyB == null)
    {
      i = 0;
      i3 = q.a..ExternalSyntheticBackport0.m(this.hKN);
      if (this.sessionBuffer != null) {
        break label271;
      }
      j = 0;
      if (this.ACt != null) {
        break label282;
      }
      k = 0;
      if (this.CFj != null) {
        break label293;
      }
      m = 0;
      i4 = this.hJx;
      i5 = this.nonceId.hashCode();
      i6 = this.scene;
      i7 = Float.floatToIntBits(this.EbM);
      i8 = Float.floatToIntBits(this.oDT);
      i9 = this.AJo;
      i10 = this.CFf;
      if (this.zIO != null) {
        break label305;
      }
      n = 0;
      if (this.ACu != null) {
        break label317;
      }
      i1 = 0;
      i11 = this.enterScene;
      i12 = this.EbN.hashCode();
      i13 = this.zVI;
      if (this.ACw != null) {
        break label329;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(356885);
      return ((((i1 + (n + ((((((((m + (k + (j + (i * 31 + i3) * 31) * 31) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31) * 31) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i2;
      i = this.AyB.hashCode();
      break;
      label271:
      j = this.sessionBuffer.hashCode();
      break label35;
      label282:
      k = this.ACt.hashCode();
      break label44;
      label293:
      m = this.CFj.hashCode();
      break label54;
      label305:
      n = this.zIO.hashCode();
      break label115;
      label317:
      i1 = this.ACu.hashCode();
      break label125;
      label329:
      i2 = this.ACw.hashCode();
    }
  }
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(356867);
    s.u(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(356867);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356881);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FinderLiveRelatedLoaderParam(lastBuf=").append(this.AyB).append(", objectId=").append(this.hKN).append(", sessionBuffer=").append(this.sessionBuffer).append(", lbsTabTipsInfo=").append(this.ACt).append(", targetFeedObject=").append(this.CFj).append(", tabType=").append(this.hJx).append(", nonceId=").append(this.nonceId).append(", scene=").append(this.scene).append(", long=").append(this.EbM).append(", lat=").append(this.oDT).append(", commentScene=").append(this.AJo).append(", pullMoreType=");
    ((StringBuilder)localObject).append(this.CFf).append(", contextId=").append(this.zIO).append(", byPassInfo=").append(this.ACu).append(", enterScene=").append(this.enterScene).append(", readList=").append(this.EbN).append(", curIndex=").append(this.zVI).append(", squareEntranceInfo=").append(this.ACw).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(356881);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.j
 * JD-Core Version:    0.7.0.1
 */