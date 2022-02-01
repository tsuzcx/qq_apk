package com.tencent.mm.media.widget.camerarecordview.c;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.b;
import com.tencent.mm.media.widget.camerarecordview.c;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hwR;
  public Context context;
  b hrW;
  private int hwP;
  public b hwQ;
  
  static
  {
    AppMethodBeat.i(94289);
    hwR = new a.a((byte)0);
    AppMethodBeat.o(94289);
  }
  
  public a(Context paramContext, final com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94288);
    this.context = paramContext;
    this.hwQ = new b(this, parama, this.context);
    AppMethodBeat.o(94288);
  }
  
  private final boolean axU()
  {
    return this.context != null;
  }
  
  public final void a(boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(94287);
    ae.i("MicroMsg.PreviewOrientationFit", "enable :" + paramBoolean + " ,cameraConfig " + paramb);
    if (!axU())
    {
      AppMethodBeat.o(94287);
      return;
    }
    if (paramBoolean)
    {
      this.hrW = paramb;
      paramb = this.context;
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(94287);
        throw paramb;
      }
      ((Activity)paramb).setRequestedOrientation(7);
      this.hwQ.enable();
      AppMethodBeat.o(94287);
      return;
    }
    paramb = this.context;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(94287);
      throw paramb;
    }
    ((Activity)paramb).setRequestedOrientation(1);
    this.hwQ.disable();
    this.hwP = 0;
    AppMethodBeat.o(94287);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"})
  public static final class b
    extends OrientationEventListener
  {
    b(com.tencent.mm.media.widget.camerarecordview.d.a parama, Context paramContext, int paramInt)
    {
      super(3);
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      AppMethodBeat.i(94286);
      if (!a.a(this.hwS))
      {
        AppMethodBeat.o(94286);
        return;
      }
      Object localObject = this.hwS.context;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(94286);
        throw ((Throwable)localObject);
      }
      localObject = ((Activity)localObject).getWindowManager();
      p.g(localObject, "(context as Activity).windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "(context as Activity).windowManager.defaultDisplay");
      paramInt = ((Display)localObject).getRotation();
      if (paramInt == a.b(this.hwS))
      {
        AppMethodBeat.o(94286);
        return;
      }
      ae.i("MicroMsg.PreviewOrientationFit", "last rotation :" + a.b(this.hwS) + " ,current rotation:" + paramInt);
      a.a(this.hwS, paramInt);
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      while (paramInt == 0)
      {
        localObject = this.hwS.hrW;
        if (localObject != null)
        {
          b.nV(270);
          parama.getCameraPreviewView().a((b)localObject);
          localObject = c.hws;
          localObject = c.getRenderer();
          if (localObject != null)
          {
            ((com.tencent.mm.media.j.a)localObject).ng(b.aws());
            AppMethodBeat.o(94286);
            return;
            paramInt = 0;
            continue;
            paramInt = 90;
            continue;
            paramInt = 180;
            continue;
            paramInt = 270;
          }
          else
          {
            AppMethodBeat.o(94286);
          }
        }
        else
        {
          AppMethodBeat.o(94286);
          return;
        }
      }
      if (paramInt == 180)
      {
        localObject = this.hwS.hrW;
        if (localObject != null)
        {
          b.nV(90);
          parama.getCameraPreviewView().a((b)localObject);
          localObject = c.hws;
          localObject = c.getRenderer();
          if (localObject != null)
          {
            ((com.tencent.mm.media.j.a)localObject).ng(b.aws());
            AppMethodBeat.o(94286);
            return;
          }
          AppMethodBeat.o(94286);
          return;
        }
      }
      AppMethodBeat.o(94286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c.a
 * JD-Core Version:    0.7.0.1
 */