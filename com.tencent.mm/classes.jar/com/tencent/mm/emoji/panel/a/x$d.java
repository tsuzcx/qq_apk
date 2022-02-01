package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class x$d
  implements View.OnLongClickListener
{
  public static final d gok;
  
  static
  {
    AppMethodBeat.i(105695);
    gok = new d();
    AppMethodBeat.o(105695);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(105694);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
    p.g(paramView, "v");
    localObject = new Intent(paramView.getContext(), EmojiDebugUI.class);
    paramView = paramView.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(105694);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x.d
 * JD-Core Version:    0.7.0.1
 */