package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ap;

final class a$1
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53084);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      a.blw().bly();
      AppMethodBeat.o(53084);
      return;
    }
    a.access$002(0);
    a.blw().ag(50L, 50L);
    AppMethodBeat.o(53084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a.1
 * JD-Core Version:    0.7.0.1
 */