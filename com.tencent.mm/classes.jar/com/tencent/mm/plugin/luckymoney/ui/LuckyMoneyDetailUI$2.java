package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class LuckyMoneyDetailUI$2
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$2(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163712);
    ac.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
    g.agS();
    if (!g.agR().isSDCardAvailable())
    {
      AppMethodBeat.o(163712);
      return;
    }
    if (bs.isNullOrNil(LuckyMoneyDetailUI.t(this.uux)))
    {
      ac.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
      AppMethodBeat.o(163712);
      return;
    }
    paramView = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(LuckyMoneyDetailUI.t(this.uux));
    bo localbo = ((k)g.ab(k.class)).dcr().vP(LuckyMoneyDetailUI.u(this.uux));
    if ((paramView == null) || (paramView.CC()))
    {
      AppMethodBeat.o(163712);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.t(this.uux));
    localIntent.putExtra("custom_to_talker_name", localbo.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.Jsr) && (paramView.field_catalog != EmojiGroupInfo.Jsq) && (paramView.field_catalog != EmojiGroupInfo.Jsp)) {
      localIntent.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    localIntent.putExtra("msg_id", localbo.field_msgSvrId);
    localIntent.putExtra("msg_content", localbo.field_content);
    String str = localbo.field_talker;
    paramView = str;
    if (w.sQ(str))
    {
      paramView = bi.yl(localbo.field_content);
      localIntent.putExtra("room_id", LuckyMoneyDetailUI.v(this.uux));
    }
    localIntent.putExtra("msg_sender", paramView);
    localIntent.putExtra("scene", 30);
    com.tencent.mm.br.d.b(this.uux, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    AppMethodBeat.o(163712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.2
 * JD-Core Version:    0.7.0.1
 */