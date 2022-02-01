package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class ab
{
  private static final byte[] hMn;
  public m hMo;
  
  static
  {
    AppMethodBeat.i(132892);
    hMn = o.hr(7);
    AppMethodBeat.o(132892);
  }
  
  public final void j(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132891);
    StringBuilder localStringBuilder = new StringBuilder("onNotify, datalen=");
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      ad.i("MicroMsg.MMNativeNetNotifyAdapter", i + " cmd= " + paramInt);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(132891);
      return;
      i = paramArrayOfByte.length;
      break;
      ad.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
      this.hMo.f(138, hMn);
      AppMethodBeat.o(132891);
      return;
      ad.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { bt.cv(paramArrayOfByte) });
      this.hMo.f(138, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      ad.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
      this.hMo.f(39, null);
      AppMethodBeat.o(132891);
      return;
      AppMethodBeat.o(132891);
      return;
      this.hMo.f(174, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      if (paramArrayOfByte.length > 0)
      {
        this.hMo.f(10, paramArrayOfByte);
        AppMethodBeat.o(132891);
        return;
        AppMethodBeat.o(132891);
        return;
        ad.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        if (paramArrayOfByte.length > 0)
        {
          this.hMo.f(120, paramArrayOfByte);
          AppMethodBeat.o(132891);
          return;
          ad.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
          if (paramArrayOfByte.length > 0)
          {
            this.hMo.f(268369921, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.hMo.f(1000000205, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.hMo.f(192, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ad.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
            this.hMo.f(268369923, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ad.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
            this.hMo.f(241, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ad.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
            this.hMo.f(244, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ad.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
            this.hMo.f(319, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ad.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
            this.hMo.f(311, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ad.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
            this.hMo.f(318, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.hMo.f(271, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.hMo.f(3941, paramArrayOfByte);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.ab
 * JD-Core Version:    0.7.0.1
 */