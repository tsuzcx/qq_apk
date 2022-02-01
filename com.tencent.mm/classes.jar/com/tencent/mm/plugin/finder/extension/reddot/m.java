package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.abtest.a;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a ASi;
  private static String ASj;
  private static String ASk;
  private static String ASl;
  private static r<p, ? extends bxq> ASm;
  private static String ASn;
  private static String ASo;
  private static String ASp;
  private static String ASq;
  private static String ASr;
  private static String ASs;
  
  static
  {
    AppMethodBeat.i(366909);
    ASi = new a((byte)0);
    ASj = "";
    ASk = "";
    ASl = "";
    ASn = "";
    ASo = "";
    ASp = "";
    ASq = "";
    ASr = "";
    ASs = "";
    AppMethodBeat.o(366909);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "clickNearbyLiveTabRedDotId", "clickNearbyPersonTabRedDotId", "clickNearbyVideoTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "lastFinderLiveExposeTipsId", "getLastFinderLiveExposeTipsId", "setLastFinderLiveExposeTipsId", "lastNearbyExposeTipsId", "getLastNearbyExposeTipsId", "setLastNearbyExposeTipsId", "pendingEntranceReport", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "getPendingEntranceReport", "()Lkotlin/Pair;", "setPendingEntranceReport", "(Lkotlin/Pair;)V", "checkPendingRedDotReport", "", "getFinderNotifyCount", "", "getNotifyCount", "hasMentionCount", "", "reportDropRedDot", "reportFindPageFinderLiveRedDotClick", "contextId", "autoClick", "", "reportFindPageNearbyRedDotClick", "reportFindPageRedDotClick", "autoTriggerType", "reportFindPageRedDotExpose", "ignoreDuplicatedId", "showNum", "dropStatus", "reportFinderEntryRedDotLongClick", "reportFinderPageFinderLiveRedDotExpose", "isEnableFinderLiveEntrance", "reportHomeFollowTabRed", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "reportNearbyLiveRedBreakage", "overwriteTipsId", "reportNearbyLiveTabRed", "clickSubTabContext", "reportNearbyPersonTabRed", "reportNearbyVideoTabRed", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void U(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(366815);
      if ((!((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZv()) || (!paramBoolean2))
      {
        AppMethodBeat.o(366815);
        return;
      }
      Object localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderLiveEntrance");
      p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveEntrance");
      Object localObject1 = av.GiL;
      if (localp == null)
      {
        localObject1 = null;
        Object localObject3 = aw.Gjk;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject1 = ((btw)localObject1).ZYN;
          localObject3 = m.ASi;
          if ((!s.p(m.eai(), localObject1)) || (paramBoolean1))
          {
            localObject3 = s.X("8001-", Long.valueOf(com.tencent.mm.model.cn.bDw()));
            String str = ((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).getTargetLiveTabId() + '-' + com.tencent.mm.model.cn.bDw();
            w localw = w.FrV;
            s.checkNotNull(localp);
            w.a(localw, "1", localp, (bxq)localObject2, 1, "", 0, (String)localObject3, str);
            localObject2 = m.ASi;
            if (localObject1 != null) {
              break label235;
            }
            localObject1 = "";
          }
        }
      }
      label235:
      for (;;)
      {
        s.u(localObject1, "<set-?>");
        m.avA((String)localObject1);
        AppMethodBeat.o(366815);
        return;
        localObject1 = localp.field_ctrInfo;
        break;
      }
    }
    
    public static String a(int paramInt, bui parambui, String paramString)
    {
      AppMethodBeat.i(366791);
      s.u(paramString, "lastExposeTipsId");
      Object localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      Object localObject4 = ((i)localObject3).avp("TLPersonalCenter");
      p localp = ((i)localObject3).Su("TLPersonalCenter");
      Object localObject1 = av.GiL;
      if (localp == null) {}
      Object localObject2;
      for (localObject1 = null;; localObject1 = localp.field_ctrInfo)
      {
        localObject2 = aw.Gjk;
        if ((localObject4 == null) || (localObject1 == null)) {
          break label521;
        }
        if (paramInt != 1) {
          break label515;
        }
        localObject2 = ((btw)localObject1).ZYN;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!s.p(paramString, localObject1)) {
          break;
        }
        AppMethodBeat.o(366791);
        return localObject1;
      }
      paramString = (String)localObject1;
      localObject1 = w.FrV;
      s.checkNotNull(localp);
      w.a((w)localObject1, "2", localp, (bxq)localObject4, paramInt, parambui, 0, null, 0, 480);
      int j = h.baE().ban().getInt(at.a.addK, 0);
      int k = h.baE().ban().getInt(at.a.addL, 0);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      int i;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1)
      {
        i = 0;
        label207:
        if (j <= 0) {
          break label253;
        }
        localObject1 = z.FrZ;
        z.a("2", 1, paramInt, 1, i, j, null, null, 0L, parambui, 0, 0, 3520);
        localObject1 = paramString;
      }
      label515:
      label521:
      for (;;)
      {
        AppMethodBeat.o(366791);
        return localObject1;
        i = 2;
        break label207;
        label253:
        if (k > 0)
        {
          localObject1 = z.FrZ;
          z.a("2", 4, paramInt, 1, i, k, null, null, 0L, parambui, 0, 0, 3520);
          localObject1 = paramString;
        }
        else
        {
          localObject2 = ((i)localObject3).avp("Personal_Center_FavList_Entrance");
          localObject3 = ((i)localObject3).Su("Personal_Center_FavList_Entrance");
          localObject1 = av.GiL;
          if (localObject3 == null) {}
          for (localObject1 = null;; localObject1 = ((p)localObject3).field_ctrInfo)
          {
            localObject4 = aw.Gjk;
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject1 = z.FrZ;
              z.a("2", 6, paramInt, 1, 0, 0, null, null, 0L, parambui, 0, 0, 3520);
              localObject1 = w.FrV;
              s.checkNotNull(localObject3);
              w.a((w)localObject1, "2", (p)localObject3, (bxq)localObject2, paramInt, parambui, 0, null, 0, 480);
            }
            localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("TLCamera");
            localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("TLCamera");
            localObject1 = av.GiL;
            localObject1 = aw.Gjk;
            localObject1 = paramString;
            if (localObject2 == null) {
              break;
            }
            localObject1 = paramString;
            if (localObject3 == null) {
              break;
            }
            localObject1 = z.FrZ;
            z.a("2", 2, paramInt, 1, 1, 0, null, null, 0L, parambui, 0, 0, 3520);
            w.a(w.FrV, "2", (p)localObject3, (bxq)localObject2, paramInt, parambui, 0, null, 0, 480);
            localObject1 = paramString;
            break;
          }
          paramString = "";
          break;
          localObject1 = "";
        }
      }
    }
    
    public static void a(int paramInt, bui parambui)
    {
      AppMethodBeat.i(366780);
      s.u(parambui, "contextObj");
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("finder_tl_nearby_tab");
      p localp = ((i)localObject1).Su("finder_tl_nearby_tab");
      localObject1 = av.GiL;
      if (localp == null) {}
      for (localObject1 = null;; localObject1 = localp.field_ctrInfo)
      {
        Object localObject2 = aw.Gjk;
        if ((localbxq != null) && (localObject1 != null))
        {
          localObject2 = z.FrZ;
          localObject2 = ((btw)localObject1).ZYN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          z.a("2", 3, paramInt, 1, 1, 0, (String)localObject1, null, 0L, parambui, 0, 0, 3456);
          localObject1 = w.FrV;
          s.checkNotNull(localp);
          w.a((w)localObject1, "2", localp, localbxq, paramInt, parambui, 0, null, 2, 352);
        }
        AppMethodBeat.o(366780);
        return;
      }
    }
    
    public static void a(int paramInt1, bui parambui, int paramInt2, String paramString)
    {
      AppMethodBeat.i(366866);
      s.u(paramString, "clickSubTabContext");
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("NearbyLiveTab");
      p localp = ((i)localObject1).Su("NearbyLiveTab");
      localObject1 = av.GiL;
      Object localObject2;
      if (localp == null)
      {
        localObject1 = null;
        localObject2 = aw.Gjk;
        if ((localbxq == null) || (localObject1 == null)) {
          break label183;
        }
        localObject2 = ((btw)localObject1).ZYN;
        if (localObject2 != null) {
          break label123;
        }
        localObject2 = "";
      }
      label123:
      for (;;)
      {
        if ((paramInt1 != 2) || (!s.p(m.eak(), localObject2))) {
          break label126;
        }
        AppMethodBeat.o(366866);
        return;
        localObject1 = localp.field_ctrInfo;
        break;
      }
      label126:
      if (parambui == null)
      {
        localObject1 = "";
        if (parambui != null) {
          break label212;
        }
        parambui = "";
      }
      for (;;)
      {
        Object localObject3 = w.FrV;
        s.checkNotNull(localp);
        w.a((w)localObject3, "9", localp, localbxq, paramInt1, (String)localObject1, paramInt2, parambui, paramString);
        if (paramInt1 == 2)
        {
          parambui = m.ASi;
          m.avC((String)localObject2);
        }
        label183:
        AppMethodBeat.o(366866);
        return;
        localObject3 = parambui.zIO;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        localObject1 = "";
        break;
        label212:
        localObject3 = parambui.zIB;
        parambui = (bui)localObject3;
        if (localObject3 == null) {
          parambui = "";
        }
      }
    }
    
    public static void a(int paramInt1, bui parambui, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(366757);
      s.u(parambui, "contextObj");
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("TLRecommendTab");
      p localp = ((i)localObject1).Su("TLRecommendTab");
      localObject1 = av.GiL;
      if (localp == null) {}
      Object localObject2;
      for (localObject1 = null;; localObject1 = localp.field_ctrInfo)
      {
        localObject2 = aw.Gjk;
        if ((localbxq == null) || (localObject1 == null)) {
          break label234;
        }
        localObject3 = ((btw)localObject1).ZYN;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (paramInt1 != 2) {
          break;
        }
        localObject3 = m.ASi;
        if (!s.p(m.eac(), localObject2)) {
          break;
        }
        AppMethodBeat.o(366757);
        return;
      }
      Object localObject3 = z.FrZ;
      long l = ((btw)localObject1).feedId;
      if (paramBoolean)
      {
        i = 1;
        z.a("2", 8, paramInt1, 1, 0, 0, (String)localObject2, null, l, parambui, paramInt2, i, 128);
        localObject1 = w.FrV;
        s.checkNotNull(localp);
        if (!paramBoolean) {
          break label247;
        }
      }
      label234:
      label247:
      for (int i = 1;; i = 0)
      {
        w.a("2", localp, localbxq, paramInt1, parambui, i, paramInt2, null, 0, 0, null, 0, 3968);
        if (paramInt1 == 2)
        {
          parambui = m.ASi;
          s.u(localObject2, "<set-?>");
          m.avv((String)localObject2);
        }
        AppMethodBeat.o(366757);
        return;
        i = 0;
        break;
      }
    }
    
    public static String ai(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(366828);
      s.u(paramString, "contextId");
      if (!((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZs())
      {
        AppMethodBeat.o(366828);
        return null;
      }
      bxq localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderEntrance");
      p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
      Object localObject1 = av.GiL;
      if (localp == null) {}
      for (localObject1 = null;; localObject1 = localp.field_ctrInfo)
      {
        Object localObject2 = aw.Gjk;
        if ((localbxq == null) || (localObject1 == null)) {
          break;
        }
        Object localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avr("FinderEntrance").report_ext_info;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        z localz = z.FrZ;
        int i = ((btw)localObject1).type;
        String str = ((btw)localObject1).ZYN;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        str = Util.nullAs(localbxq.title, "");
        s.s(str, "nullAs(showInfo.title, \"\")");
        localz.a("1", i, 2, (String)localObject3, str, ((btw)localObject1).feedId, paramString, localbxq.show_type, (String)localObject2, paramInt1);
        localObject2 = w.FrV;
        s.checkNotNull(localp);
        w.a((w)localObject2, "1", localp, localbxq, paramString, paramInt1, paramInt2);
        paramString = ((btw)localObject1).ZYN;
        AppMethodBeat.o(366828);
        return paramString;
      }
      AppMethodBeat.o(366828);
      return null;
    }
    
    public static void avE(String paramString)
    {
      AppMethodBeat.i(366843);
      s.u(paramString, "contextId");
      if (!((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZt())
      {
        AppMethodBeat.o(366843);
        return;
      }
      bxq localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderLiveEntrance");
      p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveEntrance");
      Object localObject1 = av.GiL;
      Object localObject2;
      if (localp == null)
      {
        localObject1 = null;
        localObject2 = aw.Gjk;
        if ((localbxq != null) && (localObject1 != null)) {
          if ((((btw)localObject1).type != 16) && (localbxq.show_type != 6)) {
            break label213;
          }
        }
      }
      label213:
      for (int i = 2;; i = 3)
      {
        localObject1 = s.X("8001-", Long.valueOf(com.tencent.mm.model.cn.bDw()));
        localObject2 = ((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).getTargetLiveTabId() + '-' + com.tencent.mm.model.cn.bDw();
        w localw = w.FrV;
        s.checkNotNull(localp);
        w.a(localw, "1", localp, localbxq, i, paramString, 1, (String)localObject1, (String)localObject2);
        AppMethodBeat.o(366843);
        return;
        localObject1 = localp.field_ctrInfo;
        break;
      }
    }
    
    public static void avF(String paramString)
    {
      AppMethodBeat.i(366884);
      s.u(paramString, "overwriteTipsId");
      Object localObject3 = ((Iterable)i.a(((PluginFinder)h.az(PluginFinder.class)).getRedDotManager(), "NearbyEntrance")).iterator();
      Object localObject1 = null;
      Object localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (p)((Iterator)localObject3).next();
        if (((p)localObject2).field_ctrInfo.type != 16) {
          break label169;
        }
        localObject1 = localObject2;
      }
      label161:
      label169:
      for (;;)
      {
        break;
        if (localObject1 == null)
        {
          localObject2 = null;
          localObject3 = av.GiL;
          if (localObject1 != null) {
            break label161;
          }
        }
        for (localObject3 = null;; localObject3 = localObject1.field_ctrInfo)
        {
          aw localaw = aw.Gjk;
          if ((localObject2 != null) && (localObject3 != null))
          {
            localObject3 = w.FrV;
            s.checkNotNull(localObject1);
            w.a(localObject1, (bxq)localObject2, 6, 1, null, paramString, 16);
          }
          AppMethodBeat.o(366884);
          return;
          localObject2 = localObject1.ASx;
          if (localObject2 == null)
          {
            localObject2 = null;
            break;
          }
          localObject2 = (bxq)((ConcurrentHashMap)localObject2).get("NearbyEntrance");
          break;
        }
      }
    }
    
    public static void b(int paramInt, bui parambui)
    {
      AppMethodBeat.i(366857);
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("NearbyFeedTab");
      p localp = ((i)localObject1).Su("NearbyFeedTab");
      localObject1 = av.GiL;
      if (localp == null)
      {
        localObject1 = null;
        localObject2 = aw.Gjk;
        if ((localbxq == null) || (localObject1 == null)) {
          break label147;
        }
        localObject1 = ((btw)localObject1).ZYN;
        if (localObject1 != null) {
          break label102;
        }
        localObject1 = "";
      }
      label102:
      for (;;)
      {
        if ((paramInt != 2) || (!s.p(m.eaj(), localObject1))) {
          break label105;
        }
        AppMethodBeat.o(366857);
        return;
        localObject1 = localp.field_ctrInfo;
        break;
      }
      label105:
      Object localObject2 = w.FrV;
      s.checkNotNull(localp);
      w.a((w)localObject2, "9", localp, localbxq, paramInt, parambui, 0, null, 0, 480);
      if (paramInt == 2)
      {
        parambui = m.ASi;
        m.avB((String)localObject1);
      }
      label147:
      AppMethodBeat.o(366857);
    }
    
    public static void b(int paramInt1, bui parambui, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(366762);
      s.u(parambui, "contextObj");
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("TLFollow");
      p localp = ((i)localObject1).Su("TLFollow");
      localObject1 = av.GiL;
      if (localp == null) {}
      Object localObject2;
      for (localObject1 = null;; localObject1 = localp.field_ctrInfo)
      {
        localObject2 = aw.Gjk;
        if ((localbxq == null) || (localObject1 == null)) {
          break label234;
        }
        localObject3 = ((btw)localObject1).ZYN;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (paramInt1 != 2) {
          break;
        }
        localObject3 = m.ASi;
        if (!s.p(m.ead(), localObject2)) {
          break;
        }
        AppMethodBeat.o(366762);
        return;
      }
      Object localObject3 = z.FrZ;
      long l = ((btw)localObject1).feedId;
      if (paramBoolean)
      {
        i = 1;
        z.a("2", 7, paramInt1, 1, 0, 0, (String)localObject2, null, l, parambui, paramInt2, i, 128);
        localObject1 = w.FrV;
        s.checkNotNull(localp);
        if (!paramBoolean) {
          break label247;
        }
      }
      label234:
      label247:
      for (int i = 1;; i = 0)
      {
        w.a("2", localp, localbxq, paramInt1, parambui, i, paramInt2, null, 0, 0, null, 0, 3968);
        if (paramInt1 == 2)
        {
          parambui = m.ASi;
          s.u(localObject2, "<set-?>");
          m.avw((String)localObject2);
        }
        AppMethodBeat.o(366762);
        return;
        i = 0;
        break;
      }
    }
    
    public static void c(int paramInt, bui parambui)
    {
      AppMethodBeat.i(366875);
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("NearbyPeopleTab");
      p localp = ((i)localObject1).Su("NearbyPeopleTab");
      localObject1 = av.GiL;
      if (localp == null)
      {
        localObject1 = null;
        localObject2 = aw.Gjk;
        if ((localbxq == null) || (localObject1 == null)) {
          break label147;
        }
        localObject1 = ((btw)localObject1).ZYN;
        if (localObject1 != null) {
          break label102;
        }
        localObject1 = "";
      }
      label102:
      for (;;)
      {
        if ((paramInt != 3) || (!s.p(m.eal(), localObject1))) {
          break label105;
        }
        AppMethodBeat.o(366875);
        return;
        localObject1 = localp.field_ctrInfo;
        break;
      }
      label105:
      Object localObject2 = w.FrV;
      s.checkNotNull(localp);
      w.a((w)localObject2, "9", localp, localbxq, paramInt, parambui, 0, null, 0, 480);
      if (paramInt == 3)
      {
        parambui = m.ASi;
        m.avD((String)localObject1);
      }
      label147:
      AppMethodBeat.o(366875);
    }
    
    public static void c(int paramInt1, bui parambui, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(366768);
      s.u(parambui, "contextObj");
      Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject1).avp("finder_tl_hot_tab");
      p localp = ((i)localObject1).Su("finder_tl_hot_tab");
      localObject1 = av.GiL;
      if (localp == null)
      {
        localObject2 = null;
        localObject1 = aw.Gjk;
        if ((localbxq == null) || (localObject2 == null)) {
          break label244;
        }
        localObject1 = ((btw)localObject2).ZYN;
        if (localObject1 != null) {
          break label128;
        }
        localObject1 = "";
      }
      label128:
      for (;;)
      {
        if (paramInt1 != 2) {
          break label131;
        }
        localObject3 = m.ASi;
        if (!s.p(m.eae(), localObject1)) {
          break label131;
        }
        AppMethodBeat.o(366768);
        return;
        localObject2 = localp.field_ctrInfo;
        break;
      }
      label131:
      Object localObject3 = z.FrZ;
      localObject3 = ((btw)localObject2).ZYN;
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      if (paramBoolean)
      {
        i = 1;
        z.a("2", 3, paramInt1, 1, 2, 0, (String)localObject2, null, 0L, parambui, paramInt2, i, 384);
        localObject2 = w.FrV;
        s.checkNotNull(localp);
        if (!paramBoolean) {
          break label257;
        }
      }
      label257:
      for (int i = 1;; i = 0)
      {
        w.a("2", localp, localbxq, paramInt1, parambui, i, paramInt2, null, 0, 0, null, 0, 3968);
        if (paramInt1 == 2)
        {
          parambui = m.ASi;
          s.u(localObject1, "<set-?>");
          m.avx((String)localObject1);
        }
        label244:
        AppMethodBeat.o(366768);
        return;
        i = 0;
        break;
      }
    }
    
    public static int[] eam()
    {
      AppMethodBeat.i(366746);
      Object localObject = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      bxq localbxq = ((i)localObject).avp("NotificationCenterLike");
      int i;
      int j;
      label53:
      int k;
      if (localbxq == null)
      {
        i = 0;
        localbxq = ((i)localObject).avp("NotificationCenterComment");
        if (localbxq != null) {
          break label122;
        }
        j = 0;
        localbxq = ((i)localObject).avp("NotificationCenterFollow");
        if (localbxq != null) {
          break label131;
        }
        k = 0;
        label70:
        localObject = ((i)localObject).avp("AuthorProfileNotify");
        if (localObject != null) {
          break label140;
        }
      }
      label131:
      label140:
      for (int m = 0;; m = ((bxq)localObject).count)
      {
        AppMethodBeat.o(366746);
        return new int[] { i, j, k, m };
        i = localbxq.count;
        break;
        label122:
        j = localbxq.count;
        break label53;
        k = localbxq.count;
        break label70;
      }
    }
    
    public static boolean ean()
    {
      AppMethodBeat.i(366750);
      if (eam()[3] > 0)
      {
        AppMethodBeat.o(366750);
        return true;
      }
      AppMethodBeat.o(366750);
      return false;
    }
    
    public static void ew(String paramString, int paramInt)
    {
      AppMethodBeat.i(366833);
      s.u(paramString, "contextId");
      Object localObject = a.EHr;
      if (a.eEi()) {}
      for (boolean bool = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZu(); !bool; bool = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZt())
      {
        AppMethodBeat.o(366833);
        return;
      }
      bxq localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NearbyEntrance");
      p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("NearbyEntrance");
      localObject = av.GiL;
      if (localp == null)
      {
        localObject = null;
        aw localaw = aw.Gjk;
        if ((localbxq != null) && (localObject != null)) {
          if ((((btw)localObject).type != 16) && (localbxq.show_type != 6)) {
            break label210;
          }
        }
      }
      label210:
      for (int i = 2;; i = 3)
      {
        localObject = w.FrV;
        s.checkNotNull(localp);
        w.a((w)localObject, "1", localp, localbxq, i, paramString, paramInt, 0, 0, 192);
        AppMethodBeat.o(366833);
        return;
        localObject = localp.field_ctrInfo;
        break;
      }
    }
    
    public static void h(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(366803);
      if (!((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZs())
      {
        AppMethodBeat.o(366803);
        return;
      }
      Object localObject5 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderEntrance");
      p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
      Object localObject1 = av.GiL;
      Object localObject4;
      if (localp == null)
      {
        localObject2 = null;
        localObject1 = aw.Gjk;
        if ((localObject5 != null) && (localObject2 != null))
        {
          localObject1 = ((btw)localObject2).ZYN;
          localObject4 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avr("FinderEntrance").report_ext_info;
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          localObject4 = m.ASi;
          if ((!s.p(m.eag(), localObject1)) || (paramBoolean))
          {
            z localz = z.FrZ;
            int i = ((btw)localObject2).type;
            if (localObject1 != null) {
              break label441;
            }
            localObject4 = "";
            label182:
            String str = Util.nullAs(((bxq)localObject5).title, "");
            s.s(str, "nullAs(showInfo.title, \"\")");
            z.a(localz, "1", i, (String)localObject4, str, ((btw)localObject2).feedId, "", ((bxq)localObject5).show_type, (String)localObject3);
            if (((bxq)localObject5).show_type != 3) {
              break label448;
            }
            localObject2 = m.ASi;
            s.checkNotNull(localp);
            m.b(new r(localp, localObject5));
            label261:
            if (paramInt2 == 2)
            {
              localObject2 = m.ASi;
              paramInt1 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getTimelineCommentScene();
              localObject2 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).genContextId(1, 1, paramInt1);
              localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
              if (localObject3 != null)
              {
                localObject4 = ((p)localObject3).avK("FinderEntrance");
                if (localObject4 != null)
                {
                  localObject5 = w.FrV;
                  w.a((p)localObject3, (bxq)localObject4, 12, (String)localObject2);
                }
              }
            }
            localObject2 = m.ASi;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            s.u(localObject2, "<set-?>");
            m.avy((String)localObject2);
          }
        }
        localObject1 = a.EHr;
        if (!a.eEi()) {
          break label479;
        }
      }
      label441:
      label448:
      label479:
      for (boolean bool = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZu();; bool = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZt())
      {
        if (bool) {
          break label502;
        }
        AppMethodBeat.o(366803);
        return;
        localObject2 = localp.field_ctrInfo;
        break;
        localObject4 = localObject1;
        break label182;
        localObject2 = w.FrV;
        s.checkNotNull(localp);
        w.a((w)localObject2, "1", localp, (bxq)localObject5, 1, null, 0, paramInt1, paramInt2, 48);
        break label261;
      }
      label502:
      Object localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NearbyEntrance");
      Object localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("NearbyEntrance");
      localObject1 = av.GiL;
      if (localObject3 == null)
      {
        localObject1 = null;
        localObject4 = aw.Gjk;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject1 = ((btw)localObject1).ZYN;
          localObject4 = m.ASi;
          if ((!s.p(m.eah(), localObject1)) || (paramBoolean))
          {
            localObject4 = w.FrV;
            s.checkNotNull(localObject3);
            w.a((w)localObject4, "1", (p)localObject3, (bxq)localObject2, 1, null, 0, 0, 0, 240);
            localObject2 = m.ASi;
            if (localObject1 != null) {
              break label667;
            }
            localObject1 = "";
          }
        }
      }
      label667:
      for (;;)
      {
        s.u(localObject1, "<set-?>");
        m.avz((String)localObject1);
        AppMethodBeat.o(366803);
        return;
        localObject1 = ((p)localObject3).field_ctrInfo;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.m
 * JD-Core Version:    0.7.0.1
 */