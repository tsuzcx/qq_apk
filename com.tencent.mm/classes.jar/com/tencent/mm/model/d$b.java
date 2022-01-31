package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$b
  implements b.a
{
  private d$b(d paramd) {}
  
  public final void gz(int paramInt)
  {
    AppMethodBeat.i(77794);
    switch (paramInt)
    {
    case 0: 
    default: 
      ab.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(77794);
            return;
            ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
          } while (this.fkE.fkC == null);
          AppMethodBeat.o(77794);
          return;
          ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
        } while (this.fkE.fkC == null);
        AppMethodBeat.o(77794);
        return;
        ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
      } while (this.fkE.fkC == null);
      AppMethodBeat.o(77794);
      return;
      ab.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
    } while (this.fkE.fkC == null);
    AppMethodBeat.o(77794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.d.b
 * JD-Core Version:    0.7.0.1
 */