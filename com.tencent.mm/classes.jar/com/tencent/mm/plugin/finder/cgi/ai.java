package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "feedId", "", "nonceId", "", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "category", "scene", "fromUserName", "toUserName", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "getFromUserName", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionId", "getTabType", "getToUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "getWording", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ai
  extends ac
{
  private final String TAG;
  private f callback;
  private String category;
  private final String dFE;
  private final String drf;
  public final long dtq;
  public final int duh;
  public int pullType;
  private final String rHO;
  private com.tencent.mm.al.b rr;
  private int scene;
  private final String sessionId;
  
  public ai(long paramLong, String paramString1, int paramInt1, com.tencent.mm.bx.b paramb, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(221446);
    this.dtq = paramLong;
    this.rHO = paramString1;
    this.duh = paramInt1;
    this.category = paramString2;
    this.scene = paramInt2;
    this.dFE = paramString3;
    this.drf = paramString4;
    this.sessionId = paramString5;
    this.TAG = "Finder.NetSceneFinderGetFeedRelList";
    paramString1 = new b.a();
    paramString1.oP(getType());
    paramString2 = new aoj();
    paramString2.rIZ = this.dtq;
    paramString2.objectNonceId = this.rHO;
    paramString2.duh = this.duh;
    paramString3 = com.tencent.mm.ui.component.a.KiD;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString3 = FinderGlobalLocationVM.cOb();
    paramString2.dAp = ((Number)paramString3.first).floatValue();
    paramString2.dyz = ((Number)paramString3.second).floatValue();
    paramString2.lastBuffer = paramb;
    paramString3 = v.rIR;
    paramString2.Gle = v.a(paramaqy);
    paramString3 = new all();
    paramString3.tHQ = this.category;
    paramString2.Gna = paramString3;
    paramString2.dHm = this.dFE;
    paramString2.dHz = this.drf;
    ad.i(this.TAG, "fromUserName=" + this.dFE + ",toUserName=" + this.drf);
    paramString2.scene = this.scene;
    paramString2.Oez = this.sessionId;
    paramString1.c((com.tencent.mm.bx.a)paramString2);
    paramString1.d((com.tencent.mm.bx.a)new aok());
    paramString1.Dl("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString1 = paramString1.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.TAG;
    paramString2 = new StringBuilder("NetSceneFinderGetFeedRelList feedId=").append(c.rc(this.dtq)).append(" tabType=").append(this.duh).append(" commentScene=");
    if (paramaqy != null) {}
    for (paramInt1 = paramaqy.rTD;; paramInt1 = 0)
    {
      ad.i(paramString1, paramInt1 + " category=" + this.category + " nonceId=" + this.rHO + " lastBuffer=" + paramb + " scene=" + this.scene + " sessionId=" + this.sessionId);
      AppMethodBeat.o(221446);
      return;
    }
  }
  
  public final com.tencent.mm.bx.b cyh()
  {
    AppMethodBeat.i(201114);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201114);
      throw ((Throwable)localObject);
    }
    localObject = ((aok)localObject).lastBuffer;
    AppMethodBeat.o(201114);
    return localObject;
  }
  
  public final LinkedList<FinderObject> cyi()
  {
    AppMethodBeat.i(201116);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201116);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((aok)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201116);
    return localObject;
  }
  
  public final boolean cyj()
  {
    AppMethodBeat.i(201117);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201117);
      throw ((Throwable)localObject);
    }
    if (((aok)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201117);
      return true;
    }
    AppMethodBeat.o(201117);
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201112);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201112);
    return i;
  }
  
  public final int getType()
  {
    return 3688;
  }
  
  public final String getWording()
  {
    AppMethodBeat.i(201115);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
      AppMethodBeat.o(201115);
      throw ((Throwable)localObject);
    }
    localObject = ((aok)localObject).Gnd;
    AppMethodBeat.o(201115);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201113);
    Object localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ER(this.duh);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("feedId ").append(this.dtq).append(" tabType=").append(this.duh).append(", ");
      localObject = u.rIQ;
      ad.i(paramq, u.dy((List)cyi()));
      paramq = this.rr.aEF();
      if ((paramq instanceof aok))
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.preload.a.skH;
        paramArrayOfByte = ((aok)paramq).saW;
        localObject = ((aok)paramq).object;
        p.g(localObject, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a(paramArrayOfByte, (List)localObject);
        paramArrayOfByte = com.tencent.mm.plugin.finder.report.e.snY;
        com.tencent.mm.plugin.finder.report.e.jz(this.duh, ((aok)paramq).object.size());
      }
      paramq = ((Iterable)cyi()).iterator();
    }
    while (paramq.hasNext())
    {
      d((FinderObject)paramq.next());
      continue;
      paramq = com.tencent.mm.plugin.finder.spam.a.suA;
      com.tencent.mm.plugin.finder.spam.a.w(paramInt2, paramInt3, paramString);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */