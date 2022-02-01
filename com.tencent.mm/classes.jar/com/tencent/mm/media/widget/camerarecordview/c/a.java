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
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a iqt;
  public Context context;
  b hAu;
  private int iqr;
  public b iqs;
  
  static
  {
    AppMethodBeat.i(94289);
    iqt = new a.a((byte)0);
    AppMethodBeat.o(94289);
  }
  
  public a(Context paramContext, final com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94288);
    this.context = paramContext;
    this.iqs = new b(this, parama, this.context);
    AppMethodBeat.o(94288);
  }
  
  private final boolean aQs()
  {
    return this.context != null;
  }
  
  public final void a(boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(94287);
    Log.i("MicroMsg.PreviewOrientationFit", "enable :" + paramBoolean + " ,cameraConfig " + paramb);
    if (!aQs())
    {
      AppMethodBeat.o(94287);
      return;
    }
    if (paramBoolean)
    {
      this.hAu = paramb;
      paramb = this.context;
      if (paramb == null)
      {
        paramb = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(94287);
        throw paramb;
      }
      ((Activity)paramb).setRequestedOrientation(7);
      this.iqs.enable();
      AppMethodBeat.o(94287);
      return;
    }
    paramb = this.context;
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(94287);
      throw paramb;
    }
    ((Activity)paramb).setRequestedOrientation(1);
    this.iqs.disable();
    this.iqr = 0;
    AppMethodBeat.o(94287);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"})
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
      if (!a.a(this.iqu))
      {
        AppMethodBeat.o(94286);
        return;
      }
      Object localObject = this.iqu.context;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(94286);
        throw ((Throwable)localObject);
      }
      localObject = ((Activity)localObject).getWindowManager();
      p.g(localObject, "(context as Activity).windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "(context as Activity).windowManager.defaultDisplay");
      paramInt = ((Display)localObject).getRotation();
      if (paramInt == a.b(this.iqu))
      {
        AppMethodBeat.o(94286);
        return;
      }
      Log.i("MicroMsg.PreviewOrientationFit", "last rotation :" + a.b(this.iqu) + " ,current rotation:" + paramInt);
      a.a(this.iqu, paramInt);
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      while (paramInt == 0)
      {
        localObject = this.iqu.hAu;
        if (localObject != null)
        {
          b.rt(270);
          parama.getCameraPreviewView().a((b)localObject);
          localObject = c.ipU;
          localObject = c.getRenderer();
          if (localObject != null)
          {
            ((com.tencent.mm.media.j.a)localObject).qx(b.aPk());
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
        localObject = this.iqu.hAu;
        if (localObject != null)
        {
          b.rt(90);
          parama.getCameraPreviewView().a((b)localObject);
          localObject = c.ipU;
          localObject = c.getRenderer();
          if (localObject != null)
          {
            ((com.tencent.mm.media.j.a)localObject).qx(b.aPk());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c.a
 * JD-Core Version:    0.7.0.1
 */