package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bj
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public bj(b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    d.a locala = new d.a();
    locala.sG(getType());
    asf localasf = new asf();
    localasf.lastBuffer = paramb;
    paramb = am.tuw;
    localasf.uli = am.cXY();
    locala.c((a)localasf);
    locala.d((a)new asg());
    locala.MB("/cgi-bin/micromsg-bin/findergetfollowlist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    boolean bool = false;
    AppMethodBeat.i(242410);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      params = this.rr.aYJ();
      if (params != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(242410);
      throw paramString;
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((asf)params).lastBuffer == null)
    {
      params = com.tencent.mm.kernel.g.aAh();
      p.g(params, "MMKernel.storage()");
      params = params.azQ();
      localObject1 = ar.a.OlA;
      localObject2 = this.rr.aYK();
      if (localObject2 == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(242410);
        throw paramString;
      }
      params.set((ar.a)localObject1, Integer.valueOf(((asg)localObject2).LDr));
      params = x.SXb;
    }
    params = cYt();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("firstPage ");
    if (cYm() == null) {
      bool = true;
    }
    Log.i((String)localObject1, bool + ", get " + params.size() + " follow contact ");
    params = ((Iterable)params).iterator();
    while (params.hasNext())
    {
      localObject1 = (FinderContact)params.next();
      localObject2 = c.tsp;
      c.a.a((FinderContact)localObject1);
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242410);
  }
  
  public final b cYm()
  {
    AppMethodBeat.i(165224);
    a locala = this.rr.aYK();
    Object localObject = locala;
    if (!(locala instanceof asg)) {
      localObject = null;
    }
    localObject = (asg)localObject;
    if (localObject != null)
    {
      localObject = ((asg)localObject).lastBuffer;
      AppMethodBeat.o(165224);
      return localObject;
    }
    AppMethodBeat.o(165224);
    return null;
  }
  
  public final b cYn()
  {
    AppMethodBeat.i(242412);
    a locala = this.rr.aYJ();
    Object localObject = locala;
    if (!(locala instanceof asf)) {
      localObject = null;
    }
    localObject = (asf)localObject;
    if (localObject != null)
    {
      localObject = ((asf)localObject).lastBuffer;
      AppMethodBeat.o(242412);
      return localObject;
    }
    AppMethodBeat.o(242412);
    return null;
  }
  
  public final boolean cYp()
  {
    AppMethodBeat.i(242411);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(242411);
      throw ((Throwable)localObject);
    }
    if (((asg)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(242411);
      return true;
    }
    AppMethodBeat.o(242411);
    return false;
  }
  
  public final LinkedList<FinderContact> cYt()
  {
    AppMethodBeat.i(165223);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((asg)localObject).LCI;
    p.g(localObject, "(rr.responseProtoBuf as …ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165221);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165221);
    return i;
  }
  
  public final int getType()
  {
    return 713;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bj
 * JD-Core Version:    0.7.0.1
 */