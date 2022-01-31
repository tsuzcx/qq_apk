package com.tencent.mm.plugin.account.friend.a;

import android.view.View;
import android.view.View.OnClickListener;

final class i$3
  implements View.OnClickListener
{
  i$3(i parami, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.ffI;
    int i = this.ffJ;
    if (paramView.showType == 1) {
      paramView.fdQ[i] = 0;
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      return;
      if (paramView.showType == 2) {
        paramView.fdQ[i] = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i.3
 * JD-Core Version:    0.7.0.1
 */