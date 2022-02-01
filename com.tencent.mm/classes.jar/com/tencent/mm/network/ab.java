package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ab
{
  private static final byte[] iIU;
  public m iIV;
  
  static
  {
    AppMethodBeat.i(132892);
    iIU = o.hi(7);
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
      ae.i("MicroMsg.MMNativeNetNotifyAdapter", i + " cmd= " + paramInt);
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
      ae.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
      this.iIV.f(138, iIU);
      AppMethodBeat.o(132891);
      return;
      ae.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { bu.cE(paramArrayOfByte) });
      this.iIV.f(138, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      ae.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
      this.iIV.f(39, null);
      AppMethodBeat.o(132891);
      return;
      AppMethodBeat.o(132891);
      return;
      this.iIV.f(174, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      if (paramArrayOfByte.length > 0)
      {
        this.iIV.f(10, paramArrayOfByte);
        AppMethodBeat.o(132891);
        return;
        AppMethodBeat.o(132891);
        return;
        ae.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        if (paramArrayOfByte.length > 0)
        {
          this.iIV.f(120, paramArrayOfByte);
          AppMethodBeat.o(132891);
          return;
          ae.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
          if (paramArrayOfByte.length > 0)
          {
            this.iIV.f(268369921, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.iIV.f(1000000205, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.iIV.f(192, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ae.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
            this.iIV.f(268369923, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ae.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
            this.iIV.f(241, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ae.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
            this.iIV.f(244, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ae.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
            this.iIV.f(311, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ae.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
            this.iIV.f(318, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            ae.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify");
            this.iIV.f(319, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.iIV.f(271, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.iIV.f(3941, paramArrayOfByte);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ab
 * JD-Core Version:    0.7.0.1
 */