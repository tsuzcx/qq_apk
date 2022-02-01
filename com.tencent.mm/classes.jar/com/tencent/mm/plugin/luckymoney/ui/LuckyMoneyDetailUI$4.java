package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.wallet_core.ui.k;

final class LuckyMoneyDetailUI$4
  extends k
{
  LuckyMoneyDetailUI$4(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(284306);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
    h.baF();
    if (!h.baE().isSDCardAvailable())
    {
      AppMethodBeat.o(284306);
      return;
    }
    if (Util.isNullOrNil(LuckyMoneyDetailUI.w(this.KBZ)))
    {
      Log.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
      AppMethodBeat.o(284306);
      return;
    }
    paramView = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(LuckyMoneyDetailUI.w(this.KBZ));
    cc localcc = ((n)h.ax(n.class)).gaZ().sl(LuckyMoneyDetailUI.x(this.KBZ));
    if ((paramView == null) || (paramView.aqJ()))
    {
      AppMethodBeat.o(284306);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.w(this.KBZ));
    localIntent.putExtra("custom_to_talker_name", localcc.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.aklF) && (paramView.field_catalog != EmojiGroupInfo.aklE) && (paramView.field_catalog != EmojiGroupInfo.aklD)) {
      localIntent.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    localIntent.putExtra("msg_id", localcc.field_msgSvrId);
    localIntent.putExtra("msg_content", localcc.field_content);
    String str = localcc.field_talker;
    paramView = str;
    if (au.bwE(str))
    {
      paramView = br.JJ(localcc.field_content);
      localIntent.putExtra("room_id", LuckyMoneyDetailUI.y(this.KBZ));
    }
    localIntent.putExtra("msg_sender", paramView);
    localIntent.putExtra("scene", 30);
    c.b(this.KBZ, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    AppMethodBeat.o(284306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.4
 * JD-Core Version:    0.7.0.1
 */