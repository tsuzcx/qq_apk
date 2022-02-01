package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.luggage.l.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c$2
  implements Runnable
{
  c$2(c paramc, y paramy, ad paramad, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt1, boolean paramBoolean2, String paramString4, int paramInt2, int paramInt3, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(177328);
    if (!this.elY.isRunning())
    {
      AppMethodBeat.o(177328);
      return;
    }
    this.exJ.txe.a(bb.tzO);
    final b localb = new b(this.elY.getContext());
    label231:
    Object localObject2;
    if (!Util.isNullOrNil(this.eSG))
    {
      if ((Util.isNullOrNil(this.val$content)) && (!this.sqS)) {
        localb.setMessage(this.eSG);
      }
    }
    else
    {
      if ((!Util.isNullOrNil(this.val$content)) && (!this.sqS)) {
        localb.setMessage(this.val$content);
      }
      localb.a(this.sqT, true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(177325);
          paramAnonymousDialogInterface = new HashMap();
          paramAnonymousDialogInterface.put("confirm", Boolean.TRUE);
          paramAnonymousDialogInterface.put("cancel", Boolean.FALSE);
          if (c.2.this.sqS) {
            paramAnonymousDialogInterface.put("content", localb.jHE());
          }
          c.2.this.elY.callback(c.2.this.elZ, c.2.this.sqR.m("ok", paramAnonymousDialogInterface));
          AppMethodBeat.o(177325);
        }
      });
      if (this.sqU) {
        localb.b(this.sqV, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(177326);
            HashMap localHashMap = new HashMap();
            localHashMap.put("confirm", Boolean.FALSE);
            localHashMap.put("cancel", Boolean.TRUE);
            paramAnonymousDialogInterface.dismiss();
            c.2.this.elY.callback(c.2.this.elZ, c.2.this.sqR.m("ok", localHashMap));
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
          c.2.this.elY.callback(c.2.this.elZ, c.2.this.sqR.m("ok", paramAnonymousDialogInterface));
          AppMethodBeat.o(177327);
        }
      });
      localb.ayi(this.sqW);
      if (this.sqU) {
        localb.ayj(this.sqX);
      }
      if (this.sqS)
      {
        localb.Ny(true);
        if (Util.isNullOrNil(this.val$content)) {
          break label397;
        }
        localObject1 = this.val$content;
        localb.mEditText.setVisibility(0);
        localb.mEditText.setText((CharSequence)localObject1);
        localObject1 = n.ef(this.exJ.getContentView());
        localObject2 = new c.a(localb, this.exJ, (byte)0);
        ((u)localObject1).a((u.c)localObject2);
        localb.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(325923);
            f.bv(c.2.this.exJ.getContext());
            if (this.sra != null) {
              this.sra.b(this.srb);
            }
            AppMethodBeat.o(325923);
          }
        });
      }
      this.elY.getRuntime().pmu.b(localb);
      if (this.sqS)
      {
        localb.jHD();
        localObject1 = this.exJ.getContext();
        if (!(localObject1 instanceof Activity)) {
          break label422;
        }
      }
    }
    label397:
    label422:
    for (Object localObject1 = (Activity)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = (InputMethodManager)((Activity)localObject1).getSystemService("input_method");
        if (localObject2 != null)
        {
          localObject1 = ((Activity)localObject1).getCurrentFocus();
          if ((localObject1 != null) && (((View)localObject1).getWindowToken() != null)) {
            ((InputMethodManager)localObject2).toggleSoftInput(0, 2);
          }
        }
      }
      this.elY.i(new c.2..ExternalSyntheticLambda0(localb), 500L);
      AppMethodBeat.o(177328);
      return;
      localb.setTitle(this.eSG);
      break;
      localObject1 = this.ejE.optString("placeholderText");
      if (Util.isNullOrNil((String)localObject1)) {
        break label231;
      }
      localb.bb((CharSequence)localObject1);
      break label231;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.c.2
 * JD-Core Version:    0.7.0.1
 */