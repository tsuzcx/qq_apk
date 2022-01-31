package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.e;

final class ShowNonWeixinFriendUI$2$1
  implements c.a
{
  ShowNonWeixinFriendUI$2$1(ShowNonWeixinFriendUI.2 param2) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(125587);
    ab.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
    AppMethodBeat.o(125587);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(125586);
    ab.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
    AppMethodBeat.o(125586);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(125589);
    ab.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
    AppMethodBeat.o(125589);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(125588);
    ab.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
    h.a(this.gKr.gKq.getContext(), 2131299638, 2131297087, new ShowNonWeixinFriendUI.2.1.1(this));
    AppMethodBeat.o(125588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.2.1
 * JD-Core Version:    0.7.0.1
 */