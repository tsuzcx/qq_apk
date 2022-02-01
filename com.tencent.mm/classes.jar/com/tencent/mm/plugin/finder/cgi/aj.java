package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "feedId", "", "nonceId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "scene", "fromUserName", "toUserName", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionId", "getTabType", "getToUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getResponseBuffer", "getType", "getWording", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aj
  extends ad
{
  private final String TAG;
  private com.tencent.mm.ak.f callback;
  private String category;
  private final String dGJ;
  private final String dsk;
  public final long duw;
  public final int dvm;
  public int pullType;
  private final String rPZ;
  public com.tencent.mm.ak.b rr;
  private int scene;
  private final String sessionId;
  
  public aj(long paramLong, String paramString1, int paramInt1, com.tencent.mm.bw.b paramb, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201540);
    this.duw = paramLong;
    this.rPZ = paramString1;
    this.dvm = paramInt1;
    this.category = paramString2;
    this.scene = paramInt2;
    this.dGJ = paramString3;
    this.dsk = paramString4;
    this.sessionId = paramString5;
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    paramString1 = new b.a();
    paramString1.oS(getType());
    paramString2 = new aow();
    paramString2.rRn = this.duw;
    paramString2.objectNonceId = this.rPZ;
    paramString2.dvm = this.dvm;
    paramString3 = com.tencent.mm.ui.component.a.KEX;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString3 = FinderGlobalLocationVM.cQL();
    paramString2.dBu = ((Number)paramString3.first).floatValue();
    paramString2.dzE = ((Number)paramString3.second).floatValue();
    paramString2.lastBuffer = paramb;
    paramString3 = v.rRb;
    paramString2.GEg = v.a(paramarn);
    paramString3 = new alx();
    paramString3.tSH = this.category;
    paramString2.GGh = paramString3;
    paramString2.cUA = this.dGJ;
    paramString2.cUB = this.dsk;
    ae.i(this.TAG, "fromUserName=" + this.dGJ + ",toUserName=" + this.dsk);
    paramString2.scene = this.scene;
    paramString2.GGj = this.sessionId;
    paramString1.c((com.tencent.mm.bw.a)paramString2);
    paramString1.d((com.tencent.mm.bw.a)new aox());
    paramString1.DN("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString1 = paramString1.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.TAG;
    paramString2 = new StringBuilder("NetSceneFinderGetFeedRelList feedId=").append(c.rp(this.duw)).append(" tabType=").append(this.dvm).append(" commentScene=");
    if (paramarn != null) {}
    for (paramInt1 = paramarn.sch;; paramInt1 = 0)
    {
      ae.i(paramString1, paramInt1 + " category=" + this.category + " nonceId=" + this.rPZ + " lastBuffer=" + paramb + " scene=" + this.scene + " sessionId=" + this.sessionId);
      AppMethodBeat.o(201540);
      return;
    }
  }
  
  public final com.tencent.mm.bw.b czI()
  {
    AppMethodBeat.i(201536);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201536);
      throw ((Throwable)localObject);
    }
    localObject = ((aox)localObject).lastBuffer;
    AppMethodBeat.o(201536);
    return localObject;
  }
  
  public final LinkedList<FinderObject> czJ()
  {
    AppMethodBeat.i(201538);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201538);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((aox)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201538);
    return localObject;
  }
  
  public final boolean czK()
  {
    AppMethodBeat.i(201539);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201539);
      throw ((Throwable)localObject);
    }
    if (((aox)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201539);
      return true;
    }
    AppMethodBeat.o(201539);
    return false;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(201534);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201534);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(201537);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201537);
      throw ((Throwable)localObject);
    }
    localObject = ((aox)localObject).GEf;
    AppMethodBeat.o(201537);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201535);
    Object localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.Fm(this.dvm);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.duw).append(" tabType=").append(this.dvm).append(", ");
      localObject = u.rRa;
      ae.i(paramq, u.dB((List)czJ()));
      paramq = this.rr.aEV();
      if ((paramq instanceof aox))
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.preload.a.stE;
        paramArrayOfByte = ((aox)paramq).preloadInfo;
        localObject = ((aox)paramq).object;
        p.g(localObject, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a(paramArrayOfByte, (List)localObject, 3688);
        if (((aj)this).rr.aEV() == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(201535);
          throw paramString;
        }
        paramArrayOfByte = com.tencent.mm.plugin.finder.report.f.syc;
        com.tencent.mm.plugin.finder.report.f.fJ(this.dvm, ((aox)paramq).object.size());
      }
      paramq = ((Iterable)czJ()).iterator();
    }
    while (paramq.hasNext())
    {
      d((FinderObject)paramq.next());
      continue;
      paramq = com.tencent.mm.plugin.finder.spam.a.sEK;
      com.tencent.mm.plugin.finder.spam.a.w(paramInt2, paramInt3, paramString);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */