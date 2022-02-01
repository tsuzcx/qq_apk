package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

final class c$2
  implements Runnable
{
  c$2(c paramc, q paramq, aa paramaa, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(177328);
    if (!this.cjP.isRunning())
    {
      AppMethodBeat.o(177328);
      return;
    }
    this.cqX.mbX.a(aw.mes);
    b localb = new b(this.cjP.getContext());
    if (!bt.isNullOrNil(this.cYy))
    {
      if (!bt.isNullOrNil(this.ilu)) {
        break label195;
      }
      localb.setMessage(this.cYy);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.ilu)) {
        localb.setMessage(this.ilu);
      }
      localb.a(this.leI, true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(177325);
          paramAnonymousDialogInterface = new HashMap();
          paramAnonymousDialogInterface.put("confirm", Boolean.TRUE);
          paramAnonymousDialogInterface.put("cancel", Boolean.FALSE);
          c.2.this.cjP.h(c.2.this.cjQ, c.2.this.leH.m("ok", paramAnonymousDialogInterface));
          AppMethodBeat.o(177325);
        }
      });
      if (this.leJ) {
        localb.b(this.leK, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(177326);
            HashMap localHashMap = new HashMap();
            localHashMap.put("confirm", Boolean.FALSE);
            localHashMap.put("cancel", Boolean.TRUE);
            paramAnonymousDialogInterface.dismiss();
            c.2.this.cjP.h(c.2.this.cjQ, c.2.this.leH.m("ok", localHashMap));
            AppMethodBeat.o(177326);
          }
        });
      }
      localb.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(177327);
          paramAnonymousDialogInterface = new HashMap();
          paramAnonymousDialogInterface.put("confirm", Boolean.FALSE);
          paramAnonymousDialogInterface.put("cancel", Boolean.TRUE);
          c.2.this.cjP.h(c.2.this.cjQ, c.2.this.leH.m("ok", paramAnonymousDialogInterface));
          AppMethodBeat.o(177327);
        }
      });
      localb.aaq(this.leL);
      if (this.leJ) {
        localb.aar(this.leM);
      }
      this.cjP.getRuntime().iDP.b(localb);
      AppMethodBeat.o(177328);
      return;
      label195:
      localb.setTitle(this.cYy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.c.2
 * JD-Core Version:    0.7.0.1
 */