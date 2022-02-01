package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.Iterator;
import java.util.LinkedList;

final class h$2
  implements Runnable
{
  h$2(h paramh, ad paramad, int paramInt1, hx paramhx, int paramInt2, String paramString, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(326675);
    h localh = this.rHX;
    ad localad = this.rHC;
    int i = this.elZ;
    hx localhx = this.rHV;
    int j = this.rHY;
    Object localObject2 = this.rHW;
    Object localObject3 = this.rHZ;
    if (j == 2) {}
    String str2;
    String str3;
    View localView;
    Object localObject4;
    LinearLayout localLinearLayout;
    for (String str1 = localad.getContext().getString(a.g.app_brand_auth_user_auto_fill_data_dialog_title);; str1 = localad.getContext().getString(a.g.app_brand_auth_user_auto_fill_data_dialog_title_after_write))
    {
      str2 = localad.getContext().getString(a.g.app_brand_auth_user_auto_fill_data_dialog_yes);
      str3 = localad.getContext().getString(a.g.app_brand_auth_user_auto_fill_data_dialog_no);
      String str4 = localad.getContext().getString(a.g.app_brand_auth_user_auto_fill_data_dialog_know_detail);
      localObject1 = (LayoutInflater)localad.getContext().getSystemService("layout_inflater");
      localView = ((LayoutInflater)localObject1).inflate(a.e.app_brand_auto_user_auto_fill_data, null);
      TextView localTextView = (TextView)localView.findViewById(a.d.app_brand_auth_auto_fill_data_content);
      localObject4 = (TextView)localView.findViewById(a.d.app_brand_auth_auto_fill_data_know_detail);
      localLinearLayout = (LinearLayout)localView.findViewById(a.d.app_brand_auth_auto_fill_data_list);
      localTextView.setText((CharSequence)localObject2);
      ((TextView)localObject4).setText(str4);
      ((TextView)localObject4).setOnClickListener(new h.6(localh, localad));
      localLinearLayout.removeAllViews();
      if ((localObject3 == null) || (((LinkedList)localObject3).size() <= 0)) {
        break;
      }
      localLinearLayout.setVisibility(0);
      localObject2 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = (TextView)((LayoutInflater)localObject1).inflate(a.e.app_brand_auth_auto_fill_data_list_item, null);
        ((TextView)localObject3).setText((CharSequence)localObject4);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject4).bottomMargin = localad.getContentView().getResources().getDimensionPixelOffset(a.b.app_brand_auth_auto_fill_data_know_list_item_bottom_margin);
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localLinearLayout.addView((View)localObject3);
      }
    }
    Object localObject1 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setVisibility(8);
    Log.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
    new e.a(localad.getContext()).bDv(str1).md(localView).ND(false).NC(false).bDC(str2).c(new h.8(localh, localhx, localad, i)).bDD(str3).d(new h.7(localh, localhx, localad, i)).jHH().show();
    AppMethodBeat.o(326675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.h.2
 * JD-Core Version:    0.7.0.1
 */