package com.tencent.mm.plugin.account.friend.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class RecommendFriendUI$2
  implements MenuItem.OnMenuItemClickListener
{
  RecommendFriendUI$2(RecommendFriendUI paramRecommendFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(108629);
    int i = RecommendFriendUI.b(this.gAg).aqU().length;
    h.a(this.gAg.getContext(), this.gAg.getContext().getResources().getQuantityString(2131361808, i, new Object[] { Integer.valueOf(i) }), this.gAg.getString(2131297087), new RecommendFriendUI.2.1(this), new RecommendFriendUI.2.2(this));
    AppMethodBeat.o(108629);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.2
 * JD-Core Version:    0.7.0.1
 */