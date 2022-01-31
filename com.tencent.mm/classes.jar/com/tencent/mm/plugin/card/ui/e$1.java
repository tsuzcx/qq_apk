package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class e$1
  implements AdapterView.OnItemClickListener
{
  e$1(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (com.tencent.mm.plugin.card.model.b)this.isQ.iko.get(paramInt);
    if ((paramAdapterView == null) || (TextUtils.isEmpty(paramAdapterView.url))) {}
    label153:
    label345:
    label373:
    label378:
    do
    {
      return;
      paramView = new Intent();
      int i;
      Object localObject;
      int j;
      String str;
      if ((this.isQ.ikk instanceof CardInfo))
      {
        paramView.putExtra("key_card_info_data", (CardInfo)this.isQ.ikk);
        if (!paramAdapterView.url.equals("card://jump_detail")) {
          break label378;
        }
        if ((this.isQ.ikk.azx().sII == null) || (TextUtils.isEmpty(this.isQ.ikk.azx().sII.url))) {
          break label345;
        }
        com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().sII.url, 1);
        paramAdapterView = h.nFQ;
        i = this.isQ.ikk.azx().ilo;
        paramView = this.isQ.ikk.azC();
        localObject = this.isQ.ikk.azB();
        j = this.isQ.isN.ipv;
        str = this.isQ.isN.irV;
        if (!this.isQ.ikk.azv()) {
          break label373;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        paramAdapterView.f(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(i), paramView, localObject, Integer.valueOf(0), Integer.valueOf(j), str, Integer.valueOf(paramInt), "" });
        return;
        if (!(this.isQ.ikk instanceof ShareCardInfo)) {
          break;
        }
        paramView.putExtra("key_card_info_data", (ShareCardInfo)this.isQ.ikk);
        break;
        paramView.setClass(this.isQ.isl, CardDetailPreference.class);
        this.isQ.isl.startActivity(paramView);
        break label153;
      }
      if ((paramAdapterView.url.equals("card://jump_shop_list")) && (this.isQ.ikk.azx().sIu > 0))
      {
        e.a(this.isQ);
        return;
      }
      if ((paramAdapterView.url.equals("card://jump_shop")) && (this.isQ.ikk.azx().sIu > 0))
      {
        if ((this.isQ.ikq == null) || (this.isQ.ikq.size() == 0))
        {
          y.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
          return;
        }
        paramAdapterView = (mb)this.isQ.ikq.get(0);
        if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.ina)))
        {
          com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, paramAdapterView.ina, 1);
          h.nFQ.f(11941, new Object[] { Integer.valueOf(4), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramAdapterView.name });
        }
        paramAdapterView = h.nFQ;
        i = this.isQ.ikk.azx().ilo;
        paramView = this.isQ.ikk.azC();
        localObject = this.isQ.ikk.azB();
        j = this.isQ.isN.ipv;
        str = this.isQ.isN.irV;
        if (this.isQ.ikk.azv()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramAdapterView.f(11324, new Object[] { "UsedStoresView", Integer.valueOf(i), paramView, localObject, Integer.valueOf(0), Integer.valueOf(j), str, Integer.valueOf(paramInt), "" });
          return;
        }
      }
      if (paramAdapterView.url.equals("card://jump_service"))
      {
        if (!TextUtils.isEmpty(this.isQ.ikk.azx().sIn))
        {
          com.tencent.mm.plugin.card.d.b.ab(this.isQ.isl, this.isQ.ikk.azx().sIn);
          am.aAy().r(this.isQ.ikk.azB(), this.isQ.ikk.azC(), 1);
        }
        h.nFQ.f(11582, new Object[] { "OperService", Integer.valueOf(1), Integer.valueOf(this.isQ.ikk.azx().ilo), this.isQ.ikk.azC(), this.isQ.ikk.azB(), this.isQ.isN.irV });
        return;
      }
      if (paramAdapterView.url.equals("card://jump_gift"))
      {
        e.b(this.isQ);
        paramAdapterView = this.isQ;
        if (paramAdapterView.ikk.azy().sHJ == null)
        {
          y.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
          return;
        }
        if (paramAdapterView.ikk.azy().sHJ.sOH == null)
        {
          y.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
          return;
        }
        h.nFQ.f(13866, new Object[] { Integer.valueOf(6), paramAdapterView.ikk.azy().sHJ.sOH.sti, o.getString(paramAdapterView.ikk.azy().sHJ.sOH.sth) });
        return;
      }
      if (paramAdapterView.url.equals("card://jump_card_gift"))
      {
        if (this.isQ.ikk.azy().sHJ == null)
        {
          y.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
          return;
        }
        if (this.isQ.ikk.azy().sHJ.sOH == null)
        {
          y.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
          return;
        }
        paramAdapterView = this.isQ;
        paramView = this.isQ.ikk.azy().sHJ.sOH.sti;
        paramInt = this.isQ.ikk.azy().sHJ.sOH.sth;
        y.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", new Object[] { paramView, Integer.valueOf(paramInt) });
        localObject = new Intent(paramAdapterView.isl, CardGiftReceiveUI.class);
        ((Intent)localObject).putExtra("key_biz_uin", paramInt);
        ((Intent)localObject).putExtra("key_order_id", paramView);
        ((Intent)localObject).putExtra("key_gift_into", (CardGiftInfo)paramAdapterView.isl.getIntent().getParcelableExtra("key_card_git_info"));
        paramAdapterView.isl.startActivity((Intent)localObject);
        h.nFQ.f(13866, new Object[] { Integer.valueOf(5), this.isQ.ikk.azy().sHJ.sOH.sti, o.getString(this.isQ.ikk.azy().sHJ.sOH.sth) });
        return;
      }
      if ((paramAdapterView.sJq & 0x20) > 0L)
      {
        paramAdapterView = this.isQ;
        com.tencent.mm.plugin.card.d.b.a(paramAdapterView.isl, 4, paramAdapterView);
        paramAdapterView.isl.gJb = paramAdapterView;
        return;
      }
      if (com.tencent.mm.plugin.card.d.b.d(this.isQ.ikk.azB(), paramAdapterView.sIf, paramAdapterView.sIg, this.isQ.isN.ipv, this.isQ.isN.isT))
      {
        h.nFQ.f(11941, new Object[] { Integer.valueOf(21), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramAdapterView.title });
        return;
      }
      paramView = com.tencent.mm.plugin.card.d.l.y(paramAdapterView.url, paramAdapterView.sJq);
      com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, paramView, 1);
      h.nFQ.f(11492, new Object[] { Integer.valueOf(this.isQ.isN.ipv), this.isQ.isN.irW, this.isQ.ikk.azB(), this.isQ.ikk.azC(), Integer.valueOf(this.isQ.ikk.azy().status), paramView, Integer.valueOf(this.isQ.ikk.azx().ilo), this.isQ.ikk.azx().sIn });
      h.nFQ.f(11941, new Object[] { Integer.valueOf(6), this.isQ.ikk.azB(), this.isQ.ikk.azC(), "", paramAdapterView.title });
    } while (!com.tencent.mm.plugin.card.d.l.a(paramAdapterView, this.isQ.ikk.azB()));
    paramView = this.isQ.ikk.azB();
    paramAdapterView = paramAdapterView.title;
    com.tencent.mm.plugin.card.d.l.yX(paramView);
    com.tencent.mm.plugin.card.d.b.a(this.isQ.isl, this.isQ.ikk.azx().imA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.1
 * JD-Core Version:    0.7.0.1
 */