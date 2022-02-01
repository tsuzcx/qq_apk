package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topic", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTopicRecommends", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ak
  extends w
{
  private final String TAG;
  private g callback;
  public int pullType;
  public String qYn;
  public com.tencent.mm.ak.b rr;
  
  public ak(String paramString, float paramFloat1, float paramFloat2, Long paramLong, com.tencent.mm.bw.b paramb, int paramInt, cnx paramcnx, anu paramanu, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201206);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.op(getType());
    ali localali = new ali();
    localali.rPI = 2;
    localali.dol = paramString;
    localali.doB = paramFloat1;
    localali.dmL = paramFloat2;
    localali.EEJ = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localali.EFa = paramLong.longValue();
    }
    localali.qYj = paramanu;
    localali.exY = 1;
    if (paramanu != null) {
      localali.exY = 2;
    }
    localali.diw = paramInt;
    if (paramcnx != null)
    {
      paramb = new dir();
      paramanu = new LinkedList();
      Object localObject = paramcnx.FBb;
      d.g.b.k.g(localObject, "topicRecommend.topic_list");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramanu.add(Long.valueOf(((aop)((Iterator)localObject).next()).EHG));
      }
      paramb.FSl = paramanu;
      localali.EFb = paramb;
      this.qYn = ((aop)paramcnx.FBb.get(0)).dol;
    }
    paramb = q.qXH;
    localali.EEZ = q.a(paramanm);
    locala.c((a)localali);
    locala.op(getType());
    locala.d((a)new alj());
    locala.Am("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString + ' ' + paramLong);
    AppMethodBeat.o(201206);
  }
  
  public ak(String paramString, Long paramLong, com.tencent.mm.bw.b paramb, anu paramanu, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201205);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.op(getType());
    ali localali = new ali();
    localali.rPI = 1;
    localali.dol = paramString;
    localali.EEJ = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localali.EFa = paramLong.longValue();
    }
    localali.qYj = paramanu;
    paramb = q.qXH;
    localali.EEZ = q.a(paramanm);
    locala.c((a)localali);
    locala.op(getType());
    locala.d((a)new alj());
    locala.Am("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
    AppMethodBeat.o(201205);
  }
  
  public final LinkedList<FinderObject> csE()
  {
    AppMethodBeat.i(201204);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(201204);
      throw ((Throwable)localObject);
    }
    localObject = ((alj)localObject).object;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …picListResponse).`object`");
    AppMethodBeat.o(201204);
    return localObject;
  }
  
  public final long csF()
  {
    AppMethodBeat.i(165236);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((alj)localObject).rfD;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final com.tencent.mm.bw.b csy()
  {
    AppMethodBeat.i(165237);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((alj)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int csz()
  {
    AppMethodBeat.i(165238);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((alj)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165233);
    Object localObject = d.rxr;
    localObject = this.contextObj;
    if (localObject != null) {}
    for (int i = ((anm)localObject).rfR;; i = 0)
    {
      d.DU(i);
      this.callback = paramg;
      i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
      AppMethodBeat.o(165233);
      return i;
    }
  }
  
  public final int getType()
  {
    return 817;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165234);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.qYn).append(' ');
      localObject = p.qXG;
      ac.i(paramq, p.dw((List)csE()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.contextObj;
    if (paramString != null)
    {
      paramq = ((Iterable)csE()).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        localObject = d.rxr;
        d.d(paramArrayOfByte.id, paramString.rfR, paramArrayOfByte.sessionBuffer);
      }
      AppMethodBeat.o(165234);
      return;
    }
    AppMethodBeat.o(165234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */