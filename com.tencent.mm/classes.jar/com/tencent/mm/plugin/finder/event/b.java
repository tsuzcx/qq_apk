package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.protocal.protobuf.bvf;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "VideoPlayBehavior", "plugin-finder_release"})
public final class b
  extends e<b>
{
  public b(c paramc)
  {
    super(paramc);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "()I", "setBgPreparedStatus", "currentSec", "getCurrentSec", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "position", "getPosition", "setPosition", "prepareCostTime", "getPrepareCostTime", "setPrepareCostTime", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.event.base.b
  {
    public static final a rQz;
    public long dtq;
    public d gwW;
    public int ieH;
    public h isl;
    LinkedList<bvf> mediaList;
    private String objectNonceId;
    public int offset;
    public int position;
    public bvf rQt;
    public m rQu;
    public int rQv;
    public int rQw;
    public int rQx;
    public long rQy;
    public int ret;
    public final int type;
    
    static
    {
      AppMethodBeat.i(165517);
      rQz = new a((byte)0);
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
      StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.rQt).append(", mediaId=");
      Object localObject1 = this.rQt;
      if (localObject1 != null)
      {
        localObject2 = ((bvf)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.ieH).append(", feedId=").append(this.dtq).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
      localObject1 = this.mediaList;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ')';
        AppMethodBeat.o(165516);
        return localObject1;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent$Companion;", "", "()V", "VIDEO_CHECK_VIDEO_DATA_AVAILABLE", "", "VIDEO_CLICK_PAUSE", "VIDEO_DOWNLOAD_FINISH", "VIDEO_DOWNLOAD_PROGRESS", "VIDEO_DOWNLOAD_START", "VIDEO_DOWNLOAD_STOP", "VIDEO_FIRST_FRAME", "VIDEO_MOOV_READY", "VIDEO_PAUSE", "VIDEO_PLAY_ERROR", "VIDEO_PROGRESS", "VIDEO_REAL_PLAY", "VIDEO_REPLAY", "VIDEO_SEEK", "VIDEO_START_PLAY", "VIDEO_STOP_PLAY", "VIDEO_WAITING", "VIDEO_WAITING_END", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, bvf parambvf, int paramInt);
    
    public abstract void a(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm);
    
    public abstract void a(long paramLong, bvf parambvf, int paramInt, d paramd, m paramm);
    
    public abstract void a(long paramLong, bvf parambvf, int paramInt1, m paramm, int paramInt2);
    
    public abstract void a(long paramLong, bvf parambvf, h paramh, d paramd, m paramm);
    
    public abstract void a(long paramLong, bvf parambvf, m paramm);
    
    public abstract void a(long paramLong1, bvf parambvf, m paramm, long paramLong2);
    
    public abstract void a(long paramLong, bvf parambvf, LinkedList<bvf> paramLinkedList, m paramm);
    
    public abstract void b(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm);
    
    public abstract void b(long paramLong, bvf parambvf, m paramm);
    
    public abstract void b(long paramLong, bvf parambvf, LinkedList<bvf> paramLinkedList, m paramm);
    
    public abstract void c(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm);
    
    public abstract void c(long paramLong, bvf parambvf, m paramm);
    
    public abstract void d(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm);
    
    public abstract void d(long paramLong, bvf parambvf, m paramm);
    
    public abstract void e(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm);
    
    public abstract void e(long paramLong, bvf parambvf, m paramm);
    
    public abstract void f(long paramLong, bvf parambvf, m paramm);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static final class c
    implements b.b
  {
    public final void a(long paramLong, bvf parambvf, int paramInt)
    {
      AppMethodBeat.i(201547);
      b.a locala = new b.a(18);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.ret = paramInt;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201547);
    }
    
    public final void a(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201544);
      p.h(paramm, "video");
      b.a locala = new b.a(3);
      locala.offset = paramInt1;
      locala.ieH = paramInt2;
      locala.rQu = paramm;
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201544);
    }
    
    public final void a(long paramLong, bvf parambvf, int paramInt, d paramd, m paramm)
    {
      AppMethodBeat.i(201533);
      p.h(paramm, "video");
      b.a locala = new b.a(14);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.ret = paramInt;
      locala.rQu = paramm;
      locala.gwW = paramd;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201533);
    }
    
    public final void a(long paramLong, bvf parambvf, int paramInt1, m paramm, int paramInt2)
    {
      AppMethodBeat.i(201543);
      p.h(paramm, "video");
      b.a locala = new b.a(4);
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.position = paramInt1;
      locala.rQu = paramm;
      locala.rQx = paramInt2;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201543);
    }
    
    public final void a(long paramLong, bvf parambvf, h paramh, d paramd, m paramm)
    {
      AppMethodBeat.i(201532);
      p.h(paramm, "video");
      b.a locala = new b.a(15);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.gwW = paramd;
      locala.rQu = paramm;
      locala.isl = paramh;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201532);
    }
    
    public final void a(long paramLong, bvf parambvf, m paramm)
    {
      AppMethodBeat.i(201530);
      p.h(paramm, "video");
      b.a locala = new b.a(17);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201530);
    }
    
    public final void a(long paramLong1, bvf parambvf, m paramm, long paramLong2)
    {
      AppMethodBeat.i(201535);
      p.h(paramm, "video");
      b.a locala = new b.a(12);
      locala.rQt = parambvf;
      locala.dtq = paramLong1;
      locala.rQu = paramm;
      locala.rQy = paramLong2;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201535);
    }
    
    public final void a(long paramLong, bvf parambvf, LinkedList<bvf> paramLinkedList, m paramm)
    {
      AppMethodBeat.i(201546);
      p.h(paramm, "video");
      b.a locala = new b.a(1);
      locala.rQt = parambvf;
      locala.rQu = paramm;
      locala.dtq = paramLong;
      locala.mediaList = paramLinkedList;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201546);
    }
    
    public final void b(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201539);
      p.h(paramm, "video");
      b.a locala = new b.a(7);
      locala.offset = paramInt1;
      locala.ieH = paramInt2;
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201539);
    }
    
    public final void b(long paramLong, bvf parambvf, m paramm)
    {
      AppMethodBeat.i(201541);
      p.h(paramm, "video");
      b.a locala = new b.a(9);
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201541);
    }
    
    public final void b(long paramLong, bvf parambvf, LinkedList<bvf> paramLinkedList, m paramm)
    {
      AppMethodBeat.i(201536);
      p.h(paramm, "video");
      b.a locala = new b.a(11);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.mediaList = paramLinkedList;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201536);
    }
    
    public final void c(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201538);
      p.h(paramm, "video");
      b.a locala = new b.a(8);
      locala.offset = paramInt1;
      locala.ieH = paramInt2;
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201538);
    }
    
    public final void c(long paramLong, bvf parambvf, m paramm)
    {
      AppMethodBeat.i(201542);
      p.h(paramm, "video");
      b.a locala = new b.a(5);
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201542);
    }
    
    public final void d(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201537);
      p.h(paramm, "video");
      b.a locala = new b.a(10);
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.rQv = paramInt1;
      locala.rQw = paramInt2;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201537);
    }
    
    public final void d(long paramLong, bvf parambvf, m paramm)
    {
      AppMethodBeat.i(201545);
      p.h(paramm, "video");
      b.a locala = new b.a(2);
      locala.dtq = paramLong;
      locala.rQu = paramm;
      locala.rQt = parambvf;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201545);
    }
    
    public final void e(long paramLong, bvf parambvf, int paramInt1, int paramInt2, m paramm)
    {
      AppMethodBeat.i(201534);
      p.h(paramm, "video");
      b.a locala = new b.a(13);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.offset = paramInt1;
      locala.rQu = paramm;
      locala.ieH = paramInt2;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201534);
    }
    
    public final void e(long paramLong, bvf parambvf, m paramm)
    {
      AppMethodBeat.i(201540);
      p.h(paramm, "video");
      b.a locala = new b.a(6);
      locala.dtq = paramLong;
      locala.rQt = parambvf;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201540);
    }
    
    public final void f(long paramLong, bvf parambvf, m paramm)
    {
      AppMethodBeat.i(201531);
      p.h(paramm, "video");
      b.a locala = new b.a(16);
      locala.rQt = parambvf;
      locala.dtq = paramLong;
      locala.rQu = paramm;
      this.rQA.c((com.tencent.mm.plugin.finder.event.base.b)locala);
      AppMethodBeat.o(201531);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */