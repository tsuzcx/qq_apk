package com.tencent.mm.plugin.flutter.thumbplayer.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h.a;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.c;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/MMMultiSourceCdnTPPlayer;", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "cdnTaskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaProto", "", "getMediaProto", "()[B", "setMediaProto", "([B)V", "mediaType", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;", "getMediaType", "()Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;", "setMediaType", "(Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;)V", "prepareJob", "Lkotlinx/coroutines/Job;", "tpScope", "Lkotlinx/coroutines/CoroutineScope;", "createVideoPlayCDNTask", "getVideoSize", "Lkotlin/Pair;", "", "pause", "", "stopDownload", "", "prepare", "prepareLoader", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recycle", "startCdnDownload", "stop", "stopCdnDownload", "finish", "Lkotlin/Function0;", "Companion", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.thumbplayer.e.b
{
  public static final b.a HkP;
  private static final Map<com.tencent.mm.plugin.flutter.thumbplayer.b.a.a, c> HkV;
  private com.tencent.mm.g.h HkQ;
  private aq HkR;
  private cb HkS;
  public com.tencent.mm.plugin.flutter.thumbplayer.b.a.a HkT;
  public byte[] HkU;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(263323);
    HkP = new b.a((byte)0);
    HkV = (Map)new LinkedHashMap();
    b.a.a((c)new com.tencent.mm.plugin.flutter.thumbplayer.b.a.b());
    b.a.a((c)new com.tencent.mm.plugin.flutter.thumbplayer.b.a.d());
    b.a.a((c)new com.tencent.mm.plugin.flutter.thumbplayer.b.a.e());
    AppMethodBeat.o(263323);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(263232);
    this.TAG = s.X("MicroMsg.Flutter.MMVoipStatusCdnTPPlayer@", Integer.valueOf(hashCode()));
    this.HkR = ar.d((f)bg.kCi());
    AppMethodBeat.o(263232);
  }
  
  private final Object aj(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(263253);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263253);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = this.HkU;
    Object localObject3;
    if (localObject1 != null)
    {
      Log.i(this.TAG, "prepareLoader");
      localObject3 = (c)HkV.get(this.HkT);
      if (localObject3 != null)
      {
        paramd.L$0 = this;
        paramd.label = 1;
        localObject1 = ((c)localObject3).a((byte[])localObject1, paramd);
        if (localObject1 != localObject2) {
          break label328;
        }
        AppMethodBeat.o(263253);
        return localObject2;
        paramd = (b)paramd.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
    }
    for (;;)
    {
      localObject2 = (com.tencent.mm.g.h)localObject1;
      if (localObject2 != null)
      {
        Log.i(paramd.TAG, "prepareLoader parse finished");
        localObject1 = paramd.TFd;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b.b)localObject1).mediaId)
        {
          if (!s.p(localObject1, ((com.tencent.mm.g.h)localObject2).field_mediaId))
          {
            localObject1 = (com.tencent.mm.plugin.thumbplayer.e.b)paramd;
            localObject3 = ((com.tencent.mm.g.h)localObject2).field_mediaId;
            s.s(localObject3, "cdnTask.field_mediaId");
            String str = ((com.tencent.mm.g.h)localObject2).field_fullpath;
            s.s(str, "cdnTask.field_fullpath");
            paramd.TFd = new com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject1, (String)localObject3, str);
            ((com.tencent.mm.g.h)localObject2).lxs = ((h.a)paramd.TFd);
            paramd.HkQ = ((com.tencent.mm.g.h)localObject2);
          }
          paramd = ah.aiuX;
          AppMethodBeat.o(263253);
          return paramd;
        }
      }
      paramd = ah.aiuX;
      AppMethodBeat.o(263253);
      return paramd;
      label328:
      paramd = this;
    }
  }
  
  public final void bD(final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(263377);
    s.u(parama, "finish");
    if (this.HkU == null)
    {
      super.bD(parama);
      AppMethodBeat.o(263377);
      return;
    }
    if (!this.Flw)
    {
      Log.i(this.TAG, s.X("stopCdnDownload() not start cdn ", hLo()));
      parama.invoke();
      AppMethodBeat.o(263377);
      return;
    }
    Log.i(this.TAG, "stopCdnDownload");
    com.tencent.mm.plugin.thumbplayer.b.a locala = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
    Object localObject = this.HkQ;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      locala.a((String)localObject, (g)new f(this, parama));
      this.Flw = false;
      parama = this.TFd;
      if (parama != null) {
        parama.TFx = false;
      }
      AppMethodBeat.o(263377);
      return;
      localObject = ((com.tencent.mm.g.h)localObject).field_mediaId;
      if (localObject == null) {
        localObject = "";
      }
    }
  }
  
  public final void fjg()
  {
    AppMethodBeat.i(263358);
    if (this.HkU == null)
    {
      super.fjg();
      AppMethodBeat.o(263358);
      return;
    }
    if (this.Flw)
    {
      Log.i(this.TAG, s.X("startCdnDownload() already start cdn ", hLo()));
      AppMethodBeat.o(263358);
      return;
    }
    final com.tencent.mm.plugin.thumbplayer.e.b.b localb = this.TFd;
    if (localb != null)
    {
      if (!localb.TFw)
      {
        Log.i(this.TAG, "startCdnDownload");
        com.tencent.mm.plugin.thumbplayer.b.a locala = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
        Object localObject = this.HkQ;
        if (localObject == null) {
          localObject = "";
        }
        for (;;)
        {
          locala.a((String)localObject, (com.tencent.mm.plugin.thumbplayer.b.b)new d(this), (com.tencent.mm.plugin.thumbplayer.b.e)new e(this, localb));
          this.Flw = true;
          AppMethodBeat.o(263358);
          return;
          localObject = ((com.tencent.mm.g.h)localObject).field_mediaId;
          if (localObject == null) {
            localObject = "";
          }
        }
      }
      Log.i(this.TAG, "local file or complete or fromExternResourceLoader");
    }
    AppMethodBeat.o(263358);
  }
  
  public final com.tencent.mm.g.h fvc()
  {
    AppMethodBeat.i(263388);
    com.tencent.mm.g.h localh = this.HkQ;
    if (localh == null)
    {
      localh = super.fvc();
      AppMethodBeat.o(263388);
      return localh;
    }
    AppMethodBeat.o(263388);
    return localh;
  }
  
  public final void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(263402);
    if (this.HkU == null)
    {
      super.pause(paramBoolean);
      AppMethodBeat.o(263402);
      return;
    }
    if ((hLi()) && (isPlaying()))
    {
      com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
      if (locala != null) {
        locala.pause();
      }
      if (paramBoolean)
      {
        locala = this.Flb;
        if (locala != null) {
          locala.pauseDownload();
        }
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)this);
      }
      AppMethodBeat.o(263402);
      return;
      cNW();
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(263340);
    Log.i(this.TAG, "prepare mediaProto:" + this.HkU + ", prepareJob:" + this.HkS);
    if (this.HkU == null)
    {
      super.prepare();
      AppMethodBeat.o(263340);
      return;
    }
    if (this.HkS == null) {
      this.HkS = j.a(this.HkR, null, null, (m)new b(this, null), 3);
    }
    AppMethodBeat.o(263340);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(263416);
    ar.a(this.HkR, null);
    super.recycle();
    AppMethodBeat.o(263416);
  }
  
  public final void stop()
  {
    int i = 1;
    AppMethodBeat.i(263410);
    cb localcb = this.HkS;
    if ((localcb != null) && (localcb.isActive() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localcb = this.HkS;
        if (localcb != null) {
          localcb.a(null);
        }
      }
      com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)this);
      super.stop();
      AppMethodBeat.o(263410);
      return;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    long Yx;
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(263278);
      paramd = new b(this.HkW, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(263278);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263271);
      Object localObject1 = kotlin.d.a.a.aiwj;
      long l;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263271);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        l = Util.currentTicks();
        localObject2 = this.HkW;
        localObject3 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Yx = l;
        this.label = 1;
        if (b.a((b)localObject2, (kotlin.d.d)localObject3) == localObject1)
        {
          AppMethodBeat.o(263271);
          return localObject1;
        }
        break;
      case 1: 
        l = this.Yx;
        localObject1 = (aq)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      Log.i(b.a(this.HkW), s.X("prepareLoader cost:", kotlin.d.b.a.b.BF(Util.ticksToNow(l))));
      if (!ar.a(paramObject))
      {
        Log.w(b.a(this.HkW), "prepareJob is not active, return!");
        paramObject = ah.aiuX;
        AppMethodBeat.o(263271);
        return paramObject;
      }
      Object localObject3 = this.HkW.TFd;
      localObject1 = b.b(this.HkW);
      paramObject = this.HkW;
      if ((localObject3 != null) && (localObject1 != null))
      {
        localObject2 = y.n(((com.tencent.mm.g.h)localObject1).field_fullpath, false);
        Log.i(b.a(paramObject), "startToPlay(), cache file:" + localObject2 + ", isExists:" + y.ZC((String)localObject2) + ' ' + paramObject.hLo());
        if (!((com.tencent.mm.plugin.thumbplayer.e.b.b)localObject3).TFw) {
          break label407;
        }
        localObject3 = paramObject.Flb;
        if (localObject3 != null)
        {
          localObject1 = ((com.tencent.mm.g.h)localObject1).field_mediaId;
          s.s(localObject1, "cdnTask.field_mediaId");
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject3).setMediaId((String)localObject1);
        }
        localObject1 = paramObject.Flb;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildLong(302, paramObject.TFq));
        }
        localObject1 = paramObject.Flb;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setDataSource((String)localObject2);
        }
      }
      for (;;)
      {
        b.a(paramObject, 1);
        paramObject.TFu.moe = Util.currentTicks();
        paramObject = ah.aiuX;
        AppMethodBeat.o(263271);
        return paramObject;
        label407:
        localObject2 = new TPVideoInfo.Builder();
        ((TPVideoInfo.Builder)localObject2).fileId(((com.tencent.mm.g.h)localObject1).field_fileId);
        ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
        localObject3 = paramObject.Flb;
        if (localObject3 != null)
        {
          String str = ((com.tencent.mm.g.h)localObject1).field_mediaId;
          s.s(str, "cdnTask.field_mediaId");
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject3).setMediaId(str);
        }
        localObject3 = paramObject.Flb;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject3).setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildLong(302, paramObject.TFq));
        }
        localObject3 = paramObject.Flb;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject3).setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
        }
        localObject2 = paramObject.Flb;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject2).setDataSource(((com.tencent.mm.g.h)localObject1).url);
        }
        paramObject.fjg();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(b paramb, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263256);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(this.HkW, (kotlin.d.d)this);
      AppMethodBeat.o(263256);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/thumbplayer/player/MMMultiSourceCdnTPPlayer$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    d(b paramb) {}
    
    public final com.tencent.mm.g.h aCq(String paramString)
    {
      AppMethodBeat.i(263250);
      s.u(paramString, "id");
      paramString = this.HkW.fvc();
      AppMethodBeat.o(263250);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/thumbplayer/player/MMMultiSourceCdnTPPlayer$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStop", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    e(b paramb, com.tencent.mm.plugin.thumbplayer.e.b.b paramb1) {}
    
    public final void Rv(int paramInt)
    {
      AppMethodBeat.i(263247);
      Log.i(b.a(this.HkW), "startCdnDownload()#onStart " + this.HkW.hLo() + ' ' + paramInt);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(263247);
        return;
      case 0: 
        b.c(this.HkW);
        AppMethodBeat.o(263247);
        return;
      }
      localb.TFw = true;
      localb.EUK = true;
      m localm = localb.TFy;
      if (localm != null)
      {
        localObject = b.b(this.HkW);
        if (localObject != null) {
          break label153;
        }
      }
      label153:
      for (Object localObject = null;; localObject = ((com.tencent.mm.g.h)localObject).field_fileId)
      {
        localm.invoke(localObject, Integer.valueOf(0));
        b.a(this.HkW, 4);
        break;
      }
    }
    
    public final void a(int paramInt, com.tencent.mm.g.h paramh)
    {
      AppMethodBeat.i(263254);
      String str = b.a(this.HkW);
      StringBuilder localStringBuilder = new StringBuilder("startCdnDownload() #onStop:").append(paramInt).append(", ");
      if (paramh == null) {}
      for (paramh = null;; paramh = paramh.field_mediaId)
      {
        Log.i(str, paramh);
        AppMethodBeat.o(263254);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/thumbplayer/player/MMMultiSourceCdnTPPlayer$stopCdnDownload$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements g
  {
    f(b paramb, kotlin.g.a.a<ah> parama) {}
    
    public final void a(int paramInt, com.tencent.mm.g.h paramh, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(263260);
      Log.i(b.a(this.HkW), "stopCdnDownload()#onStop(), real cancel download task " + this.HkW.hLo() + ' ' + paramInt);
      parama.invoke();
      AppMethodBeat.o(263260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.b
 * JD-Core Version:    0.7.0.1
 */