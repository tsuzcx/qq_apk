package com.tencent.mm.media.widget.camerarecordview.b;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"})
public final class a$b
  extends OrientationEventListener
{
  a$b(com.tencent.mm.media.widget.camerarecordview.c.a parama, Context paramContext, int paramInt)
  {
    super(paramInt, 3);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(13262);
    if (!a.a(this.fbv))
    {
      AppMethodBeat.o(13262);
      return;
    }
    Object localObject = this.fbv.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(13262);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindowManager();
    j.p(localObject, "(context as Activity).windowManager");
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    j.p(localObject, "(context as Activity).windowManager.defaultDisplay");
    paramInt = ((Display)localObject).getRotation();
    if (paramInt == a.b(this.fbv))
    {
      AppMethodBeat.o(13262);
      return;
    }
    ab.i("MicroMsg.PreviewOrientationFit", "last rotation :" + a.b(this.fbv) + " ,current rotation:" + paramInt);
    a.a(this.fbv, paramInt);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    while (paramInt == 0)
    {
      localObject = this.fbv.eZO;
      if (localObject != null)
      {
        com.tencent.mm.media.widget.a.b.kd(270);
        this.fbw.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
        localObject = com.tencent.mm.media.widget.camerarecordview.b.fbj;
        localObject = com.tencent.mm.media.widget.camerarecordview.b.getRenderer();
        if (localObject != null)
        {
          ((com.tencent.mm.media.h.a)localObject).jX(com.tencent.mm.media.widget.a.b.WP());
          AppMethodBeat.o(13262);
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
          AppMethodBeat.o(13262);
        }
      }
      else
      {
        AppMethodBeat.o(13262);
        return;
      }
    }
    if (paramInt == 180)
    {
      localObject = this.fbv.eZO;
      if (localObject != null)
      {
        com.tencent.mm.media.widget.a.b.kd(90);
        this.fbw.getCameraPreviewView().a((com.tencent.mm.media.widget.a.b)localObject);
        localObject = com.tencent.mm.media.widget.camerarecordview.b.fbj;
        localObject = com.tencent.mm.media.widget.camerarecordview.b.getRenderer();
        if (localObject != null)
        {
          ((com.tencent.mm.media.h.a)localObject).jX(com.tencent.mm.media.widget.a.b.WP());
          AppMethodBeat.o(13262);
          return;
        }
        AppMethodBeat.o(13262);
        return;
      }
    }
    AppMethodBeat.o(13262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.a.b
 * JD-Core Version:    0.7.0.1
 */