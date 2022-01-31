package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

final class e$1
  implements AdapterView.OnItemClickListener
{
  e$1(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(88335);
    paramAdapterView = (com.tencent.mm.plugin.card.model.b)this.ktX.klo.get(paramInt);
    if ((paramAdapterView == null) || (TextUtils.isEmpty(paramAdapterView.url)))
    {
      AppMethodBeat.o(88335);
      return;
    }
    paramView = new Intent();
    label163:
    int i;
    Object localObject;
    int j;
    String str;
    if ((this.ktX.klk instanceof CardInfo))
    {
      paramView.putExtra("key_card_info_data", (CardInfo)this.ktX.klk);
      if (!paramAdapterView.url.equals("card://jump_detail")) {
        break label393;
      }
      if ((this.ktX.klk.bbd().wGr == null) || (TextUtils.isEmpty(this.ktX.klk.bbd().wGr.url))) {
        break label360;
      }
      com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, this.ktX.klk.bbd().wGr.url, 1);
      paramAdapterView = h.qsU;
      i = this.ktX.klk.bbd().iFL;
      paramView = this.ktX.klk.bbi();
      localObject = this.ktX.klk.bbh();
      j = this.ktX.ktU.kqC;
      str = this.ktX.ktU.ktc;
      if (!this.ktX.klk.bbb()) {
        break label388;
      }
    }
    label388:
    for (paramInt = 1;; paramInt = 0)
    {
      paramAdapterView.e(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(i), paramView, localObject, Integer.valueOf(0), Integer.valueOf(j), str, Integer.valueOf(paramInt), "" });
      AppMethodBeat.o(88335);
      return;
      if (!(this.ktX.klk instanceof ShareCardInfo)) {
        break;
      }
      paramView.putExtra("key_card_info_data", (ShareCardInfo)this.ktX.klk);
      break;
      label360:
      paramView.setClass(this.ktX.kts, CardDetailPreference.class);
      this.ktX.kts.startActivity(paramView);
      break label163;
    }
    label393:
    if ((paramAdapterView.url.equals("card://jump_shop_list")) && (this.ktX.klk.bbd().wGd > 0))
    {
      e.a(this.ktX);
      AppMethodBeat.o(88335);
      return;
    }
    if ((paramAdapterView.url.equals("card://jump_shop")) && (this.ktX.klk.bbd().wGd > 0))
    {
      if ((this.ktX.klq == null) || (this.ktX.klq.size() == 0))
      {
        ab.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
        AppMethodBeat.o(88335);
        return;
      }
      paramAdapterView = (oz)this.ktX.klq.get(0);
      if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.knV)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramAdapterView.knV, 1);
        h.qsU.e(11941, new Object[] { Integer.valueOf(4), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramAdapterView.name });
      }
      paramAdapterView = h.qsU;
      i = this.ktX.klk.bbd().iFL;
      paramView = this.ktX.klk.bbi();
      localObject = this.ktX.klk.bbh();
      j = this.ktX.ktU.kqC;
      str = this.ktX.ktU.ktc;
      if (this.ktX.klk.bbb()) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramAdapterView.e(11324, new Object[] { "UsedStoresView", Integer.valueOf(i), paramView, localObject, Integer.valueOf(0), Integer.valueOf(j), str, Integer.valueOf(paramInt), "" });
        AppMethodBeat.o(88335);
        return;
      }
    }
    if (paramAdapterView.url.equals("card://jump_service"))
    {
      if (!TextUtils.isEmpty(this.ktX.klk.bbd().wFW))
      {
        com.tencent.mm.plugin.card.d.b.ae(this.ktX.kts, this.ktX.klk.bbd().wFW);
        am.bcj().w(this.ktX.klk.bbh(), this.ktX.klk.bbi(), 1);
      }
      h.qsU.e(11582, new Object[] { "OperService", Integer.valueOf(1), Integer.valueOf(this.ktX.klk.bbd().iFL), this.ktX.klk.bbi(), this.ktX.klk.bbh(), this.ktX.ktU.ktc });
      AppMethodBeat.o(88335);
      return;
    }
    if (paramAdapterView.url.equals("card://jump_gift"))
    {
      e.b(this.ktX);
      paramAdapterView = this.ktX;
      if (paramAdapterView.klk.bbe().wEf == null)
      {
        ab.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
        AppMethodBeat.o(88335);
        return;
      }
      if (paramAdapterView.klk.bbe().wEf.wML == null)
      {
        ab.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
        AppMethodBeat.o(88335);
        return;
      }
      h.qsU.e(13866, new Object[] { Integer.valueOf(6), paramAdapterView.klk.bbe().wEf.wML.wlM, p.getString(paramAdapterView.klk.bbe().wEf.wML.wlL) });
      AppMethodBeat.o(88335);
      return;
    }
    if (paramAdapterView.url.equals("card://jump_card_gift"))
    {
      if (this.ktX.klk.bbe().wEf == null)
      {
        ab.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
        AppMethodBeat.o(88335);
        return;
      }
      if (this.ktX.klk.bbe().wEf.wML == null)
      {
        ab.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
        AppMethodBeat.o(88335);
        return;
      }
      paramAdapterView = this.ktX;
      paramView = this.ktX.klk.bbe().wEf.wML.wlM;
      paramInt = this.ktX.klk.bbe().wEf.wML.wlL;
      ab.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", new Object[] { paramView, Integer.valueOf(paramInt) });
      localObject = new Intent(paramAdapterView.kts, CardGiftReceiveUI.class);
      ((Intent)localObject).putExtra("key_biz_uin", paramInt);
      ((Intent)localObject).putExtra("key_order_id", paramView);
      ((Intent)localObject).putExtra("key_gift_into", (CardGiftInfo)paramAdapterView.kts.getIntent().getParcelableExtra("key_card_git_info"));
      paramAdapterView.kts.startActivity((Intent)localObject);
      h.qsU.e(13866, new Object[] { Integer.valueOf(5), this.ktX.klk.bbe().wEf.wML.wlM, p.getString(this.ktX.klk.bbe().wEf.wML.wlL) });
      AppMethodBeat.o(88335);
      return;
    }
    if ((paramAdapterView.wGZ & 0x20) > 0L)
    {
      paramAdapterView = this.ktX;
      com.tencent.mm.plugin.card.d.b.a(paramAdapterView.kts, 4, paramAdapterView);
      paramAdapterView.kts.mmSetOnActivityResultCallback(paramAdapterView);
      AppMethodBeat.o(88335);
      return;
    }
    if (com.tencent.mm.plugin.card.d.b.d(this.ktX.klk.bbh(), paramAdapterView.wFL, paramAdapterView.wFM, this.ktX.ktU.kqC, this.ktX.ktU.kua))
    {
      h.qsU.e(11941, new Object[] { Integer.valueOf(21), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramAdapterView.title });
      AppMethodBeat.o(88335);
      return;
    }
    paramView = com.tencent.mm.plugin.card.d.l.H(paramAdapterView.url, paramAdapterView.wGZ);
    com.tencent.mm.plugin.card.d.b.a(this.ktX.kts, paramView, 1);
    h.qsU.e(11492, new Object[] { Integer.valueOf(this.ktX.ktU.kqC), this.ktX.ktU.ktd, this.ktX.klk.bbh(), this.ktX.klk.bbi(), Integer.valueOf(this.ktX.klk.bbe().status), paramView, Integer.valueOf(this.ktX.klk.bbd().iFL), this.ktX.klk.bbd().wFW });
    h.qsU.e(11941, new Object[] { Integer.valueOf(6), this.ktX.klk.bbh(), this.ktX.klk.bbi(), "", paramAdapterView.title });
    if (com.tencent.mm.plugin.card.d.l.a(paramAdapterView, this.ktX.klk.bbh()))
    {
      com.tencent.mm.plugin.card.d.l.IG(this.ktX.klk.bbh());
      com.tencent.mm.plugin.card.d.b.b(this.ktX.kts, this.ktX.klk.bbd().knw);
    }
    AppMethodBeat.o(88335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.1
 * JD-Core Version:    0.7.0.1
 */