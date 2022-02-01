package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "VideoPlayBehavior", "plugin-finder_release"})
public final class c
  extends e<b>
{
  public c(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    super(paramc);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "()I", "setBgPreparedStatus", "currentSec", "getCurrentSec", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaSource", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaSource", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "getPlayerConfig", "()Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "setPlayerConfig", "(Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;)V", "position", "getPosition", "setPosition", "prepareCostTime", "getPrepareCostTime", "setPrepareCostTime", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class a
    extends b
  {
    public static final a tHT;
    public long feedId;
    public d hmq;
    public int jcu;
    public h jqr;
    LinkedList<cjl> mediaList;
    private String objectNonceId;
    public int offset;
    public int position;
    public int ret;
    public com.tencent.mm.plugin.finder.video.s tHL;
    public cjl tHM;
    public com.tencent.mm.plugin.finder.loader.s tHN;
    public int tHO;
    public int tHP;
    public int tHQ;
    public long tHR;
    public com.tencent.mm.plugin.finder.video.reporter.c tHS;
    public final int type;
    
    static
    {
      AppMethodBeat.i(165517);
      tHT = new a((byte)0);
      AppMethodBeat.o(165517);
    }
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.objectNonceId = "";
    }
    
    public final int dam()
    {
      return this.tHO;
    }
    
    public final int dan()
    {
      return this.tHP;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.type != paramObject.type) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final long getFeedId()
    {
      return this.feedId;
    }
    
    public final int getOffset()
    {
      return this.offset;
    }
    
    public final int hashCode()
    {
      return this.type;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(165516);
      StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.tHM).append(", mediaId=");
      Object localObject1 = this.tHM;
      if (localObject1 != null)
      {
        localObject2 = ((cjl)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.jcu).append(", feedId=").append(this.feedId).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
      localObject1 = this.mediaList;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ')';
        AppMethodBeat.o(165516);
        return localObject1;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent$Companion;", "", "()V", "VIDEO_CHECK_VIDEO_DATA_AVAILABLE", "", "VIDEO_CLICK_PAUSE", "VIDEO_DOWNLOAD_FINISH", "VIDEO_DOWNLOAD_PROGRESS", "VIDEO_DOWNLOAD_START", "VIDEO_DOWNLOAD_STOP", "VIDEO_FIRST_FRAME", "VIDEO_FIRST_FRAME_RENDERED", "VIDEO_MOOV_READY", "VIDEO_PAUSE", "VIDEO_PLAYER_CONFIG", "VIDEO_PLAY_ERROR", "VIDEO_PROGRESS", "VIDEO_REAL_PLAY", "VIDEO_REPLAY", "VIDEO_SEEK", "VIDEO_START_PLAY", "VIDEO_STOP_PLAY", "VIDEO_WAITING", "VIDEO_WAITING_END", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, cjl paramcjl, int paramInt);
    
    public abstract void a(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void a(long paramLong, cjl paramcjl, int paramInt, d paramd, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void a(long paramLong, cjl paramcjl, h paramh, d paramd, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void a(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void a(long paramLong1, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params, long paramLong2);
    
    public abstract void a(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.video.s params, int paramInt1, com.tencent.mm.plugin.finder.loader.s params1, int paramInt2);
    
    public abstract void a(long paramLong, cjl paramcjl, LinkedList<cjl> paramLinkedList, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void a(long paramLong, cjl paramcjl, LinkedList<cjl> paramLinkedList, com.tencent.mm.plugin.finder.loader.s params, com.tencent.mm.plugin.finder.video.reporter.c paramc);
    
    public abstract void b(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void b(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void b(long paramLong, cjl paramcjl, LinkedList<cjl> paramLinkedList, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void c(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void c(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void d(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void d(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void e(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void e(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void f(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
    
    public abstract void g(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static final class c
    implements c.b
  {
    public final void a(long paramLong, cjl paramcjl, int paramInt)
    {
      AppMethodBeat.i(243446);
      c.a locala = new c.a(18);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.ret = paramInt;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243446);
    }
    
    public final void a(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243442);
      p.h(params, "video");
      c.a locala = new c.a(3);
      locala.offset = paramInt1;
      locala.jcu = paramInt2;
      locala.tHN = params;
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243442);
    }
    
    public final void a(long paramLong, cjl paramcjl, int paramInt, d paramd, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243430);
      p.h(params, "video");
      c.a locala = new c.a(14);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.ret = paramInt;
      locala.tHN = params;
      locala.hmq = paramd;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243430);
    }
    
    public final void a(long paramLong, cjl paramcjl, h paramh, d paramd, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243429);
      p.h(params, "video");
      c.a locala = new c.a(15);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.hmq = paramd;
      locala.tHN = params;
      locala.jqr = paramh;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243429);
    }
    
    public final void a(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243427);
      p.h(params, "video");
      c.a locala = new c.a(17);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243427);
    }
    
    public final void a(long paramLong1, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params, long paramLong2)
    {
      AppMethodBeat.i(243432);
      p.h(params, "video");
      c.a locala = new c.a(12);
      locala.tHM = paramcjl;
      locala.feedId = paramLong1;
      locala.tHN = params;
      locala.tHR = paramLong2;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243432);
    }
    
    public final void a(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.video.s params, int paramInt1, com.tencent.mm.plugin.finder.loader.s params1, int paramInt2)
    {
      AppMethodBeat.i(243441);
      p.h(params1, "video");
      c.a locala = new c.a(4);
      locala.tHL = params;
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.position = paramInt1;
      locala.tHN = params1;
      locala.tHQ = paramInt2;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243441);
    }
    
    public final void a(long paramLong, cjl paramcjl, LinkedList<cjl> paramLinkedList, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243444);
      p.h(params, "video");
      c.a locala = new c.a(1);
      locala.tHM = paramcjl;
      locala.tHN = params;
      locala.feedId = paramLong;
      locala.mediaList = paramLinkedList;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243444);
    }
    
    public final void a(long paramLong, cjl paramcjl, LinkedList<cjl> paramLinkedList, com.tencent.mm.plugin.finder.loader.s params, com.tencent.mm.plugin.finder.video.reporter.c paramc)
    {
      AppMethodBeat.i(243445);
      p.h(params, "video");
      c.a locala = new c.a(20);
      locala.tHM = paramcjl;
      locala.tHN = params;
      locala.feedId = paramLong;
      locala.mediaList = paramLinkedList;
      locala.tHS = paramc;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243445);
    }
    
    public final void b(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243437);
      p.h(params, "video");
      c.a locala = new c.a(7);
      locala.offset = paramInt1;
      locala.jcu = paramInt2;
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243437);
    }
    
    public final void b(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243439);
      p.h(params, "video");
      c.a locala = new c.a(9);
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243439);
    }
    
    public final void b(long paramLong, cjl paramcjl, LinkedList<cjl> paramLinkedList, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243434);
      p.h(params, "video");
      c.a locala = new c.a(11);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.mediaList = paramLinkedList;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243434);
    }
    
    public final void c(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243436);
      p.h(params, "video");
      c.a locala = new c.a(8);
      locala.offset = paramInt1;
      locala.jcu = paramInt2;
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243436);
    }
    
    public final void c(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243440);
      p.h(params, "video");
      c.a locala = new c.a(5);
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243440);
    }
    
    public final void d(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243435);
      p.h(params, "video");
      c.a locala = new c.a(10);
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.tHO = paramInt1;
      locala.tHP = paramInt2;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243435);
    }
    
    public final void d(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243443);
      p.h(params, "video");
      c.a locala = new c.a(2);
      locala.feedId = paramLong;
      locala.tHN = params;
      locala.tHM = paramcjl;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243443);
    }
    
    public final void e(long paramLong, cjl paramcjl, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243431);
      p.h(params, "video");
      c.a locala = new c.a(13);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.offset = paramInt1;
      locala.tHN = params;
      locala.jcu = paramInt2;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243431);
    }
    
    public final void e(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243438);
      p.h(params, "video");
      c.a locala = new c.a(6);
      locala.feedId = paramLong;
      locala.tHM = paramcjl;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243438);
    }
    
    public final void f(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243428);
      p.h(params, "video");
      c.a locala = new c.a(16);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.tHN = params;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243428);
    }
    
    public final void g(long paramLong, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(243433);
      p.h(params, "video");
      c.a locala = new c.a(19);
      locala.tHM = paramcjl;
      locala.feedId = paramLong;
      locala.tHN = params;
      locala.tHR = 0L;
      this.tHU.c((b)locala);
      AppMethodBeat.o(243433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c
 * JD-Core Version:    0.7.0.1
 */