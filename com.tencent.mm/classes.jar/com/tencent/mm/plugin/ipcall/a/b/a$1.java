package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

public final class a$1
  implements com.tencent.mm.plugin.voip.model.a
{
  public a$1(a parama) {}
  
  public final int L(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.lqm.bSr) {
      return -1;
    }
    paramInt = i.bch().lqG.playCallback(paramArrayOfByte, paramInt);
    if (paramInt < 0)
    {
      y.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", new Object[] { Integer.valueOf(paramInt) });
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */