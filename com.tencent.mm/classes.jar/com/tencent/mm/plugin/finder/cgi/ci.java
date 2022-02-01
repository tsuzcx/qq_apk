package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.extension.a.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "args", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "(Ljava/lang/String;[BIILcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "transformToServerScene", "localScene", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class ci
  extends ax
  implements m
{
  public static final a two;
  private i callback;
  public d rr;
  private b ttH;
  
  static
  {
    AppMethodBeat.i(165277);
    two = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public ci(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, a.b paramb)
  {
    AppMethodBeat.i(242513);
    this.ttH = b.tyf;
    d.a locala = new d.a();
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/findersync");
    bde localbde = new bde();
    localbde.dML = paramInt1;
    localbde.finderUsername = paramString;
    localbde.LMX = z.aC(paramArrayOfByte);
    paramString = am.tuw;
    localbde.uli = am.cXY();
    paramString = localbde.uli;
    if (paramString != null)
    {
      if (paramInt2 == 3) {
        paramString.scene = i;
      }
    }
    else
    {
      if (paramb == null) {
        break label477;
      }
      paramString = paramb.tIX;
      label122:
      localbde.LMZ = paramString;
      if (paramb == null) {
        break label482;
      }
      paramString = paramb.tIY;
      label139:
      localbde.LMY = paramString;
      if (paramb == null) {
        break label487;
      }
    }
    label477:
    label482:
    label487:
    for (paramString = paramb.tIZ;; paramString = null)
    {
      localbde.LNb = paramString;
      paramString = localObject;
      if (paramb != null) {
        paramString = paramb.tJa;
      }
      localbde.LNa = paramString;
      paramString = new bdf();
      paramString.setBaseResponse(new BaseResponse());
      locala.c((a)localbde);
      locala.d((a)paramString);
      paramString = locala.aXF();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = new StringBuilder("NetSceneFinderSync init selector=").append(paramInt1).append(" scene=").append(paramInt2).append(" ctrlInfo type=");
      paramArrayOfByte = localbde.LMY;
      p.g(paramArrayOfByte, "request.ctrlInfoList");
      paramb = (Iterable)paramArrayOfByte;
      paramArrayOfByte = (Collection)new ArrayList(j.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramArrayOfByte.add(((bbi)paramb.next()).LKM);
      }
      if (paramInt2 == 7)
      {
        i = 1;
        break;
      }
      if ((paramInt2 == 2) || (paramInt2 == 4))
      {
        i = 2;
        break;
      }
      if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        i = 4;
        break;
      }
      if (paramInt2 == 1)
      {
        i = 5;
        break;
      }
      if (paramInt2 == 8)
      {
        i = 6;
        break;
      }
      if (paramInt2 >= 10000)
      {
        i = paramInt2;
        break;
      }
      paramString = (Throwable)new RuntimeException("unknown this localScene(" + paramInt2 + ')');
      AppMethodBeat.o(242513);
      throw paramString;
      paramString = null;
      break label122;
      paramString = null;
      break label139;
    }
    Log.i("Finder.NetSceneFinderSync", (List)paramArrayOfByte + " entranceTipsId=" + localbde.LMZ);
    AppMethodBeat.o(242513);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242512);
    Log.i("Finder.NetSceneFinderSync", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(242512);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(242512);
      throw paramString;
    }
    params = (bdf)params;
    if (paramInt2 >= 4) {
      this.ttH = b.tyd;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 11L, 1L, false);
      params = params.LNe;
      if (params != null)
      {
        Object localObject = new StringBuilder("[onGYNetEnd] check_expire_info=");
        p.g(params, "it");
        Log.i("Finder.NetSceneFinderSync", cj.a(params));
        if (params.LBb == 1)
        {
          localObject = com.tencent.mm.kernel.g.aAh();
          p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.OlT, Util.encodeHexString(params.toByteArray()));
        }
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242512);
      return;
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  public final b cXS()
  {
    return this.ttH;
  }
  
  public final int cYA()
  {
    AppMethodBeat.i(165273);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((bdf)localObject).continueFlag;
    AppMethodBeat.o(165273);
    return i;
  }
  
  public final List<apf> cZf()
  {
    AppMethodBeat.i(165275);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((bdf)localObject).sKS;
    p.g(localObject, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165271);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165271);
    return i;
  }
  
  public final int getInterval()
  {
    AppMethodBeat.i(165274);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((bdf)localObject).LNd;
    AppMethodBeat.o(165274);
    return i;
  }
  
  public final int getType()
  {
    return 3565;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ci
 * JD-Core Version:    0.7.0.1
 */