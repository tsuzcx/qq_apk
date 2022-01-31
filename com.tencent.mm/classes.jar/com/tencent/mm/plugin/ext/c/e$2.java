package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.sdk.platformtools.bj;

public final class e$2
  extends bj<Boolean>
{
  public e$2(e parame, Boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    super(5000L, paramBoolean);
  }
  
  private Boolean aJK()
  {
    AppMethodBeat.i(20421);
    g.RK().eHt.a(782, new e.2.1(this));
    g.RK().eHt.a(new a(this.val$url, this.hJy, this.hJz), 0);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(20421);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.2
 * JD-Core Version:    0.7.0.1
 */