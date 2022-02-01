package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/ui/MBTextureView;", "Landroid/view/TextureView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "canCaptureFromjava", "", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "setSurfaceListener", "l", "switchRenderMode", "foceRecreate", "renderModeFlag", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class h
  extends TextureView
  implements TextureView.SurfaceTextureListener, MagicBrushView.b
{
  private final View cPC;
  private final MagicBrushView.h cPD;
  private MagicBrushView.c cPE;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140235);
    this.cPC = ((View)this);
    super.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    this.cPD = MagicBrushView.h.cPU;
    AppMethodBeat.o(140235);
  }
  
  public final void a(boolean paramBoolean, int paramInt, b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(205205);
    p.k(paramb, "callback");
    p.k(paramMBRuntime, "runtime");
    paramb.invoke(Boolean.TRUE);
    AppMethodBeat.o(205205);
  }
  
  public Object getSurface()
  {
    AppMethodBeat.i(182581);
    Object localObject = MagicBrushView.b.b.a(this);
    AppMethodBeat.o(182581);
    return localObject;
  }
  
  public View getThisView()
  {
    return this.cPC;
  }
  
  public MagicBrushView.h getViewType()
  {
    return this.cPD;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140230);
    p.k(paramSurfaceTexture, "surface");
    p.k(paramSurfaceTexture, "surface");
    MagicBrushView.c localc = this.cPE;
    if (localc != null)
    {
      localc.a(paramSurfaceTexture, paramInt1, paramInt2, true);
      AppMethodBeat.o(140230);
      return;
    }
    AppMethodBeat.o(140230);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(140232);
    p.k(paramSurfaceTexture, "surface");
    MagicBrushView.c localc = this.cPE;
    if (localc != null) {
      localc.b(paramSurfaceTexture, false);
    }
    AppMethodBeat.o(140232);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140231);
    p.k(paramSurfaceTexture, "surface");
    MagicBrushView.c localc = this.cPE;
    if (localc != null)
    {
      localc.b(paramSurfaceTexture, paramInt1, paramInt2);
      AppMethodBeat.o(140231);
      return;
    }
    AppMethodBeat.o(140231);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(140233);
    p.k(paramSurfaceTexture, "surface");
    AppMethodBeat.o(140233);
  }
  
  public void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cPE = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.ui.h
 * JD-Core Version:    0.7.0.1
 */