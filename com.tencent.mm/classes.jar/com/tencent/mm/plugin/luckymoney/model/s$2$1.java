package com.tencent.mm.plugin.luckymoney.model;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.eog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.w;

final class s$2$1
  implements Handler.Callback
{
  s$2$1(s.2 param2, eog parameog, k.b paramb) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(163569);
    Log.i("MicroMsg.LuckyMoneyEnvelopePreview", "download finish: %s", new Object[] { Integer.valueOf(paramMessage.arg1) });
    if (paramMessage.arg1 == 3)
    {
      paramMessage = this.KsQ.content;
      k.b localb = this.svq;
      cc localcc = new cc();
      localcc.setContent(paramMessage);
      localcc.setStatus(2);
      localcc.BS("1@fackuser");
      localcc.setCreateTime(br.JN("1@fackuser"));
      localcc.pI(0);
      localcc.setType(436207665);
      long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(localcc);
      paramMessage = u.iiy().bgT(localb.nSL);
      if (paramMessage != null)
      {
        paramMessage.field_hbType = 0;
        paramMessage.field_hbStatus = 0;
        paramMessage.field_receiveStatus = 0;
        paramMessage.field_receiveAmount = 0L;
        u.iiy().a(paramMessage);
      }
      b.a(Long.valueOf(l), this.KsQ);
      if (this.KsR.yAa != null) {
        this.KsR.yAa.dismiss();
      }
    }
    AppMethodBeat.o(163569);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.2.1
 * JD-Core Version:    0.7.0.1
 */