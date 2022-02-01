package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.byp.PluginByp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.gdx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "checkNeedUpdateUserNameVer", "", "old", "", "", "new", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isEnableReport", "isFetchFeedCgi", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cv
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final cv.a ACI;
  private static int ACL;
  private static final String TAG;
  private com.tencent.mm.plugin.findersdk.b.a.b AAa;
  private final JSONObject AAn;
  private com.tencent.mm.am.c ACJ;
  public bbx ACK;
  private com.tencent.mm.am.h callback;
  
  static
  {
    AppMethodBeat.i(336643);
    ACI = new cv.a((byte)0);
    ACL = -4004;
    TAG = "Finder.NetSceneFinderInit";
    AppMethodBeat.o(336643);
  }
  
  public cv()
  {
    AppMethodBeat.i(165243);
    Log.i(TAG, "NetSceneFinderInit");
    Object localObject1 = new c.a();
    bbw localbbw = new bbw();
    Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adbv, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localbbw.ZdD = w.aN(Util.decodeHexString((String)localObject2));
    localObject2 = bi.ABn;
    localbbw.CJv = bi.dVu();
    ((c.a)localObject1).funcId = getType();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderinit";
    ((c.a)localObject1).otE = ((a)localbbw);
    ((c.a)localObject1).otF = ((a)new bbx());
    this.ACJ = ((c.a)localObject1).bEF();
    com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 23L, 1L);
    this.AAn = new JSONObject();
    this.AAa = com.tencent.mm.plugin.findersdk.b.a.b.Hdf;
    AppMethodBeat.o(165243);
  }
  
  private static final void dWl()
  {
    AppMethodBeat.i(336633);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    com.tencent.mm.plugin.finder.extension.reddot.i.dZw();
    AppMethodBeat.o(336633);
  }
  
  private static final void dWm()
  {
    AppMethodBeat.i(336637);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new cv(), 0);
    AppMethodBeat.o(336637);
  }
  
  private static void u(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(336631);
    kotlin.g.b.s.u(paramList1, "old");
    kotlin.g.b.s.u(paramList2, "new");
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbe, -1);
    Log.i(TAG, "finderNameListChanged: oldFinderNameList :" + Util.listToString(paramList1, ",") + " , newFinderNameList:" + Util.listToString(paramList2, ",") + ",oldVer:" + i);
    if (!paramList2.containsAll((Collection)paramList1)) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbe, Integer.valueOf(i + 1));
    }
    AppMethodBeat.o(336631);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336717);
    Object localObject1 = TAG;
    Object localObject4 = new StringBuilder("errType ").append(paramInt2).append(", errCode ").append(paramInt3).append(", errMsg ").append(paramString).append(" username=");
    params = this.ACK;
    label117:
    bbx localbbx;
    if (params == null)
    {
      params = null;
      Log.i((String)localObject1, params);
      if (paramInt2 >= 4) {
        this.AAa = com.tencent.mm.plugin.findersdk.b.a.b.Hdd;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label3875;
      }
      params = this.ACJ;
      if (params != null) {
        break label1231;
      }
      params = null;
      if (!(params instanceof bbx)) {
        break label1244;
      }
      params = (bbx)params;
      label132:
      this.ACK = params;
      localbbx = this.ACK;
      if (localbbx == null) {
        break label3700;
      }
      params = k.aeZF;
      params = (com.tencent.mm.plugin.finder.viewmodel.c)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.c.class);
      localObject1 = localbbx.ZMD;
      kotlin.g.b.s.s(localObject1, "it.slide_up_guide_config");
      params.bj((LinkedList)localObject1);
      params = localbbx.ZMu;
      if (params != null)
      {
        Log.i(TAG, kotlin.g.b.s.X("wx_user_attr,flag = ", Integer.valueOf(params.acbC)));
        localObject1 = com.tencent.mm.kernel.h.baE().ban();
        localObject4 = at.a.adbw;
        if (params.acbC != 1) {
          break label1250;
        }
      }
    }
    List localList;
    LinkedList localLinkedList;
    label1231:
    label1244:
    label1250:
    for (boolean bool = true;; bool = false)
    {
      ((aq)localObject1).set((at.a)localObject4, Boolean.valueOf(bool));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adby, params.wording);
      params = ah.aiuX;
      params = ah.aiuX;
      params = localbbx.ZMy;
      if (params != null)
      {
        Log.i(TAG, "teenmode_tips_config：" + params.aagk + ", " + params.aagj + ", " + params.aagl + ", " + params.aagm);
        this.AAn.put("tips_durian", params.aagk);
        this.AAn.put("tips_location", params.aagl);
        this.AAn.put("tips_ui_style", params.aagm);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhE, params.aagj);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhF, Long.valueOf(params.aagk));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhG, Integer.valueOf(params.aagl));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhH, Integer.valueOf(params.aagm));
        params = ah.aiuX;
        params = ah.aiuX;
      }
      params = localbbx.ZME;
      if (params != null)
      {
        Log.i(TAG, "wx_personalized_setting：" + params.aait + ", " + params.aais);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhR, Boolean.valueOf(params.aais));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhS, Boolean.valueOf(params.aait));
        params = ah.aiuX;
        params = ah.aiuX;
      }
      params = localbbx.ZMF;
      if (params != null)
      {
        Log.i(TAG, "ringtone_config：" + params.aach + ", " + params.aaci + ", " + params.aacj + ", " + params.aack);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhX, Integer.valueOf(params.aach));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhY, Integer.valueOf(params.aaci));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhZ, Integer.valueOf(params.aacj));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adia, Integer.valueOf(params.aack));
        params = ah.aiuX;
        params = ah.aiuX;
      }
      params = localbbx.ZMG;
      if (params != null)
      {
        Log.i(TAG, "carousel_config：buzz_carousel = " + params.ZHh + '+' + params.ZHi + ", buzz_fav = " + params.ZHj + '+' + params.ZHk + ", hot_comment = " + params.ZHl + '+' + params.ZHm + ", ringtone = " + params.ZHn + '+' + params.ZHo);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhw, Boolean.valueOf(params.ZHh));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhx, Boolean.valueOf(params.ZHj));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhy, Boolean.valueOf(params.ZHl));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhz, Boolean.valueOf(params.ZHn));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhA, Boolean.valueOf(params.ZHi));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhB, Boolean.valueOf(params.ZHk));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhC, Boolean.valueOf(params.ZHm));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhD, Boolean.valueOf(params.ZHo));
        params = ah.aiuX;
        params = ah.aiuX;
      }
      params = d.AwY;
      localList = d.a.dUe();
      params = d.AwY;
      d.a.fS((List)localbbx.ZMz);
      localLinkedList = localbbx.ZMz;
      this.AAn.put("user_not_created_flag", localbbx.ZMt);
      if (localbbx.ZMt <= 0) {
        break label1390;
      }
      params = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZR, "");
      if (params != null) {
        break label1256;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(336717);
      throw paramString;
      params = params.ZMq;
      if (params == null)
      {
        params = null;
        break;
      }
      params = (FinderContact)kotlin.a.p.oL((List)params);
      if (params == null)
      {
        params = null;
        break;
      }
      params = params.username;
      break;
      params = c.c.b(params.otC);
      break label117;
      params = null;
      break label132;
    }
    label1256:
    params = (String)params;
    Log.w(TAG, "user_not_created_flag=" + localbbx.ZMt + " clear local self finder username. currentFinderUsername=" + params + ' ');
    kotlin.g.b.s.s(localLinkedList, "newFinderNameList");
    u(localList, (List)localLinkedList);
    params = av.GiL;
    av.aBR("user_not_created_flag");
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      paramString = ah.aiuX;
      paramString = ah.aiuX;
    }
    ((PluginByp)com.tencent.mm.kernel.h.az(PluginByp.class)).mergeSelectorAndDoScene();
    AppMethodBeat.o(336717);
    return;
    label1390:
    params = this.ACK;
    if (params == null)
    {
      params = null;
      if (params == null) {
        break label2950;
      }
      if (((Collection)params).isEmpty()) {
        break label1672;
      }
      paramInt1 = 1;
      label1424:
      if (paramInt1 == 0) {
        break label1677;
      }
      localObject1 = params;
    }
    label1672:
    label1677:
    Object localObject5;
    label1925:
    label1938:
    Object localObject3;
    for (;;)
    {
      if (localObject1 != null)
      {
        if (!Util.isNullOrNil(((FinderContact)params.get(0)).username))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZR, ((FinderContact)params.get(0)).username);
          localObject1 = d.AwY;
          localObject1 = params.get(0);
          kotlin.g.b.s.s(localObject1, "self[0]");
          d.a.d((FinderContact)localObject1);
          localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension();
          localObject4 = this.ACK;
          kotlin.g.b.s.checkNotNull(localObject4);
          ((j)localObject1).ho(((bbx)localObject4).continueFlag, 5);
          this.AAn.put("username", ((FinderContact)params.get(0)).username);
          this.AAn.put("nickname", ((FinderContact)params.get(0)).nickname);
          this.AAn.put("headUrl", ((FinderContact)params.get(0)).headUrl);
          localObject1 = this.ACJ;
          kotlin.g.b.s.checkNotNull(localObject1);
          localObject1 = c.c.b(((com.tencent.mm.am.c)localObject1).otC);
          if (localObject1 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderInitResponse");
            AppMethodBeat.o(336717);
            throw paramString;
            params = params.ZMq;
            break;
            paramInt1 = 0;
            break label1424;
            localObject1 = null;
            continue;
          }
          localObject1 = ((bbx)localObject1).zMR;
          if (localObject1 != null)
          {
            localObject5 = ((Iterable)localObject1).iterator();
            for (;;)
            {
              if (((Iterator)localObject5).hasNext())
              {
                localObject1 = (auw)((Iterator)localObject5).next();
                kotlin.g.b.s.s(localObject1, "it");
                Object localObject6;
                at.a locala;
                switch (((auw)localObject1).cmdId)
                {
                default: 
                  break;
                case 105: 
                  localObject4 = (a)new axo();
                  localObject1 = ((auw)localObject1).ZFn;
                  if (localObject1 == null) {}
                  for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray())
                  {
                    try
                    {
                      ((a)localObject4).parseFrom((byte[])localObject1);
                      localObject1 = localObject4;
                    }
                    catch (Exception localException1)
                    {
                      for (;;)
                      {
                        Log.printDebugStack("safeParser", "", new Object[] { localException1 });
                        localObject2 = null;
                        continue;
                        localObject2 = Integer.valueOf(((axo)localObject4).ZFT);
                        continue;
                        localObject2 = Integer.valueOf(((axo)localObject4).ZFT);
                      }
                    }
                    localObject4 = (axo)localObject1;
                    localObject1 = d.AwY;
                    if (d.a.auT(z.bAW()) == null) {
                      break;
                    }
                    localObject6 = TAG;
                    if (localObject4 != null) {
                      break label1925;
                    }
                    localObject1 = null;
                    Log.i((String)localObject6, kotlin.g.b.s.X("save follow count ", localObject1));
                    localObject6 = com.tencent.mm.kernel.h.baE().ban();
                    locala = at.a.adcN;
                    if (localObject4 != null) {
                      break label1938;
                    }
                    localObject1 = null;
                    ((aq)localObject6).set(locala, localObject1);
                    break;
                  }
                case 106: 
                  localObject4 = (a)new axd();
                  Object localObject2 = ((auw)localObject2).ZFn;
                  if (localObject2 == null) {}
                  for (localObject2 = null;; localObject2 = ((com.tencent.mm.bx.b)localObject2).toByteArray())
                  {
                    try
                    {
                      ((a)localObject4).parseFrom((byte[])localObject2);
                      localObject2 = localObject4;
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        Log.printDebugStack("safeParser", "", new Object[] { localException2 });
                        localObject3 = null;
                        continue;
                        localObject3 = Integer.valueOf(((axd)localObject4).fans_count);
                        continue;
                        localObject3 = Integer.valueOf(((axd)localObject4).fans_count);
                      }
                    }
                    localObject4 = (axd)localObject2;
                    localObject2 = d.AwY;
                    if (d.a.auT(z.bAW()) == null) {
                      break;
                    }
                    localObject6 = TAG;
                    if (localObject4 != null) {
                      break label2105;
                    }
                    localObject2 = null;
                    Log.i((String)localObject6, kotlin.g.b.s.X("save fans count ", localObject2));
                    localObject6 = com.tencent.mm.kernel.h.baE().ban();
                    locala = at.a.adcP;
                    if (localObject4 != null) {
                      break label2118;
                    }
                    localObject2 = null;
                    ((aq)localObject6).set(locala, localObject2);
                    break;
                  }
                }
              }
            }
            label2105:
            label2118:
            localObject3 = ah.aiuX;
          }
          localObject3 = com.tencent.mm.kernel.h.baE().ban();
          localObject4 = at.a.adbv;
          localObject5 = this.ACK;
          kotlin.g.b.s.checkNotNull(localObject5);
          ((aq)localObject3).set((at.a)localObject4, Util.encodeHexString(w.a(((bbx)localObject5).ZdD)));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZS, ((FinderContact)params.get(0)).nickname);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZT, ((FinderContact)params.get(0)).signature);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZU, ((FinderContact)params.get(0)).headUrl);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(((FinderContact)params.get(0)).extFlag));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adag, Integer.valueOf(((FinderContact)params.get(0)).originalFlag));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adal, Integer.valueOf(((FinderContact)params.get(0)).originalEntranceFlag));
          if (((FinderContact)params.get(0)).originalInfo != null)
          {
            localObject4 = com.tencent.mm.kernel.h.baE().ban();
            localObject5 = at.a.adah;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 != null) {
              break label3066;
            }
            localObject3 = null;
            ((aq)localObject4).set((at.a)localObject5, localObject3);
            localObject4 = com.tencent.mm.kernel.h.baE().ban();
            localObject5 = at.a.adai;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 != null) {
              break label3079;
            }
            localObject3 = null;
            label2425:
            ((aq)localObject4).set((at.a)localObject5, localObject3);
            localObject4 = com.tencent.mm.kernel.h.baE().ban();
            localObject5 = at.a.adaj;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 != null) {
              break label3092;
            }
            localObject3 = null;
            label2469:
            ((aq)localObject4).set((at.a)localObject5, localObject3);
            localObject4 = com.tencent.mm.kernel.h.baE().ban();
            localObject5 = at.a.adak;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 != null) {
              break label3105;
            }
            localObject3 = null;
            label2513:
            ((aq)localObject4).set((at.a)localObject5, localObject3);
            localObject4 = com.tencent.mm.kernel.h.baE().ban();
            localObject5 = at.a.adan;
            localObject3 = ((FinderContact)params.get(0)).originalInfo;
            if (localObject3 != null) {
              break label3118;
            }
            localObject3 = null;
            label2557:
            ((aq)localObject4).set((at.a)localObject5, localObject3);
          }
          if (((FinderContact)params.get(0)).authInfo != null) {
            break label3131;
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZV, "");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adaE, ((FinderContact)params.get(0)).liveCoverImgUrl);
          localObject3 = com.tencent.mm.kernel.h.baE().ban();
          localObject4 = at.a.adaF;
          localObject5 = ((FinderContact)params.get(0)).live_info;
          if (localObject5 != null) {
            break label3191;
          }
          l = 0L;
          label2654:
          ((aq)localObject3).set((at.a)localObject4, Long.valueOf(l));
          localObject3 = com.tencent.mm.kernel.h.baE().ban();
          localObject4 = at.a.adaG;
          localObject5 = ((FinderContact)params.get(0)).live_info;
          if (localObject5 != null) {
            break label3201;
          }
          l = 0L;
          label2701:
          ((aq)localObject3).set((at.a)localObject4, Long.valueOf(l));
          localObject3 = com.tencent.mm.kernel.h.baE().ban();
          localObject4 = at.a.adaM;
          localObject5 = ((FinderContact)params.get(0)).live_info;
          if (localObject5 != null) {
            break label3212;
          }
          l = 0L;
          label2748:
          ((aq)localObject3).set((at.a)localObject4, Long.valueOf(l));
          localObject3 = com.tencent.mm.kernel.h.baE().ban();
          localObject4 = at.a.adaH;
          localObject5 = ((FinderContact)params.get(0)).live_info;
          if (localObject5 != null) {
            break label3240;
          }
          l = 0L;
          label2795:
          ((aq)localObject3).set((at.a)localObject4, Long.valueOf(l));
          params = ((FinderContact)params.get(0)).live_info;
          if (params != null)
          {
            params = params.ZFL;
            if (params != null)
            {
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adeL, Long.valueOf(params.CJK));
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adeM, Integer.valueOf(params.BBE));
              Log.i(TAG, "lottery_setting:" + params.CJK + ',' + params.BBE);
              params = ah.aiuX;
              params = ah.aiuX;
            }
          }
          com.tencent.threadpool.h.ahAA.bo(cv..ExternalSyntheticLambda1.INSTANCE);
        }
        params = ah.aiuX;
        params = ah.aiuX;
      }
    }
    label2950:
    params = localbbx.ZMr;
    kotlin.g.b.s.s(params, "it.tabInfos");
    params = ((Iterable)params).iterator();
    for (;;)
    {
      if (!params.hasNext()) {
        break label3326;
      }
      localObject3 = (bxg)params.next();
      Log.i(TAG, ((bxg)localObject3).tab_type + " => " + ((bxg)localObject3).ZWa);
      if (((bxg)localObject3).tab_type == 4)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbX, ((bxg)localObject3).ZWa);
        continue;
        label3066:
        localObject3 = Integer.valueOf(((bry)localObject3).ZZW);
        break;
        label3079:
        localObject3 = Integer.valueOf(((bry)localObject3).ZZX);
        break label2425;
        label3092:
        localObject3 = Integer.valueOf(((bry)localObject3).ZZY);
        break label2469;
        label3105:
        localObject3 = Integer.valueOf(((bry)localObject3).ZZZ);
        break label2513;
        label3118:
        localObject3 = Integer.valueOf(((bry)localObject3).aaaa);
        break label2557;
        label3131:
        localObject4 = com.tencent.mm.kernel.h.baE().ban();
        localObject5 = at.a.acZV;
        localObject3 = ((FinderContact)params.get(0)).authInfo;
        if (localObject3 == null) {}
        for (localObject3 = null;; localObject3 = ((FinderAuthInfo)localObject3).toByteArray())
        {
          ((aq)localObject4).set((at.a)localObject5, Util.encodeHexString((byte[])localObject3));
          break;
        }
        label3191:
        l = ((avn)localObject5).ZFH;
        break label2654;
        label3201:
        l = ((avn)localObject5).ZFI;
        break label2701;
        label3212:
        localObject5 = ((avn)localObject5).ZFK;
        if (localObject5 == null)
        {
          l = 0L;
          break label2748;
        }
        l = ((dom)localObject5).CJK;
        break label2748;
        label3240:
        localObject5 = ((avn)localObject5).ZFK;
        if (localObject5 == null)
        {
          l = 0L;
          break label2795;
        }
        l = ((dom)localObject5).aaVw;
        break label2795;
      }
      if (((bxg)localObject3).tab_type == 3) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbY, ((bxg)localObject3).ZWa);
      } else if (((bxg)localObject3).tab_type == 1) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbW, ((bxg)localObject3).ZWa);
      }
    }
    label3326:
    ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).u(localbbx.ZMv);
    this.AAn.put("current_alias_role_type", localbbx.ZMw);
    this.AAn.put("next_alias_mod_available_time", localbbx.ZMx);
    paramInt1 = localbbx.ZMw;
    Log.i(TAG, kotlin.g.b.s.X("current_alias_role_type：", Integer.valueOf(paramInt1)));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaO, Integer.valueOf(paramInt1));
    long l = localbbx.ZMx;
    Log.i(TAG, kotlin.g.b.s.X("next_alias_mod_available_time：", Long.valueOf(l)));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaS, Long.valueOf(l));
    params = localbbx.ZMv;
    if (params == null)
    {
      params = null;
      if (params == null)
      {
        params = ((cv)this).ACK;
        if (params == null) {
          break label3854;
        }
        params = params.ZMv;
        if (params == null) {
          break label3854;
        }
        if (((Collection)params).isEmpty()) {
          break label3849;
        }
        paramInt1 = 1;
        label3517:
        if (paramInt1 != 1) {
          break label3854;
        }
        paramInt1 = 1;
        label3524:
        if (paramInt1 != 0)
        {
          params = av.GiL;
          av.aBS("NetSceneFinderInit");
        }
        params = ah.aiuX;
      }
      params = d.AwY;
      localObject3 = new ArrayList((Collection)d.a.dUe());
      params = z.bAW();
      kotlin.g.b.s.s(params, "myFinderUserName");
      if (((CharSequence)params).length() <= 0) {
        break label3859;
      }
      paramInt1 = 1;
      label3591:
      if ((paramInt1 == 0) || (((ArrayList)localObject3).contains(params))) {
        break label3864;
      }
      paramInt1 = 1;
      label3607:
      if (paramInt1 == 0) {
        break label3869;
      }
      label3611:
      if (params != null)
      {
        ((ArrayList)localObject3).add(params);
        params = d.AwY;
        d.a.fS((List)localObject3);
        params = ah.aiuX;
        params = ah.aiuX;
      }
      this.AAn.put("finderUserNameList", localObject3);
      kotlin.g.b.s.s(localLinkedList, "newFinderNameList");
      u(localList, (List)localLinkedList);
      ((PluginByp)com.tencent.mm.kernel.h.az(PluginByp.class)).mergeSelectorAndDoScene();
      params = ah.aiuX;
      params = ah.aiuX;
    }
    for (;;)
    {
      label3700:
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
        paramString = ah.aiuX;
        paramString = ah.aiuX;
      }
      AppMethodBeat.o(336717);
      return;
      localObject3 = ((Iterable)params).iterator();
      label3755:
      if (((Iterator)localObject3).hasNext())
      {
        params = ((Iterator)localObject3).next();
        if (((bcz)params).ZNI == 2)
        {
          paramInt1 = 1;
          label3788:
          if (paramInt1 == 0) {
            break label3813;
          }
        }
      }
      for (;;)
      {
        params = (bcz)params;
        if (params != null) {
          break label3821;
        }
        params = null;
        break;
        paramInt1 = 0;
        break label3788;
        label3813:
        break label3755;
        params = null;
      }
      label3821:
      localObject3 = av.GiL;
      av.a(params, Boolean.TRUE, "NetSceneFinderInit");
      params = ah.aiuX;
      params = ah.aiuX;
      break;
      label3849:
      paramInt1 = 0;
      break label3517;
      label3854:
      paramInt1 = 0;
      break label3524;
      label3859:
      paramInt1 = 0;
      break label3591;
      label3864:
      paramInt1 = 0;
      break label3607;
      label3869:
      params = null;
      break label3611;
      label3875:
      if ((paramInt2 != 4) || (paramInt3 != ACL)) {
        break label4001;
      }
      params = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZR, "");
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(336717);
        throw paramString;
      }
      params = (String)params;
      Log.w(TAG, "errCode=" + paramInt3 + " clear local self finder username. currentFinderUsername=" + params + ' ');
      params = av.GiL;
      av.aBR("MMFinder_FinderInit_Err_User_NotCreated");
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 26L, 1L);
    }
    label4001:
    params = this.ACJ;
    if (params == null)
    {
      params = null;
      label4015:
      if (!(params instanceof bbx)) {
        break label4105;
      }
      params = (bbx)params;
      label4030:
      this.ACK = params;
      params = this.ACK;
      if (params != null) {
        break label4111;
      }
      params = null;
    }
    for (;;)
    {
      if (params == null)
      {
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).resetLastFinderInitTime();
        params = ah.aiuX;
        params = ah.aiuX;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 24L, 1L);
      break;
      params = c.c.b(params.otC);
      break label4015;
      label4105:
      params = null;
      break label4030;
      label4111:
      params = Integer.valueOf(params.ZMB);
      if (((Number)params).intValue() > 0)
      {
        paramInt1 = 1;
        label4134:
        if (paramInt1 == 0) {
          break label4154;
        }
      }
      for (;;)
      {
        if (params != null) {
          break label4160;
        }
        params = null;
        break;
        paramInt1 = 0;
        break label4134;
        label4154:
        params = null;
      }
      label4160:
      paramInt1 = ((Number)params).intValue();
      params = com.tencent.threadpool.h.ahAA.r(cv..ExternalSyntheticLambda0.INSTANCE, paramInt1 * 1000L);
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return this.AAa;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165241);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.ACJ, (m)this);
    AppMethodBeat.o(165241);
    return i;
  }
  
  public final int getType()
  {
    return 3930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cv
 * JD-Core Version:    0.7.0.1
 */