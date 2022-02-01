package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.g.c;

final class URISpanHandlerSet$TransferUriSpanHandler$1
  implements g.c
{
  URISpanHandlerSet$TransferUriSpanHandler$1(URISpanHandlerSet.TransferUriSpanHandler paramTransferUriSpanHandler, Bundle paramBundle) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(19760);
    if (paramBoolean)
    {
      paramString = this.hkZ.getString("transaction_id");
      String str1 = this.hkZ.getString("transfer_id");
      String str2 = this.hkZ.getString("receiver_name");
      Intent localIntent = new Intent();
      localIntent.putExtra("transaction_id", paramString);
      localIntent.putExtra("transfer_id", str1);
      localIntent.putExtra("receiver_name", str2);
      localIntent.putExtra("resend_msg_from_flag", 3);
      c.b(MMApplicationContext.getContext(), "remittance", ".ui.RemittanceResendMsgUI", localIntent);
    }
    AppMethodBeat.o(19760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler.1
 * JD-Core Version:    0.7.0.1
 */