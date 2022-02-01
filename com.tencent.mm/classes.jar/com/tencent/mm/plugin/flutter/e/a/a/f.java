package com.tencent.mm.plugin.flutter.e.a.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.vending.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorAudioRecommend;", "", "()V", "FLUTTER_TAG", "", "TAG", "audioCacheList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "Lkotlin/collections/ArrayList;", "getAudioCacheList", "()Ljava/util/ArrayList;", "callback", "Lkotlin/Function2;", "", "", "taskLifeCycle", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "uiThreadHandler", "Landroid/os/Handler;", "videoRecommendAudioTask", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "addAudioList", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "downloadMusic", "info", "getMusicRequestId", "", "getRecommendAudio", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioRecommendResponse;", "videoPath", "startTime", "endTime", "startGetRecommendAudio", "Companion", "plugin-flutter_release"})
public final class f
{
  private static f wJU;
  public static final a wJV;
  public final String TAG;
  private m<? super Boolean, ? super String, x> gWp;
  private final Handler uiThreadHandler;
  public final String vRb;
  private final ArrayList<AudioCacheInfo> wJR;
  public com.tencent.mm.plugin.recordvideo.model.audio.a wJS;
  public c<com.tencent.mm.vending.e.a> wJT;
  
  static
  {
    AppMethodBeat.i(241071);
    wJV = new a((byte)0);
    AppMethodBeat.o(241071);
  }
  
  private f()
  {
    AppMethodBeat.i(241070);
    this.TAG = "MMVideoEditorAudioRecommend";
    this.vRb = "MMVideoEditorAudioRecommend.FlutterVideoEditor_DataReport";
    this.wJR = new ArrayList();
    this.wJT = new c();
    this.uiThreadHandler = new Handler(Looper.getMainLooper());
    this.gWp = ((m)new b(this));
    AppMethodBeat.o(241070);
  }
  
  public final void eL(List<? extends clp> paramList)
  {
    AppMethodBeat.i(241069);
    p.h(paramList, "audioList");
    this.wJR.clear();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    Object localObject2;
    if (paramList.hasNext())
    {
      localObject1 = paramList.next();
      if (i < 0) {
        j.hxH();
      }
      localObject1 = (clp)localObject1;
      localObject2 = AudioCacheInfo.BPo;
      localObject2 = AudioCacheInfo.BPo;
      localObject1 = AudioCacheInfo.a.a((clp)localObject1, AudioCacheInfo.eJW());
      localObject2 = AudioCacheInfo.BPo;
      ((AudioCacheInfo)localObject1).source = AudioCacheInfo.eKb();
      ((AudioCacheInfo)localObject1).position = i;
      localObject2 = this.wJS;
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.plugin.recordvideo.model.audio.a)localObject2).BOT;; l = -1L)
      {
        ((AudioCacheInfo)localObject1).BPd = l;
        this.wJR.add(localObject1);
        i += 1;
        break;
      }
    }
    paramList = new ArrayList();
    Object localObject1 = this.wJR.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (AudioCacheInfo)((Iterator)localObject1).next();
      localObject2 = new HashMap();
      Object localObject4 = ((AudioCacheInfo)localObject3).cachePath;
      if (localObject4 != null) {
        ((HashMap)localObject2).put("cachePath", localObject4);
      }
      ((HashMap)localObject2).put("duration", Integer.valueOf(((AudioCacheInfo)localObject3).duration));
      localObject4 = new ArrayList();
      Object localObject5 = ((AudioCacheInfo)localObject3).BOY;
      if (localObject5 == null) {
        p.hyc();
      }
      localObject5 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        AudioCacheInfo.c localc = (AudioCacheInfo.c)((Iterator)localObject5).next();
        HashMap localHashMap = new HashMap();
        localHashMap.put("lrc", localc.BPp);
        localHashMap.put("startTime", Integer.valueOf(localc.dvv));
        localHashMap.put("endTime", Integer.valueOf(localc.BPq));
        ((ArrayList)localObject4).add(localHashMap);
      }
      ((HashMap)localObject2).put("lrcList", localObject4);
      localObject4 = new ArrayList();
      localObject5 = ((AudioCacheInfo)localObject3).BOZ.iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((ArrayList)localObject4).add((String)((Iterator)localObject5).next());
      }
      ((HashMap)localObject2).put("singers", localObject4);
      ((HashMap)localObject2).put("songName", ((AudioCacheInfo)localObject3).BPc);
      ((HashMap)localObject2).put("musicId", Integer.valueOf(((AudioCacheInfo)localObject3).BOX));
      ((HashMap)localObject2).put("cached", Boolean.valueOf(((AudioCacheInfo)localObject3).aXa));
      localObject3 = ((AudioCacheInfo)localObject3).musicUrl;
      if (localObject3 != null) {
        ((HashMap)localObject2).put("musicUrl", localObject3);
      }
      paramList.add(localObject2);
    }
    localObject1 = o.wKI;
    o.a.dMh().t("onReceiveMusicRecommend", paramList);
    AppMethodBeat.o(241069);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorAudioRecommend$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorAudioRecommend;", "getInstance", "plugin-flutter_release"})
  public static final class a
  {
    public static f dLQ()
    {
      AppMethodBeat.i(241064);
      if (f.dLP() == null) {
        f.d(new f((byte)0));
      }
      f localf = f.dLP();
      if (localf == null) {
        p.hyc();
      }
      AppMethodBeat.o(241064);
      return localf;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, String, x>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */