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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ae;

final class g$1
  implements Runnable
{
  g$1(g paramg, z paramz, int paramInt, gy paramgy, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(147154);
    g localg = this.kEg;
    Object localObject1 = this.kDF;
    int j = this.cjS;
    gy localgy = this.kEe;
    Object localObject2 = this.kEf;
    View localView = ((LayoutInflater)((z)localObject1).getContext().getSystemService("layout_inflater")).inflate(2131494167, null);
    TextView localTextView = (TextView)localView.findViewById(2131307270);
    Button localButton1 = (Button)localView.findViewById(2131307269);
    Button localButton2 = (Button)localView.findViewById(2131307271);
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
    localTextView.setMovementMethod(new g.3(localg, (z)localObject1));
    localButton1.setOnClickListener(new g.4(localg, localgy, (z)localObject1, j));
    localButton2.setOnClickListener(new g.5(localg, localgy, (z)localObject1, j));
    ae.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, show the new bottom dialog!");
    localg.kEd = new j(((z)localObject1).getContext());
    localg.kEd.setContentView(localView);
    localg.kEd.setCancelable(false);
    localg.kEd.setCanceledOnTouchOutside(false);
    localObject1 = ((z)localObject1).getRuntime().jzH;
    if (localObject1 != null) {
      ((m)localObject1).b(localg.kEd);
    }
    AppMethodBeat.o(147154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.1
 * JD-Core Version:    0.7.0.1
 */