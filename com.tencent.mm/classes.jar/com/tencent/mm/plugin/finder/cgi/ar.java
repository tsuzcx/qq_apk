package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topic", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTopicRecommends", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ar
  extends ac
{
  private final String TAG;
  private f callback;
  public int pullType;
  public String rJz;
  public com.tencent.mm.al.b rr;
  
  public ar(String paramString, float paramFloat1, float paramFloat2, Long paramLong, com.tencent.mm.bx.b paramb, int paramInt, cta paramcta, arg paramarg, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201154);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.oP(getType());
    aon localaon = new aon();
    localaon.sMj = 2;
    localaon.dzZ = paramString;
    localaon.dAp = paramFloat1;
    localaon.dyz = paramFloat2;
    localaon.GmG = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localaon.Gng = paramLong.longValue();
    }
    localaon.rJv = paramarg;
    localaon.ePx = 1;
    if (paramarg != null) {
      localaon.ePx = 2;
    }
    localaon.duh = paramInt;
    if (paramcta != null)
    {
      paramb = new dog();
      paramarg = new LinkedList();
      Object localObject = paramcta.Hlo;
      p.g(localObject, "topicRecommend.topic_list");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramarg.add(Long.valueOf(((asg)((Iterator)localObject).next()).Gqv));
      }
      paramb.HCR = paramarg;
      localaon.Gnh = paramb;
      this.rJz = ((asg)paramcta.Hlo.get(0)).dzZ;
    }
    paramb = v.rIR;
    localaon.Gnf = v.a(paramaqy);
    locala.c((a)localaon);
    locala.oP(getType());
    locala.d((a)new aoo());
    locala.Dl("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aDC();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString + ' ' + paramLong);
    AppMethodBeat.o(201154);
  }
  
  public ar(String paramString, Long paramLong, com.tencent.mm.bx.b paramb, arg paramarg, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201153);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.oP(getType());
    aon localaon = new aon();
    localaon.sMj = 1;
    localaon.dzZ = paramString;
    localaon.GmG = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localaon.Gng = paramLong.longValue();
    }
    localaon.rJv = paramarg;
    paramb = v.rIR;
    localaon.Gnf = v.a(paramaqy);
    locala.c((a)localaon);
    locala.oP(getType());
    locala.d((a)new aoo());
    locala.Dl("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aDC();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
    AppMethodBeat.o(201153);
  }
  
  public final com.tencent.mm.bx.b cyp()
  {
    AppMethodBeat.i(165237);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((aoo)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int cyq()
  {
    AppMethodBeat.i(165238);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((aoo)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final LinkedList<FinderObject> cyv()
  {
    AppMethodBeat.i(201152);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(201152);
      throw ((Throwable)localObject);
    }
    localObject = ((aoo)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …picListResponse).`object`");
    AppMethodBeat.o(201152);
    return localObject;
  }
  
  public final long cyw()
  {
    AppMethodBeat.i(165236);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((aoo)localObject).rTp;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165233);
    Object localObject = h.soM;
    localObject = this.rIl;
    if (localObject != null) {}
    for (int i = ((aqy)localObject).rTD;; i = 0)
    {
      h.EY(i);
      this.callback = paramf;
      i = dispatch(parame, (q)this.rr, (k)this);
      AppMethodBeat.o(165233);
      return i;
    }
  }
  
  public final int getType()
  {
    return 817;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165234);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.rJz).append(' ');
      localObject = u.rIQ;
      ad.i(paramq, u.dy((List)cyv()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.rIl;
    if (paramString != null)
    {
      paramq = ((Iterable)cyv()).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        localObject = h.soM;
        h.d(paramArrayOfByte.id, paramString.rTD, paramArrayOfByte.sessionBuffer);
      }
      AppMethodBeat.o(165234);
      return;
    }
    AppMethodBeat.o(165234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ar
 * JD-Core Version:    0.7.0.1
 */