package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.b;

final class e$2
  implements b
{
  e$2(e parame) {}
  
  public final int M(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(135469);
    if (e.c(this.kJQ) != 2)
    {
      AppMethodBeat.o(135469);
      return -1;
    }
    o localo = o.kKN;
    paramInt = o.O(paramArrayOfByte, paramInt);
    if (!e.l(this.kJQ))
    {
      if (paramInt < 0)
      {
        AppMethodBeat.o(135469);
        return -1;
      }
    }
    else
    {
      AppMethodBeat.o(135469);
      return -10086;
    }
    AppMethodBeat.o(135469);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e.2
 * JD-Core Version:    0.7.0.1
 */