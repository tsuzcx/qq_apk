package com.tencent.mm.plugin.flutter.voip.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import com.tencent.c.j.b;
import com.tencent.c.j.c;
import com.tencent.c.j.e;
import com.tencent.c.j.f;
import com.tencent.c.j.h;
import com.tencent.c.j.n;
import com.tencent.c.j.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.flutter.voip.b.a.c;
import com.tencent.mm.plugin.flutter.voip.b.a.d;
import com.tencent.mm.plugin.flutter.voip.b.a.d.a;
import com.tencent.mm.plugin.flutter.voip.b.a.e;
import com.tencent.mm.plugin.flutter.voip.b.a.f;
import com.tencent.mm.plugin.ringtone.g.d;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.PatchedFlutterActivityController.CachedEngineIntentBuilder;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/service/FlutterVoipService;", "Lcom/tencent/mm/plugin/flutter/voip/api/IFlutterVoipService;", "()V", "TAG", "", "engineId", "flutterApi", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$VoIPFlutterApi;", "onSelectResult", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$Result;", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$VirtualBgInfo;", "roomInfoObserver", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "", "", "username", "createVoIPMgr", "", "dispose", "getAvatarPath", "getEngineIdFromIntent", "intent", "Landroid/content/Intent;", "getLaunchIntent", "context", "Landroid/content/Context;", "talkerUsername", "getVideoActivityProxy", "Lcom/tencent/mm/plugin/voip/api/VideoActivityProxy;", "activity", "Landroid/app/Activity;", "jumpToAlbumPreviewUI", "result", "jumpToFinderPreviewUI", "jumpToVirtualBgSetting", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "path", "thumb", "isVideo", "", "onAccepted", "onAudioOutputDeviceChanged", "device", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$AudioDevice;", "onCompleted", "reason", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$CompleteReason;", "onConnected", "roomId", "onError", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$ErrorReason;", "onEvent", "type", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$EventType;", "message", "onModeChanged", "isVideoMode", "onNewState", "action", "newState", "onRespond", "onScreenStateChange", "isScreenOn", "onTextureInfoChanged", "surfaceHolder", "Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterTextureMgr$SurfaceHolder;", "width", "height", "preloadFlutterEngine", "responseRingtoneInfo", "mediaInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.flutter.voip.a.a
{
  public static final b HnG;
  private static j.v HnH;
  private static final androidx.lifecycle.y<r<Integer, Long>> HnI;
  private static String engineId;
  private static String username;
  
  static
  {
    AppMethodBeat.i(263594);
    HnG = new b();
    HnI = b..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(263594);
  }
  
  public static void VU(int paramInt)
  {
    AppMethodBeat.i(263428);
    Object localObject = new j.e();
    ((j.e)localObject).ahhF = Long.valueOf(paramInt);
    j.v localv = HnH;
    if (localv != null) {
      localv.a((j.e)localObject, new b..ExternalSyntheticLambda1(paramInt));
    }
    localObject = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmV;
    com.tencent.mm.plugin.flutter.voip.flutterplugin.b.onConnected();
    AppMethodBeat.o(263428);
  }
  
  private static final void a(int paramInt, Void paramVoid)
  {
    AppMethodBeat.i(263537);
    Log.i("MicroMsg.FlutterVoipService", "callback onConnected(" + paramInt + ')');
    AppMethodBeat.o(263537);
  }
  
  private static final void a(j.h paramh, Void paramVoid)
  {
    AppMethodBeat.i(263584);
    s.u(paramh, "$params");
    Log.i("MicroMsg.FlutterVoipService", "callback onTextureInfoChanged textureId:" + paramh.ahik + ", width:" + paramh.ahhP + ", height:" + paramh.ahhQ);
    AppMethodBeat.o(263584);
  }
  
  private static final void a(j.n paramn, Void paramVoid)
  {
    AppMethodBeat.i(263564);
    s.u(paramn, "$ringtoneInfo");
    Log.i("MicroMsg.FlutterVoipService", "callback responseRingtoneInfo(" + paramn + ')');
    AppMethodBeat.o(263564);
  }
  
  private static final void a(j.v paramv, j.e parame)
  {
    AppMethodBeat.i(263543);
    s.u(parame, "$params");
    paramv.c(parame, b..ExternalSyntheticLambda12.INSTANCE);
    AppMethodBeat.o(263543);
  }
  
  public static void a(com.tencent.mm.plugin.flutter.voip.b.a.a parama)
  {
    AppMethodBeat.i(263477);
    s.u(parama, "device");
    j.e locale = new j.e();
    locale.ahhF = Long.valueOf(parama.ordinal());
    j.v localv = HnH;
    if (localv != null) {
      localv.d(locale, new b..ExternalSyntheticLambda4(parama));
    }
    AppMethodBeat.o(263477);
  }
  
  private static final void a(com.tencent.mm.plugin.flutter.voip.b.a.a parama, Void paramVoid)
  {
    AppMethodBeat.i(263570);
    s.u(parama, "$device");
    Log.i("MicroMsg.FlutterVoipService", "callback onAudioOutputDeviceChanged(" + parama + ')');
    AppMethodBeat.o(263570);
  }
  
  public static void a(a.c paramc)
  {
    AppMethodBeat.i(263461);
    s.u(paramc, "reason");
    j.e locale = new j.e();
    locale.ahhF = Long.valueOf(paramc.ordinal());
    j.v localv = HnH;
    if (localv != null) {
      localv.b(locale, new b..ExternalSyntheticLambda5(paramc));
    }
    paramc = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmV;
    com.tencent.mm.plugin.flutter.voip.flutterplugin.b.fvq();
    AppMethodBeat.o(263461);
  }
  
  private static final void a(a.c paramc, Void paramVoid)
  {
    AppMethodBeat.i(263558);
    s.u(paramc, "$reason");
    Log.i("MicroMsg.FlutterVoipService", "callback onCompleted(" + paramc + ')');
    AppMethodBeat.o(263558);
  }
  
  public static void a(a.e parame)
  {
    AppMethodBeat.i(263440);
    s.u(parame, "reason");
    j.e locale = new j.e();
    locale.ahhF = Long.valueOf(parame.ordinal());
    parame = HnH;
    if (parame != null) {
      com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda13(parame, locale));
    }
    parame = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmV;
    com.tencent.mm.plugin.flutter.voip.flutterplugin.b.fvq();
    AppMethodBeat.o(263440);
  }
  
  public static void a(a.f paramf, String paramString)
  {
    AppMethodBeat.i(263494);
    s.u(paramf, "type");
    j.b localb = new j.b();
    localb.ahig = Long.valueOf(paramf.ordinal());
    localb.message = paramString;
    j.v localv = HnH;
    if (localv != null) {
      localv.a(localb, new b..ExternalSyntheticLambda6(paramf, paramString));
    }
    AppMethodBeat.o(263494);
  }
  
  private static final void a(a.f paramf, String paramString, Void paramVoid)
  {
    AppMethodBeat.i(263579);
    s.u(paramf, "$type");
    Log.i("MicroMsg.FlutterVoipService", "callback onEvent(" + paramf + ", " + paramString + ')');
    AppMethodBeat.o(263579);
  }
  
  public static void a(com.tencent.mm.plugin.flutter.voip.manager.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263512);
    s.u(parama, "surfaceHolder");
    if ((parama.width != paramInt1) || (parama.height != paramInt2))
    {
      parama.width = paramInt1;
      parama.height = paramInt2;
      parama.Hnq.HnK.setDefaultBufferSize(paramInt1, paramInt2);
      com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda14(parama, paramInt1, paramInt2));
    }
    AppMethodBeat.o(263512);
  }
  
  public static void a(d paramd)
  {
    String str = null;
    AppMethodBeat.i(263468);
    Log.i("MicroMsg.FlutterVoipService", s.X("responseRingtoneInfo: ", paramd));
    j.n localn = new j.n();
    if (paramd != null)
    {
      localn.title = paramd.ODz;
      localn.singerName = paramd.ODA;
      localn.nUM = paramd.nUM;
      paramd = paramd.ODy;
      if (paramd != null) {
        break label108;
      }
      paramd = null;
      if (paramd != null) {
        break label133;
      }
      label71:
      if (paramd != null) {
        break label147;
      }
    }
    for (;;)
    {
      localn.vendor = str;
      paramd = HnH;
      if (paramd != null) {
        paramd.a(localn, new b..ExternalSyntheticLambda3(localn));
      }
      AppMethodBeat.o(263468);
      return;
      label108:
      paramd = paramd.acjr;
      if (paramd == null)
      {
        paramd = null;
        break;
      }
      paramd = Integer.valueOf(paramd.oOt);
      break;
      label133:
      if (paramd.intValue() != 0) {
        break label71;
      }
      str = "qq_music";
      continue;
      label147:
      if (paramd.intValue() == 1) {
        str = "qq_music_vip";
      }
    }
  }
  
  private static final void a(boolean paramBoolean, Void paramVoid)
  {
    AppMethodBeat.i(263546);
    Log.i("MicroMsg.FlutterVoipService", s.X("callback onModeChanged: ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(263546);
  }
  
  public static String aDI(String paramString)
  {
    AppMethodBeat.i(263520);
    q.bFp();
    String str = AvatarStorage.R(paramString, true);
    Object localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = str;
        if (com.tencent.mm.vfs.y.ZC(str)) {}
      }
      else
      {
        q.bFp();
        localObject = AvatarStorage.R(paramString, false);
      }
      paramString = com.tencent.mm.vfs.y.n((String)localObject, false);
      if (com.tencent.mm.vfs.y.ZC(paramString)) {
        break;
      }
      AppMethodBeat.o(263520);
      return null;
    }
    AppMethodBeat.o(263520);
    return paramString;
  }
  
  public static void aV(Activity paramActivity)
  {
    AppMethodBeat.i(263412);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(263412);
  }
  
  public static void aW(Activity paramActivity)
  {
    AppMethodBeat.i(263415);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(263415);
  }
  
  private static final void b(com.tencent.mm.plugin.flutter.voip.manager.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263588);
    s.u(parama, "$surfaceHolder");
    j.h localh = new j.h();
    localh.ahik = Long.valueOf(parama.id);
    localh.ahhP = Long.valueOf(paramInt1);
    localh.ahhQ = Long.valueOf(paramInt2);
    localh.ahim = Boolean.FALSE;
    localh.ahil = Long.valueOf(0L);
    parama = HnH;
    if (parama != null) {
      parama.a(localh, new b..ExternalSyntheticLambda2(localh));
    }
    AppMethodBeat.o(263588);
  }
  
  private static final void b(boolean paramBoolean, Void paramVoid)
  {
    AppMethodBeat.i(263574);
    Log.i("MicroMsg.FlutterVoipService", "callback onScreenStateChanged(" + paramBoolean + ')');
    AppMethodBeat.o(263574);
  }
  
  public static void dispose()
  {
    AppMethodBeat.i(263406);
    Log.i("MicroMsg.FlutterVoipService", "dispose()");
    com.tencent.mm.plugin.voip.d.c localc = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.hZN().b(HnI);
    HnH = null;
    username = null;
    engineId = null;
    AppMethodBeat.o(263406);
  }
  
  private static final void f(Void paramVoid) {}
  
  private static void fwo()
  {
    AppMethodBeat.i(263448);
    Object localObject = new j.c();
    ((j.c)localObject).ahhE = Boolean.FALSE;
    j.v localv = HnH;
    if (localv != null) {
      localv.a((j.c)localObject, new b..ExternalSyntheticLambda8(false));
    }
    localObject = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmV;
    com.tencent.mm.plugin.flutter.voip.flutterplugin.b.fvr();
    AppMethodBeat.o(263448);
  }
  
  private static void fwp()
  {
    AppMethodBeat.i(263454);
    j.v localv = HnH;
    if (localv != null) {
      localv.b(b..ExternalSyntheticLambda9.INSTANCE);
    }
    AppMethodBeat.o(263454);
  }
  
  private static final void g(Void paramVoid)
  {
    AppMethodBeat.i(263541);
    Log.i("MicroMsg.FlutterVoipService", "callback onError");
    AppMethodBeat.o(263541);
  }
  
  private static final void h(Void paramVoid)
  {
    AppMethodBeat.i(263548);
    Log.i("MicroMsg.FlutterVoipService", "callback onRespond");
    AppMethodBeat.o(263548);
  }
  
  private static final void h(r paramr)
  {
    AppMethodBeat.i(263535);
    if (paramr != null)
    {
      int i = ((Number)paramr.bsC).intValue();
      long l = ((Number)paramr.bsD).longValue();
      paramr = new j.f();
      paramr.ahii = Long.valueOf(i);
      paramr.ahij = Long.valueOf(l);
      j.v localv = HnH;
      if (localv != null) {
        localv.a(paramr, b..ExternalSyntheticLambda11.INSTANCE);
      }
    }
    AppMethodBeat.o(263535);
  }
  
  private static final void i(Void paramVoid)
  {
    AppMethodBeat.i(263553);
    Log.i("MicroMsg.FlutterVoipService", "callback onAccepted");
    AppMethodBeat.o(263553);
  }
  
  public static void iT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263528);
    Object localObject = a.d.Hmu;
    localObject = a.d.a.VP(paramInt2);
    Log.i("MicroMsg.FlutterVoipService", "onNewState: action=0x" + Integer.toHexString(paramInt1) + ", newState=0x" + Integer.toHexString(paramInt2) + ", status:" + localObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(263528);
      return;
      if (localObject == a.d.Hmx)
      {
        localObject = HnH;
        if (localObject != null) {
          ((j.v)localObject).a(b..ExternalSyntheticLambda10.INSTANCE);
        }
        AppMethodBeat.o(263528);
        return;
        if (localObject == a.d.HmA)
        {
          a(a.c.Hmm);
          AppMethodBeat.o(263528);
          return;
          if (localObject == a.d.HmA)
          {
            a(a.c.Hmn);
            AppMethodBeat.o(263528);
            return;
            if (localObject == a.d.Hmy)
            {
              fwp();
              AppMethodBeat.o(263528);
              return;
              fwo();
              if (localObject == a.d.Hmy)
              {
                fwp();
                AppMethodBeat.o(263528);
                return;
                fwo();
                AppMethodBeat.o(263528);
                return;
                AppMethodBeat.o(263528);
                return;
                if (localObject == a.d.HmA)
                {
                  localObject = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmV;
                  com.tencent.mm.plugin.flutter.voip.flutterplugin.b.fvq();
                  AppMethodBeat.o(263528);
                  return;
                  if (localObject == a.d.HmA)
                  {
                    a(a.c.Hml);
                    AppMethodBeat.o(263528);
                    return;
                    if (localObject == a.d.HmA)
                    {
                      a(a.c.Hmp);
                      AppMethodBeat.o(263528);
                      return;
                      if (localObject == a.d.HmA)
                      {
                        a(a.c.Hmq);
                        AppMethodBeat.o(263528);
                        return;
                        if (localObject == a.d.HmA) {
                          a(a.c.Hmr);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void onScreenStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(263486);
    j.c localc = new j.c();
    localc.ahhE = Boolean.valueOf(paramBoolean);
    j.v localv = HnH;
    if (localv != null) {
      localv.b(localc, new b..ExternalSyntheticLambda7(paramBoolean));
    }
    AppMethodBeat.o(263486);
  }
  
  public final void aDE(String paramString)
  {
    AppMethodBeat.i(263664);
    s.u(paramString, "engineId");
    SubCoreVoip.hVp().a((com.tencent.mm.plugin.voip.a)new com.tencent.mm.plugin.flutter.voip.manager.b(paramString));
    AppMethodBeat.o(263664);
  }
  
  public final Intent aQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(263657);
    s.u(paramContext, "context");
    s.u(paramString, "talkerUsername");
    com.tencent.mm.plugin.voip.a locala = SubCoreVoip.hVp().UBF;
    Object localObject1 = engineId;
    if (((locala instanceof com.tencent.mm.plugin.flutter.voip.manager.b)) && (s.p(locala.getUserName(), paramString))) {
      Log.i("MicroMsg.FlutterVoipService", s.X("getLaunchIntent(): reuse previous engine, engineId=", ((com.tencent.mm.plugin.flutter.voip.manager.b)locala).engineId));
    }
    for (paramString = ((com.tencent.mm.plugin.flutter.voip.manager.b)locala).engineId;; paramString = (String)localObject1)
    {
      localObject1 = com.tencent.mm.plugin.flutter.ui.a.Hlo;
      s.u(paramString, "cachedEngineId");
      paramContext = new PatchedFlutterActivityController.CachedEngineIntentBuilder(VideoActivity.class, paramString).destroyEngineWithActivity(false).backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque).build(paramContext);
      s.s(paramContext, "CachedFlutterActivityCon…          .build(context)");
      paramContext.addFlags(268435456);
      AppMethodBeat.o(263657);
      return paramContext;
      if ((!s.p(paramString, username)) || (localObject1 == null) || (!FlutterEngineCache.getInstance().contains((String)localObject1))) {
        break;
      }
      Log.i("MicroMsg.FlutterVoipService", "getLaunchIntent(): FlutterVoipMgr hasn't been attached, reuse the previous engine");
    }
    Object localObject2 = new StringBuilder("getLaunchIntent(): no reusable FlutterVoipMgr, manager=").append(locala).append(", username=");
    if (locala == null) {}
    for (localObject1 = null;; localObject1 = locala.getUserName())
    {
      Log.i("MicroMsg.FlutterVoipService", localObject1);
      username = paramString;
      Log.i("MicroMsg.FlutterVoipService", "preloadFlutterEngine(" + paramString + ')');
      localObject1 = com.tencent.mm.plugin.flutter.b.b.Hke;
      localObject1 = com.tencent.mm.plugin.flutter.b.b.t("flutter_voip", (kotlin.g.a.b)new b.a(paramString));
      paramString = (String)((r)localObject1).bsC;
      localObject1 = (FlutterEngine)((r)localObject1).bsD;
      SubCoreVoip.hVp().a(MMApplicationContext.getContext(), (com.tencent.mm.plugin.voip.model.x)new a(paramString));
      localObject2 = ((FlutterEngine)localObject1).getPlugins();
      ((PluginRegistry)localObject2).add((FlutterPlugin)new com.tencent.mm.plugin.flutter.voip.flutterplugin.c());
      ((PluginRegistry)localObject2).add((FlutterPlugin)new com.tencent.mm.plugin.flutter.voip.flutterplugin.a());
      ((com.tencent.mm.flutter.plugin.data_sources.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.flutter.plugin.data_sources.b.class)).a((FlutterEngine)localObject1);
      ((com.tencent.mm.plugin.flutter.thumbplayer.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.thumbplayer.a.a.class)).a((FlutterEngine)localObject1);
      HnH = new j.v(((FlutterEngine)localObject1).getDartExecutor().getBinaryMessenger());
      localObject1 = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.hZN().a(HnI);
      engineId = paramString;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.voip.b.a aS(Activity paramActivity)
  {
    AppMethodBeat.i(263670);
    s.u(paramActivity, "activity");
    paramActivity = (com.tencent.mm.plugin.voip.b.a)new com.tencent.mm.plugin.flutter.ui.a((VideoActivity)paramActivity);
    AppMethodBeat.o(263670);
    return paramActivity;
  }
  
  public final String aT(Intent paramIntent)
  {
    AppMethodBeat.i(263661);
    s.u(paramIntent, "intent");
    if (!paramIntent.hasExtra("cached_engine_id"))
    {
      AppMethodBeat.o(263661);
      return null;
    }
    paramIntent = paramIntent.getStringExtra("cached_engine_id");
    AppMethodBeat.o(263661);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.c.b
 * JD-Core Version:    0.7.0.1
 */