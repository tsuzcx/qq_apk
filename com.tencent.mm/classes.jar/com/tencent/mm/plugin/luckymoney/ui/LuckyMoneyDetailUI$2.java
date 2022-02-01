package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
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
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    Log.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
    h.aHH();
    if (!h.aHG().isSDCardAvailable())
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163712);
      return;
    }
    if (Util.isNullOrNil(LuckyMoneyDetailUI.v(this.EIF)))
    {
      Log.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163712);
      return;
    }
    paramView = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(LuckyMoneyDetailUI.v(this.EIF));
    ca localca = ((n)h.ae(n.class)).eSe().Oq(LuckyMoneyDetailUI.w(this.EIF));
    if ((paramView == null) || (paramView.Qv()))
    {
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163712);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.v(this.EIF));
    localIntent.putExtra("custom_to_talker_name", localca.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.YCw) && (paramView.field_catalog != EmojiGroupInfo.YCv) && (paramView.field_catalog != EmojiGroupInfo.YCu)) {
      localIntent.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    localIntent.putExtra("msg_id", localca.field_msgSvrId);
    localIntent.putExtra("msg_content", localca.field_content);
    localObject = localca.field_talker;
    paramView = (View)localObject;
    if (ab.Lj((String)localObject))
    {
      paramView = bq.RL(localca.field_content);
      localIntent.putExtra("room_id", LuckyMoneyDetailUI.x(this.EIF));
    }
    localIntent.putExtra("msg_sender", paramView);
    localIntent.putExtra("scene", 30);
    c.b(this.EIF, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.2
 * JD-Core Version:    0.7.0.1
 */