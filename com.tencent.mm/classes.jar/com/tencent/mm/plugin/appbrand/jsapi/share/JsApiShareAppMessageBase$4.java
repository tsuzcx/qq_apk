package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ui.MMActivity.a;

final class JsApiShareAppMessageBase$4
  implements Runnable
{
  JsApiShareAppMessageBase$4(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, JsApiShareAppMessageBase.d paramd, MMActivity.a parama, boolean paramBoolean, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(174894);
    f.aK(this.mra.dKq).b(new f.c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(226985);
        if (JsApiShareAppMessageBase.4.this.mrb.mqZ != paramAnonymousInt1)
        {
          AppMethodBeat.o(226985);
          return false;
        }
        JsApiShareAppMessageBase.4.this.mmh.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(226985);
        return true;
      }
    });
    Activity localActivity = this.mra.dKq;
    if (this.mrc) {}
    for (String str = ".ui.transmit.SelectConversationDirectSelectUI";; str = ".ui.transmit.SelectConversationUI")
    {
      c.c(localActivity, str, this.val$intent, this.mrb.mqZ);
      AppMethodBeat.o(174894);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.4
 * JD-Core Version:    0.7.0.1
 */