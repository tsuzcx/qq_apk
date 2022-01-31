package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o;

final class CollectMainUI$19
  implements View.OnClickListener
{
  CollectMainUI$19(CollectMainUI paramCollectMainUI, o paramo1, o paramo2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41273);
    if (CollectMainUI.g(this.kSz).getText().toString().equals(CollectMainUI.i(this.kSz)))
    {
      this.kSH.onClick(paramView);
      AppMethodBeat.o(41273);
      return;
    }
    this.kSI.onClick(paramView);
    AppMethodBeat.o(41273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.19
 * JD-Core Version:    0.7.0.1
 */