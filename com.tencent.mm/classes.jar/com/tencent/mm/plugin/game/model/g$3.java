package com.tencent.mm.plugin.game.model;

import com.tencent.mm.as.a.c.c;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class g$3
  implements c
{
  g$3(awk paramawk, List paramList, g.a parama) {}
  
  public final void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[] { this.kOB.mQp });
      g.b(this.kOC, this.kOD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g.3
 * JD-Core Version:    0.7.0.1
 */