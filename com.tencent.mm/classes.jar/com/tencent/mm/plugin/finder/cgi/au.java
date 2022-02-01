package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "(Ljava/lang/String;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class au
  extends n
  implements k
{
  private static final int rRQ = 1;
  private static final int rRR = 3;
  private static final int rRS = 4;
  private static final int rRT = 5;
  private static final int rRU = 7;
  private static final int rRV = 8;
  private static final int rRW = 9;
  private static final int rRX = 10;
  public static final a rRY;
  private final String TAG;
  private f callback;
  private b rr;
  
  static
  {
    AppMethodBeat.i(165249);
    rRY = new a((byte)0);
    rRQ = 1;
    rRR = 3;
    rRS = 4;
    rRT = 5;
    rRU = 7;
    rRV = 8;
    rRW = 9;
    rRX = 10;
    AppMethodBeat.o(165249);
  }
  
  public au(String paramString, List<? extends ama> paramList)
  {
    AppMethodBeat.i(165248);
    this.TAG = "Finder.NetSceneFinderOplog";
    b.a locala = new b.a();
    locala.oS(getType());
    locala.DN("/cgi-bin/micromsg-bin/finderoplog");
    aqr localaqr = new aqr();
    localaqr.username = paramString;
    localaqr.rjr.addAll((Collection)paramList);
    paramString = v.rRb;
    localaqr.GDR = v.czz();
    locala.c((com.tencent.mm.bw.a)localaqr);
    locala.d((com.tencent.mm.bw.a)new aqs());
    paramString = locala.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ae.i(this.TAG, "NetSceneFinderOplog init ");
    AppMethodBeat.o(165248);
  }
  
  public final List<ama> czY()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((b)localObject).aEU();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((aqr)localObject).rjr;
    p.g(localObject, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<amb> czZ()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((b)localObject).aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((aqs)localObject).oGy;
    p.g(localObject, "(rr!!.responseProtoBuf a…derOplogResponse).retList");
    localObject = (List)localObject;
    AppMethodBeat.o(165247);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165244);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165244);
    return i;
  }
  
  public final int getType()
  {
    return 3870;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165245);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    ae.i(this.TAG, "retList " + czZ().size());
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = czZ().iterator();
    while (paramString.hasNext())
    {
      paramq = (amb)paramString.next();
      ae.i(this.TAG, "retCode " + paramq.retCode + " retMsg " + paramq.kuP);
      paramArrayOfByte = com.tencent.mm.plugin.finder.spam.a.sEK;
      com.tencent.mm.plugin.finder.spam.a.aY(paramq.retCode, paramq.kuP);
    }
    AppMethodBeat.o(165245);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdIdModFeedReproduction", "", "getCmdIdModFeedReproduction", "()I", "CmdIdModMsgMuteSetting", "getCmdIdModMsgMuteSetting", "CmdModBlackList", "getCmdModBlackList", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModMsgSessionMuteSetting", "getCmdModMsgSessionMuteSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "CmdModWxMsgSessionMuteSetting", "getCmdModWxMsgSessionMuteSetting", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */