package com.tencent.mm.plugin.account.ui;

import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.ui.g.a.d.b;

final class FacebookAuthUI$6
  implements d.b
{
  FacebookAuthUI$6(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(124780);
    ab.i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
    AppMethodBeat.o(124780);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(124781);
    ab.i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", new Object[] { paramString });
    h.b(this.gDa, this.gDa.getString(2131299621), "", true);
    AppMethodBeat.o(124781);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(124779);
    ab.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
    FacebookAuthUI.a(this.gDa, FacebookAuthUI.c(this.gDa).AnY.getToken());
    FacebookAuthUI.d(this.gDa);
    AppMethodBeat.o(124779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.6
 * JD-Core Version:    0.7.0.1
 */