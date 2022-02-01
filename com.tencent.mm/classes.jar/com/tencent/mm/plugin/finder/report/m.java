package com.tencent.mm.plugin.finder.report;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dn;
import com.tencent.mm.autogen.mmdata.rpt.dv;
import com.tencent.mm.autogen.mmdata.rpt.ed;
import com.tencent.mm.autogen.mmdata.rpt.ee;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.video.reporter.c.b;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.a.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "extStatusRecord", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "getExtStatusRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "ExtStatsRecord", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class m
  extends com.tencent.mm.plugin.finder.event.base.d
{
  public static final a Fpx = new a((byte)0);
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  public bui Auc;
  private final MMFragmentActivity EzS;
  private final long FpA;
  final com.tencent.mm.plugin.finder.video.reporter.c FpB;
  private i Fpy;
  private final b Fpz;
  public boolean visible;
  
  public m(MMFragmentActivity paramMMFragmentActivity, bui parambui)
  {
    this.EzS = paramMMFragmentActivity;
    this.Auc = parambui;
    this.FpA = 1277L;
    this.FpB = new com.tencent.mm.plugin.finder.video.reporter.c(this.Auc);
    paramMMFragmentActivity = com.tencent.mm.plugin.vlog.model.o.TZr;
    com.tencent.mm.plugin.vlog.model.o.bz((Activity)this.EzS);
    this.Fpz = new b();
    this.Fpy = ((i)new i()
    {
      public final void a(cc paramAnonymouscc, i.c paramAnonymousc, boolean[] paramAnonymousArrayOfBoolean) {}
      
      public final void a(cc paramAnonymouscc, bb paramAnonymousbb, boolean paramAnonymousBoolean, i.c paramAnonymousc) {}
      
      public final void b(cc paramAnonymouscc, bb paramAnonymousbb, boolean paramAnonymousBoolean, i.c paramAnonymousc)
      {
        AppMethodBeat.i(331424);
        this.FpC.eMw();
        AppMethodBeat.o(331424);
      }
    });
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().a(this.Fpy);
    this.visible = true;
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    s.u(paramb, "event");
    if (this.Auc.AJo == 0) {
      Log.i(TAG, "[onEventHappen] invalid scene");
    }
    Object localObject1;
    label323:
    label583:
    label599:
    label607:
    label615:
    label636:
    do
    {
      do
      {
        do
        {
          Object localObject2;
          int i;
          long l;
          float f;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                Object localObject3;
                                Object localObject4;
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  return;
                                                } while (!(paramb instanceof com.tencent.mm.plugin.finder.event.c.a));
                                                switch (((com.tencent.mm.plugin.finder.event.c.a)paramb).type)
                                                {
                                                default: 
                                                  return;
                                                case 1: 
                                                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(this.FpA, 1L, 1L, false);
                                                  localObject1 = this.FpB;
                                                  paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                                  s.u(paramb, "event");
                                                  localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                                                }
                                              } while (localObject1 == null);
                                              ((c.b)localObject1).cJs = true;
                                              ((c.b)localObject1).Ftb = paramb.ANT;
                                              if (((c.b)localObject1).GtV > 0L)
                                              {
                                                ((c.b)localObject1).GtU += paramb.ANT - ((c.b)localObject1).GtV;
                                                ((c.b)localObject1).GtV = 0L;
                                              }
                                              Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onResume", (c.b)localObject1) + " onResume:" + ((c.b)localObject1).GtU);
                                              return;
                                              localObject1 = this.FpB;
                                              localObject2 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                              s.u(localObject2, "event");
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANO;
                                              if (paramb != null) {
                                                break;
                                              }
                                              paramb = null;
                                              if (paramb != null) {
                                                break label583;
                                              }
                                              i = ((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Fla;
                                              ((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Fla = i;
                                              Log.i("Finder.FinderVideoPlayReporter", s.X("onPlayerConfig enableRendererSharpen:", Integer.valueOf(((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Fla)));
                                              localObject3 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject2).feedId));
                                            } while (localObject3 == null);
                                            paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANO;
                                            if (paramb == null)
                                            {
                                              i = -1;
                                              ((c.b)localObject3).Gup = i;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANO;
                                              if (paramb != null) {
                                                break label599;
                                              }
                                              i = -1;
                                              ((c.b)localObject3).Guq = i;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANO;
                                              if (paramb != null) {
                                                break label607;
                                              }
                                              i = -1;
                                              ((c.b)localObject3).Gur = i;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANO;
                                              if (paramb != null) {
                                                break label615;
                                              }
                                              paramb = "0";
                                              s.u(paramb, "<set-?>");
                                              ((c.b)localObject3).Gus = paramb;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANO;
                                              if (paramb != null) {
                                                break label636;
                                              }
                                            }
                                            for (i = -1;; i = paramb.Gut)
                                            {
                                              ((c.b)localObject3).Gut = i;
                                              Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onPlayerConfig", (c.b)localObject3) + " mediaCodecInitDuration " + ((c.b)localObject3).Gut + " enableMediaCodecReuse:" + ((c.b)localObject3).Gup + " mediaCodecReuseEnabled:" + ((c.b)localObject3).Guq + " mediaCodecReused:" + ((c.b)localObject3).Gur + " mediaCodecErrorCode:" + ((c.b)localObject3).Gus);
                                              return;
                                              paramb = Integer.valueOf(paramb.Fla);
                                              break;
                                              i = paramb.intValue();
                                              break label323;
                                              i = paramb.Gup;
                                              break label387;
                                              i = paramb.Guq;
                                              break label405;
                                              i = paramb.Gur;
                                              break label423;
                                              localObject1 = paramb.Gus;
                                              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                              if (localObject1 != null) {
                                                break label443;
                                              }
                                              paramb = "0";
                                              break label443;
                                            }
                                            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(this.FpA, 2L, 1L, false);
                                            localObject1 = this.FpB;
                                            paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                            s.u(paramb, "event");
                                            paramb = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                                          } while (paramb == null);
                                          paramb.AVo += 1;
                                          return;
                                          localObject1 = this.FpB;
                                          paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                          s.u(paramb, "event");
                                          localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                                        } while (localObject1 == null);
                                        ((c.b)localObject1).Gug.add(Integer.valueOf(paramb.offset));
                                        localObject2 = av.GiL;
                                        i = av.iu(paramb.offset, paramb.total);
                                      } while (i <= ((c.b)localObject1).Ggs);
                                      ((c.b)localObject1).Ggs = i;
                                      return;
                                      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(this.FpA, 0L, 1L, false);
                                      localObject4 = this.FpB;
                                      localObject3 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                      s.u(localObject3, "event");
                                      localObject2 = new c.b();
                                      localObject1 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
                                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                      if (localObject1 == null) {
                                        paramb = "";
                                      }
                                      s.u(paramb, "<set-?>");
                                      ((c.b)localObject2).sessionId = paramb;
                                      ((c.b)localObject2).Eac = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                      if (paramb == null)
                                      {
                                        paramb = "";
                                        s.u(paramb, "<set-?>");
                                        ((c.b)localObject2).GtB = paramb;
                                        ((c.b)localObject2).GtE = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                        ((c.b)localObject2).GtF = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANJ;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANI;
                                        if (paramb != null) {
                                          break label1132;
                                        }
                                        paramb = "-1";
                                        s.u(paramb, "<set-?>");
                                        ((c.b)localObject2).GtC = paramb;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANI;
                                        if (paramb != null) {
                                          break label1169;
                                        }
                                        paramb = "-1";
                                        paramb = com.tencent.mm.plugin.finder.utils.o.aBv(paramb);
                                        s.s(paramb, "simpleDescription(event.…ata?.description ?: \"-1\")");
                                        s.u(paramb, "<set-?>");
                                        ((c.b)localObject2).GtD = paramb;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                        if (paramb != null) {
                                          break label1206;
                                        }
                                        paramb = "";
                                      }
                                      for (;;)
                                      {
                                        s.u(paramb, "<set-?>");
                                        ((c.b)localObject2).mediaPath = paramb;
                                        ((c.b)localObject2).tpS = ((com.tencent.mm.plugin.finder.event.base.b)localObject3).ANT;
                                        ((c.b)localObject2).GtH = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).position;
                                        ((c.b)localObject2).GtI = 1;
                                        ((c.b)localObject2).GtS = true;
                                        ((c.b)localObject2).ANM = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANM;
                                        ((c.b)localObject2).GtT = CdnLogic.getRecentAverageSpeed(2);
                                        paramb = MMApplicationContext.getContext().getSystemService("audio");
                                        if (paramb != null) {
                                          break label1229;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
                                        localObject1 = paramb.aUt();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {
                                          break;
                                        }
                                        paramb = "";
                                        break;
                                        paramb = paramb.AWA;
                                        if (paramb == null)
                                        {
                                          paramb = "-1";
                                          break label954;
                                        }
                                        localObject1 = paramb.getNickName();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {
                                          break label954;
                                        }
                                        paramb = "-1";
                                        break label954;
                                        paramb = paramb.AWA;
                                        if (paramb == null)
                                        {
                                          paramb = "-1";
                                          break label981;
                                        }
                                        localObject1 = paramb.getDescription();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {
                                          break label981;
                                        }
                                        paramb = "-1";
                                        break label981;
                                        localObject1 = paramb.getPath();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 == null) {
                                          paramb = "";
                                        }
                                      }
                                      ((c.b)localObject2).Fti = ((AudioManager)paramb).getStreamVolume(3);
                                      paramb = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                      boolean bool;
                                      if (paramb == null)
                                      {
                                        paramb = "";
                                        paramb = com.tencent.mm.plugin.finder.storage.logic.e.aAN(paramb);
                                        if (((c.b)localObject2).ANM <= 0) {
                                          break label1650;
                                        }
                                        i = ((c.b)localObject2).ANM + 1;
                                        ((c.b)localObject2).GtK = i;
                                        if (!paramb.field_hasPlayed) {
                                          break label1667;
                                        }
                                        i = 0;
                                        ((c.b)localObject2).GtR = i;
                                        ((c.b)localObject2).GtL = paramb.eDy();
                                        localObject1 = paramb.field_fileFormat;
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 == null) {
                                          paramb = "";
                                        }
                                        ((c.b)localObject2).aCt(paramb);
                                        if (((c.b)localObject2).GtL == 100) {
                                          break label1672;
                                        }
                                        bool = true;
                                        ((c.b)localObject2).GtS = bool;
                                        paramb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
                                        s.s(paramb, "getNetTypeString(MMAppli…tionContext.getContext())");
                                        s.u(paramb, "<set-?>");
                                        ((c.b)localObject2).GtP = paramb;
                                        paramb = z.FrZ;
                                        ((c.b)localObject2).GtQ = z.bUg();
                                        if (((com.tencent.mm.plugin.finder.video.reporter.c)localObject4).Auc.GSX) {
                                          break label1678;
                                        }
                                        paramb = z.FrZ;
                                        l = z.pI(((c.b)localObject2).Eac);
                                        ((c.b)localObject2).GtZ = l;
                                        if (!com.tencent.mm.modelcontrol.e.wb(4)) {
                                          break label1695;
                                        }
                                        paramb = "h265";
                                        s.u(paramb, "<set-?>");
                                        ((c.b)localObject2).Gul = paramb;
                                        ((c.b)localObject2).GtG = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVt;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANJ;
                                        if (paramb != null) {
                                          break label1702;
                                        }
                                        f = 0.0F;
                                        ((c.b)localObject2).Gum = f;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANJ;
                                        if (paramb != null) {
                                          break label1710;
                                        }
                                        f = 0.0F;
                                        ((c.b)localObject2).Gun = f;
                                        ((c.b)localObject2).ANM = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANM;
                                        ((Map)((com.tencent.mm.plugin.finder.video.reporter.c)localObject4).Gty).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId), localObject2);
                                        if (((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANJ != null) {
                                          break label1718;
                                        }
                                        i = -1;
                                      }
                                      for (;;)
                                      {
                                        ((c.b)localObject2).Guu = i;
                                        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onStartPlay", (c.b)localObject2) + " firstplay:" + ((c.b)localObject2).GtR + " posterNickName:" + ((c.b)localObject2).GtC + " mediaDesc:" + ((c.b)localObject2).GtD);
                                        return;
                                        localObject1 = paramb.aUt();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {
                                          break;
                                        }
                                        paramb = "";
                                        break;
                                        if (paramb.eDy() > 0)
                                        {
                                          i = 1;
                                          break label1281;
                                        }
                                        i = 0;
                                        break label1281;
                                        i = 1;
                                        break label1296;
                                        bool = false;
                                        break label1348;
                                        paramb = z.FrZ;
                                        l = z.pJ(((c.b)localObject2).Eac);
                                        break label1420;
                                        paramb = "h264";
                                        break label1438;
                                        f = paramb.width;
                                        break label1483;
                                        f = paramb.height;
                                        break label1501;
                                        localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel();
                                        localObject4 = ((com.tencent.mm.plugin.finder.preload.model.b)localObject1).EVz;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANJ;
                                        if (paramb == null)
                                        {
                                          paramb = null;
                                          paramb = (kotlin.u)((com.tencent.mm.b.h)localObject4).get(paramb);
                                          if (paramb != null) {
                                            break label1784;
                                          }
                                          paramb = null;
                                        }
                                        for (;;)
                                        {
                                          if (paramb == null)
                                          {
                                            i = -1;
                                            break;
                                            paramb = paramb.mediaId;
                                            break label1751;
                                            paramb = (boz)paramb.bsC;
                                            if (paramb == null)
                                            {
                                              paramb = null;
                                            }
                                            else
                                            {
                                              if (paramb.ZPI >= ((com.tencent.mm.plugin.finder.preload.model.b)localObject1).EVs) {}
                                              for (i = 1;; i = 0)
                                              {
                                                paramb = Integer.valueOf(i);
                                                break;
                                              }
                                            }
                                          }
                                        }
                                        i = paramb.intValue();
                                      }
                                      localObject2 = this.FpB;
                                      localObject1 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                      s.u(localObject1, "event");
                                      localObject2 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject2).Gty.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject1).feedId));
                                    } while (localObject2 == null);
                                    paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject1).ANP;
                                    if (paramb == null) {}
                                    for (paramb = null;; paramb = paramb.fjS())
                                    {
                                      ((c.b)localObject2).ANP = paramb;
                                      ((c.b)localObject2).cJs = false;
                                      ((c.b)localObject2).GtV = ((com.tencent.mm.plugin.finder.event.base.b)localObject1).ANT;
                                      if (((c.b)localObject2).Ftb > 0L)
                                      {
                                        ((c.b)localObject2).Fta += ((com.tencent.mm.plugin.finder.event.base.b)localObject1).ANT - ((c.b)localObject2).Ftb;
                                        ((c.b)localObject2).Ftb = 0L;
                                      }
                                      Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onPause", (c.b)localObject2) + " realPlayTime:" + ((c.b)localObject2).Fta);
                                      return;
                                    }
                                    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(this.FpA, 3L, 1L, false);
                                    localObject2 = this.FpB;
                                    localObject3 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                    s.u(localObject3, "event");
                                    localObject4 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject2).Gty.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId));
                                  } while ((localObject4 == null) || (((c.b)localObject4).Eac != ((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId));
                                  localObject1 = ((c.b)localObject4).GtB;
                                  paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                  if (paramb != null) {
                                    break;
                                  }
                                  paramb = null;
                                } while (!s.p(localObject1, paramb));
                                ((c.b)localObject4).Ftc = (((com.tencent.mm.plugin.finder.event.base.b)localObject3).ANT - ((c.b)localObject4).tpS);
                                paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANP;
                                if (paramb == null) {}
                                for (paramb = null;; paramb = paramb.fjS())
                                {
                                  ((c.b)localObject4).ANP = paramb;
                                  if (((c.b)localObject4).GtV > 0L)
                                  {
                                    ((c.b)localObject4).GtU += ((com.tencent.mm.plugin.finder.event.base.b)localObject3).ANT - ((c.b)localObject4).GtV;
                                    ((c.b)localObject4).GtV = 0L;
                                  }
                                  if (((c.b)localObject4).Ftb > 0L)
                                  {
                                    ((c.b)localObject4).Fta += ((com.tencent.mm.plugin.finder.event.base.b)localObject3).ANT - ((c.b)localObject4).Ftb;
                                    ((c.b)localObject4).Ftb = 0L;
                                  }
                                  if (((c.b)localObject4).GtX > 0L)
                                  {
                                    ((c.b)localObject4).GtY += ((com.tencent.mm.plugin.finder.event.base.b)localObject3).ANT - ((c.b)localObject4).GtX;
                                    ((c.b)localObject4).GtX = 0L;
                                    paramb = new bza();
                                    paramb.aaic = ((int)(((com.tencent.mm.plugin.finder.event.base.b)localObject3).ANT - ((c.b)localObject4).GtX));
                                    paramb.percent = ((c.b)localObject4).Ggs;
                                    paramb.type = 0;
                                    ((c.b)localObject4).Guf.add(paramb);
                                  }
                                  paramb = MMApplicationContext.getContext().getSystemService("audio");
                                  if (paramb != null) {
                                    break label2346;
                                  }
                                  throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
                                  paramb = paramb.aUt();
                                  break;
                                }
                                ((c.b)localObject4).Ftj = ((AudioManager)paramb).getStreamVolume(3);
                                if ((((c.b)localObject4).Fqp == 0L) && (((c.b)localObject4).GtS) && (((c.b)localObject4).Ggs < 5)) {
                                  ((c.b)localObject4).oYt = 1;
                                }
                                paramb = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
                                paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                if (paramb == null)
                                {
                                  paramb = "";
                                  localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.aAN(paramb).field_fileFormat;
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                  if (localObject1 == null) {
                                    paramb = "";
                                  }
                                  ((c.b)localObject4).aCt(paramb);
                                  paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).ANK;
                                  if (paramb != null) {
                                    break label2626;
                                  }
                                  paramb = "";
                                  paramb = com.tencent.mm.plugin.sight.base.f.aVX(paramb);
                                  if (paramb != null)
                                  {
                                    ((c.b)localObject4).Guj = paramb.videoBitrate;
                                    ((c.b)localObject4).Guk = paramb.audioBitrate;
                                    ((c.b)localObject4).frameRate = paramb.frameRate;
                                  }
                                  if (((c.b)localObject4).Gud) {
                                    break label2649;
                                  }
                                  ((com.tencent.mm.plugin.finder.video.reporter.c)localObject2).a((c.b)localObject4);
                                }
                                for (;;)
                                {
                                  ((com.tencent.mm.plugin.finder.video.reporter.c)localObject2).Gty.remove(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId));
                                  Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onStopPlay", (c.b)localObject4) + " playTime:" + ((c.b)localObject4).Ftc + " pauseTotalTime:" + ((c.b)localObject4).GtU + " realPlayTime:" + ((c.b)localObject4).Fta + " playStatus:" + ((c.b)localObject4).oYt);
                                  return;
                                  localObject1 = paramb.aUt();
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                  if (localObject1 != null) {
                                    break;
                                  }
                                  paramb = "";
                                  break;
                                  localObject1 = paramb.getPath();
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                  if (localObject1 != null) {
                                    break label2451;
                                  }
                                  paramb = "";
                                  break label2451;
                                  ((com.tencent.mm.plugin.finder.video.reporter.c)localObject2).Gtx.add(localObject4);
                                }
                                localObject1 = this.FpB;
                                paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                s.u(paramb, "event");
                                localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                              } while (localObject1 == null);
                              ((c.b)localObject1).GtS = true;
                              ((c.b)localObject1).GtX = paramb.ANT;
                              ((c.b)localObject1).GtW += 1;
                              if (((c.b)localObject1).Fqp > 0L) {
                                ((c.b)localObject1).Gue += 1L;
                              }
                              Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.c.a("onWaiting", (c.b)localObject1)));
                              return;
                              localObject1 = this.FpB;
                              paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                              s.u(paramb, "event");
                              localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                            } while (localObject1 == null);
                            ((c.b)localObject1).GtS = false;
                          } while (((c.b)localObject1).GtX <= 0L);
                          l = paramb.ANT - ((c.b)localObject1).GtX;
                          ((c.b)localObject1).GtY += l;
                          paramb = new bza();
                          paramb.aaic = ((int)l);
                          paramb.percent = ((c.b)localObject1).Ggs;
                          if ((((c.b)localObject1).GtW == 1) && (((c.b)localObject1).Gue == 0L)) {}
                          for (paramb.type = 2;; paramb.type = 0)
                          {
                            ((c.b)localObject1).Guf.add(paramb);
                            ((c.b)localObject1).GtX = 0L;
                            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onWaitingEnd", (c.b)localObject1) + " totalWaitingTime:" + ((c.b)localObject1).GtY);
                            return;
                          }
                          localObject1 = this.FpB;
                          paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                          s.u(paramb, "event");
                          localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                        } while (localObject1 == null);
                        if (((c.b)localObject1).GtN == 0L) {
                          ((c.b)localObject1).GtN = (paramb.ANT - ((c.b)localObject1).tpS - ((c.b)localObject1).GtU);
                        }
                        ((c.b)localObject1).GtO = (paramb.offset + paramb.total);
                        ((c.b)localObject1).GtS = false;
                        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onMoovReady", (c.b)localObject1) + " moovReadyTime:" + ((c.b)localObject1).GtN);
                        return;
                        localObject1 = this.FpB;
                        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                        s.u(paramb, "event");
                        localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                      } while (localObject1 == null);
                      localObject2 = av.GiL;
                      i = av.iu(paramb.offset, paramb.total);
                    } while (i <= ((c.b)localObject1).sIA);
                    ((c.b)localObject1).sIA = i;
                    return;
                    localObject1 = this.FpB;
                    paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                    s.u(paramb, "event");
                    localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                  } while ((localObject1 == null) || (((c.b)localObject1).Gua != 0L));
                  ((c.b)localObject1).Gua = (paramb.offset + paramb.total);
                  return;
                  localObject1 = this.FpB;
                  paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                  s.u(paramb, "event");
                  localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
                } while (localObject1 == null);
                ((c.b)localObject1).GtM = (paramb.ANT - ((c.b)localObject1).tpS);
                paramb = paramb.mxU;
                if ((paramb != null) && (((c.b)localObject1).Guc == null)) {
                  ((c.b)localObject1).Guc = com.tencent.mm.plugin.finder.video.reporter.c.b(paramb);
                }
                Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.c.a("onDownloadFinish", (c.b)localObject1)));
                return;
                this.FpB.c((com.tencent.mm.plugin.finder.event.c.a)paramb);
                return;
                localObject1 = this.FpB;
                paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                s.u(paramb, "event");
                paramb = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
              } while (paramb == null);
              paramb.Gud = true;
              Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.c.a("onDownloadStart", paramb)));
              return;
              localObject1 = this.FpB;
              paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
              s.u(paramb, "event");
              paramb = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
            } while (paramb == null);
            paramb.Ftf = 1;
            return;
            localObject1 = this.FpB;
            localObject2 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
            s.u(localObject2, "event");
            paramb = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject2).feedId));
          } while (paramb == null);
          if (paramb.Fqp == 0L)
          {
            paramb.Fqp = (((com.tencent.mm.plugin.finder.event.base.b)localObject2).ANT - paramb.tpS);
            if (paramb.Fqp > paramb.GtU) {
              paramb.Fqp -= paramb.GtU;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gtz;
            l = paramb.Fqp;
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).GuU = l;
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).GuT = (l + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).GuT);
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count += 1;
            f = 1.0F * (float)((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).GuT / ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count;
            Log.i(((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).TAG, "count:" + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count + " current:" + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).GuU + ",  average:" + f);
          }
          if (paramb.GtJ == 0L) {
            paramb.GtJ = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANN;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).ANJ;
          if (localObject1 == null) {
            i = 0;
          }
          for (;;)
          {
            paramb.playDecoderType = i;
            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onFirstFrameUpdate", paramb) + " firstFrameTime:" + paramb.Fqp + " firstLoadTime:" + paramb.GtJ + " playDecoderType=" + paramb.playDecoderType);
            return;
            localObject1 = ((dji)localObject1).aaPt;
            if (localObject1 == null) {
              i = 0;
            } else {
              i = ((FinderMediaReportObject)localObject1).playDecoderType;
            }
          }
          localObject1 = this.FpB;
          paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
          s.u(paramb, "event");
          localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
        } while (localObject1 == null);
        if (((c.b)localObject1).FpZ == 0L)
        {
          ((c.b)localObject1).FpZ = (paramb.ANT - ((c.b)localObject1).tpS);
          if (((c.b)localObject1).FpZ > ((c.b)localObject1).GtU) {
            ((c.b)localObject1).FpZ -= ((c.b)localObject1).GtU;
          }
        }
        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onFirstVideoFrameRendered", (c.b)localObject1) + " firstVideoFrameRendered:" + ((c.b)localObject1).FpZ);
        return;
        localObject1 = this.FpB;
        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
        s.u(paramb, "event");
        paramb = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
      } while (paramb == null);
      paramb.Fte = 1;
      return;
      localObject1 = this.FpB;
      paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
      s.u(paramb, "event");
      localObject1 = (c.b)((com.tencent.mm.plugin.finder.video.reporter.c)localObject1).Gty.get(Long.valueOf(paramb.feedId));
    } while (localObject1 == null);
    label387:
    label405:
    label423:
    label443:
    label981:
    label1132:
    label1650:
    label1784:
    ((c.b)localObject1).Guo = paramb.ret;
    label954:
    label1229:
    label1501:
    Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.c.a("onPlayError", (c.b)localObject1) + " playerErrCode:" + ((c.b)localObject1).Guo);
    label1169:
    label1206:
    label1348:
    label1483:
    label1751:
    label2649:
    return;
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    s.u(paramc, "dispatcher");
    s.u(paramb, "event");
    return (paramb instanceof com.tencent.mm.plugin.finder.event.c.a);
  }
  
  public final MMFragmentActivity dUP()
  {
    return this.EzS;
  }
  
  protected final b eMu()
  {
    return this.Fpz;
  }
  
  public final com.tencent.mm.plugin.finder.video.reporter.c eMv()
  {
    return this.FpB;
  }
  
  public void eMw() {}
  
  public LinkedList<fhp> eMx()
  {
    return new LinkedList();
  }
  
  public final void f(bui parambui)
  {
    s.u(parambui, "contextObj");
    this.Auc = parambui;
    this.FpB.f(parambui);
  }
  
  public final bui getContextObj()
  {
    return this.Auc;
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    com.tencent.mm.ae.d.e(com.tencent.mm.plugin.finder.viewmodel.component.as.foC(), (kotlin.g.a.a)new d(this));
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "maps", "", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "megaVideoItem", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "report21140", "contextId", "extraInfo", "sourceFeedId", "sourceUserName", "report21464", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(331278);
      s.u(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(331278);
        return localJSONObject;
        localJSONObject.put("len", paramVarArgs[0]);
        localJSONObject.put("idx_last", paramVarArgs[1]);
        localJSONObject.put("idx_now", paramVarArgs[2]);
        localJSONObject.put("is_video", paramVarArgs[3]);
        localJSONObject.put("video_play_percent", paramVarArgs[4]);
        localJSONObject.put("video_replay_count", paramVarArgs[5]);
        localJSONObject.put("idx_type", paramVarArgs[6]);
        continue;
        localJSONObject.put("scene", paramVarArgs[0]);
        continue;
        localJSONObject.put("type", paramVarArgs[0]);
        localJSONObject.put("username", paramVarArgs[1]);
        continue;
        localJSONObject.put("type", paramVarArgs[0]);
        continue;
        localJSONObject.put("type", paramVarArgs[0]);
        continue;
        localJSONObject.put("type", paramVarArgs[0]);
      }
    }
    
    public static void a(bui parambui, long paramLong1, int paramInt, String paramString, long paramLong2, ca paramca)
    {
      AppMethodBeat.i(331258);
      s.u(parambui, "contextObj");
      s.u(paramString, "actionValue");
      Object localObject1 = av.GiL;
      if (!av.qN(paramLong1))
      {
        Log.i(m.access$getTAG$cp(), "feedId:" + paramLong1 + " is loacl fake feed,not report 18054");
        AppMethodBeat.o(331258);
        return;
      }
      dn localdn = new dn();
      int i;
      a.b localb;
      if (paramInt == 2)
      {
        localObject1 = k.aeZF;
        localObject1 = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.a.class);
        s.s(localObject1, "UICProvider.of(PluginFin…18054CacheVM::class.java)");
        localObject1 = (com.tencent.mm.plugin.finder.viewmodel.a)localObject1;
        i = parambui.AJo;
        if (!((com.tencent.mm.plugin.finder.viewmodel.a)localObject1).GJU)
        {
          ((com.tencent.mm.plugin.finder.viewmodel.a)localObject1).fmL();
          ((com.tencent.mm.plugin.finder.viewmodel.a)localObject1).GJU = true;
        }
        localb = (a.b)((com.tencent.mm.plugin.finder.viewmodel.a)localObject1).BvD.get(com.tencent.mm.plugin.finder.viewmodel.a.ay(i, paramLong1));
        if (localb != null) {
          break label822;
        }
        i = 0;
        if (i >= ((Number)((com.tencent.mm.plugin.finder.viewmodel.a)localObject1).GJV.getValue()).intValue()) {
          break label832;
        }
        i = 1;
        label184:
        if (i == 0)
        {
          Log.w(m.access$getTAG$cp(), "this feed[" + com.tencent.mm.ae.d.hF(paramLong1) + "] over limit exposed count in scene[" + parambui.AJo + ']');
          localdn.iAc = 1;
        }
        i = parambui.AJo;
        Object localObject2 = (ConcurrentMap)((com.tencent.mm.plugin.finder.viewmodel.a)localObject1).BvD;
        String str = com.tencent.mm.plugin.finder.viewmodel.a.ay(i, paramLong1);
        localObject1 = ((ConcurrentMap)localObject2).get(str);
        if (localObject1 != null) {
          break label1189;
        }
        localb = new a.b(i, paramLong1);
        localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(str, localb);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localb;
        }
      }
      label409:
      label544:
      label1189:
      for (;;)
      {
        localObject1 = (a.b)localObject1;
        ((a.b)localObject1).count += 1;
        ((a.b)localObject1).time = System.nanoTime();
        localdn.iuI = localdn.F("FeedID", com.tencent.mm.ae.d.hF(paramLong1), true);
        localdn.ipV = parambui.AJo;
        localdn.ipH = paramInt;
        localdn.izP = localdn.F("ActionValue", kotlin.n.n.bV(paramString, ",", ";"), true);
        if (BuildInfo.DEBUG)
        {
          paramInt = 0;
          localdn.izQ = paramInt;
          localdn.eJ(paramLong2);
          localdn.izT = localdn.F("sessionID", parambui.sessionId, true);
          if (paramca != null) {
            break label844;
          }
          paramString = null;
          if (paramString == null)
          {
            paramString = z.FrZ;
            paramString = z.jm(paramLong1);
            if (paramString != null)
            {
              localdn.izU = paramString.getMediaType();
              paramString = (dji)p.oL((List)paramString.getMediaList());
              if (paramString != null) {
                break label1034;
              }
              paramLong2 = 0L;
              label504:
              localdn.izV = paramLong2;
            }
          }
          paramString = z.FrZ;
          paramString = z.q(paramLong1, parambui.AJo);
          if (paramString != null) {
            break label1045;
          }
          paramca = null;
          if (paramca != null) {
            break label1055;
          }
          paramString = "";
          localdn.nx(paramString);
          paramString = bi.ABn;
          if (paramca != null) {
            break label1105;
          }
          paramString = "";
          label567:
          localObject1 = parambui.GSW;
          paramca = (ca)localObject1;
          if (localObject1 == null) {
            paramca = "";
          }
          localdn.iAb = localdn.F("client_udf_kv", kotlin.n.n.bV(bi.hG(paramString, paramca), ",", ";"), true);
          localdn.izW = localdn.F("ClickFeedId", com.tencent.mm.ae.d.hF(parambui.ADF), true);
          paramca = parambui.GSR;
          paramString = paramca;
          if (paramca == null) {
            paramString = "";
          }
          localdn.izX = localdn.F("ClickFeedContextId", paramString, true);
          localdn.ipU = localdn.F("ClickTabContextId", parambui.zIB, true);
          localdn.ipT = localdn.F("ContextId", parambui.zIO, true);
          paramString = parambui.extraInfo;
          if (paramString != null) {
            break label1129;
          }
          paramString = "";
          label726:
          localdn.iwJ = localdn.F("ExtraInfo", paramString, true);
          paramString = parambui.zIE;
          if (paramString != null) {
            break label1159;
          }
          paramString = "";
        }
        for (;;)
        {
          localdn.iwK = localdn.F("enterSourceInfo", paramString, true);
          localdn.izZ = 1L;
          localdn.iAa = localdn.F("jump_id", parambui.DUN, true);
          localdn.gNE();
          parambui = z.FrZ;
          z.a((com.tencent.mm.plugin.report.a)localdn);
          AppMethodBeat.o(331258);
          return;
          label822:
          i = localb.count;
          break;
          label832:
          i = 0;
          break label184;
          paramInt = 43;
          break label409;
          label844:
          localdn.izU = 4;
          paramString = z.FrZ;
          paramString = z.p(paramca.bZA(), parambui.AJo);
          if (paramString == null)
          {
            paramString = "";
            label879:
            localdn.nx(paramString);
            paramString = paramca.ABK;
            if (paramString != null) {
              break label968;
            }
            paramInt = 0;
          }
          for (;;)
          {
            localdn.izV = paramInt;
            localdn.izY = localdn.F("LongVideoId", com.tencent.mm.ae.d.hF(paramca.bZA()), true);
            paramString = ah.aiuX;
            break;
            localObject1 = kotlin.n.n.bV(paramString, ",", ";");
            paramString = (String)localObject1;
            if (localObject1 != null) {
              break label879;
            }
            paramString = "";
            break label879;
            label968:
            paramString = paramString.aaUt;
            if (paramString == null)
            {
              paramInt = 0;
            }
            else
            {
              paramString = paramString.media;
              if (paramString == null)
              {
                paramInt = 0;
              }
              else
              {
                paramString = (dnv)p.oL((List)paramString);
                if (paramString == null) {
                  paramInt = 0;
                } else {
                  paramInt = paramString.aaUX;
                }
              }
            }
          }
          paramLong2 = paramString.videoDuration;
          break label504;
          paramca = paramString.FuM;
          break label534;
          paramString = paramca.ZJK;
          if (paramString == null)
          {
            paramString = "";
            break label544;
          }
          localObject1 = kotlin.n.n.bV(paramString, ",", ";");
          paramString = (String)localObject1;
          if (localObject1 != null) {
            break label544;
          }
          paramString = "";
          break label544;
          label1105:
          paramca = paramca.ZZe;
          paramString = paramca;
          if (paramca != null) {
            break label567;
          }
          paramString = "";
          break label567;
          label1129:
          paramca = kotlin.n.n.bV(paramString, ",", ";");
          paramString = paramca;
          if (paramca != null) {
            break label726;
          }
          paramString = "";
          break label726;
          paramca = kotlin.n.n.bV(paramString, ",", ";");
          paramString = paramca;
          if (paramca == null) {
            paramString = "";
          }
        }
      }
    }
    
    public static void a(bui parambui, af paramaf)
    {
      AppMethodBeat.i(331329);
      s.u(parambui, "contextObj");
      s.u(paramaf, "record");
      dv localdv = new dv();
      localdv.ixm = localdv.F("Sessionid", parambui.sessionId, true);
      localdv.iwI = localdv.F("Contextid", parambui.zIO, true);
      localdv.ijl = localdv.F("ClickTabContextid", parambui.zIB, true);
      localdv.ipV = parambui.AJo;
      localdv.ivZ = localdv.F("FeedId", com.tencent.mm.ae.d.hF(paramaf.feedId), true);
      parambui = paramaf.ANj;
      long l1;
      label145:
      long l2;
      if (parambui == null)
      {
        l1 = 0L;
        localdv.iAV = l1;
        parambui = paramaf.ANj;
        if (parambui != null) {
          break label400;
        }
        parambui = "";
        localdv.iAU = localdv.F("FlodUsername", parambui, true);
        localdv.nJ("");
        l2 = 0L;
        parambui = FinderFoldedScrollLayout.Gzl;
        if (FinderFoldedScrollLayout.fkA() == 0L) {
          break label437;
        }
        parambui = FinderFoldedScrollLayout.Gzl;
        localdv.iAY = FinderFoldedScrollLayout.fkA();
        l1 = 0L;
      }
      for (;;)
      {
        label199:
        parambui = paramaf.ANj;
        if (parambui != null)
        {
          parambui = parambui.getFoldedLayout();
          if (parambui != null)
          {
            parambui = parambui.ZIQ;
            if (parambui != null)
            {
              Object localObject = ((Iterable)parambui).iterator();
              int i = 0;
              for (;;)
              {
                label239:
                if (!((Iterator)localObject).hasNext()) {
                  break label751;
                }
                parambui = ((Iterator)localObject).next();
                int j = i + 1;
                if (i < 0) {
                  p.kkW();
                }
                FinderObject localFinderObject = (FinderObject)parambui;
                parambui = paramaf.AOo;
                if (parambui == null) {
                  parambui = null;
                }
                for (;;)
                {
                  if (parambui != null) {
                    break label530;
                  }
                  parambui = null;
                  if (parambui != null) {
                    break label746;
                  }
                  parambui = m.Fpx;
                  if (l2 != localFinderObject.id) {
                    break label696;
                  }
                  localdv.nJ(localdv.iAW + com.tencent.mm.ae.d.hF(localFinderObject.id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                  break label239;
                  parambui = parambui.getFoldedLayout();
                  if (parambui == null)
                  {
                    l1 = 0L;
                    break;
                  }
                  l1 = parambui.lNX;
                  break;
                  label400:
                  parambui = parambui.getFoldedLayout();
                  if (parambui == null)
                  {
                    parambui = "";
                    break label145;
                  }
                  localObject = parambui.username;
                  parambui = (bui)localObject;
                  if (localObject != null) {
                    break label145;
                  }
                  parambui = "";
                  break label145;
                  label437:
                  parambui = FinderFoldedScrollLayout.Gzl;
                  if (FinderFoldedScrollLayout.fkC() != 0L)
                  {
                    parambui = FinderFoldedScrollLayout.Gzl;
                    localdv.iAX = FinderFoldedScrollLayout.fkC();
                    l1 = 0L;
                    break label199;
                  }
                  parambui = FinderFoldedScrollLayout.Gzl;
                  if (FinderFoldedScrollLayout.fkF() == 0L) {
                    break label805;
                  }
                  parambui = FinderFoldedScrollLayout.Gzl;
                  l2 = FinderFoldedScrollLayout.fkD();
                  parambui = FinderFoldedScrollLayout.Gzl;
                  l1 = FinderFoldedScrollLayout.fkF();
                  break label199;
                  parambui = parambui.agOy;
                  if (parambui == null) {
                    parambui = null;
                  } else {
                    parambui = (com.tencent.mm.view.recyclerview.n)parambui.get(localFinderObject.id);
                  }
                }
                label530:
                if (l2 == parambui.agOG.bZA()) {
                  localdv.nJ(localdv.iAW + com.tencent.mm.ae.d.hF(parambui.agOG.bZA()) + ';' + i + ';' + parambui.Fzm + ';' + l1 + '#');
                }
                for (;;)
                {
                  parambui = ah.aiuX;
                  break;
                  localdv.nJ(localdv.iAW + com.tencent.mm.ae.d.hF(parambui.agOG.bZA()) + ';' + i + ';' + parambui.Fzm + ";0#");
                }
                label696:
                localdv.nJ(localdv.iAW + com.tencent.mm.ae.d.hF(localFinderObject.id) + ';' + i + ";0;0#");
                label746:
                i = j;
              }
            }
          }
        }
        label751:
        parambui = FinderFoldedScrollLayout.Gzl;
        FinderFoldedScrollLayout.fkB();
        parambui = FinderFoldedScrollLayout.Gzl;
        FinderFoldedScrollLayout.fkG();
        parambui = FinderFoldedScrollLayout.Gzl;
        FinderFoldedScrollLayout.fkE();
        parambui = FinderFoldedScrollLayout.Gzl;
        FinderFoldedScrollLayout.rb(0L);
        localdv.gNE();
        parambui = z.FrZ;
        z.a((com.tencent.mm.plugin.report.a)localdv);
        AppMethodBeat.o(331329);
        return;
        label805:
        l1 = 0L;
      }
    }
    
    public static void a(bui parambui, af paramaf, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(331309);
      s.u(parambui, "contextObj");
      s.u(paramaf, "record");
      FinderItem localFinderItem = paramaf.ANj;
      if (localFinderItem != null)
      {
        ed localed = new ed();
        localed.ivZ = localed.F("FeedId", com.tencent.mm.ae.d.hF(localFinderItem.getId()), true);
        localed.iwe = localFinderItem.getMediaType();
        localed.ijk = localed.F("SessionId", parambui.sessionId, true);
        localed.ipV = parambui.AJo;
        localed.iBY = paramaf.hlB;
        localed.iBZ = localFinderItem.getLikeCount();
        localed.iCa = localFinderItem.getCommentCount();
        Object localObject1 = com.tencent.mm.plugin.finder.utils.as.GiG;
        localed.iCb = localed.F("topic", kotlin.n.n.m(com.tencent.mm.plugin.finder.utils.as.F(localFinderItem), ",", ";", false), true);
        Object localObject2 = localFinderItem.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localed.iCc = localed.F("recommendWording", kotlin.n.n.m((String)localObject1, ",", ";", false), true);
        long l1;
        if (s.p(localFinderItem.getUserName(), com.tencent.mm.model.z.bAW()))
        {
          l1 = 1L;
          localed.iCd = l1;
          localed.iCe = localFinderItem.getCreateTime();
          if ((localFinderItem.getLocation().latitude > 0.0F) && (localFinderItem.getLocation().longitude > 0.0F)) {
            localed.iqE = 1L;
          }
          localed.iCf = localFinderItem.getMediaList().size();
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localed.irv = ((dji)localFinderItem.getMediaList().get(0)).videoDuration;
          }
          localed.iAQ = (paramaf.endTime - paramaf.startTime);
          if (!BuildInfo.DEBUG) {
            break label804;
          }
          l1 = l2;
          label361:
          localed.iwf = l1;
          localed.iCg = localFinderItem.getFeedObject().recommendType;
          localed.izv = localed.F("FeedUsername", localFinderItem.getUserName(), true);
          localed.iCh = localFinderItem.getFeedObject().orgRecommendType;
          localObject2 = localFinderItem.getFeedObject().warnWording;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localed.iCi = localed.F("NoticeWording", (String)localObject1, true);
          localed.iCj = localFinderItem.getFeedObject().warnFlag;
          localed.iCk = paramInt;
          localObject2 = parambui.zIO;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localed.ipT = localed.F("ContextId", (String)localObject1, true);
          localed.izW = localed.F("ClickFeedId", com.tencent.mm.ae.d.hF(parambui.ADF), true);
          localObject2 = parambui.GSR;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localed.izX = localed.F("ClickFeedContextId", (String)localObject1, true);
          localObject2 = parambui.zIB;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localed.ipU = localed.F("ClickTabContextId", (String)localObject1, true);
          localed.iAO = paramaf.FsD;
          paramaf = com.tencent.mm.plugin.findersdk.b.c.HcH;
          localed.iAE = com.tencent.mm.plugin.findersdk.b.c.a.VA(parambui.AJo);
          paramaf = z.FrZ;
          localed.iqp = localed.F("SessionBuffer", z.p(localFinderItem.getId(), parambui.AJo), true);
          parambui = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
          parambui = com.tencent.mm.plugin.finder.upload.action.l.fek().x(localFinderItem.getFeedObject());
          localed.iCm = parambui.size();
          if (parambui.size() <= 3) {
            break label811;
          }
        }
        label804:
        label811:
        for (localed.iCn = 3L;; localed.iCn = parambui.size())
        {
          localed.oj("");
          parambui = ((Iterable)parambui).iterator();
          paramInt = 0;
          while (parambui.hasNext())
          {
            paramaf = parambui.next();
            if (paramInt < 0) {
              p.kkW();
            }
            paramaf = (FinderCommentInfo)paramaf;
            if (paramInt <= 2) {
              localed.oj(localed.iCo + paramaf.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          l1 = 5L;
          break label361;
        }
        localed.iCp = localFinderItem.getFeedObject().commentList.size();
        parambui = localFinderItem.getFeedObject().commentList;
        s.s(parambui, "it.feedObject.commentList");
        parambui = (FinderCommentInfo)p.oL((List)parambui);
        if (parambui == null) {
          parambui = "";
        }
        for (;;)
        {
          localed.iCq = localed.F("ExpoCommentUser", parambui, true);
          parambui = av.GiL;
          if (av.H(localFinderItem)) {
            localed.iCt = localFinderItem.getFeedObject().incFriendLikeCount;
          }
          parambui = localFinderItem.getFeedObject().commentList;
          s.s(parambui, "it.feedObject.commentList");
          paramaf = (Iterable)parambui;
          parambui = (Collection)new ArrayList();
          paramaf = paramaf.iterator();
          while (paramaf.hasNext())
          {
            localObject1 = paramaf.next();
            localObject2 = (FinderCommentInfo)localObject1;
            if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).isFriend(((FinderCommentInfo)localObject2).username)) {
              parambui.add(localObject1);
            }
          }
          paramaf = parambui.username;
          parambui = paramaf;
          if (paramaf == null) {
            parambui = "";
          }
        }
        localed.iCu = ((List)parambui).size();
        localed.iCv = localFinderItem.getFeedObject().commentList.size();
        localed.gNE();
        parambui = z.FrZ;
        z.a((com.tencent.mm.plugin.report.a)localed);
      }
      AppMethodBeat.o(331309);
    }
    
    public static String aj(Map<String, ? extends Object> paramMap)
    {
      AppMethodBeat.i(331287);
      s.u(paramMap, "maps");
      aw localaw = aw.Gjk;
      paramMap = aw.aj(paramMap);
      AppMethodBeat.o(331287);
      return paramMap;
    }
    
    public static void v(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(331338);
      ee localee = new ee();
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      localee.iny = localee.F("contextid", str, true);
      if (paramString2 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        localee.iCw = localee.F("ReportExtraInfo", paramString1, true);
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        localee.iCx = localee.F("EnterSourceFeedid", paramString1, true);
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        localee.iCy = localee.F("EnterSourceUsername", paramString1, true);
        localee.bMH();
        AppMethodBeat.o(331338);
        return;
        paramString2 = kotlin.n.n.m(paramString2, ",", ";", false);
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "", "()V", "isReceivedMsg", "", "()Z", "setReceivedMsg", "(Z)V", "isRingUp", "setRingUp", "reset", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    boolean FpD;
    boolean FpE;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final a FpF;
    private static final String FpG;
    
    static
    {
      AppMethodBeat.i(331216);
      FpF = new a((byte)0);
      FpG = "1";
      AppMethodBeat.o(331216);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT$Companion;", "", "()V", "CLICK", "", "getCLICK", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static String eMz()
      {
        AppMethodBeat.i(331048);
        String str = m.c.eMy();
        AppMethodBeat.o(331048);
        return str;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */