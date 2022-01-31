package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$12$1
  implements Runnable
{
  o$12$1(o.12 param12, int paramInt1, int paramInt2, p paramp, boolean paramBoolean, String paramString) {}
  
  @SuppressLint({"DefaultLocale"})
  public final void run()
  {
    AppMethodBeat.i(135529);
    if (!o.a(this.kLV.kLI))
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not joining room! abort");
      AppMethodBeat.o(135529);
      return;
    }
    if ((this.val$errType == 0) && (this.val$errCode == 0) && (this.kLT != null) && (this.kLT.isValid()))
    {
      if (!o.b(this.kLV.kLI))
      {
        int i = o.a(this.kLV.kLI, this.kLT.kMp);
        if (i != 0)
        {
          o.a(this.kLV.kLI, this.kLV.kLQ, -10086, -3, "init failed: ".concat(String.valueOf(i)));
          AppMethodBeat.o(135529);
          return;
        }
        m localm = m.kKx;
        ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: start listen to network change");
        localm.tK(0);
      }
      for (;;)
      {
        o.c(this.kLV.kLI);
        o.a(this.kLV.kLI, this.kLV.hyc, this.kLV.kLx, this.kLV.kLD, this.kLV.kLy, this.kLV.kLQ);
        AppMethodBeat.o(135529);
        return;
        if (this.kLU)
        {
          ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: already initialized, but the former ");
          l.Jl(this.kLT.kMp);
        }
      }
    }
    o.a(this.kLV.kLI, this.kLV.kLQ, -10088, -8, String.format("get session key failed. errType: %d, errCode: %d errMsg: %s", new Object[] { Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode), this.ftO }));
    AppMethodBeat.o(135529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.12.1
 * JD-Core Version:    0.7.0.1
 */