package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static String KMs;
  public static final a qtb;
  
  static
  {
    AppMethodBeat.i(178149);
    qtb = new a((byte)0);
    KMs = "";
    AppMethodBeat.o(178149);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotLogic$Companion;", "", "()V", "TAG", "", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "()Ljava/lang/String;", "setLastFindPageExposeTipsId", "(Ljava/lang/String;)V", "getNotifyCount", "", "hasMentionCount", "", "reportFindPageRedDotClick", "contextId", "reportFindPageRedDotExpose", "", "ignoreDuplicatedId", "reportHomeFollowTabRed", "action", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "plugin-finder_release"})
  public static final class a
  {
    public static String a(int paramInt, dzp paramdzp, String paramString)
    {
      AppMethodBeat.i(197565);
      k.h(paramString, "lastExposeTipsId");
      Object localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject3 = ((PluginFinder)localObject1).getRedDotManager();
      Object localObject2 = ((c)localObject3).YV("TLPersonalCenter");
      localObject1 = ((c)localObject3).YW("TLPersonalCenter");
      i locali = i.qTa;
      if (localObject1 != null) {
        localObject1 = ((f)localObject1).field_ctrInfo;
      }
      int k;
      int i;
      for (;;)
      {
        if ((localObject2 != null) && (localObject1 != null)) {
          if (paramInt == 1)
          {
            localObject2 = ((akv)localObject1).Dmu;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            if (k.g(paramString, localObject1))
            {
              AppMethodBeat.o(197565);
              return localObject1;
              localObject1 = null;
              continue;
            }
            paramString = (String)localObject1;
            localObject1 = g.afB();
            k.g(localObject1, "MMKernel.storage()");
            int j = ((e)localObject1).afk().getInt(ae.a.LBn, 0);
            localObject1 = g.afB();
            k.g(localObject1, "MMKernel.storage()");
            k = ((e)localObject1).afk().getInt(ae.a.LBo, 0);
            localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
            if (com.tencent.mm.plugin.finder.storage.b.fUw())
            {
              i = 0;
              label196:
              if (j <= 0) {
                break label241;
              }
              localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
              com.tencent.mm.plugin.finder.report.b.a("2", 1, paramInt, 1, i, j, null, null, 0L, paramdzp, 0, 1472);
              localObject1 = paramString;
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(197565);
        return localObject1;
        i = 2;
        break label196;
        label241:
        if (k > 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.a("2", 4, paramInt, 1, i, k, null, null, 0L, paramdzp, 0, 1472);
          localObject1 = paramString;
        }
        else
        {
          localObject2 = ((c)localObject3).YV("FinderFirstFav");
          localObject1 = ((c)localObject3).YW("FinderFirstFav");
          localObject3 = i.qTa;
          if (localObject1 != null) {}
          for (localObject1 = ((f)localObject1).field_ctrInfo;; localObject1 = null)
          {
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
              com.tencent.mm.plugin.finder.report.b.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, paramdzp, 0, 1472);
            }
            localObject1 = g.ad(PluginFinder.class);
            k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject2 = ((PluginFinder)localObject1).getRedDotManager().YV("TLCamera");
            localObject1 = g.ad(PluginFinder.class);
            k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
            localObject3 = ((PluginFinder)localObject1).getRedDotManager().YW("TLCamera");
            localObject1 = i.qTa;
            localObject1 = paramString;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramString;
            if (localObject3 == null) {
              break;
            }
            localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
            com.tencent.mm.plugin.finder.report.b.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, paramdzp, 0, 1472);
            localObject1 = paramString;
            break;
          }
          paramString = "";
          break;
          localObject1 = "";
        }
      }
    }
    
    public static void a(int paramInt, dzp paramdzp)
    {
      AppMethodBeat.i(197564);
      k.h(paramdzp, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      Object localObject2 = ((c)localObject1).YV("TLLbsTab");
      localObject1 = ((c)localObject1).YW("TLLbsTab");
      i locali = i.qTa;
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).field_ctrInfo;; localObject1 = null)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          localObject2 = ((akv)localObject1).Dmu;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          com.tencent.mm.plugin.finder.report.b.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, paramdzp, 0, 1408);
        }
        AppMethodBeat.o(197564);
        return;
      }
    }
    
    public static void a(int paramInt1, dzp paramdzp, int paramInt2)
    {
      AppMethodBeat.i(197561);
      k.h(paramdzp, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      Object localObject2 = ((c)localObject1).YV("TLRecommendTab");
      localObject1 = ((c)localObject1).YW("TLRecommendTab");
      Object localObject3 = i.qTa;
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).field_ctrInfo;; localObject1 = null)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          localObject3 = ((akv)localObject1).Dmu;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          com.tencent.mm.plugin.finder.report.b.a("2", 8, paramInt1, 1, 0, 0, (String)localObject2, null, ((akv)localObject1).feedId, paramdzp, paramInt2, 128);
        }
        AppMethodBeat.o(197561);
        return;
      }
    }
    
    public static String aVj(String paramString)
    {
      AppMethodBeat.i(197567);
      k.h(paramString, "contextId");
      Object localObject1 = g.ad(j.class);
      k.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((j)localObject1).getRedDotManager();
      k.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((h)localObject1).fSK())
      {
        AppMethodBeat.o(197567);
        return null;
      }
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)localObject1).getRedDotManager().YV("FinderEntrance");
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().YW("FinderEntrance");
      Object localObject3 = i.qTa;
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).field_ctrInfo; (localObject2 != null) && (localObject1 != null); localObject1 = null)
      {
        localObject3 = com.tencent.mm.plugin.finder.report.b.qFq;
        int i = ((akv)localObject1).type;
        localObject3 = ((akv)localObject1).Dmu;
        k.g(localObject3, "ctrInfo.tips_id");
        localObject2 = bt.by(((aln)localObject2).title, "");
        k.g(localObject2, "Util.nullAs(showInfo.title, \"\")");
        com.tencent.mm.plugin.finder.report.b.a("1", i, 2, (String)localObject3, (String)localObject2, ((akv)localObject1).feedId, paramString);
        paramString = ((akv)localObject1).Dmu;
        AppMethodBeat.o(197567);
        return paramString;
      }
      AppMethodBeat.o(197567);
      return null;
    }
    
    public static void b(int paramInt1, dzp paramdzp, int paramInt2)
    {
      AppMethodBeat.i(197562);
      k.h(paramdzp, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      Object localObject2 = ((c)localObject1).YV("TLFollow");
      localObject1 = ((c)localObject1).YW("TLFollow");
      Object localObject3 = i.qTa;
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).field_ctrInfo;; localObject1 = null)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          localObject3 = ((akv)localObject1).Dmu;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          com.tencent.mm.plugin.finder.report.b.a("2", 7, paramInt1, 1, 0, 0, (String)localObject2, null, ((akv)localObject1).feedId, paramdzp, paramInt2, 128);
        }
        AppMethodBeat.o(197562);
        return;
      }
    }
    
    public static void c(int paramInt1, dzp paramdzp, int paramInt2)
    {
      AppMethodBeat.i(197563);
      k.h(paramdzp, "contextObj");
      Object localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager();
      Object localObject2 = ((c)localObject1).YV("TLMachineTab");
      localObject1 = ((c)localObject1).YW("TLMachineTab");
      i locali = i.qTa;
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).field_ctrInfo;; localObject1 = null)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          localObject2 = ((akv)localObject1).Dmu;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          com.tencent.mm.plugin.finder.report.b.a("2", 3, paramInt1, 1, 2, 0, (String)localObject1, null, 0L, paramdzp, paramInt2, 384);
        }
        AppMethodBeat.o(197563);
        return;
      }
    }
    
    public static int[] fSG()
    {
      AppMethodBeat.i(197559);
      e locale = g.afB();
      k.g(locale, "MMKernel.storage()");
      int i = locale.afk().getInt(ae.a.LBn, 0);
      locale = g.afB();
      k.g(locale, "MMKernel.storage()");
      int j = locale.afk().getInt(ae.a.LBo, 0);
      AppMethodBeat.o(197559);
      return new int[] { i, j };
    }
    
    public static boolean fSH()
    {
      AppMethodBeat.i(197560);
      int[] arrayOfInt = fSG();
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
        AppMethodBeat.o(197560);
        return true;
      }
      AppMethodBeat.o(197560);
      return false;
    }
    
    public static void yz(boolean paramBoolean)
    {
      AppMethodBeat.i(197566);
      Object localObject1 = g.ad(j.class);
      k.g(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((j)localObject1).getRedDotManager();
      k.g(localObject1, "MMKernel.plugin(IPluginF…class.java).redDotManager");
      if (!((h)localObject1).fSK())
      {
        AppMethodBeat.o(197566);
        return;
      }
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      Object localObject2 = ((PluginFinder)localObject1).getRedDotManager().YV("FinderEntrance");
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().YW("FinderEntrance");
      Object localObject3 = i.qTa;
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).field_ctrInfo;; localObject1 = null)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject3 = ((akv)localObject1).Dmu;
          Object localObject4 = b.qtb;
          if (((k.g(b.fSF(), localObject3) ^ true)) || (paramBoolean))
          {
            localObject4 = com.tencent.mm.plugin.finder.report.b.qFq;
            int i = ((akv)localObject1).type;
            k.g(localObject3, "tipsId");
            localObject2 = bt.by(((aln)localObject2).title, "");
            k.g(localObject2, "Util.nullAs(showInfo.title, \"\")");
            com.tencent.mm.plugin.finder.report.b.a("1", i, 1, (String)localObject3, (String)localObject2, ((akv)localObject1).feedId, "");
            localObject1 = b.qtb;
            k.h(localObject3, "<set-?>");
            b.aVi((String)localObject3);
          }
        }
        AppMethodBeat.o(197566);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.b
 * JD-Core Version:    0.7.0.1
 */