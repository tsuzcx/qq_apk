package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.protocal.protobuf.bmd;
import d.g.b.k;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "()V", "getBehavior", "PlayEvent", "VideoPlayBehavior", "plugin-finder_release"})
public final class b
  extends g<b>
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "currentSec", "getCurrentSec", "()I", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "position", "getPosition", "setPosition", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class a
    extends c
  {
    public static final a qse;
    public d fYG;
    public long feedId;
    public int hlk;
    public h hyo;
    public LinkedList<bmd> mediaList;
    private String objectNonceId;
    public int offset;
    public int position;
    public com.tencent.mm.plugin.finder.loader.l qCU;
    public bmd qsb;
    public int qsc;
    public int qsd;
    int ret;
    public final int type;
    
    static
    {
      AppMethodBeat.i(165517);
      qse = new a((byte)0);
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
      StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.qsb).append(", mediaId=");
      Object localObject1 = this.qsb;
      if (localObject1 != null)
      {
        localObject2 = ((bmd)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.hlk).append(", feedId=").append(this.feedId).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
      localObject1 = this.mediaList;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ')';
        AppMethodBeat.o(165516);
        return localObject1;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent$Companion;", "", "()V", "VIDEO_CHECK_VIDEO_DATA_AVAILABLE", "", "VIDEO_CLICK_PAUSE", "VIDEO_DOWNLOAD_FINISH", "VIDEO_DOWNLOAD_PROGRESS", "VIDEO_DOWNLOAD_START", "VIDEO_DOWNLOAD_STOP", "VIDEO_FIRST_FRAME", "VIDEO_MOOV_READY", "VIDEO_PAUSE", "VIDEO_PROGRESS", "VIDEO_REAL_PLAY", "VIDEO_REPLAY", "VIDEO_SEEK", "VIDEO_START_PLAY", "VIDEO_STOP_PLAY", "VIDEO_WAITING", "VIDEO_WAITING_END", "plugin-finder_release"})
    public static final class a {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "objectNonceId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onFirstFrame", "mediaList", "Ljava/util/LinkedList;", "onMoovReady", "onPause", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "eedId", "position", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bmd parambmd, int paramInt, d paramd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bmd parambmd, h paramh, d paramd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, int paramInt, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void a(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void b(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void b(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void b(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void c(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void c(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void c(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void d(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void d(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void e(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void e(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml);
    
    public abstract void f(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "objectNonceId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onFirstFrame", "mediaList", "Ljava/util/LinkedList;", "onMoovReady", "onPause", "onPlayProgress", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "position", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
  public static final class c
    implements b.b
  {
    public final void a(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197529);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(3);
      locala.offset = paramInt1;
      locala.hlk = paramInt2;
      locala.qCU = paraml;
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      this.qsf.b((c)locala);
      AppMethodBeat.o(197529);
    }
    
    public final void a(long paramLong, String paramString, bmd parambmd, int paramInt, d paramd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197518);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(14);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.ret = paramInt;
      locala.qCU = paraml;
      locala.fYG = paramd;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197518);
    }
    
    public final void a(long paramLong, String paramString, bmd parambmd, h paramh, d paramd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197517);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(15);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.fYG = paramd;
      locala.qCU = paraml;
      locala.hyo = paramh;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197517);
    }
    
    public final void a(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197515);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(17);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197515);
    }
    
    public final void a(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, int paramInt, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197528);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(4);
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.mediaList = paramLinkedList;
      locala.setObjectNonceId(paramString);
      locala.position = paramInt;
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197528);
    }
    
    public final void a(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197531);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(1);
      locala.qsb = parambmd;
      locala.qCU = paraml;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.mediaList = paramLinkedList;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197531);
    }
    
    public final void b(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197524);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(7);
      locala.offset = paramInt1;
      locala.hlk = paramInt2;
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197524);
    }
    
    public final void b(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197526);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(9);
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197526);
    }
    
    public final void b(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197521);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(11);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.mediaList = paramLinkedList;
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197521);
    }
    
    public final void c(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197523);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(8);
      locala.offset = paramInt1;
      locala.hlk = paramInt2;
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197523);
    }
    
    public final void c(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197527);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(5);
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197527);
    }
    
    public final void c(long paramLong, String paramString, bmd parambmd, LinkedList<bmd> paramLinkedList, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197520);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(12);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      locala.mediaList = paramLinkedList;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197520);
    }
    
    public final void d(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197522);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(10);
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      locala.qsc = paramInt1;
      locala.qsd = paramInt2;
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197522);
    }
    
    public final void d(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197530);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(2);
      locala.feedId = paramLong;
      locala.qCU = paraml;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      this.qsf.b((c)locala);
      AppMethodBeat.o(197530);
    }
    
    public final void e(long paramLong, String paramString, bmd parambmd, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197519);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(13);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.offset = paramInt1;
      locala.qCU = paraml;
      locala.hlk = paramInt2;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197519);
    }
    
    public final void e(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197525);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(6);
      locala.feedId = paramLong;
      locala.qsb = parambmd;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197525);
    }
    
    public final void f(long paramLong, String paramString, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(197516);
      k.h(paramString, "objectNonceId");
      k.h(paraml, "video");
      b.a locala = new b.a(16);
      locala.qsb = parambmd;
      locala.feedId = paramLong;
      locala.setObjectNonceId(paramString);
      locala.qCU = paraml;
      this.qsf.b((c)locala);
      AppMethodBeat.o(197516);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.b
 * JD-Core Version:    0.7.0.1
 */