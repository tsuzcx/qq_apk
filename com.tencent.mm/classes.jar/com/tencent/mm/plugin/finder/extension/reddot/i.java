package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class i
{
  private static String tLa;
  private static String tLb;
  private static String tLc;
  private static String tLd;
  private static String tLe;
  private static String tLf;
  private static String tLg;
  private static String tLh;
  public static final a tLi;
  
  static
  {
    AppMethodBeat.i(243624);
    tLi = new a((byte)0);
    tLa = "";
    tLb = "";
    tLc = "";
    tLd = "";
    tLe = "";
    tLf = "";
    tLg = "";
    tLh = "";
    AppMethodBeat.o(243624);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "clickNearbyLiveTabRedDotId", "clickNearbyPersonTabRedDotId", "clickNearbyVideoTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "lastNearbyExposeTipsId", "getLastNearbyExposeTipsId", "setLastNearbyExposeTipsId", "getFinderNotifyCount", "", "getNotifyCount", "hasMentionCount", "", "reportFindPageNearbyRedDotClick", "", "contextId", "autoClick", "", "reportFindPageRedDotClick", "reportFindPageRedDotExpose", "ignoreDuplicatedId", "reportHomeFollowTabRed", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "reportNearbyLiveRedBreakage", "overwriteTipsId", "reportNearbyLiveTabRed", "reportNearbyPersonTabRed", "reportNearbyVideoTabRed", "plugin-finder_release"})
  public static final class a
  {
    public static String a(int paramInt, bbn parambbn, String paramString)
    {
      AppMethodBeat.i(243617);
      p.h(paramString, "lastExposeTipsId");
      Object localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
      bdo localbdo = ((f)localObject3).asW("TLPersonalCenter");
      k localk = ((f)localObject3).asX("TLPersonalCenter");
      localObject1 = y.vXH;
      if (localk != null) {
        localObject1 = localk.field_ctrInfo;
      }
      Object localObject2;
      int k;
      int i;
      for (;;)
      {
        if ((localbdo != null) && (localObject1 != null)) {
          if (paramInt == 1)
          {
            localObject2 = ((bbi)localObject1).LKM;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (p.j(paramString, localObject1))
            {
              AppMethodBeat.o(243617);
              return localObject1;
              localObject1 = null;
              continue;
            }
            paramString = (String)localObject1;
            localObject1 = j.vft;
            if (localk == null) {
              p.hyc();
            }
            j.a("2", localk, localbdo, paramInt, parambbn, 0, 0, 96);
            localObject1 = g.aAh();
            p.g(localObject1, "MMKernel.storage()");
            int j = ((e)localObject1).azQ().getInt(ar.a.Omr, 0);
            localObject1 = g.aAh();
            p.g(localObject1, "MMKernel.storage()");
            k = ((e)localObject1).azQ().getInt(ar.a.Oms, 0);
            localObject1 = c.vCb;
            if (((Number)c.dsx().value()).intValue() == 1)
            {
              i = 0;
              label234:
              if (j <= 0) {
                break label280;
              }
              localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
              com.tencent.mm.plugin.finder.report.k.a("2", 1, paramInt, 1, i, j, null, null, 0L, parambbn, 0, 0, 3520);
              localObject1 = paramString;
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(243617);
        return localObject1;
        i = 2;
        break label234;
        label280:
        if (k > 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a("2", 4, paramInt, 1, i, k, null, null, 0L, parambbn, 0, 0, 3520);
          localObject1 = paramString;
        }
        else
        {
          localObject2 = ((f)localObject3).asW("Personal_Center_FavList_Entrance");
          localObject3 = ((f)localObject3).asX("Personal_Center_FavList_Entrance");
          localObject1 = y.vXH;
          if (localObject3 != null) {}
          for (localObject1 = ((k)localObject3).field_ctrInfo;; localObject1 = null)
          {
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
              com.tencent.mm.plugin.finder.report.k.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, parambbn, 0, 0, 3520);
              localObject1 = j.vft;
              if (localObject3 == null) {
                p.hyc();
              }
              j.a("2", (k)localObject3, (bdo)localObject2, paramInt, parambbn, 0, 0, 96);
            }
            localObject1 = g.ah(PluginFinder.class);
            p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject2 = ((PluginFinder)localObject1).getRedDotManager().asW("TLCamera");
            localObject1 = g.ah(PluginFinder.class);
            p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject3 = ((PluginFinder)localObject1).getRedDotManager().asX("TLCamera");
            localObject1 = y.vXH;
            localObject1 = paramString;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramString;
            if (localObject3 == null) {
              break;
            }
            localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, parambbn, 0, 0, 3520);
            localObject1 = j.vft;
            j.a("2", (k)localObject3, (bdo)localObject2, paramInt, parambbn, 0, 0, 96);
            localObject1 = paramString;
            break;
          }
          paramString = "";
          break;
          localObject1 = "";
        }
      }
    }
    
    public static void a(int paramInt, bbn parambbn)
    {
      AppMethodBeat.i(243616);
      p.h(parambbn, "contextObj");
      Object localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bdo localbdo = ((f)localObject1).asW("finder_tl_nearby_tab");
      k localk = ((f)localObject1).asX("finder_tl_nearby_tab");
      localObject1 = y.vXH;
      if (localk != null) {}
      for (localObject1 = localk.field_ctrInfo;; localObject1 = null)
      {
        if ((localbdo != null) && (localObject1 != null))
        {
          Object localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject2 = ((bbi)localObject1).LKM;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          com.tencent.mm.plugin.finder.report.k.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, parambbn, 0, 0, 3456);
          localObject1 = j.vft;
          if (localk == null) {
            p.hyc();
          }
          j.a("2", localk, localbdo, paramInt, parambbn, 0, 2, 32);
        }
        AppMethodBeat.o(243616);
        return;
      }
    }
    
    public static void a(int paramInt1, bbn parambbn, int paramInt2)
    {
      AppMethodBeat.i(243622);
      Object localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bdo localbdo = ((f)localObject).asW("NearbyLiveTab");
      k localk = ((f)localObject).asX("NearbyLiveTab");
      localObject = y.vXH;
      if (localk != null)
      {
        localObject = localk.field_ctrInfo;
        if ((localbdo == null) || (localObject == null)) {
          break label146;
        }
        localObject = ((bbi)localObject).LKM;
        if (localObject != null) {
          break label152;
        }
        localObject = "";
      }
      label146:
      label152:
      for (;;)
      {
        p.g(localObject, "ctrInfo.tips_id ?: \"\"");
        if ((paramInt1 == 2) && (p.j(i.dbm(), localObject)))
        {
          AppMethodBeat.o(243622);
          return;
          localObject = null;
          break;
        }
        j localj = j.vft;
        if (localk == null) {
          p.hyc();
        }
        j.a("9", localk, localbdo, paramInt1, parambbn, paramInt2, 0, 64);
        if (paramInt1 == 2) {
          i.ati((String)localObject);
        }
        AppMethodBeat.o(243622);
        return;
      }
    }
    
    public static void a(int paramInt1, bbn parambbn, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(243613);
      p.h(parambbn, "contextObj");
      Object localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bdo localbdo = ((f)localObject1).asW("TLRecommendTab");
      k localk = ((f)localObject1).asX("TLRecommendTab");
      localObject1 = y.vXH;
      Object localObject2;
      if (localk != null) {
        localObject2 = localk.field_ctrInfo;
      }
      while ((localbdo != null) && (localObject2 != null))
      {
        Object localObject3 = ((bbi)localObject2).LKM;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        p.g(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = i.tLi;
          if (p.j(i.dbg(), localObject1))
          {
            AppMethodBeat.o(243613);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = com.tencent.mm.plugin.finder.report.k.vfA;
        long l = ((bbi)localObject2).feedId;
        if (!paramBoolean) {
          break label244;
        }
        i = 1;
        com.tencent.mm.plugin.finder.report.k.a("2", 8, paramInt1, 1, 0, 0, (String)localObject1, null, l, parambbn, paramInt2, i, 128);
        localObject2 = j.vft;
        if (localk == null) {
          p.hyc();
        }
        if (!paramBoolean) {
          break label250;
        }
      }
      label244:
      label250:
      for (int i = 1;; i = 0)
      {
        j.a("2", localk, localbdo, paramInt1, parambbn, i, paramInt2);
        if (paramInt1 == 2)
        {
          parambbn = i.tLi;
          p.h(localObject1, "<set-?>");
          i.atc((String)localObject1);
        }
        AppMethodBeat.o(243613);
        return;
        i = 0;
        break;
      }
    }
    
    public static void atk(String paramString)
    {
      AppMethodBeat.i(243620);
      p.h(paramString, "contextId");
      Object localObject = g.ah(aj.class);
      p.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject = ((aj)localObject).getRedDotManager();
      p.g(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((z)localObject).daH())
      {
        AppMethodBeat.o(243620);
        return;
      }
      localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      bdo localbdo = ((PluginFinder)localObject).getRedDotManager().asW("NearbyEntrance");
      localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      k localk = ((PluginFinder)localObject).getRedDotManager().asX("NearbyEntrance");
      localObject = y.vXH;
      if (localk != null) {
        localObject = localk.field_ctrInfo;
      }
      while ((localbdo != null) && (localObject != null)) {
        if (localbdo.xGz == 6)
        {
          AppMethodBeat.o(243620);
          return;
          localObject = null;
        }
        else
        {
          if (((bbi)localObject).type != 16) {
            break label199;
          }
        }
      }
      label199:
      for (int i = 2;; i = 3)
      {
        localObject = j.vft;
        if (localk == null) {
          p.hyc();
        }
        j.a("1", localk, localbdo, i, paramString, 0);
        AppMethodBeat.o(243620);
        return;
      }
    }
    
    public static void b(int paramInt, bbn parambbn)
    {
      AppMethodBeat.i(243621);
      Object localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bdo localbdo = ((f)localObject).asW("NearbyFeedTab");
      k localk = ((f)localObject).asX("NearbyFeedTab");
      localObject = y.vXH;
      if (localk != null)
      {
        localObject = localk.field_ctrInfo;
        if ((localbdo == null) || (localObject == null)) {
          break label147;
        }
        localObject = ((bbi)localObject).LKM;
        if (localObject != null) {
          break label154;
        }
        localObject = "";
      }
      label147:
      label154:
      for (;;)
      {
        p.g(localObject, "ctrInfo.tips_id ?: \"\"");
        if ((paramInt == 2) && (p.j(i.dbl(), localObject)))
        {
          AppMethodBeat.o(243621);
          return;
          localObject = null;
          break;
        }
        j localj = j.vft;
        if (localk == null) {
          p.hyc();
        }
        j.a("9", localk, localbdo, paramInt, parambbn, 0, 0, 96);
        if (paramInt == 2) {
          i.ath((String)localObject);
        }
        AppMethodBeat.o(243621);
        return;
      }
    }
    
    public static void b(int paramInt1, bbn parambbn, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(243614);
      p.h(parambbn, "contextObj");
      Object localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bdo localbdo = ((f)localObject1).asW("TLFollow");
      k localk = ((f)localObject1).asX("TLFollow");
      localObject1 = y.vXH;
      Object localObject2;
      if (localk != null) {
        localObject2 = localk.field_ctrInfo;
      }
      while ((localbdo != null) && (localObject2 != null))
      {
        Object localObject3 = ((bbi)localObject2).LKM;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        p.g(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = i.tLi;
          if (p.j(i.dbh(), localObject1))
          {
            AppMethodBeat.o(243614);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = com.tencent.mm.plugin.finder.report.k.vfA;
        long l = ((bbi)localObject2).feedId;
        if (!paramBoolean) {
          break label249;
        }
        i = 1;
        com.tencent.mm.plugin.finder.report.k.a("2", 7, paramInt1, 1, 0, 0, (String)localObject1, null, l, parambbn, paramInt2, i, 128);
        localObject2 = j.vft;
        if (localk == null) {
          p.hyc();
        }
        if (!paramBoolean) {
          break label255;
        }
      }
      label249:
      label255:
      for (int i = 1;; i = 0)
      {
        j.a("2", localk, localbdo, paramInt1, parambbn, i, paramInt2);
        if (paramInt1 == 2)
        {
          parambbn = i.tLi;
          p.h(localObject1, "<set-?>");
          i.atd((String)localObject1);
        }
        AppMethodBeat.o(243614);
        return;
        i = 0;
        break;
      }
    }
    
    public static void c(int paramInt, bbn parambbn)
    {
      AppMethodBeat.i(243623);
      Object localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bdo localbdo = ((f)localObject).asW("NearbyPeopleTab");
      k localk = ((f)localObject).asX("NearbyPeopleTab");
      localObject = y.vXH;
      if (localk != null)
      {
        localObject = localk.field_ctrInfo;
        if ((localbdo == null) || (localObject == null)) {
          break label147;
        }
        localObject = ((bbi)localObject).LKM;
        if (localObject != null) {
          break label154;
        }
        localObject = "";
      }
      label147:
      label154:
      for (;;)
      {
        p.g(localObject, "ctrInfo.tips_id ?: \"\"");
        if ((paramInt == 3) && (p.j(i.dbn(), localObject)))
        {
          AppMethodBeat.o(243623);
          return;
          localObject = null;
          break;
        }
        j localj = j.vft;
        if (localk == null) {
          p.hyc();
        }
        j.a("9", localk, localbdo, paramInt, parambbn, 0, 0, 96);
        if (paramInt == 3) {
          i.atj((String)localObject);
        }
        AppMethodBeat.o(243623);
        return;
      }
    }
    
    public static void c(int paramInt1, bbn parambbn, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(243615);
      p.h(parambbn, "contextObj");
      Object localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      bdo localbdo = ((f)localObject1).asW("finder_tl_hot_tab");
      k localk = ((f)localObject1).asX("finder_tl_hot_tab");
      localObject1 = y.vXH;
      Object localObject2;
      if (localk != null)
      {
        localObject2 = localk.field_ctrInfo;
        if ((localbdo == null) || (localObject2 == null)) {
          break label249;
        }
        localObject1 = ((bbi)localObject2).LKM;
        if (localObject1 != null) {
          break label268;
        }
        localObject1 = "";
      }
      label262:
      label268:
      for (;;)
      {
        p.g(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = i.tLi;
          if (p.j(i.dbi(), localObject1))
          {
            AppMethodBeat.o(243615);
            return;
            localObject2 = null;
            break;
          }
        }
        Object localObject3 = com.tencent.mm.plugin.finder.report.k.vfA;
        localObject3 = ((bbi)localObject2).LKM;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (paramBoolean)
        {
          i = 1;
          com.tencent.mm.plugin.finder.report.k.a("2", 3, paramInt1, 1, 2, 0, (String)localObject2, null, 0L, parambbn, paramInt2, i, 384);
          localObject2 = j.vft;
          if (localk == null) {
            p.hyc();
          }
          if (!paramBoolean) {
            break label262;
          }
        }
        for (int i = 1;; i = 0)
        {
          j.a("2", localk, localbdo, paramInt1, parambbn, i, paramInt2);
          if (paramInt1 == 2)
          {
            parambbn = i.tLi;
            p.h(localObject1, "<set-?>");
            i.ate((String)localObject1);
          }
          label249:
          AppMethodBeat.o(243615);
          return;
          i = 0;
          break;
        }
      }
    }
    
    public static int[] dbo()
    {
      AppMethodBeat.i(243611);
      Object localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager();
      bdo localbdo = ((f)localObject).asW("NotificationCenterLike");
      int i;
      int j;
      label72:
      int k;
      if (localbdo != null)
      {
        i = localbdo.count;
        localbdo = ((f)localObject).asW("NotificationCenterComment");
        if (localbdo == null) {
          break label145;
        }
        j = localbdo.count;
        localbdo = ((f)localObject).asW("NotificationCenterFollow");
        if (localbdo == null) {
          break label150;
        }
        k = localbdo.count;
        label93:
        localObject = ((f)localObject).asW("AuthorProfileNotify");
        if (localObject == null) {
          break label155;
        }
      }
      label145:
      label150:
      label155:
      for (int m = ((bdo)localObject).count;; m = 0)
      {
        AppMethodBeat.o(243611);
        return new int[] { i, j, k, m };
        i = 0;
        break;
        j = 0;
        break label72;
        k = 0;
        break label93;
      }
    }
    
    public static boolean dbp()
    {
      AppMethodBeat.i(243612);
      if (dbo()[3] > 0)
      {
        AppMethodBeat.o(243612);
        return true;
      }
      AppMethodBeat.o(243612);
      return false;
    }
    
    public static String dw(String paramString, int paramInt)
    {
      AppMethodBeat.i(243619);
      p.h(paramString, "contextId");
      Object localObject1 = g.ah(aj.class);
      p.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((aj)localObject1).getRedDotManager();
      p.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((z)localObject1).daH())
      {
        AppMethodBeat.o(243619);
        return null;
      }
      localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      bdo localbdo = ((PluginFinder)localObject1).getRedDotManager().asW("FinderEntrance");
      localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      k localk = ((PluginFinder)localObject1).getRedDotManager().asX("FinderEntrance");
      localObject1 = y.vXH;
      if (localk != null) {}
      for (localObject1 = localk.field_ctrInfo; (localbdo != null) && (localObject1 != null); localObject1 = null)
      {
        Object localObject2 = g.ah(PluginFinder.class);
        p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
        Object localObject3 = ((PluginFinder)localObject2).getRedDotManager().asZ("FinderEntrance").report_ext_info;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        p.g(localObject2, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
        com.tencent.mm.plugin.finder.report.k localk1 = com.tencent.mm.plugin.finder.report.k.vfA;
        int i = ((bbi)localObject1).type;
        String str = ((bbi)localObject1).LKM;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        str = Util.nullAs(localbdo.title, "");
        p.g(str, "Util.nullAs(showInfo.title, \"\")");
        localk1.a("1", i, 2, (String)localObject3, str, ((bbi)localObject1).feedId, paramString, localbdo.xGz, (String)localObject2, paramInt);
        localObject2 = j.vft;
        if (localk == null) {
          p.hyc();
        }
        j.a("1", localk, localbdo, 2, paramString, paramInt);
        paramString = ((bbi)localObject1).LKM;
        AppMethodBeat.o(243619);
        return paramString;
      }
      AppMethodBeat.o(243619);
      return null;
    }
    
    public static void mT(boolean paramBoolean)
    {
      AppMethodBeat.i(243618);
      Object localObject1 = g.ah(aj.class);
      p.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((aj)localObject1).getRedDotManager();
      p.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((z)localObject1).daH())
      {
        AppMethodBeat.o(243618);
        return;
      }
      localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      bdo localbdo = ((PluginFinder)localObject1).getRedDotManager().asW("FinderEntrance");
      localObject1 = g.ah(PluginFinder.class);
      p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      k localk = ((PluginFinder)localObject1).getRedDotManager().asX("FinderEntrance");
      localObject1 = y.vXH;
      Object localObject2;
      Object localObject3;
      com.tencent.mm.plugin.finder.report.k localk1;
      int i;
      if (localk != null)
      {
        localObject2 = localk.field_ctrInfo;
        if ((localbdo != null) && (localObject2 != null))
        {
          localObject1 = ((bbi)localObject2).LKM;
          localObject3 = g.ah(PluginFinder.class);
          p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject3).getRedDotManager().asZ("FinderEntrance").report_ext_info;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          p.g(localObject3, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
          localObject4 = i.tLi;
          if (((p.j(i.dbj(), localObject1) ^ true)) || (paramBoolean))
          {
            localk1 = com.tencent.mm.plugin.finder.report.k.vfA;
            i = ((bbi)localObject2).type;
            if (localObject1 != null) {
              break label491;
            }
          }
        }
      }
      label491:
      for (Object localObject4 = "";; localObject4 = localObject1)
      {
        String str = Util.nullAs(localbdo.title, "");
        p.g(str, "Util.nullAs(showInfo.title, \"\")");
        com.tencent.mm.plugin.finder.report.k.a(localk1, "1", i, (String)localObject4, str, ((bbi)localObject2).feedId, "", localbdo.xGz, (String)localObject3);
        localObject2 = j.vft;
        if (localk == null) {
          p.hyc();
        }
        j.a((j)localObject2, "1", localk, localbdo, 1);
        localObject2 = i.tLi;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        p.h(localObject2, "<set-?>");
        i.atf((String)localObject2);
        localObject1 = g.ah(PluginFinder.class);
        p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        localObject3 = ((PluginFinder)localObject1).getRedDotManager().asW("NearbyEntrance");
        localObject1 = g.ah(PluginFinder.class);
        p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        localObject4 = ((PluginFinder)localObject1).getRedDotManager().asX("NearbyEntrance");
        localObject1 = y.vXH;
        if (localObject4 != null) {}
        for (localObject1 = ((k)localObject4).field_ctrInfo;; localObject1 = null)
        {
          if ((localObject3 != null) && (localObject1 != null))
          {
            localObject2 = ((bbi)localObject1).LKM;
            localObject1 = i.tLi;
            if (((p.j(i.dbk(), localObject2) ^ true)) || (paramBoolean))
            {
              localObject1 = j.vft;
              if (localObject4 == null) {
                p.hyc();
              }
              j.a((j)localObject1, "1", (k)localObject4, (bdo)localObject3, 1);
              localObject1 = i.tLi;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              p.h(localObject1, "<set-?>");
              i.atg((String)localObject1);
            }
          }
          AppMethodBeat.o(243618);
          return;
          localObject2 = null;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.i
 * JD-Core Version:    0.7.0.1
 */