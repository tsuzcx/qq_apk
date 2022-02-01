package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad
{
  private static final byte[] jFy;
  public o jFz;
  
  static
  {
    AppMethodBeat.i(132892);
    jFy = com.tencent.mm.b.o.iC(7);
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
      this.jFz.f(138, jFy);
      AppMethodBeat.o(132891);
      return;
      Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", new Object[] { Util.dumpHex(paramArrayOfByte) });
      this.jFz.f(138, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
      this.jFz.f(39, null);
      AppMethodBeat.o(132891);
      return;
      AppMethodBeat.o(132891);
      return;
      this.jFz.f(174, paramArrayOfByte);
      AppMethodBeat.o(132891);
      return;
      if (paramArrayOfByte.length > 0)
      {
        this.jFz.f(10, paramArrayOfByte);
        AppMethodBeat.o(132891);
        return;
        AppMethodBeat.o(132891);
        return;
        Log.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
        if (paramArrayOfByte.length > 0)
        {
          this.jFz.f(120, paramArrayOfByte);
          AppMethodBeat.o(132891);
          return;
          Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
          if (paramArrayOfByte.length > 0)
          {
            this.jFz.f(268369921, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.jFz.f(1000000205, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.jFz.f(192, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
            this.jFz.f(268369923, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
            this.jFz.f(241, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
            this.jFz.f(244, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
            this.jFz.f(311, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
            this.jFz.f(318, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify");
            this.jFz.f(319, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.jFz.f(271, paramArrayOfByte);
            AppMethodBeat.o(132891);
            return;
            this.jFz.f(3941, paramArrayOfByte);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ad
 * JD-Core Version:    0.7.0.1
 */