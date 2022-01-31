package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class GLSurfaceView$j
{
  private static String TAG = "GLThreadManager";
  
  public final void b(GLSurfaceView.i parami)
  {
    try
    {
      AppMethodBeat.i(133993);
      ab.i("GLThread", "exiting tid=" + parami.getId());
      GLSurfaceView.i.a(parami);
      notifyAll();
      AppMethodBeat.o(133993);
      return;
    }
    finally
    {
      parami = finally;
      throw parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.j
 * JD-Core Version:    0.7.0.1
 */