package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class FindMContactInviteUI$11
  implements View.OnClickListener
{
  FindMContactInviteUI$11(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131209);
    paramView = FindMContactInviteUI.i(this.iMu);
    paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.c.b((ListView)paramView.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/FindMContactInviteUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    AppMethodBeat.o(131209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.11
 * JD-Core Version:    0.7.0.1
 */