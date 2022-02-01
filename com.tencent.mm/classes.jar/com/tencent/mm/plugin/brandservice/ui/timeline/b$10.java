package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.w;

final class b$10
  implements View.OnClickListener
{
  b$10(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175421);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    localObject1 = (w)paramView.getTag();
    paramView = ((w)localObject1).field_talker;
    Object localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(((w)localObject1).field_talker);
    if ((!((w)localObject1).fpe()) && (localObject2 != null) && (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type)))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      ((Intent)localObject2).putExtra("Contact_Scene", 174);
      ((Intent)localObject2).putExtra("force_get_contact", true);
      ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
      d.b(b.a(this.oaH), "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      this.oaH.oaB.d((w)localObject1, 1);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(175421);
      return;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Chat_User", paramView);
      ((Intent)localObject2).putExtra("finish_direct", true);
      ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 90);
      ((Intent)localObject2).putExtra("specific_chat_from_scene", 2);
      ((Intent)localObject2).putExtra("preChatTYPE", 11);
      d.f(b.a(this.oaH), ".ui.chatting.ChattingUI", (Intent)localObject2);
      this.oaH.oaB.d((w)localObject1, 9);
      localObject1 = c.nWy;
      c.s(3, paramView, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b.10
 * JD-Core Version:    0.7.0.1
 */