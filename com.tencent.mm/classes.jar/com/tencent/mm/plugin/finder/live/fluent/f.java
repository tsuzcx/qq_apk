package com.tencent.mm.plugin.finder.live.fluent;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveParams;", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "fluentScene", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "isFloatWindowEnter", "", "feedId", "", "parentView", "Landroid/view/View;", "isFloatWindow", "liveView", "Landroid/view/TextureView;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "livePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "videoWidth", "", "videoHeight", "videoRatioWH", "", "maskViewResolution", "", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;ZJLandroid/view/View;ZLandroid/view/TextureView;Landroid/graphics/SurfaceTexture;Lcom/tencent/mm/live/core/core/player/ILivePlayer;IIF[I)V", "()Z", "setFloatWindow", "(Z)V", "setFloatWindowEnter", "getLiveView", "()Landroid/view/TextureView;", "getMaskViewResolution", "()[I", "renderView", "getRenderView", "()Landroid/view/View;", "setRenderView", "(Landroid/view/View;)V", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends h
{
  public boolean CCq;
  public boolean CCr;
  public final TextureView CCs;
  private final int[] CCt;
  public View mUN;
  public SurfaceTexture surfaceTexture;
  
  public f(h.a parama, boolean paramBoolean, long paramLong, View paramView, TextureView paramTextureView, b paramb, int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt)
  {
    super(parama, paramLong, paramView, paramInt1, paramInt2, paramFloat, paramb);
    AppMethodBeat.i(352078);
    this.CCq = paramBoolean;
    this.CCr = false;
    this.CCs = paramTextureView;
    this.surfaceTexture = null;
    this.CCt = paramArrayOfInt;
    AppMethodBeat.o(352078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.f
 * JD-Core Version:    0.7.0.1
 */