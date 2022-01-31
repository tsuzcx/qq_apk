package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FindMContactInviteUI$12$1
  implements f
{
  FindMContactInviteUI$12$1(FindMContactInviteUI.12 param12) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (FindMContactInviteUI.a(this.fhy.fhx) != null)
    {
      FindMContactInviteUI.a(this.fhy.fhx).dismiss();
      FindMContactInviteUI.a(this.fhy.fhx, null);
    }
    if (FindMContactInviteUI.k(this.fhy.fhx) != null)
    {
      g.Dk().b(432, FindMContactInviteUI.k(this.fhy.fhx));
      FindMContactInviteUI.a(this.fhy.fhx, null);
    }
    FindMContactInviteUI.l(this.fhy.fhx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.12.1
 * JD-Core Version:    0.7.0.1
 */