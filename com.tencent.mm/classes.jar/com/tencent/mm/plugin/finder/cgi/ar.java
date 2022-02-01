package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.o;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "feedId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ar
  extends ap
{
  private final int IoU;
  private final String TAG;
  private g callback;
  private String category;
  private final long feedId;
  public int pullType;
  private com.tencent.mm.al.b rr;
  private int scene;
  
  public ar(long paramLong, int paramInt1, com.tencent.mm.bx.b paramb, String paramString, int paramInt2, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197293);
    this.feedId = paramLong;
    this.IoU = paramInt1;
    this.category = paramString;
    this.scene = paramInt2;
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    paramString = new b.a();
    paramString.nB(getType());
    Object localObject1 = new dyz();
    ((dyz)localObject1).objectId = this.feedId;
    ((dyz)localObject1).IoU = this.IoU;
    Object localObject2 = com.tencent.mm.ui.component.a.LCX;
    com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject2 = FinderGlobalLocationVM.fXf();
    ((dyz)localObject1).dqQ = ((Number)((o)localObject2).first).floatValue();
    ((dyz)localObject1).dpb = ((Number)((o)localObject2).second).floatValue();
    ((dyz)localObject1).lastBuffer = paramb;
    localObject2 = am.KJy;
    ((dyz)localObject1).DlF = am.a(paramdzp);
    localObject2 = new dye();
    ((dye)localObject2).rCn = this.category;
    ((dyz)localObject1).Lxy = ((dye)localObject2);
    ((dyz)localObject1).scene = this.scene;
    paramString.c((com.tencent.mm.bx.a)localObject1);
    paramString.d((com.tencent.mm.bx.a)new dza());
    paramString.wg("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.TAG;
    localObject1 = new StringBuilder("NetSceneFinderGetFeedRelList feedId ").append(this.feedId).append(" tabType ").append(this.IoU).append(" commentScene ");
    if (paramdzp != null) {}
    for (paramInt1 = paramdzp.qqE;; paramInt1 = 0)
    {
      ad.i(paramString, paramInt1 + " category " + this.category + " lastBuffer " + paramb);
      AppMethodBeat.o(197293);
      return;
    }
  }
  
  public final com.tencent.mm.bx.b ckJ()
  {
    AppMethodBeat.i(197290);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(197290);
      throw ((Throwable)localObject);
    }
    localObject = ((dza)localObject).lastBuffer;
    AppMethodBeat.o(197290);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197288);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197288);
    return i;
  }
  
  public final LinkedList<FinderObject> fRV()
  {
    AppMethodBeat.i(197291);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(197291);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((dza)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(197291);
    return localObject;
  }
  
  public final boolean fRW()
  {
    AppMethodBeat.i(197292);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(197292);
      throw ((Throwable)localObject);
    }
    if (((dza)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(197292);
      return true;
    }
    AppMethodBeat.o(197292);
    return false;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197289);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.feedId).append(" tabType=").append(this.IoU).append(", ");
      i locali = i.qoK;
      ad.i(paramq, i.du((List)fRV()));
      paramq = ((Iterable)fRV()).iterator();
    }
    while (paramq.hasNext())
    {
      k((FinderObject)paramq.next());
      continue;
      paramq = com.tencent.mm.plugin.finder.spam.a.qIC;
      com.tencent.mm.plugin.finder.spam.a.w(paramInt2, paramInt3, paramString);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ar
 * JD-Core Version:    0.7.0.1
 */