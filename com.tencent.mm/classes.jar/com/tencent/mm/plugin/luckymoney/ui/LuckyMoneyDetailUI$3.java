package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class LuckyMoneyDetailUI$3
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$3(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213355);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
    g.aAi();
    if (!g.aAh().isSDCardAvailable())
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213355);
      return;
    }
    if (Util.isNullOrNil(LuckyMoneyDetailUI.x(this.zee)))
    {
      Log.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213355);
      return;
    }
    paramView = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(LuckyMoneyDetailUI.x(this.zee));
    ca localca = ((l)g.af(l.class)).eiy().Hb(LuckyMoneyDetailUI.y(this.zee));
    if ((paramView == null) || (paramView.NA()))
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213355);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.x(this.zee));
    localIntent.putExtra("custom_to_talker_name", localca.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.Uuo) && (paramView.field_catalog != EmojiGroupInfo.Uun) && (paramView.field_catalog != EmojiGroupInfo.Uum)) {
      localIntent.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    localIntent.putExtra("msg_id", localca.field_msgSvrId);
    localIntent.putExtra("msg_content", localca.field_content);
    localObject = localca.field_talker;
    paramView = (View)localObject;
    if (ab.Eq((String)localObject))
    {
      paramView = bp.Ks(localca.field_content);
      localIntent.putExtra("room_id", LuckyMoneyDetailUI.s(this.zee));
    }
    localIntent.putExtra("msg_sender", paramView);
    localIntent.putExtra("scene", 30);
    c.b(this.zee, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.3
 * JD-Core Version:    0.7.0.1
 */