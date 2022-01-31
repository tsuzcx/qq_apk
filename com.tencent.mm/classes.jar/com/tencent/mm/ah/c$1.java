package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(77850);
    if (bo.isNullOrNil(this.efI))
    {
      AppMethodBeat.o(77850);
      return;
    }
    if (this.efI.equals(this.fry.frv))
    {
      AppMethodBeat.o(77850);
      return;
    }
    Object localObject = c.acR();
    if (localObject == null)
    {
      AppMethodBeat.o(77850);
      return;
    }
    localObject = ((i)localObject).rj(this.efI);
    if ((localObject == null) || (!((h)localObject).getUsername().equals(this.efI)))
    {
      AppMethodBeat.o(77850);
      return;
    }
    if (bo.aox() - ((h)localObject).fsn * 60L > 86400L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(77850);
      return;
    }
    if (bo.isNullOrNil(((h)localObject).acY()))
    {
      ab.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { this.efI });
      AppMethodBeat.o(77850);
      return;
    }
    if (c.acQ() == null)
    {
      AppMethodBeat.o(77850);
      return;
    }
    d.F(this.efI, false);
    d.F(this.efI, true);
    this.fry.qU(this.efI);
    AppMethodBeat.o(77850);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77851);
    String str = super.toString() + "|checkAvatarExpire";
    AppMethodBeat.o(77851);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.c.1
 * JD-Core Version:    0.7.0.1
 */