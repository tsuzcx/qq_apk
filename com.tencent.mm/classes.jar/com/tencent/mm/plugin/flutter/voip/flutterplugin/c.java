package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.c.j.c;
import com.tencent.c.j.d;
import com.tencent.c.j.e;
import com.tencent.c.j.g;
import com.tencent.c.j.j;
import com.tencent.c.j.k;
import com.tencent.c.j.l;
import com.tencent.c.j.m;
import com.tencent.c.j.r;
import com.tencent.c.j.s;
import com.tencent.c.j.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.hf;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.media.util.d.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.flutter.ui.CachedFlutterActivity.b;
import com.tencent.mm.plugin.flutter.voip.b.a.a.a;
import com.tencent.mm.plugin.flutter.voip.b.a.d;
import com.tencent.mm.plugin.flutter.voip.b.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bh;
import com.tencent.threadpool.i;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoipPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$VoIPPluginApi;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "activity", "Landroid/app/Activity;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "engineId", "", "isFreshLaunch", "", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "textureMgr", "Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterTextureMgr;", "voipMgr", "Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr;", "accept", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLBoolType;", "arg", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$AcceptParams;", "cancel", "clearVirtualBackground", "", "getAudioOutputDevice", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLIntType;", "getConnectedTime", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getRingStreamType", "getSmallStreamAspectRatio", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLDoubleType;", "getStatus", "getTextureId", "getUserInfo", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$UserInfoParams;", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLStringType;", "hangUp", "isCaller", "isCameraFloatable", "isFrontCamera", "isMuted", "isScreenInteractive", "isScreenSplited", "isSplitScreenSupported", "isVideoMode", "minimize", "params", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$MinimizeParams;", "result", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$Result;", "observePermission", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToActivity", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onBooted", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "onRendered", "pauseRing", "prepareTextures", "queryGPURating", "", "()Ljava/lang/Long;", "reject", "releaseTexture", "reportFps", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FpsParams;", "requestRingtoneInfo", "requestRingtoneMute", "restartRing", "resumeRing", "setFinderVirtualBackground", "info", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FinderVirtualBgInfo;", "setImageVirtualBackground", "imagePath", "setMuted", "setRingtoneSelf", "setSegmentVirtualBackground", "segmentMode", "(Ljava/lang/Long;)V", "setSpeakerEnabled", "setVideoVirtualBackground", "videoPath", "switchCamera", "switchToVoiceMode", "toggleSplitScreen", "updateTextureSize", "sizeParam", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$UpdateTextureSizeParams;", "toVoipType", "(Ljava/lang/Boolean;)Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLBoolType;", "", "(Ljava/lang/Float;)Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLDoubleType;", "", "(Ljava/lang/Integer;)Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLIntType;", "(Ljava/lang/Long;)Lcom/tencent/pigeon/VoIPFlutterPluginApi$FLIntType;", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends j.x
  implements q, FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler
{
  public static final c.a Hne;
  private com.tencent.mm.plugin.flutter.voip.manager.a Hnf;
  private boolean Hng;
  private com.tencent.mm.plugin.flutter.voip.manager.b Hnh;
  private Activity activity;
  private MethodChannel channel;
  private aq coroutineScope;
  private String engineId;
  private final androidx.lifecycle.s lifecycle;
  
  static
  {
    AppMethodBeat.i(263547);
    Hne = new c.a((byte)0);
    AppMethodBeat.o(263547);
  }
  
  public c()
  {
    AppMethodBeat.i(263490);
    this.lifecycle = new androidx.lifecycle.s((q)this);
    this.Hng = true;
    aq localaq = ar.kBZ();
    ar.a(localaq, null);
    ah localah = ah.aiuX;
    this.coroutineScope = localaq;
    AppMethodBeat.o(263490);
  }
  
  private static final void E(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(263523);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(263523);
  }
  
  private static final void a(Activity paramActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(263518);
    kotlin.g.b.s.u(paramActivity, "$activity");
    paramDialogInterface.dismiss();
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramActivity);
    AppMethodBeat.o(263518);
  }
  
  private static final void a(c paramc, com.tencent.mm.plugin.flutter.voip.manager.b paramb)
  {
    AppMethodBeat.i(263506);
    kotlin.g.b.s.u(paramc, "this$0");
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("executing clear engine: activity=", paramc.activity));
    if (paramc.activity == null)
    {
      paramc = com.tencent.mm.plugin.flutter.b.b.Hke;
      com.tencent.mm.plugin.flutter.b.b.clear(paramb.engineId);
    }
    AppMethodBeat.o(263506);
  }
  
  private static final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(263513);
    kotlin.g.b.s.u(paramc, "this$0");
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("executing clear engine: activity=", paramc.activity));
    if (paramc.activity == null)
    {
      paramc = com.tencent.mm.plugin.flutter.b.b.Hke;
      com.tencent.mm.plugin.flutter.b.b.clear(paramString);
    }
    AppMethodBeat.o(263513);
  }
  
  private static final boolean b(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(263533);
    kotlin.g.b.s.u(paramActivity, "$activity");
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    if (paramInt != 19)
    {
      AppMethodBeat.o(263533);
      return false;
    }
    Resources localResources = MMApplicationContext.getResources();
    int j = paramArrayOfString.length;
    int i = 0;
    paramInt = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (paramArrayOfInt[paramInt] != 0)
      {
        paramArrayOfString = (Context)paramActivity;
        if (kotlin.g.b.s.p(str, "android.permission.CAMERA")) {}
        for (paramInt = b.g.permission_camera_request_again_msg;; paramInt = b.g.permission_microphone_request_again_msg)
        {
          com.tencent.mm.ui.base.k.a(paramArrayOfString, localResources.getString(paramInt), localResources.getString(b.g.permission_tips_title), localResources.getString(b.g.jump_to_settings), localResources.getString(b.g.app_cancel), false, new c..ExternalSyntheticLambda0(paramActivity), c..ExternalSyntheticLambda1.INSTANCE);
          AppMethodBeat.o(263533);
          return true;
        }
      }
      i += 1;
      paramInt += 1;
    }
    AppMethodBeat.o(263533);
    return true;
  }
  
  private static j.c y(Boolean paramBoolean)
  {
    AppMethodBeat.i(263495);
    if (paramBoolean == null) {}
    for (boolean bool = false;; bool = paramBoolean.booleanValue())
    {
      paramBoolean = new j.c();
      paramBoolean.ahhE = Boolean.valueOf(bool);
      AppMethodBeat.o(263495);
      return paramBoolean;
    }
  }
  
  public final j.c a(com.tencent.c.j.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(263645);
    kotlin.g.b.s.u(parama, "arg");
    Log.i("MicroMsg.FlutterVoipPlugin", "accept(" + parama.ahif + ')');
    parama = parama.ahif;
    kotlin.g.b.s.s(parama, "arg.needSwitchToVoice");
    if (parama.booleanValue())
    {
      parama = this.Hnh;
      if (parama == null) {}
      for (parama = localObject1;; parama = Boolean.valueOf(parama.hVI()))
      {
        parama = y(parama);
        AppMethodBeat.o(263645);
        return parama;
      }
    }
    parama = this.Hnh;
    if (parama == null) {}
    for (parama = localObject2;; parama = Boolean.valueOf(parama.fvX()))
    {
      parama = y(parama);
      AppMethodBeat.o(263645);
      return parama;
    }
  }
  
  public final j.e a(j.e parame)
  {
    long l2 = 0L;
    AppMethodBeat.i(263679);
    kotlin.g.b.s.u(parame, "arg");
    int i = (int)parame.ahhF.longValue();
    parame = this.Hnf;
    if (parame != null)
    {
      parame = (com.tencent.mm.plugin.flutter.voip.manager.a.a)parame.Hnn.bl(i);
      if (parame != null) {
        Log.i("MicroMsg.FlutterVoipPlugin", "getCameraTextureId, textureId:" + parame.id + ", renderType:" + i);
      }
    }
    for (long l1 = parame.id;; l1 = 0L)
    {
      parame = Long.valueOf(l1);
      if (parame == null) {}
      for (l1 = l2;; l1 = parame.longValue())
      {
        parame = new j.e();
        parame.ahhF = Long.valueOf(l1);
        AppMethodBeat.o(263679);
        return parame;
      }
    }
  }
  
  public final j.s a(j.g paramg)
  {
    AppMethodBeat.i(263686);
    kotlin.g.b.s.u(paramg, "arg");
    String str = paramg.value;
    j.s locals = new j.s();
    paramg = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    locals.AmC = com.tencent.mm.plugin.flutter.voip.c.b.aDI(str);
    locals.displayName = aa.getDisplayName(str);
    locals.username = str;
    switch (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str).sex)
    {
    default: 
      paramg = "unknown";
    }
    for (;;)
    {
      locals.ahit = paramg;
      locals.ahiv = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str));
      locals.ahiu = Boolean.valueOf(au.bwO(str));
      AppMethodBeat.o(263686);
      return locals;
      paramg = "male";
      continue;
      paramg = "female";
    }
  }
  
  public final void a(final j.c paramc)
  {
    AppMethodBeat.i(263650);
    kotlin.g.b.s.u(paramc, "arg");
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("setSpeakerEnabled: ", paramc.ahhE));
    kotlinx.coroutines.j.a(this.coroutineScope, (f)bg.kCi(), null, (m)new f(this, paramc, null), 2);
    Log.i("MicroMsg.FlutterVoipPlugin", "setSpeakerEnabled ended");
    AppMethodBeat.o(263650);
  }
  
  public final void a(j.g paramg, j.m<j.c> paramm)
  {
    AppMethodBeat.i(263706);
    if (paramg == null) {}
    for (Object localObject = null;; localObject = paramg.value)
    {
      Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("setRingtoneSelf: ", localObject));
      kotlinx.coroutines.j.a(this.coroutineScope, null, null, (m)new c.e(paramg, paramm, this, null), 3);
      AppMethodBeat.o(263706);
      return;
    }
  }
  
  public final void a(j.j paramj)
  {
    AppMethodBeat.i(263832);
    if (paramj == null)
    {
      AppMethodBeat.o(263832);
      return;
    }
    Object localObject = paramj.ahin;
    paramj = paramj.LYS;
    ca localca = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi();
    kotlin.g.b.s.s(localObject, "finderObjectId");
    paramj = localca.J(((Long)localObject).longValue(), paramj).bsD;
    if ((paramj instanceof FinderObject)) {}
    for (paramj = (FinderObject)paramj;; paramj = null)
    {
      if (paramj != null)
      {
        localObject = com.tencent.mm.plugin.voip.video.a.d.UPM;
        com.tencent.mm.plugin.voip.video.a.d.S(paramj);
      }
      AppMethodBeat.o(263832);
      return;
    }
  }
  
  public final void a(j.k paramk)
  {
    AppMethodBeat.i(263780);
    kotlin.g.b.s.u(paramk, "params");
    b localb = b.HmV;
    paramk = paramk.ahip;
    kotlin.g.b.s.s(paramk, "params.slowFrameRate");
    b.N(((Number)paramk).doubleValue());
    AppMethodBeat.o(263780);
  }
  
  public final void a(j.l paraml, final j.m<j.c> paramm)
  {
    AppMethodBeat.i(263624);
    kotlin.g.b.s.u(paraml, "params");
    kotlin.g.b.s.u(paramm, "result");
    Log.i("MicroMsg.FlutterVoipPlugin", "minimize: activity=" + this.activity + ", needPop=" + paraml.ahir);
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      if (!paraml.ahiq.booleanValue())
      {
        paramm.success(y(Boolean.FALSE));
        AppMethodBeat.o(263624);
        return;
      }
      Log.e("MicroMsg.FlutterVoipPlugin", "minimize, permission denied");
      paraml = MMApplicationContext.getContext();
      RequestFloatWindowPermissionDialog.a(paraml, paraml.getString(b.g.voip_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new b(this, paramm), com.tencent.mm.bq.a.aQB());
      AppMethodBeat.o(263624);
      return;
    }
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (boolean bool = false;; bool = ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).Gn(true))
    {
      localObject = this.Hnf;
      if (localObject != null) {
        ((com.tencent.mm.plugin.flutter.voip.manager.a)localObject).releaseAll();
      }
      paraml = paraml.ahir;
      kotlin.g.b.s.s(paraml, "params.needPop");
      if (paraml.booleanValue())
      {
        paraml = this.activity;
        if (paraml != null) {
          paraml.finish();
        }
      }
      paramm.success(y(Boolean.valueOf(bool)));
      AppMethodBeat.o(263624);
      return;
    }
  }
  
  public final void a(j.m<j.c> paramm)
  {
    AppMethodBeat.i(263628);
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).roomId))
    {
      Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("switchCamera, this.roomId:", localObject));
      localObject = this.Hnh;
      if (localObject != null) {
        ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).aL((kotlin.g.a.b)new c.g(paramm, this));
      }
      AppMethodBeat.o(263628);
      return;
    }
  }
  
  public final void a(j.r paramr)
  {
    AppMethodBeat.i(263682);
    kotlin.g.b.s.u(paramr, "sizeParam");
    AppMethodBeat.o(263682);
  }
  
  public final void aDF(String paramString)
  {
    AppMethodBeat.i(263805);
    if (paramString == null)
    {
      AppMethodBeat.o(263805);
      return;
    }
    com.tencent.mm.plugin.voip.video.a.d locald = com.tencent.mm.plugin.voip.video.a.d.UPM;
    com.tencent.mm.plugin.voip.video.a.d.bfQ(paramString);
    AppMethodBeat.o(263805);
  }
  
  public final void aDG(String paramString)
  {
    AppMethodBeat.i(263812);
    if (paramString == null)
    {
      AppMethodBeat.o(263812);
      return;
    }
    com.tencent.mm.plugin.voip.video.a.d locald = com.tencent.mm.plugin.voip.video.a.d.UPM;
    com.tencent.mm.plugin.voip.video.a.d.setImage(paramString);
    AppMethodBeat.o(263812);
  }
  
  public final void b(j.c paramc)
  {
    AppMethodBeat.i(263666);
    kotlin.g.b.s.u(paramc, "arg");
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("setMuted(", paramc.ahhE));
    com.tencent.mm.plugin.flutter.voip.manager.b localb = this.Hnh;
    if (localb != null)
    {
      paramc = paramc.ahhE;
      kotlin.g.b.s.s(paramc, "arg.value");
      localb.vH(paramc.booleanValue());
    }
    AppMethodBeat.o(263666);
  }
  
  public final void b(j.e parame)
  {
    AppMethodBeat.i(263683);
    kotlin.g.b.s.u(parame, "arg");
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("releaseTexture, textureId:", parame.ahhF));
    com.tencent.mm.plugin.flutter.voip.manager.a locala = this.Hnf;
    Long localLong;
    if (locala != null)
    {
      localLong = parame.ahhF;
      if (localLong != null) {
        if (localLong != null) {
          break label115;
        }
      }
    }
    label115:
    for (parame = null;; parame = (com.tencent.mm.plugin.flutter.voip.manager.a.a)locala.Hnn.get(localLong.longValue(), null))
    {
      if (parame != null)
      {
        parame.Hnq.HnM = null;
        locala.Hno.add(parame);
        parame.Hnq.fwh();
      }
      locala.Hnn.remove(localLong.longValue());
      Log.i(locala.TAG, kotlin.g.b.s.X("release flutter texture ", localLong));
      AppMethodBeat.o(263683);
      return;
    }
  }
  
  public final void b(j.g paramg)
  {
    AppMethodBeat.i(263687);
    kotlin.g.b.s.u(paramg, "arg");
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("requestRingtoneInfo: ", paramg.value));
    kotlinx.coroutines.j.a(this.coroutineScope, null, null, (m)new c.d(paramg, null), 3);
    AppMethodBeat.o(263687);
  }
  
  public final void c(j.c paramc)
  {
    AppMethodBeat.i(263692);
    if (paramc == null) {}
    for (paramc = null; paramc == null; paramc = paramc.ahhE)
    {
      AppMethodBeat.o(263692);
      return;
    }
    boolean bool = paramc.booleanValue();
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("requestRingtoneMute: ", Boolean.valueOf(bool)));
    ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).setMute(bool);
    AppMethodBeat.o(263692);
  }
  
  public final j.d d(j.c paramc)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(263718);
    kotlin.g.b.s.u(paramc, "arg");
    com.tencent.mm.plugin.flutter.voip.manager.b localb = this.Hnh;
    if (localb == null)
    {
      f1 = 0.0F;
      paramc = Float.valueOf(f1);
      if (paramc != null) {
        break label133;
      }
    }
    label133:
    for (float f1 = f2;; f1 = paramc.floatValue())
    {
      paramc = new j.d();
      paramc.ahih = Double.valueOf(f1);
      AppMethodBeat.o(263718);
      return paramc;
      paramc = paramc.ahhE;
      kotlin.g.b.s.s(paramc, "arg.value");
      boolean bool = paramc.booleanValue();
      Log.i("MicroMsg.FlutterVoipMgr", "getSmallStreamSizeRatio, roomId:" + localb.roomId + ", isLocal:" + bool);
      SubCoreVoip.hVp();
      f1 = u.Gv(bool);
      break;
    }
  }
  
  public final j.c fvA()
  {
    AppMethodBeat.i(263662);
    Log.i("MicroMsg.FlutterVoipPlugin", "switchToVoiceMode()");
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).hVZ()))
    {
      localObject = y((Boolean)localObject);
      AppMethodBeat.o(263662);
      return localObject;
    }
  }
  
  public final void fvB()
  {
    AppMethodBeat.i(263671);
    Log.i("MicroMsg.FlutterVoipPlugin", "hangUp()");
    com.tencent.mm.plugin.flutter.voip.manager.b localb = this.Hnh;
    if (localb != null) {
      localb.hVH();
    }
    AppMethodBeat.o(263671);
  }
  
  public final void fvC()
  {
    AppMethodBeat.i(263675);
    Log.i("MicroMsg.FlutterVoipPlugin", "prepareTextures");
    com.tencent.mm.plugin.flutter.voip.manager.b localb = this.Hnh;
    if (localb != null)
    {
      com.tencent.mm.plugin.flutter.voip.manager.a locala = this.Hnf;
      if (locala != null) {
        locala.a(localb);
      }
    }
    AppMethodBeat.o(263675);
  }
  
  public final j.e fvD()
  {
    AppMethodBeat.i(263691);
    int i = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType();
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("getRingStreamType: ", Integer.valueOf(i)));
    Object localObject = Integer.valueOf(i);
    if (localObject == null) {}
    for (i = 0;; i = ((Integer)localObject).intValue())
    {
      localObject = new j.e();
      ((j.e)localObject).ahhF = Long.valueOf(i);
      AppMethodBeat.o(263691);
      return localObject;
    }
  }
  
  public final void fvE()
  {
    AppMethodBeat.i(263695);
    Log.i("MicroMsg.FlutterVoipPlugin", "pauseRing");
    ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).pausePlay();
    AppMethodBeat.o(263695);
  }
  
  public final void fvF()
  {
    AppMethodBeat.i(263701);
    Log.i("MicroMsg.FlutterVoipPlugin", "resumeRing");
    ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).resumePlay();
    AppMethodBeat.o(263701);
  }
  
  public final void fvG()
  {
    AppMethodBeat.i(263704);
    Log.i("MicroMsg.FlutterVoipPlugin", "restartRing");
    com.tencent.mm.plugin.flutter.voip.manager.b localb = this.Hnh;
    if (localb != null) {
      localb.hVP();
    }
    AppMethodBeat.o(263704);
  }
  
  public final j.c fvH()
  {
    boolean bool = true;
    AppMethodBeat.i(263709);
    j.c localc = new j.c();
    if (af.lXY.lST == 1) {}
    for (;;)
    {
      localc.ahhE = Boolean.valueOf(bool);
      AppMethodBeat.o(263709);
      return localc;
      bool = false;
    }
  }
  
  public final j.e fvI()
  {
    AppMethodBeat.i(263713);
    j.e locale = new j.e();
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = Long.valueOf(0L);; localObject = Long.valueOf(((NewVoipMgr)localObject).Uxj))
    {
      locale.ahhF = ((Long)localObject);
      AppMethodBeat.o(263713);
      return locale;
    }
  }
  
  public final j.c fvJ()
  {
    AppMethodBeat.i(263722);
    j.c localc = new j.c();
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = Boolean.FALSE;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).hVi()))
    {
      localc.ahhE = ((Boolean)localObject);
      AppMethodBeat.o(263722);
      return localc;
    }
  }
  
  public final j.c fvK()
  {
    AppMethodBeat.i(263730);
    j.c localc = new j.c();
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = Boolean.FALSE;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).isMuted()))
    {
      localc.ahhE = ((Boolean)localObject);
      AppMethodBeat.o(263730);
      return localc;
    }
  }
  
  public final j.e fvL()
  {
    AppMethodBeat.i(263737);
    j.e locale = new j.e();
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (int i = 2;; i = ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).fvZ())
    {
      localObject = com.tencent.mm.plugin.flutter.voip.b.a.a.Hmf;
      locale.ahhF = Long.valueOf(a.a.a.VO(i).ordinal());
      AppMethodBeat.o(263737);
      return locale;
    }
  }
  
  public final j.e fvM()
  {
    AppMethodBeat.i(263748);
    j.e locale = new j.e();
    locale.ahhF = Long.valueOf(a.d.Hmv.ordinal());
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).getState()))
    {
      AppMethodBeat.o(263748);
      return locale;
    }
    int i = ((Integer)localObject).intValue();
    localObject = a.d.Hmu;
    locale.ahhF = Long.valueOf(a.d.a.VP(i).ordinal());
    AppMethodBeat.o(263748);
    return locale;
  }
  
  public final j.c fvN()
  {
    AppMethodBeat.i(263755);
    Object localObject = this.activity;
    if (localObject == null)
    {
      localObject = y(Boolean.FALSE);
      AppMethodBeat.o(263755);
      return localObject;
    }
    bh.mN((Context)localObject);
    if ((aw.jkS()) || (aj.aAy(((Activity)localObject).getTaskId()))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = y(Boolean.valueOf(bool));
      AppMethodBeat.o(263755);
      return localObject;
    }
  }
  
  public final void fvO()
  {
    AppMethodBeat.i(263762);
    Activity localActivity = this.activity;
    if (localActivity == null)
    {
      AppMethodBeat.o(263762);
      return;
    }
    Boolean localBoolean = fvP().ahhE;
    kotlin.g.b.s.s(localBoolean, "isScreenSplited.value");
    if (localBoolean.booleanValue())
    {
      Log.i("MicroMsg.FlutterVoipPlugin", "merge screen");
      ag.nX(localActivity.getTaskId(), 0);
      AppMethodBeat.o(263762);
      return;
    }
    Log.i("MicroMsg.FlutterVoipPlugin", "split screen");
    ag.nX(localActivity.getTaskId(), 2);
    AppMethodBeat.o(263762);
  }
  
  public final j.c fvP()
  {
    AppMethodBeat.i(263769);
    Object localObject = this.activity;
    if (localObject == null)
    {
      localObject = y(Boolean.FALSE);
      AppMethodBeat.o(263769);
      return localObject;
    }
    bh.mN((Context)localObject);
    if ((!aw.jkS()) && (!aj.aAy(((Activity)localObject).getTaskId())))
    {
      localObject = y(Boolean.FALSE);
      AppMethodBeat.o(263769);
      return localObject;
    }
    if (aw.aAj(((Activity)localObject).getTaskId()))
    {
      localObject = y(Boolean.TRUE);
      AppMethodBeat.o(263769);
      return localObject;
    }
    localObject = y(Boolean.FALSE);
    AppMethodBeat.o(263769);
    return localObject;
  }
  
  public final j.c fvQ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(263775);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = ((Context)localObject2).getSystemService("keyguard");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
      AppMethodBeat.o(263775);
      throw ((Throwable)localObject1);
    }
    localObject1 = (KeyguardManager)localObject1;
    localObject2 = ((Context)localObject2).getSystemService("power");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(263775);
      throw ((Throwable)localObject1);
    }
    localObject2 = (PowerManager)localObject2;
    boolean bool3 = ((KeyguardManager)localObject1).isKeyguardLocked();
    localObject1 = this.activity;
    if (localObject1 == null)
    {
      bool1 = true;
      boolean bool4 = ((PowerManager)localObject2).isInteractive();
      if (((!bool1) && (bool3)) || (!bool4)) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = y(Boolean.valueOf(bool1));
      AppMethodBeat.o(263775);
      return localObject1;
      bool1 = ((Activity)localObject1).hasWindowFocus();
      break;
    }
  }
  
  public final Long fvR()
  {
    AppMethodBeat.i(263794);
    long l = com.tencent.mm.media.util.d.nFC.bqn();
    AppMethodBeat.o(263794);
    return Long.valueOf(l);
  }
  
  public final void fvS()
  {
    AppMethodBeat.i(263839);
    com.tencent.mm.plugin.voip.video.a.d locald = com.tencent.mm.plugin.voip.video.a.d.UPM;
    com.tencent.mm.plugin.voip.video.a.d.GT(false);
    AppMethodBeat.o(263839);
  }
  
  public final void fvo()
  {
    AppMethodBeat.i(263786);
    b localb = b.HmV;
    b.fvo();
    AppMethodBeat.o(263786);
  }
  
  public final void fvp()
  {
    AppMethodBeat.i(263637);
    Log.i("MicroMsg.FlutterVoipPlugin", "onRendered()");
    b localb = b.HmV;
    b.fvp();
    AppMethodBeat.o(263637);
  }
  
  public final j.c fvw()
  {
    AppMethodBeat.i(263617);
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).fvV()))
    {
      localObject = y((Boolean)localObject);
      AppMethodBeat.o(263617);
      return localObject;
    }
  }
  
  public final j.c fvx()
  {
    boolean bool2 = false;
    AppMethodBeat.i(263633);
    Object localObject = this.Hnh;
    boolean bool1;
    if (localObject == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      localObject = y(Boolean.valueOf(bool1));
      AppMethodBeat.o(263633);
      return localObject;
      localObject = ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).UwT;
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.voip.video.render.j)localObject).UTc;
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icu();
        }
      }
    }
  }
  
  public final j.c fvy()
  {
    AppMethodBeat.i(263653);
    Log.i("MicroMsg.FlutterVoipPlugin", "cancel()");
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).fvY()))
    {
      localObject = y((Boolean)localObject);
      AppMethodBeat.o(263653);
      return localObject;
    }
  }
  
  public final j.c fvz()
  {
    AppMethodBeat.i(263658);
    Log.i("MicroMsg.FlutterVoipPlugin", "isVideoMode()");
    Object localObject = this.Hnh;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).hVh()))
    {
      localObject = y((Boolean)localObject);
      AppMethodBeat.o(263658);
      return localObject;
    }
  }
  
  public final androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)this.lifecycle;
  }
  
  public final void j(Long paramLong)
  {
    AppMethodBeat.i(263819);
    if (paramLong == null)
    {
      AppMethodBeat.o(263819);
      return;
    }
    com.tencent.mm.plugin.voip.video.a.d locald = com.tencent.mm.plugin.voip.video.a.d.UPM;
    paramLong = com.tencent.mm.plugin.xlabeffect.k.e.values()[((int)paramLong.longValue())];
    kotlin.g.b.s.u(paramLong, "mode");
    Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, kotlin.g.b.s.X("setSegmentBgBlur: ", paramLong));
    com.tencent.mm.plugin.voip.video.a.d.icT();
    com.tencent.mm.plugin.voip.video.a.d.a(locald);
    com.tencent.mm.plugin.voip.video.a.d.UPN = paramLong;
    AppMethodBeat.o(263819);
  }
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(263604);
    kotlin.g.b.s.u(paramActivityPluginBinding, "binding");
    this.activity = paramActivityPluginBinding.getActivity();
    Object localObject1 = this.activity;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.engineId = ((String)localObject1);
      Log.i("MicroMsg.FlutterVoipPlugin", "onAttachedToActivity: " + this.activity + ", isFreshLaunch=" + this.Hng);
      paramActivityPluginBinding.getActivity().getWindow().addFlags(6815872);
      paramActivityPluginBinding.getActivity().setRequestedOrientation(7);
      localObject1 = paramActivityPluginBinding.getActivity().getWindow();
      if (Build.VERSION.SDK_INT < 30) {
        break label232;
      }
      ((Window)localObject1).setDecorFitsSystemWindows(false);
    }
    for (;;)
    {
      if (!(SubCoreVoip.hVp().UBF instanceof com.tencent.mm.plugin.flutter.voip.manager.b))
      {
        localObject1 = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
        localObject2 = paramActivityPluginBinding.getActivity().getIntent();
        kotlin.g.b.s.s(localObject2, "binding.activity.intent");
        localObject1 = ((com.tencent.mm.plugin.flutter.voip.c.b)localObject1).aT((Intent)localObject2);
        kotlin.g.b.s.checkNotNull(localObject1);
        com.tencent.mm.plugin.flutter.voip.c.b.HnG.aDE((String)localObject1);
      }
      localObject1 = SubCoreVoip.hVp().UBF;
      if (localObject1 != null) {
        break label252;
      }
      paramActivityPluginBinding = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.voip.manager.FlutterVoipMgr");
      AppMethodBeat.o(263604);
      throw paramActivityPluginBinding;
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = com.tencent.mm.plugin.flutter.voip.c.b.HnG.aT((Intent)localObject1);
      break;
      label232:
      localObject1 = ((Window)localObject1).getDecorView();
      ((View)localObject1).setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x700);
    }
    label252:
    localObject1 = (com.tencent.mm.plugin.flutter.voip.manager.b)localObject1;
    this.Hnh = ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject1);
    Object localObject2 = paramActivityPluginBinding.getActivity();
    kotlin.g.b.s.s(localObject2, "binding.activity");
    kotlin.g.b.s.u(localObject2, "activity");
    Log.i("MicroMsg.FlutterVoipMgr", "onActivityAttached");
    ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject1).activity = ((Activity)localObject2);
    localObject2 = this.activity;
    kotlin.g.b.s.checkNotNull(localObject2);
    if (!((com.tencent.mm.plugin.flutter.voip.manager.b)localObject1).aT((Activity)localObject2))
    {
      ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject1).finish();
      paramActivityPluginBinding.getActivity().finish();
      this.Hnh = null;
      AppMethodBeat.o(263604);
      return;
    }
    if (this.Hng)
    {
      if (((com.tencent.mm.plugin.flutter.voip.manager.b)localObject1).hVh())
      {
        localObject2 = this.Hnf;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.flutter.voip.manager.a)localObject2).a((com.tencent.mm.plugin.flutter.voip.manager.b)localObject1);
        }
      }
      this.Hng = false;
      if (com.tencent.mm.kernel.h.baz()) {
        SubCoreVoip.hVp().bp(false, false);
      }
      localObject1 = paramActivityPluginBinding.getActivity();
      if (!(localObject1 instanceof VideoActivity)) {
        break label613;
      }
      localObject1 = (VideoActivity)localObject1;
      label405:
      if (localObject1 != null) {
        break label618;
      }
      localObject1 = null;
      label411:
      if (!(localObject1 instanceof com.tencent.mm.plugin.flutter.ui.a)) {
        break label626;
      }
      localObject1 = (com.tencent.mm.plugin.flutter.ui.a)localObject1;
      label423:
      if (localObject1 != null)
      {
        localObject2 = (CachedFlutterActivity.b)new c.c(this);
        kotlin.g.b.s.u(localObject2, "listener");
        ((com.tencent.mm.plugin.flutter.ui.a)localObject1).Hln = ((CachedFlutterActivity.b)localObject2);
      }
      com.tencent.mm.plugin.flutter.voip.manager.b localb = this.Hnh;
      if (localb != null)
      {
        localObject2 = paramActivityPluginBinding.getActivity();
        kotlin.g.b.s.s(localObject2, "binding.activity");
        if (!(localObject2 instanceof q)) {
          break label631;
        }
        localObject1 = (q)localObject2;
        label488:
        if (localObject1 != null)
        {
          localObject1 = ((q)localObject1).getLifecycle();
          if (localObject1 != null) {
            ((androidx.lifecycle.j)localObject1).addObserver((p)new FlutterVoipPlugin.observePermission.1(this));
          }
        }
        if (!com.tencent.mm.plugin.voip.f.k.ark(localb.getState())) {
          break label636;
        }
        localObject1 = new String[2];
        localObject1[0] = "android.permission.CAMERA";
        localObject1[1] = "android.permission.RECORD_AUDIO";
      }
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject2, (String[])localObject1, 19, "");
      paramActivityPluginBinding.addRequestPermissionsResultListener(new c..ExternalSyntheticLambda2((Activity)localObject2));
      AppMethodBeat.o(263604);
      return;
      localObject1 = b.HmV;
      Log.i("MicroMsg.FlutterVoIPReportAgent", "onRestoreFromPIP");
      b.HmY.teM = System.currentTimeMillis();
      b.HmY.HmZ = true;
      b.fvs();
      break;
      label613:
      localObject1 = null;
      break label405;
      label618:
      localObject1 = ((VideoActivity)localObject1).iar();
      break label411;
      label626:
      localObject1 = null;
      break label423;
      label631:
      localObject1 = null;
      break label488;
      label636:
      localObject1 = new String[1];
      localObject1[0] = "android.permission.RECORD_AUDIO";
    }
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    int j = 1;
    AppMethodBeat.i(263578);
    kotlin.g.b.s.u(paramFlutterPluginBinding, "flutterPluginBinding");
    Log.i("MicroMsg.FlutterVoipPlugin", "onAttachToEngine");
    this.Hng = true;
    Object localObject = b.HmV;
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onLaunch");
    b.HmY = new b.a((byte)0);
    localObject = new hf();
    b.HmW = (hf)localObject;
    if (SubCoreVoip.hVp().UBE.OEa)
    {
      i = 1;
      ((hf)localObject).iNs = i;
      localObject = b.HmW;
      if (!SubCoreVoip.hVp().UBE.UvH) {
        break label246;
      }
    }
    label246:
    for (int i = j;; i = 2)
    {
      ((hf)localObject).iNr = i;
      b.HmY.teM = System.currentTimeMillis();
      kotlinx.coroutines.j.a(b.coroutineScope, null, null, (m)new b.d(null), 3);
      b.fvs();
      j.x.a(paramFlutterPluginBinding.getBinaryMessenger(), (j.x)this);
      localObject = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "flutter_voip");
      ((MethodChannel)localObject).setMethodCallHandler((MethodChannel.MethodCallHandler)this);
      ah localah = ah.aiuX;
      this.channel = ((MethodChannel)localObject);
      this.lifecycle.a(androidx.lifecycle.j.a.ON_START);
      paramFlutterPluginBinding = paramFlutterPluginBinding.getTextureRegistry();
      kotlin.g.b.s.s(paramFlutterPluginBinding, "flutterPluginBinding.textureRegistry");
      this.Hnf = new com.tencent.mm.plugin.flutter.voip.manager.a(paramFlutterPluginBinding);
      this.coroutineScope = ar.kBZ();
      AppMethodBeat.o(263578);
      return;
      i = 2;
      break;
    }
  }
  
  public final void onDetachedFromActivity()
  {
    AppMethodBeat.i(263598);
    Log.w("MicroMsg.FlutterVoipPlugin", "onDetachedFromActivity: activity=" + this.activity + ", voipMgr=" + this.Hnh);
    Object localObject = this.activity;
    if (localObject != null)
    {
      if (!((Activity)localObject).isFinishing())
      {
        Log.w("MicroMsg.FlutterVoipPlugin", "activity detached but not in finishing state");
        ((Activity)localObject).finish();
      }
      this.activity = null;
    }
    localObject = this.Hnh;
    if (localObject != null)
    {
      int i = ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).getState();
      Log.w("MicroMsg.FlutterVoipPlugin", "state=" + i + ", engineId=" + ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).engineId);
      if ((com.tencent.mm.plugin.voip.f.k.arn(i)) || (i == -1))
      {
        Log.w("MicroMsg.FlutterVoipPlugin", "VoIP has been finished, clear the engine");
        com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda3(this, (com.tencent.mm.plugin.flutter.voip.manager.b)localObject));
      }
      Log.i("MicroMsg.FlutterVoipMgr", "onActivityDetached");
      ((com.tencent.mm.plugin.flutter.voip.manager.b)localObject).activity = null;
      AppMethodBeat.o(263598);
      return;
    }
    localObject = this.engineId;
    if (localObject != null) {
      com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda4(this, (String)localObject));
    }
    AppMethodBeat.o(263598);
  }
  
  public final void onDetachedFromActivityForConfigChanges()
  {
    this.activity = null;
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263590);
    kotlin.g.b.s.u(paramFlutterPluginBinding, "binding");
    Log.i("MicroMsg.FlutterVoipPlugin", "onDetachedFromEngine");
    paramFlutterPluginBinding = this.channel;
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setMethodCallHandler(null);
    }
    this.channel = null;
    this.lifecycle.a(androidx.lifecycle.j.a.ON_STOP);
    ar.a(this.coroutineScope, null);
    this.Hnh = null;
    paramFlutterPluginBinding = this.Hnf;
    if (paramFlutterPluginBinding != null)
    {
      Log.i(paramFlutterPluginBinding.TAG, "clearTextureTrash");
      Iterator localIterator = ((Iterable)paramFlutterPluginBinding.Hno).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.flutter.voip.manager.a.a)localIterator.next()).Hnp.release();
      }
      paramFlutterPluginBinding.Hno.clear();
    }
    AppMethodBeat.o(263590);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(263585);
    kotlin.g.b.s.u(paramMethodCall, "call");
    kotlin.g.b.s.u(paramResult, "result");
    if (kotlin.g.b.s.p(paramMethodCall.method, "getPlatformVersion"))
    {
      paramResult.success(kotlin.g.b.s.X("Android ", Build.VERSION.RELEASE));
      AppMethodBeat.o(263585);
      return;
    }
    paramResult.notImplemented();
    AppMethodBeat.o(263585);
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(263612);
    kotlin.g.b.s.u(paramActivityPluginBinding, "binding");
    this.activity = paramActivityPluginBinding.getActivity();
    Log.i("MicroMsg.FlutterVoipPlugin", kotlin.g.b.s.X("onReattachedToActivityForConfigChanges:", this.activity));
    AppMethodBeat.o(263612);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoipPlugin$minimize$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements RequestFloatWindowPermissionDialog.a
  {
    b(c paramc, j.m<j.c> paramm) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(263435);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Log.e("MicroMsg.FlutterVoipPlugin", "minimize, onResultAllow");
      paramRequestFloatWindowPermissionDialog.finish();
      kotlinx.coroutines.j.a(c.b(this.Hni), null, null, (m)new a(this.Hni, paramm, null), 3);
      AppMethodBeat.o(263435);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(263443);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Log.e("MicroMsg.FlutterVoipPlugin", "minimize, onResultRefuse");
      paramRequestFloatWindowPermissionDialog.finish();
      paramm.success(c.z(Boolean.FALSE));
      AppMethodBeat.o(263443);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(263450);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Log.e("MicroMsg.FlutterVoipPlugin", "minimize, onResultCancel");
      paramRequestFloatWindowPermissionDialog.finish();
      paramm.success(c.z(Boolean.FALSE));
      AppMethodBeat.o(263450);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(c paramc, j.m<j.c> paramm, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(263427);
        paramObject = (kotlin.d.d)new a(this.Hni, this.Hnj, paramd);
        AppMethodBeat.o(263427);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        boolean bool2 = false;
        AppMethodBeat.i(263418);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(263418);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = c.a(this.Hni);
        if (paramObject == null) {}
        for (boolean bool1 = false;; bool1 = paramObject.Gn(true))
        {
          paramObject = c.c(this.Hni);
          if (paramObject != null) {
            paramObject.releaseAll();
          }
          paramObject = c.d(this.Hni);
          if (paramObject != null) {
            paramObject.finish();
          }
          paramObject = this.Hnj;
          if (bool1) {
            bool2 = true;
          }
          paramObject.success(c.z(Boolean.valueOf(bool2)));
          paramObject = ah.aiuX;
          AppMethodBeat.o(263418);
          return paramObject;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    f(c paramc, j.c paramc1, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(263429);
      paramObject = (kotlin.d.d)new f(this.Hni, paramc, paramd);
      AppMethodBeat.o(263429);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(263421);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(263421);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = c.a(this.Hni);
      if (paramObject != null)
      {
        localObject = paramc.ahhE;
        kotlin.g.b.s.s(localObject, "arg.value");
        paramObject.vG(((Boolean)localObject).booleanValue());
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(263421);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.c
 * JD-Core Version:    0.7.0.1
 */