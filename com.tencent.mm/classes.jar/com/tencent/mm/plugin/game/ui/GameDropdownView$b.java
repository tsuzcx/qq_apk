package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameDropdownView$b
  extends PopupWindow
{
  public GameDropdownView$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(42086);
    setWindowLayoutMode(-1, -2);
    setBackgroundDrawable(new BitmapDrawable());
    setFocusable(true);
    setOutsideTouchable(true);
    setTouchInterceptor(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42085);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/game/ui/GameDropdownView$PopupMenu$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 4)
        {
          GameDropdownView.b.this.dismiss();
          a.a(true, this, "com/tencent/mm/plugin/game/ui/GameDropdownView$PopupMenu$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(42085);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/game/ui/GameDropdownView$PopupMenu$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(42085);
        return false;
      }
    });
    setAnimationStyle(2130772061);
    AppMethodBeat.o(42086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDropdownView.b
 * JD-Core Version:    0.7.0.1
 */