package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.Map;
import kotlin.a.ae;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "getEditText", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "showEditTextDialog", "text", "", "Companion", "plugin-appbrand-integration_release"})
public final class ay
  extends c<j>
{
  public static final int CTRL_INDEX = 906;
  public static final String NAME = "editTextWithPopForm";
  public static final ay.a ouB;
  
  static
  {
    AppMethodBeat.i(266157);
    ouB = new ay.a((byte)0);
    AppMethodBeat.o(266157);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm$showEditTextDialog$1$1"})
  static final class c
    implements Runnable
  {
    c(ay paramay, Activity paramActivity, String paramString, j paramj, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(268176);
      final EditText localEditText = ay.dJ((Context)this.ouE);
      localEditText.setText((CharSequence)this.ouF);
      f.a locala = new f.a((Context)this.ouE);
      locala.aR((CharSequence)this.ouE.getResources().getString(au.i.appbrand_live_shop_edit_title)).iK((View)localEditText);
      locala.c((f.c)new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(277861);
          paramAnonymousString = this.ouI.ouE.getSystemService("input_method");
          if (paramAnonymousString == null)
          {
            paramAnonymousString = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(277861);
            throw paramAnonymousString;
          }
          ((InputMethodManager)paramAnonymousString).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
          if (paramAnonymousBoolean) {
            this.ouI.ouG.j(this.ouI.ouH, this.ouI.ouD.m("ok", (Map)ae.g(new o[] { s.M("text", localEditText.getText().toString()) })));
          }
          Log.i("JsApiEditTextWithPopForm", "dialog click is ok:".concat(String.valueOf(paramAnonymousBoolean)));
          AppMethodBeat.o(277861);
        }
      }).show();
      Log.i("JsApiEditTextWithPopForm", "showEditTextDialog");
      AppMethodBeat.o(268176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */