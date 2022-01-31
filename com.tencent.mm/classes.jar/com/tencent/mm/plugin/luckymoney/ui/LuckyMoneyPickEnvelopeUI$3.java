package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.vending.c.a;
import java.io.IOException;

final class LuckyMoneyPickEnvelopeUI$3
  implements a<Object, a.a<vb>>
{
  LuckyMoneyPickEnvelopeUI$3(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI, String paramString) {}
  
  private Object f(a.a<vb> parama)
  {
    AppMethodBeat.i(42903);
    ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do confirm errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if (LuckyMoneyPickEnvelopeUI.k(this.ovW) != null) {
      LuckyMoneyPickEnvelopeUI.k(this.ovW).dismiss();
    }
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", new Object[] { Integer.valueOf(((vb)parama.fsN).cnK) });
      parama = new Intent();
      localObject = LuckyMoneyPickEnvelopeUI.c(this.ovW, this.ovX);
      if (localObject == null) {}
    }
    try
    {
      localObject = ((aus)localObject).toByteArray();
      parama.putExtra(e.e.yVc, (byte[])localObject);
      this.ovW.setResult(-1, parama);
      this.ovW.finish();
      AppMethodBeat.o(42903);
      return null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.3
 * JD-Core Version:    0.7.0.1
 */