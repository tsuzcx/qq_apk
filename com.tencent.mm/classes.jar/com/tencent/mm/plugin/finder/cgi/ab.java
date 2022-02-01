package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "(Ljava/lang/String;[BII)V", "contacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(Ljava/lang/String;[BLjava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class ab
  extends n
  implements com.tencent.mm.network.k
{
  public static final a qpx;
  private g callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165277);
    qpx = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public ab(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178087);
    b.a locala = new b.a();
    locala.nB(getType());
    locala.wg("/cgi-bin/micromsg-bin/findersync");
    all localall = new all();
    localall.hkT = paramInt1;
    localall.finderUsername = paramString;
    localall.DmH = z.am(paramArrayOfByte);
    paramString = am.KJy;
    localall.Dkw = am.fRS();
    localall.Dkw.scene = paramInt2;
    paramString = new alm();
    paramString.setBaseResponse(new BaseResponse());
    locala.c((a)localall);
    locala.d((a)paramString);
    paramString = locala.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i("Finder.NetSceneFinderSync", "NetSceneFinderSync init selector=" + paramInt1 + " scene=" + paramInt2);
    AppMethodBeat.o(178087);
  }
  
  public final int ckO()
  {
    AppMethodBeat.i(165273);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((alm)localObject).continueFlag;
    AppMethodBeat.o(165273);
    return i;
  }
  
  public final List<ahv> ckX()
  {
    AppMethodBeat.i(165275);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((alm)localObject).pJl;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(165271);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165271);
    return i;
  }
  
  public final int getInterval()
  {
    AppMethodBeat.i(165274);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((alm)localObject).DmK;
    AppMethodBeat.o(165274);
    return i;
  }
  
  public final int getType()
  {
    return 3565;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165272);
    ad.i("Finder.NetSceneFinderSync", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 11L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fvU();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165272);
      return;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */