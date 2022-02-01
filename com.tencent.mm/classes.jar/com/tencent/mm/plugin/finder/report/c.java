package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import d.g.b.q;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"})
public abstract class c
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  public static final a sxE = new a((byte)0);
  final MMActivity activity;
  public arn rQw;
  private final long sxC;
  public final s sxD;
  boolean visible;
  
  public c(MMActivity paramMMActivity, arn paramarn)
  {
    this.activity = paramMMActivity;
    this.rQw = paramarn;
    this.sxC = 1277L;
    this.sxD = new s(this.rQw);
    this.visible = true;
  }
  
  public void a(b paramb)
  {
    d.g.b.p.h(paramb, "event");
    if (this.rQw.sch == 0) {
      ae.i(TAG, "[onEventHappen] invalid scene");
    }
    Object localObject1;
    label787:
    label839:
    label1099:
    label1104:
    do
    {
      do
      {
        Object localObject2;
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
                                            return;
                                          } while (!(paramb instanceof com.tencent.mm.plugin.finder.event.c.a));
                                          switch (((com.tencent.mm.plugin.finder.event.c.a)paramb).type)
                                          {
                                          default: 
                                            return;
                                          case 1: 
                                            com.tencent.mm.plugin.report.e.ywz.idkeyStat(this.sxC, 1L, 1L, false);
                                            localObject1 = this.sxD;
                                            paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                            d.g.b.p.h(paramb, "event");
                                            localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                                          }
                                        } while (localObject1 == null);
                                        ((s.b)localObject1).bfZ = true;
                                        ((s.b)localObject1).szF = paramb.rZe;
                                        if (((s.b)localObject1).sBu > 0L)
                                        {
                                          ((s.b)localObject1).sBt += paramb.rZe - ((s.b)localObject1).sBu;
                                          ((s.b)localObject1).sBu = 0L;
                                        }
                                        paramb = new StringBuilder();
                                        d.g.b.p.g(localObject1, "this");
                                        ae.i("Finder.FinderVideoPlayReporter", s.a("onResume", (s.b)localObject1) + " onResume:" + ((s.b)localObject1).sBt);
                                        return;
                                        com.tencent.mm.plugin.report.e.ywz.idkeyStat(this.sxC, 2L, 1L, false);
                                        localObject1 = this.sxD;
                                        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                        d.g.b.p.h(paramb, "event");
                                        paramb = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                                      } while (paramb == null);
                                      paramb.sBq += 1;
                                      return;
                                      localObject1 = this.sxD;
                                      paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                      d.g.b.p.h(paramb, "event");
                                      localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                                    } while (localObject1 == null);
                                    ((s.b)localObject1).sBG.add(Integer.valueOf(paramb.offset));
                                    localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
                                    i = com.tencent.mm.plugin.finder.utils.p.fV(paramb.offset, paramb.ihz);
                                  } while (i <= ((s.b)localObject1).sBh);
                                  ((s.b)localObject1).sBh = i;
                                  return;
                                  com.tencent.mm.plugin.report.e.ywz.idkeyStat(this.sxC, 0L, 1L, false);
                                  localObject2 = this.sxD;
                                  localObject3 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                  d.g.b.p.h(localObject3, "event");
                                  localObject4 = new s.b();
                                  localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
                                  paramb = (b)localObject1;
                                  if (localObject1 == null) {
                                    paramb = "";
                                  }
                                  d.g.b.p.h(paramb, "<set-?>");
                                  ((s.b)localObject4).sessionId = paramb;
                                  ((s.b)localObject4).sAZ = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).duw;
                                  paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYW;
                                  if (paramb != null)
                                  {
                                    localObject1 = paramb.aeM();
                                    paramb = (b)localObject1;
                                    if (localObject1 != null) {}
                                  }
                                  else
                                  {
                                    paramb = "";
                                  }
                                  d.g.b.p.h(paramb, "<set-?>");
                                  ((s.b)localObject4).sBa = paramb;
                                  ((s.b)localObject4).sBb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYW;
                                  ((s.b)localObject4).sBc = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYV;
                                  paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYW;
                                  if (paramb != null)
                                  {
                                    localObject1 = paramb.getPath();
                                    paramb = (b)localObject1;
                                    if (localObject1 != null) {}
                                  }
                                  else
                                  {
                                    paramb = "";
                                  }
                                  d.g.b.p.h(paramb, "<set-?>");
                                  ((s.b)localObject4).mediaPath = paramb;
                                  ((s.b)localObject4).mbM = ((b)localObject3).rZe;
                                  ((s.b)localObject4).sBe = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).position;
                                  ((s.b)localObject4).sBf = 1;
                                  ((s.b)localObject4).sBr = true;
                                  ((s.b)localObject4).rYZ = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYZ;
                                  ((s.b)localObject4).sBs = CdnLogic.getRecentAverageSpeed(2);
                                  paramb = ak.getContext().getSystemService("audio");
                                  if (paramb == null) {
                                    throw new d.v("null cannot be cast to non-null type android.media.AudioManager");
                                  }
                                  ((s.b)localObject4).szM = ((AudioManager)paramb).getStreamVolume(3);
                                  paramb = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
                                  paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYW;
                                  if (paramb != null)
                                  {
                                    localObject1 = paramb.aeM();
                                    paramb = (b)localObject1;
                                    if (localObject1 != null) {}
                                  }
                                  else
                                  {
                                    paramb = "";
                                  }
                                  paramb = com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramb);
                                  boolean bool;
                                  if (((s.b)localObject4).rYZ > 0)
                                  {
                                    i = ((s.b)localObject4).rYZ + 1;
                                    ((s.b)localObject4).sBi = i;
                                    if (!paramb.field_hasPlayed) {
                                      break label1081;
                                    }
                                    i = 0;
                                    ((s.b)localObject4).sBp = i;
                                    ((s.b)localObject4).sBj = paramb.cEL();
                                    localObject1 = paramb.field_fileFormat;
                                    paramb = (b)localObject1;
                                    if (localObject1 == null) {
                                      paramb = "";
                                    }
                                    ((s.b)localObject4).aiN(paramb);
                                    if (((s.b)localObject4).sBj == 100) {
                                      break label1086;
                                    }
                                    bool = true;
                                    ((s.b)localObject4).sBr = bool;
                                    paramb = com.tencent.mm.sdk.platformtools.az.getNetTypeString(ak.getContext());
                                    d.g.b.p.g(paramb, "NetStatusUtil.getNetType…tionContext.getContext())");
                                    d.g.b.p.h(paramb, "<set-?>");
                                    ((s.b)localObject4).sBn = paramb;
                                    paramb = i.syT;
                                    ((s.b)localObject4).sBo = i.cFu();
                                    paramb = i.syT;
                                    ((s.b)localObject4).sBz = i.wK(((s.b)localObject4).sAZ);
                                    if (!com.tencent.mm.modelcontrol.d.pi(4)) {
                                      break label1092;
                                    }
                                    paramb = "h265";
                                    d.g.b.p.h(paramb, "<set-?>");
                                    ((s.b)localObject4).sBL = paramb;
                                    ((s.b)localObject4).sBd = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().sun;
                                    paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYV;
                                    if (paramb == null) {
                                      break label1099;
                                    }
                                    f = paramb.width;
                                    ((s.b)localObject4).sBM = f;
                                    paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYV;
                                    if (paramb == null) {
                                      break label1104;
                                    }
                                  }
                                  for (float f = paramb.height;; f = 0.0F)
                                  {
                                    ((s.b)localObject4).sBN = f;
                                    ((s.b)localObject4).rYZ = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).rYZ;
                                    ((Map)((s)localObject2).DQY).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject3).duw), localObject4);
                                    ae.i("Finder.FinderVideoPlayReporter", s.a("onStartPlay", (s.b)localObject4) + " firstplay:" + ((s.b)localObject4).sBp);
                                    return;
                                    if (paramb.cEL() > 0)
                                    {
                                      i = 1;
                                      break;
                                    }
                                    i = 0;
                                    break;
                                    i = 1;
                                    break label787;
                                    bool = false;
                                    break label839;
                                    paramb = "h264";
                                    break label914;
                                    f = 0.0F;
                                    break label962;
                                  }
                                  localObject1 = this.sxD;
                                  paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                  d.g.b.p.h(paramb, "event");
                                  localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                                } while (localObject1 == null);
                                ((s.b)localObject1).bfZ = false;
                                ((s.b)localObject1).sBu = paramb.rZe;
                                if (((s.b)localObject1).szF > 0L)
                                {
                                  ((s.b)localObject1).szE += paramb.rZe - ((s.b)localObject1).szF;
                                  ((s.b)localObject1).szF = 0L;
                                }
                                paramb = new StringBuilder();
                                d.g.b.p.g(localObject1, "this");
                                ae.i("Finder.FinderVideoPlayReporter", s.a("onPause", (s.b)localObject1) + " realPlayTime:" + ((s.b)localObject1).szE);
                                return;
                                com.tencent.mm.plugin.report.e.ywz.idkeyStat(this.sxC, 3L, 1L, false);
                                localObject2 = this.sxD;
                                localObject4 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                d.g.b.p.h(localObject4, "event");
                                localObject3 = (s.b)((s)localObject2).DQY.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject4).duw));
                              } while ((localObject3 == null) || (((s.b)localObject3).sAZ != ((com.tencent.mm.plugin.finder.event.c.a)localObject4).duw));
                              localObject1 = ((s.b)localObject3).sBa;
                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).rYW;
                              if (paramb != null) {}
                              for (paramb = paramb.aeM(); d.g.b.p.i(localObject1, paramb); paramb = null)
                              {
                                ((s.b)localObject3).szG = (((b)localObject4).rZe - ((s.b)localObject3).mbM);
                                if (((s.b)localObject3).sBu > 0L)
                                {
                                  ((s.b)localObject3).sBt += ((b)localObject4).rZe - ((s.b)localObject3).sBu;
                                  ((s.b)localObject3).sBu = 0L;
                                }
                                if (((s.b)localObject3).szF > 0L)
                                {
                                  ((s.b)localObject3).szE += ((b)localObject4).rZe - ((s.b)localObject3).szF;
                                  ((s.b)localObject3).szF = 0L;
                                }
                                if (((s.b)localObject3).sBx > 0L)
                                {
                                  ((s.b)localObject3).sBy += ((b)localObject4).rZe - ((s.b)localObject3).sBx;
                                  ((s.b)localObject3).sBx = 0L;
                                  paramb = new atl();
                                  paramb.GKm = ((int)(((b)localObject4).rZe - ((s.b)localObject3).sBx));
                                  paramb.percent = ((s.b)localObject3).sBh;
                                  paramb.type = 0;
                                  ((s.b)localObject3).sBF.add(paramb);
                                }
                                paramb = ak.getContext().getSystemService("audio");
                                if (paramb != null) {
                                  break label1566;
                                }
                                throw new d.v("null cannot be cast to non-null type android.media.AudioManager");
                              }
                              ((s.b)localObject3).szN = ((AudioManager)paramb).getStreamVolume(3);
                              if ((((s.b)localObject3).sBv == 0L) && (((s.b)localObject3).sBr) && (((s.b)localObject3).sBh < 5)) {
                                ((s.b)localObject3).iuK = 1;
                              }
                              paramb = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).rYW;
                              if (paramb != null)
                              {
                                localObject1 = paramb.aeM();
                                paramb = (b)localObject1;
                                if (localObject1 != null) {}
                              }
                              else
                              {
                                paramb = "";
                              }
                              localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramb).field_fileFormat;
                              paramb = (b)localObject1;
                              if (localObject1 == null) {
                                paramb = "";
                              }
                              ((s.b)localObject3).aiN(paramb);
                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).rYW;
                              if (paramb != null)
                              {
                                localObject1 = paramb.getPath();
                                paramb = (b)localObject1;
                                if (localObject1 != null) {}
                              }
                              else
                              {
                                paramb = "";
                              }
                              paramb = com.tencent.mm.plugin.sight.base.e.ayN(paramb);
                              if (paramb != null)
                              {
                                ((s.b)localObject3).sBJ = paramb.videoBitrate;
                                ((s.b)localObject3).sBK = paramb.audioBitrate;
                                ((s.b)localObject3).frameRate = paramb.frameRate;
                              }
                              if (!((s.b)localObject3).sBD) {
                                ((s)localObject2).a((s.b)localObject3);
                              }
                              for (;;)
                              {
                                ((s)localObject2).DQY.remove(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject4).duw));
                                paramb = new StringBuilder();
                                d.g.b.p.g(localObject3, "this");
                                ae.i("Finder.FinderVideoPlayReporter", s.a("onStopPlay", (s.b)localObject3) + " playTime:" + ((s.b)localObject3).szG + " pauseTotalTime:" + ((s.b)localObject3).sBt + " realPlayTime:" + ((s.b)localObject3).szE + " playStatus:" + ((s.b)localObject3).iuK);
                                return;
                                ((s)localObject2).sAT.add(localObject3);
                              }
                              localObject1 = this.sxD;
                              paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                              d.g.b.p.h(paramb, "event");
                              localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                            } while (localObject1 == null);
                            ((s.b)localObject1).sBr = true;
                            ((s.b)localObject1).sBx = paramb.rZe;
                            ((s.b)localObject1).sBw += 1;
                            if (((s.b)localObject1).sBv > 0L) {
                              ((s.b)localObject1).sBE += 1L;
                            }
                            d.g.b.p.g(localObject1, "this");
                            ae.i("Finder.FinderVideoPlayReporter", String.valueOf(s.a("onWaiting", (s.b)localObject1)));
                            return;
                            localObject1 = this.sxD;
                            localObject2 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                            d.g.b.p.h(localObject2, "event");
                            paramb = (s.b)((s)localObject1).DQY.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject2).duw));
                          } while (paramb == null);
                          paramb.sBr = false;
                        } while (paramb.sBx <= 0L);
                        long l = ((b)localObject2).rZe - paramb.sBx;
                        paramb.sBy += l;
                        localObject1 = new atl();
                        ((atl)localObject1).GKm = ((int)l);
                        ((atl)localObject1).percent = paramb.sBh;
                        if ((paramb.sBw == 1) && (paramb.sBE == 0L)) {}
                        for (((atl)localObject1).type = 2;; ((atl)localObject1).type = 0)
                        {
                          paramb.sBF.add(localObject1);
                          paramb.sBx = 0L;
                          localObject1 = new StringBuilder();
                          d.g.b.p.g(paramb, "this");
                          ae.i("Finder.FinderVideoPlayReporter", s.a("onWaitingEnd", paramb) + " totalWaitingTime:" + paramb.sBy);
                          return;
                        }
                        localObject1 = this.sxD;
                        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                        d.g.b.p.h(paramb, "event");
                        localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                      } while (localObject1 == null);
                      if (((s.b)localObject1).sBl == 0L) {
                        ((s.b)localObject1).sBl = (paramb.rZe - ((s.b)localObject1).mbM - ((s.b)localObject1).sBt);
                      }
                      ((s.b)localObject1).sBm = (paramb.offset + paramb.ihz);
                      ((s.b)localObject1).sBr = false;
                      paramb = new StringBuilder();
                      d.g.b.p.g(localObject1, "this");
                      ae.i("Finder.FinderVideoPlayReporter", s.a("onMoovReady", (s.b)localObject1) + " moovReadyTime:" + ((s.b)localObject1).sBl);
                      return;
                      localObject1 = this.sxD;
                      paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                      d.g.b.p.h(paramb, "event");
                      localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                    } while (localObject1 == null);
                    localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
                    i = com.tencent.mm.plugin.finder.utils.p.fV(paramb.offset, paramb.ihz);
                  } while (i <= ((s.b)localObject1).lxg);
                  ((s.b)localObject1).lxg = i;
                  return;
                  localObject1 = this.sxD;
                  paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                  d.g.b.p.h(paramb, "event");
                  localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
                } while ((localObject1 == null) || (((s.b)localObject1).sBA != 0L));
                ((s.b)localObject1).sBA = (paramb.offset + paramb.ihz);
                return;
                localObject1 = this.sxD;
                paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                d.g.b.p.h(paramb, "event");
                localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
              } while (localObject1 == null);
              ((s.b)localObject1).sBk = (paramb.rZe - ((s.b)localObject1).mbM);
              paramb = paramb.gzD;
              if ((paramb != null) && (((s.b)localObject1).sBC == null)) {
                ((s.b)localObject1).sBC = s.b(paramb);
              }
              d.g.b.p.g(localObject1, "this");
              ae.i("Finder.FinderVideoPlayReporter", String.valueOf(s.a("onDownloadFinish", (s.b)localObject1)));
              return;
              this.sxD.a((com.tencent.mm.plugin.finder.event.c.a)paramb);
              return;
              localObject1 = this.sxD;
              paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
              d.g.b.p.h(paramb, "event");
              paramb = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
            } while (paramb == null);
            paramb.sBD = true;
            d.g.b.p.g(paramb, "this");
            ae.i("Finder.FinderVideoPlayReporter", String.valueOf(s.a("onDownloadStart", paramb)));
            return;
            localObject1 = this.sxD;
            paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
            d.g.b.p.h(paramb, "event");
            paramb = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
          } while (paramb == null);
          paramb.szJ = 1;
          return;
          localObject1 = this.sxD;
          localObject2 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
          d.g.b.p.h(localObject2, "event");
          paramb = (s.b)((s)localObject1).DQY.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject2).duw));
        } while (paramb == null);
        if (paramb.sBv == 0L)
        {
          paramb.sBv = (((b)localObject2).rZe - paramb.mbM);
          if (paramb.sBv > paramb.sBt) {
            paramb.sBv -= paramb.sBt;
          }
        }
        if (paramb.sBg == 0L) {
          paramb.sBg = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).rZa;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).rYV;
        if (localObject1 != null)
        {
          localObject1 = ((bvz)localObject1).HiY;
          if (localObject1 == null) {}
        }
        for (int i = ((FinderMediaReportObject)localObject1).playDecoderType;; i = 0)
        {
          paramb.playDecoderType = i;
          localObject1 = new StringBuilder();
          d.g.b.p.g(paramb, "this");
          ae.i("Finder.FinderVideoPlayReporter", s.a("onFirstFrameUpdate", paramb) + " firstFrameTime:" + paramb.sBv + " firstLoadTime:" + paramb.sBg + " playDecoderType=" + paramb.playDecoderType);
          return;
        }
        localObject1 = this.sxD;
        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
        d.g.b.p.h(paramb, "event");
        paramb = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
      } while (paramb == null);
      paramb.szI = 1;
      return;
      localObject1 = this.sxD;
      paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
      d.g.b.p.h(paramb, "event");
      localObject1 = (s.b)((s)localObject1).DQY.get(Long.valueOf(paramb.duw));
    } while (localObject1 == null);
    label914:
    label962:
    label1092:
    ((s.b)localObject1).sBO = paramb.ret;
    label1081:
    label1086:
    paramb = new StringBuilder();
    label1566:
    d.g.b.p.g(localObject1, "this");
    ae.i("Finder.FinderVideoPlayReporter", s.a("onPlayError", (s.b)localObject1) + " playerErrCode:" + ((s.b)localObject1).sBO);
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    d.g.b.p.h(paramc, "dispatcher");
    d.g.b.p.h(paramb, "event");
    return (paramb instanceof com.tencent.mm.plugin.finder.event.c.a);
  }
  
  public final void c(arn paramarn)
  {
    d.g.b.p.h(paramarn, "contextObj");
    this.rQw = paramarn;
    this.sxD.c(paramarn);
  }
  
  public LinkedList<dje> cFh()
  {
    return new LinkedList();
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    FinderReporterUIC.a locala = FinderReporterUIC.tnG;
    com.tencent.mm.ac.c.c(FinderReporterUIC.cRd(), (d.g.a.a)new c(this));
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "maps", "", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "plugin-finder_release"})
  public static final class a
  {
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(203743);
      d.g.b.p.h(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(203743);
        return localJSONObject;
        localJSONObject.put("len", paramVarArgs[0]);
        localJSONObject.put("idx_last", paramVarArgs[1]);
        localJSONObject.put("idx_now", paramVarArgs[2]);
        localJSONObject.put("is_video", paramVarArgs[3]);
        localJSONObject.put("video_play_percent", paramVarArgs[4]);
        localJSONObject.put("video_replay_count", paramVarArgs[5]);
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
    
    public static void a(arn paramarn, long paramLong1, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(203741);
      d.g.b.p.h(paramarn, "contextObj");
      d.g.b.p.h(paramString, "actionValue");
      ar localar = new ar();
      localar.ih(com.tencent.mm.ac.c.rp(paramLong1));
      localar.dD(paramarn.sch);
      localar.iq(paramInt);
      localar.ii(n.h(paramString, ",", ";", false));
      if (com.tencent.mm.sdk.platformtools.j.DEBUG)
      {
        paramInt = 0;
        localar.ir(paramInt);
        localar.dB(paramLong2);
        localar.ij(paramarn.sessionId);
        paramString = i.syT;
        paramString = i.wJ(paramLong1);
        if (paramString != null)
        {
          localar.is(paramString.getMediaType());
          paramString = (bvz)d.a.j.jm((List)paramString.getMediaList());
          if (paramString == null) {
            break label393;
          }
        }
      }
      label393:
      for (paramLong2 = paramString.videoDuration;; paramLong2 = 0L)
      {
        localar.dC(paramLong2);
        paramString = i.syT;
        paramString = i.I(paramLong1, paramarn.sch);
        if (paramString != null)
        {
          str = n.h(paramString, ",", ";", false);
          paramString = str;
          if (str != null) {}
        }
        else
        {
          paramString = "";
        }
        localar.ik(paramString);
        localar.il(com.tencent.mm.ac.c.rp(paramarn.tnd));
        String str = paramarn.tne;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localar.im(paramString);
        localar.in(paramarn.rfo);
        localar.io(paramarn.rfA);
        paramString = paramarn.extraInfo;
        if (paramString != null)
        {
          str = n.h(paramString, ",", ";", false);
          paramString = str;
          if (str != null) {}
        }
        else
        {
          paramString = "";
        }
        localar.ip(paramString);
        paramarn = paramarn.rfr;
        if (paramarn != null)
        {
          paramString = n.h(paramarn, ",", ";", false);
          paramarn = paramString;
          if (paramString != null) {}
        }
        else
        {
          paramarn = "";
        }
        localar.iq(paramarn);
        localar.dNp();
        paramarn = i.syT;
        i.a((com.tencent.mm.plugin.report.a)localar);
        AppMethodBeat.o(203741);
        return;
        paramInt = 43;
        break;
      }
    }
    
    public static void a(arn paramarn, m paramm)
    {
      AppMethodBeat.i(203746);
      d.g.b.p.h(paramarn, "contextObj");
      d.g.b.p.h(paramm, "record");
      com.tencent.mm.g.b.a.az localaz = new com.tencent.mm.g.b.a.az();
      localaz.iZ(paramarn.sessionId);
      localaz.ja(paramarn.rfA);
      localaz.jb(paramarn.rfo);
      localaz.eo(paramarn.sch);
      localaz.jc(com.tencent.mm.ac.c.rp(paramm.duw));
      paramarn = paramm.feed;
      long l1;
      Object localObject1;
      label148:
      long l2;
      if (paramarn != null)
      {
        paramarn = paramarn.getFoldedLayout();
        if (paramarn != null)
        {
          l1 = paramarn.fVS;
          localaz.ep(l1);
          paramarn = paramm.feed;
          if (paramarn != null)
          {
            paramarn = paramarn.getFoldedLayout();
            if (paramarn != null)
            {
              localObject1 = paramarn.username;
              paramarn = (arn)localObject1;
              if (localObject1 != null) {
                break label148;
              }
            }
          }
          paramarn = "";
          localaz.jd(paramarn);
          localaz.je("");
          l2 = 0L;
          paramarn = FinderFoldedScrollLayout.tfJ;
          if (FinderFoldedScrollLayout.cPZ() == 0L) {
            break label409;
          }
          paramarn = FinderFoldedScrollLayout.tfJ;
          localaz.er(FinderFoldedScrollLayout.cPZ());
          l1 = 0L;
        }
      }
      for (;;)
      {
        label194:
        paramarn = paramm.feed;
        if (paramarn != null)
        {
          paramarn = paramarn.getFoldedLayout();
          if (paramarn != null)
          {
            paramarn = paramarn.GFu;
            if (paramarn != null)
            {
              localObject1 = ((Iterable)paramarn).iterator();
              int i = 0;
              for (;;)
              {
                label234:
                if (!((Iterator)localObject1).hasNext()) {
                  break label692;
                }
                paramarn = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  d.a.j.gkd();
                }
                Object localObject2 = (FinderObject)paramarn;
                paramarn = paramm.rZD;
                if (paramarn != null)
                {
                  paramarn = paramarn.LSq;
                  if (paramarn != null) {
                    paramarn = (h)paramarn.get(((FinderObject)localObject2).id);
                  }
                }
                for (;;)
                {
                  if (paramarn != null)
                  {
                    if (l2 == paramarn.LSx.lP())
                    {
                      localObject2 = localaz.Sb();
                      localaz.je((String)localObject2 + com.tencent.mm.ac.c.rp(paramarn.LSx.lP()) + ';' + i + ';' + paramarn.LSy + ';' + l1 + '#');
                      i = j;
                      break label234;
                      l1 = 0L;
                      break;
                      label409:
                      paramarn = FinderFoldedScrollLayout.tfJ;
                      if (FinderFoldedScrollLayout.cQa() != 0L)
                      {
                        paramarn = FinderFoldedScrollLayout.tfJ;
                        localaz.eq(FinderFoldedScrollLayout.cQa());
                        l1 = 0L;
                        break label194;
                      }
                      paramarn = FinderFoldedScrollLayout.tfJ;
                      if (FinderFoldedScrollLayout.cQc() == 0L) {
                        break label748;
                      }
                      paramarn = FinderFoldedScrollLayout.tfJ;
                      l2 = FinderFoldedScrollLayout.cQb();
                      paramarn = FinderFoldedScrollLayout.tfJ;
                      l1 = FinderFoldedScrollLayout.cQc();
                      break label194;
                      paramarn = null;
                      continue;
                    }
                    localObject2 = localaz.Sb();
                    localaz.je((String)localObject2 + com.tencent.mm.ac.c.rp(paramarn.LSx.lP()) + ';' + i + ';' + paramarn.LSy + ";0#");
                    i = j;
                    break label234;
                  }
                }
                paramarn = c.sxE;
                if (l2 == ((FinderObject)localObject2).id)
                {
                  paramarn = localaz.Sb();
                  localaz.je(paramarn + com.tencent.mm.ac.c.rp(((FinderObject)localObject2).id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                }
                else
                {
                  paramarn = localaz.Sb();
                  localaz.je(paramarn + com.tencent.mm.ac.c.rp(((FinderObject)localObject2).id) + ';' + i + ";0;0#");
                  i = j;
                }
              }
            }
          }
        }
        label692:
        paramarn = FinderFoldedScrollLayout.tfJ;
        FinderFoldedScrollLayout.xM(0L);
        paramarn = FinderFoldedScrollLayout.tfJ;
        FinderFoldedScrollLayout.xP(0L);
        paramarn = FinderFoldedScrollLayout.tfJ;
        FinderFoldedScrollLayout.xO(0L);
        paramarn = FinderFoldedScrollLayout.tfJ;
        FinderFoldedScrollLayout.xN(0L);
        localaz.dNp();
        paramarn = i.syT;
        i.a((com.tencent.mm.plugin.report.a)localaz);
        AppMethodBeat.o(203746);
        return;
        label748:
        l1 = 0L;
      }
    }
    
    public static void a(arn paramarn, m paramm, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(203745);
      d.g.b.p.h(paramarn, "contextObj");
      d.g.b.p.h(paramm, "record");
      FinderItem localFinderItem = paramm.feed;
      if (localFinderItem != null)
      {
        bc localbc = new bc();
        localbc.ju(com.tencent.mm.ac.c.rp(localFinderItem.getId()));
        localbc.eF(localFinderItem.getMediaType());
        localbc.jv(paramarn.sessionId);
        localbc.eT(paramarn.sch);
        localbc.eG(paramm.szi);
        localbc.eH(localFinderItem.getLikeCount());
        localbc.eI(localFinderItem.getCommentCount());
        Object localObject1 = o.sXt;
        localbc.jw(n.h(o.p(localFinderItem), ",", ";", false));
        Object localObject2 = localFinderItem.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbc.jx((String)localObject1);
        long l1;
        if (d.g.b.p.i(localFinderItem.getUserName(), com.tencent.mm.model.v.aAK()))
        {
          l1 = 1L;
          localbc.eJ(l1);
          localbc.eK(localFinderItem.getCreateTime());
          localObject1 = localFinderItem.getLocation();
          if ((localObject1 != null) && (((apl)localObject1).dzE > 0.0F) && (((apl)localObject1).dBu > 0.0F)) {
            localbc.Sd();
          }
          localbc.eL(localFinderItem.getMediaList().size());
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localbc.eM(((bvz)localFinderItem.getMediaList().get(0)).videoDuration);
          }
          localbc.eN(paramm.endTime - paramm.startTime);
          if (!com.tencent.mm.sdk.platformtools.j.DEBUG) {
            break label722;
          }
          l1 = l2;
          label331:
          localbc.eO(l1);
          localbc.eP(localFinderItem.getFeedObject().recommendType);
          localbc.jy(localFinderItem.getUserName());
          localbc.eQ(localFinderItem.getFeedObject().orgRecommendType);
          localObject2 = localFinderItem.getFeedObject().warnWording;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jz((String)localObject1);
          localbc.eR(localFinderItem.getFeedObject().warnFlag);
          localbc.eS(paramInt);
          localObject2 = paramarn.rfA;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jA((String)localObject1);
          localbc.jB(com.tencent.mm.ac.c.rp(paramarn.tnd));
          localObject2 = paramarn.tne;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jC((String)localObject1);
          localObject2 = paramarn.rfo;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jD((String)localObject1);
          localbc.eU(paramm.szj);
          paramm = i.syT;
          localbc.eV(i.Ft(paramarn.sch));
          paramm = i.syT;
          localbc.jE(i.I(localFinderItem.getId(), paramarn.sch));
          paramarn = com.tencent.mm.plugin.finder.upload.action.g.sVv;
          paramarn = com.tencent.mm.plugin.finder.upload.action.g.cNz().n(localFinderItem.getFeedObject());
          localbc.eW(paramarn.size());
          if (paramarn.size() <= 3) {
            break label729;
          }
          localbc.eX(3L);
        }
        for (;;)
        {
          localbc.jF("");
          paramarn = ((Iterable)paramarn).iterator();
          paramInt = 0;
          while (paramarn.hasNext())
          {
            paramm = paramarn.next();
            if (paramInt < 0) {
              d.a.j.gkd();
            }
            paramm = (FinderCommentInfo)paramm;
            if (paramInt <= 2) {
              localbc.jF(localbc.Se() + paramm.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          label722:
          l1 = 5L;
          break label331;
          label729:
          localbc.eX(paramarn.size());
        }
        localbc.eY(localFinderItem.getFeedObject().commentList.size());
        paramarn = localFinderItem.getFeedObject().commentList;
        d.g.b.p.g(paramarn, "it.feedObject.commentList");
        paramarn = (FinderCommentInfo)d.a.j.jm((List)paramarn);
        if (paramarn != null)
        {
          paramm = paramarn.username;
          paramarn = paramm;
          if (paramm != null) {}
        }
        else
        {
          paramarn = "";
        }
        localbc.jG(paramarn);
        paramarn = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.r(localFinderItem)) {
          localbc.eZ(localFinderItem.getFeedObject().incFriendLikeCount);
        }
        paramarn = localFinderItem.getFeedObject().commentList;
        d.g.b.p.g(paramarn, "it.feedObject.commentList");
        paramm = (Iterable)paramarn;
        paramarn = (Collection)new ArrayList();
        paramm = paramm.iterator();
        while (paramm.hasNext())
        {
          localObject1 = paramm.next();
          localObject2 = (FinderCommentInfo)localObject1;
          if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isFriend(((FinderCommentInfo)localObject2).username)) {
            paramarn.add(localObject1);
          }
        }
        localbc.fa(((List)paramarn).size());
        localbc.fb(localFinderItem.getFeedObject().commentList.size());
        localbc.dNp();
        paramarn = i.syT;
        i.a((com.tencent.mm.plugin.report.a)localbc);
        AppMethodBeat.o(203745);
        return;
      }
      AppMethodBeat.o(203745);
    }
    
    public static String ae(Map<String, ? extends Object> paramMap)
    {
      AppMethodBeat.i(203744);
      d.g.b.p.h(paramMap, "maps");
      JSONObject localJSONObject = new JSONObject();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        try
        {
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        catch (Exception localException) {}
      }
      paramMap = localJSONObject.toString();
      d.g.b.p.g(paramMap, "json.toString()");
      paramMap = n.h(paramMap, ",", ";", false);
      AppMethodBeat.o(203744);
      return paramMap;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT;", "", "()V", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final String sxF = "1";
    public static final a sxG;
    
    static
    {
      AppMethodBeat.i(203747);
      sxG = new a((byte)0);
      sxF = "1";
      AppMethodBeat.o(203747);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT$Companion;", "", "()V", "CLICK", "", "getCLICK", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<d.z>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c
 * JD-Core Version:    0.7.0.1
 */