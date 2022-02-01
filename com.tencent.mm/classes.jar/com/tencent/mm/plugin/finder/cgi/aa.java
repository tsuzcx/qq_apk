package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aa
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneCreateFinderUser";
  public static final a rRm;
  private f callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165204);
    rRm = new a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public aa(String paramString1, String paramString2, String paramString3, amj paramamj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165203);
    b.a locala = new b.a();
    locala.oS(getType());
    amr localamr = new amr();
    localamr.nickname = bu.nullAsNil(paramString1);
    localamr.signature = paramString2;
    localamr.hGI = paramString3;
    localamr.GES = paramamj;
    localamr.GEV = paramInt1;
    localamr.GEU = paramInt2;
    paramString1 = v.rRb;
    localamr.GDR = v.czz();
    locala.c((a)localamr);
    locala.d((a)new ams());
    locala.DN("/cgi-bin/micromsg-bin/findercreateuser");
    paramString1 = locala.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ae.i(TAG, "NetSceneCreateFinderUser init ");
    AppMethodBeat.o(165203);
  }
  
  public final FinderContact czB()
  {
    AppMethodBeat.i(165202);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((ams)localObject).contact;
    AppMethodBeat.o(165202);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165200);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165200);
    return i;
  }
  
  public final int getType()
  {
    return 3922;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165201);
    ae.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = czB();
      if (paramq != null)
      {
        paramArrayOfByte = c.rPy;
        c.a.a(paramq);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaW, paramq.username);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaX, paramq.nickname);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaZ, paramq.headUrl);
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165201);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */