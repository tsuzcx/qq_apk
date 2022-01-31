package com.tencent.mm.plugin.account.friend.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$3
  implements View.OnClickListener
{
  i$3(i parami, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108341);
    paramView = this.gxq;
    int i = this.gxr;
    if (paramView.showType == 1) {
      paramView.gvA[i] = 0;
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      AppMethodBeat.o(108341);
      return;
      if (paramView.showType == 2) {
        paramView.gvA[i] = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i.3
 * JD-Core Version:    0.7.0.1
 */