package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topic", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTopicRecommends", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class as
  extends ad
{
  private final String TAG;
  private f callback;
  public int pullType;
  public String rRN;
  public com.tencent.mm.ak.b rr;
  
  public as(String paramString, float paramFloat1, float paramFloat2, Long paramLong, com.tencent.mm.bw.b paramb, int paramInt, ctu paramctu, arv paramarv, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201576);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.oS(getType());
    apa localapa = new apa();
    localapa.sXu = 2;
    localapa.dBe = paramString;
    localapa.dBu = paramFloat1;
    localapa.dzE = paramFloat2;
    localapa.GFN = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localapa.GGm = paramLong.longValue();
    }
    localapa.rRJ = paramarv;
    localapa.eRi = 1;
    if (paramarv != null) {
      localapa.eRi = 2;
    }
    localapa.dvm = paramInt;
    if (paramctu != null)
    {
      paramb = new dpd();
      paramarv = new LinkedList();
      Object localObject = paramctu.HEO;
      p.g(localObject, "topicRecommend.topic_list");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramarv.add(Long.valueOf(((asv)((Iterator)localObject).next()).GJQ));
      }
      paramb.HWE = paramarv;
      localapa.GGn = paramb;
      this.rRN = ((asv)paramctu.HEO.get(0)).dBe;
    }
    paramb = v.rRb;
    localapa.GGl = v.a(paramarn);
    locala.c((com.tencent.mm.bw.a)localapa);
    locala.oS(getType());
    locala.d((com.tencent.mm.bw.a)new apb());
    locala.DN("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aDS();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString + ' ' + paramLong);
    AppMethodBeat.o(201576);
  }
  
  public as(String paramString, Long paramLong, com.tencent.mm.bw.b paramb, arv paramarv, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201575);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.oS(getType());
    apa localapa = new apa();
    localapa.sXu = 1;
    localapa.dBe = paramString;
    localapa.GFN = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localapa.GGm = paramLong.longValue();
    }
    localapa.rRJ = paramarv;
    paramb = v.rRb;
    localapa.GGl = v.a(paramarn);
    locala.c((com.tencent.mm.bw.a)localapa);
    locala.oS(getType());
    locala.d((com.tencent.mm.bw.a)new apb());
    locala.DN("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aDS();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
    AppMethodBeat.o(201575);
  }
  
  public final com.tencent.mm.bw.b czQ()
  {
    AppMethodBeat.i(165237);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((apb)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int czR()
  {
    AppMethodBeat.i(165238);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((apb)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final LinkedList<FinderObject> czW()
  {
    AppMethodBeat.i(201574);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(201574);
      throw ((Throwable)localObject);
    }
    localObject = ((apb)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …picListResponse).`object`");
    AppMethodBeat.o(201574);
    return localObject;
  }
  
  public final long czX()
  {
    AppMethodBeat.i(165236);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((apb)localObject).sbT;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165233);
    Object localObject = i.syT;
    localObject = this.rQw;
    if (localObject != null) {}
    for (int i = ((arn)localObject).sch;; i = 0)
    {
      i.Fu(i);
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
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.rRN).append(' ');
      localObject = u.rRa;
      ae.i(paramq, u.dB((List)czW()));
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
        AppMethodBeat.o(165234);
        throw paramString;
      }
      paramq = (apb)paramq;
      paramArrayOfByte = com.tencent.mm.plugin.finder.preload.a.stE;
      paramArrayOfByte = paramq.preloadInfo;
      paramq = paramq.object;
      p.g(paramq, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a(paramArrayOfByte, (List)paramq, 817);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.rQw;
    if (paramString != null)
    {
      paramq = ((Iterable)czW()).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        localObject = i.syT;
        i.d(paramArrayOfByte.id, paramString.sch, paramArrayOfByte.sessionBuffer);
      }
      AppMethodBeat.o(165234);
      return;
    }
    AppMethodBeat.o(165234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */