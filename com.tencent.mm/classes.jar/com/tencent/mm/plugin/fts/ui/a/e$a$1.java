package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.x;

final class e$a$1
  implements View.OnClickListener
{
  e$a$1(e.a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194918);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (x.AW(this.tLH.tLG.talker))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", this.tLH.tLG.talker);
      paramView.putExtra("app_brand_conversation_from_scene", 1);
      paramView.addFlags(67108864);
      d.f(this.val$context, ".ui.conversation.AppBrandServiceConversationUI", paramView);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194918);
      return;
      paramView = new Intent();
      paramView.putExtra("Chat_User", this.tLH.tLG.talker);
      paramView.putExtra("finish_direct", true);
      d.f(this.val$context, ".ui.chatting.ChattingUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e.a.1
 * JD-Core Version:    0.7.0.1
 */