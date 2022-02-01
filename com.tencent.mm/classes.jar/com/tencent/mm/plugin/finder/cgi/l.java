package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class l
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneCreateFinderUser";
  public static final a qpc;
  private com.tencent.mm.al.g callback;
  public com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(165204);
    qpc = new a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public l(String paramString1, String paramString2, String paramString3, ahz paramahz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165203);
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.nB(getType());
    aib localaib = new aib();
    localaib.nickname = bt.nullAsNil(paramString1);
    localaib.signature = paramString2;
    localaib.gLg = paramString3;
    localaib.DkH = paramahz;
    localaib.DkJ = paramInt1;
    localaib.DkI = paramInt2;
    paramString1 = am.KJy;
    localaib.Dkw = am.fRS();
    locala.c((a)localaib);
    locala.d((a)new aic());
    locala.wg("/cgi-bin/micromsg-bin/findercreateuser");
    paramString1 = locala.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ad.i(TAG, "NetSceneCreateFinderUser init ");
    AppMethodBeat.o(165203);
  }
  
  public final FinderContact ckE()
  {
    AppMethodBeat.i(165202);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((aic)localObject).contact;
    AppMethodBeat.o(165202);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165200);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    ad.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ckE();
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qnX;
        com.tencent.mm.plugin.finder.api.b.a.a(paramq);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvW, paramq.username);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvX, paramq.nickname);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvZ, paramq.headUrl);
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165201);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */