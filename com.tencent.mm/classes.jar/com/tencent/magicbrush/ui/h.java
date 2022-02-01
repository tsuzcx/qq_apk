package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/MBTextureView;", "Landroid/view/TextureView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "canCaptureFromjava", "", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "setSurfaceListener", "l", "switchToRecordableMode", "foceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class h
  extends TextureView
  implements TextureView.SurfaceTextureListener, MagicBrushView.b
{
  private final View cAa;
  private final MagicBrushView.h cAb;
  private MagicBrushView.c cAc;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140235);
    this.cAa = ((View)this);
    super.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    this.cAb = MagicBrushView.h.cAq;
    AppMethodBeat.o(140235);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(215129);
    p.h(paramb, "callback");
    p.h(paramMBRuntime, "runtime");
    paramb.invoke(Boolean.TRUE);
    AppMethodBeat.o(215129);
  }
  
  public Object getSurface()
  {
    AppMethodBeat.i(182581);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(182581);
    return localObject;
  }
  
  public View getThisView()
  {
    return this.cAa;
  }
  
  public MagicBrushView.h getViewType()
  {
    return this.cAb;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140230);
    p.h(paramSurfaceTexture, "surface");
    p.h(paramSurfaceTexture, "surface");
    MagicBrushView.c localc = this.cAc;
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
    p.h(paramSurfaceTexture, "surface");
    MagicBrushView.c localc = this.cAc;
    if (localc != null) {
      localc.b(paramSurfaceTexture, false);
    }
    AppMethodBeat.o(140232);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140231);
    p.h(paramSurfaceTexture, "surface");
    MagicBrushView.c localc = this.cAc;
    if (localc != null)
    {
      localc.a(paramSurfaceTexture, paramInt1, paramInt2);
      AppMethodBeat.o(140231);
      return;
    }
    AppMethodBeat.o(140231);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(140233);
    p.h(paramSurfaceTexture, "surface");
    AppMethodBeat.o(140233);
  }
  
  public void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cAc = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.h
 * JD-Core Version:    0.7.0.1
 */