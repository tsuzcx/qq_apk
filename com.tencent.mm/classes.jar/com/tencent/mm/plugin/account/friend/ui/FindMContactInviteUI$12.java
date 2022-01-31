package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.ui.base.h;

final class FindMContactInviteUI$12
  implements DialogInterface.OnClickListener
{
  FindMContactInviteUI$12(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(108550);
    if (FindMContactInviteUI.j(this.gzf) == 1)
    {
      paramDialogInterface = new StringBuilder();
      g.RJ();
      paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_500_QQ,");
      g.RJ();
      com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R300_500_QQ") + ",3");
    }
    for (;;)
    {
      g.Rc().a(432, FindMContactInviteUI.a(this.gzf, new FindMContactInviteUI.12.1(this)));
      paramDialogInterface = this.gzf;
      AppCompatActivity localAppCompatActivity = this.gzf.getContext();
      this.gzf.getString(2131297087);
      FindMContactInviteUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.gzf.getString(2131299935), true, new FindMContactInviteUI.12.2(this)));
      FindMContactInviteUI.b(this.gzf).xg(FindMContactInviteUI.m(this.gzf));
      AppMethodBeat.o(108550);
      return;
      paramDialogInterface = new StringBuilder();
      g.RJ();
      paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R300_500_phone,");
      g.RJ();
      com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R300_500_phone") + ",3");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.12
 * JD-Core Version:    0.7.0.1
 */