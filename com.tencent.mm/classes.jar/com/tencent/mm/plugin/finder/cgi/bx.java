package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.byp.PluginByp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "checkNeedUpdateUserNameVer", "", "old", "", "", "new", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isEnableReport", "isFetchFeedCgi", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bx
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderInit";
  private static int xdn;
  public static final a xdo;
  private com.tencent.mm.an.i callback;
  private com.tencent.mm.plugin.findersdk.b.a.b xbn;
  private final JSONObject xbw;
  private com.tencent.mm.an.d xdl;
  public awg xdm;
  
  static
  {
    AppMethodBeat.i(284999);
    xdo = new a((byte)0);
    xdn = -4004;
    TAG = "Finder.NetSceneFinderInit";
    AppMethodBeat.o(284999);
  }
  
  public bx()
  {
    AppMethodBeat.i(165243);
    Log.i(TAG, "NetSceneFinderInit");
    Object localObject1 = new com.tencent.mm.an.d.a();
    awf localawf = new awf();
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.Vzq, "");
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localawf.SfI = com.tencent.mm.platformtools.z.aN(Util.decodeHexString((String)localObject2));
    localObject2 = ao.xcj;
    localawf.yjp = ao.dnO();
    ((com.tencent.mm.an.d.a)localObject1).vD(getType());
    ((com.tencent.mm.an.d.a)localObject1).TW("/cgi-bin/micromsg-bin/finderinit");
    ((com.tencent.mm.an.d.a)localObject1).c((com.tencent.mm.cd.a)localawf);
    ((com.tencent.mm.an.d.a)localObject1).d((com.tencent.mm.cd.a)new awg());
    this.xdl = ((com.tencent.mm.an.d.a)localObject1).bgN();
    com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 23L, 1L);
    this.xbw = new JSONObject();
    this.xbn = com.tencent.mm.plugin.findersdk.b.a.b.BvV;
    AppMethodBeat.o(165243);
  }
  
  private static void o(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(284998);
    p.k(paramList1, "old");
    p.k(paramList2, "new");
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.Vzd, -1);
    Log.i(TAG, "finderNameListChanged: oldFinderNameList :" + Util.listToString(paramList1, ",") + " , newFinderNameList:" + Util.listToString(paramList2, ",") + ",oldVer:" + i);
    if (!paramList2.containsAll((Collection)paramList1))
    {
      paramList1 = com.tencent.mm.kernel.h.aHG();
      p.j(paramList1, "MMKernel.storage()");
      paramList1.aHp().set(ar.a.Vzd, Integer.valueOf(i + 1));
    }
    AppMethodBeat.o(284998);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(284997);
    Object localObject1 = TAG;
    Object localObject4 = new StringBuilder("errType ").append(paramInt2).append(", errCode ").append(paramInt3).append(", errMsg ").append(paramString).append(" username=");
    params = this.xdm;
    label155:
    awg localawg;
    if (params != null)
    {
      params = params.SIy;
      if (params != null)
      {
        params = (FinderContact)j.lp((List)params);
        if (params != null)
        {
          params = params.username;
          Log.i((String)localObject1, params);
          if (paramInt2 >= 4) {
            this.xbn = com.tencent.mm.plugin.findersdk.b.a.b.BvT;
          }
          if ((paramInt2 != 0) || (paramInt3 != 0)) {
            break label3406;
          }
          params = this.xdl;
          if (params == null) {
            break label624;
          }
          params = params.bhY();
          localObject1 = params;
          if (!(params instanceof awg)) {
            localObject1 = null;
          }
          this.xdm = ((awg)localObject1);
          localawg = this.xdm;
          if (localawg == null) {
            break label3272;
          }
          if (localawg != null)
          {
            params = localawg.SIC;
            if (params != null)
            {
              Log.i(TAG, "wx_user_attr,flag = " + params.UHs);
              localObject1 = com.tencent.mm.kernel.h.aHG();
              p.j(localObject1, "MMKernel.storage()");
              localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp();
              localObject4 = ar.a.Vzr;
              if (params.UHs != 1) {
                break label630;
              }
            }
          }
        }
      }
    }
    List localList;
    LinkedList localLinkedList;
    label624:
    label630:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.storage.ao)localObject1).set((ar.a)localObject4, Boolean.valueOf(bool));
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vzt, params.wording);
      params = x.aazN;
      params = localawg.SIG;
      if (params != null)
      {
        Log.i(TAG, "teenmode_tips_config：" + params.SVn + ", " + params.SVm + ", " + params.SVo);
        this.xbw.put("tips_durian", params.SVn);
        this.xbw.put("tips_location", params.SVo);
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VEj, params.SVm);
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VEk, Long.valueOf(params.SVn));
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VEl, Integer.valueOf(params.SVo));
        params = x.aazN;
      }
      params = com.tencent.mm.plugin.finder.api.d.wZQ;
      localList = com.tencent.mm.plugin.finder.api.d.a.dnk();
      params = com.tencent.mm.plugin.finder.api.d.wZQ;
      com.tencent.mm.plugin.finder.api.d.a.dV((List)localawg.SIH);
      localLinkedList = localawg.SIH;
      this.xbw.put("user_not_created_flag", localawg.SIB);
      if (localawg.SIB <= 0) {
        break label765;
      }
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params = params.aHp().get(ar.a.VxX, "");
      if (params != null) {
        break label636;
      }
      paramString = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(284997);
      throw paramString;
      params = null;
      break;
      params = null;
      break label155;
    }
    label636:
    params = (String)params;
    Log.w(TAG, "user_not_created_flag=" + localawg.SIB + " clear local self finder username. currentFinderUsername=" + params + ' ');
    p.j(localLinkedList, "newFinderNameList");
    o(localList, (List)localLinkedList);
    params = aj.AGc;
    aj.aFS("user_not_created_flag");
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      paramString = x.aazN;
    }
    ((PluginByp)com.tencent.mm.kernel.h.ag(PluginByp.class)).mergeSelectorAndDoScene();
    AppMethodBeat.o(284997);
    return;
    label765:
    params = this.xdm;
    if (params != null)
    {
      params = params.SIy;
      if (params == null) {
        break label2542;
      }
      if (((Collection)params).isEmpty()) {
        break label1062;
      }
      paramInt1 = 1;
      label803:
      if (paramInt1 == 0) {
        break label1067;
      }
      localObject1 = params;
    }
    label1062:
    label1067:
    Object localObject5;
    label1352:
    label1358:
    Object localObject3;
    for (;;)
    {
      if (localObject1 != null)
      {
        if (!Util.isNullOrNil(((FinderContact)params.get(0)).username))
        {
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VxX, ((FinderContact)params.get(0)).username);
          localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
          localObject1 = params.get(0);
          p.j(localObject1, "self[0]");
          com.tencent.mm.plugin.finder.api.d.a.a((FinderContact)localObject1);
          localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension();
          localObject4 = this.xdm;
          if (localObject4 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.finder.api.g)localObject1).gu(((awg)localObject4).continueFlag, 5);
          this.xbw.put("username", ((FinderContact)params.get(0)).username);
          this.xbw.put("nickname", ((FinderContact)params.get(0)).nickname);
          this.xbw.put("headUrl", ((FinderContact)params.get(0)).headUrl);
          localObject1 = this.xdl;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((com.tencent.mm.an.d)localObject1).bhY();
          if (localObject1 == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderInitResponse");
            AppMethodBeat.o(284997);
            throw paramString;
            params = null;
            break;
            paramInt1 = 0;
            break label803;
            localObject1 = null;
            continue;
          }
          localObject1 = ((awg)localObject1).wqP;
          if (localObject1 != null)
          {
            localObject5 = ((Iterable)localObject1).iterator();
            for (;;)
            {
              if (((Iterator)localObject5).hasNext())
              {
                localObject1 = (aqt)((Iterator)localObject5).next();
                p.j(localObject1, "it");
                Object localObject6;
                Object localObject7;
                switch (((aqt)localObject1).cmdId)
                {
                default: 
                  break;
                case 105: 
                  localObject4 = (com.tencent.mm.cd.a)new ata();
                  localObject1 = ((aqt)localObject1).SDX;
                  if (localObject1 != null) {}
                  for (localObject1 = ((com.tencent.mm.cd.b)localObject1).toByteArray();; localObject1 = null)
                  {
                    try
                    {
                      ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
                      localObject1 = localObject4;
                    }
                    catch (Exception localException1)
                    {
                      for (;;)
                      {
                        Log.printDebugStack("safeParser", "", new Object[] { localException1 });
                        localObject2 = null;
                        continue;
                        localObject2 = null;
                        continue;
                        localObject2 = null;
                      }
                    }
                    localObject4 = (ata)localObject1;
                    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
                    if (com.tencent.mm.plugin.finder.api.d.a.aAK(com.tencent.mm.model.z.bdh()) == null) {
                      break;
                    }
                    localObject6 = TAG;
                    localObject7 = new StringBuilder("save follow count ");
                    if (localObject4 == null) {
                      break label1352;
                    }
                    localObject1 = Integer.valueOf(((ata)localObject4).SEt);
                    Log.i((String)localObject6, localObject1);
                    localObject1 = com.tencent.mm.kernel.h.aHG();
                    p.j(localObject1, "MMKernel.storage()");
                    localObject6 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                    localObject7 = ar.a.VAv;
                    if (localObject4 == null) {
                      break label1358;
                    }
                    localObject1 = Integer.valueOf(((ata)localObject4).SEt);
                    ((com.tencent.mm.storage.ao)localObject6).set((ar.a)localObject7, localObject1);
                    break;
                  }
                case 106: 
                  localObject4 = (com.tencent.mm.cd.a)new aso();
                  Object localObject2 = ((aqt)localObject2).SDX;
                  if (localObject2 != null) {}
                  for (localObject2 = ((com.tencent.mm.cd.b)localObject2).toByteArray();; localObject2 = null)
                  {
                    try
                    {
                      ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject2);
                      localObject2 = localObject4;
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        Log.printDebugStack("safeParser", "", new Object[] { localException2 });
                        localObject3 = null;
                        continue;
                        localObject3 = null;
                        continue;
                        localObject3 = null;
                      }
                    }
                    localObject4 = (aso)localObject2;
                    localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
                    if (com.tencent.mm.plugin.finder.api.d.a.aAK(com.tencent.mm.model.z.bdh()) == null) {
                      break;
                    }
                    localObject6 = TAG;
                    localObject7 = new StringBuilder("save fans count ");
                    if (localObject4 == null) {
                      break label1557;
                    }
                    localObject2 = Integer.valueOf(((aso)localObject4).fans_count);
                    Log.i((String)localObject6, localObject2);
                    localObject2 = com.tencent.mm.kernel.h.aHG();
                    p.j(localObject2, "MMKernel.storage()");
                    localObject6 = ((com.tencent.mm.kernel.f)localObject2).aHp();
                    localObject7 = ar.a.VAx;
                    if (localObject4 == null) {
                      break label1563;
                    }
                    localObject2 = Integer.valueOf(((aso)localObject4).fans_count);
                    ((com.tencent.mm.storage.ao)localObject6).set((ar.a)localObject7, localObject2);
                    break;
                  }
                }
              }
            }
            label1557:
            label1563:
            localObject3 = x.aazN;
          }
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          localObject3 = ((com.tencent.mm.kernel.f)localObject3).aHp();
          localObject4 = ar.a.Vzq;
          localObject5 = this.xdm;
          if (localObject5 == null) {
            p.iCn();
          }
          ((com.tencent.mm.storage.ao)localObject3).set((ar.a)localObject4, Util.encodeHexString(com.tencent.mm.platformtools.z.a(((awg)localObject5).SfI)));
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VxY, ((FinderContact)params.get(0)).nickname);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VxZ, ((FinderContact)params.get(0)).signature);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vya, ((FinderContact)params.get(0)).headUrl);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vzn, Integer.valueOf(((FinderContact)params.get(0)).extFlag));
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vyl, Integer.valueOf(((FinderContact)params.get(0)).originalFlag));
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vyq, Integer.valueOf(((FinderContact)params.get(0)).originalEntranceFlag));
          if (((FinderContact)params.get(0)).originalInfo != null)
          {
            localObject3 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject3, "MMKernel.storage()");
            localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
            localObject5 = ar.a.Vym;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 == null) {
              break label2669;
            }
            localObject3 = Integer.valueOf(((bgi)localObject3).SRe);
            ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
            localObject3 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject3, "MMKernel.storage()");
            localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
            localObject5 = ar.a.Vyn;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 == null) {
              break label2675;
            }
            localObject3 = Integer.valueOf(((bgi)localObject3).SRf);
            label1979:
            ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
            localObject3 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject3, "MMKernel.storage()");
            localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
            localObject5 = ar.a.Vyo;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 == null) {
              break label2681;
            }
            localObject3 = Integer.valueOf(((bgi)localObject3).SRg);
            label2041:
            ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
            localObject3 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject3, "MMKernel.storage()");
            localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
            localObject5 = ar.a.Vyp;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 == null) {
              break label2687;
            }
            localObject3 = Integer.valueOf(((bgi)localObject3).SRh);
            label2103:
            ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
            localObject3 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject3, "MMKernel.storage()");
            localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
            localObject5 = ar.a.Vys;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 == null) {
              break label2693;
            }
            localObject3 = Integer.valueOf(((bgi)localObject3).SRi);
            label2165:
            ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
          }
          if (((FinderContact)params.get(0)).authInfo != null) {
            break label2699;
          }
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vyb, "");
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VyI, ((FinderContact)params.get(0)).liveCoverImgUrl);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
          localObject5 = ar.a.VyJ;
          localObject3 = ((FinderContact)params.get(0)).live_info;
          if (localObject3 == null) {
            break label2770;
          }
          localObject3 = Long.valueOf(((arf)localObject3).SEj);
          label2302:
          ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
          localObject5 = ar.a.VyK;
          localObject3 = ((FinderContact)params.get(0)).live_info;
          if (localObject3 == null) {
            break label2779;
          }
          localObject3 = Long.valueOf(((arf)localObject3).SEk);
          label2365:
          ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
          localObject5 = ar.a.VyQ;
          localObject3 = ((FinderContact)params.get(0)).live_info;
          if (localObject3 == null) {
            break label2788;
          }
          localObject3 = ((arf)localObject3).SEm;
          if (localObject3 == null) {
            break label2788;
          }
          localObject3 = Long.valueOf(((cxh)localObject3).TFP);
          label2439:
          ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject3, "MMKernel.storage()");
          localObject3 = ((com.tencent.mm.kernel.f)localObject3).aHp();
          localObject4 = ar.a.VyL;
          params = ((FinderContact)params.get(0)).live_info;
          if (params == null) {
            break label2797;
          }
          params = params.SEm;
          if (params == null) {
            break label2797;
          }
          params = Long.valueOf(params.TFQ);
          label2513:
          ((com.tencent.mm.storage.ao)localObject3).set((ar.a)localObject4, params);
          com.tencent.e.h.ZvG.bg((Runnable)b.xdp);
        }
        params = x.aazN;
      }
    }
    label2542:
    params = localawg.SIz;
    p.j(params, "it.tabInfos");
    params = ((Iterable)params).iterator();
    for (;;)
    {
      if (!params.hasNext()) {
        break label2886;
      }
      localObject3 = (bkd)params.next();
      Log.i(TAG, ((bkd)localObject3).tab_type + " => " + ((bkd)localObject3).SOb);
      if (((bkd)localObject3).tab_type == 4)
      {
        localObject4 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject4, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject4).aHp().set(ar.a.VzI, ((bkd)localObject3).SOb);
        continue;
        label2669:
        localObject3 = null;
        break;
        label2675:
        localObject3 = null;
        break label1979;
        label2681:
        localObject3 = null;
        break label2041;
        label2687:
        localObject3 = null;
        break label2103;
        label2693:
        localObject3 = null;
        break label2165;
        label2699:
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        localObject4 = ((com.tencent.mm.kernel.f)localObject3).aHp();
        localObject5 = ar.a.Vyb;
        localObject3 = ((FinderContact)params.get(0)).authInfo;
        if (localObject3 != null) {}
        for (localObject3 = ((FinderAuthInfo)localObject3).toByteArray();; localObject3 = null)
        {
          ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, Util.encodeHexString((byte[])localObject3));
          break;
        }
        label2770:
        localObject3 = Long.valueOf(0L);
        break label2302;
        label2779:
        localObject3 = Long.valueOf(0L);
        break label2365;
        label2788:
        localObject3 = Long.valueOf(0L);
        break label2439;
        label2797:
        params = Long.valueOf(0L);
        break label2513;
      }
      if (((bkd)localObject3).tab_type == 3)
      {
        localObject4 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject4, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject4).aHp().set(ar.a.VzJ, ((bkd)localObject3).SOb);
      }
      else if (((bkd)localObject3).tab_type == 1)
      {
        localObject4 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject4, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject4).aHp().set(ar.a.VzH, ((bkd)localObject3).SOb);
      }
    }
    label2886:
    params = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.aq(localawg.SID);
    this.xbw.put("current_alias_role_type", localawg.SIE);
    this.xbw.put("next_alias_mod_available_time", localawg.SIF);
    paramInt1 = localawg.SIE;
    Log.i(TAG, "current_alias_role_type：".concat(String.valueOf(paramInt1)));
    params = com.tencent.mm.kernel.h.aHG();
    p.j(params, "MMKernel.storage()");
    params.aHp().set(ar.a.VyS, Integer.valueOf(paramInt1));
    long l = localawg.SIF;
    Log.i(TAG, "next_alias_mod_available_time：".concat(String.valueOf(l)));
    params = com.tencent.mm.kernel.h.aHG();
    p.j(params, "MMKernel.storage()");
    params.aHp().set(ar.a.VyW, Long.valueOf(l));
    params = localawg.SID;
    if (params != null)
    {
      localObject3 = ((Iterable)params).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        params = ((Iterator)localObject3).next();
        if (((axc)params).SJy == 2)
        {
          paramInt1 = 1;
          label3089:
          if (paramInt1 == 0) {
            break label3313;
          }
          label3093:
          params = (axc)params;
          if (params == null) {
            break label3321;
          }
          localObject3 = aj.AGc;
          aj.a(params, Boolean.TRUE, "NetSceneFinderInit");
          params = x.aazN;
          params = com.tencent.mm.plugin.finder.api.d.wZQ;
          localObject3 = new ArrayList((Collection)com.tencent.mm.plugin.finder.api.d.a.dnk());
          params = com.tencent.mm.model.z.bdh();
          p.j(params, "myFinderUserName");
          if (((CharSequence)params).length() <= 0) {
            break label3390;
          }
          paramInt1 = 1;
          label3173:
          if ((paramInt1 == 0) || (((ArrayList)localObject3).contains(params))) {
            break label3395;
          }
          paramInt1 = 1;
          label3189:
          if (paramInt1 == 0) {
            break label3400;
          }
          label3193:
          if (params != null)
          {
            ((ArrayList)localObject3).add(params);
            params = com.tencent.mm.plugin.finder.api.d.wZQ;
            com.tencent.mm.plugin.finder.api.d.a.dV((List)localObject3);
            params = x.aazN;
          }
          this.xbw.put("finderUserNameList", localObject3);
          p.j(localLinkedList, "newFinderNameList");
          o(localList, (List)localLinkedList);
          ((PluginByp)com.tencent.mm.kernel.h.ag(PluginByp.class)).mergeSelectorAndDoScene();
          params = x.aazN;
        }
      }
    }
    for (;;)
    {
      label3272:
      params = this.callback;
      if (params == null) {
        break label3710;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      paramString = x.aazN;
      AppMethodBeat.o(284997);
      return;
      paramInt1 = 0;
      break label3089;
      label3313:
      break;
      params = null;
      break label3093;
      label3321:
      params = ((bx)this).xdm;
      if (params != null)
      {
        params = params.SID;
        if (params != null) {
          if (((Collection)params).isEmpty()) {
            break label3385;
          }
        }
      }
      label3385:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 1)
        {
          params = aj.AGc;
          aj.aFT("NetSceneFinderInit");
        }
        params = x.aazN;
        break;
      }
      label3390:
      paramInt1 = 0;
      break label3173;
      label3395:
      paramInt1 = 0;
      break label3189;
      label3400:
      params = null;
      break label3193;
      label3406:
      if ((paramInt2 != 4) || (paramInt3 != xdn)) {
        break label3543;
      }
      params = com.tencent.mm.kernel.h.aHG();
      p.j(params, "MMKernel.storage()");
      params = params.aHp().get(ar.a.VxX, "");
      if (params == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(284997);
        throw paramString;
      }
      params = (String)params;
      Log.w(TAG, "errCode=" + paramInt3 + " clear local self finder username. currentFinderUsername=" + params + ' ');
      params = aj.AGc;
      aj.aFS("MMFinder_FinderInit_Err_User_NotCreated");
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 26L, 1L);
    }
    label3543:
    params = this.xdl;
    if (params != null)
    {
      params = params.bhY();
      label3561:
      localObject3 = params;
      if (!(params instanceof awg)) {
        localObject3 = null;
      }
      this.xdm = ((awg)localObject3);
      params = this.xdm;
      if (params != null)
      {
        params = Integer.valueOf(params.SIJ);
        if (((Number)params).intValue() <= 0) {
          break label3699;
        }
        paramInt1 = 1;
        label3619:
        if (paramInt1 == 0) {
          break label3704;
        }
      }
    }
    for (;;)
    {
      if (params != null)
      {
        paramInt1 = ((Number)params).intValue();
        if (com.tencent.e.h.ZvG.q((Runnable)c.xdq, paramInt1 * 1000L) != null) {}
      }
      else
      {
        ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).resetLastFinderInitTime();
        params = x.aazN;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 24L, 1L);
      break;
      params = null;
      break label3561;
      label3699:
      paramInt1 = 0;
      break label3619;
      label3704:
      params = null;
    }
    label3710:
    AppMethodBeat.o(284997);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return this.xbn;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(165241);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.xdl, (m)this);
    AppMethodBeat.o(165241);
    return i;
  }
  
  public final int getType()
  {
    return 3930;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit$Companion;", "", "()V", "MMFinder_FinderInit_Err_User_NotCreated", "", "getMMFinder_FinderInit_Err_User_NotCreated", "()I", "setMMFinder_FinderInit_Err_User_NotCreated", "(I)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b xdp;
    
    static
    {
      AppMethodBeat.i(271199);
      xdp = new b();
      AppMethodBeat.o(271199);
    }
    
    public final void run()
    {
      AppMethodBeat.i(271198);
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager();
      com.tencent.mm.plugin.finder.extension.reddot.f.dqL();
      AppMethodBeat.o(271198);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c xdq;
    
    static
    {
      AppMethodBeat.i(286119);
      xdq = new c();
      AppMethodBeat.o(286119);
    }
    
    public final void run()
    {
      AppMethodBeat.i(286118);
      com.tencent.mm.kernel.h.aGY().b((q)new bx());
      AppMethodBeat.o(286118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bx
 * JD-Core Version:    0.7.0.1
 */