package com.tencent.mm.plugin.game.chatroom.k;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/utils/KeyboardUtils;", "", "()V", "hideKeyboard", "", "view", "Landroid/view/View;", "showKeyboard", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Iof;
  
  static
  {
    AppMethodBeat.i(275709);
    Iof = new c();
    AppMethodBeat.o(275709);
  }
  
  public static void hv(View paramView)
  {
    AppMethodBeat.i(275705);
    s.u(paramView, "view");
    Object localObject = paramView.getContext().getSystemService("input_method");
    if ((localObject instanceof InputMethodManager)) {}
    for (localObject = (InputMethodManager)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        paramView.requestFocus();
        ((InputMethodManager)localObject).showSoftInput(paramView, 0);
      }
      AppMethodBeat.o(275705);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.k.c
 * JD-Core Version:    0.7.0.1
 */