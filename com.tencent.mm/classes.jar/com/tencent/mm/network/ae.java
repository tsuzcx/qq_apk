package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ae
{
  private static final byte[] ppA;
  public o ppB;
  
  static
  {
    AppMethodBeat.i(132892);
    ppA = com.tencent.mm.b.o.nE(7);
    AppMethodBeat.o(132892);
  }
  
  public final void k(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132891);
    StringBuilder localStringBuilder = new StringBuilder("onNotify, datalen=");
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      Log.i("MicroMsg.MMNativeNetNotifyAdapter", i + " cmd= " + paramInt);
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
      Log.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
      this.ppB.f(138, ppA);
      AppMethodBeat.o(132891);
      return;
      Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { Util.dumpHex(paramArrayOfByte) });
      this.ppB.f(138, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
      this.ppB.f(39, null);
      AppMethodBeat.o(132891);
      return;
      AppMethodBeat.o(132891);
      return;
      this.ppB.f(174, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      if (paramArrayOfByte.length > 0)
      {
        this.ppB.f(10, paramArrayOfByte);
        AppMethodBeat.o(132891);
        return;
        AppMethodBeat.o(132891);
        return;
        Log.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        if (paramArrayOfByte.length > 0)
        {
          this.ppB.f(120, paramArrayOfByte);
          AppMethodBeat.o(132891);
          return;
          Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
          if (paramArrayOfByte.length > 0)
          {
            this.ppB.f(268369921, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.ppB.f(1000000205, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.ppB.f(192, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
            this.ppB.f(268369923, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
            this.ppB.f(241, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
            this.ppB.f(244, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
            this.ppB.f(311, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
            this.ppB.f(318, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify");
            this.ppB.f(319, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.ppB.f(271, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.ppB.f(3941, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.ppB.f(10098, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.ppB.f(6238, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify ACTION_EVENT");
            this.ppB.f(320, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify ACTION_EVENT_FINDER_REDDOT");
            this.ppB.f(322, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify encryted ACTION_EVENT");
            this.ppB.f(321, paramArrayOfByte);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */