package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "(Ljava/lang/String;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class v
  extends n
  implements com.tencent.mm.network.k
{
  private static final int KJO = 5;
  private static final int qpo = 1;
  private static final int qpp = 3;
  private static final int qpq = 4;
  public static final a qpr;
  private final String TAG;
  private g callback;
  private b rr;
  
  static
  {
    AppMethodBeat.i(165249);
    qpr = new a((byte)0);
    qpo = 1;
    qpp = 3;
    qpq = 4;
    KJO = 5;
    AppMethodBeat.o(165249);
  }
  
  public v(String paramString, List<? extends ahv> paramList)
  {
    AppMethodBeat.i(165248);
    this.TAG = "Finder.NetSceneFinderOplog";
    b.a locala = new b.a();
    locala.nB(getType());
    locala.wg("/cgi-bin/micromsg-bin/finderoplog");
    akg localakg = new akg();
    localakg.username = paramString;
    localakg.pJl.addAll((Collection)paramList);
    paramString = am.KJy;
    localakg.Dkw = am.fRS();
    locala.c((com.tencent.mm.bx.a)localakg);
    locala.d((com.tencent.mm.bx.a)new akh());
    paramString = locala.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(this.TAG, "NetSceneFinderOplog init ");
    AppMethodBeat.o(165248);
  }
  
  public final List<ahv> ckP()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    localObject = ((b)localObject).auL();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((akg)localObject).pJl;
    d.g.b.k.g(localObject, "(rr!!.requestProtoBuf as…nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<ahw> ckQ()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    localObject = ((b)localObject).auM();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((akh)localObject).ntC;
    d.g.b.k.g(localObject, "(rr!!.responseProtoBuf a…derOplogResponse).retList");
    localObject = (List)localObject;
    AppMethodBeat.o(165247);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165244);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    ad.i(this.TAG, "retList " + ckQ().size());
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = ckQ().iterator();
    while (paramString.hasNext())
    {
      paramq = (ahw)paramString.next();
      ad.i(this.TAG, "retCode " + paramq.retCode + " retMsg " + paramq.jwH);
      paramArrayOfByte = com.tencent.mm.plugin.finder.spam.a.qIC;
      com.tencent.mm.plugin.finder.spam.a.aS(paramq.retCode, paramq.jwH);
    }
    AppMethodBeat.o(165245);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog$Companion;", "", "()V", "CmdModBlackList", "", "getCmdModBlackList", "()I", "CmdModFeedSetting", "getCmdModFeedSetting", "CmdModRecommendSetting", "getCmdModRecommendSetting", "CmdModUserInfo", "getCmdModUserInfo", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */