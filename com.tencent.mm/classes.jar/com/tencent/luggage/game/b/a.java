package com.tencent.luggage.game.b;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.lang.ref.WeakReference;

public class a
{
  public static final a ciw;
  
  static
  {
    AppMethodBeat.i(130461);
    ciw = new a();
    AppMethodBeat.o(130461);
  }
  
  public void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130460);
    paramAppBrandRuntime = new WeakReference(paramAppBrandRuntime);
    paramMBRuntime = (i)paramMBRuntime.Hj();
    paramAppBrandRuntime = new a.1(this, paramAppBrandRuntime);
    paramMBRuntime.cyl = paramAppBrandRuntime;
    if (paramMBRuntime.cyE != null) {
      paramMBRuntime.cyE.cyl = paramAppBrandRuntime;
    }
    AppMethodBeat.o(130460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.b.a
 * JD-Core Version:    0.7.0.1
 */