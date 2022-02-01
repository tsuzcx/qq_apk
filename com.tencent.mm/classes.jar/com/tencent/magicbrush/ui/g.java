package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/MBSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "setSurfaceListener", "", "l", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "switchToRecordableMode", "recordable", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class g
  extends SurfaceView
  implements SurfaceHolder.Callback, MagicBrushView.b
{
  private final View csc;
  private final MagicBrushView.h csd;
  private MagicBrushView.c cse;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140229);
    this.csc = ((View)this);
    this.csd = MagicBrushView.h.csr;
    getHolder().addCallback((SurfaceHolder.Callback)this);
    AppMethodBeat.o(140229);
  }
  
  public void a(b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(140225);
    k.h(paramb, "callback");
    k.h(paramMBRuntime, "runtime");
    paramb.aA(Boolean.TRUE);
    AppMethodBeat.o(140225);
  }
  
  public Object getSurface()
  {
    AppMethodBeat.i(182579);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(182579);
    return localObject;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return null;
  }
  
  public View getThisView()
  {
    return this.csc;
  }
  
  public MagicBrushView.h getViewType()
  {
    return this.csd;
  }
  
  public void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cse = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140227);
    k.h(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.cse;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        k.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.a(paramSurfaceHolder, paramInt2, paramInt3);
        AppMethodBeat.o(140227);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          k.fvU();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(140227);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(140226);
    k.h(paramSurfaceHolder, "holder");
    Rect localRect = paramSurfaceHolder.getSurfaceFrame();
    MagicBrushView.c localc = this.cse;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        k.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.a(paramSurfaceHolder, localRect.width(), localRect.height(), false);
        AppMethodBeat.o(140226);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          k.fvU();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(140226);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(140228);
    k.h(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.cse;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        k.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.aC(paramSurfaceHolder);
        AppMethodBeat.o(140228);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          k.fvU();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(140228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.g
 * JD-Core Version:    0.7.0.1
 */