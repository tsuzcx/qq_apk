package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.c.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ae;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invertMatrix", "Landroid/graphics/Matrix;", "getPlayerView", "Landroid/view/View;", "getScale", "", "values", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "startRemux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoEditPluginLayout
  extends EditorVideoPluginLayoutNew
{
  private Matrix ANh;
  
  public FinderVideoEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165510);
    AppMethodBeat.o(165510);
  }
  
  private static float u(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(165507);
    kotlin.g.b.s.u(paramArrayOfFloat, "values");
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
    kotlin.g.b.s.u(parama, "navigator");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    paramRecordConfigProvider = paramRecordConfigProvider.oSS;
    Object localObject2;
    float f1;
    float f2;
    if (paramRecordConfigProvider != null)
    {
      parama = getPreviewPlugin().KZh;
      if (parama == null) {
        parama = null;
      }
      while (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(165506);
        throw parama;
        parama = parama.getParent();
        if (parama == null) {
          parama = null;
        } else {
          parama = parama.getParent();
        }
      }
      parama = (RelativeLayout)parama;
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      localObject2 = new WxCropOperationLayout((Context)localObject2);
      RectF localRectF = ((WxCropOperationLayout)localObject2).getVisibilityRect();
      Parcelable localParcelable = paramRecordConfigProvider.getParcelable("cropRect");
      kotlin.g.b.s.checkNotNull(localParcelable);
      localRectF.set((Rect)localParcelable);
      parama.addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
      ((WxCropOperationLayout)localObject2).setStyle(WxCropOperationLayout.j.NTl);
      ((WxCropOperationLayout)localObject2).bringToFront();
      localObject2 = paramRecordConfigProvider.getFloatArray("matrix");
      paramRecordConfigProvider = paramRecordConfigProvider.getFloatArray("offset");
      parama = paramRecordConfigProvider;
      if (paramRecordConfigProvider == null) {
        parama = new float[2];
      }
      f1 = parama[0];
      f2 = parama[1];
      if (localObject2 != null)
      {
        paramRecordConfigProvider = new Matrix();
        paramRecordConfigProvider.setValues((float[])localObject2);
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          parama.setScaleX(u((float[])localObject2));
        }
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          parama.setScaleY(u((float[])localObject2));
        }
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          parama.setTranslationX(f1);
        }
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          parama.setTranslationY(f2);
        }
        localObject2 = new StringBuilder("translationX=");
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          break label470;
        }
        parama = null;
        localObject2 = ((StringBuilder)localObject2).append(parama).append(" translationY=");
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          break label481;
        }
        parama = null;
        label366:
        localObject2 = ((StringBuilder)localObject2).append(parama).append(" scaleX=");
        parama = getPreviewPlugin().KZh;
        if (parama != null) {
          break label492;
        }
      }
    }
    label470:
    label481:
    label492:
    for (parama = localObject1;; parama = Float.valueOf(parama.getScaleX()))
    {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", parama + " offsetX=" + f1 + " offsetY=" + f2 + " matrix=" + paramRecordConfigProvider);
      this.ANh = new Matrix();
      paramRecordConfigProvider.invert(this.ANh);
      getCropVideoPlugin().NLX = true;
      AppMethodBeat.o(165506);
      return;
      parama = Float.valueOf(parama.getTranslationX());
      break;
      parama = Float.valueOf(parama.getTranslationY());
      break label366;
    }
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(165509);
    kotlin.g.b.s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      if (paramc != a.c.NOK) {
        Log.e("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("unknown status ", paramc));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(165509);
      return;
    }
    paramc = getBgPlugin().gID();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().NJY) {
      i = 1;
    }
    CaptureDataManager.NHH.rnY.putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().dbk == 2)
    {
      CaptureDataManager.NHH.rnY.putString("key_group_list", getMoreMenuPlugin().gIy());
      paramc = new g(getAddMusicPlugin().Gso.getMuteOrigin(), getAddMusicPlugin().Gss, getItemContainerPlugin().f(this.ANh), getItemContainerPlugin().getEditorDataList(), getItemContainerPlugin().gIq(), getPreviewPlugin().startTime, getPreviewPlugin().endTime, new ArrayList(), paramc, getItemContainerPlugin().gIq());
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", kotlin.g.b.s.X("edit config: ", paramc));
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIu()));
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().gIv()));
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      if (getAddMusicPlugin().Gss != null) {
        break label467;
      }
      i = 0;
      label317:
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      if (!getAddMusicPlugin().Gso.getMuteOrigin()) {
        break label472;
      }
      i = 0;
      label346:
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.agH(13);
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().jjw = System.currentTimeMillis();
      paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      paramc = getConfigProvider();
      if (paramc != null) {
        break label477;
      }
    }
    label467:
    label472:
    label477:
    for (i = 0;; i = paramc.scene)
    {
      com.tencent.mm.plugin.recordvideo.f.c.agI(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
      if (paramc != null) {
        paramc.gId();
      }
      AppMethodBeat.o(165509);
      return;
      if (getMoreMenuPlugin().dbk != 3) {
        break;
      }
      CaptureDataManager.NHH.rnY.putString("key_black_list", getMoreMenuPlugin().gIy());
      break;
      i = 1;
      break label317;
      i = 1;
      break label346;
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(165508);
    Object localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setBackgroundColor(-16777216);
    b localb = new b(getContext());
    setPreviewPlugin(new u((VideoPlayerTextureView)localb, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, (TextView)findViewById(b.e.video_debug_info)));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ((FrameLayout)localObject).addView((View)localb, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = (View)localObject;
    AppMethodBeat.o(165508);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout$getPlayerView$playerView$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "setVideoCenter", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends EditorVideoPlayView
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final void dYi() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */