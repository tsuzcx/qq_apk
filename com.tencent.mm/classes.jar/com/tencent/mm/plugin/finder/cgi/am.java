package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "(Ljava/lang/String;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class am
  extends n
  implements com.tencent.mm.network.k
{
  private static final int qYq = 1;
  private static final int qYr = 3;
  private static final int qYs = 4;
  private static final int qYt = 5;
  public static final a qYu;
  private final String TAG;
  private g callback;
  private b rr;
  
  static
  {
    AppMethodBeat.i(165249);
    qYu = new a((byte)0);
    qYq = 1;
    qYr = 3;
    qYs = 4;
    qYt = 5;
    AppMethodBeat.o(165249);
  }
  
  public am(String paramString, List<? extends aiy> paramList)
  {
    AppMethodBeat.i(165248);
    this.TAG = "Finder.NetSceneFinderOplog";
    b.a locala = new b.a();
    locala.op(getType());
    locala.Am("/cgi-bin/micromsg-bin/finderoplog");
    amr localamr = new amr();
    localamr.username = paramString;
    localamr.qrS.addAll((Collection)paramList);
    paramString = q.qXH;
    localamr.EDL = q.csi();
    locala.c((com.tencent.mm.bw.a)localamr);
    locala.d((com.tencent.mm.bw.a)new ams());
    paramString = locala.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ac.i(this.TAG, "NetSceneFinderOplog init ");
    AppMethodBeat.o(165248);
  }
  
  public final List<aiy> csG()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    localObject = ((b)localObject).aBC();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((amr)localObject).qrS;
    d.g.b.k.g(localObject, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<aiz> csH()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    localObject = ((b)localObject).aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((ams)localObject).nWC;
    d.g.b.k.g(localObject, "(rr!!.responseProtoBuf a…derOplogResponse).retList");
    localObject = (List)localObject;
    AppMethodBeat.o(165247);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165244);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165244);
    return i;
  }
  
  public final int getType()
  {
    return 3870;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165245);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    ac.i(this.TAG, "retList " + csH().size());
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = csH().iterator();
    while (paramString.hasNext())
    {
      paramq = (aiz)paramString.next();
      ac.i(this.TAG, "retCode " + paramq.retCode + " retMsg " + paramq.jXd);
      paramArrayOfByte = com.tencent.mm.plugin.finder.spam.a.rBD;
      com.tencent.mm.plugin.finder.spam.a.aW(paramq.retCode, paramq.jXd);
    }
    AppMethodBeat.o(165245);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdModBlackList", "", "getCmdModBlackList", "()I", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */