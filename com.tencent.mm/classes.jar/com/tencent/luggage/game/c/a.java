package com.tencent.luggage.game.c;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import java.lang.ref.WeakReference;

public class a
{
  public static final a bzT;
  
  static
  {
    AppMethodBeat.i(140338);
    bzT = new a();
    AppMethodBeat.o(140338);
  }
  
  public void a(MBRuntime paramMBRuntime, i parami)
  {
    AppMethodBeat.i(140337);
    parami = new WeakReference(parami);
    paramMBRuntime = (h)paramMBRuntime.getFontHandler();
    parami = new a.1(this, parami);
    paramMBRuntime.bJO = parami;
    if (paramMBRuntime.bKf != null) {
      paramMBRuntime.bKf.bJO = parami;
    }
    AppMethodBeat.o(140337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.c.a
 * JD-Core Version:    0.7.0.1
 */