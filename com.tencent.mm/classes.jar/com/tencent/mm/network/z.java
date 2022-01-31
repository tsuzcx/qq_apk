package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class z
{
  private static final byte[] ger;
  public m ges;
  
  static
  {
    AppMethodBeat.i(58643);
    ger = o.fT(7);
    AppMethodBeat.o(58643);
  }
  
  public final void onPush(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58642);
    StringBuilder localStringBuilder = new StringBuilder("onNotify, datalen=");
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      ab.i("MicroMsg.MMNativeNetNotifyAdapter", i + " cmd= " + paramInt);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(58642);
      return;
      i = paramArrayOfByte.length;
      break;
      ab.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
      this.ges.e(138, ger);
      AppMethodBeat.o(58642);
      return;
      ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { bo.cd(paramArrayOfByte) });
      this.ges.e(138, paramArrayOfByte);
      AppMethodBeat.o(58642);
      return;
      ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
      this.ges.e(39, null);
      AppMethodBeat.o(58642);
      return;
      AppMethodBeat.o(58642);
      return;
      this.ges.e(174, paramArrayOfByte);
      AppMethodBeat.o(58642);
      return;
      if (paramArrayOfByte.length > 0)
      {
        this.ges.e(10, paramArrayOfByte);
        AppMethodBeat.o(58642);
        return;
        AppMethodBeat.o(58642);
        return;
        ab.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        if (paramArrayOfByte.length > 0)
        {
          this.ges.e(120, paramArrayOfByte);
          AppMethodBeat.o(58642);
          return;
          ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
          if (paramArrayOfByte.length > 0)
          {
            this.ges.e(268369921, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            this.ges.e(1000000205, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            this.ges.e(192, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
            this.ges.e(268369923, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            ab.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
            this.ges.e(241, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            ab.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
            this.ges.e(244, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            ab.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
            this.ges.e(319, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            ab.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
            this.ges.e(311, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            ab.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
            this.ges.e(318, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            this.ges.e(271, paramArrayOfByte);
            AppMethodBeat.o(58642);
            return;
            this.ges.e(3941, paramArrayOfByte);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.z
 * JD-Core Version:    0.7.0.1
 */