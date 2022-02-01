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
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invertMatrix", "Landroid/graphics/Matrix;", "getPlayerView", "Landroid/view/View;", "getScale", "", "values", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "startRemux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderVideoEditPluginLayout
  extends EditorVideoPluginLayoutNew
{
  private Matrix tHm;
  
  public FinderVideoEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165510);
    AppMethodBeat.o(165510);
  }
  
  private static float l(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(165507);
    p.h(paramArrayOfFloat, "values");
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
    AppMethodBeat.i(165506);
    p.h(parama, "navigator");
    p.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    parama = paramRecordConfigProvider.jkf;
    if (parama != null)
    {
      paramRecordConfigProvider = getPreviewPlugin().zyd.getParent();
      p.g(paramRecordConfigProvider, "previewPlugin.videoPlayView.parent");
      paramRecordConfigProvider = paramRecordConfigProvider.getParent();
      if (paramRecordConfigProvider == null)
      {
        parama = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(165506);
        throw parama;
      }
      paramRecordConfigProvider = (RelativeLayout)paramRecordConfigProvider;
      Object localObject = getContext();
      p.g(localObject, "context");
      localObject = new WxCropOperationLayout((Context)localObject);
      ((WxCropOperationLayout)localObject).getVisibilityRect().set((Rect)parama.getParcelable("cropRect"));
      paramRecordConfigProvider.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      ((WxCropOperationLayout)localObject).setStyle(WxCropOperationLayout.j.BZJ);
      ((WxCropOperationLayout)localObject).bringToFront();
      localObject = parama.getFloatArray("matrix");
      paramRecordConfigProvider = parama.getFloatArray("offset");
      parama = paramRecordConfigProvider;
      if (paramRecordConfigProvider == null) {
        parama = new float[2];
      }
      p.g(parama, "getFloatArray(\"offset\") ?: FloatArray(2)");
      float f1 = parama[0];
      float f2 = parama[1];
      if (localObject != null)
      {
        parama = new Matrix();
        parama.setValues((float[])localObject);
        getPreviewPlugin().zyd.setScaleX(l((float[])localObject));
        getPreviewPlugin().zyd.setScaleY(l((float[])localObject));
        getPreviewPlugin().zyd.setTranslationX(f1);
        getPreviewPlugin().zyd.setTranslationY(f2);
        Log.i("MicroMsg.EditorVideoPluginLayoutNew", "translationX=" + getPreviewPlugin().zyd.getTranslationX() + " translationY=" + getPreviewPlugin().zyd.getTranslationY() + ' ' + "scaleX=" + getPreviewPlugin().zyd.getScaleX() + " offsetX=" + f1 + " offsetY=" + f2 + " matrix=" + parama);
        this.tHm = new Matrix();
        parama.invert(this.tHm);
      }
    }
    getCropVideoPlugin().BSz = true;
    AppMethodBeat.o(165506);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(165509);
    p.h(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.BVq) {
        Log.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(165509);
      return;
    }
    paramc = getBgPlugin().eKD();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().BQn) {
      i = 1;
    }
    paramBundle = CaptureDataManager.BOb;
    p.g(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bxP == 2)
    {
      paramBundle = CaptureDataManager.BOb;
      p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().eKy());
      paramc = new f(getAddMusicPlugin().wgL.getMuteOrigin(), getAddMusicPlugin().wgG, getItemContainerPlugin().d(this.tHm), getItemContainerPlugin().getEditorDataList(), getItemContainerPlugin().eKr(), getPreviewPlugin().dvv, getPreviewPlugin().iqg, new ArrayList(), paramc, getItemContainerPlugin().eKr());
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKu()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKv()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      if (getAddMusicPlugin().wgG != null) {
        break label504;
      }
      i = 0;
      label341:
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      if (!getAddMusicPlugin().wgL.getMuteOrigin()) {
        break label509;
      }
      i = 0;
      label370:
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.VI(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKX().ry(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramc = getConfigProvider();
      if (paramc == null) {
        break label514;
      }
    }
    label514:
    for (i = paramc.scene;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.VJ(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.eKi();
      if (paramc == null) {
        break label519;
      }
      paramc.eKe();
      AppMethodBeat.o(165509);
      return;
      if (getMoreMenuPlugin().bxP != 3) {
        break;
      }
      paramBundle = CaptureDataManager.BOb;
      p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().eKy());
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
    setPreviewPlugin(new s((VideoPlayerTextureView)locala, (d)this, (TextView)findViewById(2131309744)));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ((FrameLayout)localObject).addView((View)locala, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = (View)localObject;
    AppMethodBeat.o(165508);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout$getPlayerView$playerView$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "setVideoCenter", "", "plugin-finder_release"})
  public static final class a
    extends EditorVideoPlayView
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final void crn() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */