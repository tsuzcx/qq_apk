package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.abtest.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class i
{
  private static String xuA;
  private static String xuB;
  private static String xuC;
  private static String xuD;
  private static String xuE;
  private static String xuF;
  public static final a xuG;
  private static String xux;
  private static String xuy;
  private static String xuz;
  
  static
  {
    AppMethodBeat.i(274311);
    xuG = new a((byte)0);
    xux = "";
    xuy = "";
    xuz = "";
    xuA = "";
    xuB = "";
    xuC = "";
    xuD = "";
    xuE = "";
    xuF = "";
    AppMethodBeat.o(274311);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "clickNearbyLiveTabRedDotId", "clickNearbyPersonTabRedDotId", "clickNearbyVideoTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "lastFinderLiveExposeTipsId", "getLastFinderLiveExposeTipsId", "setLastFinderLiveExposeTipsId", "lastNearbyExposeTipsId", "getLastNearbyExposeTipsId", "setLastNearbyExposeTipsId", "getFinderNotifyCount", "", "getNotifyCount", "hasMentionCount", "", "reportFindPageFinderLiveRedDotClick", "", "contextId", "autoClick", "", "reportFindPageNearbyRedDotClick", "reportFindPageRedDotClick", "reportFindPageRedDotExpose", "ignoreDuplicatedId", "reportFinderEntryRedDotLongClick", "reportFinderPageFinderLiveRedDotExpose", "isEnableFinderLiveEntrance", "reportHomeFollowTabRed", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "reportNearbyLiveRedBreakage", "overwriteTipsId", "reportNearbyLiveTabRed", "clickSubTabContext", "reportNearbyPersonTabRed", "reportNearbyVideoTabRed", "plugin-finder_release"})
  public static final class a
  {
    public static void P(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(291939);
      Object localObject1 = h.ag(ak.class);
      p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((ak)localObject1).getRedDotManager();
      p.j(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if ((!((z)localObject1).dqK()) || (!paramBoolean2))
      {
        AppMethodBeat.o(291939);
        return;
      }
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)localObject1).getRedDotManager().aBe("FinderLiveEntrance");
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      l locall = ((PluginFinder)localObject1).getRedDotManager().aBf("FinderLiveEntrance");
      localObject1 = aj.AGc;
      if (locall != null)
      {
        localObject1 = locall.field_ctrInfo;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject1 = ((bhw)localObject1).SQm;
          Object localObject3 = i.xuG;
          if (((p.h(i.drt(), localObject1) ^ true)) || (paramBoolean1))
          {
            localObject3 = "8001-" + cm.bfE();
            String str = String.valueOf(((com.tencent.c.a.b.a.d)h.ag(com.tencent.c.a.b.a.d.class)).getTargetLiveTabId()) + "-" + cm.bfE();
            com.tencent.mm.plugin.finder.report.l locall1 = com.tencent.mm.plugin.finder.report.l.zWx;
            if (locall == null) {
              p.iCn();
            }
            locall1.a("1", locall, (bkn)localObject2, 1, "", 0, (String)localObject3, str);
            localObject2 = i.xuG;
            if (localObject1 != null) {
              break label277;
            }
            localObject1 = "";
          }
        }
      }
      label277:
      for (;;)
      {
        p.k(localObject1, "<set-?>");
        i.aBq((String)localObject1);
        AppMethodBeat.o(291939);
        return;
        localObject1 = null;
        break;
      }
    }
    
    public static String a(int paramInt, bid parambid, String paramString)
    {
      AppMethodBeat.i(291937);
      p.k(paramString, "lastExposeTipsId");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
      bkn localbkn = ((f)localObject3).aBe("TLPersonalCenter");
      l locall = ((f)localObject3).aBf("TLPersonalCenter");
      localObject1 = aj.AGc;
      if (locall != null) {
        localObject1 = locall.field_ctrInfo;
      }
      Object localObject2;
      int k;
      int i;
      for (;;)
      {
        if ((localbkn != null) && (localObject1 != null)) {
          if (paramInt == 1)
          {
            localObject2 = ((bhw)localObject1).SQm;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (p.h(paramString, localObject1))
            {
              AppMethodBeat.o(291937);
              return localObject1;
              localObject1 = null;
              continue;
            }
            paramString = (String)localObject1;
            localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
            if (locall == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.finder.report.l.a("2", locall, localbkn, paramInt, parambid, 0, 0, null, 224);
            localObject1 = h.aHG();
            p.j(localObject1, "MMKernel.storage()");
            int j = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VBo, 0);
            localObject1 = h.aHG();
            p.j(localObject1, "MMKernel.storage()");
            k = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VBp, 0);
            localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() == 1)
            {
              i = 0;
              label236:
              if (j <= 0) {
                break label282;
              }
              localObject1 = n.zWF;
              n.a("2", 1, paramInt, 1, i, j, null, null, 0L, parambid, 0, 0, 3520);
              localObject1 = paramString;
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(291937);
        return localObject1;
        i = 2;
        break label236;
        label282:
        if (k > 0)
        {
          localObject1 = n.zWF;
          n.a("2", 4, paramInt, 1, i, k, null, null, 0L, parambid, 0, 0, 3520);
          localObject1 = paramString;
        }
        else
        {
          localObject2 = ((f)localObject3).aBe("Personal_Center_FavList_Entrance");
          localObject3 = ((f)localObject3).aBf("Personal_Center_FavList_Entrance");
          localObject1 = aj.AGc;
          if (localObject3 != null) {}
          for (localObject1 = ((l)localObject3).field_ctrInfo;; localObject1 = null)
          {
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject1 = n.zWF;
              n.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, parambid, 0, 0, 3520);
              localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
              if (localObject3 == null) {
                p.iCn();
              }
              com.tencent.mm.plugin.finder.report.l.a("2", (l)localObject3, (bkn)localObject2, paramInt, parambid, 0, 0, null, 224);
            }
            localObject1 = h.ag(PluginFinder.class);
            p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject2 = ((PluginFinder)localObject1).getRedDotManager().aBe("TLCamera");
            localObject1 = h.ag(PluginFinder.class);
            p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject3 = ((PluginFinder)localObject1).getRedDotManager().aBf("TLCamera");
            localObject1 = aj.AGc;
            localObject1 = paramString;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramString;
            if (localObject3 == null) {
              break;
            }
            localObject1 = n.zWF;
            n.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, parambid, 0, 0, 3520);
            localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
            com.tencent.mm.plugin.finder.report.l.a("2", (l)localObject3, (bkn)localObject2, paramInt, parambid, 0, 0, null, 224);
            localObject1 = paramString;
            break;
          }
          paramString = "";
          break;
          localObject1 = "";
        }
      }
    }
    
    public static void a(int paramInt, bid parambid)
    {
      AppMethodBeat.i(291936);
      p.k(parambid, "contextObj");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bkn localbkn = ((f)localObject1).aBe("finder_tl_nearby_tab");
      l locall = ((f)localObject1).aBf("finder_tl_nearby_tab");
      localObject1 = aj.AGc;
      if (locall != null) {}
      for (localObject1 = locall.field_ctrInfo;; localObject1 = null)
      {
        if ((localbkn != null) && (localObject1 != null))
        {
          Object localObject2 = n.zWF;
          localObject2 = ((bhw)localObject1).SQm;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          n.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, parambid, 0, 0, 3456);
          localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
          if (locall == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.finder.report.l.a("2", locall, localbkn, paramInt, parambid, 0, 2, null, 160);
        }
        AppMethodBeat.o(291936);
        return;
      }
    }
    
    public static void a(int paramInt1, bid parambid, int paramInt2, String paramString)
    {
      AppMethodBeat.i(291946);
      p.k(paramString, "clickSubTabContext");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bkn localbkn = ((f)localObject1).aBe("NearbyLiveTab");
      l locall = ((f)localObject1).aBf("NearbyLiveTab");
      localObject1 = aj.AGc;
      if (locall != null)
      {
        localObject1 = locall.field_ctrInfo;
        if ((localbkn == null) || (localObject1 == null)) {
          break label237;
        }
        localObject1 = ((bhw)localObject1).SQm;
        if (localObject1 != null) {
          break label244;
        }
        localObject1 = "";
      }
      label237:
      label244:
      for (;;)
      {
        p.j(localObject1, "ctrInfo.tips_id ?: \"\"");
        if ((paramInt1 == 2) && (p.h(i.drv(), localObject1)))
        {
          AppMethodBeat.o(291946);
          return;
          localObject1 = null;
          break;
        }
        Object localObject2;
        if (parambid != null)
        {
          localObject3 = parambid.wmL;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        p.j(localObject2, "contextObj?.contextId ?: \"\"");
        if (parambid != null)
        {
          localObject3 = parambid.wmz;
          parambid = (bid)localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          parambid = "";
        }
        p.j(parambid, "contextObj?.clickTabContextId ?: \"\"");
        Object localObject3 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.finder.report.l)localObject3).a("9", locall, localbkn, paramInt1, (String)localObject2, paramInt2, parambid, paramString);
        if (paramInt1 == 2) {
          i.aBs((String)localObject1);
        }
        AppMethodBeat.o(291946);
        return;
      }
    }
    
    public static void a(int paramInt1, bid parambid, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(291933);
      p.k(parambid, "contextObj");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bkn localbkn = ((f)localObject1).aBe("TLRecommendTab");
      l locall = ((f)localObject1).aBf("TLRecommendTab");
      localObject1 = aj.AGc;
      Object localObject2;
      if (locall != null) {
        localObject2 = locall.field_ctrInfo;
      }
      while ((localbkn != null) && (localObject2 != null))
      {
        Object localObject3 = ((bhw)localObject2).SQm;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        p.j(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = i.xuG;
          if (p.h(i.dro(), localObject1))
          {
            AppMethodBeat.o(291933);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = n.zWF;
        long l = ((bhw)localObject2).feedId;
        if (!paramBoolean) {
          break label254;
        }
        i = 1;
        n.a("2", 8, paramInt1, 1, 0, 0, (String)localObject1, null, l, parambid, paramInt2, i, 128);
        localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        if (!paramBoolean) {
          break label260;
        }
      }
      label260:
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.report.l.a("2", locall, localbkn, paramInt1, parambid, i, paramInt2, null, 128);
        if (paramInt1 == 2)
        {
          parambid = i.xuG;
          p.k(localObject1, "<set-?>");
          i.aBl((String)localObject1);
        }
        AppMethodBeat.o(291933);
        return;
        label254:
        i = 0;
        break;
      }
    }
    
    public static void aBu(String paramString)
    {
      AppMethodBeat.i(291942);
      p.k(paramString, "contextId");
      Object localObject = a.zDp;
      if (a.dLo())
      {
        localObject = h.ag(ak.class);
        p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
        p.j(((ak)localObject).getRedDotManager(), "MMKernel.plugin(IPluginF…class.java).redDotManager");
      }
      for (boolean bool = true; !bool; bool = ((z)localObject).dqJ())
      {
        AppMethodBeat.o(291942);
        return;
        localObject = h.ag(ak.class);
        p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
        localObject = ((ak)localObject).getRedDotManager();
        p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      }
      localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      bkn localbkn = ((PluginFinder)localObject).getRedDotManager().aBe("NearbyEntrance");
      localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      l locall = ((PluginFinder)localObject).getRedDotManager().aBf("NearbyEntrance");
      localObject = aj.AGc;
      if (locall != null)
      {
        localObject = locall.field_ctrInfo;
        if ((localbkn != null) && (localObject != null)) {
          if ((((bhw)localObject).type != 16) && (localbkn.CKC != 6)) {
            break label236;
          }
        }
      }
      label236:
      for (int i = 2;; i = 3)
      {
        localObject = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.finder.report.l)localObject).a("1", locall, localbkn, i, paramString, 0);
        AppMethodBeat.o(291942);
        return;
        localObject = null;
        break;
      }
    }
    
    public static void aBv(String paramString)
    {
      AppMethodBeat.i(291951);
      p.k(paramString, "overwriteTipsId");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject3 = ((Iterable)f.a(((PluginFinder)localObject1).getRedDotManager(), "NearbyEntrance")).iterator();
      localObject1 = null;
      Object localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (l)((Iterator)localObject3).next();
        if (((l)localObject2).field_ctrInfo.type != 16) {
          break label170;
        }
        localObject1 = localObject2;
      }
      label165:
      label170:
      for (;;)
      {
        break;
        if (localObject1 != null)
        {
          localObject2 = ((l)localObject1).xuK;
          if (localObject2 != null)
          {
            localObject2 = (bkn)((ConcurrentHashMap)localObject2).get("NearbyEntrance");
            localObject3 = aj.AGc;
            if (localObject1 == null) {
              break label165;
            }
          }
        }
        for (localObject3 = ((l)localObject1).field_ctrInfo;; localObject3 = null)
        {
          if ((localObject2 != null) && (localObject3 != null))
          {
            localObject3 = com.tencent.mm.plugin.finder.report.l.zWx;
            if (localObject1 == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.finder.report.l.a((l)localObject1, (bkn)localObject2, 6, 1, null, paramString, 16);
          }
          AppMethodBeat.o(291951);
          return;
          localObject2 = null;
          break;
        }
      }
    }
    
    public static void b(int paramInt, bid parambid)
    {
      AppMethodBeat.i(291943);
      Object localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bkn localbkn = ((f)localObject).aBe("NearbyFeedTab");
      l locall = ((f)localObject).aBf("NearbyFeedTab");
      localObject = aj.AGc;
      if (locall != null)
      {
        localObject = locall.field_ctrInfo;
        if ((localbkn == null) || (localObject == null)) {
          break label151;
        }
        localObject = ((bhw)localObject).SQm;
        if (localObject != null) {
          break label158;
        }
        localObject = "";
      }
      label151:
      label158:
      for (;;)
      {
        p.j(localObject, "ctrInfo.tips_id ?: \"\"");
        if ((paramInt == 2) && (p.h(i.dru(), localObject)))
        {
          AppMethodBeat.o(291943);
          return;
          localObject = null;
          break;
        }
        com.tencent.mm.plugin.finder.report.l locall1 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        com.tencent.mm.plugin.finder.report.l.a("9", locall, localbkn, paramInt, parambid, 0, 0, null, 224);
        if (paramInt == 2) {
          i.aBr((String)localObject);
        }
        AppMethodBeat.o(291943);
        return;
      }
    }
    
    public static void b(int paramInt1, bid parambid, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(291934);
      p.k(parambid, "contextObj");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bkn localbkn = ((f)localObject1).aBe("TLFollow");
      l locall = ((f)localObject1).aBf("TLFollow");
      localObject1 = aj.AGc;
      Object localObject2;
      if (locall != null) {
        localObject2 = locall.field_ctrInfo;
      }
      while ((localbkn != null) && (localObject2 != null))
      {
        Object localObject3 = ((bhw)localObject2).SQm;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        p.j(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = i.xuG;
          if (p.h(i.drp(), localObject1))
          {
            AppMethodBeat.o(291934);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = n.zWF;
        long l = ((bhw)localObject2).feedId;
        if (!paramBoolean) {
          break label254;
        }
        i = 1;
        n.a("2", 7, paramInt1, 1, 0, 0, (String)localObject1, null, l, parambid, paramInt2, i, 128);
        localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        if (!paramBoolean) {
          break label260;
        }
      }
      label260:
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.report.l.a("2", locall, localbkn, paramInt1, parambid, i, paramInt2, null, 128);
        if (paramInt1 == 2)
        {
          parambid = i.xuG;
          p.k(localObject1, "<set-?>");
          i.aBm((String)localObject1);
        }
        AppMethodBeat.o(291934);
        return;
        label254:
        i = 0;
        break;
      }
    }
    
    public static void c(int paramInt, bid parambid)
    {
      AppMethodBeat.i(291948);
      Object localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bkn localbkn = ((f)localObject).aBe("NearbyPeopleTab");
      l locall = ((f)localObject).aBf("NearbyPeopleTab");
      localObject = aj.AGc;
      if (locall != null)
      {
        localObject = locall.field_ctrInfo;
        if ((localbkn == null) || (localObject == null)) {
          break label151;
        }
        localObject = ((bhw)localObject).SQm;
        if (localObject != null) {
          break label158;
        }
        localObject = "";
      }
      label151:
      label158:
      for (;;)
      {
        p.j(localObject, "ctrInfo.tips_id ?: \"\"");
        if ((paramInt == 3) && (p.h(i.drw(), localObject)))
        {
          AppMethodBeat.o(291948);
          return;
          localObject = null;
          break;
        }
        com.tencent.mm.plugin.finder.report.l locall1 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        com.tencent.mm.plugin.finder.report.l.a("9", locall, localbkn, paramInt, parambid, 0, 0, null, 224);
        if (paramInt == 3) {
          i.aBt((String)localObject);
        }
        AppMethodBeat.o(291948);
        return;
      }
    }
    
    public static void c(int paramInt1, bid parambid, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(291935);
      p.k(parambid, "contextObj");
      Object localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bkn localbkn = ((f)localObject1).aBe("finder_tl_hot_tab");
      l locall = ((f)localObject1).aBf("finder_tl_hot_tab");
      localObject1 = aj.AGc;
      Object localObject2;
      if (locall != null)
      {
        localObject2 = locall.field_ctrInfo;
        if ((localbkn == null) || (localObject2 == null)) {
          break label254;
        }
        localObject1 = ((bhw)localObject2).SQm;
        if (localObject1 != null) {
          break label273;
        }
        localObject1 = "";
      }
      label267:
      label273:
      for (;;)
      {
        p.j(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = i.xuG;
          if (p.h(i.drq(), localObject1))
          {
            AppMethodBeat.o(291935);
            return;
            localObject2 = null;
            break;
          }
        }
        Object localObject3 = n.zWF;
        localObject3 = ((bhw)localObject2).SQm;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (paramBoolean)
        {
          i = 1;
          n.a("2", 3, paramInt1, 1, 2, 0, (String)localObject2, null, 0L, parambid, paramInt2, i, 384);
          localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
          if (locall == null) {
            p.iCn();
          }
          if (!paramBoolean) {
            break label267;
          }
        }
        for (int i = 1;; i = 0)
        {
          com.tencent.mm.plugin.finder.report.l.a("2", locall, localbkn, paramInt1, parambid, i, paramInt2, null, 128);
          if (paramInt1 == 2)
          {
            parambid = i.xuG;
            p.k(localObject1, "<set-?>");
            i.aBn((String)localObject1);
          }
          label254:
          AppMethodBeat.o(291935);
          return;
          i = 0;
          break;
        }
      }
    }
    
    public static String dQ(String paramString, int paramInt)
    {
      AppMethodBeat.i(291940);
      p.k(paramString, "contextId");
      Object localObject1 = h.ag(ak.class);
      p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((ak)localObject1).getRedDotManager();
      p.j(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((z)localObject1).dqI())
      {
        AppMethodBeat.o(291940);
        return null;
      }
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      bkn localbkn = ((PluginFinder)localObject1).getRedDotManager().aBe("FinderEntrance");
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      l locall = ((PluginFinder)localObject1).getRedDotManager().aBf("FinderEntrance");
      localObject1 = aj.AGc;
      if (locall != null) {}
      for (localObject1 = locall.field_ctrInfo; (localbkn != null) && (localObject1 != null); localObject1 = null)
      {
        Object localObject2 = h.ag(PluginFinder.class);
        p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
        Object localObject3 = ((PluginFinder)localObject2).getRedDotManager().aBh("FinderEntrance").report_ext_info;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        p.j(localObject2, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
        n localn = n.zWF;
        int i = ((bhw)localObject1).type;
        String str = ((bhw)localObject1).SQm;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        str = Util.nullAs(localbkn.title, "");
        p.j(str, "Util.nullAs(showInfo.title, \"\")");
        localn.a("1", i, 2, (String)localObject3, str, ((bhw)localObject1).feedId, paramString, localbkn.CKC, (String)localObject2, paramInt);
        localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.finder.report.l)localObject2).a("1", locall, localbkn, 2, paramString, paramInt);
        paramString = ((bhw)localObject1).SQm;
        AppMethodBeat.o(291940);
        return paramString;
      }
      AppMethodBeat.o(291940);
      return null;
    }
    
    public static int[] drx()
    {
      AppMethodBeat.i(291931);
      Object localObject = h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bkn localbkn = ((f)localObject).aBe("NotificationCenterLike");
      int i;
      int j;
      label72:
      int k;
      if (localbkn != null)
      {
        i = localbkn.count;
        localbkn = ((f)localObject).aBe("NotificationCenterComment");
        if (localbkn == null) {
          break label145;
        }
        j = localbkn.count;
        localbkn = ((f)localObject).aBe("NotificationCenterFollow");
        if (localbkn == null) {
          break label150;
        }
        k = localbkn.count;
        label93:
        localObject = ((f)localObject).aBe("AuthorProfileNotify");
        if (localObject == null) {
          break label155;
        }
      }
      label145:
      label150:
      label155:
      for (int m = ((bkn)localObject).count;; m = 0)
      {
        AppMethodBeat.o(291931);
        return new int[] { i, j, k, m };
        i = 0;
        break;
        j = 0;
        break label72;
        k = 0;
        break label93;
      }
    }
    
    public static boolean dry()
    {
      AppMethodBeat.i(291932);
      if (drx()[3] > 0)
      {
        AppMethodBeat.o(291932);
        return true;
      }
      AppMethodBeat.o(291932);
      return false;
    }
    
    public static void on(boolean paramBoolean)
    {
      AppMethodBeat.i(291938);
      Object localObject1 = h.ag(ak.class);
      p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((ak)localObject1).getRedDotManager();
      p.j(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((z)localObject1).dqI())
      {
        AppMethodBeat.o(291938);
        return;
      }
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      bkn localbkn = ((PluginFinder)localObject1).getRedDotManager().aBe("FinderEntrance");
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      l locall = ((PluginFinder)localObject1).getRedDotManager().aBf("FinderEntrance");
      localObject1 = aj.AGc;
      Object localObject2;
      Object localObject3;
      n localn;
      int i;
      if (locall != null)
      {
        localObject2 = locall.field_ctrInfo;
        if ((localbkn != null) && (localObject2 != null))
        {
          localObject1 = ((bhw)localObject2).SQm;
          localObject3 = h.ag(PluginFinder.class);
          p.j(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject3).getRedDotManager().aBh("FinderEntrance").report_ext_info;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          p.j(localObject3, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
          localObject4 = i.xuG;
          if (((p.h(i.drr(), localObject1) ^ true)) || (paramBoolean))
          {
            localn = n.zWF;
            i = ((bhw)localObject2).type;
            if (localObject1 != null) {
              break label587;
            }
          }
        }
      }
      label422:
      label587:
      for (Object localObject4 = "";; localObject4 = localObject1)
      {
        String str = Util.nullAs(localbkn.title, "");
        p.j(str, "Util.nullAs(showInfo.title, \"\")");
        n.a(localn, "1", i, (String)localObject4, str, ((bhw)localObject2).feedId, "", localbkn.CKC, (String)localObject3);
        localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        if (locall == null) {
          p.iCn();
        }
        com.tencent.mm.plugin.finder.report.l.a((com.tencent.mm.plugin.finder.report.l)localObject2, "1", locall, localbkn, 1);
        localObject2 = i.xuG;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        p.k(localObject2, "<set-?>");
        i.aBo((String)localObject2);
        localObject1 = a.zDp;
        if (a.dLo())
        {
          localObject1 = h.ag(ak.class);
          p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
          p.j(((ak)localObject1).getRedDotManager(), "MMKernel.plugin(IPluginF…class.java).redDotManager");
        }
        for (boolean bool = true;; bool = ((z)localObject1).dqJ())
        {
          if (bool) {
            break label422;
          }
          AppMethodBeat.o(291938);
          return;
          localObject2 = null;
          break;
          localObject1 = h.ag(ak.class);
          p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
          localObject1 = ((ak)localObject1).getRedDotManager();
          p.j(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        }
        localObject1 = h.ag(PluginFinder.class);
        p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        localObject3 = ((PluginFinder)localObject1).getRedDotManager().aBe("NearbyEntrance");
        localObject1 = h.ag(PluginFinder.class);
        p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        localObject4 = ((PluginFinder)localObject1).getRedDotManager().aBf("NearbyEntrance");
        localObject1 = aj.AGc;
        if (localObject4 != null) {}
        for (localObject1 = ((l)localObject4).field_ctrInfo;; localObject1 = null)
        {
          if ((localObject3 != null) && (localObject1 != null))
          {
            localObject2 = ((bhw)localObject1).SQm;
            localObject1 = i.xuG;
            if (((p.h(i.drs(), localObject2) ^ true)) || (paramBoolean))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
              if (localObject4 == null) {
                p.iCn();
              }
              com.tencent.mm.plugin.finder.report.l.a((com.tencent.mm.plugin.finder.report.l)localObject1, "1", (l)localObject4, (bkn)localObject3, 1);
              localObject1 = i.xuG;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              p.k(localObject1, "<set-?>");
              i.aBp((String)localObject1);
            }
          }
          AppMethodBeat.o(291938);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.i
 * JD-Core Version:    0.7.0.1
 */