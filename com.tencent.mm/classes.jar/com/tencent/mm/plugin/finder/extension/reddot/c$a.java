package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "getNotifyCount", "", "hasMentionCount", "", "reportFindPageRedDotClick", "contextId", "reportFindPageRedDotExpose", "", "ignoreDuplicatedId", "reportHomeFollowTabRed", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "autoClick", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class c$a
{
  public static String a(int paramInt, anm paramanm, String paramString)
  {
    AppMethodBeat.i(201447);
    k.h(paramString, "lastExposeTipsId");
    Object localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = ((d)localObject3).adw("TLPersonalCenter");
    localObject1 = ((d)localObject3).adx("TLPersonalCenter");
    n localn = n.rPN;
    if (localObject1 != null) {
      localObject1 = ((h)localObject1).field_ctrInfo;
    }
    int k;
    int i;
    for (;;)
    {
      if ((localObject2 != null) && (localObject1 != null)) {
        if (paramInt == 1)
        {
          localObject2 = ((ani)localObject1).EGt;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (k.g(paramString, localObject1))
          {
            AppMethodBeat.o(201447);
            return localObject1;
            localObject1 = null;
            continue;
          }
          paramString = (String)localObject1;
          localObject1 = g.agR();
          k.g(localObject1, "MMKernel.storage()");
          int j = ((e)localObject1).agA().getInt(ah.a.GVL, 0);
          localObject1 = g.agR();
          k.g(localObject1, "MMKernel.storage()");
          k = ((e)localObject1).agA().getInt(ah.a.GVM, 0);
          localObject1 = b.rCU;
          if (b.czT())
          {
            i = 0;
            label196:
            if (j <= 0) {
              break label242;
            }
            localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.a("2", 1, paramInt, 1, i, j, null, null, 0L, paramanm, 0, 0, 3520);
            localObject1 = paramString;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201447);
      return localObject1;
      i = 2;
      break label196;
      label242:
      if (k > 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.a("2", 4, paramInt, 1, i, k, null, null, 0L, paramanm, 0, 0, 3520);
        localObject1 = paramString;
      }
      else
      {
        localObject2 = ((d)localObject3).adw("FinderFirstFav");
        localObject1 = ((d)localObject3).adx("FinderFirstFav");
        localObject3 = n.rPN;
        if (localObject1 != null) {}
        for (localObject1 = ((h)localObject1).field_ctrInfo;; localObject1 = null)
        {
          if ((localObject2 != null) && (localObject1 != null))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, paramanm, 0, 0, 3520);
          }
          localObject1 = g.ad(PluginFinder.class);
          k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
          localObject2 = ((PluginFinder)localObject1).getRedDotManager().adw("TLCamera");
          localObject1 = g.ad(PluginFinder.class);
          k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
          localObject3 = ((PluginFinder)localObject1).getRedDotManager().adx("TLCamera");
          localObject1 = n.rPN;
          localObject1 = paramString;
          if (localObject2 == null) {
            break;
          }
          localObject1 = paramString;
          if (localObject3 == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, paramanm, 0, 0, 3520);
          localObject1 = paramString;
          break;
        }
        paramString = "";
        break;
        localObject1 = "";
      }
    }
  }
  
  public static void a(int paramInt, anm paramanm)
  {
    AppMethodBeat.i(201446);
    k.h(paramanm, "contextObj");
    Object localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = ((d)localObject1).adw("TLLbsTab");
    localObject1 = ((d)localObject1).adx("TLLbsTab");
    n localn = n.rPN;
    if (localObject1 != null) {}
    for (localObject1 = ((h)localObject1).field_ctrInfo;; localObject1 = null)
    {
      if ((localObject2 != null) && (localObject1 != null))
      {
        localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
        localObject2 = ((ani)localObject1).EGt;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.finder.report.d.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, paramanm, 0, 0, 3456);
      }
      AppMethodBeat.o(201446);
      return;
    }
  }
  
  public static void a(int paramInt1, anm paramanm, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(201443);
    k.h(paramanm, "contextObj");
    Object localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = ((d)localObject1).adw("TLRecommendTab");
    localObject1 = ((d)localObject1).adx("TLRecommendTab");
    Object localObject3 = n.rPN;
    if (localObject1 != null) {
      localObject1 = ((h)localObject1).field_ctrInfo;
    }
    long l;
    while ((localObject2 != null) && (localObject1 != null))
    {
      localObject3 = ((ani)localObject1).EGt;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      if (paramInt1 == 2)
      {
        localObject3 = c.rem;
        if (k.g(c.ctz(), localObject2))
        {
          AppMethodBeat.o(201443);
          return;
          localObject1 = null;
          continue;
        }
      }
      localObject3 = com.tencent.mm.plugin.finder.report.d.rxr;
      l = ((ani)localObject1).dig;
      if (!paramBoolean) {
        break label202;
      }
    }
    label202:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.d.a("2", 8, paramInt1, 1, 0, 0, (String)localObject2, null, l, paramanm, paramInt2, i, 128);
      if (paramInt1 == 2)
      {
        paramanm = c.rem;
        k.h(localObject2, "<set-?>");
        c.adq((String)localObject2);
      }
      AppMethodBeat.o(201443);
      return;
    }
  }
  
  public static String adu(String paramString)
  {
    AppMethodBeat.i(201449);
    k.h(paramString, "contextId");
    Object localObject1 = g.ad(com.tencent.mm.plugin.i.a.l.class);
    k.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
    localObject1 = ((com.tencent.mm.plugin.i.a.l)localObject1).getRedDotManager();
    k.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
    if (!((j)localObject1).ctK())
    {
      AppMethodBeat.o(201449);
      return null;
    }
    localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    aon localaon = ((PluginFinder)localObject1).getRedDotManager().adw("FinderEntrance");
    localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager().adx("FinderEntrance");
    Object localObject2 = n.rPN;
    if (localObject1 != null) {}
    for (localObject1 = ((h)localObject1).field_ctrInfo; (localaon != null) && (localObject1 != null); localObject1 = null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
      int i = ((ani)localObject1).type;
      localObject2 = ((ani)localObject1).EGt;
      k.g(localObject2, "ctrInfo.tips_id");
      String str = bs.bG(localaon.title, "");
      k.g(str, "Util.nullAs(showInfo.title, \"\")");
      com.tencent.mm.plugin.finder.report.d.a("1", i, 2, (String)localObject2, str, ((ani)localObject1).dig, paramString, localaon.tfk);
      paramString = ((ani)localObject1).EGt;
      AppMethodBeat.o(201449);
      return paramString;
    }
    AppMethodBeat.o(201449);
    return null;
  }
  
  public static void b(int paramInt1, anm paramanm, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(201444);
    k.h(paramanm, "contextObj");
    Object localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = ((d)localObject1).adw("TLFollow");
    localObject1 = ((d)localObject1).adx("TLFollow");
    Object localObject3 = n.rPN;
    if (localObject1 != null) {
      localObject1 = ((h)localObject1).field_ctrInfo;
    }
    long l;
    while ((localObject2 != null) && (localObject1 != null))
    {
      localObject3 = ((ani)localObject1).EGt;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      if (paramInt1 == 2)
      {
        localObject3 = c.rem;
        if (k.g(c.ctA(), localObject2))
        {
          AppMethodBeat.o(201444);
          return;
          localObject1 = null;
          continue;
        }
      }
      localObject3 = com.tencent.mm.plugin.finder.report.d.rxr;
      l = ((ani)localObject1).dig;
      if (!paramBoolean) {
        break label204;
      }
    }
    label204:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.finder.report.d.a("2", 7, paramInt1, 1, 0, 0, (String)localObject2, null, l, paramanm, paramInt2, i, 128);
      if (paramInt1 == 2)
      {
        paramanm = c.rem;
        k.h(localObject2, "<set-?>");
        c.adr((String)localObject2);
      }
      AppMethodBeat.o(201444);
      return;
    }
  }
  
  public static void c(int paramInt1, anm paramanm, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(201445);
    k.h(paramanm, "contextObj");
    Object localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    Object localObject2 = ((d)localObject1).adw("TLMachineTab");
    localObject1 = ((d)localObject1).adx("TLMachineTab");
    Object localObject3 = n.rPN;
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).field_ctrInfo;
      if ((localObject2 == null) || (localObject1 == null)) {
        break label207;
      }
      localObject2 = ((ani)localObject1).EGt;
      if (localObject2 != null) {
        break label220;
      }
      localObject2 = "";
    }
    label207:
    label220:
    for (;;)
    {
      if (paramInt1 == 2)
      {
        localObject3 = c.rem;
        if (k.g(c.ctB(), localObject2))
        {
          AppMethodBeat.o(201445);
          return;
          localObject1 = null;
          break;
        }
      }
      localObject3 = com.tencent.mm.plugin.finder.report.d.rxr;
      localObject3 = ((ani)localObject1).EGt;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.finder.report.d.a("2", 3, paramInt1, 1, 2, 0, (String)localObject1, null, 0L, paramanm, paramInt2, i, 384);
        if (paramInt1 == 2)
        {
          paramanm = c.rem;
          k.h(localObject2, "<set-?>");
          c.ads((String)localObject2);
        }
        AppMethodBeat.o(201445);
        return;
      }
    }
  }
  
  public static int[] ctD()
  {
    AppMethodBeat.i(201441);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GVL, 0);
    locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int j = locale.agA().getInt(ah.a.GVM, 0);
    AppMethodBeat.o(201441);
    return new int[] { i, j };
  }
  
  public static boolean ctE()
  {
    AppMethodBeat.i(201442);
    int[] arrayOfInt = ctD();
    k.h(arrayOfInt, "$this$sum");
    int i = 0;
    int j = 0;
    while (i < 2)
    {
      j += arrayOfInt[i];
      i += 1;
    }
    if (j > 0)
    {
      AppMethodBeat.o(201442);
      return true;
    }
    AppMethodBeat.o(201442);
    return false;
  }
  
  public static void ls(boolean paramBoolean)
  {
    AppMethodBeat.i(201448);
    Object localObject1 = g.ad(com.tencent.mm.plugin.i.a.l.class);
    k.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
    localObject1 = ((com.tencent.mm.plugin.i.a.l)localObject1).getRedDotManager();
    k.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
    if (!((j)localObject1).ctK())
    {
      AppMethodBeat.o(201448);
      return;
    }
    localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    aon localaon = ((PluginFinder)localObject1).getRedDotManager().adw("FinderEntrance");
    localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager().adx("FinderEntrance");
    Object localObject2 = n.rPN;
    if (localObject1 != null) {}
    for (localObject1 = ((h)localObject1).field_ctrInfo;; localObject1 = null)
    {
      if ((localaon != null) && (localObject1 != null))
      {
        localObject2 = ((ani)localObject1).EGt;
        Object localObject3 = c.rem;
        if (((k.g(c.ctC(), localObject2) ^ true)) || (paramBoolean))
        {
          localObject3 = com.tencent.mm.plugin.finder.report.d.rxr;
          int i = ((ani)localObject1).type;
          k.g(localObject2, "tipsId");
          localObject3 = bs.bG(localaon.title, "");
          k.g(localObject3, "Util.nullAs(showInfo.title, \"\")");
          com.tencent.mm.plugin.finder.report.d.a("1", i, 1, (String)localObject2, (String)localObject3, ((ani)localObject1).dig, "", localaon.tfk);
          localObject1 = c.rem;
          k.h(localObject2, "<set-?>");
          c.adt((String)localObject2);
        }
      }
      AppMethodBeat.o(201448);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.c.a
 * JD-Core Version:    0.7.0.1
 */