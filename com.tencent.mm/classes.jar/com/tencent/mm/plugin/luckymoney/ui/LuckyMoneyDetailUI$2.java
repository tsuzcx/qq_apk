package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class LuckyMoneyDetailUI$2
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$2(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163712);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
    g.afC();
    if (!g.afB().isSDCardAvailable())
    {
      AppMethodBeat.o(163712);
      return;
    }
    if (bt.isNullOrNil(LuckyMoneyDetailUI.t(this.tme)))
    {
      ad.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
      AppMethodBeat.o(163712);
      return;
    }
    paramView = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(LuckyMoneyDetailUI.t(this.tme));
    bl localbl = ((k)g.ab(k.class)).cOI().rm(LuckyMoneyDetailUI.u(this.tme));
    if ((paramView == null) || (paramView.CZ()))
    {
      AppMethodBeat.o(163712);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.t(this.tme));
    localIntent.putExtra("custom_to_talker_name", localbl.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.LBP) && (paramView.field_catalog != EmojiGroupInfo.LBO) && (paramView.field_catalog != EmojiGroupInfo.LBN)) {
      localIntent.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    localIntent.putExtra("msg_id", localbl.field_msgSvrId);
    localIntent.putExtra("msg_content", localbl.field_content);
    String str = localbl.field_talker;
    paramView = str;
    if (w.pF(str))
    {
      paramView = bi.uf(localbl.field_content);
      localIntent.putExtra("room_id", LuckyMoneyDetailUI.v(this.tme));
    }
    localIntent.putExtra("msg_sender", paramView);
    localIntent.putExtra("scene", 30);
    com.tencent.mm.bs.d.b(this.tme, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    AppMethodBeat.o(163712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.2
 * JD-Core Version:    0.7.0.1
 */