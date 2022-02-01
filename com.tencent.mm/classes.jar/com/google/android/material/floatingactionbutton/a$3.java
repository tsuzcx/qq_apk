package com.google.android.material.floatingactionbutton;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements ViewTreeObserver.OnPreDrawListener
{
  a$3(a parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(237331);
    a locala = this.bBb;
    float f = locala.bAT.getRotation();
    if (locala.rotation != f)
    {
      locala.rotation = f;
      if (Build.VERSION.SDK_INT == 19)
      {
        if (locala.rotation % 90.0F == 0.0F) {
          break label151;
        }
        if (locala.bAT.getLayerType() != 1) {
          locala.bAT.setLayerType(1, null);
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (locala.bAE != null)
      {
        localObject = locala.bAE;
        f = -locala.rotation;
        if (((com.google.android.material.g.a)localObject).rotation != f)
        {
          ((com.google.android.material.g.a)localObject).rotation = f;
          ((com.google.android.material.g.a)localObject).invalidateSelf();
        }
      }
      if (locala.bAH != null)
      {
        localObject = locala.bAH;
        f = -locala.rotation;
        if (f != ((com.google.android.material.internal.a)localObject).rotation)
        {
          ((com.google.android.material.internal.a)localObject).rotation = f;
          ((com.google.android.material.internal.a)localObject).invalidateSelf();
        }
      }
      AppMethodBeat.o(237331);
      return true;
      label151:
      if (locala.bAT.getLayerType() != 0) {
        locala.bAT.setLayerType(0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.a.3
 * JD-Core Version:    0.7.0.1
 */