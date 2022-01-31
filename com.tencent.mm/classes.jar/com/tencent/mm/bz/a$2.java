package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements f
{
  a$2(a parama, bug parambug) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(116346);
    paramm.setHasCallbackToQueue(true);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a.a(this.yiz) });
      AppMethodBeat.o(116346);
      return;
    }
    ab.i("MicroMsg.MediaSecurityReport", "report successfully! %s", new Object[] { a.a(this.yiz) });
    AppMethodBeat.o(116346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bz.a.2
 * JD-Core Version:    0.7.0.1
 */