package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;

final class c$10
  implements View.OnClickListener
{
  c$10(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175421);
    paramView = (s)paramView.getTag();
    String str = paramView.field_talker;
    Object localObject = ((k)g.ab(k.class)).apM().aHY(paramView.field_talker);
    if ((!paramView.eJM()) && (localObject != null) && (!b.ls(((au)localObject).field_type)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      ((Intent)localObject).putExtra("Contact_Scene", 174);
      ((Intent)localObject).putExtra("force_get_contact", true);
      ((Intent)localObject).putExtra("key_use_new_contact_profile", true);
      d.b(c.a(this.mXd), "profile", ".ui.ContactInfoUI", (Intent)localObject);
      this.mXd.mWX.c(paramView, 1);
      AppMethodBeat.o(175421);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", str);
    ((Intent)localObject).putExtra("finish_direct", true);
    ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 90);
    ((Intent)localObject).putExtra("specific_chat_from_scene", 2);
    ((Intent)localObject).putExtra("preChatTYPE", 11);
    d.e(c.a(this.mXd), ".ui.chatting.ChattingUI", (Intent)localObject);
    this.mXd.mWX.c(paramView, 9);
    AppMethodBeat.o(175421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.10
 * JD-Core Version:    0.7.0.1
 */