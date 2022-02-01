package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$b
  implements View.OnClickListener
{
  b$b(b paramb, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264823);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    p.j(paramView, "v");
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.storage.BizTimeLineInfo");
      AppMethodBeat.o(264823);
      throw paramView;
    }
    localObject1 = (z)paramView;
    paramView = ((z)localObject1).field_talker;
    Object localObject2 = h.ae(n.class);
    p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
    localObject2 = ((n)localObject2).bbL().RG(((z)localObject1).field_talker);
    if ((!((z)localObject1).hwB()) && (localObject2 != null) && (!((as)localObject2).axZ()))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", paramView);
      ((Intent)localObject2).putExtra("Contact_Scene", 174);
      ((Intent)localObject2).putExtra("force_get_contact", true);
      ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
      c.b((Context)this.sAP.sAm, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      this.sAQ.g((z)localObject1);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264823);
      return;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Chat_User", paramView);
      ((Intent)localObject2).putExtra("finish_direct", true);
      ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 90);
      ((Intent)localObject2).putExtra("specific_chat_from_scene", 2);
      ((Intent)localObject2).putExtra("preChatTYPE", 11);
      c.f((Context)this.sAP.sAm, ".ui.chatting.ChattingUI", (Intent)localObject2);
      this.sAQ.h((z)localObject1);
      localObject1 = d.swc;
      d.t(3, paramView, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b.b
 * JD-Core Version:    0.7.0.1
 */