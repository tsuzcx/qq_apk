package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$1
  implements b
{
  public a$1(a parama) {}
  
  public final int M(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(21798);
    if (!this.nNI.isStart)
    {
      AppMethodBeat.o(21798);
      return -1;
    }
    paramInt = i.bJo().nOc.playCallback(paramArrayOfByte, paramInt);
    if (paramInt < 0)
    {
      ab.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(21798);
      return -1;
    }
    AppMethodBeat.o(21798);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */