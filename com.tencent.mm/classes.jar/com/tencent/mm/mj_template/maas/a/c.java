package com.tencent.mm.mj_template.maas.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.maas.MJMaasCore;
import com.tencent.maas.MJMaasCore.TemplateServiceProvider;
import com.tencent.maas.camerafun.MJAuditCaptureSettings;
import com.tencent.maas.camerafun.MJCamFunSession;
import com.tencent.maas.camerafun.MJCamFunSession.d;
import com.tencent.maas.camerafun.MJCaptureOptions;
import com.tencent.maas.camerafun.MJRecordingFinishInfo;
import com.tencent.maas.camerafun.MJVideoFrame;
import com.tencent.maas.instamovie.MJAsyncTaskInfo;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.maas.d.c;
import com.tencent.mm.mj_template.maas.d.d;
import com.tencent.mm.mj_template.maas.d.f;
import com.tencent.mm.mj_template.maas.d.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseScopePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.ewu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.y;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.mj_template.maas.a.f;>;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.l;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/FinderTemplateCorePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/media/ImageReader$OnImageAvailableListener;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "templateLayout", "Landroid/view/ViewGroup;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;Landroid/view/ViewGroup;)V", "audioFrameCache", "Lcom/tencent/mm/mj_template/maas/record/FrameCache;", "audioRecorder", "Lcom/tencent/mm/mj_template/maas/record/FinderTemplateAudioRecorder;", "cameraSessionManager", "Lcom/tencent/mm/mj_template/maas/MaasCamFunSessionManager;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "currentCaptureOption", "Lcom/tencent/maas/camerafun/MJCaptureOptions;", "hasReleased", "", "imageFrameSentContinuation", "Lkotlin/coroutines/Continuation;", "", "imageReader", "Landroid/media/ImageReader;", "loadingDialog", "Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "mute", "<set-?>", "Lcom/tencent/mm/mj_template/maas/record/TemplateOutputInfo;", "outputInfo", "getOutputInfo", "()Lcom/tencent/mm/mj_template/maas/record/TemplateOutputInfo;", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "setPluginLayout", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;)V", "resumeTemplateName", "", "sendImageFrameCount", "", "setupJob", "Lkotlinx/coroutines/Job;", "getSetupJob", "()Lkotlinx/coroutines/Job;", "setupJob$delegate", "startRecordJob", "Lkotlinx/coroutines/Deferred;", "startRecordMs", "", "templateName", "getTemplateName", "()Ljava/lang/String;", "thread", "Landroid/os/HandlerThread;", "videoFrameCache", "videoFrameInfo", "Lcom/tencent/mm/mj_template/maas/record/VideoFrameInfo;", "awaitImageFrameSent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSetup", "checkImageReaderValid", "previewWidth", "previewHeight", "closeImageReader", "getCaptureOption", "hasTemplate", "initLogic", "isTemplateShow", "launch", "con", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onImageAvailable", "reader", "onPause", "onReceiveAudioFrame", "pcm", "", "len", "onResume", "packageTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "info", "Lcom/tencent/maas/camerafun/MJRecordingFinishInfo;", "prepareMaas", "recordFps", "release", "sendBlackVideoFrame", "setMutePcm", "setTemplateProvider", "templateProvider", "Lcom/tencent/maas/MJMaasCore$TemplateServiceProvider;", "showErrorTips", "tips", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAudioRecord", "startRecord", "auditCaptureSettings", "Lcom/tencent/maas/camerafun/MJAuditCaptureSettings;", "(Lcom/tencent/maas/camerafun/MJAuditCaptureSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAudioRecord", "stopRecord", "Lcom/tencent/mm/mj_template/maas/record/TemplateResult;", "switchEmptyTemplate", "switchToTemplate", "Landroid/view/Surface;", "cameraUsage", "Lcom/tencent/mm/media/camera/view/ICameraAdvancedUsage;", "(Ljava/lang/String;Lcom/tencent/mm/media/camera/view/ICameraAdvancedUsage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "templateRenderTarget", "toggleLoading", "show", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleTemplateShow", "waitFistFrameRendered", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements ImageReader.OnImageAvailableListener, v
{
  public static final int Ue;
  public static final c.a oaQ;
  private final Context context;
  public ImageReader imageReader;
  private boolean nLP;
  private final kotlin.j nWe;
  private BaseScopePluginLayout oaR;
  public final ViewGroup oaS;
  private com.tencent.mm.mj_template.maas.d oaT;
  private b oaU;
  private RecordConfigProvider oaV;
  public MJCaptureOptions oaW;
  public String oaX;
  public String oaY;
  public e oaZ;
  private final kotlin.j oba;
  private d obb;
  private g obc;
  private int obd;
  private d obe;
  private boolean obf;
  private ay<Boolean> qMn;
  private final HandlerThread thread;
  private long uxu;
  
  static
  {
    AppMethodBeat.i(240211);
    oaQ = new c.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(240211);
  }
  
  public c(BaseScopePluginLayout paramBaseScopePluginLayout, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(240034);
    this.oaR = paramBaseScopePluginLayout;
    this.oaS = paramViewGroup;
    this.context = this.oaR.getContext();
    this.thread = com.tencent.threadpool.c.d.jy("RecordTemplate-Use", -2);
    this.oaZ = new e();
    this.nWe = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.oba = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.obb = new d();
    this.obc = new g((byte)0);
    this.obe = new d();
    AppMethodBeat.o(240034);
  }
  
  private final Object D(kotlin.d.d<? super ah> paramd)
  {
    Object localObject3 = null;
    AppMethodBeat.i(240077);
    Object localObject1;
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject2 = ((f)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((f)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240077);
        throw paramd;
        localObject1 = new f(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.FinderTemplateCorePlugin", "prepareMaas");
    paramd = (kotlin.d.f)bg.kCh();
    Object localObject2 = (m)new g(this, null);
    ((f)localObject1).L$0 = this;
    ((f)localObject1).label = 1;
    Object localObject4 = l.a(paramd, (m)localObject2, (kotlin.d.d)localObject1);
    localObject2 = localObject4;
    paramd = this;
    if (localObject4 == locala)
    {
      AppMethodBeat.o(240077);
      return locala;
      paramd = (c)((f)localObject1).L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    if (!((Boolean)localObject2).booleanValue())
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(240077);
      return paramd;
    }
    localObject2 = paramd.oaT;
    label287:
    boolean bool;
    if (localObject2 != null)
    {
      localObject4 = com.tencent.mm.mj_template.maas.e.nZS;
      localObject2 = ((com.tencent.mm.mj_template.maas.d)localObject2).nZJ;
      s.u(localObject2, "camFunSession");
      if (!com.tencent.mm.mj_template.maas.e.nZV) {
        Log.e("MicroMsg.MaasManager", "not initialized");
      }
    }
    else
    {
      localObject2 = paramd.oaT;
      if (localObject2 != null) {
        break label410;
      }
      localObject1 = null;
      paramd.thread.start();
      paramd = new StringBuilder("start camera session finished, success:");
      if (localObject1 == null) {
        break label520;
      }
      bool = true;
      label311:
      localObject2 = paramd.append(bool).append(", maxRecordingDuration:");
      if (localObject1 != null) {
        break label525;
      }
      paramd = null;
      label330:
      localObject2 = ((StringBuilder)localObject2).append(paramd).append(", audioEnable:");
      if (localObject1 != null) {
        break label550;
      }
      paramd = null;
      label350:
      localObject2 = ((StringBuilder)localObject2).append(paramd).append(", frontCamera:");
      if (localObject1 != null) {
        break label561;
      }
    }
    label410:
    label550:
    label561:
    for (paramd = localObject3;; paramd = Boolean.valueOf(((MJCaptureOptions)localObject1).isUseFrontCamera()))
    {
      Log.i("MicroMsg.FinderTemplateCorePlugin", paramd);
      paramd = ah.aiuX;
      AppMethodBeat.o(240077);
      return paramd;
      com.tencent.mm.mj_template.maas.e.bxo().connectToSession((MJCamFunSession)localObject2);
      break;
      ((f)localObject1).L$0 = paramd;
      ((f)localObject1).label = 2;
      localObject4 = com.tencent.mm.mj_template.maas.b.a.obp;
      com.tencent.mm.mj_template.maas.b.a.HH("maas_" + ((com.tencent.mm.mj_template.maas.d)localObject2).hashCode() + '_' + System.currentTimeMillis());
      localObject1 = com.tencent.mm.mj_template.maas.c.b("1000", (kotlin.g.a.b)new d.d((com.tencent.mm.mj_template.maas.d)localObject2), (kotlin.d.d)localObject1);
      localObject2 = localObject1;
      if (localObject1 == locala)
      {
        AppMethodBeat.o(240077);
        return locala;
        paramd = (c)((f)localObject1).L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      localObject1 = (MJCaptureOptions)localObject2;
      break label287;
      bool = false;
      break label311;
      paramd = ((MJCaptureOptions)localObject1).getMaxRecordingDuration();
      if (paramd == null)
      {
        paramd = null;
        break label330;
      }
      paramd = Double.valueOf(paramd.toMilliseconds());
      break label330;
      paramd = Boolean.valueOf(((MJCaptureOptions)localObject1).isAudioEnabled());
      break label350;
    }
  }
  
  private final Object E(kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(240088);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new b(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240088);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = this;
    if (bxD().isActive())
    {
      localObject2 = bxD();
      paramd.L$0 = this;
      paramd.label = 1;
      localObject1 = this;
      if (((cb)localObject2).ay(paramd) == locala)
      {
        AppMethodBeat.o(240088);
        return locala;
        localObject1 = (c)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
    }
    if (((c)localObject1).bxD().isCancelled())
    {
      paramd = ((c)localObject1).bxD().kCu();
      Log.e("MicroMsg.FinderTemplateCorePlugin", "setup failed:" + paramd + ' ' + paramd.getCause() + ' ' + paramd.getMessage());
      paramd = Boolean.FALSE;
      AppMethodBeat.o(240088);
      return paramd;
    }
    paramd = Boolean.TRUE;
    AppMethodBeat.o(240088);
    return paramd;
  }
  
  private final byy a(MJRecordingFinishInfo paramMJRecordingFinishInfo)
  {
    AppMethodBeat.i(240130);
    if (this.oaW == null)
    {
      AppMethodBeat.o(240130);
      return null;
    }
    byy localbyy = new byy();
    localbyy.type = 2;
    localbyy.id = this.oaX;
    localbyy.aahW = 1001000;
    Log.i("MicroMsg.FinderTemplateCorePlugin", "templateName:" + this.oaX + " sdk_version:" + localbyy.aahW);
    ewu localewu = new ewu();
    Object localObject1 = y.eB(paramMJRecordingFinishInfo.getOriginalImageSeqDirPath(), false);
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.vfs.j)((Iterator)localObject1).next();
        String str = ((com.tencent.mm.vfs.j)localObject2).acpB;
        s.s(str, "it.relPath");
        if (n.i((CharSequence)str, (CharSequence)"mjScy"))
        {
          localObject2 = paramMJRecordingFinishInfo.getOriginalImageSeqDirPath() + '/' + ((com.tencent.mm.vfs.j)localObject2).name;
          localewu.abyV.add(localObject2);
          Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("frame_urls add path:", localObject2));
        }
      }
    }
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("frame_urls size:", Integer.valueOf(localewu.abyV.size())));
    paramMJRecordingFinishInfo = ah.aiuX;
    localbyy.aaia = localewu;
    AppMethodBeat.o(240130);
    return localbyy;
  }
  
  private final cb a(kotlin.d.f paramf, m<? super aq, ? super kotlin.d.d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(240055);
    paramf = BaseScopePluginLayout.a(this.oaR, paramf, null, paramm, 2);
    AppMethodBeat.o(240055);
    return paramf;
  }
  
  public static void a(MJMaasCore.TemplateServiceProvider paramTemplateServiceProvider)
  {
    AppMethodBeat.i(240062);
    s.u(paramTemplateServiceProvider, "templateProvider");
    com.tencent.mm.mj_template.maas.e locale = com.tencent.mm.mj_template.maas.e.nZS;
    com.tencent.mm.mj_template.maas.e.a(paramTemplateServiceProvider);
    AppMethodBeat.o(240062);
  }
  
  private static final void a(c paramc, float paramFloat)
  {
    AppMethodBeat.i(240142);
    s.u(paramc, "this$0");
    Log.d("MicroMsg.FinderTemplateCorePlugin", s.X("switchToTemplate onProgress:", Float.valueOf(paramFloat)));
    com.tencent.mm.mj_template.album_template.f localf = paramc.bwJ();
    paramc = paramc.oaR.getContext().getResources().getString(com.tencent.mm.mj_template.plugin.c.g.odk, new Object[] { Integer.valueOf(kotlin.h.a.eH(100.0F * paramFloat)) });
    s.s(paramc, "pluginLayout.context.res…ToInt()\n                )");
    localf.Hy(paramc);
    AppMethodBeat.o(240142);
  }
  
  private final com.tencent.mm.mj_template.album_template.f bwJ()
  {
    AppMethodBeat.i(240042);
    com.tencent.mm.mj_template.album_template.f localf = (com.tencent.mm.mj_template.album_template.f)this.nWe.getValue();
    AppMethodBeat.o(240042);
    return localf;
  }
  
  private final cb bxD()
  {
    AppMethodBeat.i(240048);
    cb localcb = (cb)this.oba.getValue();
    AppMethodBeat.o(240048);
    return localcb;
  }
  
  private final void bxE()
  {
    AppMethodBeat.i(240094);
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("closeImageReader:", this.imageReader));
    ImageReader localImageReader = this.imageReader;
    if (localImageReader != null) {
      localImageReader.close();
    }
    this.imageReader = null;
    AppMethodBeat.o(240094);
  }
  
  private final Object c(final String paramString, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(240109);
    paramString = l.a((kotlin.d.f)bg.kCh(), (m)new j(this, paramString, null), paramd);
    if (paramString == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(240109);
      return paramString;
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(240109);
    return paramString;
  }
  
  private final Object d(boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(240116);
    paramd = l.a((kotlin.d.f)bg.kCh(), (m)new p(paramBoolean, this, null), paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(240116);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(240116);
    return paramd;
  }
  
  public final Object F(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(240278);
    n localn;
    if ((paramd instanceof n))
    {
      localn = (n)paramd;
      if ((localn.label & 0x80000000) != 0) {
        localn.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = localn.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localn.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240278);
        throw paramd;
        localn = new n(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    this.oaX = null;
    this.oaY = null;
    this.oaW = null;
    localn.L$0 = this;
    localn.label = 1;
    Object localObject2 = E(localn);
    Object localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(240278);
      return locala;
      paramd = (c)localn.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    if (!((Boolean)localObject1).booleanValue())
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(240278);
      return paramd;
    }
    paramd.obd = 0;
    localObject1 = paramd.oaT;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramd;
      ((c)localObject2).bxE();
      localStringBuilder = new StringBuilder("switchEmptyTemplate result,isAudioEnabled:[");
      if (localObject1 != null) {
        break label404;
      }
      paramd = null;
      label249:
      localStringBuilder = localStringBuilder.append(paramd).append("] isUseFrontCamera:[");
      if (localObject1 != null) {
        break label415;
      }
      paramd = null;
      label269:
      localStringBuilder = localStringBuilder.append(paramd).append("]  maxRecordingDuration:[");
      if (localObject1 != null) {
        break label426;
      }
      paramd = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.FinderTemplateCorePlugin", paramd + ']');
      if (localObject1 == null) {
        break label467;
      }
      localn.L$0 = null;
      localn.label = 3;
      if (((c)localObject2).b(false, true, localn) != locala) {
        break label455;
      }
      AppMethodBeat.o(240278);
      return locala;
      localn.L$0 = paramd;
      localn.label = 2;
      localObject2 = ((com.tencent.mm.mj_template.maas.d)localObject1).x(localn);
      localObject1 = localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(240278);
        return locala;
        paramd = (c)localn.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      localObject1 = (MJCaptureOptions)localObject1;
      localObject2 = paramd;
      break;
      label404:
      paramd = Boolean.valueOf(((MJCaptureOptions)localObject1).isAudioEnabled());
      break label249;
      label415:
      paramd = Boolean.valueOf(((MJCaptureOptions)localObject1).isUseFrontCamera());
      break label269;
      label426:
      paramd = ((MJCaptureOptions)localObject1).getMaxRecordingDuration();
      if (paramd == null) {
        paramd = null;
      } else {
        paramd = Double.valueOf(paramd.toMilliseconds());
      }
    }
    ResultKt.throwOnFailure(localObject1);
    label455:
    paramd = ah.aiuX;
    AppMethodBeat.o(240278);
    return paramd;
    label467:
    Log.i("MicroMsg.FinderTemplateCorePlugin", "switchEmptyTemplate happen error");
    paramd = ah.aiuX;
    AppMethodBeat.o(240278);
    return paramd;
  }
  
  public final Object G(kotlin.d.d<? super f> paramd)
  {
    Object localObject3 = null;
    AppMethodBeat.i(240300);
    Object localObject1;
    if ((paramd instanceof m))
    {
      localObject1 = (m)paramd;
      if ((((m)localObject1).label & 0x80000000) != 0) {
        ((m)localObject1).label += -2147483648;
      }
    }
    Object localObject4;
    for (;;)
    {
      paramd = ((m)localObject1).result;
      localObject4 = kotlin.d.a.a.aiwj;
      switch (((m)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240300);
        throw paramd;
        localObject1 = new m(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("stopRecord start, currentCaptureOption:", this.oaW));
    paramd = this.qMn;
    if ((paramd != null) && (paramd.isActive() == true)) {}
    for (int i = 1;; i = 0)
    {
      paramd = this;
      if (i == 0) {
        break;
      }
      localObject2 = this.qMn;
      paramd = this;
      if (localObject2 == null) {
        break;
      }
      ((m)localObject1).L$0 = this;
      ((m)localObject1).label = 1;
      paramd = this;
      if (((ay)localObject2).ay((kotlin.d.d)localObject1) != localObject4) {
        break;
      }
      AppMethodBeat.o(240300);
      return localObject4;
    }
    Object localObject2 = (c)((m)localObject1).L$0;
    ResultKt.throwOnFailure(paramd);
    paramd = (kotlin.d.d<? super f>)localObject2;
    if (!paramd.nLP)
    {
      localObject2 = paramd.oaU;
      if (localObject2 != null)
      {
        boolean bool = ((b)localObject2).oaO.aGH();
        Log.i(((b)localObject2).TAG, s.X("stop ret:", Boolean.valueOf(bool)));
        ((b)localObject2).mgM = null;
      }
      paramd.oaU = null;
      paramd.obe.reset();
      Log.i("MicroMsg.FinderTemplateCorePlugin", "stopAudioRecord");
    }
    localObject2 = paramd.oaT;
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject2 = paramd;
      localObject4 = new StringBuilder("stopRecord result path:");
      if (localObject1 != null) {
        break label539;
      }
      paramd = null;
      label352:
      localObject4 = ((StringBuilder)localObject4).append(paramd).append(" duration:");
      if (localObject1 != null) {
        break label548;
      }
      paramd = null;
      label373:
      localObject4 = ((StringBuilder)localObject4).append(paramd).append(" originalImageSeqDirPath:");
      if (localObject1 != null) {
        break label574;
      }
    }
    label539:
    label548:
    label574:
    for (paramd = null;; paramd = ((MJRecordingFinishInfo)localObject1).getOriginalImageSeqDirPath())
    {
      Log.i("MicroMsg.FinderTemplateCorePlugin", paramd);
      if (System.currentTimeMillis() - ((c)localObject2).uxu > 2000L) {
        break label583;
      }
      Log.i("MicroMsg.FinderTemplateCorePlugin", "stopRecord cost time not enough");
      paramd = f.obn;
      paramd = f.a.Ee(-4);
      AppMethodBeat.o(240300);
      return paramd;
      ((m)localObject1).L$0 = paramd;
      ((m)localObject1).label = 2;
      localObject2 = com.tencent.mm.mj_template.maas.c.b("1007", (kotlin.g.a.b)new d.f((com.tencent.mm.mj_template.maas.d)localObject2), (kotlin.d.d)localObject1);
      localObject1 = localObject2;
      if (localObject2 == localObject4)
      {
        AppMethodBeat.o(240300);
        return localObject4;
        localObject2 = (c)((m)localObject1).L$0;
        ResultKt.throwOnFailure(paramd);
        localObject1 = paramd;
        paramd = (kotlin.d.d<? super f>)localObject2;
      }
      localObject1 = (MJRecordingFinishInfo)localObject1;
      localObject2 = paramd;
      break;
      paramd = ((MJRecordingFinishInfo)localObject1).getOutputFilePath();
      break label352;
      paramd = ((MJRecordingFinishInfo)localObject1).getRecordingDuration();
      if (paramd == null)
      {
        paramd = null;
        break label373;
      }
      paramd = Double.valueOf(paramd.toMilliseconds());
      break label373;
    }
    label583:
    if (localObject1 == null)
    {
      paramd = null;
      if (!y.ZC(paramd)) {
        break label730;
      }
      paramd = com.tencent.mm.plugin.gallery.b.g.HRf;
      if (localObject1 != null) {
        break label674;
      }
    }
    label674:
    for (paramd = null;; paramd = ((MJRecordingFinishInfo)localObject1).getOutputFilePath())
    {
      paramd = com.tencent.mm.plugin.gallery.b.g.aBH(paramd);
      Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("export video info:", paramd));
      if (paramd.videoDuration >= 2000L) {
        break label683;
      }
      Log.i("MicroMsg.FinderTemplateCorePlugin", "stopRecord file duration not enough");
      paramd = f.obn;
      paramd = f.a.Ee(-4);
      AppMethodBeat.o(240300);
      return paramd;
      paramd = ((MJRecordingFinishInfo)localObject1).getOutputFilePath();
      break;
    }
    label683:
    if (localObject1 == null) {}
    for (paramd = localObject3;; paramd = ((MJRecordingFinishInfo)localObject1).getOutputFilePath())
    {
      s.checkNotNull(localObject1);
      paramd = new f(0, paramd, ((c)localObject2).a((MJRecordingFinishInfo)localObject1));
      AppMethodBeat.o(240300);
      return paramd;
    }
    label730:
    paramd = f.obn;
    paramd = f.a.Ee(-2);
    AppMethodBeat.o(240300);
    return paramd;
  }
  
  public final Object a(MJAuditCaptureSettings paramMJAuditCaptureSettings, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(240291);
    Object localObject;
    if ((paramd instanceof l))
    {
      localObject = (l)paramd;
      if ((((l)localObject).label & 0x80000000) != 0) {
        ((l)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new l(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramMJAuditCaptureSettings = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240291);
        throw paramMJAuditCaptureSettings;
      }
    }
    ResultKt.throwOnFailure(localObject);
    this.qMn = BaseScopePluginLayout.a(this.oaR, (m)new c.s(this, paramMJAuditCaptureSettings, null));
    paramMJAuditCaptureSettings = this.qMn;
    boolean bool;
    if (paramMJAuditCaptureSettings == null) {
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(240291);
      return Boolean.valueOf(bool);
      paramd.label = 1;
      paramd = paramMJAuditCaptureSettings.e(paramd);
      paramMJAuditCaptureSettings = paramd;
      if (paramd == locala)
      {
        AppMethodBeat.o(240291);
        return locala;
        ResultKt.throwOnFailure(localObject);
        paramMJAuditCaptureSettings = (MJAuditCaptureSettings)localObject;
      }
      paramMJAuditCaptureSettings = (Boolean)paramMJAuditCaptureSettings;
      if (paramMJAuditCaptureSettings == null) {
        bool = false;
      } else {
        bool = paramMJAuditCaptureSettings.booleanValue();
      }
    }
  }
  
  public final Object a(String paramString, com.tencent.mm.media.camera.view.b paramb, kotlin.d.d<? super Surface> paramd)
  {
    AppMethodBeat.i(240256);
    o localo;
    if ((paramd instanceof o))
    {
      localo = (o)paramd;
      if ((localo.label & 0x80000000) != 0) {
        localo.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = localo.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localo.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240256);
        throw paramString;
        localo = new o(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("switchToTemplate name:", paramString));
    if (!s.p(this.oaX, paramString))
    {
      paramd = (CharSequence)paramString;
      if ((paramd != null) && (paramd.length() != 0)) {
        break label208;
      }
    }
    label208:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(240256);
      return null;
    }
    this.oaX = paramString;
    localo.L$0 = this;
    localo.Uf = paramString;
    localo.VC = paramb;
    localo.label = 1;
    Object localObject1 = this;
    paramd = paramString;
    if (d(true, localo) == locala)
    {
      AppMethodBeat.o(240256);
      return locala;
      paramb = (com.tencent.mm.media.camera.view.b)localo.VC;
      paramd = (String)localo.Uf;
      paramString = (c)localo.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject1 = paramString;
    }
    ((c)localObject1).obb.reset();
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("start switchToTemplate: ", paramd));
    localo.L$0 = localObject1;
    localo.Uf = paramd;
    localo.VC = paramb;
    localo.label = 2;
    Object localObject2 = ((c)localObject1).E(localo);
    if (localObject2 == locala)
    {
      AppMethodBeat.o(240256);
      return locala;
      paramb = (com.tencent.mm.media.camera.view.b)localo.VC;
      paramd = (String)localo.Uf;
      paramString = (c)localo.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    for (;;)
    {
      if (!((Boolean)localObject1).booleanValue())
      {
        localo.L$0 = paramString;
        localo.Uf = null;
        localo.VC = null;
        localo.label = 3;
        paramb = paramString;
        if (paramString.d(false, localo) == locala)
        {
          AppMethodBeat.o(240256);
          return locala;
          paramb = (c)localo.L$0;
          ResultKt.throwOnFailure(localObject1);
        }
        paramString = paramb.context.getString(com.tencent.mm.mj_template.plugin.c.g.oda);
        s.s(paramString, "context.getString(R.stri….can_not_switch_template)");
        localo.L$0 = null;
        localo.label = 4;
        if (paramb.c(paramString, localo) == locala)
        {
          AppMethodBeat.o(240256);
          return locala;
          ResultKt.throwOnFailure(localObject1);
        }
        AppMethodBeat.o(240256);
        return null;
      }
      Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("start switchToTemplate cameraUsage:", paramb));
      int j;
      int k;
      if (paramb != null)
      {
        j = paramString.oaZ.nvN.width;
        k = paramString.oaZ.nvN.height;
        if (paramString.imageReader != null)
        {
          localObject1 = paramString.imageReader;
          if ((localObject1 == null) || (((ImageReader)localObject1).getWidth() != j)) {
            break label1010;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = paramString.imageReader;
            if ((localObject1 == null) || (((ImageReader)localObject1).getHeight() != k)) {
              break label1016;
            }
          }
        }
      }
      Object localObject3;
      boolean bool;
      label816:
      label841:
      label866:
      label1010:
      label1016:
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          Log.i("MicroMsg.FinderTemplateCorePlugin", "recreate imageReader:[" + j + ',' + k + ']');
          localObject1 = paramString.imageReader;
          if (localObject1 != null) {
            ((ImageReader)localObject1).close();
          }
          paramString.imageReader = ImageReader.newInstance(j, k, 1, 1);
          localObject1 = paramString.imageReader;
          if (localObject1 != null) {
            ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)paramString, new Handler(paramString.thread.getLooper()));
          }
          paramString.obd = 0;
        }
        paramString.obd = 0;
        localObject1 = paramString.oaT;
        if (localObject1 != null) {
          break label1022;
        }
        localObject3 = null;
        localObject1 = paramString;
        paramd = paramb;
        localObject2 = localObject1;
        localObject1 = localObject3;
        ((c)localObject2).oaW = ((MJCaptureOptions)localObject1);
        paramb = new StringBuilder("switchToTemplate finished, success:");
        if (paramString.oaW == null) {
          break label1315;
        }
        bool = true;
        localObject1 = paramb.append(bool).append(", isUseFrontCamera:");
        paramb = paramString.oaW;
        if (paramb != null) {
          break label1321;
        }
        paramb = null;
        localObject1 = ((StringBuilder)localObject1).append(paramb).append(", isAudioEnabled:");
        paramb = paramString.oaW;
        if (paramb != null) {
          break label1332;
        }
        paramb = null;
        localObject1 = ((StringBuilder)localObject1).append(paramb).append(", maxRecordingDuration:");
        paramb = paramString.oaW;
        if (paramb != null) {
          break label1343;
        }
        paramb = null;
        label891:
        Log.i("MicroMsg.FinderTemplateCorePlugin", paramb);
        if (paramString.oaW == null) {
          break label1368;
        }
        paramb = paramString.imageReader;
        if (paramb == null) {
          break label1368;
        }
        paramb = paramb.getSurface();
        if (paramb == null) {
          break label1573;
        }
        localObject1 = paramString.oaW;
        s.checkNotNull(localObject1);
        bool = ((MJCaptureOptions)localObject1).isUseFrontCamera();
        if (paramd == null) {
          break label1573;
        }
        if (bool) {
          break label1373;
        }
        bool = true;
        localo.L$0 = paramString;
        localo.Uf = paramb;
        localo.VC = null;
        localo.label = 6;
        if (paramd.c(bool, localo) != locala) {
          break label1573;
        }
        AppMethodBeat.o(240256);
        return locala;
        i = 0;
        break;
      }
      label927:
      label961:
      label1022:
      localObject2 = new c..ExternalSyntheticLambda0(paramString);
      localo.L$0 = paramString;
      localo.Uf = paramb;
      localo.VC = paramString;
      localo.label = 5;
      localObject2 = (m)new d.h((com.tencent.mm.mj_template.maas.d)localObject1, paramd, (MJCamFunSession.d)localObject2);
      paramd = new q(kotlin.d.a.b.au(localo), 1);
      paramd.kBA();
      localObject1 = (p)paramd;
      long l = System.currentTimeMillis();
      localObject2 = (MJAsyncTaskInfo)((m)localObject2).invoke(com.tencent.mm.mj_template.maas.c.b.nZE, new com.tencent.mm.mj_template.maas.c.c((p)localObject1, "1003", l));
      if ((((MJAsyncTaskInfo)localObject2).error != null) && (((p)localObject1).isActive()))
      {
        localObject3 = com.tencent.mm.mj_template.maas.b.b.obs;
        localObject3 = ((MJAsyncTaskInfo)localObject2).error;
        s.s(localObject3, "task.error");
        com.tencent.mm.mj_template.maas.b.b.a("1003", (MJError)localObject3, System.currentTimeMillis() - l);
        localObject3 = (kotlin.d.d)localObject1;
        Result.Companion localCompanion = Result.Companion;
        ((kotlin.d.d)localObject3).resumeWith(Result.constructor-impl(null));
      }
      ((p)localObject1).bg((kotlin.g.a.b)new com.tencent.mm.mj_template.maas.c.a("1003", l, (MJAsyncTaskInfo)localObject2));
      localObject1 = paramd.getResult();
      if (localObject1 == kotlin.d.a.a.aiwj) {
        s.u(localo, "frame");
      }
      if (localObject1 == locala)
      {
        AppMethodBeat.o(240256);
        return locala;
        paramd = (c)localo.VC;
        paramb = (com.tencent.mm.media.camera.view.b)localo.Uf;
        paramString = (c)localo.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      for (;;)
      {
        localObject1 = (MJCaptureOptions)localObject1;
        localObject2 = paramd;
        paramd = paramb;
        break;
        label1315:
        bool = false;
        break label816;
        label1321:
        paramb = Boolean.valueOf(paramb.isUseFrontCamera());
        break label841;
        label1332:
        paramb = Boolean.valueOf(paramb.isAudioEnabled());
        break label866;
        label1343:
        paramb = paramb.getMaxRecordingDuration();
        if (paramb == null)
        {
          paramb = null;
          break label891;
        }
        paramb = Double.valueOf(paramb.toMilliseconds());
        break label891;
        label1368:
        paramb = null;
        break label927;
        label1373:
        bool = false;
        break label961;
        paramb = (Surface)localo.Uf;
        paramString = (c)localo.L$0;
        ResultKt.throwOnFailure(localObject1);
        label1573:
        for (;;)
        {
          localo.L$0 = paramString;
          localo.Uf = paramb;
          localo.VC = null;
          localo.label = 7;
          paramd = paramString;
          if (paramString.d(false, localo) == locala)
          {
            AppMethodBeat.o(240256);
            return locala;
            paramb = (Surface)localo.Uf;
            paramd = (c)localo.L$0;
            ResultKt.throwOnFailure(localObject1);
          }
          paramString = paramb;
          if (paramb == null)
          {
            Log.i("MicroMsg.FinderTemplateCorePlugin", "switch to template error");
            localObject1 = paramd.context.getString(com.tencent.mm.mj_template.plugin.c.g.oda);
            s.s(localObject1, "context.getString(R.stri….can_not_switch_template)");
            localo.L$0 = paramb;
            localo.Uf = null;
            localo.label = 8;
            paramString = paramb;
            if (paramd.c((String)localObject1, localo) == locala)
            {
              AppMethodBeat.o(240256);
              return locala;
              paramString = (Surface)localo.L$0;
              ResultKt.throwOnFailure(localObject1);
            }
          }
          AppMethodBeat.o(240256);
          return paramString;
        }
        paramd = paramString;
      }
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(240227);
    s.u(paramRecordConfigProvider, "configProvider");
    v.a.a((v)this, paramRecordConfigProvider);
    this.oaV = paramRecordConfigProvider;
    paramRecordConfigProvider = paramRecordConfigProvider.oXZ;
    int i;
    Integer localInteger;
    if (paramRecordConfigProvider == null)
    {
      paramRecordConfigProvider = com.tencent.mm.modelcontrol.e.bIg().bIm();
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVC, 30);
      Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("recordFps:", Integer.valueOf(i)));
      localInteger = Integer.valueOf(i);
      if (((Number)localInteger).intValue() <= 0) {
        break label220;
      }
      i = 1;
      label95:
      if (i == 0) {
        break label225;
      }
      label99:
      if (localInteger != null) {
        break label230;
      }
      i = 30;
      label106:
      this.oaZ.averageAudioBitRate = paramRecordConfigProvider.audioBitrate;
      this.oaZ.videoBitsPerFrame = (paramRecordConfigProvider.videoBitrate / i);
      this.oaZ.maxKeyframeInterval = (i * paramRecordConfigProvider.nCd);
      if (paramRecordConfigProvider.width > 540) {
        break label238;
      }
      this.oaZ.c(com.tencent.maas.instamovie.mediafoundation.b.eFY);
      this.oaZ.nvN.width = 540;
      this.oaZ.nvN.height = 960;
    }
    for (;;)
    {
      Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("outputInfo:", this.oaZ));
      bxD();
      AppMethodBeat.o(240227);
      return;
      break;
      label220:
      i = 0;
      break label95;
      label225:
      localInteger = null;
      break label99;
      label230:
      i = localInteger.intValue();
      break label106;
      label238:
      if (paramRecordConfigProvider.width <= 720)
      {
        this.oaZ.c(com.tencent.maas.instamovie.mediafoundation.b.eFZ);
        this.oaZ.nvN.width = 720;
        this.oaZ.nvN.height = 1280;
      }
      else
      {
        this.oaZ.c(com.tencent.maas.instamovie.mediafoundation.b.eGa);
        this.oaZ.nvN.width = 1080;
        this.oaZ.nvN.height = 1920;
      }
    }
  }
  
  public final Object b(final boolean paramBoolean1, boolean paramBoolean2, kotlin.d.d<? super ah> paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(240271);
    if ((paramd instanceof q))
    {
      localObject1 = (q)paramd;
      if ((((q)localObject1).label & 0x80000000) != 0) {
        ((q)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new q(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240271);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = this;
    boolean bool1 = paramBoolean1;
    if (paramBoolean1)
    {
      localObject1 = this;
      bool1 = paramBoolean1;
      if (paramBoolean2)
      {
        localObject2 = this.oaT;
        localObject1 = this;
        bool1 = paramBoolean1;
        if (localObject2 != null)
        {
          paramd.L$0 = this;
          paramd.YF = paramBoolean1;
          paramd.label = 1;
          Log.i("MicroMsg.CamFunSessionManager", "awaitFirstFrame");
          if (((com.tencent.mm.mj_template.maas.d)localObject2).nZK != null)
          {
            localObject1 = ((com.tencent.mm.mj_template.maas.d)localObject2).nZK;
            if ((localObject1 == null) || (((cb)localObject1).isActive() != true)) {
              break label290;
            }
          }
          label268:
          label290:
          for (int i = 1;; i = 0)
          {
            if (i != 0)
            {
              localObject1 = ((com.tencent.mm.mj_template.maas.d)localObject2).nZK;
              if (localObject1 != null)
              {
                localObject1 = ((cb)localObject1).ay(paramd);
                localObject2 = localObject1;
                if (localObject1 == kotlin.d.a.a.aiwj) {
                  break label268;
                }
              }
            }
            localObject2 = ah.aiuX;
            localObject1 = this;
            bool1 = paramBoolean1;
            if (localObject2 != locala) {
              break;
            }
            AppMethodBeat.o(240271);
            return locala;
          }
          bool1 = paramd.YF;
          localObject1 = (c)paramd.L$0;
          ResultKt.throwOnFailure(localObject2);
        }
      }
    }
    Object localObject2 = (kotlin.d.f)bg.kCh();
    if (bool1) {}
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localObject1 = (m)new r((c)localObject1, paramBoolean1, null);
      paramd.L$0 = null;
      paramd.label = 2;
      if (l.a((kotlin.d.f)localObject2, (m)localObject1, paramd) != locala) {
        break;
      }
      AppMethodBeat.o(240271);
      return locala;
    }
    ResultKt.throwOnFailure(localObject2);
    paramd = ah.aiuX;
    AppMethodBeat.o(240271);
    return paramd;
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(240330);
    s.u(this, "this");
    AppMethodBeat.o(240330);
  }
  
  public final void gN(boolean paramBoolean)
  {
    AppMethodBeat.i(240260);
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("setMutePcm:", Boolean.valueOf(paramBoolean)));
    this.nLP = paramBoolean;
    AppMethodBeat.o(240260);
  }
  
  public final String name()
  {
    AppMethodBeat.i(240324);
    String str = v.a.b(this);
    AppMethodBeat.o(240324);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(240328);
    s.u(this, "this");
    AppMethodBeat.o(240328);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(240336);
    s.u(this, "this");
    AppMethodBeat.o(240336);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(240344);
    s.u(this, "this");
    AppMethodBeat.o(240344);
  }
  
  public final void onImageAvailable(ImageReader paramImageReader)
  {
    Object localObject1 = null;
    AppMethodBeat.i(240311);
    long l = System.currentTimeMillis();
    if (paramImageReader == null) {
      paramImageReader = null;
    }
    for (;;)
    {
      if (paramImageReader == null)
      {
        label24:
        Log.d("MicroMsg.FinderTemplateCorePlugin", s.X("onImageAvailable start timeStamp:", localObject1));
        if (paramImageReader == null) {}
      }
      try
      {
        localObject1 = paramImageReader.getPlanes();
        if (localObject1 == null)
        {
          return;
          paramImageReader = paramImageReader.acquireNextImage();
          continue;
          localObject1 = Long.valueOf(paramImageReader.getTimestamp());
          break label24;
        }
        else
        {
          localObject1 = paramImageReader.getPlanes()[0];
          Object localObject3 = ((Image.Plane)localObject1).getBuffer();
          ((ByteBuffer)localObject3).position(0);
          this.obb.uJ(paramImageReader.getWidth() * paramImageReader.getHeight() * ((Image.Plane)localObject1).getPixelStride());
          int i = ((Image.Plane)localObject1).getRowStride();
          int j = ((Image.Plane)localObject1).getPixelStride();
          Object localObject4 = this.obb.bxF();
          SightVideoJNI.nativeBufferCopy((ByteBuffer)localObject3, (ByteBuffer)localObject4, paramImageReader.getWidth() * j, paramImageReader.getHeight(), i - j * paramImageReader.getWidth());
          localObject3 = new MJVideoFrame(paramImageReader.getWidth(), paramImageReader.getHeight(), paramImageReader.getWidth() * ((Image.Plane)localObject1).getPixelStride(), paramImageReader.getPlanes()[0].getPixelStride(), (ByteBuffer)localObject4, 0, paramImageReader.getTimestamp());
          this.obc.width = paramImageReader.getWidth();
          this.obc.height = paramImageReader.getHeight();
          localObject4 = this.obc;
          i = paramImageReader.getWidth();
          ((g)localObject4).rowStride = (((Image.Plane)localObject1).getPixelStride() * i);
          this.obc.pixelStride = paramImageReader.getPlanes()[0].getPixelStride();
          localObject1 = this.oaT;
          if (localObject1 != null)
          {
            s.u(localObject3, "videoFrame");
            ((com.tencent.mm.mj_template.maas.d)localObject1).nZJ.sendVideoFrame((MJVideoFrame)localObject3);
          }
          paramImageReader.close();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FinderTemplateCorePlugin", (Throwable)localException, "onImageAvailable error", new Object[0]);
          if (paramImageReader != null) {
            paramImageReader.close();
          }
        }
      }
      finally
      {
        if (paramImageReader == null) {
          break label384;
        }
        paramImageReader.close();
        AppMethodBeat.o(240311);
      }
    }
    Log.d("MicroMsg.FinderTemplateCorePlugin", s.X("onImageAvailable end cost:", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(240311);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(240234);
    Log.i("MicroMsg.FinderTemplateCorePlugin", s.X("onPause templateName:", this.oaX));
    s.u((v)this, "this");
    if (!TextUtils.isEmpty((CharSequence)this.oaX)) {
      a(this, (m)new d(this, null));
    }
    AppMethodBeat.o(240234);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(240349);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(240349);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(240239);
    Log.i("MicroMsg.FinderTemplateCorePlugin", "onResume");
    s.u((v)this, "this");
    String str = this.oaY;
    if (str == null)
    {
      AppMethodBeat.o(240239);
      return;
    }
    if (((CharSequence)str).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(240239);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)this.oaY)) {
      a(this, (m)new e(this, null));
    }
    AppMethodBeat.o(240239);
  }
  
  public final void release()
  {
    AppMethodBeat.i(240317);
    if (this.obf)
    {
      AppMethodBeat.o(240317);
      return;
    }
    Log.i("MicroMsg.FinderTemplateCorePlugin", "release");
    this.obf = true;
    kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new h(this, null), 2);
    this.obe.reset();
    this.obb.reset();
    bxE();
    this.oaX = null;
    this.oaW = null;
    this.thread.quitSafely();
    AppMethodBeat.o(240317);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(240351);
    s.u(this, "this");
    AppMethodBeat.o(240351);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(240355);
    s.u(this, "this");
    AppMethodBeat.o(240355);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(c paramc, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240052);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = c.c(this.obg, (kotlin.d.d)this);
      AppMethodBeat.o(240052);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.mj_template.album_template.f>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(c paramc, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240084);
      paramObject = (kotlin.d.d)new d(this.obg, paramd);
      AppMethodBeat.o(240084);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240073);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240073);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.FinderTemplateCorePlugin", "onPause switchToEmptyTemplate");
        c.a(this.obg, this.obg.oaX);
        c.b(this.obg);
        paramObject = c.c(this.obg);
        if (paramObject != null)
        {
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.x(locald) == locala)
          {
            AppMethodBeat.o(240073);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(240073);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(c paramc, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240061);
      paramObject = (kotlin.d.d)new e(this.obg, paramd);
      AppMethodBeat.o(240061);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240057);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240057);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.obg;
        String str = c.d(this.obg);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (c.a(paramObject, str, locald) == locala)
        {
          AppMethodBeat.o(240057);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(240057);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    f(c paramc, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240051);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = c.b(this.obg, (kotlin.d.d)this);
      AppMethodBeat.o(240051);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    
    g(c paramc, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240010);
      paramd = new g(this.obg, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(240010);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239999);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239999);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        Object localObject = com.tencent.mm.mj_template.maas.e.nZS;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject = ((com.tencent.mm.mj_template.maas.e)localObject).y(locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(239999);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (SurfaceView)paramObject;
      if (paramObject == null)
      {
        Log.e("MicroMsg.FinderTemplateCorePlugin", "createRenderSurface error");
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(239999);
        return paramObject;
      }
      c.a(this.obg).addView((View)paramObject, new ViewGroup.LayoutParams(-1, -1));
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(239999);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(c paramc, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240005);
      paramObject = (kotlin.d.d)new h(this.obg, paramd);
      AppMethodBeat.o(240005);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239996);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239996);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.FinderTemplateCorePlugin", "release");
        s.u((v)this.obg, "this");
        paramObject = com.tencent.mm.mj_template.maas.e.nZS;
        com.tencent.mm.mj_template.maas.e.a(null);
        paramObject = c.c(this.obg);
        if (paramObject != null)
        {
          Object localObject = (kotlin.d.d)this;
          this.label = 1;
          Log.i("MicroMsg.CamFunSessionManager", "release");
          localObject = com.tencent.mm.mj_template.maas.c.a("1009", (kotlin.g.a.b)new d.c(paramObject), (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject != kotlin.d.a.a.aiwj) {
            paramObject = ah.aiuX;
          }
          if (paramObject == locala)
          {
            AppMethodBeat.o(239996);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Log.i("MicroMsg.FinderTemplateCorePlugin", "MaasManager release");
      paramObject = com.tencent.mm.mj_template.maas.e.nZS;
      com.tencent.mm.mj_template.maas.e.release();
      paramObject = ah.aiuX;
      AppMethodBeat.o(239996);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/Job;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<cb>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    j(c paramc, String paramString, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240016);
      paramObject = (kotlin.d.d)new j(this.obg, paramString, paramd);
      AppMethodBeat.o(240016);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240006);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240006);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      aa.dc(c.e(this.obg), paramString);
      paramObject = ah.aiuX;
      AppMethodBeat.o(240006);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.d
  {
    int label;
    
    l(c paramc, kotlin.d.d<? super l> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240043);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.obg.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(240043);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    m(c paramc, kotlin.d.d<? super m> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240033);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.obg.G((kotlin.d.d)this);
      AppMethodBeat.o(240033);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    n(c paramc, kotlin.d.d<? super n> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240032);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.obg.F((kotlin.d.d)this);
      AppMethodBeat.o(240032);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    o(c paramc, kotlin.d.d<? super o> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240038);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.obg.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(240038);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    p(boolean paramBoolean, c paramc, kotlin.d.d<? super p> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240044);
      paramObject = (kotlin.d.d)new p(this.obi, jdField_this, paramd);
      AppMethodBeat.o(240044);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240039);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240039);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (this.obi)
      {
        paramObject = c.f(jdField_this);
        localObject = com.tencent.mm.cd.a.bt(c.e(jdField_this), com.tencent.mm.mj_template.plugin.c.g.odj);
        s.s(localObject, "getString(context, R.str…plate_downloading_widget)");
        paramObject.Hy((String)localObject);
        c.f(jdField_this).show();
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(240039);
        return paramObject;
        c.f(jdField_this).dismiss();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    q(c paramc, kotlin.d.d<? super q> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240041);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.obg.b(false, false, (kotlin.d.d)this);
      AppMethodBeat.o(240041);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    r(c paramc, boolean paramBoolean, kotlin.d.d<? super r> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240046);
      paramObject = (kotlin.d.d)new r(this.obg, paramBoolean1, paramd);
      AppMethodBeat.o(240046);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240040);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240040);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = c.a(this.obg);
      if (paramBoolean1) {}
      for (int i = 0;; i = 4)
      {
        paramObject.setVisibility(i);
        paramObject = ah.aiuX;
        AppMethodBeat.o(240040);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.c
 * JD-Core Version:    0.7.0.1
 */