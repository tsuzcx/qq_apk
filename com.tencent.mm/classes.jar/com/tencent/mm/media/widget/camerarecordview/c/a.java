package com.tencent.mm.media.widget.camerarecordview.c;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nKg;
  public Context context;
  com.tencent.mm.media.widget.a.b mRv;
  private int nKh;
  public b nKi;
  
  static
  {
    AppMethodBeat.i(94289);
    nKg = new a.a((byte)0);
    AppMethodBeat.o(94289);
  }
  
  public a(Context paramContext, final com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94288);
    this.context = paramContext;
    this.nKi = new b(this, parama, this.context);
    AppMethodBeat.o(94288);
  }
  
  private final boolean buj()
  {
    return this.context != null;
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94287);
    Log.i("MicroMsg.PreviewOrientationFit", "enable :" + paramBoolean + " ,cameraConfig " + paramb);
    if (!buj())
    {
      AppMethodBeat.o(94287);
      return;
    }
    if (paramBoolean)
    {
      this.mRv = paramb;
      paramb = this.context;
      if (paramb == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(94287);
        throw paramb;
      }
      ((Activity)paramb).setRequestedOrientation(7);
      this.nKi.enable();
      AppMethodBeat.o(94287);
      return;
    }
    paramb = this.context;
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(94287);
      throw paramb;
    }
    ((Activity)paramb).setRequestedOrientation(1);
    this.nKi.disable();
    this.nKh = 0;
    AppMethodBeat.o(94287);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends OrientationEventListener
  {
    b(a parama, com.tencent.mm.media.widget.camerarecordview.d.a parama1, Context paramContext)
    {
      super(3);
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      AppMethodBeat.i(94286);
      if (!a.a(this.nKj))
      {
        AppMethodBeat.o(94286);
        return;
      }
      Object localObject = this.nKj.context;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(94286);
        throw ((Throwable)localObject);
      }
      paramInt = ((Activity)localObject).getWindowManager().getDefaultDisplay().getRotation();
      if (paramInt == a.b(this.nKj))
      {
        AppMethodBeat.o(94286);
        return;
      }
      Log.i("MicroMsg.PreviewOrientationFit", "last rotation :" + a.b(this.nKj) + " ,current rotation:" + paramInt);
      a.a(this.nKj, paramInt);
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        switch (paramInt)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(94286);
        return;
        paramInt = 0;
        break;
        paramInt = 90;
        break;
        paramInt = 180;
        break;
        paramInt = 270;
        break;
        localObject = this.nKj.mRv;
        if (localObject != null)
        {
          com.tencent.mm.media.widget.camerarecordview.d.a locala = parama;
          com.tencent.mm.media.widget.a.b.ul(270);
          locala.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
          localObject = d.nJI;
          localObject = d.getRenderer();
          if (localObject != null) {
            ((com.tencent.mm.media.j.a)localObject).th(com.tencent.mm.media.widget.a.b.bsL());
          }
          AppMethodBeat.o(94286);
          return;
          localObject = this.nKj.mRv;
          if (localObject != null)
          {
            locala = parama;
            com.tencent.mm.media.widget.a.b.ul(90);
            locala.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
            localObject = d.nJI;
            localObject = d.getRenderer();
            if (localObject != null) {
              ((com.tencent.mm.media.j.a)localObject).th(com.tencent.mm.media.widget.a.b.bsL());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c.a
 * JD-Core Version:    0.7.0.1
 */