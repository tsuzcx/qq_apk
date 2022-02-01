package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.r;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invertMatrix", "Landroid/graphics/Matrix;", "getPlayerView", "Landroid/view/View;", "getScale", "", "values", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "startRemux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderVideoEditPluginLayout
  extends EditorVideoPluginLayoutNew
{
  private Matrix xpW;
  
  public FinderVideoEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165510);
    AppMethodBeat.o(165510);
  }
  
  private static float m(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(165507);
    p.k(paramArrayOfFloat, "values");
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(165507);
    return f1;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject1 = null;
    AppMethodBeat.i(165506);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    paramRecordConfigProvider = paramRecordConfigProvider.mab;
    Object localObject2;
    float f1;
    float f2;
    if (paramRecordConfigProvider != null)
    {
      parama = getPreviewPlugin().Fdy;
      if (parama != null)
      {
        parama = parama.getParent();
        if (parama == null) {}
      }
      for (parama = parama.getParent(); parama == null; parama = null)
      {
        parama = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(165506);
        throw parama;
      }
      parama = (RelativeLayout)parama;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = new WxCropOperationLayout((Context)localObject2);
      ((WxCropOperationLayout)localObject2).getVisibilityRect().set((Rect)paramRecordConfigProvider.getParcelable("cropRect"));
      parama.addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
      ((WxCropOperationLayout)localObject2).setStyle(WxCropOperationLayout.j.HWy);
      ((WxCropOperationLayout)localObject2).bringToFront();
      localObject2 = paramRecordConfigProvider.getFloatArray("matrix");
      paramRecordConfigProvider = paramRecordConfigProvider.getFloatArray("offset");
      parama = paramRecordConfigProvider;
      if (paramRecordConfigProvider == null) {
        parama = new float[2];
      }
      p.j(parama, "getFloatArray(\"offset\") ?: FloatArray(2)");
      f1 = parama[0];
      f2 = parama[1];
      if (localObject2 != null)
      {
        paramRecordConfigProvider = new Matrix();
        paramRecordConfigProvider.setValues((float[])localObject2);
        parama = getPreviewPlugin().Fdy;
        if (parama != null) {
          parama.setScaleX(m((float[])localObject2));
        }
        parama = getPreviewPlugin().Fdy;
        if (parama != null) {
          parama.setScaleY(m((float[])localObject2));
        }
        parama = getPreviewPlugin().Fdy;
        if (parama != null) {
          parama.setTranslationX(f1);
        }
        parama = getPreviewPlugin().Fdy;
        if (parama != null) {
          parama.setTranslationY(f2);
        }
        localObject2 = new StringBuilder("translationX=");
        parama = getPreviewPlugin().Fdy;
        if (parama == null) {
          break label486;
        }
        parama = Float.valueOf(parama.getTranslationX());
        localObject2 = ((StringBuilder)localObject2).append(parama).append(" translationY=");
        parama = getPreviewPlugin().Fdy;
        if (parama == null) {
          break label491;
        }
      }
    }
    label486:
    label491:
    for (parama = Float.valueOf(parama.getTranslationY());; parama = null)
    {
      localObject2 = ((StringBuilder)localObject2).append(parama).append(' ').append("scaleX=");
      VideoPlayerTextureView localVideoPlayerTextureView = getPreviewPlugin().Fdy;
      parama = localObject1;
      if (localVideoPlayerTextureView != null) {
        parama = Float.valueOf(localVideoPlayerTextureView.getScaleX());
      }
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", parama + " offsetX=" + f1 + " offsetY=" + f2 + " matrix=" + paramRecordConfigProvider);
      this.xpW = new Matrix();
      paramRecordConfigProvider.invert(this.xpW);
      getCropVideoPlugin().HPo = true;
      AppMethodBeat.o(165506);
      return;
      parama = null;
      break;
    }
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(165509);
    p.k(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.HSe) {
        Log.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(165509);
      return;
    }
    paramc = getBgPlugin().fwV();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().HNb) {
      i = 1;
    }
    paramBundle = CaptureDataManager.HKJ;
    p.j(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bhr == 2)
    {
      paramBundle = CaptureDataManager.HKJ;
      p.j(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().fwQ());
      paramc = new g(getAddMusicPlugin().AQb.getMuteOrigin(), getAddMusicPlugin().AQf, getItemContainerPlugin().d(this.xpW), getItemContainerPlugin().getEditorDataList(), getItemContainerPlugin().fwI(), getPreviewPlugin().fod, getPreviewPlugin().endTime, new ArrayList(), paramc, getItemContainerPlugin().fwI());
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().fwM()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().fwN()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      if (getAddMusicPlugin().AQf != null) {
        break label504;
      }
      i = 0;
      label341:
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      if (!getAddMusicPlugin().AQb.getMuteOrigin()) {
        break label509;
      }
      i = 0;
      label370:
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.acr(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.fxq().vA(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramc = getConfigProvider();
      if (paramc == null) {
        break label514;
      }
    }
    label514:
    for (i = paramc.scene;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.acs(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.fwy();
      if (paramc == null) {
        break label519;
      }
      paramc.fwu();
      AppMethodBeat.o(165509);
      return;
      if (getMoreMenuPlugin().bhr != 3) {
        break;
      }
      paramBundle = CaptureDataManager.HKJ;
      p.j(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().fwQ());
      break;
      label504:
      i = 1;
      break label341;
      label509:
      i = 1;
      break label370;
    }
    label519:
    AppMethodBeat.o(165509);
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(165508);
    Object localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setBackgroundColor(-16777216);
    a locala = new a(this, getContext());
    setPreviewPlugin(new com.tencent.mm.plugin.recordvideo.plugin.t((VideoPlayerTextureView)locala, (d)this, (TextView)findViewById(b.e.video_debug_info)));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ((FrameLayout)localObject).addView((View)locala, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = (View)localObject;
    AppMethodBeat.o(165508);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout$getPlayerView$playerView$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "setVideoCenter", "", "plugin-finder_release"})
  public static final class a
    extends EditorVideoPlayView
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final void cEw() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */