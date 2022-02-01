package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aj;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import d.a.j;
import d.g.b.k;
import d.v;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"})
public abstract class a
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  public static final a rwX = new a((byte)0);
  final MMActivity activity;
  anm contextObj;
  private final long rwV;
  public final m rwW;
  boolean visible;
  
  public a(MMActivity paramMMActivity, anm paramanm)
  {
    this.activity = paramMMActivity;
    this.contextObj = paramanm;
    this.rwV = 1277L;
    this.rwW = new m(this.contextObj);
    this.visible = true;
  }
  
  public void a(b paramb)
  {
    k.h(paramb, "event");
    if (this.contextObj.rfR == 0) {
      ac.i(TAG, "[onEventHappen] invalid scene");
    }
    int i;
    label578:
    label997:
    label2806:
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
                    do
                    {
                      do
                      {
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
                                            m.b localb;
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
                                                                } while (!(paramb instanceof b.a));
                                                                switch (((b.a)paramb).type)
                                                                {
                                                                default: 
                                                                  return;
                                                                case 1: 
                                                                  com.tencent.mm.plugin.report.e.wTc.idkeyStat(this.rwV, 1L, 1L, false);
                                                                  localObject2 = ((b.a)paramb).rcY;
                                                                }
                                                              } while (localObject2 == null);
                                                              localObject1 = this.rwW;
                                                              l1 = ((b.a)paramb).dig;
                                                              l2 = paramb.rdg;
                                                              paramb = ((b.a)paramb).rcZ;
                                                              k.h(localObject2, "media");
                                                              localObject2 = new StringBuilder("onResume ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                                              if (paramb != null) {}
                                                              for (paramb = paramb.abW();; paramb = null)
                                                              {
                                                                ac.i("Finder.FinderVideoPlayReporter", paramb);
                                                                paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
                                                                if (paramb == null) {
                                                                  break;
                                                                }
                                                                paramb.aVE = true;
                                                                paramb.rxZ = l2;
                                                                if (paramb.rzA <= 0L) {
                                                                  break;
                                                                }
                                                                paramb.rzz += l2 - paramb.rzA;
                                                                paramb.rzA = 0L;
                                                                return;
                                                              }
                                                              com.tencent.mm.plugin.report.e.wTc.idkeyStat(this.rwV, 2L, 1L, false);
                                                              localObject1 = ((b.a)paramb).rcY;
                                                            } while (localObject1 == null);
                                                            localObject2 = this.rwW;
                                                            l1 = ((b.a)paramb).dig;
                                                            k.h(localObject1, "media");
                                                            paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
                                                          } while (paramb == null);
                                                          paramb.rzw += 1;
                                                          return;
                                                          localObject1 = ((b.a)paramb).rcY;
                                                        } while (localObject1 == null);
                                                        localObject2 = this.rwW;
                                                        l1 = ((b.a)paramb).dig;
                                                        i = ((b.a)paramb).offset;
                                                        j = ((b.a)paramb).hLN;
                                                        k.h(localObject1, "media");
                                                        paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
                                                      } while (paramb == null);
                                                      paramb.rzM.add(Integer.valueOf(i));
                                                      localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
                                                      i = com.tencent.mm.plugin.finder.utils.n.fH(i, j);
                                                    } while (i <= paramb.rzn);
                                                    paramb.rzn = i;
                                                    return;
                                                    com.tencent.mm.plugin.report.e.wTc.idkeyStat(this.rwV, 0L, 1L, false);
                                                    localObject2 = ((b.a)paramb).rcY;
                                                  } while (localObject2 == null);
                                                  localObject1 = ((b.a)paramb).mediaList;
                                                  com.tencent.mm.plugin.finder.loader.l locall;
                                                  if (localObject1 != null)
                                                  {
                                                    i = 0;
                                                    j = ((Collection)localObject1).size();
                                                    if (i < j) {
                                                      if (k.g(((bqs)((LinkedList)localObject1).get(i)).mediaId, ((bqs)localObject2).mediaId))
                                                      {
                                                        localObject3 = this.rwW;
                                                        l1 = ((b.a)paramb).dig;
                                                        l2 = paramb.rdg;
                                                        j = ((b.a)paramb).position;
                                                        locall = ((b.a)paramb).rcZ;
                                                        k.h(localObject2, "media");
                                                        localObject1 = new StringBuilder("onStartPlay ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                                        if (locall == null) {
                                                          break label922;
                                                        }
                                                      }
                                                    }
                                                  }
                                                  for (paramb = locall.abW();; paramb = null)
                                                  {
                                                    ac.i("Finder.FinderVideoPlayReporter", paramb + ' ' + j + " size:" + ((m)localObject3).rzb.size());
                                                    localb = new m.b();
                                                    localObject1 = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
                                                    paramb = (b)localObject1;
                                                    if (localObject1 == null) {
                                                      paramb = "";
                                                    }
                                                    k.h(paramb, "<set-?>");
                                                    localb.sessionId = paramb;
                                                    localb.rze = l1;
                                                    if (locall != null)
                                                    {
                                                      localObject1 = locall.abW();
                                                      paramb = (b)localObject1;
                                                      if (localObject1 != null) {}
                                                    }
                                                    else
                                                    {
                                                      paramb = "";
                                                    }
                                                    k.h(paramb, "<set-?>");
                                                    localb.rzf = paramb;
                                                    localb.rzg = locall;
                                                    localb.rzh = ((bqs)localObject2);
                                                    if (locall != null)
                                                    {
                                                      localObject1 = locall.getPath();
                                                      paramb = (b)localObject1;
                                                      if (localObject1 != null) {}
                                                    }
                                                    else
                                                    {
                                                      paramb = "";
                                                    }
                                                    k.h(paramb, "<set-?>");
                                                    localb.mediaPath = paramb;
                                                    localb.rzj = l2;
                                                    localb.rzk = j;
                                                    localb.rzl = (i + 1);
                                                    localb.rzx = true;
                                                    localb.rzy = CdnLogic.getRecentAverageSpeed(2);
                                                    paramb = ai.getContext().getSystemService("audio");
                                                    if (paramb != null) {
                                                      break label927;
                                                    }
                                                    throw new v("null cannot be cast to non-null type android.media.AudioManager");
                                                    i += 1;
                                                    break;
                                                    i = 0;
                                                    break label578;
                                                    i = 0;
                                                    break label578;
                                                  }
                                                  localb.ryg = ((AudioManager)paramb).getStreamVolume(3);
                                                  paramb = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
                                                  if (locall != null)
                                                  {
                                                    localObject1 = locall.abW();
                                                    paramb = (b)localObject1;
                                                    if (localObject1 != null) {}
                                                  }
                                                  else
                                                  {
                                                    paramb = "";
                                                  }
                                                  paramb = com.tencent.mm.plugin.finder.storage.logic.c.aei(paramb);
                                                  if (paramb.cwI() > 0)
                                                  {
                                                    i = 1;
                                                    localb.rzo = i;
                                                    if (!paramb.field_hasPlayed) {
                                                      break label1204;
                                                    }
                                                    i = 0;
                                                    localb.rzv = i;
                                                    localb.rzp = paramb.cwI();
                                                    localObject1 = paramb.field_fileFormat;
                                                    paramb = (b)localObject1;
                                                    if (localObject1 == null) {
                                                      paramb = "";
                                                    }
                                                    localb.adP(paramb);
                                                    if (localb.rzp == 100) {
                                                      break label1209;
                                                    }
                                                    bool = true;
                                                    localb.rzx = bool;
                                                    paramb = ax.getNetTypeString(ai.getContext());
                                                    k.g(paramb, "NetStatusUtil.getNetType…tionContext.getContext())");
                                                    k.h(paramb, "<set-?>");
                                                    localb.rzt = paramb;
                                                    paramb = d.rxr;
                                                    localb.rzu = d.cwU();
                                                    paramb = d.rxr;
                                                    localb.rzF = d.us(localb.rze);
                                                    if (!com.tencent.mm.modelcontrol.d.oE(4)) {
                                                      break label1215;
                                                    }
                                                  }
                                                  for (paramb = "h265";; paramb = "h264")
                                                  {
                                                    k.h(paramb, "<set-?>");
                                                    localb.rzR = paramb;
                                                    ((Map)((m)localObject3).rzb).put(Long.valueOf(l1), localb);
                                                    localb.rzi = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().rvL;
                                                    localb.rzS = ((bqs)localObject2).width;
                                                    localb.rzT = ((bqs)localObject2).height;
                                                    return;
                                                    i = 0;
                                                    break;
                                                    i = 1;
                                                    break label997;
                                                    bool = false;
                                                    break label1049;
                                                  }
                                                  localObject2 = ((b.a)paramb).rcY;
                                                } while (localObject2 == null);
                                                localObject1 = this.rwW;
                                                l1 = ((b.a)paramb).dig;
                                                l2 = paramb.rdg;
                                                paramb = ((b.a)paramb).rcZ;
                                                k.h(localObject2, "media");
                                                localObject2 = new StringBuilder("onPause ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                                if (paramb != null) {}
                                                for (paramb = paramb.abW();; paramb = null)
                                                {
                                                  ac.i("Finder.FinderVideoPlayReporter", paramb);
                                                  paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
                                                  if (paramb == null) {
                                                    break;
                                                  }
                                                  paramb.aVE = false;
                                                  paramb.rzA = l2;
                                                  if (paramb.rxZ <= 0L) {
                                                    break;
                                                  }
                                                  paramb.rxY += l2 - paramb.rxZ;
                                                  paramb.rxZ = 0L;
                                                  return;
                                                }
                                                com.tencent.mm.plugin.report.e.wTc.idkeyStat(this.rwV, 3L, 1L, false);
                                                localObject1 = ((b.a)paramb).rcY;
                                              } while (localObject1 == null);
                                              localObject2 = this.rwW;
                                              l1 = ((b.a)paramb).dig;
                                              l2 = paramb.rdg;
                                              localObject3 = ((b.a)paramb).rcZ;
                                              k.h(localObject1, "media");
                                              localObject1 = new StringBuilder("onStopPlay ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                              if (localObject3 == null) {
                                                break;
                                              }
                                              paramb = ((com.tencent.mm.plugin.finder.loader.l)localObject3).abW();
                                              ac.i("Finder.FinderVideoPlayReporter", paramb);
                                              localb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
                                            } while ((localb == null) || (localb.rze != l1));
                                            localObject1 = localb.rzf;
                                            if (localObject3 != null) {}
                                            for (paramb = ((com.tencent.mm.plugin.finder.loader.l)localObject3).abW(); k.g(localObject1, paramb); paramb = null)
                                            {
                                              localb.rya = (l2 - localb.rzj);
                                              if (localb.rzA > 0L)
                                              {
                                                localb.rzz += l2 - localb.rzA;
                                                localb.rzA = 0L;
                                              }
                                              if (localb.rxZ > 0L)
                                              {
                                                long l3 = localb.rxY;
                                                localb.rxY = (l2 - localb.rxZ + l3);
                                                localb.rxZ = 0L;
                                              }
                                              paramb = ai.getContext().getSystemService("audio");
                                              if (paramb != null) {
                                                break label1687;
                                              }
                                              throw new v("null cannot be cast to non-null type android.media.AudioManager");
                                              paramb = null;
                                              break label1490;
                                            }
                                            localb.ryh = ((AudioManager)paramb).getStreamVolume(3);
                                            if ((localb.rzB == 0L) && (localb.rzx) && (localb.rzn < 5)) {
                                              localb.hYu = 1;
                                            }
                                            paramb = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
                                            if (localObject3 != null)
                                            {
                                              paramb = ((com.tencent.mm.plugin.finder.loader.l)localObject3).abW();
                                              localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.aei(paramb).field_fileFormat;
                                              paramb = (b)localObject1;
                                              if (localObject1 == null) {
                                                paramb = "";
                                              }
                                              localb.adP(paramb);
                                              paramb = com.tencent.mm.plugin.sight.base.e.asx(((com.tencent.mm.plugin.finder.loader.l)localObject3).getPath());
                                              if (paramb != null)
                                              {
                                                localb.rzP = paramb.videoBitrate;
                                                localb.rzQ = paramb.audioBitrate;
                                                localb.frameRate = paramb.frameRate;
                                              }
                                              if (localb.rzJ) {
                                                break label1850;
                                              }
                                              ((m)localObject2).a(localb);
                                            }
                                            for (;;)
                                            {
                                              ((m)localObject2).rzb.remove(Long.valueOf(l1));
                                              return;
                                              paramb = null;
                                              break;
                                              ((m)localObject2).rza.add(localb);
                                            }
                                            localObject2 = ((b.a)paramb).rcY;
                                          } while (localObject2 == null);
                                          localObject1 = this.rwW;
                                          l1 = ((b.a)paramb).dig;
                                          l2 = paramb.rdg;
                                          paramb = ((b.a)paramb).rcZ;
                                          k.h(localObject2, "media");
                                          localObject2 = new StringBuilder("onWaiting ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                          if (paramb != null) {}
                                          for (paramb = paramb.abW();; paramb = null)
                                          {
                                            ac.i("Finder.FinderVideoPlayReporter", paramb);
                                            paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
                                            if (paramb == null) {
                                              break;
                                            }
                                            paramb.rzx = true;
                                            paramb.rzD = l2;
                                            paramb.rzC += 1;
                                            if (paramb.rzB <= 0L) {
                                              break;
                                            }
                                            paramb.rzK += 1L;
                                            return;
                                          }
                                          localObject2 = ((b.a)paramb).rcY;
                                        } while (localObject2 == null);
                                        localObject1 = this.rwW;
                                        l1 = ((b.a)paramb).dig;
                                        l2 = paramb.rdg;
                                        paramb = ((b.a)paramb).rcZ;
                                        k.h(localObject2, "media");
                                        localObject2 = new StringBuilder("onWaitingEnd ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                        if (paramb == null) {
                                          break;
                                        }
                                        paramb = paramb.abW();
                                        ac.i("Finder.FinderVideoPlayReporter", paramb);
                                        paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
                                      } while (paramb == null);
                                      paramb.rzx = false;
                                    } while (paramb.rzD <= 0L);
                                    l1 = l2 - paramb.rzD;
                                    paramb.rzE += l1;
                                    localObject1 = new apa();
                                    ((apa)localObject1).EHV = ((int)l1);
                                    ((apa)localObject1).percent = paramb.rzn;
                                    if ((paramb.rzC == 1) && (paramb.rzK == 0L)) {}
                                    for (((apa)localObject1).type = 2;; ((apa)localObject1).type = 0)
                                    {
                                      paramb.rzL.add(localObject1);
                                      paramb.rzD = 0L;
                                      return;
                                      paramb = null;
                                      break;
                                    }
                                    localObject2 = ((b.a)paramb).rcY;
                                  } while (localObject2 == null);
                                  localObject1 = this.rwW;
                                  l1 = ((b.a)paramb).dig;
                                  l2 = paramb.rdg;
                                  i = ((b.a)paramb).offset;
                                  j = ((b.a)paramb).hLN;
                                  paramb = ((b.a)paramb).rcZ;
                                  k.h(localObject2, "media");
                                  localObject2 = new StringBuilder("onMoovReady ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                                  if (paramb != null) {}
                                  for (paramb = paramb.abW();; paramb = null)
                                  {
                                    ac.i("Finder.FinderVideoPlayReporter", paramb);
                                    paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
                                    if (paramb == null) {
                                      break;
                                    }
                                    paramb.rzr = (l2 - paramb.rzj - paramb.rzz);
                                    paramb.rzs = (i + j);
                                    paramb.rzx = false;
                                    return;
                                  }
                                  localObject1 = ((b.a)paramb).rcY;
                                } while (localObject1 == null);
                                localObject2 = this.rwW;
                                l1 = ((b.a)paramb).dig;
                                i = ((b.a)paramb).offset;
                                j = ((b.a)paramb).hLN;
                                k.h(localObject1, "media");
                                paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
                              } while (paramb == null);
                              localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
                              i = com.tencent.mm.plugin.finder.utils.n.fH(i, j);
                            } while (i <= paramb.kVI);
                            paramb.kVI = i;
                            return;
                            localObject1 = ((b.a)paramb).rcY;
                          } while (localObject1 == null);
                          localObject2 = this.rwW;
                          l1 = ((b.a)paramb).dig;
                          i = ((b.a)paramb).offset;
                          j = ((b.a)paramb).hLN;
                          k.h(localObject1, "media");
                          paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
                        } while ((paramb == null) || (paramb.rzG != 0L));
                        paramb.rzG = (i + j);
                        return;
                        localObject3 = ((b.a)paramb).rcY;
                      } while (localObject3 == null);
                      localObject2 = this.rwW;
                      l1 = ((b.a)paramb).dig;
                      l2 = paramb.rdg;
                      localObject1 = ((b.a)paramb).gdm;
                      paramb = ((b.a)paramb).rcZ;
                      k.h(localObject3, "media");
                      Object localObject3 = new StringBuilder("onDownloadFinish ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                      if (paramb != null)
                      {
                        paramb = paramb.abW();
                        paramb = ((StringBuilder)localObject3).append(paramb).append(' ');
                        if (localObject1 == null) {
                          break label2806;
                        }
                      }
                      for (boolean bool = true;; bool = false)
                      {
                        ac.i("Finder.FinderVideoPlayReporter", bool);
                        paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
                        if (paramb == null) {
                          break;
                        }
                        paramb.rzq = (l2 - paramb.rzj);
                        if ((localObject1 == null) || (paramb.rzI != null)) {
                          break;
                        }
                        paramb.rzI = m.b((com.tencent.mm.i.d)localObject1);
                        return;
                        paramb = null;
                        break label2713;
                      }
                      localObject1 = ((b.a)paramb).rcY;
                    } while (localObject1 == null);
                    this.rwW.a(((b.a)paramb).dig, (bqs)localObject1, ((b.a)paramb).hYP, ((b.a)paramb).gdm, ((b.a)paramb).rcZ);
                    return;
                    localObject2 = ((b.a)paramb).rcY;
                  } while (localObject2 == null);
                  localObject1 = this.rwW;
                  l1 = ((b.a)paramb).dig;
                  paramb = ((b.a)paramb).rcZ;
                  k.h(localObject2, "media");
                  localObject2 = new StringBuilder("onDownloadStart ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
                  if (paramb != null) {}
                  for (paramb = paramb.abW();; paramb = null)
                  {
                    ac.i("Finder.FinderVideoPlayReporter", paramb);
                    paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
                    if (paramb == null) {
                      break;
                    }
                    paramb.rzJ = true;
                    return;
                  }
                  localObject1 = ((b.a)paramb).rcY;
                } while (localObject1 == null);
                localObject2 = this.rwW;
                l1 = ((b.a)paramb).dig;
                k.h(localObject1, "media");
                paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
              } while (paramb == null);
              paramb.ryd = 1;
              return;
              localObject2 = ((b.a)paramb).rcY;
            } while (localObject2 == null);
            localObject1 = this.rwW;
            l1 = ((b.a)paramb).dig;
            long l2 = paramb.rdg;
            paramb = ((b.a)paramb).rcZ;
            k.h(localObject2, "media");
            localObject2 = new StringBuilder("onFirstFrameUpdate ").append(com.tencent.mm.ac.c.pb(l1)).append(' ');
            if (paramb != null) {}
            for (paramb = paramb.abW();; paramb = null)
            {
              ac.i("Finder.FinderVideoPlayReporter", paramb);
              paramb = (m.b)((m)localObject1).rzb.get(Long.valueOf(l1));
              if ((paramb == null) || (paramb.rzB != 0L)) {
                break;
              }
              paramb.rzB = (l2 - paramb.rzj);
              if (paramb.rzB <= paramb.rzz) {
                break;
              }
              paramb.rzB -= paramb.rzz;
              return;
            }
            localObject1 = ((b.a)paramb).rcY;
          } while (localObject1 == null);
          localObject2 = this.rwW;
          l1 = ((b.a)paramb).dig;
          k.h(localObject1, "it");
          paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
        } while (paramb == null);
        paramb.ryc = 1;
        return;
        localObject1 = ((b.a)paramb).rcY;
      } while (localObject1 == null);
      Object localObject2 = this.rwW;
      long l1 = ((b.a)paramb).dig;
      i = ((b.a)paramb).ret;
      k.h(localObject1, "media");
      ac.i("Finder.FinderVideoPlayReporter", "onPlayError " + com.tencent.mm.ac.c.pb(l1) + ' ' + ((bqs)localObject1).mediaId + ' ' + i);
      paramb = (m.b)((m)localObject2).rzb.get(Long.valueOf(l1));
    } while (paramb == null);
    label922:
    label927:
    label1204:
    label1209:
    label1215:
    label1490:
    paramb.uGI = i;
    label1049:
    label1850:
    return;
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, b paramb)
  {
    k.h(paramc, "dispatcher");
    k.h(paramb, "event");
    return (paramb instanceof b.a);
  }
  
  public final void b(anm paramanm)
  {
    k.h(paramanm, "contextObj");
    this.contextObj = paramanm;
    this.rwW.b(paramanm);
  }
  
  public LinkedList<dcw> cwN()
  {
    return new LinkedList();
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    FinderReporterUIC.a locala = FinderReporterUIC.seQ;
    com.tencent.mm.ac.c.c(FinderReporterUIC.cGf(), (d.g.a.a)new c(this));
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "plugin-finder_release"})
  public static final class a
  {
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(202706);
      k.h(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(202706);
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
    
    public static void a(anm paramanm, long paramLong1, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(202704);
      k.h(paramanm, "contextObj");
      k.h(paramString, "actionValue");
      aj localaj = new aj();
      localaj.gO(com.tencent.mm.ac.c.pb(paramLong1));
      localaj.dg(paramanm.rfR);
      localaj.id(paramInt);
      localaj.gP(d.n.n.h(paramString, ",", ";", false));
      if (com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        paramInt = 0;
        localaj.ie(paramInt);
        localaj.de(paramLong2);
        localaj.gQ(paramanm.sessionId);
        paramString = d.rxr;
        paramString = d.ur(paramLong1);
        if (paramString != null)
        {
          localaj.jdMethod_if(paramString.getMediaType());
          paramString = (bqs)j.iP((List)paramString.getMediaList());
          if (paramString == null) {
            break label311;
          }
        }
      }
      label311:
      for (paramLong2 = paramString.videoDuration;; paramLong2 = 0L)
      {
        localaj.df(paramLong2);
        paramString = d.rxr;
        paramString = d.G(paramLong1, paramanm.rfR);
        if (paramString != null)
        {
          str = d.n.n.h(paramString, ",", ";", false);
          paramString = str;
          if (str != null) {}
        }
        else
        {
          paramString = "";
        }
        localaj.gR(paramString);
        localaj.gS(com.tencent.mm.ac.c.pb(paramanm.sem));
        String str = paramanm.sen;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localaj.gT(paramString);
        localaj.gU(paramanm.qom);
        localaj.gV(paramanm.qox);
        localaj.dyF();
        paramanm = d.rxr;
        d.a((com.tencent.mm.plugin.report.a)localaj);
        AppMethodBeat.o(202704);
        return;
        paramInt = 43;
        break;
      }
    }
    
    public static void a(anm paramanm, h paramh)
    {
      AppMethodBeat.i(202708);
      k.h(paramanm, "contextObj");
      k.h(paramh, "record");
      ao localao = new ao();
      localao.hs(paramanm.sessionId);
      localao.ht(paramanm.qox);
      localao.hu(paramanm.qom);
      localao.dw(paramanm.rfR);
      localao.hv(com.tencent.mm.ac.c.pb(paramh.dig));
      paramanm = paramh.feed;
      long l1;
      Object localObject1;
      label148:
      long l2;
      if (paramanm != null)
      {
        paramanm = paramanm.getFoldedLayout();
        if (paramanm != null)
        {
          l1 = paramanm.fAw;
          localao.dx(l1);
          paramanm = paramh.feed;
          if (paramanm != null)
          {
            paramanm = paramanm.getFoldedLayout();
            if (paramanm != null)
            {
              localObject1 = paramanm.username;
              paramanm = (anm)localObject1;
              if (localObject1 != null) {
                break label148;
              }
            }
          }
          paramanm = "";
          localao.hw(paramanm);
          localao.hx("");
          l2 = 0L;
          paramanm = FinderFoldedScrollLayout.rXB;
          if (FinderFoldedScrollLayout.cES() == 0L) {
            break label409;
          }
          paramanm = FinderFoldedScrollLayout.rXB;
          localao.dz(FinderFoldedScrollLayout.cES());
          l1 = 0L;
        }
      }
      for (;;)
      {
        label194:
        paramanm = paramh.feed;
        if (paramanm != null)
        {
          paramanm = paramanm.getFoldedLayout();
          if (paramanm != null)
          {
            paramanm = paramanm.EEw;
            if (paramanm != null)
            {
              localObject1 = ((Iterable)paramanm).iterator();
              int i = 0;
              for (;;)
              {
                label234:
                if (!((Iterator)localObject1).hasNext()) {
                  break label692;
                }
                paramanm = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  j.fOc();
                }
                Object localObject2 = (FinderObject)paramanm;
                paramanm = paramh.rdF;
                if (paramanm != null)
                {
                  paramanm = paramanm.JCx;
                  if (paramanm != null) {
                    paramanm = (com.tencent.mm.view.recyclerview.h)paramanm.get(((FinderObject)localObject2).id);
                  }
                }
                for (;;)
                {
                  if (paramanm != null)
                  {
                    if (l2 == paramanm.JCE.lx())
                    {
                      localObject2 = localao.Qg();
                      localao.hx((String)localObject2 + com.tencent.mm.ac.c.pb(paramanm.JCE.lx()) + ';' + i + ';' + paramanm.JCF + ';' + l1 + '#');
                      i = j;
                      break label234;
                      l1 = 0L;
                      break;
                      label409:
                      paramanm = FinderFoldedScrollLayout.rXB;
                      if (FinderFoldedScrollLayout.cET() != 0L)
                      {
                        paramanm = FinderFoldedScrollLayout.rXB;
                        localao.dy(FinderFoldedScrollLayout.cET());
                        l1 = 0L;
                        break label194;
                      }
                      paramanm = FinderFoldedScrollLayout.rXB;
                      if (FinderFoldedScrollLayout.cEW() == 0L) {
                        break label746;
                      }
                      paramanm = FinderFoldedScrollLayout.rXB;
                      l2 = FinderFoldedScrollLayout.cEU();
                      paramanm = FinderFoldedScrollLayout.rXB;
                      l1 = FinderFoldedScrollLayout.cEW();
                      break label194;
                      paramanm = null;
                      continue;
                    }
                    localObject2 = localao.Qg();
                    localao.hx((String)localObject2 + com.tencent.mm.ac.c.pb(paramanm.JCE.lx()) + ';' + i + ';' + paramanm.JCF + ";0#");
                    i = j;
                    break label234;
                  }
                }
                paramanm = a.rwX;
                if (l2 == ((FinderObject)localObject2).id)
                {
                  paramanm = localao.Qg();
                  localao.hx(paramanm + com.tencent.mm.ac.c.pb(((FinderObject)localObject2).id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                }
                else
                {
                  paramanm = localao.Qg();
                  localao.hx(paramanm + com.tencent.mm.ac.c.pb(((FinderObject)localObject2).id) + ';' + i + ";0;0#");
                  i = j;
                }
              }
            }
          }
        }
        label692:
        paramanm = FinderFoldedScrollLayout.rXB;
        FinderFoldedScrollLayout.vo(0L);
        paramanm = FinderFoldedScrollLayout.rXB;
        FinderFoldedScrollLayout.cEX();
        paramanm = FinderFoldedScrollLayout.rXB;
        FinderFoldedScrollLayout.cEV();
        paramanm = FinderFoldedScrollLayout.rXB;
        FinderFoldedScrollLayout.vp(0L);
        localao.dyF();
        paramanm = d.rxr;
        d.a((com.tencent.mm.plugin.report.a)localao);
        AppMethodBeat.o(202708);
        return;
        label746:
        l1 = 0L;
      }
    }
    
    public static void a(anm paramanm, h paramh, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(202707);
      k.h(paramanm, "contextObj");
      k.h(paramh, "record");
      FinderItem localFinderItem = paramh.feed;
      if (localFinderItem != null)
      {
        ar localar = new ar();
        localar.hL(com.tencent.mm.ac.c.pb(localFinderItem.getId()));
        localar.dK(localFinderItem.getMediaType());
        localar.hM(paramanm.sessionId);
        localar.dY(paramanm.rfR);
        localar.dL(paramh.rxC);
        localar.dM(localFinderItem.getLikeCount());
        localar.dN(localFinderItem.getCommentCount());
        Object localObject = com.tencent.mm.plugin.finder.utils.m.rPH;
        localar.hN(d.n.n.h(com.tencent.mm.plugin.finder.utils.m.n(localFinderItem), ",", ";", false));
        String str = localFinderItem.getFeedObject().recommendReason;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localar.hO((String)localObject);
        long l1;
        if (k.g(localFinderItem.getUserName(), u.axE()))
        {
          l1 = 1L;
          localar.dO(l1);
          localar.dP(localFinderItem.getCreateTime());
          localObject = localFinderItem.getLocation();
          if ((localObject != null) && (((alt)localObject).dmL > 0.0F) && (((alt)localObject).doB > 0.0F)) {
            localar.Qh();
          }
          localar.dQ(localFinderItem.getMediaList().size());
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localar.dR(((bqs)localFinderItem.getMediaList().get(0)).videoDuration);
          }
          localar.dS(paramh.endTime - paramh.startTime);
          if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
            break label722;
          }
          l1 = l2;
          label331:
          localar.dT(l1);
          localar.dU(localFinderItem.getFeedObject().recommendType);
          localar.hP(localFinderItem.getUserName());
          localar.dV(localFinderItem.getFeedObject().orgRecommendType);
          str = localFinderItem.getFeedObject().warnWording;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localar.hQ((String)localObject);
          localar.dW(localFinderItem.getFeedObject().warnFlag);
          localar.dX(paramInt);
          str = paramanm.qox;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localar.hR((String)localObject);
          localar.hS(com.tencent.mm.ac.c.pb(paramanm.sem));
          str = paramanm.sen;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localar.hT((String)localObject);
          str = paramanm.qom;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localar.hU((String)localObject);
          localar.dZ(paramh.rxD);
          paramh = d.rxr;
          localar.ea(d.DT(paramanm.rfR));
          paramh = d.rxr;
          localar.hV(d.G(localFinderItem.getId(), paramanm.rfR));
          paramanm = com.tencent.mm.plugin.finder.upload.action.g.rOb;
          paramanm = com.tencent.mm.plugin.finder.upload.action.g.cCH().m(localFinderItem.getFeedObject());
          localar.eb(paramanm.size());
          if (paramanm.size() <= 3) {
            break label729;
          }
          localar.ec(3L);
        }
        for (;;)
        {
          localar.hW("");
          paramanm = ((Iterable)paramanm).iterator();
          paramInt = 0;
          while (paramanm.hasNext())
          {
            paramh = paramanm.next();
            if (paramInt < 0) {
              j.fOc();
            }
            paramh = (FinderCommentInfo)paramh;
            if (paramInt <= 2) {
              localar.hW(localar.Qi() + paramh.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          label722:
          l1 = 5L;
          break label331;
          label729:
          localar.ec(paramanm.size());
        }
        localar.ed(localFinderItem.getFeedObject().commentList.size());
        paramanm = localFinderItem.getFeedObject().commentList;
        k.g(paramanm, "it.feedObject.commentList");
        paramanm = (FinderCommentInfo)j.iP((List)paramanm);
        if (paramanm != null)
        {
          paramh = paramanm.username;
          paramanm = paramh;
          if (paramh != null) {}
        }
        else
        {
          paramanm = "";
        }
        localar.hX(paramanm);
        localar.dyF();
        paramanm = d.rxr;
        d.a((com.tencent.mm.plugin.report.a)localar);
        AppMethodBeat.o(202707);
        return;
      }
      AppMethodBeat.o(202707);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT;", "", "()V", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final String rwY = "1";
    public static final a rwZ;
    
    static
    {
      AppMethodBeat.i(202709);
      rwZ = new a((byte)0);
      rwY = "1";
      AppMethodBeat.o(202709);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT$Companion;", "", "()V", "CLICK", "", "getCLICK", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.a
 * JD-Core Version:    0.7.0.1
 */