package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.d.b;

final class WelcomeActivity$2
  implements d.b
{
  WelcomeActivity$2(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(125635);
    ab.i("MicroMsg.WelcomeActivity", "facebook-android login cancel!");
    AppMethodBeat.o(125635);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(125636);
    ab.i("MicroMsg.WelcomeActivity", "facebook-android login error! %s", new Object[] { paramString });
    h.b(this.gKy, this.gKy.getString(2131299621), "", true);
    AppMethodBeat.o(125636);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(125634);
    ab.i("MicroMsg.WelcomeActivity", "facebook-android login success!");
    WelcomeActivity.f(this.gKy);
    AppMethodBeat.o(125634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.2
 * JD-Core Version:    0.7.0.1
 */