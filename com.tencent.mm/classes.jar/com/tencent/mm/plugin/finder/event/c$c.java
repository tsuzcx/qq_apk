package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.reporter.f;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.protocal.protobuf.csg;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder-base_release"})
public final class c$c
  implements c.b
{
  public final void a(long paramLong, csg paramcsg, int paramInt)
  {
    AppMethodBeat.i(258471);
    c.a locala = new c.a(18);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.ret = paramInt;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258471);
  }
  
  public final void a(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(258466);
    p.k(paramac, "video");
    c.a locala = new c.a(3);
    locala.offset = paramInt1;
    locala.total = paramInt2;
    locala.xqx = paramac;
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258466);
  }
  
  public final void a(long paramLong, csg paramcsg, int paramInt, d paramd, ac paramac)
  {
    AppMethodBeat.i(258453);
    p.k(paramac, "video");
    c.a locala = new c.a(14);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.ret = paramInt;
    locala.xqx = paramac;
    locala.jYa = paramd;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258453);
  }
  
  public final void a(long paramLong, csg paramcsg, h paramh, d paramd, ac paramac)
  {
    AppMethodBeat.i(258452);
    p.k(paramac, "video");
    c.a locala = new c.a(15);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.jYa = paramd;
    locala.xqx = paramac;
    locala.mfS = paramh;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258452);
  }
  
  public final void a(long paramLong, csg paramcsg, ac paramac)
  {
    AppMethodBeat.i(258450);
    p.k(paramac, "video");
    c.a locala = new c.a(17);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258450);
  }
  
  public final void a(long paramLong1, csg paramcsg, ac paramac, long paramLong2)
  {
    AppMethodBeat.i(258455);
    p.k(paramac, "video");
    c.a locala = new c.a(12);
    locala.xqw = paramcsg;
    locala.feedId = paramLong1;
    locala.xqx = paramac;
    locala.xqA = paramLong2;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258455);
  }
  
  public final void a(long paramLong, csg paramcsg, ac paramac, e parame)
  {
    AppMethodBeat.i(258461);
    p.k(paramac, "video");
    c.a locala = new c.a(6);
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    locala.xqC = parame;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258461);
  }
  
  public final void a(long paramLong, csg paramcsg, t paramt, int paramInt1, ac paramac, int paramInt2)
  {
    AppMethodBeat.i(258465);
    p.k(paramac, "video");
    c.a locala = new c.a(4);
    locala.xqv = paramt;
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.position = paramInt1;
    locala.xqx = paramac;
    locala.xqz = paramInt2;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258465);
  }
  
  public final void a(long paramLong, csg paramcsg, LinkedList<csg> paramLinkedList, ac paramac)
  {
    AppMethodBeat.i(258468);
    p.k(paramac, "video");
    c.a locala = new c.a(1);
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    locala.feedId = paramLong;
    locala.mediaList = paramLinkedList;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258468);
  }
  
  public final void a(long paramLong, csg paramcsg, LinkedList<csg> paramLinkedList, ac paramac, e parame)
  {
    AppMethodBeat.i(258457);
    p.k(paramac, "video");
    c.a locala = new c.a(11);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.mediaList = paramLinkedList;
    locala.xqx = paramac;
    locala.xqC = parame;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258457);
  }
  
  public final void a(long paramLong, csg paramcsg, LinkedList<csg> paramLinkedList, ac paramac, f paramf)
  {
    AppMethodBeat.i(258470);
    p.k(paramac, "video");
    c.a locala = new c.a(20);
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    locala.feedId = paramLong;
    locala.mediaList = paramLinkedList;
    locala.xqB = paramf;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258470);
  }
  
  public final void b(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(258460);
    p.k(paramac, "video");
    c.a locala = new c.a(7);
    locala.offset = paramInt1;
    locala.total = paramInt2;
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258460);
  }
  
  public final void b(long paramLong, csg paramcsg, ac paramac)
  {
    AppMethodBeat.i(258462);
    p.k(paramac, "video");
    c.a locala = new c.a(9);
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258462);
  }
  
  public final void c(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(258459);
    p.k(paramac, "video");
    c.a locala = new c.a(8);
    locala.offset = paramInt1;
    locala.total = paramInt2;
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258459);
  }
  
  public final void c(long paramLong, csg paramcsg, ac paramac)
  {
    AppMethodBeat.i(258463);
    p.k(paramac, "video");
    c.a locala = new c.a(5);
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258463);
  }
  
  public final void d(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(258458);
    p.k(paramac, "video");
    c.a locala = new c.a(10);
    locala.feedId = paramLong;
    locala.xqw = paramcsg;
    locala.xqy = paramInt1;
    locala.fFM = paramInt2;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258458);
  }
  
  public final void d(long paramLong, csg paramcsg, ac paramac)
  {
    AppMethodBeat.i(258467);
    p.k(paramac, "video");
    c.a locala = new c.a(2);
    locala.feedId = paramLong;
    locala.xqx = paramac;
    locala.xqw = paramcsg;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258467);
  }
  
  public final void e(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(258454);
    p.k(paramac, "video");
    c.a locala = new c.a(13);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.offset = paramInt1;
    locala.xqx = paramac;
    locala.total = paramInt2;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258454);
  }
  
  public final void e(long paramLong, csg paramcsg, ac paramac)
  {
    AppMethodBeat.i(258451);
    p.k(paramac, "video");
    c.a locala = new c.a(16);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.xqx = paramac;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258451);
  }
  
  public final void f(long paramLong, csg paramcsg, ac paramac)
  {
    AppMethodBeat.i(258456);
    p.k(paramac, "video");
    c.a locala = new c.a(19);
    locala.xqw = paramcsg;
    locala.feedId = paramLong;
    locala.xqx = paramac;
    locala.xqA = 0L;
    this.xqE.c((b)locala);
    AppMethodBeat.o(258456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.c
 * JD-Core Version:    0.7.0.1
 */