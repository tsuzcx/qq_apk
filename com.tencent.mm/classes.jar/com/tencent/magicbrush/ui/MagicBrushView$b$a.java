package com.tencent.magicbrush.ui;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 13})
public final class MagicBrushView$b$a
{
  public static Object a(MagicBrushView.b paramb)
  {
    AppMethodBeat.i(182583);
    paramb = paramb.getThisView();
    if (paramb != null)
    {
      if ((paramb instanceof TextureView))
      {
        paramb = ((TextureView)paramb).getSurfaceTexture();
        AppMethodBeat.o(182583);
        return paramb;
      }
      if ((paramb instanceof SurfaceView))
      {
        paramb = ((SurfaceView)paramb).getHolder();
        p.g(paramb, "it.holder");
        paramb = paramb.getSurface();
        AppMethodBeat.o(182583);
        return paramb;
      }
    }
    AppMethodBeat.o(182583);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.MagicBrushView.b.a
 * JD-Core Version:    0.7.0.1
 */