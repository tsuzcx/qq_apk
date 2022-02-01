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
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/MBSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "notifySurfaceDestroy", "", "holder", "Landroid/view/SurfaceHolder;", "syncDestroy", "", "setSurfaceListener", "l", "surfaceChanged", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class g
  extends SurfaceView
  implements SurfaceHolder.Callback, MagicBrushView.b
{
  private final View cON;
  private final MagicBrushView.h cOO;
  private MagicBrushView.c cOP;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140229);
    this.cON = ((View)this);
    this.cOO = MagicBrushView.h.cPc;
    getHolder().addCallback((SurfaceHolder.Callback)this);
    AppMethodBeat.o(140229);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(206873);
    p.h(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.cOP;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        p.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.a(paramSurfaceHolder, paramBoolean);
        AppMethodBeat.o(206873);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          p.hyc();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(206873);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(206872);
    p.h(paramb, "callback");
    p.h(paramMBRuntime, "runtime");
    paramb.invoke(Boolean.TRUE);
    AppMethodBeat.o(206872);
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
    return this.cON;
  }
  
  public MagicBrushView.h getViewType()
  {
    return this.cOO;
  }
  
  public void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cOP = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140227);
    p.h(paramSurfaceHolder, "holder");
    MagicBrushView.c localc = this.cOP;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        p.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.c(paramSurfaceHolder, paramInt2, paramInt3);
        AppMethodBeat.o(140227);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          p.hyc();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(140227);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(140226);
    p.h(paramSurfaceHolder, "holder");
    Rect localRect = paramSurfaceHolder.getSurfaceFrame();
    MagicBrushView.c localc = this.cOP;
    if (localc != null)
    {
      if (getSurfaceTexture() == null) {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
      }
      for (;;)
      {
        p.g(paramSurfaceHolder, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
        localc.a(paramSurfaceHolder, localRect.width(), localRect.height(), false);
        AppMethodBeat.o(140226);
        return;
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        paramSurfaceHolder = localSurfaceTexture;
        if (localSurfaceTexture == null)
        {
          p.hyc();
          paramSurfaceHolder = localSurfaceTexture;
        }
      }
    }
    AppMethodBeat.o(140226);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(140228);
    p.h(paramSurfaceHolder, "holder");
    a(paramSurfaceHolder, false);
    AppMethodBeat.o(140228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ui.g
 * JD-Core Version:    0.7.0.1
 */