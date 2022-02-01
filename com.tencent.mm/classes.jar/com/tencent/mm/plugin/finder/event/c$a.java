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
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "()I", "setBgPreparedStatus", "currentSec", "getCurrentSec", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaSource", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaSource", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "getOnStopPlayData", "()Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "setOnStopPlayData", "(Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;)V", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "getPlayerConfig", "()Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "setPlayerConfig", "(Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;)V", "position", "getPosition", "setPosition", "prepareCostTime", "getPrepareCostTime", "setPrepareCostTime", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder-base_release"})
public final class c$a
  extends b
{
  public static final c.a.a xqD;
  public int fFM;
  public long feedId;
  public d jYa;
  LinkedList<csg> mediaList;
  public h mfS;
  private String objectNonceId;
  public int offset;
  public int position;
  public int ret;
  public int total;
  public final int type;
  public long xqA;
  public f xqB;
  public e xqC;
  public t xqv;
  public csg xqw;
  public ac xqx;
  public int xqy;
  public int xqz;
  
  static
  {
    AppMethodBeat.i(165517);
    xqD = new c.a.a((byte)0);
    AppMethodBeat.o(165517);
  }
  
  public c$a(int paramInt)
  {
    this.type = paramInt;
    this.objectNonceId = "";
  }
  
  public final int dqj()
  {
    return this.xqy;
  }
  
  public final int dqk()
  {
    return this.fFM;
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
    StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.xqw).append(", mediaId=");
    Object localObject1 = this.xqw;
    if (localObject1 != null)
    {
      localObject2 = ((csg)localObject1).mediaId;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.total).append(", feedId=").append(this.feedId).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
    localObject1 = this.mediaList;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
    {
      localObject1 = localObject1 + ')';
      AppMethodBeat.o(165516);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.a
 * JD-Core Version:    0.7.0.1
 */