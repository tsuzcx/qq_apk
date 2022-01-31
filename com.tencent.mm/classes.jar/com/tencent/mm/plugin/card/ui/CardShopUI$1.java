package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class CardShopUI$1
  implements AdapterView.OnItemClickListener
{
  CardShopUI$1(CardShopUI paramCardShopUI, Intent paramIntent) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      y.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
    }
    do
    {
      return;
      int i = paramInt;
      if (paramInt > 0) {
        i = paramInt - 1;
      }
      paramAdapterView = (mb)CardShopUI.a(this.iwP).get(i);
      if ((!TextUtils.isEmpty(paramAdapterView.sIf)) && (!TextUtils.isEmpty(paramAdapterView.sIg)))
      {
        paramInt = this.val$intent.getIntExtra("key_from_appbrand_type", 0);
        com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(this.iwP), paramAdapterView.sIf, paramAdapterView.sIg, 1052, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramAdapterView.ina));
    com.tencent.mm.plugin.card.d.b.a(this.iwP, paramAdapterView.ina, 1);
    h.nFQ.f(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(this.iwP).azB(), CardShopUI.c(this.iwP).azC(), "", paramAdapterView.name });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI.1
 * JD-Core Version:    0.7.0.1
 */