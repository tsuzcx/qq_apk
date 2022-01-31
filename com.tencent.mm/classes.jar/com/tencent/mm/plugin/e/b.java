package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class b
  extends a
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(18522);
    k.a("FFmpeg", getClass().getClassLoader());
    k.a("wechatpack", getClass().getClassLoader());
    AppMethodBeat.o(18522);
  }
  
  public final String name()
  {
    return "boot-load-FFmpeg-and-wechatpack-libraries";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.e.b
 * JD-Core Version:    0.7.0.1
 */