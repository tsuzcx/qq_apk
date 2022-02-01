package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.Iterator;
import java.util.LinkedList;

final class g$2
  implements Runnable
{
  g$2(g paramg, aa paramaa, int paramInt1, gy paramgy, int paramInt2, String paramString, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(192212);
    g localg = this.kAR;
    aa localaa = this.kAq;
    int i = this.cjQ;
    gy localgy = this.kAP;
    int j = this.kAS;
    Object localObject2 = this.kAQ;
    Object localObject3 = this.kAT;
    if (j == 2) {}
    String str2;
    String str3;
    View localView;
    Object localObject4;
    LinearLayout localLinearLayout;
    for (String str1 = localaa.getContext().getString(2131755326);; str1 = localaa.getContext().getString(2131755327))
    {
      str2 = localaa.getContext().getString(2131755328);
      str3 = localaa.getContext().getString(2131755325);
      String str4 = localaa.getContext().getString(2131755324);
      localObject1 = (LayoutInflater)localaa.getContext().getSystemService("layout_inflater");
      localView = ((LayoutInflater)localObject1).inflate(2131492975, null);
      TextView localTextView = (TextView)localView.findViewById(2131296687);
      localObject4 = (TextView)localView.findViewById(2131296688);
      localLinearLayout = (LinearLayout)localView.findViewById(2131296689);
      localTextView.setText((CharSequence)localObject2);
      ((TextView)localObject4).setText(str4);
      ((TextView)localObject4).setOnClickListener(new g.6(localg, localaa));
      localLinearLayout.removeAllViews();
      if ((localObject3 == null) || (((LinkedList)localObject3).size() <= 0)) {
        break;
      }
      localLinearLayout.setVisibility(0);
      localObject2 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = (TextView)((LayoutInflater)localObject1).inflate(2131492971, null);
        ((TextView)localObject3).setText((CharSequence)localObject4);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject4).bottomMargin = localaa.kca.getResources().getDimensionPixelOffset(2131165752);
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localLinearLayout.addView((View)localObject3);
      }
    }
    Object localObject1 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setVisibility(8);
    ad.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
    new d.a(localaa.getContext()).aXF(str1).gY(localView).yS(false).yR(false).aXM(str2).c(new g.8(localg, localgy, localaa, i)).aXN(str3).d(new g.7(localg, localgy, localaa, i)).fMb().show();
    AppMethodBeat.o(192212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.2
 * JD-Core Version:    0.7.0.1
 */