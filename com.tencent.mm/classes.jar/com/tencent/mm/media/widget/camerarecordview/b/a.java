package com.tencent.mm.media.widget.camerarecordview.b;

import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a fbu;
  public Context context;
  b eZO;
  private int fbs;
  public a.b fbt;
  
  static
  {
    AppMethodBeat.i(13265);
    fbu = new a.a((byte)0);
    AppMethodBeat.o(13265);
  }
  
  public a(Context paramContext, com.tencent.mm.media.widget.camerarecordview.c.a parama)
  {
    AppMethodBeat.i(13264);
    this.context = paramContext;
    this.fbt = new a.b(this, parama, this.context);
    AppMethodBeat.o(13264);
  }
  
  private final boolean Xj()
  {
    return this.context != null;
  }
  
  public final void a(boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(13263);
    ab.i("MicroMsg.PreviewOrientationFit", "enable :" + paramBoolean + " ,cameraConfig " + paramb);
    if (!Xj())
    {
      AppMethodBeat.o(13263);
      return;
    }
    if (paramBoolean)
    {
      this.eZO = paramb;
      paramb = this.context;
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(13263);
        throw paramb;
      }
      ((Activity)paramb).setRequestedOrientation(7);
      this.fbt.enable();
      AppMethodBeat.o(13263);
      return;
    }
    paramb = this.context;
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(13263);
      throw paramb;
    }
    ((Activity)paramb).setRequestedOrientation(1);
    this.fbt.disable();
    this.fbs = 0;
    AppMethodBeat.o(13263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.a
 * JD-Core Version:    0.7.0.1
 */