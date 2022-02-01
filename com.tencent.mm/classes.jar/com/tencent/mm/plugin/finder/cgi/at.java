package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "(Ljava/lang/String;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class at
  extends n
  implements k
{
  private static final int rJC = 1;
  private static final int rJD = 3;
  private static final int rJE = 4;
  private static final int rJF = 5;
  private static final int rJG = 7;
  private static final int rJH = 8;
  private static final int rJI = 9;
  private static final int rJJ = 10;
  public static final a rJK;
  private final String TAG;
  private f callback;
  private b rr;
  
  static
  {
    AppMethodBeat.i(165249);
    rJK = new a((byte)0);
    rJC = 1;
    rJD = 3;
    rJE = 4;
    rJF = 5;
    rJG = 7;
    rJH = 8;
    rJI = 9;
    rJJ = 10;
    AppMethodBeat.o(165249);
  }
  
  public at(String paramString, List<? extends alo> paramList)
  {
    AppMethodBeat.i(165248);
    this.TAG = "Finder.NetSceneFinderOplog";
    b.a locala = new b.a();
    locala.oP(getType());
    locala.Dl("/cgi-bin/micromsg-bin/finderoplog");
    aqc localaqc = new aqc();
    localaqc.username = paramString;
    localaqc.rbl.addAll((Collection)paramList);
    paramString = v.rIR;
    localaqc.Glv = v.cxY();
    locala.c((com.tencent.mm.bx.a)localaqc);
    locala.d((com.tencent.mm.bx.a)new aqd());
    paramString = locala.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(this.TAG, "NetSceneFinderOplog init ");
    AppMethodBeat.o(165248);
  }
  
  public final List<alo> cyx()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((b)localObject).aEE();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((aqc)localObject).rbl;
    p.g(localObject, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<alp> cyy()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((b)localObject).aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((aqd)localObject).ozW;
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
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    ad.i(this.TAG, "retList " + cyy().size());
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = cyy().iterator();
    while (paramString.hasNext())
    {
      paramq = (alp)paramString.next();
      ad.i(this.TAG, "retCode " + paramq.retCode + " retMsg " + paramq.krz);
      paramArrayOfByte = com.tencent.mm.plugin.finder.spam.a.suA;
      com.tencent.mm.plugin.finder.spam.a.aZ(paramq.retCode, paramq.krz);
    }
    AppMethodBeat.o(165245);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdIdModFeedReproduction", "", "getCmdIdModFeedReproduction", "()I", "CmdIdModMsgMuteSetting", "getCmdIdModMsgMuteSetting", "CmdModBlackList", "getCmdModBlackList", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModMsgSessionMuteSetting", "getCmdModMsgSessionMuteSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "CmdModWxMsgSessionMuteSetting", "getCmdModWxMsgSessionMuteSetting", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */