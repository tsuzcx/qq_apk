package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.c;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class f$3
  implements c
{
  f$3(bcz parambcz, List paramList, f.a parama) {}
  
  public final void cZ(boolean paramVarArgs)
  {
    AppMethodBeat.i(151883);
    if (paramVarArgs)
    {
      ab.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.nmy.ThumbUrl });
      f.b(this.nmz, this.nmA);
    }
    AppMethodBeat.o(151883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.f.3
 * JD-Core Version:    0.7.0.1
 */