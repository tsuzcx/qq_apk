package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MBSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurfaceTexture", "", "notifySurfaceDestroy", "", "holder", "Landroid/view/SurfaceHolder;", "syncDestroy", "", "setSurfaceListener", "l", "surfaceChanged", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "switchRenderMode", "forceRecreate", "renderModeFlag", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public class g
  extends SurfaceView
  implements SurfaceHolder.Callback, MagicBrushView.b
{
  private final View eKH;
  private final MagicBrushView.h eKI;
  private MagicBrushView.c eKJ;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140229);
    this.eKH = ((View)this);
    this.eKI = MagicBrushView.h.eKY;
    getHolder().addCallback((SurfaceHolder.Callback)this);
    AppMethodBeat.o(140229);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(229059);
    s.t(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.eKJ;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        s.r(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.c(paramSurfaceHolder, paramBoolean);
        AppMethodBeat.o(229059);
        return;
        Object localObject = getSurfaceTexture();
        paramSurfaceHolder = localObject;
        if (localObject == null)
        {
          s.klw();
          paramSurfaceHolder = localObject;
        }
      }
    }
    AppMethodBeat.o(229059);
  }
  
  public void a(boolean paramBoolean, int paramInt, b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(229047);
    s.t(paramb, "callback");
    s.t(paramMBRuntime, "runtime");
    paramb.invoke(Boolean.TRUE);
    AppMethodBeat.o(229047);
  }
  
  public Object getSurface()
  {
    AppMethodBeat.i(182579);
    Object localObject = MagicBrushView.b.b.a(this);
    AppMethodBeat.o(182579);
    return localObject;
  }
  
  public Object getSurfaceTexture()
  {
    return null;
  }
  
  public View getThisView()
  {
    return this.eKH;
  }
  
  public MagicBrushView.h getViewType()
  {
    return this.eKI;
  }
  
  public final void onDestroy() {}
  
  public void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.eKJ = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140227);
    s.t(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.eKJ;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        s.r(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.e(paramSurfaceHolder, paramInt2, paramInt3);
        AppMethodBeat.o(140227);
        return;
        Object localObject = getSurfaceTexture();
        paramSurfaceHolder = localObject;
        if (localObject == null)
        {
          s.klw();
          paramSurfaceHolder = localObject;
        }
      }
    }
    AppMethodBeat.o(140227);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(140226);
    s.t(paramSurfaceHolder, "holder");
    Rect localRect = paramSurfaceHolder.getSurfaceFrame();
    MagicBrushView.c localc = this.eKJ;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        s.r(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.a(paramSurfaceHolder, localRect.width(), localRect.height(), false);
        AppMethodBeat.o(140226);
        return;
        Object localObject = getSurfaceTexture();
        paramSurfaceHolder = localObject;
        if (localObject == null)
        {
          s.klw();
          paramSurfaceHolder = localObject;
        }
      }
    }
    AppMethodBeat.o(140226);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(140228);
    s.t(paramSurfaceHolder, "holder");
    a(paramSurfaceHolder, false);
    AppMethodBeat.o(140228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.g
 * JD-Core Version:    0.7.0.1
 */