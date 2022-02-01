package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.video.plugin.c;
import com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordBeautyView;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.aa;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar;
import com.tencent.mm.plugin.recordvideo.plugin.w;
import com.tencent.mm.plugin.recordvideo.plugin.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderRecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "beautifyPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "horizontalSubProgressPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewBottomProvider", "Lkotlin/Function0;", "", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "recordController", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "recordEditRootView", "Landroid/view/ViewGroup;", "recordFeatureView", "Landroid/view/View;", "recordPathPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "selectTypePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/subvideo/FinderRecordTypePlugin;", "subRecordDeletePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "subRecordFinishPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "touchFocusPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "util", "Lcom/tencent/mm/plugin/finder/video/plugin/util/FinderLayoutUtil;", "initConfig", "", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "onDetach", "onOrientationChange", "orientation", "onPause", "onResume", "release", "setPreviewRatio", "ratio", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderRecordPluginLayout
  extends BasePluginLayout
  implements d.a, com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a Lcb;
  private final ViewGroup LbP;
  private final com.tencent.mm.plugin.finder.video.plugin.b LbQ;
  private final com.tencent.mm.plugin.finder.video.plugin.a LbR;
  private final com.tencent.mm.plugin.recordvideo.plugin.progress.a LbS;
  private final com.tencent.mm.plugin.finder.video.plugin.a.a LbT;
  private final com.tencent.mm.plugin.finder.video.plugin.d LbU;
  private final c LbV;
  private final View LbW;
  private a LbX;
  private com.tencent.mm.plugin.finder.video.plugin.e LbY;
  private com.tencent.mm.plugin.finder.video.plugin.b.a LbZ;
  private final d.g.a.a<Integer> Lca;
  private com.tencent.mm.plugin.mmsight.model.d tKW;
  private RecordConfigProvider vcC;
  private final CameraPreviewGLSurfaceView vcT;
  private com.tencent.mm.plugin.recordvideo.activity.a vmM;
  private final w voN;
  private final aa voQ;
  private final z voR;
  private com.tencent.mm.media.widget.camerarecordview.a voV;
  
  static
  {
    AppMethodBeat.i(199746);
    Lcb = new a((byte)0);
    AppMethodBeat.o(199746);
  }
  
  public FinderRecordPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168010);
    this.tKW = new com.tencent.mm.plugin.mmsight.model.d(paramContext, (byte)0);
    this.LbY = new com.tencent.mm.plugin.finder.video.plugin.e((com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.LbZ = new com.tencent.mm.plugin.finder.video.plugin.b.a();
    LayoutInflater.from(paramContext).inflate(2131496245, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131307362);
    k.g(paramAttributeSet, "findViewById(R.id.finder_record_layout)");
    this.LbP = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131305575);
    k.g(paramAttributeSet, "findViewById(R.id.switch_camera)");
    this.voQ = new aa((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131298376);
    k.g(paramAttributeSet, "findViewById(R.id.close_plugin)");
    this.LbQ = new com.tencent.mm.plugin.finder.video.plugin.b((WeImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.voR = new z((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131303903);
    k.g(paramAttributeSet, "findViewById(R.id.record_plugin)");
    this.voN = new w((RelativeLayout)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307347);
    k.g(paramAttributeSet, "findViewById(R.id.finder_preview_plugin)");
    this.vcT = ((CameraPreviewGLSurfaceView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307833);
    k.g(paramAttributeSet, "findViewById(R.id.record_type_view)");
    this.LbT = new com.tencent.mm.plugin.finder.video.plugin.a.a((RecordTypeSelectView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307287);
    k.g(paramAttributeSet, "findViewById(R.id.delete_sub_video)");
    this.LbV = new c((WeImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131303525);
    k.g(paramAttributeSet, "findViewById(R.id.progress_horizontal)");
    this.LbS = new com.tencent.mm.plugin.recordvideo.plugin.progress.a((HorizontalSubProgressBar)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.voN.Lnn = ((d.g.a.b)new FinderRecordPluginLayout.1(this));
    this.Lca = ((d.g.a.a)new FinderRecordPluginLayout.2(this));
    paramAttributeSet = findViewById(2131307362);
    k.g(paramAttributeSet, "findViewById(R.id.finder_record_layout)");
    this.LbW = paramAttributeSet;
    paramAttributeSet = new SubRecordFinishView(paramContext, null);
    paramAttributeSet.setVisibility(4);
    ((FrameLayout)findViewById(2131307837)).addView((View)paramAttributeSet, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.LbU = new com.tencent.mm.plugin.finder.video.plugin.d(paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramContext = new SubRecordBeautyView(paramContext, null);
    ((FrameLayout)findViewById(2131307837)).addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.LbR = new com.tencent.mm.plugin.finder.video.plugin.a((ViewGroup)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, (com.tencent.mm.media.widget.camerarecordview.preview.e)this.vcT);
    getPluginList().add(this.voN);
    getPluginList().add(this.LbQ);
    getPluginList().add(this.voQ);
    getPluginList().add(this.voR);
    getPluginList().add(this.LbT);
    getPluginList().add(this.LbY);
    paramContext = this.tKW;
    if (paramContext != null) {
      paramContext.a((d.a)this);
    }
    paramContext = this.tKW;
    if (paramContext != null)
    {
      paramContext.enable();
      AppMethodBeat.o(168010);
      return;
    }
    AppMethodBeat.o(168010);
  }
  
  private final void csj()
  {
    AppMethodBeat.i(168007);
    Object localObject = this.vcC;
    if (localObject != null)
    {
      localObject = ((RecordConfigProvider)localObject).vhH;
      if (localObject != null)
      {
        ad.i("Finder.FinderRecordPluginLayout", "onResume init SightRecordConfig");
        g localg = g.vgS;
        g.a((VideoTransPara)localObject, 0, false);
        AppMethodBeat.o(168007);
        return;
      }
    }
    AppMethodBeat.o(168007);
  }
  
  private final void setPreviewRatio(float paramFloat)
  {
    AppMethodBeat.i(168009);
    Object localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "MMApplicationContext.getContext().resources");
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = (int)(i / paramFloat);
    ad.i("Finder.FinderRecordPluginLayout", "[setPreviewSize] width=" + i + " height=" + j);
    localObject = new RelativeLayout.LayoutParams(i, j);
    if (this.LbZ.a(getContext(), Float.valueOf(paramFloat)))
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).removeRule(2);
    }
    for (;;)
    {
      this.vcT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(168009);
      return;
      ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.ao(getContext(), 2131167033);
    }
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(199744);
    super.a(paramb);
    setBackgroundColor(Color.parseColor("#000000"));
    if (this.LbT.Ldq)
    {
      this.LbV.setVisibility(0);
      this.LbU.setVisibility(0);
      this.LbS.setVisibility(0);
      AppMethodBeat.o(199744);
      return;
    }
    this.LbT.setVisibility(0);
    this.LbR.setVisibility(0);
    this.LbS.reset();
    this.LbY.fWB();
    AppMethodBeat.o(199744);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(168005);
    k.h(parama, "navigator");
    k.h(paramRecordConfigProvider, "configProvider");
    this.vcC = paramRecordConfigProvider;
    this.LbX = new a(paramRecordConfigProvider, this.vcT);
    csj();
    setPreviewRatio(paramRecordConfigProvider.vhI.fGZ);
    this.vmM = parama;
    this.vcC = paramRecordConfigProvider;
    parama = this.LbX;
    if (parama == null) {
      k.fvU();
    }
    this.voV = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)parama);
    if (paramRecordConfigProvider.scene == 11)
    {
      parama = com.tencent.mm.modelcontrol.d.awT();
      k.g(parama, "SubCoreVideoControl.getCore()");
      long l = parama.awY().minDuration * 1000L;
      if (l >= 1000L)
      {
        parama = this.voV;
        if (parama != null) {
          parama.lQ(l);
        }
      }
    }
    for (;;)
    {
      this.voR.a(paramRecordConfigProvider);
      this.voN.a(paramRecordConfigProvider);
      this.LbQ.a(paramRecordConfigProvider);
      this.LbR.a(paramRecordConfigProvider);
      this.LbY.a(paramRecordConfigProvider);
      parama = new StringBuilder("configProvider:").append(paramRecordConfigProvider).append(", config:");
      paramRecordConfigProvider = g.vgS;
      ad.i("Finder.FinderRecordPluginLayout", g.fXZ());
      AppMethodBeat.o(168005);
      return;
      parama = this.voV;
      if (parama != null)
      {
        parama.lQ(1000L);
        continue;
        parama = this.voV;
        if (parama != null) {
          parama.lQ(1000L);
        }
      }
    }
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(199743);
    k.h(paramc, "status");
    ad.i("Finder.FinderRecordPluginLayout", "status : " + paramc + "  param: " + paramBundle);
    boolean bool;
    label332:
    label347:
    label605:
    Object localObject1;
    switch (j.ciE[paramc.ordinal()])
    {
    default: 
      ad.i("Finder.FinderRecordPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
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
      do
      {
        AppMethodBeat.o(199743);
        return;
        paramc = this.vcC;
        int i;
        if ((paramc != null) && (paramc.vib == true))
        {
          paramc = this.tKW;
          if (paramc != null)
          {
            bool = paramc.aov();
            paramc = this.tKW;
            if (paramc == null) {
              break label332;
            }
            i = paramc.getOrientation();
          }
        }
        for (;;)
        {
          paramc = this.voV;
          if (paramc != null) {
            paramc.j(bool, i);
          }
          paramc = g.vgS;
          g.dhw();
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
          this.LbR.setVisibility(4);
          this.LbU.setVisibility(4);
          this.LbV.setVisibility(4);
          this.LbT.setVisibility(4);
          this.LbQ.setVisibility(8);
          if (!this.LbT.Ldq) {
            break label347;
          }
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_SUB_VIDEO_RECORD_CLICK_INT");
          paramc = q.KVK;
          q.ay(228L, 1L);
          AppMethodBeat.o(199743);
          return;
          bool = false;
          break;
          i = 0;
          continue;
          bool = false;
          i = 0;
        }
        paramc = q.KVK;
        q.ay(210L, 1L);
        AppMethodBeat.o(199743);
        return;
        this.LbS.LoL.fYp();
        paramc = this.voV;
        if ((paramc != null) && (!paramc.j((d.g.a.b)new FinderRecordPluginLayout.e(this, paramBundle))))
        {
          if (!this.LbT.Ldq) {
            break label533;
          }
          paramc = q.KVK;
          q.ay(230L, 1L);
          this.voN.aic(this.LbY.Ldm.size());
          this.LbS.o(Integer.valueOf(this.LbY.Ldm.size()));
          if (!this.LbY.Ldm.isEmpty()) {
            break label514;
          }
          this.LbT.setVisibility(0);
          this.voN.Kl(2131762241);
          this.voN.reset();
        }
        for (;;)
        {
          this.LbQ.setVisibility(0);
          AppMethodBeat.o(199743);
          return;
          this.LbV.setVisibility(0);
          this.LbU.setVisibility(0);
          break;
          this.voN.reset();
          paramc = this.voV;
          if (paramc != null) {}
          for (l = paramc.gAE;; l = 0L)
          {
            if (bt.aS(l) <= 1000L) {
              break label605;
            }
            paramc = q.KVK;
            q.ay(212L, 1L);
            this.voN.Kl(2131762241);
            this.LbT.setVisibility(0);
            break;
          }
          this.voN.fYi();
        }
        if (paramBundle != null)
        {
          paramc = this.voN;
          if (!paramBundle.getBoolean("PARAM_1_BOOLEAN"))
          {
            bool = true;
            paramc.za(bool);
            if (!paramBundle.getBoolean("PARAM_1_BOOLEAN")) {
              break label716;
            }
            this.voN.setEnableSubProgress(true);
            this.LbS.reset();
            this.LbS.setVisibility(0);
            paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
            com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.TRUE);
            paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
            com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_CHANGE_SUB_RECORD_TAB_INT");
          }
          for (;;)
          {
            paramc = y.JfV;
            AppMethodBeat.o(199743);
            return;
            bool = false;
            break;
            this.voN.setEnableSubProgress(false);
            this.LbS.setVisibility(4);
            paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
            com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
          }
        }
        AppMethodBeat.o(199743);
        return;
        if (paramBundle != null)
        {
          Object localObject2 = paramBundle.getStringArrayList("PARAM_PHOTO_LIST");
          localObject1 = paramBundle.getStringArrayList("PARAM_VIDEO_LIST");
          paramc = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, 16383);
          Object localObject3 = (Collection)localObject2;
          if ((localObject3 == null) || (((Collection)localObject3).isEmpty()))
          {
            i = 1;
            if (i == 0)
            {
              if (localObject2 == null) {
                k.fvU();
              }
              localObject3 = ((ArrayList)localObject2).get(0);
              k.g(localObject3, "imageList!![0]");
              paramc.rt((String)localObject3);
              paramc.aS((ArrayList)localObject2);
            }
            localObject2 = (Collection)localObject1;
            if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
              break label991;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              if (localObject1 == null) {
                k.fvU();
              }
              localObject2 = ((ArrayList)localObject1).get(0);
              k.g(localObject2, "videoList!![0]");
              paramc.rr((String)localObject2);
              paramc.aU((ArrayList)localObject1);
            }
            paramc.gBl = false;
            paramc.fQH();
            localObject1 = this.vmM;
            if (localObject1 != null)
            {
              ((com.tencent.mm.plugin.recordvideo.activity.a)localObject1).a(paramBundle.getInt("PARAM_ROUTER_INT", 0), paramc);
              paramc = y.JfV;
            }
            paramc = y.JfV;
            AppMethodBeat.o(199743);
            return;
            i = 0;
            break;
          }
        }
        AppMethodBeat.o(199743);
        return;
        if (paramBundle != null)
        {
          paramc = this.voV;
          if (paramc != null)
          {
            paramc.mN(paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
            paramc = y.JfV;
          }
          paramc = y.JfV;
          AppMethodBeat.o(199743);
          return;
        }
        AppMethodBeat.o(199743);
        return;
        if (paramBundle != null)
        {
          paramc = this.voV;
          if (paramc != null)
          {
            bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
            paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
            paramc.i(bool, paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
            paramc = y.JfV;
          }
          paramc = y.JfV;
        }
        AppMethodBeat.o(199743);
        return;
        paramc = this.voV;
        if (paramc != null)
        {
          paramc = Boolean.valueOf(com.tencent.mm.media.widget.camerarecordview.a.b(paramc));
          paramBundle = this.LbR;
          localObject1 = this.voV;
          if (localObject1 == null) {
            break label1202;
          }
          bool = ((com.tencent.mm.media.widget.camerarecordview.a)localObject1).gAD;
          paramBundle.ot(bool);
          if (paramc == null) {
            break label1214;
          }
          paramc.booleanValue();
          paramBundle = this.voQ;
          if (paramc.booleanValue()) {
            break label1208;
          }
        }
        for (bool = true;; bool = false)
        {
          paramBundle.zc(bool);
          paramc = y.JfV;
          AppMethodBeat.o(199743);
          return;
          paramc = null;
          break;
          bool = false;
          break label1150;
        }
        AppMethodBeat.o(199743);
        return;
        if (paramBundle != null)
        {
          f1 = paramBundle.getFloat("PARAM_POINT_X");
          if (paramBundle == null) {
            break label1292;
          }
        }
        for (float f2 = paramBundle.getFloat("PARAM_POINT_Y");; f2 = 0.0F)
        {
          paramc = this.voV;
          if (paramc == null) {
            break label1298;
          }
          paramc.b(f1, f2, this.vcT.getWidth(), this.vcT.getHeight());
          paramc = y.JfV;
          AppMethodBeat.o(199743);
          return;
          f1 = 0.0F;
          break;
        }
        AppMethodBeat.o(199743);
        return;
        long l = bt.GC();
        paramc = this.tKW;
        if (paramc != null) {}
        for (float f1 = paramc.cPE();; f1 = 0.0F)
        {
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
          paramc = this.voV;
          if (paramc == null) {
            break;
          }
          paramc.l((d.g.a.b)new FinderRecordPluginLayout.f(this, l, f1));
          paramc = y.JfV;
          AppMethodBeat.o(199743);
          return;
        }
        AppMethodBeat.o(199743);
        return;
        if (paramBundle != null)
        {
          bool = paramBundle.getBoolean("PARAM_BEAUTIFY_ENABLE");
          paramc = this.LbX;
          if (paramc == null) {
            break label1468;
          }
        }
        for (paramc = paramc.getPreviewRenderer();; paramc = null)
        {
          paramBundle = paramc;
          if (!(paramc instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
            paramBundle = null;
          }
          paramc = (com.tencent.mm.plugin.recordvideo.c.b)paramBundle;
          this.vcT.j((d.g.a.a)new FinderRecordPluginLayout.g(this, paramc, bool));
          AppMethodBeat.o(199743);
          return;
          bool = false;
          break;
        }
        paramc = q.KVK;
        q.ay(192L, 1L);
        this.LbS.yY(true);
        this.voN.yY(true);
        AppMethodBeat.o(199743);
        return;
        this.LbS.yY(false);
        this.voN.yY(false);
        AppMethodBeat.o(199743);
        return;
        paramc = q.KVK;
        q.ay(193L, 1L);
        this.LbY.fWB();
        this.voN.aic(this.LbY.Ldm.size());
        this.LbS.o(Integer.valueOf(this.LbY.Ldm.size()));
      } while (!this.LbY.Ldm.isEmpty());
      this.LbT.setVisibility(0);
      this.LbV.setVisibility(4);
      this.LbR.setVisibility(0);
      this.LbU.setVisibility(4);
      AppMethodBeat.o(199743);
      return;
    case 14: 
      if (this.LbT.Ldq)
      {
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(this.LbY.fWD().size()));
      }
      if ((this.LbT.Ldq) && (!this.LbY.Ldm.isEmpty()))
      {
        paramc = q.KVK;
        q.ay(194L, 1L);
        this.LbQ.iAV.show();
        AppMethodBeat.o(199743);
        return;
      }
      paramc = getContext();
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(199743);
        throw paramc;
      }
      ((MMRecordUI)paramc).fXY();
      AppMethodBeat.o(199743);
      return;
    case 15: 
      if (this.LbT.Ldq)
      {
        paramc = q.KVK;
        q.ay(229L, 1L);
        paramc = q.KVK;
        q.aX(this.LbY.fWD());
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(this.LbY.fWD().size()));
      }
      paramc = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, 16383);
      paramBundle = this.LbY.fWD();
      localObject1 = paramBundle.get(0);
      k.g(localObject1, "videoList[0]");
      paramc.rr((String)localObject1);
      paramc.aU(paramBundle);
      paramc.gBl = true;
      paramc.fQH();
      paramBundle = this.vcC;
      if (paramBundle != null) {
        paramBundle.hsl = this.LbY.fWC();
      }
      paramBundle = this.vmM;
      if (paramBundle != null)
      {
        paramBundle.a(4, paramc);
        paramc = y.JfV;
        AppMethodBeat.o(199743);
        return;
      }
      AppMethodBeat.o(199743);
      return;
    case 16: 
      label514:
      label533:
      label716:
      label991:
      label1150:
      if (paramBundle != null) {}
      label1202:
      label1208:
      label1214:
      for (bool = paramBundle.getBoolean("PARAM_STICKER_PANEL_OPEN"); !bool; bool = false)
      {
        this.LbW.setVisibility(0);
        AppMethodBeat.o(199743);
        return;
      }
      label1292:
      label1298:
      label1468:
      this.LbW.setVisibility(4);
      AppMethodBeat.o(199743);
      return;
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("PARAM_STICKER_LENS_ID");
      paramc = this.LbX;
      if (paramc == null) {
        break label2090;
      }
      paramc = paramc.getPreviewRenderer();
      label2021:
      localObject1 = paramc;
      if (!(paramc instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.plugin.recordvideo.c.b)localObject1;
      if (localObject1 == null) {
        break label2114;
      }
      if (paramBundle != null) {
        break label2095;
      }
    }
    for (paramc = null;; paramc = e.a.aWf(com.tencent.mm.sticker.loader.e.aHd(paramBundle)))
    {
      this.vcT.j((d.g.a.a)new FinderRecordPluginLayout.d((com.tencent.mm.plugin.recordvideo.c.b)localObject1, paramc, this, paramBundle));
      paramc = y.JfV;
      AppMethodBeat.o(199743);
      return;
      paramBundle = null;
      break;
      label2090:
      paramc = null;
      break label2021;
      label2095:
      paramc = com.tencent.mm.sticker.e.Fdd;
      paramc = com.tencent.mm.sticker.loader.e.Fds;
    }
    label2114:
    AppMethodBeat.o(199743);
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(199745);
    if (!super.dia())
    {
      d.b.a(this, d.c.LoF);
      AppMethodBeat.o(199745);
      return true;
    }
    AppMethodBeat.o(199745);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(199742);
    super.onDetach();
    ad.i("Finder.FinderRecordPluginLayout", "onDetach");
    com.tencent.mm.media.widget.camerarecordview.a locala = this.voV;
    if (locala != null)
    {
      locala.stopPreview();
      AppMethodBeat.o(199742);
      return;
    }
    AppMethodBeat.o(199742);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(199739);
    super.onPause();
    ad.i("Finder.FinderRecordPluginLayout", "onPause");
    Object localObject = this.voV;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).stopPreview();
    }
    localObject = this.tKW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    }
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Kp(15);
    AppMethodBeat.o(199739);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199738);
    super.onResume();
    csj();
    Object localObject = this.tKW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
    }
    localObject = this.voV;
    if (localObject != null)
    {
      this.LbR.ot(((com.tencent.mm.media.widget.camerarecordview.a)localObject).gAD);
      com.tencent.mm.media.widget.camerarecordview.a.a((com.tencent.mm.media.widget.camerarecordview.a)localObject, false, (d.g.a.b)FinderRecordPluginLayout.b.Lcd, 3);
      AppMethodBeat.o(199738);
      return;
    }
    AppMethodBeat.o(199738);
  }
  
  public final void release()
  {
    AppMethodBeat.i(199740);
    super.release();
    ad.i("Finder.FinderRecordPluginLayout", "release");
    Object localObject = this.voV;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).release();
    }
    localObject = this.tKW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    }
    localObject = this.tKW;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
    }
    this.tKW = null;
    localObject = this.vcC;
    if (localObject != null)
    {
      if (!((RecordConfigProvider)localObject).vhR) {
        h.Iye.aR((Runnable)new FinderRecordPluginLayout.c(this));
      }
      AppMethodBeat.o(199740);
      return;
    }
    AppMethodBeat.o(199740);
  }
  
  public final void wy(int paramInt)
  {
    AppMethodBeat.i(199741);
    if (paramInt < 0)
    {
      AppMethodBeat.o(199741);
      return;
    }
    float f;
    if ((paramInt == 90) || (paramInt == 270)) {
      if (paramInt == 270) {
        f = 90.0F;
      }
    }
    for (;;)
    {
      this.voQ.cb(f);
      AppMethodBeat.o(199741);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout
 * JD-Core Version:    0.7.0.1
 */