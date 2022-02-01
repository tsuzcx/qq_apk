package com.tencent.mm.plugin.flutter.thumbplayer.c;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import com.tencent.c.i.a;
import com.tencent.c.i.c;
import com.tencent.c.i.d;
import com.tencent.c.i.e;
import com.tencent.c.i.f;
import com.tencent.c.i.g;
import com.tencent.c.i.h;
import com.tencent.c.i.i;
import com.tencent.c.i.j;
import com.tencent.c.i.k;
import com.tencent.c.i.l;
import com.tencent.c.i.m;
import com.tencent.c.i.n;
import com.tencent.c.i.o;
import com.tencent.c.i.p;
import com.tencent.c.i.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.a.a;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.a.b;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.e;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.f;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.g;
import com.tencent.mm.plugin.flutter.thumbplayer.b.a.h;
import com.tencent.mm.plugin.thumbplayer.view.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.effect.b.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.j;
import com.tencent.mm.xeffect.effect.l;
import com.tencent.thumbplayer.api.ITPPlayer;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.c;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/plugin/FlutterThumbPlayerPlugin;", "Lcom/tencent/pigeon/TPPlayerApi$Api;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$TPEventSinkProvider;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "activity", "Landroid/app/Activity;", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "idGenerator", "Lkotlin/random/Random;", "playerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer;", "Lkotlin/collections/HashMap;", "textureRegistry", "Lio/flutter/view/TextureRegistry;", "tpEventChannel", "Lio/flutter/plugin/common/EventChannel;", "tpEventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "foundNextId", "getTPEventSink", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "tpAddEffect", "Lcom/tencent/pigeon/TPPlayerApi$TPBoolType;", "arg", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerRenderEffect;", "tpClearEffect", "Lcom/tencent/pigeon/TPPlayerApi$TPIntType;", "tpGetVideoSize", "Lcom/tencent/pigeon/TPPlayerApi$TPVideoSizeRet;", "playerId", "tpPlaySetScaleType", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerScaleTypeParams;", "tpPlayerCreate", "tpPlayerGetPlayRange", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerRange;", "tpPlayerInit", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerInitParams;", "tpPlayerPause", "tpPlayerPlay", "tpPlayerPrepare", "tpPlayerSeek", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSeekParams;", "tpPlayerSetLoop", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSetLoopParams;", "tpPlayerSetMediaInfo", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSetMediaInfoParams;", "tpPlayerSetMediaProto", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSetMediaProtoParams;", "tpPlayerSetMute", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSetMuteParams;", "tpPlayerSetPlayRange", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSetPlayRangeParams;", "tpPlayerSetStreamType", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerSetStreamTypeParams;", "tpRelease", "tpRemoveEffect", "tpSetOnFirstFrameRenderedListener", "tpSetOnPreparedListener", "tpSetProgressListener", "tpStop", "tpUpdateDisplaySize", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerUpdateSizeParams;", "tpUpdateEffect", "toTPType", "", "", "Companion", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends i.a
  implements com.tencent.mm.plugin.flutter.thumbplayer.b.a.b, FlutterPlugin, ActivityAware
{
  public static final a.a Hlg;
  private HashMap<Long, com.tencent.mm.plugin.flutter.thumbplayer.b.a> EEK;
  private c Hlh;
  private EventChannel Hli;
  private EventChannel.EventSink Hlj;
  private Activity activity;
  private TextureRegistry textureRegistry;
  
  static
  {
    AppMethodBeat.i(263237);
    Hlg = new a.a((byte)0);
    AppMethodBeat.o(263237);
  }
  
  public a()
  {
    AppMethodBeat.i(263207);
    this.EEK = new HashMap();
    this.Hlh = kotlin.j.d.BG(Util.currentTicks());
    AppMethodBeat.o(263207);
  }
  
  private static i.d fvg()
  {
    AppMethodBeat.i(263213);
    i.d locald = new i.d();
    locald.ahhF = Long.valueOf(0L);
    AppMethodBeat.o(263213);
    return locald;
  }
  
  private static i.d ro(long paramLong)
  {
    AppMethodBeat.i(263219);
    i.d locald = new i.d();
    locald.ahhF = Long.valueOf(paramLong);
    AppMethodBeat.o(263219);
    return locald;
  }
  
  private static i.c vE(boolean paramBoolean)
  {
    AppMethodBeat.i(263224);
    i.c localc = new i.c();
    localc.ahhE = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(263224);
    return localc;
  }
  
  public final i.c a(i.d paramd)
  {
    AppMethodBeat.i(263294);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263294);
      return paramd;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpPlayerPrepare playerId:", paramd.ahhF));
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263294);
      return paramd;
    }
    Log.i(paramd.TAG, "prepare");
    paramd = paramd.HkG;
    if (paramd != null) {
      paramd.prepare();
    }
    paramd = vE(true);
    AppMethodBeat.o(263294);
    return paramd;
  }
  
  public final i.c a(i.h paramh)
  {
    AppMethodBeat.i(263342);
    if (paramh == null)
    {
      paramh = vE(false);
      AppMethodBeat.o(263342);
      return paramh;
    }
    Object localObject = paramh.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramh = vE(false);
      AppMethodBeat.o(263342);
      return paramh;
    }
    int i = (int)paramh.ahhV.longValue();
    paramh = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkF;
    paramh.nDl = i;
    com.tencent.mm.videocomposition.d.b.i(paramh.TAG, "setScaleType:".concat(String.valueOf(i)), new Object[0]);
    paramh = vE(true);
    AppMethodBeat.o(263342);
    return paramh;
  }
  
  public final i.c a(i.i parami)
  {
    AppMethodBeat.i(263313);
    if (parami == null)
    {
      parami = vE(false);
      AppMethodBeat.o(263313);
      return parami;
    }
    Object localObject = parami.ahhO;
    parami = parami.ahhW;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      parami = vE(false);
      AppMethodBeat.o(263313);
      return parami;
    }
    int i = (int)parami.longValue();
    Log.i(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).TAG, s.X("seek:", Integer.valueOf(i)));
    parami = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkG;
    if (parami != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)parami, i, true, 4);
    }
    parami = vE(true);
    AppMethodBeat.o(263313);
    return parami;
  }
  
  public final i.c a(i.j paramj)
  {
    AppMethodBeat.i(263455);
    if (paramj == null)
    {
      paramj = vE(false);
      AppMethodBeat.o(263455);
      return paramj;
    }
    Object localObject = paramj.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramj = vE(false);
      AppMethodBeat.o(263455);
      return paramj;
    }
    paramj = paramj.ahhX;
    s.s(paramj, "loop");
    boolean bool = paramj.booleanValue();
    paramj = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkG;
    if (paramj != null) {
      paramj.setLoop(bool);
    }
    paramj = vE(true);
    AppMethodBeat.o(263455);
    return paramj;
  }
  
  public final i.c a(i.k paramk)
  {
    AppMethodBeat.i(263280);
    if (paramk == null)
    {
      paramk = vE(false);
      AppMethodBeat.o(263280);
      return paramk;
    }
    Object localObject1 = paramk.ahhO;
    localObject1 = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject1);
    if (localObject1 == null)
    {
      paramk = vE(false);
      AppMethodBeat.o(263280);
      return paramk;
    }
    Object localObject2 = paramk.mediaId;
    String str1 = paramk.path;
    String str2 = paramk.url;
    Long localLong1 = paramk.ahhY;
    Long localLong2 = paramk.ahhZ;
    Boolean localBoolean = paramk.ahib;
    localObject2 = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject2, str1, str2, (int)localLong1.longValue(), (int)localLong2.longValue());
    ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).decodeKey = paramk.decodeKey;
    s.s(localBoolean, "isLocal");
    ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).hJv = localBoolean.booleanValue();
    com.tencent.mm.plugin.flutter.thumbplayer.b.a.a((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1, (com.tencent.mm.plugin.thumbplayer.a.b)localObject2);
    paramk = vE(true);
    AppMethodBeat.o(263280);
    return paramk;
  }
  
  public final i.c a(i.l paraml)
  {
    AppMethodBeat.i(263290);
    if (paraml == null)
    {
      paraml = vE(false);
      AppMethodBeat.o(263290);
      return paraml;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpPlayerSetMediaProto playerId:", paraml.ahhO));
    Object localObject1 = paraml.ahhO;
    localObject1 = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject1);
    if (localObject1 == null)
    {
      paraml = vE(false);
      AppMethodBeat.o(263290);
      return paraml;
    }
    Object localObject2 = com.tencent.mm.plugin.flutter.thumbplayer.b.a.a.values()[((int)paraml.ahic.longValue())];
    paraml = paraml.HkU;
    s.s(paraml, "arg.mediaProto");
    s.u(localObject2, "mediaType");
    s.u(paraml, "mediaProto");
    Log.i(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).TAG, "setMediaProto");
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).fva();
    com.tencent.mm.plugin.flutter.thumbplayer.b.b localb = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkG;
    if (localb != null) {
      localb.aF((kotlin.g.a.b)new a.e((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1));
    }
    localb = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkG;
    if (localb != null) {
      localb.HkT = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a.a)localObject2);
    }
    localObject2 = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkG;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.flutter.thumbplayer.b.b)localObject2).HkU = paraml;
    }
    paraml = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkG;
    if (paraml != null) {
      paraml.Flr = true;
    }
    if (((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkH != null)
    {
      paraml = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkG;
      if (paraml != null) {
        paraml.b(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).HkH, ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject1).isStarted);
      }
    }
    paraml = vE(true);
    AppMethodBeat.o(263290);
    return paraml;
  }
  
  public final i.c a(i.m paramm)
  {
    AppMethodBeat.i(263351);
    if (paramm == null)
    {
      paramm = vE(false);
      AppMethodBeat.o(263351);
      return paramm;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpPlayerSetMute mute:", paramm.ahid));
    Object localObject = paramm.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramm = vE(false);
      AppMethodBeat.o(263351);
      return paramm;
    }
    paramm = paramm.ahid;
    s.s(paramm, "arg.mute");
    boolean bool = paramm.booleanValue();
    paramm = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkG;
    if (paramm != null) {
      paramm.setMute(bool);
    }
    paramm = vE(true);
    AppMethodBeat.o(263351);
    return paramm;
  }
  
  public final i.c a(i.n paramn)
  {
    AppMethodBeat.i(263324);
    if (paramn == null)
    {
      paramn = vE(false);
      AppMethodBeat.o(263324);
      return paramn;
    }
    Object localObject = paramn.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramn = vE(false);
      AppMethodBeat.o(263324);
      return paramn;
    }
    Long localLong = paramn.ahhR;
    s.s(localLong, "arg.startTimeMs");
    long l = ((Number)localLong).longValue();
    paramn = paramn.ahhS;
    s.s(paramn, "arg.endTimeMs");
    paramn = new a.a.a(l, ((Number)paramn).longValue());
    s.u(paramn, "playRange");
    Log.i(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).TAG, "setPlayRange:[" + paramn.startTimeMs + ", " + paramn.endTimeMs + ']');
    localObject = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.flutter.thumbplayer.b.b)localObject).bs(paramn.startTimeMs, paramn.endTimeMs);
    }
    paramn = vE(true);
    AppMethodBeat.o(263324);
    return paramn;
  }
  
  public final i.c a(i.o paramo)
  {
    AppMethodBeat.i(263360);
    if (paramo == null)
    {
      paramo = vE(false);
      AppMethodBeat.o(263360);
      return paramo;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpPlayerSetStreamType streamType:", paramo.ahie));
    Object localObject = paramo.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramo = vE(false);
      AppMethodBeat.o(263360);
      return paramo;
    }
    int i = (int)paramo.ahie.longValue();
    paramo = ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkG;
    if (paramo != null) {
      paramo.TFq = i;
    }
    paramo = vE(true);
    AppMethodBeat.o(263360);
    return paramo;
  }
  
  public final i.c a(i.p paramp)
  {
    AppMethodBeat.i(263370);
    if (paramp == null)
    {
      paramp = vE(false);
      AppMethodBeat.o(263370);
      return paramp;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", "tpUpdateDisplaySize playerId:" + paramp.ahhO + ", width:" + paramp.ahhP + ", height:" + paramp.ahhQ);
    Object localObject = paramp.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramp = vE(false);
      AppMethodBeat.o(263370);
      return paramp;
    }
    int i = (int)paramp.ahhP.longValue();
    int j = (int)paramp.ahhQ.longValue();
    Log.i(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).TAG, "updateRenderSize: [" + i + ',' + j + ']');
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).width = i;
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).height = j;
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkF.setSize(i, j);
    paramp = vE(true);
    AppMethodBeat.o(263370);
    return paramp;
  }
  
  public final i.d a(i.e parame)
  {
    AppMethodBeat.i(263272);
    if (parame == null)
    {
      parame = fvg();
      AppMethodBeat.o(263272);
      return parame;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", "tpPlayerInit playerId:" + parame.ahhO + ", width:" + parame.ahhP + ", height:" + parame.ahhQ);
    Object localObject = parame.ahhO;
    Long localLong = parame.ahhP;
    parame = parame.ahhQ;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      parame = fvg();
      AppMethodBeat.o(263272);
      return parame;
    }
    int i = (int)localLong.longValue();
    int j = (int)parame.longValue();
    Log.i(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).TAG, "init: [" + i + ',' + j + ']');
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).width = i;
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).height = j;
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).surfaceTexture.setDefaultBufferSize(i, j);
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkF.d(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).surfaceTexture, i, j);
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkF.setSurfaceCallback((b.b)localObject);
    parame = ro(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkE);
    AppMethodBeat.o(263272);
    return parame;
  }
  
  public final i.c b(i.d paramd)
  {
    AppMethodBeat.i(263298);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263298);
      return paramd;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpPlayerPlay playerId:", paramd.ahhF));
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263298);
      return paramd;
    }
    Log.i(paramd.TAG, "start");
    paramd.isStarted = true;
    paramd = paramd.HkG;
    if (paramd != null) {
      paramd.hLh();
    }
    paramd = vE(true);
    AppMethodBeat.o(263298);
    return paramd;
  }
  
  public final i.c b(i.g paramg)
  {
    AppMethodBeat.i(263404);
    if (paramg == null)
    {
      paramg = vE(false);
      AppMethodBeat.o(263404);
      return paramg;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpAddEffect playerId:", paramg.ahhO));
    Object localObject1 = paramg.ahhO;
    com.tencent.mm.plugin.flutter.thumbplayer.b.a locala = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject1);
    if (locala == null)
    {
      paramg = vE(false);
      AppMethodBeat.o(263404);
      return paramg;
    }
    s.u(paramg, "effect");
    Log.i(locala.TAG, s.X("createRenderEffect type:", paramg.ahhU));
    localObject1 = paramg.ahhU;
    s.s(localObject1, "effect.effectType");
    long l = ((Number)localObject1).longValue();
    Object localObject2 = a.a.b.values();
    int k = localObject2.length;
    int i = 0;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if (l == ((a.a.b)localObject1).ordinal())
      {
        j = 1;
        label167:
        if (j == 0) {
          break label305;
        }
        label172:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a.a.b.HkJ;
        }
        switch (com.tencent.mm.plugin.flutter.thumbplayer.b.a.c.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        default: 
          localObject1 = null;
          if (localObject1 != null)
          {
            Log.i(locala.TAG, "addRenderEffect");
            locala.HkF.GpO.b((af)localObject1);
            localObject2 = (Map)locala.HkI;
            paramg = paramg.ahhT;
            s.s(paramg, "effect.effectId");
            ((Map)localObject2).put(paramg, localObject1);
          }
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramg = vE(bool);
      AppMethodBeat.o(263404);
      return paramg;
      j = 0;
      break label167;
      label305:
      i += 1;
      break;
      localObject1 = null;
      break label172;
      localObject1 = (String)paramg.params.get("radius");
      double d1;
      label346:
      double d2;
      if (localObject1 == null)
      {
        d1 = -1.0D;
        localObject1 = (String)paramg.params.get("sampleFactor");
        if (localObject1 != null) {
          break label431;
        }
        d2 = -1.0D;
        label373:
        localObject1 = locala.HkF.GpO.a(j.agYb);
        if (!(localObject1 instanceof com.tencent.mm.xeffect.effect.b)) {
          break label441;
        }
        localObject1 = (com.tencent.mm.xeffect.effect.b)localObject1;
        label404:
        if (localObject1 != null) {
          break label447;
        }
        localObject1 = null;
      }
      for (;;)
      {
        localObject1 = (af)localObject1;
        break;
        d1 = Double.parseDouble((String)localObject1);
        break label346;
        label431:
        d2 = Double.parseDouble((String)localObject1);
        break label373;
        label441:
        localObject1 = null;
        break label404;
        label447:
        ((com.tencent.mm.xeffect.effect.b)localObject1).setRadius((float)d1);
        ((com.tencent.mm.xeffect.effect.b)localObject1).eC((float)d2);
      }
      localObject1 = (String)paramg.params.get("contentOffsetPercent");
      if (localObject1 != null) {
        Double.parseDouble((String)localObject1);
      }
      localObject1 = (String)paramg.params.get("contentOffsetPx");
      if (localObject1 != null) {
        Double.parseDouble((String)localObject1);
      }
      localObject1 = (String)paramg.params.get("radius");
      if (localObject1 == null)
      {
        d1 = -1.0D;
        label547:
        localObject1 = (String)paramg.params.get("blurTop");
        if (localObject1 != null) {
          Boolean.parseBoolean((String)localObject1);
        }
        localObject1 = (String)paramg.params.get("blurBottom");
        if (localObject1 != null) {
          Boolean.parseBoolean((String)localObject1);
        }
        localObject1 = (String)paramg.params.get("blurMaskRatio");
        if (localObject1 != null) {
          Double.parseDouble((String)localObject1);
        }
        localObject1 = locala.HkF.GpO.a(j.agXZ);
        if (!(localObject1 instanceof l)) {
          break label689;
        }
        localObject1 = (l)localObject1;
        label662:
        if (localObject1 != null) {
          break label695;
        }
        localObject1 = null;
      }
      for (;;)
      {
        localObject1 = (af)localObject1;
        break;
        d1 = Double.parseDouble((String)localObject1);
        break label547;
        label689:
        localObject1 = null;
        break label662;
        label695:
        ((l)localObject1).setRadius((float)d1);
      }
    }
  }
  
  public final i.c c(i.d paramd)
  {
    AppMethodBeat.i(263306);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263306);
      return paramd;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpPause playerId:", paramd.ahhF));
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263306);
      return paramd;
    }
    Log.i(paramd.TAG, "pause");
    paramd.isStarted = false;
    paramd = paramd.HkG;
    if (paramd != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)paramd);
    }
    paramd = vE(true);
    AppMethodBeat.o(263306);
    return paramd;
  }
  
  public final i.c c(i.g paramg)
  {
    AppMethodBeat.i(263411);
    if (paramg == null)
    {
      paramg = vE(false);
      AppMethodBeat.o(263411);
      return paramg;
    }
    Object localObject = paramg.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramg = vE(false);
      AppMethodBeat.o(263411);
      return paramg;
    }
    paramg = vE(((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).a(paramg));
    AppMethodBeat.o(263411);
    return paramg;
  }
  
  public final i.c d(i.g paramg)
  {
    AppMethodBeat.i(263414);
    if (paramg == null)
    {
      paramg = vE(false);
      AppMethodBeat.o(263414);
      return paramg;
    }
    Object localObject = paramg.ahhO;
    localObject = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (localObject == null)
    {
      paramg = vE(false);
      AppMethodBeat.o(263414);
      return paramg;
    }
    s.u(paramg, "effect");
    paramg = paramg.ahhT;
    ((com.tencent.mm.plugin.flutter.thumbplayer.b.a)localObject).HkI.get(paramg);
    paramg = vE(true);
    AppMethodBeat.o(263414);
    return paramg;
  }
  
  public final i.f d(i.d paramd)
  {
    long l2 = -1L;
    AppMethodBeat.i(263332);
    Object localObject = new i.f();
    ((i.f)localObject).ahhR = Long.valueOf(-1L);
    ((i.f)localObject).ahhS = Long.valueOf(-1L);
    if (paramd == null)
    {
      AppMethodBeat.o(263332);
      return localObject;
    }
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(263332);
      return localObject;
    }
    localObject = paramd.HkG;
    long l1;
    if (localObject == null)
    {
      l1 = -1L;
      paramd = paramd.HkG;
      if (paramd != null) {
        break label171;
      }
    }
    for (;;)
    {
      paramd = new a.a.a(l1, l2);
      localObject = new i.f();
      ((i.f)localObject).ahhR = Long.valueOf(paramd.startTimeMs);
      ((i.f)localObject).ahhS = Long.valueOf(paramd.endTimeMs);
      AppMethodBeat.o(263332);
      return localObject;
      l1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).GmG;
      break;
      label171:
      l2 = paramd.TFp;
    }
  }
  
  public final i.c e(i.d paramd)
  {
    AppMethodBeat.i(263382);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263382);
      return paramd;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpStop playerId:", paramd.ahhF));
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263382);
      return paramd;
    }
    Log.i(paramd.TAG, "stop");
    paramd.isStarted = false;
    paramd = paramd.HkG;
    if (paramd != null) {
      paramd.stop();
    }
    paramd = vE(true);
    AppMethodBeat.o(263382);
    return paramd;
  }
  
  public final i.c f(i.d paramd)
  {
    AppMethodBeat.i(263390);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263390);
      return paramd;
    }
    Log.i("MicroMsg.FlutterThumbPlayerPlugin", s.X("tpRelease playerId:", paramd.ahhF));
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263390);
      return paramd;
    }
    Log.i(paramd.TAG, "release");
    paramd.isStarted = false;
    com.tencent.mm.plugin.flutter.thumbplayer.b.b localb = paramd.HkG;
    if (localb != null) {
      localb.eLO();
    }
    localb = paramd.HkG;
    if (localb != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localb);
    }
    localb = paramd.HkG;
    if (localb != null) {
      localb.stop();
    }
    localb = paramd.HkG;
    if (localb != null) {
      localb.recycle();
    }
    paramd.HkG = null;
    paramd.HkC.release();
    paramd.HkF.release();
    paramd = vE(true);
    AppMethodBeat.o(263390);
    return paramd;
  }
  
  public final EventChannel.EventSink fvb()
  {
    return this.Hlj;
  }
  
  public final i.d fvf()
  {
    AppMethodBeat.i(263262);
    Object localObject = this.textureRegistry;
    if (localObject == null)
    {
      localObject = fvg();
      AppMethodBeat.o(263262);
      return localObject;
    }
    for (long l = this.Hlh.Zn(); this.EEK.containsKey(Long.valueOf(l)); l = this.Hlh.Zn()) {}
    localObject = ((TextureRegistry)localObject).createSurfaceTexture();
    if (localObject == null)
    {
      localObject = fvg();
      AppMethodBeat.o(263262);
      return localObject;
    }
    localObject = new com.tencent.mm.plugin.flutter.thumbplayer.b.a((TextureRegistry.SurfaceTextureEntry)localObject, (com.tencent.mm.plugin.flutter.thumbplayer.b.a.b)this);
    ((Map)this.EEK).put(Long.valueOf(l), localObject);
    localObject = ro(l);
    AppMethodBeat.o(263262);
    return localObject;
  }
  
  public final i.c g(i.d paramd)
  {
    AppMethodBeat.i(263422);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263422);
      return paramd;
    }
    paramd = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263422);
      return paramd;
    }
    paramd.HkF.GpO.jQl();
    paramd.HkI.clear();
    paramd = vE(true);
    AppMethodBeat.o(263422);
    return paramd;
  }
  
  public final i.c h(i.d paramd)
  {
    AppMethodBeat.i(263430);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263430);
      return paramd;
    }
    Object localObject = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263430);
      return paramd;
    }
    s.s(localObject, "playerId");
    long l = ((Long)localObject).longValue();
    localObject = paramd.HkG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.flutter.thumbplayer.b.b)localObject).a((e)new a.h(l, paramd), 33L);
    }
    paramd = vE(true);
    AppMethodBeat.o(263430);
    return paramd;
  }
  
  public final i.c i(i.d paramd)
  {
    AppMethodBeat.i(263439);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263439);
      return paramd;
    }
    Object localObject = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263439);
      return paramd;
    }
    s.s(localObject, "playerId");
    long l = ((Long)localObject).longValue();
    localObject = paramd.HkG;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).TFg = ((kotlin.g.a.b)new a.g(l, paramd));
      if (((com.tencent.mm.plugin.thumbplayer.e.b)localObject).cxs()) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).b((ITPPlayer)((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flb);
      }
    }
    paramd = vE(true);
    AppMethodBeat.o(263439);
    return paramd;
  }
  
  public final i.c j(i.d paramd)
  {
    AppMethodBeat.i(263446);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263446);
      return paramd;
    }
    Object localObject = paramd.ahhF;
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(localObject);
    if (paramd == null)
    {
      paramd = vE(false);
      AppMethodBeat.o(263446);
      return paramd;
    }
    s.s(localObject, "playerId");
    long l = ((Long)localObject).longValue();
    localObject = paramd.HkG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.flutter.thumbplayer.b.b)localObject).aH((kotlin.g.a.b)new a.f(l, paramd));
    }
    paramd = vE(true);
    AppMethodBeat.o(263446);
    return paramd;
  }
  
  public final i.q k(i.d paramd)
  {
    i.q localq = null;
    int k = 0;
    AppMethodBeat.i(263462);
    s.u(paramd, "playerId");
    paramd = (com.tencent.mm.plugin.flutter.thumbplayer.b.a)this.EEK.get(paramd.ahhF);
    int i;
    if (paramd == null)
    {
      paramd = localq;
      localq = new i.q();
      if (paramd != null) {
        break label169;
      }
      i = 0;
      label56:
      localq.ahhP = Long.valueOf(i);
      if (paramd != null) {
        break label197;
      }
      i = k;
    }
    for (;;)
    {
      localq.ahhQ = Long.valueOf(i);
      AppMethodBeat.o(263462);
      return localq;
      Object localObject = paramd.HkG;
      paramd = localq;
      if (localObject == null) {
        break;
      }
      paramd = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flb;
      if (paramd == null)
      {
        i = 0;
        label118:
        paramd = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flb;
        if (paramd != null) {
          break label159;
        }
      }
      label159:
      for (int j = 0;; j = paramd.getVideoHeight())
      {
        paramd = new r(Integer.valueOf(i), Integer.valueOf(j));
        break;
        i = paramd.getVideoWidth();
        break label118;
      }
      label169:
      localObject = (Integer)paramd.bsC;
      if (localObject == null)
      {
        i = 0;
        break label56;
      }
      i = ((Integer)localObject).intValue();
      break label56;
      label197:
      paramd = (Integer)paramd.bsD;
      i = k;
      if (paramd != null) {
        i = paramd.intValue();
      }
    }
  }
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(263469);
    s.u(paramActivityPluginBinding, "binding");
    this.activity = paramActivityPluginBinding.getActivity();
    AppMethodBeat.o(263469);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263243);
    s.u(paramFlutterPluginBinding, "flutterPluginBinding");
    i.a.a(paramFlutterPluginBinding.getBinaryMessenger(), (i.a)this);
    this.textureRegistry = paramFlutterPluginBinding.getTextureRegistry();
    this.Hli = new EventChannel(paramFlutterPluginBinding.getBinaryMessenger(), "tp_player/event");
    paramFlutterPluginBinding = this.Hli;
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setStreamHandler((EventChannel.StreamHandler)new b(this));
    }
    AppMethodBeat.o(263243);
  }
  
  public final void onDetachedFromActivity()
  {
    this.activity = null;
  }
  
  public final void onDetachedFromActivityForConfigChanges()
  {
    this.activity = null;
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263248);
    s.u(paramFlutterPluginBinding, "flutterPluginBinding");
    paramFlutterPluginBinding = this.Hli;
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setStreamHandler(null);
    }
    this.EEK.clear();
    AppMethodBeat.o(263248);
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(263485);
    s.u(paramActivityPluginBinding, "binding");
    this.activity = paramActivityPluginBinding.getActivity();
    AppMethodBeat.o(263485);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/thumbplayer/plugin/FlutterThumbPlayerPlugin$onAttachedToEngine$1", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "onCancel", "", "p0", "", "onListen", "eventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements EventChannel.StreamHandler
  {
    b(a parama) {}
    
    public final void onCancel(Object paramObject)
    {
      AppMethodBeat.i(263205);
      a.a(this.Hlk, null);
      AppMethodBeat.o(263205);
    }
    
    public final void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
    {
      AppMethodBeat.i(263200);
      s.u(paramEventSink, "eventSink");
      a.a(this.Hlk, paramEventSink);
      AppMethodBeat.o(263200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */