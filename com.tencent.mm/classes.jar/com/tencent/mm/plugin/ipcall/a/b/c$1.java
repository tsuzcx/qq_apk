package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final void bS(int paramInt1, int paramInt2) {}
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(21812);
    synchronized (this.nNX.nNS)
    {
      c localc = this.nNX;
      if (localc.nNT <= 10) {
        localc.nNT = 92;
      }
      a locala = i.bJq().nNK;
      if (locala.kJR != null) {}
      for (int i = locala.kJR.cLI();; i = 0)
      {
        localc.nNT = ((i + 24 + localc.nNT * 3) / 4);
        if (!localc.nNU) {
          break;
        }
        ab.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
        locala = i.bJq().nNK;
        i = j;
        if (locala.kJR != null) {
          i = locala.kJR.cLF();
        }
        localc.nNV = i;
        if (localc.nNV >= localc.nNT) {
          localc.nNV -= localc.nNT;
        }
        localc.nNT = localc.nNV;
        localc.nNU = false;
        if (i.bJr().mCurrentState == 5)
        {
          if (this.nNX.nNW)
          {
            ab.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
            this.nNX.nNW = false;
          }
          i.bJo().nOc.recordCallback(paramArrayOfByte, paramInt, this.nNX.nNT);
        }
        AppMethodBeat.o(21812);
        return;
      }
      localc.nNT = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c.1
 * JD-Core Version:    0.7.0.1
 */