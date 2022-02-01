package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"})
public final class x$c
  extends RecyclerView.w
  implements View.OnClickListener
{
  ImageView dtJ;
  ImageView gqE;
  
  public x$c(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(105693);
    paramView = localObject.findViewById(2131304867);
    p.g(paramView, "view.findViewById(R.id.smiley_listview_item_view)");
    this.dtJ = ((ImageView)paramView);
    paramView = localObject.findViewById(2131304866);
    p.g(paramView, "view.findViewById(R.id.smiley_listview_item_dot)");
    this.gqE = ((ImageView)paramView);
    localObject.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(105693);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105692);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    p.h(paramView, "v");
    if (x.a(this.gqF) != null)
    {
      localObject = x.a(this.gqF);
      if (localObject == null) {
        p.gkB();
      }
      ((x.b)localObject).b(lN(), paramView);
    }
    a.a(this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(105692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x.c
 * JD-Core Version:    0.7.0.1
 */