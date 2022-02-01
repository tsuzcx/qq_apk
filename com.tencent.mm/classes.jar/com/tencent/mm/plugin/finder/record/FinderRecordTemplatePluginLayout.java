package com.tencent.mm.plugin.finder.record;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.media.ImageReader;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.j.a;
import androidx.lifecycle.q;
import com.tencent.maas.MJMaasCore.TemplateServiceProvider;
import com.tencent.maas.camerafun.MJAuditCaptureSettings;
import com.tencent.maas.camerafun.MJCaptureOptions;
import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.g;
import com.tencent.mm.mj_template.report.MaasPageFinderReporter;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.record.plugin.b.c;
import com.tencent.mm.plugin.finder.record.plugin.b.d;
import com.tencent.mm.plugin.finder.record.plugin.b.g;
import com.tencent.mm.plugin.finder.record.plugin.b.h;
import com.tencent.mm.plugin.finder.record.plugin.b.i;
import com.tencent.mm.plugin.finder.record.plugin.b.j;
import com.tencent.mm.plugin.finder.record.plugin.b.k;
import com.tencent.mm.plugin.finder.video.util.a.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.ad;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseScopePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordCheckAudioPermissionPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.media.g.d;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/FinderRecordTemplatePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordCheckAudioPermissionPluginLayout;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "cameraUsage", "Lcom/tencent/mm/media/camera/view/ICameraAdvancedUsage;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "corePlugin", "Lcom/tencent/mm/mj_template/maas/record/FinderTemplateCorePlugin;", "effectRenderPlugin", "Lcom/tencent/mm/plugin/finder/record/plugin/FinderEffectRenderPlugin;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordOrientationPlugin;", "recordControlPlugin", "Lcom/tencent/mm/plugin/finder/record/plugin/FinderRecordControlPlugin;", "recorder", "Lcom/tencent/mm/plugin/recordvideo/recorder/CameraKitRecorder;", "session", "", "buildCameraKitSetting", "Lcom/tencent/mm/media/camera/model/CameraKitSetting;", "changeToScreenPreview", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAudioPermission", "", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "glCreate", "glRelease", "glRender", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "(Lcom/tencent/mm/media/globject/GLTextureObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLogic", "initRecord", "isCameraScreenOutput", "jumpToPhotoEditPage", "path", "jumpToVideoEditPage", "pathArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "template", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "loadReportInfo", "makeRecordVideoRatio", "onAttach", "onBackPress", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetach", "onOrientationChange", "orientation", "", "onPause", "onResume", "onSizeChanged", "w", "h", "oldw", "oldh", "registerPlugin", "release", "reset", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "toggleCameraScreenOutput", "show", "surface", "Landroid/view/Surface;", "(ZLandroid/view/Surface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordTipByAudioPermission", "permission", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRecordTemplatePluginLayout
  extends RecordCheckAudioPermissionPluginLayout
  implements q, com.tencent.mm.media.camera.d, com.tencent.mm.plugin.mmsight.model.d.a
{
  public static final FinderRecordTemplatePluginLayout.a Fil;
  private final kotlin.j Fim;
  private final com.tencent.mm.plugin.recordvideo.d.a Fin;
  private final com.tencent.mm.media.camera.view.b Fio;
  private final ad Fip;
  private final ac Fiq;
  private final com.tencent.mm.plugin.finder.record.plugin.b Fir;
  private final com.tencent.mm.mj_template.maas.a.c Fis;
  private final com.tencent.mm.plugin.finder.record.plugin.a Fit;
  private com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  private final String hQR;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(337094);
    Fil = new FinderRecordTemplatePluginLayout.a((byte)0);
    AppMethodBeat.o(337094);
  }
  
  public FinderRecordTemplatePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(336946);
    this.hQR = String.valueOf(hashCode());
    this.Fim = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Fin = new com.tencent.mm.plugin.recordvideo.d.a(true);
    this.Fiq = new ac(paramContext);
    this.Fit = new com.tencent.mm.plugin.finder.record.plugin.a((BaseScopePluginLayout)this);
    LayoutInflater.from(paramContext).inflate(l.f.Fii, (ViewGroup)this, true);
    setBackgroundColor(-16777216);
    paramContext = findViewById(l.e.camera_view);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.camera_view)");
    this.Fio = ((com.tencent.mm.media.camera.view.b)paramContext);
    this.Fio.n((q)this);
    this.Fio.setCustomRender((com.tencent.mm.media.camera.d)this);
    this.Fir = new com.tencent.mm.plugin.finder.record.plugin.b((BaseScopePluginLayout)this);
    paramContext = (BaseScopePluginLayout)this;
    paramAttributeSet = findViewById(l.e.Fie);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById<FrameLayout>(R.id.template_preview)");
    paramContext = new com.tencent.mm.mj_template.maas.a.c(paramContext, (ViewGroup)paramAttributeSet);
    com.tencent.mm.mj_template.maas.a.c.a((MJMaasCore.TemplateServiceProvider)this.Fir);
    paramAttributeSet = ah.aiuX;
    this.Fis = paramContext;
    paramContext = findViewById(l.e.switch_camera);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.switch_camera)");
    this.Fip = new ad((ImageView)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    this.Fiq.KUU = ((com.tencent.mm.plugin.mmsight.model.d.a)this);
    getPluginList().add(this.Fip);
    getPluginList().add(this.Fiq);
    getPluginList().add(this.Fis);
    getPluginList().add(this.Fir);
    AppMethodBeat.o(336946);
  }
  
  private final Object a(boolean paramBoolean, final Surface paramSurface, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(336955);
    paramSurface = l.a((kotlin.d.f)bg.kCh(), (m)new h(paramBoolean, paramSurface, this, null), paramd);
    if (paramSurface == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(336955);
      return paramSurface;
    }
    paramSurface = ah.aiuX;
    AppMethodBeat.o(336955);
    return paramSurface;
  }
  
  private static final void a(FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout)
  {
    AppMethodBeat.i(336998);
    kotlin.g.b.s.u(paramFinderRecordTemplatePluginLayout, "this$0");
    paramFinderRecordTemplatePluginLayout.setCheckAudioPermission(true);
    paramFinderRecordTemplatePluginLayout = paramFinderRecordTemplatePluginLayout.getContext();
    if (paramFinderRecordTemplatePluginLayout == null)
    {
      paramFinderRecordTemplatePluginLayout = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(336998);
      throw paramFinderRecordTemplatePluginLayout;
    }
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramFinderRecordTemplatePluginLayout);
    AppMethodBeat.o(336998);
  }
  
  private final void a(ArrayList<String> paramArrayList, byy parambyy)
  {
    Object localObject1 = null;
    AppMethodBeat.i(336980);
    com.tencent.mm.media.widget.camerarecordview.b.b localb = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
    Object localObject2 = paramArrayList.get(0);
    kotlin.g.b.s.s(localObject2, "pathArray[0]");
    localb.GZ((String)localObject2);
    localb.w(paramArrayList);
    localb.nJW = true;
    if (parambyy != null)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putByteArray("KEY_POST_VIDEO_TEMPLATE", parambyy.toByteArray());
      parambyy = ah.aiuX;
      localb.nKf = ((Bundle)localObject2);
    }
    parambyy = this.oaV;
    if (parambyy == null)
    {
      parambyy = (byy)localObject1;
      if (parambyy != null) {
        break label201;
      }
      parambyy = new Bundle();
    }
    label201:
    for (;;)
    {
      localObject1 = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramArrayList.add(GalleryItem.MediaItem.a(2, 0L, (String)((Iterator)localObject1).next(), "", ""));
      }
      parambyy = parambyy.oSS;
      break;
    }
    paramArrayList = ((Collection)paramArrayList).toArray(new GalleryItem.MediaItem[0]);
    if (paramArrayList == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(336980);
      throw paramArrayList;
    }
    parambyy.putParcelableArrayList("media_list", com.tencent.luggage.l.c.toArrayList(paramArrayList));
    paramArrayList = this.oaV;
    if (paramArrayList != null) {
      paramArrayList.oSS = parambyy;
    }
    paramArrayList = this.Fiu;
    if (paramArrayList != null) {
      paramArrayList.a(4, localb);
    }
    AppMethodBeat.o(336980);
  }
  
  private final boolean eLh()
  {
    AppMethodBeat.i(336967);
    if (((View)this.Fio).getVisibility() == 0)
    {
      if (this.Fis.oaS.getVisibility() == 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(336967);
        return true;
      }
    }
    AppMethodBeat.o(336967);
    return false;
  }
  
  private final androidx.lifecycle.s getLifecycleRegistry()
  {
    AppMethodBeat.i(336952);
    androidx.lifecycle.s locals = (androidx.lifecycle.s)this.Fim.getValue();
    AppMethodBeat.o(336952);
    return locals;
  }
  
  public final Object a(com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    AppMethodBeat.i(337265);
    if ((paramd1 instanceof e))
    {
      localObject1 = (e)paramd1;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject1;; paramd1 = new e(this, paramd1))
    {
      localObject1 = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337265);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = this.Fit;
    paramd1.L$0 = this;
    paramd1.label = 1;
    Object localObject2 = ((com.tencent.mm.plugin.finder.record.plugin.a)localObject1).a(paramd, paramd1);
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(337265);
      return locala;
      paramd = (FinderRecordTemplatePluginLayout)paramd1.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (com.tencent.mm.media.g.d)localObject1;
    paramd = paramd.Fin;
    paramd1.L$0 = null;
    paramd1.label = 2;
    paramd = paramd.a((com.tencent.mm.media.g.d)localObject1, paramd1);
    localObject1 = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(337265);
      return locala;
      ResultKt.throwOnFailure(localObject1);
    }
    AppMethodBeat.o(337265);
    return localObject1;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(337131);
    kotlin.g.b.s.u(parama, "navigator");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    Object localObject = paramRecordConfigProvider.oXZ;
    if (localObject != null)
    {
      ((VideoTransPara)localObject).height = (((VideoTransPara)localObject).width * 16 / 9);
      Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "onResume init SightRecordConfig,fix record size:" + ((VideoTransPara)localObject).width + 'x' + ((VideoTransPara)localObject).height);
      com.tencent.mm.plugin.recordvideo.c.h localh = com.tencent.mm.plugin.recordvideo.c.h.NHb;
      com.tencent.mm.plugin.recordvideo.c.h.a((VideoTransPara)localObject, 0, false);
    }
    localObject = com.tencent.mm.plugin.recordvideo.c.NDb;
    com.tencent.mm.plugin.recordvideo.c.f(paramRecordConfigProvider);
    this.Fiu = parama;
    this.oaV = paramRecordConfigProvider;
    localObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.j(paramRecordConfigProvider);
    this.Fin.i(paramRecordConfigProvider);
    long l = com.tencent.mm.modelcontrol.e.bIg().bIm().minDuration;
    localObject = this.Fin;
    l = kotlin.k.k.bR(l * 1000L, 2000L);
    Log.i("MicroMsg.CameraKitRecorder", kotlin.g.b.s.X("setRecordMinTimeMs:", Long.valueOf(l)));
    ((com.tencent.mm.plugin.recordvideo.d.a)localObject).NQU = l;
    this.Fio.setCameraKitSetting(new com.tencent.mm.media.camera.d.f(new g(com.tencent.mm.cd.a.w(getContext(), l.b.orange_100), false, 2)));
    super.a(parama, paramRecordConfigProvider);
    parama = com.tencent.mm.plugin.finder.record.report.a.Fjw;
    parama = getContext();
    if (parama == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(337131);
      throw parama;
    }
    parama = ((Activity)parama).getIntent();
    kotlin.g.b.s.s(parama, "context as Activity).intent");
    kotlin.g.b.s.u(parama, "intent");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    localObject = com.tencent.mm.mj_template.maas.b.a.obp;
    com.tencent.mm.mj_template.maas.b.a.uK(1001);
    parama.putExtras(paramRecordConfigProvider.oSS);
    com.tencent.mm.plugin.finder.record.report.a.ogn = new MaasPageFinderReporter(com.tencent.mm.plugin.finder.record.report.a.getSessionId(), 99, "", parama);
    AppMethodBeat.o(337131);
  }
  
  public final void a(a.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(337139);
    kotlin.g.b.s.u(paramc, "status");
    Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "status : " + paramc + "  param: " + paramBundle);
    BaseScopePluginLayout.a((BaseScopePluginLayout)this, (kotlin.d.f)bg.kCi(), null, (m)new g(paramc, this, paramBundle, null), 2);
    AppMethodBeat.o(337139);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(337167);
    super.bwk();
    this.Fir.setVisibility(0);
    AppMethodBeat.o(337167);
  }
  
  public final boolean eLi()
  {
    boolean bool2 = true;
    AppMethodBeat.i(337230);
    boolean bool3 = super.eLi();
    Object localObject = this.Fin;
    if (!bool3)
    {
      bool1 = true;
      ((com.tencent.mm.plugin.recordvideo.d.a)localObject).setMute(bool1);
      localObject = this.Fis;
      if (bool3) {
        break label62;
      }
    }
    label62:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.mj_template.maas.a.c)localObject).gN(bool1);
      AppMethodBeat.o(337230);
      return bool3;
      bool1 = false;
      break;
    }
  }
  
  public final androidx.lifecycle.j getLifecycle()
  {
    AppMethodBeat.i(337145);
    androidx.lifecycle.j localj = (androidx.lifecycle.j)getLifecycleRegistry();
    AppMethodBeat.o(337145);
    return localj;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(337201);
    if (super.onBackPress())
    {
      com.tencent.mm.mj_template.maas.b.c localc = com.tencent.mm.mj_template.maas.b.c.obu;
      com.tencent.mm.mj_template.maas.b.c.rG(1);
      AppMethodBeat.o(337201);
      return true;
    }
    AppMethodBeat.o(337201);
    return false;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(337210);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.oaV;
    if (paramConfiguration == null)
    {
      AppMethodBeat.o(337210);
      return;
    }
    com.tencent.mm.plugin.recordvideo.c localc = com.tencent.mm.plugin.recordvideo.c.NDb;
    com.tencent.mm.plugin.recordvideo.c.f(paramConfiguration);
    this.Fin.i(paramConfiguration);
    AppMethodBeat.o(337210);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(337177);
    super.onDetach();
    this.Fir.setVisibility(4);
    AppMethodBeat.o(337177);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(337221);
    this.Fip.cX(paramInt);
    AppMethodBeat.o(337221);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337161);
    Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "onPause");
    com.tencent.mm.plugin.finder.record.report.a locala = com.tencent.mm.plugin.finder.record.report.a.Fjw;
    com.tencent.mm.plugin.finder.record.report.a.eLn();
    super.onPause();
    getLifecycleRegistry().a(j.a.ON_PAUSE);
    AppMethodBeat.o(337161);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337152);
    Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "onResume");
    Object localObject = com.tencent.mm.plugin.finder.record.report.a.Fjw;
    com.tencent.mm.plugin.finder.record.report.a.eLo();
    super.onResume();
    getLifecycleRegistry().a(j.a.ON_RESUME);
    if (getCheckAudioPermission())
    {
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(337152);
        throw ((Throwable)localObject);
      }
      tr(com.tencent.mm.pluginsdk.permission.b.g((Context)localObject, new String[] { "android.permission.RECORD_AUDIO" }));
    }
    localObject = this.Fis;
    CharSequence localCharSequence = (CharSequence)((com.tencent.mm.mj_template.maas.a.c)localObject).oaX;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (CharSequence)((com.tencent.mm.mj_template.maas.a.c)localObject).oaY;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label190;
        }
        i = 1;
        label150:
        if (i != 0) {
          break label195;
        }
      }
      i = 1;
      label156:
      if (i == 0) {
        break label250;
      }
      localObject = this.Fis.imageReader;
      if (localObject != null) {
        break label200;
      }
    }
    label190:
    label195:
    label200:
    for (localObject = null;; localObject = ((ImageReader)localObject).getSurface())
    {
      if (localObject != null) {
        break label208;
      }
      AppMethodBeat.o(337152);
      return;
      i = 0;
      break;
      i = 0;
      break label150;
      i = 0;
      break label156;
    }
    label208:
    this.Fio.b((Surface)localObject, Integer.valueOf(this.Fis.oaZ.nvN.width), Integer.valueOf(this.Fis.oaZ.nvN.height));
    label250:
    AppMethodBeat.o(337152);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(337113);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    kotlin.g.b.s.u(this, "<this>");
    View localView1 = findViewById(l.e.finder_record_layout);
    View localView2 = findViewById(l.e.record_type_view);
    View localView3 = findViewById(l.e.finder_record_header);
    View localView4 = findViewById(l.e.camera_view);
    View localView5 = findViewById(l.e.record_plugin);
    paramInt1 = bf.bk(getContext());
    if ((getContext() instanceof Activity))
    {
      localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(337113);
        throw ((Throwable)localObject1);
      }
    }
    for (Object localObject1 = aw.bV((Activity)localObject1);; localObject1 = new Rect())
    {
      localObject2 = localView1.getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(337113);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = (RelativeLayout.LayoutParams)localObject2;
    Object localObject3 = localView3.getLayoutParams();
    if (localObject3 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(337113);
      throw ((Throwable)localObject1);
    }
    localObject3 = (RelativeLayout.LayoutParams)localObject3;
    Object localObject4 = localView2.getLayoutParams();
    if (localObject4 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(337113);
      throw ((Throwable)localObject1);
    }
    localObject4 = (RelativeLayout.LayoutParams)localObject4;
    localView4.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a.b(localView4, paramInt2, this, paramInt1, (RelativeLayout.LayoutParams)localObject2, (RelativeLayout.LayoutParams)localObject4, (RelativeLayout.LayoutParams)localObject3, localView3, (Rect)localObject1, localView2, localView1, localView5));
    AppMethodBeat.o(337113);
  }
  
  public final Object p(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(337253);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337253);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = this.Fit;
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (((com.tencent.mm.plugin.finder.record.plugin.a)localObject2).p(paramd) == locala)
    {
      AppMethodBeat.o(337253);
      return locala;
      localObject1 = (FinderRecordTemplatePluginLayout)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    localObject1 = ((FinderRecordTemplatePluginLayout)localObject1).Fin;
    paramd.L$0 = null;
    paramd.label = 2;
    if (((com.tencent.mm.plugin.recordvideo.d.a)localObject1).p(paramd) == locala)
    {
      AppMethodBeat.o(337253);
      return locala;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(337253);
    return paramd;
  }
  
  public final Object q(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(337271);
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337271);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = this.Fit;
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = this;
    if (((com.tencent.mm.plugin.finder.record.plugin.a)localObject2).q(paramd) == locala)
    {
      AppMethodBeat.o(337271);
      return locala;
      localObject1 = (FinderRecordTemplatePluginLayout)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    localObject1 = ((FinderRecordTemplatePluginLayout)localObject1).Fin;
    paramd.L$0 = null;
    paramd.label = 2;
    if (((com.tencent.mm.plugin.recordvideo.d.a)localObject1).q(paramd) == locala)
    {
      AppMethodBeat.o(337271);
      return locala;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(337271);
    return paramd;
  }
  
  public final void release()
  {
    AppMethodBeat.i(337192);
    com.tencent.mm.plugin.finder.record.report.a locala = com.tencent.mm.plugin.finder.record.report.a.Fjw;
    com.tencent.mm.plugin.finder.record.report.a.onDestroy();
    super.release();
    getLifecycleRegistry().a(j.a.ON_DESTROY);
    AppMethodBeat.o(337192);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(337183);
    super.reset();
    this.Fin.reset();
    AppMethodBeat.o(337183);
  }
  
  public final void tr(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(337241);
    Object localObject = this.Fin;
    if (!paramBoolean)
    {
      bool1 = true;
      ((com.tencent.mm.plugin.recordvideo.d.a)localObject).setMute(bool1);
      localObject = this.Fis;
      if (paramBoolean) {
        break label72;
      }
    }
    label72:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.mj_template.maas.a.c)localObject).gN(bool1);
      this.Fir.d(paramBoolean, new FinderRecordTemplatePluginLayout..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(337241);
      return;
      bool1 = false;
      break;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336932);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = FinderRecordTemplatePluginLayout.b(this.Fiv, (kotlin.d.d)this);
      AppMethodBeat.o(336932);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336929);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Fiv.p((kotlin.d.d)this);
      AppMethodBeat.o(336929);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336944);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Fiv.q((kotlin.d.d)this);
      AppMethodBeat.o(336944);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    e(FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336933);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Fiv.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(336933);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/LifecycleRegistry;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<androidx.lifecycle.s>
  {
    f(FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    g(a.c paramc, FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, Bundle paramBundle, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(336995);
      paramObject = (kotlin.d.d)new g(this.Fiw, jdField_this, paramBundle, paramd);
      AppMethodBeat.o(336995);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336982);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      int i;
      boolean bool;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(336982);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Fiw;
        switch (FinderRecordTemplatePluginLayout.g.a.$EnumSwitchMapping$0[paramObject.ordinal()])
        {
        default: 
          Log.i("MicroMsg.FinderRecordTemplatePluginLayout", kotlin.g.b.s.X("unknown status ", this.Fiw));
        }
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
        for (;;)
        {
          paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
          localObject1 = this.Fiw;
          localObject2 = paramBundle;
          kotlin.g.b.s.u(localObject1, "status");
          BaseScopePluginLayout.a(paramObject.oaR, (kotlin.d.f)bg.kCh(), null, (m)new b.g((a.c)localObject1, (Bundle)localObject2, paramObject, null), 2);
          FinderRecordTemplatePluginLayout.j(jdField_this).b(this.Fiw, paramBundle);
          paramObject = ah.aiuX;
          AppMethodBeat.o(336982);
          return paramObject;
          if (FinderRecordTemplatePluginLayout.b(jdField_this).buc() == 3)
          {
            paramObject = com.tencent.mm.plugin.finder.record.report.a.Fjw;
            localObject1 = FinderRecordTemplatePluginLayout.c(jdField_this).oaX;
            paramObject = localObject1;
            if (localObject1 == null) {
              paramObject = "";
            }
            com.tencent.mm.plugin.finder.record.report.a.hZ("btn_start_shooting", paramObject);
            paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
            localObject1 = (kotlin.d.d)this;
            this.label = 1;
            localObject1 = l.a((kotlin.d.f)bg.kCh(), (m)new b.j(paramObject, null), (kotlin.d.d)localObject1);
            paramObject = localObject1;
            if (localObject1 != kotlin.d.a.a.aiwj) {
              paramObject = ah.aiuX;
            }
            if (paramObject == locala)
            {
              AppMethodBeat.o(336982);
              return locala;
              ResultKt.throwOnFailure(paramObject);
            }
            paramObject = FinderRecordTemplatePluginLayout.c(jdField_this);
            localObject1 = com.tencent.mm.plugin.finder.record.config.a.Fix;
            localObject1 = com.tencent.mm.plugin.finder.record.config.a.azC(FinderRecordTemplatePluginLayout.d(jdField_this));
            localObject2 = (kotlin.d.d)this;
            this.label = 2;
            if (paramObject.a((MJAuditCaptureSettings)localObject1, (kotlin.d.d)localObject2) == locala)
            {
              AppMethodBeat.o(336982);
              return locala;
              ResultKt.throwOnFailure(paramObject);
            }
          }
          else
          {
            paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
            localObject1 = (kotlin.d.d)this;
            this.label = 3;
            localObject1 = l.a((kotlin.d.f)bg.kCh(), (m)new b.d(paramObject, null), (kotlin.d.d)localObject1);
            paramObject = localObject1;
            if (localObject1 != kotlin.d.a.a.aiwj) {
              paramObject = ah.aiuX;
            }
            if (paramObject == locala)
            {
              AppMethodBeat.o(336982);
              return locala;
              ResultKt.throwOnFailure(paramObject);
            }
            i = -FinderRecordTemplatePluginLayout.e(jdField_this).NLn;
            bool = FinderRecordTemplatePluginLayout.e(jdField_this).isLandscape();
            paramObject = FinderRecordTemplatePluginLayout.f(jdField_this);
            if (bool) {}
            for (bool = true;; bool = false)
            {
              paramObject.bu((i + 360) % 360, bool);
              break;
            }
            switch (FinderRecordTemplatePluginLayout.b(jdField_this).buc())
            {
            default: 
              break;
            case 1: 
              paramObject = FinderRecordTemplatePluginLayout.f(jdField_this);
              localObject1 = (kotlin.d.d)this;
              this.label = 8;
              localObject1 = paramObject.G((kotlin.d.d)localObject1);
              paramObject = localObject1;
              if (localObject1 == locala)
              {
                AppMethodBeat.o(336982);
                return locala;
              }
            case 3: 
              paramObject = FinderRecordTemplatePluginLayout.c(jdField_this);
              localObject1 = (kotlin.d.d)this;
              this.label = 4;
              localObject1 = paramObject.G((kotlin.d.d)localObject1);
              paramObject = localObject1;
              if (localObject1 == locala)
              {
                AppMethodBeat.o(336982);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = (com.tencent.mm.mj_template.maas.a.f)paramObject;
              localObject1 = FinderRecordTemplatePluginLayout.b(jdField_this);
              localObject2 = (kotlin.d.d)this;
              this.L$0 = paramObject;
              this.label = 5;
              localObject2 = l.a((kotlin.d.f)bg.kCh(), (m)new b.i((com.tencent.mm.plugin.finder.record.plugin.b)localObject1, null), (kotlin.d.d)localObject2);
              localObject1 = localObject2;
              if (localObject2 != kotlin.d.a.a.aiwj) {
                localObject1 = ah.aiuX;
              }
              if (localObject1 == locala)
              {
                AppMethodBeat.o(336982);
                return locala;
                localObject1 = (com.tencent.mm.mj_template.maas.a.f)this.L$0;
                ResultKt.throwOnFailure(paramObject);
                paramObject = localObject1;
              }
              switch (paramObject.result)
              {
              default: 
                break;
              case -4: 
                paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
                localObject1 = (kotlin.d.d)this;
                this.L$0 = null;
                this.label = 7;
                if (paramObject.ag((kotlin.d.d)localObject1) == locala)
                {
                  AppMethodBeat.o(336982);
                  return locala;
                }
                break;
              case 0: 
                localObject1 = com.tencent.mm.mj_template.maas.b.c.obu;
                localObject1 = paramObject.path;
                kotlin.g.b.s.checkNotNull(localObject1);
                com.tencent.mm.mj_template.maas.b.c.HJ((String)localObject1);
                localObject1 = com.tencent.mm.mj_template.maas.b.c.obu;
                com.tencent.mm.mj_template.maas.b.c.rG(3);
                localObject1 = jdField_this;
                localObject2 = (kotlin.d.d)this;
                this.L$0 = paramObject;
                this.label = 6;
                if (FinderRecordTemplatePluginLayout.a((FinderRecordTemplatePluginLayout)localObject1, (kotlin.d.d)localObject2) == locala)
                {
                  AppMethodBeat.o(336982);
                  return locala;
                  localObject1 = (com.tencent.mm.mj_template.maas.a.f)this.L$0;
                  ResultKt.throwOnFailure(paramObject);
                  paramObject = localObject1;
                }
                localObject1 = jdField_this;
                localObject2 = paramObject.path;
                kotlin.g.b.s.checkNotNull(localObject2);
                FinderRecordTemplatePluginLayout.a((FinderRecordTemplatePluginLayout)localObject1, p.al(new String[] { localObject2 }), paramObject.obo);
                continue;
                ResultKt.throwOnFailure(paramObject);
                continue;
                ResultKt.throwOnFailure(paramObject);
                localObject1 = (r)paramObject;
                paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
                localObject2 = (kotlin.d.d)this;
                this.L$0 = localObject1;
                this.label = 9;
                localObject2 = l.a((kotlin.d.f)bg.kCh(), (m)new b.c(paramObject, null), (kotlin.d.d)localObject2);
                paramObject = localObject2;
                if (localObject2 != kotlin.d.a.a.aiwj) {
                  paramObject = ah.aiuX;
                }
                if (paramObject == locala)
                {
                  AppMethodBeat.o(336982);
                  return locala;
                  localObject1 = (r)this.L$0;
                  ResultKt.throwOnFailure(paramObject);
                }
                Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "stopRecord resurlt:" + ((Number)((r)localObject1).bsC).intValue() + " info:" + ((r)localObject1).bsD);
                if (((Number)((r)localObject1).bsC).intValue() == 0)
                {
                  paramObject = jdField_this;
                  localObject1 = ((r)localObject1).bsD;
                  kotlin.g.b.s.checkNotNull(localObject1);
                  FinderRecordTemplatePluginLayout.a(paramObject, p.al(new String[] { ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU }));
                }
                else if (((Number)((r)localObject1).bsC).intValue() == -4)
                {
                  paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
                  localObject1 = (kotlin.d.d)this;
                  this.L$0 = null;
                  this.label = 10;
                  if (paramObject.ag((kotlin.d.d)localObject1) == locala)
                  {
                    AppMethodBeat.o(336982);
                    return locala;
                    ResultKt.throwOnFailure(paramObject);
                  }
                }
                break;
              }
              break;
            case 2: 
              paramObject = FinderRecordTemplatePluginLayout.f(jdField_this);
              localObject1 = (kotlin.d.d)this;
              this.label = 11;
              localObject1 = paramObject.G((kotlin.d.d)localObject1);
              paramObject = localObject1;
              if (localObject1 == locala)
              {
                AppMethodBeat.o(336982);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              localObject1 = (r)paramObject;
              FinderRecordTemplatePluginLayout.f(jdField_this).reset();
              Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "stopRecord result:" + ((Number)((r)localObject1).bsC).intValue() + " info:" + ((r)localObject1).bsD);
              switch (((Number)((r)localObject1).bsC).intValue())
              {
              default: 
                break;
              case -4: 
                paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
                localObject1 = (kotlin.d.d)this;
                this.label = 13;
                if (paramObject.ag((kotlin.d.d)localObject1) == locala)
                {
                  AppMethodBeat.o(336982);
                  return locala;
                }
                break;
              case 0: 
                paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
                localObject1 = ((r)localObject1).bsD;
                kotlin.g.b.s.checkNotNull(localObject1);
                localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
                kotlin.g.b.s.u(localObject1, "path");
                paramObject.FiI.bV((String)localObject1, true);
                paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
                localObject1 = (kotlin.d.d)this;
                this.label = 12;
                localObject1 = l.a((kotlin.d.f)bg.kCh(), (m)new b.h(paramObject, null), (kotlin.d.d)localObject1);
                paramObject = localObject1;
                if (localObject1 != kotlin.d.a.a.aiwj) {
                  paramObject = ah.aiuX;
                }
                if (paramObject == locala)
                {
                  AppMethodBeat.o(336982);
                  return locala;
                  ResultKt.throwOnFailure(paramObject);
                  continue;
                  ResultKt.throwOnFailure(paramObject);
                  continue;
                  FinderRecordTemplatePluginLayout.a(jdField_this, FinderRecordTemplatePluginLayout.b(jdField_this).FiI.fjR());
                  continue;
                  paramObject = (com.tencent.mm.media.camera.view.d)FinderRecordTemplatePluginLayout.g(jdField_this);
                  i = -FinderRecordTemplatePluginLayout.e(jdField_this).NLn;
                  localObject1 = (kotlin.d.d)this;
                  this.label = 14;
                  localObject1 = com.tencent.mm.media.camera.view.d.a.a(paramObject, (i + 360) % 360, (kotlin.d.d)localObject1);
                  paramObject = localObject1;
                  if (localObject1 == locala)
                  {
                    AppMethodBeat.o(336982);
                    return locala;
                    ResultKt.throwOnFailure(paramObject);
                  }
                  paramObject = (r)paramObject;
                  if (((Number)paramObject.bsC).intValue() == 0)
                  {
                    localObject1 = FinderRecordTemplatePluginLayout.h(jdField_this);
                    kotlin.g.b.s.checkNotNull(localObject1);
                    localObject1 = ((RecordConfigProvider)localObject1).NIf;
                    BitmapUtil.saveBitmapToImage((Bitmap)paramObject.bsD, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
                    paramObject = jdField_this;
                    kotlin.g.b.s.s(localObject1, "path");
                    FinderRecordTemplatePluginLayout.a(paramObject, (String)localObject1);
                    continue;
                    FinderRecordTemplatePluginLayout.g(jdField_this).switchCamera();
                    continue;
                    if (paramBundle != null)
                    {
                      paramObject = paramBundle;
                      localObject1 = jdField_this;
                      if (paramObject.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false)) {
                        FinderRecordTemplatePluginLayout.g((FinderRecordTemplatePluginLayout)localObject1).bof();
                      } else {
                        FinderRecordTemplatePluginLayout.g((FinderRecordTemplatePluginLayout)localObject1).bog();
                      }
                    }
                  }
                }
                break;
              }
              break;
            }
          }
        }
        paramObject = paramBundle;
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = paramObject.getByteArray("PARAM_1_BYTEARRAY"))
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(336982);
          return paramObject;
        }
        localObject1 = new fxr();
        ((fxr)localObject1).parseFrom(paramObject);
        paramObject = com.tencent.mm.mj_template.maas.b.c.obu;
        com.tencent.mm.mj_template.maas.b.c.HI(((fxr)localObject1).id);
        bool = FinderRecordTemplatePluginLayout.i(jdField_this);
        paramObject = new StringBuilder("RECORD_SWITCH_TEMPLATE:").append(((fxr)localObject1).id).append(" name:").append(((fxr)localObject1).abVq.title).append(", isCurrentCameraScreenOutput:");
        if (bool)
        {
          bool = true;
          Log.i("MicroMsg.FinderRecordTemplatePluginLayout", bool);
          paramObject = FinderRecordTemplatePluginLayout.b(jdField_this);
          localObject2 = ((fxr)localObject1).abVq.title;
          locald = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.label = 15;
          if (localObject2 != null) {
            break label2119;
          }
          paramObject = ah.aiuX;
        }
      case 15: 
        for (;;)
        {
          if (paramObject == locala)
          {
            AppMethodBeat.o(336982);
            return locala;
            bool = false;
            break;
            label2119:
            localObject2 = l.a((kotlin.d.f)bg.kCh(), (m)new b.k(paramObject, (String)localObject2, null), locald);
            paramObject = localObject2;
            if (localObject2 != kotlin.d.a.a.aiwj)
            {
              paramObject = ah.aiuX;
              continue;
              localObject1 = (fxr)this.L$0;
              ResultKt.throwOnFailure(paramObject);
            }
          }
        }
      }
      for (paramObject = localObject1;; paramObject = localObject1)
      {
        if (kotlin.g.b.s.p(paramObject.id, "empty"))
        {
          FinderRecordTemplatePluginLayout.b(jdField_this).ts(true);
          paramObject = jdField_this;
          localObject1 = (kotlin.d.d)this;
          this.L$0 = null;
          this.label = 16;
          if (FinderRecordTemplatePluginLayout.b(paramObject, (kotlin.d.d)localObject1) != locala) {
            break;
          }
          AppMethodBeat.o(336982);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          break;
        }
        localObject1 = com.tencent.mm.plugin.finder.record.report.a.Fjw;
        localObject1 = paramObject.id;
        kotlin.g.b.s.s(localObject1, "template.id");
        com.tencent.mm.plugin.finder.record.report.a.hZ("shooting_template", (String)localObject1);
        FinderRecordTemplatePluginLayout.b(jdField_this).ts(false);
        localObject1 = FinderRecordTemplatePluginLayout.c(jdField_this);
        paramObject = paramObject.id;
        localObject2 = FinderRecordTemplatePluginLayout.g(jdField_this);
        locald = (kotlin.d.d)this;
        this.L$0 = null;
        this.label = 17;
        localObject1 = ((com.tencent.mm.mj_template.maas.a.c)localObject1).a(paramObject, (com.tencent.mm.media.camera.view.b)localObject2, locald);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(336982);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (Surface)paramObject;
        if (paramObject == null) {
          break;
        }
        localObject1 = jdField_this;
        FinderRecordTemplatePluginLayout.j((FinderRecordTemplatePluginLayout)localObject1).yoh = false;
        localObject2 = FinderRecordTemplatePluginLayout.c((FinderRecordTemplatePluginLayout)localObject1).oaW;
        if (localObject2 == null) {
          i = -1;
        }
        for (;;)
        {
          if (i > 0) {
            FinderRecordTemplatePluginLayout.b((FinderRecordTemplatePluginLayout)localObject1).RG(i);
          }
          this.label = 18;
          if (FinderRecordTemplatePluginLayout.a((FinderRecordTemplatePluginLayout)localObject1, paramObject, this) != locala) {
            break;
          }
          AppMethodBeat.o(336982);
          return locala;
          localObject2 = ((MJCaptureOptions)localObject2).getMaxRecordingDuration();
          if (localObject2 == null) {
            i = -1;
          } else {
            i = (int)((MJTime)localObject2).toMilliseconds();
          }
        }
        ResultKt.throwOnFailure(paramObject);
        break;
        paramObject = com.tencent.mm.mj_template.maas.b.c.obu;
        com.tencent.mm.mj_template.maas.b.c.HI("");
        paramObject = jdField_this;
        localObject1 = (kotlin.d.d)this;
        this.label = 19;
        if (FinderRecordTemplatePluginLayout.b(paramObject, (kotlin.d.d)localObject1) != locala) {
          break;
        }
        AppMethodBeat.o(336982);
        return locala;
        ResultKt.throwOnFailure(paramObject);
        break;
        paramObject = (kotlin.d.f)bg.kCh();
        localObject1 = (m)new kotlin.d.b.a.k(jdField_this, null)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(336904);
            paramAnonymousObject = (kotlin.d.d)new 1(this.Fiv, paramAnonymousd);
            AppMethodBeat.o(336904);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(336896);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(336896);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            if (!this.Fiv.onBackPress())
            {
              paramAnonymousObject = this.Fiv.getContext();
              if (paramAnonymousObject == null)
              {
                paramAnonymousObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
                AppMethodBeat.o(336896);
                throw paramAnonymousObject;
              }
              ((MMRecordUI)paramAnonymousObject).gGB();
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(336896);
            return paramAnonymousObject;
          }
        };
        localObject2 = (kotlin.d.d)this;
        this.label = 20;
        if (l.a(paramObject, (m)localObject1, (kotlin.d.d)localObject2) != locala) {
          break;
        }
        AppMethodBeat.o(336982);
        return locala;
        ResultKt.throwOnFailure(paramObject);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(boolean paramBoolean, Surface paramSurface, FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(336936);
      paramObject = (kotlin.d.d)new h(this.obi, paramSurface, jdField_this, paramd);
      AppMethodBeat.o(336936);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336930);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(336930);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.FinderRecordTemplatePluginLayout", "toggleCameraScreenOutput show:" + this.obi + ", surface:" + paramSurface);
        if ((paramSurface == null) || (this.obi)) {
          break label237;
        }
        FinderRecordTemplatePluginLayout.g(jdField_this).b(paramSurface, Integer.valueOf(FinderRecordTemplatePluginLayout.c(jdField_this).oaZ.nvN.width), Integer.valueOf(FinderRecordTemplatePluginLayout.c(jdField_this).oaZ.nvN.height));
        paramObject = FinderRecordTemplatePluginLayout.c(jdField_this);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (com.tencent.mm.mj_template.maas.a.c.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(336930);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (View)FinderRecordTemplatePluginLayout.g(jdField_this);
      if (this.obi) {}
      for (int i = 0;; i = 4)
      {
        paramObject.setVisibility(i);
        paramObject = ah.aiuX;
        AppMethodBeat.o(336930);
        return paramObject;
        label237:
        if (!this.obi) {
          break;
        }
        FinderRecordTemplatePluginLayout.g(jdField_this).box();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.FinderRecordTemplatePluginLayout
 * JD-Core Version:    0.7.0.1
 */