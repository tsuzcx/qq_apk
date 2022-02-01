package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static String sar;
  private static String sas;
  private static String sat;
  private static String sau;
  public static final a sav;
  
  static
  {
    AppMethodBeat.i(178149);
    sav = new a((byte)0);
    sar = "";
    sas = "";
    sat = "";
    sau = "";
    AppMethodBeat.o(178149);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "getNotifyCount", "", "hasMentionCount", "", "reportFindPageRedDotClick", "contextId", "autoClick", "", "reportFindPageRedDotExpose", "", "ignoreDuplicatedId", "reportHomeFollowTabRed", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
  public static final class a
  {
    public static String a(int paramInt, arn paramarn, String paramString)
    {
      AppMethodBeat.i(202052);
      d.g.b.p.h(paramString, "lastExposeTipsId");
      Object localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
      ast localast = ((e)localObject3).aii("TLPersonalCenter");
      i locali = ((e)localObject3).aij("TLPersonalCenter");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (locali != null) {
        localObject1 = locali.field_ctrInfo;
      }
      Object localObject2;
      int k;
      int i;
      for (;;)
      {
        if ((localast != null) && (localObject1 != null)) {
          if (paramInt == 1)
          {
            localObject2 = ((arj)localObject1).GIg;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (d.g.b.p.i(paramString, localObject1))
            {
              AppMethodBeat.o(202052);
              return localObject1;
              localObject1 = null;
              continue;
            }
            paramString = (String)localObject1;
            localObject1 = h.syO;
            if (locali == null) {
              d.g.b.p.gkB();
            }
            h.a("2", locali, localast, paramInt, paramarn, 0, 0, 96);
            localObject1 = g.ajR();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            int j = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jde, 0);
            localObject1 = g.ajR();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            k = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jdf, 0);
            localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
            {
              i = 0;
              label234:
              if (j <= 0) {
                break label280;
              }
              localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
              com.tencent.mm.plugin.finder.report.i.a("2", 1, paramInt, 1, i, j, null, null, 0L, paramarn, 0, 0, 3520);
              localObject1 = paramString;
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(202052);
        return localObject1;
        i = 2;
        break label234;
        label280:
        if (k > 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
          com.tencent.mm.plugin.finder.report.i.a("2", 4, paramInt, 1, i, k, null, null, 0L, paramarn, 0, 0, 3520);
          localObject1 = paramString;
        }
        else
        {
          localObject2 = ((e)localObject3).aii("FinderFirstFav");
          localObject3 = ((e)localObject3).aij("FinderFirstFav");
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (localObject3 != null) {}
          for (localObject1 = ((i)localObject3).field_ctrInfo;; localObject1 = null)
          {
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
              com.tencent.mm.plugin.finder.report.i.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, paramarn, 0, 0, 3520);
              localObject1 = h.syO;
              if (localObject3 == null) {
                d.g.b.p.gkB();
              }
              h.a("2", (i)localObject3, (ast)localObject2, paramInt, paramarn, 0, 0, 96);
            }
            localObject1 = g.ad(PluginFinder.class);
            d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject2 = ((PluginFinder)localObject1).getRedDotManager().aii("TLCamera");
            localObject1 = g.ad(PluginFinder.class);
            d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject3 = ((PluginFinder)localObject1).getRedDotManager().aij("TLCamera");
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject1 = paramString;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramString;
            if (localObject3 == null) {
              break;
            }
            localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
            com.tencent.mm.plugin.finder.report.i.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, paramarn, 0, 0, 3520);
            localObject1 = h.syO;
            h.a("2", (i)localObject3, (ast)localObject2, paramInt, paramarn, 0, 0, 96);
            localObject1 = paramString;
            break;
          }
          paramString = "";
          break;
          localObject1 = "";
        }
      }
    }
    
    public static void a(int paramInt, arn paramarn)
    {
      AppMethodBeat.i(202051);
      d.g.b.p.h(paramarn, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ast localast = ((e)localObject1).aii("TLLbsTab");
      i locali = ((e)localObject1).aij("TLLbsTab");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (locali != null) {}
      for (localObject1 = locali.field_ctrInfo;; localObject1 = null)
      {
        if ((localast != null) && (localObject1 != null))
        {
          Object localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
          localObject2 = ((arj)localObject1).GIg;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          com.tencent.mm.plugin.finder.report.i.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, paramarn, 0, 0, 3456);
          localObject1 = h.syO;
          if (locali == null) {
            d.g.b.p.gkB();
          }
          h.a("2", locali, localast, paramInt, paramarn, 0, 2, 32);
        }
        AppMethodBeat.o(202051);
        return;
      }
    }
    
    public static void a(int paramInt1, arn paramarn, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(202048);
      d.g.b.p.h(paramarn, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ast localast = ((e)localObject1).aii("TLRecommendTab");
      i locali = ((e)localObject1).aij("TLRecommendTab");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      Object localObject2;
      if (locali != null) {
        localObject2 = locali.field_ctrInfo;
      }
      while ((localast != null) && (localObject2 != null))
      {
        Object localObject3 = ((arj)localObject2).GIg;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        d.g.b.p.g(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = d.sav;
          if (d.g.b.p.i(d.cBl(), localObject1))
          {
            AppMethodBeat.o(202048);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = com.tencent.mm.plugin.finder.report.i.syT;
        long l = ((arj)localObject2).duw;
        if (!paramBoolean) {
          break label243;
        }
        i = 1;
        com.tencent.mm.plugin.finder.report.i.a("2", 8, paramInt1, 1, 0, 0, (String)localObject1, null, l, paramarn, paramInt2, i, 128);
        localObject2 = h.syO;
        if (locali == null) {
          d.g.b.p.gkB();
        }
        if (!paramBoolean) {
          break label249;
        }
      }
      label243:
      label249:
      for (int i = 1;; i = 0)
      {
        h.a("2", locali, localast, paramInt1, paramarn, i, paramInt2);
        if (paramInt1 == 2)
        {
          paramarn = d.sav;
          d.g.b.p.h(localObject1, "<set-?>");
          d.aid((String)localObject1);
        }
        AppMethodBeat.o(202048);
        return;
        i = 0;
        break;
      }
    }
    
    public static void b(int paramInt1, arn paramarn, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(202049);
      d.g.b.p.h(paramarn, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ast localast = ((e)localObject1).aii("TLFollow");
      i locali = ((e)localObject1).aij("TLFollow");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      Object localObject2;
      if (locali != null) {
        localObject2 = locali.field_ctrInfo;
      }
      while ((localast != null) && (localObject2 != null))
      {
        Object localObject3 = ((arj)localObject2).GIg;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        d.g.b.p.g(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = d.sav;
          if (d.g.b.p.i(d.cBm(), localObject1))
          {
            AppMethodBeat.o(202049);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = com.tencent.mm.plugin.finder.report.i.syT;
        long l = ((arj)localObject2).duw;
        if (!paramBoolean) {
          break label243;
        }
        i = 1;
        com.tencent.mm.plugin.finder.report.i.a("2", 7, paramInt1, 1, 0, 0, (String)localObject1, null, l, paramarn, paramInt2, i, 128);
        localObject2 = h.syO;
        if (locali == null) {
          d.g.b.p.gkB();
        }
        if (!paramBoolean) {
          break label249;
        }
      }
      label243:
      label249:
      for (int i = 1;; i = 0)
      {
        h.a("2", locali, localast, paramInt1, paramarn, i, paramInt2);
        if (paramInt1 == 2)
        {
          paramarn = d.sav;
          d.g.b.p.h(localObject1, "<set-?>");
          d.aie((String)localObject1);
        }
        AppMethodBeat.o(202049);
        return;
        i = 0;
        break;
      }
    }
    
    public static void c(int paramInt1, arn paramarn, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(202050);
      d.g.b.p.h(paramarn, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ast localast = ((e)localObject1).aii("TLMachineTab");
      i locali = ((e)localObject1).aij("TLMachineTab");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      Object localObject2;
      if (locali != null)
      {
        localObject2 = locali.field_ctrInfo;
        if ((localast == null) || (localObject2 == null)) {
          break label244;
        }
        localObject1 = ((arj)localObject2).GIg;
        if (localObject1 != null) {
          break label262;
        }
        localObject1 = "";
      }
      label256:
      label262:
      for (;;)
      {
        d.g.b.p.g(localObject1, "ctrInfo.tips_id ?: \"\"");
        if (paramInt1 == 2)
        {
          localObject3 = d.sav;
          if (d.g.b.p.i(d.cBn(), localObject1))
          {
            AppMethodBeat.o(202050);
            return;
            localObject2 = null;
            break;
          }
        }
        Object localObject3 = com.tencent.mm.plugin.finder.report.i.syT;
        localObject3 = ((arj)localObject2).GIg;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (paramBoolean)
        {
          i = 1;
          com.tencent.mm.plugin.finder.report.i.a("2", 3, paramInt1, 1, 2, 0, (String)localObject2, null, 0L, paramarn, paramInt2, i, 384);
          localObject2 = h.syO;
          if (locali == null) {
            d.g.b.p.gkB();
          }
          if (!paramBoolean) {
            break label256;
          }
        }
        for (int i = 1;; i = 0)
        {
          h.a("2", locali, localast, paramInt1, paramarn, i, paramInt2);
          if (paramInt1 == 2)
          {
            paramarn = d.sav;
            d.g.b.p.h(localObject1, "<set-?>");
            d.aif((String)localObject1);
          }
          label244:
          AppMethodBeat.o(202050);
          return;
          i = 0;
          break;
        }
      }
    }
    
    public static int[] cBp()
    {
      AppMethodBeat.i(202046);
      com.tencent.mm.kernel.e locale = g.ajR();
      d.g.b.p.g(locale, "MMKernel.storage()");
      int i = locale.ajA().getInt(am.a.Jde, 0);
      locale = g.ajR();
      d.g.b.p.g(locale, "MMKernel.storage()");
      int j = locale.ajA().getInt(am.a.Jdf, 0);
      AppMethodBeat.o(202046);
      return new int[] { i, j };
    }
    
    public static boolean cBq()
    {
      AppMethodBeat.i(202047);
      int[] arrayOfInt = cBp();
      d.g.b.p.h(arrayOfInt, "$this$sum");
      int i = 0;
      int j = 0;
      while (i < 2)
      {
        j += arrayOfInt[i];
        i += 1;
      }
      if (j > 0)
      {
        AppMethodBeat.o(202047);
        return true;
      }
      AppMethodBeat.o(202047);
      return false;
    }
    
    public static String jdMethod_do(String paramString, int paramInt)
    {
      AppMethodBeat.i(202054);
      d.g.b.p.h(paramString, "contextId");
      Object localObject1 = g.ad(t.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((t)localObject1).getRedDotManager();
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((o)localObject1).cBv())
      {
        AppMethodBeat.o(202054);
        return null;
      }
      localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ast localast = ((PluginFinder)localObject1).getRedDotManager().aii("FinderEntrance");
      localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      i locali = ((PluginFinder)localObject1).getRedDotManager().aij("FinderEntrance");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (locali != null) {}
      for (localObject1 = locali.field_ctrInfo; (localast != null) && (localObject1 != null); localObject1 = null)
      {
        Object localObject2 = g.ad(PluginFinder.class);
        d.g.b.p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
        Object localObject3 = ((PluginFinder)localObject2).getRedDotManager().aik("FinderEntrance").GJL;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        d.g.b.p.g(localObject2, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
        localObject3 = com.tencent.mm.plugin.finder.report.i.syT;
        int i = ((arj)localObject1).type;
        String str = ((arj)localObject1).GIg;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        str = bu.bI(localast.title, "");
        d.g.b.p.g(str, "Util.nullAs(showInfo.title, \"\")");
        com.tencent.mm.plugin.finder.report.i.a("1", i, 2, (String)localObject3, str, ((arj)localObject1).duw, paramString, localast.uoi, (String)localObject2, paramInt);
        localObject2 = h.syO;
        if (locali == null) {
          d.g.b.p.gkB();
        }
        h.a("1", locali, localast, 2, paramString, paramInt);
        paramString = ((arj)localObject1).GIg;
        AppMethodBeat.o(202054);
        return paramString;
      }
      AppMethodBeat.o(202054);
      return null;
    }
    
    public static void lM(boolean paramBoolean)
    {
      AppMethodBeat.i(202053);
      Object localObject1 = g.ad(t.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((t)localObject1).getRedDotManager();
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((o)localObject1).cBv())
      {
        AppMethodBeat.o(202053);
        return;
      }
      localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ast localast = ((PluginFinder)localObject1).getRedDotManager().aii("FinderEntrance");
      localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      i locali = ((PluginFinder)localObject1).getRedDotManager().aij("FinderEntrance");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      Object localObject2;
      Object localObject3;
      int i;
      if (locali != null)
      {
        localObject2 = locali.field_ctrInfo;
        if ((localast != null) && (localObject2 != null))
        {
          localObject1 = ((arj)localObject2).GIg;
          localObject3 = g.ad(PluginFinder.class);
          d.g.b.p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
          localObject4 = ((PluginFinder)localObject3).getRedDotManager().aik("FinderEntrance").GJL;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          d.g.b.p.g(localObject3, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
          localObject4 = d.sav;
          if (((d.g.b.p.i(d.cBo(), localObject1) ^ true)) || (paramBoolean))
          {
            localObject4 = com.tencent.mm.plugin.finder.report.i.syT;
            i = ((arj)localObject2).type;
            if (localObject1 != null) {
              break label331;
            }
          }
        }
      }
      label331:
      for (Object localObject4 = "";; localObject4 = localObject1)
      {
        String str = bu.bI(localast.title, "");
        d.g.b.p.g(str, "Util.nullAs(showInfo.title, \"\")");
        com.tencent.mm.plugin.finder.report.i.a("1", i, (String)localObject4, str, ((arj)localObject2).duw, "", localast.uoi, (String)localObject3);
        localObject2 = h.syO;
        if (locali == null) {
          d.g.b.p.gkB();
        }
        h.a("1", locali, localast, 1);
        localObject2 = d.sav;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        d.g.b.p.h(localObject2, "<set-?>");
        d.aig((String)localObject2);
        AppMethodBeat.o(202053);
        return;
        localObject2 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */