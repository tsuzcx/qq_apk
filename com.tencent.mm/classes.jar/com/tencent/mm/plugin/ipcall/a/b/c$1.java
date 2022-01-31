package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    for (;;)
    {
      synchronized (this.lqB.lqw)
      {
        c localc = this.lqB;
        if (localc.lqx <= 10) {
          localc.lqx = 92;
        }
        a locala = i.bcj().lqo;
        if (locala.iEF != null)
        {
          i = locala.iEF.bPE();
          localc.lqx = ((i + 24 + localc.lqx * 3) / 4);
          if (localc.lqy)
          {
            y.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
            locala = i.bcj().lqo;
            i = j;
            if (locala.iEF != null) {
              i = locala.iEF.bPB();
            }
            localc.lqz = i;
            if (localc.lqz >= localc.lqx) {
              localc.lqz -= localc.lqx;
            }
            localc.lqx = localc.lqz;
            localc.lqy = false;
            if (i.bck().mCurrentState == 5)
            {
              if (this.lqB.lqA)
              {
                y.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                this.lqB.lqA = false;
              }
              i.bch().lqG.recordCallback(paramArrayOfByte, paramInt, this.lqB.lqx);
            }
            return;
          }
          localc.lqx = 0;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c.1
 * JD-Core Version:    0.7.0.1
 */