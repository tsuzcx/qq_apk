package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ah.b;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

final class f$1
  implements Runnable
{
  f$1(f paramf, q paramq, int paramInt1, er paramer, b paramb, int paramInt2, String paramString, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    f localf = this.gkR;
    q localq = this.gkf;
    int i = this.dIS;
    er localer = this.gkN;
    b localb = this.eew;
    int j = this.gkO;
    Object localObject2 = this.gkP;
    Object localObject3 = this.gkQ;
    if (j == 2) {}
    String str2;
    String str3;
    View localView;
    Object localObject4;
    LinearLayout localLinearLayout;
    for (String str1 = localq.mContext.getString(y.j.app_brand_auth_user_auto_fill_data_dialog_title);; str1 = localq.mContext.getString(y.j.app_brand_auth_user_auto_fill_data_dialog_title_after_write))
    {
      str2 = localq.mContext.getString(y.j.app_brand_auth_user_auto_fill_data_dialog_yes);
      str3 = localq.mContext.getString(y.j.app_brand_auth_user_auto_fill_data_dialog_no);
      String str4 = localq.mContext.getString(y.j.app_brand_auth_user_auto_fill_data_dialog_know_detail);
      localObject1 = (LayoutInflater)localq.mContext.getSystemService("layout_inflater");
      localView = ((LayoutInflater)localObject1).inflate(y.h.app_brand_auto_user_auto_fill_data, null);
      TextView localTextView = (TextView)localView.findViewById(y.g.app_brand_auth_auto_fill_data_content);
      localObject4 = (TextView)localView.findViewById(y.g.app_brand_auth_auto_fill_data_know_detail);
      localLinearLayout = (LinearLayout)localView.findViewById(y.g.app_brand_auth_auto_fill_data_list);
      localTextView.setText((CharSequence)localObject2);
      ((TextView)localObject4).setText(str4);
      ((TextView)localObject4).setOnClickListener(new f.2(localf, localq));
      localLinearLayout.removeAllViews();
      if ((localObject3 == null) || (((LinkedList)localObject3).size() <= 0)) {
        break;
      }
      localLinearLayout.setVisibility(0);
      localObject2 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject3 = (TextView)((LayoutInflater)localObject1).inflate(y.h.app_brand_auth_auto_fill_data_list_item, null);
        ((TextView)localObject3).setText((CharSequence)localObject4);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject4).bottomMargin = localq.getContentView().getResources().getDimensionPixelOffset(y.e.app_brand_auth_auto_fill_data_know_list_item_bottom_margin);
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localLinearLayout.addView((View)localObject3);
      }
    }
    Object localObject1 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localLinearLayout.setVisibility(8);
    y.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
    h.a(localq.mContext, false, str1, localView, str2, str3, new f.3(localf, localer, localq, i, localb), new f.4(localf, localer, localq, i, localb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.f.1
 * JD-Core Version:    0.7.0.1
 */