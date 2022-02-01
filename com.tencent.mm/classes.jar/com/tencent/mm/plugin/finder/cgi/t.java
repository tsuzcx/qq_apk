package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topic", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "poiClassifyId", "longitude", "", "latitude", "tabType", "", "topicRecommend", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Ljava/lang/String;FFLjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getSubTitle", "Lcom/tencent/mm/protocal/protobuf/PoiTopicSubTitle;", "getTopicRecommends", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class t
  extends ap
{
  public String KJN;
  private final String TAG;
  private g callback;
  public int pullType;
  public com.tencent.mm.al.b rr;
  
  public t(String paramString, float paramFloat1, float paramFloat2, Long paramLong, com.tencent.mm.bx.b paramb, int paramInt, ebq paramebq, dzq paramdzq, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197328);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.nB(getType());
    ajh localajh = new ajh();
    localajh.qSS = 2;
    localajh.dqA = paramString;
    localajh.dqQ = paramFloat1;
    localajh.dpb = paramFloat2;
    localajh.Dlt = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localajh.Lxz = paramLong.longValue();
    }
    localajh.KJJ = paramdzq;
    localajh.evC = 1;
    if (paramdzq != null) {
      localajh.evC = 2;
    }
    localajh.IoU = paramInt;
    if (paramebq != null)
    {
      paramb = new ebv();
      paramdzq = new LinkedList();
      Object localObject = paramebq.LAk;
      d.g.b.k.g(localObject, "topicRecommend.topic_list");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramdzq.add(Long.valueOf(((dzw)((Iterator)localObject).next()).LyD));
      }
      paramb.LAl = paramdzq;
      localajh.LxA = paramb;
      this.KJN = ((dzw)paramebq.LAk.get(0)).dqA;
    }
    paramb = am.KJy;
    localajh.Dlx = am.a(paramdzp);
    locala.c((a)localajh);
    locala.nB(getType());
    locala.d((a)new aji());
    locala.wg("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetTopicFeed get poi init: " + paramString + ' ' + paramLong);
    AppMethodBeat.o(197328);
  }
  
  public t(String paramString, Long paramLong, com.tencent.mm.bx.b paramb, dzq paramdzq, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197327);
    this.TAG = "Finder.NetSceneFinderGetTopicFeed";
    b.a locala = new b.a();
    locala.nB(getType());
    ajh localajh = new ajh();
    localajh.qSS = 1;
    localajh.dqA = paramString;
    localajh.Dlt = paramb;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      localajh.Lxz = paramLong.longValue();
    }
    localajh.KJJ = paramdzq;
    paramb = am.KJy;
    localajh.Dlx = am.a(paramdzp);
    locala.c((a)localajh);
    locala.nB(getType());
    locala.d((a)new aji());
    locala.wg("/cgi-bin/micromsg-bin/findergettopiclist");
    paramb = locala.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetTopicFeed get word init: " + paramString + ", " + paramLong);
    AppMethodBeat.o(197327);
  }
  
  public final long ckM()
  {
    AppMethodBeat.i(165236);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165236);
      throw ((Throwable)localObject);
    }
    long l = ((aji)localObject).qxB;
    AppMethodBeat.o(165236);
    return l;
  }
  
  public final com.tencent.mm.bx.b ckN()
  {
    AppMethodBeat.i(165237);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165237);
      throw ((Throwable)localObject);
    }
    localObject = ((aji)localObject).lastBuffer;
    AppMethodBeat.o(165237);
    return localObject;
  }
  
  public final int ckO()
  {
    AppMethodBeat.i(165238);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(165238);
      throw ((Throwable)localObject);
    }
    int i = ((aji)localObject).continueFlag;
    AppMethodBeat.o(165238);
    return i;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165233);
    Object localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    localObject = this.contextObj;
    if (localObject != null) {}
    for (int i = ((dzp)localObject).qqE;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.b.ahp(i);
      this.callback = paramg;
      i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
      AppMethodBeat.o(165233);
      return i;
    }
  }
  
  public final LinkedList<FinderObject> fSe()
  {
    AppMethodBeat.i(197326);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTopicListResponse");
      AppMethodBeat.o(197326);
      throw ((Throwable)localObject);
    }
    localObject = ((aji)localObject).object;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …picListResponse).`object`");
    AppMethodBeat.o(197326);
    return localObject;
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
      paramArrayOfByte = new StringBuilder("pullType ").append(this.pullType).append(" selectedTag").append(this.KJN).append(' ');
      localObject = i.qoK;
      ad.i(paramq, i.du((List)fSe()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.contextObj;
    if (paramString != null)
    {
      paramq = ((Iterable)fSe()).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.j(paramArrayOfByte.id, paramString.qqE, paramArrayOfByte.sessionBuffer);
      }
      AppMethodBeat.o(165234);
      return;
    }
    AppMethodBeat.o(165234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */