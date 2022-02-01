package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "(Ljava/lang/String;[BII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "transformToServerScene", "localScene", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class bb
  extends n
  implements k
{
  public static final a rJT;
  private f callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165277);
    rJT = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public bb(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178087);
    b.a locala = new b.a();
    locala.oP(getType());
    locala.Dl("/cgi-bin/micromsg-bin/findersync");
    arv localarv = new arv();
    localarv.duf = paramInt1;
    localarv.rTn = paramString;
    localarv.Gqg = z.al(paramArrayOfByte);
    paramString = v.rIR;
    localarv.Glv = v.cxY();
    paramString = localarv.Glv;
    if (paramInt2 == 3) {}
    for (;;)
    {
      paramString.scene = i;
      paramString = new arw();
      paramString.setBaseResponse(new BaseResponse());
      locala.c((a)localarv);
      locala.d((a)paramString);
      paramString = locala.aDC();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ad.i("Finder.NetSceneFinderSync", "NetSceneFinderSync init selector=" + paramInt1 + " scene=" + paramInt2);
      AppMethodBeat.o(178087);
      return;
      if (paramInt2 == 7)
      {
        i = 1;
      }
      else if ((paramInt2 == 2) || (paramInt2 == 4))
      {
        i = 2;
      }
      else if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        i = 4;
      }
      else if (paramInt2 == 1)
      {
        i = 5;
      }
      else
      {
        if (paramInt2 < 10000) {
          break;
        }
        i = paramInt2;
      }
    }
    paramString = (Throwable)new RuntimeException("unknown this localScene(" + paramInt2 + ')');
    AppMethodBeat.o(178087);
    throw paramString;
  }
  
  public final List<alo> cyM()
  {
    AppMethodBeat.i(165275);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((arw)localObject).rbl;
    p.g(localObject, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int cyq()
  {
    AppMethodBeat.i(165273);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((arw)localObject).continueFlag;
    AppMethodBeat.o(165273);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165271);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165271);
    return i;
  }
  
  public final int getInterval()
  {
    AppMethodBeat.i(165274);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((arw)localObject).Gqi;
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 11L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165272);
      return;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bb
 * JD-Core Version:    0.7.0.1
 */