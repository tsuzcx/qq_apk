package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.findersdk.a.cm;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/findersdk/api/INetSceneFinderGetFansList;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "scene", "", "(Lcom/tencent/mm/protobuf/ByteString;JI)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cg
  extends com.tencent.mm.plugin.findersdk.b.h
  implements cm
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public cg(b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(336691);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    c.a locala = new c.a();
    locala.funcId = getType();
    ayq localayq = new ayq();
    localayq.finderUsername = z.bAW();
    localayq.BgS = paramb;
    paramb = bi.ABn;
    localayq.CJv = bi.dVu();
    localayq.ZJA = paramLong;
    localayq.scene = paramInt;
    locala.otE = ((a)localayq);
    locala.otF = ((a)new ayr());
    locala.uri = "/cgi-bin/micromsg-bin/findergetfanslist";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFansList,liveId:" + paramLong + ",scene:" + paramInt);
    AppMethodBeat.o(336691);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336708);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      f.Ozc.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336708);
      return;
      f.Ozc.idkeyStat(1279L, 10L, 1L, false);
    }
  }
  
  public final b dVJ()
  {
    AppMethodBeat.i(336718);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(336718);
      throw ((Throwable)localObject);
    }
    localObject = ((ayr)localObject).BgS;
    AppMethodBeat.o(336718);
    return localObject;
  }
  
  public final b dVL()
  {
    AppMethodBeat.i(336710);
    Object localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
      AppMethodBeat.o(336710);
      throw ((Throwable)localObject);
    }
    localObject = ((ayq)localObject).BgS;
    AppMethodBeat.o(336710);
    return localObject;
  }
  
  public final LinkedList<axc> dVM()
  {
    AppMethodBeat.i(165219);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((ayr)localObject).ZJB;
    AppMethodBeat.o(165219);
    return localObject;
  }
  
  public final boolean dVN()
  {
    AppMethodBeat.i(336732);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(336732);
      throw ((Throwable)localObject);
    }
    if (((ayr)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(336732);
      return true;
    }
    AppMethodBeat.o(336732);
    return false;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165217);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165217);
    return i;
  }
  
  public final int getType()
  {
    return 3531;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cg
 * JD-Core Version:    0.7.0.1
 */