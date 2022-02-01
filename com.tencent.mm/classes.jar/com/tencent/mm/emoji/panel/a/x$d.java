package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class x$d
  implements View.OnLongClickListener
{
  public static final d fQN;
  
  static
  {
    AppMethodBeat.i(105695);
    fQN = new d();
    AppMethodBeat.o(105695);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(105694);
    k.g(paramView, "v");
    Object localObject = new Intent(paramView.getContext(), EmojiDebugUI.class);
    paramView = paramView.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(105694);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x.d
 * JD-Core Version:    0.7.0.1
 */