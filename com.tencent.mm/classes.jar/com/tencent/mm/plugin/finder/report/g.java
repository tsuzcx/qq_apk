package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.cn;
import com.tencent.mm.f.b.a.cv;
import com.tencent.mm.f.b.a.da;
import com.tencent.mm.f.b.a.db;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.video.reporter.d.b;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "extStatusRecord", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "getExtStatusRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "ExtStatsRecord", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"})
public abstract class g
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  public static final a zUU = new a((byte)0);
  private boolean visible;
  public bid xbu;
  private i zUQ;
  private final b zUR;
  private final long zUS;
  final com.tencent.mm.plugin.finder.video.reporter.d zUT;
  private final MMFragmentActivity zwS;
  
  public g(MMFragmentActivity paramMMFragmentActivity, bid parambid)
  {
    this.zwS = paramMMFragmentActivity;
    this.xbu = parambid;
    this.zUS = 1277L;
    this.zUT = new com.tencent.mm.plugin.finder.video.reporter.d(this.xbu);
    this.zUR = new b();
    this.zUQ = ((i)new i()
    {
      public final void a(ca paramAnonymousca, i.c paramAnonymousc, boolean[] paramAnonymousArrayOfBoolean) {}
      
      public final void a(ca paramAnonymousca, az paramAnonymousaz, boolean paramAnonymousBoolean, i.c paramAnonymousc) {}
      
      public final void b(ca paramAnonymousca, az paramAnonymousaz, boolean paramAnonymousBoolean, i.c paramAnonymousc)
      {
        AppMethodBeat.i(285790);
        this.zUV.dPk();
        AppMethodBeat.o(285790);
      }
    });
    paramMMFragmentActivity = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(paramMMFragmentActivity, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)paramMMFragmentActivity).bbR().a(this.zUQ);
    this.visible = true;
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    p.k(paramb, "event");
    if (this.xbu.xkX == 0) {
      Log.i(TAG, "[onEventHappen] invalid scene");
    }
    Object localObject1;
    label370:
    label1273:
    do
    {
      do
      {
        do
        {
          Object localObject2;
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
                                                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(this.zUS, 1L, 1L, false);
                                                  localObject1 = this.zUT;
                                                  paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                                  p.k(paramb, "event");
                                                  localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                                                }
                                              } while (localObject1 == null);
                                              ((d.b)localObject1).aPw = true;
                                              ((d.b)localObject1).zXv = paramb.xqG;
                                              if (((d.b)localObject1).ARX > 0L)
                                              {
                                                ((d.b)localObject1).ARW += paramb.xqG - ((d.b)localObject1).ARX;
                                                ((d.b)localObject1).ARX = 0L;
                                              }
                                              paramb = new StringBuilder();
                                              p.j(localObject1, "this");
                                              Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onResume", (d.b)localObject1) + " onResume:" + ((d.b)localObject1).ARW);
                                              return;
                                              localObject1 = this.zUT;
                                              localObject3 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                              p.k(localObject3, "event");
                                              localObject2 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId));
                                            } while (localObject2 == null);
                                            paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqB;
                                            if (paramb != null)
                                            {
                                              i = paramb.ehU();
                                              ((d.b)localObject2).ASs = i;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqB;
                                              if (paramb == null) {
                                                break label580;
                                              }
                                              i = paramb.ehV();
                                              ((d.b)localObject2).ASt = i;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqB;
                                              if (paramb == null) {
                                                break label585;
                                              }
                                              i = paramb.ehW();
                                              ((d.b)localObject2).ASu = i;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqB;
                                              if (paramb != null)
                                              {
                                                localObject1 = paramb.ehX();
                                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                                if (localObject1 != null) {}
                                              }
                                              else
                                              {
                                                paramb = "0";
                                              }
                                              p.k(paramb, "<set-?>");
                                              ((d.b)localObject2).ASv = paramb;
                                              paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqB;
                                              if (paramb == null) {
                                                break label590;
                                              }
                                            }
                                            for (i = paramb.ehY();; i = -1)
                                            {
                                              ((d.b)localObject2).ASw = i;
                                              paramb = new StringBuilder();
                                              p.j(localObject2, "this");
                                              Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onPlayerConfig", (d.b)localObject2) + ' ' + "mediaCodecInitDuration " + ((d.b)localObject2).ASw + " enableMediaCodecReuse:" + ((d.b)localObject2).ASs + " mediaCodecReuseEnabled:" + ((d.b)localObject2).ASt + ' ' + "mediaCodecReused:" + ((d.b)localObject2).ASu + " mediaCodecErrorCode:" + ((d.b)localObject2).ASv);
                                              return;
                                              i = -1;
                                              break;
                                              i = -1;
                                              break label370;
                                              i = -1;
                                              break label391;
                                            }
                                            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(this.zUS, 2L, 1L, false);
                                            localObject1 = this.zUT;
                                            paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                            p.k(paramb, "event");
                                            paramb = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                                          } while (paramb == null);
                                          paramb.xyo += 1;
                                          return;
                                          localObject1 = this.zUT;
                                          paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                          p.k(paramb, "event");
                                          localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                                        } while (localObject1 == null);
                                        ((d.b)localObject1).ASj.add(Integer.valueOf(paramb.offset));
                                        localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
                                        i = com.tencent.mm.plugin.finder.utils.aj.hc(paramb.offset, paramb.total);
                                      } while (i <= ((d.b)localObject1).ARL);
                                      ((d.b)localObject1).ARL = i;
                                      return;
                                      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(this.zUS, 0L, 1L, false);
                                      localObject2 = this.zUT;
                                      localObject3 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                      p.k(localObject3, "event");
                                      localObject4 = new d.b();
                                      localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
                                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                      if (localObject1 == null) {
                                        paramb = "";
                                      }
                                      p.k(paramb, "<set-?>");
                                      ((d.b)localObject4).sessionId = paramb;
                                      ((d.b)localObject4).ARB = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqx;
                                      if (paramb != null)
                                      {
                                        localObject1 = paramb.aBv();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {}
                                      }
                                      else
                                      {
                                        paramb = "";
                                      }
                                      p.k(paramb, "<set-?>");
                                      ((d.b)localObject4).ARC = paramb;
                                      ((d.b)localObject4).ARF = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqx;
                                      ((d.b)localObject4).ARG = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqw;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqv;
                                      if (paramb != null)
                                      {
                                        paramb = paramb.xzp;
                                        if (paramb != null)
                                        {
                                          localObject1 = paramb.getNickName();
                                          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                          if (localObject1 != null) {
                                            break label944;
                                          }
                                        }
                                      }
                                      paramb = "-1";
                                      p.k(paramb, "<set-?>");
                                      ((d.b)localObject4).ARD = paramb;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqv;
                                      if (paramb != null)
                                      {
                                        paramb = paramb.xzp;
                                        if (paramb != null)
                                        {
                                          localObject1 = paramb.getDescription();
                                          paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                          if (localObject1 != null) {
                                            break label994;
                                          }
                                        }
                                      }
                                      paramb = "-1";
                                      paramb = com.tencent.mm.plugin.finder.utils.j.aFA(paramb);
                                      p.j(paramb, "FinderFeedParser.simpleD…ata?.description ?: \"-1\")");
                                      p.k(paramb, "<set-?>");
                                      ((d.b)localObject4).ARE = paramb;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqx;
                                      if (paramb != null)
                                      {
                                        localObject1 = paramb.getPath();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {}
                                      }
                                      else
                                      {
                                        paramb = "";
                                      }
                                      p.k(paramb, "<set-?>");
                                      ((d.b)localObject4).mediaPath = paramb;
                                      ((d.b)localObject4).qkV = ((com.tencent.mm.plugin.finder.event.base.b)localObject3).xqG;
                                      ((d.b)localObject4).ARI = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).position;
                                      ((d.b)localObject4).ARJ = 1;
                                      ((d.b)localObject4).ARU = true;
                                      ((d.b)localObject4).xqz = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqz;
                                      ((d.b)localObject4).ARV = CdnLogic.getRecentAverageSpeed(2);
                                      paramb = MMApplicationContext.getContext().getSystemService("audio");
                                      if (paramb == null) {
                                        throw new kotlin.t("null cannot be cast to non-null type android.media.AudioManager");
                                      }
                                      ((d.b)localObject4).zXC = ((AudioManager)paramb).getStreamVolume(3);
                                      paramb = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
                                      paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqx;
                                      if (paramb != null)
                                      {
                                        localObject1 = paramb.aBv();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {}
                                      }
                                      else
                                      {
                                        paramb = "";
                                      }
                                      paramb = com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramb);
                                      boolean bool;
                                      if (((d.b)localObject4).xqz > 0)
                                      {
                                        i = ((d.b)localObject4).xqz + 1;
                                        ((d.b)localObject4).ARM = i;
                                        if (!paramb.field_hasPlayed) {
                                          break label1563;
                                        }
                                        i = 0;
                                        ((d.b)localObject4).ART = i;
                                        ((d.b)localObject4).ARN = paramb.dKP();
                                        localObject1 = paramb.field_fileFormat;
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 == null) {
                                          paramb = "";
                                        }
                                        ((d.b)localObject4).aGm(paramb);
                                        if (((d.b)localObject4).ARN == 100) {
                                          break label1568;
                                        }
                                        bool = true;
                                        ((d.b)localObject4).ARU = bool;
                                        paramb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
                                        p.j(paramb, "NetStatusUtil.getNetType…tionContext.getContext())");
                                        p.k(paramb, "<set-?>");
                                        ((d.b)localObject4).ARR = paramb;
                                        paramb = n.zWF;
                                        ((d.b)localObject4).ARS = n.bvR();
                                        if (((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).xbu.BmT) {
                                          break label1574;
                                        }
                                        paramb = n.zWF;
                                        l = n.Mn(((d.b)localObject4).ARB);
                                        ((d.b)localObject4).ASc = l;
                                        if (!com.tencent.mm.modelcontrol.e.vW(4)) {
                                          break label1591;
                                        }
                                        paramb = "h265";
                                        p.k(paramb, "<set-?>");
                                        ((d.b)localObject4).ASo = paramb;
                                        ((d.b)localObject4).ARH = ((PluginFinder)h.ag(PluginFinder.class)).getMediaPreloadModel().zKM;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqw;
                                        if (paramb == null) {
                                          break label1598;
                                        }
                                        f = paramb.width;
                                        ((d.b)localObject4).ASp = f;
                                        paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqw;
                                        if (paramb == null) {
                                          break label1603;
                                        }
                                      }
                                      for (f = paramb.height;; f = 0.0F)
                                      {
                                        ((d.b)localObject4).ASq = f;
                                        ((d.b)localObject4).xqz = ((com.tencent.mm.plugin.finder.event.c.a)localObject3).xqz;
                                        ((Map)((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).ARv).put(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject3).feedId), localObject4);
                                        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onStartPlay", (d.b)localObject4) + " firstplay:" + ((d.b)localObject4).ART + ' ' + "posterNickName:" + ((d.b)localObject4).ARD + " mediaDesc:" + ((d.b)localObject4).ARE);
                                        return;
                                        if (paramb.dKP() > 0)
                                        {
                                          i = 1;
                                          break;
                                        }
                                        i = 0;
                                        break;
                                        i = 1;
                                        break label1221;
                                        bool = false;
                                        break label1273;
                                        paramb = n.zWF;
                                        l = n.Mo(((d.b)localObject4).ARB);
                                        break label1345;
                                        paramb = "h264";
                                        break label1363;
                                        f = 0.0F;
                                        break label1411;
                                      }
                                      localObject2 = this.zUT;
                                      localObject1 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                      p.k(localObject1, "event");
                                      localObject2 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).ARv.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject1).feedId));
                                    } while (localObject2 == null);
                                    paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject1).xqC;
                                    if (paramb != null) {}
                                    for (paramb = paramb.ehR();; paramb = null)
                                    {
                                      ((d.b)localObject2).xqC = paramb;
                                      ((d.b)localObject2).aPw = false;
                                      ((d.b)localObject2).ARX = ((com.tencent.mm.plugin.finder.event.base.b)localObject1).xqG;
                                      if (((d.b)localObject2).zXv > 0L)
                                      {
                                        ((d.b)localObject2).zXu += ((com.tencent.mm.plugin.finder.event.base.b)localObject1).xqG - ((d.b)localObject2).zXv;
                                        ((d.b)localObject2).zXv = 0L;
                                      }
                                      paramb = new StringBuilder();
                                      p.j(localObject2, "this");
                                      Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onPause", (d.b)localObject2) + " realPlayTime:" + ((d.b)localObject2).zXu);
                                      return;
                                    }
                                    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(this.zUS, 3L, 1L, false);
                                    localObject2 = this.zUT;
                                    localObject4 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                    p.k(localObject4, "event");
                                    localObject3 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).ARv.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject4).feedId));
                                  } while ((localObject3 == null) || (((d.b)localObject3).ARB != ((com.tencent.mm.plugin.finder.event.c.a)localObject4).feedId));
                                  localObject1 = ((d.b)localObject3).ARC;
                                  paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).xqx;
                                  if (paramb == null) {
                                    break;
                                  }
                                  paramb = paramb.aBv();
                                } while (!p.h(localObject1, paramb));
                                ((d.b)localObject3).zXw = (((com.tencent.mm.plugin.finder.event.base.b)localObject4).xqG - ((d.b)localObject3).qkV);
                                paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).xqC;
                                if (paramb != null) {}
                                for (paramb = paramb.ehR();; paramb = null)
                                {
                                  ((d.b)localObject3).xqC = paramb;
                                  if (((d.b)localObject3).ARX > 0L)
                                  {
                                    ((d.b)localObject3).ARW += ((com.tencent.mm.plugin.finder.event.base.b)localObject4).xqG - ((d.b)localObject3).ARX;
                                    ((d.b)localObject3).ARX = 0L;
                                  }
                                  if (((d.b)localObject3).zXv > 0L)
                                  {
                                    ((d.b)localObject3).zXu += ((com.tencent.mm.plugin.finder.event.base.b)localObject4).xqG - ((d.b)localObject3).zXv;
                                    ((d.b)localObject3).zXv = 0L;
                                  }
                                  if (((d.b)localObject3).ASa > 0L)
                                  {
                                    ((d.b)localObject3).ASb += ((com.tencent.mm.plugin.finder.event.base.b)localObject4).xqG - ((d.b)localObject3).ASa;
                                    ((d.b)localObject3).ASa = 0L;
                                    paramb = new bll();
                                    paramb.SWy = ((int)(((com.tencent.mm.plugin.finder.event.base.b)localObject4).xqG - ((d.b)localObject3).ASa));
                                    paramb.percent = ((d.b)localObject3).ARL;
                                    paramb.type = 0;
                                    ((d.b)localObject3).ASi.add(paramb);
                                  }
                                  paramb = MMApplicationContext.getContext().getSystemService("audio");
                                  if (paramb != null) {
                                    break label2124;
                                  }
                                  throw new kotlin.t("null cannot be cast to non-null type android.media.AudioManager");
                                  paramb = null;
                                  break;
                                }
                                ((d.b)localObject3).zXD = ((AudioManager)paramb).getStreamVolume(3);
                                if ((((d.b)localObject3).ARY == 0L) && (((d.b)localObject3).ARU) && (((d.b)localObject3).ARL < 5)) {
                                  ((d.b)localObject3).mfx = 1;
                                }
                                paramb = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
                                paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).xqx;
                                if (paramb != null)
                                {
                                  localObject1 = paramb.aBv();
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                  if (localObject1 != null) {}
                                }
                                else
                                {
                                  paramb = "";
                                }
                                localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramb).field_fileFormat;
                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                if (localObject1 == null) {
                                  paramb = "";
                                }
                                ((d.b)localObject3).aGm(paramb);
                                paramb = ((com.tencent.mm.plugin.finder.event.c.a)localObject4).xqx;
                                if (paramb != null)
                                {
                                  localObject1 = paramb.getPath();
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                  if (localObject1 != null) {}
                                }
                                else
                                {
                                  paramb = "";
                                }
                                paramb = com.tencent.mm.plugin.sight.base.f.aYg(paramb);
                                if (paramb != null)
                                {
                                  ((d.b)localObject3).ASm = paramb.videoBitrate;
                                  ((d.b)localObject3).ASn = paramb.audioBitrate;
                                  ((d.b)localObject3).frameRate = paramb.frameRate;
                                }
                                if (!((d.b)localObject3).ASg) {
                                  ((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).a((d.b)localObject3);
                                }
                                for (;;)
                                {
                                  ((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).ARv.remove(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject4).feedId));
                                  paramb = new StringBuilder();
                                  p.j(localObject3, "this");
                                  Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onStopPlay", (d.b)localObject3) + " playTime:" + ((d.b)localObject3).zXw + " pauseTotalTime:" + ((d.b)localObject3).ARW + " realPlayTime:" + ((d.b)localObject3).zXu + " playStatus:" + ((d.b)localObject3).mfx);
                                  return;
                                  ((com.tencent.mm.plugin.finder.video.reporter.d)localObject2).ARu.add(localObject3);
                                }
                                localObject1 = this.zUT;
                                paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                                p.k(paramb, "event");
                                localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                              } while (localObject1 == null);
                              ((d.b)localObject1).ARU = true;
                              ((d.b)localObject1).ASa = paramb.xqG;
                              ((d.b)localObject1).ARZ += 1;
                              if (((d.b)localObject1).ARY > 0L) {
                                ((d.b)localObject1).ASh += 1L;
                              }
                              p.j(localObject1, "this");
                              Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.d.a("onWaiting", (d.b)localObject1)));
                              return;
                              localObject1 = this.zUT;
                              localObject2 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                              p.k(localObject2, "event");
                              paramb = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject2).feedId));
                            } while (paramb == null);
                            paramb.ARU = false;
                          } while (paramb.ASa <= 0L);
                          l = ((com.tencent.mm.plugin.finder.event.base.b)localObject2).xqG - paramb.ASa;
                          paramb.ASb += l;
                          localObject1 = new bll();
                          ((bll)localObject1).SWy = ((int)l);
                          ((bll)localObject1).percent = paramb.ARL;
                          if ((paramb.ARZ == 1) && (paramb.ASh == 0L)) {}
                          for (((bll)localObject1).type = 2;; ((bll)localObject1).type = 0)
                          {
                            paramb.ASi.add(localObject1);
                            paramb.ASa = 0L;
                            localObject1 = new StringBuilder();
                            p.j(paramb, "this");
                            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onWaitingEnd", paramb) + " totalWaitingTime:" + paramb.ASb);
                            return;
                          }
                          localObject1 = this.zUT;
                          paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                          p.k(paramb, "event");
                          localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                        } while (localObject1 == null);
                        if (((d.b)localObject1).ARP == 0L) {
                          ((d.b)localObject1).ARP = (paramb.xqG - ((d.b)localObject1).qkV - ((d.b)localObject1).ARW);
                        }
                        ((d.b)localObject1).ARQ = (paramb.offset + paramb.total);
                        ((d.b)localObject1).ARU = false;
                        paramb = new StringBuilder();
                        p.j(localObject1, "this");
                        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onMoovReady", (d.b)localObject1) + " moovReadyTime:" + ((d.b)localObject1).ARP);
                        return;
                        localObject1 = this.zUT;
                        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                        p.k(paramb, "event");
                        localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                      } while (localObject1 == null);
                      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
                      i = com.tencent.mm.plugin.finder.utils.aj.hc(paramb.offset, paramb.total);
                    } while (i <= ((d.b)localObject1).pDo);
                    ((d.b)localObject1).pDo = i;
                    return;
                    localObject1 = this.zUT;
                    paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                    p.k(paramb, "event");
                    localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                  } while ((localObject1 == null) || (((d.b)localObject1).ASd != 0L));
                  ((d.b)localObject1).ASd = (paramb.offset + paramb.total);
                  return;
                  localObject1 = this.zUT;
                  paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                  p.k(paramb, "event");
                  localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
                } while (localObject1 == null);
                ((d.b)localObject1).ARO = (paramb.xqG - ((d.b)localObject1).qkV);
                paramb = paramb.jYa;
                if ((paramb != null) && (((d.b)localObject1).ASf == null)) {
                  ((d.b)localObject1).ASf = com.tencent.mm.plugin.finder.video.reporter.d.b(paramb);
                }
                p.j(localObject1, "this");
                Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.d.a("onDownloadFinish", (d.b)localObject1)));
                return;
                this.zUT.c((com.tencent.mm.plugin.finder.event.c.a)paramb);
                return;
                localObject1 = this.zUT;
                paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
                p.k(paramb, "event");
                paramb = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
              } while (paramb == null);
              paramb.ASg = true;
              p.j(paramb, "this");
              Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.d.a("onDownloadStart", paramb)));
              return;
              localObject1 = this.zUT;
              paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
              p.k(paramb, "event");
              paramb = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
            } while (paramb == null);
            paramb.zXz = 1;
            return;
            localObject1 = this.zUT;
            localObject2 = (com.tencent.mm.plugin.finder.event.c.a)paramb;
            p.k(localObject2, "event");
            paramb = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(((com.tencent.mm.plugin.finder.event.c.a)localObject2).feedId));
          } while (paramb == null);
          if (paramb.ARY == 0L)
          {
            paramb.ARY = (((com.tencent.mm.plugin.finder.event.base.b)localObject2).xqG - paramb.qkV);
            if (paramb.ARY > paramb.ARW) {
              paramb.ARY -= paramb.ARW;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARw;
            l = paramb.ARY;
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).ASV = l;
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).ASU = (l + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).ASU);
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count += 1;
            f = 1.0F * (float)((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).ASU / ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count;
            Log.i(((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).TAG, "count:" + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count + " current:" + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).ASV + ",  average:" + f);
          }
          if (paramb.ARK == 0L) {
            paramb.ARK = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).xqA;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.event.c.a)localObject2).xqw;
          if (localObject1 != null)
          {
            localObject1 = ((csg)localObject1).TAf;
            if (localObject1 == null) {}
          }
          for (int i = ((FinderMediaReportObject)localObject1).playDecoderType;; i = 0)
          {
            paramb.playDecoderType = i;
            localObject1 = new StringBuilder();
            p.j(paramb, "this");
            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onFirstFrameUpdate", paramb) + " firstFrameTime:" + paramb.ARY + " firstLoadTime:" + paramb.ARK + " playDecoderType=" + paramb.playDecoderType);
            return;
          }
          localObject1 = this.zUT;
          paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
          p.k(paramb, "event");
          localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
        } while (localObject1 == null);
        if (((d.b)localObject1).zVj == 0L)
        {
          ((d.b)localObject1).zVj = (paramb.xqG - ((d.b)localObject1).qkV);
          if (((d.b)localObject1).zVj > ((d.b)localObject1).ARW) {
            ((d.b)localObject1).zVj -= ((d.b)localObject1).ARW;
          }
        }
        paramb = new StringBuilder();
        p.j(localObject1, "this");
        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onFirstVideoFrameRendered", (d.b)localObject1) + " firstVideoFrameRendered:" + ((d.b)localObject1).zVj);
        return;
        localObject1 = this.zUT;
        paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
        p.k(paramb, "event");
        paramb = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
      } while (paramb == null);
      paramb.zXy = 1;
      return;
      localObject1 = this.zUT;
      paramb = (com.tencent.mm.plugin.finder.event.c.a)paramb;
      p.k(paramb, "event");
      localObject1 = (d.b)((com.tencent.mm.plugin.finder.video.reporter.d)localObject1).ARv.get(Long.valueOf(paramb.feedId));
    } while (localObject1 == null);
    label391:
    label580:
    label585:
    label590:
    label994:
    ((d.b)localObject1).ASr = paramb.ret;
    label944:
    label1221:
    label1363:
    paramb = new StringBuilder();
    label1345:
    label1603:
    label2124:
    p.j(localObject1, "this");
    label1411:
    label1563:
    label1568:
    label1574:
    label1591:
    label1598:
    Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.d.a("onPlayError", (d.b)localObject1) + " playerErrCode:" + ((d.b)localObject1).ASr);
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    return (paramb instanceof com.tencent.mm.plugin.finder.event.c.a);
  }
  
  protected final b dPj()
  {
    return this.zUR;
  }
  
  public void dPk() {}
  
  public LinkedList<emr> dPl()
  {
    return new LinkedList();
  }
  
  public final MMFragmentActivity dsB()
  {
    return this.zwS;
  }
  
  public final void f(bid parambid)
  {
    p.k(parambid, "contextObj");
    this.xbu = parambid;
    this.zUT.f(parambid);
  }
  
  public final bid getContextObj()
  {
    return this.xbu;
  }
  
  public final boolean getVisible()
  {
    return this.visible;
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    com.tencent.mm.ae.d.c(com.tencent.mm.plugin.finder.viewmodel.component.aj.eld(), (kotlin.g.a.a)new d(this));
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "maps", "", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "megaVideoItem", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "report21140", "contextId", "extraInfo", "sourceFeedId", "sourceUserName", "report21464", "plugin-finder_release"})
  public static final class a
  {
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(277895);
      p.k(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(277895);
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
    
    public static void a(bid parambid, long paramLong1, int paramInt, String paramString, long paramLong2, bs parambs)
    {
      AppMethodBeat.i(277891);
      p.k(parambid, "contextObj");
      p.k(paramString, "actionValue");
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.Nk(paramLong1))
      {
        Log.i(g.access$getTAG$cp(), "feedId:" + paramLong1 + " is loacl fake feed,not report 18054");
        AppMethodBeat.o(277891);
        return;
      }
      cn localcn = new cn();
      localcn.mE(com.tencent.mm.ae.d.Fw(paramLong1));
      localcn.fH(parambid.xkX);
      localcn.ls(paramInt);
      localcn.mF(kotlin.n.n.l(paramString, ",", ";", false));
      if (BuildInfo.DEBUG)
      {
        paramInt = 0;
        localcn.lt(paramInt);
        localcn.fF(paramLong2);
        localcn.mG(parambid.sessionId);
        if (parambs == null) {
          break label572;
        }
        localcn.lu(4);
        paramString = n.zWF;
        paramString = n.N(parambs.mf(), parambid.xkX);
        if (paramString != null)
        {
          localObject = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramString = "";
        }
        localcn.mH(paramString);
        paramString = parambs.xcy;
        if (paramString == null) {
          break label567;
        }
        paramString = paramString.TEM;
        if (paramString == null) {
          break label567;
        }
        paramString = paramString.media;
        if (paramString == null) {
          break label567;
        }
        paramString = (cwq)kotlin.a.j.lp((List)paramString);
        if (paramString == null) {
          break label567;
        }
        paramInt = paramString.TFq;
        label278:
        localcn.fG(paramInt);
        localcn.mO(com.tencent.mm.ae.d.Fw(parambs.mf()));
        label300:
        paramString = n.zWF;
        paramString = n.N(paramLong1, parambid.xkX);
        if (paramString != null)
        {
          parambs = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = parambs;
          if (parambs != null) {}
        }
        else
        {
          paramString = "";
        }
        localcn.mH(paramString);
        localcn.mI(com.tencent.mm.ae.d.Fw(parambid.BmO));
        parambs = parambid.BmP;
        paramString = parambs;
        if (parambs == null) {
          paramString = "";
        }
        localcn.mJ(paramString);
        localcn.mK(parambid.wmz);
        localcn.mL(parambid.wmL);
        paramString = parambid.extraInfo;
        if (paramString != null)
        {
          parambs = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = parambs;
          if (parambs != null) {}
        }
        else
        {
          paramString = "";
        }
        localcn.mM(paramString);
        paramString = parambid.wmC;
        if (paramString != null)
        {
          parambs = kotlin.n.n.l(paramString, ",", ";", false);
          paramString = parambs;
          if (parambs != null) {}
        }
        else
        {
          paramString = "";
        }
        localcn.mN(paramString);
        paramString = com.tencent.mm.plugin.finder.utils.aj.AGc;
        parambs = n.zWF;
        if (!com.tencent.mm.plugin.finder.utils.aj.a(paramString, n.PA(parambid.xkX), 0, 2)) {
          break label645;
        }
      }
      label645:
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        localcn.fI(paramLong1);
        localcn.fBl();
        parambid = n.zWF;
        n.a((com.tencent.mm.plugin.report.a)localcn);
        AppMethodBeat.o(277891);
        return;
        paramInt = 43;
        break;
        label567:
        paramInt = 0;
        break label278;
        label572:
        paramString = n.zWF;
        paramString = n.Hc(paramLong1);
        if (paramString == null) {
          break label300;
        }
        localcn.lu(paramString.getMediaType());
        paramString = (csg)kotlin.a.j.lp((List)paramString.getMediaList());
        if (paramString != null) {}
        for (paramLong2 = paramString.videoDuration;; paramLong2 = 0L)
        {
          localcn.fG(paramLong2);
          break;
        }
      }
    }
    
    public static void a(bid parambid, t paramt)
    {
      AppMethodBeat.i(277900);
      p.k(parambid, "contextObj");
      p.k(paramt, "record");
      cv localcv = new cv();
      localcv.nB(parambid.sessionId);
      localcv.nC(parambid.wmL);
      localcv.nD(parambid.wmz);
      localcv.gx(parambid.xkX);
      localcv.nE(com.tencent.mm.ae.d.Fw(paramt.feedId));
      parambid = paramt.xpY;
      long l1;
      Object localObject1;
      label150:
      long l2;
      if (parambid != null)
      {
        parambid = parambid.getFoldedLayout();
        if (parambid != null)
        {
          l1 = parambid.jlf;
          localcv.gy(l1);
          parambid = paramt.xpY;
          if (parambid != null)
          {
            parambid = parambid.getFoldedLayout();
            if (parambid != null)
            {
              localObject1 = parambid.username;
              parambid = (bid)localObject1;
              if (localObject1 != null) {
                break label150;
              }
            }
          }
          parambid = "";
          localcv.nF(parambid);
          localcv.nG("");
          l2 = 0L;
          parambid = FinderFoldedScrollLayout.AXT;
          if (FinderFoldedScrollLayout.eiI() == 0L) {
            break label411;
          }
          parambid = FinderFoldedScrollLayout.AXT;
          localcv.gA(FinderFoldedScrollLayout.eiI());
          l1 = 0L;
        }
      }
      for (;;)
      {
        label196:
        parambid = paramt.xpY;
        if (parambid != null)
        {
          parambid = parambid.getFoldedLayout();
          if (parambid != null)
          {
            parambid = parambid.SGi;
            if (parambid != null)
            {
              localObject1 = ((Iterable)parambid).iterator();
              int i = 0;
              for (;;)
              {
                label236:
                if (!((Iterator)localObject1).hasNext()) {
                  break label694;
                }
                parambid = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  kotlin.a.j.iBO();
                }
                Object localObject2 = (FinderObject)parambid;
                parambid = paramt.xrf;
                if (parambid != null)
                {
                  parambid = parambid.YSH;
                  if (parambid != null) {
                    parambid = (com.tencent.mm.view.recyclerview.l)parambid.get(((FinderObject)localObject2).id);
                  }
                }
                for (;;)
                {
                  if (parambid != null)
                  {
                    if (l2 == parambid.YSP.mf())
                    {
                      localObject2 = localcv.ahQ();
                      localcv.nG((String)localObject2 + com.tencent.mm.ae.d.Fw(parambid.YSP.mf()) + ';' + i + ';' + parambid.BQj + ';' + l1 + '#');
                      i = j;
                      break label236;
                      l1 = 0L;
                      break;
                      label411:
                      parambid = FinderFoldedScrollLayout.AXT;
                      if (FinderFoldedScrollLayout.eiJ() != 0L)
                      {
                        parambid = FinderFoldedScrollLayout.AXT;
                        localcv.gz(FinderFoldedScrollLayout.eiJ());
                        l1 = 0L;
                        break label196;
                      }
                      parambid = FinderFoldedScrollLayout.AXT;
                      if (FinderFoldedScrollLayout.eiL() == 0L) {
                        break label751;
                      }
                      parambid = FinderFoldedScrollLayout.AXT;
                      l2 = FinderFoldedScrollLayout.eiK();
                      parambid = FinderFoldedScrollLayout.AXT;
                      l1 = FinderFoldedScrollLayout.eiL();
                      break label196;
                      parambid = null;
                      continue;
                    }
                    localObject2 = localcv.ahQ();
                    localcv.nG((String)localObject2 + com.tencent.mm.ae.d.Fw(parambid.YSP.mf()) + ';' + i + ';' + parambid.BQj + ";0#");
                    i = j;
                    break label236;
                  }
                }
                parambid = g.zUU;
                if (l2 == ((FinderObject)localObject2).id)
                {
                  parambid = localcv.ahQ();
                  localcv.nG(parambid + com.tencent.mm.ae.d.Fw(((FinderObject)localObject2).id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                }
                else
                {
                  parambid = localcv.ahQ();
                  localcv.nG(parambid + com.tencent.mm.ae.d.Fw(((FinderObject)localObject2).id) + ';' + i + ";0;0#");
                  i = j;
                }
              }
            }
          }
        }
        label694:
        parambid = FinderFoldedScrollLayout.AXT;
        FinderFoldedScrollLayout.Nu(0L);
        parambid = FinderFoldedScrollLayout.AXT;
        FinderFoldedScrollLayout.Nx(0L);
        parambid = FinderFoldedScrollLayout.AXT;
        FinderFoldedScrollLayout.Nw(0L);
        parambid = FinderFoldedScrollLayout.AXT;
        FinderFoldedScrollLayout.Nv(0L);
        localcv.fBl();
        parambid = n.zWF;
        n.a((com.tencent.mm.plugin.report.a)localcv);
        AppMethodBeat.o(277900);
        return;
        label751:
        l1 = 0L;
      }
    }
    
    public static void a(bid parambid, t paramt, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(277899);
      p.k(parambid, "contextObj");
      p.k(paramt, "record");
      FinderItem localFinderItem = paramt.xpY;
      if (localFinderItem != null)
      {
        da localda = new da();
        localda.oh(com.tencent.mm.ae.d.Fw(localFinderItem.getId()));
        localda.gQ(localFinderItem.getMediaType());
        localda.oi(parambid.sessionId);
        localda.he(parambid.xkX);
        localda.gR(paramt.fhq);
        localda.gS(localFinderItem.getLikeCount());
        localda.gT(localFinderItem.getCommentCount());
        Object localObject1 = ag.AFH;
        localda.oj(kotlin.n.n.l(ag.A(localFinderItem), ",", ";", false));
        Object localObject2 = localFinderItem.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.j(localObject1, "(it.feedObject.recommendReason ?: \"\")");
        localda.ok(kotlin.n.n.l((String)localObject1, ",", ";", false));
        long l1;
        if (p.h(localFinderItem.getUserName(), z.bdh()))
        {
          l1 = 1L;
          localda.gU(l1);
          localda.gV(localFinderItem.getCreateTime());
          if ((localFinderItem.getLocation().latitude > 0.0F) && (localFinderItem.getLocation().longitude > 0.0F)) {
            localda.ahV();
          }
          localda.gW(localFinderItem.getMediaList().size());
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localda.gX(((csg)localFinderItem.getMediaList().get(0)).videoDuration);
          }
          localda.gY(paramt.endTime - paramt.startTime);
          if (!BuildInfo.DEBUG) {
            break label733;
          }
          l1 = l2;
          label342:
          localda.gZ(l1);
          localda.ha(localFinderItem.getFeedObject().recommendType);
          localda.ol(localFinderItem.getUserName());
          localda.hb(localFinderItem.getFeedObject().orgRecommendType);
          localObject2 = localFinderItem.getFeedObject().warnWording;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localda.om((String)localObject1);
          localda.hc(localFinderItem.getFeedObject().warnFlag);
          localda.hd(paramInt);
          localObject2 = parambid.wmL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localda.on((String)localObject1);
          localda.oo(com.tencent.mm.ae.d.Fw(parambid.BmO));
          localObject2 = parambid.BmP;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localda.op((String)localObject1);
          localObject2 = parambid.wmz;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localda.oq((String)localObject1);
          localda.hf(paramt.zWX);
          paramt = com.tencent.mm.plugin.findersdk.b.c.BvA;
          localda.hg(com.tencent.mm.plugin.findersdk.b.c.a.Sh(parambid.xkX));
          paramt = n.zWF;
          localda.or(n.N(localFinderItem.getId(), parambid.xkX));
          parambid = com.tencent.mm.plugin.finder.upload.action.l.ACj;
          parambid = com.tencent.mm.plugin.finder.upload.action.l.ecG().u(localFinderItem.getFeedObject());
          localda.hh(parambid.size());
          if (parambid.size() <= 3) {
            break label740;
          }
          localda.hi(3L);
        }
        for (;;)
        {
          localda.os("");
          parambid = ((Iterable)parambid).iterator();
          paramInt = 0;
          while (parambid.hasNext())
          {
            paramt = parambid.next();
            if (paramInt < 0) {
              kotlin.a.j.iBO();
            }
            paramt = (FinderCommentInfo)paramt;
            if (paramInt <= 2) {
              localda.os(localda.ahW() + paramt.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          label733:
          l1 = 5L;
          break label342;
          label740:
          localda.hi(parambid.size());
        }
        localda.hj(localFinderItem.getFeedObject().commentList.size());
        parambid = localFinderItem.getFeedObject().commentList;
        p.j(parambid, "it.feedObject.commentList");
        parambid = (FinderCommentInfo)kotlin.a.j.lp((List)parambid);
        if (parambid != null)
        {
          paramt = parambid.username;
          parambid = paramt;
          if (paramt != null) {}
        }
        else
        {
          parambid = "";
        }
        localda.ot(parambid);
        parambid = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.C(localFinderItem)) {
          localda.hk(localFinderItem.getFeedObject().incFriendLikeCount);
        }
        parambid = localFinderItem.getFeedObject().commentList;
        p.j(parambid, "it.feedObject.commentList");
        paramt = (Iterable)parambid;
        parambid = (Collection)new ArrayList();
        paramt = paramt.iterator();
        while (paramt.hasNext())
        {
          localObject1 = paramt.next();
          localObject2 = (FinderCommentInfo)localObject1;
          if (((PluginFinder)h.ag(PluginFinder.class)).isFriend(((FinderCommentInfo)localObject2).username)) {
            parambid.add(localObject1);
          }
        }
        localda.hl(((List)parambid).size());
        localda.hm(localFinderItem.getFeedObject().commentList.size());
        localda.fBl();
        parambid = n.zWF;
        n.a((com.tencent.mm.plugin.report.a)localda);
        AppMethodBeat.o(277899);
        return;
      }
      AppMethodBeat.o(277899);
    }
    
    public static String aa(Map<String, ? extends Object> paramMap)
    {
      AppMethodBeat.i(277898);
      p.k(paramMap, "maps");
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
      p.j(paramMap, "json.toString()");
      paramMap = kotlin.n.n.l(paramMap, ",", ";", false);
      AppMethodBeat.o(277898);
      return paramMap;
    }
    
    public static void s(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(277901);
      db localdb = new db();
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      localdb.ou(str);
      if (paramString2 != null)
      {
        paramString2 = kotlin.n.n.l(paramString2, ",", ";", false);
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localdb.ov(paramString1);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      localdb.ow(paramString1);
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      localdb.ox(paramString1);
      localdb.bpa();
      AppMethodBeat.o(277901);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "", "()V", "isReceivedMsg", "", "()Z", "setReceivedMsg", "(Z)V", "isRingUp", "setRingUp", "reset", "", "plugin-finder_release"})
  public static final class b
  {
    boolean zUW;
    boolean zUX;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT;", "", "()V", "Companion", "plugin-finder_release"})
  public static final class c
  {
    private static final String zUY = "1";
    public static final a zUZ;
    
    static
    {
      AppMethodBeat.i(268659);
      zUZ = new a((byte)0);
      zUY = "1";
      AppMethodBeat.o(268659);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT$Companion;", "", "()V", "CLICK", "", "getCLICK", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a
    {
      public static String dPn()
      {
        AppMethodBeat.i(283435);
        String str = g.c.dPm();
        AppMethodBeat.o(283435);
        return str;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.g
 * JD-Core Version:    0.7.0.1
 */