package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.v.b;

final class c$4
  implements a
{
  c$4(c paramc) {}
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(118179);
    if (paramBoolean)
    {
      if ((paramh != null) && ((paramh instanceof j.a)) && (paramh.getSceneStatus() == 12))
      {
        b.abP();
        AppMethodBeat.o(118179);
      }
    }
    else if ((paramh != null) && (paramh.getSceneStatus() == 16)) {
      b.abP();
    }
    AppMethodBeat.o(118179);
  }
  
  public final void a(v.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.c.4
 * JD-Core Version:    0.7.0.1
 */