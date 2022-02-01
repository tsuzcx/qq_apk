package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.c.b;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "args", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "(Ljava/lang/String;[BIILcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "transformToServerScene", "localScene", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class cm
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xed;
  private i callback;
  public d rr;
  private com.tencent.mm.plugin.findersdk.b.a.b xbn;
  
  static
  {
    AppMethodBeat.i(165277);
    xed = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public cm(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, c.b paramb)
  {
    AppMethodBeat.i(277406);
    this.xbn = com.tencent.mm.plugin.findersdk.b.a.b.BvV;
    d.a locala = new d.a();
    locala.vD(getType());
    locala.TW("/cgi-bin/micromsg-bin/findersync");
    bkb localbkb = new bkb();
    localbkb.fFT = paramInt1;
    localbkb.finderUsername = paramString;
    localbkb.SUZ = z.aN(paramArrayOfByte);
    paramString = ao.xcj;
    localbkb.yjp = ao.dnO();
    paramString = localbkb.yjp;
    if (paramString != null)
    {
      if (paramInt2 == 3) {
        paramString.scene = i;
      }
    }
    else
    {
      if (paramb == null) {
        break label619;
      }
      paramString = paramb.xsg;
      label122:
      localbkb.SVb = paramString;
      if (paramb == null) {
        break label624;
      }
      paramString = paramb.xsh;
      label139:
      localbkb.SVa = paramString;
      if (paramb == null) {
        break label629;
      }
      paramString = paramb.xsi;
      label156:
      localbkb.SVd = paramString;
      if (paramb == null) {
        break label634;
      }
    }
    label619:
    label624:
    label629:
    label634:
    for (paramString = paramb.xsj;; paramString = null)
    {
      localbkb.SVc = paramString;
      paramString = com.tencent.mm.ui.component.g.Xox;
      localbkb.SVe = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).Bgq;
      paramArrayOfByte = localbkb.yjp;
      paramString = localObject;
      if (paramArrayOfByte != null) {
        paramString = Integer.valueOf(paramArrayOfByte.scene);
      }
      if (paramString == null) {
        p.iCn();
      }
      if (paramString.intValue() >= 10000)
      {
        paramString = h.aHG();
        p.j(paramString, "MMKernel.storage()");
        localbkb.SGm = paramString.aHp().a(ar.a.VCm, "");
        paramString = h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VCm, "");
      }
      paramString = new bkc();
      paramString.setBaseResponse(new jh());
      locala.c((a)localbkb);
      locala.d((a)paramString);
      paramString = locala.bgN();
      p.j(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = new StringBuilder("NetSceneFinderSync init selector=").append(paramInt1).append(" scene=").append(paramInt2).append(" ctrlInfo type=");
      paramArrayOfByte = localbkb.SVa;
      p.j(paramArrayOfByte, "request.ctrlInfoList");
      paramb = (Iterable)paramArrayOfByte;
      paramArrayOfByte = (Collection)new ArrayList(j.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramArrayOfByte.add(((bhw)paramb.next()).SQm);
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
      if (paramInt2 == 9)
      {
        i = 7;
        break;
      }
      if (paramInt2 == 10)
      {
        i = 8;
        break;
      }
      if (paramInt2 >= 10000)
      {
        i = paramInt2;
        break;
      }
      paramString = (Throwable)new RuntimeException("unknown this localScene(" + paramInt2 + ')');
      AppMethodBeat.o(277406);
      throw paramString;
      paramString = null;
      break label122;
      paramString = null;
      break label139;
      paramString = null;
      break label156;
    }
    Log.i("Finder.NetSceneFinderSync", (List)paramArrayOfByte + ' ' + "entranceTipsId=" + localbkb.SVb + " stay_display_tab_type=" + localbkb.SVe + " request.client_ai_info=" + localbkb.SGm);
    AppMethodBeat.o(277406);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(277405);
    Log.i("Finder.NetSceneFinderSync", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(277405);
      throw paramString;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(277405);
      throw paramString;
    }
    params = (bkc)params;
    if (paramInt2 >= 4) {
      this.xbn = com.tencent.mm.plugin.findersdk.b.a.b.BvT;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 11L, 1L, false);
      params = params.SVg;
      if (params != null)
      {
        Object localObject = new StringBuilder("[onGYNetEnd] check_expire_info=");
        p.j(params, "it");
        Log.i("Finder.NetSceneFinderSync", cn.a(params));
        if (params.SDK == 1)
        {
          localObject = h.aHG();
          p.j(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAP, Util.encodeHexString(params.toByteArray()));
        }
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(277405);
      return;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return this.xbn;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165271);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165271);
    return i;
  }
  
  public final int doW()
  {
    AppMethodBeat.i(165274);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((bkc)localObject).SSD;
    AppMethodBeat.o(165274);
    return i;
  }
  
  public final List<aqt> doX()
  {
    AppMethodBeat.i(165275);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((bkc)localObject).wqP;
    p.j(localObject, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int doo()
  {
    AppMethodBeat.i(165273);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((bkc)localObject).continueFlag;
    AppMethodBeat.o(165273);
    return i;
  }
  
  public final int getType()
  {
    return 3565;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cm
 * JD-Core Version:    0.7.0.1
 */