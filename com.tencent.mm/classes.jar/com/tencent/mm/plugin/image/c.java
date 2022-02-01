package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.storage.cb;

public final class c
  extends y
{
  private static c JFd;
  
  private c()
  {
    super(r.class);
  }
  
  public static cb bzI()
  {
    AppMethodBeat.i(151491);
    h.baC().aZJ();
    cb localcb = ((a)h.ax(a.class)).bzI();
    AppMethodBeat.o(151491);
    return localcb;
  }
  
  public static c fQB()
  {
    try
    {
      AppMethodBeat.i(151490);
      if (JFd == null) {
        JFd = new c();
      }
      c localc = JFd;
      AppMethodBeat.o(151490);
      return localc;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.image.c
 * JD-Core Version:    0.7.0.1
 */