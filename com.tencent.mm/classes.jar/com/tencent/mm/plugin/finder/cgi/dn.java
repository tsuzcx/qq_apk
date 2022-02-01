package com.tencent.mm.plugin.finder.cgi;

import android.content.res.Resources;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.am.b;
import com.tencent.mm.ui.am.g;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "keyBuf", "", "selector", "", "scene", "args", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "(Ljava/lang/String;[BIILcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fillRedDotArgs", "", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "isEnableReport", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "transformToServerScene", "localScene", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dn
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADm;
  private b AAa;
  private com.tencent.mm.am.h callback;
  public c rr;
  
  static
  {
    AppMethodBeat.i(165277);
    ADm = new a((byte)0);
    AppMethodBeat.o(165277);
  }
  
  public dn(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.extension.c.c paramc)
  {
    AppMethodBeat.i(336909);
    this.AAa = b.Hdf;
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/findersync";
    Object localObject2;
    int i;
    if (paramc != null)
    {
      Object localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
      localObject1 = ((i)localObject3).Su("FinderEntrance");
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo;
        if (localObject1 != null)
        {
          localObject2 = ((btw)localObject1).ZYN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          kotlin.g.b.s.u(localObject1, "<set-?>");
          paramc.APq = ((String)localObject1);
        }
      }
      localObject1 = ((i)localObject3).Su("FinderEntrance");
      if (localObject1 != null) {
        paramc.APr.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
      }
      localObject1 = ((i)localObject3).Su("TLFollow");
      btw localbtw;
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APr;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1016;
        }
        localbtw = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, localbtw.ZYN)) {
          break label1007;
        }
        label221:
        if (i < 0) {
          paramc.APr.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
      }
      localObject1 = ((i)localObject3).Su("TLRecommendTab");
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APr;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label276:
        if (!((Iterator)localObject2).hasNext()) {
          break label1031;
        }
        localbtw = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, localbtw.ZYN)) {
          break label1022;
        }
        label314:
        if (i < 0) {
          paramc.APr.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
      }
      localObject1 = ((i)localObject3).Su("finder_tl_hot_tab");
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APr;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label369:
        if (!((Iterator)localObject2).hasNext()) {
          break label1046;
        }
        localbtw = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, localbtw.ZYN)) {
          break label1037;
        }
        label407:
        if (i < 0) {
          paramc.APr.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
      }
      localObject1 = ((i)localObject3).Su("finder_tl_nearby_tab");
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APr;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label462:
        if (!((Iterator)localObject2).hasNext()) {
          break label1061;
        }
        localbtw = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, localbtw.ZYN)) {
          break label1052;
        }
        label500:
        if (i < 0) {
          paramc.APr.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
      }
      localObject1 = ((i)localObject3).Su("NearbyEntrance");
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo;
        if (localObject1 != null)
        {
          localObject2 = ((btw)localObject1).ZYN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          paramc.avn((String)localObject1);
        }
      }
      localObject1 = ((i)localObject3).Su("FinderLiveEntrance");
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo;
        if (localObject1 != null)
        {
          localObject2 = ((btw)localObject1).ZYN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          paramc.avn((String)localObject1);
        }
      }
      localObject1 = ((i)localObject3).Su("NearbyEntrance");
      if (localObject1 != null) {
        paramc.APt.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
      }
      localObject1 = ((i)localObject3).Su("NearbyFeedTab");
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APt;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label689:
        if (!((Iterator)localObject2).hasNext()) {
          break label1076;
        }
        localbtw = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, localbtw.ZYN)) {
          break label1067;
        }
        label727:
        if (i < 0) {
          paramc.APt.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
      }
      localObject1 = ((i)localObject3).Su("NearbyLiveTab");
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APt;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label782:
        if (!((Iterator)localObject2).hasNext()) {
          break label1091;
        }
        localbtw = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, localbtw.ZYN)) {
          break label1082;
        }
        label820:
        if (i < 0) {
          paramc.APt.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
      }
      localObject1 = ((i)localObject3).Su("NearbyPeopleTab");
      if (localObject1 != null)
      {
        localObject2 = (List)paramc.APt;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label875:
        if (!((Iterator)localObject2).hasNext()) {
          break label1106;
        }
        localObject3 = (btw)((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId, ((btw)localObject3).ZYN)) {
          break label1097;
        }
      }
      for (;;)
      {
        if (i < 0) {
          paramc.APt.add(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo);
        }
        localObject2 = (Iterable)paramc.APr;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(com.tencent.mm.ae.d.hF(((btw)((Iterator)localObject2).next()).feedId));
        }
        label1007:
        i += 1;
        break;
        label1016:
        i = -1;
        break label221;
        label1022:
        i += 1;
        break label276;
        label1031:
        i = -1;
        break label314;
        label1037:
        i += 1;
        break label369;
        label1046:
        i = -1;
        break label407;
        label1052:
        i += 1;
        break label462;
        label1061:
        i = -1;
        break label500;
        label1067:
        i += 1;
        break label689;
        label1076:
        i = -1;
        break label727;
        label1082:
        i += 1;
        break label782;
        label1091:
        i = -1;
        break label820;
        label1097:
        i += 1;
        break label875;
        label1106:
        i = -1;
      }
      Log.i("Finder.NetSceneFinderSync", kotlin.g.b.s.X("[fillRedDotArgs] finderCtrlInfoList=", (List)localObject1));
      Log.i("Finder.NetSceneFinderSync", "[fillRedDotArgs] nearbyCtrlInfoList=" + paramc.APt + ".map { long2UnsignedString(it.feedId) }");
    }
    Object localObject1 = new bxe();
    ((bxe)localObject1).selector = paramInt1;
    ((bxe)localObject1).finderUsername = paramString;
    ((bxe)localObject1).aafS = w.aN(paramArrayOfByte);
    paramString = bi.ABn;
    if (paramc == null)
    {
      paramString = null;
      ((bxe)localObject1).CJv = bi.a(paramString);
      paramString = ((bxe)localObject1).CJv;
      if (paramString != null) {}
      switch (paramInt2)
      {
      default: 
        if (paramInt2 >= 10000)
        {
          i = paramInt2;
          label1292:
          paramString.scene = i;
          if (paramc != null) {
            break label1901;
          }
          paramString = null;
          label1305:
          ((bxe)localObject1).aafU = paramString;
          if (paramc != null) {
            break label1910;
          }
          paramString = null;
          label1318:
          ((bxe)localObject1).aafT = paramString;
          if (paramc != null) {
            break label1919;
          }
          paramString = null;
          label1331:
          ((bxe)localObject1).aafW = paramString;
          if (paramc != null) {
            break label1928;
          }
        }
        break;
      }
    }
    label1928:
    for (paramString = null;; paramString = paramc.APt)
    {
      ((bxe)localObject1).aafV = paramString;
      paramString = k.aeZF;
      ((bxe)localObject1).aafX = ((com.tencent.mm.plugin.finder.viewmodel.d)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).GKq;
      paramString = new bww();
      paramArrayOfByte = av.GiL;
      paramArrayOfByte = at.GiI;
      i = at.getScreenWidth();
      paramArrayOfByte = MMApplicationContext.getResources();
      paramc = paramArrayOfByte.getString(am.g.find_friends_by_finder);
      kotlin.g.b.s.s(paramc, "resources.getString(com.…g.find_friends_by_finder)");
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setTextSize(av.Ua(e.c.BodyTextSize));
      float f1 = ((TextPaint)localObject2).measureText(paramc);
      float f2 = i - f1 - paramArrayOfByte.getDimension(am.b.Edge_16A);
      float f3 = av.ffQ();
      i = (int)(f2 / f3);
      Log.i(av.TAG, "measureSingleLineMaxWords maxWords:" + i + " titleWidth:" + f1 + " wordWith:" + f3 + " availableWidth:" + f2);
      Log.i("Finder.NetSceneFinderSync", kotlin.g.b.s.X("count2: ", Integer.valueOf(i)));
      paramString.aafL = (i * 2);
      paramString.aafM = i;
      paramArrayOfByte = ah.aiuX;
      ((bxe)localObject1).aagb = paramString;
      paramString = new bwx();
      paramString.aafN = ((com.tencent.mm.plugin.ai.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ai.a.a.class)).bZI();
      paramArrayOfByte = ah.aiuX;
      ((bxe)localObject1).aagc = paramString;
      ((bxe)localObject1).aafY = ((com.tencent.mm.plugin.ai.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ai.a.a.class)).bZJ();
      paramString = new bxf();
      paramString.setBaseResponse(new kd());
      locala.otE = ((com.tencent.mm.bx.a)localObject1);
      locala.otF = ((com.tencent.mm.bx.a)paramString);
      paramString = locala.bEF();
      kotlin.g.b.s.s(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = new StringBuilder("NetSceneFinderSync init selector=").append(paramInt1).append(" scene=").append(paramInt2).append(" ctrlInfo type=");
      paramArrayOfByte = ((bxe)localObject1).aafT;
      kotlin.g.b.s.s(paramArrayOfByte, "request.ctrlInfoList");
      paramc = (Iterable)paramArrayOfByte;
      paramArrayOfByte = (Collection)new ArrayList(kotlin.a.p.a(paramc, 10));
      paramc = paramc.iterator();
      while (paramc.hasNext()) {
        paramArrayOfByte.add(((btw)paramc.next()).ZYN);
      }
      paramString = paramc.Auc;
      break;
      i = 3;
      break label1292;
      i = 1;
      break label1292;
      i = 2;
      break label1292;
      i = 4;
      break label1292;
      i = 5;
      break label1292;
      i = 6;
      break label1292;
      i = 7;
      break label1292;
      i = 8;
      break label1292;
      i = 9;
      break label1292;
      paramString = new RuntimeException("unknown this localScene(" + paramInt2 + ')');
      AppMethodBeat.o(336909);
      throw paramString;
      label1901:
      paramString = paramc.APq;
      break label1305;
      label1910:
      paramString = paramc.APr;
      break label1318;
      label1919:
      paramString = paramc.APs;
      break label1331;
    }
    paramArrayOfByte = paramString.append((List)paramArrayOfByte).append(" entranceTipsId=").append(((bxe)localObject1).aafU).append(" stay_display_tab_type=").append(((bxe)localObject1).aafX).append(" request.client_ai_info=");
    paramString = ((bxe)localObject1).aafY;
    if (paramString == null) {}
    for (paramString = null;; paramString = Integer.valueOf(paramString.length()))
    {
      paramString = paramArrayOfByte.append(paramString).append(" hasDiscoveryRedDot = ");
      paramArrayOfByte = ((bxe)localObject1).aagc;
      kotlin.g.b.s.checkNotNull(paramArrayOfByte);
      Log.i("Finder.NetSceneFinderSync", paramArrayOfByte.aafN);
      AppMethodBeat.o(336909);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336931);
    Log.i("Finder.NetSceneFinderSync", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(336931);
      throw paramString;
    }
    params = com.tencent.mm.am.c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(336931);
      throw paramString;
    }
    params = (bxf)params;
    if (paramInt2 >= 4) {
      this.AAa = b.Hdd;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 11L, 1L, false);
      params = params.aage;
      if (params != null)
      {
        Log.i("Finder.NetSceneFinderSync", kotlin.g.b.s.X("[onGYNetEnd] check_expire_info=", do.a(params)));
        if (params.ZES == 1) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.addh, Util.encodeHexString(params.toByteArray()));
        }
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(336931);
      return;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 12L, 1L, false);
    }
  }
  
  public final int dVZ()
  {
    AppMethodBeat.i(165273);
    Object localObject = com.tencent.mm.am.c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165273);
      throw ((Throwable)localObject);
    }
    int i = ((bxf)localObject).continueFlag;
    AppMethodBeat.o(165273);
    return i;
  }
  
  public final b dVi()
  {
    return this.AAa;
  }
  
  public final int dWw()
  {
    AppMethodBeat.i(165274);
    Object localObject = com.tencent.mm.am.c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165274);
      throw ((Throwable)localObject);
    }
    int i = ((bxf)localObject).aabV;
    AppMethodBeat.o(165274);
    return i;
  }
  
  public final List<auw> dWx()
  {
    AppMethodBeat.i(165275);
    Object localObject = com.tencent.mm.am.c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
      AppMethodBeat.o(165275);
      throw ((Throwable)localObject);
    }
    localObject = ((bxf)localObject).zMR;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as FinderSyncResponse).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165275);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165271);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165271);
    return i;
  }
  
  public final int getType()
  {
    return 3565;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dn
 * JD-Core Version:    0.7.0.1
 */