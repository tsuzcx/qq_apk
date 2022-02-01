package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Arrays;
import java.util.List;

final class i$1
  implements c.a
{
  i$1(i parami, c paramc, int paramInt1, int paramInt2) {}
  
  public final void Nr(final String paramString)
  {
    AppMethodBeat.i(180270);
    ae.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, localPath: ".concat(String.valueOf(paramString)));
    if (bu.isNullOrNil(paramString))
    {
      this.koV.h(this.cjS, this.llU.e("fail:imagePath is illegal", null));
      AppMethodBeat.o(180270);
      return;
    }
    final Activity localActivity = this.koV.au(Activity.class);
    if (localActivity == null)
    {
      ae.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, activity is null");
      this.koV.h(this.cjS, this.llU.e("fail:activity is null", null));
      AppMethodBeat.o(180270);
      return;
    }
    final MMActivity.a local1 = new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(180267);
        if (paramAnonymousInt1 != i.1.this.llU.llT)
        {
          ae.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, requestCode: %d is not match", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(180267);
          return;
        }
        if (paramAnonymousInt2 != -1)
        {
          ae.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, resultCode is not RESULT_OK: ".concat(String.valueOf(paramAnonymousInt2)));
          i.1.this.koV.h(i.1.this.cjS, i.1.this.llU.e("cancel", null));
          AppMethodBeat.o(180267);
          return;
        }
        if (paramAnonymousIntent == null) {}
        for (paramAnonymousIntent = null; (paramAnonymousIntent == null) || (paramAnonymousIntent.isEmpty()); paramAnonymousIntent = paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"))
        {
          ae.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUsers is empty");
          i.1.this.koV.h(i.1.this.cjS, i.1.this.llU.e("fail:selected user is empty", null));
          AppMethodBeat.o(180267);
          return;
        }
        ae.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUser: " + Arrays.toString(paramAnonymousIntent.toArray()));
        i.1.this.koV.h(i.1.this.cjS, i.1.this.llU.e("ok", null));
        AppMethodBeat.o(180267);
      }
    };
    this.koV.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180269);
        e.aB(localActivity).b(new e.c()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(180268);
            if (i.1.this.llU.llT != paramAnonymous2Int1)
            {
              AppMethodBeat.o(180268);
              return false;
            }
            i.1.2.this.lgL.c(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Intent);
            AppMethodBeat.o(180268);
            return true;
          }
        });
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_File_Name", paramString);
        localIntent.putExtra("Retr_Compress_Type", i.1.this.idQ);
        localIntent.putExtra("Retr_Msg_Type", 0);
        d.c(localActivity, ".ui.transmit.MsgRetransmitUI", localIntent, i.1.this.llU.llT);
        AppMethodBeat.o(180269);
      }
    });
    AppMethodBeat.o(180270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.i.1
 * JD-Core Version:    0.7.0.1
 */