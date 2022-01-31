package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

final class GameDropdownView$1
  implements View.OnClickListener
{
  GameDropdownView$1(GameDropdownView paramGameDropdownView) {}
  
  public final void onClick(View paramView)
  {
    if ((GameDropdownView.a(this.laT).getContentView() == null) || (!(GameDropdownView.a(this.laT).getContentView() instanceof ViewGroup)))
    {
      GameDropdownView.a(this.laT).dismiss();
      return;
    }
    int i = ((ViewGroup)GameDropdownView.a(this.laT).getContentView()).indexOfChild(paramView);
    GameDropdownView.a(this.laT, i);
    GameDropdownView.a(this.laT).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView.1
 * JD-Core Version:    0.7.0.1
 */