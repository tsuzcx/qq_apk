package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class CardShopUI$1
  implements AdapterView.OnItemClickListener
{
  CardShopUI$1(CardShopUI paramCardShopUI, Intent paramIntent) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(88629);
    if (paramInt == 0)
    {
      ab.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
      AppMethodBeat.o(88629);
      return;
    }
    int i = paramInt;
    if (paramInt > 0) {
      i = paramInt - 1;
    }
    paramAdapterView = (oz)CardShopUI.a(this.kxT).get(i);
    if ((!TextUtils.isEmpty(paramAdapterView.wFL)) && (!TextUtils.isEmpty(paramAdapterView.wFM)))
    {
      paramInt = this.val$intent.getIntExtra("key_from_appbrand_type", 0);
      com.tencent.mm.plugin.card.d.b.d(CardShopUI.b(this.kxT), paramAdapterView.wFL, paramAdapterView.wFM, 1052, paramInt);
      AppMethodBeat.o(88629);
      return;
    }
    if (!TextUtils.isEmpty(paramAdapterView.knV))
    {
      com.tencent.mm.plugin.card.d.b.a(this.kxT, paramAdapterView.knV, 1);
      h.qsU.e(11941, new Object[] { Integer.valueOf(4), CardShopUI.c(this.kxT).bbh(), CardShopUI.c(this.kxT).bbi(), "", paramAdapterView.name });
    }
    AppMethodBeat.o(88629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI.1
 * JD-Core Version:    0.7.0.1
 */