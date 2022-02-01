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
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;

final class g$1
  implements Runnable
{
  g$1(g paramg, ac paramac, int paramInt, hl paramhl, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(147154);
    g localg = this.lIG;
    Object localObject1 = this.lIf;
    int j = this.cvP;
    hl localhl = this.lIE;
    Object localObject2 = this.lIF;
    View localView = ((LayoutInflater)((ac)localObject1).getContext().getSystemService("layout_inflater")).inflate(2131493010, null);
    TextView localTextView = (TextView)localView.findViewById(2131297112);
    Button localButton1 = (Button)localView.findViewById(2131297111);
    Button localButton2 = (Button)localView.findViewById(2131297113);
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
    localTextView.setMovementMethod(new g.3(localg, (ac)localObject1));
    localButton1.setOnClickListener(new g.4(localg, localhl, (ac)localObject1, j));
    localButton2.setOnClickListener(new g.5(localg, localhl, (ac)localObject1, j));
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, show the new bottom dialog!");
    localg.lID = new j(((ac)localObject1).getContext());
    localg.lID.setContentView(localView);
    localg.lID.setCancelable(false);
    localg.lID.setCanceledOnTouchOutside(false);
    localObject1 = ((ac)localObject1).getRuntime().kAv;
    if (localObject1 != null) {
      ((m)localObject1).b(localg.lID);
    }
    AppMethodBeat.o(147154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.1
 * JD-Core Version:    0.7.0.1
 */