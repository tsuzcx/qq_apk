package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FindMContactInviteUI$12$1
  implements f
{
  FindMContactInviteUI$12$1(FindMContactInviteUI.12 param12) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108549);
    if (FindMContactInviteUI.a(this.gzg.gzf) != null)
    {
      FindMContactInviteUI.a(this.gzg.gzf).dismiss();
      FindMContactInviteUI.a(this.gzg.gzf, null);
    }
    if (FindMContactInviteUI.k(this.gzg.gzf) != null)
    {
      g.Rc().b(432, FindMContactInviteUI.k(this.gzg.gzf));
      FindMContactInviteUI.a(this.gzg.gzf, null);
    }
    FindMContactInviteUI.l(this.gzg.gzf);
    AppMethodBeat.o(108549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.12.1
 * JD-Core Version:    0.7.0.1
 */