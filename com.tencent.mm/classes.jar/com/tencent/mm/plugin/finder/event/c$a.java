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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "()I", "setBgPreparedStatus", "currentSec", "getCurrentSec", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaSource", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaSource", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "getOnStopPlayData", "()Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "setOnStopPlayData", "(Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;)V", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "getPlayerConfig", "()Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "setPlayerConfig", "(Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;)V", "position", "getPosition", "setPosition", "prepareCostTime", "getPrepareCostTime", "setPrepareCostTime", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;)V", "videoTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "getVideoTrace", "()Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setVideoTrace", "(Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  extends b
{
  public static final c.a.a ANH;
  public v ANI;
  public dji ANJ;
  public x ANK;
  public int ANL;
  public int ANM;
  public long ANN;
  public e ANO;
  public com.tencent.mm.plugin.finder.video.reporter.d ANP;
  public a ANQ;
  public long feedId;
  public int hKX;
  LinkedList<dji> mediaList;
  public com.tencent.mm.g.d mxU;
  public h oYO;
  private String objectNonceId;
  public int offset;
  public int position;
  public int ret;
  public int total;
  public final int type;
  
  static
  {
    AppMethodBeat.i(165517);
    ANH = new c.a.a((byte)0);
    AppMethodBeat.o(165517);
  }
  
  public c$a(int paramInt)
  {
    this.type = paramInt;
    this.objectNonceId = "";
  }
  
  public final int dYF()
  {
    return this.ANL;
  }
  
  public final int dYG()
  {
    return this.hKX;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
    } while (this.type == paramObject.type);
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
    StringBuilder localStringBuilder = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.ANJ).append(", mediaId=");
    Object localObject1 = this.ANJ;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = localStringBuilder.append((String)localObject1).append(", offset=").append(this.offset).append(", total=").append(this.total).append(", feedId=").append(this.feedId).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
      localObject1 = this.mediaList;
      if (localObject1 != null) {
        break label159;
      }
    }
    label159:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((LinkedList)localObject1).size()))
    {
      localObject1 = localObject1 + ')';
      AppMethodBeat.o(165516);
      return localObject1;
      localObject2 = ((dji)localObject1).mediaId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.a
 * JD-Core Version:    0.7.0.1
 */