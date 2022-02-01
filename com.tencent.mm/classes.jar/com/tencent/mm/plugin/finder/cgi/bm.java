package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFollowContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bm
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public bm(b paramb)
  {
    AppMethodBeat.i(165225);
    this.TAG = "Finder.NetSceneFinderGetFollowList";
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    locala.vD(getType());
    aug localaug = new aug();
    localaug.lastBuffer = paramb;
    paramb = ao.xcj;
    localaug.yjp = ao.dnO();
    locala.c((a)localaug);
    locala.d((a)new auh());
    locala.TW("/cgi-bin/micromsg-bin/findergetfollowlist");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(165225);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    boolean bool = false;
    AppMethodBeat.i(285357);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      params = this.rr.bhX();
      if (params != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListRequest");
      AppMethodBeat.o(285357);
      throw paramString;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 8L, 1L, false);
    }
    if (((aug)params).lastBuffer == null)
    {
      params = h.aHG();
      p.j(params, "MMKernel.storage()");
      params = params.aHp();
      localObject1 = ar.a.VAv;
      localObject2 = this.rr.bhY();
      if (localObject2 == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
        AppMethodBeat.o(285357);
        throw paramString;
      }
      params.set((ar.a)localObject1, Integer.valueOf(((auh)localObject2).SGL));
      params = x.aazN;
    }
    params = doh();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("firstPage ");
    if (doa() == null) {
      bool = true;
    }
    Log.i((String)localObject1, bool + ", get " + params.size() + " follow contact ");
    params = ((Iterable)params).iterator();
    while (params.hasNext())
    {
      localObject1 = (FinderContact)params.next();
      localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      com.tencent.mm.plugin.finder.api.d.a.a((FinderContact)localObject1);
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(285357);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165221);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165221);
    return i;
  }
  
  public final b doa()
  {
    AppMethodBeat.i(165224);
    a locala = this.rr.bhY();
    Object localObject = locala;
    if (!(locala instanceof auh)) {
      localObject = null;
    }
    localObject = (auh)localObject;
    if (localObject != null)
    {
      localObject = ((auh)localObject).lastBuffer;
      AppMethodBeat.o(165224);
      return localObject;
    }
    AppMethodBeat.o(165224);
    return null;
  }
  
  public final b dob()
  {
    AppMethodBeat.i(285359);
    a locala = this.rr.bhX();
    Object localObject = locala;
    if (!(locala instanceof aug)) {
      localObject = null;
    }
    localObject = (aug)localObject;
    if (localObject != null)
    {
      localObject = ((aug)localObject).lastBuffer;
      AppMethodBeat.o(285359);
      return localObject;
    }
    AppMethodBeat.o(285359);
    return null;
  }
  
  public final boolean dod()
  {
    AppMethodBeat.i(285358);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(285358);
      throw ((Throwable)localObject);
    }
    if (((auh)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(285358);
      return true;
    }
    AppMethodBeat.o(285358);
    return false;
  }
  
  public final LinkedList<FinderContact> doh()
  {
    AppMethodBeat.i(165223);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowListResponse");
      AppMethodBeat.o(165223);
      throw ((Throwable)localObject);
    }
    localObject = ((auh)localObject).SFU;
    p.j(localObject, "(rr.responseProtoBuf as …ListResponse).contactList");
    AppMethodBeat.o(165223);
    return localObject;
  }
  
  public final int getType()
  {
    return 713;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bm
 * JD-Core Version:    0.7.0.1
 */