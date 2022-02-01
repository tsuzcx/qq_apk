package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.b.k;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "objectNonceId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "mediaList", "Ljava/util/LinkedList;", "onMoovReady", "onPause", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "position", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
public final class b$c
  implements b.b
{
  public final void a(long paramLong, bqs parambqs, int paramInt)
  {
    AppMethodBeat.i(210184);
    b.a locala = new b.a(18);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.ret = paramInt;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(210184);
  }
  
  public final void a(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201404);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(3);
    locala.offset = paramInt1;
    locala.hLN = paramInt2;
    locala.rcZ = paraml;
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201404);
  }
  
  public final void a(long paramLong, String paramString, bqs parambqs, int paramInt, d paramd, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201393);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(14);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.ret = paramInt;
    locala.rcZ = paraml;
    locala.gdm = paramd;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201393);
  }
  
  public final void a(long paramLong, String paramString, bqs parambqs, h paramh, d paramd, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201392);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(15);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.gdm = paramd;
    locala.rcZ = paraml;
    locala.hYP = paramh;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201392);
  }
  
  public final void a(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201390);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(17);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201390);
  }
  
  public final void a(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, int paramInt, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201403);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(4);
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.mediaList = paramLinkedList;
    locala.setObjectNonceId(paramString);
    locala.position = paramInt;
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201403);
  }
  
  public final void a(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201406);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(1);
    locala.rcY = parambqs;
    locala.rcZ = paraml;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.mediaList = paramLinkedList;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201406);
  }
  
  public final void b(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201399);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(7);
    locala.offset = paramInt1;
    locala.hLN = paramInt2;
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201399);
  }
  
  public final void b(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201401);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(9);
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201401);
  }
  
  public final void b(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201396);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(11);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.mediaList = paramLinkedList;
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201396);
  }
  
  public final void c(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201398);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(8);
    locala.offset = paramInt1;
    locala.hLN = paramInt2;
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201398);
  }
  
  public final void c(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201402);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(5);
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201402);
  }
  
  public final void c(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201395);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(12);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    locala.mediaList = paramLinkedList;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201395);
  }
  
  public final void d(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201397);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(10);
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    locala.rda = paramInt1;
    locala.rdb = paramInt2;
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201397);
  }
  
  public final void d(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201405);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(2);
    locala.dig = paramLong;
    locala.rcZ = paraml;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201405);
  }
  
  public final void e(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201394);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(13);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.offset = paramInt1;
    locala.rcZ = paraml;
    locala.hLN = paramInt2;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201394);
  }
  
  public final void e(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201400);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(6);
    locala.dig = paramLong;
    locala.rcY = parambqs;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201400);
  }
  
  public final void f(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(201391);
    k.h(paramString, "objectNonceId");
    k.h(paraml, "video");
    b.a locala = new b.a(16);
    locala.rcY = parambqs;
    locala.dig = paramLong;
    locala.setObjectNonceId(paramString);
    locala.rcZ = paraml;
    this.rdd.c((com.tencent.mm.plugin.finder.event.base.b)locala);
    AppMethodBeat.o(201391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b.c
 * JD-Core Version:    0.7.0.1
 */