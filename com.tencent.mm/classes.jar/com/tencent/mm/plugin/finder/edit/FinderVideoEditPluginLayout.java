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
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
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
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invertMatrix", "Landroid/graphics/Matrix;", "getPlayerView", "Landroid/view/View;", "getScale", "", "values", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "startRemux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderVideoEditPluginLayout
  extends EditorVideoPluginLayoutNew
{
  private Matrix rcD;
  
  public FinderVideoEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165510);
    AppMethodBeat.o(165510);
  }
  
  private static float n(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(165507);
    k.h(paramArrayOfFloat, "values");
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
    k.h(parama, "navigator");
    k.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    parama = paramRecordConfigProvider.hSN;
    if (parama != null)
    {
      paramRecordConfigProvider = getPreviewPlugin().uOi.getParent();
      k.g(paramRecordConfigProvider, "previewPlugin.videoPlayView.parent");
      paramRecordConfigProvider = paramRecordConfigProvider.getParent();
      if (paramRecordConfigProvider == null)
      {
        parama = new v("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(165506);
        throw parama;
      }
      paramRecordConfigProvider = (RelativeLayout)paramRecordConfigProvider;
      Object localObject = getContext();
      k.g(localObject, "context");
      localObject = new WxCropOperationLayout((Context)localObject);
      ((WxCropOperationLayout)localObject).getVisibilityRect().set((Rect)parama.getParcelable("cropRect"));
      paramRecordConfigProvider.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      ((WxCropOperationLayout)localObject).setStyle(WxCropOperationLayout.j.wzI);
      ((WxCropOperationLayout)localObject).bringToFront();
      localObject = parama.getFloatArray("matrix");
      paramRecordConfigProvider = parama.getFloatArray("offset");
      parama = paramRecordConfigProvider;
      if (paramRecordConfigProvider == null) {
        parama = new float[2];
      }
      float f1 = parama[0];
      float f2 = parama[1];
      if (localObject != null)
      {
        parama = new Matrix();
        parama.setValues((float[])localObject);
        getPreviewPlugin().uOi.setScaleX(n((float[])localObject));
        getPreviewPlugin().uOi.setScaleY(n((float[])localObject));
        getPreviewPlugin().uOi.setTranslationX(f1);
        getPreviewPlugin().uOi.setTranslationY(f2);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditorVideoPluginLayoutNew", "translationX=" + getPreviewPlugin().uOi.getTranslationX() + " translationY=" + getPreviewPlugin().uOi.getTranslationY() + ' ' + "scaleX=" + getPreviewPlugin().uOi.getScaleX() + " offsetX=" + f1 + " offsetY=" + f2 + " matrix=" + parama);
        this.rcD = new Matrix();
        parama.invert(this.rcD);
      }
    }
    getCropVideoPlugin().wuB = true;
    AppMethodBeat.o(165506);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(165509);
    k.h(paramc, "status");
    switch (a.cfA[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.wwI) {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(165509);
      return;
    }
    paramc = getBgPlugin().dwb();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    if (getMoreMenuPlugin().wsv) {}
    for (int i = 1;; i = 0)
    {
      paramBundle = CaptureDataManager.wqi;
      k.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bns == 2)
      {
        paramBundle = CaptureDataManager.wqi;
        k.g(paramBundle, "CaptureDataManager.INSTANCE");
        paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().dvU());
        paramc = new f(getAddMusicPlugin().wvm.getMuteOrigin(), getAddMusicPlugin().wpt, getItemContainerPlugin().d(this.rcD), getItemContainerPlugin().dvN(), getItemContainerPlugin().dvO(), getPreviewPlugin().cSh, getPreviewPlugin().hbI, new ArrayList(), paramc);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dvQ()));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dvR()));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        if (getAddMusicPlugin().wpt != null) {
          break label502;
        }
        i = 0;
        label336:
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        if (!getAddMusicPlugin().wvm.getMuteOrigin()) {
          break label507;
        }
      }
      label502:
      label507:
      for (i = 0;; i = 1)
      {
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.Mo(13);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.dwr().iz(System.currentTimeMillis());
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        com.tencent.mm.plugin.recordvideo.d.c.Mp(i);
        paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.wrN;
        paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.dvH();
        if (paramc == null) {
          break label512;
        }
        paramc.dvE();
        AppMethodBeat.o(165509);
        return;
        if (getMoreMenuPlugin().bns != 3) {
          break;
        }
        paramBundle = CaptureDataManager.wqi;
        k.g(paramBundle, "CaptureDataManager.INSTANCE");
        paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().dvU());
        break;
        i = 1;
        break label336;
      }
      label512:
      AppMethodBeat.o(165509);
      return;
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(165508);
    Object localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setBackgroundColor(-16777216);
    a locala = new a(this, getContext());
    setPreviewPlugin(new s((VideoPlayerTextureView)locala, (d)this, (TextView)findViewById(2131306323)));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ((FrameLayout)localObject).addView((View)locala, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = (View)localObject;
    AppMethodBeat.o(165508);
    return localObject;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout$getPlayerView$playerView$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "setVideoCenter", "", "plugin-finder_release"})
  public static final class a
    extends EditorVideoPlayView
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final void bNN() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */