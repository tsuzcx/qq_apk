package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.view.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEditTextWithPopForm;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "getEditText", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "showEditTextDialog", "text", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
  extends c<k>
{
  public static final int CTRL_INDEX = 906;
  public static final String NAME = "editTextWithPopForm";
  public static final bb.a rxY;
  
  static
  {
    AppMethodBeat.i(325594);
    rxY = new bb.a((byte)0);
    AppMethodBeat.o(325594);
  }
  
  private static final void a(Activity paramActivity, EditText paramEditText, k paramk, int paramInt, bb parambb, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(325585);
    s.u(paramEditText, "$customView");
    s.u(paramk, "$env");
    s.u(parambb, "this$0");
    paramActivity = paramActivity.getSystemService("input_method");
    if (paramActivity == null)
    {
      paramActivity = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(325585);
      throw paramActivity;
    }
    ((InputMethodManager)paramActivity).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    if (paramBoolean) {
      paramk.callback(paramInt, parambb.m("ok", (Map)ak.g(new r[] { v.Y("text", paramEditText.getText().toString()) })));
    }
    Log.i("JsApiEditTextWithPopForm", s.X("dialog click is ok:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(325585);
  }
  
  private static final void a(bb parambb, Activity paramActivity, String paramString, k paramk, int paramInt)
  {
    AppMethodBeat.i(325593);
    s.u(parambb, "this$0");
    s.u(paramString, "$text");
    s.u(paramk, "$env");
    Context localContext = (Context)paramActivity;
    EditText localEditText = new EditText(localContext);
    localEditText.setHint((CharSequence)localContext.getResources().getString(ba.i.appbrand_live_shop_edit_hint));
    localEditText.setGravity(51);
    localEditText.setTextSize(0, d.e(localContext, 15.0F));
    localEditText.setMaxEms(80);
    localEditText.setMaxLines(2);
    localEditText.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject = av.GiL;
    av.a(localEditText, (a)bb.b.rxZ);
    localEditText.setPadding(localEditText.getPaddingLeft(), localContext.getResources().getDimensionPixelOffset(ba.d.Edge_0_5_A), localEditText.getPaddingRight(), localContext.getResources().getDimensionPixelOffset(ba.d.Edge_0_5_A));
    localEditText.setBackgroundColor(localContext.getResources().getColor(ba.c.app_brand_BW_0_Alpha_0_0_5));
    localObject = new ViewGroup.LayoutParams(-1, -1);
    localEditText.setHeight(d.e(localContext, 100.0F));
    localEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localEditText.setText((CharSequence)paramString);
    paramString = new g.a((Context)paramActivity);
    paramString.bf((CharSequence)paramActivity.getResources().getString(ba.i.appbrand_live_shop_edit_title)).mg((View)localEditText);
    paramString.c(new bb..ExternalSyntheticLambda0(paramActivity, localEditText, paramk, paramInt, parambb)).show();
    Log.i("JsApiEditTextWithPopForm", "showEditTextDialog");
    AppMethodBeat.o(325593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bb
 * JD-Core Version:    0.7.0.1
 */