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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "(Ljava/lang/String;[BII)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "transformToServerScene", "localScene", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class bc
  extends n
  implements k
{
  public static final a rSh;
  private f callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165277);
    rSh = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public bc(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178087);
    b.a locala = new b.a();
    locala.oS(getType());
    locala.DN("/cgi-bin/micromsg-bin/findersync");
    ask localask = new ask();
    localask.dvk = paramInt1;
    localask.sbR = paramString;
    localask.GJB = z.al(paramArrayOfByte);
    paramString = v.rRb;
    localask.GDR = v.czz();
    paramString = localask.GDR;
    if (paramString != null) {
      if (paramInt2 != 3) {
        break label280;
      }
    }
    for (;;)
    {
      paramString.scene = i;
      paramString = g.ad(PluginFinder.class);
      p.g(paramString, "MMKernel.plugin(PluginFinder::class.java)");
      paramString = ((PluginFinder)paramString).getRedDotManager().aij("FinderEntrance");
      if (paramString != null)
      {
        paramString = paramString.field_ctrInfo;
        if (paramString != null)
        {
          localask.LGu.add(paramString);
          localask.LGv = paramString.GIg;
        }
      }
      paramString = new asl();
      paramString.setBaseResponse(new BaseResponse());
      locala.c((a)localask);
      locala.d((a)paramString);
      paramString = locala.aDS();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ae.i("Finder.NetSceneFinderSync", "NetSceneFinderSync init selector=" + paramInt1 + " scene=" + paramInt2 + " ctrlInfo type=" + localask.LGu.size() + " entranceTipsId=" + localask.LGv);
      AppMethodBeat.o(178087);
      return;
      label280:
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
  
  public final List<ama> cAn()
  {
    AppMethodBeat.i(165275);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((asl)localObject).rjr;
    p.g(localObject, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int czR()
  {
    AppMethodBeat.i(165273);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((asl)localObject).continueFlag;
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
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((asl)localObject).GJD;
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
    ae.i("Finder.NetSceneFinderSync", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 11L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165272);
      return;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bc
 * JD-Core Version:    0.7.0.1
 */