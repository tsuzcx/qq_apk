package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.sdk.platformtools.Log;

final class h$1
  implements Runnable
{
  h$1(h paramh, ad paramad, int paramInt, hx paramhx, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(147154);
    h localh = this.rHX;
    Object localObject1 = this.rHC;
    int j = this.elZ;
    hx localhx = this.rHV;
    Object localObject2 = this.rHW;
    View localView = ((LayoutInflater)((ad)localObject1).getContext().getSystemService("layout_inflater")).inflate(a.e.app_brand_auth_user_auto_fill_data_new, null);
    TextView localTextView = (TextView)localView.findViewById(a.d.auto_fill_request_dialog_content);
    Button localButton1 = (Button)localView.findViewById(a.d.auto_fill_request_dialog_accept);
    Button localButton2 = (Button)localView.findViewById(a.d.auto_fill_request_dialog_reject);
    localTextView.setText(Html.fromHtml((String)localObject2));
    localObject2 = new SpannableString(localTextView.getText());
    URLSpan[] arrayOfURLSpan = (URLSpan[])((Spannable)localObject2).getSpans(0, ((Spannable)localObject2).length(), URLSpan.class);
    int k = arrayOfURLSpan.length;
    int i = 0;
    while (i < k)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      int m = ((Spannable)localObject2).getSpanStart(localURLSpan);
      int n = ((Spannable)localObject2).getSpanEnd(localURLSpan);
      ((Spannable)localObject2).removeSpan(localURLSpan);
      ((Spannable)localObject2).setSpan(new URLSpanNoUnderline(localURLSpan.getURL()), m, n, 0);
      i += 1;
    }
    localTextView.setText((CharSequence)localObject2);
    localTextView.setMovementMethod(new h.3(localh, (ad)localObject1));
    localButton1.setOnClickListener(new h.4(localh, localhx, (ad)localObject1, j));
    localButton2.setOnClickListener(new h.5(localh, localhx, (ad)localObject1, j));
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, show the new bottom dialog!");
    localh.rHU = new l(((ad)localObject1).getContext());
    localh.rHU.setContentView(localView);
    localh.rHU.setCancelable(false);
    localh.rHU.setCanceledOnTouchOutside(false);
    localObject1 = ((ad)localObject1).getRuntime().qsn;
    if (localObject1 != null) {
      ((r)localObject1).b(localh.rHU);
    }
    AppMethodBeat.o(147154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.h.1
 * JD-Core Version:    0.7.0.1
 */