package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class u
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneCreateFinderUser";
  public static final u.a qXO;
  private com.tencent.mm.ak.g callback;
  public com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(165204);
    qXO = new u.a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public u(String paramString1, String paramString2, String paramString3, aje paramaje, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165203);
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.op(getType());
    ajk localajk = new ajk();
    localajk.nickname = bs.nullAsNil(paramString1);
    localajk.signature = paramString2;
    localajk.hlG = paramString3;
    localajk.EEc = paramaje;
    localajk.EEe = paramInt1;
    localajk.EEd = paramInt2;
    paramString1 = q.qXH;
    localajk.EDL = q.csi();
    locala.c((a)localajk);
    locala.d((a)new ajl());
    locala.Am("/cgi-bin/micromsg-bin/findercreateuser");
    paramString1 = locala.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ac.i(TAG, "NetSceneCreateFinderUser init ");
    AppMethodBeat.o(165203);
  }
  
  public final FinderContact csk()
  {
    AppMethodBeat.i(165202);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((ajl)localObject).contact;
    AppMethodBeat.o(165202);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165200);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165200);
    return i;
  }
  
  public final int getType()
  {
    return 3922;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165201);
    ac.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = csk();
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qWt;
        com.tencent.mm.plugin.finder.api.b.a.a(paramq);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTQ, paramq.username);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTR, paramq.nickname);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTT, paramq.headUrl);
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.u
 * JD-Core Version:    0.7.0.1
 */