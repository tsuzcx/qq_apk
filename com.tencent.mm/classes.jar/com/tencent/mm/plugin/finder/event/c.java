package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.protocal.protobuf.bvz;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "VideoPlayBehavior", "plugin-finder_release"})
public final class c
  extends e<b>
{
  public c(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    super(paramc);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "()I", "setBgPreparedStatus", "currentSec", "getCurrentSec", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "position", "getPosition", "setPosition", "prepareCostTime", "getPrepareCostTime", "setPrepareCostTime", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class a
    extends b
  {
    public static final a rZb;
    public long duw;
    public d gzD;
    public int ihz;
    public h ivf;
    LinkedList<bvz> mediaList;
    private String objectNonceId;
    public int offset;
    public int position;
    public bvz rYV;
    public m rYW;
    public int rYX;
    public int rYY;
    public int rYZ;
    public long rZa;
    public int ret;
    public final int type;
    
    static
    {
      AppMethodBeat.i(165517);
      rZb = new a((byte)0);
      AppMethodBeat.o(165517);
    }
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.objectNonceId = "";
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
    
    public final int hashCode()
    {
      return this.type;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(165516);
      StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.rYV).append(", mediaId=");
      Object localObject1 = this.rYV;
      if (localObject1 != null)
      {
        localObject2 = ((bvz)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.ihz).append(", feedId=").append(this.duw).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
      localObject1 = this.mediaList;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ')';
        AppMethodBeat.o(165516);
        return localObject1;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent$Companion;", "", "()V", "VIDEO_CHECK_VIDEO_DATA_AVAILABLE", "", "VIDEO_CLICK_PAUSE", "VIDEO_DOWNLOAD_FINISH", "VIDEO_DOWNLOAD_PROGRESS", "VIDEO_DOWNLOAD_START", "VIDEO_DOWNLOAD_STOP", "VIDEO_FIRST_FRAME", "VIDEO_MOOV_READY", "VIDEO_PAUSE", "VIDEO_PLAY_ERROR", "VIDEO_PROGRESS", "VIDEO_REAL_PLAY", "VIDEO_REPLAY", "VIDEO_SEEK", "VIDEO_START_PLAY", "VIDEO_STOP_PLAY", "VIDEO_WAITING", "VIDEO_WAITING_END", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, bvz parambvz, int paramInt);
    
    public abstract void a(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm);
    
    public abstract void a(long paramLong, bvz parambvz, int paramInt, d paramd, m paramm);
    
    public abstract void a(long paramLong, bvz parambvz, int paramInt1, m paramm, int paramInt2);
    
    public abstract void a(long paramLong, bvz parambvz, h paramh, d paramd, m paramm);
    
    public abstract void a(long paramLong, bvz parambvz, m paramm);
    
    public abstract void a(long paramLong1, bvz parambvz, m paramm, long paramLong2);
    
    public abstract void a(long paramLong, bvz parambvz, LinkedList<bvz> paramLinkedList, m paramm);
    
    public abstract void b(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm);
    
    public abstract void b(long paramLong, bvz parambvz, m paramm);
    
    public abstract void b(long paramLong, bvz parambvz, LinkedList<bvz> paramLinkedList, m paramm);
    
    public abstract void c(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm);
    
    public abstract void c(long paramLong, bvz parambvz, m paramm);
    
    public abstract void d(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm);
    
    public abstract void d(long paramLong, bvz parambvz, m paramm);
    
    public abstract void e(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm);
    
    public abstract void e(long paramLong, bvz parambvz, m paramm);
    
    public abstract void f(long paramLong, bvz parambvz, m paramm);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static final class c
    implements c.b
  {
    public final void a(long paramLong, bvz parambvz, int paramInt)
    {
      AppMethodBeat.i(201994);
      c.a locala = new c.a(18);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.ret = paramInt;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201994);
    }
    
    public final void a(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201991);
      p.h(paramm, "video");
      c.a locala = new c.a(3);
      locala.offset = paramInt1;
      locala.ihz = paramInt2;
      locala.rYW = paramm;
      locala.duw = paramLong;
      locala.rYV = parambvz;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201991);
    }
    
    public final void a(long paramLong, bvz parambvz, int paramInt, d paramd, m paramm)
    {
      AppMethodBeat.i(201980);
      p.h(paramm, "video");
      c.a locala = new c.a(14);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.ret = paramInt;
      locala.rYW = paramm;
      locala.gzD = paramd;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201980);
    }
    
    public final void a(long paramLong, bvz parambvz, int paramInt1, m paramm, int paramInt2)
    {
      AppMethodBeat.i(201990);
      p.h(paramm, "video");
      c.a locala = new c.a(4);
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.position = paramInt1;
      locala.rYW = paramm;
      locala.rYZ = paramInt2;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201990);
    }
    
    public final void a(long paramLong, bvz parambvz, h paramh, d paramd, m paramm)
    {
      AppMethodBeat.i(201979);
      p.h(paramm, "video");
      c.a locala = new c.a(15);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.gzD = paramd;
      locala.rYW = paramm;
      locala.ivf = paramh;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201979);
    }
    
    public final void a(long paramLong, bvz parambvz, m paramm)
    {
      AppMethodBeat.i(201977);
      p.h(paramm, "video");
      c.a locala = new c.a(17);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201977);
    }
    
    public final void a(long paramLong1, bvz parambvz, m paramm, long paramLong2)
    {
      AppMethodBeat.i(201982);
      p.h(paramm, "video");
      c.a locala = new c.a(12);
      locala.rYV = parambvz;
      locala.duw = paramLong1;
      locala.rYW = paramm;
      locala.rZa = paramLong2;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201982);
    }
    
    public final void a(long paramLong, bvz parambvz, LinkedList<bvz> paramLinkedList, m paramm)
    {
      AppMethodBeat.i(201993);
      p.h(paramm, "video");
      c.a locala = new c.a(1);
      locala.rYV = parambvz;
      locala.rYW = paramm;
      locala.duw = paramLong;
      locala.mediaList = paramLinkedList;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201993);
    }
    
    public final void b(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201986);
      p.h(paramm, "video");
      c.a locala = new c.a(7);
      locala.offset = paramInt1;
      locala.ihz = paramInt2;
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201986);
    }
    
    public final void b(long paramLong, bvz parambvz, m paramm)
    {
      AppMethodBeat.i(201988);
      p.h(paramm, "video");
      c.a locala = new c.a(9);
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201988);
    }
    
    public final void b(long paramLong, bvz parambvz, LinkedList<bvz> paramLinkedList, m paramm)
    {
      AppMethodBeat.i(201983);
      p.h(paramm, "video");
      c.a locala = new c.a(11);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.mediaList = paramLinkedList;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201983);
    }
    
    public final void c(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201985);
      p.h(paramm, "video");
      c.a locala = new c.a(8);
      locala.offset = paramInt1;
      locala.ihz = paramInt2;
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201985);
    }
    
    public final void c(long paramLong, bvz parambvz, m paramm)
    {
      AppMethodBeat.i(201989);
      p.h(paramm, "video");
      c.a locala = new c.a(5);
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201989);
    }
    
    public final void d(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201984);
      p.h(paramm, "video");
      c.a locala = new c.a(10);
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.rYX = paramInt1;
      locala.rYY = paramInt2;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201984);
    }
    
    public final void d(long paramLong, bvz parambvz, m paramm)
    {
      AppMethodBeat.i(201992);
      p.h(paramm, "video");
      c.a locala = new c.a(2);
      locala.duw = paramLong;
      locala.rYW = paramm;
      locala.rYV = parambvz;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201992);
    }
    
    public final void e(long paramLong, bvz parambvz, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201981);
      p.h(paramm, "video");
      c.a locala = new c.a(13);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.offset = paramInt1;
      locala.rYW = paramm;
      locala.ihz = paramInt2;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201981);
    }
    
    public final void e(long paramLong, bvz parambvz, m paramm)
    {
      AppMethodBeat.i(201987);
      p.h(paramm, "video");
      c.a locala = new c.a(6);
      locala.duw = paramLong;
      locala.rYV = parambvz;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201987);
    }
    
    public final void f(long paramLong, bvz parambvz, m paramm)
    {
      AppMethodBeat.i(201978);
      p.h(paramm, "video");
      c.a locala = new c.a(16);
      locala.rYV = parambvz;
      locala.duw = paramLong;
      locala.rYW = paramm;
      this.rZc.c((b)locala);
      AppMethodBeat.o(201978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c
 * JD-Core Version:    0.7.0.1
 */