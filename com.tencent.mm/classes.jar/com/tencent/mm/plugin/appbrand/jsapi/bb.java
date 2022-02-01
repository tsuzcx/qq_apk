package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.Map;
import kotlin.a.ae;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "getEditText", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "showEditTextDialog", "text", "", "Companion", "plugin-appbrand-integration_release"})
public final class bb
  extends d<k>
{
  public static final int CTRL_INDEX = 906;
  public static final String NAME = "editTextWithPopForm";
  public static final a lzn;
  
  static
  {
    AppMethodBeat.i(228280);
    lzn = new a((byte)0);
    AppMethodBeat.o(228280);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm$showEditTextDialog$1$1"})
  static final class c
    implements Runnable
  {
    c(bb parambb, Activity paramActivity, String paramString, k paramk, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(228278);
      final EditText localEditText = bb.dK((Context)this.lzq);
      localEditText.setText((CharSequence)this.lzr);
      f.a locala = new f.a((Context)this.lzq);
      locala.aC((CharSequence)this.lzq.getResources().getString(2131756101)).hu((View)localEditText);
      locala.c((f.c)new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(228277);
          paramAnonymousString = this.lzu.lzq.getSystemService("input_method");
          if (paramAnonymousString == null)
          {
            paramAnonymousString = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(228277);
            throw paramAnonymousString;
          }
          ((InputMethodManager)paramAnonymousString).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
          if (paramAnonymousBoolean) {
            this.lzu.lzs.i(this.lzu.lzt, this.lzu.lzp.n("ok", (Map)ae.g(new o[] { s.U("text", localEditText.getText().toString()) })));
          }
          Log.i("JsApiEditTextWithPopForm", "dialog click is ok:".concat(String.valueOf(paramAnonymousBoolean)));
          AppMethodBeat.o(228277);
        }
      }).show();
      Log.i("JsApiEditTextWithPopForm", "showEditTextDialog");
      AppMethodBeat.o(228278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bb
 * JD-Core Version:    0.7.0.1
 */