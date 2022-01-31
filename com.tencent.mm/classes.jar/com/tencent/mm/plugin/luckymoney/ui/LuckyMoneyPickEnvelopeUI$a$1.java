package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.a;
import com.tencent.mm.plugin.luckymoney.scaledLayout.d;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class LuckyMoneyPickEnvelopeUI$a$1
  implements View.OnClickListener
{
  LuckyMoneyPickEnvelopeUI$a$1(LuckyMoneyPickEnvelopeUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42914);
    LuckyMoneyPickEnvelopeUI.f(this.ovY.ovW);
    int k = LuckyMoneyEnvelopeTouchRecyclerView.bq(paramView);
    LuckyMoneyPickEnvelopeUI.d(this.ovY.ovW);
    LuckyMoneyEnvelopeTouchRecyclerView localLuckyMoneyEnvelopeTouchRecyclerView;
    RecyclerView.i locali;
    int j;
    if (a.h(LuckyMoneyPickEnvelopeUI.c(this.ovY.ovW)) != paramView)
    {
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to target view");
      localLuckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.f(this.ovY.ovW);
      locali = localLuckyMoneyEnvelopeTouchRecyclerView.getLayoutManager();
      if ((locali instanceof ViewPagerLayoutManager))
      {
        ViewPagerLayoutManager localViewPagerLayoutManager = (ViewPagerLayoutManager)locali;
        i = 0;
        if (i >= localViewPagerLayoutManager.oqk.size()) {
          break label270;
        }
        j = localViewPagerLayoutManager.oqk.keyAt(i);
        if ((View)localViewPagerLayoutManager.oqk.get(j) != paramView) {
          break label263;
        }
      }
    }
    label263:
    label270:
    for (int i = j;; i = -1)
    {
      d.a(localLuckyMoneyEnvelopeTouchRecyclerView, (ViewPagerLayoutManager)locali, i);
      ab.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "touch pos: %s", new Object[] { Integer.valueOf(k) });
      if ((k < 0) || (k >= LuckyMoneyPickEnvelopeUI.b(this.ovY.ovW).size())) {
        break label441;
      }
      paramView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(this.ovY.ovW).get(k);
      if ((paramView.opR == null) || ((paramView.opR.xjO != 1) && (paramView.opR.wyC != 1))) {
        break label275;
      }
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(k) });
      AppMethodBeat.o(42914);
      return;
      i += 1;
      break;
    }
    label275:
    if (!paramView.kql)
    {
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(k) });
      if (LuckyMoneyPickEnvelopeUI.a(this.ovY.ovW) >= 0)
      {
        ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(this.ovY.ovW).get(LuckyMoneyPickEnvelopeUI.a(this.ovY.ovW))).kql = false;
        LuckyMoneyPickEnvelopeUI.i(this.ovY.ovW).bR(LuckyMoneyPickEnvelopeUI.a(this.ovY.ovW));
      }
      paramView.kql = true;
      LuckyMoneyPickEnvelopeUI.c(this.ovY.ovW, k);
      LuckyMoneyPickEnvelopeUI.i(this.ovY.ovW).bR(LuckyMoneyPickEnvelopeUI.a(this.ovY.ovW));
    }
    for (;;)
    {
      this.ovY.ovW.enableOptionMenu(1, true);
      LuckyMoneyPickEnvelopeUI.f(this.ovY.ovW).getAdapter().ajb.notifyChanged();
      label441:
      AppMethodBeat.o(42914);
      return;
      paramView.kql = false;
      LuckyMoneyPickEnvelopeUI.c(this.ovY.ovW, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a.1
 * JD-Core Version:    0.7.0.1
 */