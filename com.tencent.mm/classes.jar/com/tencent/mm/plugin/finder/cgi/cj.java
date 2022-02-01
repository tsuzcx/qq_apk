package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cj
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public cj(b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    c.a locala = new c.a();
    locala.funcId = getType();
    ayy localayy = new ayy();
    localayy.lastBuffer = paramb;
    paramb = bi.ABn;
    localayy.CJv = bi.dVu();
    locala.otE = ((a)localayy);
    locala.otF = ((a)new ayz());
    locala.uri = "/cgi-bin/micromsg-bin/findergetfollowlist";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    boolean bool = false;
    AppMethodBeat.i(336716);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      params = c.b.b(this.rr.otB);
      if (params != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(336716);
      throw paramString;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((ayy)params).lastBuffer == null)
    {
      params = com.tencent.mm.kernel.h.baE().ban();
      localObject1 = at.a.adcN;
      localObject2 = c.c.b(this.rr.otC);
      if (localObject2 == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(336716);
        throw paramString;
      }
      params.set((at.a)localObject1, Integer.valueOf(((ayz)localObject2).followCount));
    }
    params = dVR();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("firstPage ");
    if (dVJ() == null) {
      bool = true;
    }
    Log.i((String)localObject1, bool + ", get " + params.size() + " follow contact ");
    params = ((Iterable)params).iterator();
    while (params.hasNext())
    {
      localObject1 = (FinderContact)params.next();
      localObject2 = d.AwY;
      d.a.d((FinderContact)localObject1);
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336716);
  }
  
  public final b dVJ()
  {
    AppMethodBeat.i(165224);
    Object localObject = c.c.b(this.rr.otC);
    if ((localObject instanceof ayz)) {}
    for (localObject = (ayz)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(165224);
      return null;
    }
    localObject = ((ayz)localObject).lastBuffer;
    AppMethodBeat.o(165224);
    return localObject;
  }
  
  public final b dVL()
  {
    AppMethodBeat.i(336738);
    Object localObject = c.b.b(this.rr.otB);
    if ((localObject instanceof ayy)) {}
    for (localObject = (ayy)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(336738);
      return null;
    }
    localObject = ((ayy)localObject).lastBuffer;
    AppMethodBeat.o(336738);
    return localObject;
  }
  
  public final boolean dVN()
  {
    AppMethodBeat.i(336731);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(336731);
      throw ((Throwable)localObject);
    }
    if (((ayz)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(336731);
      return true;
    }
    AppMethodBeat.o(336731);
    return false;
  }
  
  public final LinkedList<FinderContact> dVR()
  {
    AppMethodBeat.i(165223);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((ayz)localObject).ZIt;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165221);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165221);
    return i;
  }
  
  public final int getType()
  {
    return 713;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cj
 * JD-Core Version:    0.7.0.1
 */