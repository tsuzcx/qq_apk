package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDropdownView$1
  implements View.OnClickListener
{
  GameDropdownView$1(GameDropdownView paramGameDropdownView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111913);
    if ((GameDropdownView.a(this.nyP).getContentView() == null) || (!(GameDropdownView.a(this.nyP).getContentView() instanceof ViewGroup)))
    {
      GameDropdownView.a(this.nyP).dismiss();
      AppMethodBeat.o(111913);
      return;
    }
    int i = ((ViewGroup)GameDropdownView.a(this.nyP).getContentView()).indexOfChild(paramView);
    GameDropdownView.a(this.nyP, i);
    GameDropdownView.a(this.nyP).dismiss();
    AppMethodBeat.o(111913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView.1
 * JD-Core Version:    0.7.0.1
 */