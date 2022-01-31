package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.sdk.platformtools.ab;

final class o$14$1
  implements Runnable
{
  o$14$1(o.14 param14, int paramInt1, int paramInt2, b paramb, String paramString) {}
  
  @SuppressLint({"DefaultLocale"})
  public final void run()
  {
    AppMethodBeat.i(135535);
    if ((this.val$errType != 0) || (this.val$errCode != 0) || (this.fuz.fsW.fta == null))
    {
      ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: getroomId fail, errType:" + this.val$errType + ",errCode:" + this.val$errCode);
      o.a(this.kLY.kLI, this.kLY.kLQ, -10088, -10, String.format("join room failed. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode), this.ftO }));
      AppMethodBeat.o(135535);
      return;
    }
    ayf localayf = (ayf)this.fuz.fsW.fta;
    o.a(this.kLY.kLI, localayf.wNz);
    o.a(this.kLY.kLI, o.g(this.kLY.kLI), this.kLY.kLQ);
    AppMethodBeat.o(135535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.14.1
 * JD-Core Version:    0.7.0.1
 */