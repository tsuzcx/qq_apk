package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import android.util.LongSparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.reporter.b.b;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.i;
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
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "IDKEY_VIDEO_PLAY", "", "getIDKEY_VIDEO_PLAY", "()J", "getActivity", "()Lcom/tencent/mm/ui/MMFragmentActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "extStatusRecord", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "getExtStatusRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "onInvisible", "onRelease", "onTabChange", "onVisible", "sendStatsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "Companion", "ExtStatsRecord", "INPUT_RESULT", "ShareSceneType", "plugin-finder_release"})
public abstract class e
  extends com.tencent.mm.plugin.finder.event.base.d
{
  private static final String TAG = "Finder.FinderFeedFlowReporter";
  public static final a vdS = new a((byte)0);
  public bbn ttO;
  final MMFragmentActivity uLr;
  private com.tencent.mm.plugin.messenger.foundation.a.g vdO;
  final b vdP;
  private final long vdQ;
  public final com.tencent.mm.plugin.finder.video.reporter.b vdR;
  boolean visible;
  
  public e(MMFragmentActivity paramMMFragmentActivity, bbn parambbn)
  {
    this.uLr = paramMMFragmentActivity;
    this.ttO = parambbn;
    this.vdQ = 1277L;
    this.vdR = new com.tencent.mm.plugin.finder.video.reporter.b(this.ttO);
    this.vdP = new b();
    this.vdO = ((com.tencent.mm.plugin.messenger.foundation.a.g)new com.tencent.mm.plugin.messenger.foundation.a.g()
    {
      public final void a(ca paramAnonymousca, i.c paramAnonymousc, boolean[] paramAnonymousArrayOfBoolean) {}
      
      public final void a(ca paramAnonymousca, az paramAnonymousaz, boolean paramAnonymousBoolean, i.c paramAnonymousc) {}
      
      public final void b(ca paramAnonymousca, az paramAnonymousaz, boolean paramAnonymousBoolean, i.c paramAnonymousc)
      {
        AppMethodBeat.i(250538);
        this.vdT.dnL();
        AppMethodBeat.o(250538);
      }
    });
    paramMMFragmentActivity = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(paramMMFragmentActivity, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)paramMMFragmentActivity).aST().a(this.vdO);
    this.visible = true;
  }
  
  public void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    kotlin.g.b.p.h(paramb, "event");
    if (this.ttO.tCE == 0) {
      Log.i(TAG, "[onEventHappen] invalid scene");
    }
    Object localObject1;
    label370:
    label1267:
    label1405:
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
                                                return;
                                              } while (!(paramb instanceof c.a));
                                              switch (((c.a)paramb).type)
                                              {
                                              default: 
                                                return;
                                              case 1: 
                                                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(this.vdQ, 1L, 1L, false);
                                                localObject1 = this.vdR;
                                                paramb = (c.a)paramb;
                                                kotlin.g.b.p.h(paramb, "event");
                                                localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                                              }
                                            } while (localObject1 == null);
                                            ((b.b)localObject1).bfW = true;
                                            ((b.b)localObject1).vgn = paramb.tHW;
                                            if (((b.b)localObject1).wii > 0L)
                                            {
                                              ((b.b)localObject1).wih += paramb.tHW - ((b.b)localObject1).wii;
                                              ((b.b)localObject1).wii = 0L;
                                            }
                                            paramb = new StringBuilder();
                                            kotlin.g.b.p.g(localObject1, "this");
                                            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onResume", (b.b)localObject1) + " onResume:" + ((b.b)localObject1).wih);
                                            return;
                                            localObject1 = this.vdR;
                                            localObject3 = (c.a)paramb;
                                            kotlin.g.b.p.h(localObject3, "event");
                                            localObject2 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(((c.a)localObject3).feedId));
                                          } while (localObject2 == null);
                                          paramb = ((c.a)localObject3).tHS;
                                          if (paramb != null)
                                          {
                                            i = paramb.dGa();
                                            ((b.b)localObject2).wiD = i;
                                            paramb = ((c.a)localObject3).tHS;
                                            if (paramb == null) {
                                              break label580;
                                            }
                                            i = paramb.dGb();
                                            ((b.b)localObject2).wiE = i;
                                            paramb = ((c.a)localObject3).tHS;
                                            if (paramb == null) {
                                              break label585;
                                            }
                                            i = paramb.dGc();
                                            ((b.b)localObject2).wiF = i;
                                            paramb = ((c.a)localObject3).tHS;
                                            if (paramb != null)
                                            {
                                              localObject1 = paramb.dGd();
                                              paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                              if (localObject1 != null) {}
                                            }
                                            else
                                            {
                                              paramb = "0";
                                            }
                                            kotlin.g.b.p.h(paramb, "<set-?>");
                                            ((b.b)localObject2).wiG = paramb;
                                            paramb = ((c.a)localObject3).tHS;
                                            if (paramb == null) {
                                              break label590;
                                            }
                                          }
                                          for (i = paramb.dGe();; i = -1)
                                          {
                                            ((b.b)localObject2).wiH = i;
                                            paramb = new StringBuilder();
                                            kotlin.g.b.p.g(localObject2, "this");
                                            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onPlayerConfig", (b.b)localObject2) + ' ' + "mediaCodecInitDuration " + ((b.b)localObject2).wiH + " enableMediaCodecReuse:" + ((b.b)localObject2).wiD + " mediaCodecReuseEnabled:" + ((b.b)localObject2).wiE + ' ' + "mediaCodecReused:" + ((b.b)localObject2).wiF + " mediaCodecErrorCode:" + ((b.b)localObject2).wiG);
                                            return;
                                            i = -1;
                                            break;
                                            i = -1;
                                            break label370;
                                            i = -1;
                                            break label391;
                                          }
                                          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(this.vdQ, 2L, 1L, false);
                                          localObject1 = this.vdR;
                                          paramb = (c.a)paramb;
                                          kotlin.g.b.p.h(paramb, "event");
                                          paramb = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                                        } while (paramb == null);
                                        paramb.wie += 1;
                                        return;
                                        localObject1 = this.vdR;
                                        paramb = (c.a)paramb;
                                        kotlin.g.b.p.h(paramb, "event");
                                        localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                                      } while (localObject1 == null);
                                      ((b.b)localObject1).wiu.add(Integer.valueOf(paramb.offset));
                                      localObject2 = y.vXH;
                                      i = y.gq(paramb.offset, paramb.jcu);
                                    } while (i <= ((b.b)localObject1).whV);
                                    ((b.b)localObject1).whV = i;
                                    return;
                                    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(this.vdQ, 0L, 1L, false);
                                    localObject2 = this.vdR;
                                    localObject3 = (c.a)paramb;
                                    kotlin.g.b.p.h(localObject3, "event");
                                    localObject4 = new b.b();
                                    localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
                                    paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                    if (localObject1 == null) {
                                      paramb = "";
                                    }
                                    kotlin.g.b.p.h(paramb, "<set-?>");
                                    ((b.b)localObject4).sessionId = paramb;
                                    ((b.b)localObject4).whL = ((c.a)localObject3).feedId;
                                    paramb = ((c.a)localObject3).tHN;
                                    if (paramb != null)
                                    {
                                      localObject1 = paramb.auA();
                                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                      if (localObject1 != null) {}
                                    }
                                    else
                                    {
                                      paramb = "";
                                    }
                                    kotlin.g.b.p.h(paramb, "<set-?>");
                                    ((b.b)localObject4).whM = paramb;
                                    ((b.b)localObject4).whP = ((c.a)localObject3).tHN;
                                    ((b.b)localObject4).whQ = ((c.a)localObject3).tHM;
                                    paramb = ((c.a)localObject3).tHL;
                                    if (paramb != null)
                                    {
                                      paramb = paramb.wgm;
                                      if (paramb != null)
                                      {
                                        localObject1 = paramb.getNickName();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {
                                          break label942;
                                        }
                                      }
                                    }
                                    paramb = "-1";
                                    kotlin.g.b.p.h(paramb, "<set-?>");
                                    ((b.b)localObject4).whN = paramb;
                                    paramb = ((c.a)localObject3).tHL;
                                    if (paramb != null)
                                    {
                                      paramb = paramb.wgm;
                                      if (paramb != null)
                                      {
                                        localObject1 = paramb.getDescription();
                                        paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                        if (localObject1 != null) {
                                          break label992;
                                        }
                                      }
                                    }
                                    paramb = "-1";
                                    paramb = h.awf(paramb);
                                    kotlin.g.b.p.g(paramb, "FinderFeedParser.simpleD…ata?.description ?: \"-1\")");
                                    kotlin.g.b.p.h(paramb, "<set-?>");
                                    ((b.b)localObject4).whO = paramb;
                                    paramb = ((c.a)localObject3).tHN;
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
                                    kotlin.g.b.p.h(paramb, "<set-?>");
                                    ((b.b)localObject4).mediaPath = paramb;
                                    ((b.b)localObject4).njx = ((com.tencent.mm.plugin.finder.event.base.b)localObject3).tHW;
                                    ((b.b)localObject4).whS = ((c.a)localObject3).position;
                                    ((b.b)localObject4).whT = 1;
                                    ((b.b)localObject4).wif = true;
                                    ((b.b)localObject4).tHQ = ((c.a)localObject3).tHQ;
                                    ((b.b)localObject4).wig = CdnLogic.getRecentAverageSpeed(2);
                                    paramb = MMApplicationContext.getContext().getSystemService("audio");
                                    if (paramb == null) {
                                      throw new t("null cannot be cast to non-null type android.media.AudioManager");
                                    }
                                    ((b.b)localObject4).vgu = ((AudioManager)paramb).getStreamVolume(3);
                                    paramb = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                                    paramb = ((c.a)localObject3).tHN;
                                    if (paramb != null)
                                    {
                                      localObject1 = paramb.auA();
                                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                      if (localObject1 != null) {}
                                    }
                                    else
                                    {
                                      paramb = "";
                                    }
                                    paramb = com.tencent.mm.plugin.finder.storage.logic.d.avH(paramb);
                                    boolean bool;
                                    if (((b.b)localObject4).tHQ > 0)
                                    {
                                      i = ((b.b)localObject4).tHQ + 1;
                                      ((b.b)localObject4).whW = i;
                                      if (!paramb.field_hasPlayed) {
                                        break label1557;
                                      }
                                      i = 0;
                                      ((b.b)localObject4).wid = i;
                                      ((b.b)localObject4).whX = paramb.dkP();
                                      localObject1 = paramb.field_fileFormat;
                                      paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                      if (localObject1 == null) {
                                        paramb = "";
                                      }
                                      ((b.b)localObject4).awK(paramb);
                                      if (((b.b)localObject4).whX == 100) {
                                        break label1562;
                                      }
                                      bool = true;
                                      ((b.b)localObject4).wif = bool;
                                      paramb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
                                      kotlin.g.b.p.g(paramb, "NetStatusUtil.getNetType…tionContext.getContext())");
                                      kotlin.g.b.p.h(paramb, "<set-?>");
                                      ((b.b)localObject4).wib = paramb;
                                      paramb = k.vfA;
                                      ((b.b)localObject4).wic = k.dod();
                                      if (((com.tencent.mm.plugin.finder.video.reporter.b)localObject2).ttO.wzb) {
                                        break label1568;
                                      }
                                      paramb = k.vfA;
                                      l = k.Fe(((b.b)localObject4).whL);
                                      ((b.b)localObject4).win = l;
                                      if (!com.tencent.mm.modelcontrol.e.sX(4)) {
                                        break label1585;
                                      }
                                      paramb = "h265";
                                      kotlin.g.b.p.h(paramb, "<set-?>");
                                      ((b.b)localObject4).wiz = paramb;
                                      ((b.b)localObject4).whR = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUw;
                                      paramb = ((c.a)localObject3).tHM;
                                      if (paramb == null) {
                                        break label1592;
                                      }
                                      f = paramb.width;
                                      ((b.b)localObject4).wiA = f;
                                      paramb = ((c.a)localObject3).tHM;
                                      if (paramb == null) {
                                        break label1597;
                                      }
                                    }
                                    for (f = paramb.height;; f = 0.0F)
                                    {
                                      ((b.b)localObject4).wiB = f;
                                      ((b.b)localObject4).tHQ = ((c.a)localObject3).tHQ;
                                      ((Map)((com.tencent.mm.plugin.finder.video.reporter.b)localObject2).whF).put(Long.valueOf(((c.a)localObject3).feedId), localObject4);
                                      Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onStartPlay", (b.b)localObject4) + " firstplay:" + ((b.b)localObject4).wid + ' ' + "posterNickName:" + ((b.b)localObject4).whN + " mediaDesc:" + ((b.b)localObject4).whO);
                                      return;
                                      if (paramb.dkP() > 0)
                                      {
                                        i = 1;
                                        break;
                                      }
                                      i = 0;
                                      break;
                                      i = 1;
                                      break label1215;
                                      bool = false;
                                      break label1267;
                                      paramb = k.vfA;
                                      l = k.Ff(((b.b)localObject4).whL);
                                      break label1339;
                                      paramb = "h264";
                                      break label1357;
                                      f = 0.0F;
                                      break label1405;
                                    }
                                    localObject1 = this.vdR;
                                    paramb = (c.a)paramb;
                                    kotlin.g.b.p.h(paramb, "event");
                                    localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                                  } while (localObject1 == null);
                                  ((b.b)localObject1).bfW = false;
                                  ((b.b)localObject1).wii = paramb.tHW;
                                  if (((b.b)localObject1).vgn > 0L)
                                  {
                                    ((b.b)localObject1).vgm += paramb.tHW - ((b.b)localObject1).vgn;
                                    ((b.b)localObject1).vgn = 0L;
                                  }
                                  paramb = new StringBuilder();
                                  kotlin.g.b.p.g(localObject1, "this");
                                  Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onPause", (b.b)localObject1) + " realPlayTime:" + ((b.b)localObject1).vgm);
                                  return;
                                  com.tencent.mm.plugin.report.e.Cxv.idkeyStat(this.vdQ, 3L, 1L, false);
                                  localObject2 = this.vdR;
                                  localObject4 = (c.a)paramb;
                                  kotlin.g.b.p.h(localObject4, "event");
                                  localObject3 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject2).whF.get(Long.valueOf(((c.a)localObject4).feedId));
                                } while ((localObject3 == null) || (((b.b)localObject3).whL != ((c.a)localObject4).feedId));
                                localObject1 = ((b.b)localObject3).whM;
                                paramb = ((c.a)localObject4).tHN;
                                if (paramb != null) {}
                                for (paramb = paramb.auA(); kotlin.g.b.p.j(localObject1, paramb); paramb = null)
                                {
                                  ((b.b)localObject3).vgo = (((com.tencent.mm.plugin.finder.event.base.b)localObject4).tHW - ((b.b)localObject3).njx);
                                  if (((b.b)localObject3).wii > 0L)
                                  {
                                    ((b.b)localObject3).wih += ((com.tencent.mm.plugin.finder.event.base.b)localObject4).tHW - ((b.b)localObject3).wii;
                                    ((b.b)localObject3).wii = 0L;
                                  }
                                  if (((b.b)localObject3).vgn > 0L)
                                  {
                                    ((b.b)localObject3).vgm += ((com.tencent.mm.plugin.finder.event.base.b)localObject4).tHW - ((b.b)localObject3).vgn;
                                    ((b.b)localObject3).vgn = 0L;
                                  }
                                  if (((b.b)localObject3).wil > 0L)
                                  {
                                    ((b.b)localObject3).wim += ((com.tencent.mm.plugin.finder.event.base.b)localObject4).tHW - ((b.b)localObject3).wil;
                                    ((b.b)localObject3).wil = 0L;
                                    paramb = new bek();
                                    paramb.LOf = ((int)(((com.tencent.mm.plugin.finder.event.base.b)localObject4).tHW - ((b.b)localObject3).wil));
                                    paramb.percent = ((b.b)localObject3).whV;
                                    paramb.type = 0;
                                    ((b.b)localObject3).wit.add(paramb);
                                  }
                                  paramb = MMApplicationContext.getContext().getSystemService("audio");
                                  if (paramb != null) {
                                    break label2059;
                                  }
                                  throw new t("null cannot be cast to non-null type android.media.AudioManager");
                                }
                                ((b.b)localObject3).vgv = ((AudioManager)paramb).getStreamVolume(3);
                                if ((((b.b)localObject3).wij == 0L) && (((b.b)localObject3).wif) && (((b.b)localObject3).whV < 5)) {
                                  ((b.b)localObject3).jpW = 1;
                                }
                                paramb = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                                paramb = ((c.a)localObject4).tHN;
                                if (paramb != null)
                                {
                                  localObject1 = paramb.auA();
                                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                  if (localObject1 != null) {}
                                }
                                else
                                {
                                  paramb = "";
                                }
                                localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.avH(paramb).field_fileFormat;
                                paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject1;
                                if (localObject1 == null) {
                                  paramb = "";
                                }
                                ((b.b)localObject3).awK(paramb);
                                paramb = ((c.a)localObject4).tHN;
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
                                paramb = com.tencent.mm.plugin.sight.base.e.aNx(paramb);
                                if (paramb != null)
                                {
                                  ((b.b)localObject3).wix = paramb.videoBitrate;
                                  ((b.b)localObject3).wiy = paramb.audioBitrate;
                                  ((b.b)localObject3).frameRate = paramb.frameRate;
                                }
                                if (!((b.b)localObject3).wir) {
                                  ((com.tencent.mm.plugin.finder.video.reporter.b)localObject2).a((b.b)localObject3);
                                }
                                for (;;)
                                {
                                  ((com.tencent.mm.plugin.finder.video.reporter.b)localObject2).whF.remove(Long.valueOf(((c.a)localObject4).feedId));
                                  paramb = new StringBuilder();
                                  kotlin.g.b.p.g(localObject3, "this");
                                  Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onStopPlay", (b.b)localObject3) + " playTime:" + ((b.b)localObject3).vgo + " pauseTotalTime:" + ((b.b)localObject3).wih + " realPlayTime:" + ((b.b)localObject3).vgm + " playStatus:" + ((b.b)localObject3).jpW);
                                  return;
                                  ((com.tencent.mm.plugin.finder.video.reporter.b)localObject2).whE.add(localObject3);
                                }
                                localObject1 = this.vdR;
                                paramb = (c.a)paramb;
                                kotlin.g.b.p.h(paramb, "event");
                                localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                              } while (localObject1 == null);
                              ((b.b)localObject1).wif = true;
                              ((b.b)localObject1).wil = paramb.tHW;
                              ((b.b)localObject1).wik += 1;
                              if (((b.b)localObject1).wij > 0L) {
                                ((b.b)localObject1).wis += 1L;
                              }
                              kotlin.g.b.p.g(localObject1, "this");
                              Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.b.a("onWaiting", (b.b)localObject1)));
                              return;
                              localObject1 = this.vdR;
                              localObject2 = (c.a)paramb;
                              kotlin.g.b.p.h(localObject2, "event");
                              paramb = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(((c.a)localObject2).feedId));
                            } while (paramb == null);
                            paramb.wif = false;
                          } while (paramb.wil <= 0L);
                          l = ((com.tencent.mm.plugin.finder.event.base.b)localObject2).tHW - paramb.wil;
                          paramb.wim += l;
                          localObject1 = new bek();
                          ((bek)localObject1).LOf = ((int)l);
                          ((bek)localObject1).percent = paramb.whV;
                          if ((paramb.wik == 1) && (paramb.wis == 0L)) {}
                          for (((bek)localObject1).type = 2;; ((bek)localObject1).type = 0)
                          {
                            paramb.wit.add(localObject1);
                            paramb.wil = 0L;
                            localObject1 = new StringBuilder();
                            kotlin.g.b.p.g(paramb, "this");
                            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onWaitingEnd", paramb) + " totalWaitingTime:" + paramb.wim);
                            return;
                          }
                          localObject1 = this.vdR;
                          paramb = (c.a)paramb;
                          kotlin.g.b.p.h(paramb, "event");
                          localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                        } while (localObject1 == null);
                        if (((b.b)localObject1).whZ == 0L) {
                          ((b.b)localObject1).whZ = (paramb.tHW - ((b.b)localObject1).njx - ((b.b)localObject1).wih);
                        }
                        ((b.b)localObject1).wia = (paramb.offset + paramb.jcu);
                        ((b.b)localObject1).wif = false;
                        paramb = new StringBuilder();
                        kotlin.g.b.p.g(localObject1, "this");
                        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onMoovReady", (b.b)localObject1) + " moovReadyTime:" + ((b.b)localObject1).whZ);
                        return;
                        localObject1 = this.vdR;
                        paramb = (c.a)paramb;
                        kotlin.g.b.p.h(paramb, "event");
                        localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                      } while (localObject1 == null);
                      localObject2 = y.vXH;
                      i = y.gq(paramb.offset, paramb.jcu);
                    } while (i <= ((b.b)localObject1).mEd);
                    ((b.b)localObject1).mEd = i;
                    return;
                    localObject1 = this.vdR;
                    paramb = (c.a)paramb;
                    kotlin.g.b.p.h(paramb, "event");
                    localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                  } while ((localObject1 == null) || (((b.b)localObject1).wio != 0L));
                  ((b.b)localObject1).wio = (paramb.offset + paramb.jcu);
                  return;
                  localObject1 = this.vdR;
                  paramb = (c.a)paramb;
                  kotlin.g.b.p.h(paramb, "event");
                  localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
                } while (localObject1 == null);
                ((b.b)localObject1).whY = (paramb.tHW - ((b.b)localObject1).njx);
                paramb = paramb.hmq;
                if ((paramb != null) && (((b.b)localObject1).wiq == null)) {
                  ((b.b)localObject1).wiq = com.tencent.mm.plugin.finder.video.reporter.b.b(paramb);
                }
                kotlin.g.b.p.g(localObject1, "this");
                Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.b.a("onDownloadFinish", (b.b)localObject1)));
                return;
                this.vdR.a((c.a)paramb);
                return;
                localObject1 = this.vdR;
                paramb = (c.a)paramb;
                kotlin.g.b.p.h(paramb, "event");
                paramb = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
              } while (paramb == null);
              paramb.wir = true;
              kotlin.g.b.p.g(paramb, "this");
              Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.b.a("onDownloadStart", paramb)));
              return;
              localObject1 = this.vdR;
              paramb = (c.a)paramb;
              kotlin.g.b.p.h(paramb, "event");
              paramb = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
            } while (paramb == null);
            paramb.vgr = 1;
            return;
            localObject1 = this.vdR;
            localObject2 = (c.a)paramb;
            kotlin.g.b.p.h(localObject2, "event");
            paramb = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(((c.a)localObject2).feedId));
          } while (paramb == null);
          if (paramb.wij == 0L)
          {
            paramb.wij = (((com.tencent.mm.plugin.finder.event.base.b)localObject2).tHW - paramb.njx);
            if (paramb.wij > paramb.wih) {
              paramb.wij -= paramb.wih;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whG;
            l = paramb.wij;
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).wiN = l;
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).wiM = (l + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).wiM);
            ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count += 1;
            f = 1.0F * (float)((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).wiM / ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count;
            Log.i(((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).TAG, "count:" + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).count + " current:" + ((com.tencent.mm.plugin.finder.video.statistics.a)localObject1).wiN + ",  average:" + f);
          }
          if (paramb.whU == 0L) {
            paramb.whU = ((c.a)localObject2).tHR;
          }
          localObject1 = ((c.a)localObject2).tHM;
          if (localObject1 != null)
          {
            localObject1 = ((cjl)localObject1).MoZ;
            if (localObject1 == null) {}
          }
          for (int i = ((FinderMediaReportObject)localObject1).playDecoderType;; i = 0)
          {
            paramb.playDecoderType = i;
            localObject1 = new StringBuilder();
            kotlin.g.b.p.g(paramb, "this");
            Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onFirstFrameUpdate", paramb) + " firstFrameTime:" + paramb.wij + " firstLoadTime:" + paramb.whU + " playDecoderType=" + paramb.playDecoderType);
            return;
          }
          localObject1 = this.vdR;
          paramb = (c.a)paramb;
          kotlin.g.b.p.h(paramb, "event");
          localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
        } while (localObject1 == null);
        if (((b.b)localObject1).veh == 0L)
        {
          ((b.b)localObject1).veh = (paramb.tHW - ((b.b)localObject1).njx);
          if (((b.b)localObject1).veh > ((b.b)localObject1).wih) {
            ((b.b)localObject1).veh -= ((b.b)localObject1).wih;
          }
        }
        paramb = new StringBuilder();
        kotlin.g.b.p.g(localObject1, "this");
        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onFirstVideoFrameRendered", (b.b)localObject1) + " firstVideoFrameRendered:" + ((b.b)localObject1).veh);
        return;
        localObject1 = this.vdR;
        paramb = (c.a)paramb;
        kotlin.g.b.p.h(paramb, "event");
        paramb = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
      } while (paramb == null);
      paramb.vgq = 1;
      return;
      localObject1 = this.vdR;
      paramb = (c.a)paramb;
      kotlin.g.b.p.h(paramb, "event");
      localObject1 = (b.b)((com.tencent.mm.plugin.finder.video.reporter.b)localObject1).whF.get(Long.valueOf(paramb.feedId));
    } while (localObject1 == null);
    label391:
    label580:
    label585:
    label590:
    label992:
    ((b.b)localObject1).wiC = paramb.ret;
    label942:
    label1215:
    label1357:
    paramb = new StringBuilder();
    label1339:
    label1597:
    kotlin.g.b.p.g(localObject1, "this");
    label1557:
    label1562:
    label1568:
    label1585:
    label1592:
    Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onPlayError", (b.b)localObject1) + " playerErrCode:" + ((b.b)localObject1).wiC);
    label2059:
  }
  
  public boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    kotlin.g.b.p.h(paramc, "dispatcher");
    kotlin.g.b.p.h(paramb, "event");
    return (paramb instanceof c.a);
  }
  
  public final void d(bbn parambbn)
  {
    kotlin.g.b.p.h(parambbn, "contextObj");
    this.ttO = parambbn;
    this.vdR.d(parambbn);
  }
  
  public void dnL() {}
  
  public LinkedList<ecq> dnM()
  {
    return new LinkedList();
  }
  
  public final bbn getContextObj()
  {
    return this.ttO;
  }
  
  public void onInvisible()
  {
    this.visible = false;
  }
  
  public void onRelease()
  {
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    com.tencent.mm.ac.d.c(FinderReporterUIC.dIB(), (kotlin.g.a.a)new d(this));
  }
  
  public void onVisible()
  {
    this.visible = true;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$Companion;", "", "()V", "KV_VERSION", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "buildJson", "Lorg/json/JSONObject;", "actionType", "values", "", "(I[Ljava/lang/String;)Lorg/json/JSONObject;", "maps", "", "report18054", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "actionValue", "actionTime", "megaVideoItem", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "report19259", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "exposeType", "report19997", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "report20027", "report21140", "contextId", "extraInfo", "sourceFeedId", "sourceUserName", "plugin-finder_release"})
  public static final class a
  {
    public static JSONObject a(int paramInt, String... paramVarArgs)
    {
      AppMethodBeat.i(250541);
      kotlin.g.b.p.h(paramVarArgs, "values");
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(250541);
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
    
    public static void a(bbn parambbn, long paramLong1, int paramInt, String paramString, long paramLong2, bm parambm)
    {
      AppMethodBeat.i(250539);
      kotlin.g.b.p.h(parambbn, "contextObj");
      kotlin.g.b.p.h(paramString, "actionValue");
      Object localObject = y.vXH;
      if (!y.Gj(paramLong1))
      {
        Log.i(e.access$getTAG$cp(), "feedId:" + paramLong1 + " is loacl fake feed,not report 18054");
        AppMethodBeat.o(250539);
        return;
      }
      com.tencent.mm.g.b.a.bw localbw = new com.tencent.mm.g.b.a.bw();
      localbw.ko(com.tencent.mm.ac.d.zs(paramLong1));
      localbw.eR(parambbn.tCE);
      localbw.jY(paramInt);
      localbw.kp(n.j(paramString, ",", ";", false));
      if (BuildInfo.DEBUG)
      {
        paramInt = 0;
        localbw.jZ(paramInt);
        localbw.eP(paramLong2);
        localbw.kq(parambbn.sessionId);
        if (parambm == null) {
          break label572;
        }
        localbw.ka(4);
        paramString = k.vfA;
        paramString = k.H(parambm.lT(), parambbn.tCE);
        if (paramString != null)
        {
          localObject = n.j(paramString, ",", ";", false);
          paramString = (String)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramString = "";
        }
        localbw.kr(paramString);
        paramString = parambm.tuP;
        if (paramString == null) {
          break label567;
        }
        paramString = paramString.MtG;
        if (paramString == null) {
          break label567;
        }
        paramString = paramString.media;
        if (paramString == null) {
          break label567;
        }
        paramString = (cod)kotlin.a.j.kt((List)paramString);
        if (paramString == null) {
          break label567;
        }
        paramInt = paramString.Mur;
        label278:
        localbw.eQ(paramInt);
        localbw.ky(com.tencent.mm.ac.d.zs(parambm.lT()));
        label300:
        paramString = k.vfA;
        paramString = k.G(paramLong1, parambbn.tCE);
        if (paramString != null)
        {
          parambm = n.j(paramString, ",", ";", false);
          paramString = parambm;
          if (parambm != null) {}
        }
        else
        {
          paramString = "";
        }
        localbw.kr(paramString);
        localbw.ks(com.tencent.mm.ac.d.zs(parambbn.wyW));
        parambm = parambbn.wyX;
        paramString = parambm;
        if (parambm == null) {
          paramString = "";
        }
        localbw.kt(paramString);
        localbw.ku(parambbn.sGE);
        localbw.kv(parambbn.sGQ);
        paramString = parambbn.extraInfo;
        if (paramString != null)
        {
          parambm = n.j(paramString, ",", ";", false);
          paramString = parambm;
          if (parambm != null) {}
        }
        else
        {
          paramString = "";
        }
        localbw.kw(paramString);
        paramString = parambbn.sGH;
        if (paramString != null)
        {
          parambm = n.j(paramString, ",", ";", false);
          paramString = parambm;
          if (parambm != null) {}
        }
        else
        {
          paramString = "";
        }
        localbw.kx(paramString);
        paramString = y.vXH;
        parambm = k.vfA;
        if (!y.a(paramString, k.Kx(parambbn.tCE), 0, 2)) {
          break label645;
        }
      }
      label645:
      for (paramLong1 = 1L;; paramLong1 = 0L)
      {
        localbw.eS(paramLong1);
        localbw.eOp();
        parambbn = k.vfA;
        k.a((com.tencent.mm.plugin.report.a)localbw);
        AppMethodBeat.o(250539);
        return;
        paramInt = 43;
        break;
        label567:
        paramInt = 0;
        break label278;
        label572:
        paramString = k.vfA;
        paramString = k.Fc(paramLong1);
        if (paramString == null) {
          break label300;
        }
        localbw.ka(paramString.getMediaType());
        paramString = (cjl)kotlin.a.j.kt((List)paramString.getMediaList());
        if (paramString != null) {}
        for (paramLong2 = paramString.videoDuration;; paramLong2 = 0L)
        {
          localbw.eQ(paramLong2);
          break;
        }
      }
    }
    
    public static void a(bbn parambbn, p paramp)
    {
      AppMethodBeat.i(250544);
      kotlin.g.b.p.h(parambbn, "contextObj");
      kotlin.g.b.p.h(paramp, "record");
      ce localce = new ce();
      localce.ll(parambbn.sessionId);
      localce.lm(parambbn.sGQ);
      localce.ln(parambbn.sGE);
      localce.fF(parambbn.tCE);
      localce.lo(com.tencent.mm.ac.d.zs(paramp.feedId));
      parambbn = paramp.tHo;
      long l1;
      Object localObject1;
      label150:
      long l2;
      if (parambbn != null)
      {
        parambbn = parambbn.getFoldedLayout();
        if (parambbn != null)
        {
          l1 = parambbn.gAZ;
          localce.fG(l1);
          parambbn = paramp.tHo;
          if (parambbn != null)
          {
            parambbn = parambbn.getFoldedLayout();
            if (parambbn != null)
            {
              localObject1 = parambbn.username;
              parambbn = (bbn)localObject1;
              if (localObject1 != null) {
                break label150;
              }
            }
          }
          parambbn = "";
          localce.lp(parambbn);
          localce.lq("");
          l2 = 0L;
          parambbn = FinderFoldedScrollLayout.wmQ;
          if (FinderFoldedScrollLayout.dGK() == 0L) {
            break label411;
          }
          parambbn = FinderFoldedScrollLayout.wmQ;
          localce.fI(FinderFoldedScrollLayout.dGK());
          l1 = 0L;
        }
      }
      for (;;)
      {
        label196:
        parambbn = paramp.tHo;
        if (parambbn != null)
        {
          parambbn = parambbn.getFoldedLayout();
          if (parambbn != null)
          {
            parambbn = parambbn.LCW;
            if (parambbn != null)
            {
              localObject1 = ((Iterable)parambbn).iterator();
              int i = 0;
              for (;;)
              {
                label236:
                if (!((Iterator)localObject1).hasNext()) {
                  break label694;
                }
                parambbn = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  kotlin.a.j.hxH();
                }
                Object localObject2 = (FinderObject)parambbn;
                parambbn = paramp.tIw;
                if (parambbn != null)
                {
                  parambbn = parambbn.Rrh;
                  if (parambbn != null) {
                    parambbn = (com.tencent.mm.view.recyclerview.k)parambbn.get(((FinderObject)localObject2).id);
                  }
                }
                for (;;)
                {
                  if (parambbn != null)
                  {
                    if (l2 == parambbn.Rrp.lT())
                    {
                      localObject2 = localce.ada();
                      localce.lq((String)localObject2 + com.tencent.mm.ac.d.zs(parambbn.Rrp.lT()) + ';' + i + ';' + parambbn.Rrq + ';' + l1 + '#');
                      i = j;
                      break label236;
                      l1 = 0L;
                      break;
                      label411:
                      parambbn = FinderFoldedScrollLayout.wmQ;
                      if (FinderFoldedScrollLayout.dGL() != 0L)
                      {
                        parambbn = FinderFoldedScrollLayout.wmQ;
                        localce.fH(FinderFoldedScrollLayout.dGL());
                        l1 = 0L;
                        break label196;
                      }
                      parambbn = FinderFoldedScrollLayout.wmQ;
                      if (FinderFoldedScrollLayout.dGN() == 0L) {
                        break label751;
                      }
                      parambbn = FinderFoldedScrollLayout.wmQ;
                      l2 = FinderFoldedScrollLayout.dGM();
                      parambbn = FinderFoldedScrollLayout.wmQ;
                      l1 = FinderFoldedScrollLayout.dGN();
                      break label196;
                      parambbn = null;
                      continue;
                    }
                    localObject2 = localce.ada();
                    localce.lq((String)localObject2 + com.tencent.mm.ac.d.zs(parambbn.Rrp.lT()) + ';' + i + ';' + parambbn.Rrq + ";0#");
                    i = j;
                    break label236;
                  }
                }
                parambbn = e.vdS;
                if (l2 == ((FinderObject)localObject2).id)
                {
                  parambbn = localce.ada();
                  localce.lq(parambbn + com.tencent.mm.ac.d.zs(((FinderObject)localObject2).id) + ';' + i + ";0;" + l1 + '#');
                  i = j;
                }
                else
                {
                  parambbn = localce.ada();
                  localce.lq(parambbn + com.tencent.mm.ac.d.zs(((FinderObject)localObject2).id) + ';' + i + ";0;0#");
                  i = j;
                }
              }
            }
          }
        }
        label694:
        parambbn = FinderFoldedScrollLayout.wmQ;
        FinderFoldedScrollLayout.Gu(0L);
        parambbn = FinderFoldedScrollLayout.wmQ;
        FinderFoldedScrollLayout.Gx(0L);
        parambbn = FinderFoldedScrollLayout.wmQ;
        FinderFoldedScrollLayout.Gw(0L);
        parambbn = FinderFoldedScrollLayout.wmQ;
        FinderFoldedScrollLayout.Gv(0L);
        localce.eOp();
        parambbn = k.vfA;
        k.a((com.tencent.mm.plugin.report.a)localce);
        AppMethodBeat.o(250544);
        return;
        label751:
        l1 = 0L;
      }
    }
    
    public static void a(bbn parambbn, p paramp, int paramInt)
    {
      long l2 = 0L;
      AppMethodBeat.i(250543);
      kotlin.g.b.p.h(parambbn, "contextObj");
      kotlin.g.b.p.h(paramp, "record");
      FinderItem localFinderItem = paramp.tHo;
      if (localFinderItem != null)
      {
        cj localcj = new cj();
        localcj.lO(com.tencent.mm.ac.d.zs(localFinderItem.getId()));
        localcj.fY(localFinderItem.getMediaType());
        localcj.lP(parambbn.sessionId);
        localcj.gm(parambbn.tCE);
        localcj.fZ(paramp.uOV);
        localcj.ga(localFinderItem.getLikeCount());
        localcj.gb(localFinderItem.getCommentCount());
        Object localObject1 = w.vXp;
        localcj.lQ(n.j(w.z(localFinderItem), ",", ";", false));
        Object localObject2 = localFinderItem.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localcj.lR((String)localObject1);
        long l1;
        if (kotlin.g.b.p.j(localFinderItem.getUserName(), z.aUg()))
        {
          l1 = 1L;
          localcj.gc(l1);
          localcj.gd(localFinderItem.getCreateTime());
          if ((localFinderItem.getLocation().latitude > 0.0F) && (localFinderItem.getLocation().dTj > 0.0F)) {
            localcj.adg();
          }
          localcj.ge(localFinderItem.getMediaList().size());
          if ((localFinderItem.getMediaType() == 4) && (localFinderItem.getMediaList().size() > 0)) {
            localcj.gf(((cjl)localFinderItem.getMediaList().get(0)).videoDuration);
          }
          localcj.gg(paramp.endTime - paramp.startTime);
          if (!BuildInfo.DEBUG) {
            break label717;
          }
          l1 = l2;
          label326:
          localcj.gh(l1);
          localcj.gi(localFinderItem.getFeedObject().recommendType);
          localcj.lS(localFinderItem.getUserName());
          localcj.gj(localFinderItem.getFeedObject().orgRecommendType);
          localObject2 = localFinderItem.getFeedObject().warnWording;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcj.lT((String)localObject1);
          localcj.gk(localFinderItem.getFeedObject().warnFlag);
          localcj.gl(paramInt);
          localObject2 = parambbn.sGQ;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcj.lU((String)localObject1);
          localcj.lV(com.tencent.mm.ac.d.zs(parambbn.wyW));
          localObject2 = parambbn.wyX;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcj.lW((String)localObject1);
          localObject2 = parambbn.sGE;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcj.lX((String)localObject1);
          localcj.gn(paramp.vfP);
          paramp = k.vfA;
          localcj.go(k.Kt(parambbn.tCE));
          paramp = k.vfA;
          localcj.lY(k.G(localFinderItem.getId(), parambbn.tCE));
          parambbn = com.tencent.mm.plugin.finder.upload.action.j.vUw;
          parambbn = com.tencent.mm.plugin.finder.upload.action.j.dBt().p(localFinderItem.getFeedObject());
          localcj.gp(parambbn.size());
          if (parambbn.size() <= 3) {
            break label724;
          }
          localcj.gq(3L);
        }
        for (;;)
        {
          localcj.lZ("");
          parambbn = ((Iterable)parambbn).iterator();
          paramInt = 0;
          while (parambbn.hasNext())
          {
            paramp = parambbn.next();
            if (paramInt < 0) {
              kotlin.a.j.hxH();
            }
            paramp = (FinderCommentInfo)paramp;
            if (paramInt <= 2) {
              localcj.lZ(localcj.adh() + paramp.username + '|');
            }
            paramInt += 1;
          }
          l1 = 0L;
          break;
          label717:
          l1 = 5L;
          break label326;
          label724:
          localcj.gq(parambbn.size());
        }
        localcj.gr(localFinderItem.getFeedObject().commentList.size());
        parambbn = localFinderItem.getFeedObject().commentList;
        kotlin.g.b.p.g(parambbn, "it.feedObject.commentList");
        parambbn = (FinderCommentInfo)kotlin.a.j.kt((List)parambbn);
        if (parambbn != null)
        {
          paramp = parambbn.username;
          parambbn = paramp;
          if (paramp != null) {}
        }
        else
        {
          parambbn = "";
        }
        localcj.ma(parambbn);
        parambbn = y.vXH;
        if (y.B(localFinderItem)) {
          localcj.gs(localFinderItem.getFeedObject().incFriendLikeCount);
        }
        parambbn = localFinderItem.getFeedObject().commentList;
        kotlin.g.b.p.g(parambbn, "it.feedObject.commentList");
        paramp = (Iterable)parambbn;
        parambbn = (Collection)new ArrayList();
        paramp = paramp.iterator();
        while (paramp.hasNext())
        {
          localObject1 = paramp.next();
          localObject2 = (FinderCommentInfo)localObject1;
          if (((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).isFriend(((FinderCommentInfo)localObject2).username)) {
            parambbn.add(localObject1);
          }
        }
        localcj.gt(((List)parambbn).size());
        localcj.gu(localFinderItem.getFeedObject().commentList.size());
        localcj.eOp();
        parambbn = k.vfA;
        k.a((com.tencent.mm.plugin.report.a)localcj);
        AppMethodBeat.o(250543);
        return;
      }
      AppMethodBeat.o(250543);
    }
    
    public static String ah(Map<String, ? extends Object> paramMap)
    {
      AppMethodBeat.i(250542);
      kotlin.g.b.p.h(paramMap, "maps");
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
      kotlin.g.b.p.g(paramMap, "json.toString()");
      paramMap = n.j(paramMap, ",", ";", false);
      AppMethodBeat.o(250542);
      return paramMap;
    }
    
    public static void o(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(250545);
      ck localck = new ck();
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      localck.mb(str);
      if (paramString2 != null)
      {
        paramString2 = n.j(paramString2, ",", ";", false);
        paramString1 = paramString2;
        if (paramString2 != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localck.mc(paramString1);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      localck.md(paramString1);
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      localck.me(paramString1);
      localck.bfK();
      AppMethodBeat.o(250545);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$ExtStatsRecord;", "", "()V", "isReceivedMsg", "", "()Z", "setReceivedMsg", "(Z)V", "isRingUp", "setRingUp", "reset", "", "plugin-finder_release"})
  public static final class b
  {
    boolean vdU;
    boolean vdV;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT;", "", "()V", "Companion", "plugin-finder_release"})
  public static final class c
  {
    private static final String vdW = "1";
    public static final a vdX;
    
    static
    {
      AppMethodBeat.i(250546);
      vdX = new a((byte)0);
      vdW = "1";
      AppMethodBeat.o(250546);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter$INPUT_RESULT$Companion;", "", "()V", "CLICK", "", "getCLICK", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e
 * JD-Core Version:    0.7.0.1
 */