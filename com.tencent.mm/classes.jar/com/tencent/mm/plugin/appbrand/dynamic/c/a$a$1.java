package com.tencent.mm.plugin.appbrand.dynamic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import junit.framework.Assert;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(10795);
    Assert.assertTrue(String.format("execute assert process(%s) command", new Object[] { e.PM() }), false);
    AppMethodBeat.o(10795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c.a.a.1
 * JD-Core Version:    0.7.0.1
 */