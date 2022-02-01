package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "videoTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$c
  implements c.b
{
  public c$c(c paramc) {}
  
  public final void a(long paramLong, dji paramdji, int paramInt)
  {
    AppMethodBeat.i(330403);
    c.a locala = new c.a(18);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.ret = paramInt;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330403);
  }
  
  public final void a(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(330377);
    s.u(paramx, "video");
    c.a locala = new c.a(3);
    locala.offset = paramInt1;
    locala.total = paramInt2;
    locala.ANK = paramx;
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330377);
  }
  
  public final void a(long paramLong, dji paramdji, int paramInt, com.tencent.mm.g.d paramd, x paramx)
  {
    AppMethodBeat.i(330312);
    s.u(paramx, "video");
    c.a locala = new c.a(14);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.ret = paramInt;
    locala.ANK = paramx;
    locala.mxU = paramd;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330312);
  }
  
  public final void a(long paramLong, dji paramdji, h paramh, com.tencent.mm.g.d paramd, x paramx)
  {
    AppMethodBeat.i(330306);
    s.u(paramx, "video");
    c.a locala = new c.a(15);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.mxU = paramd;
    locala.ANK = paramx;
    locala.oYO = paramh;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330306);
  }
  
  public final void a(long paramLong, dji paramdji, x paramx)
  {
    AppMethodBeat.i(330297);
    s.u(paramx, "video");
    c.a locala = new c.a(17);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330297);
  }
  
  public final void a(long paramLong1, dji paramdji, x paramx, long paramLong2)
  {
    AppMethodBeat.i(330320);
    s.u(paramx, "video");
    c.a locala = new c.a(12);
    locala.ANJ = paramdji;
    locala.feedId = paramLong1;
    locala.ANK = paramx;
    locala.ANN = paramLong2;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330320);
  }
  
  public final void a(long paramLong, dji paramdji, x paramx, com.tencent.mm.plugin.finder.video.reporter.d paramd)
  {
    AppMethodBeat.i(330351);
    s.u(paramx, "video");
    c.a locala = new c.a(6);
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    locala.ANP = paramd;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330351);
  }
  
  public final void a(long paramLong, dji paramdji, x paramx, a parama)
  {
    AppMethodBeat.i(330325);
    s.u(paramx, "video");
    c.a locala = new c.a(19);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.ANK = paramx;
    locala.ANN = 0L;
    locala.ANQ = parama;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330325);
  }
  
  public final void a(long paramLong, dji paramdji, v paramv, int paramInt1, x paramx, int paramInt2)
  {
    AppMethodBeat.i(330369);
    s.u(paramx, "video");
    c.a locala = new c.a(4);
    locala.ANI = paramv;
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.position = paramInt1;
    locala.ANK = paramx;
    locala.ANM = paramInt2;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330369);
  }
  
  public final void a(long paramLong, dji paramdji, LinkedList<dji> paramLinkedList, x paramx)
  {
    AppMethodBeat.i(330392);
    s.u(paramx, "video");
    c.a locala = new c.a(1);
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    locala.feedId = paramLong;
    locala.mediaList = paramLinkedList;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330392);
  }
  
  public final void a(long paramLong, dji paramdji, LinkedList<dji> paramLinkedList, x paramx, com.tencent.mm.plugin.finder.video.reporter.d paramd)
  {
    AppMethodBeat.i(330333);
    s.u(paramx, "video");
    c.a locala = new c.a(11);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.mediaList = paramLinkedList;
    locala.ANK = paramx;
    locala.ANP = paramd;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330333);
  }
  
  public final void a(long paramLong, dji paramdji, LinkedList<dji> paramLinkedList, x paramx, e parame)
  {
    AppMethodBeat.i(330398);
    s.u(paramx, "video");
    c.a locala = new c.a(20);
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    locala.feedId = paramLong;
    locala.mediaList = paramLinkedList;
    locala.ANO = parame;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330398);
  }
  
  public final void b(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(330347);
    s.u(paramx, "video");
    c.a locala = new c.a(7);
    locala.offset = paramInt1;
    locala.total = paramInt2;
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330347);
  }
  
  public final void b(long paramLong, dji paramdji, x paramx)
  {
    AppMethodBeat.i(330356);
    s.u(paramx, "video");
    c.a locala = new c.a(9);
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330356);
  }
  
  public final void c(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(330341);
    s.u(paramx, "video");
    c.a locala = new c.a(8);
    locala.offset = paramInt1;
    locala.total = paramInt2;
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330341);
  }
  
  public final void c(long paramLong, dji paramdji, x paramx)
  {
    AppMethodBeat.i(330362);
    s.u(paramx, "video");
    c.a locala = new c.a(5);
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330362);
  }
  
  public final void d(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(330338);
    s.u(paramx, "video");
    c.a locala = new c.a(10);
    locala.feedId = paramLong;
    locala.ANJ = paramdji;
    locala.ANL = paramInt1;
    locala.hKX = paramInt2;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330338);
  }
  
  public final void d(long paramLong, dji paramdji, x paramx)
  {
    AppMethodBeat.i(330385);
    s.u(paramx, "video");
    c.a locala = new c.a(2);
    locala.feedId = paramLong;
    locala.ANK = paramx;
    locala.ANJ = paramdji;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330385);
  }
  
  public final void e(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(330315);
    s.u(paramx, "video");
    c.a locala = new c.a(13);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.offset = paramInt1;
    locala.ANK = paramx;
    locala.total = paramInt2;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330315);
  }
  
  public final void e(long paramLong, dji paramdji, x paramx)
  {
    AppMethodBeat.i(330300);
    s.u(paramx, "video");
    c.a locala = new c.a(16);
    locala.ANJ = paramdji;
    locala.feedId = paramLong;
    locala.ANK = paramx;
    this.ANR.c((b)locala);
    AppMethodBeat.o(330300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.c
 * JD-Core Version:    0.7.0.1
 */