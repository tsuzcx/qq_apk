package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.ui.MMActivity;

final class c$b
  implements View.OnClickListener
{
  private String id;
  
  public c$b(c paramc, String paramString)
  {
    this.id = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26406);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = h.ehF().aDL(this.id);
    paramView = new Intent(c.a(this.znT), MassSendMsgUI.class);
    paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.a.a)localObject).ehz());
    paramView.putExtra("mass_send_again", true);
    localObject = c.a(this.znT);
    paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject).startActivity((Intent)paramView.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.b
 * JD-Core Version:    0.7.0.1
 */