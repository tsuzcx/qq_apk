package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.o;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "feedId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "", "scene", "fromUserName", "toUserName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getTabType", "getToUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ab
  extends w
{
  private final String TAG;
  private g callback;
  private String category;
  private final String dfJ;
  private final long dig;
  private final int diw;
  private final String dtD;
  public int pullType;
  private com.tencent.mm.ak.b rr;
  private int scene;
  
  public ab(long paramLong, int paramInt1, com.tencent.mm.bw.b paramb, String paramString1, int paramInt2, String paramString2, String paramString3, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201170);
    this.dig = paramLong;
    this.diw = paramInt1;
    this.category = paramString1;
    this.scene = paramInt2;
    this.dtD = paramString2;
    this.dfJ = paramString3;
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    paramString1 = new b.a();
    paramString1.op(getType());
    paramString2 = new ale();
    paramString2.qXP = this.dig;
    paramString2.diw = this.diw;
    paramString3 = com.tencent.mm.ui.component.a.IrY;
    com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString3 = FinderGlobalLocationVM.cFH();
    paramString2.doB = ((Number)paramString3.first).floatValue();
    paramString2.dmL = ((Number)paramString3.second).floatValue();
    paramString2.lastBuffer = paramb;
    paramString3 = q.qXH;
    paramString2.EDu = q.a(paramanm);
    paramString3 = new aiv();
    paramString3.sLh = this.category;
    paramString2.EEV = paramString3;
    paramString2.zTO = this.dtD;
    paramString2.dvw = this.dfJ;
    ac.i(this.TAG, "fromUserName=" + this.dtD + ",toUserName=" + this.dfJ);
    paramString2.scene = this.scene;
    paramString1.c((com.tencent.mm.bw.a)paramString2);
    paramString1.d((com.tencent.mm.bw.a)new alf());
    paramString1.Am("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString1 = paramString1.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.TAG;
    paramString2 = new StringBuilder("NetSceneFinderGetFeedRelList feedId ").append(this.dig).append(" tabType ").append(this.diw).append(" commentScene ");
    if (paramanm != null) {}
    for (paramInt1 = paramanm.rfR;; paramInt1 = 0)
    {
      ac.i(paramString1, paramInt1 + " category " + this.category + " lastBuffer " + paramb);
      AppMethodBeat.o(201170);
      return;
    }
  }
  
  public final com.tencent.mm.bw.b csq()
  {
    AppMethodBeat.i(201167);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201167);
      throw ((Throwable)localObject);
    }
    localObject = ((alf)localObject).lastBuffer;
    AppMethodBeat.o(201167);
    return localObject;
  }
  
  public final LinkedList<FinderObject> csr()
  {
    AppMethodBeat.i(201168);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201168);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((alf)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201168);
    return localObject;
  }
  
  public final boolean css()
  {
    AppMethodBeat.i(201169);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201169);
      throw ((Throwable)localObject);
    }
    if (((alf)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201169);
      return true;
    }
    AppMethodBeat.o(201169);
    return false;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201165);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201165);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201166);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.dig).append(" tabType=").append(this.diw).append(", ");
      p localp = p.qXG;
      ac.i(paramq, p.dw((List)csr()));
      paramq = ((Iterable)csr()).iterator();
    }
    while (paramq.hasNext())
    {
      d((FinderObject)paramq.next());
      continue;
      paramq = com.tencent.mm.plugin.finder.spam.a.rBD;
      com.tencent.mm.plugin.finder.spam.a.w(paramInt2, paramInt3, paramString);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */