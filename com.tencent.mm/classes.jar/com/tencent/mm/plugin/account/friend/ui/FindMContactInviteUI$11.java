package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class FindMContactInviteUI$11
  implements View.OnClickListener
{
  FindMContactInviteUI$11(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131209);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = FindMContactInviteUI.i(this.jfE);
    paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.c.b((ListView)paramView.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(131209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.11
 * JD-Core Version:    0.7.0.1
 */