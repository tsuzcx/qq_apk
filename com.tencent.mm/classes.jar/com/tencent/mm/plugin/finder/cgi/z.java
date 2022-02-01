package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class z
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneCreateFinderUser";
  public static final a rIY;
  private f callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165204);
    rIY = new a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public z(String paramString1, String paramString2, String paramString3, alx paramalx, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165203);
    b.a locala = new b.a();
    locala.oP(getType());
    amf localamf = new amf();
    localamf.nickname = bt.nullAsNil(paramString1);
    localamf.signature = paramString2;
    localamf.hDQ = paramString3;
    localamf.GlR = paramalx;
    localamf.GlT = paramInt1;
    localamf.GlS = paramInt2;
    paramString1 = v.rIR;
    localamf.Glv = v.cxY();
    locala.c((a)localamf);
    locala.d((a)new amg());
    locala.Dl("/cgi-bin/micromsg-bin/findercreateuser");
    paramString1 = locala.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ad.i(TAG, "NetSceneCreateFinderUser init ");
    AppMethodBeat.o(165203);
  }
  
  public final FinderContact cya()
  {
    AppMethodBeat.i(165202);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((amg)localObject).contact;
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
    ad.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = cya();
      if (paramq != null)
      {
        paramArrayOfByte = c.rHn;
        c.a.a(paramq);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGw, paramq.username);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGx, paramq.nickname);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGz, paramq.headUrl);
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165201);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */