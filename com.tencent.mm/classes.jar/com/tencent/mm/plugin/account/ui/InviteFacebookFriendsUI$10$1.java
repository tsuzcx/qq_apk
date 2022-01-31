package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.e;
import java.util.ArrayList;
import java.util.List;

final class InviteFacebookFriendsUI$10$1
  implements c.a
{
  InviteFacebookFriendsUI$10$1(InviteFacebookFriendsUI.10 param10, long[] paramArrayOfLong) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(124884);
    ab.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
    AppMethodBeat.o(124884);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(124883);
    ab.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
    AppMethodBeat.o(124883);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(124886);
    ab.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
    AppMethodBeat.o(124886);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(124885);
    ab.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
    paramBundle = new ArrayList();
    paramBundle.add(new h.a(33, Integer.toString(this.gDy.length)));
    ((j)g.E(j.class)).Yz().c(new com.tencent.mm.az.h(paramBundle));
    paramBundle = this.gDy;
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      long l = paramBundle[i];
      p localp = new p();
      localp.username = Long.toString(l);
      localp.gxG = 5;
      localp.fvK = ((int)bo.aox());
      a.getInviteFriendOpenStg().b(localp);
      i += 1;
    }
    com.tencent.mm.ui.base.h.a(this.gDz.gDx, 2131299635, 2131297087, 2131297115, 2131297014, new InviteFacebookFriendsUI.10.1.1(this), new InviteFacebookFriendsUI.10.1.2(this));
    AppMethodBeat.o(124885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.10.1
 * JD-Core Version:    0.7.0.1
 */