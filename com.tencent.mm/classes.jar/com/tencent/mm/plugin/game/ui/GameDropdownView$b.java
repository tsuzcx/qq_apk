package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameDropdownView$b
  extends PopupWindow
{
  public GameDropdownView$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111915);
    setWindowLayoutMode(-1, -2);
    setBackgroundDrawable(new BitmapDrawable());
    setFocusable(true);
    setOutsideTouchable(true);
    setTouchInterceptor(new GameDropdownView.b.1(this));
    setAnimationStyle(2131034187);
    AppMethodBeat.o(111915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView.b
 * JD-Core Version:    0.7.0.1
 */