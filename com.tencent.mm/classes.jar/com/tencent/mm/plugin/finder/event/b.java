package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.b.k;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "VideoPlayBehavior", "plugin-finder_release"})
public final class b
  extends e<b>
{
  public b(c paramc)
  {
    super(paramc);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "currentSec", "getCurrentSec", "()I", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "position", "getPosition", "setPosition", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.event.base.b
  {
    public static final a rdc;
    public long dig;
    public d gdm;
    public int hLN;
    public h hYP;
    public LinkedList<bqs> mediaList;
    private String objectNonceId;
    public int offset;
    public int position;
    public bqs rcY;
    public com.tencent.mm.plugin.finder.loader.l rcZ;
    public int rda;
    public int rdb;
    public int ret;
    public final int type;
    
    static
    {
      AppMethodBeat.i(165517);
      rdc = new a((byte)0);
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
    
    public final void setObjectNonceId(String paramString)
    {
      AppMethodBeat.i(165515);
      k.h(paramString, "<set-?>");
      this.objectNonceId = paramString;
      AppMethodBeat.o(165515);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(165516);
      StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.rcY).append(", mediaId=");
      Object localObject1 = this.rcY;
      if (localObject1 != null)
      {
        localObject2 = ((bqs)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.hLN).append(", feedId=").append(this.dig).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
      localObject1 = this.mediaList;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ')';
        AppMethodBeat.o(165516);
        return localObject1;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent$Companion;", "", "()V", "VIDEO_CHECK_VIDEO_DATA_AVAILABLE", "", "VIDEO_CLICK_PAUSE", "VIDEO_DOWNLOAD_FINISH", "VIDEO_DOWNLOAD_PROGRESS", "VIDEO_DOWNLOAD_START", "VIDEO_DOWNLOAD_STOP", "VIDEO_FIRST_FRAME", "VIDEO_MOOV_READY", "VIDEO_PAUSE", "VIDEO_PLAY_ERROR", "VIDEO_PROGRESS", "VIDEO_REAL_PLAY", "VIDEO_REPLAY", "VIDEO_SEEK", "VIDEO_START_PLAY", "VIDEO_STOP_PLAY", "VIDEO_WAITING", "VIDEO_WAITING_END", "plugin-finder_release"})
    public static final class a {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "objectNonceId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "mediaList", "Ljava/util/LinkedList;", "onMoovReady", "onPause", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "eedId", "position", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, bqs parambqs, int paramInt);
    
    public abstract void a(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bqs parambqs, int paramInt, d paramd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bqs parambqs, h paramh, d paramd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, int paramInt, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void b(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void b(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void b(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void c(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void c(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void c(long paramLong, String paramString, bqs parambqs, LinkedList<bqs> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void d(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void d(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void e(long paramLong, String paramString, bqs parambqs, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void e(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void f(long paramLong, String paramString, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */