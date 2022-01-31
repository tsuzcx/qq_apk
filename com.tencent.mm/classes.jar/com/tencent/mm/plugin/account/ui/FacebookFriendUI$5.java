package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.p.a;

final class FacebookFriendUI$5
  implements p.a
{
  FacebookFriendUI$5(FacebookFriendUI paramFacebookFriendUI, TextView paramTextView) {}
  
  public final void apT()
  {
    AppMethodBeat.i(124811);
    if ((r.ZP()) && (FacebookFriendUI.a(this.gDg)))
    {
      if (FacebookFriendUI.b(this.gDg).getCount() != 0) {
        break label56;
      }
      this.gDh.setVisibility(0);
    }
    for (;;)
    {
      FacebookFriendUI.c(this.gDg);
      AppMethodBeat.o(124811);
      return;
      label56:
      this.gDh.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.5
 * JD-Core Version:    0.7.0.1
 */