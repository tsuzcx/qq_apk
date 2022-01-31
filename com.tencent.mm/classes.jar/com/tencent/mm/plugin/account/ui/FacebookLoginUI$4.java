package com.tencent.mm.plugin.account.ui;

import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.ui.g.a.d.b;

final class FacebookLoginUI$4
  implements d.b
{
  FacebookLoginUI$4(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(124834);
    ab.i("MicroMsg.FacebookLoginUI", "facebook-android login cancel!");
    AppMethodBeat.o(124834);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(124835);
    ab.i("MicroMsg.FacebookLoginUI", "facebook-android login error! %s", new Object[] { paramString });
    h.b(this.gDq, this.gDq.getString(2131299621), "", true);
    AppMethodBeat.o(124835);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(124833);
    ab.i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
    FacebookLoginUI.a(this.gDq, FacebookLoginUI.a(this.gDq).AnY.getToken());
    FacebookLoginUI.b(this.gDq);
    AppMethodBeat.o(124833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.4
 * JD-Core Version:    0.7.0.1
 */