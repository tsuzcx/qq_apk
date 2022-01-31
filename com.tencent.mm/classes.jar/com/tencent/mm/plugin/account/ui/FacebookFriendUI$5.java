package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.r.a;

final class FacebookFriendUI$5
  implements r.a
{
  FacebookFriendUI$5(FacebookFriendUI paramFacebookFriendUI, TextView paramTextView) {}
  
  public final void Wp()
  {
    if ((q.GL()) && (FacebookFriendUI.a(this.flO)))
    {
      if (FacebookFriendUI.b(this.flO).getCount() != 0) {
        break label46;
      }
      this.flP.setVisibility(0);
    }
    for (;;)
    {
      FacebookFriendUI.c(this.flO);
      return;
      label46:
      this.flP.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.5
 * JD-Core Version:    0.7.0.1
 */