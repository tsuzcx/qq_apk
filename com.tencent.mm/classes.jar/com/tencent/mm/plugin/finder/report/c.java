package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import d.a.j;
import d.g.b.q;
import d.n.n;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"})
public abstract class c
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  public static final a snN = new a((byte)0);
  final MMActivity activity;
  public aqy rIl;
  private final long snL;
  public final r snM;
  boolean visible;
  
  public c(MMActivity paramMMActivity, aqy paramaqy)
  {
    this.activity = paramMMActivity;
    this.rIl = paramaqy;
    this.snL = 1277L;
    this.snM = new r(this.rIl);
    this.visible = true;
  }
  
  public void a(b paramb)
  {
    d.g.b.p.h(paramb, "event");
    if (this.rIl.rTD == 0) {
      ad.i(TAG, "[onEventHappen] invalid scene");
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
                  int i;
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
                                          } while (!(paramb instanceof b.a));
                                          switch (((b.a)paramb).type)
                                          {
                                          default: 
                                            return;
                                          case 1: 
                                            com.tencent.mm.plugin.report.e.ygI.idkeyStat(this.snL, 1L, 1L, false);
                                            localObject1 = this.snM;
                                            paramb = (b.a)paramb;
                                            d.g.b.p.h(paramb, "event");
                                            localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                                          }
                                        } while (localObject1 == null);
                                        ((r.b)localObject1).bfZ = true;
                                        ((r.b)localObject1).spu = paramb.rQC;
                                        if (((r.b)localObject1).srk > 0L)
                                        {
                                          ((r.b)localObject1).srj += paramb.rQC - ((r.b)localObject1).srk;
                                          ((r.b)localObject1).srk = 0L;
                                        }
                                        paramb = new StringBuilder();
                                        d.g.b.p.g(localObject1, "this");
                                        ad.i("Finder.FinderVideoPlayReporter", r.a("onResume", (r.b)localObject1) + " onResume:" + ((r.b)localObject1).srj);
                                        return;
                                        com.tencent.mm.plugin.report.e.ygI.idkeyStat(this.snL, 2L, 1L, false);
                                        localObject1 = this.snM;
                                        paramb = (b.a)paramb;
                                        d.g.b.p.h(paramb, "event");
                                        paramb = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                                      } while (paramb == null);
                                      paramb.srg += 1;
                                      return;
                                      localObject1 = this.snM;
                                      paramb = (b.a)paramb;
                                      d.g.b.p.h(paramb, "event");
                                      localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                                    } while (localObject1 == null);
                                    ((r.b)localObject1).srw.add(Integer.valueOf(paramb.offset));
                                    localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
                                    i = com.tencent.mm.plugin.finder.utils.p.fV(paramb.offset, paramb.ieH);
                                  } while (i <= ((r.b)localObject1).sqW);
                                  ((r.b)localObject1).sqW = i;
                                  return;
                                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(this.snL, 0L, 1L, false);
                                  localObject2 = this.snM;
                                  localObject3 = (b.a)paramb;
                                  d.g.b.p.h(localObject3, "event");
                                  localObject4 = new r.b();
                                  localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
                                  paramb = (b)localObject1;
                                  if (localObject1 == null) {
                                    paramb = "";
                                  }
                                  d.g.b.p.h(paramb, "<set-?>");
                                  ((r.b)localObject4).sessionId = paramb;
                                  ((r.b)localObject4).sqO = ((b.a)localObject3).dtq;
                                  paramb = ((b.a)localObject3).rQu;
                                  if (paramb != null)
                                  {
                                    localObject1 = paramb.aeA();
                                    paramb = (b)localObject1;
                                    if (localObject1 != null) {}
                                  }
                                  else
                                  {
                                    paramb = "";
                                  }
                                  d.g.b.p.h(paramb, "<set-?>");
                                  ((r.b)localObject4).sqP = paramb;
                                  ((r.b)localObject4).sqQ = ((b.a)localObject3).rQu;
                                  ((r.b)localObject4).sqR = ((b.a)localObject3).rQt;
                                  paramb = ((b.a)localObject3).rQu;
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
                                  ((r.b)localObject4).mediaPath = paramb;
                                  ((r.b)localObject4).lXf = ((b)localObject3).rQC;
                                  ((r.b)localObject4).sqT = ((b.a)localObject3).position;
                                  ((r.b)localObject4).sqU = 1;
                                  ((r.b)localObject4).srh = true;
                                  ((r.b)localObject4).rQx = ((b.a)localObject3).rQx;
                                  ((r.b)localObject4).sri = CdnLogic.getRecentAverageSpeed(2);
                                  paramb = aj.getContext().getSystemService("audio");
                                  if (paramb == null) {
                                    throw new v("null cannot be cast to non-null type android.media.AudioManager");
                                  }
                                  ((r.b)localObject4).spB = ((AudioManager)paramb).getStreamVolume(3);
                                  paramb = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
                                  paramb = ((b.a)localObject3).rQu;
                                  if (paramb != null)
                                  {
                                    localObject1 = paramb.aeA();
                                    paramb = (b)localObject1;
                                    if (localObject1 != null) {}
                                  }
                                  else
                                  {
                                    paramb = "";
                                  }
                                  paramb = com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramb);
                                  boolean bool;
                                  if (((r.b)localObject4).rQx > 0)
                                  {
                                    i = ((r.b)localObject4).rQx + 1;
                                    ((r.b)localObject4).sqX = i;
                                    if (!paramb.field_hasPlayed) {
                                      break label1081;
                                    }
                                    i = 0;
                                    ((r.b)localObject4).srf = i;
                                    ((r.b)localObject4).sqY = paramb.cCY();
                                    localObject1 = paramb.field_fileFormat;
                                    paramb = (b)localObject1;
                                    if (localObject1 == null) {
                                      paramb = "";
                                    }
                                    ((r.b)localObject4).ahP(paramb);
                                    if (((r.b)localObject4).sqY == 100) {
                                      break label1086;
                                    }
                                    bool = true;
                                    ((r.b)localObject4).srh = bool;
                                    paramb = ay.getNetTypeString(aj.getContext());
                                    d.g.b.p.g(paramb, "NetStatusUtil.getNetType…tionContext.getContext())");
                                    d.g.b.p.h(paramb, "<set-?>");
                                    ((r.b)localObject4).srd = paramb;
                                    paramb = h.soM;
                                    ((r.b)localObject4).sre = h.cDz();
                                    paramb = h.soM;
                                    ((r.b)localObject4).srp = h.wt(((r.b)localObject4).sqO);
                                    if (!com.tencent.mm.modelcontrol.d.pf(4)) {
                                      break label1092;
                                    }
                                    paramb = "h265";
                                    d.g.b.p.h(paramb, "<set-?>");
                                    ((r.b)localObject4).srB = paramb;
                                    ((r.b)localObject4).sqS = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().slp;
                                    paramb = ((b.a)localObject3).rQt;
                                    if (paramb == null) {
                                      break label1099;
                                    }
                                    f = paramb.width;
                                    ((r.b)localObject4).srC = f;
                                    paramb = ((b.a)localObject3).rQt;
                                    if (paramb == null) {
                                      break label1104;
                                    }
                                  }
                                  for (float f = paramb.height;; f = 0.0F)
                                  {
                                    ((r.b)localObject4).srD = f;
                                    ((r.b)localObject4).rQx = ((b.a)localObject3).rQx;
                                    ((Map)((r)localObject2).sqK).put(Long.valueOf(((b.a)localObject3).dtq), localObject4);
                                    ad.i("Finder.FinderVideoPlayReporter", r.a("onStartPlay", (r.b)localObject4) + " firstplay:" + ((r.b)localObject4).srf);
                                    return;
                                    if (paramb.cCY() > 0)
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
                                  localObject1 = this.snM;
                                  paramb = (b.a)paramb;
                                  d.g.b.p.h(paramb, "event");
                                  localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                                } while (localObject1 == null);
                                ((r.b)localObject1).bfZ = false;
                                ((r.b)localObject1).srk = paramb.rQC;
                                if (((r.b)localObject1).spu > 0L)
                                {
                                  ((r.b)localObject1).spt += paramb.rQC - ((r.b)localObject1).spu;
                                  ((r.b)localObject1).spu = 0L;
                                }
                                paramb = new StringBuilder();
                                d.g.b.p.g(localObject1, "this");
                                ad.i("Finder.FinderVideoPlayReporter", r.a("onPause", (r.b)localObject1) + " realPlayTime:" + ((r.b)localObject1).spt);
                                return;
                                com.tencent.mm.plugin.report.e.ygI.idkeyStat(this.snL, 3L, 1L, false);
                                localObject2 = this.snM;
                                localObject4 = (b.a)paramb;
                                d.g.b.p.h(localObject4, "event");
                                localObject3 = (r.b)((r)localObject2).sqK.get(Long.valueOf(((b.a)localObject4).dtq));
                              } while ((localObject3 == null) || (((r.b)localObject3).sqO != ((b.a)localObject4).dtq));
                              localObject1 = ((r.b)localObject3).sqP;
                              paramb = ((b.a)localObject4).rQu;
                              if (paramb != null) {}
                              for (paramb = paramb.aeA(); d.g.b.p.i(localObject1, paramb); paramb = null)
                              {
                                ((r.b)localObject3).spv = (((b)localObject4).rQC - ((r.b)localObject3).lXf);
                                if (((r.b)localObject3).srk > 0L)
                                {
                                  ((r.b)localObject3).srj += ((b)localObject4).rQC - ((r.b)localObject3).srk;
                                  ((r.b)localObject3).srk = 0L;
                                }
                                if (((r.b)localObject3).spu > 0L)
                                {
                                  ((r.b)localObject3).spt += ((b)localObject4).rQC - ((r.b)localObject3).spu;
                                  ((r.b)localObject3).spu = 0L;
                                }
                                if (((r.b)localObject3).srn > 0L)
                                {
                                  ((r.b)localObject3).sro += ((b)localObject4).rQC - ((r.b)localObject3).srn;
                                  ((r.b)localObject3).srn = 0L;
                                  paramb = new asv();
                                  paramb.GqO = ((int)(((b)localObject4).rQC - ((r.b)localObject3).srn));
                                  paramb.percent = ((r.b)localObject3).sqW;
                                  paramb.type = 0;
                                  ((r.b)localObject3).srv.add(paramb);
                                }
                                paramb = aj.getContext().getSystemService("audio");
                                if (paramb != null) {
                                  break label1566;
                                }
                                throw new v("null cannot be cast to non-null type android.media.AudioManager");
                              }
                              ((r.b)localObject3).spC = ((AudioManager)paramb).getStreamVolume(3);
                              if ((((r.b)localObject3).srl == 0L) && (((r.b)localObject3).srh) && (((r.b)localObject3).sqW < 5)) {
                                ((r.b)localObject3).irQ = 1;
                              }
                              paramb = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
                              paramb = ((b.a)localObject4).rQu;
                              if (paramb != null)
                              {
                                localObject1 = paramb.aeA();
                                paramb = (b)localObject1;
                                if (localObject1 != null) {}
                              }
                              else
                              {
                                paramb = "";
                              }
                              localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramb).field_fileFormat;
                              paramb = (b)localObject1;
                              if (localObject1 == null) {
                                paramb = "";
                              }
                              ((r.b)localObject3).ahP(paramb);
                              paramb = ((b.a)localObject4).rQu;
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
                              paramb = com.tencent.mm.plugin.sight.base.e.axx(paramb);
                              if (paramb != null)
                              {
                                ((r.b)localObject3).srz = paramb.videoBitrate;
                                ((r.b)localObject3).srA = paramb.audioBitrate;
                                ((r.b)localObject3).frameRate = paramb.frameRate;
                              }
                              if (!((r.b)localObject3).srt) {
                                ((r)localObject2).a((r.b)localObject3);
                              }
                              for (;;)
                              {
                                ((r)localObject2).sqK.remove(Long.valueOf(((b.a)localObject4).dtq));
                                paramb = new StringBuilder();
                                d.g.b.p.g(localObject3, "this");
                                ad.i("Finder.FinderVideoPlayReporter", r.a("onStopPlay", (r.b)localObject3) + " playTime:" + ((r.b)localObject3).spv + " pauseTotalTime:" + ((r.b)localObject3).srj + " realPlayTime:" + ((r.b)localObject3).spt + " playStatus:" + ((r.b)localObject3).irQ);
                                return;
                                ((r)localObject2).sqJ.add(localObject3);
                              }
                              localObject1 = this.snM;
                              paramb = (b.a)paramb;
                              d.g.b.p.h(paramb, "event");
                              localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                            } while (localObject1 == null);
                            ((r.b)localObject1).srh = true;
                            ((r.b)localObject1).srn = paramb.rQC;
                            ((r.b)localObject1).srm += 1;
                            if (((r.b)localObject1).srl > 0L) {
                              ((r.b)localObject1).sru += 1L;
                            }
                            d.g.b.p.g(localObject1, "this");
                            ad.i("Finder.FinderVideoPlayReporter", String.valueOf(r.a("onWaiting", (r.b)localObject1)));
                            return;
                            localObject1 = this.snM;
                            localObject2 = (b.a)paramb;
                            d.g.b.p.h(localObject2, "event");
                            paramb = (r.b)((r)localObject1).sqK.get(Long.valueOf(((b.a)localObject2).dtq));
                          } while (paramb == null);
                          paramb.srh = false;
                        } while (paramb.srn <= 0L);
                        long l = ((b)localObject2).rQC - paramb.srn;
                        paramb.sro += l;
                        localObject1 = new asv();
                        ((asv)localObject1).GqO = ((int)l);
                        ((asv)localObject1).percent = paramb.sqW;
                        if ((paramb.srm == 1) && (paramb.sru == 0L)) {}
                        for (((asv)localObject1).type = 2;; ((asv)localObject1).type = 0)
                        {
                          paramb.srv.add(localObject1);
                          paramb.srn = 0L;
                          localObject1 = new StringBuilder();
                          d.g.b.p.g(paramb, "this");
                          ad.i("Finder.FinderVideoPlayReporter", r.a("onWaitingEnd", paramb) + " totalWaitingTime:" + paramb.sro);
                          return;
                        }
                        localObject1 = this.snM;
                        paramb = (b.a)paramb;
                        d.g.b.p.h(paramb, "event");
                        localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                      } while (localObject1 == null);
                      if (((r.b)localObject1).sra == 0L) {
                        ((r.b)localObject1).sra = (paramb.rQC - ((r.b)localObject1).lXf - ((r.b)localObject1).srj);
                      }
                      ((r.b)localObject1).srb = (paramb.offset + paramb.ieH);
                      ((r.b)localObject1).srh = false;
                      paramb = new StringBuilder();
                      d.g.b.p.g(localObject1, "this");
                      ad.i("Finder.FinderVideoPlayReporter", r.a("onMoovReady", (r.b)localObject1) + " moovReadyTime:" + ((r.b)localObject1).sra);
                      return;
                      localObject1 = this.snM;
                      paramb = (b.a)paramb;
                      d.g.b.p.h(paramb, "event");
                      localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                    } while (localObject1 == null);
                    Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
                    i = com.tencent.mm.plugin.finder.utils.p.fV(paramb.offset, paramb.ieH);
                  } while (i <= ((r.b)localObject1).lsH);
                  ((r.b)localObject1).lsH = i;
                  return;
                  localObject1 = this.snM;
                  paramb = (b.a)paramb;
                  d.g.b.p.h(paramb, "event");
                  localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
                } while ((localObject1 == null) || (((r.b)localObject1).srq != 0L));
                ((r.b)localObject1).srq = (paramb.offset + paramb.ieH);
                return;
                localObject1 = this.snM;
                paramb = (b.a)paramb;
                d.g.b.p.h(paramb, "event");
                localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
              } while (localObject1 == null);
              ((r.b)localObject1).sqZ = (paramb.rQC - ((r.b)localObject1).lXf);
              paramb = paramb.gwW;
              if ((paramb != null) && (((r.b)localObject1).srs == null)) {
                ((r.b)localObject1).srs = r.b(paramb);
              }
              d.g.b.p.g(localObject1, "this");
              ad.i("Finder.FinderVideoPlayReporter", String.valueOf(r.a("onDownloadFinish", (r.b)localObject1)));
              return;
              this.snM.a((b.a)paramb);
              return;
              localObject1 = this.snM;
              paramb = (b.a)paramb;
              d.g.b.p.h(paramb, "event");
              paramb = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
            } while (paramb == null);
            paramb.srt = true;
            d.g.b.p.g(paramb, "this");
            ad.i("Finder.FinderVideoPlayReporter", String.valueOf(r.a("onDownloadStart", paramb)));
            return;
            localObject1 = this.snM;
            paramb = (b.a)paramb;
            d.g.b.p.h(paramb, "event");
            paramb = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
          } while (paramb == null);
          paramb.spy = 1;
          return;
          localObject1 = this.snM;
          paramb = (b.a)paramb;
          d.g.b.p.h(paramb, "event");
          localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
        } while (localObject1 == null);
        if (((r.b)localObject1).srl == 0L)
        {
          ((r.b)localObject1).srl = (paramb.rQC - ((r.b)localObject1).lXf);
          if (((r.b)localObject1).srl > ((r.b)localObject1).srj) {
            ((r.b)localObject1).srl -= ((r.b)localObject1).srj;
          }
        }
        if (((r.b)localObject1).sqV == 0L) {
          ((r.b)localObject1).sqV = paramb.rQy;
        }
        paramb = new StringBuilder();
        d.g.b.p.g(localObject1, "this");
        ad.i("Finder.FinderVideoPlayReporter", r.a("onFirstFrameUpdate", (r.b)localObject1) + " firstFrameTime:" + ((r.b)localObject1).srl + " firstLoadTime:" + ((r.b)localObject1).sqV);
        return;
        localObject1 = this.snM;
        paramb = (b.a)paramb;
        d.g.b.p.h(paramb, "event");
        paramb = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
      } while (paramb == null);
      paramb.spx = 1;
      return;
      localObject1 = this.snM;
      paramb = (b.a)paramb;
      d.g.b.p.h(paramb, "event");
      localObject1 = (r.b)((r)localObject1).sqK.get(Long.valueOf(paramb.dtq));
    } while (localObject1 == null);
    label914:
    label962:
    label1092:
    ((r.b)localObject1).srE = paramb.ret;
    label1081:
    label1086:
    paramb = new StringBuilder();
    label1566:
    d.g.b.p.g(localObject1, "this");
    ad.i("Finder.FinderVideoPlayReporter", r.a("onPlayError", (r.b)localObject1) + " playerErrCode:" + ((r.b)localObject1).srE);
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    d.g.b.p.h(paramc, "dispatcher");
    d.g.b.p.h(paramb, "event");
    return (paramb instanceof b.a);
  }
  
  public final void c(aqy paramaqy)
  {
    d.g.b.p.h(paramaqy, "contextObj");
    this.rIl = paramaqy;
    this.snM.c(paramaqy);
  }
  
  public LinkedList<dij> cDp()
  {
    return new LinkedList();
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    FinderReporterUIC.a locala = FinderReporterUIC.tcM;
    com.tencent.mm.ad.c.c(FinderReporterUIC.cOy(), (d.g.a.a)new c(this));
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "maps", "", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "plugin-finder_release"})
  public static final class a
  {
    public static String Y(Map<String, ? extends Object> paramMap)
    {
      AppMethodBeat.i(203203);
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
      AppMethodBeat.o(203203);
      return paramMap;
    }
    
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(203202);
      d.g.b.p.h(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(203202);
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
    
    public static void a(aqy paramaqy, long paramLong1, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(203200);
      d.g.b.p.h(paramaqy, "contextObj");
      d.g.b.p.h(paramString, "actionValue");
      ar localar = new ar();
      localar.hY(com.tencent.mm.ad.c.rc(paramLong1));
      localar.dC(paramaqy.rTD);
      localar.io(paramInt);
      localar.hZ(n.h(paramString, ",", ";", false));
      if (i.DEBUG)
      {
        paramInt = 0;
        localar.ip(paramInt);
        localar.dA(paramLong2);
        localar.ia(paramaqy.sessionId);
        paramString = h.soM;
        paramString = h.ws(paramLong1);
        if (paramString != null)
        {
          localar.iq(paramString.getMediaType());
          paramString = (bvf)j.jd((List)paramString.getMediaList());
          if (paramString == null) {
            break label311;
          }
        }
      }
      label311:
      for (paramLong2 = paramString.videoDuration;; paramLong2 = 0L)
      {
        localar.dB(paramLong2);
        paramString = h.soM;
        paramString = h.I(paramLong1, paramaqy.rTD);
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
        localar.ib(paramString);
        localar.ic(com.tencent.mm.ad.c.rc(paramaqy.tcj));
        String str = paramaqy.tck;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localar.ie(paramString);
        localar.jdMethod_if(paramaqy.qXj);
        localar.ig(paramaqy.qXu);
        localar.dJX();
        paramaqy = h.soM;
        h.a((com.tencent.mm.plugin.report.a)localar);
        AppMethodBeat.o(203200);
        return;
        paramInt = 43;
        break;
      }
    }
    
    public static void a(aqy paramaqy, l paraml)
    {
      AppMethodBeat.i(203205);
      d.g.b.p.h(paramaqy, "contextObj");
      d.g.b.p.h(paraml, "record");
      az localaz = new az();
      localaz.iP(paramaqy.sessionId);
      localaz.iQ(paramaqy.qXu);
      localaz.iR(paramaqy.qXj);
      localaz.en(paramaqy.rTD);
      localaz.iS(com.tencent.mm.ad.c.rc(paraml.dtq));
      paramaqy = paraml.feed;
      long l1;
      Object localObject1;
      label150:
      long l2;
      if (paramaqy != null)
      {
        paramaqy = paramaqy.getFoldedLayout();
        if (paramaqy != null)
        {
          l1 = paramaqy.fTM;
          localaz.eo(l1);
          paramaqy = paraml.feed;
          if (paramaqy != null)
          {
            paramaqy = paramaqy.getFoldedLayout();
            if (paramaqy != null)
            {
              localObject1 = paramaqy.username;
              paramaqy = (aqy)localObject1;
              if (localObject1 != null) {
                break label150;
              }
            }
          }
          paramaqy = "";
          localaz.iT(paramaqy);
          localaz.iU("");
          l2 = 0L;
          paramaqy = FinderFoldedScrollLayout.sUv;
          if (FinderFoldedScrollLayout.cNp() == 0L) {
            break label411;
          }
          paramaqy = FinderFoldedScrollLayout.sUv;
          localaz.eq(FinderFoldedScrollLayout.cNp());
          l1 = 0L;
        }
      }
      for (;;)
      {
        label196:
        paramaqy = paraml.feed;
        if (paramaqy != null)
        {
          paramaqy = paramaqy.getFoldedLayout();
          if (paramaqy != null)
          {
            paramaqy = paramaqy.Gmm;
            if (paramaqy != null)
            {
              localObject1 = ((Iterable)paramaqy).iterator();
              int i = 0;
              for (;;)
              {
                label236:
                if (!((Iterator)localObject1).hasNext()) {
                  break label694;
                }
                paramaqy = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  j.gfB();
                }
                Object localObject2 = (FinderObject)paramaqy;
                paramaqy = paraml.rRb;
                if (paramaqy != null)
                {
                  paramaqy = paramaqy.LvD;
                  if (paramaqy != null) {
                    paramaqy = (com.tencent.mm.view.recyclerview.h)paramaqy.get(((FinderObject)localObject2).id);
                  }
                }
                for (;;)
                {
                  if (paramaqy != null)
                  {
                    if (l2 == paramaqy.LvK.lP())
                    {
                      localObject2 = localaz.Sd();
                      localaz.iU((String)localObject2 + com.tencent.mm.ad.c.rc(paramaqy.LvK.lP()) + ';' + i + ';' + paramaqy.LvL + ';' + l1 + '#');
                      i = j;
                      break label236;
                      l1 = 0L;
                      break;
                      label411:
                      paramaqy = FinderFoldedScrollLayout.sUv;
                      if (FinderFoldedScrollLayout.cNq() != 0L)
                      {
                        paramaqy = FinderFoldedScrollLayout.sUv;
                        localaz.ep(FinderFoldedScrollLayout.cNq());
                        l1 = 0L;
                        break label196;
                      }
                      paramaqy = FinderFoldedScrollLayout.sUv;
                      if (FinderFoldedScrollLayout.cNs() == 0L) {
                        break label751;
                      }
                      paramaqy = FinderFoldedScrollLayout.sUv;
                      l2 = FinderFoldedScrollLayout.cNr();
                      paramaqy = FinderFoldedScrollLayout.sUv;
                      l1 = FinderFoldedScrollLayout.cNs();
                      break label196;
                      paramaqy = null;
                      continue;
                    }
                    localObject2 = localaz.Sd();
                    localaz.iU((String)localObject2 + com.tencent.mm.ad.c.rc(paramaqy.LvK.lP()) + ';' + i + ';' + paramaqy.LvL + ";0#");
                    i = j;
                    break label236;
                  }
                }
                paramaqy = c.snN;
                if (l2 == ((FinderObject)localObject2).id)
                {
                  paramaqy = localaz.Sd();
                  localaz.iU(paramaqy + com.tencent.mm.ad.c.rc(((FinderObject)localObject2).id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                }
                else
                {
                  paramaqy = localaz.Sd();
                  localaz.iU(paramaqy + com.tencent.mm.ad.c.rc(((FinderObject)localObject2).id) + ';' + i + ";0;0#");
                  i = j;
                }
              }
            }
          }
        }
        label694:
        paramaqy = FinderFoldedScrollLayout.sUv;
        FinderFoldedScrollLayout.xs(0L);
        paramaqy = FinderFoldedScrollLayout.sUv;
        FinderFoldedScrollLayout.xv(0L);
        paramaqy = FinderFoldedScrollLayout.sUv;
        FinderFoldedScrollLayout.xu(0L);
        paramaqy = FinderFoldedScrollLayout.sUv;
        FinderFoldedScrollLayout.xt(0L);
        localaz.dJX();
        paramaqy = h.soM;
        h.a((com.tencent.mm.plugin.report.a)localaz);
        AppMethodBeat.o(203205);
        return;
        label751:
        l1 = 0L;
      }
    }
    
    public static void a(aqy paramaqy, l paraml, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(203204);
      d.g.b.p.h(paramaqy, "contextObj");
      d.g.b.p.h(paraml, "record");
      FinderItem localFinderItem = paraml.feed;
      if (localFinderItem != null)
      {
        bc localbc = new bc();
        localbc.ji(com.tencent.mm.ad.c.rc(localFinderItem.getId()));
        localbc.eE(localFinderItem.getMediaType());
        localbc.jj(paramaqy.sessionId);
        localbc.eS(paramaqy.rTD);
        localbc.eF(paraml.soX);
        localbc.eG(localFinderItem.getLikeCount());
        localbc.eH(localFinderItem.getCommentCount());
        Object localObject1 = o.sMi;
        localbc.jk(n.h(o.p(localFinderItem), ",", ";", false));
        Object localObject2 = localFinderItem.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbc.jl((String)localObject1);
        long l1;
        if (d.g.b.p.i(localFinderItem.getUserName(), u.aAu()))
        {
          l1 = 1L;
          localbc.eI(l1);
          localbc.eJ(localFinderItem.getCreateTime());
          localObject1 = localFinderItem.getLocation();
          if ((localObject1 != null) && (((aoy)localObject1).dyz > 0.0F) && (((aoy)localObject1).dAp > 0.0F)) {
            localbc.Sf();
          }
          localbc.eK(localFinderItem.getMediaList().size());
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localbc.eL(((bvf)localFinderItem.getMediaList().get(0)).videoDuration);
          }
          localbc.eM(paraml.endTime - paraml.startTime);
          if (!i.DEBUG) {
            break label723;
          }
          l1 = l2;
          label332:
          localbc.eN(l1);
          localbc.eO(localFinderItem.getFeedObject().recommendType);
          localbc.jm(localFinderItem.getUserName());
          localbc.eP(localFinderItem.getFeedObject().orgRecommendType);
          localObject2 = localFinderItem.getFeedObject().warnWording;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jn((String)localObject1);
          localbc.eQ(localFinderItem.getFeedObject().warnFlag);
          localbc.eR(paramInt);
          localObject2 = paramaqy.qXu;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jo((String)localObject1);
          localbc.jp(com.tencent.mm.ad.c.rc(paramaqy.tcj));
          localObject2 = paramaqy.tck;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jq((String)localObject1);
          localObject2 = paramaqy.qXj;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localbc.jr((String)localObject1);
          localbc.eT(paraml.soY);
          paraml = h.soM;
          localbc.eU(h.EX(paramaqy.rTD));
          paraml = h.soM;
          localbc.js(h.I(localFinderItem.getId(), paramaqy.rTD));
          paramaqy = com.tencent.mm.plugin.finder.upload.action.g.sKi;
          paramaqy = com.tencent.mm.plugin.finder.upload.action.g.cKV().n(localFinderItem.getFeedObject());
          localbc.eV(paramaqy.size());
          if (paramaqy.size() <= 3) {
            break label730;
          }
          localbc.eW(3L);
        }
        for (;;)
        {
          localbc.jt("");
          paramaqy = ((Iterable)paramaqy).iterator();
          paramInt = 0;
          while (paramaqy.hasNext())
          {
            paraml = paramaqy.next();
            if (paramInt < 0) {
              j.gfB();
            }
            paraml = (FinderCommentInfo)paraml;
            if (paramInt <= 2) {
              localbc.jt(localbc.Sg() + paraml.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          label723:
          l1 = 5L;
          break label332;
          label730:
          localbc.eW(paramaqy.size());
        }
        localbc.eX(localFinderItem.getFeedObject().commentList.size());
        paramaqy = localFinderItem.getFeedObject().commentList;
        d.g.b.p.g(paramaqy, "it.feedObject.commentList");
        paramaqy = (FinderCommentInfo)j.jd((List)paramaqy);
        if (paramaqy != null)
        {
          paraml = paramaqy.username;
          paramaqy = paraml;
          if (paraml != null) {}
        }
        else
        {
          paramaqy = "";
        }
        localbc.ju(paramaqy);
        paramaqy = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.r(localFinderItem)) {
          localbc.eY(localFinderItem.getFeedObject().incFriendLikeCount);
        }
        paramaqy = localFinderItem.getFeedObject().commentList;
        d.g.b.p.g(paramaqy, "it.feedObject.commentList");
        paraml = (Iterable)paramaqy;
        paramaqy = (Collection)new ArrayList();
        paraml = paraml.iterator();
        while (paraml.hasNext())
        {
          localObject1 = paraml.next();
          localObject2 = (FinderCommentInfo)localObject1;
          if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isFriend(((FinderCommentInfo)localObject2).username)) {
            paramaqy.add(localObject1);
          }
        }
        localbc.yL(((List)paramaqy).size());
        localbc.FR(localFinderItem.getFeedObject().commentList.size());
        localbc.dJX();
        paramaqy = h.soM;
        h.a((com.tencent.mm.plugin.report.a)localbc);
        AppMethodBeat.o(203204);
        return;
      }
      AppMethodBeat.o(203204);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT;", "", "()V", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final String snO = "1";
    public static final a snP;
    
    static
    {
      AppMethodBeat.i(203206);
      snP = new a((byte)0);
      snO = "1";
      AppMethodBeat.o(203206);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT$Companion;", "", "()V", "CLICK", "", "getCLICK", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
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