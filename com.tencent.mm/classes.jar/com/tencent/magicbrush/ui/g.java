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

@l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/ui/MBSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "notifySurfaceDestroy", "", "holder", "Landroid/view/SurfaceHolder;", "syncDestroy", "", "setSurfaceListener", "l", "surfaceChanged", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class g
  extends SurfaceView
  implements SurfaceHolder.Callback, MagicBrushView.b
{
  private final View cpj;
  private final MagicBrushView.h cpk;
  private MagicBrushView.c cpl;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140229);
    this.cpj = ((View)this);
    this.cpk = MagicBrushView.h.cpy;
    getHolder().addCallback((SurfaceHolder.Callback)this);
    AppMethodBeat.o(140229);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(190938);
    k.h(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.cpl;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        k.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.b(paramSurfaceHolder, paramBoolean);
        AppMethodBeat.o(190938);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          k.fOy();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(190938);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(190937);
    k.h(paramb, "callback");
    k.h(paramMBRuntime, "runtime");
    paramb.ay(Boolean.TRUE);
    AppMethodBeat.o(190937);
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
    return this.cpj;
  }
  
  public MagicBrushView.h getViewType()
  {
    return this.cpk;
  }
  
  public void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cpl = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140227);
    k.h(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.cpl;
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
          k.fOy();
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
    MagicBrushView.c localc = this.cpl;
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
          k.fOy();
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
    a(paramSurfaceHolder, false);
    AppMethodBeat.o(140228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ui.g
 * JD-Core Version:    0.7.0.1
 */