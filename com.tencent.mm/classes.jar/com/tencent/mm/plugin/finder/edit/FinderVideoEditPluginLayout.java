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
import com.tencent.mm.g.b.a.fp;
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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invertMatrix", "Landroid/graphics/Matrix;", "getPlayerView", "Landroid/view/View;", "getScale", "", "values", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "startRemux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderVideoEditPluginLayout
  extends EditorVideoPluginLayoutNew
{
  private Matrix rPV;
  
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
    parama = paramRecordConfigProvider.ime;
    if (parama != null)
    {
      paramRecordConfigProvider = getPreviewPlugin().vRr.getParent();
      p.g(paramRecordConfigProvider, "previewPlugin.videoPlayView.parent");
      paramRecordConfigProvider = paramRecordConfigProvider.getParent();
      if (paramRecordConfigProvider == null)
      {
        parama = new v("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(165506);
        throw parama;
      }
      paramRecordConfigProvider = (RelativeLayout)paramRecordConfigProvider;
      Object localObject = getContext();
      p.g(localObject, "context");
      localObject = new WxCropOperationLayout((Context)localObject);
      ((WxCropOperationLayout)localObject).getVisibilityRect().set((Rect)parama.getParcelable("cropRect"));
      paramRecordConfigProvider.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      ((WxCropOperationLayout)localObject).setStyle(WxCropOperationLayout.j.xIW);
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
        getPreviewPlugin().vRr.setScaleX(l((float[])localObject));
        getPreviewPlugin().vRr.setScaleY(l((float[])localObject));
        getPreviewPlugin().vRr.setTranslationX(f1);
        getPreviewPlugin().vRr.setTranslationY(f2);
        ad.i("MicroMsg.EditorVideoPluginLayoutNew", "translationX=" + getPreviewPlugin().vRr.getTranslationX() + " translationY=" + getPreviewPlugin().vRr.getTranslationY() + ' ' + "scaleX=" + getPreviewPlugin().vRr.getScaleX() + " offsetX=" + f1 + " offsetY=" + f2 + " matrix=" + parama);
        this.rPV = new Matrix();
        parama.invert(this.rPV);
      }
    }
    getCropVideoPlugin().xCx = true;
    AppMethodBeat.o(165506);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(165509);
    p.h(paramc, "status");
    switch (a.cpQ[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.xER) {
        ad.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(165509);
      return;
    }
    paramc = getBgPlugin().dGy();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().xAo) {
      i = 1;
    }
    paramBundle = CaptureDataManager.xxY;
    p.g(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bxN == 2)
    {
      paramBundle = CaptureDataManager.xxY;
      p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().dGs());
      paramc = new f(getAddMusicPlugin().xDi.getMuteOrigin(), getAddMusicPlugin().xxj, getItemContainerPlugin().d(this.rPV), getItemContainerPlugin().getEditorDataList(), getItemContainerPlugin().dGl(), getPreviewPlugin().ddx, getPreviewPlugin().htQ, new ArrayList(), paramc, getItemContainerPlugin().dGl());
      ad.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dGo()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dGp()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      if (getAddMusicPlugin().xxj != null) {
        break label504;
      }
      i = 0;
      label341:
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      if (!getAddMusicPlugin().xDi.getMuteOrigin()) {
        break label509;
      }
      i = 0;
      label370:
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.NN(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.dGL().kl(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramc = getConfigProvider();
      if (paramc == null) {
        break label514;
      }
    }
    label514:
    for (i = paramc.scene;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.NO(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.dGf();
      if (paramc == null) {
        break label519;
      }
      paramc.dGb();
      AppMethodBeat.o(165509);
      return;
      if (getMoreMenuPlugin().bxN != 3) {
        break;
      }
      paramBundle = CaptureDataManager.xxY;
      p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().dGs());
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
    setPreviewPlugin(new s((VideoPlayerTextureView)locala, (d)this, (TextView)findViewById(2131306323)));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    ((FrameLayout)localObject).addView((View)locala, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = (View)localObject;
    AppMethodBeat.o(165508);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout$getPlayerView$playerView$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "setVideoCenter", "", "plugin-finder_release"})
  public static final class a
    extends EditorVideoPlayView
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final void bSn() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */