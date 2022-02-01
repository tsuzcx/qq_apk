package com.tencent.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.LruCache;
import android.util.Pair;
import android.util.Size;
import com.tencent.d.a.a;
import com.tencent.d.a.aa;
import com.tencent.d.a.ab;
import com.tencent.d.a.ac;
import com.tencent.d.a.ad;
import com.tencent.d.a.ae;
import com.tencent.d.a.af;
import com.tencent.d.a.ag;
import com.tencent.d.a.ah;
import com.tencent.d.a.ai;
import com.tencent.d.a.aj;
import com.tencent.d.a.ak;
import com.tencent.d.a.al;
import com.tencent.d.a.am;
import com.tencent.d.a.an;
import com.tencent.d.a.ao;
import com.tencent.d.a.ap;
import com.tencent.d.a.aq;
import com.tencent.d.a.ar;
import com.tencent.d.a.as;
import com.tencent.d.a.at;
import com.tencent.d.a.at.1;
import com.tencent.d.a.at.10;
import com.tencent.d.a.at.11;
import com.tencent.d.a.at.12;
import com.tencent.d.a.at.13;
import com.tencent.d.a.at.14;
import com.tencent.d.a.at.15;
import com.tencent.d.a.at.16;
import com.tencent.d.a.at.17;
import com.tencent.d.a.at.18;
import com.tencent.d.a.at.19;
import com.tencent.d.a.at.2;
import com.tencent.d.a.at.20;
import com.tencent.d.a.at.21;
import com.tencent.d.a.at.22;
import com.tencent.d.a.at.23;
import com.tencent.d.a.at.24;
import com.tencent.d.a.at.25;
import com.tencent.d.a.at.26;
import com.tencent.d.a.at.27;
import com.tencent.d.a.at.28;
import com.tencent.d.a.at.29;
import com.tencent.d.a.at.3;
import com.tencent.d.a.at.30;
import com.tencent.d.a.at.31;
import com.tencent.d.a.at.32;
import com.tencent.d.a.at.33;
import com.tencent.d.a.at.34;
import com.tencent.d.a.at.35;
import com.tencent.d.a.at.36;
import com.tencent.d.a.at.37;
import com.tencent.d.a.at.38;
import com.tencent.d.a.at.39;
import com.tencent.d.a.at.4;
import com.tencent.d.a.at.40;
import com.tencent.d.a.at.41;
import com.tencent.d.a.at.42;
import com.tencent.d.a.at.43;
import com.tencent.d.a.at.44;
import com.tencent.d.a.at.45;
import com.tencent.d.a.at.46;
import com.tencent.d.a.at.47;
import com.tencent.d.a.at.48;
import com.tencent.d.a.at.49;
import com.tencent.d.a.at.5;
import com.tencent.d.a.at.50;
import com.tencent.d.a.at.51;
import com.tencent.d.a.at.52;
import com.tencent.d.a.at.53;
import com.tencent.d.a.at.54;
import com.tencent.d.a.at.55;
import com.tencent.d.a.at.6;
import com.tencent.d.a.at.7;
import com.tencent.d.a.at.8;
import com.tencent.d.a.at.9;
import com.tencent.d.a.c;
import com.tencent.d.a.d;
import com.tencent.d.a.e;
import com.tencent.d.a.f;
import com.tencent.d.a.g;
import com.tencent.d.a.i;
import com.tencent.d.a.j;
import com.tencent.d.a.k;
import com.tencent.d.a.m;
import com.tencent.d.a.n;
import com.tencent.d.a.o;
import com.tencent.d.a.q;
import com.tencent.d.a.r;
import com.tencent.d.a.s;
import com.tencent.d.a.t;
import com.tencent.d.a.u;
import com.tencent.d.a.v;
import com.tencent.d.a.w;
import com.tencent.d.a.x;
import com.tencent.d.a.y;
import com.tencent.d.a.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.b.g;
import com.tencent.mm.videocomposition.n.b;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.aa;
import com.tencent.mm.xeffect.effect.ab;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.f;
import com.tencent.mm.xeffect.effect.h;
import com.tencent.mm.xeffect.effect.r;
import com.tencent.mm.xeffect.effect.u;
import com.tencent.tav.core.AssetExportSession;
import io.flutter.plugin.a.d.a;
import io.flutter.plugin.a.d.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import kotlin.g.a.m;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/video_editor_videocomposition/VideoCompositionApiPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$VideoCompositionApi;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "()V", "compositionDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/video_editor_videocomposition/VideoCompositionPluginData;", "Lkotlin/collections/HashMap;", "context", "Landroid/content/Context;", "effectManagerDataMap", "Lcom/tencent/video_editor_videocomposition/EffectManagerData;", "eventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "exportChannel", "Lio/flutter/plugin/common/EventChannel;", "handler", "Landroid/os/Handler;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "playerCallbackChannel", "playerMap", "Lcom/tencent/video_editor_videocomposition/VideoCompositionPlayerPluginData;", "random", "Ljava/util/Random;", "textureRegistry", "Lio/flutter/view/TextureRegistry;", "thumbListChannel", "trackMap", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "addEffect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$BoolReply;", "arg", "Lcom/tencent/pigeon/VideoCompositionPluginApi$AddEffectRequest;", "addTrack", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackRequest;", "bringToFront", "Lcom/tencent/pigeon/VideoCompositionPluginApi$BringToFrontRequest;", "callbackFrameData", "", "time", "bitmap", "Landroid/graphics/Bitmap;", "trackId", "compositionId", "cancelExport", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CancelExportRequest;", "clearEffect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$ClearEffectRequest;", "compositionSetPlayRange", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetPlayRangeRequest;", "create", "Lcom/tencent/pigeon/VideoCompositionPluginApi$IntReply;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$IntRequest;", "createComposition", "createEffectByBinary", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateEffectByBinaryRequest;", "createEffectByPath", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateEffectByPathRequest;", "createEffectManager", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateEffectManagerRequest;", "createPlayer", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreatePlayerRequest;", "createTrack", "Lcom/tencent/pigeon/VideoCompositionPluginApi$CreateTrackRequest;", "destroyEffectManager", "Lcom/tencent/pigeon/VideoCompositionPluginApi$DestroyEffectManagerRequest;", "export", "Lcom/tencent/pigeon/VideoCompositionPluginApi$ExportRequest;", "getCompositionDuration", "getCompositionLabel", "Lcom/tencent/pigeon/VideoCompositionPluginApi$GetCompositionLabelRequest;", "getPAGInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGInfoReply;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGInfoRequest;", "getPAGTemplateInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGTemplateInfoReply;", "Lcom/tencent/pigeon/VideoCompositionPluginApi$PAGTemplateInfoRequest;", "getTrackInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackInfoReply;", "getVieoEnhancementEnabled", "Lcom/tencent/pigeon/VideoCompositionPluginApi$GetVideoEnhancementEnabledRequest;", "isGif", "", "bytes", "", "onAttachedToEngine", "applicationContext", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onCancel", "arguments", "", "onDetachedFromEngine", "p0", "onListen", "sink", "playerPause", "playerRefreshSurface", "playerRelease", "playerSeek", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SeekRequest;", "playerSetLoop", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetLoopRequest;", "playerSetPlayRange", "playerStart", "playerStop", "playerUpdateComposition", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateCompositionRequest;", "playerUpdateDisplaySize", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateDisplaySizeRequest;", "release", "removeEffect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$RemoveEffectRequest;", "removeTrack", "requestTrackThumbs", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackThumbsRequest;", "setCompositionRenderArea", "Lcom/tencent/pigeon/VideoCompositionPluginApi$RenderAreaRequest;", "setEffectLayout", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectLayoutRequest;", "setEffectManager", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectManagerRequest;", "setEffectParams", "Lcom/tencent/pigeon/VideoCompositionPluginApi$EffectParamsRequest;", "setEffectSize", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectSizeRequest;", "setEffectText", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectTextRequest;", "setEffectTimeRange", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetEffectTimeRangeRequest;", "setEnableOriginSound", "Lcom/tencent/pigeon/VideoCompositionPluginApi$EnableOriginSoundRequest;", "setPAGEffectCheckMarker", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetPAGEffectCheckMarkerRequest;", "setPAGTemplateText", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetPAGTemplateTextRequest;", "setPlayerCallback", "setPlayerProfileCallback", "setRenderSize", "Lcom/tencent/pigeon/VideoCompositionPluginApi$RenderSizeRequest;", "setTrackCropArea", "setTrackInfo", "Lcom/tencent/pigeon/VideoCompositionPluginApi$TrackInfoRequest;", "setTrackRenderArea", "setVideoEnhancement", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetVideoEnhancementRequest;", "setVideoEnhancementEffectJsonConfig", "Lcom/tencent/pigeon/VideoCompositionPluginApi$SetVideoEnhancementEffectJsonConfigRequest;", "updateCropRect", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateRectRequest;", "updateTrack", "Lcom/tencent/pigeon/VideoCompositionPluginApi$UpdateTrackRequest;", "Companion", "video_editor_videocomposition_release"})
public final class b
  extends a.at
  implements io.flutter.embedding.engine.plugins.a, d.c
{
  public static final b.a StI;
  private io.flutter.view.c StA;
  private final HashMap<Long, d> StB;
  private final HashMap<Long, com.tencent.mm.videocomposition.d> StC;
  private final HashMap<Long, a> StD;
  private io.flutter.plugin.a.d StE;
  private d.a StF;
  private io.flutter.plugin.a.k StG;
  private io.flutter.plugin.a.k StH;
  private Context context;
  private Handler handler;
  private final Random random;
  private final HashMap<Long, c> uPC;
  private io.flutter.plugin.a.k wJr;
  
  static
  {
    AppMethodBeat.i(199370);
    StI = new b.a((byte)0);
    AppMethodBeat.o(199370);
  }
  
  public b()
  {
    AppMethodBeat.i(199369);
    this.StB = new HashMap();
    this.StC = new HashMap();
    this.uPC = new HashMap();
    this.StD = new HashMap();
    this.random = new Random();
    AppMethodBeat.o(199369);
  }
  
  public final com.tencent.d.a.b a(a.a parama)
  {
    AppMethodBeat.i(199356);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    a locala = (a)this.StD.get(parama.RHk);
    if (locala != null)
    {
      parama = (ad)locala.Sty.get(parama.RHl);
      if (parama != null)
      {
        locala.wet.a(parama);
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199356);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.aa paramaa)
  {
    AppMethodBeat.i(199353);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    Object localObject1 = (a)this.StD.get(paramaa.RHk);
    if (localObject1 != null)
    {
      Object localObject2 = ((a)localObject1).Sty.get(paramaa.RHl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.xeffect.effect.p)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.xeffect.effect.p)localObject1;
      if (localObject1 != null)
      {
        ((com.tencent.mm.xeffect.effect.p)localObject1).a(new f((int)paramaa.RHS.longValue(), (int)paramaa.RHT.longValue(), (float)paramaa.RHU.doubleValue(), (float)paramaa.RHV.doubleValue()));
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199353);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.ab paramab)
  {
    AppMethodBeat.i(199348);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    Object localObject = (d)this.StB.get(paramab.RHW);
    paramab = (a)this.StD.get(paramab.RHk);
    if (localObject != null)
    {
      localObject = ((d)localObject).Gez;
      if (paramab == null) {
        break label89;
      }
    }
    label89:
    for (paramab = paramab.wet;; paramab = null)
    {
      ((com.tencent.mm.videocomposition.n)localObject).GAw = paramab;
      localb.BOc = Boolean.TRUE;
      AppMethodBeat.o(199348);
      return localb;
    }
  }
  
  public final com.tencent.d.a.b a(a.ac paramac)
  {
    AppMethodBeat.i(199355);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    Object localObject1 = (a)this.StD.get(paramac.RHk);
    if (localObject1 != null)
    {
      Object localObject2 = ((a)localObject1).Sty.get(paramac.RHl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof aa)) {
        localObject1 = null;
      }
      localObject1 = (aa)localObject1;
      if (localObject1 != null)
      {
        ((aa)localObject1).setSize((int)paramac.RHy.longValue(), (int)paramac.RHz.longValue());
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199355);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.ad paramad)
  {
    AppMethodBeat.i(199354);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    Object localObject1 = (a)this.StD.get(paramad.RHk);
    if (localObject1 != null)
    {
      Object localObject2 = ((a)localObject1).Sty.get(paramad.RHl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof ab)) {
        localObject1 = null;
      }
      localObject1 = (ab)localObject1;
      if (localObject1 != null)
      {
        localObject2 = paramad.text;
        kotlin.g.b.p.g(localObject2, "arg.text");
        float f = (float)paramad.RHX.doubleValue();
        String str = paramad.fontFamily;
        kotlin.g.b.p.g(str, "arg.fontFamily");
        Boolean localBoolean = paramad.RHY;
        kotlin.g.b.p.g(localBoolean, "arg.italic");
        boolean bool = localBoolean.booleanValue();
        paramad = paramad.RHZ;
        kotlin.g.b.p.g(paramad, "arg.bold");
        ((ab)localObject1).a(new h((String)localObject2, f, str, bool, paramad.booleanValue()));
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199354);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.ae paramae)
  {
    AppMethodBeat.i(199352);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    Object localObject = (a)this.StD.get(paramae.RHk);
    if (localObject != null)
    {
      localObject = (ad)((a)localObject).Sty.get(paramae.RHl);
      if (localObject != null)
      {
        Long localLong = paramae.RHq;
        kotlin.g.b.p.g(localLong, "arg.startTimeMs");
        long l = localLong.longValue();
        paramae = paramae.RHr;
        kotlin.g.b.p.g(paramae, "arg.endTimeMs");
        ((ad)localObject).aH(l, paramae.longValue());
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199352);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.af paramaf)
  {
    AppMethodBeat.i(199323);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (c)this.uPC.get(paramaf.RHo);
    if (localObject != null)
    {
      localObject = ((c)localObject).RhC;
      if (localObject != null)
      {
        paramaf = paramaf.RIa;
        kotlin.g.b.p.g(paramaf, "arg.loop");
        ((com.tencent.mm.videocomposition.play.a)localObject).setLoop(paramaf.booleanValue());
        localb.BOc = Boolean.TRUE;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199323);
      return localb;
      localb.BOc = Boolean.FALSE;
      continue;
      localb.BOc = Boolean.FALSE;
    }
  }
  
  public final com.tencent.d.a.b a(a.ag paramag)
  {
    AppMethodBeat.i(199362);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject1 = (a)this.StD.get(paramag.RHk);
    if (localObject1 != null)
    {
      Object localObject2 = ((a)localObject1).Sty.get(paramag.RHl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof r)) {
        localObject1 = null;
      }
      localObject1 = (r)localObject1;
      if (localObject1 != null)
      {
        paramag = paramag.RHM;
        kotlin.g.b.p.g(paramag, "arg.checkMarker");
        boolean bool = paramag.booleanValue();
        VLogEffectJNI.INSTANCE.setCheckMarker$renderlib_release(((ad)localObject1).ptr, bool);
      }
    }
    AppMethodBeat.o(199362);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.ah paramah)
  {
    AppMethodBeat.i(199363);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    Object localObject1 = (a)this.StD.get(paramah.RHk);
    if (localObject1 != null)
    {
      Object localObject2 = ((a)localObject1).Sty.get(paramah.RHl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof u)) {
        localObject1 = null;
      }
      localObject1 = (u)localObject1;
      if (localObject1 != null)
      {
        int i = (int)paramah.RIb.longValue();
        localObject2 = paramah.text;
        kotlin.g.b.p.g(localObject2, "arg.text");
        float f = (float)paramah.RHX.doubleValue();
        String str = paramah.fontFamily;
        kotlin.g.b.p.g(str, "arg.fontFamily");
        Boolean localBoolean = paramah.RHY;
        kotlin.g.b.p.g(localBoolean, "arg.italic");
        boolean bool = localBoolean.booleanValue();
        paramah = paramah.RHZ;
        kotlin.g.b.p.g(paramah, "arg.bold");
        paramah = new h((String)localObject2, f, str, bool, paramah.booleanValue());
        kotlin.g.b.p.h(paramah, "textInfo");
        VLogEffectJNI.INSTANCE.setPagTemplateText$renderlib_release(((ad)localObject1).ptr, i, paramah);
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199363);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.ai paramai)
  {
    AppMethodBeat.i(199337);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramai == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199337);
      return localb;
      Object localObject = (d)this.StB.get(paramai.RHm);
      if (localObject != null)
      {
        localObject = ((d)localObject).Gez;
        Long localLong = paramai.RIc;
        kotlin.g.b.p.g(localLong, "arg.start");
        long l = localLong.longValue();
        paramai = paramai.end;
        kotlin.g.b.p.g(paramai, "arg.end");
        ((com.tencent.mm.videocomposition.n)localObject).at(l, paramai.longValue());
        localb.BOc = Boolean.TRUE;
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b a(a.aj paramaj)
  {
    AppMethodBeat.i(199366);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (a)this.StD.get(paramaj.RHk);
    if (localObject != null)
    {
      localObject = ((a)localObject).Stz;
      if (localObject != null)
      {
        paramaj = paramaj.MjW;
        kotlin.g.b.p.g(paramaj, "arg.configJson");
        ((com.tencent.mm.xeffect.effect.n)localObject).bpE(paramaj);
      }
    }
    AppMethodBeat.o(199366);
    return localb;
  }
  
  public final com.tencent.d.a.b a(final a.ak paramak)
  {
    Object localObject1 = null;
    AppMethodBeat.i(199367);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    a locala = (a)this.StD.get(paramak.RHk);
    Object localObject2;
    if (locala != null)
    {
      localObject2 = paramak.RHx;
      kotlin.g.b.p.g(localObject2, "arg.enable");
      if ((!((Boolean)localObject2).booleanValue()) || (locala.Stz != null)) {
        break label166;
      }
      localObject2 = locala.wet.a(com.tencent.mm.xeffect.effect.j.Ryg);
      if ((localObject2 instanceof com.tencent.mm.xeffect.effect.n)) {
        break label215;
      }
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.xeffect.effect.n)localObject1;
      if (localObject1 != null)
      {
        locala.Stz = ((com.tencent.mm.xeffect.effect.n)localObject1);
        locala.wet.a((ad)localObject1);
      }
      for (;;)
      {
        localObject1 = (d)this.StB.get(paramak.RHm);
        if (localObject1 != null)
        {
          localObject2 = ((d)localObject1).Gez;
          ((com.tencent.mm.videocomposition.n)localObject2).a((com.tencent.mm.videocomposition.b.e)new i((com.tencent.mm.videocomposition.n)localObject2, ((d)localObject1).Sue, this, paramak));
        }
        AppMethodBeat.o(199367);
        return localb;
        label166:
        if ((!paramak.RHx.booleanValue()) && (locala.Stz != null))
        {
          localObject1 = locala.Stz;
          if (localObject1 != null)
          {
            locala.wet.Ot(((ad)localObject1).id);
            locala.Stz = null;
          }
        }
      }
      label215:
      localObject1 = localObject2;
    }
  }
  
  public final com.tencent.d.a.b a(a.am paramam)
  {
    AppMethodBeat.i(199316);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    com.tencent.mm.videocomposition.d locald = (com.tencent.mm.videocomposition.d)this.StC.get(paramam.RHp);
    if (locald == null)
    {
      localb.BOc = Boolean.FALSE;
      AppMethodBeat.o(199316);
      return localb;
    }
    kotlin.g.b.p.g(locald, "trackMap[arg.trackId] ?:…eturn reply\n            }");
    Object localObject1 = paramam.RHq;
    kotlin.g.b.p.g(localObject1, "arg.startTimeMs");
    locald.KO(((Long)localObject1).longValue());
    localObject1 = paramam.RHr;
    kotlin.g.b.p.g(localObject1, "arg.endTimeMs");
    locald.KP(((Long)localObject1).longValue());
    localObject1 = paramam.RHs;
    if (localObject1 != null) {}
    for (long l = ((Long)localObject1).longValue();; l = 0L)
    {
      locald.KQ(l);
      localObject1 = paramam.RHt;
      kotlin.g.b.p.g(localObject1, "arg.trackEndTimeMs");
      locald.KR(((Long)localObject1).longValue());
      if ((kotlin.g.b.p.j(locald.Rhc.path, paramam.RIg) ^ true)) {
        locald.Rhc.GAn = null;
      }
      localObject1 = locald.Rhc;
      Object localObject2 = paramam.RIg;
      kotlin.g.b.p.g(localObject2, "arg.transitionPath");
      ((com.tencent.mm.videocomposition.k)localObject1).setPath((String)localObject2);
      localObject1 = locald.Rhc;
      localObject2 = paramam.RIh;
      kotlin.g.b.p.g(localObject2, "arg.transitionDuration");
      ((com.tencent.mm.videocomposition.k)localObject1).duration = ((Long)localObject2).longValue();
      locald.dYT = ((int)paramam.RIi.longValue());
      locald.volume = ((float)paramam.RIj.doubleValue());
      localb.BOc = Boolean.TRUE;
      AppMethodBeat.o(199316);
      return localb;
    }
  }
  
  public final com.tencent.d.a.b a(a.an paraman)
  {
    AppMethodBeat.i(199320);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paraman == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199320);
      return localb;
      d locald = (d)this.StB.get(paraman.RHm);
      if (locald == null)
      {
        localb.BOc = Boolean.FALSE;
        AppMethodBeat.o(199320);
        return localb;
      }
      com.tencent.mm.videocomposition.d locald1 = (com.tencent.mm.videocomposition.d)this.StC.get(paraman.RHp);
      if (locald1 != null)
      {
        Map localMap = (Map)locald.StC;
        paraman = paraman.RHp;
        kotlin.g.b.p.g(paraman, "arg.trackId");
        kotlin.g.b.p.g(locald1, "track");
        localMap.put(paraman, locald1);
        locald.Gez.e(locald1);
        localb.BOc = Boolean.TRUE;
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b a(a.ap paramap)
  {
    AppMethodBeat.i(199318);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject2 = (d)this.StB.get(paramap.RHW);
    Object localObject1 = (c)this.uPC.get(paramap.RHo);
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject1 = ((c)localObject1).RhC;
      if (localObject1 != null)
      {
        localObject2 = ((d)localObject2).Gez;
        Boolean localBoolean = paramap.RIk;
        kotlin.g.b.p.g(localBoolean, "arg.playAfterUpdate");
        boolean bool = localBoolean.booleanValue();
        paramap = paramap.RIl;
        kotlin.g.b.p.g(paramap, "arg.seekTo");
        com.tencent.mm.videocomposition.play.a.a((com.tencent.mm.videocomposition.play.a)localObject1, (com.tencent.mm.videocomposition.n)localObject2, bool, paramap.longValue(), 4);
      }
    }
    localb.BOc = Boolean.TRUE;
    AppMethodBeat.o(199318);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.aq paramaq)
  {
    AppMethodBeat.i(199332);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (c)this.uPC.get(paramaq.RHo);
    if (localObject == null)
    {
      localb.BOc = Boolean.FALSE;
      AppMethodBeat.o(199332);
      return localb;
    }
    kotlin.g.b.p.g(localObject, "playerMap[arg.playerId] …eturn reply\n            }");
    com.tencent.mm.videocomposition.play.a locala = ((c)localObject).RhC;
    if ((locala != null) && (!locala.RhI))
    {
      locala = ((c)localObject).RhC;
      if (locala != null)
      {
        SurfaceTexture localSurfaceTexture = ((c)localObject).Gii;
        if (localSurfaceTexture != null)
        {
          localSurfaceTexture.setDefaultBufferSize((int)paramaq.RHy.longValue(), (int)paramaq.RHz.longValue());
          locala.c(localSurfaceTexture, (int)paramaq.RHy.longValue(), (int)paramaq.RHz.longValue());
        }
      }
      ((c)localObject).RhC = locala;
    }
    for (;;)
    {
      localb.BOc = Boolean.TRUE;
      AppMethodBeat.o(199332);
      return localb;
      localObject = ((c)localObject).RhC;
      if (localObject != null) {
        ((com.tencent.mm.videocomposition.play.a)localObject).lX((int)paramaq.RHy.longValue(), (int)paramaq.RHz.longValue());
      }
    }
  }
  
  public final com.tencent.d.a.b a(a.ar paramar)
  {
    AppMethodBeat.i(199330);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    d locald = (d)this.StB.get(paramar.RHm);
    if (locald != null) {
      locald.Gez.t(new Rect((int)paramar.RHN.doubleValue(), (int)paramar.RHO.doubleValue(), (int)paramar.RHP.doubleValue(), (int)paramar.RHQ.doubleValue()));
    }
    for (;;)
    {
      AppMethodBeat.o(199330);
      return localb;
      localb.BOc = Boolean.FALSE;
    }
  }
  
  public final com.tencent.d.a.b a(a.as paramas)
  {
    AppMethodBeat.i(199321);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (d)this.StB.get(paramas.RHm);
    if (localObject == null)
    {
      localb.BOc = Boolean.FALSE;
      AppMethodBeat.o(199321);
      return localb;
    }
    ((d)localObject).StC.remove(paramas.RHp);
    com.tencent.mm.videocomposition.d locald = (com.tencent.mm.videocomposition.d)this.StC.get(paramas.RHp);
    int i;
    int j;
    if (locald != null)
    {
      localObject = ((d)localObject).Gez;
      i = (int)paramas.RIm.longValue();
      kotlin.g.b.p.g(locald, "track");
      kotlin.g.b.p.h(locald, "track");
      j = ((Collection)((com.tencent.mm.videocomposition.n)localObject).Gzn).size();
      if (i >= 0) {
        break label154;
      }
    }
    for (;;)
    {
      localb.BOc = Boolean.TRUE;
      AppMethodBeat.o(199321);
      return localb;
      label154:
      if (j > i) {
        ((com.tencent.mm.videocomposition.n)localObject).Gzn.set(i, locald);
      }
    }
  }
  
  public final com.tencent.d.a.b a(a.c paramc)
  {
    AppMethodBeat.i(199317);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    a locala = (a)this.StD.get(paramc.RHk);
    if (locala != null)
    {
      paramc = (ad)locala.Sty.get(paramc.RHl);
      if (paramc != null)
      {
        locala.wet.Ou(paramc.id);
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199317);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.d paramd)
  {
    AppMethodBeat.i(199342);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    paramd = (d)this.StB.get(paramd.RHm);
    if (paramd != null)
    {
      paramd = paramd.Gez;
      if (paramd != null)
      {
        paramd = paramd.exportSession;
        if (paramd != null) {
          paramd.cancelExport();
        }
      }
    }
    localb.BOc = Boolean.TRUE;
    AppMethodBeat.o(199342);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.e parame)
  {
    AppMethodBeat.i(199358);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    parame = (a)this.StD.get(parame.RHk);
    if (parame != null)
    {
      parame.wet.hiv();
      parame.Sty.clear();
      localb.BOc = Boolean.TRUE;
    }
    AppMethodBeat.o(199358);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.k paramk)
  {
    AppMethodBeat.i(199359);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    paramk = (a)this.StD.remove(paramk.RHk);
    if (paramk != null)
    {
      paramk.wet.destroy();
      paramk.Sty.clear();
      localb.BOc = Boolean.TRUE;
    }
    AppMethodBeat.o(199359);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.m paramm)
  {
    AppMethodBeat.i(199326);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (d)this.StB.get(paramm.RHm);
    if (localObject != null)
    {
      localObject = ((d)localObject).Gez;
      if (localObject != null)
      {
        paramm = paramm.RHx;
        kotlin.g.b.p.g(paramm, "arg.enable");
        ((com.tencent.mm.videocomposition.n)localObject).wB(paramm.booleanValue());
        paramm = x.SXb;
      }
    }
    for (localb.BOc = Boolean.TRUE;; localb.BOc = Boolean.FALSE)
    {
      AppMethodBeat.o(199326);
      return localb;
    }
  }
  
  public final com.tencent.d.a.b a(a.o paramo)
  {
    AppMethodBeat.i(199365);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    paramo = (d)this.StB.get(paramo.RHm);
    if (paramo != null)
    {
      final com.tencent.mm.videocomposition.n localn = paramo.Gez;
      com.tencent.mm.videocomposition.e locale = com.tencent.mm.videocomposition.b.RgQ.fEd();
      if ((locale != null) && (locale.isEnable()))
      {
        new StringBuilder("call getCompositionLabel, id:").append(localn.id);
        locale.a(localn, (kotlin.g.a.b)new e(paramo, localn, this));
      }
    }
    AppMethodBeat.o(199365);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.w paramw)
  {
    AppMethodBeat.i(199357);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    localb.BOc = Boolean.FALSE;
    a locala = (a)this.StD.get(paramw.RHk);
    if (locala != null)
    {
      paramw = (ad)locala.Sty.get(paramw.RHl);
      if (paramw != null)
      {
        locala.wet.Ot(paramw.id);
        localb.BOc = Boolean.TRUE;
      }
    }
    AppMethodBeat.o(199357);
    return localb;
  }
  
  public final com.tencent.d.a.b a(a.x paramx)
  {
    AppMethodBeat.i(199336);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramx == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199336);
      return localb;
      Object localObject = (d)this.StB.get(paramx.RHm);
      if (localObject != null)
      {
        localObject = ((d)localObject).Gez;
        paramx = new Rect((int)paramx.RHN.doubleValue(), (int)paramx.RHO.doubleValue(), (int)paramx.RHP.doubleValue(), (int)paramx.RHQ.doubleValue());
        kotlin.g.b.p.h(paramx, "rect");
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setDisplayScreenCoordinate: ".concat(String.valueOf(paramx)), new Object[0]);
        g localg = ((com.tencent.mm.videocomposition.n)localObject).Rhs;
        if (localg != null) {
          localg.lY(paramx.width(), paramx.height());
        }
        ((com.tencent.mm.videocomposition.n)localObject).viewRect.set(paramx);
        localb.BOc = Boolean.TRUE;
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b a(a.y paramy)
  {
    AppMethodBeat.i(199334);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (d)this.StB.get(paramy.RHm);
    if (localObject != null)
    {
      localObject = ((d)localObject).Gez;
      if (localObject != null)
      {
        ((com.tencent.mm.videocomposition.n)localObject).lW((int)paramy.RHy.longValue(), (int)paramy.RHz.longValue());
        paramy = x.SXb;
      }
    }
    for (localb.BOc = Boolean.TRUE;; localb.BOc = Boolean.FALSE)
    {
      AppMethodBeat.o(199334);
      return localb;
    }
  }
  
  public final com.tencent.d.a.b a(a.z paramz)
  {
    AppMethodBeat.i(199331);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    Object localObject = (c)this.uPC.get(paramz.RHo);
    if (localObject != null)
    {
      localObject = ((c)localObject).RhC;
      if (localObject != null)
      {
        paramz = paramz.RHR;
        kotlin.g.b.p.g(paramz, "arg.timeMs");
        ((com.tencent.mm.videocomposition.play.a)localObject).seekTo(paramz.longValue());
        localb.BOc = Boolean.TRUE;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199331);
      return localb;
      localb.BOc = Boolean.FALSE;
      continue;
      localb.BOc = Boolean.FALSE;
    }
  }
  
  public final a.q a(a.f paramf)
  {
    AppMethodBeat.i(199350);
    a.q localq = new a.q();
    localq.RHG = Long.valueOf(0L);
    a locala = (a)this.StD.get(paramf.RHk);
    if (locala != null)
    {
      com.tencent.mm.xeffect.effect.j localj = (com.tencent.mm.xeffect.effect.j)kotlin.a.e.f(com.tencent.mm.xeffect.effect.j.values(), (int)paramf.RHn.longValue());
      if (localj == null)
      {
        AppMethodBeat.o(199350);
        return localq;
      }
      EffectManager localEffectManager = locala.wet;
      paramf = paramf.zy;
      kotlin.g.b.p.g(paramf, "arg.bytes");
      paramf = localEffectManager.a(localj, paramf);
      if (paramf != null)
      {
        ((Map)locala.Sty).put(Long.valueOf(paramf.ptr), paramf);
        localq.RHG = Long.valueOf(paramf.ptr);
      }
    }
    AppMethodBeat.o(199350);
    return localq;
  }
  
  public final a.q a(a.g paramg)
  {
    AppMethodBeat.i(199349);
    a.q localq = new a.q();
    localq.RHG = Long.valueOf(0L);
    a locala = (a)this.StD.get(paramg.RHk);
    if (locala != null)
    {
      com.tencent.mm.xeffect.effect.j localj = (com.tencent.mm.xeffect.effect.j)kotlin.a.e.f(com.tencent.mm.xeffect.effect.j.values(), (int)paramg.RHn.longValue());
      if (localj == null)
      {
        AppMethodBeat.o(199349);
        return localq;
      }
      EffectManager localEffectManager = locala.wet;
      paramg = paramg.path;
      kotlin.g.b.p.g(paramg, "arg.path");
      paramg = localEffectManager.a(localj, paramg);
      if (paramg != null)
      {
        ((Map)locala.Sty).put(Long.valueOf(paramg.ptr), paramg);
        localq.RHG = Long.valueOf(paramg.ptr);
      }
    }
    AppMethodBeat.o(199349);
    return localq;
  }
  
  public final a.q a(a.i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(199329);
    a.q localq = new a.q();
    Object localObject3 = (d)this.StB.get(parami.RHm);
    Object localObject4 = (c)this.uPC.get(parami.RHo);
    if (localObject4 != null)
    {
      localObject1 = ((c)localObject4).Sud;
      if (localObject1 == null) {
        break label169;
      }
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((c)localObject4).RhC;
      }
      if (localObject1 == null) {
        break label169;
      }
      localObject1 = ((c)localObject4).Sud;
      if (localObject1 == null) {
        break label164;
      }
    }
    label164:
    for (long l = ((io.flutter.view.c.a)localObject1).hxb();; l = 0L)
    {
      localq.RHG = Long.valueOf(l);
      new StringBuilder("createPlayer2 ").append(parami.RHm).append(", reply ").append(localq.RHG);
      AppMethodBeat.o(199329);
      return localq;
      localObject1 = null;
      break;
    }
    label169:
    localObject4 = parami.RHo;
    if ((((Long)localObject4).longValue() <= 0L) || (localObject3 == null))
    {
      localq.RHG = Long.valueOf(-1L);
      new StringBuilder("createPlayer3 ").append(parami.RHm).append(", reply ").append(localq.RHG);
      AppMethodBeat.o(199329);
      return localq;
    }
    localObject2 = ((d)localObject3).Gez;
    Object localObject1 = new c();
    kotlin.g.b.p.g(localObject4, "playerId");
    ((c)localObject1).id = ((Long)localObject4).longValue();
    ((Map)this.uPC).put(localObject4, localObject1);
    localObject3 = this.StA;
    if (localObject3 != null)
    {
      localObject3 = ((io.flutter.view.c)localObject3).hwY();
      ((c)localObject1).Sud = ((io.flutter.view.c.a)localObject3);
      localObject4 = ((com.tencent.mm.videocomposition.n)localObject2).hfp();
      localObject2 = new com.tencent.mm.videocomposition.play.a((com.tencent.mm.videocomposition.n)localObject2);
      SurfaceTexture localSurfaceTexture = ((io.flutter.view.c.a)localObject3).surfaceTexture();
      ((c)localObject1).Gii = localSurfaceTexture;
      if ((((Size)localObject4).getWidth() > 0) && (((Size)localObject4).getHeight() > 0))
      {
        localSurfaceTexture.setDefaultBufferSize(((Size)localObject4).getWidth(), ((Size)localObject4).getHeight());
        kotlin.g.b.p.g(localSurfaceTexture, "surfaceTexture");
        ((com.tencent.mm.videocomposition.play.a)localObject2).c(localSurfaceTexture, ((Size)localObject4).getWidth(), ((Size)localObject4).getHeight());
      }
      ((c)localObject1).RhC = ((com.tencent.mm.videocomposition.play.a)localObject2);
      localq.RHG = Long.valueOf(((io.flutter.view.c.a)localObject3).hxb());
      new StringBuilder("createPlayer4 ").append(parami.RHm).append(", reply ").append(localq.RHG);
    }
    for (;;)
    {
      new StringBuilder("createPlayer6 ").append(parami.RHm).append(", reply ").append(localq.RHG);
      AppMethodBeat.o(199329);
      return localq;
      localq.RHG = Long.valueOf(-1L);
      new StringBuilder("createPlayer5 ").append(parami.RHm).append(", reply ").append(localq.RHG);
    }
  }
  
  public final a.q a(a.j paramj)
  {
    AppMethodBeat.i(199333);
    a.q localq = new a.q();
    Object localObject1 = paramj.path;
    kotlin.g.b.p.g(localObject1, "arg.path");
    localObject1 = new com.tencent.mm.videocomposition.d((String)localObject1, (int)paramj.RHn.longValue());
    Object localObject2 = paramj.RHp;
    kotlin.g.b.p.g(localObject2, "arg.trackId");
    ((com.tencent.mm.videocomposition.d)localObject1).id = ((Long)localObject2).longValue();
    localObject2 = paramj.RHq;
    kotlin.g.b.p.g(localObject2, "arg.startTimeMs");
    ((com.tencent.mm.videocomposition.d)localObject1).KO(((Long)localObject2).longValue());
    localObject2 = paramj.RHr;
    kotlin.g.b.p.g(localObject2, "arg.endTimeMs");
    ((com.tencent.mm.videocomposition.d)localObject1).KP(((Long)localObject2).longValue());
    localObject2 = paramj.RHs;
    kotlin.g.b.p.g(localObject2, "arg.trackStartTimeMs");
    ((com.tencent.mm.videocomposition.d)localObject1).KQ(((Long)localObject2).longValue());
    localObject2 = paramj.RHt;
    kotlin.g.b.p.g(localObject2, "arg.trackEndTimeMs");
    ((com.tencent.mm.videocomposition.d)localObject1).KR(((Long)localObject2).longValue());
    localObject2 = (Map)this.StC;
    Long localLong = paramj.RHp;
    kotlin.g.b.p.g(localLong, "arg.trackId");
    ((Map)localObject2).put(localLong, localObject1);
    localq.RHG = paramj.RHp;
    AppMethodBeat.o(199333);
    return localq;
  }
  
  public final a.q a(a.r paramr)
  {
    AppMethodBeat.i(199319);
    a.q localq = new a.q();
    if (paramr == null) {}
    for (localq.RHG = Long.valueOf(-1L);; localq.RHG = paramr.RHm)
    {
      AppMethodBeat.o(199319);
      return localq;
      d locald = new d();
      Object localObject = paramr.RHm;
      kotlin.g.b.p.g(localObject, "arg.id");
      locald.id = ((Long)localObject).longValue();
      localObject = locald.Gez;
      Long localLong = paramr.RHm;
      kotlin.g.b.p.g(localLong, "arg.id");
      ((com.tencent.mm.videocomposition.n)localObject).id = localLong.longValue();
      localObject = (Map)this.StB;
      localLong = paramr.RHm;
      kotlin.g.b.p.g(localLong, "arg.id");
      ((Map)localObject).put(localLong, locald);
    }
  }
  
  public final a.s a(a.t paramt)
  {
    AppMethodBeat.i(199360);
    a.s locals = new a.s();
    Object localObject = (a)this.StD.get(paramt.RHk);
    if (localObject != null)
    {
      localObject = ((a)localObject).Sty.get(paramt.RHl);
      paramt = (a.t)localObject;
      if (!(localObject instanceof r)) {
        paramt = null;
      }
      paramt = (r)paramt;
      if (paramt != null)
      {
        locals.RHy = Long.valueOf(paramt.ApT.getWidth());
        locals.RHz = Long.valueOf(paramt.ApT.getHeight());
        locals.RHH = Long.valueOf(paramt.RyV);
        locals.RHI = Long.valueOf(paramt.RyW);
      }
    }
    AppMethodBeat.o(199360);
    return locals;
  }
  
  public final a.u a(a.v paramv)
  {
    AppMethodBeat.i(199361);
    a.u localu = new a.u();
    Object localObject1 = (a)this.StD.get(paramv.RHk);
    if (localObject1 != null)
    {
      Object localObject2 = ((a)localObject1).Sty.get(paramv.RHl);
      localObject1 = localObject2;
      if (!(localObject2 instanceof u)) {
        localObject1 = null;
      }
      localObject1 = (u)localObject1;
      if (localObject1 != null)
      {
        localObject2 = (com.tencent.mm.xeffect.effect.q)kotlin.a.e.f(com.tencent.mm.xeffect.effect.q.values(), (int)paramv.RHL.longValue());
        if (localObject2 == null)
        {
          AppMethodBeat.o(199361);
          return localu;
        }
        paramv = paramv.RHM;
        kotlin.g.b.p.g(paramv, "arg.checkMarker");
        boolean bool = paramv.booleanValue();
        kotlin.g.b.p.h(localObject2, "replacementType");
        paramv = VLogEffectJNI.INSTANCE.getPagTemplateInfo$renderlib_release(((ad)localObject1).ptr, (com.tencent.mm.xeffect.effect.q)localObject2, bool);
        localObject2 = (Iterable)paramv;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add((Long)((Pair)((Iterator)localObject2).next()).first);
        }
        localu.RHJ = kotlin.a.j.toLongArray((Collection)localObject1);
        localObject1 = (Iterable)paramv;
        paramv = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramv.add((Long)((Pair)((Iterator)localObject1).next()).second);
        }
        localu.RHK = kotlin.a.j.toLongArray((Collection)paramv);
      }
    }
    AppMethodBeat.o(199361);
    return localu;
  }
  
  public final void a(final a.ao paramao)
  {
    AppMethodBeat.i(199343);
    Object localObject1 = (com.tencent.mm.videocomposition.d)this.StC.get(paramao.RHm);
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.videocomposition.c.RgU;
      kotlin.g.b.p.g(localObject1, "track");
      kotlin.g.b.p.h(localObject1, "$this$copy");
      localObject2 = new com.tencent.mm.videocomposition.d(((com.tencent.mm.videocomposition.d)localObject1).path, ((com.tencent.mm.videocomposition.d)localObject1).type);
      ((com.tencent.mm.videocomposition.d)localObject2).id = ((com.tencent.mm.videocomposition.d)localObject1).id;
      ((com.tencent.mm.videocomposition.d)localObject2).iiw.set(((com.tencent.mm.videocomposition.d)localObject1).iiw);
      ((com.tencent.mm.videocomposition.d)localObject2).Rha.set(((com.tencent.mm.videocomposition.d)localObject1).Rha);
      ((com.tencent.mm.videocomposition.d)localObject2).KQ(((com.tencent.mm.videocomposition.d)localObject1).GGz);
      ((com.tencent.mm.videocomposition.d)localObject2).KR(((com.tencent.mm.videocomposition.d)localObject1).GGA);
      ((com.tencent.mm.videocomposition.d)localObject2).KO(((com.tencent.mm.videocomposition.d)localObject1).startTimeMs);
      ((com.tencent.mm.videocomposition.d)localObject2).KP(((com.tencent.mm.videocomposition.d)localObject1).endTimeMs);
      ((com.tencent.mm.videocomposition.d)localObject2).GJB = ((com.tencent.mm.videocomposition.d)localObject1).GJB;
      ((com.tencent.mm.videocomposition.d)localObject2).Gzu = ((com.tencent.mm.videocomposition.d)localObject1).Gzu;
      ((com.tencent.mm.videocomposition.d)localObject2).Gzv = ((com.tencent.mm.videocomposition.d)localObject1).Gzv;
      Object localObject3 = ((com.tencent.mm.videocomposition.d)localObject1).Rhc;
      kotlin.g.b.p.h(localObject3, "$this$copy");
      com.tencent.mm.videocomposition.k localk = new com.tencent.mm.videocomposition.k(((com.tencent.mm.videocomposition.k)localObject3).path, ((com.tencent.mm.videocomposition.k)localObject3).GAn, ((com.tencent.mm.videocomposition.k)localObject3).duration);
      long l = ((com.tencent.mm.videocomposition.k)localObject3).startTime;
      if (localk.startTime != l)
      {
        localk.startTime = l;
        localk.bGB = true;
      }
      localk.endTime = ((com.tencent.mm.videocomposition.k)localObject3).endTime;
      localk.bGB = ((com.tencent.mm.videocomposition.k)localObject3).bGB;
      kotlin.g.b.p.h(localk, "<set-?>");
      ((com.tencent.mm.videocomposition.d)localObject2).Rhc = localk;
      ((com.tencent.mm.videocomposition.d)localObject2).volume = ((com.tencent.mm.videocomposition.d)localObject1).volume;
      localObject1 = com.tencent.mm.videocomposition.c.a.b((com.tencent.mm.videocomposition.d)localObject2);
      ((com.tencent.mm.videocomposition.c)localObject1).setSize((int)paramao.RHy.longValue(), (int)paramao.RHz.longValue());
      localObject2 = new z.d();
      ((z.d)localObject2).SYE = 0;
      localObject3 = paramao.cTo;
      kotlin.g.b.p.g(localObject3, "arg.times");
      ((com.tencent.mm.videocomposition.c)localObject1).b(kotlin.a.e.h((long[])localObject3), (m)new f((z.d)localObject2, (com.tencent.mm.videocomposition.c)localObject1, this, paramao));
      AppMethodBeat.o(199343);
      return;
    }
    AppMethodBeat.o(199343);
  }
  
  public final void a(final a.n paramn)
  {
    int m = 1;
    AppMethodBeat.i(199341);
    Object localObject1 = this.StB.get(paramn.RHm);
    if (localObject1 == null) {
      kotlin.g.b.p.hyc();
    }
    kotlin.g.b.p.g(localObject1, "compositionDataMap[arg.id]!!");
    localObject1 = (d)localObject1;
    com.tencent.mm.videocomposition.n localn = ((d)localObject1).Gez;
    Object localObject2 = new Size((int)paramn.RHy.longValue(), (int)paramn.RHz.longValue());
    int n = (int)paramn.RHA.longValue();
    int i1 = (int)paramn.RHB.longValue();
    Object localObject3 = paramn.RHC;
    int i;
    int j;
    if (localObject3 != null)
    {
      i = (int)((Long)localObject3).longValue();
      localObject3 = paramn.RHD;
      if (localObject3 == null) {
        break label275;
      }
      j = (int)((Long)localObject3).longValue();
      label133:
      localObject3 = paramn.RHE;
      if (localObject3 == null) {
        break label282;
      }
    }
    label275:
    label282:
    for (int k = (int)((Long)localObject3).longValue();; k = 44100)
    {
      localObject3 = paramn.RHF;
      if (localObject3 != null) {
        m = (int)((Long)localObject3).longValue();
      }
      localObject2 = new n.b((Size)localObject2, n, i1, i, j, k, m);
      new StringBuilder("export crop rect ").append(localn.hfq());
      localObject3 = paramn.path;
      kotlin.g.b.p.g(localObject3, "arg.path");
      localn.a((String)localObject3, (n.b)localObject2, (m)new c(this, paramn, (d)localObject1), (kotlin.g.a.b)new d(this, paramn, (d)localObject1));
      AppMethodBeat.o(199341);
      return;
      i = 1;
      break;
      j = 48000;
      break label133;
    }
  }
  
  public final void a(io.flutter.embedding.engine.plugins.a.b paramb)
  {
    AppMethodBeat.i(199311);
    kotlin.g.b.p.h(paramb, "binding");
    Context localContext = paramb.applicationContext;
    kotlin.g.b.p.g(localContext, "binding.applicationContext");
    io.flutter.plugin.a.c localc = paramb.SOH;
    kotlin.g.b.p.g(localc, "binding.binaryMessenger");
    paramb = paramb.StA;
    kotlin.g.b.p.g(paramb, "binding.textureRegistry");
    this.context = localContext;
    this.StA = paramb;
    this.wJr = new io.flutter.plugin.a.k(localc, "com.tencent.mm/video_composition");
    this.StE = new io.flutter.plugin.a.d(localc, "com.tencent.mm/video_composition/export");
    this.StG = new io.flutter.plugin.a.k(localc, "com.tencent.mm/video_composition/playercallback");
    this.StH = new io.flutter.plugin.a.k(localc, "com.tencent.mm/video_composition/thumblist");
    paramb = this.StE;
    if (paramb != null) {
      paramb.a((d.c)this);
    }
    this.random.setSeed(SystemClock.elapsedRealtime());
    this.handler = new Handler(Looper.getMainLooper());
    paramb = (a.at)this;
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.create", new io.flutter.plugin.a.n()).a(new a.at.1(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.createTrack", new io.flutter.plugin.a.n()).a(new a.at.12(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.addTrack", new io.flutter.plugin.a.n()).a(new a.at.23(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.updateTrack", new io.flutter.plugin.a.n()).a(new a.at.34(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.removeTrack", new io.flutter.plugin.a.n()).a(new a.at.45(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setTrackInfo", new io.flutter.plugin.a.n()).a(new a.at.52(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.getTrackInfo", new io.flutter.plugin.a.n()).a(new a.at.53(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.createComposition", new io.flutter.plugin.a.n()).a(new a.at.54(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.getCompositionDuration", new io.flutter.plugin.a.n()).a(new a.at.55(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.compositionSetPlayRange", new io.flutter.plugin.a.n()).a(new a.at.2(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEnableOriginSound", new io.flutter.plugin.a.n()).a(new a.at.3(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setRenderSize", new io.flutter.plugin.a.n()).a(new a.at.4(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setCompositionRenderArea", new io.flutter.plugin.a.n()).a(new a.at.5(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setTrackRenderArea", new io.flutter.plugin.a.n()).a(new a.at.6(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setTrackCropArea", new io.flutter.plugin.a.n()).a(new a.at.7(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.createPlayer", new io.flutter.plugin.a.n()).a(new a.at.8(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerUpdateDisplaySize", new io.flutter.plugin.a.n()).a(new a.at.9(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerStart", new io.flutter.plugin.a.n()).a(new a.at.10(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerSetLoop", new io.flutter.plugin.a.n()).a(new a.at.11(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerSeek", new io.flutter.plugin.a.n()).a(new a.at.13(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerPause", new io.flutter.plugin.a.n()).a(new a.at.14(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerStop", new io.flutter.plugin.a.n()).a(new a.at.15(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerRelease", new io.flutter.plugin.a.n()).a(new a.at.16(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerSetPlayRange", new io.flutter.plugin.a.n()).a(new a.at.17(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerRefreshSurface", new io.flutter.plugin.a.n()).a(new a.at.18(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.playerUpdateComposition", new io.flutter.plugin.a.n()).a(new a.at.19(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.release", new io.flutter.plugin.a.n()).a(new a.at.20(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.createEffectManager", new io.flutter.plugin.a.n()).a(new a.at.21(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEffectManager", new io.flutter.plugin.a.n()).a(new a.at.22(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.createEffectByPath", new io.flutter.plugin.a.n()).a(new a.at.24(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.createEffectByBinary", new io.flutter.plugin.a.n()).a(new a.at.25(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEffectTimeRange", new io.flutter.plugin.a.n()).a(new a.at.26(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEffectLayout", new io.flutter.plugin.a.n()).a(new a.at.27(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEffectText", new io.flutter.plugin.a.n()).a(new a.at.28(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEffectSize", new io.flutter.plugin.a.n()).a(new a.at.29(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.addEffect", new io.flutter.plugin.a.n()).a(new a.at.30(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.removeEffect", new io.flutter.plugin.a.n()).a(new a.at.31(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.clearEffect", new io.flutter.plugin.a.n()).a(new a.at.32(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.destroyEffectManager", new io.flutter.plugin.a.n()).a(new a.at.33(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.getPAGInfo", new io.flutter.plugin.a.n()).a(new a.at.35(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.getPAGTemplateInfo", new io.flutter.plugin.a.n()).a(new a.at.36(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setPAGEffectCheckMarker", new io.flutter.plugin.a.n()).a(new a.at.37(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setPAGTemplateText", new io.flutter.plugin.a.n()).a(new a.at.38(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.getVieoEnhancementEnabled", new io.flutter.plugin.a.n()).a(new a.at.39(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.getCompositionLabel", new io.flutter.plugin.a.n()).a(new a.at.40(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setVideoEnhancementEffectJsonConfig", new io.flutter.plugin.a.n()).a(new a.at.41(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setVideoEnhancement", new io.flutter.plugin.a.n()).a(new a.at.42(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.bringToFront", new io.flutter.plugin.a.n()).a(new a.at.43(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.updateCropRect", new io.flutter.plugin.a.n()).a(new a.at.44(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setEffectParams", new io.flutter.plugin.a.n()).a(new a.at.46(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.export", new io.flutter.plugin.a.n()).a(new a.at.47(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.cancelExport", new io.flutter.plugin.a.n()).a(new a.at.48(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.requestTrackThumbs", new io.flutter.plugin.a.n()).a(new a.at.49(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setPlayerCallback", new io.flutter.plugin.a.n()).a(new a.at.50(paramb));
    new io.flutter.plugin.a.b(localc, "dev.flutter.pigeon.VideoCompositionApi.setPlayerProfileCallback", new io.flutter.plugin.a.n()).a(new a.at.51(paramb));
    AppMethodBeat.o(199311);
  }
  
  public final void a(Object paramObject, d.a parama)
  {
    AppMethodBeat.i(199368);
    new StringBuilder("onListen, arguments:").append(paramObject);
    this.StF = parama;
    AppMethodBeat.o(199368);
  }
  
  public final a.al b(a.r paramr)
  {
    AppMethodBeat.i(199327);
    a.al localal = new a.al();
    if (paramr == null)
    {
      AppMethodBeat.o(199327);
      return localal;
    }
    paramr = (com.tencent.mm.videocomposition.d)this.StC.get(paramr.RHm);
    if (paramr == null)
    {
      AppMethodBeat.o(199327);
      return localal;
    }
    kotlin.g.b.p.g(paramr, "trackMap[arg.id] ?: run …   return reply\n        }");
    localal.RHq = Long.valueOf(paramr.startTimeMs);
    localal.RHr = Long.valueOf(paramr.endTimeMs);
    localal.RHs = Long.valueOf(paramr.GGz);
    localal.RHt = Long.valueOf(paramr.GGA);
    localal.RId = Long.valueOf(paramr.GJB);
    localal.RIf = Long.valueOf(paramr.Gzv);
    localal.RIe = Long.valueOf(paramr.Gzu);
    AppMethodBeat.o(199327);
    return localal;
  }
  
  public final com.tencent.d.a.b b(a.ai paramai)
  {
    AppMethodBeat.i(199340);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramai == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199340);
      return localb;
      Object localObject = (c)this.uPC.get(paramai.RHm);
      if (localObject != null)
      {
        localObject = ((c)localObject).RhC;
        if (localObject != null)
        {
          Long localLong = paramai.RIc;
          kotlin.g.b.p.g(localLong, "arg.start");
          long l = localLong.longValue();
          paramai = paramai.end;
          kotlin.g.b.p.g(paramai, "arg.end");
          ((com.tencent.mm.videocomposition.play.a)localObject).at(l, paramai.longValue());
          localb.BOc = Boolean.TRUE;
        }
        else
        {
          localb.BOc = Boolean.FALSE;
        }
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b b(a.an paraman)
  {
    AppMethodBeat.i(199322);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paraman == null) {}
    for (localb.BOc = Boolean.FALSE;; localb.BOc = Boolean.TRUE)
    {
      AppMethodBeat.o(199322);
      return localb;
      Object localObject = (d)this.StB.get(paraman.RHm);
      if (localObject == null)
      {
        localb.BOc = Boolean.FALSE;
        AppMethodBeat.o(199322);
        return localb;
      }
      ((d)localObject).StC.remove(paraman.RHp);
      paraman = (com.tencent.mm.videocomposition.d)this.StC.get(paraman.RHp);
      if (paraman != null)
      {
        localObject = ((d)localObject).Gez;
        kotlin.g.b.p.g(paraman, "track");
        kotlin.g.b.p.h(paraman, "track");
        ((com.tencent.mm.videocomposition.n)localObject).Gzn.remove(paraman);
      }
    }
  }
  
  public final com.tencent.d.a.b b(a.x paramx)
  {
    AppMethodBeat.i(199313);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramx == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199313);
      return localb;
      com.tencent.mm.videocomposition.d locald = (com.tencent.mm.videocomposition.d)this.StC.get(paramx.RHm);
      if (locald != null)
      {
        locald.iiw.set((int)paramx.RHN.doubleValue(), (int)paramx.RHO.doubleValue(), (int)paramx.RHP.doubleValue(), (int)paramx.RHQ.doubleValue());
        localb.BOc = Boolean.TRUE;
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final void b(io.flutter.embedding.engine.plugins.a.b paramb)
  {
    AppMethodBeat.i(199312);
    kotlin.g.b.p.h(paramb, "p0");
    this.context = null;
    this.handler = null;
    paramb = this.wJr;
    if (paramb != null) {
      paramb.a(null);
    }
    this.wJr = null;
    paramb = this.StE;
    if (paramb != null) {
      paramb.a(null);
    }
    this.StE = null;
    paramb = this.StG;
    if (paramb != null) {
      paramb.a(null);
    }
    this.StG = null;
    paramb = this.StH;
    if (paramb != null) {
      paramb.a(null);
    }
    this.StH = null;
    paramb = com.tencent.mm.videocomposition.c.RgU;
    com.tencent.mm.videocomposition.c.evK().evictAll();
    AppMethodBeat.o(199312);
  }
  
  public final com.tencent.d.a.b c(a.x paramx)
  {
    AppMethodBeat.i(199314);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramx == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199314);
      return localb;
      com.tencent.mm.videocomposition.d locald = (com.tencent.mm.videocomposition.d)this.StC.get(paramx.RHm);
      if (locald != null)
      {
        locald.Rha.set((int)paramx.RHN.doubleValue(), (int)paramx.RHO.doubleValue(), (int)paramx.RHP.doubleValue(), (int)paramx.RHQ.doubleValue());
        localb.BOc = Boolean.TRUE;
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final a.q c(a.r paramr)
  {
    AppMethodBeat.i(199335);
    a.q localq = new a.q();
    if (paramr == null) {
      localq.RHG = Long.valueOf(-1L);
    }
    for (;;)
    {
      AppMethodBeat.o(199335);
      return localq;
      paramr = (d)this.StB.get(paramr.RHm);
      if (paramr != null) {
        localq.RHG = Long.valueOf(paramr.Gez.getDurationMs());
      }
    }
  }
  
  public final a.q d(a.r paramr)
  {
    AppMethodBeat.i(199351);
    a.q localq = new a.q();
    if (paramr == null) {
      localq.RHG = Long.valueOf(-1L);
    }
    for (;;)
    {
      AppMethodBeat.o(199351);
      return localq;
      paramr = (d)this.StB.get(paramr.RHm);
      if (paramr != null) {
        localq.RHG = Long.valueOf(paramr.Gez.getDurationMs());
      }
    }
  }
  
  public final com.tencent.d.a.b e(a.r paramr)
  {
    AppMethodBeat.i(199338);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramr == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199338);
      return localb;
      paramr = (c)this.uPC.get(paramr.RHm);
      if (paramr != null)
      {
        paramr = paramr.RhC;
        if (paramr != null)
        {
          paramr.start();
          localb.BOc = Boolean.TRUE;
        }
        else
        {
          localb.BOc = Boolean.FALSE;
        }
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b f(a.r paramr)
  {
    AppMethodBeat.i(199315);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramr == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199315);
      return localb;
      paramr = (c)this.uPC.get(paramr.RHm);
      if (paramr != null)
      {
        paramr = paramr.RhC;
        if (paramr != null)
        {
          paramr.pause();
          localb.BOc = Boolean.TRUE;
        }
        else
        {
          localb.BOc = Boolean.FALSE;
        }
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b g(a.r paramr)
  {
    AppMethodBeat.i(199324);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramr == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199324);
      return localb;
      paramr = (c)this.uPC.get(paramr.RHm);
      if (paramr != null)
      {
        paramr = paramr.RhC;
        if (paramr != null)
        {
          paramr.stop();
          localb.BOc = Boolean.TRUE;
        }
        else
        {
          localb.BOc = Boolean.FALSE;
        }
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final com.tencent.d.a.b h(a.r paramr)
  {
    AppMethodBeat.i(199339);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramr == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      AppMethodBeat.o(199339);
      return localb;
      paramr = (c)this.uPC.get(paramr.RHm);
      if (paramr != null)
      {
        Object localObject = paramr.RhC;
        if (localObject != null) {
          ((com.tencent.mm.videocomposition.play.a)localObject).release();
        }
        paramr.RhC = null;
        paramr.RhH = null;
        localObject = paramr.Sud;
        if (localObject != null) {
          ((io.flutter.view.c.a)localObject).release();
        }
        localObject = paramr.Gii;
        if (localObject != null) {
          ((SurfaceTexture)localObject).release();
        }
        this.uPC.remove(Long.valueOf(paramr.id));
        localb.BOc = Boolean.TRUE;
      }
      else
      {
        localb.BOc = Boolean.FALSE;
      }
    }
  }
  
  public final a.q hjx()
  {
    AppMethodBeat.i(199347);
    a.q localq = new a.q();
    localq.RHG = Long.valueOf(0L);
    a locala = new a();
    UUID localUUID = UUID.randomUUID();
    kotlin.g.b.p.g(localUUID, "UUID.randomUUID()");
    long l = localUUID.getMostSignificantBits() & 0xFFFFFFFF;
    ((Map)this.StD).put(Long.valueOf(l), locala);
    localq.RHG = Long.valueOf(l);
    AppMethodBeat.o(199347);
    return localq;
  }
  
  public final com.tencent.d.a.b hjy()
  {
    AppMethodBeat.i(199364);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    com.tencent.mm.videocomposition.e locale = com.tencent.mm.videocomposition.b.RgQ.fEd();
    if (locale != null) {}
    for (boolean bool = locale.isEnable();; bool = false)
    {
      localb.BOc = Boolean.valueOf(bool);
      AppMethodBeat.o(199364);
      return localb;
    }
  }
  
  public final com.tencent.d.a.b hjz()
  {
    AppMethodBeat.i(199325);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    AppMethodBeat.o(199325);
    return localb;
  }
  
  public final com.tencent.d.a.b i(a.r paramr)
  {
    AppMethodBeat.i(199328);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramr == null) {
      localb.BOc = Boolean.FALSE;
    }
    for (;;)
    {
      localb.BOc = Boolean.TRUE;
      AppMethodBeat.o(199328);
      return localb;
      paramr = (c)this.uPC.get(paramr.RHm);
      if (paramr != null)
      {
        paramr = paramr.RhC;
        if (paramr != null) {
          paramr.hft();
        }
      }
    }
  }
  
  public final com.tencent.d.a.b j(a.r paramr)
  {
    AppMethodBeat.i(199346);
    com.tencent.d.a.b localb = new com.tencent.d.a.b();
    if (paramr == null) {}
    for (localb.BOc = Boolean.FALSE;; localb.BOc = Boolean.TRUE)
    {
      AppMethodBeat.o(199346);
      return localb;
      Object localObject = (d)this.StB.get(paramr.RHm);
      if (localObject != null)
      {
        localObject = ((d)localObject).StC;
        if (localObject != null) {
          ((HashMap)localObject).clear();
        }
      }
      this.StB.remove(paramr.RHm);
      paramr = com.tencent.mm.videocomposition.c.RgU;
      com.tencent.mm.videocomposition.c.evK().evictAll();
    }
  }
  
  public final void k(a.r paramr)
  {
    AppMethodBeat.i(199344);
    if (paramr == null)
    {
      AppMethodBeat.o(199344);
      return;
    }
    paramr = (c)this.uPC.get(paramr.RHm);
    if (paramr != null)
    {
      if (paramr.RhC != null)
      {
        if (paramr.RhH != null)
        {
          AppMethodBeat.o(199344);
          return;
        }
        paramr.RhH = ((a.a.a)new g(paramr, this));
        com.tencent.mm.videocomposition.play.a locala = paramr.RhC;
        if (locala == null) {
          break label105;
        }
        locala.setPlayerCallback(paramr.RhH);
      }
      label105:
      for (paramr = x.SXb; paramr == null; paramr = null)
      {
        AppMethodBeat.o(199344);
        return;
      }
      AppMethodBeat.o(199344);
      return;
    }
    AppMethodBeat.o(199344);
  }
  
  public final void l(a.r paramr)
  {
    AppMethodBeat.i(199345);
    if (paramr == null)
    {
      AppMethodBeat.o(199345);
      return;
    }
    paramr = (c)this.uPC.get(paramr.RHm);
    if (paramr != null)
    {
      if (paramr.RhC != null)
      {
        if (paramr.RhE != null)
        {
          AppMethodBeat.o(199345);
          return;
        }
        paramr.RhE = ((a.a.c)new h(paramr, this));
        com.tencent.mm.videocomposition.play.a locala = paramr.RhC;
        if (locala != null)
        {
          locala.RhE = paramr.RhE;
          AppMethodBeat.o(199345);
          return;
        }
      }
      AppMethodBeat.o(199345);
      return;
    }
    AppMethodBeat.o(199345);
  }
  
  public final void sT()
  {
    this.StF = null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$export$1$1"})
  static final class c
    extends kotlin.g.b.q
    implements m<Boolean, Integer, x>
  {
    c(b paramb, a.n paramn, d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "progress", "", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$export$1$2"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Float, x>
  {
    d(b paramb, a.n paramn, d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "labels", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$getCompositionLabel$1$1"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<HashMap<String, Pair<Integer, Long>>, x>
  {
    e(d paramd, com.tencent.mm.videocomposition.n paramn, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$requestTrackThumbs$1$1"})
  static final class f
    extends kotlin.g.b.q
    implements m<Long, Bitmap, x>
  {
    f(z.d paramd, com.tencent.mm.videocomposition.c paramc, b paramb, a.ao paramao)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$setPlayerCallback$1$1$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_editor_videocomposition_release", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$$special$$inlined$let$lambda$1"})
  public static final class g
    implements a.a.a
  {
    g(c paramc, b paramb) {}
    
    public final void Go(long paramLong)
    {
      AppMethodBeat.i(199303);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("playerId", this.StZ.id);
      localJSONObject.put("playerEvent", "onPlayProgress");
      localJSONObject.put("progress", paramLong);
      io.flutter.plugin.a.k localk = b.b(jdField_this);
      if (localk != null)
      {
        localk.a("playerCallback", localJSONObject.toString(), null);
        AppMethodBeat.o(199303);
        return;
      }
      AppMethodBeat.o(199303);
    }
    
    public final void dER()
    {
      AppMethodBeat.i(199304);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("playerId", this.StZ.id);
      localJSONObject.put("playerEvent", "onPlayStarted");
      io.flutter.plugin.a.k localk = b.b(jdField_this);
      if (localk != null)
      {
        localk.a("playerCallback", localJSONObject.toString(), null);
        AppMethodBeat.o(199304);
        return;
      }
      AppMethodBeat.o(199304);
    }
    
    public final void dES()
    {
      AppMethodBeat.i(199305);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("playerId", this.StZ.id);
      localJSONObject.put("playerEvent", "onPlayStop");
      io.flutter.plugin.a.k localk = b.b(jdField_this);
      if (localk != null)
      {
        localk.a("playerCallback", localJSONObject.toString(), null);
        AppMethodBeat.o(199305);
        return;
      }
      AppMethodBeat.o(199305);
    }
    
    public final void dET()
    {
      AppMethodBeat.i(199300);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("playerId", this.StZ.id);
      localJSONObject.put("playerEvent", "onPlayCompleted");
      io.flutter.plugin.a.k localk = b.b(jdField_this);
      if (localk != null)
      {
        localk.a("playerCallback", localJSONObject.toString(), null);
        AppMethodBeat.o(199300);
        return;
      }
      AppMethodBeat.o(199300);
    }
    
    public final void dEU()
    {
      AppMethodBeat.i(199302);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("playerId", this.StZ.id);
      localJSONObject.put("playerEvent", "onPlayFirstFrame");
      io.flutter.plugin.a.k localk = b.b(jdField_this);
      if (localk != null)
      {
        localk.a("playerCallback", localJSONObject.toString(), null);
        AppMethodBeat.o(199302);
        return;
      }
      AppMethodBeat.o(199302);
    }
    
    public final void dEV()
    {
      AppMethodBeat.i(199301);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("playerId", this.StZ.id);
      localJSONObject.put("playerEvent", "onPlayError");
      io.flutter.plugin.a.k localk = b.b(jdField_this);
      if (localk != null)
      {
        localk.a("playerCallback", localJSONObject.toString(), null);
        AppMethodBeat.o(199301);
        return;
      }
      AppMethodBeat.o(199301);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$setPlayerProfileCallback$1$1$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "onSeek", "", "cost", "", "onUpdateComposition", "video_editor_videocomposition_release", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$$special$$inlined$let$lambda$2"})
  public static final class h
    implements a.a.c
  {
    h(c paramc, b paramb) {}
    
    public final void Lc(final long paramLong)
    {
      AppMethodBeat.i(199308);
      com.tencent.mm.videocomposition.c.c.h((kotlin.g.a.a)new kotlin.g.b.q(paramLong) {});
      AppMethodBeat.o(199308);
    }
    
    public final void Ld(final long paramLong)
    {
      AppMethodBeat.i(199309);
      com.tencent.mm.videocomposition.c.c.h((kotlin.g.a.a)new kotlin.g.b.q(paramLong) {});
      AppMethodBeat.o(199309);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$setVideoEnhancement$1$3$1", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "lastTrackPath", "", "getLastTrackPath", "()Ljava/lang/String;", "setLastTrackPath", "(Ljava/lang/String;)V", "onFrameStart", "", "pts", "", "onRelease", "video_editor_videocomposition_release", "com/tencent/video_editor_videocomposition/VideoCompositionApiPlugin$$special$$inlined$let$lambda$3"})
  public static final class i
    implements com.tencent.mm.videocomposition.b.e
  {
    private String GAN = "";
    
    i(com.tencent.mm.videocomposition.n paramn, HashMap paramHashMap, b paramb, a.ak paramak) {}
    
    public final void KM(long paramLong)
    {
      AppMethodBeat.i(199310);
      Object localObject1 = (a)b.d(jdField_this).get(paramak.RHk);
      if (localObject1 != null)
      {
        Object localObject2 = ((a)localObject1).Stz;
        if (localObject2 != null)
        {
          Object localObject3 = ((Iterable)this.GLI.Gzn).iterator();
          int i;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            Object localObject4 = (com.tencent.mm.videocomposition.d)localObject1;
            if ((((com.tencent.mm.videocomposition.d)localObject4).startTimeMs <= paramLong) && (((com.tencent.mm.videocomposition.d)localObject4).endTimeMs > paramLong))
            {
              i = 1;
              label109:
              if (i == 0) {
                break label264;
              }
              label113:
              localObject3 = (com.tencent.mm.videocomposition.d)localObject1;
              if (localObject3 == null) {
                break label272;
              }
              localObject1 = ((com.tencent.mm.videocomposition.d)localObject3).path;
              label132:
              if ((kotlin.g.b.p.j(localObject1, this.GAN) ^ true))
              {
                localObject4 = (Map)this.Sub;
                if (localObject3 == null) {
                  break label278;
                }
                localObject1 = ((com.tencent.mm.videocomposition.d)localObject3).path;
                label167:
                localObject1 = (Pair)((Map)localObject4).get(localObject1);
                if (localObject1 == null) {
                  break label284;
                }
              }
            }
          }
          label264:
          label272:
          label278:
          label284:
          for (localObject1 = (Integer)((Pair)localObject1).first;; localObject1 = null)
          {
            if ((localObject1 != null) && (com.tencent.mm.videocomposition.a.hfg().contains(localObject1))) {
              ((com.tencent.mm.xeffect.effect.n)localObject2).setScene(((Integer)localObject1).intValue());
            }
            if (localObject3 != null)
            {
              localObject2 = ((com.tencent.mm.videocomposition.d)localObject3).path;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            this.GAN = ((String)localObject1);
            AppMethodBeat.o(199310);
            return;
            i = 0;
            break label109;
            break;
            localObject1 = null;
            break label113;
            localObject1 = null;
            break label132;
            localObject1 = null;
            break label167;
          }
        }
        AppMethodBeat.o(199310);
        return;
      }
      AppMethodBeat.o(199310);
    }
    
    public final void onRelease() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.j.b
 * JD-Core Version:    0.7.0.1
 */