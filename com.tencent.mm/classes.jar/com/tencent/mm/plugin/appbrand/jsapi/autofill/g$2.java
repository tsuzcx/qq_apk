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
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.Iterator;
import java.util.LinkedList;

final class g$2
  implements Runnable
{
  g$2(g paramg, ac paramac, int paramInt1, hl paramhl, int paramInt2, String paramString, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(229891);
    g localg = this.lIG;
    ac localac = this.lIf;
    int i = this.cvP;
    hl localhl = this.lIE;
    int j = this.lIH;
    Object localObject2 = this.lIF;
    Object localObject3 = this.lII;
    if (j == 2) {}
    String str2;
    String str3;
    View localView;
    Object localObject4;
    LinearLayout localLinearLayout;
    for (String str1 = localac.getContext().getString(2131755362);; str1 = localac.getContext().getString(2131755363))
    {
      str2 = localac.getContext().getString(2131755364);
      str3 = localac.getContext().getString(2131755361);
      String str4 = localac.getContext().getString(2131755360);
      localObject1 = (LayoutInflater)localac.getContext().getSystemService("layout_inflater");
      localView = ((LayoutInflater)localObject1).inflate(2131493013, null);
      TextView localTextView = (TextView)localView.findViewById(2131296777);
      localObject4 = (TextView)localView.findViewById(2131296778);
      localLinearLayout = (LinearLayout)localView.findViewById(2131296779);
      localTextView.setText((CharSequence)localObject2);
      ((TextView)localObject4).setText(str4);
      ((TextView)localObject4).setOnClickListener(new g.6(localg, localac));
      localLinearLayout.removeAllViews();
      if ((localObject3 == null) || (((LinkedList)localObject3).size() <= 0)) {
        break;
      }
      localLinearLayout.setVisibility(0);
      localObject2 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = (TextView)((LayoutInflater)localObject1).inflate(2131493007, null);
        ((TextView)localObject3).setText((CharSequence)localObject4);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject4).bottomMargin = localac.getContentView().getResources().getDimensionPixelOffset(2131165771);
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localLinearLayout.addView((View)localObject3);
      }
    }
    Object localObject1 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setVisibility(8);
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
    new d.a(localac.getContext()).bon(str1).hs(localView).Dl(false).Dk(false).bou(str2).c(new g.8(localg, localhl, localac, i)).bov(str3).d(new g.7(localg, localhl, localac, i)).hbn().show();
    AppMethodBeat.o(229891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.g.2
 * JD-Core Version:    0.7.0.1
 */