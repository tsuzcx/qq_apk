package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isEnableReport", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bt
  extends ax
  implements m
{
  private static final String TAG = "Finder.NetSceneFinderInit";
  private static int tvF;
  public static final a tvG;
  private i callback;
  private com.tencent.mm.plugin.finder.cgi.report.b ttH;
  private com.tencent.mm.ak.d tvD;
  public auc tvE;
  
  static
  {
    AppMethodBeat.i(242468);
    tvG = new a((byte)0);
    tvF = -4004;
    TAG = "Finder.NetSceneFinderInit";
    AppMethodBeat.o(242468);
  }
  
  public bt()
  {
    AppMethodBeat.i(165243);
    Log.i(TAG, "NetSceneFinderInit");
    Object localObject1 = new d.a();
    aub localaub = new aub();
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ().get(ar.a.Okz, "");
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localaub.Lev = com.tencent.mm.platformtools.z.aC(Util.decodeHexString((String)localObject2));
    localObject2 = am.tuw;
    localaub.uli = am.cXY();
    ((d.a)localObject1).sG(getType());
    ((d.a)localObject1).MB("/cgi-bin/micromsg-bin/finderinit");
    ((d.a)localObject1).c((com.tencent.mm.bw.a)localaub);
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new auc());
    this.tvD = ((d.a)localObject1).aXF();
    com.tencent.mm.plugin.report.service.h.CyF.n(1279L, 23L, 1L);
    this.ttH = com.tencent.mm.plugin.finder.cgi.report.b.tyf;
    AppMethodBeat.o(165243);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242467);
    Object localObject1 = TAG;
    Object localObject4 = new StringBuilder("errType ").append(paramInt2).append(", errCode ").append(paramInt3).append(", errMsg ").append(paramString).append(" username=");
    params = this.tvE;
    label150:
    auc localauc;
    if (params != null)
    {
      params = params.LEN;
      if (params != null)
      {
        params = (FinderContact)j.kt((List)params);
        if (params != null)
        {
          params = params.username;
          Log.i((String)localObject1, params);
          if (paramInt2 >= 4) {
            this.ttH = com.tencent.mm.plugin.finder.cgi.report.b.tyd;
          }
          if ((paramInt2 != 0) || (paramInt3 != 0)) {
            break label2059;
          }
          params = this.tvD;
          if (params == null) {
            break label412;
          }
          params = params.aYK();
          localObject1 = params;
          if (!(params instanceof auc)) {
            localObject1 = null;
          }
          this.tvE = ((auc)localObject1);
          localauc = this.tvE;
          if (localauc == null) {
            break label2432;
          }
          params = this.tvE;
          if (params == null) {
            break label418;
          }
          params = params.LEN;
          label203:
          if (params == null) {
            break label1733;
          }
          if (((Collection)params).isEmpty()) {
            break label424;
          }
          paramInt1 = 1;
          label223:
          if (paramInt1 == 0) {
            break label429;
          }
          localObject1 = params;
        }
      }
    }
    label412:
    label418:
    label424:
    label429:
    Object localObject5;
    label716:
    label722:
    Object localObject3;
    for (;;)
    {
      if ((localObject1 != null) && (!Util.isNullOrNil(((FinderContact)params.get(0)).username)))
      {
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.OjG, ((FinderContact)params.get(0)).username);
        localObject1 = c.tsp;
        localObject1 = params.get(0);
        p.g(localObject1, "self[0]");
        c.a.a((FinderContact)localObject1);
        localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension();
        localObject4 = this.tvE;
        if (localObject4 == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.finder.api.e)localObject1).fX(((auc)localObject4).continueFlag, 5);
        localObject1 = this.tvD;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((com.tencent.mm.ak.d)localObject1).aYK();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderInitResponse");
          AppMethodBeat.o(242467);
          throw paramString;
          params = null;
          break;
          params = null;
          break label150;
          params = null;
          break label203;
          paramInt1 = 0;
          break label223;
          localObject1 = null;
          continue;
        }
        localObject1 = ((auc)localObject1).sKS;
        if (localObject1 != null)
        {
          localObject5 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject5).hasNext())
            {
              localObject1 = (apf)((Iterator)localObject5).next();
              p.g(localObject1, "it");
              Object localObject6;
              Object localObject7;
              switch (((apf)localObject1).cmdId)
              {
              default: 
                break;
              case 105: 
                localObject4 = (com.tencent.mm.bw.a)new are();
                localObject1 = ((apf)localObject1).LBo;
                if (localObject1 != null) {}
                for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();; localObject1 = null)
                {
                  try
                  {
                    ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject1);
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
                  localObject4 = (are)localObject1;
                  localObject1 = c.tsp;
                  if (c.a.asG(com.tencent.mm.model.z.aUg()) == null) {
                    break;
                  }
                  localObject6 = TAG;
                  localObject7 = new StringBuilder("save follow count ");
                  if (localObject4 == null) {
                    break label716;
                  }
                  localObject1 = Integer.valueOf(((are)localObject4).LBI);
                  Log.i((String)localObject6, localObject1);
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  localObject6 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                  localObject7 = ar.a.OlA;
                  if (localObject4 == null) {
                    break label722;
                  }
                  localObject1 = Integer.valueOf(((are)localObject4).LBI);
                  ((ao)localObject6).set((ar.a)localObject7, localObject1);
                  break;
                }
              case 106: 
                localObject4 = (com.tencent.mm.bw.a)new aqs();
                Object localObject2 = ((apf)localObject2).LBo;
                if (localObject2 != null) {}
                for (localObject2 = ((com.tencent.mm.bw.b)localObject2).toByteArray();; localObject2 = null)
                {
                  try
                  {
                    ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject2);
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
                  localObject4 = (aqs)localObject2;
                  localObject2 = c.tsp;
                  if (c.a.asG(com.tencent.mm.model.z.aUg()) == null) {
                    break;
                  }
                  localObject6 = TAG;
                  localObject7 = new StringBuilder("save fans count ");
                  if (localObject4 == null) {
                    break label921;
                  }
                  localObject2 = Integer.valueOf(((aqs)localObject4).LAB);
                  Log.i((String)localObject6, localObject2);
                  localObject2 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject2, "MMKernel.storage()");
                  localObject6 = ((com.tencent.mm.kernel.e)localObject2).azQ();
                  localObject7 = ar.a.OlC;
                  if (localObject4 == null) {
                    break label927;
                  }
                  localObject2 = Integer.valueOf(((aqs)localObject4).LAB);
                  ((ao)localObject6).set((ar.a)localObject7, localObject2);
                  break;
                }
              }
            }
          }
        }
        label921:
        label927:
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        localObject3 = ((com.tencent.mm.kernel.e)localObject3).azQ();
        localObject4 = ar.a.Okz;
        localObject5 = this.tvE;
        if (localObject5 == null) {
          p.hyc();
        }
        ((ao)localObject3).set((ar.a)localObject4, Util.encodeHexString(com.tencent.mm.platformtools.z.a(((auc)localObject5).Lev)));
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OjH, ((FinderContact)params.get(0)).nickname);
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OjI, ((FinderContact)params.get(0)).signature);
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OjJ, ((FinderContact)params.get(0)).headUrl);
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.Okw, Integer.valueOf(((FinderContact)params.get(0)).extFlag));
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OjP, Integer.valueOf(((FinderContact)params.get(0)).originalFlag));
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OjU, Integer.valueOf(((FinderContact)params.get(0)).originalEntranceFlag));
        if (((FinderContact)params.get(0)).originalInfo != null)
        {
          localObject3 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
          localObject5 = ar.a.OjQ;
          localObject3 = ((FinderContact)params.get(0)).originalInfo;
          if (localObject3 == null) {
            break label1860;
          }
          localObject3 = Integer.valueOf(((bac)localObject3).LJQ);
          ((ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
          localObject5 = ar.a.OjR;
          localObject3 = ((FinderContact)params.get(0)).originalInfo;
          if (localObject3 == null) {
            break label1866;
          }
          localObject3 = Integer.valueOf(((bac)localObject3).LJR);
          label1338:
          ((ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
          localObject5 = ar.a.OjS;
          localObject3 = ((FinderContact)params.get(0)).originalInfo;
          if (localObject3 == null) {
            break label1872;
          }
          localObject3 = Integer.valueOf(((bac)localObject3).LJS);
          label1400:
          ((ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
          localObject5 = ar.a.OjT;
          localObject3 = ((FinderContact)params.get(0)).originalInfo;
          if (localObject3 == null) {
            break label1878;
          }
          localObject3 = Integer.valueOf(((bac)localObject3).LJT);
          label1462:
          ((ao)localObject4).set((ar.a)localObject5, localObject3);
          localObject3 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
          localObject5 = ar.a.OjW;
          localObject3 = ((FinderContact)params.get(0)).originalInfo;
          if (localObject3 == null) {
            break label1884;
          }
          localObject3 = Integer.valueOf(((bac)localObject3).LJU);
          label1524:
          ((ao)localObject4).set((ar.a)localObject5, localObject3);
        }
        if (((FinderContact)params.get(0)).authInfo != null) {
          break label1890;
        }
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.OjK, "");
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject3).azQ().set(ar.a.Okk, ((FinderContact)params.get(0)).liveCoverImgUrl);
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
        localObject5 = ar.a.Okl;
        localObject3 = ((FinderContact)params.get(0)).live_info;
        if (localObject3 == null) {
          break label1961;
        }
        localObject3 = Long.valueOf(((apr)localObject3).LBA);
        label1661:
        ((ao)localObject4).set((ar.a)localObject5, localObject3);
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        localObject3 = ((com.tencent.mm.kernel.e)localObject3).azQ();
        localObject4 = ar.a.Okm;
        params = ((FinderContact)params.get(0)).live_info;
        if (params == null) {
          break label1970;
        }
        params = Long.valueOf(params.LBB);
        label1724:
        ((ao)localObject3).set((ar.a)localObject4, params);
      }
    }
    label1733:
    params = localauc.LEO;
    p.g(params, "it.tabInfos");
    params = ((Iterable)params).iterator();
    label1860:
    label1866:
    label1872:
    label1878:
    label1884:
    label1890:
    boolean bool;
    for (;;)
    {
      if (params.hasNext())
      {
        localObject3 = (bdg)params.next();
        Log.i(TAG, ((bdg)localObject3).tab_type + " => " + ((bdg)localObject3).LHR);
        if (((bdg)localObject3).tab_type == 4)
        {
          localObject4 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject4, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject4).azQ().set(ar.a.OkN, ((bdg)localObject3).LHR);
          continue;
          localObject3 = null;
          break;
          localObject3 = null;
          break label1338;
          localObject3 = null;
          break label1400;
          localObject3 = null;
          break label1462;
          localObject3 = null;
          break label1524;
          localObject3 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject3, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.e)localObject3).azQ();
          localObject5 = ar.a.OjK;
          localObject3 = ((FinderContact)params.get(0)).authInfo;
          if (localObject3 != null) {}
          for (localObject3 = ((FinderAuthInfo)localObject3).toByteArray();; localObject3 = null)
          {
            ((ao)localObject4).set((ar.a)localObject5, Util.encodeHexString((byte[])localObject3));
            break;
          }
          label1961:
          localObject3 = Long.valueOf(0L);
          break label1661;
          label1970:
          params = Long.valueOf(0L);
          break label1724;
        }
        if (((bdg)localObject3).tab_type == 3)
        {
          localObject4 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject4, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject4).azQ().set(ar.a.OkO, ((bdg)localObject3).LHR);
        }
        else if (((bdg)localObject3).tab_type == 1)
        {
          localObject4 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject4, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject4).azQ().set(ar.a.OkM, ((bdg)localObject3).LHR);
          continue;
          label2059:
          if ((paramInt2 != 4) || (paramInt3 != tvF)) {
            break label2470;
          }
          params = com.tencent.mm.kernel.g.aAh();
          p.g(params, "MMKernel.storage()");
          params = params.azQ().get(ar.a.OjG, "");
          if (params == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(242467);
            throw paramString;
          }
          params = (String)params;
          Log.w(TAG, "errCode=" + paramInt3 + " clear local self finder username. currentFinderUsername=" + params + ' ');
          localObject3 = c.tsp;
          p.h(params, "username");
          Log.d(c.access$getTAG$cp(), "delete contact %s", new Object[] { params });
          if (!Util.isNullOrNil(params))
          {
            localObject3 = c.cXE();
            p.h(params, "key");
            ((com.tencent.mm.plugin.finder.api.a)localObject3).tsn.remove(params);
            localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).aSN();
            localObject4 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage().avA(params);
            ((bv)localObject3).ayf(params);
            ((bv)localObject3).ayf((String)localObject4);
            params = "DELETE FROM FinderContact WHERE username = " + com.tencent.mm.storagebase.h.Fl(params);
            localObject3 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage();
            if (localObject3 == null) {
              break label2464;
            }
            bool = ((com.tencent.mm.plugin.finder.storage.d)localObject3).execSQL("FinderContact", params);
            Log.d(c.access$getTAG$cp(), "delete success %s", new Object[] { Boolean.valueOf(bool) });
            if ((bool) && (localObject3 != null)) {
              ((com.tencent.mm.plugin.finder.storage.d)localObject3).doNotify("FinderContact", 5, localObject3);
            }
          }
          params = com.tencent.mm.kernel.g.aAh();
          p.g(params, "MMKernel.storage()");
          params.azQ().set(ar.a.OjG, "");
          com.tencent.mm.plugin.report.service.h.CyF.n(1279L, 26L, 1L);
        }
      }
    }
    for (;;)
    {
      label2432:
      params = this.callback;
      if (params == null) {
        break label2486;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242467);
      return;
      label2464:
      bool = false;
      break;
      label2470:
      com.tencent.mm.plugin.report.service.h.CyF.n(1279L, 24L, 1L);
    }
    label2486:
    AppMethodBeat.o(242467);
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return this.ttH;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165241);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.tvD, (m)this);
    AppMethodBeat.o(165241);
    return i;
  }
  
  public final int getType()
  {
    return 3930;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit$Companion;", "", "()V", "MMFinder_FinderInit_Err_User_NotCreated", "", "getMMFinder_FinderInit_Err_User_NotCreated", "()I", "setMMFinder_FinderInit_Err_User_NotCreated", "(I)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bt
 * JD-Core Version:    0.7.0.1
 */