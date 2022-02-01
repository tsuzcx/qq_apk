package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.luggage.k.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c$2
  implements Runnable
{
  c$2(c paramc, v paramv, ad paramad, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt1, boolean paramBoolean2, String paramString4, int paramInt2, int paramInt3, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(177328);
    if (!this.cue.isRunning())
    {
      AppMethodBeat.o(177328);
      return;
    }
    this.cEy.qsA.a(bb.quZ);
    Object localObject1 = new b(this.cue.getContext());
    if (!Util.isNullOrNil(this.cWz))
    {
      if ((Util.isNullOrNil(this.val$content)) && (!this.plZ)) {
        ((b)localObject1).setMessage(this.cWz);
      }
    }
    else
    {
      if ((!Util.isNullOrNil(this.val$content)) && (!this.plZ)) {
        ((b)localObject1).setMessage(this.val$content);
      }
      ((b)localObject1).a(this.pma, true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(177325);
          paramAnonymousDialogInterface = new HashMap();
          paramAnonymousDialogInterface.put("confirm", Boolean.TRUE);
          paramAnonymousDialogInterface.put("cancel", Boolean.FALSE);
          if (c.2.this.plZ) {
            paramAnonymousDialogInterface.put("content", this.pmf.icq());
          }
          c.2.this.cue.j(c.2.this.cuf, c.2.this.plY.m("ok", paramAnonymousDialogInterface));
          AppMethodBeat.o(177325);
        }
      });
      if (this.pmb) {
        ((b)localObject1).b(this.pmc, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(177326);
            HashMap localHashMap = new HashMap();
            localHashMap.put("confirm", Boolean.FALSE);
            localHashMap.put("cancel", Boolean.TRUE);
            paramAnonymousDialogInterface.dismiss();
            c.2.this.cue.j(c.2.this.cuf, c.2.this.plY.m("ok", localHashMap));
            AppMethodBeat.o(177326);
          }
        });
      }
      ((b)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(177327);
          paramAnonymousDialogInterface = new HashMap();
          paramAnonymousDialogInterface.put("confirm", Boolean.FALSE);
          paramAnonymousDialogInterface.put("cancel", Boolean.TRUE);
          c.2.this.cue.j(c.2.this.cuf, c.2.this.plY.m("ok", paramAnonymousDialogInterface));
          AppMethodBeat.o(177327);
        }
      });
      ((b)localObject1).asd(this.pmd);
      if (this.pmb) {
        ((b)localObject1).ase(this.pme);
      }
      if (this.plZ)
      {
        ((b)localObject1).HC(true);
        if (Util.isNullOrNil(this.val$content)) {
          break label347;
        }
        localObject2 = this.val$content;
        ((d)localObject1).mEditText.setVisibility(0);
        ((d)localObject1).mEditText.setText((CharSequence)localObject2);
        label231:
        localObject2 = n.dr(this.cEy.getContentView());
        final c.a locala = new c.a((b)localObject1, this.cEy, (byte)0);
        ((u)localObject2).a(locala);
        ((b)localObject1).setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(208966);
            g.aK(c.2.this.cEy.getContext());
            if (this.pmh != null) {
              this.pmh.b(locala);
            }
            AppMethodBeat.o(208966);
          }
        });
      }
      this.cue.getRuntime().msX.a((j)localObject1);
      if (!this.plZ) {
        break label413;
      }
      ((d)localObject1).mEditText.requestFocus();
      localObject1 = this.cEy.getContext();
      if (!(localObject1 instanceof Activity)) {
        break label372;
      }
    }
    label347:
    label372:
    for (localObject1 = (Activity)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label377;
      }
      AppMethodBeat.o(177328);
      return;
      ((b)localObject1).setTitle(this.cWz);
      break;
      localObject2 = this.cui.optString("placeholderText");
      if (Util.isNullOrNil((String)localObject2)) {
        break label231;
      }
      ((b)localObject1).aN((CharSequence)localObject2);
      break label231;
    }
    label377:
    Object localObject2 = (InputMethodManager)((Activity)localObject1).getSystemService("input_method");
    if (localObject2 != null)
    {
      localObject1 = ((Activity)localObject1).getCurrentFocus();
      if ((localObject1 != null) && (((View)localObject1).getWindowToken() != null)) {
        ((InputMethodManager)localObject2).toggleSoftInput(0, 2);
      }
    }
    label413:
    AppMethodBeat.o(177328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.c.2
 * JD-Core Version:    0.7.0.1
 */