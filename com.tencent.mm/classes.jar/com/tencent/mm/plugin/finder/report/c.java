package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.b.k;
import d.n.n;
import d.v;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"})
public abstract class c
  extends com.tencent.mm.plugin.finder.event.base.f
{
  public static final a KUz = new a((byte)0);
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  private final long KUx;
  final g KUy;
  final MMActivity activity;
  dzp contextObj;
  boolean visible;
  
  public c(MMActivity paramMMActivity, dzp paramdzp)
  {
    this.activity = paramMMActivity;
    this.contextObj = paramdzp;
    this.KUx = 1277L;
    this.KUy = new g(this.contextObj);
    this.visible = true;
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    k.h(paramc, "event");
    if (this.contextObj.qqE == 0) {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "[onEventHappen] invalid scene");
    }
    label574:
    label881:
    label886:
    label1143:
    label1148:
    do
    {
      Object localObject1;
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
                    int j;
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
                                                          do
                                                          {
                                                            do
                                                            {
                                                              return;
                                                            } while (!(paramc instanceof b.a));
                                                            switch (((b.a)paramc).type)
                                                            {
                                                            default: 
                                                              return;
                                                            case 1: 
                                                              e.vIY.idkeyStat(this.KUx, 1L, 1L, false);
                                                              localObject2 = ((b.a)paramc).qsb;
                                                            }
                                                          } while (localObject2 == null);
                                                          localObject1 = this.KUy;
                                                          l1 = ((b.a)paramc).feedId;
                                                          l2 = paramc.KLZ;
                                                          paramc = ((b.a)paramc).qCU;
                                                          k.h(localObject2, "media");
                                                          localObject2 = new StringBuilder("onResume ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                                                          if (paramc != null) {}
                                                          for (paramc = paramc.aaX();; paramc = null)
                                                          {
                                                            com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                                                            paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
                                                            if (paramc == null) {
                                                              break;
                                                            }
                                                            paramc.aUR = true;
                                                            paramc.KVj = l2;
                                                            if (paramc.qGQ <= 0L) {
                                                              break;
                                                            }
                                                            paramc.qGP += l2 - paramc.qGQ;
                                                            paramc.qGQ = 0L;
                                                            return;
                                                          }
                                                          e.vIY.idkeyStat(this.KUx, 2L, 1L, false);
                                                          localObject1 = ((b.a)paramc).qsb;
                                                        } while (localObject1 == null);
                                                        localObject2 = this.KUy;
                                                        l1 = ((b.a)paramc).feedId;
                                                        k.h(localObject1, "media");
                                                        paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
                                                      } while (paramc == null);
                                                      paramc.qGM += 1;
                                                      return;
                                                      localObject1 = ((b.a)paramc).qsb;
                                                    } while (localObject1 == null);
                                                    localObject2 = this.KUy;
                                                    l1 = ((b.a)paramc).feedId;
                                                    i = ((b.a)paramc).offset;
                                                    j = ((b.a)paramc).hlk;
                                                    k.h(localObject1, "media");
                                                    paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
                                                  } while (paramc == null);
                                                  paramc.KVC.add(Integer.valueOf(i));
                                                  localObject1 = i.qTa;
                                                  i = i.lb(i, j);
                                                } while (i <= paramc.qGE);
                                                paramc.qGE = i;
                                                return;
                                                e.vIY.idkeyStat(this.KUx, 0L, 1L, false);
                                                localObject4 = ((b.a)paramc).qsb;
                                              } while (localObject4 == null);
                                              localObject1 = ((b.a)paramc).mediaList;
                                              com.tencent.mm.plugin.finder.loader.l locall;
                                              if (localObject1 != null)
                                              {
                                                i = 0;
                                                j = ((Collection)localObject1).size();
                                                if (i < j) {
                                                  if (k.g(((bmd)((LinkedList)localObject1).get(i)).mediaId, ((bmd)localObject4).mediaId))
                                                  {
                                                    localObject2 = this.KUy;
                                                    l1 = ((b.a)paramc).feedId;
                                                    l2 = paramc.KLZ;
                                                    j = ((b.a)paramc).position;
                                                    locall = ((b.a)paramc).qCU;
                                                    k.h(localObject4, "media");
                                                    localObject1 = new StringBuilder("onStartPlay ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                                                    if (locall == null) {
                                                      break label881;
                                                    }
                                                  }
                                                }
                                              }
                                              for (paramc = locall.aaX();; paramc = null)
                                              {
                                                com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc + ' ' + j + " size:" + ((g)localObject2).KVw.size());
                                                localObject3 = new g.b();
                                                localObject1 = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
                                                paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                                                if (localObject1 == null) {
                                                  paramc = "";
                                                }
                                                k.h(paramc, "<set-?>");
                                                ((g.b)localObject3).sessionId = paramc;
                                                ((g.b)localObject3).qGv = l1;
                                                if (locall != null)
                                                {
                                                  localObject1 = locall.aaX();
                                                  paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                                                  if (localObject1 != null) {}
                                                }
                                                else
                                                {
                                                  paramc = "";
                                                }
                                                k.h(paramc, "<set-?>");
                                                ((g.b)localObject3).qGw = paramc;
                                                ((g.b)localObject3).KVy = locall;
                                                ((g.b)localObject3).qGx = ((bmd)localObject4);
                                                ((g.b)localObject3).qGz = l2;
                                                ((g.b)localObject3).qGA = j;
                                                ((g.b)localObject3).qGB = (i + 1);
                                                ((g.b)localObject3).qGN = true;
                                                ((g.b)localObject3).qGO = CdnLogic.getRecentAverageSpeed(2);
                                                paramc = aj.getContext().getSystemService("audio");
                                                if (paramc != null) {
                                                  break label886;
                                                }
                                                throw new v("null cannot be cast to non-null type android.media.AudioManager");
                                                i += 1;
                                                break;
                                                i = 0;
                                                break label574;
                                                i = 0;
                                                break label574;
                                              }
                                              ((g.b)localObject3).KVp = ((AudioManager)paramc).getStreamVolume(3);
                                              paramc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
                                              if (locall != null)
                                              {
                                                localObject1 = locall.aaX();
                                                paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                                                if (localObject1 != null) {}
                                              }
                                              else
                                              {
                                                paramc = "";
                                              }
                                              paramc = com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramc);
                                              if (paramc.cno() > 0)
                                              {
                                                i = 1;
                                                ((g.b)localObject3).qGF = i;
                                                if (!paramc.field_hasPlayed) {
                                                  break label1143;
                                                }
                                                i = 0;
                                                ((g.b)localObject3).qEr = i;
                                                ((g.b)localObject3).qGG = paramc.cno();
                                                localObject1 = paramc.field_fileFormat;
                                                paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                                                if (localObject1 == null) {
                                                  paramc = "";
                                                }
                                                ((g.b)localObject3).aVv(paramc);
                                                if (((g.b)localObject3).qGG == 100) {
                                                  break label1148;
                                                }
                                                bool = true;
                                                ((g.b)localObject3).qGN = bool;
                                                paramc = ay.getNetTypeString(aj.getContext());
                                                k.g(paramc, "NetStatusUtil.getNetType…tionContext.getContext())");
                                                k.h(paramc, "<set-?>");
                                                ((g.b)localObject3).qGK = paramc;
                                                paramc = b.qFq;
                                                ((g.b)localObject3).qGL = b.fTW();
                                                paramc = b.qFq;
                                                ((g.b)localObject3).qGW = b.BN(((g.b)localObject3).qGv);
                                                if (!com.tencent.mm.modelcontrol.d.nQ(4)) {
                                                  break label1154;
                                                }
                                              }
                                              for (paramc = "h265";; paramc = "h264")
                                              {
                                                k.h(paramc, "<set-?>");
                                                ((g.b)localObject3).KVH = paramc;
                                                ((Map)((g)localObject2).KVw).put(Long.valueOf(l1), localObject3);
                                                ((g.b)localObject3).KVz = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().Dmj;
                                                return;
                                                i = 0;
                                                break;
                                                i = 1;
                                                break label956;
                                                bool = false;
                                                break label1008;
                                              }
                                              localObject2 = ((b.a)paramc).qsb;
                                            } while (localObject2 == null);
                                            localObject1 = this.KUy;
                                            l1 = ((b.a)paramc).feedId;
                                            l2 = paramc.KLZ;
                                            paramc = ((b.a)paramc).qCU;
                                            k.h(localObject2, "media");
                                            localObject2 = new StringBuilder("onPause ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                                            if (paramc != null) {}
                                            for (paramc = paramc.aaX();; paramc = null)
                                            {
                                              com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                                              paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
                                              if (paramc == null) {
                                                break;
                                              }
                                              paramc.aUR = false;
                                              paramc.qGQ = l2;
                                              if (paramc.KVj <= 0L) {
                                                break;
                                              }
                                              paramc.qGR += l2 - paramc.KVj;
                                              paramc.KVj = 0L;
                                              return;
                                            }
                                            e.vIY.idkeyStat(this.KUx, 3L, 1L, false);
                                            localObject1 = ((b.a)paramc).qsb;
                                          } while (localObject1 == null);
                                          localObject2 = this.KUy;
                                          l1 = ((b.a)paramc).feedId;
                                          l2 = paramc.KLZ;
                                          localObject3 = ((b.a)paramc).qCU;
                                          k.h(localObject1, "media");
                                          localObject1 = new StringBuilder("onStopPlay ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                                          if (localObject3 == null) {
                                            break;
                                          }
                                          paramc = ((com.tencent.mm.plugin.finder.loader.l)localObject3).aaX();
                                          com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                                          localObject4 = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
                                        } while ((localObject4 == null) || (((g.b)localObject4).qGv != l1));
                                        localObject1 = ((g.b)localObject4).qGw;
                                        if (localObject3 != null) {}
                                        for (paramc = ((com.tencent.mm.plugin.finder.loader.l)localObject3).aaX(); k.g(localObject1, paramc); paramc = null)
                                        {
                                          ((g.b)localObject4).qGD = (l2 - ((g.b)localObject4).qGz);
                                          if (((g.b)localObject4).qGQ > 0L)
                                          {
                                            ((g.b)localObject4).qGP += l2 - ((g.b)localObject4).qGQ;
                                            ((g.b)localObject4).qGQ = 0L;
                                          }
                                          if (((g.b)localObject4).KVj > 0L)
                                          {
                                            long l3 = ((g.b)localObject4).qGR;
                                            ((g.b)localObject4).qGR = (l2 - ((g.b)localObject4).KVj + l3);
                                            ((g.b)localObject4).KVj = 0L;
                                          }
                                          paramc = aj.getContext().getSystemService("audio");
                                          if (paramc != null) {
                                            break label1626;
                                          }
                                          throw new v("null cannot be cast to non-null type android.media.AudioManager");
                                          paramc = null;
                                          break label1429;
                                        }
                                        ((g.b)localObject4).KVq = ((AudioManager)paramc).getStreamVolume(3);
                                        if ((((g.b)localObject4).qGS == 0L) && (((g.b)localObject4).qGN) && (((g.b)localObject4).qGE < 5)) {
                                          ((g.b)localObject4).hxT = 1;
                                        }
                                        paramc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
                                        if (localObject3 != null)
                                        {
                                          paramc = ((com.tencent.mm.plugin.finder.loader.l)localObject3).aaX();
                                          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramc).field_fileFormat;
                                          paramc = (com.tencent.mm.plugin.finder.event.base.c)localObject1;
                                          if (localObject1 == null) {
                                            paramc = "";
                                          }
                                          ((g.b)localObject4).aVv(paramc);
                                          paramc = i.qTa;
                                          paramc = i.ZP(((com.tencent.mm.plugin.finder.loader.l)localObject3).getPath());
                                          if (paramc != null)
                                          {
                                            ((g.b)localObject4).KVF = paramc.videoBitrate;
                                            ((g.b)localObject4).KVG = paramc.audioBitrate;
                                          }
                                          if (((g.b)localObject4).qHa) {
                                            break label1784;
                                          }
                                          ((g)localObject2).a((g.b)localObject4);
                                        }
                                        for (;;)
                                        {
                                          ((g)localObject2).KVw.remove(Long.valueOf(l1));
                                          return;
                                          paramc = null;
                                          break;
                                          ((g)localObject2).qGr.add(localObject4);
                                        }
                                        localObject2 = ((b.a)paramc).qsb;
                                      } while (localObject2 == null);
                                      localObject1 = this.KUy;
                                      l1 = ((b.a)paramc).feedId;
                                      l2 = paramc.KLZ;
                                      paramc = ((b.a)paramc).qCU;
                                      k.h(localObject2, "media");
                                      localObject2 = new StringBuilder("onWaiting ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                                      if (paramc != null) {}
                                      for (paramc = paramc.aaX();; paramc = null)
                                      {
                                        com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                                        paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
                                        if (paramc == null) {
                                          break;
                                        }
                                        paramc.qGN = true;
                                        paramc.qGU = l2;
                                        paramc.qGT += 1;
                                        if (paramc.qGS <= 0L) {
                                          break;
                                        }
                                        paramc.qHb += 1L;
                                        return;
                                      }
                                      localObject2 = ((b.a)paramc).qsb;
                                    } while (localObject2 == null);
                                    localObject1 = this.KUy;
                                    l1 = ((b.a)paramc).feedId;
                                    l2 = paramc.KLZ;
                                    paramc = ((b.a)paramc).qCU;
                                    k.h(localObject2, "media");
                                    localObject2 = new StringBuilder("onWaitingEnd ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                                    if (paramc == null) {
                                      break;
                                    }
                                    paramc = paramc.aaX();
                                    com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                                    paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
                                  } while (paramc == null);
                                  paramc.qGN = false;
                                } while (paramc.qGU <= 0L);
                                l1 = l2 - paramc.qGU;
                                paramc.qGV += l1;
                                localObject1 = new alx();
                                ((alx)localObject1).DmW = ((int)l1);
                                ((alx)localObject1).percent = paramc.qGE;
                                if ((paramc.qGT == 1) && (paramc.qHb == 0L)) {}
                                for (((alx)localObject1).type = 2;; ((alx)localObject1).type = 0)
                                {
                                  paramc.qHc.add(localObject1);
                                  paramc.qGU = 0L;
                                  return;
                                  paramc = null;
                                  break;
                                }
                                localObject2 = ((b.a)paramc).qsb;
                              } while (localObject2 == null);
                              localObject1 = this.KUy;
                              l1 = ((b.a)paramc).feedId;
                              l2 = paramc.KLZ;
                              i = ((b.a)paramc).offset;
                              j = ((b.a)paramc).hlk;
                              paramc = ((b.a)paramc).qCU;
                              k.h(localObject2, "media");
                              localObject2 = new StringBuilder("onMoovReady ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                              if (paramc != null) {}
                              for (paramc = paramc.aaX();; paramc = null)
                              {
                                com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                                paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
                                if (paramc == null) {
                                  break;
                                }
                                paramc.qGI = (l2 - paramc.qGz - paramc.qGP);
                                paramc.qGJ = (i + j);
                                paramc.qGN = false;
                                return;
                              }
                              localObject1 = ((b.a)paramc).qsb;
                            } while (localObject1 == null);
                            localObject2 = this.KUy;
                            l1 = ((b.a)paramc).feedId;
                            i = ((b.a)paramc).offset;
                            j = ((b.a)paramc).hlk;
                            k.h(localObject1, "media");
                            paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
                          } while (paramc == null);
                          localObject1 = i.qTa;
                          i = i.lb(i, j);
                        } while (i <= paramc.kut);
                        paramc.kut = i;
                        return;
                        localObject1 = ((b.a)paramc).qsb;
                      } while (localObject1 == null);
                      localObject2 = this.KUy;
                      l1 = ((b.a)paramc).feedId;
                      i = ((b.a)paramc).offset;
                      j = ((b.a)paramc).hlk;
                      k.h(localObject1, "media");
                      paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
                    } while ((paramc == null) || (paramc.qGX != 0L));
                    paramc.qGX = (i + j);
                    return;
                    localObject3 = ((b.a)paramc).qsb;
                  } while (localObject3 == null);
                  localObject2 = this.KUy;
                  l1 = ((b.a)paramc).feedId;
                  l2 = paramc.KLZ;
                  localObject1 = ((b.a)paramc).fYG;
                  paramc = ((b.a)paramc).qCU;
                  k.h(localObject3, "media");
                  Object localObject3 = new StringBuilder("onDownloadFinish ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
                  if (paramc != null)
                  {
                    paramc = paramc.aaX();
                    paramc = ((StringBuilder)localObject3).append(paramc).append(' ');
                    if (localObject1 == null) {
                      break label2740;
                    }
                  }
                  for (boolean bool = true;; bool = false)
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", bool);
                    paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
                    if (paramc == null) {
                      break;
                    }
                    paramc.qGH = (l2 - paramc.qGz);
                    if ((localObject1 == null) || (paramc.KVB != null)) {
                      break;
                    }
                    paramc.KVB = g.c((com.tencent.mm.i.d)localObject1);
                    return;
                    paramc = null;
                    break label2647;
                  }
                  localObject1 = ((b.a)paramc).qsb;
                } while (localObject1 == null);
                this.KUy.a(((b.a)paramc).feedId, (bmd)localObject1, ((b.a)paramc).hyo, ((b.a)paramc).fYG, ((b.a)paramc).qCU);
                return;
                localObject2 = ((b.a)paramc).qsb;
              } while (localObject2 == null);
              localObject1 = this.KUy;
              l1 = ((b.a)paramc).feedId;
              paramc = ((b.a)paramc).qCU;
              k.h(localObject2, "media");
              localObject2 = new StringBuilder("onDownloadStart ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
              if (paramc != null) {}
              for (paramc = paramc.aaX();; paramc = null)
              {
                com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
                paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
                if (paramc == null) {
                  break;
                }
                paramc.qHa = true;
                return;
              }
              localObject1 = ((b.a)paramc).qsb;
            } while (localObject1 == null);
            localObject2 = this.KUy;
            l1 = ((b.a)paramc).feedId;
            k.h(localObject1, "media");
            paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
          } while (paramc == null);
          paramc.KVm = 1;
          return;
          localObject2 = ((b.a)paramc).qsb;
        } while (localObject2 == null);
        localObject1 = this.KUy;
        l1 = ((b.a)paramc).feedId;
        long l2 = paramc.KLZ;
        paramc = ((b.a)paramc).qCU;
        k.h(localObject2, "media");
        localObject2 = new StringBuilder("onFirstFrameUpdate ").append(com.tencent.mm.ad.c.ly(l1)).append(' ');
        if (paramc != null) {}
        for (paramc = paramc.aaX();; paramc = null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderVideoPlayReporter", paramc);
          paramc = (g.b)((g)localObject1).KVw.get(Long.valueOf(l1));
          if ((paramc == null) || (paramc.qGS != 0L)) {
            break;
          }
          paramc.qGS = (l2 - paramc.qGz);
          if (paramc.qGS <= paramc.qGQ) {
            break;
          }
          paramc.qGC = (paramc.qGS - paramc.qGQ);
          return;
        }
        localObject1 = ((b.a)paramc).qsb;
      } while (localObject1 == null);
      Object localObject2 = this.KUy;
      long l1 = ((b.a)paramc).feedId;
      k.h(localObject1, "it");
      paramc = (g.b)((g)localObject2).KVw.get(Long.valueOf(l1));
    } while (paramc == null);
    label956:
    label1008:
    label1784:
    paramc.KVl = 1;
    label1154:
    label1429:
    label1626:
    return;
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    k.h(paramd, "dispatcher");
    k.h(paramc, "event");
    return (paramc instanceof b.a);
  }
  
  public final void b(dzp paramdzp)
  {
    k.h(paramdzp, "contextObj");
    this.contextObj = paramdzp;
    this.KUy.b(paramdzp);
  }
  
  public LinkedList<cxk> fTS()
  {
    return new LinkedList();
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    super.onRelease();
    g localg = this.KUy;
    Object localObject1 = localg.KVw;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        g.b localb = (g.b)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localb != null)
        {
          Object localObject2 = aj.getContext().getSystemService("audio");
          if (localObject2 == null) {
            throw new v("null cannot be cast to non-null type android.media.AudioManager");
          }
          localb.KVq = ((AudioManager)localObject2).getStreamVolume(3);
          long l = ce.asS();
          if (localb.qGD == 0L)
          {
            localb.qGD = (l - localb.qGz);
            if (localb.qGQ > 0L)
            {
              localb.qGP += l - localb.qGQ;
              localb.qGQ = 0L;
            }
            if (localb.KVj > 0L)
            {
              localb.qGR += l - localb.KVj;
              localb.KVj = 0L;
            }
          }
          if (localb.qGU > 0L)
          {
            localb.qGV += l - localb.qGU;
            localb.qGU = 0L;
            localObject2 = new alx();
            ((alx)localObject2).DmW = ((int)(l - localb.qGU));
            ((alx)localObject2).percent = localb.qGE;
            ((alx)localObject2).type = 1;
            localb.qHc.add(localObject2);
          }
          if ((localb.qGS == 0L) && (localb.qGN) && (localb.qGE < 5)) {
            localb.hxT = 1;
          }
          localg.a(localb);
          localg.b(localb);
        }
      }
    }
    localg.KVw = new HashMap();
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "plugin-finder_release"})
  public static final class a
  {
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(198770);
      k.h(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(198770);
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
    
    public static void a(dzp paramdzp, long paramLong1, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(198768);
      k.h(paramdzp, "contextObj");
      k.h(paramString, "actionValue");
      hk localhk = new hk();
      localhk.YP(com.tencent.mm.ad.c.ly(paramLong1));
      localhk.yi(paramdzp.qqE);
      localhk.ch(paramInt);
      localhk.YR(n.h(paramString, ",", ";", false));
      if (com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        paramInt = 0;
        localhk.kg(paramInt);
        localhk.yg(paramLong2);
        localhk.YS(paramdzp.sessionId);
        paramString = b.qFq;
        paramString = b.qh(paramLong1);
        if (paramString != null)
        {
          localhk.kI(paramString.getMediaType());
          paramString = (bmd)j.iz((List)paramString.getMediaList());
          if (paramString == null) {
            break label311;
          }
        }
      }
      label311:
      for (paramLong2 = paramString.videoDuration;; paramLong2 = 0L)
      {
        localhk.yh(paramLong2);
        paramString = b.qFq;
        paramString = b.am(paramLong1, paramdzp.qqE);
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
        localhk.Za(paramString);
        localhk.Zd(com.tencent.mm.ad.c.ly(paramdzp.LiJ));
        String str = paramdzp.LiK;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localhk.Ze(paramString);
        localhk.Zf(paramdzp.KHW);
        localhk.Zg(paramdzp.qwV);
        localhk.fYy();
        paramdzp = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localhk);
        AppMethodBeat.o(198768);
        return;
        paramInt = 43;
        break;
      }
    }
    
    public static void a(dzp paramdzp, m paramm)
    {
      AppMethodBeat.i(198772);
      k.h(paramdzp, "contextObj");
      k.h(paramm, "record");
      ho localho = new ho();
      localho.aRG(paramdzp.sessionId);
      localho.aRH(paramdzp.qwV);
      localho.aRI(paramdzp.KHW);
      localho.yy(paramdzp.qqE);
      localho.aRJ(com.tencent.mm.ad.c.ly(paramm.feedId));
      paramdzp = paramm.feed;
      long l1;
      Object localObject1;
      label148:
      long l2;
      if (paramdzp != null)
      {
        paramdzp = paramdzp.getFoldedLayout();
        if (paramdzp != null)
        {
          l1 = paramdzp.fwP;
          localho.yz(l1);
          paramdzp = paramm.feed;
          if (paramdzp != null)
          {
            paramdzp = paramdzp.getFoldedLayout();
            if (paramdzp != null)
            {
              localObject1 = paramdzp.username;
              paramdzp = (dzp)localObject1;
              if (localObject1 != null) {
                break label148;
              }
            }
          }
          paramdzp = "";
          localho.aRK(paramdzp);
          localho.aRL("");
          l2 = 0L;
          paramdzp = FinderFoldedScrollLayout.LeX;
          if (FinderFoldedScrollLayout.fWJ() == 0L) {
            break label409;
          }
          paramdzp = FinderFoldedScrollLayout.LeX;
          localho.yB(FinderFoldedScrollLayout.fWJ());
          l1 = 0L;
        }
      }
      for (;;)
      {
        label194:
        paramdzp = paramm.feed;
        if (paramdzp != null)
        {
          paramdzp = paramdzp.getFoldedLayout();
          if (paramdzp != null)
          {
            paramdzp = paramdzp.Dlg;
            if (paramdzp != null)
            {
              localObject1 = ((Iterable)paramdzp).iterator();
              int i = 0;
              for (;;)
              {
                label234:
                if (!((Iterator)localObject1).hasNext()) {
                  break label692;
                }
                paramdzp = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  j.fvx();
                }
                Object localObject2 = (FinderObject)paramdzp;
                paramdzp = paramm.KMj;
                if (paramdzp != null)
                {
                  paramdzp = paramdzp.LDN;
                  if (paramdzp != null) {
                    paramdzp = (com.tencent.mm.view.recyclerview.h)paramdzp.get(((FinderObject)localObject2).id);
                  }
                }
                for (;;)
                {
                  if (paramdzp != null)
                  {
                    if (l2 == paramdzp.LDU.bMs())
                    {
                      localObject2 = localho.akp();
                      localho.aRL((String)localObject2 + com.tencent.mm.ad.c.ly(paramdzp.LDU.bMs()) + ';' + i + ';' + paramdzp.LDV + ';' + l1 + '#');
                      i = j;
                      break label234;
                      l1 = 0L;
                      break;
                      label409:
                      paramdzp = FinderFoldedScrollLayout.LeX;
                      if (FinderFoldedScrollLayout.fWK() != 0L)
                      {
                        paramdzp = FinderFoldedScrollLayout.LeX;
                        localho.yA(FinderFoldedScrollLayout.fWK());
                        l1 = 0L;
                        break label194;
                      }
                      paramdzp = FinderFoldedScrollLayout.LeX;
                      if (FinderFoldedScrollLayout.fWN() == 0L) {
                        break label746;
                      }
                      paramdzp = FinderFoldedScrollLayout.LeX;
                      l2 = FinderFoldedScrollLayout.fWL();
                      paramdzp = FinderFoldedScrollLayout.LeX;
                      l1 = FinderFoldedScrollLayout.fWN();
                      break label194;
                      paramdzp = null;
                      continue;
                    }
                    localObject2 = localho.akp();
                    localho.aRL((String)localObject2 + com.tencent.mm.ad.c.ly(paramdzp.LDU.bMs()) + ';' + i + ';' + paramdzp.LDV + ";0#");
                    i = j;
                    break label234;
                  }
                }
                paramdzp = c.KUz;
                if (l2 == ((FinderObject)localObject2).id)
                {
                  paramdzp = localho.akp();
                  localho.aRL(paramdzp + com.tencent.mm.ad.c.ly(((FinderObject)localObject2).id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                }
                else
                {
                  paramdzp = localho.akp();
                  localho.aRL(paramdzp + com.tencent.mm.ad.c.ly(((FinderObject)localObject2).id) + ';' + i + ";0;0#");
                  i = j;
                }
              }
            }
          }
        }
        label692:
        paramdzp = FinderFoldedScrollLayout.LeX;
        FinderFoldedScrollLayout.Cc(0L);
        paramdzp = FinderFoldedScrollLayout.LeX;
        FinderFoldedScrollLayout.fWO();
        paramdzp = FinderFoldedScrollLayout.LeX;
        FinderFoldedScrollLayout.fWM();
        paramdzp = FinderFoldedScrollLayout.LeX;
        FinderFoldedScrollLayout.Cd(0L);
        localho.fYy();
        paramdzp = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localho);
        AppMethodBeat.o(198772);
        return;
        label746:
        l1 = 0L;
      }
    }
    
    public static void a(dzp paramdzp, m paramm, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(198771);
      k.h(paramdzp, "contextObj");
      k.h(paramm, "record");
      FinderItem localFinderItem = paramm.feed;
      if (localFinderItem != null)
      {
        com.tencent.mm.g.b.a.ad localad = new com.tencent.mm.g.b.a.ad();
        localad.gL(com.tencent.mm.ad.c.ly(localFinderItem.getId()));
        localad.cQ(localFinderItem.getMediaType());
        localad.gM(paramdzp.sessionId);
        localad.yG(paramdzp.qqE);
        localad.cS(paramm.yLW);
        localad.cT(localFinderItem.getLikeCount());
        localad.cU(localFinderItem.getCommentCount());
        Object localObject = com.tencent.mm.plugin.finder.utils.h.qSR;
        localad.gN(n.h(com.tencent.mm.plugin.finder.utils.h.l(localFinderItem), ",", ";", false));
        String str = localFinderItem.getFeedObject().recommendReason;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localad.gO((String)localObject);
        long l1;
        if (k.g(localFinderItem.getUserName(), u.aqO()))
        {
          l1 = 1L;
          localad.cV(l1);
          localad.cW(localFinderItem.getCreateTime());
          localObject = localFinderItem.getLocation();
          if ((localObject != null) && (((ajq)localObject).dpb > 0.0F) && (((ajq)localObject).dqQ > 0.0F)) {
            localad.Qc();
          }
          localad.cX(localFinderItem.getMediaList().size());
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localad.cY(((bmd)localFinderItem.getMediaList().get(0)).videoDuration);
          }
          localad.cZ(paramm.endTime - paramm.startTime);
          if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
            break label722;
          }
          l1 = l2;
          label331:
          localad.da(l1);
          localad.db(localFinderItem.getFeedObject().recommendType);
          localad.gP(localFinderItem.getUserName());
          localad.dc(localFinderItem.getFeedObject().orgRecommendType);
          str = localFinderItem.getFeedObject().warnWording;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localad.aRS((String)localObject);
          localad.yF(localFinderItem.getFeedObject().warnFlag);
          localad.dd(paramInt);
          str = paramdzp.qwV;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localad.gQ((String)localObject);
          localad.aRT(com.tencent.mm.ad.c.ly(paramdzp.LiJ));
          str = paramdzp.LiK;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localad.aRU((String)localObject);
          str = paramdzp.KHW;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localad.aRV((String)localObject);
          localad.yH(paramm.KUQ);
          paramm = b.qFq;
          localad.yI(b.aho(paramdzp.qqE));
          paramm = b.qFq;
          localad.aRW(b.am(localFinderItem.getId(), paramdzp.qqE));
          paramdzp = com.tencent.mm.plugin.finder.upload.action.d.qRR;
          paramdzp = com.tencent.mm.plugin.finder.upload.action.d.crL().o(localFinderItem.getFeedObject());
          localad.yJ(paramdzp.size());
          if (paramdzp.size() <= 3) {
            break label729;
          }
          localad.yK(3L);
        }
        for (;;)
        {
          localad.aRX("");
          paramdzp = ((Iterable)paramdzp).iterator();
          paramInt = 0;
          while (paramdzp.hasNext())
          {
            paramm = paramdzp.next();
            if (paramInt < 0) {
              j.fvx();
            }
            paramm = (FinderCommentInfo)paramm;
            if (paramInt <= 2) {
              localad.aRX(localad.akw() + paramm.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          label722:
          l1 = 5L;
          break label331;
          label729:
          localad.yK(paramdzp.size());
        }
        localad.yL(localFinderItem.getFeedObject().commentList.size());
        paramdzp = localFinderItem.getFeedObject().commentList;
        k.g(paramdzp, "it.feedObject.commentList");
        paramdzp = (FinderCommentInfo)j.iz((List)paramdzp);
        if (paramdzp != null)
        {
          paramm = paramdzp.username;
          paramdzp = paramm;
          if (paramm != null) {}
        }
        else
        {
          paramdzp = "";
        }
        localad.aRY(paramdzp);
        localad.fYy();
        paramdzp = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localad);
        AppMethodBeat.o(198771);
        return;
      }
      AppMethodBeat.o(198771);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c
 * JD-Core Version:    0.7.0.1
 */