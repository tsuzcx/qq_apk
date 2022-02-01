package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static String rRP;
  private static String rRQ;
  private static String rRR;
  private static String rRS;
  public static final a rRT;
  
  static
  {
    AppMethodBeat.i(178149);
    rRT = new a((byte)0);
    rRP = "";
    rRQ = "";
    rRR = "";
    rRS = "";
    AppMethodBeat.o(178149);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "getNotifyCount", "", "hasMentionCount", "", "reportFindPageRedDotClick", "contextId", "reportFindPageRedDotExpose", "", "ignoreDuplicatedId", "reportHomeFollowTabRed", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "autoClick", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
  public static final class a
  {
    public static String a(int paramInt, aqy paramaqy, String paramString)
    {
      AppMethodBeat.i(201604);
      d.g.b.p.h(paramString, "lastExposeTipsId");
      Object localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
      ase localase = ((e)localObject3).ahm("TLPersonalCenter");
      i locali = ((e)localObject3).ahn("TLPersonalCenter");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (locali != null) {
        localObject1 = locali.field_ctrInfo;
      }
      Object localObject2;
      int k;
      int i;
      for (;;)
      {
        if ((localase != null) && (localObject1 != null)) {
          if (paramInt == 1)
          {
            localObject2 = ((aqu)localObject1).GoQ;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (d.g.b.p.i(paramString, localObject1))
            {
              AppMethodBeat.o(201604);
              return localObject1;
              localObject1 = null;
              continue;
            }
            paramString = (String)localObject1;
            localObject1 = com.tencent.mm.plugin.finder.report.g.soH;
            if (locali == null) {
              d.g.b.p.gfZ();
            }
            com.tencent.mm.plugin.finder.report.g.b("2", locali, localase, paramInt, paramaqy, 0, 96);
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            int j = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IIB, 0);
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            k = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IIC, 0);
            localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
            {
              i = 0;
              label233:
              if (j <= 0) {
                break label279;
              }
              localObject1 = h.soM;
              h.a("2", 1, paramInt, 1, i, j, null, null, 0L, paramaqy, 0, 0, 3520);
              localObject1 = paramString;
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(201604);
        return localObject1;
        i = 2;
        break label233;
        label279:
        if (k > 0)
        {
          localObject1 = h.soM;
          h.a("2", 4, paramInt, 1, i, k, null, null, 0L, paramaqy, 0, 0, 3520);
          localObject1 = paramString;
        }
        else
        {
          localObject2 = ((e)localObject3).ahm("FinderFirstFav");
          localObject3 = ((e)localObject3).ahn("FinderFirstFav");
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (localObject3 != null) {}
          for (localObject1 = ((i)localObject3).field_ctrInfo;; localObject1 = null)
          {
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject1 = h.soM;
              h.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, paramaqy, 0, 0, 3520);
              localObject1 = com.tencent.mm.plugin.finder.report.g.soH;
              if (localObject3 == null) {
                d.g.b.p.gfZ();
              }
              com.tencent.mm.plugin.finder.report.g.b("2", (i)localObject3, (ase)localObject2, paramInt, paramaqy, 0, 96);
            }
            localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
            d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject2 = ((PluginFinder)localObject1).getRedDotManager().ahm("TLCamera");
            localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
            d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject3 = ((PluginFinder)localObject1).getRedDotManager().ahn("TLCamera");
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject1 = paramString;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramString;
            if (localObject3 == null) {
              break;
            }
            localObject1 = h.soM;
            h.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, paramaqy, 0, 0, 3520);
            localObject1 = com.tencent.mm.plugin.finder.report.g.soH;
            com.tencent.mm.plugin.finder.report.g.b("2", (i)localObject3, (ase)localObject2, paramInt, paramaqy, 0, 96);
            localObject1 = paramString;
            break;
          }
          paramString = "";
          break;
          localObject1 = "";
        }
      }
    }
    
    public static void a(int paramInt, aqy paramaqy)
    {
      AppMethodBeat.i(201603);
      d.g.b.p.h(paramaqy, "contextObj");
      Object localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ase localase = ((e)localObject1).ahm("TLLbsTab");
      i locali = ((e)localObject1).ahn("TLLbsTab");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (locali != null) {}
      for (localObject1 = locali.field_ctrInfo;; localObject1 = null)
      {
        if ((localase != null) && (localObject1 != null))
        {
          Object localObject2 = h.soM;
          localObject2 = ((aqu)localObject1).GoQ;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          h.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, paramaqy, 0, 0, 3456);
          localObject1 = com.tencent.mm.plugin.finder.report.g.soH;
          if (locali == null) {
            d.g.b.p.gfZ();
          }
          com.tencent.mm.plugin.finder.report.g.b("2", locali, localase, paramInt, paramaqy, 2, 32);
        }
        AppMethodBeat.o(201603);
        return;
      }
    }
    
    public static void a(int paramInt1, aqy paramaqy, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(201600);
      d.g.b.p.h(paramaqy, "contextObj");
      Object localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ase localase = ((e)localObject1).ahm("TLRecommendTab");
      i locali = ((e)localObject1).ahn("TLRecommendTab");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      Object localObject2;
      if (locali != null) {
        localObject2 = locali.field_ctrInfo;
      }
      while ((localase != null) && (localObject2 != null))
      {
        Object localObject3 = ((aqu)localObject2).GoQ;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        if (paramInt1 == 2)
        {
          localObject3 = d.rRT;
          if (d.g.b.p.i(d.czH(), localObject1))
          {
            AppMethodBeat.o(201600);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = h.soM;
        long l = ((aqu)localObject2).dtq;
        if (!paramBoolean) {
          break label236;
        }
        i = 1;
        h.a("2", 8, paramInt1, 1, 0, 0, (String)localObject1, null, l, paramaqy, paramInt2, i, 128);
        localObject2 = com.tencent.mm.plugin.finder.report.g.soH;
        if (locali == null) {
          d.g.b.p.gfZ();
        }
        if (!paramBoolean) {
          break label242;
        }
      }
      label236:
      label242:
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.report.g.a("2", locali, localase, paramInt1, paramaqy, i, paramInt2);
        if (paramInt1 == 2)
        {
          paramaqy = d.rRT;
          d.g.b.p.h(localObject1, "<set-?>");
          d.ahg((String)localObject1);
        }
        AppMethodBeat.o(201600);
        return;
        i = 0;
        break;
      }
    }
    
    public static String ahk(String paramString)
    {
      AppMethodBeat.i(201606);
      d.g.b.p.h(paramString, "contextId");
      Object localObject1 = com.tencent.mm.kernel.g.ad(t.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((t)localObject1).getRedDotManager();
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((o)localObject1).czR())
      {
        AppMethodBeat.o(201606);
        return null;
      }
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ase localase = ((PluginFinder)localObject1).getRedDotManager().ahm("FinderEntrance");
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      i locali = ((PluginFinder)localObject1).getRedDotManager().ahn("FinderEntrance");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (locali != null) {}
      for (localObject1 = locali.field_ctrInfo; (localase != null) && (localObject1 != null); localObject1 = null)
      {
        Object localObject2 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
        Object localObject3 = ((PluginFinder)localObject2).getRedDotManager().aho("FinderEntrance").Gqq;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = h.soM;
        int i = ((aqu)localObject1).type;
        localObject3 = ((aqu)localObject1).GoQ;
        d.g.b.p.g(localObject3, "ctrInfo.tips_id");
        String str = bt.bI(localase.title, "");
        d.g.b.p.g(str, "Util.nullAs(showInfo.title, \"\")");
        h.a("1", i, 2, (String)localObject3, str, ((aqu)localObject1).dtq, paramString, localase.uda, (String)localObject2);
        localObject2 = com.tencent.mm.plugin.finder.report.g.soH;
        if (locali == null) {
          d.g.b.p.gfZ();
        }
        com.tencent.mm.plugin.finder.report.g.a("1", locali, localase, 2, paramString);
        paramString = ((aqu)localObject1).GoQ;
        AppMethodBeat.o(201606);
        return paramString;
      }
      AppMethodBeat.o(201606);
      return null;
    }
    
    public static void b(int paramInt1, aqy paramaqy, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(201601);
      d.g.b.p.h(paramaqy, "contextObj");
      Object localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ase localase = ((e)localObject1).ahm("TLFollow");
      i locali = ((e)localObject1).ahn("TLFollow");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      Object localObject2;
      if (locali != null) {
        localObject2 = locali.field_ctrInfo;
      }
      while ((localase != null) && (localObject2 != null))
      {
        Object localObject3 = ((aqu)localObject2).GoQ;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        if (paramInt1 == 2)
        {
          localObject3 = d.rRT;
          if (d.g.b.p.i(d.czI(), localObject1))
          {
            AppMethodBeat.o(201601);
            return;
            localObject2 = null;
            continue;
          }
        }
        localObject3 = h.soM;
        long l = ((aqu)localObject2).dtq;
        if (!paramBoolean) {
          break label241;
        }
        i = 1;
        h.a("2", 7, paramInt1, 1, 0, 0, (String)localObject1, null, l, paramaqy, paramInt2, i, 128);
        localObject2 = com.tencent.mm.plugin.finder.report.g.soH;
        if (locali == null) {
          d.g.b.p.gfZ();
        }
        if (!paramBoolean) {
          break label247;
        }
      }
      label241:
      label247:
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.report.g.a("2", locali, localase, paramInt1, paramaqy, i, paramInt2);
        if (paramInt1 == 2)
        {
          paramaqy = d.rRT;
          d.g.b.p.h(localObject1, "<set-?>");
          d.ahh((String)localObject1);
        }
        AppMethodBeat.o(201601);
        return;
        i = 0;
        break;
      }
    }
    
    public static void c(int paramInt1, aqy paramaqy, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(201602);
      d.g.b.p.h(paramaqy, "contextObj");
      Object localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      ase localase = ((e)localObject1).ahm("TLMachineTab");
      i locali = ((e)localObject1).ahn("TLMachineTab");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      Object localObject2;
      if (locali != null)
      {
        localObject2 = locali.field_ctrInfo;
        if ((localase == null) || (localObject2 == null)) {
          break label241;
        }
        localObject1 = ((aqu)localObject2).GoQ;
        if (localObject1 != null) {
          break label260;
        }
        localObject1 = "";
      }
      label260:
      for (;;)
      {
        if (paramInt1 == 2)
        {
          localObject3 = d.rRT;
          if (d.g.b.p.i(d.czJ(), localObject1))
          {
            AppMethodBeat.o(201602);
            return;
            localObject2 = null;
            break;
          }
        }
        Object localObject3 = h.soM;
        localObject3 = ((aqu)localObject2).GoQ;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (paramBoolean)
        {
          i = 1;
          h.a("2", 3, paramInt1, 1, 2, 0, (String)localObject2, null, 0L, paramaqy, paramInt2, i, 384);
          localObject2 = com.tencent.mm.plugin.finder.report.g.soH;
          if (locali == null) {
            d.g.b.p.gfZ();
          }
          if (!paramBoolean) {
            break label254;
          }
        }
        label241:
        label254:
        for (int i = 1;; i = 0)
        {
          com.tencent.mm.plugin.finder.report.g.a("2", locali, localase, paramInt1, paramaqy, i, paramInt2);
          if (paramInt1 == 2)
          {
            paramaqy = d.rRT;
            d.g.b.p.h(localObject1, "<set-?>");
            d.ahi((String)localObject1);
          }
          AppMethodBeat.o(201602);
          return;
          i = 0;
          break;
        }
      }
    }
    
    public static int[] czL()
    {
      AppMethodBeat.i(201598);
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(locale, "MMKernel.storage()");
      int i = locale.ajl().getInt(al.a.IIB, 0);
      locale = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(locale, "MMKernel.storage()");
      int j = locale.ajl().getInt(al.a.IIC, 0);
      AppMethodBeat.o(201598);
      return new int[] { i, j };
    }
    
    public static boolean czM()
    {
      AppMethodBeat.i(201599);
      int[] arrayOfInt = czL();
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
        AppMethodBeat.o(201599);
        return true;
      }
      AppMethodBeat.o(201599);
      return false;
    }
    
    public static void lM(boolean paramBoolean)
    {
      AppMethodBeat.i(201605);
      Object localObject1 = com.tencent.mm.kernel.g.ad(t.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((t)localObject1).getRedDotManager();
      d.g.b.p.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((o)localObject1).czR())
      {
        AppMethodBeat.o(201605);
        return;
      }
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ase localase = ((PluginFinder)localObject1).getRedDotManager().ahm("FinderEntrance");
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      i locali = ((PluginFinder)localObject1).getRedDotManager().ahn("FinderEntrance");
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (locali != null) {}
      for (localObject1 = locali.field_ctrInfo;; localObject1 = null)
      {
        if ((localase != null) && (localObject1 != null))
        {
          String str = ((aqu)localObject1).GoQ;
          Object localObject2 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          d.g.b.p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
          Object localObject3 = ((PluginFinder)localObject2).getRedDotManager().aho("FinderEntrance").Gqq;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject3 = d.rRT;
          if (((d.g.b.p.i(d.czK(), str) ^ true)) || (paramBoolean))
          {
            localObject3 = h.soM;
            int i = ((aqu)localObject1).type;
            d.g.b.p.g(str, "tipsId");
            localObject3 = bt.bI(localase.title, "");
            d.g.b.p.g(localObject3, "Util.nullAs(showInfo.title, \"\")");
            h.a("1", i, 1, str, (String)localObject3, ((aqu)localObject1).dtq, "", localase.uda, (String)localObject2);
            localObject1 = com.tencent.mm.plugin.finder.report.g.soH;
            if (locali == null) {
              d.g.b.p.gfZ();
            }
            com.tencent.mm.plugin.finder.report.g.a("1", locali, localase);
            localObject1 = d.rRT;
            d.g.b.p.h(str, "<set-?>");
            d.ahj(str);
          }
        }
        AppMethodBeat.o(201605);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */