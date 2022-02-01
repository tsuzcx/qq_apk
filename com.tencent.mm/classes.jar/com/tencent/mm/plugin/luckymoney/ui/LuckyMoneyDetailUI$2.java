package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class LuckyMoneyDetailUI$2
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$2(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163712);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    ae.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
    g.ajS();
    if (!g.ajR().isSDCardAvailable())
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163712);
      return;
    }
    if (bu.isNullOrNil(LuckyMoneyDetailUI.t(this.vJe)))
    {
      ae.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163712);
      return;
    }
    paramView = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(LuckyMoneyDetailUI.t(this.vJe));
    bv localbv = ((l)g.ab(l.class)).doJ().ys(LuckyMoneyDetailUI.u(this.vJe));
    if ((paramView == null) || (paramView.Ee()))
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163712);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.t(this.vJe));
    localIntent.putExtra("custom_to_talker_name", localbv.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.OzT) && (paramView.field_catalog != EmojiGroupInfo.OzS) && (paramView.field_catalog != EmojiGroupInfo.OzR)) {
      localIntent.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    localIntent.putExtra("msg_id", localbv.field_msgSvrId);
    localIntent.putExtra("msg_content", localbv.field_content);
    localObject = localbv.field_talker;
    paramView = (View)localObject;
    if (x.wb((String)localObject))
    {
      paramView = bl.BM(localbv.field_content);
      localIntent.putExtra("room_id", LuckyMoneyDetailUI.v(this.vJe));
    }
    localIntent.putExtra("msg_sender", paramView);
    localIntent.putExtra("scene", 30);
    com.tencent.mm.br.d.b(this.vJe, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.2
 * JD-Core Version:    0.7.0.1
 */