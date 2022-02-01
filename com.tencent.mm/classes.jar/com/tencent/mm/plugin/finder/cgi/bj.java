package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "scene", "", "(Lcom/tencent/mm/protobuf/ByteString;JI)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bj
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public bj(b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(248187);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    d.a locala = new d.a();
    locala.vD(getType());
    aty localaty = new aty();
    localaty.finderUsername = z.bdh();
    localaty.xHE = paramb;
    paramb = ao.xcj;
    localaty.yjp = ao.dnO();
    localaty.SGI = paramLong;
    localaty.scene = paramInt;
    locala.c((a)localaty);
    locala.d((a)new atz());
    locala.TW("/cgi-bin/micromsg-bin/findergetfanslist");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFansList,liveId:" + paramLong + ",scene:" + paramInt);
    AppMethodBeat.o(248187);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(248178);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      f.Iyx.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(248178);
      return;
      f.Iyx.idkeyStat(1279L, 10L, 1L, false);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165217);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165217);
    return i;
  }
  
  public final b doa()
  {
    AppMethodBeat.i(248181);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(248181);
      throw ((Throwable)localObject);
    }
    localObject = ((atz)localObject).xHE;
    AppMethodBeat.o(248181);
    return localObject;
  }
  
  public final b dob()
  {
    AppMethodBeat.i(248179);
    Object localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
      AppMethodBeat.o(248179);
      throw ((Throwable)localObject);
    }
    localObject = ((aty)localObject).xHE;
    AppMethodBeat.o(248179);
    return localObject;
  }
  
  public final LinkedList<asn> doc()
  {
    AppMethodBeat.i(165219);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((atz)localObject).SGJ;
    AppMethodBeat.o(165219);
    return localObject;
  }
  
  public final boolean dod()
  {
    AppMethodBeat.i(248184);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(248184);
      throw ((Throwable)localObject);
    }
    if (((atz)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(248184);
      return true;
    }
    AppMethodBeat.o(248184);
    return false;
  }
  
  public final int getType()
  {
    return 3531;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bj
 * JD-Core Version:    0.7.0.1
 */