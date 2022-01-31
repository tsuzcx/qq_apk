package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

final class GameCenterActivity$2
  implements View.OnApplyWindowInsetsListener
{
  GameCenterActivity$2(GameCenterActivity paramGameCenterActivity, ViewGroup paramViewGroup) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    this.kYa.a(this.kYb, paramWindowInsets);
    return paramWindowInsets.consumeSystemWindowInsets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterActivity.2
 * JD-Core Version:    0.7.0.1
 */