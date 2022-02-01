package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "(Ljava/lang/String;[BII)V", "contacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(Ljava/lang/String;[BLjava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class at
  extends n
  implements com.tencent.mm.network.k
{
  public static final a qYD;
  private g callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165277);
    qYD = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public at(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178087);
    b.a locala = new b.a();
    locala.op(getType());
    locala.Am("/cgi-bin/micromsg-bin/findersync");
    aog localaog = new aog();
    localaog.hLw = paramInt1;
    localaog.rfC = paramString;
    localaog.EHs = z.al(paramArrayOfByte);
    paramString = q.qXH;
    localaog.EDL = q.csi();
    localaog.EDL.scene = paramInt2;
    paramString = new aoh();
    paramString.setBaseResponse(new BaseResponse());
    locala.c((a)localaog);
    locala.d((a)paramString);
    paramString = locala.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ac.i("Finder.NetSceneFinderSync", "NetSceneFinderSync init selector=" + paramInt1 + " scene=" + paramInt2);
    AppMethodBeat.o(178087);
  }
  
  public final List<aiy> csQ()
  {
    AppMethodBeat.i(165275);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((aoh)localObject).qrS;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int csz()
  {
    AppMethodBeat.i(165273);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((aoh)localObject).continueFlag;
    AppMethodBeat.o(165273);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(165271);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165271);
    return i;
  }
  
  public final int getInterval()
  {
    AppMethodBeat.i(165274);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((aoh)localObject).EHu;
    AppMethodBeat.o(165274);
    return i;
  }
  
  public final int getType()
  {
    return 3565;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165272);
    ac.i("Finder.NetSceneFinderSync", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 11L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165272);
      return;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */